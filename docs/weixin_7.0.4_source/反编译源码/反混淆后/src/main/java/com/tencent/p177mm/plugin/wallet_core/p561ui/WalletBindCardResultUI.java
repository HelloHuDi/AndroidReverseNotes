package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C45334iy;
import com.tencent.p177mm.p230g.p231a.C45334iy.C26168a;
import com.tencent.p177mm.p230g.p231a.C9489us;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.plugin.wallet_core.model.C46368q.C29638b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoNewUI.C14282a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoNewUI.C14289b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35474x;
import com.tencent.p177mm.plugin.wallet_core.p749c.C43790m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI */
public class WalletBindCardResultUI extends WalletBaseUI {
    private PayInfo pVL;
    private String pVl;
    private TextView pWB;
    private C4884c pap = new C71851();
    private String pdC = null;
    private BindCardOrder tEB;
    private boolean tEC = false;
    private String tED;
    private String tEE;
    private C29638b tEF;
    private C14289b tEG;
    private HashMap<String, C14282a> tEH = new HashMap();
    private String tEI;
    private BindCardOrder tEJ = null;
    private String tEK = "-1";
    private Button tEL;
    private ImageView tEM;
    private ViewGroup tEN;
    private CdnImageView tEO;
    private TextView tEP;
    private TextView tEQ;
    private View tER;
    private Button tES;
    private ViewGroup tET;
    private boolean tEU = false;
    private boolean tEV = false;
    private boolean tEW = false;
    private C40931c tEX;
    private int tzY;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$4 */
    class C44024 implements OnClickListener {
        C44024() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47189);
            C4990ab.m7416i("MicroMsg.WalletBindCardResultUI", "click activity layout");
            WalletBindCardResultUI.m68775b(WalletBindCardResultUI.this);
            AppMethodBeat.m2505o(47189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$5 */
    class C44035 implements OnClickListener {
        C44035() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47190);
            C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", WalletBindCardResultUI.this.tED, WalletBindCardResultUI.this.tEE, Integer.valueOf(WalletBindCardResultUI.this.tzY));
            WalletBindCardResultUI.this.mo63451jX(2);
            C32628se c32628se = new C32628se();
            c32628se.cOf.userName = WalletBindCardResultUI.this.tED;
            c32628se.cOf.cOh = C5046bo.m7532bc(WalletBindCardResultUI.this.tEE, "");
            c32628se.cOf.scene = 1034;
            c32628se.cOf.cOi = 0;
            if (WalletBindCardResultUI.this.tzY > 0) {
                c32628se.cOf.axy = WalletBindCardResultUI.this.tzY;
            }
            C4879a.xxA.mo10055m(c32628se);
            if (C5046bo.isNullOrNil(WalletBindCardResultUI.this.tEB.txP.tzX) || WalletBindCardResultUI.this.tEB.txN.ttW <= 0) {
                WalletBindCardResultUI.this.tEU = false;
                AppMethodBeat.m2505o(47190);
                return;
            }
            WalletBindCardResultUI.this.tEU = true;
            AppMethodBeat.m2505o(47190);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$1 */
    class C71851 extends C4884c<C9489us> {
        C71851() {
            AppMethodBeat.m2504i(47185);
            this.xxI = C9489us.class.getName().hashCode();
            AppMethodBeat.m2505o(47185);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47186);
            C9489us c9489us = (C9489us) c4883b;
            if (c9489us instanceof C9489us) {
                if (!c9489us.cRy.cRz.oZd) {
                    C4990ab.m7416i("MicroMsg.WalletBindCardResultUI", "block pass");
                    AppMethodBeat.m2505o(47186);
                    return true;
                } else if ("1".equals(c9489us.cRy.cRz.cRb) || "2".equals(c9489us.cRy.cRz.cRb)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.mo74571a(c9489us.cRy.cRz.cRb, c9489us.cRy.cRz.cRc, c9489us.cRy.cRz.cRd, c9489us.cRy.cRz.cRe, c9489us.cRy.cRz.cRf, WalletBindCardResultUI.this.pVL == null ? 0 : WalletBindCardResultUI.this.pVL.cIf);
                    C4990ab.m7416i("MicroMsg.WalletBindCardResultUI", "receive guide");
                    WalletBindCardResultUI.this.mBundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.m2505o(47186);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$2 */
    class C226002 implements OnClickListener {
        C226002() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47187);
            WalletBindCardResultUI.this.done();
            AppMethodBeat.m2505o(47187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$3 */
    class C296403 implements OnClickListener {
        C296403() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47188);
            C4990ab.m7416i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.m68775b(WalletBindCardResultUI.this);
            AppMethodBeat.m2505o(47188);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$6 */
    class C354876 implements Runnable {
        C354876() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47191);
            if (WalletBindCardResultUI.this.tES.getVisibility() == 0 && WalletBindCardResultUI.this.tEP.getRight() >= WalletBindCardResultUI.this.tES.getLeft() && !C5046bo.m7519ac(WalletBindCardResultUI.this.tEP.getText())) {
                float textSize = WalletBindCardResultUI.this.tEP.getTextSize();
                C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletBindCardResultUI.this.tEP.getRight()), Integer.valueOf(WalletBindCardResultUI.this.tES.getLeft()));
                Paint paint = new Paint();
                paint.setTextSize(textSize);
                String charSequence = WalletBindCardResultUI.this.tEP.getText().toString();
                float measureText = paint.measureText(charSequence) - ((float) (WalletBindCardResultUI.this.tEP.getRight() - WalletBindCardResultUI.this.tES.getLeft()));
                int i = 1;
                while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                    i++;
                }
                C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                WalletBindCardResultUI.this.tEP.setText(charSequence.substring(0, (charSequence.length() - i) - 1));
                WalletBindCardResultUI.this.tEP.append("...");
            }
            AppMethodBeat.m2505o(47191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$8 */
    class C354888 implements DialogInterface.OnClickListener {
        C354888() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$7 */
    class C401177 implements C30391c {
        C401177() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(47192);
            switch (i) {
                case 0:
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletBindCardResultUI.this.pdC).toString()));
                    intent.addFlags(268435456);
                    WalletBindCardResultUI.this.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(47192);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBindCardResultUI() {
        AppMethodBeat.m2504i(47193);
        AppMethodBeat.m2505o(47193);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47194);
        super.onCreate(bundle);
        if (C1443d.m3068iW(21)) {
            if (C1443d.m3068iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        mo9439AM(4);
        C24143a.m37112aE(this);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.mBundle.getInt("key_pay_type", -1);
        BindCardOrder bindCardOrder = (BindCardOrder) this.mBundle.getParcelable("key_bindcard_value_result");
        if (bindCardOrder == null) {
            bindCardOrder = new BindCardOrder();
        }
        this.tEB = bindCardOrder;
        mo9439AM(0);
        initView();
        this.tEX = dOD();
        cRo();
        mo63451jX(1);
        mo39992nf(1979);
        C4879a.xxA.mo10052c(this.pap);
        this.tEW = true;
        AppMethodBeat.m2505o(47194);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47195);
        super.onResume();
        C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", Boolean.valueOf(this.tEW), this.tEJ, Boolean.valueOf(this.tEU), Boolean.valueOf(this.tEV), this.tEF);
        if (this.tEW) {
            this.tEW = false;
            AppMethodBeat.m2505o(47195);
        } else if (this.tEJ == null || !this.tEV) {
            if (this.tEU && this.tEF != null) {
                mo39970a(new C35474x(this.tEB.txN.ttW, this.tEB.txN.tzO, this.tEB.txN.tzP, this.tEB.txN.tzQ, this.tEB.txN.tzR, this.tEB.txN.tzN, this.tEB.pbn, this.tEB.txK, this.tEB.txL, this.tEB.txL), true, true);
            }
            AppMethodBeat.m2505o(47195);
        } else {
            mo39970a(new C35474x(this.tEJ.txN.ttW, this.tEJ.txN.tzO, this.tEJ.txN.tzP, this.tEJ.txN.tzQ, this.tEJ.txN.tzN, this.tEJ.txN.tzR, this.tEB.pbn, this.tEB.txK, this.tEB.txL, this.tEB.txL), true, true);
            AppMethodBeat.m2505o(47195);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(47196);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.tEM = (ImageView) findViewById(2131828704);
        this.pWB = (TextView) findViewById(2131828705);
        this.tEL = (Button) findViewById(2131828708);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(C25738R.string.f9142qt);
        if (this.tEB == null || C5046bo.isNullOrNil(this.tEB.txG)) {
            this.tEL.setText(string);
        } else {
            this.tEL.setText(this.tEB.txG);
        }
        this.tEL.setOnClickListener(new C226002());
        this.tET = (ViewGroup) findViewById(2131828707);
        this.tEN = (ViewGroup) findViewById(2131827111);
        this.tEO = (CdnImageView) findViewById(2131827112);
        this.tEO.setUseSdcardCache(true);
        this.tEP = (TextView) findViewById(2131827114);
        this.tEQ = (TextView) findViewById(2131827113);
        this.tES = (Button) findViewById(2131827115);
        this.tER = findViewById(2131826995);
        this.tET.setVisibility(4);
        cRo();
        cRp();
        cRn();
        if (!(C5046bo.isNullOrNil(this.tEB.txI) || C5046bo.isNullOrNil(this.tEB.txJ))) {
            ((TextView) findViewById(2131828706)).setText(getString(C25738R.string.f_s, new Object[]{this.tEB.txI, this.tEB.txJ}));
        }
        AppMethodBeat.m2505o(47196);
    }

    private void cRn() {
        AppMethodBeat.m2504i(47197);
        this.tET.setVisibility(0);
        AppMethodBeat.m2505o(47197);
    }

    private void cRo() {
        AppMethodBeat.m2504i(47198);
        this.pWB.setText(this.tEB.txH);
        AppMethodBeat.m2505o(47198);
    }

    private void cRp() {
        MarginLayoutParams marginLayoutParams;
        AppMethodBeat.m2504i(47199);
        this.tEN.setVisibility(4);
        this.tEV = false;
        this.tEU = false;
        if (this.tEB != null) {
            if (this.tEB.txN != null) {
                C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", this.tEJ);
                C14282a c14282a;
                CharSequence text;
                if (this.tEB != null && ((this.tEB.cPi() || this.tEB.cPk()) && this.tEB.txN.ttW > 0 && !C5046bo.isNullOrNil(this.tEB.txO.tzS))) {
                    this.tEJ = this.tEB;
                    this.tER.setVisibility(8);
                    this.tEO.setRoundCorner(true);
                    this.tES.setEnabled(true);
                    this.tES.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.tEQ.setCompoundDrawables(null, null, null, null);
                    c14282a = (C14282a) this.tEH.get(this.tEJ.txN.ttW);
                    if (c14282a != null) {
                        if (!C5046bo.isNullOrNil(c14282a.cIY)) {
                            this.tEO.setUrl(c14282a.cIY);
                        }
                        if (!C5046bo.isNullOrNil(c14282a.cEh)) {
                            this.tEP.setText(c14282a.cEh);
                        }
                        if (!C5046bo.isNullOrNil(c14282a.tID)) {
                            this.tES.setText(c14282a.tID);
                            this.tES.setBackgroundResource(C25738R.drawable.a65);
                        }
                    } else {
                        this.tEO.setUrl(this.tEB.txO.pia);
                        this.tEP.setText(this.tEB.txO.name);
                        this.tES.setText(this.tEB.txO.tzS);
                    }
                    LayoutParams layoutParams = (LayoutParams) this.tEQ.getLayoutParams();
                    if (c14282a != null && !C5046bo.isNullOrNil(c14282a.title)) {
                        this.tEQ.setText(c14282a.title);
                        layoutParams.addRule(15, 0);
                    } else if (C5046bo.isNullOrNil(this.tEB.txO.title)) {
                        this.tEQ.setVisibility(8);
                        layoutParams.addRule(15, -1);
                    } else {
                        this.tEQ.setText(this.tEB.txO.title);
                        layoutParams.addRule(15, 0);
                    }
                    this.tEQ.setLayoutParams(layoutParams);
                    this.tES.setVisibility(0);
                    this.tES.setOnClickListener(new C296403());
                    if (this.tEJ.txN.tzN != 1) {
                        this.tEN.setOnClickListener(new C44024());
                    }
                    String str = this.tEK;
                    boolean z = true;
                    switch (str.hashCode()) {
                        case 48:
                            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                z = false;
                                break;
                            }
                            break;
                        case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 50:
                            if (str.equals("2")) {
                                z = true;
                                break;
                            }
                            break;
                        case 51:
                            if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                z = true;
                                break;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                z = true;
                                break;
                            }
                            break;
                        case 1444:
                            if (str.equals("-1")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            this.tES.setEnabled(false);
                            break;
                    }
                    text = this.tEP.getText();
                    if (!C5046bo.m7519ac(text) && text.length() > 9) {
                        this.tEP.setText(text.subSequence(0, 9));
                        this.tEP.append("...");
                    }
                    marginLayoutParams = (MarginLayoutParams) this.tEN.getLayoutParams();
                    marginLayoutParams.topMargin = C1338a.fromDPToPix(this, 50);
                    this.tEN.setLayoutParams(marginLayoutParams);
                } else if (!(this.tEB.txP == null || C5046bo.isNullOrNil(this.tEB.txP.tzW) || !this.tEB.cPj())) {
                    this.tED = this.tEB.txP.tzW;
                    this.tEE = this.tEB.txP.ttg;
                    this.tzY = this.tEB.txP.tzY;
                    this.tEF = this.tEB.txP;
                    this.tEO.setUrl(this.tEB.txP.tzU);
                    this.tEP.setText(this.tEB.txP.tzV);
                    this.tEQ.setText(getString(C25738R.string.f8_));
                    this.tEQ.setVisibility(0);
                    this.tEO.setRoundCorner(true);
                    this.tES.setEnabled(true);
                    this.tES.setBackgroundResource(C25738R.drawable.f6484fp);
                    LayoutParams layoutParams2 = (LayoutParams) this.tEQ.getLayoutParams();
                    layoutParams2.addRule(15, 0);
                    this.tEQ.setLayoutParams(layoutParams2);
                    if (this.tEB.txN.ttW > 0) {
                        if (!C5046bo.isNullOrNil(this.tEB.txP.tzX)) {
                            this.tES.setVisibility(0);
                            this.tES.setText(this.tEB.txP.tzX);
                            this.tER.setVisibility(8);
                        }
                        c14282a = (C14282a) this.tEH.get(this.tEB.txN.ttW);
                        if (c14282a != null) {
                            if (!C5046bo.isNullOrNil(c14282a.tzU)) {
                                this.tEO.setUrl(c14282a.tzU);
                            }
                            if (!C5046bo.isNullOrNil(c14282a.tzV)) {
                                this.tEP.setText(c14282a.tzV);
                            }
                            if (!C5046bo.isNullOrNil(c14282a.tzX)) {
                                this.tES.setText(c14282a.tzX);
                                this.tES.setBackgroundResource(C25738R.drawable.a65);
                            }
                            if (!C5046bo.isNullOrNil(c14282a.tzW)) {
                                this.tED = c14282a.tzW;
                            }
                            if (!C5046bo.isNullOrNil(c14282a.ttg)) {
                                this.tEE = c14282a.ttg;
                            }
                        }
                    } else {
                        this.tES.setVisibility(8);
                        this.tER.setVisibility(8);
                    }
                    C44035 c44035 = new C44035();
                    this.tEN.setOnClickListener(c44035);
                    this.tES.setOnClickListener(c44035);
                    text = this.tEP.getText();
                    if (!C5046bo.m7519ac(text) && text.length() > 9) {
                        this.tEP.setText(text.subSequence(0, 9));
                        this.tEP.append("...");
                    }
                }
                this.tEN.setVisibility(0);
            }
            if (this.tEP.getVisibility() == 0) {
                this.tEP.post(new C354876());
            }
        }
        if (this.tEN.getVisibility() == 8) {
            marginLayoutParams = (MarginLayoutParams) this.tEM.getLayoutParams();
            marginLayoutParams.topMargin = C1338a.fromDPToPix(this, 91);
            this.tEM.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(47199);
    }

    private void acZ(String str) {
        AppMethodBeat.m2504i(47200);
        cRq();
        C36391e.m60016n(this, str, false);
        AppMethodBeat.m2505o(47200);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47201);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
            mo39970a(new C35474x(this.tEG.tuv, this.tEG.tIF, this.tEG.tIG, this.tEG.tIH, this.tEG.tBC, this.tEG.tII, this.tEB.pbn, this.tEB.txK, this.tEB.txL, this.tEB.txL), true, true);
        }
        AppMethodBeat.m2505o(47201);
    }

    public final int getLayoutId() {
        return 2130971073;
    }

    public final void done() {
        AppMethodBeat.m2504i(47203);
        Bundle bundle = new Bundle();
        if (this.tEX != null) {
            this.tEX.mo8124a((Activity) this, 0, bundle);
            AppMethodBeat.m2505o(47203);
            return;
        }
        finish();
        AppMethodBeat.m2505o(47203);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47204);
        if (i == 4) {
            done();
            AppMethodBeat.m2505o(47204);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47204);
        return onKeyUp;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47205);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.pap);
        mo39993ng(1979);
        AppMethodBeat.m2505o(47205);
    }

    private void cRq() {
        int i = 0;
        AppMethodBeat.m2504i(47206);
        if (!this.tEC) {
            C45334iy c45334iy = new C45334iy();
            c45334iy.cEc.requestCode = 4;
            C26168a c26168a = c45334iy.cEc;
            if (this.mBundle.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            c26168a.bFZ = i;
            C4879a.xxA.mo10055m(c45334iy);
            this.tEC = true;
        }
        AppMethodBeat.m2505o(47206);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47207);
        if (c1207m instanceof C35474x) {
            if (i == 0 && i2 == 0) {
                C35474x c35474x = (C35474x) c1207m;
                C14282a c14282a = new C14282a(c35474x.hwh);
                if (this.tEG != null) {
                    this.tEH.put(c35474x.tuv, c14282a);
                    cRp();
                    cRn();
                } else if (this.tEU) {
                    this.tEH.put(c35474x.tuv, c14282a);
                    cRp();
                    cRn();
                }
            }
        } else if (c1207m instanceof C43790m) {
            if (i == 0 && i2 == 0) {
                C43790m c43790m = (C43790m) c1207m;
                String str2 = c43790m.tud;
                if (this.tEJ != null && this.tEJ.txN.ttW == c43790m.tuf.txN.ttW) {
                    C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", this.tEJ);
                    this.tEK = str2;
                    cRp();
                    cRn();
                    if (!(C5046bo.isNullOrNil(c43790m.ehr) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.tES.setText(c43790m.ehr);
                    }
                }
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !C5046bo.isNullOrNil(c43790m.tue)) {
                    C30379h.m48461b((Context) this, c43790m.tue, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    CharSequence string;
                    if (C5046bo.isNullOrNil(c43790m.tue)) {
                        string = getString(C25738R.string.fns);
                    } else {
                        string = c43790m.tue;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                AppMethodBeat.m2505o(47207);
                return true;
            }
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.fu2);
            }
            C30379h.m48448a((Context) this, str, null, false, new C354888());
            AppMethodBeat.m2505o(47207);
            return true;
        }
        AppMethodBeat.m2505o(47207);
        return false;
    }

    /* renamed from: jX */
    public final void mo63451jX(int i) {
        AppMethodBeat.m2504i(47209);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = this.tEB.txN == null ? "" : C5046bo.m7532bc(this.tEB.txN.ttW, "");
        objArr[1] = this.tEB.txK;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = this.tEB.pbn;
        c7060h.mo8381e(14877, objArr);
        AppMethodBeat.m2505o(47209);
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(47202);
        Dialog a = C30379h.m48422a(this.mController.ylL, getString(C25738R.string.fla), getResources().getStringArray(C25738R.array.f12640au), "", new C401177());
        AppMethodBeat.m2505o(47202);
        return a;
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(47208);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(47208);
    }

    /* renamed from: b */
    static /* synthetic */ void m68775b(WalletBindCardResultUI walletBindCardResultUI) {
        AppMethodBeat.m2504i(47210);
        String str = "MicroMsg.WalletBindCardResultUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletBindCardResultUI.tEJ != null ? walletBindCardResultUI.tEJ.txN.ttW : 0);
        C4990ab.m7417i(str, str2, objArr);
        if (walletBindCardResultUI.tEJ != null && walletBindCardResultUI.tEJ.txN.ttW > 0) {
            walletBindCardResultUI.mo63451jX(2);
            walletBindCardResultUI.tEV = true;
            if (walletBindCardResultUI.tEK.equals("-1") || walletBindCardResultUI.tEK.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                if (walletBindCardResultUI.tEB.cPk()) {
                    BindCardOrder bindCardOrder = walletBindCardResultUI.tEJ;
                    walletBindCardResultUI.mo39970a(new C43790m(bindCardOrder, bindCardOrder.txN.ttW, bindCardOrder.txN.tzO, bindCardOrder.txN.tzP, bindCardOrder.txN.tzQ, bindCardOrder.txN.tzR, bindCardOrder.txN.tzN, walletBindCardResultUI.tEB.pbn, walletBindCardResultUI.tEB.txK, walletBindCardResultUI.tEB.txL, walletBindCardResultUI.tEB.txM), true, false);
                    AppMethodBeat.m2505o(47210);
                    return;
                } else if (!walletBindCardResultUI.tEB.cPi() || C5046bo.isNullOrNil(walletBindCardResultUI.tEJ.txO.url)) {
                    C4990ab.m7412e("MicroMsg.WalletBindCardResultUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletBindCardResultUI.tEH.containsKey(walletBindCardResultUI.tEJ.txN.ttW)) {
                    C14282a c14282a = (C14282a) walletBindCardResultUI.tEH.get(walletBindCardResultUI.tEJ.txN.ttW);
                    C4990ab.m7417i("MicroMsg.WalletBindCardResultUI", "go to new url %s", c14282a.url);
                    if (C5046bo.isNullOrNil(c14282a.url)) {
                        walletBindCardResultUI.acZ(walletBindCardResultUI.tEJ.txO.url);
                        AppMethodBeat.m2505o(47210);
                        return;
                    }
                    walletBindCardResultUI.acZ(c14282a.url);
                    AppMethodBeat.m2505o(47210);
                    return;
                } else {
                    walletBindCardResultUI.tEI = walletBindCardResultUI.tEJ.txO.url;
                    String str3 = walletBindCardResultUI.tEJ.txO.url;
                    C14289b c14289b = new C14289b(walletBindCardResultUI.tEJ.txN.ttW, walletBindCardResultUI.tEJ.txN.tzO, walletBindCardResultUI.tEJ.txN.tzP, walletBindCardResultUI.tEJ.txN.tzQ, walletBindCardResultUI.cNH(), walletBindCardResultUI.pVl, walletBindCardResultUI.tEJ.txN.tzR, walletBindCardResultUI.tEJ.txN.tzN);
                    walletBindCardResultUI.cRq();
                    walletBindCardResultUI.tEG = c14289b;
                    C36391e.m59984a((Context) walletBindCardResultUI, str3, false, 1);
                    AppMethodBeat.m2505o(47210);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(47210);
    }
}
