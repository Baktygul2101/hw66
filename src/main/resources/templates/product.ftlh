<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/style.css">

    <title>About product</title>
</head>
<body>
<div class="container flex flex-col align-center">
    <h1>${product.name}</h1>
    <main class="flex flex-wrap align-center">
        <div class="card flex flex-col align-center">

                <p>about: ${product.description}</p>
                <p> <img src="/static/images/${product.image}"></p>
                <p>price: ${product.price}</p>
                <p>saldo: ${product.quantity}</p>

        <a href="/products">back to list</a>
        </div>
    </main>
</div>

</body>
</html>
