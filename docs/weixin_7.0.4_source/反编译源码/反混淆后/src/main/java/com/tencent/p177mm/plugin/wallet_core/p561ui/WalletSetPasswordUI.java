package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import com.tencent.ttpic.VError;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI */
public class WalletSetPasswordUI extends WalletBaseUI {
    private TextView iDT;
    private TextView kiF;
    protected EditHintPasswdView nrZ;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI$2 */
    class C143002 implements C30883a {
        C143002() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47665);
            if (z) {
                String md5Value = WalletSetPasswordUI.this.nrZ.getMd5Value();
                Bundle bundle = new Bundle();
                bundle.putString("key_new_pwd1", md5Value);
                WalletSetPasswordUI.this.nrZ.cey();
                C24143a.m37116j(WalletSetPasswordUI.this, bundle);
            }
            AppMethodBeat.m2505o(47665);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI$1 */
    class C296631 implements OnClickListener {
        C296631() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47664);
            if (WalletSetPasswordUI.this.cNR()) {
                WalletSetPasswordUI.this.aqX();
                WalletSetPasswordUI.this.showDialog(1000);
                AppMethodBeat.m2505o(47664);
                return;
            }
            WalletSetPasswordUI.this.finish();
            AppMethodBeat.m2505o(47664);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47666);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        initView();
        C40148d.m68847a(this, this.mBundle, 5);
        findViewById(2131828753).setOnClickListener(new C296631());
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.f12206vy));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.m2505o(47666);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47667);
        this.iDT = (TextView) findViewById(2131824899);
        this.kiF = (TextView) findViewById(2131828754);
        if (!(!cRu() || C5046bo.isNullOrNil(this.mBundle.getString("key_identity")) || this.mBundle.getInt("key_id_type", -1) == -1 || C5046bo.isNullOrNil(this.mBundle.getString("key_true_name")))) {
            this.kiF.setVisibility(4);
        }
        if (dOD() != null && "ModifyPwdProcess".equals(dOD().bxP())) {
            this.iDT.setText(C25738R.string.fk2);
        }
        if (this.mBundle.getInt("key_err_code", 0) == VError.ERROR_FACE_MODEL_INIT) {
            TextView textView = (TextView) findViewById(2131829059);
            textView.setVisibility(0);
            textView.setText(C44423ae.m80311it(this));
            this.mBundle.putInt("key_err_code", 0);
        }
        this.nrZ = (EditHintPasswdView) findViewById(2131824902);
        C30890a.m49291a(this.nrZ);
        findViewById(2131826507).setVisibility(8);
        this.nrZ.setOnInputValidListener(new C143002());
        mo39989e(this.nrZ, 0, false);
        AppMethodBeat.m2505o(47667);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47668);
        this.nrZ.requestFocus();
        super.onResume();
        AppMethodBeat.m2505o(47668);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971169;
    }

    public final boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private boolean cRu() {
        AppMethodBeat.m2504i(47669);
        boolean z = this.mBundle.getBoolean("key_is_forgot_process", false);
        AppMethodBeat.m2505o(47669);
        return z;
    }
}
