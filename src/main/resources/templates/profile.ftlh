<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dto??>
        <h1>Ваши учетные данные!</h1>
        <p> <b>Пользователь   i</b>   ${(dto.name)!'-- missing --'}</p>
        <p> <b>Почтовый адрес i</b>   ${(dto.email)!'-- email missing --'}</p>
        <p> <b>Адрес доставки i</b>   ${(dto.address)!'-- missing --'}</p>
        <p> <b>Номер телефона i</b>   ${(dto.phoneNumber)!'--  missing --'}</p>

    <#else>
        <h1>Пользователь не найден!</h1>
    </#if>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>