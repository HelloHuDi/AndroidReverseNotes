package com.tencent.p177mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.p057v4.app.C6184a;
import android.support.p057v4.content.C0380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.pluginsdk.permission.b */
public final class C35805b {
    private static HashMap<String, C35807c> vdj = new HashMap();
    private static HashMap<String, C35808d> vdk = new HashMap();

    static {
        AppMethodBeat.m2504i(79426);
        AppMethodBeat.m2505o(79426);
    }

    /* renamed from: a */
    public static boolean m58707a(final Activity activity, final String str, final int i, String str2, String str3) {
        AppMethodBeat.m2504i(79412);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (C0380b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.m2505o(79412);
                    return true;
                }
                if (C5046bo.isNullOrNil(str3)) {
                    C6184a.m9880a(activity, new String[]{str}, i);
                } else {
                    C30379h.m48448a((Context) activity, str3, str2, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(79411);
                            dialogInterface.dismiss();
                            C6184a.m9880a(activity, new String[]{str}, i);
                            AppMethodBeat.m2505o(79411);
                        }
                    });
                }
                AppMethodBeat.m2505o(79412);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
                AppMethodBeat.m2505o(79412);
                return true;
            }
        }
        AppMethodBeat.m2505o(79412);
        return true;
    }

    /* renamed from: ai */
    public static boolean m58708ai(Activity activity) {
        AppMethodBeat.m2504i(79413);
        C4990ab.m7417i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(C35805b.m58712g(activity, "android.permission.WRITE_EXTERNAL_STORAGE")));
        if (C35805b.m58712g(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            C4990ab.m7417i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(C35805b.m58712g(activity, "android.permission.READ_PHONE_STATE")));
            if (C35805b.m58712g(activity, "android.permission.READ_PHONE_STATE")) {
                AppMethodBeat.m2505o(79413);
                return true;
            }
            AppMethodBeat.m2505o(79413);
            return false;
        }
        AppMethodBeat.m2505o(79413);
        return false;
    }

    /* renamed from: g */
    private static boolean m58712g(Activity activity, String str) {
        AppMethodBeat.m2504i(79414);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (C0380b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.m2505o(79414);
                    return true;
                }
                AppMethodBeat.m2505o(79414);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
                AppMethodBeat.m2505o(79414);
                return true;
            }
        }
        AppMethodBeat.m2505o(79414);
        return true;
    }

    /* renamed from: o */
    public static boolean m58714o(Context context, String str) {
        AppMethodBeat.m2504i(79415);
        boolean j = C35805b.m58713j(context, str, true);
        AppMethodBeat.m2505o(79415);
        return j;
    }

    /* renamed from: j */
    public static boolean m58713j(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(79416);
        try {
            int checkSelfPermission = C0380b.checkSelfPermission(context, str);
            if (checkSelfPermission != 0) {
                AppMethodBeat.m2505o(79416);
                return false;
            } else if (z) {
                int i;
                String str2 = null;
                if (str.equals("android.permission.READ_CONTACTS")) {
                    str2 = "android.permission.WRITE_CONTACTS";
                } else if (str.equals("android.permission.WRITE_CONTACTS")) {
                    str2 = "android.permission.READ_CONTACTS";
                }
                if (C5046bo.isNullOrNil(str2)) {
                    i = checkSelfPermission;
                } else {
                    try {
                        i = C0380b.checkSelfPermission(context, str2);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", e);
                        AppMethodBeat.m2505o(79416);
                        return false;
                    }
                }
                if (i == 0) {
                    AppMethodBeat.m2505o(79416);
                    return true;
                }
                AppMethodBeat.m2505o(79416);
                return false;
            } else {
                AppMethodBeat.m2505o(79416);
                return true;
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
            AppMethodBeat.m2505o(79416);
            return false;
        }
    }

    /* renamed from: b */
    public static void m58709b(Activity activity, String str, int i) {
        AppMethodBeat.m2504i(79417);
        C6184a.m9880a(activity, new String[]{str}, i);
        AppMethodBeat.m2505o(79417);
    }

    /* renamed from: a */
    public static void m58703a(Activity activity, String[] strArr, int i) {
        AppMethodBeat.m2504i(79418);
        C6184a.m9880a(activity, strArr, i);
        AppMethodBeat.m2505o(79418);
    }

    /* renamed from: a */
    public static void m58706a(C35807c c35807c, String[] strArr) {
        AppMethodBeat.m2504i(79419);
        C4990ab.m7417i("MicroMsg.MPermissionUtil", "requestPermission requestCode:%s", Integer.valueOf(1001));
        Context context = C4996ah.getContext();
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = 0;
        }
        if (VERSION.SDK_INT < 23 || C35805b.m58711e(context, strArr)) {
            c35807c.mo54547r(iArr);
            AppMethodBeat.m2505o(79419);
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        vdj.put(valueOf, c35807c);
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("scene", 1);
        intent.putExtra("requestCode", 1001);
        intent.putExtra("permission", strArr);
        intent.putExtra("key", valueOf);
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.m2505o(79419);
    }

    /* renamed from: a */
    public static void m58705a(Intent intent, String str, String str2, C35808d c35808d) {
        AppMethodBeat.m2504i(79420);
        C4990ab.m7417i("MicroMsg.MPermissionUtil", "startSettings reasonTitle:%s, reasonMsg:%s", str, str2);
        String valueOf = String.valueOf(System.currentTimeMillis());
        vdk.put(valueOf, c35808d);
        Context context = C4996ah.getContext();
        Intent intent2 = new Intent(context, PermissionActivity.class);
        intent2.putExtra("scene", 2);
        intent2.setSelector(intent);
        intent2.putExtra("key", valueOf);
        intent2.putExtra("reasonTitle", str);
        intent2.putExtra("reasonMsg", str2);
        intent2.addFlags(268435456);
        context.startActivity(intent2);
        AppMethodBeat.m2505o(79420);
    }

    /* renamed from: a */
    public static void m58704a(Intent intent, C35808d c35808d) {
        AppMethodBeat.m2504i(79421);
        C35805b.m58705a(intent, "", "", c35808d);
        AppMethodBeat.m2505o(79421);
    }

    /* renamed from: e */
    public static boolean m58711e(Context context, String... strArr) {
        AppMethodBeat.m2504i(79422);
        if (strArr.length == 0) {
            AppMethodBeat.m2505o(79422);
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            if (C35805b.m58710bz(context, strArr[i])) {
                i++;
            } else {
                AppMethodBeat.m2505o(79422);
                return false;
            }
        }
        AppMethodBeat.m2505o(79422);
        return true;
    }

    /* renamed from: bz */
    private static boolean m58710bz(Context context, String str) {
        AppMethodBeat.m2504i(79423);
        try {
            if (C0380b.checkSelfPermission(context, str) != 0) {
                AppMethodBeat.m2505o(79423);
                return false;
            }
            AppMethodBeat.m2505o(79423);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
            AppMethodBeat.m2505o(79423);
            return false;
        }
    }

    static C35807c aiT(String str) {
        AppMethodBeat.m2504i(79424);
        C35807c c35807c = (C35807c) vdj.remove(str);
        AppMethodBeat.m2505o(79424);
        return c35807c;
    }

    static C35808d aiU(String str) {
        AppMethodBeat.m2504i(79425);
        C35808d c35808d = (C35808d) vdk.remove(str);
        AppMethodBeat.m2505o(79425);
        return c35808d;
    }
}
