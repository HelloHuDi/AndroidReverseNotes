package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.a.c;

public class RequestFloatWindowPermissionDialog extends MMBaseActivity {
    public static int vdq = 1234;
    private static a vdr;
    private c ggF = null;

    public interface a {
        void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);

        void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79439);
        super.onCreate(bundle);
        requestWindowFeature(1);
        aVh();
        AppMethodBeat.o(79439);
    }

    public void onResume() {
        AppMethodBeat.i(79440);
        super.onResume();
        y.activateBroadcast(true);
        AppMethodBeat.o(79440);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(79441);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ggF != null) {
            this.ggF.dismiss();
            this.ggF = null;
        }
        aVh();
        AppMethodBeat.o(79441);
    }

    public void onPause() {
        AppMethodBeat.i(79442);
        super.onPause();
        y.activateBroadcast(false);
        AppMethodBeat.o(79442);
    }

    private void aVh() {
        AppMethodBeat.i(79443);
        if (getIntent() == null) {
            ab.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
            AppMethodBeat.o(79443);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            ab.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
            AppMethodBeat.o(79443);
            return;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
        aVar.PV(R.string.bvz);
        aVar.asE(extras.getString("warning_content"));
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(79437);
                RequestFloatWindowPermissionDialog.this.finish();
                AppMethodBeat.o(79437);
            }
        });
        aVar.Qc(d.iW(23) ? R.string.bvy : R.string.bvx).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(79438);
                if (d.iW(23)) {
                    try {
                        if (!bo.isNullOrNil((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                            RequestFloatWindowPermissionDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ah.getPackageName())), RequestFloatWindowPermissionDialog.vdq);
                            AppMethodBeat.o(79438);
                            return;
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", e.getMessage(), e.getClass().getCanonicalName());
                    }
                }
                String string = RequestFloatWindowPermissionDialog.this.getString(R.string.bw0);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                com.tencent.mm.bp.d.b(RequestFloatWindowPermissionDialog.this, "webview", ".ui.tools.WebViewUI", intent);
                RequestFloatWindowPermissionDialog.this.finish();
                AppMethodBeat.o(79438);
            }
        });
        this.ggF = aVar.aMb();
        this.ggF.setCanceledOnTouchOutside(false);
        this.ggF.show();
        AppMethodBeat.o(79443);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(79444);
        if (vdr == null) {
            AppMethodBeat.o(79444);
        } else if (i != vdq) {
            vdr.b(this);
            AppMethodBeat.o(79444);
        } else if (b.bF(ah.getContext())) {
            vdr.a(this);
            AppMethodBeat.o(79444);
        } else {
            vdr.b(this);
            AppMethodBeat.o(79444);
        }
    }

    public static void a(Context context, String str, a aVar) {
        AppMethodBeat.i(79445);
        vdr = aVar;
        Intent intent = new Intent(context, RequestFloatWindowPermissionDialog.class);
        intent.putExtra("warning_content", str);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.o(79445);
    }
}
