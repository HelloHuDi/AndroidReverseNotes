package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.base.MMFormVerifyCodeInputView;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.ResizeLayout.C33029a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI */
public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected String fHE = null;
    protected int flQ;
    private C4884c gAY = new C99761();
    protected String gBE = null;
    protected EditText gBJ;
    protected Button gBP;
    protected Button gBQ;
    private View gBR;
    protected Button gBS;
    protected MMFormInputView gCV;
    private ResizeLayout gCa;
    private Button gCj;
    protected int[] gCr = new int[5];
    protected MMFormInputView gDH;
    protected EditText gDI;
    protected MMFormVerifyCodeInputView gDJ;
    protected View gDK;
    protected TextView gDL;
    protected Button gDM;
    protected Button gDN;
    protected TextView gDO;
    protected TextView gDP;
    protected TextView gDQ;
    protected Button gDR;
    protected View gDS;
    protected boolean gDT = true;
    protected String gDU = null;
    protected String gDV = null;
    private int gDW = 0;
    private C38070b gDX;
    protected boolean gDY;
    protected boolean gDa;
    private MMKeyboardUperView gDb;
    protected boolean gDc = false;
    private final int gDd = 128;
    protected LinearLayout grF;
    protected TextView grH;
    protected String grJ = null;
    protected String gsF;
    protected C44275p guc;

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$20 */
    class C202620 implements C15994a {
        C202620() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$1 */
    class C99761 extends C4884c<C37745jk> {
        C99761() {
            AppMethodBeat.m2504i(125159);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(125159);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(125160);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(125160);
                return false;
            }
            C4990ab.m7417i("MicroMsg.MobileInputUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(125160);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$2 */
    class C99772 implements OnClickListener {
        C99772() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125161);
            MobileInputUI.m74807d(MobileInputUI.this);
            AppMethodBeat.m2505o(125161);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$15 */
    class C1889215 implements C33029a {
        C1889215() {
        }

        public final void aqZ() {
            AppMethodBeat.m2504i(125175);
            MobileInputUI.m74806c(MobileInputUI.this);
            AppMethodBeat.m2505o(125175);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$16 */
    class C1889316 implements OnClickListener {
        C1889316() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125176);
            MobileInputUI.m74804S(MobileInputUI.this, MobileInputUI.this.getString(C25738R.string.g7t) + C4988aa.dor());
            AppMethodBeat.m2505o(125176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$18 */
    class C1889418 implements C36073c {
        C1889418() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(125178);
            if (c44273l.dzR()) {
                c44273l.mo70072hi(ReaderCallback.HIDDEN_BAR, C25738R.string.g0m);
                c44273l.mo70072hi(ReaderCallback.SHOW_BAR, C25738R.string.g0k);
            }
            AppMethodBeat.m2505o(125178);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$17 */
    class C2662117 implements OnClickListener {
        C2662117() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125177);
            MobileInputUI.m74804S(MobileInputUI.this, MobileInputUI.this.getString(C25738R.string.g7k, new Object[]{C4988aa.dor()}));
            AppMethodBeat.m2505o(125177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$6 */
    class C330056 implements TextWatcher {
        C330056() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125166);
            MobileInputUI.this.gDN.setEnabled(MobileInputUI.m74808e(MobileInputUI.this));
            AppMethodBeat.m2505o(125166);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$7 */
    class C330067 implements OnEditorActionListener {
        C330067() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125167);
            if (i == 6 || i == 5) {
                boolean e = MobileInputUI.m74808e(MobileInputUI.this);
                AppMethodBeat.m2505o(125167);
                return e;
            }
            AppMethodBeat.m2505o(125167);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$8 */
    class C330078 implements OnKeyListener {
        C330078() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125168);
            if (66 == i && keyEvent.getAction() == 0) {
                boolean e = MobileInputUI.m74808e(MobileInputUI.this);
                AppMethodBeat.m2505o(125168);
                return e;
            }
            AppMethodBeat.m2505o(125168);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$a */
    protected enum C33008a {
        GoBack,
        GoNext;

        static {
            AppMethodBeat.m2505o(125182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$12 */
    class C3806712 implements OnMenuItemClickListener {
        C3806712() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125172);
            MobileInputUI.m74805b(MobileInputUI.this);
            AppMethodBeat.m2505o(125172);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$19 */
    class C3806819 implements C5279d {
        C3806819() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(125179);
            switch (menuItem.getItemId()) {
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    MobileInputUI.m74807d(MobileInputUI.this);
                    AppMethodBeat.m2505o(125179);
                    return;
                case ReaderCallback.SHOW_BAR /*5002*/:
                    MobileInputUI.m74804S(MobileInputUI.this, MobileInputUI.this.getString(C25738R.string.gb3) + C4988aa.dor());
                    break;
            }
            AppMethodBeat.m2505o(125179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$b */
    public interface C38070b {
        /* renamed from: a */
        void mo21368a(C33008a c33008a);

        /* renamed from: a */
        void mo21369a(MobileInputUI mobileInputUI);

        void start();

        void stop();
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$14 */
    class C4229614 implements OnClickListener {
        C4229614() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125174);
            C25985d.m41448H(MobileInputUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            MobileInputUI.this.overridePendingTransition(C25738R.anim.f8372cd, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(125174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileInputUI$11 */
    class C4229711 implements OnClickListener {
        C4229711() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125171);
            Intent intent = new Intent();
            intent.putExtra("country_name", MobileInputUI.this.fHE);
            intent.putExtra("couttry_code", MobileInputUI.this.countryCode);
            intent.putExtra("iso_code", MobileInputUI.this.gBE);
            C24679a.gkE.mo38903b(intent, MobileInputUI.this);
            AppMethodBeat.m2505o(125171);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MobileInputUI() {
        AppMethodBeat.m2504i(125183);
        AppMethodBeat.m2505o(125183);
    }

    /* renamed from: S */
    static /* synthetic */ void m74804S(Context context, String str) {
        AppMethodBeat.m2504i(125199);
        MobileInputUI.m74803R(context, str);
        AppMethodBeat.m2505o(125199);
    }

    /* renamed from: b */
    static /* synthetic */ void m74805b(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125197);
        mobileInputUI.goBack();
        AppMethodBeat.m2505o(125197);
    }

    /* renamed from: f */
    static /* synthetic */ void m74809f(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125202);
        mobileInputUI.are();
        AppMethodBeat.m2505o(125202);
    }

    public final int getLayoutId() {
        return 2130970237;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125184);
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(this.mController.ylL.getResources().getColor(C25738R.color.f12207vz));
        this.gDW = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.flQ = getIntent().getIntExtra("mobile_auth_type", 0);
        this.gDY = getIntent().getBooleanExtra("can_finish", false);
        setBackBtn(new C3806712(), C1318a.actionbar_icon_close_black);
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        dyb();
        switch (this.gDW) {
            case -1:
                this.gDX = new C42311l();
                break;
            case 1:
                if (!C5046bo.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
                    this.gDX = new C42311l();
                    break;
                }
                int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                if (intArrayExtra != null) {
                    this.gCr = intArrayExtra;
                }
                this.gDX = new C10010i();
                break;
            case 2:
                this.gDX = new C42308k();
                break;
            case 3:
                this.gDX = new C26654h();
                break;
            case 4:
                this.gDX = new C45504j();
                break;
            default:
                C4990ab.m7413e("MicroMsg.MobileInputUI", "wrong purpose %s", Integer.valueOf(this.gDW));
                finish();
                AppMethodBeat.m2505o(125184);
                return;
        }
        this.countryCode = C5025av.amO(C5046bo.m7532bc(getIntent().getStringExtra("couttry_code"), ""));
        this.fHE = C5046bo.m7532bc(getIntent().getStringExtra("country_name"), "");
        this.gBE = C5046bo.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.grJ = C5046bo.m7532bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.gDU = C5025av.amP(this.countryCode);
        this.gDV = C5046bo.m7532bc(getIntent().getStringExtra("input_mobile_number"), "");
        this.gsF = C42756a.m75794FP();
        initView();
        this.gDc = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(!this.gDc || C5046bo.isNullOrNil(this.gDU) || C5046bo.isNullOrNil(this.gDV))) {
            this.gDH.setText(this.gDV);
        }
        this.gDX.mo21369a(this);
        if (C5058f.EX_DEVICE_LOGIN) {
            this.gCj.setVisibility(0);
            this.gCj.setOnClickListener(new C4229614());
        }
        this.gDa = getIntent().getBooleanExtra("from_switch_account", false);
        AppMethodBeat.m2505o(125184);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125185);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        this.gDX.start();
        AppMethodBeat.m2505o(125185);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125186);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        this.gDX.stop();
        AppMethodBeat.m2505o(125186);
    }

    public void finish() {
        AppMethodBeat.m2504i(125187);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
        C7060h.pYm.mo8381e(14262, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]));
        AppMethodBeat.m2505o(125187);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125188);
        C6998b.oTO.mo8087TK("ie_reg_eu");
        this.gDJ.reset();
        super.onDestroy();
        AppMethodBeat.m2505o(125188);
    }

    private void apc() {
        AppMethodBeat.m2504i(125189);
        if (C5046bo.isNullOrNil(this.fHE) || C5046bo.isNullOrNil(this.countryCode)) {
            this.gBE = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            C4990ab.m7410d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.gBE);
            if (C5046bo.isNullOrNil(this.gBE)) {
                C4990ab.m7412e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                AppMethodBeat.m2505o(125189);
                return;
            }
            C17951a k = C17950b.m28210k(this, this.gBE, getString(C25738R.string.b3_));
            if (k == null) {
                C4990ab.m7412e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                AppMethodBeat.m2505o(125189);
                return;
            }
            this.countryCode = C5025av.amO(k.fHD);
            this.fHE = k.fHE;
            AppMethodBeat.m2505o(125189);
            return;
        }
        AppMethodBeat.m2505o(125189);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125190);
        this.gCV = (MMFormInputView) findViewById(2131826122);
        this.gBJ = this.gCV.getContentEditText();
        C7357c.m12555d(this.gBJ).mo15877PM(16).mo15879a(null);
        this.gDH = (MMFormInputView) findViewById(2131826121);
        this.gDH.setInputType(3);
        this.gDI = this.gDH.getContentEditText();
        this.gDJ = (MMFormVerifyCodeInputView) findViewById(2131825301);
        this.gDJ.setInputType(3);
        this.grF = (LinearLayout) findViewById(2131821726);
        this.grH = (TextView) findViewById(2131821728);
        this.gDK = findViewById(2131826123);
        this.gDL = (TextView) findViewById(2131826124);
        this.gDM = (Button) findViewById(2131826067);
        this.gDN = (Button) findViewById(2131822846);
        this.gDO = (TextView) findViewById(2131826119);
        this.gDP = (TextView) findViewById(2131821135);
        this.gDQ = (TextView) findViewById(2131826120);
        this.gDR = (Button) findViewById(2131825291);
        this.gCj = (Button) findViewById(2131825293);
        this.gBP = (Button) findViewById(2131825295);
        this.gBQ = (Button) findViewById(2131825297);
        this.gBR = findViewById(2131825296);
        this.gBS = (Button) findViewById(2131825298);
        this.gDS = findViewById(2131826125);
        this.gCa = (ResizeLayout) findViewById(2131825288);
        this.gDb = (MMKeyboardUperView) findViewById(2131820921);
        this.grF.setVisibility(8);
        this.gCV.setVisibility(8);
        this.gDJ.setVisibility(8);
        this.gDH.setVisibility(8);
        this.gDO.setVisibility(8);
        this.gDP.setVisibility(8);
        this.gDN.setVisibility(8);
        this.gDK.setVisibility(8);
        this.gDR.setVisibility(8);
        this.gCa.setOnSizeChanged(new C1889215());
        this.gBP.setOnClickListener(new C1889316());
        this.gBQ.setOnClickListener(new C2662117());
        final C36356d c36356d = new C36356d(this, 1, false);
        c36356d.rBl = new C1889418();
        c36356d.rBm = new C3806819();
        c36356d.zQf = new C202620();
        if (C4988aa.doo()) {
            this.gBS.setOnClickListener(new C99772());
        } else {
            this.gBR.setVisibility(8);
            this.gBS.setText(C25738R.string.co6);
            this.gBS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125162);
                    c36356d.cpD();
                    AppMethodBeat.m2505o(125162);
                }
            });
        }
        final boolean[] zArr = new boolean[]{true};
        this.gDI.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.m2504i(125163);
                if (z) {
                    zArr[0] = true;
                    AppMethodBeat.m2505o(125163);
                    return;
                }
                C6998b.oTO.mo8087TK("ie_reg_eu");
                AppMethodBeat.m2505o(125163);
            }
        });
        this.gDI.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.m2504i(125164);
                MobileInputUI.this.gDN.setEnabled(MobileInputUI.m74808e(MobileInputUI.this));
                AppMethodBeat.m2505o(125164);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.m2504i(125165);
                if (zArr[0]) {
                    zArr[0] = false;
                    C6998b.oTO.mo8085TI("ie_reg_eu");
                }
                C6998b.oTO.mo8086TJ("ie_reg_eu");
                AppMethodBeat.m2505o(125165);
            }
        });
        this.gBJ.addTextChangedListener(new C330056());
        this.gDI.setOnEditorActionListener(new C330067());
        this.gDI.setOnKeyListener(new C330078());
        zArr = new boolean[]{false};
        this.gDN.setEnabled(false);
        this.gDN.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(125169);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr[0] = true;
                        C6998b.oTO.mo8107fu("ce_reg_eu", "<Reg>");
                        break;
                    case 1:
                    case 6:
                        C6998b.oTO.mo8095a("ce_reg_eu", motionEvent);
                        C6998b.oTO.mo8090TN("ce_reg_eu");
                        break;
                }
                AppMethodBeat.m2505o(125169);
                return false;
            }
        });
        this.gDN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(125170);
                if (zArr[0]) {
                    zArr[0] = false;
                } else {
                    C6998b.oTO.mo8107fu("ce_reg_eu", "<Reg>");
                    C6998b.oTO.mo8095a("ce_reg_eu", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, CdnLogic.kBizGeneric));
                    C6998b.oTO.mo8090TN("ce_reg_eu");
                }
                MobileInputUI.m74809f(MobileInputUI.this);
                AppMethodBeat.m2505o(125170);
            }
        });
        if (C5046bo.isNullOrNil(this.countryCode)) {
            this.fHE = getString(C25738R.string.b3b);
            this.countryCode = C5025av.amO(getString(C25738R.string.b3a));
        } else {
            this.fHE = C17950b.m28211l(this, this.countryCode, getString(C25738R.string.b3_));
        }
        apc();
        arf();
        if (C5046bo.isNullOrNil(this.grJ)) {
            this.gDI.setText(this.grJ);
        }
        this.grF.setOnClickListener(new C4229711());
        String str = "";
        if (C7243d.vxr) {
            str = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(str);
        mo17446xE(getResources().getColor(C25738R.color.f12206vy));
        dyb();
        AppMethodBeat.m2505o(125190);
    }

    private void are() {
        AppMethodBeat.m2504i(125191);
        aqX();
        this.gDX.mo21368a(C33008a.GoNext);
        AppMethodBeat.m2505o(125191);
    }

    private void goBack() {
        AppMethodBeat.m2504i(125192);
        if (this.gDY) {
            aqX();
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            C5274b.m8054hM(this);
            AppMethodBeat.m2505o(125192);
            return;
        }
        this.gDX.mo21368a(C33008a.GoBack);
        C42756a.m75796wA(this.gsF);
        aqX();
        finish();
        AppMethodBeat.m2505o(125192);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125193);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(125193);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125193);
        return onKeyDown;
    }

    private void arf() {
        AppMethodBeat.m2504i(125194);
        if (C5046bo.isNullOrNil(this.fHE) || C5046bo.isNullOrNil(this.countryCode)) {
            this.grH.setText(getString(C25738R.string.d03));
            AppMethodBeat.m2505o(125194);
            return;
        }
        this.grH.setText(C5025av.m7485hS(this.fHE, this.countryCode));
        AppMethodBeat.m2505o(125194);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundle = null;
        int i3 = false;
        AppMethodBeat.m2504i(125195);
        super.onActivityResult(i, i2, intent);
        if (i == 32047) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                C7060h.pYm.mo8378a(712, 1, 1, false);
                if (this.gDX instanceof C42308k) {
                    ((C42308k) this.gDX).gDz = 1;
                }
                AppMethodBeat.m2505o(125195);
                return;
            }
            C7060h.pYm.mo8378a(712, 2, 1, false);
            if (this.gDX instanceof C42308k) {
                ((C42308k) this.gDX).gDz = 0;
            }
            this.gDX.mo21368a(C33008a.GoNext);
            AppMethodBeat.m2505o(125195);
        } else if (i == 32046) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i2 == -1 && r0 != null && r0.getString("go_next", "").equals("get_reg_verify_code")) {
                if (this.gDX instanceof C42308k) {
                    ((C42308k) this.gDX).gDz = 2;
                }
                this.gDX.mo21368a(C33008a.GoNext);
            }
            AppMethodBeat.m2505o(125195);
        } else if (i == 32045) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i2 == -1 && bundle != null && bundle.getString("go_next", "").equals("auth_again") && (this.gDX instanceof C42311l)) {
                this.gDX.mo21368a(C33008a.GoNext);
            }
            AppMethodBeat.m2505o(125195);
        } else {
            switch (i2) {
                case -1:
                    if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                        String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                        int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                        String str = "MicroMsg.MobileInputUI";
                        String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
                        if (!C5046bo.isNullOrNil(stringExtra)) {
                            i3 = stringExtra.length();
                        }
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = Integer.valueOf(intExtra);
                        C4990ab.m7411d(str, str2, objArr);
                        if (intExtra == -217) {
                            are();
                            AppMethodBeat.m2505o(125195);
                            return;
                        }
                    }
                    break;
                case 100:
                    this.fHE = C5046bo.m7532bc(intent.getStringExtra("country_name"), "");
                    this.countryCode = C5046bo.m7532bc(intent.getStringExtra("couttry_code"), "");
                    this.gBE = C5046bo.m7532bc(intent.getStringExtra("iso_code"), "");
                    if (this.gDW != 2 || C17950b.m28217sP(this.countryCode)) {
                        arf();
                        AppMethodBeat.m2505o(125195);
                        return;
                    }
                    Intent intent2 = new Intent(this, RegByMobileRegAIOUI.class);
                    intent2.putExtra("couttry_code", this.countryCode);
                    intent2.putExtra("country_name", this.fHE);
                    intent2.putExtra("iso_code", this.gBE);
                    startActivity(intent2);
                    finish();
                    AppMethodBeat.m2505o(125195);
                    return;
            }
            AppMethodBeat.m2505o(125195);
        }
    }

    public void setRequestedOrientation(int i) {
    }

    /* renamed from: R */
    private static void m74803R(Context context, String str) {
        AppMethodBeat.m2504i(125196);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(125196);
    }

    /* renamed from: c */
    static /* synthetic */ void m74806c(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125198);
        View currentFocus = mobileInputUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - mobileInputUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                mobileInputUI.gDb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(125173);
                        MobileInputUI.this.gDb.smoothScrollBy(0, height);
                        AppMethodBeat.m2505o(125173);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(125198);
    }

    /* renamed from: d */
    static /* synthetic */ void m74807d(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125200);
        MobileInputUI.m74803R(mobileInputUI, mobileInputUI.getString(C25738R.string.g0n) + C4988aa.dor());
        AppMethodBeat.m2505o(125200);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m74808e(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125201);
        if (!(mobileInputUI.gDI.getText() == null || C5046bo.isNullOrNil(mobileInputUI.gDI.getText().toString()) || !mobileInputUI.gDT)) {
            if (mobileInputUI.gDW != 2) {
                AppMethodBeat.m2505o(125201);
                return true;
            } else if (!(mobileInputUI.gBJ.getText() == null || C5046bo.isNullOrNil(mobileInputUI.gBJ.getText().toString()))) {
                AppMethodBeat.m2505o(125201);
                return true;
            }
        }
        AppMethodBeat.m2505o(125201);
        return false;
    }
}
