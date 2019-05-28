package com.tencent.luggage.p147g;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.p057v4.app.C6184a;
import android.support.p057v4.content.C0380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.luggage.g.g */
public final class C0991g {
    /* renamed from: a */
    public static boolean m2252a(final Activity activity, final String str, final int i, String str2, String str3) {
        AppMethodBeat.m2504i(90907);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (C0380b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.m2505o(90907);
                    return true;
                }
                if (C5046bo.isNullOrNil(str3)) {
                    C6184a.m9880a(activity, new String[]{str}, i);
                } else {
                    C09921 c09921 = new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(90906);
                            dialogInterface.dismiss();
                            C6184a.m9880a(activity, new String[]{str}, i);
                            AppMethodBeat.m2505o(90906);
                        }
                    };
                    String string = activity.getString(C25738R.string.dbw);
                    String string2 = activity.getString(C25738R.string.dbv);
                    Builder builder = new Builder(activity);
                    builder.setMessage(str3).setTitle(str2).setCancelable(false).setPositiveButton(string, c09921).setNegativeButton(string2, null);
                    builder.show();
                }
                AppMethodBeat.m2505o(90907);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("Luggage.PermissionUtil", "check mpermission exception:%s.", e);
                AppMethodBeat.m2505o(90907);
                return true;
            }
        }
        AppMethodBeat.m2505o(90907);
        return true;
    }

    /* renamed from: o */
    public static boolean m2253o(Context context, String str) {
        AppMethodBeat.m2504i(90908);
        try {
            int checkSelfPermission = C0380b.checkSelfPermission(context, str);
            if (checkSelfPermission != 0) {
                AppMethodBeat.m2505o(90908);
                return false;
            }
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
                    C4990ab.m7413e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", e);
                    AppMethodBeat.m2505o(90908);
                    return false;
                }
            }
            if (i == 0) {
                AppMethodBeat.m2505o(90908);
                return true;
            }
            AppMethodBeat.m2505o(90908);
            return false;
        } catch (Exception e2) {
            C4990ab.m7413e("Luggage.PermissionUtil", "check mpermission exception:%s.", e2);
            AppMethodBeat.m2505o(90908);
            return false;
        }
    }
}
