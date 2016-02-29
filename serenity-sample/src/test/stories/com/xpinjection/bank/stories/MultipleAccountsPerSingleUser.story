package com.xpinjection.bank.stories

import com.xpinjection.bank.BankApplication.AccountsManagement.MultipleAccountsPerUser
import com.xpinjection.bank.steps.AccountSteps

using "thucydides"

thucydides.uses_default_base_url "http://localhost:8080"
thucydides.uses_steps_from AccountSteps
thucydides.tests_story MultipleAccountsPerUser

scenario "Register two accounts for the same user", {
    given "the user is on accounts management page", {
        account.openAccountsPage()
    }
    when "user 'Bob' creates account with amount '10'", {
        account.registerAccount "Bob", 10
    }
    and "user 'Bob' creates account with amount '20'", {
        account.registerAccount "Bob", 20
    }
    then "both accounts are created and unique"
}

