package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5622c;
import com.tencent.p177mm.platformtools.C45475ag;
import com.tencent.p177mm.platformtools.C45476c;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI */
public class MobileVerifyUI extends MMActivity {
    String bCu;
    protected String cFl;
    protected ProgressDialog ehJ = null;
    int fPA;
    private C45476c gCd;
    private int gDW;
    protected boolean gDc = false;
    protected String gDy;
    protected MMFormInputView gEV;
    protected TextView gEW;
    protected TextView gEX;
    protected TextView gEY;
    protected Button gEZ;
    String gEk;
    int gEs;
    protected int gEu;
    protected ScrollView gFa;
    private long gFb = 0;
    private boolean gFc = false;
    private String[] gFd;
    private boolean gFe = false;
    Boolean gFf;
    private int gFg = 30;
    protected boolean gFh = false;
    protected boolean gFi = false;
    protected int gFj = -1;
    private C7703b gFk;
    String gFl;
    protected String gFm;
    protected EditText grL;
    protected TextView grM;
    String gsF;
    SecurityImage gue = null;
    private Timer mTimer;

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$2 */
    class C76952 implements OnClickListener {
        C76952() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$11 */
    class C769611 implements OnKeyListener {
        C769611() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125278);
            if (66 == i && keyEvent.getAction() == 0) {
                MobileVerifyUI.m13730e(MobileVerifyUI.this);
                AppMethodBeat.m2505o(125278);
                return true;
            }
            AppMethodBeat.m2505o(125278);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$4 */
    class C76974 implements OnCancelListener {
        C76974() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$9 */
    class C76989 implements OnMenuItemClickListener {
        C76989() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125276);
            MobileVerifyUI.m13734i(MobileVerifyUI.this);
            AppMethodBeat.m2505o(125276);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$1 */
    class C76991 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$1$1 */
        class C77001 implements Runnable {
            C77001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(125268);
                MobileVerifyUI.this.gFb = MobileVerifyUI.this.gFb - 1;
                if (MobileVerifyUI.this.gFb >= 0) {
                    MobileVerifyUI.this.gEX.setText(MobileVerifyUI.this.getResources().getQuantityString(C25738R.plurals.f9607t, (int) MobileVerifyUI.this.gFb, new Object[]{Integer.valueOf((int) MobileVerifyUI.this.gFb)}));
                    AppMethodBeat.m2505o(125268);
                    return;
                }
                MobileVerifyUI.this.gEX.setVisibility(8);
                MobileVerifyUI.this.gEW.setVisibility(0);
                MobileVerifyUI.m13729d(MobileVerifyUI.this);
                MobileVerifyUI.this.gEW.setEnabled(true);
                MobileVerifyUI.this.gEW.setText(MobileVerifyUI.this.getString(C25738R.string.d0t));
                AppMethodBeat.m2505o(125268);
            }
        }

        C76991() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125269);
            MobileVerifyUI.this.gEX.post(new C77001());
            AppMethodBeat.m2505o(125269);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$3 */
    class C77013 implements OnClickListener {
        C77013() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$12 */
    class C770212 implements OnClickListener {
        C770212() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$b */
    public interface C7703b {
        /* renamed from: a */
        void mo17520a(MobileVerifyUI mobileVerifyUI);

        /* renamed from: a */
        boolean mo17521a(C7711a c7711a);

        void start();

