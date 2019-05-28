package com.tencent.p177mm.plugin.wallet_core.p561ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.p230g.p231a.C45349oa;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p613a.C5218c;
import com.tencent.p177mm.p612ui.p615c.C5300a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.FavourLayout;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.p */
public final class C35506p extends C15532i implements C22624d {
    /* renamed from: Ue */
    protected OnCancelListener f15070Ue;
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
    public C35505b tJG;
    public View tJH;
    public View tJI;
    public TextView tJJ;
    public ImageView tJK;
    public TextView tJL;
    public TextView tJM;
    public View tJN;
    public TextView tJO;
    protected C35504a tJP;
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
    protected C40141a tln = new C40141a();
    public TextView tpG;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$2 */
    class C143172 implements View.OnClickListener {
        C143172() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47555);
            if (!C35506p.this.nTi.isShown()) {
                C35506p.this.nTi.setVisibility(0);
            }
            AppMethodBeat.m2505o(47555);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$3 */
    class C296793 implements View.OnClickListener {
        C296793() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47556);
            if (C35506p.this.nTi.isShown()) {
                C35506p.this.nTi.setVisibility(8);
            }
            AppMethodBeat.m2505o(47556);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$1 */
    class C314601 implements C30883a {
        C314601() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47554);
            if (z) {
                C35506p.this.cRO();
                C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(47554);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$a */
    public interface C35504a {
        void bXx();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$b */
    public interface C35505b {
        /* renamed from: f */
        void mo41714f(String str, boolean z, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$4 */
    class C355074 implements View.OnClickListener {
        C355074() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47557);
            if (C35506p.this.tJX == 0) {
                C35506p.m58271a(C35506p.this);
            } else if (C35506p.this.tJX == 1) {
                C35506p.m58273b(C35506p.this);
            }
            if (C35506p.this.tJX == 1) {
                C35506p.cRQ();
                if (C35506p.m58274c(C35506p.this)) {
                    C35506p.m58275d(C35506p.this);
                }
            }
            AppMethodBeat.m2505o(47557);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$6 */
    class C355086 implements View.OnClickListener {
        C355086() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47563);
            C35506p.this.cRO();
            AppMethodBeat.m2505o(47563);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m58273b(C35506p c35506p) {
        AppMethodBeat.m2504i(47581);
        c35506p.cRN();
        AppMethodBeat.m2505o(47581);
    }

    static /* synthetic */ void cRQ() {
        AppMethodBeat.m2504i(47582);
        C35506p.cRz();
        AppMethodBeat.m2505o(47582);
    }

    static /* synthetic */ void cRR() {
        AppMethodBeat.m2504i(47586);
        C35506p.m58283nl(true);
        AppMethodBeat.m2505o(47586);
    }

    /* renamed from: d */
    static /* synthetic */ void m58275d(C35506p c35506p) {
        AppMethodBeat.m2504i(47584);
        c35506p.cRy();
        AppMethodBeat.m2505o(47584);
    }

    private C35506p(Context context) {
        super(context, C25738R.style.f11419zx);
        AppMethodBeat.m2504i(47565);
        C4990ab.m7418v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
        this.jcl = View.inflate(context, 2130971107, null);
        this.tJz = (Button) this.jcl.findViewById(2131822912);
        this.oft = (ImageView) this.jcl.findViewById(2131826480);
        this.mKeyboard = (MyKeyboardWindow) this.jcl.findViewById(2131822357);
        this.nTi = this.jcl.findViewById(2131822356);
        this.qcc = (TextView) this.jcl.findViewById(2131821019);
        this.tJA = (TextView) this.jcl.findViewById(2131829019);
        this.pUA = (TextView) this.jcl.findViewById(2131826481);
        this.tpG = (TextView) this.jcl.findViewById(2131826482);
        this.tpG.getPaint().setFlags(16);
        this.tJB = (TextView) this.jcl.findViewById(2131825789);
        this.tJC = (FavourLayout) this.jcl.findViewById(2131828748);
        this.tJD = (CdnImageView) this.jcl.findViewById(2131829026);
        this.tJH = this.jcl.findViewById(2131829022);
        this.tJE = (TextView) this.jcl.findViewById(2131826485);
        this.gvq = (ImageView) this.jcl.findViewById(2131826478);
        this.tJI = this.jcl.findViewById(2131826483);
        this.tJJ = (TextView) this.jcl.findViewById(2131829025);
        C40460b.m69434b(this.gvq, C36391e.getUsername());
        this.tJF = (EditHintPasswdView) this.jcl.findViewById(2131824902);
        this.tJK = (ImageView) this.jcl.findViewById(2131826484);
        this.tJU = (TextView) this.jcl.findViewById(2131829020);
        this.tJV = this.jcl.findViewById(2131828755);
        this.tJW = (TextView) this.jcl.findViewById(2131828757);
        this.tGW = (ImageView) this.jcl.findViewById(2131828756);
        this.tJL = (TextView) this.jcl.findViewById(2131827122);
        this.tJM = (TextView) this.jcl.findViewById(2131829024);
        this.tJN = this.jcl.findViewById(2131829021);
        this.tJO = (TextView) this.jcl.findViewById(2131829023);
        this.tJC.setVisibility(8);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.tJz.setEnabled(false);
        this.tJz.setTextColor(context.getResources().getColorStateList(C25738R.color.a8j));
        C30890a.m49291a(this.tJF);
        this.tJF.setOnInputValidListener(new C314601());
        this.tJF.requestFocus();
        TextView textView = (TextView) this.jcl.findViewById(2131829019);
        if (textView != null) {
            textView.setText(C44423ae.m80309ir(context));
        }
        EditText editText = (EditText) this.jcl.findViewById(2131820687);
        C36391e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            C5218c c5218c = new C5218c();
            this.mKeyboard.setSecureAccessibility(c5218c);
            editText.setAccessibilityDelegate(c5218c);
        }
        editText.setOnClickListener(new C143172());
        this.jcl.findViewById(2131822358).setOnClickListener(new C296793());
        cRM();
        AppMethodBeat.m2505o(47565);
    }

    private void cRM() {
        boolean z;
        AppMethodBeat.m2504i(47566);
        C4990ab.m7418v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
        this.tJZ = 0;
        this.tJU.setVisibility(8);
        this.tJV.setVisibility(8);
        this.tKc = C5046bo.m7588yz();
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (C14241r.cPI() == null || !c30052l.bxe()) {
            z = true;
        } else {
            z = c30052l.bxz();
        }
        C4990ab.m7417i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", Boolean.valueOf(z));
        this.tKd = 0;
        this.cHI = "";
        if (c30052l == null || !c30052l.bxn() || c30052l.bxf()) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7419v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", Boolean.valueOf(z));
        boolean z2 = c30052l != null && c30052l.bxe();
        if (z2 && z && this.tJY && !C35506p.cRP()) {
            this.tJU.setVisibility(0);
            this.tJU.setText(getContext().getString(C25738R.string.fq6));
            this.tJX = 1;
            this.tJV.setVisibility(0);
            this.tGW.setVisibility(0);
            this.tJF.setVisibility(8);
            this.nTi.setVisibility(8);
            this.tJA.setText(C25738R.string.fpz);
            this.tKd = 1;
            cRy();
            C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (z2 && z && this.tJY && C35506p.cRP()) {
            this.tJU.setText(getContext().getString(C25738R.string.fez));
            this.tJU.setVisibility(0);
            this.tJX = 0;
            this.tJV.setVisibility(8);
            this.tJF.setVisibility(0);
            if (!this.nTi.isShown()) {
                this.nTi.setVisibility(0);
            }
            this.tJA.setText(C25738R.string.fq4);
            this.tKd = 0;
            this.cHI = "";
            C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            C36391e.m59978QS(8);
        } else {
            this.tKd = 0;
            this.cHI = "";
            this.tJU.setVisibility(8);
            C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        }
        C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.tJY + ", isForcePwdMode:" + C35506p.cRP());
        this.tJU.setOnClickListener(new C355074());
        AppMethodBeat.m2505o(47566);
    }

    private void cRN() {
        AppMethodBeat.m2504i(47567);
        this.tJU.setText(getContext().getString(C25738R.string.fez));
        this.tJX = 0;
        this.tKc = C5046bo.m7588yz();
        this.tJV.setVisibility(8);
        this.tJF.setVisibility(0);
        if (!this.nTi.isShown()) {
            this.nTi.setVisibility(0);
        }
        this.tJA.setText(C25738R.string.fq4);
        C35506p.m58283nl(true);
        this.tKd = 0;
        this.cHI = "";
        C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        C36391e.m59978QS(29);
        C35506p.cRz();
        AppMethodBeat.m2505o(47567);
    }

    private void cRy() {
        AppMethodBeat.m2504i(47568);
        C4990ab.m7417i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", C5046bo.dpG().toString());
        C46261a.cvP();
        final C4883b c18316lv = new C18316lv();
        c18316lv.cHD.cBT = this.czZ;
        c18316lv.cHD.cHF = 1;
        c18316lv.cHD.cHH = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$5$1 */
            class C226351 implements AnimationListener {

                /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$5$1$1 */
                class C226361 implements Runnable {
                    C226361() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(47558);
                        C35506p.this.tJW.setVisibility(0);
                        AppMethodBeat.m2505o(47558);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.wallet_core.ui.p$5$1$2 */
                class C226372 implements Runnable {
                    C226372() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(47559);
                        C35506p.this.tJW.setVisibility(8);
                        C35506p.this.tGW.setVisibility(0);
                        AppMethodBeat.m2505o(47559);
                    }
                }

                C226351() {
                }

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.m2504i(47560);
                    C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
                    C5004al.m7441d(new C226361());
                    AppMethodBeat.m2505o(47560);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(47561);
                    C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
                    C5004al.m7441d(new C226372());
                    AppMethodBeat.m2505o(47561);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(47562);
                C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
                C18317b c18317b = c18316lv.cHE;
                if (c18317b == null) {
                    C35506p.this.tKd = 0;
                    C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.m2505o(47562);
                    return;
                }
                int i = c18317b.errCode;
                C4990ab.m7419v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), c18317b.aIm);
                if (i == 0) {
                    C4990ab.m7417i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", c18317b.cHI);
                    C35506p.this.tKd = 1;
                    C35506p.this.cHI = c18317b.cHI;
                    try {
                        JSONObject jSONObject = new JSONObject(C35506p.this.cHI);
                        jSONObject.put("soter_type", "1");
                        C35506p.this.cHI = jSONObject.toString();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", e, "", new Object[0]);
                    }
                    C35506p.this.tKe = C35506p.this.tKe + 1;
                    C35506p.this.tJW.setText("");
                    C35506p.this.cRO();
                    C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                    C46261a.m86636EC(0);
                    AppMethodBeat.m2505o(47562);
                    return;
                }
                boolean z;
                C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                C35506p.this.tKd = 0;
                C35506p.this.cHI = "";
                C35506p.this.tJV.setVisibility(0);
                C35506p.this.tJW.setTextColor(C35506p.this.getContext().getResources().getColor(C25738R.color.f12266xy));
                C35506p.this.tJW.setText(C25738R.string.fex);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int g = currentTimeMillis - C35506p.this.msy;
                if (g > 1) {
                    C35506p.this.msy = currentTimeMillis;
                    C35506p.this.tJZ = C35506p.this.tJZ + 1;
                    C35506p.this.tKe = C35506p.this.tKe + 1;
                }
                C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                boolean z2 = i == 2 || i == 10308;
                if (c18317b.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7419v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(C35506p.this.tJZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (C35506p.this.tJZ < 3 && g > 1)) && !z2) {
                    C4990ab.m7418v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
                    if (C35506p.this.tKa == null) {
                        C35506p.this.tKa = C5300a.m8068eS(C35506p.this.getContext());
                    }
                    C35506p.this.tGW.setVisibility(8);
                    C35506p.this.tJW.setVisibility(4);
                    C35506p.this.tKa.reset();
                    C35506p.this.tKa.setAnimationListener(new C226351());
                    C35506p.this.tJW.startAnimation(C35506p.this.tKa);
                    C46261a.m86636EC(1);
                    AppMethodBeat.m2505o(47562);
                    return;
                }
                if (C35506p.this.tJZ >= 3 || z2) {
                    C4990ab.m7418v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
                    C35506p.cRQ();
                    C35506p.this.tJX = 0;
                    C35506p.m58282k(C35506p.this);
                    C35506p.this.tJU.setVisibility(8);
                    C35506p.this.tJV.setVisibility(8);
                    C35506p.this.tJW.setVisibility(0);
                    C35506p.this.tJW.setText(C25738R.string.fey);
                    C35506p.this.tJW.setTextColor(C35506p.this.getContext().getResources().getColor(C25738R.color.a53));
                    C35506p.this.tJA.setText(C25738R.string.fq4);
                    C35506p.this.tJF.setVisibility(0);
                    if (!C35506p.this.nTi.isShown()) {
                        C35506p.this.nTi.setVisibility(0);
                    }
                    C46261a.m86636EC(2);
                    C35506p.cRR();
                }
                AppMethodBeat.m2505o(47562);
            }
        };
        C4879a.xxA.mo10048a(c18316lv, Looper.getMainLooper());
        AppMethodBeat.m2505o(47568);
    }

