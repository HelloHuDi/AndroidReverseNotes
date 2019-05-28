package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.WxaLuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI */
public class WxaLuckyMoneyReceiveUI extends WxaLuckyMoneyBaseUI implements C34432b {
    static final /* synthetic */ boolean $assertionsDisabled = (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus());
    private TextView kGq;
    private int lqz = -1;
    private ImageView nSM;
    private int nTB = -1;
    private C34431a nTC;
    private TextView nTD;
    private Button nTE;
    private View nTF;
    private ImageView nTG;
    private TextView nTH;
    private View nTI;
    private TextView nsq;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI$2 */
    class C124152 implements OnClickListener {
        C124152() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42100);
            WxaLuckyMoneyReceiveUI.m76934c(WxaLuckyMoneyReceiveUI.this);
            AppMethodBeat.m2505o(42100);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI$1 */
    class C284041 extends C24019s {
        C284041() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(42099);
            WxaLuckyMoneyReceiveUI.m76932a(WxaLuckyMoneyReceiveUI.this);
            if (WxaLuckyMoneyReceiveUI.this.nTC != null) {
                WxaLuckyMoneyReceiveUI.this.nTC.bLb();
            }
            AppMethodBeat.m2505o(42099);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI$3 */
    class C284053 implements OnClickListener {
        C284053() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42101);
            WxaLuckyMoneyReceiveUI.m76935d(WxaLuckyMoneyReceiveUI.this);
            WxaLuckyMoneyReceiveUI.this.finish();
            AppMethodBeat.m2505o(42101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI$4 */
    class C393104 implements OnCancelListener {
        C393104() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42102);
            WxaLuckyMoneyReceiveUI.this.bKV();
            if (WxaLuckyMoneyReceiveUI.this.mController.contentView.getVisibility() == 8 || WxaLuckyMoneyReceiveUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
                WxaLuckyMoneyReceiveUI.m76935d(WxaLuckyMoneyReceiveUI.this);
                WxaLuckyMoneyReceiveUI.this.finish();
            }
            AppMethodBeat.m2505o(42102);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(42122);
        AppMethodBeat.m2505o(42122);
    }

    /* renamed from: d */
    static /* synthetic */ void m76935d(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.m2504i(42121);
        wxaLuckyMoneyReceiveUI.m76939eq(4, -1);
        AppMethodBeat.m2505o(42121);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void bKV() {
        AppMethodBeat.m2504i(42104);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(42104);
    }

    /* renamed from: Qf */
    public final void mo24264Qf(String str) {
    }

    /* renamed from: a */
    public final void mo54966a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        AppMethodBeat.m2504i(42105);
        bKV();
        m76937eT(str, str2);
        m76938eU(str3, str4);
        this.nTE.setOnClickListener(new C284041());
        this.nTE.setVisibility(0);
        m76931C(z, z2);
        bLe();
        AppMethodBeat.m2505o(42105);
    }

    /* renamed from: a */
    public final void mo54965a(String str, String str2, int i, String str3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(42106);
        this.lqz = i;
        this.nTB = 1;
        bKV();
        m76937eT(str, str2);
        m76938eU(null, str3);
        this.nTE.setOnClickListener(null);
        this.nTE.setVisibility(8);
        m76931C(z, z2);
        bLe();
        AppMethodBeat.m2505o(42106);
    }

    private void bLe() {
        AppMethodBeat.m2504i(42107);
        C46063x.m85801a(this.nTI, null);
        this.mController.contentView.setVisibility(0);
        AppMethodBeat.m2505o(42107);
    }

    /* renamed from: eT */
    private void m76937eT(String str, String str2) {
        AppMethodBeat.m2504i(42108);
        C46063x.m85811b(this.nSM, str2, null);
        C46063x.m85800a(this.mController.ylL, this.nTD, str);
        AppMethodBeat.m2505o(42108);
    }

    /* renamed from: eU */
    private void m76938eU(String str, String str2) {
        AppMethodBeat.m2504i(42109);
        if (C5046bo.isNullOrNil(str)) {
            this.kGq.setVisibility(8);
        } else {
            this.kGq.setText(str);
            this.kGq.setVisibility(0);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            C46063x.m85800a(this.mController.ylL, this.nsq, str2);
            this.nsq.setVisibility(0);
        }
        AppMethodBeat.m2505o(42109);
    }

