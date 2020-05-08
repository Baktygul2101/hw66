<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dto??>
        <h1>Ваши учетные данные!</h1>
        <p>${(dto.name)!'-- missing --'} - ${(dto.email)!'-- email missing --'}</p>
        <p>${(dto.address)!'-- missing --'} - ${(dto.phoneNumber)!'-- email missing --'}</p>
    <#else>
        <h1>Пользователь не найден!</h1>
    </#if>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>