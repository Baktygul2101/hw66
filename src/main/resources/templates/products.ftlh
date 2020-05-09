<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div>
    <a href="/">back to main</a>
<h1>Products</h1>


<ul>
    <div class="card-columns">
    <#list products as product>
        <div class="card my-5">

        <li>
            <div class="card-body text-center m-2">
            <p>
                ${product.id} -<b>${product.name}</b>  <br>
                <a href="/product/${product.id}"> <img src="/images/${product.image}" width="150" height="150"></a>
            </p>
            </div>
        </li>
        </div>
    </#list>
    </div>
</ul>
</div>





</body>
</html>
