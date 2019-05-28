package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C9431oo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI */
public class WalletForgotPwdSelectUI extends WalletBaseUI {
    private View tru;
    private View trv;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI$2 */
    class C225472 implements OnClickListener {
        C225472() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46266);
            if (WalletForgotPwdSelectUI.this.dOD() != null) {
                C7060h.pYm.mo8381e(15774, Integer.valueOf(WalletForgotPwdSelectUI.this.dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(3));
            }
            WalletForgotPwdSelectUI.m78463b(WalletForgotPwdSelectUI.this);
            AppMethodBeat.m2505o(46266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI$1 */
    class C354611 implements OnClickListener {
        C354611() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46265);
            WalletForgotPwdSelectUI.m78462a(WalletForgotPwdSelectUI.this);
            AppMethodBeat.m2505o(46265);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m78463b(WalletForgotPwdSelectUI walletForgotPwdSelectUI) {
        AppMethodBeat.m2504i(46271);
        walletForgotPwdSelectUI.cOB();
        AppMethodBeat.m2505o(46271);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46267);
        super.onCreate(bundle);
        mo17446xE(Color.parseColor("#FFFFFF"));
        dyb();
        mo17369MY(8);
        this.tru = findViewById(2131828794);
        this.trv = findViewById(2131828795);
        this.tru.setOnClickListener(new C354611());
        this.trv.setOnClickListener(new C225472());
        AppMethodBeat.m2505o(46267);
    }

    private void cOB() {
        AppMethodBeat.m2504i(46268);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
        this.mBundle.putBoolean("key_select_bank_card", true);
        dOD().mo8124a((Activity) this, 0, this.mBundle);
        AppMethodBeat.m2505o(46268);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46269);
        C4990ab.m7417i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        int intExtra = intent.getIntExtra("err_code", 0);
        int intExtra2 = intent.getIntExtra("scene", 0);
        int intExtra3 = intent.getIntExtra("countFace", 0);
        long longExtra = intent.getLongExtra("totalTime", 0);
        int intExtra4 = intent.getIntExtra("err_type", 6);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "errCode： ".concat(String.valueOf(intExtra)));
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "scene： ".concat(String.valueOf(intExtra2)));
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "countFace： ".concat(String.valueOf(intExtra3)));
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： ".concat(String.valueOf(longExtra)));
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "errorType： ".concat(String.valueOf(intExtra4)));
        if (i == 233) {
            if (i2 == -1) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
                if (!(intent == null || intent.getExtras() == null)) {
                    String string = intent.getExtras().getString("token");
                    if (!(dOD() == null || C5046bo.isNullOrNil(string))) {
                        C7060h.pYm.mo8381e(15774, Integer.valueOf(dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(4));
                        C7060h.pYm.mo8381e(15711, Integer.valueOf(intExtra2), Integer.valueOf(0), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(intExtra));
                    }
                    this.mBundle.putString("key_face_action_result_token", string);
                    this.mBundle.putBoolean("key_is_set_pwd_after_face_action", true);
                    dOD().mo8124a((Activity) this, 0, this.mBundle);
                    finish();
                    AppMethodBeat.m2505o(46269);
                    return;
                }
            }
            if (!(intent == null || intent.getExtras() == null)) {
                String string2 = intent.getExtras().getString("click_other_verify_btn");
                Object obj = (C5046bo.isNullOrNil(string2) || !string2.equalsIgnoreCase("yes")) ? null : 1;
                C4990ab.m7417i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", string2);
                if (obj != null) {
                    C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
                    if (dOD() != null) {
                        C7060h.pYm.mo8381e(15774, Integer.valueOf(dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(5));
                        C7060h.pYm.mo8381e(15711, Integer.valueOf(intExtra2), Integer.valueOf(3), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(1), Integer.valueOf(intExtra4), Integer.valueOf(intExtra));
                    }
                    cOB();
                }
            }
            if (i2 == 0) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
                if (dOD() != null) {
                    C7060h.pYm.mo8381e(15774, Integer.valueOf(dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(6));
                    C7060h.pYm.mo8381e(15711, Integer.valueOf(intExtra2), Integer.valueOf(2), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(intExtra));
                }
            }
        }
        AppMethodBeat.m2505o(46269);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971096;
    }

    /* renamed from: a */
    static /* synthetic */ void m78462a(WalletForgotPwdSelectUI walletForgotPwdSelectUI) {
        AppMethodBeat.m2504i(46270);
        if (walletForgotPwdSelectUI.dOD() != null) {
            C7060h.pYm.mo8381e(15774, Integer.valueOf(walletForgotPwdSelectUI.dOD().mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(2));
            C7060h.pYm.mo8378a(917, 33, 1, false);
        }
        C4990ab.m7416i("MicroMsg.WalletForgotPwdSelectUI", "gotToFaceCheck");
        C9431oo c9431oo = new C9431oo();
        c9431oo.cKR.czX = walletForgotPwdSelectUI;
        c9431oo.cKR.scene = walletForgotPwdSelectUI.mBundle.getInt("key_face_action_scene");
        c9431oo.cKR.packageName = walletForgotPwdSelectUI.mBundle.getString("key_face_action_package");
        c9431oo.cKR.cKT = walletForgotPwdSelectUI.mBundle.getString("key_face_action_package_sign");
        c9431oo.cKR.cKU = walletForgotPwdSelectUI.getString(C25738R.string.ffd);
        c9431oo.cKR.requestCode = C31128d.MIC_PTU_MEISHI;
        C4879a.xxA.mo10055m(c9431oo);
        AppMethodBeat.m2505o(46270);
    }
}
