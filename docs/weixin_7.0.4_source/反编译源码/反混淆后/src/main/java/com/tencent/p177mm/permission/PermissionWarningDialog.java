package com.tencent.p177mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.permission.PermissionWarningDialog */
public class PermissionWarningDialog extends MMBaseActivity {
    /* renamed from: Ue */
    private OnCancelListener f1240Ue = new C19431();
    private C5653c ggF = null;

    /* renamed from: com.tencent.mm.permission.PermissionWarningDialog$4 */
    class C19424 implements C5662c {
        C19424() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(16649);
            if (z) {
                C4990ab.m7416i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
                ((AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMicrophoneMute(false);
            }
            PermissionWarningDialog.this.finish();
            AppMethodBeat.m2505o(16649);
        }
    }

    /* renamed from: com.tencent.mm.permission.PermissionWarningDialog$1 */
    class C19431 implements OnCancelListener {
        C19431() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(16646);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.m2505o(16646);
        }
    }

    /* renamed from: com.tencent.mm.permission.PermissionWarningDialog$2 */
    class C19442 implements OnClickListener {
        C19442() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16647);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.m2505o(16647);
        }
    }

    /* renamed from: com.tencent.mm.permission.PermissionWarningDialog$3 */
    class C19453 implements OnClickListener {
        C19453() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16648);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.m2505o(16648);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public PermissionWarningDialog() {
        AppMethodBeat.m2504i(16650);
        AppMethodBeat.m2505o(16650);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16651);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (!anB()) {
            finish();
        }
        AppMethodBeat.m2505o(16651);
    }

    public void onResume() {
        AppMethodBeat.m2504i(16652);
        super.onResume();
        C5288y.activateBroadcast(true);
        AppMethodBeat.m2505o(16652);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(16653);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ggF != null) {
            this.ggF.dismiss();
            this.ggF = null;
        }
        if (!anB()) {
            finish();
        }
        AppMethodBeat.m2505o(16653);
    }

    public void onPause() {
        AppMethodBeat.m2504i(16654);
        super.onPause();
        C5288y.activateBroadcast(false);
        AppMethodBeat.m2505o(16654);
    }

    private boolean anB() {
        AppMethodBeat.m2504i(16655);
        if (getIntent() == null) {
            C4990ab.m7412e("MicroMsg.PermissionWarningDialog", "Intent is null");
            AppMethodBeat.m2505o(16655);
            return false;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C4990ab.m7412e("MicroMsg.PermissionWarningDialog", "invalid params");
            AppMethodBeat.m2505o(16655);
            return false;
        }
        int i = extras.getInt("warning_type", 0);
        C5652a c5652a;
        if (1 == i) {
            c5652a = new C5652a(this);
            c5652a.asD(extras.getString("warning_title"));
            c5652a.asE(extras.getString("warning_content"));
            c5652a.mo11453Qc(C25738R.string.f9151r4).mo11457a(new C19442());
            c5652a.mo11478f(this.f1240Ue);
            this.ggF = c5652a.aMb();
            this.ggF.setCanceledOnTouchOutside(false);
            this.ggF.show();
        } else if (2 == i) {
            c5652a = new C5652a(this);
            extras.getBoolean("warning_filter", false);
            extras.getBoolean("warning_due2Exception", false);
            c5652a.mo11446PV(C25738R.string.f9198sm);
            c5652a.asE(getString(C25738R.string.f9195sh));
            c5652a.mo11453Qc(C25738R.string.f9192sb).mo11457a(new C19453());
            c5652a.mo11478f(this.f1240Ue);
            this.ggF = c5652a.aMb();
            this.ggF.setCanceledOnTouchOutside(false);
            this.ggF.show();
        } else if (3 == i) {
            C5659a c5659a = new C5659a(this);
            c5659a.mo11526re(false);
            C5659a asL = c5659a.asL(getString(C25738R.string.f9167rl));
            asL.zQK = getString(C25738R.string.f9153r6);
            asL.zQJ = getString(C25738R.string.f9168rm);
            asL.mo11523c(new C19424()).show();
        } else {
            AppMethodBeat.m2505o(16655);
            return false;
        }
        AppMethodBeat.m2505o(16655);
        return true;
    }

    /* renamed from: b */
    public static void m4144b(Context context, boolean z, boolean z2) {
        AppMethodBeat.m2504i(16656);
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.m2505o(16656);
    }

    /* renamed from: ci */
    public static void m4145ci(Context context) {
        AppMethodBeat.m2504i(16657);
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 3);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.m2505o(16657);
    }
}
