package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.soter.a.g.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class p extends i implements d {
    protected OnCancelListener Ue;
    private String cHI = "";
    private String czZ;
    protected boolean gHY;
    public ImageView gvq;
    private boolean isPaused = false;
    public View jcl;
    protected MyKeyboardWindow mKeyboard;
    private Animation msx;
    private int msy = 0;
    protected View nTi;
    public ImageView oft;
    public TextView pUA;
    public TextView qcc;
    public ImageView tGW;
    public TextView tJA;
    public TextView tJB;
    public FavourLayout tJC;
    public CdnImageView tJD;
    public TextView tJE;
    public EditHintPasswdView tJF;
    public b tJG;
    public View tJH;
    public View tJI;
    public TextView tJJ;
    public ImageView tJK;
    public TextView tJL;
    public TextView tJM;
    public View tJN;
    public TextView tJO;
    protected a tJP;
    protected OnClickListener tJQ;
    protected boolean tJR = false;
    protected boolean tJS = true;
    protected Bankcard tJT = null;
    public TextView tJU;
    public View tJV;
    public TextView tJW;
    protected int tJX = 0;
    protected boolean tJY = false;
    private int tJZ = 0;
    public Button tJz;
    private Animation tKa = null;
    private String tKb = "";
    private long tKc = -1;
    private int tKd = 0;
    private int tKe = 0;
    private boolean tKf = false;
    protected com.tencent.mm.plugin.wallet_core.utils.a tln = new com.tencent.mm.plugin.wallet_core.utils.a();
    public TextView tpG;

    public interface a {
        void bXx();
    }

    public interface b {
        void f(String str, boolean z, String str2);
    }

    static /* synthetic */ void b(p pVar) {
        AppMethodBeat.i(47581);
        pVar.cRN();
        AppMethodBeat.o(47581);
    }

    static /* synthetic */ void cRQ() {
        AppMethodBeat.i(47582);
        cRz();
        AppMethodBeat.o(47582);
    }

    static /* synthetic */ void cRR() {
        AppMethodBeat.i(47586);
        nl(true);
        AppMethodBeat.o(47586);
    }

    static /* synthetic */ void d(p pVar) {
        AppMethodBeat.i(47584);
        pVar.cRy();
        AppMethodBeat.o(47584);
    }

    private p(Context context) {
        super(context, R.style.zx);
        AppMethodBeat.i(47565);
        ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
        this.jcl = View.inflate(context, R.layout.b4h, null);
        this.tJz = (Button) this.jcl.findViewById(R.id.b00);
        this.oft = (ImageView) this.jcl.findViewById(R.id.dlg);
        this.mKeyboard = (MyKeyboardWindow) this.jcl.findViewById(R.id.akz);
        this.nTi = this.jcl.findViewById(R.id.aky);
        this.qcc = (TextView) this.jcl.findViewById(R.id.m5);
        this.tJA = (TextView) this.jcl.findViewById(R.id.fg3);
        this.pUA = (TextView) this.jcl.findViewById(R.id.dlh);
        this.tpG = (TextView) this.jcl.findViewById(R.id.dli);
        this.tpG.getPaint().setFlags(16);
        this.tJB = (TextView) this.jcl.findViewById(R.id.d3s);
        this.tJC = (FavourLayout) this.jcl.findViewById(R.id.f9r);
        this.tJD = (CdnImageView) this.jcl.findViewById(R.id.fg_);
        this.tJH = this.jcl.findViewById(R.id.fg6);
        this.tJE = (TextView) this.jcl.findViewById(R.id.dll);
        this.gvq = (ImageView) this.jcl.findViewById(R.id.dle);
        this.tJI = this.jcl.findViewById(R.id.dlj);
        this.tJJ = (TextView) this.jcl.findViewById(R.id.fg9);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.gvq, e.getUsername());
        this.tJF = (EditHintPasswdView) this.jcl.findViewById(R.id.cfs);
        this.tJK = (ImageView) this.jcl.findViewById(R.id.dlk);
        this.tJU = (TextView) this.jcl.findViewById(R.id.fg4);
        this.tJV = this.jcl.findViewById(R.id.f9y);
        this.tJW = (TextView) this.jcl.findViewById(R.id.f_0);
        this.tGW = (ImageView) this.jcl.findViewById(R.id.f9z);
        this.tJL = (TextView) this.jcl.findViewById(R.id.e2t);
        this.tJM = (TextView) this.jcl.findViewById(R.id.fg8);
        this.tJN = this.jcl.findViewById(R.id.fg5);
        this.tJO = (TextView) this.jcl.findViewById(R.id.fg7);
        this.tJC.setVisibility(8);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.tJz.setEnabled(false);
        this.tJz.setTextColor(context.getResources().getColorStateList(R.color.a8j));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tJF);
        this.tJF.setOnInputValidListener(new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47554);
                if (z) {
                    p.this.cRO();
                    h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
                AppMethodBeat.o(47554);
            }
        });
        this.tJF.requestFocus();
        TextView textView = (TextView) this.jcl.findViewById(R.id.fg3);
        if (textView != null) {
            textView.setText(ae.ir(context));
        }
        EditText editText = (EditText) this.jcl.findViewById(R.id.d6);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            c cVar = new c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47555);
                if (!p.this.nTi.isShown()) {
                    p.this.nTi.setVisibility(0);
                }
                AppMethodBeat.o(47555);
            }
        });
        this.jcl.findViewById(R.id.al0).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47556);
                if (p.this.nTi.isShown()) {
                    p.this.nTi.setVisibility(8);
                }
                AppMethodBeat.o(47556);
            }
        });
        cRM();
        AppMethodBeat.o(47565);
    }

    private void cRM() {
        boolean z;
        AppMethodBeat.i(47566);
        ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
        this.tJZ = 0;
        this.tJU.setVisibility(8);
        this.tJV.setVisibility(8);
        this.tKc = bo.yz();
        l lVar = (l) g.K(l.class);
        if (r.cPI() == null || !lVar.bxe()) {
            z = true;
        } else {
            z = lVar.bxz();
        }
        ab.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", Boolean.valueOf(z));
        this.tKd = 0;
        this.cHI = "";
        if (lVar == null || !lVar.bxn() || lVar.bxf()) {
            z = false;
        } else {
            z = true;
        }
        ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", Boolean.valueOf(z));
        boolean z2 = lVar != null && lVar.bxe();
        if (z2 && z && this.tJY && !cRP()) {
            this.tJU.setVisibility(0);
            this.tJU.setText(getContext().getString(R.string.fq6));
            this.tJX = 1;
            this.tJV.setVisibility(0);
            this.tGW.setVisibility(0);
            this.tJF.setVisibility(8);
            this.nTi.setVisibility(8);
            this.tJA.setText(R.string.fpz);
            this.tKd = 1;
            cRy();
            h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (z2 && z && this.tJY && cRP()) {
            this.tJU.setText(getContext().getString(R.string.fez));
            this.tJU.setVisibility(0);
            this.tJX = 0;
            this.tJV.setVisibility(8);
            this.tJF.setVisibility(0);
            if (!this.nTi.isShown()) {
                this.nTi.setVisibility(0);
            }
            this.tJA.setText(R.string.fq4);
            this.tKd = 0;
            this.cHI = "";
            h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            e.QS(8);
        } else {
            this.tKd = 0;
            this.cHI = "";
            this.tJU.setVisibility(8);
            h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        }
        ab.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.tJY + ", isForcePwdMode:" + cRP());
        this.tJU.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47557);
                if (p.this.tJX == 0) {
                    p.a(p.this);
                } else if (p.this.tJX == 1) {
                    p.b(p.this);
                }
                if (p.this.tJX == 1) {
                    p.cRQ();
                    if (p.c(p.this)) {
                        p.d(p.this);
                    }
                }
                AppMethodBeat.o(47557);
            }
        });
        AppMethodBeat.o(47566);
    }

    private void cRN() {
        AppMethodBeat.i(47567);
        this.tJU.setText(getContext().getString(R.string.fez));
        this.tJX = 0;
        this.tKc = bo.yz();
        this.tJV.setVisibility(8);
        this.tJF.setVisibility(0);
        if (!this.nTi.isShown()) {
            this.nTi.setVisibility(0);
        }
        this.tJA.setText(R.string.fq4);
        nl(true);
        this.tKd = 0;
        this.cHI = "";
        h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        e.QS(29);
        cRz();
        AppMethodBeat.o(47567);
    }

    private void cRy() {
        AppMethodBeat.i(47568);
        ab.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", bo.dpG().toString());
        com.tencent.mm.plugin.soter.d.a.cvP();
        final com.tencent.mm.sdk.b.b lvVar = new lv();
        lvVar.cHD.cBT = this.czZ;
        lvVar.cHD.cHF = 1;
        lvVar.cHD.cHH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(47562);
                ab.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
                com.tencent.mm.g.a.lv.b bVar = lvVar.cHE;
                if (bVar == null) {
                    p.this.tKd = 0;
                    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(47562);
                    return;
                }
                int i = bVar.errCode;
                ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.aIm);
                if (i == 0) {
                    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", bVar.cHI);
                    p.this.tKd = 1;
                    p.this.cHI = bVar.cHI;
                    try {
                        JSONObject jSONObject = new JSONObject(p.this.cHI);
                        jSONObject.put("soter_type", "1");
                        p.this.cHI = jSONObject.toString();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", e, "", new Object[0]);
                    }
                    p.this.tKe = p.this.tKe + 1;
                    p.this.tJW.setText("");
                    p.this.cRO();
                    h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                    com.tencent.mm.plugin.soter.d.a.EC(0);
                    AppMethodBeat.o(47562);
                    return;
                }
                boolean z;
                ab.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                p.this.tKd = 0;
                p.this.cHI = "";
                p.this.tJV.setVisibility(0);
                p.this.tJW.setTextColor(p.this.getContext().getResources().getColor(R.color.xy));
                p.this.tJW.setText(R.string.fex);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int g = currentTimeMillis - p.this.msy;
                if (g > 1) {
                    p.this.msy = currentTimeMillis;
                    p.this.tJZ = p.this.tJZ + 1;
                    p.this.tKe = p.this.tKe + 1;
                }
                h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                boolean z2 = i == 2 || i == 10308;
                if (bVar.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(p.this.tJZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (p.this.tJZ < 3 && g > 1)) && !z2) {
                    ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
                    if (p.this.tKa == null) {
                        p.this.tKa = com.tencent.mm.ui.c.a.eS(p.this.getContext());
                    }
                    p.this.tGW.setVisibility(8);
                    p.this.tJW.setVisibility(4);
                    p.this.tKa.reset();
                    p.this.tKa.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(47560);
                            ab.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47558);
                                    p.this.tJW.setVisibility(0);
                                    AppMethodBeat.o(47558);
                                }
                            });
                            AppMethodBeat.o(47560);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(47561);
                            ab.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47559);
                                    p.this.tJW.setVisibility(8);
                                    p.this.tGW.setVisibility(0);
                                    AppMethodBeat.o(47559);
                                }
                            });
                            AppMethodBeat.o(47561);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    p.this.tJW.startAnimation(p.this.tKa);
                    com.tencent.mm.plugin.soter.d.a.EC(1);
                    AppMethodBeat.o(47562);
                    return;
                }
                if (p.this.tJZ >= 3 || z2) {
                    ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
                    p.cRQ();
                    p.this.tJX = 0;
                    p.k(p.this);
                    p.this.tJU.setVisibility(8);
                    p.this.tJV.setVisibility(8);
                    p.this.tJW.setVisibility(0);
                    p.this.tJW.setText(R.string.fey);
                    p.this.tJW.setTextColor(p.this.getContext().getResources().getColor(R.color.a53));
                    p.this.tJA.setText(R.string.fq4);
                    p.this.tJF.setVisibility(0);
                    if (!p.this.nTi.isShown()) {
                        p.this.nTi.setVisibility(0);
                    }
                    com.tencent.mm.plugin.soter.d.a.EC(2);
                    p.cRR();
                }
                AppMethodBeat.o(47562);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(lvVar, Looper.getMainLooper());
        AppMethodBeat.o(47568);
    }

    private static void cRz() {
        AppMethodBeat.i(47569);
        ab.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.xxA.m(new oa());
        AppMethodBeat.o(47569);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47570);
        if (i == 4) {
            if (this.Ue != null) {
                this.Ue.onCancel(this);
            }
            if (this.tJP != null) {
                this.tJP.bXx();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47570);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(47571);
        super.onCreate(bundle);
        setContentView(this.jcl);
        f.dRn().dRo();
        AppMethodBeat.o(47571);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(47572);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.o(47572);
    }

    public final void dismiss() {
        AppMethodBeat.i(47573);
        try {
            super.dismiss();
        } catch (Exception e) {
            ab.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + e.getMessage());
        }
        cRz();
        this.tln.destory();
        if (this.msx != null) {
            this.msx.cancel();
        }
        AppMethodBeat.o(47573);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRO() {
        AppMethodBeat.i(47574);
        nl(false);
        if (this.tJQ != null) {
            this.tJQ.onClick(this, 0);
        }
        dismiss();
        if (this.tJG != null) {
            boolean z;
            ab.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", Integer.valueOf(this.tKd), this.cHI);
            b bVar = this.tJG;
            String text = this.tJF.getText();
            if (this.tKd == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.f(text, z, this.cHI);
        }
        if (this.tKc < 0) {
            ab.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
            AppMethodBeat.o(47574);
        } else if (this.tJX == 0) {
            h.pYm.a(686, 0, 1, false);
            h.pYm.a(686, 1, bo.az(this.tKc), false);
            AppMethodBeat.o(47574);
        } else {
            if (this.tJX == 1) {
                h.pYm.a(686, 2, 1, false);
                h.pYm.a(686, 3, bo.az(this.tKc), false);
            }
            AppMethodBeat.o(47574);
        }
    }

    public static p a(Context context, String str, String str2, String str3, boolean z, b bVar, final OnCancelListener onCancelListener, a aVar) {
        AppMethodBeat.i(47575);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(47575);
            return null;
        }
        p pVar = new p(context);
        if (pVar.tJz != null) {
            pVar.tJQ = null;
            pVar.tJz.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47563);
                    p.this.cRO();
                    AppMethodBeat.o(47563);
                }
            });
        }
        if (pVar.oft != null) {
            pVar.Ue = onCancelListener;
            pVar.oft.setVisibility(0);
            pVar.oft.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47564);
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(null);
                    }
                    if (p.this.tJP != null) {
                        p.this.tJP.bXx();
                    }
                    p.this.cancel();
                    if (p.this.tJU.isShown()) {
                        h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        AppMethodBeat.o(47564);
                        return;
                    }
                    h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(47564);
                }
            });
        }
        pVar.setOnCancelListener(onCancelListener);
        pVar.setCancelable(true);
        pVar.qcc.setText(str);
        if (TextUtils.isEmpty(str2)) {
            pVar.pUA.setVisibility(8);
        } else {
            pVar.pUA.setVisibility(0);
            pVar.pUA.setText(str2);
        }
        pVar.tJI.setVisibility(8);
        pVar.tJS = false;
        pVar.tJP = aVar;
        if (TextUtils.isEmpty(str3)) {
            ab.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
            pVar.tJL.setVisibility(8);
        } else {
            pVar.tJL.setVisibility(0);
            pVar.tJL.setText(str3);
        }
        pVar.tJG = bVar;
        pVar.tJY = z;
        if (!com.tencent.mm.model.r.YM()) {
            pVar.cRM();
        }
        pVar.show();
        com.tencent.mm.ui.base.h.a(context, pVar);
        AppMethodBeat.o(47575);
        return pVar;
    }

    public final void cRm() {
        AppMethodBeat.i(47576);
        this.isPaused = false;
        if (com.tencent.mm.model.r.YM()) {
            AppMethodBeat.o(47576);
        } else {
            AppMethodBeat.o(47576);
        }
    }

    public final void onActivityPause() {
        AppMethodBeat.i(47577);
        this.isPaused = true;
        if (com.tencent.mm.model.r.YM()) {
            AppMethodBeat.o(47577);
            return;
        }
        if (this.tJX == 1) {
            cRN();
        }
        AppMethodBeat.o(47577);
    }

    private static void nl(boolean z) {
        AppMethodBeat.i(47578);
        g.RQ();
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(47578);
    }

    private static boolean cRP() {
        boolean booleanValue;
        AppMethodBeat.i(47579);
        g.RQ();
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.o(47579);
        return booleanValue;
    }

    static /* synthetic */ void a(p pVar) {
        AppMethodBeat.i(47580);
        pVar.tJU.setText(pVar.getContext().getString(R.string.fq6));
        pVar.tJX = 1;
        pVar.tKc = bo.yz();
        pVar.tJV.setVisibility(0);
        pVar.tGW.setVisibility(0);
        pVar.tJW.setVisibility(8);
        pVar.tJF.setVisibility(8);
        pVar.nTi.setVisibility(8);
        pVar.tJA.setText(R.string.fpz);
        nl(false);
        pVar.tKd = 1;
        h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
        e.QS(9);
        AppMethodBeat.o(47580);
    }

    static /* synthetic */ boolean c(p pVar) {
        boolean z;
        AppMethodBeat.i(47583);
        String str = "MicroMsg.WalletPwdCustomDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        if (pVar.isPaused) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (pVar.isPaused) {
            AppMethodBeat.o(47583);
            return false;
        }
        AppMethodBeat.o(47583);
        return true;
    }

    static /* synthetic */ void k(p pVar) {
        AppMethodBeat.i(47585);
        pVar.tKc = bo.yz();
        AppMethodBeat.o(47585);
    }
}
