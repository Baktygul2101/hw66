<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8">
        <title>Registration</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
    <form:form action="/SpringFromValidWebApp/registerSuccess" method="post" modelAttribute="user">
        <!-- Splash screen -->
        <section id="page-splash" class="page-splash">
            <div class="d-flex justify-content-center">
                <div class="mx-3">
                    <h3>Регистрация</h3>
                    <form id="registration-form">
                        <input type="email" name="email" class="form-control mb-1" placeholder="Email" cssClass="error"><br>
                        <input type="text" name="name" class="form-control mb-1" placeholder="Полное имя" cssClass="error"><br>
                        <input type="text" name="address" class="form-control mb-1" placeholder="address" cssClass="error"><br>
                        <input type="text" name="phoneNumber" class="form-control mb-1" placeholder="phoneNumber" cssClass="error"><br>
                        <input type="password" name="password" class="form-control mb-1" placeholder="Пароль" cssClass="error"><br>
                        <button class="btn btn-outline-primary btn-block">Зарегистрироваться</button>
                    </form>
                    <div>
                        <#if errors?? >
                            <p>Входные данные с ошибками!</p>
                            <#list errors as fieldError>
                                <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                            </#list>
                        </#if>
                    </div>
                </div>
            </div>

        </section>
    </body>
</html>

<script src="/js/reg.js"></script>
