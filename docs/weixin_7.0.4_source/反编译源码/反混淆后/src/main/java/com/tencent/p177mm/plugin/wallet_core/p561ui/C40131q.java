package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p613a.C5218c;
import com.tencent.p177mm.p612ui.p615c.C5300a;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.C11932a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet.p748a.C35391c;
import com.tencent.p177mm.plugin.wallet.p748a.C35392d;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b.C22622a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29674l.C22625b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.FavourLayout;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.q */
public class C40131q extends C15532i implements C22624d {
    private static HashMap<String, Boolean> tKp = new HashMap();
    /* renamed from: Ue */
    protected OnCancelListener f16192Ue;
    protected boolean gHY;
    public ImageView gvq;
    private boolean isPaused = false;
    public View jcl;
    private Context mContext;
    protected MyKeyboardWindow mKeyboard;
    private Animation msx;
    private int msy = 0;
    protected View nTi;
    public ImageView oft;
    protected PayInfo pGr;
    public TextView pUA;
    public TextView qcc;
    public ImageView tGW;
    public TextView tJA;
    public TextView tJB;
    public FavourLayout tJC;
    public CdnImageView tJD;
    public TextView tJE;
    public EditHintPasswdView tJF;
    public View tJH;
    public View tJI;
    public TextView tJJ;
    public ImageView tJK;
    public TextView tJL;
    public TextView tJM;
    public View tJN;
    public TextView tJO;
    protected OnClickListener tJQ;
    protected boolean tJR = false;
    protected boolean tJS = true;
    public Bankcard tJT = null;
    public TextView tJU;
    public View tJV;
    public TextView tJW;
    protected int tJX = 0;
    protected boolean tJY = false;
    private int tJZ = 0;
    private Animation tKa = null;
    private String tKb = "";
    private long tKc = -1;
    boolean tKf = false;
    public C29682c tKk;
    public Button tKl;
    protected C40134a tKm;
    protected int tKn = -1;
    private byte[] tKo = new byte[0];
    protected C40141a tln = new C40141a();
    protected FavorPayInfo toH = new FavorPayInfo();
    public TextView tpG;
    protected C22621b tpu = null;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$b */
    static class C14324b implements OnCancelListener {
        private OnCancelListener tKx;

        /* synthetic */ C14324b(OnCancelListener onCancelListener, byte b) {
            this(onCancelListener);
        }

