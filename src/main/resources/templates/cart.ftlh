<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title> Cart</title>

    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div class="container">
    <h1>Ваша корзина<i class="fa fa-shopping-cart"></h1>
    <#if products??>
        <#list products as item>
            <p>${item.id}</p>
        </#list>
        <form action="/cart/empty" method="post">
            <button>Очистить корзину</button>
        </form>
    <#else>
        <p>тут ничего нет!</p>
    </#if>

    <div>
        <a href="/">назад</a>
    </div>
</div>

</body>
</html>