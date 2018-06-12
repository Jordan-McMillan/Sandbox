new Vue({
    el: '#app',
    data: {
        playerHealth: 100,
        monsterHealth: 100,
        isGameRunning: false,
        turns: []
    },
    methods: {
        startNewGame: function() {
            this.isGameRunning = true;
            this.playerHealth = 100;
            this.monsterHealth = 100;
            this.turns = [];
        },
        attack: function() {
            this.playerAttacks(3, 10);
            this.monsterAttacks();
        },
        specialAttack: function() {
            this.playerAttacks(10, 20);
            this.monsterAttacks();
        },
        playerAttacks: function(min, max) {
            var dmg = this.monsterHealth;
            this.monsterHealth -= this.calculateDamage(min, max);
            this.monsterHealth = Math.max(this.monsterHealth, 0);
            dmg = dmg - this.monsterHealth;

            this.turns.unshift({ 
                isPlayer: true, 
                text: 'Player attacks for ' + dmg 
            });
        },
        monsterAttacks: function() {
            var dmg = this.playerHealth;
            this.playerHealth -= this.calculateDamage(5, 12);
            this.playerHealth = Math.max(this.playerHealth, 0);
            dmg = dmg - this.playerHealth;

            this.turns.unshift({ 
                isPlayer: false, 
                text: 'Monster attacks for ' + dmg 
            });
        },
        heal: function() {
            var orig = this.playerHealth;
            this.playerHealth += 10;
            this.playerHealth = Math.min(this.playerHealth, 100);
            orig = this.playerHealth - orig;
            this.turns.unshift({ 
                isPlayer: true, 
                text: 'Player heals for ' + orig 
            });

            this.monsterAttacks();

        },
        giveUp: function() {
            this.isGameRunning = false;
        },
        calculateDamage: function(min, max) {
            return Math.max(Math.floor(Math.random() * max) + 1, min);
        },
        checkWinner: function(value, message) {
            if (value <= 0) {
                this.isGameRunning = false;
                if (confirm(message)) {
                    this.startNewGame();
                }
            }
        }
    },
    watch: {
        playerHealth: function(value) {
            this.checkWinner(value, 'You lost. New Game?');
        },
        monsterHealth: function(value) {
            this.checkWinner(value, 'You won. New Game?');
        }
    }
});