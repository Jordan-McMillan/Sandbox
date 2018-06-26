
export const totalCost = {
    computed: {
        totalCost() {
            return this.quantity * this.stock.price;
        }
    }
}