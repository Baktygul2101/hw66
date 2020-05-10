<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->

<@main.renderWith scripts=["/js/main.js"]>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body {
                font-family: Arial;
            }

            * {
                box-sizing: border-box;
            }

            form.search input[type=text] {
                padding: 10px;
                font-size: 17px;
                border: 1px solid grey;
                float: left;
                width: 80%;
                background: #f1f1f1;
            }

            form.search button {
                float: left;
                width: 20%;
                padding: 10px;
                background: #2196F3;
                color: white;
                font-size: 17px;
                border: 1px solid grey;
                border-left: none;
                cursor: pointer;
            }

            form.search button:hover {
                background: #0b7dda;
            }

            form.search::after {
                content: "";
                clear: both;
                display: table;
            }
        </style>
    </head>
<div>
    <a href="/">back to main</a>
<h1>Products</h1>

    <form method="get" action="/products" class="search">
        <input type="text" name="filter" value="${filter}" placeholder="Search..">
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>

    <div class="colum container">
    <div class="row">
        <div class="col-12 col-sm-6 col-lg-4">
            <#list products as product>
            <div class="card" style="background-color: #cccccc">
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

</@main.renderWith>