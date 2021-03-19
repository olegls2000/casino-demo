<#import "../common/page.ftl" as common>
<@common.page>
    <form action="/bet" method="post">
        <label for="bet">Chose option:</label>
        <select name="bet">
            <option value="RED">Red</option>
            <option value="BLACK">Black</option>
            <option value="ZERO">Zero</option>
        </select>

        <label for="betValue">Bet Value:</label>
        <input type="number" name="betValue">

        <button type="submit">Bet</button>
    </form>
</@common.page>