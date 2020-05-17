
const baseUrl = 'http://localhost:1515';




const constructGetUrl = (url, queryParams) => {
    for (let key in queryParams) {
        if (queryParams.hasOwnProperty(key)) {
            console.log(key, queryParams[key]);
        }
    }
    // TODO
};

(function loadPlacesPageable() {

    const productTemplate = (product) => {

        let card = document.createElement('div');
        card.className = 'card d-inline-block';
        card.style.width = '18rem';
        card.style.margin = '0 1rem';
        card.innerHTML =
            `<img class="card-img-top" src="/images/${product.image}" alt="Card image cap">
                 <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="card-text"><b>Price</b>: ${product.price}$</p>
                 </div>`;

        return card;
    };


    const loadNextProductsGenerator = (loadNextElement, page) => {
        return async (event) => {
            event.preventDefault();
            event.stopPropagation();

            const defaultPageSize = loadNextElement.getAttribute('data-default-page-size');
            const data = await fetchProducts(page, defaultPageSize);


            loadNextElement.hidden = data.length === 0;
            if (data.length === 0) {
                return;
            }
            const list = document.getElementById('products');
            for (let item of data) {
                list.append(productTemplate(item));
            }

            loadNextElement.addEventListener('click', loadNextProductsGenerator(loadNextElement, page + 1), {once: true});
            window.scrollTo(0, document.body.scrollHeight);
        };
    };
    document.getElementById('loadPrev').hidden = true;
    const loadNextElement = document.getElementById('loadNext');
    if (loadNextElement !== null) {
        loadNextElement.innerText = "Load more products";
        loadNextElement.addEventListener('click', loadNextProductsGenerator(loadNextElement, getCurrentPage()), {once: true});
    }

})();

