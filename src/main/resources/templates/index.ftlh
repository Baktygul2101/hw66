<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->

<@main.renderWith scripts=["/js/main.js"]>
    <div>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>WELCOME to MY ONLINE SHOP</h1>

        </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="/">Main page</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">by Category</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">by Brand</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products">by Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
            </ul>
        </div>
    </nav>



    <form class="flex box-128" action="/logout" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <button class="flex box-128 logout-button">Выйти </button>
        </form>

    </div>



</@main.renderWith>