        void stop();
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$10 */
    class C770410 implements OnEditorActionListener {
        C770410() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125277);
            if (i == 6 || i == 5) {
                MobileVerifyUI.m13730e(MobileVerifyUI.this);
                AppMethodBeat.m2505o(125277);
                return true;
            }
            AppMethodBeat.m2505o(125277);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$5 */
    class C77055 implements InputFilter {
        C77055() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(125270);
            CharSequence ad = C5046bo.m7520ad(charSequence);
            AppMethodBeat.m2505o(125270);
            return ad;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$6 */
    class C77066 implements View.OnClickListener {
        C77066() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125271);
            MobileVerifyUI.m13730e(MobileVerifyUI.this);
            AppMethodBeat.m2505o(125271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$7 */
    class C77077 implements TextWatcher {
        C77077() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125272);
            if (C5046bo.isNullOrNil(MobileVerifyUI.this.grL.getText().toString())) {
                MobileVerifyUI.this.grL.setTextSize(15.0f);
                MobileVerifyUI.this.grL.setGravity(16);
            } else {
                MobileVerifyUI.this.grL.setTextSize(24.0f);
                MobileVerifyUI.this.grL.setGravity(16);
            }
            if (MobileVerifyUI.this.grL.getText() == null || MobileVerifyUI.this.grL.getText().toString().length() <= 0) {
                MobileVerifyUI.this.gEZ.setEnabled(false);
                AppMethodBeat.m2505o(125272);
                return;
            }
            MobileVerifyUI.this.gEZ.setEnabled(true);
            AppMethodBeat.m2505o(125272);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$8 */
    class C77088 implements View.OnClickListener {
        private final int gFp = 0;
        private final int gFq = 1;
        private final int gFr = 2;

        /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$8$2 */
        class C77092 implements C5279d {
            C77092() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(125274);
                switch (menuItem.getItemId()) {
                    case 0:
                        MobileVerifyUI.m13732g(MobileVerifyUI.this);
                        AppMethodBeat.m2505o(125274);
                        return;
                    case 1:
                        MobileVerifyUI.this.aqX();
                        if (MobileVerifyUI.this.gDW == 2) {
                            C42756a.m75796wA("R200_500");
                        } else if (MobileVerifyUI.this.gDW == 3) {
                            C42756a.m75796wA("F200_300");
                        }
                        Intent intent = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("bindmcontact_mobile", MobileVerifyUI.this.cFl);
                        bundle.putInt("voice_verify_type", MobileVerifyUI.m13733h(MobileVerifyUI.this));
                        intent.putExtras(bundle);
                        MobileVerifyUI.this.startActivity(intent);
                        break;
                }
                AppMethodBeat.m2505o(125274);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$8$1 */
        class C77101 implements C36073c {
            C77101() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(125273);
                c44273l.mo70068e(0, MobileVerifyUI.this.getString(C25738R.string.d0u));
                if (C17950b.m28214sM(MobileVerifyUI.this.cFl)) {
                    c44273l.mo70068e(1, MobileVerifyUI.this.getString(C25738R.string.a82));
                }
                if (MobileVerifyUI.this.gDW == 2 && MobileVerifyUI.this.gFi) {
                    c44273l.mo70068e(2, MobileVerifyUI.this.getString(C25738R.string.dl9));
                }
                AppMethodBeat.m2505o(125273);
            }
        }

        C77088() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125275);
            C46696j c46696j = new C46696j(MobileVerifyUI.this);
            c46696j.rBl = new C77101();
            c46696j.rBm = new C77092();
            c46696j.cuu();
            AppMethodBeat.m2505o(125275);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileVerifyUI$a */
    protected enum C7711a {
        GoBack,
        GoNext,
        DoSend,
        DoProcessSMS;

        static {
            AppMethodBeat.m2505o(125281);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m13730e(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.m2504i(125297);
        mobileVerifyUI.ari();
        AppMethodBeat.m2505o(125297);
    }

    /* renamed from: g */
    static /* synthetic */ void m13732g(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.m2504i(125298);
        mobileVerifyUI.arj();
        AppMethodBeat.m2505o(125298);
    }

    /* renamed from: i */
    static /* synthetic */ void m13734i(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.m2504i(125299);
        mobileVerifyUI.goBack();
        AppMethodBeat.m2505o(125299);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125282);
        super.onCreate(bundle);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        this.gDW = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.gFl = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.gEk = getIntent().getStringExtra("kintent_password");
        this.bCu = getIntent().getStringExtra("kintent_nickname");
        this.gFf = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.gDc = getIntent().getBooleanExtra("from_deep_link", false);
        this.gDy = getIntent().getStringExtra("regsession_id");
        this.gFm = getIntent().getStringExtra("reg_3d_app_ticket");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        switch (this.gDW) {
            case 2:
                this.gFk = new C26672o();
                if (this.gEk != null && this.gEk.length() >= 8) {
                    this.fPA = 1;
                    break;
                } else {
                    this.fPA = 4;
                    break;
                }
            case 3:
            case 5:
                this.gFk = new C42315m(this.gDW);
                break;
            case 4:
                this.gFk = new C41219n();
                break;
            default:
                C4990ab.m7413e("MicroMsg.MobileVerifyUI", "wrong purpose %s", Integer.valueOf(this.gDW));
                finish();
                AppMethodBeat.m2505o(125282);
                return;
        }
        String string = getString(C25738R.string.a7b);
        if (C7243d.vxr) {
            string = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(string);
        this.gFg = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.gFh = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.gFi = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        this.gsF = C42756a.m75794FP();
        initView();
        this.gFk.mo17520a(this);
        if (this.gFl != null) {
            this.grL.setText(this.gFl);
            ari();
        } else if (this.gDW == 5) {
            this.gFk.mo17521a(C7711a.DoSend);
        }
        this.gCd = new C45476c();
        AppMethodBeat.m2505o(125282);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125283);
        if (this.gCd != null) {
            this.gCd.close();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(125283);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125284);
        super.onResume();
        this.gFk.start();
        AppMethodBeat.m2505o(125284);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125285);
        super.onPause();
        this.gFk.stop();
        AppMethodBeat.m2505o(125285);
    }

    public final int getLayoutId() {
        return 2130970239;
    }

    private void arh() {
        AppMethodBeat.m2504i(125286);
        if (!this.gFc) {
            this.mTimer = new Timer();
            this.gFc = true;
            this.gFb = (long) this.gFg;
            this.mTimer.schedule(new C76991(), 1000, 1000);
        }
        AppMethodBeat.m2505o(125286);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125288);
        C4990ab.m7410d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.cFl);
        this.gEV = (MMFormInputView) findViewById(2131821771);
        this.gEV.setImeOption(5);
        this.gEV.setInputType(3);
        this.grL = this.gEV.getContentEditText();
        this.gEW = (TextView) findViewById(2131826131);
        this.gEX = (TextView) findViewById(2131826132);
        this.grM = (TextView) findViewById(2131821769);
        this.grM.setText(this.cFl);
        this.cFl = C5025av.amN(this.cFl);
        this.gEW.setText(getString(C25738R.string.d0u));
        this.gEY = (TextView) findViewById(2131826130);
        this.gEZ = (Button) findViewById(2131822846);
        this.gFa = (ScrollView) findViewById(2131820741);
        this.gFd = getResources().getStringArray(C25738R.array.f12636ao);
        this.gEY.setText(Html.fromHtml(getString(C25738R.string.dl5)));
        InputFilter[] inputFilterArr = new InputFilter[]{new C77055()};
        this.gEX.setVisibility(0);
        this.gEX.setText(getResources().getQuantityString(C25738R.plurals.f9607t, this.gFg, new Object[]{Integer.valueOf(this.gFg)}));
        arh();
        this.gFe = false;
        this.grL.setFilters(inputFilterArr);
        this.grL.addTextChangedListener(new C5622c(this.grL, null, 12));
        this.gEZ.setOnClickListener(new C77066());
        this.gEZ.setEnabled(false);
        this.grL.setTextSize(15.0f);
        this.grL.addTextChangedListener(new C77077());
        this.gEW.setOnClickListener(new C77088());
        this.gEW.setEnabled(false);
        setBackBtn(new C76989());
        this.grL.setOnEditorActionListener(new C770410());
        this.grL.setOnKeyListener(new C769611());
        AppMethodBeat.m2505o(125288);
    }

