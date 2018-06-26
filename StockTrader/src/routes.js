const Home = resolve => {
	require.ensure(['./components/Home.vue'], () => {
		resolve(require('./components/Home.vue'));
	});
};

const Portfolio = resolve => {
	require.ensure(['./components/portfolio/Portfolio.vue'], () => {
		resolve(require('./components/portfolio/Portfolio.vue'));
	});
};

const Stocks = resolve => {
	require.ensure(['./components/stocks/Stocks.vue'], () => {
		resolve(require('./components/stocks/Stocks.vue'));
	});
};


export const routes = [
    { path: '/', component: Home },
    { path: '/portfolio', component: Portfolio },
    { path: '/stocks', component: Stocks }
];