<#import "../common/page.ftl" as common>
<@common.page>
    <div class="row">
        <div class="col"></div>
        <div class="col">
            <form action="/user/registration" method="post">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name:</label>
                    <input type="text" class="form-control" name="firstName" aria-describedby="firstNameHelp">
                    <div id="firstNameHelp" class="form-text">Input your First Name</div>
                </div>

                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name:</label>
                    <input type="text" class="form-control" name="lastName" aria-describedby="lastNameHelp">
                    <div id="lastNameHelp" class="form-text">Input your Last Name</div>
                </div>

                <div class="mb-3">
                    <label for="taxNumber" class="form-label">Tax Number:</label>
                    <input type="number" class="form-control" name="taxNumber" aria-describedby="taxNumberHelp">
                    <div id="taxNumberHelp" class="form-text">Input your Tax Number. Must be Unique!</div>
                </div>

                <div class="mb-3">
                    <label for="birthday" class="form-label">Birthday:</label>
                    <input type="date" class="form-control" name="birthday" aria-describedby="birthdayHelp">
                    <div id="birthdayHelp" class="form-text">Input your Birthday</div>
                </div>

                <div class="mb-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" class="form-control" name="username" aria-describedby="usernameHelp">
                    <div id="usernameHelp" class="form-text">Input your Username. Must be Unique!</div>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" name="password" aria-describedby="passwordHelp">
                    <div id="passwordHelp" class="form-text">Input your Password. Don't share password!</div>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" name="email" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">Input your Email. Must be Unique!</div>
                </div>

                <button type="submit" class="btn btn-dark">Registration</button>
            </form>
        </div>
        <div class="col"></div>
    </div>
</@common.page>