    private void ari() {
        AppMethodBeat.m2504i(125289);
        aqX();
        if (this.grL.getText().toString().trim().equals("")) {
            C30379h.m48467g(this, C25738R.string.a7z, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(125289);
            return;
        }
        this.gFk.mo17521a(C7711a.GoNext);
        AppMethodBeat.m2505o(125289);
    }

    private void arj() {
        AppMethodBeat.m2504i(125290);
        this.gFe = false;
        this.gEW.setEnabled(false);
        this.gEX.setVisibility(0);
        this.gEX.setText(getResources().getQuantityString(C25738R.plurals.f9607t, this.gFg, new Object[]{Integer.valueOf(this.gFg)}));
        this.gEW.setVisibility(8);
        arh();
        this.gFk.mo17521a(C7711a.DoSend);
        C30379h.m48465bQ(this, getString(C25738R.string.d06));
        AppMethodBeat.m2505o(125290);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125291);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(125291);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125291);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(125292);
        C42756a.m75796wA(this.gsF);
        if (this.gFk.mo17521a(C7711a.GoBack)) {
            AppMethodBeat.m2505o(125292);
            return;
        }
        finish();
        AppMethodBeat.m2505o(125292);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(125293);
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            C4990ab.m7411d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", stringExtra);
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                arj();
            }
        }
        AppMethodBeat.m2505o(125293);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:13:0x0041, code skipped:
            com.tencent.p177mm.platformtools.C42257z.m74634cu(r8);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(125294);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    public final boolean mo17511j(int i, int i2, String str) {
        AppMethodBeat.m2504i(125294);
        C42124a jY = C42124a.m74268jY(str);
        if (jY != null) {
            jY.mo67668a(this, null, null);
            AppMethodBeat.m2505o(125294);
            return true;
        }
        int i3;
        if (i == 4) {
            switch (i2) {
                case -75:
                    break;
                case -1:
                    if (C1720g.m3540Rg().acS() == 5) {
                        C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                        AppMethodBeat.m2505o(125294);
                        return true;
                    }
                    break;
            }
        }
        switch (i2) {
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                String an;
                C1668a.hold();
                Context context = this.mController.ylL;
                C1720g.m3534RN();
                if (TextUtils.isEmpty(C1668a.m3385QH())) {
                    an = C1338a.m2858an(this.mController.ylL, C25738R.string.cvw);
                } else {
                    C1720g.m3534RN();
                    an = C1668a.m3385QH();
                }
                C30379h.m48439a(context, an, this.mController.ylL.getString(C25738R.string.f9238tz), new C77013(), new C76974());
                i3 = 1;
                break;
            case -43:
                Toast.makeText(this, C25738R.string.a6h, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, C25738R.string.a6j, 0).show();
                i3 = 1;
                break;
            case -36:
                Toast.makeText(this, C25738R.string.a6m, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, C25738R.string.a6k, 0).show();
                i3 = 1;
                break;
            case -33:
                C30379h.m48431a((Context) this, (int) C25738R.string.a7s, (int) C25738R.string.a7y, new C76952());
                i3 = 1;
                break;
            case -32:
                C30379h.m48438a((Context) this, getString(C25738R.string.a7u), "", new C770212());
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 != 0) {
            AppMethodBeat.m2505o(125294);
            return true;
        }
        if (this.gCd.mo73273a(this, new C45475ag(i, i2, str))) {
            AppMethodBeat.m2505o(125294);
            return true;
        }
        AppMethodBeat.m2505o(125294);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dq */
    public final void mo17510dq(boolean z) {
        AppMethodBeat.m2504i(125295);
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(C25738R.string.e8s));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
        AppMethodBeat.m2505o(125295);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(125287);
        if (this.mController.ymc == 1) {
            this.gFa.scrollTo(0, this.gFa.getChildAt(0).getMeasuredHeight() - this.gFa.getMeasuredHeight());
            AppMethodBeat.m2505o(125287);
            return;
        }
        this.gFa.scrollTo(0, 0);
        AppMethodBeat.m2505o(125287);
    }

    /* renamed from: d */
    static /* synthetic */ void m13729d(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.m2504i(125296);
        mobileVerifyUI.gFc = false;
        if (mobileVerifyUI.mTimer != null) {
            mobileVerifyUI.mTimer.cancel();
        }
        AppMethodBeat.m2505o(125296);
    }

    /* renamed from: h */
    static /* synthetic */ int m13733h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.gDW) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }
}