        private C14324b(OnCancelListener onCancelListener) {
            this.tKx = null;
            this.tKx = onCancelListener;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47604);
            C40131q.m68824np(false);
            if (this.tKx != null) {
                this.tKx.onCancel(dialogInterface);
            }
            AppMethodBeat.m2505o(47604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$1 */
    class C226381 implements C30883a {
        C226381() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47587);
            if (z) {
                C40131q.this.cRO();
                C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(47587);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$6 */
    class C226396 implements View.OnClickListener {
        C226396() {
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.m2504i(47592);
            if (C40131q.this.tJX == 0) {
                if (C40131q.this.tKn == 0) {
                    C40131q.m68810b(C40131q.this);
                } else {
                    C40131q.m68811c(C40131q.this);
                }
            } else if (C40131q.this.tJX == 1) {
                if (C40131q.this.pGr != null) {
                    i = C40131q.this.pGr.cIf;
                }
                C44422ad.m80306e(i, C40131q.this.pGr == null ? "" : C40131q.this.pGr.czZ, 19, "");
                C40131q.m68812d(C40131q.this);
            } else if (C40131q.this.tJX == 2) {
                C40131q.m68812d(C40131q.this);
                C7060h.pYm.mo8381e(15817, Integer.valueOf(4));
            }
            if (C40131q.this.tJX == 1) {
                C40131q.cRS();
                if (C40131q.m68813e(C40131q.this)) {
                    C40131q.m68814f(C40131q.this);
                }
            }
            AppMethodBeat.m2505o(47592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$7 */
    class C296807 implements C11932a {
        C296807() {
        }

        /* renamed from: ef */
        public final void mo9481ef(int i, int i2) {
            AppMethodBeat.m2504i(47593);
            C4990ab.m7416i("MicroMsg.WalletPwdDialog", "face id auth success");
            C40131q.this.pGr.tKd = 1;
            C40131q.this.pGr.cBU = "";
            C40131q.this.pGr.cBV = "";
            try {
                JSONObject jSONObject = new JSONObject(((C30052l) C1720g.m3528K(C30052l.class)).bxi());
                jSONObject.put("soter_type", C14241r.cPI().cQm());
                C40131q.this.pGr.cHI = jSONObject.toString();
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletPwdDialog", e, "", new Object[0]);
            }
            C40131q.this.pGr.cBS = i;
            C40131q.this.pGr.tKe = i2;
            C40131q.this.cRO();
            C46261a.m86637ED(0);
            AppMethodBeat.m2505o(47593);
        }

        /* renamed from: vJ */
        public final void mo9482vJ(int i) {
            AppMethodBeat.m2504i(47594);
            C4990ab.m7417i("MicroMsg.WalletPwdDialog", "face id auth fail: %s, %s", Integer.valueOf(i), Integer.valueOf(C40131q.this.pGr.tKe));
            C40131q.this.jcl.setVisibility(0);
            C40131q.this.tJU.setVisibility(8);
            C40131q.m68812d(C40131q.this);
            PayInfo payInfo = C40131q.this.pGr;
            payInfo.tKe++;
            C46261a.m86637ED(1);
            AppMethodBeat.m2505o(47594);
        }

        public final void bwO() {
            AppMethodBeat.m2504i(47595);
            C40131q.this.jcl.setVisibility(0);
            AppMethodBeat.m2505o(47595);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$c */
    public interface C29682c {
        /* renamed from: a */
        void mo9392a(String str, FavorPayInfo favorPayInfo, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$4 */
    class C401304 implements View.OnClickListener {
        C401304() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47590);
            if (C40131q.this.nTi.isShown()) {
                C40131q.this.nTi.setVisibility(8);
            }
            AppMethodBeat.m2505o(47590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$3 */
    class C401333 implements View.OnClickListener {
        C401333() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47589);
            if (!C40131q.this.nTi.isShown()) {
                C40131q.this.nTi.setVisibility(0);
            }
            AppMethodBeat.m2505o(47589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$a */
    public interface C40134a {
        void bXx();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$5 */
    class C401355 implements View.OnClickListener {
        C401355() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47591);
            C40131q.m68805a(C40131q.this);
            AppMethodBeat.m2505o(47591);
        }
    }

    static /* synthetic */ void cRS() {
        AppMethodBeat.m2504i(47646);
        C40131q.cRz();
        AppMethodBeat.m2505o(47646);
    }

    /* renamed from: d */
    static /* synthetic */ void m68812d(C40131q c40131q) {
        AppMethodBeat.m2504i(47645);
        c40131q.cRN();
        AppMethodBeat.m2505o(47645);
    }

    /* renamed from: f */
    static /* synthetic */ void m68814f(C40131q c40131q) {
        AppMethodBeat.m2504i(47648);
        c40131q.cRy();
        AppMethodBeat.m2505o(47648);
    }

    /* renamed from: np */
    static /* synthetic */ void m68824np(boolean z) {
        AppMethodBeat.m2504i(47650);
        C40131q.m68821nl(z);
        AppMethodBeat.m2505o(47650);
    }

    public C40131q(Context context) {
        super(context, C25738R.style.f11419zx);
        AppMethodBeat.m2504i(47605);
        mo63474cA(context);
        AppMethodBeat.m2505o(47605);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cA */
    public void mo63474cA(Context context) {
        AppMethodBeat.m2504i(47606);
        C4990ab.m7418v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
        this.mContext = context;
        mo63477fl(context);
        mo63478fm(context);
        AppMethodBeat.m2505o(47606);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fl */
    public final void mo63477fl(Context context) {
        AppMethodBeat.m2504i(47607);
        this.jcl = View.inflate(context, btU(), null);
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
        this.tKl = (Button) this.jcl.findViewById(2131829028);
        this.tJC.setVisibility(8);
        AppMethodBeat.m2505o(47607);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(14)
    /* renamed from: fm */
    public void mo63478fm(Context context) {
        AppMethodBeat.m2504i(47608);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        C30890a.m49291a(this.tJF);
        this.tJF.setOnInputValidListener(new C226381());
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
        editText.setOnClickListener(new C401333());
        this.jcl.findViewById(2131822358).setOnClickListener(new C401304());
        this.tKl.setOnClickListener(new C401355());
        AppMethodBeat.m2505o(47608);
    }

    private void cRN() {
        AppMethodBeat.m2504i(47609);
        if (this.tJX == 1) {
            this.tJU.setText(C25738R.string.fez);
        } else {
            this.tJU.setText(C25738R.string.fer);
        }
        this.tJX = 0;
        this.tKc = C5046bo.m7588yz();
        this.tJV.setVisibility(8);
        this.tKl.setVisibility(8);
        this.tJF.setVisibility(0);
        if (!this.nTi.isShown()) {
            this.nTi.setVisibility(0);
        }
        this.tJA.setText(C25738R.string.fq4);
        C40131q.m68821nl(true);
        this.pGr.tKd = 0;
        C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        C36391e.m59978QS(29);
        C40131q.cRz();
        AppMethodBeat.m2505o(47609);
    }

    private void cRy() {
        AppMethodBeat.m2504i(47610);
        C46261a.cvP();
        final C18316lv c18316lv = new C18316lv();
        c18316lv.cHD.cBT = this.pGr.czZ;
        c18316lv.cHD.cHF = 1;
        c18316lv.cHD.cHH = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$8$1 */
            class C143201 implements AnimationListener {

                /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$8$1$1 */
                class C143191 implements Runnable {
                    C143191() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(47596);
                        C40131q.this.tJW.setVisibility(0);
                        AppMethodBeat.m2505o(47596);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$8$1$2 */
                class C143212 implements Runnable {
                    C143212() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(47597);
                        C40131q.this.tJW.setVisibility(8);
                        C40131q.this.tGW.setVisibility(0);
                        AppMethodBeat.m2505o(47597);
                    }
                }

                C143201() {
                }

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.m2504i(47598);
                    C4990ab.m7416i("MicroMsg.WalletPwdDialog", "hy: on flash start");
                    C5004al.m7441d(new C143191());
                    AppMethodBeat.m2505o(47598);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(47599);
                    C4990ab.m7416i("MicroMsg.WalletPwdDialog", "hy: on flash end");
                    C5004al.m7441d(new C143212());
                    AppMethodBeat.m2505o(47599);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(47600);
                C4990ab.m7416i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
                C18317b c18317b = c18316lv.cHE;
                if (c18317b == null) {
                    C40131q.this.pGr.tKd = 0;
                    C4990ab.m7416i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.m2505o(47600);
                    return;
                }
                int i = c18317b.errCode;
                C4990ab.m7419v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), c18317b.aIm);
                PayInfo payInfo;
                if (i == 0) {
                    C4990ab.m7417i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", c18317b.cHI);
                    C44422ad.m80306e(C40131q.this.pGr == null ? 0 : C40131q.this.pGr.cIf, C40131q.this.pGr == null ? "" : C40131q.this.pGr.czZ, 22, "");
                    C40131q.this.pGr.tKd = 1;
                    C40131q.this.pGr.cBU = c18317b.cBU;
                    C40131q.this.pGr.cBV = c18317b.cBV;
                    try {
                        JSONObject jSONObject = new JSONObject(((C30052l) C1720g.m3528K(C30052l.class)).bxi());
                        jSONObject.put("soter_type", C14241r.cPI().cQm());
                        C40131q.this.pGr.cHI = jSONObject.toString();
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.WalletPwdDialog", e, "", new Object[0]);
                    }
                    C40131q.this.pGr.cBS = c18317b.cBS;
                    payInfo = C40131q.this.pGr;
                    payInfo.tKe++;
                    C40131q.this.tJW.setText("");
                    C40131q.this.cRO();
                    C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                    C46261a.m86636EC(0);
                    AppMethodBeat.m2505o(47600);
                    return;
                }
                int i2;
                String str;
                boolean z;
                C4990ab.m7416i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                if (C40131q.this.pGr == null) {
                    i2 = 0;
                } else {
                    i2 = C40131q.this.pGr.cIf;
                }
                if (C40131q.this.pGr == null) {
                    str = "";
                } else {
                    str = C40131q.this.pGr.czZ;
                }
                C44422ad.m80306e(i2, str, 23, "");
                C40131q.this.pGr.tKd = 0;
                C40131q.this.tJV.setVisibility(0);
                C40131q.this.tJW.setTextColor(C40131q.this.getContext().getResources().getColor(C25738R.color.f12266xy));
                C40131q.this.tJW.setText(C25738R.string.fex);
                i2 = (int) (System.currentTimeMillis() / 1000);
                int g = i2 - C40131q.this.msy;
                if (g > 1) {
                    C40131q.this.msy = i2;
                    C40131q.this.tJZ = C40131q.this.tJZ + 1;
                    payInfo = C40131q.this.pGr;
                    payInfo.tKe++;
                }
                C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                boolean z2 = i == 2 || i == 10308;
                if (c18317b.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7419v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(C40131q.this.tJZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (C40131q.this.tJZ < 3 && g > 1)) && !z2) {
                    C4990ab.m7418v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
                    if (C40131q.this.tKa == null) {
                        C40131q.this.tKa = C5300a.m8068eS(C40131q.this.getContext());
                    }
                    C40131q.this.tGW.setVisibility(8);
                    C40131q.this.tJW.setVisibility(4);
                    C40131q.this.tKa.reset();
                    C40131q.this.tKa.setAnimationListener(new C143201());
                    C40131q.this.tJW.startAnimation(C40131q.this.tKa);
                    C46261a.m86636EC(1);
                    AppMethodBeat.m2505o(47600);
                    return;
                }
                if (C40131q.this.tJZ >= 3 || z2) {
                    C4990ab.m7418v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
                    C40131q.cRS();
                    C40131q.this.tJX = 0;
                    C40131q.m68820k(C40131q.this);
                    C40131q.this.tJU.setVisibility(8);
                    C40131q.this.tJV.setVisibility(8);
                    C40131q.this.tJW.setVisibility(0);
                    C40131q.this.tJW.setText(C25738R.string.fey);
                    C40131q.this.tJW.setTextColor(C40131q.this.getContext().getResources().getColor(C25738R.color.a53));
                    C40131q.this.tJA.setText(C25738R.string.fq4);
                    C40131q.this.tJF.setVisibility(0);
                    if (!C40131q.this.nTi.isShown()) {
                        C40131q.this.nTi.setVisibility(0);
                    }
                    C46261a.m86636EC(2);
                    C40131q.m68824np(true);
                }
                AppMethodBeat.m2505o(47600);
            }
        };
        C4879a.xxA.mo10055m(c18316lv);
        AppMethodBeat.m2505o(47610);
    }

    private static void cRz() {
        AppMethodBeat.m2504i(47611);
        C4990ab.m7416i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        ((C30052l) C1720g.m3528K(C30052l.class)).bxk();
        AppMethodBeat.m2505o(47611);
    }

    public int btU() {
        return 2130971107;
    }

    /* renamed from: nm */
    private void m68822nm(boolean z) {
        AppMethodBeat.m2504i(47612);
        View findViewById = this.jcl.findViewById(2131829027);
        if (findViewById != null) {
            if (z) {
                findViewById.setVisibility(0);
                this.tKf = true;
                AppMethodBeat.m2505o(47612);
                return;
            }
            findViewById.setVisibility(8);
            this.tKf = false;
        }
        AppMethodBeat.m2505o(47612);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47613);
        if (i == 4) {
            if (this.f16192Ue != null) {
                this.f16192Ue.onCancel(this);
            }
            if (this.tKm != null) {
                this.tKm.bXx();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47613);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47614);
        super.onCreate(bundle);
        setContentView(this.jcl);
        C40994f.dRn().dRo();
        AppMethodBeat.m2505o(47614);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.m2504i(47615);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.m2505o(47615);
    }

    public void dismiss() {
        AppMethodBeat.m2504i(47616);
        try {
            super.dismiss();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e.getMessage());
        }
        C40131q.cRz();
        this.tln.destory();
        if (this.msx != null) {
            this.msx.cancel();
        }
        AppMethodBeat.m2505o(47616);
    }

    public final void adc(String str) {
        AppMethodBeat.m2504i(47617);
        this.qcc.setText(str);
        AppMethodBeat.m2505o(47617);
    }

    /* renamed from: f */
    public final void mo63476f(String str, double d) {
        AppMethodBeat.m2504i(47618);
        if (TextUtils.isEmpty(str)) {
            this.pUA.setVisibility(8);
            this.tJS = true;
            m68823nn(this.tJS);
            AppMethodBeat.m2505o(47618);
            return;
        }
        this.pUA.setVisibility(0);
        this.pUA.setText(str);
        if (d == 0.0d) {
            this.tJS = false;
            m68823nn(this.tJS);
            AppMethodBeat.m2505o(47618);
            return;
        }
        m68823nn(this.tJS);
        AppMethodBeat.m2505o(47618);
    }

    private void add(String str) {
        AppMethodBeat.m2504i(47619);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7416i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
            this.tJL.setVisibility(8);
            AppMethodBeat.m2505o(47619);
            return;
        }
        this.tJL.setVisibility(0);
        this.tJL.setText(str);
        AppMethodBeat.m2505o(47619);
    }

    /* renamed from: gN */
    public final void mo63479gN(String str, String str2) {
        AppMethodBeat.m2504i(47620);
        if (TextUtils.isEmpty(str2)) {
            this.tJE.setVisibility(8);
        } else {
            this.tJE.setVisibility(0);
            this.tJE.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.tJO.setVisibility(8);
            AppMethodBeat.m2505o(47620);
            return;
        }
        this.tJO.setText(str);
        this.tJO.setVisibility(0);
        AppMethodBeat.m2505o(47620);
    }

    public final void ade(String str) {
        AppMethodBeat.m2504i(47621);
        if (TextUtils.isEmpty(str)) {
            this.tpG.setVisibility(8);
            AppMethodBeat.m2505o(47621);
            return;
        }
        this.tpG.setVisibility(0);
        this.tpG.setText(str);
        AppMethodBeat.m2505o(47621);
    }

    /* renamed from: a */
    private void m68806a(PayInfo payInfo, boolean z) {
        AppMethodBeat.m2504i(47622);
        this.pGr = payInfo;
        this.tJY = z;
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(47622);
            return;
        }
        boolean z2;
        C4990ab.m7418v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
        synchronized (this.tKo) {
            try {
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(47622);
                }
            }
        }
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (c30052l.bxn() && c30052l.bxo() && !c30052l.bxf() && c30052l.bxe()) {
            this.tKn = 0;
        } else if (c30052l.bxA() && c30052l.bxB() && !c30052l.bxg() && c30052l.bxh()) {
            this.tKn = 1;
        }
        C4990ab.m7417i("MicroMsg.WalletPwdDialog", "bio mode: %s", Integer.valueOf(this.tKn));
        this.tJZ = 0;
        this.tJU.setVisibility(8);
        this.tJV.setVisibility(8);
        this.tKc = C5046bo.m7588yz();
        if (C14241r.cPI() == null || this.tKn < 0) {
            z2 = true;
        } else {
            z2 = c30052l.bxz();
        }
        C4990ab.m7417i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", Boolean.valueOf(z2));
        if ((this.pGr == null || !(this.pGr.vwi == 100000 || this.pGr.vwi == 100102)) && z2) {
            if (this.pGr != null && this.pGr.vwi == 100001) {
                this.pGr.tKd = 1;
            }
            if (this.tKn >= 0 && this.tJY && !C40131q.cRP()) {
                this.tJU.setVisibility(0);
                this.tJU.setText(getContext().getString(C25738R.string.fq6));
                this.tJF.setVisibility(8);
                this.nTi.setVisibility(8);
                if (this.pGr != null) {
                    this.pGr.tKd = 1;
                }
                if (this.tKn == 0) {
                    this.tJX = 1;
                    this.tJV.setVisibility(0);
                    this.tGW.setVisibility(0);
                    this.tJA.setText(C25738R.string.fpz);
                    cRy();
                    C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                } else if (this.tKn == 1) {
                    this.tJX = 2;
                    this.tKl.setVisibility(0);
                    this.tJA.setText(C25738R.string.fpy);
                }
            } else if (this.tKn >= 0 && this.tJY && C40131q.cRP()) {
                if (this.tKn == 0) {
                    this.tJU.setText(getContext().getString(C25738R.string.fez));
                } else {
                    this.tJU.setText(getContext().getString(C25738R.string.fer));
                }
                this.tJU.setVisibility(0);
                this.tJX = 0;
                this.tJV.setVisibility(8);
                this.tKl.setVisibility(8);
                this.tJF.setVisibility(0);
                if (!this.nTi.isShown()) {
                    this.nTi.setVisibility(0);
                }
                this.tJA.setText(C25738R.string.fq4);
                if (this.pGr != null) {
                    this.pGr.tKd = 0;
                }
                C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                C36391e.m59978QS(8);
            } else {
                if (this.pGr != null) {
                    this.pGr.tKd = 0;
                }
                this.tJU.setVisibility(8);
                C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            C4990ab.m7417i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", Integer.valueOf(this.tKn), Boolean.valueOf(this.tJY), Boolean.valueOf(C40131q.cRP()));
            this.tJU.setOnClickListener(new C226396());
            AppMethodBeat.m2505o(47622);
            return;
        }
        C4990ab.m7417i("MicroMsg.WalletPwdDialog", "errCode: %s", Integer.valueOf(this.pGr.vwi));
        if (!this.nTi.isShown()) {
            this.nTi.setVisibility(0);
        }
        if (this.pGr != null) {
            this.pGr.tKd = 0;
            this.pGr.cBU = "";
            this.pGr.cBV = "";
        }
        this.tJV.setVisibility(0);
        this.tJW.setVisibility(0);
        TextView textView = this.tJW;
        int i = (this.pGr == null || this.pGr.vwi != 100102) ? C25738R.string.fey : C25738R.string.ff5;
        textView.setText(i);
        this.tJW.setTextColor(getContext().getResources().getColor(C25738R.color.a53));
        if (z2) {
            this.tJI.setVisibility(8);
            this.tJJ.setVisibility(8);
        } else {
            this.tJI.setVisibility(0);
            this.tJJ.setVisibility(0);
        }
        if (this.pGr != null && this.pGr.vwi == 100102) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.TRUE);
            c30052l.mo48312hq(false);
            c30052l.mo48313hr(false);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE);
        }
        C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.m2505o(47622);
    }

    /* renamed from: h */
    private void m68817h(Bankcard bankcard) {
        AppMethodBeat.m2504i(47623);
        if (bankcard == null) {
            C4990ab.m7412e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
            AppMethodBeat.m2505o(47623);
        } else if (bankcard.cPc()) {
            this.tJD.setImageResource(C25738R.drawable.bki);
            AppMethodBeat.m2505o(47623);
        } else if (bankcard.cPd()) {
            this.tln.mo63493a(bankcard, this.tJD);
            AppMethodBeat.m2505o(47623);
        } else {
            if (bankcard.cPg()) {
                this.tJD.setImageDrawable(C5147a.m7837f(getContext().getResources(), C1318a.honey_pay_bank_logo));
                if (!C5046bo.isNullOrNil(bankcard.txk)) {
                    this.tJD.setUseSdcardCache(true);
                    this.tJD.setImgSavedPath(C46362b.cRb());
                    this.tJD.mo38952eb(bankcard.txk, C1318a.honey_pay_bank_logo);
                    AppMethodBeat.m2505o(47623);
                    return;
                }
            }
            this.tln.mo63491a(getContext(), bankcard, this.tJD);
            AppMethodBeat.m2505o(47623);
        }
    }

    /* renamed from: a */
    public final void mo63469a(CharSequence charSequence, View.OnClickListener onClickListener, boolean z) {
        AppMethodBeat.m2504i(47624);
        if (TextUtils.isEmpty(charSequence)) {
            this.tJI.setVisibility(8);
            this.tJJ.setVisibility(8);
            AppMethodBeat.m2505o(47624);
            return;
        }
        this.tJI.setOnClickListener(onClickListener);
        this.tJB.setText(charSequence);
        m68823nn(this.tJS);
        if (z) {
            this.tJH.setVisibility(0);
            AppMethodBeat.m2505o(47624);
            return;
        }
        this.tJH.setVisibility(8);
        AppMethodBeat.m2505o(47624);
    }

    /* renamed from: nn */
    private void m68823nn(boolean z) {
        AppMethodBeat.m2504i(47625);
        if (z) {
            this.tJI.setVisibility(0);
            this.tJJ.setVisibility(0);
            AppMethodBeat.m2505o(47625);
            return;
        }
        this.tJI.setVisibility(8);
        this.tJJ.setVisibility(8);
        AppMethodBeat.m2505o(47625);
    }

    /* renamed from: a */
    public final void mo63467a(final Context context, final Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        AppMethodBeat.m2504i(47626);
        this.tpu = C29666c.tDU.mo47919a(orders);
        if (orders == null || orders.tAr == null || orders.tAr.tmV == null || orders.tAr.tmV.size() <= 0 || this.tpu == null) {
            this.tJE.setVisibility(8);
            AppMethodBeat.m2505o(47626);
            return;
        }
        if (favorPayInfo == null) {
            this.toH = this.tpu.acX(orders.tAr.tmU);
        } else {
            this.toH = favorPayInfo;
        }
        this.tJE.setVisibility(0);
        if (this.tJI != null) {
            this.tJI.setTag(this.toH);
        }
        this.tJT = bankcard;
        this.tJN.setOnClickListener(new View.OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.wallet_core.ui.q$9$1 */
            class C143231 implements C22625b {
                C143231() {
                }

                /* renamed from: a */
                public final void mo9492a(FavorPayInfo favorPayInfo) {
                    int i;
                    String str;
                    double d;
                    String G;
                    String string;
                    String str2;
                    String str3;
                    String str4 = null;
                    AppMethodBeat.m2504i(47601);
                    C40131q.this.toH = favorPayInfo;
                    if (C40131q.this.pGr == null) {
                        i = 0;
                    } else {
                        i = C40131q.this.pGr.cIf;
                    }
                    if (C40131q.this.pGr == null) {
                        str = "";
                    } else {
                        str = C40131q.this.pGr.czZ;
                    }
                    C44422ad.m80306e(i, str, 15, C40131q.this.toH.tzb);
                    C40131q.this.tJR = false;
                    List bt = C22621b.m34308bt(C40131q.this.toH.tzc, C40131q.this.toH.tzd);
                    C40131q.this.toH.tzf = "";
                    if (C22621b.m34307a(C40131q.this.toH, C40131q.this.tJT)) {
                        C40131q.this.tJR = true;
                        if (bt.size() == 0) {
                            C40131q.this.toH.tzf = context.getString(C25738R.string.fet);
                        } else {
                            C40131q.this.toH.tzf = context.getString(C25738R.string.feu);
                        }
                        C40131q.this.dismiss();
                        if (C40131q.this.tKk != null) {
                            C40131q.this.tKk.mo9392a(C40131q.this.tJF.getText(), C40131q.this.toH, C40131q.this.tJR);
                            AppMethodBeat.m2505o(47601);
                            return;
                        }
                    }
                    if (C40131q.this.tJI != null) {
                        C40131q.this.tJI.setTag(C40131q.this.toH);
                    }
                    C46330j acU = C40131q.this.tpu.acU(C40131q.this.toH.tzb);
                    if (acU == null || acU.tnb <= 0.0d) {
                        d = orders.tAr.tmR;
                        G = C36391e.m59972G(orders.tAr.tmR);
                        string = context.getString(C25738R.string.fq0);
                        str = G;
                        str2 = null;
                        str3 = null;
                    } else {
                        d = acU.tmT;
                        G = C36391e.m59972G(acU.tna);
                        str3 = C36391e.m59972G(orders.tAr.tmR);
                        str2 = acU.tnd;
                        str = G;
                        string = null;
                    }
                    if (acU == null || acU.tnc == 0) {
                        G = null;
                    } else {
                        G = acU.tne;
                        if (!C5046bo.isNullOrNil(str2)) {
                            G = ",".concat(String.valueOf(G));
                        }
                    }
                    if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(G)) {
                        str4 = string;
                    } else if (!C5046bo.isNullOrNil(string)) {
                        str4 = ",".concat(String.valueOf(string));
                    }
                    C40131q.this.mo63476f(str, d);
                    C40131q.this.ade(str3);
                    C40131q.this.mo63479gN(str2, str4);
                    C40131q.this.adf(G);
                    AppMethodBeat.m2505o(47601);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(47602);
                C40131q.this.tJK.setVisibility(8);
                C44422ad.m80306e(C40131q.this.pGr == null ? 0 : C40131q.this.pGr.cIf, C40131q.this.pGr == null ? "" : C40131q.this.pGr.czZ, 12, "");
                C29674l.m47060a(context, orders, C40131q.this.toH.tzb, new C143231(), null);
                AppMethodBeat.m2505o(47602);
            }
        });
        Assert.assertNotNull(this.tpu);
        this.tJK.setVisibility(8);
        AppMethodBeat.m2505o(47626);
    }

    /* Access modifiers changed, original: protected */
    public void cRO() {
        AppMethodBeat.m2504i(47627);
        C40131q.m68821nl(false);
        if (this.tJQ != null) {
            this.tJQ.onClick(this, 0);
        }
        dismiss();
        if (this.tKk != null) {
            this.tKk.mo9392a(this.tJF.getText(), this.toH, this.tJR);
        }
        if (this.tKc < 0) {
            C4990ab.m7412e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
            AppMethodBeat.m2505o(47627);
        } else if (this.tJX == 0) {
            C7060h.pYm.mo8378a(686, 0, 1, false);
            C7060h.pYm.mo8378a(686, 1, C5046bo.m7525az(this.tKc), false);
            AppMethodBeat.m2505o(47627);
        } else {
            if (this.tJX == 1) {
                C7060h.pYm.mo8378a(686, 2, 1, false);
                C7060h.pYm.mo8378a(686, 3, C5046bo.m7525az(this.tKc), false);
            }
            AppMethodBeat.m2505o(47627);
        }
    }

    /* renamed from: b */
    public final void mo63473b(final OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(47628);
        if (this.oft == null) {
            AppMethodBeat.m2505o(47628);
            return;
        }
        this.f16192Ue = onCancelListener;
        this.oft.setVisibility(0);
        this.oft.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47603);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(null);
                }
                if (C40131q.this.tKm != null) {
                    C40131q.this.tKm.bXx();
                }
                C40131q.this.cancel();
                if (C40131q.this.tJU.isShown()) {
                    C7060h.pYm.mo8381e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.m2505o(47603);
                    return;
                }
                C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                AppMethodBeat.m2505o(47603);
            }
        });
        AppMethodBeat.m2505o(47628);
    }

    /* renamed from: no */
    public final void mo63480no(boolean z) {
        AppMethodBeat.m2504i(47629);
        if (z) {
            this.tJI.setVisibility(0);
            AppMethodBeat.m2505o(47629);
            return;
        }
        this.tJI.setVisibility(8);
        AppMethodBeat.m2505o(47629);
    }

    /* renamed from: aw */
    private void m68809aw(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(47630);
        if (this.tJC != null) {
            if (linkedList == null || linkedList.size() <= 0) {
                this.tJC.setVisibility(8);
            } else {
                this.tJC.setWording(linkedList);
                this.tJC.setVisibility(0);
                AppMethodBeat.m2505o(47630);
                return;
            }
        }
        AppMethodBeat.m2505o(47630);
    }

    public final void adf(String str) {
        AppMethodBeat.m2504i(47631);
        if (C5046bo.isNullOrNil(str)) {
            this.tJM.setVisibility(8);
            AppMethodBeat.m2505o(47631);
            return;
        }
        this.tJM.setText(str);
        this.tJM.setVisibility(0);
        AppMethodBeat.m2505o(47631);
    }

    /* renamed from: a */
    public final void mo63468a(C40134a c40134a) {
        this.tKm = c40134a;
    }

    /* renamed from: a */
    private static boolean m68808a(PayInfo payInfo) {
        if (payInfo == null || (payInfo.cIf != 31 && payInfo.cIf != 32 && payInfo.cIf != 33)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static C40131q m68803a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, String str, C29682c c29682c, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(47633);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47633);
            return null;
        } else if (orders == null || orders.tAq == null || orders.tAq.size() <= 0) {
            AppMethodBeat.m2505o(47633);
            return null;
        } else {
            String str2;
            String bC;
            String str3;
            List cRl;
            String string;
            CharSequence charSequence;
            C22621b a = C29666c.tDU.mo47919a(orders);
            String str4 = "MicroMsg.WalletPwdDialog";
            String str5 = "showAlert with favInfo %s bindSerial %s  bankcardType %s";
            Object[] objArr = new Object[3];
            objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
            if (bankcard == null) {
                str2 = "";
            } else {
                str2 = bankcard.field_bindSerial;
            }
            objArr[1] = str2;
            if (bankcard == null) {
                str2 = "";
            } else {
                str2 = bankcard.field_bankcardType;
            }
            objArr[2] = str2;
            C4990ab.m7417i(str4, str5, objArr);
            if (a != null) {
                if (favorPayInfo != null && bankcard != null) {
                    boolean z2;
                    if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    C4990ab.m7417i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", favorPayInfo.tzb, Boolean.valueOf(z2));
                    bC = a.mo38205bC(favorPayInfo.tzb, z2);
                    C4990ab.m7417i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", bC);
                    C22622a c22622a = (C22622a) a.acS(bC).get(bankcard.field_bindSerial);
                    C22622a c22622a2 = (C22622a) a.mo38204bB(bC, true).get(bankcard.field_bankcardType);
                    C46330j bA = a.mo38203bA(bC, z2);
                    String str6 = "MicroMsg.WalletPwdDialog";
                    str3 = "defaultComposeInfo %s wrapperSerial %s wrapper %s";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = bA == null ? "" : bA.tnk;
                    objArr2[1] = c22622a == null ? "" : c22622a.toString();
                    objArr2[2] = c22622a2 == null ? "" : c22622a2.toString();
                    C4990ab.m7417i(str6, str3, objArr2);
                    if (c22622a != null && c22622a.tDR != null && !C5046bo.isNullOrNil(c22622a.tDR.tnk)) {
                        favorPayInfo.tzb = c22622a.tDR.tnk;
                    } else if (c22622a2 != null && c22622a2.tDR != null && !C5046bo.isNullOrNil(c22622a2.tDR.tnk)) {
                        favorPayInfo.tzb = c22622a2.tDR.tnk;
                    } else if (bA != null) {
                        favorPayInfo.tzb = bA.tnk;
                    } else {
                        favorPayInfo.tzb = bC;
                    }
                } else if (orders.tAr != null) {
                    favorPayInfo = a.acX(a.acY(orders.tAr.tmU));
                }
                cRl = a.cRl();
            } else {
                C4990ab.m7410d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
                cRl = null;
            }
            bC = "";
            str2 = payInfo.vwh == null ? "" : payInfo.vwh.getString("extinfo_key_19", "");
            C7616ad aoM;
            if (!C5046bo.isNullOrNil(str2)) {
                bC = str2;
            } else if (payInfo.cIf == 32 || payInfo.cIf == 33) {
                str2 = payInfo.vwh.getString("extinfo_key_5", "");
                String string2 = payInfo.vwh.getString("extinfo_key_1", "");
                str5 = context.getString(C25738R.string.fq3);
                if (!C5046bo.isNullOrNil(str2)) {
                    str5 = str2;
                    bC = str2;
                }
                if (C5046bo.isNullOrNil(string2)) {
                    C4990ab.m7412e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    C1720g.m3537RQ();
                    aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(string2);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = C36391e.atA(aoM.mo16707Oj()) + (C5046bo.isNullOrNil(str) ? "" : "(" + str + ")");
                        bC = C5046bo.m7584t(str5, objArr);
                    } else {
                        C4990ab.m7412e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(string2)));
                    }
                }
            } else if (payInfo.cIf == 31) {
                str5 = payInfo.vwh.getString("extinfo_key_1", "");
                if (C5046bo.isNullOrNil(str5)) {
                    C4990ab.m7412e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    C1720g.m3537RQ();
                    aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(str5);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = aoM.mo16706Oi() + (C5046bo.isNullOrNil(str) ? "" : "(" + str + ")");
                        bC = context.getString(C25738R.string.fq3, objArr);
                    } else {
                        C4990ab.m7412e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(str5)));
                    }
                }
            } else if (payInfo.cIf == 42) {
                str5 = payInfo.vwh.getString("extinfo_key_1", "");
                if (C5046bo.isNullOrNil(str5)) {
                    C4990ab.m7412e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    C1720g.m3537RQ();
                    aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(str5);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = aoM.mo16706Oi() + (C5046bo.isNullOrNil(str) ? "" : "(" + str + ")");
                        bC = context.getString(C25738R.string.fpx, objArr);
                    } else {
                        C4990ab.m7412e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(str5)));
                    }
                }
            } else if (payInfo.cIf == 48) {
                bC = context.getString(C25738R.string.dfl);
            } else if (payInfo.cIf == 49) {
                if (C5046bo.isNullOrNil(payInfo.vwh.getString("extinfo_key_1", ""))) {
                    C4990ab.m7413e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", Integer.valueOf(payInfo.cIf));
                } else {
                    bC = context.getString(C25738R.string.fq3, new Object[]{payInfo.vwh.getString("extinfo_key_1", "")});
                }
            }
            if (!C5046bo.isNullOrNil(bC) || orders == null || orders.tAq == null) {
                C4990ab.m7420w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
                str5 = bC;
            } else {
                Commodity commodity = (Commodity) orders.tAq.get(0);
                if (commodity != null) {
                    str5 = commodity.pca;
                    if (C40131q.m68808a(payInfo)) {
                        if (!C5046bo.isNullOrNil(str5)) {
                            str5 = str5 + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        str5 = str5 + commodity.desc;
                    }
                    if (C5046bo.isNullOrNil(str5)) {
                        str5 = commodity.desc;
                    }
                }
                str5 = bC;
            }
            String str7 = null;
            String str8 = null;
            str3 = null;
            str2 = null;
            double d = orders.pTN;
            boolean z3 = false;
            if (a == null || favorPayInfo == null) {
                str4 = null;
            } else {
                C46330j acU = a.acU(favorPayInfo.tzb);
                if (acU != null && acU.tnb > 0.0d) {
                    z3 = true;
                    str8 = C36391e.m60006e(orders.pTN, orders.pcl);
                    str7 = C36391e.m60006e(acU.tna, orders.pcl);
                    d = acU.tmT;
                    str3 = acU.tnd;
                    if (tKp.containsKey(payInfo.czZ)) {
                        str4 = null;
                    } else {
                        C7060h.pYm.mo8381e(14530, Integer.valueOf(3));
                        str4 = null;
                    }
                } else if (cRl == null || cRl.size() <= 0) {
                    str7 = C36391e.m60006e(orders.pTN, orders.pcl);
                    str4 = null;
                } else {
                    str7 = C36391e.m60006e(acU.tna, orders.pcl);
                    z3 = true;
                    str4 = context.getString(C25738R.string.fq0);
                }
                if (!(acU == null || acU.tnc == 0)) {
                    str2 = acU.tne;
                    if (!C5046bo.isNullOrNil(str3)) {
                        str2 = ",".concat(String.valueOf(str2));
                    }
                }
                if (!(C5046bo.isNullOrNil(str3) && C5046bo.isNullOrNil(r4))) {
                    if (C5046bo.isNullOrNil(str4)) {
                        str4 = null;
                    } else {
                        str4 = ",".concat(String.valueOf(str4));
                    }
                }
            }
            if (orders.pPp > 0.0d) {
                Resources resources = context.getResources();
                Object[] objArr3 = new Object[1];
                objArr3[0] = C36391e.m60006e(orders.pPp, orders.pcl);
                string = resources.getString(C25738R.string.fcz, objArr3);
            } else {
                string = null;
            }
            if (bankcard == null) {
                charSequence = "";
            } else {
                charSequence = bankcard.field_desc;
            }
            if (bankcard != null && bankcard.cPg()) {
                charSequence = C44089j.m79292b(context, charSequence);
            }
            final C40131q c40131q = new C40131q(context);
            c40131q.mo63467a(context, orders, favorPayInfo, bankcard);
            c40131q.mo63480no(z);
            c40131q.tJS = z;
            c40131q.mo63473b((OnCancelListener) new C14324b(onCancelListener, (byte) 0));
            c40131q.setOnCancelListener(new C14324b(onCancelListener, (byte) 0));
            c40131q.setCancelable(true);
            c40131q.adc(str5);
            c40131q.mo63476f(str7, d);
            c40131q.ade(str8);
            final PayInfo payInfo2 = payInfo;
            final View.OnClickListener onClickListener2 = onClickListener;
            c40131q.mo63469a(charSequence, new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47588);
                    C40131q.tKp.put(payInfo2.czZ, Boolean.TRUE);
                    onClickListener2.onClick(view);
                    if (c40131q.tKf) {
                        C7060h.pYm.mo8381e(14530, Integer.valueOf(2));
                    }
                    AppMethodBeat.m2505o(47588);
                }
            }, z3);
            c40131q.m68817h(bankcard);
            c40131q.m68806a(payInfo, orders.tAo == 1);
            c40131q.mo63479gN(str3, str4);
            c40131q.adf(str2);
            c40131q.add(string);
            c40131q.tKk = c29682c;
            c40131q.m68809aw(C40131q.m68804a(bankcard, orders));
            if (C40131q.m68807a(bankcard, orders, payInfo.czZ)) {
                c40131q.m68822nm(true);
                C7060h.pYm.mo8381e(14530, Integer.valueOf(1));
            } else {
                c40131q.m68822nm(false);
            }
            c40131q.show();
            C5222ae.m7935a(c40131q.getWindow());
            C30379h.m48455a(context, c40131q);
            AppMethodBeat.m2505o(47633);
            return c40131q;
        }
    }

    /* renamed from: a */
    private static LinkedList<String> m68804a(Bankcard bankcard, Orders orders) {
        AppMethodBeat.m2504i(47634);
        LinkedList<String> linkedList = new LinkedList();
        if (!(orders == null || orders.tAr == null || orders.tAr.tnf == null)) {
            Iterator it = orders.tAr.tnf.tmA.iterator();
            while (it.hasNext()) {
                C35391c c35391c = (C35391c) it.next();
                if (c35391c.pbo.equals(bankcard.field_bindSerial)) {
                    it = c35391c.tmL.iterator();
                    while (it.hasNext()) {
                        C35392d c35392d = (C35392d) it.next();
                        if (c35392d.tmM != 0) {
                            linkedList.add(c35392d.pOz);
                        }
                    }
                    AppMethodBeat.m2505o(47634);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.m2505o(47634);
        return linkedList;
    }

    static {
        AppMethodBeat.m2504i(47651);
        AppMethodBeat.m2505o(47651);
    }

    /* renamed from: a */
    private static boolean m68807a(Bankcard bankcard, Orders orders, String str) {
        AppMethodBeat.m2504i(47635);
        if (bankcard == null) {
            AppMethodBeat.m2505o(47635);
            return false;
        } else if (tKp.containsKey(str)) {
            AppMethodBeat.m2505o(47635);
            return false;
        } else {
            if (!(orders.tAr == null || orders.tAr.tnf == null)) {
                boolean z;
                if (orders.tAr.tnf.tmA.size() > 0) {
                    Iterator it = orders.tAr.tnf.tmA.iterator();
                    z = false;
                    while (it.hasNext()) {
                        boolean z2;
                        C35391c c35391c = (C35391c) it.next();
                        if (c35391c.pbo == null || !c35391c.pbo.equals(bankcard.field_bindSerial)) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        z = z2;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.m2505o(47635);
                    return false;
                } else if (orders.tAr.tnf.tmA.size() > 0) {
                    AppMethodBeat.m2505o(47635);
                    return true;
                } else if (orders.tAr.tnf.tmB != null && orders.tAr.tnf.tmB.tns.size() > 0) {
                    AppMethodBeat.m2505o(47635);
                    return true;
                }
            }
            AppMethodBeat.m2505o(47635);
            return false;
        }
    }

    /* renamed from: a */
    public static C40131q m68802a(Context context, String str, String str2, C29682c c29682c, OnCancelListener onCancelListener, C40134a c40134a) {
        AppMethodBeat.m2504i(47636);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47636);
            return null;
        }
        String str3 = "";
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47636);
            return null;
        }
        C40131q c40131q = new C40131q(context);
        c40131q.mo63473b(onCancelListener);
        c40131q.setOnCancelListener(onCancelListener);
        c40131q.setCancelable(true);
        c40131q.adc(str);
        if (TextUtils.isEmpty(str2)) {
            c40131q.pUA.setVisibility(8);
        } else {
            c40131q.pUA.setVisibility(0);
            c40131q.pUA.setText(str2);
        }
        c40131q.tJS = true;
        c40131q.m68823nn(c40131q.tJS);
        c40131q.mo63480no(false);
        c40131q.tJS = false;
        c40131q.tKm = c40134a;
        c40131q.add(str3);
        c40131q.tKk = c29682c;
        c40131q.show();
        C30379h.m48455a(context, c40131q);
        AppMethodBeat.m2505o(47636);
        return c40131q;
    }

    /* renamed from: a */
    public static C40131q m68801a(Context context, String str, double d, String str2, Bankcard bankcard, C29682c c29682c, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        boolean z = true;
        AppMethodBeat.m2504i(47637);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(47637);
            return null;
        }
        C40131q c40131q = new C40131q(context);
        c40131q.mo63473b(onCancelListener);
        c40131q.setOnCancelListener(onCancelListener);
        c40131q.setCancelable(true);
        c40131q.adc(str);
        c40131q.mo63476f(C36391e.m60006e(d, str2), d);
        c40131q.tJS = true;
        CharSequence charSequence = bankcard == null ? "" : bankcard.field_desc;
        c40131q.m68817h(bankcard);
        if (TextUtils.isEmpty(charSequence)) {
            z = false;
        }
        c40131q.mo63480no(z);
        if (bankcard != null) {
            c40131q.mo63469a(charSequence, onClickListener, false);
        }
        c40131q.tKk = c29682c;
        c40131q.show();
        C30379h.m48455a(context, c40131q);
        AppMethodBeat.m2505o(47637);
        return c40131q;
    }

    public final void cRm() {
        AppMethodBeat.m2504i(47638);
        this.isPaused = false;
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(47638);
        } else {
            AppMethodBeat.m2505o(47638);
        }
    }

    public final void onActivityPause() {
        AppMethodBeat.m2504i(47639);
        this.isPaused = true;
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(47639);
            return;
        }
        if (this.tJX == 1) {
            cRN();
        }
        AppMethodBeat.m2505o(47639);
    }

    /* renamed from: nl */
    private static void m68821nl(boolean z) {
        AppMethodBeat.m2504i(47640);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.m2505o(47640);
    }

    private static boolean cRP() {
        boolean booleanValue;
        AppMethodBeat.m2504i(47641);
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.m2505o(47641);
        return booleanValue;
    }

    /* renamed from: a */
    public static C40131q m68800a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, C29682c c29682c, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(47632);
        C40131q a = C40131q.m68803a(context, true, orders, favorPayInfo, bankcard, payInfo, null, c29682c, onClickListener, onCancelListener);
        AppMethodBeat.m2505o(47632);
        return a;
    }

    /* renamed from: c */
    static /* synthetic */ void m68811c(C40131q c40131q) {
        AppMethodBeat.m2504i(47644);
        c40131q.tJU.setText(c40131q.getContext().getString(C25738R.string.fq6));
        c40131q.tJX = 2;
        c40131q.tKc = C5046bo.m7588yz();
        c40131q.tKl.setVisibility(0);
        c40131q.tJF.setVisibility(8);
        c40131q.nTi.setVisibility(8);
        c40131q.tJA.setText(C25738R.string.fpy);
        C40131q.m68821nl(false);
        c40131q.pGr.tKd = 1;
        AppMethodBeat.m2505o(47644);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m68813e(C40131q c40131q) {
        boolean z;
        AppMethodBeat.m2504i(47647);
        String str = "MicroMsg.WalletPwdDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        if (c40131q.isPaused) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (c40131q.isPaused) {
            AppMethodBeat.m2505o(47647);
            return false;
        }
        AppMethodBeat.m2505o(47647);
        return true;
    }

    /* renamed from: k */
    static /* synthetic */ void m68820k(C40131q c40131q) {
        AppMethodBeat.m2504i(47649);
        c40131q.tKc = C5046bo.m7588yz();
        AppMethodBeat.m2505o(47649);
    }
}
