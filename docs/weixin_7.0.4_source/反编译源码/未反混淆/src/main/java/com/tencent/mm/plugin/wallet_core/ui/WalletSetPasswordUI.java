package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.ttpic.VError;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    private TextView iDT;
    private TextView kiF;
    protected EditHintPasswdView nrZ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47666);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        initView();
        d.a(this, this.mBundle, 5);
        findViewById(R.id.f9w).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47664);
                if (WalletSetPasswordUI.this.cNR()) {
                    WalletSetPasswordUI.this.aqX();
                    WalletSetPasswordUI.this.showDialog(1000);
                    AppMethodBeat.o(47664);
                    return;
                }
                WalletSetPasswordUI.this.finish();
                AppMethodBeat.o(47664);
            }
        });
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.vy));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.o(47666);
    }

    public final void initView() {
        AppMethodBeat.i(47667);
        this.iDT = (TextView) findViewById(R.id.cfp);
        this.kiF = (TextView) findViewById(R.id.f9x);
        if (!(!cRu() || bo.isNullOrNil(this.mBundle.getString("key_identity")) || this.mBundle.getInt("key_id_type", -1) == -1 || bo.isNullOrNil(this.mBundle.getString("key_true_name")))) {
            this.kiF.setVisibility(4);
        }
        if (dOD() != null && "ModifyPwdProcess".equals(dOD().bxP())) {
            this.iDT.setText(R.string.fk2);
        }
        if (this.mBundle.getInt("key_err_code", 0) == VError.ERROR_FACE_MODEL_INIT) {
            TextView textView = (TextView) findViewById(R.id.fh6);
            textView.setVisibility(0);
            textView.setText(ae.it(this));
            this.mBundle.putInt("key_err_code", 0);
        }
        this.nrZ = (EditHintPasswdView) findViewById(R.id.cfs);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.nrZ);
        findViewById(R.id.dm7).setVisibility(8);
        this.nrZ.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47665);
                if (z) {
                    String md5Value = WalletSetPasswordUI.this.nrZ.getMd5Value();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_new_pwd1", md5Value);
                    WalletSetPasswordUI.this.nrZ.cey();
                    com.tencent.mm.wallet_core.a.j(WalletSetPasswordUI.this, bundle);
                }
                AppMethodBeat.o(47665);
            }
        });
        e(this.nrZ, 0, false);
        AppMethodBeat.o(47667);
    }

    public void onResume() {
        AppMethodBeat.i(47668);
        this.nrZ.requestFocus();
        super.onResume();
        AppMethodBeat.o(47668);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b66;
    }

    public final boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private boolean cRu() {
        AppMethodBeat.i(47669);
        boolean z = this.mBundle.getBoolean("key_is_forgot_process", false);
        AppMethodBeat.o(47669);
        return z;
    }
}
