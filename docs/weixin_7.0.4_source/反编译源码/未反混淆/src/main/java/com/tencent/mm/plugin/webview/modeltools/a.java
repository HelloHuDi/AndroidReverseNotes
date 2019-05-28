package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class a {
    public static void e(Activity activity, String str) {
        AppMethodBeat.i(6910);
        if (activity == null || activity.isFinishing() || bo.isNullOrNil(str)) {
            AppMethodBeat.o(6910);
            return;
        }
        if (!(str.startsWith("http://") || str.startsWith("https://"))) {
            str = "http://".concat(String.valueOf(str));
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            if (bo.gT(activity) || g.dnY()) {
                activity.startActivity(intent);
                AppMethodBeat.o(6910);
                return;
            }
            activity.startActivityForResult(a(activity, intent, str), 2);
            AppMethodBeat.o(6910);
        } catch (Exception e) {
            ab.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e.getMessage());
            AppMethodBeat.o(6910);
        }
    }

    public static Intent a(Activity activity, Intent intent, String str) {
        AppMethodBeat.i(6911);
        Bundle bundle = new Bundle();
        bundle.putString("targeturl", str);
        bundle.putParcelable("targetintent", intent);
        Intent intent2 = new Intent();
        intent2.setClass(activity, AppChooserUI.class);
        intent2.putExtra("scene", 4);
        intent2.putExtra("type", 0);
        intent2.putExtra("title", activity.getString(R.string.ape));
        intent2.putExtra("targetintent", intent);
        intent2.putExtra("transferback", bundle);
        AppMethodBeat.o(6911);
        return intent2;
    }

    public static boolean d(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.i(6912);
        if (2 == i) {
            if (-1 == i2 && intent != null) {
                String stringExtra = intent.getStringExtra("selectpkg");
                Bundle bundleExtra = intent.getBundleExtra("transferback");
                boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                ab.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", stringExtra);
                s.dhn();
                o oVar = (o) s.y(0, null);
                Intent intent2;
                if (oVar.aix(stringExtra)) {
                    if (oVar.fE(activity)) {
                        o.bv(activity, bundleExtra.getString("targeturl"));
                    } else {
                        intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                        intent2.setPackage(stringExtra);
                        intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                        activity.startActivity(intent2);
                    }
                    if (booleanExtra) {
                        h.pYm.e(10998, Integer.valueOf(4), Integer.valueOf(2));
                    } else {
                        h.pYm.e(10998, Integer.valueOf(4), Integer.valueOf(1));
                    }
                } else {
                    intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                    intent2.setPackage(stringExtra);
                    intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                    try {
                        activity.startActivity(intent2);
                    } catch (Exception e) {
                        ab.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", e.getMessage());
                    }
                    h.pYm.e(10998, Integer.valueOf(5));
                    if (booleanExtra) {
                        h.pYm.e(10998, Integer.valueOf(5), Integer.valueOf(2));
                    } else {
                        h.pYm.e(10998, Integer.valueOf(5), Integer.valueOf(1));
                    }
                }
            }
            AppMethodBeat.o(6912);
            return true;
        }
        AppMethodBeat.o(6912);
        return false;
    }
}
