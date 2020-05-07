<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div>
<h1>Products</h1>

<ul>
    <#list products as product>
        <li>
            <p>${product.id} - ${product.name} -
                <img src="/image/${product.image}">
                ${product.image} -<a href="/product/${product.id}">more info</a></p>
        </li>
    </#list>
</ul>
</div>





</body>
</html>
