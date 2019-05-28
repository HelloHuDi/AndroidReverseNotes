package com.tencent.p177mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog */
public class RequestFloatWindowPermissionDialog extends MMBaseActivity {
    public static int vdq = 1234;
    private static C30091a vdr;
    private C5653c ggF = null;

    /* renamed from: com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog$a */
    public interface C30091a {
        /* renamed from: a */
        void mo38035a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);

        /* renamed from: b */
        void mo38036b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog);
    }

    /* renamed from: com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog$1 */
    class C358031 implements OnCancelListener {
        C358031() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(79437);
            RequestFloatWindowPermissionDialog.this.finish();
            AppMethodBeat.m2505o(79437);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog$2 */
    class C358042 implements OnClickListener {
        C358042() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79438);
            if (C1443d.m3068iW(23)) {
                try {
                    if (!C5046bo.isNullOrNil((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                        RequestFloatWindowPermissionDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + C4996ah.getPackageName())), RequestFloatWindowPermissionDialog.vdq);
                        AppMethodBeat.m2505o(79438);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", e.getMessage(), e.getClass().getCanonicalName());
                }
            }
            String string = RequestFloatWindowPermissionDialog.this.getString(C25738R.string.bw0);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            C25985d.m41467b(RequestFloatWindowPermissionDialog.this, "webview", ".ui.tools.WebViewUI", intent);
            RequestFloatWindowPermissionDialog.this.finish();
            AppMethodBeat.m2505o(79438);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(79439);
        super.onCreate(bundle);
        requestWindowFeature(1);
        aVh();
        AppMethodBeat.m2505o(79439);
    }

    public void onResume() {
        AppMethodBeat.m2504i(79440);
        super.onResume();
        C5288y.activateBroadcast(true);
        AppMethodBeat.m2505o(79440);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(79441);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ggF != null) {
            this.ggF.dismiss();
            this.ggF = null;
        }
        aVh();
        AppMethodBeat.m2505o(79441);
    }

    public void onPause() {
        AppMethodBeat.m2504i(79442);
        super.onPause();
        C5288y.activateBroadcast(false);
        AppMethodBeat.m2505o(79442);
    }

    private void aVh() {
        AppMethodBeat.m2504i(79443);
        if (getIntent() == null) {
            C4990ab.m7412e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
            AppMethodBeat.m2505o(79443);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C4990ab.m7412e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
            AppMethodBeat.m2505o(79443);
            return;
        }
        C5652a c5652a = new C5652a(this);
        c5652a.mo11446PV(C25738R.string.bvz);
        c5652a.asE(extras.getString("warning_content"));
        c5652a.mo11478f(new C358031());
        c5652a.mo11453Qc(C1443d.m3068iW(23) ? C25738R.string.bvy : C25738R.string.bvx).mo11457a(new C358042());
        this.ggF = c5652a.aMb();
        this.ggF.setCanceledOnTouchOutside(false);
        this.ggF.show();
        AppMethodBeat.m2505o(79443);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(79444);
        if (vdr == null) {
            AppMethodBeat.m2505o(79444);
        } else if (i != vdq) {
            vdr.mo38036b(this);
            AppMethodBeat.m2505o(79444);
        } else if (C37657b.m63684bF(C4996ah.getContext())) {
            vdr.mo38035a(this);
            AppMethodBeat.m2505o(79444);
        } else {
            vdr.mo38036b(this);
            AppMethodBeat.m2505o(79444);
        }
    }

    /* renamed from: a */
    public static void m58702a(Context context, String str, C30091a c30091a) {
        AppMethodBeat.m2504i(79445);
        vdr = c30091a;
        Intent intent = new Intent(context, RequestFloatWindowPermissionDialog.class);
        intent.putExtra("warning_content", str);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.m2505o(79445);
    }
}
