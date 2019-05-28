package com.tencent.mm.plugin.remittance.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceResultOldUI extends RemittanceResultUI {
    private int pQY;
    private boolean pWA;
    private Orders pWy;
    private String pWz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RemittanceResultOldUI remittanceResultOldUI) {
        AppMethodBeat.i(45154);
        remittanceResultOldUI.cgd();
        AppMethodBeat.o(45154);
    }

    static /* synthetic */ void b(RemittanceResultOldUI remittanceResultOldUI) {
        AppMethodBeat.i(45155);
        remittanceResultOldUI.cge();
        AppMethodBeat.o(45155);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.aon;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45148);
        super.onCreate(bundle);
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        initView();
        if (this.pQY == 31) {
            String str = "";
            if (this.pWy.tAq.size() > 0) {
                str = ((Commodity) this.pWy.tAq.get(0)).cAa;
            }
            ab.i("MicroMsg.RemittanceResultOldUI", "transId: %s", str);
            c.ceW().ceZ().fN(str, this.pWz);
        }
        AppMethodBeat.o(45148);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(45149);
        if (i == 4) {
            cgd();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(45149);
        return onKeyUp;
    }

    public final void initView() {
        int i = 1;
        AppMethodBeat.i(45150);
        setMMTitle(getString(R.string.dq_));
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        TextView textView = (TextView) findViewById(R.id.e2r);
        if (this.pWy != null) {
            textView.setText(e.e(this.pWy.pTN, this.pWy.pcl));
        }
        PayInfo payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        if (payInfo == null) {
            ab.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            AppMethodBeat.o(45150);
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
        str = e.mJ(str);
        if (i2 == 31) {
            textView = (TextView) findViewById(R.id.e2q);
            CharSequence string = getString(R.string.dq9, new Object[]{str});
            if (bo.isNullOrNil(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(j.b((Context) this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(R.id.e2u).setVisibility(8);
            if (this.pWy.pPp > 0.0d) {
                ((TextView) findViewById(R.id.e2t)).setText(getResources().getString(R.string.dq7, new Object[]{e.e(this.pWy.pPp, this.pWy.pcl)}));
                findViewById(R.id.e2s).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.vwh != null) {
                str2 = payInfo.vwh.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str2 = str;
            } else if (bo.isNullOrNil(str2)) {
                str2 = str + getString(R.string.dqo);
            } else {
                str2 = str + "（" + e.att(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(R.id.e2q);
            if (bo.isNullOrNil(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(j.b((Context) this, getString(R.string.dq8, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(R.id.e2v);
                textView2 = (TextView) findViewById(R.id.e2w);
                TextView textView3 = (TextView) findViewById(R.id.e2x);
                CharSequence string2 = payInfo.vwh.getString("extinfo_key_3");
                String string3 = payInfo.vwh.getString("extinfo_key_8");
                if (bo.isNullOrNil(string2)) {
                    findViewById.setVisibility(8);
                    boolean z = false;
                } else {
                    textView3.setText(j.b((Context) this, string2, textView3.getTextSize()));
                    findViewById.setVisibility(0);
                    if (bo.isNullOrNil(string3)) {
                        i2 = 1;
                    } else {
                        textView2.setText(string3);
                        i2 = 1;
                    }
                }
                View findViewById2 = findViewById(R.id.e2y);
                textView2 = (TextView) findViewById(R.id.e2z);
                textView3 = (TextView) findViewById(R.id.e30);
                CharSequence string4 = payInfo.vwh.getString("extinfo_key_6");
                CharSequence string5 = payInfo.vwh.getString("extinfo_key_7");
                if (bo.isNullOrNil(string5)) {
                    findViewById2.setVisibility(8);
                    i = 0;
                } else {
                    textView3.setText(j.b((Context) this, string5, textView3.getTextSize()));
                    textView3.setVisibility(0);
                    if (!bo.isNullOrNil(string4)) {
                        textView2.setText(j.b((Context) this, string4, textView2.getTextSize()));
                    }
                }
                if (i2 == 0 && i == 0) {
                    findViewById(R.id.e2u).setVisibility(8);
                }
            } else if (!(i2 != 5 || this.pWy.tAq == null || this.pWy.tAq.get(0) == null || TextUtils.isEmpty(((Commodity) this.pWy.tAq.get(0)).pca))) {
                textView2.setText(((Commodity) this.pWy.tAq.get(0)).pca);
            }
        }
        ((Button) findViewById(R.id.e31)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45145);
                RemittanceResultOldUI.a(RemittanceResultOldUI.this);
                AppMethodBeat.o(45145);
            }
        });
        cgf();
        AppMethodBeat.o(45150);
    }

    private void cge() {
        AppMethodBeat.i(45152);
        dOD().b(this, this.mBundle);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(45147);
                if (RemittanceResultOldUI.this.pQY == 33 || RemittanceResultOldUI.this.pQY == 32) {
                    RemittanceResultOldUI.this.finish();
                    AppMethodBeat.o(45147);
                } else if (bo.isNullOrNil(RemittanceResultOldUI.this.pWz) || RemittanceResultOldUI.this.pWA) {
                    RemittanceResultOldUI.this.finish();
                    AppMethodBeat.o(45147);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultOldUI.this.pWz);
                    intent.putExtra("finish_direct", false);
                    d.f(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(45147);
                }
            }
        }, 100);
        AppMethodBeat.o(45152);
    }

    private void cgf() {
        AppMethodBeat.i(45153);
        ((i) g.K(i.class)).g(this);
        AppMethodBeat.o(45153);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    private void cgd() {
        AppMethodBeat.i(45151);
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45146);
                        RemittanceResultOldUI.b(RemittanceResultOldUI.this);
                        AppMethodBeat.o(45146);
                    }
                });
                this.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(45151);
            return;
        }
        cge();
        AppMethodBeat.o(45151);
    }
}
