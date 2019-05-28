package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.widget.j;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.b;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private int cCF = 0;
    private String czZ;
    private String gEk;
    private TextView gnj;
    private ScrollView hJh;
    protected EditHintPasswdView nrZ;
    private boolean tHd = false;
    private LinearLayout tHe;
    private ImageView tHf;
    private TextView tHg;
    private TextView tHh;
    private TextView tHi;
    private boolean tHj = false;
    private boolean tHk = false;
    private String tHl;
    private int tHm = 0;
    private int tHn;
    private String tHo;
    private String tHp;
    private Animation tHq;
    private c.a tHr;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void cRA() {
        AppMethodBeat.i(47358);
        cRz();
        AppMethodBeat.o(47358);
    }

    static /* synthetic */ void f(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.i(47359);
        walletCheckPwdUI.cRy();
        AppMethodBeat.o(47359);
    }

    static /* synthetic */ void g(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.i(47360);
        walletCheckPwdUI.cRw();
        AppMethodBeat.o(47360);
    }

    public final int getLayoutId() {
        return R.layout.b3u;
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        AppMethodBeat.i(47342);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        dyb();
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            c aE = com.tencent.mm.wallet_core.a.aE(this);
            if (aE != null) {
                int i2 = aE.mqu.getInt("scene", -1);
                boolean z = i2 == 1 && "UnbindProcess".equals(aE.bxP());
                this.tHk = z;
                i = i2;
            }
        } else {
            i = intent.getIntExtra("scene", -1);
        }
        if (i == 1) {
            m aVar;
            this.tHj = true;
            ab.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            AM(4);
            Bundle bundle2 = null;
            if (this.tHk) {
                c aE2 = com.tencent.mm.wallet_core.a.aE(this);
                if (aE2 != null) {
                    bundle2 = aE2.mqu;
                }
                if (bundle2 == null) {
                    ab.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
            } else if (getIntent() == null) {
                ab.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
            }
            String string = bundle2.getString("appId");
            String string2 = bundle2.getString("timeStamp");
            String string3 = bundle2.getString("nonceStr");
            String string4 = bundle2.getString("packageExt");
            String string5 = bundle2.getString("signtype");
            String string6 = bundle2.getString("paySignature");
            String string7 = bundle2.getString("url");
            int i3 = bundle2.getInt("pay_channel", 0);
            if (this.tHk) {
                ab.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bo.isNullOrNil(string));
                aVar = new com.tencent.mm.plugin.wallet_core.c.a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
            } else {
                aVar = new b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
            }
            a(aVar, true, false);
        } else {
            AM(0);
        }
        initView();
        cRx();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47332);
                WalletCheckPwdUI.a(WalletCheckPwdUI.this);
                AppMethodBeat.o(47332);
                return false;
            }
        });
        findViewById(R.id.f9w).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47333);
                WalletCheckPwdUI.a(WalletCheckPwdUI.this);
                AppMethodBeat.o(47333);
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
        AppMethodBeat.o(47342);
    }

    public final void bLz() {
        AppMethodBeat.i(47343);
        ab.d("Micromsg.WalletCheckPwdUI", "check pwd ");
        this.Ahr.bLz();
        AppMethodBeat.o(47343);
    }

    public void onResume() {
        AppMethodBeat.i(47344);
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        nf(580);
        super.onResume();
        AppMethodBeat.o(47344);
    }

    public void onPause() {
        AppMethodBeat.i(47345);
        super.onPause();
        this.cCF = 0;
        cRw();
        cRz();
        ng(580);
        AppMethodBeat.o(47345);
    }

    public void onDestroy() {
        AppMethodBeat.i(47346);
        super.onDestroy();
        cRz();
        AppMethodBeat.o(47346);
    }

    public final void initView() {
        AppMethodBeat.i(47347);
        bo.ac(dOF());
        this.nrZ = (EditHintPasswdView) findViewById(R.id.cfs);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.nrZ);
        this.nrZ.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47334);
                if (z) {
                    WalletCheckPwdUI.this.gEk = WalletCheckPwdUI.this.nrZ.getText();
                    c aE = com.tencent.mm.wallet_core.a.aE(WalletCheckPwdUI.this);
                    Object obj = null;
                    if (aE != null) {
                        obj = aE.bxP();
                    }
                    if (!WalletCheckPwdUI.this.tHj || "UnbindProcess".equals(obj)) {
                        if (!WalletCheckPwdUI.this.dOE().p(WalletCheckPwdUI.this.gEk, WalletCheckPwdUI.this.cNH())) {
                            WalletCheckPwdUI.this.a(new r(WalletCheckPwdUI.this.gEk, 1, WalletCheckPwdUI.this.cNH()), true, true);
                        }
                    } else {
                        WalletCheckPwdUI.this.a(new s(WalletCheckPwdUI.this.gEk, WalletCheckPwdUI.this.tHl, (byte) 0), true, true);
                        h.pYm.e(15021, Integer.valueOf(1));
                        AppMethodBeat.o(47334);
                        return;
                    }
                }
                AppMethodBeat.o(47334);
            }
        });
        this.hJh = (ScrollView) findViewById(R.id.f9t);
        this.tHe = (LinearLayout) findViewById(R.id.f9y);
        this.tHf = (ImageView) findViewById(R.id.f9z);
        this.tHh = (TextView) findViewById(R.id.cfp);
        this.tHi = (TextView) findViewById(R.id.f9x);
        this.tHg = (TextView) findViewById(R.id.f_0);
        this.gnj = (TextView) findViewById(R.id.f_1);
        this.gnj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47335);
                WalletCheckPwdUI.cRA();
                if (WalletCheckPwdUI.this.cCF == 0) {
                    WalletCheckPwdUI.this.cCF = 1;
                    WalletCheckPwdUI.f(WalletCheckPwdUI.this);
                } else {
                    WalletCheckPwdUI.this.cCF = 0;
                }
                WalletCheckPwdUI.g(WalletCheckPwdUI.this);
                AppMethodBeat.o(47335);
            }
        });
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(final boolean z) {
                AppMethodBeat.i(47337);
                ab.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", Boolean.valueOf(z));
                WalletCheckPwdUI.this.hJh.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47336);
                        if (z) {
                            WalletCheckPwdUI.this.hJh.fullScroll(130);
                            AppMethodBeat.o(47336);
                            return;
                        }
                        WalletCheckPwdUI.this.hJh.fullScroll(33);
                        AppMethodBeat.o(47336);
                    }
                });
                AppMethodBeat.o(47337);
            }
        };
        e(this.nrZ, 0, false);
        dOC();
        AppMethodBeat.o(47347);
    }

    private void a(bjk bjk) {
        AppMethodBeat.i(47348);
        if (!(bjk == null || bo.isNullOrNil(bjk.title))) {
            this.tHh.setText(bjk.title);
        }
        if (!(bjk == null || bo.isNullOrNil(bjk.wMQ))) {
            this.tHi.setText(bjk.wMQ);
        }
        cRx();
        AppMethodBeat.o(47348);
    }

    private void cRw() {
        AppMethodBeat.i(47349);
        ab.i("Micromsg.WalletCheckPwdUI", "change mode: %s", Integer.valueOf(this.cCF));
        if (this.cCF == 1) {
            this.tHe.setVisibility(0);
            this.nrZ.setVisibility(8);
            this.gnj.setText(R.string.fd5);
            this.tHe.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47338);
                    WalletCheckPwdUI.this.aoB();
                    AppMethodBeat.o(47338);
                }
            }, 300);
            if (bo.isNullOrNil(this.tHp)) {
                this.tHi.setText(R.string.fd9);
                AppMethodBeat.o(47349);
                return;
            }
            this.tHi.setText(this.tHp);
            AppMethodBeat.o(47349);
            return;
        }
        this.tHe.setVisibility(8);
        this.nrZ.cey();
        this.nrZ.setVisibility(0);
        this.gnj.setText(R.string.fd4);
        dOC();
        if (bo.isNullOrNil(this.tHo)) {
            this.tHi.setText(R.string.fd8);
            AppMethodBeat.o(47349);
            return;
        }
        this.tHi.setText(this.tHo);
        AppMethodBeat.o(47349);
    }

    private void cRx() {
        AppMethodBeat.i(47350);
        c dOD = dOD();
        if (dOD != null) {
            if ("UnbindProcess".equals(dOD.bxP())) {
                this.tHh.setText(R.string.fgg);
                this.tHi.setText(R.string.fdd);
                AppMethodBeat.o(47350);
                return;
            } else if (dOD instanceof com.tencent.mm.plugin.wallet_core.b.b) {
                this.tHh.setText(R.string.ffz);
                this.tHi.setText(R.string.fdd);
                AppMethodBeat.o(47350);
                return;
            } else if ("ModifyPwdProcess".equals(dOD.bxP())) {
                this.tHh.setText(R.string.fk2);
                this.tHi.setText(R.string.fdd);
                AppMethodBeat.o(47350);
                return;
            } else if ("OfflineProcess".equals(dOD.bxP())) {
                this.tHh.setText(R.string.fdc);
                this.tHi.setText(R.string.fdd);
            }
        }
        AppMethodBeat.o(47350);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47351);
        ab.d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        c aE;
        if (i == 0 && i2 == 0) {
            if (mVar instanceof r) {
                Bundle bundle = this.mBundle;
                bundle.putString("key_pwd1", this.nrZ.getText());
                com.tencent.mm.wallet_core.a.j(this, bundle);
                if (this.nrZ != null) {
                    this.nrZ.cey();
                }
                finish();
            } else if (mVar instanceof y) {
                com.tencent.mm.ui.base.h.bQ(this, getString(R.string.fdj));
                aE = com.tencent.mm.wallet_core.a.aE(this);
                if (aE != null) {
                    aE.mqu.putInt("key_process_result_code", -1);
                }
                com.tencent.mm.wallet_core.a.j(this, aE.mqu);
                if (this.nrZ != null) {
                    this.nrZ.cey();
                }
                finish();
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                this.tHl = ((com.tencent.mm.plugin.wallet_core.c.a) mVar).getToken();
                setResult(-1);
                a(((rp) ((com.tencent.mm.plugin.wallet_core.c.a) mVar).ehh.fsH.fsP).vYW);
                AM(0);
            } else if (mVar instanceof b) {
                b bVar = (b) mVar;
                this.tHl = bVar.ttM.token;
                this.czZ = bVar.ttM.vwr;
                f.akr(bVar.ttM.vwr);
                if (bVar.ttM.vYW != null) {
                    this.tHo = bVar.ttM.vYW.wMQ;
                    this.tHp = bVar.ttM.vYW.wMR;
                }
                setResult(-1);
                a(bVar.ttM.vYW);
                chz chz = bVar.ttM.vZv;
                if (!(chz == null || chz.vPM == null)) {
                    l lVar = (l) g.K(l.class);
                    if (chz.xhl == 1 && chz.xhm == 1 && lVar.bxo() && lVar.bxn() && !lVar.bxf()) {
                        boolean z;
                        ab.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                        this.cCF = 1;
                        if (chz.vPM != null) {
                            v.tCn.msn = chz.vPM.dlY();
                        }
                        v vVar = v.tCn;
                        if (chz.vPN == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        vVar.mso = z;
                        cRy();
                        this.gnj.setVisibility(0);
                    }
                }
                cRw();
                AM(0);
            } else if (mVar instanceof s) {
                s sVar = (s) mVar;
                if (sVar.cOT()) {
                    ab.i("Micromsg.WalletCheckPwdUI", "need free sms");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key_pwd1", this.gEk);
                    bundle2.putString("key_jsapi_token", this.tHl);
                    bundle2.putString("key_relation_key", sVar.tul);
                    bundle2.putString("key_mobile", sVar.tuk);
                    this.tHr = new c.a() {
                        public final Intent n(int i, Bundle bundle) {
                            AppMethodBeat.i(47339);
                            ab.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", Integer.valueOf(i));
                            Intent intent = new Intent();
                            intent.putExtra("token", bundle.getString("key_jsapi_token"));
                            intent.putExtra("key_process_result_code", i);
                            intent.setClass(WalletCheckPwdUI.this.mController.ylL, WalletCheckPwdUI.class);
                            intent.addFlags(536870912);
                            intent.putExtra("key_process_is_stay", false);
                            AppMethodBeat.o(47339);
                            return intent;
                        }
                    };
                    com.tencent.mm.wallet_core.a.a((Activity) this, n.class, bundle2, this.tHr);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", ((s) mVar).tui);
                    setResult(-1, intent);
                    finish();
                }
            }
            AppMethodBeat.o(47351);
            return true;
        }
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        if ((mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) || (mVar instanceof b)) {
            ab.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
            aE = com.tencent.mm.wallet_core.a.aE(this);
            if (aE == null || !aE.bxP().equals("UnbindProcess")) {
                setResult(0);
                finish();
            } else {
                setResult(1);
                aE.mqu.putInt("key_process_result_code", 1);
                com.tencent.mm.wallet_core.a.j(this, aE.mqu);
            }
            AppMethodBeat.o(47351);
            return true;
        }
        AppMethodBeat.o(47351);
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47352);
        if (this.nTi == null || !this.nTi.isShown()) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.o(47352);
            return onKeyUp;
        }
        this.nTi.setVisibility(8);
        AppMethodBeat.o(47352);
        return true;
    }

    public final void wU(int i) {
        AppMethodBeat.i(47354);
        if (this.tHd) {
            finish();
            AppMethodBeat.o(47354);
            return;
        }
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        AppMethodBeat.o(47354);
    }

    public final boolean bwP() {
        return this.tHd;
    }

    public int getForceOrientation() {
        return 1;
    }

    private void cRy() {
        AppMethodBeat.i(47355);
        com.tencent.mm.plugin.soter.d.a.cvP();
        final com.tencent.mm.sdk.b.b lvVar = new lv();
        lvVar.cHD.cBT = this.czZ;
        lvVar.cHD.cHF = 1;
        lvVar.cHD.cHH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(47340);
                ab.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
                lv.b bVar = lvVar.cHE;
                if (bVar == null) {
                    ab.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(47340);
                    return;
                }
                int i = bVar.errCode;
                ab.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.aIm);
                if (i == 0) {
                    ab.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", bVar.cHI);
                    WalletCheckPwdUI.this.tHg.setVisibility(8);
                    WalletCheckPwdUI.b(WalletCheckPwdUI.this, bVar.cHI);
                    com.tencent.mm.plugin.soter.d.a.EC(0);
                    AppMethodBeat.o(47340);
                    return;
                }
                boolean z;
                ab.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int j = currentTimeMillis - WalletCheckPwdUI.this.tHn;
                if (j > 1) {
                    WalletCheckPwdUI.this.tHn = currentTimeMillis;
                    WalletCheckPwdUI.this.tHm = WalletCheckPwdUI.this.tHm + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (bVar.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                ab.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(WalletCheckPwdUI.this.tHm), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (WalletCheckPwdUI.this.tHm < 3 && j > 1)) && !z2) {
                    ab.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
                    if (WalletCheckPwdUI.this.tHq == null) {
                        WalletCheckPwdUI.this.tHq = com.tencent.mm.ui.c.a.eS(WalletCheckPwdUI.this.mController.ylL);
                    }
                    WalletCheckPwdUI.this.tHg.setVisibility(0);
                    WalletCheckPwdUI.this.tHg.startAnimation(WalletCheckPwdUI.this.tHq);
                    WalletCheckPwdUI.this.tHq.setFillAfter(true);
                    com.tencent.mm.plugin.soter.d.a.EC(1);
                    AppMethodBeat.o(47340);
                    return;
                }
                if (WalletCheckPwdUI.this.tHm >= 3 || z2) {
                    ab.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
                    WalletCheckPwdUI.cRA();
                    WalletCheckPwdUI.this.cCF = 0;
                    WalletCheckPwdUI.g(WalletCheckPwdUI.this);
                    WalletCheckPwdUI.this.gnj.setVisibility(8);
                    com.tencent.mm.plugin.soter.d.a.EC(2);
                }
                AppMethodBeat.o(47340);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(lvVar, Looper.getMainLooper());
        AppMethodBeat.o(47355);
    }

    private static void cRz() {
        AppMethodBeat.i(47356);
        ab.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.xxA.m(new oa());
        AppMethodBeat.o(47356);
    }

    public final void AM(int i) {
        AppMethodBeat.i(47341);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(47341);
    }

    public boolean cNR() {
        AppMethodBeat.i(47353);
        if (this.mBundle.getInt("key_pay_flag", 0) != 0) {
            AppMethodBeat.o(47353);
            return true;
        }
        AppMethodBeat.o(47353);
        return false;
    }
}
