// ============================================================================
//  File          : BankApplication
//  Created       : 06.10.2011   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2010 Zoral, Ukraine
// ============================================================================

package com.xpinjection.bank;

import net.thucydides.core.annotations.Feature;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class BankApplication {
    @Feature
    public class AccountsManagement {
        public class MultipleUsersSupport {}
        public class MultipleAccountsPerUser {}
        public class UserNameSuggestions {}
    }
    @Feature
    public class MoneyOperations {
        public class GetMoneyFromAccount {}
        public class PutMoneyToAccount {}
        public class TransferMoneyBetweenAccounts {}
    }
}


