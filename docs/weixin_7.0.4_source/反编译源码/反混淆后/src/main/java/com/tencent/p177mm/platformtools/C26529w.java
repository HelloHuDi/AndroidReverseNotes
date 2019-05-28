package com.tencent.p177mm.platformtools;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.google.android.gms.common.internal.Constants;
import com.p802jg.EType;
import com.p802jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C7616ad;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.platformtools.w */
public final class C26529w {

    /* renamed from: com.tencent.mm.platformtools.w$a */
    public interface C26530a {
        /* renamed from: o */
        void mo5767o(Bundle bundle);
    }

    /* renamed from: a */
    public static int m42354a(Context context, C26530a c26530a) {
        AppMethodBeat.m2504i(124565);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "context is null");
            AppMethodBeat.m2505o(124565);
            return 0;
        }
        String anQ = C26529w.anQ();
        if (C5046bo.isNullOrNil(anQ)) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "account username is null or nil");
            anQ = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
            if (C5046bo.isNullOrNil(anQ)) {
                AppMethodBeat.m2505o(124565);
                return 0;
            }
        }
        if (C26529w.m42352K(context, anQ)) {
            AppMethodBeat.m2505o(124565);
            return 3;
        } else if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(anQ, "com.tencent.mm.account");
                if (accountManager.addAccountExplicitly(account, "", null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", anQ);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (c26530a != null) {
                        c26530a.mo5767o(bundle);
                    }
                    AppMethodBeat.m2505o(124565);
                    return 1;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e.getMessage());
            }
            if (c26530a != null) {
                c26530a.mo5767o(null);
            }
            AppMethodBeat.m2505o(124565);
            return 2;
        } else {
            AppMethodBeat.m2505o(124565);
            return 2;
        }
    }

    /* renamed from: a */
    public static int m42355a(Context context, String str, C26530a c26530a) {
        AppMethodBeat.m2504i(124566);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "activity is null");
            AppMethodBeat.m2505o(124566);
            return 0;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "account username is null or nil");
            AppMethodBeat.m2505o(124566);
            return 0;
        } else {
            String anQ = C26529w.anQ();
            if (!C5046bo.isNullOrNil(anQ)) {
                str = anQ;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
                    AppMethodBeat.m2505o(124566);
                    return 2;
                } else if (C26529w.m42352K(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    AppMethodBeat.m2505o(124566);
                    return 3;
                } else {
                    C26529w.m42350I(context, null);
                    if (accountManager.addAccountExplicitly(account, "", null)) {
                        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                        Bundle bundle = new Bundle();
                        bundle.putString("authAccount", str);
                        bundle.putString("accountType", "com.tencent.mm.account");
                        if (c26530a != null) {
                            c26530a.mo5767o(bundle);
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.KEY_ACCOUNT_NAME, str);
                        contentValues.put("account_type", "com.tencent.mm.account");
                        contentValues.put("should_sync", Integer.valueOf(1));
                        contentValues.put("ungrouped_visible", Integer.valueOf(1));
                        context.getContentResolver().insert(Settings.CONTENT_URI, contentValues);
                        AppMethodBeat.m2505o(124566);
                        return 1;
                    }
                    if (c26530a != null) {
                        c26530a.mo5767o(null);
                    }
                    AppMethodBeat.m2505o(124566);
                    return 2;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.MMAccountManager", "exception in addAccount() " + e.getMessage());
            }
        }
    }

    /* renamed from: cm */
    public static void m42356cm(Context context) {
        AppMethodBeat.m2504i(124567);
        C25985d.dlL();
        if (C5059g.cdl == 0) {
            C4990ab.m7410d("MicroMsg.MMAccountManager", "do not auto add account");
            AppMethodBeat.m2505o(124567);
        } else if (C5059g.cdl != 1) {
            if (C5059g.cdl == 2) {
                C4990ab.m7410d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(C26529w.m42354a(context, null))));
            }
            AppMethodBeat.m2505o(124567);
        } else if (C38033l.apS() == C38034a.SUCC) {
            C4990ab.m7410d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(C26529w.m42355a(context, C38033l.apU(), null))));
            AppMethodBeat.m2505o(124567);
        } else {
            C4990ab.m7416i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
            AppMethodBeat.m2505o(124567);
        }
    }

    /* renamed from: I */
    public static boolean m42350I(Context context, String str) {
        AppMethodBeat.m2504i(124568);
        boolean isNullOrNil = C5046bo.isNullOrNil(str);
        C4990ab.m7418v("MicroMsg.MMAccountManager", "remove account : ".concat(String.valueOf(str)));
        if (context == null) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "null context");
            AppMethodBeat.m2505o(124568);
            return false;
        }
        try {
            Account[] cs = C26529w.m42362cs(context);
            if (cs == null || cs.length == 0) {
                C4990ab.m7410d("MicroMsg.MMAccountManager", "get account info is null or nil");
                AppMethodBeat.m2505o(124568);
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : cs) {
                if (isNullOrNil) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    C4990ab.m7416i("MicroMsg.MMAccountManager", "remove account success: ".concat(String.valueOf(str)));
                }
            }
            AppMethodBeat.m2505o(124568);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e.getMessage());
            AppMethodBeat.m2505o(124568);
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    /* renamed from: cn */
    public static boolean m42357cn(Context context) {
        AppMethodBeat.m2504i(124569);
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", C26529w.anQ());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = C26529w.m42350I(context, C26529w.anQ());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        AppMethodBeat.m2505o(124569);
        return z;
    }

    private static String anQ() {
        AppMethodBeat.m2504i(124570);
        String str;
        if (C1720g.m3531RK()) {
            String str2 = "";
            str = (String) C1720g.m3536RP().mo5239Ry().get(4, null);
            if (C5046bo.isNullOrNil(str)) {
                str = C1853r.m3819YA();
                if (C5046bo.isNullOrNil(str)) {
                    str = C1853r.m3846Yz();
                    if (C5046bo.isNullOrNil(str) || C7616ad.aoA(str)) {
                        str = str2;
                    }
                }
            }
            str = C26529w.m42365vu(str);
            AppMethodBeat.m2505o(124570);
            return str;
        }
        C4990ab.m7412e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
        str = "";
        AppMethodBeat.m2505o(124570);
        return str;
    }

    /* renamed from: co */
    public static void m42358co(Context context) {
        AppMethodBeat.m2504i(124571);
        if (C26529w.m42359cp(context)) {
            C7305d.m12301h(new C32887h(context, C26529w.m42361cr(context)), "MMAccountManager_updateAllContact").start();
            AppMethodBeat.m2505o(124571);
            return;
        }
        C26529w.m42350I(context, null);
        C4990ab.m7410d("MicroMsg.MMAccountManager", "no account added or not current account");
        AppMethodBeat.m2505o(124571);
    }

    /* renamed from: n */
    public static void m42364n(Context context, String str, String str2) {
        AppMethodBeat.m2504i(124572);
        if (C26529w.m42359cp(context)) {
            C7305d.m12301h(new C32887h(context, C26529w.m42361cr(context), str, str2), "MMAccountManager_updateSpecifiedContact").start();
            AppMethodBeat.m2505o(124572);
            return;
        }
        C26529w.m42350I(context, null);
        C4990ab.m7410d("MicroMsg.MMAccountManager", "no account added or not current account");
        AppMethodBeat.m2505o(124572);
    }

    /* renamed from: J */
    public static void m42351J(Context context, String str) {
        AppMethodBeat.m2504i(124573);
        if (C26529w.m42359cp(context)) {
            C7305d.m12301h(new C32887h(context, C26529w.m42361cr(context), str), "MMAccountManager_deleteSpecifiedContact").start();
            AppMethodBeat.m2505o(124573);
            return;
        }
        C26529w.m42350I(context, null);
        C4990ab.m7410d("MicroMsg.MMAccountManager", "no account added or not current account");
        AppMethodBeat.m2505o(124573);
    }

    /* renamed from: cp */
    private static boolean m42359cp(Context context) {
        AppMethodBeat.m2504i(124574);
        Account cr = C26529w.m42361cr(context);
        if (cr == null) {
            AppMethodBeat.m2505o(124574);
            return false;
        } else if (cr.name.equals(C26529w.anQ())) {
            AppMethodBeat.m2505o(124574);
            return true;
        } else {
            AppMethodBeat.m2505o(124574);
            return false;
        }
    }

    /* renamed from: cq */
    public static boolean m42360cq(Context context) {
        AppMethodBeat.m2504i(124575);
        if (!C26529w.m42359cp(context)) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "no account added or not current account");
            AppMethodBeat.m2505o(124575);
            return false;
        } else if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
            Account cr = C26529w.m42361cr(context);
            if (cr != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(cr, "com.android.contacts", bundle);
                AppMethodBeat.m2505o(124575);
                return true;
            }
            C4990ab.m7412e("MicroMsg.MMAccountManager", "no account added");
            AppMethodBeat.m2505o(124575);
            return false;
        } else {
            AppMethodBeat.m2505o(124575);
            return false;
        }
    }

    /* renamed from: cr */
    private static Account m42361cr(Context context) {
        AppMethodBeat.m2504i(124576);
        String anQ = C26529w.anQ();
        if (C5046bo.isNullOrNil(anQ)) {
            anQ = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
        }
        if (!C5046bo.isNullOrNil(anQ)) {
            Account[] cs = C26529w.m42362cs(context);
            if (cs == null) {
                AppMethodBeat.m2505o(124576);
                return null;
            }
            for (Account account : cs) {
                if (account.name.equals(anQ)) {
                    AppMethodBeat.m2505o(124576);
                    return account;
                }
            }
        }
        AppMethodBeat.m2505o(124576);
        return null;
    }

    /* renamed from: cs */
    private static Account[] m42362cs(Context context) {
        AppMethodBeat.m2504i(124577);
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
            AppMethodBeat.m2505o(124577);
            return accountsByType;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "get all accounts failed");
            C4990ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(124577);
            return null;
        }
    }

    /* renamed from: K */
    private static boolean m42352K(Context context, String str) {
        AppMethodBeat.m2504i(124578);
        Account[] cs = C26529w.m42362cs(context);
        if (cs == null || cs.length == 0) {
            AppMethodBeat.m2505o(124578);
            return false;
        }
        for (Account account : cs) {
            if (account.name.equals(str)) {
                AppMethodBeat.m2505o(124578);
                return true;
            }
        }
        AppMethodBeat.m2505o(124578);
        return false;
    }

    /* renamed from: L */
    private static Account[] m42353L(Context context, String str) {
        AppMethodBeat.m2504i(124579);
        Account[] accountArr = null;
        try {
            accountArr = AccountManager.get(context).getAccountsByType(str);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMAccountManager", "get all accounts failed");
            C4990ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(124579);
        return accountArr;
    }

    /* renamed from: ct */
    public static String m42363ct(Context context) {
        AppMethodBeat.m2504i(124580);
        Account[] L = C26529w.m42353L(context, "com.google");
        String str = null;
        if (L != null && L.length > 0) {
            for (Account account : L) {
                str = account.name;
                if (!C5046bo.isNullOrNil(str) && C5046bo.amW(str)) {
                    break;
                }
            }
        }
        AppMethodBeat.m2505o(124580);
        return str;
    }

    /* renamed from: vu */
    private static String m42365vu(String str) {
        AppMethodBeat.m2504i(124581);
        try {
            str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
            AppMethodBeat.m2505o(124581);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", str, e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(124581);
        }
        return str;
    }
}
