package com.tencent.p177mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity */
public class RealnameDialogActivity extends WalletBaseUI {
    private RealnameGuideHelper oht;
    private int type = 1;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity$2 */
    class C225702 implements OnClickListener {
        C225702() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46588);
            dialogInterface.dismiss();
            RealnameDialogActivity.this.finish();
            AppMethodBeat.m2505o(46588);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity$1 */
    class C296211 implements OnClickListener {
        C296211() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46587);
            dialogInterface.dismiss();
            RealnameDialogActivity.this.finish();
            AppMethodBeat.m2505o(46587);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46589);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("key_realname_guide_helper")) {
            finish();
            AppMethodBeat.m2505o(46589);
            return;
        }
        this.oht = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
        Bundle bundle2 = new Bundle();
        bundle2.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle2.putString("realname_verify_process_jump_activity", ".id_verify.RealnameDialogActivity");
        bundle2.putBoolean("process_finish_stay_orgpage", false);
        boolean a = this.oht.mo74573a(this, bundle2, new C296211(), null, true);
        boolean a2 = this.oht.mo74572a(this, bundle2, new C225702());
        if (!(a || a2)) {
            finish();
        }
        AppMethodBeat.m2505o(46589);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
