package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.google.android.gms.common.internal.Constants;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.regex.Pattern;

public final class w {

    public interface a {
        void o(Bundle bundle);
    }

    public static int a(Context context, a aVar) {
        AppMethodBeat.i(124565);
        if (context == null) {
            ab.e("MicroMsg.MMAccountManager", "context is null");
            AppMethodBeat.o(124565);
            return 0;
        }
        String anQ = anQ();
        if (bo.isNullOrNil(anQ)) {
            ab.e("MicroMsg.MMAccountManager", "account username is null or nil");
            anQ = (String) g.RP().Ry().get(6, (Object) "");
            if (bo.isNullOrNil(anQ)) {
                AppMethodBeat.o(124565);
                return 0;
            }
        }
        if (K(context, anQ)) {
            AppMethodBeat.o(124565);
            return 3;
        } else if (b.o(context, "android.permission.READ_CONTACTS")) {
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(anQ, "com.tencent.mm.account");
                if (accountManager.addAccountExplicitly(account, "", null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", anQ);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (aVar != null) {
                        aVar.o(bundle);
                    }
                    AppMethodBeat.o(124565);
                    return 1;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                ab.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e.getMessage());
            }
            if (aVar != null) {
                aVar.o(null);
            }
            AppMethodBeat.o(124565);
            return 2;
        } else {
            AppMethodBeat.o(124565);
            return 2;
        }
    }

    public static int a(Context context, String str, a aVar) {
        AppMethodBeat.i(124566);
        if (context == null) {
            ab.e("MicroMsg.MMAccountManager", "activity is null");
            AppMethodBeat.o(124566);
            return 0;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MMAccountManager", "account username is null or nil");
            AppMethodBeat.o(124566);
            return 0;
        } else {
            String anQ = anQ();
            if (!bo.isNullOrNil(anQ)) {
                str = anQ;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!b.o(context, "android.permission.READ_CONTACTS")) {
                    AppMethodBeat.o(124566);
                    return 2;
                } else if (K(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    AppMethodBeat.o(124566);
                    return 3;
                } else {
                    I(context, null);
                    if (accountManager.addAccountExplicitly(account, "", null)) {
                        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                        Bundle bundle = new Bundle();
                        bundle.putString("authAccount", str);
                        bundle.putString("accountType", "com.tencent.mm.account");
                        if (aVar != null) {
                            aVar.o(bundle);
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.KEY_ACCOUNT_NAME, str);
                        contentValues.put("account_type", "com.tencent.mm.account");
                        contentValues.put("should_sync", Integer.valueOf(1));
                        contentValues.put("ungrouped_visible", Integer.valueOf(1));
                        context.getContentResolver().insert(Settings.CONTENT_URI, contentValues);
                        AppMethodBeat.o(124566);
                        return 1;
                    }
                    if (aVar != null) {
                        aVar.o(null);
                    }
                    AppMethodBeat.o(124566);
                    return 2;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                ab.e("MicroMsg.MMAccountManager", "exception in addAccount() " + e.getMessage());
            }
        }
    }

    public static void cm(Context context) {
        AppMethodBeat.i(124567);
        d.dlL();
        if (com.tencent.mm.sdk.platformtools.g.cdl == 0) {
            ab.d("MicroMsg.MMAccountManager", "do not auto add account");
            AppMethodBeat.o(124567);
        } else if (com.tencent.mm.sdk.platformtools.g.cdl != 1) {
            if (com.tencent.mm.sdk.platformtools.g.cdl == 2) {
                ab.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(context, null))));
            }
            AppMethodBeat.o(124567);
        } else if (l.apS() == com.tencent.mm.plugin.account.friend.a.l.a.SUCC) {
            ab.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(context, l.apU(), null))));
            AppMethodBeat.o(124567);
        } else {
            ab.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
            AppMethodBeat.o(124567);
        }
    }

    public static boolean I(Context context, String str) {
        AppMethodBeat.i(124568);
        boolean isNullOrNil = bo.isNullOrNil(str);
        ab.v("MicroMsg.MMAccountManager", "remove account : ".concat(String.valueOf(str)));
        if (context == null) {
            ab.e("MicroMsg.MMAccountManager", "null context");
            AppMethodBeat.o(124568);
            return false;
        }
        try {
            Account[] cs = cs(context);
            if (cs == null || cs.length == 0) {
                ab.d("MicroMsg.MMAccountManager", "get account info is null or nil");
                AppMethodBeat.o(124568);
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : cs) {
                if (isNullOrNil) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    ab.i("MicroMsg.MMAccountManager", "remove account success: ".concat(String.valueOf(str)));
                }
            }
            AppMethodBeat.o(124568);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            ab.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e.getMessage());
            AppMethodBeat.o(124568);
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public static boolean cn(Context context) {
        AppMethodBeat.i(124569);
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", anQ());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = I(context, anQ());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        AppMethodBeat.o(124569);
        return z;
    }

    private static String anQ() {
        AppMethodBeat.i(124570);
        String str;
        if (g.RK()) {
            String str2 = "";
            str = (String) g.RP().Ry().get(4, null);
            if (bo.isNullOrNil(str)) {
                str = r.YA();
                if (bo.isNullOrNil(str)) {
                    str = r.Yz();
                    if (bo.isNullOrNil(str) || ad.aoA(str)) {
                        str = str2;
                    }
                }
            }
            str = vu(str);
            AppMethodBeat.o(124570);
            return str;
        }
        ab.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
        str = "";
        AppMethodBeat.o(124570);
        return str;
    }

    public static void co(Context context) {
        AppMethodBeat.i(124571);
        if (cp(context)) {
            com.tencent.mm.sdk.g.d.h(new h(context, cr(context)), "MMAccountManager_updateAllContact").start();
            AppMethodBeat.o(124571);
            return;
        }
        I(context, null);
        ab.d("MicroMsg.MMAccountManager", "no account added or not current account");
        AppMethodBeat.o(124571);
    }

    public static void n(Context context, String str, String str2) {
        AppMethodBeat.i(124572);
        if (cp(context)) {
            com.tencent.mm.sdk.g.d.h(new h(context, cr(context), str, str2), "MMAccountManager_updateSpecifiedContact").start();
            AppMethodBeat.o(124572);
            return;
        }
        I(context, null);
        ab.d("MicroMsg.MMAccountManager", "no account added or not current account");
        AppMethodBeat.o(124572);
    }

    public static void J(Context context, String str) {
        AppMethodBeat.i(124573);
        if (cp(context)) {
            com.tencent.mm.sdk.g.d.h(new h(context, cr(context), str), "MMAccountManager_deleteSpecifiedContact").start();
            AppMethodBeat.o(124573);
            return;
        }
        I(context, null);
        ab.d("MicroMsg.MMAccountManager", "no account added or not current account");
        AppMethodBeat.o(124573);
    }

    private static boolean cp(Context context) {
        AppMethodBeat.i(124574);
        Account cr = cr(context);
        if (cr == null) {
            AppMethodBeat.o(124574);
            return false;
        } else if (cr.name.equals(anQ())) {
            AppMethodBeat.o(124574);
            return true;
        } else {
            AppMethodBeat.o(124574);
            return false;
        }
    }

    public static boolean cq(Context context) {
        AppMethodBeat.i(124575);
        if (!cp(context)) {
            ab.e("MicroMsg.MMAccountManager", "no account added or not current account");
            AppMethodBeat.o(124575);
            return false;
        } else if (b.o(context, "android.permission.READ_CONTACTS")) {
            Account cr = cr(context);
            if (cr != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(cr, "com.android.contacts", bundle);
                AppMethodBeat.o(124575);
                return true;
            }
            ab.e("MicroMsg.MMAccountManager", "no account added");
            AppMethodBeat.o(124575);
            return false;
        } else {
            AppMethodBeat.o(124575);
            return false;
        }
    }

    private static Account cr(Context context) {
        AppMethodBeat.i(124576);
        String anQ = anQ();
        if (bo.isNullOrNil(anQ)) {
            anQ = (String) g.RP().Ry().get(6, (Object) "");
        }
        if (!bo.isNullOrNil(anQ)) {
            Account[] cs = cs(context);
            if (cs == null) {
                AppMethodBeat.o(124576);
                return null;
            }
            for (Account account : cs) {
                if (account.name.equals(anQ)) {
                    AppMethodBeat.o(124576);
                    return account;
                }
            }
        }
        AppMethodBeat.o(124576);
        return null;
    }

    private static Account[] cs(Context context) {
        AppMethodBeat.i(124577);
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
            AppMethodBeat.o(124577);
            return accountsByType;
        } catch (Exception e) {
            ab.e("MicroMsg.MMAccountManager", "get all accounts failed");
            ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            AppMethodBeat.o(124577);
            return null;
        }
    }

    private static boolean K(Context context, String str) {
        AppMethodBeat.i(124578);
        Account[] cs = cs(context);
        if (cs == null || cs.length == 0) {
            AppMethodBeat.o(124578);
            return false;
        }
        for (Account account : cs) {
            if (account.name.equals(str)) {
                AppMethodBeat.o(124578);
                return true;
            }
        }
        AppMethodBeat.o(124578);
        return false;
    }

    private static Account[] L(Context context, String str) {
        AppMethodBeat.i(124579);
        Account[] accountArr = null;
        try {
            accountArr = AccountManager.get(context).getAccountsByType(str);
        } catch (Exception e) {
            ab.e("MicroMsg.MMAccountManager", "get all accounts failed");
            ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
        }
        AppMethodBeat.o(124579);
        return accountArr;
    }

    public static String ct(Context context) {
        AppMethodBeat.i(124580);
        Account[] L = L(context, "com.google");
        String str = null;
        if (L != null && L.length > 0) {
            for (Account account : L) {
                str = account.name;
                if (!bo.isNullOrNil(str) && bo.amW(str)) {
                    break;
                }
            }
        }
        AppMethodBeat.o(124580);
        return str;
    }

    private static String vu(String str) {
        AppMethodBeat.i(124581);
        try {
            str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
            AppMethodBeat.o(124581);
        } catch (Exception e) {
            ab.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", str, e.getMessage());
            ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            AppMethodBeat.o(124581);
        }
        return str;
    }
}