    private static void cRz() {
        AppMethodBeat.m2504i(47569);
        C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
        C4879a.xxA.mo10055m(new C45349oa());
        AppMethodBeat.m2505o(47569);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47570);
        if (i == 4) {
            if (this.f15070Ue != null) {
                this.f15070Ue.onCancel(this);
            }
            if (this.tJP != null) {
                this.tJP.bXx();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47570);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47571);
        super.onCreate(bundle);
        setContentView(this.jcl);
        C40994f.dRn().dRo();
        AppMethodBeat.m2505o(47571);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(47572);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.m2505o(47572);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(47573);
        try {
            super.dismiss();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + e.getMessage());
        }
        C35506p.cRz();
        this.tln.destory();
        if (this.msx != null) {
            this.msx.cancel();
        }
        AppMethodBeat.m2505o(47573);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRO() {
        AppMethodBeat.m2504i(47574);
        C35506p.m58283nl(false);
        if (this.tJQ != null) {
            this.tJQ.onClick(this, 0);
        }
        dismiss();
        if (this.tJG != null) {
            boolean z;
            C4990ab.m7417i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", Integer.valueOf(this.tKd), this.cHI);
            C35505b c35505b = this.tJG;
            String text = this.tJF.getText();
            if (this.tKd == 1) {
                z = true;
            } else {
                z = false;
            }
            c35505b.mo41714f(text, z, this.cHI);
        }
        if (this.tKc < 0) {
            C4990ab.m7412e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
            AppMethodBeat.m2505o(47574);
        } else if (this.tJX == 0) {
            C7060h.pYm.mo8378a(686, 0, 1, false);
            C7060h.pYm.mo8378a(686, 1, C5046bo.m7525az(this.tKc), false);
            AppMethodBeat.m2505o(47574);
        } else {
            if (this.tJX == 1) {
                C7060h.pYm.mo8378a(686, 2, 1, false);
                C7060h.pYm.mo8378a(686, 3, C5046bo.m7525az(this.tKc), false);
            }
            AppMethodBeat.m2505o(47574);
        }
    }

    /* renamed from: a */
    public static C35506p m58269a(Context context, String str, String str2, String str3, boolean z, C35505b c35505b, final OnCancelListener onCancelListener, C35504a c35504a) {
        AppMethodBeat.m2504i(47575);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47575);
            return null;
        }
        C35506p c35506p = new C35506p(context);
        if (c35506p.tJz != null) {
            c35506p.tJQ = null;
            c35506p.tJz.setOnClickListener(new C355086());
        }
        if (c35506p.oft != null) {
            c35506p.f15070Ue = onCancelListener;
            c35506p.oft.setVisibility(0);
            c35506p.oft.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47564);
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(null);
                    }
                    if (C35506p.this.tJP != null) {
                        C35506p.this.tJP.bXx();
                    }
                    C35506p.this.cancel();
                    if (C35506p.this.tJU.isShown()) {
                        C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        AppMethodBeat.m2505o(47564);
                        return;
                    }
                    C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.m2505o(47564);
                }
            });
        }
        c35506p.setOnCancelListener(onCancelListener);
        c35506p.setCancelable(true);
        c35506p.qcc.setText(str);
        if (TextUtils.isEmpty(str2)) {
            c35506p.pUA.setVisibility(8);
        } else {
            c35506p.pUA.setVisibility(0);
            c35506p.pUA.setText(str2);
        }
        c35506p.tJI.setVisibility(8);
        c35506p.tJS = false;
        c35506p.tJP = c35504a;
        if (TextUtils.isEmpty(str3)) {
            C4990ab.m7416i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
            c35506p.tJL.setVisibility(8);
        } else {
            c35506p.tJL.setVisibility(0);
            c35506p.tJL.setText(str3);
        }
        c35506p.tJG = c35505b;
        c35506p.tJY = z;
        if (!C1853r.m3831YM()) {
            c35506p.cRM();
        }
        c35506p.show();
        C30379h.m48455a(context, c35506p);
        AppMethodBeat.m2505o(47575);
        return c35506p;
    }

    public final void cRm() {
        AppMethodBeat.m2504i(47576);
        this.isPaused = false;
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(47576);
        } else {
            AppMethodBeat.m2505o(47576);
        }
    }

    public final void onActivityPause() {
        AppMethodBeat.m2504i(47577);
        this.isPaused = true;
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(47577);
            return;
        }
        if (this.tJX == 1) {
            cRN();
        }
        AppMethodBeat.m2505o(47577);
    }

    /* renamed from: nl */
    private static void m58283nl(boolean z) {
        AppMethodBeat.m2504i(47578);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.m2505o(47578);
    }

    private static boolean cRP() {
        boolean booleanValue;
        AppMethodBeat.m2504i(47579);
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.m2505o(47579);
        return booleanValue;
    }

    /* renamed from: a */
    static /* synthetic */ void m58271a(C35506p c35506p) {
        AppMethodBeat.m2504i(47580);
        c35506p.tJU.setText(c35506p.getContext().getString(C25738R.string.fq6));
        c35506p.tJX = 1;
        c35506p.tKc = C5046bo.m7588yz();
        c35506p.tJV.setVisibility(0);
        c35506p.tGW.setVisibility(0);
        c35506p.tJW.setVisibility(8);
        c35506p.tJF.setVisibility(8);
        c35506p.nTi.setVisibility(8);
        c35506p.tJA.setText(C25738R.string.fpz);
        C35506p.m58283nl(false);
        c35506p.tKd = 1;
        C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
        C36391e.m59978QS(9);
        AppMethodBeat.m2505o(47580);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m58274c(C35506p c35506p) {
        boolean z;
        AppMethodBeat.m2504i(47583);
        String str = "MicroMsg.WalletPwdCustomDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        if (c35506p.isPaused) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (c35506p.isPaused) {
            AppMethodBeat.m2505o(47583);
            return false;
        }
        AppMethodBeat.m2505o(47583);
        return true;
    }

    /* renamed from: k */
    static /* synthetic */ void m58282k(C35506p c35506p) {
        AppMethodBeat.m2504i(47585);
        c35506p.tKc = C5046bo.m7588yz();
        AppMethodBeat.m2505o(47585);
    }
}
