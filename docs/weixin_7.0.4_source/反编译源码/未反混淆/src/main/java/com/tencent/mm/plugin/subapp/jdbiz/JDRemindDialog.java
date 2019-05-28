package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class JDRemindDialog extends MMBaseActivity {
    private c ggF = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25181);
        super.onCreate(bundle);
        requestWindowFeature(1);
        aVh();
        AppMethodBeat.o(25181);
    }

    public void onResume() {
        AppMethodBeat.i(25182);
        super.onResume();
        y.activateBroadcast(true);
        AppMethodBeat.o(25182);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(25183);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ggF != null) {
            this.ggF.dismiss();
            this.ggF = null;
        }
        aVh();
        AppMethodBeat.o(25183);
    }

    public void onPause() {
        AppMethodBeat.i(25184);
        super.onPause();
        y.activateBroadcast(false);
        AppMethodBeat.o(25184);
    }

    private void aVh() {
        AppMethodBeat.i(25185);
        if (getIntent() == null) {
            AppMethodBeat.o(25185);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            AppMethodBeat.o(25185);
            return;
        }
        a aVar = new a(this);
        aVar.asD("");
        aVar.asE(extras.getString("alertcontent"));
        aVar.asJ(extras.getString("alertconfirm")).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(25179);
                String str = null;
                String str2 = "";
                if (!(JDRemindDialog.this.getIntent() == null || JDRemindDialog.this.getIntent().getExtras() == null)) {
                    str = JDRemindDialog.this.getIntent().getExtras().getString("alertjumpurl");
                    str2 = JDRemindDialog.this.getIntent().getExtras().getString("alert_activityid");
                }
                if (str2.equals(c.cDr().cDw().ssr) && c.cDr().cDs()) {
                    c.cDr().cDv();
                    c.cDr().cDu();
                }
                if (!bo.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    d.b(JDRemindDialog.this, "webview", ".ui.tools.WebViewUI", intent);
                    h.pYm.e(11179, str, c.cDr().cDw().ssr, Integer.valueOf(5));
                }
                JDRemindDialog.this.finish();
                AppMethodBeat.o(25179);
            }
        });
        aVar.asK(extras.getString("alert_cancel")).b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(25180);
                JDRemindDialog.this.finish();
                AppMethodBeat.o(25180);
            }
        });
        this.ggF = aVar.aMb();
        this.ggF.setCanceledOnTouchOutside(false);
        this.ggF.show();
        AppMethodBeat.o(25185);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(25186);
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.o(25186);
    }
}
