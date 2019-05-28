package com.tencent.p177mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog */
public class JDRemindDialog extends MMBaseActivity {
    private C5653c ggF = null;

    /* renamed from: com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog$1 */
    class C352701 implements OnClickListener {
        C352701() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25179);
            String str = null;
            String str2 = "";
            if (!(JDRemindDialog.this.getIntent() == null || JDRemindDialog.this.getIntent().getExtras() == null)) {
                str = JDRemindDialog.this.getIntent().getExtras().getString("alertjumpurl");
                str2 = JDRemindDialog.this.getIntent().getExtras().getString("alert_activityid");
            }
            if (str2.equals(C22337c.cDr().cDw().ssr) && C22337c.cDr().cDs()) {
                C22337c.cDr().cDv();
                C22337c.cDr().cDu();
            }
            if (!C5046bo.isNullOrNil(str)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                C25985d.m41467b(JDRemindDialog.this, "webview", ".ui.tools.WebViewUI", intent);
                C7060h.pYm.mo8381e(11179, str, C22337c.cDr().cDw().ssr, Integer.valueOf(5));
            }
            JDRemindDialog.this.finish();
            AppMethodBeat.m2505o(25179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog$2 */
    class C352712 implements OnClickListener {
        C352712() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25180);
            JDRemindDialog.this.finish();
            AppMethodBeat.m2505o(25180);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25181);
        super.onCreate(bundle);
        requestWindowFeature(1);
        aVh();
        AppMethodBeat.m2505o(25181);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25182);
        super.onResume();
        C5288y.activateBroadcast(true);
        AppMethodBeat.m2505o(25182);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(25183);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ggF != null) {
            this.ggF.dismiss();
            this.ggF = null;
        }
        aVh();
        AppMethodBeat.m2505o(25183);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25184);
        super.onPause();
        C5288y.activateBroadcast(false);
        AppMethodBeat.m2505o(25184);
    }

    private void aVh() {
        AppMethodBeat.m2504i(25185);
        if (getIntent() == null) {
            AppMethodBeat.m2505o(25185);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            AppMethodBeat.m2505o(25185);
            return;
        }
        C5652a c5652a = new C5652a(this);
        c5652a.asD("");
        c5652a.asE(extras.getString("alertcontent"));
        c5652a.asJ(extras.getString("alertconfirm")).mo11457a(new C352701());
        c5652a.asK(extras.getString("alert_cancel")).mo11476b(new C352712());
        this.ggF = c5652a.aMb();
        this.ggF.setCanceledOnTouchOutside(false);
        this.ggF.show();
        AppMethodBeat.m2505o(25185);
    }

    /* renamed from: a */
    public static void m86840a(Context context, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(25186);
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.m2505o(25186);
    }
}
