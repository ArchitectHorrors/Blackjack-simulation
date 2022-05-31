package com.company.BlackJack;

import java.util.Locale;

public enum Action {
    BLOCK_MYSELF, YES, NO;

    public static Action stringValueOf(String action){
        final String confirmation = "YES";
        String actionUpper = action.toUpperCase();
        if (actionUpper.equals(confirmation) || action.equalsIgnoreCase(confirmation)) {
            return YES;
        }
        return NO;
    }
}
