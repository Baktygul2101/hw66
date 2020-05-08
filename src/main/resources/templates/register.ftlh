<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Please register</h2>
    <div>
        <form action="/register" method="post" id="registration-form">

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <input type="email" name="email" class="form-control mb-1" placeholder="Email" value="${(dto.email)!''}" ><br>
            <input type="text" name="name" class="form-control mb-1" placeholder="Полное имя"  value="${(dto.name)!''}"><br>
            <input type="text" name="address" class="form-control mb-1" placeholder="address" value="${(dto.address)!''}"><br>
            <input type="tel" name="phoneNumber" class="form-control mb-1" placeholder="phoneNumber" value="${(dto.phoneNumber)!''}">><br>
            <input type="password" name="password" class="form-control mb-1" placeholder="Пароль"  value=""> <br>
            <button class="btn btn-outline-primary btn-block" type="submit">Зарегистрироваться</button>

            <div>
                <#if errors?? >
                    <p>Входные данные с ошибками!</p>
                    <#list errors as fieldError>
                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                    </#list>
                </#if>
            </div>
        </form>
    </div>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>


</@main.renderWith>








