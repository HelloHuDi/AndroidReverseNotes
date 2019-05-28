package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class b {
    private static HashMap<String, c> vdj = new HashMap();
    private static HashMap<String, d> vdk = new HashMap();

    static {
        AppMethodBeat.i(79426);
        AppMethodBeat.o(79426);
    }

    public static boolean a(final Activity activity, final String str, final int i, String str2, String str3) {
        AppMethodBeat.i(79412);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.o(79412);
                    return true;
                }
                if (bo.isNullOrNil(str3)) {
                    a.a(activity, new String[]{str}, i);
                } else {
                    h.a((Context) activity, str3, str2, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(79411);
                            dialogInterface.dismiss();
                            a.a(activity, new String[]{str}, i);
                            AppMethodBeat.o(79411);
                        }
                    });
                }
                AppMethodBeat.o(79412);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
                AppMethodBeat.o(79412);
                return true;
            }
        }
        AppMethodBeat.o(79412);
        return true;
    }

    public static boolean ai(Activity activity) {
        AppMethodBeat.i(79413);
        ab.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(g(activity, "android.permission.WRITE_EXTERNAL_STORAGE")));
        if (g(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            ab.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(g(activity, "android.permission.READ_PHONE_STATE")));
            if (g(activity, "android.permission.READ_PHONE_STATE")) {
                AppMethodBeat.o(79413);
                return true;
            }
            AppMethodBeat.o(79413);
            return false;
        }
        AppMethodBeat.o(79413);
        return false;
    }

    private static boolean g(Activity activity, String str) {
        AppMethodBeat.i(79414);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.o(79414);
                    return true;
                }
                AppMethodBeat.o(79414);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
                AppMethodBeat.o(79414);
                return true;
            }
        }
        AppMethodBeat.o(79414);
        return true;
    }

    public static boolean o(Context context, String str) {
        AppMethodBeat.i(79415);
        boolean j = j(context, str, true);
        AppMethodBeat.o(79415);
        return j;
    }

    public static boolean j(Context context, String str, boolean z) {
        AppMethodBeat.i(79416);
        try {
            int checkSelfPermission = android.support.v4.content.b.checkSelfPermission(context, str);
            if (checkSelfPermission != 0) {
                AppMethodBeat.o(79416);
                return false;
            } else if (z) {
                int i;
                String str2 = null;
                if (str.equals("android.permission.READ_CONTACTS")) {
                    str2 = "android.permission.WRITE_CONTACTS";
                } else if (str.equals("android.permission.WRITE_CONTACTS")) {
                    str2 = "android.permission.READ_CONTACTS";
                }
                if (bo.isNullOrNil(str2)) {
                    i = checkSelfPermission;
                } else {
                    try {
                        i = android.support.v4.content.b.checkSelfPermission(context, str2);
                    } catch (Exception e) {
                        ab.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", e);
                        AppMethodBeat.o(79416);
                        return false;
                    }
                }
                if (i == 0) {
                    AppMethodBeat.o(79416);
                    return true;
                }
                AppMethodBeat.o(79416);
                return false;
            } else {
                AppMethodBeat.o(79416);
                return true;
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
            AppMethodBeat.o(79416);
            return false;
        }
    }

    public static void b(Activity activity, String str, int i) {
        AppMethodBeat.i(79417);
        a.a(activity, new String[]{str}, i);
        AppMethodBeat.o(79417);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        AppMethodBeat.i(79418);
        a.a(activity, strArr, i);
        AppMethodBeat.o(79418);
    }

    public static void a(c cVar, String[] strArr) {
        AppMethodBeat.i(79419);
        ab.i("MicroMsg.MPermissionUtil", "requestPermission requestCode:%s", Integer.valueOf(1001));
        Context context = ah.getContext();
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = 0;
        }
        if (VERSION.SDK_INT < 23 || e(context, strArr)) {
            cVar.r(iArr);
            AppMethodBeat.o(79419);
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        vdj.put(valueOf, cVar);
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("scene", 1);
        intent.putExtra("requestCode", 1001);
        intent.putExtra("permission", strArr);
        intent.putExtra("key", valueOf);
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.o(79419);
    }

    public static void a(Intent intent, String str, String str2, d dVar) {
        AppMethodBeat.i(79420);
        ab.i("MicroMsg.MPermissionUtil", "startSettings reasonTitle:%s, reasonMsg:%s", str, str2);
        String valueOf = String.valueOf(System.currentTimeMillis());
        vdk.put(valueOf, dVar);
        Context context = ah.getContext();
        Intent intent2 = new Intent(context, PermissionActivity.class);
        intent2.putExtra("scene", 2);
        intent2.setSelector(intent);
        intent2.putExtra("key", valueOf);
        intent2.putExtra("reasonTitle", str);
        intent2.putExtra("reasonMsg", str2);
        intent2.addFlags(268435456);
        context.startActivity(intent2);
        AppMethodBeat.o(79420);
    }

    public static void a(Intent intent, d dVar) {
        AppMethodBeat.i(79421);
        a(intent, "", "", dVar);
        AppMethodBeat.o(79421);
    }

    public static boolean e(Context context, String... strArr) {
        AppMethodBeat.i(79422);
        if (strArr.length == 0) {
            AppMethodBeat.o(79422);
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            if (bz(context, strArr[i])) {
                i++;
            } else {
                AppMethodBeat.o(79422);
                return false;
            }
        }
        AppMethodBeat.o(79422);
        return true;
    }

    private static boolean bz(Context context, String str) {
        AppMethodBeat.i(79423);
        try {
            if (android.support.v4.content.b.checkSelfPermission(context, str) != 0) {
                AppMethodBeat.o(79423);
                return false;
            }
            AppMethodBeat.o(79423);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
            AppMethodBeat.o(79423);
            return false;
        }
    }

    static c aiT(String str) {
        AppMethodBeat.i(79424);
        c cVar = (c) vdj.remove(str);
        AppMethodBeat.o(79424);
        return cVar;
    }

    static d aiU(String str) {
        AppMethodBeat.i(79425);
        d dVar = (d) vdk.remove(str);
        AppMethodBeat.o(79425);
        return dVar;
    }
}
