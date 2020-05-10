<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/styles.css">

    <title>About product</title>
</head>
<body>
<div class="container flex flex-col align-center">

    <main class="flex flex-wrap align-center">
        <div class="card flex flex-col align-center">
            <form method="get" action="/product/{id}">
              <h1>${product.name}</h1>
                <img src="/images/${product.image}" width="150" height="150">
                <p><b>Цена</b>            ${product.price}</p>
                <p><b>Наличие:</b>        ${product.quantity}</p
                <p><b>Описание товара</b> ${product.description}</p>
                <a href="/products">back to list</a>
            </form>
        </div>
    </main>
</div>

</body>
</html>
