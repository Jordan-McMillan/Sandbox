<template>
    <div class="col-sm-6 col-md-4">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">
                    {{ stock.name }}
                    <small>Price: {{ stock.price }} | Quantity: {{ stock.quantity }}</small>
                </h3>
            </div>
            <div class="panel-body">
                <div class="pull-left">
                    <input 
                        type="number"
                        class="form-control"
                        placeholder="Quantity" 
                        v-model.number="quantity"
                        @keyup.enter="sellStock"
                        :class="{danger: insufficientQuantity}" />
                    <div>
                        Total: {{ totalCost | currency }}
                    </div>
                </div>
                <div class="pull-right">
                    <button 
                        class="btn btn-info" 
                        @click="sellStock"
                        :disabled="quantity <= 0 || !Number.isInteger(quantity) || insufficientQuantity"
                        >{{ insufficientQuantity ? '---' : 'SELL' }}</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    import {mapActions} from 'vuex';
    import {totalCost} from '../mixins/totalCost';

    export default {
        mixins: [totalCost],
        data() {
            return {
                quantity: 0
            };            
        },
        props: {
            stock: Object            
        },
        computed: {
            insufficientQuantity() {
                return this.quantity > this.stock.quantity;
            }
        },
        methods: {
            ...mapActions({
                placeSellOrder: 'sellStock'
            }),
            sellStock() {
                const order = {
                    stockId: this.stock.id,
                    stockPrice: this.stock.price,
                    quantity: this.quantity
                };
                this.placeSellOrder(order);
                this.quantity = 0;
            }
        }
    }
    
</script>

<style scoped>
    .danger {
        border: 1px solid red;
    }
</style>
