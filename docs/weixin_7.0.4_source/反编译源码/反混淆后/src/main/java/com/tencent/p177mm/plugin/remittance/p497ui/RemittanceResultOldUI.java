package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.remittance.p1017a.C28850c;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI */
public class RemittanceResultOldUI extends RemittanceResultUI {
    private int pQY;
    private boolean pWA;
    private Orders pWy;
    private String pWz;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI$1 */
    class C131021 implements OnClickListener {
        C131021() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45145);
            RemittanceResultOldUI.m21118a(RemittanceResultOldUI.this);
            AppMethodBeat.m2505o(45145);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI$2 */
    class C131032 implements DialogInterface.OnClickListener {
        C131032() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45146);
            RemittanceResultOldUI.m21119b(RemittanceResultOldUI.this);
            AppMethodBeat.m2505o(45146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI$3 */
    class C131043 implements Runnable {
        C131043() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45147);
            if (RemittanceResultOldUI.this.pQY == 33 || RemittanceResultOldUI.this.pQY == 32) {
                RemittanceResultOldUI.this.finish();
                AppMethodBeat.m2505o(45147);
            } else if (C5046bo.isNullOrNil(RemittanceResultOldUI.this.pWz) || RemittanceResultOldUI.this.pWA) {
                RemittanceResultOldUI.this.finish();
                AppMethodBeat.m2505o(45147);
            } else {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", RemittanceResultOldUI.this.pWz);
                intent.putExtra("finish_direct", false);
                C25985d.m41473f(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(45147);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m21118a(RemittanceResultOldUI remittanceResultOldUI) {
        AppMethodBeat.m2504i(45154);
        remittanceResultOldUI.cgd();
        AppMethodBeat.m2505o(45154);
    }

    /* renamed from: b */
    static /* synthetic */ void m21119b(RemittanceResultOldUI remittanceResultOldUI) {
        AppMethodBeat.m2504i(45155);
        remittanceResultOldUI.cge();
        AppMethodBeat.m2505o(45155);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130970518;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45148);
        super.onCreate(bundle);
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        initView();
        if (this.pQY == 31) {
            String str = "";
            if (this.pWy.tAq.size() > 0) {
                str = ((Commodity) this.pWy.tAq.get(0)).cAa;
            }
            C4990ab.m7417i("MicroMsg.RemittanceResultOldUI", "transId: %s", str);
            C28850c.ceW().ceZ().mo55425fN(str, this.pWz);
        }
        AppMethodBeat.m2505o(45148);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45149);
        if (i == 4) {
            cgd();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(45149);
        return onKeyUp;
    }

    public final void initView() {
        int i = 1;
        AppMethodBeat.m2504i(45150);
        setMMTitle(getString(C25738R.string.dq_));
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        TextView textView = (TextView) findViewById(2131827120);
        if (this.pWy != null) {
            textView.setText(C36391e.m60006e(this.pWy.pTN, this.pWy.pcl));
        }
        PayInfo payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        if (payInfo == null) {
            C4990ab.m7412e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            AppMethodBeat.m2505o(45150);
            return;
        }
        String str = "";
        if (payInfo.vwh != null) {
            this.pWA = payInfo.vwh.getBoolean("extinfo_key_4");
            str = payInfo.vwh.getString("extinfo_key_1");
        }
        int i2 = payInfo.cIf;
        this.pQY = i2;
        this.pWz = str;
        str = C36391e.m60015mJ(str);
        if (i2 == 31) {
            textView = (TextView) findViewById(2131827119);
            CharSequence string = getString(C25738R.string.dq9, new Object[]{str});
            if (C5046bo.isNullOrNil(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(C44089j.m79293b((Context) this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(2131827123).setVisibility(8);
            if (this.pWy.pPp > 0.0d) {
                ((TextView) findViewById(2131827122)).setText(getResources().getString(C25738R.string.dq7, new Object[]{C36391e.m60006e(this.pWy.pPp, this.pWy.pcl)}));
                findViewById(2131827121).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.vwh != null) {
                str2 = payInfo.vwh.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str2 = str;
            } else if (C5046bo.isNullOrNil(str2)) {
                str2 = str + getString(C25738R.string.dqo);
            } else {
                str2 = str + "（" + C36391e.att(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(2131827119);
            if (C5046bo.isNullOrNil(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(C44089j.m79293b((Context) this, getString(C25738R.string.dq8, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(2131827124);
                textView2 = (TextView) findViewById(2131827125);
                TextView textView3 = (TextView) findViewById(2131827126);
                CharSequence string2 = payInfo.vwh.getString("extinfo_key_3");
                String string3 = payInfo.vwh.getString("extinfo_key_8");
                if (C5046bo.isNullOrNil(string2)) {
                    findViewById.setVisibility(8);
                    boolean z = false;
                } else {
                    textView3.setText(C44089j.m79293b((Context) this, string2, textView3.getTextSize()));
                    findViewById.setVisibility(0);
                    if (C5046bo.isNullOrNil(string3)) {
                        i2 = 1;
                    } else {
                        textView2.setText(string3);
                        i2 = 1;
                    }
                }
                View findViewById2 = findViewById(2131827127);
                textView2 = (TextView) findViewById(2131827128);
                textView3 = (TextView) findViewById(2131827129);
                CharSequence string4 = payInfo.vwh.getString("extinfo_key_6");
                CharSequence string5 = payInfo.vwh.getString("extinfo_key_7");
                if (C5046bo.isNullOrNil(string5)) {
                    findViewById2.setVisibility(8);
                    i = 0;
                } else {
                    textView3.setText(C44089j.m79293b((Context) this, string5, textView3.getTextSize()));
                    textView3.setVisibility(0);
                    if (!C5046bo.isNullOrNil(string4)) {
                        textView2.setText(C44089j.m79293b((Context) this, string4, textView2.getTextSize()));
                    }
                }
                if (i2 == 0 && i == 0) {
                    findViewById(2131827123).setVisibility(8);
                }
            } else if (!(i2 != 5 || this.pWy.tAq == null || this.pWy.tAq.get(0) == null || TextUtils.isEmpty(((Commodity) this.pWy.tAq.get(0)).pca))) {
                textView2.setText(((Commodity) this.pWy.tAq.get(0)).pca);
            }
        }
        ((Button) findViewById(2131827130)).setOnClickListener(new C131021());
        cgf();
        AppMethodBeat.m2505o(45150);
    }

    private void cge() {
        AppMethodBeat.m2504i(45152);
        dOD().mo8125b(this, this.mBundle);
        new C7306ak().postDelayed(new C131043(), 100);
        AppMethodBeat.m2505o(45152);
    }

    private void cgf() {
        AppMethodBeat.m2504i(45153);
        ((C11927i) C1720g.m3528K(C11927i.class)).mo7362g(this);
        AppMethodBeat.m2505o(45153);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    private void cgd() {
        AppMethodBeat.m2504i(45151);
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.mo74574b(this, bundle, new C131032());
                this.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.m2505o(45151);
            return;
        }
        cge();
        AppMethodBeat.m2505o(45151);
    }
}
