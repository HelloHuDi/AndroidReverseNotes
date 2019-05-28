package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.p230g.p231a.C45349oa;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.p615c.C5300a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22559b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.C7184s;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.protocal.protobuf.C23435rp;
import com.tencent.p177mm.protocal.protobuf.bjk;
import com.tencent.p177mm.protocal.protobuf.chz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI */
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
    private C30857a tHr;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$3 */
    class C44093 implements C30883a {
        C44093() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47334);
            if (z) {
                WalletCheckPwdUI.this.gEk = WalletCheckPwdUI.this.nrZ.getText();
                C40931c aE = C24143a.m37112aE(WalletCheckPwdUI.this);
                Object obj = null;
                if (aE != null) {
                    obj = aE.bxP();
                }
                if (!WalletCheckPwdUI.this.tHj || "UnbindProcess".equals(obj)) {
                    if (!WalletCheckPwdUI.this.dOE().mo9366p(WalletCheckPwdUI.this.gEk, WalletCheckPwdUI.this.cNH())) {
                        WalletCheckPwdUI.this.mo39970a(new C29619r(WalletCheckPwdUI.this.gEk, 1, WalletCheckPwdUI.this.cNH()), true, true);
                    }
                } else {
                    WalletCheckPwdUI.this.mo39970a(new C7184s(WalletCheckPwdUI.this.gEk, WalletCheckPwdUI.this.tHl, (byte) 0), true, true);
                    C7060h.pYm.mo8381e(15021, Integer.valueOf(1));
                    AppMethodBeat.m2505o(47334);
                    return;
                }
            }
            AppMethodBeat.m2505o(47334);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$1 */
    class C44101 implements OnMenuItemClickListener {
        C44101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47332);
            WalletCheckPwdUI.m6749a(WalletCheckPwdUI.this);
            AppMethodBeat.m2505o(47332);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$2 */
    class C44112 implements OnClickListener {
        C44112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47333);
            WalletCheckPwdUI.m6749a(WalletCheckPwdUI.this);
            AppMethodBeat.m2505o(47333);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$4 */
    class C44124 implements OnClickListener {
        C44124() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47335);
            WalletCheckPwdUI.cRA();
            if (WalletCheckPwdUI.this.cCF == 0) {
                WalletCheckPwdUI.this.cCF = 1;
                WalletCheckPwdUI.m6757f(WalletCheckPwdUI.this);
            } else {
                WalletCheckPwdUI.this.cCF = 0;
            }
            WalletCheckPwdUI.m6758g(WalletCheckPwdUI.this);
            AppMethodBeat.m2505o(47335);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$6 */
    class C44136 implements Runnable {
        C44136() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47338);
            WalletCheckPwdUI.this.aoB();
            AppMethodBeat.m2505o(47338);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$7 */
    class C44147 implements C30857a {
        C44147() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(47339);
            C4990ab.m7417i("Micromsg.WalletCheckPwdUI", "verify code end: %s", Integer.valueOf(i));
            Intent intent = new Intent();
            intent.putExtra("token", bundle.getString("key_jsapi_token"));
            intent.putExtra("key_process_result_code", i);
            intent.setClass(WalletCheckPwdUI.this.mController.ylL, WalletCheckPwdUI.class);
            intent.addFlags(536870912);
            intent.putExtra("key_process_is_stay", false);
            AppMethodBeat.m2505o(47339);
            return intent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI$5 */
    class C44165 implements C40947a {
        C44165() {
        }

        /* renamed from: ic */
        public final void mo9448ic(final boolean z) {
            AppMethodBeat.m2504i(47337);
            C4990ab.m7411d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", Boolean.valueOf(z));
            WalletCheckPwdUI.this.hJh.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47336);
                    if (z) {
                        WalletCheckPwdUI.this.hJh.fullScroll(130);
                        AppMethodBeat.m2505o(47336);
                        return;
                    }
                    WalletCheckPwdUI.this.hJh.fullScroll(33);
                    AppMethodBeat.m2505o(47336);
                }
            });
            AppMethodBeat.m2505o(47337);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static /* synthetic */ void cRA() {
        AppMethodBeat.m2504i(47358);
        WalletCheckPwdUI.cRz();
        AppMethodBeat.m2505o(47358);
    }

    /* renamed from: f */
    static /* synthetic */ void m6757f(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.m2504i(47359);
        walletCheckPwdUI.cRy();
        AppMethodBeat.m2505o(47359);
    }

    /* renamed from: g */
    static /* synthetic */ void m6758g(WalletCheckPwdUI walletCheckPwdUI) {
        AppMethodBeat.m2504i(47360);
        walletCheckPwdUI.cRw();
        AppMethodBeat.m2505o(47360);
    }

    public final int getLayoutId() {
        return 2130971083;
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        AppMethodBeat.m2504i(47342);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        dyb();
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            C40931c aE = C24143a.m37112aE(this);
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
            C1207m c22558a;
            this.tHj = true;
            C4990ab.m7410d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            mo9439AM(4);
            Bundle bundle2 = null;
            if (this.tHk) {
                C40931c aE2 = C24143a.m37112aE(this);
                if (aE2 != null) {
                    bundle2 = aE2.mqu;
                }
                if (bundle2 == null) {
                    C4990ab.m7410d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
            } else if (getIntent() == null) {
                C4990ab.m7410d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
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
                C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "appId is null? " + C5046bo.isNullOrNil(string));
                c22558a = new C22558a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
            } else {
                c22558a = new C22559b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
            }
            mo39970a(c22558a, true, false);
        } else {
            mo9439AM(0);
        }
        initView();
        cRx();
        setBackBtn(new C44101());
        findViewById(2131828753).setOnClickListener(new C44112());
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.f12206vy));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.m2505o(47342);
    }

    public final void bLz() {
        AppMethodBeat.m2504i(47343);
        C4990ab.m7410d("Micromsg.WalletCheckPwdUI", "check pwd ");
        this.Ahr.bLz();
        AppMethodBeat.m2505o(47343);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47344);
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        mo39992nf(580);
        super.onResume();
        AppMethodBeat.m2505o(47344);
    }

    public void onPause() {
        AppMethodBeat.m2504i(47345);
        super.onPause();
        this.cCF = 0;
        cRw();
        WalletCheckPwdUI.cRz();
        mo39993ng(580);
        AppMethodBeat.m2505o(47345);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47346);
        super.onDestroy();
        WalletCheckPwdUI.cRz();
        AppMethodBeat.m2505o(47346);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47347);
        C5046bo.m7519ac(dOF());
        this.nrZ = (EditHintPasswdView) findViewById(2131824902);
        C30890a.m49291a(this.nrZ);
        this.nrZ.setOnInputValidListener(new C44093());
        this.hJh = (ScrollView) findViewById(2131828750);
        this.tHe = (LinearLayout) findViewById(2131828755);
        this.tHf = (ImageView) findViewById(2131828756);
        this.tHh = (TextView) findViewById(2131824899);
        this.tHi = (TextView) findViewById(2131828754);
        this.tHg = (TextView) findViewById(2131828757);
        this.gnj = (TextView) findViewById(2131828758);
        this.gnj.setOnClickListener(new C44124());
        this.obM = new C44165();
        mo39989e(this.nrZ, 0, false);
        dOC();
        AppMethodBeat.m2505o(47347);
    }

    /* renamed from: a */
    private void m6750a(bjk bjk) {
        AppMethodBeat.m2504i(47348);
        if (!(bjk == null || C5046bo.isNullOrNil(bjk.title))) {
            this.tHh.setText(bjk.title);
        }
        if (!(bjk == null || C5046bo.isNullOrNil(bjk.wMQ))) {
            this.tHi.setText(bjk.wMQ);
        }
        cRx();
        AppMethodBeat.m2505o(47348);
    }

    private void cRw() {
        AppMethodBeat.m2504i(47349);
        C4990ab.m7417i("Micromsg.WalletCheckPwdUI", "change mode: %s", Integer.valueOf(this.cCF));
        if (this.cCF == 1) {
            this.tHe.setVisibility(0);
            this.nrZ.setVisibility(8);
            this.gnj.setText(C25738R.string.fd5);
            this.tHe.postDelayed(new C44136(), 300);
            if (C5046bo.isNullOrNil(this.tHp)) {
                this.tHi.setText(C25738R.string.fd9);
                AppMethodBeat.m2505o(47349);
                return;
            }
            this.tHi.setText(this.tHp);
            AppMethodBeat.m2505o(47349);
            return;
        }
        this.tHe.setVisibility(8);
        this.nrZ.cey();
        this.nrZ.setVisibility(0);
        this.gnj.setText(C25738R.string.fd4);
        dOC();
        if (C5046bo.isNullOrNil(this.tHo)) {
            this.tHi.setText(C25738R.string.fd8);
            AppMethodBeat.m2505o(47349);
            return;
        }
        this.tHi.setText(this.tHo);
        AppMethodBeat.m2505o(47349);
    }

    private void cRx() {
        AppMethodBeat.m2504i(47350);
        C40931c dOD = dOD();
        if (dOD != null) {
            if ("UnbindProcess".equals(dOD.bxP())) {
                this.tHh.setText(C25738R.string.fgg);
                this.tHi.setText(C25738R.string.fdd);
                AppMethodBeat.m2505o(47350);
                return;
            } else if (dOD instanceof C29615b) {
                this.tHh.setText(C25738R.string.ffz);
                this.tHi.setText(C25738R.string.fdd);
                AppMethodBeat.m2505o(47350);
                return;
            } else if ("ModifyPwdProcess".equals(dOD.bxP())) {
                this.tHh.setText(C25738R.string.fk2);
                this.tHi.setText(C25738R.string.fdd);
                AppMethodBeat.m2505o(47350);
                return;
            } else if ("OfflineProcess".equals(dOD.bxP())) {
                this.tHh.setText(C25738R.string.fdc);
                this.tHi.setText(C25738R.string.fdd);
            }
        }
        AppMethodBeat.m2505o(47350);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47351);
        C4990ab.m7410d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        C40931c aE;
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C29619r) {
                Bundle bundle = this.mBundle;
                bundle.putString("key_pwd1", this.nrZ.getText());
                C24143a.m37116j(this, bundle);
                if (this.nrZ != null) {
                    this.nrZ.cey();
                }
                finish();
            } else if (c1207m instanceof C35475y) {
                C30379h.m48465bQ(this, getString(C25738R.string.fdj));
                aE = C24143a.m37112aE(this);
                if (aE != null) {
                    aE.mqu.putInt("key_process_result_code", -1);
                }
                C24143a.m37116j(this, aE.mqu);
                if (this.nrZ != null) {
                    this.nrZ.cey();
                }
                finish();
            } else if (c1207m instanceof C22558a) {
                C46512f.akr(((C22558a) c1207m).cOS());
                this.tHl = ((C22558a) c1207m).getToken();
                setResult(-1);
                m6750a(((C23435rp) ((C22558a) c1207m).ehh.fsH.fsP).vYW);
                mo9439AM(0);
            } else if (c1207m instanceof C22559b) {
                C22559b c22559b = (C22559b) c1207m;
                this.tHl = c22559b.ttM.token;
                this.czZ = c22559b.ttM.vwr;
                C46512f.akr(c22559b.ttM.vwr);
                if (c22559b.ttM.vYW != null) {
                    this.tHo = c22559b.ttM.vYW.wMQ;
                    this.tHp = c22559b.ttM.vYW.wMR;
                }
                setResult(-1);
                m6750a(c22559b.ttM.vYW);
                chz chz = c22559b.ttM.vZv;
                if (!(chz == null || chz.vPM == null)) {
                    C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
                    if (chz.xhl == 1 && chz.xhm == 1 && c30052l.bxo() && c30052l.bxn() && !c30052l.bxf()) {
                        boolean z;
                        C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                        this.cCF = 1;
                        if (chz.vPM != null) {
                            C35481v.tCn.msn = chz.vPM.dlY();
                        }
                        C35481v c35481v = C35481v.tCn;
                        if (chz.vPN == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c35481v.mso = z;
                        cRy();
                        this.gnj.setVisibility(0);
                    }
                }
                cRw();
                mo9439AM(0);
            } else if (c1207m instanceof C7184s) {
                C7184s c7184s = (C7184s) c1207m;
                if (c7184s.cOT()) {
                    C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "need free sms");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key_pwd1", this.gEk);
                    bundle2.putString("key_jsapi_token", this.tHl);
                    bundle2.putString("key_relation_key", c7184s.tul);
                    bundle2.putString("key_mobile", c7184s.tuk);
                    this.tHr = new C44147();
                    C24143a.m37106a((Activity) this, C29677n.class, bundle2, this.tHr);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", ((C7184s) c1207m).tui);
                    setResult(-1, intent);
                    finish();
                }
            }
            AppMethodBeat.m2505o(47351);
            return true;
        }
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        if ((c1207m instanceof C22558a) || (c1207m instanceof C22559b)) {
            C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
            aE = C24143a.m37112aE(this);
            if (aE == null || !aE.bxP().equals("UnbindProcess")) {
                setResult(0);
                finish();
            } else {
                setResult(1);
                aE.mqu.putInt("key_process_result_code", 1);
                C24143a.m37116j(this, aE.mqu);
            }
            AppMethodBeat.m2505o(47351);
            return true;
        }
        AppMethodBeat.m2505o(47351);
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47352);
        if (this.nTi == null || !this.nTi.isShown()) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.m2505o(47352);
            return onKeyUp;
        }
        this.nTi.setVisibility(8);
        AppMethodBeat.m2505o(47352);
        return true;
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(47354);
        if (this.tHd) {
            finish();
            AppMethodBeat.m2505o(47354);
            return;
        }
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        AppMethodBeat.m2505o(47354);
    }

    public final boolean bwP() {
        return this.tHd;
    }

    public int getForceOrientation() {
        return 1;
    }

    private void cRy() {
        AppMethodBeat.m2504i(47355);
        C46261a.cvP();
        final C4883b c18316lv = new C18316lv();
        c18316lv.cHD.cBT = this.czZ;
        c18316lv.cHD.cHF = 1;
        c18316lv.cHD.cHH = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(47340);
                C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
                C18317b c18317b = c18316lv.cHE;
                if (c18317b == null) {
                    C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.m2505o(47340);
                    return;
                }
                int i = c18317b.errCode;
                C4990ab.m7419v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), c18317b.aIm);
                if (i == 0) {
                    C4990ab.m7417i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", c18317b.cHI);
                    WalletCheckPwdUI.this.tHg.setVisibility(8);
                    WalletCheckPwdUI.m6752b(WalletCheckPwdUI.this, c18317b.cHI);
                    C46261a.m86636EC(0);
                    AppMethodBeat.m2505o(47340);
                    return;
                }
                boolean z;
                C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int j = currentTimeMillis - WalletCheckPwdUI.this.tHn;
                if (j > 1) {
                    WalletCheckPwdUI.this.tHn = currentTimeMillis;
                    WalletCheckPwdUI.this.tHm = WalletCheckPwdUI.this.tHm + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (c18317b.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7419v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(WalletCheckPwdUI.this.tHm), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (WalletCheckPwdUI.this.tHm < 3 && j > 1)) && !z2) {
                    C4990ab.m7418v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
                    if (WalletCheckPwdUI.this.tHq == null) {
                        WalletCheckPwdUI.this.tHq = C5300a.m8068eS(WalletCheckPwdUI.this.mController.ylL);
                    }
                    WalletCheckPwdUI.this.tHg.setVisibility(0);
                    WalletCheckPwdUI.this.tHg.startAnimation(WalletCheckPwdUI.this.tHq);
                    WalletCheckPwdUI.this.tHq.setFillAfter(true);
                    C46261a.m86636EC(1);
                    AppMethodBeat.m2505o(47340);
                    return;
                }
                if (WalletCheckPwdUI.this.tHm >= 3 || z2) {
                    C4990ab.m7418v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
                    WalletCheckPwdUI.cRA();
                    WalletCheckPwdUI.this.cCF = 0;
                    WalletCheckPwdUI.m6758g(WalletCheckPwdUI.this);
                    WalletCheckPwdUI.this.gnj.setVisibility(8);
                    C46261a.m86636EC(2);
                }
                AppMethodBeat.m2505o(47340);
            }
        };
        C4879a.xxA.mo10048a(c18316lv, Looper.getMainLooper());
        AppMethodBeat.m2505o(47355);
    }

    private static void cRz() {
        AppMethodBeat.m2504i(47356);
        C4990ab.m7416i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
        C4879a.xxA.mo10055m(new C45349oa());
        AppMethodBeat.m2505o(47356);
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(47341);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(47341);
    }

    public boolean cNR() {
        AppMethodBeat.m2504i(47353);
        if (this.mBundle.getInt("key_pay_flag", 0) != 0) {
            AppMethodBeat.m2505o(47353);
            return true;
        }
        AppMethodBeat.m2505o(47353);
        return false;
    }
}
