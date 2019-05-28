package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(3)
public class WalletForgotPwdVerifyIdUI extends WalletBaseUI implements OnLayoutChangeListener {
    private TextView gsf;
    private int iev = 0;
    private View iym;
    private int keyHeight = 0;
    private boolean trE;
    private MMEditText trJ;
    private TextView trK;
    private WalletFormView trL;
    private Button trM;
    private TextView trN;
    private LinearLayout trO;
    MarginLayoutParams trP;
    MarginLayoutParams trQ;
    private View trR;
    private boolean trS = false;
    private boolean trT = false;
    private boolean trU = false;
    private boolean trV = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI, View view, View view2) {
        AppMethodBeat.i(46319);
        walletForgotPwdVerifyIdUI.b(view, view2, 10);
        AppMethodBeat.o(46319);
    }

    static /* synthetic */ void i(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.i(46320);
        walletForgotPwdVerifyIdUI.cOD();
        AppMethodBeat.o(46320);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46313);
        super.onCreate(bundle);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
        xE(Color.parseColor("#FFFFFF"));
        dyb();
        MY(8);
        this.trR = findViewById(R.id.d3v);
        this.iev = getWindowManager().getDefaultDisplay().getHeight();
        this.keyHeight = this.iev / 3;
        this.trR.addOnLayoutChangeListener(this);
        this.trE = this.mBundle.getBoolean("key_is_force_bind", false);
        if (!this.trE) {
            a(new y(null, 6), true, true);
            AM(4);
        }
        this.trJ = (MMEditText) findViewById(R.id.faa);
        this.trK = (TextView) findViewById(R.id.fab);
        this.trL = (WalletFormView) findViewById(R.id.f90);
        this.trM = (Button) findViewById(R.id.ay8);
        this.trN = (TextView) findViewById(R.id.fad);
        this.iym = findViewById(R.id.l_);
        this.gsf = (TextView) findViewById(R.id.cx);
        this.trO = (LinearLayout) findViewById(R.id.bl5);
        this.trL.setEnabled(false);
        this.trL.setFocusable(false);
        this.trM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46306);
                String text = WalletForgotPwdVerifyIdUI.this.trL.getText();
                int cQq = r.cPI().cQq();
                String obj = WalletForgotPwdVerifyIdUI.this.trJ.getText().toString();
                if (!(bo.isNullOrNil(text) || bo.isNullOrNil(obj))) {
                    WalletForgotPwdVerifyIdUI.this.mBundle.putString("key_identity", text);
                    WalletForgotPwdVerifyIdUI.this.mBundle.putInt("key_id_type", cQq);
                    WalletForgotPwdVerifyIdUI.this.mBundle.putString("key_true_name", obj);
                    if (WalletForgotPwdVerifyIdUI.this.dOD() != null) {
                        WalletForgotPwdVerifyIdUI.this.dOD().mqu.putString("key_identity", text);
                        WalletForgotPwdVerifyIdUI.this.dOD().mqu.putInt("key_id_type", cQq);
                        WalletForgotPwdVerifyIdUI.this.dOD().mqu.putString("key_true_name", obj);
                    }
                    WalletForgotPwdVerifyIdUI.this.dOE().p(text, Integer.valueOf(cQq), obj);
                }
                AppMethodBeat.o(46306);
            }
        });
        this.trN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46307);
                e.n(WalletForgotPwdVerifyIdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
                AppMethodBeat.o(46307);
            }
        });
        cu();
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(46311);
                if (z) {
                    ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
                    WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.this.iym, WalletForgotPwdVerifyIdUI.this.trL);
                    WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
                    AppMethodBeat.o(46311);
                    return;
                }
                ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
                WalletForgotPwdVerifyIdUI.j(WalletForgotPwdVerifyIdUI.this);
                WalletForgotPwdVerifyIdUI.this.iym.scrollTo(0, 0);
                AppMethodBeat.o(46311);
            }
        };
        this.trJ.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(46312);
                if (z) {
                    ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
                    WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
                    AppMethodBeat.o(46312);
                    return;
                }
                ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
                AppMethodBeat.o(46312);
            }
        });
        this.trJ.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(46309);
                ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.this.trJ.getText());
                if (WalletForgotPwdVerifyIdUI.this.trJ.getText() == null || "".equals(WalletForgotPwdVerifyIdUI.this.trJ.getText().toString())) {
                    WalletForgotPwdVerifyIdUI.this.trS = false;
                } else {
                    WalletForgotPwdVerifyIdUI.this.trS = true;
                }
                WalletForgotPwdVerifyIdUI.g(WalletForgotPwdVerifyIdUI.this);
                AppMethodBeat.o(46309);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.trL.a(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(46310);
                if (WalletForgotPwdVerifyIdUI.this.trL.getText() != null) {
                    WalletForgotPwdVerifyIdUI.this.trT = true;
                } else {
                    WalletForgotPwdVerifyIdUI.this.trT = false;
                }
                WalletForgotPwdVerifyIdUI.g(WalletForgotPwdVerifyIdUI.this);
                AppMethodBeat.o(46310);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(46313);
    }

    private void cu() {
        AppMethodBeat.i(46314);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
        int i = r.cPE().cRh().field_cre_type;
        String str = r.cPE().cRh().field_cre_name;
        String str2 = r.cPE().cRh().field_true_name;
        this.trJ.setHint(getString(R.string.fcr, new Object[]{e.att(str2)}));
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
        } else {
            this.trK.setText(str);
        }
        if (i == 1) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this.trL);
            e(this.trL, 1, false);
            AppMethodBeat.o(46314);
            return;
        }
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
        AppMethodBeat.o(46314);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46315);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", Integer.valueOf(i2), str, mVar);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof y) {
                cu();
                AM(0);
            } else if (mVar instanceof q) {
                q qVar = (q) mVar;
                this.mBundle.putInt("key_is_support_face", qVar.tqK);
                this.mBundle.putInt("key_face_action_scene", qVar.scene);
                this.mBundle.putString("key_face_action_package", qVar.packageName);
                this.mBundle.putString("key_face_action_package_sign", qVar.cKT);
                if (qVar.tqL == 1) {
                    com.tencent.mm.wallet_core.c.ab.dNZ();
                    String dNY = com.tencent.mm.wallet_core.c.ab.dNY();
                    b.dNJ();
                    if (b.isCertExist(dNY)) {
                        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
                        dOD().a((Activity) this, 0, this.mBundle);
                    } else {
                        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
                        a(new n(qVar.tqI, qVar.tqJ, qVar.cQY), true, false);
                    }
                } else {
                    ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
                    dOD().a((Activity) this, 0, this.mBundle);
                }
            } else if (mVar instanceof n) {
                ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
                dOD().a((Activity) this, 0, this.mBundle);
            }
        }
        AppMethodBeat.o(46315);
        return false;
    }

    private void cOD() {
        AppMethodBeat.i(46316);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(46308);
                WalletForgotPwdVerifyIdUI.this.gsf.setVisibility(8);
                WalletForgotPwdVerifyIdUI.this.trN.setVisibility(8);
                WalletForgotPwdVerifyIdUI.this.trP = (MarginLayoutParams) WalletForgotPwdVerifyIdUI.this.trO.getLayoutParams();
                WalletForgotPwdVerifyIdUI.this.trP.topMargin = aj.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
                WalletForgotPwdVerifyIdUI.this.trO.setLayoutParams(WalletForgotPwdVerifyIdUI.this.trP);
                WalletForgotPwdVerifyIdUI.this.trQ = (MarginLayoutParams) WalletForgotPwdVerifyIdUI.this.trM.getLayoutParams();
                WalletForgotPwdVerifyIdUI.this.trQ.topMargin = aj.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
                WalletForgotPwdVerifyIdUI.this.trM.setLayoutParams(WalletForgotPwdVerifyIdUI.this.trQ);
                AppMethodBeat.o(46308);
            }
        }, 100);
        AppMethodBeat.o(46316);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(46317);
        if (i8 == 0 || i4 == 0 || i8 - i4 <= this.keyHeight) {
            if (!(i8 == 0 || i4 == 0 || i4 - i8 <= this.keyHeight)) {
                ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
            }
            AppMethodBeat.o(46317);
            return;
        }
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
        cOD();
        AppMethodBeat.o(46317);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.b4a;
    }

    static /* synthetic */ void g(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.i(46318);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveIdentityText：" + walletForgotPwdVerifyIdUI.trT);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameText：" + walletForgotPwdVerifyIdUI.trS);
        if (walletForgotPwdVerifyIdUI.trT && walletForgotPwdVerifyIdUI.trS) {
            walletForgotPwdVerifyIdUI.trM.setEnabled(true);
            AppMethodBeat.o(46318);
            return;
        }
        walletForgotPwdVerifyIdUI.trM.setEnabled(false);
        AppMethodBeat.o(46318);
    }

    static /* synthetic */ void j(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.i(46321);
        ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " resetParams()");
        walletForgotPwdVerifyIdUI.gsf.setVisibility(0);
        walletForgotPwdVerifyIdUI.trN.setVisibility(0);
        walletForgotPwdVerifyIdUI.trP = (MarginLayoutParams) walletForgotPwdVerifyIdUI.trO.getLayoutParams();
        walletForgotPwdVerifyIdUI.trP.topMargin = aj.fromDPToPix(walletForgotPwdVerifyIdUI, 59);
        walletForgotPwdVerifyIdUI.trO.setLayoutParams(walletForgotPwdVerifyIdUI.trP);
        walletForgotPwdVerifyIdUI.trQ = (MarginLayoutParams) walletForgotPwdVerifyIdUI.trM.getLayoutParams();
        walletForgotPwdVerifyIdUI.trQ.topMargin = aj.fromDPToPix(walletForgotPwdVerifyIdUI, 114);
        walletForgotPwdVerifyIdUI.trM.setLayoutParams(walletForgotPwdVerifyIdUI.trQ);
        AppMethodBeat.o(46321);
    }
}
