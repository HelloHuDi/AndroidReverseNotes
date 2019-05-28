package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

@a(3)
public class WxaLuckyMoneyReceiveUI extends WxaLuckyMoneyBaseUI implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus());
    private TextView kGq;
    private int lqz = -1;
    private ImageView nSM;
    private int nTB = -1;
    private a nTC;
    private TextView nTD;
    private Button nTE;
    private View nTF;
    private ImageView nTG;
    private TextView nTH;
    private View nTI;
    private TextView nsq;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(42122);
        AppMethodBeat.o(42122);
    }

    static /* synthetic */ void d(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(42121);
        wxaLuckyMoneyReceiveUI.eq(4, -1);
        AppMethodBeat.o(42121);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void bKV() {
        AppMethodBeat.i(42104);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(42104);
    }

    public final void Qf(String str) {
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        AppMethodBeat.i(42105);
        bKV();
        eT(str, str2);
        eU(str3, str4);
        this.nTE.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(42099);
                WxaLuckyMoneyReceiveUI.a(WxaLuckyMoneyReceiveUI.this);
                if (WxaLuckyMoneyReceiveUI.this.nTC != null) {
                    WxaLuckyMoneyReceiveUI.this.nTC.bLb();
                }
                AppMethodBeat.o(42099);
            }
        });
        this.nTE.setVisibility(0);
        C(z, z2);
        bLe();
        AppMethodBeat.o(42105);
    }

    public final void a(String str, String str2, int i, String str3, boolean z, boolean z2) {
        AppMethodBeat.i(42106);
        this.lqz = i;
        this.nTB = 1;
        bKV();
        eT(str, str2);
        eU(null, str3);
        this.nTE.setOnClickListener(null);
        this.nTE.setVisibility(8);
        C(z, z2);
        bLe();
        AppMethodBeat.o(42106);
    }

    private void bLe() {
        AppMethodBeat.i(42107);
        x.a(this.nTI, null);
        this.mController.contentView.setVisibility(0);
        AppMethodBeat.o(42107);
    }

    private void eT(String str, String str2) {
        AppMethodBeat.i(42108);
        x.b(this.nSM, str2, null);
        x.a(this.mController.ylL, this.nTD, str);
        AppMethodBeat.o(42108);
    }

    private void eU(String str, String str2) {
        AppMethodBeat.i(42109);
        if (bo.isNullOrNil(str)) {
            this.kGq.setVisibility(8);
        } else {
            this.kGq.setText(str);
            this.kGq.setVisibility(0);
        }
        if (!bo.isNullOrNil(str2)) {
            x.a(this.mController.ylL, this.nsq, str2);
            this.nsq.setVisibility(0);
        }
        AppMethodBeat.o(42109);
    }

    private void C(boolean z, boolean z2) {
        AppMethodBeat.i(42110);
        if (z) {
            this.nTF.setVisibility(0);
            if (z2) {
                this.nTH.setText(R.string.cqh);
            } else {
                this.nTH.setText(R.string.cqa);
            }
            this.nTG.setVisibility(8);
            this.nTF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42100);
                    WxaLuckyMoneyReceiveUI.c(WxaLuckyMoneyReceiveUI.this);
                    AppMethodBeat.o(42100);
                }
            });
            AppMethodBeat.o(42110);
            return;
        }
        this.nTF.setVisibility(8);
        this.nTG.setVisibility(0);
        AppMethodBeat.o(42110);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42111);
        super.onCreate(bundle);
        ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
        initView();
        getIntent();
        this.nTC = new c();
        this.nTC.a(this, getIntent());
        AppMethodBeat.o(42111);
    }

    public void onResume() {
        AppMethodBeat.i(42112);
        super.onResume();
        x.d(this.nTE);
        this.nTE.setBackgroundResource(R.drawable.b5t);
        bLf();
        AppMethodBeat.o(42112);
    }

    public void onDestroy() {
        AppMethodBeat.i(42113);
        super.onDestroy();
        ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.nTC != null) {
            this.nTC.onDestroy();
            this.nTC = null;
        }
        AppMethodBeat.o(42113);
    }

    public void onBackPressed() {
        AppMethodBeat.i(42114);
        eq(this.nTB, this.lqz);
        finish();
        AppMethodBeat.o(42114);
    }

    private void eq(int i, int i2) {
        AppMethodBeat.i(42115);
        ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
            AppMethodBeat.o(42115);
            return;
        }
        if (i == 4) {
            setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        }
        AppMethodBeat.o(42115);
    }

    public final void initView() {
        AppMethodBeat.i(42116);
        this.nTI = findViewById(R.id.cwi);
        this.nSM = (ImageView) findViewById(R.id.cwe);
        this.nTD = (TextView) findViewById(R.id.cwf);
        this.kGq = (TextView) findViewById(R.id.cwk);
        this.nsq = (TextView) findViewById(R.id.d01);
        this.nTE = (Button) findViewById(R.id.d02);
        this.nTH = (TextView) findViewById(R.id.d04);
        this.nTF = findViewById(R.id.d03);
        this.nTG = (ImageView) findViewById(R.id.cwl);
        ImageView imageView = (ImageView) findViewById(R.id.cwm);
        if ($assertionsDisabled || imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42101);
                    WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
                    WxaLuckyMoneyReceiveUI.this.finish();
                    AppMethodBeat.o(42101);
                }
            });
            f(this.nTD, R.dimen.a4h);
            f(this.kGq, R.dimen.a4i);
            f(this.nsq, R.dimen.a4j);
            this.mController.contentView.setVisibility(8);
            this.tipDialog = h.b(this.mController.ylL, getString(R.string.cn5), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(42102);
                    WxaLuckyMoneyReceiveUI.this.bKV();
                    if (WxaLuckyMoneyReceiveUI.this.mController.contentView.getVisibility() == 8 || WxaLuckyMoneyReceiveUI.this.mController.contentView.getVisibility() == 4) {
                        ab.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
                        WxaLuckyMoneyReceiveUI.d(WxaLuckyMoneyReceiveUI.this);
                        WxaLuckyMoneyReceiveUI.this.finish();
                    }
                    AppMethodBeat.o(42102);
                }
            });
            this.tipDialog.show();
            bLf();
            AppMethodBeat.o(42116);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(42116);
        throw assertionError;
    }

    private void bLf() {
        AppMethodBeat.i(42118);
        if (this.nTE == null) {
            AppMethodBeat.o(42118);
            return;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
        ah.getContext();
        String g = aa.g(sharedPreferences);
        if (g == null || g.length() <= 0 || !(g.equals("zh_CN") || g.equals("zh_TW") || g.equals("zh_HK"))) {
            this.nTE.setBackgroundResource(R.drawable.sx);
            this.nTE.setText(R.string.csa);
            AppMethodBeat.o(42118);
            return;
        }
        AppMethodBeat.o(42118);
    }

    public final int getLayoutId() {
        return R.layout.b89;
    }

    public final void bLd() {
        AppMethodBeat.i(42103);
        x.d(this.nTE);
        AppMethodBeat.o(42103);
    }

    private void f(TextView textView, int i) {
        AppMethodBeat.i(42117);
        int am = (int) (((float) com.tencent.mm.bz.a.am(this.mController.ylL, i)) * 1.125f);
        int al = com.tencent.mm.bz.a.al(this.mController.ylL, i);
        if (al <= am) {
            am = al;
        }
        textView.setTextSize(0, (float) am);
        AppMethodBeat.o(42117);
    }

    static /* synthetic */ void a(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(42119);
        x.b(wxaLuckyMoneyReceiveUI.nTE);
        AppMethodBeat.o(42119);
    }

    static /* synthetic */ void c(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        AppMethodBeat.i(42120);
        if (wxaLuckyMoneyReceiveUI.nTC != null) {
            wxaLuckyMoneyReceiveUI.nTC.bLc();
        }
        AppMethodBeat.o(42120);
    }
}
