package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class AccountPicker {
    public static final int CUSTOM_THEME_ACCOUNT_CHIPS = 2;
    public static final int CUSTOM_THEME_GAMES = 1;
    public static final int CUSTOM_THEME_NONE = 0;
    public static final String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
    public static final String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
    public static final String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
    public static final String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
    public static final String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
    public static final String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
    public static final String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
    public static final String EXTRA_HOSTED_DOMAIN_FILTER = "hostedDomainFilter";
    public static final String EXTRA_IS_ACCOUNT_CHIPS_ACCOUNT_PICKER = "pickedFromAccountChips";
    public static final String EXTRA_OVERRIDE_CUSTOM_THEME = "overrideCustomTheme";
    public static final String EXTRA_OVERRIDE_THEME = "overrideTheme";
    public static final String EXTRA_REAL_CLIENT_PACKAGE = "realClientPackage";
    public static final String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
    public static final String EXTRA_SET_GMS_CORE_ACCOUNT = "setGmsCoreAccount";
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_LIGHT = 1;

    private AccountPicker() {
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        AppMethodBeat.i(89334);
        Intent newChooseAccountIntent = newChooseAccountIntent(account, arrayList, strArr, z, str, str2, strArr2, bundle, false);
        AppMethodBeat.o(89334);
        return newChooseAccountIntent;
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2) {
        AppMethodBeat.i(89335);
        Intent newChooseAccountIntent = newChooseAccountIntent(account, arrayList, strArr, z, str, str2, strArr2, bundle, z2, 0, 0);
        AppMethodBeat.o(89335);
        return newChooseAccountIntent;
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2, int i, int i2) {
        AppMethodBeat.i(89336);
        Intent newChooseAccountIntent = newChooseAccountIntent(account, arrayList, strArr, z, str, str2, strArr2, bundle, z2, i, i2, null, false);
        AppMethodBeat.o(89336);
        return newChooseAccountIntent;
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2, int i, int i2, String str3, boolean z3) {
        AppMethodBeat.i(89337);
        Intent intent = new Intent();
        if (!z3) {
            Preconditions.checkArgument(str3 == null, "We only support hostedDomain filter for account chip styled account picker");
        }
        intent.setAction(z3 ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z);
        intent.putExtra(EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra(EXTRA_SET_GMS_CORE_ACCOUNT, z2);
        intent.putExtra(EXTRA_OVERRIDE_THEME, i);
        intent.putExtra(EXTRA_OVERRIDE_CUSTOM_THEME, i2);
        intent.putExtra(EXTRA_HOSTED_DOMAIN_FILTER, str3);
        AppMethodBeat.o(89337);
        return intent;
    }
}
