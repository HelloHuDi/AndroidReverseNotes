package com.tencent.p177mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C14893s;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.AppChooserUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.a */
public final class C35618a {
    /* renamed from: e */
    public static void m58463e(Activity activity, String str) {
        AppMethodBeat.m2504i(6910);
        if (activity == null || activity.isFinishing() || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6910);
            return;
        }
        if (!(str.startsWith("http://") || str.startsWith("https://"))) {
            str = "http://".concat(String.valueOf(str));
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            if (C5046bo.m7558gT(activity) || C5059g.dnY()) {
                activity.startActivity(intent);
                AppMethodBeat.m2505o(6910);
                return;
            }
            activity.startActivityForResult(C35618a.m58461a(activity, intent, str), 2);
            AppMethodBeat.m2505o(6910);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e.getMessage());
            AppMethodBeat.m2505o(6910);
        }
    }

    /* renamed from: a */
    public static Intent m58461a(Activity activity, Intent intent, String str) {
        AppMethodBeat.m2504i(6911);
        Bundle bundle = new Bundle();
        bundle.putString("targeturl", str);
        bundle.putParcelable("targetintent", intent);
        Intent intent2 = new Intent();
        intent2.setClass(activity, AppChooserUI.class);
        intent2.putExtra("scene", 4);
        intent2.putExtra("type", 0);
        intent2.putExtra("title", activity.getString(C25738R.string.ape));
        intent2.putExtra("targetintent", intent);
        intent2.putExtra("transferback", bundle);
        AppMethodBeat.m2505o(6911);
        return intent2;
    }

    /* renamed from: d */
    public static boolean m58462d(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(6912);
        if (2 == i) {
            if (-1 == i2 && intent != null) {
                String stringExtra = intent.getStringExtra("selectpkg");
                Bundle bundleExtra = intent.getBundleExtra("transferback");
                boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                C4990ab.m7417i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", stringExtra);
                C14893s.dhn();
                C44065o c44065o = (C44065o) C14893s.m23163y(0, null);
                Intent intent2;
                if (c44065o.aix(stringExtra)) {
                    if (c44065o.mo27192fE(activity)) {
                        C44065o.m79202bv(activity, bundleExtra.getString("targeturl"));
                    } else {
                        intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                        intent2.setPackage(stringExtra);
                        intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                        activity.startActivity(intent2);
                    }
                    if (booleanExtra) {
                        C7060h.pYm.mo8381e(10998, Integer.valueOf(4), Integer.valueOf(2));
                    } else {
                        C7060h.pYm.mo8381e(10998, Integer.valueOf(4), Integer.valueOf(1));
                    }
                } else {
                    intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                    intent2.setPackage(stringExtra);
                    intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                    try {
                        activity.startActivity(intent2);
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", e.getMessage());
                    }
                    C7060h.pYm.mo8381e(10998, Integer.valueOf(5));
                    if (booleanExtra) {
                        C7060h.pYm.mo8381e(10998, Integer.valueOf(5), Integer.valueOf(2));
                    } else {
                        C7060h.pYm.mo8381e(10998, Integer.valueOf(5), Integer.valueOf(1));
                    }
                }
            }
            AppMethodBeat.m2505o(6912);
            return true;
        }
        AppMethodBeat.m2505o(6912);
        return false;
    }
}
