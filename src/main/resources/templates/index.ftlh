<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith>

    <#if errorText?? >
        <div>
            <p>${errorText!'-- no message --'}</p>
        </div>
    </#if>


</@main.renderWith>







