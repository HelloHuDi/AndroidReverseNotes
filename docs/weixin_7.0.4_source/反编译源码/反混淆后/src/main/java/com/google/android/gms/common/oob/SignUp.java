package com.google.android.gms.common.oob;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class SignUp {
    public static final String ACTION_OOB_SIGN_UP = "com.google.android.gms.common.oob.OOB_SIGN_UP";
    public static final String EXTRAS_CALLING_APP_DESCRIPTION = "com.google.android.gms.common.oob.EXTRAS_APP_DESCRIPTION";
    public static final String EXTRAS_CLIENT_CALLING_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_CLIENT_CALLING_APP_PACKAGE";
    public static final String EXTRAS_PROMO_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE";
    public static final String EXTRAS_PROMO_APP_TEXT = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT";
    public static final String EXTRA_ACCOUNT_NAME = "com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME";
    public static final String EXTRA_BACK_BUTTON_NAME = "com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME";
    public static final String EXTRA_GPSRC = "com.google.android.gms.plus.GPSRC";
    public static final String EXTRA_OVERRIDE_THEME = "com.google.android.gms.plus.OVERRIDE_THEME";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = BaseGmsClient.GOOGLE_PLUS_REQUIRED_FEATURES;
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_FULL = 1;
    public static final int THEME_SETUP_WIZARD = 2;

    private SignUp() {
    }

    public static AccountManagerFuture<Boolean> checkSignUpState(Context context, String str, String[] strArr, AccountManagerCallback<Boolean> accountManagerCallback, Handler handler) {
        AppMethodBeat.m2504i(61413);
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "The accountName is required");
        Preconditions.checkArgument(strArr != null, "The requiredFeatures parameter is required");
        AccountManager accountManager = AccountManager.get(context);
        Object obj = null;
        for (Account account : accountManager.getAccountsByType("com.google")) {
            if (str.equals(account.name)) {
                obj = 1;
            }
        }
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Given account does not exist on the device");
            AppMethodBeat.m2505o(61413);
            throw illegalStateException;
        }
        AccountManagerFuture hasFeatures = accountManager.hasFeatures(new Account(str, "com.google"), strArr, accountManagerCallback, handler);
        AppMethodBeat.m2505o(61413);
        return hasFeatures;
    }

    public static boolean isSignedUpBlocking(Context context, String str, String[] strArr) {
        AppMethodBeat.m2504i(61414);
        boolean booleanValue = ((Boolean) checkSignUpState(context, str, strArr, null, null).getResult()).booleanValue();
        AppMethodBeat.m2505o(61414);
        return booleanValue;
    }

    public static Intent newSignUpIntent(String str) {
        AppMethodBeat.m2504i(61410);
        Intent newSignUpIntent = newSignUpIntent(str, null);
        AppMethodBeat.m2505o(61410);
        return newSignUpIntent;
    }

    public static Intent newSignUpIntent(String str, String str2) {
        AppMethodBeat.m2504i(61411);
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(ACTION_OOB_SIGN_UP);
        intent.putExtra(EXTRA_ACCOUNT_NAME, str);
        intent.putExtra(EXTRA_BACK_BUTTON_NAME, str2);
        AppMethodBeat.m2505o(61411);
        return intent;
    }

    public static Intent newSignUpIntent(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(61412);
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(ACTION_OOB_SIGN_UP);
        intent.putExtra(EXTRA_ACCOUNT_NAME, str);
        intent.putExtra(EXTRA_BACK_BUTTON_NAME, str2);
        intent.putExtra(EXTRAS_PROMO_APP_PACKAGE, str3);
        intent.putExtra(EXTRAS_PROMO_APP_TEXT, str4);
        AppMethodBeat.m2505o(61412);
        return intent;
    }
}
