<#import "../common/page.ftl" as common>
<@common.page>

    <h1>All Bets:</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Bet</th>
            <th>Amount, $</th>
            <th>Is Active</th>
        </tr>
        </thead>
        <#list bets as bet>
            <tr>
                <td>${bet.bet}</td>
                <td>${bet.betValue}</td>
                <td>${bet.active?c}</td>
            </tr>
        </#list>
    </table>
</@common.page>