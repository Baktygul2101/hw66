<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="/css/styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://kit.fontawesome.com/7174afae6d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  </head>
<body>
<div>
    <a href="/">back to main</a>
<h1>Products</h1>

    <form method="get" action="/products">
        <input type="text" name="filter" value="${filter}">
        <button type="submit">Найти</button>
    </form>

</div>






<div class="colum container">
    <h1 class="mt-5">Welcome to Modern Business</h1>
    <hr class="my-3">
    <div class="row">
        <div class="col-12 col-sm-6 col-lg-4">
            <#list products as product>
            <div class="card">
                <h5 class="card-header"> ${product.name}</h5>
                <div class="card-body">
                    <a href="/product/${product.id}"> <img src="/images/${product.image}" width="150" height="150"></a>
                    <br>
                    <a href="/product/${product.id}" class="btn btn-outline-dark">Learn More</a>
                </div>
            </div>
            </#list>
        </div>
    </div>
</div>


</body>
</html>
