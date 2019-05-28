package com.tencent.luggage.g;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.v4.app.a;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g {
    public static boolean a(final Activity activity, final String str, final int i, String str2, String str3) {
        AppMethodBeat.i(90907);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.o(90907);
                    return true;
                }
                if (bo.isNullOrNil(str3)) {
                    a.a(activity, new String[]{str}, i);
                } else {
                    AnonymousClass1 anonymousClass1 = new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(90906);
                            dialogInterface.dismiss();
                            a.a(activity, new String[]{str}, i);
                            AppMethodBeat.o(90906);
                        }
                    };
                    String string = activity.getString(R.string.dbw);
                    String string2 = activity.getString(R.string.dbv);
                    Builder builder = new Builder(activity);
                    builder.setMessage(str3).setTitle(str2).setCancelable(false).setPositiveButton(string, anonymousClass1).setNegativeButton(string2, null);
                    builder.show();
                }
                AppMethodBeat.o(90907);
                return false;
            } catch (Exception e) {
                ab.e("Luggage.PermissionUtil", "check mpermission exception:%s.", e);
                AppMethodBeat.o(90907);
                return true;
            }
        }
        AppMethodBeat.o(90907);
        return true;
    }

    public static boolean o(Context context, String str) {
        AppMethodBeat.i(90908);
        try {
            int checkSelfPermission = b.checkSelfPermission(context, str);
            if (checkSelfPermission != 0) {
                AppMethodBeat.o(90908);
                return false;
            }
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
                    i = b.checkSelfPermission(context, str2);
                } catch (Exception e) {
                    ab.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", e);
                    AppMethodBeat.o(90908);
                    return false;
                }
            }
            if (i == 0) {
                AppMethodBeat.o(90908);
                return true;
            }
            AppMethodBeat.o(90908);
            return false;
        } catch (Exception e2) {
            ab.e("Luggage.PermissionUtil", "check mpermission exception:%s.", e2);
            AppMethodBeat.o(90908);
            return false;
        }
    }
}
