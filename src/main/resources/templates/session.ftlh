<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Lesson 69. Storing data in session</title>

    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div class="container">
    <h1>Данные из сессии</h1>
    <div class="border"><strong><span class="key-cell">ключ</span><span class="value-cell">значение</span></strong></div>
    <#list sessionAttributes as key, value>
        <div class="border"><span class="key-cell">${key}</span><span class="value-cell">${value}</span></div>
    </#list>
    <form action="/cart/add" method="post" id="cart-form">
        <h2>Добавить в корзину.</h2>
        <div>
            <label for="value">что покупаем? </label>
            <input name="value" id="value">
            <button type="submit">Добавить в корзину</button>
        </div>
        <div>
            <div class="key-cell"><a href="" id="cart-add" >Добавить через fetch()</a>(обновите страницу)</div>
            <a href="/cart" class="value-cell">Посмотреть корзину</a>
        </div>
    </form>
    <form action="/store" method="post">
        <h2>Сохраним что-то в сессии.</h2>
        <div>
            <label for="key">имя поля: </label>
            <input name="key" id="key">
            <label for="value">некоторое значение: </label>
            <input name="value" id="value">
            <button type="submit">Добавить</button>
        </div>
    </form>
    <div>
        <h2><a href="/invalidate">Удалим всё, включая текущую сессию.</a></h2>
    </div>
</div>

<script>
    'use strict';

    async function addToCart(e) {
        e.preventDefault();
        e.stopPropagation();

        const form = document.getElementById("cart-form");
        const options = {
            method : 'post',
            body: new FormData(form)
        };

        await fetch("/cart", options);
        alert("обновите страницу для просмотра данных из сессии, или перейдите в корзину");
    }

    const updateElement = document.getElementById("cart-add");
    updateElement.addEventListener('click', addToCart);
</script>

</body>
</html>