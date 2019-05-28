package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.view.d;

public class WalletForgotPwdSelectUI extends WalletBaseUI {
    private View tru;
    private View trv;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletForgotPwdSelectUI walletForgotPwdSelectUI) {
        AppMethodBeat.i(46271);
        walletForgotPwdSelectUI.cOB();
        AppMethodBeat.o(46271);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46267);
        super.onCreate(bundle);
        xE(Color.parseColor("#FFFFFF"));
        dyb();
        MY(8);
        this.tru = findViewById(R.id.fa0);
        this.trv = findViewById(R.id.fa1);
        this.tru.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46265);
                WalletForgotPwdSelectUI.a(WalletForgotPwdSelectUI.this);
                AppMethodBeat.o(46265);
            }
        });
        this.trv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46266);
                if (WalletForgotPwdSelectUI.this.dOD() != null) {
                    h.pYm.e(15774, Integer.valueOf(WalletForgotPwdSelectUI.this.dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(3));
                }
                WalletForgotPwdSelectUI.b(WalletForgotPwdSelectUI.this);
                AppMethodBeat.o(46266);
            }
        });
        AppMethodBeat.o(46267);
    }

    private void cOB() {
        AppMethodBeat.i(46268);
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
        this.mBundle.putBoolean("key_select_bank_card", true);
        dOD().a((Activity) this, 0, this.mBundle);
        AppMethodBeat.o(46268);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46269);
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        int intExtra = intent.getIntExtra("err_code", 0);
        int intExtra2 = intent.getIntExtra("scene", 0);
        int intExtra3 = intent.getIntExtra("countFace", 0);
        long longExtra = intent.getLongExtra("totalTime", 0);
        int intExtra4 = intent.getIntExtra("err_type", 6);
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "errCode： ".concat(String.valueOf(intExtra)));
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "scene： ".concat(String.valueOf(intExtra2)));
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "countFace： ".concat(String.valueOf(intExtra3)));
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： ".concat(String.valueOf(longExtra)));
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "errorType： ".concat(String.valueOf(intExtra4)));
        if (i == 233) {
            if (i2 == -1) {
                ab.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
                if (!(intent == null || intent.getExtras() == null)) {
                    String string = intent.getExtras().getString("token");
                    if (!(dOD() == null || bo.isNullOrNil(string))) {
                        h.pYm.e(15774, Integer.valueOf(dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(4));
                        h.pYm.e(15711, Integer.valueOf(intExtra2), Integer.valueOf(0), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(intExtra));
                    }
                    this.mBundle.putString("key_face_action_result_token", string);
                    this.mBundle.putBoolean("key_is_set_pwd_after_face_action", true);
                    dOD().a((Activity) this, 0, this.mBundle);
                    finish();
                    AppMethodBeat.o(46269);
                    return;
                }
            }
            if (!(intent == null || intent.getExtras() == null)) {
                String string2 = intent.getExtras().getString("click_other_verify_btn");
                Object obj = (bo.isNullOrNil(string2) || !string2.equalsIgnoreCase("yes")) ? null : 1;
                ab.i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", string2);
                if (obj != null) {
                    ab.i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
                    if (dOD() != null) {
                        h.pYm.e(15774, Integer.valueOf(dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(5));
                        h.pYm.e(15711, Integer.valueOf(intExtra2), Integer.valueOf(3), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(1), Integer.valueOf(intExtra4), Integer.valueOf(intExtra));
                    }
                    cOB();
                }
            }
            if (i2 == 0) {
                ab.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
                if (dOD() != null) {
                    h.pYm.e(15774, Integer.valueOf(dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(6));
                    h.pYm.e(15711, Integer.valueOf(intExtra2), Integer.valueOf(2), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(intExtra));
                }
            }
        }
        AppMethodBeat.o(46269);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b47;
    }

    static /* synthetic */ void a(WalletForgotPwdSelectUI walletForgotPwdSelectUI) {
        AppMethodBeat.i(46270);
        if (walletForgotPwdSelectUI.dOD() != null) {
            h.pYm.e(15774, Integer.valueOf(walletForgotPwdSelectUI.dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(2));
            h.pYm.a(917, 33, 1, false);
        }
        ab.i("MicroMsg.WalletForgotPwdSelectUI", "gotToFaceCheck");
        oo ooVar = new oo();
        ooVar.cKR.czX = walletForgotPwdSelectUI;
        ooVar.cKR.scene = walletForgotPwdSelectUI.mBundle.getInt("key_face_action_scene");
        ooVar.cKR.packageName = walletForgotPwdSelectUI.mBundle.getString("key_face_action_package");
        ooVar.cKR.cKT = walletForgotPwdSelectUI.mBundle.getString("key_face_action_package_sign");
        ooVar.cKR.cKU = walletForgotPwdSelectUI.getString(R.string.ffd);
        ooVar.cKR.requestCode = d.MIC_PTU_MEISHI;
        a.xxA.m(ooVar);
        AppMethodBeat.o(46270);
    }
}