    /* renamed from: C */
    private void m76931C(boolean z, boolean z2) {
        AppMethodBeat.m2504i(42110);
        if (z) {
            this.nTF.setVisibility(0);
            if (z2) {
                this.nTH.setText(C25738R.string.cqh);
            } else {
                this.nTH.setText(C25738R.string.cqa);
            }
            this.nTG.setVisibility(8);
            this.nTF.setOnClickListener(new C124152());
            AppMethodBeat.m2505o(42110);
            return;
        }
        this.nTF.setVisibility(8);
        this.nTG.setVisibility(0);
        AppMethodBeat.m2505o(42110);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42111);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
        initView();
        getIntent();
        this.nTC = new C36780c();
        this.nTC.mo24262a(this, getIntent());
        AppMethodBeat.m2505o(42111);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42112);
        super.onResume();
        C46063x.m85814d(this.nTE);
        this.nTE.setBackgroundResource(C25738R.drawable.b5t);
        bLf();
        AppMethodBeat.m2505o(42112);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42113);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.nTC != null) {
            this.nTC.onDestroy();
            this.nTC = null;
        }
        AppMethodBeat.m2505o(42113);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42114);
        m76939eq(this.nTB, this.lqz);
        finish();
        AppMethodBeat.m2505o(42114);
    }

    /* renamed from: eq */
    private void m76939eq(int i, int i2) {
        AppMethodBeat.m2504i(42115);
        C4990ab.m7417i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
            AppMethodBeat.m2505o(42115);
            return;
        }
        if (i == 4) {
            setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        }
        AppMethodBeat.m2505o(42115);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42116);
        this.nTI = findViewById(2131825520);
        this.nSM = (ImageView) findViewById(2131825516);
        this.nTD = (TextView) findViewById(2131825517);
        this.kGq = (TextView) findViewById(2131825522);
        this.nsq = (TextView) findViewById(2131825650);
        this.nTE = (Button) findViewById(2131825651);
        this.nTH = (TextView) findViewById(2131825653);
        this.nTF = findViewById(2131825652);
        this.nTG = (ImageView) findViewById(2131825523);
        ImageView imageView = (ImageView) findViewById(2131825524);
        if ($assertionsDisabled || imageView != null) {
            imageView.setOnClickListener(new C284053());
            m76941f(this.nTD, C25738R.dimen.a4h);
            m76941f(this.kGq, C25738R.dimen.a4i);
            m76941f(this.nsq, C25738R.dimen.a4j);
            this.mController.contentView.setVisibility(8);
            this.tipDialog = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cn5), true, new C393104());
            this.tipDialog.show();
            bLf();
            AppMethodBeat.m2505o(42116);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(42116);
        throw assertionError;
    }

    private void bLf() {
        AppMethodBeat.m2504i(42118);
        if (this.nTE == null) {
            AppMethodBeat.m2505o(42118);
            return;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        C4996ah.getContext();
        String g = C4988aa.m7402g(sharedPreferences);
        if (g == null || g.length() <= 0 || !(g.equals("zh_CN") || g.equals("zh_TW") || g.equals("zh_HK"))) {
            this.nTE.setBackgroundResource(C25738R.drawable.f6846sx);
            this.nTE.setText(C25738R.string.csa);
            AppMethodBeat.m2505o(42118);
            return;
        }
        AppMethodBeat.m2505o(42118);
    }

    public final int getLayoutId() {
        return 2130971246;
    }

    public final void bLd() {
        AppMethodBeat.m2504i(42103);
        C46063x.m85814d(this.nTE);
        AppMethodBeat.m2505o(42103);
    }

    /* renamed from: f */
    private void m76941f(TextView textView, int i) {
        AppMethodBeat.m2504i(42117);
        int am = (int) (((float) C1338a.m2857am(this.mController.ylL, i)) * 1.125f);
        int al = C1338a.m2856al(this.mController.ylL, i);
        if (al <= am) {
            am = al;
        }
        textView.setTextSize(0, (float) am);
        AppMethodBeat.m2505o(42117);
    }

    /* renamed from: a */
    static /* synthetic */ void m76932a(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.m2504i(42119);
        C46063x.m85810b(wxaLuckyMoneyReceiveUI.nTE);
        AppMethodBeat.m2505o(42119);
    }

    /* renamed from: c */
    static /* synthetic */ void m76934c(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.m2504i(42120);
        if (wxaLuckyMoneyReceiveUI.nTC != null) {
            wxaLuckyMoneyReceiveUI.nTC.bLc();
        }
        AppMethodBeat.m2505o(42120);
    }
}
