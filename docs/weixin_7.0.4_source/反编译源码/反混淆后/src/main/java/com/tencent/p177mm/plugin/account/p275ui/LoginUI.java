package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMClearEditText;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.platformtools.C45475ag;
import com.tencent.p177mm.platformtools.C45476c;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p275ui.ResizeLayout.C33029a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* renamed from: com.tencent.mm.plugin.account.ui.LoginUI */
public class LoginUI extends MMActivity implements C1202f {
    private TextWatcher arx = new C99741();
    private String cOG = "";
    private String cxb = null;
    private ProgressDialog ehJ = null;
    private C4884c gAY = new C996412();
    protected Button gBP;
    protected Button gBQ;
    private View gBR;
    protected Button gBS;
    private C31280f gBT = new C31280f();
    private String gBV;
    private String gBW;
    private MMClearEditText gCS;
    private MMClearEditText gCT;
    private MMFormInputView gCU;
    private MMFormInputView gCV;
    private Button gCW;
    private Button gCX;
    protected View gCY;
    private String gCZ;
    private ResizeLayout gCa;
    private C45476c gCd;
    private Button gCj;
    private boolean gDa;
    private MMKeyboardUperView gDb;
    private boolean gDc = false;
    private final int gDd = 128;
    private String gsF;
    private SecurityImage gue = null;
    private String gzO;
    private int sceneType = 0;

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$16 */
    class C673516 implements C1835a {
        C673516() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(125043);
            if (c1902e == null) {
                AppMethodBeat.m2505o(125043);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(125043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$21 */
    class C995321 implements OnClickListener {
        C995321() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125048);
            LoginUI.m17583S(LoginUI.this, LoginUI.this.getString(C25738R.string.g7k, new Object[]{C4988aa.dor()}));
            AppMethodBeat.m2505o(125048);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$23 */
    class C995423 implements C15994a {
        C995423() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$19 */
    class C995519 implements C33029a {
        C995519() {
        }

        public final void aqZ() {
            AppMethodBeat.m2504i(125046);
            LoginUI.m17586b(LoginUI.this);
            AppMethodBeat.m2505o(125046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$6 */
    class C99566 implements Runnable {
        C99566() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125031);
            LoginUI.m17589e(LoginUI.this);
            AppMethodBeat.m2505o(125031);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$7 */
    class C99577 implements OnEditorActionListener {
        C99577() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125032);
            if (i == 6 || i == 5) {
                LoginUI.m17589e(LoginUI.this);
                AppMethodBeat.m2505o(125032);
                return true;
            }
            AppMethodBeat.m2505o(125032);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$24 */
    class C995924 implements C5279d {
        C995924() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(125050);
            switch (menuItem.getItemId()) {
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    LoginUI.m17587c(LoginUI.this);
                    AppMethodBeat.m2505o(125050);
                    return;
                case ReaderCallback.SHOW_BAR /*5002*/:
                    LoginUI.m17583S(LoginUI.this, LoginUI.this.getString(C25738R.string.gb3) + C4988aa.dor());
                    break;
            }
            AppMethodBeat.m2505o(125050);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$5 */
    class C99605 implements OnClickListener {
        C99605() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125030);
            Intent intent = new Intent(LoginUI.this, MobileInputUI.class);
            int[] iArr = new int[5];
            iArr[0] = 2;
            intent.putExtra("mobile_input_purpose", 1);
            intent.putExtra("kv_report_login_method_data", iArr);
            intent.putExtra("from_switch_account", LoginUI.this.gDa);
            LoginUI.this.startActivity(intent);
            LoginUI.this.finish();
            AppMethodBeat.m2505o(125030);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$8 */
    class C99618 implements OnKeyListener {
        C99618() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125033);
            if (66 == i && keyEvent.getAction() == 0) {
                LoginUI.m17589e(LoginUI.this);
                AppMethodBeat.m2505o(125033);
                return true;
            }
            AppMethodBeat.m2505o(125033);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$11 */
    class C996211 implements DialogInterface.OnClickListener {
        C996211() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125037);
            if (LoginUI.this.gue == null) {
                C4990ab.m7412e("MicroMsg.LoginUI", "secimg is null!");
                AppMethodBeat.m2505o(125037);
                return;
            }
            C4990ab.m7410d("MicroMsg.LoginUI", "imgSid:" + LoginUI.this.gBT.guh + " img len" + LoginUI.this.gBT.gug.length + " " + C1447g.m3075Mq());
            final C1207m c6686q = new C6686q(LoginUI.this.gBT.account, LoginUI.this.gBT.guf, LoginUI.this.gBT.gCL, LoginUI.this.gue.getSecImgCode(), LoginUI.this.gue.getSecImgSid(), LoginUI.this.gue.getSecImgEncryptKey(), 2, "", false, false);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            LoginUI loginUI = LoginUI.this;
            Context context = LoginUI.this;
            LoginUI.this.getString(C25738R.string.f9238tz);
            loginUI.ehJ = C30379h.m48458b(context, LoginUI.this.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125036);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    C1720g.m3540Rg().mo14546b(701, LoginUI.this);
                    C1720g.m3540Rg().mo14546b(252, LoginUI.this);
                    AppMethodBeat.m2505o(125036);
                }
            });
            AppMethodBeat.m2505o(125037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$12 */
    class C996412 extends C4884c<C37745jk> {
        C996412() {
            AppMethodBeat.m2504i(125038);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(125038);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(125039);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(125039);
                return false;
            }
            C4990ab.m7417i("MicroMsg.LoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(125039);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$13 */
    class C996513 implements OnDismissListener {
        C996513() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125040);
            LoginUI.this.gue = null;
            AppMethodBeat.m2505o(125040);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$14 */
    class C996614 implements DialogInterface.OnClickListener {
        C996614() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125041);
            LoginUI.m17596k(LoginUI.this);
            AppMethodBeat.m2505o(125041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$22 */
    class C996722 implements C36073c {
        C996722() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(125049);
            if (c44273l.dzR()) {
                c44273l.mo70072hi(ReaderCallback.HIDDEN_BAR, C25738R.string.g0m);
                c44273l.mo70072hi(ReaderCallback.SHOW_BAR, C25738R.string.g0k);
            }
            AppMethodBeat.m2505o(125049);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$15 */
    class C996815 implements OnCancelListener {
        C996815() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125042);
            LoginUI.m17596k(LoginUI.this);
            AppMethodBeat.m2505o(125042);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$25 */
    class C996925 implements OnClickListener {
        C996925() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125051);
            LoginUI.m17587c(LoginUI.this);
            AppMethodBeat.m2505o(125051);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$9 */
    class C99709 implements OnClickListener {
        C99709() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125034);
            C25985d.m41448H(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginUI.this.overridePendingTransition(C25738R.anim.f8372cd, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(125034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$3 */
    class C99723 implements OnMenuItemClickListener {
        C99723() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125028);
            LoginUI.m17588d(LoginUI.this);
            AppMethodBeat.m2505o(125028);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$4 */
    class C99734 implements OnClickListener {
        C99734() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125029);
            LoginUI.m17589e(LoginUI.this);
            AppMethodBeat.m2505o(125029);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$1 */
    class C99741 implements TextWatcher {
        C99741() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125026);
            LoginUI.m17585a(LoginUI.this);
            AppMethodBeat.m2505o(125026);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginUI$20 */
    class C997520 implements OnClickListener {
        C997520() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125047);
            LoginUI.m17583S(LoginUI.this, LoginUI.this.getString(C25738R.string.g7t) + C4988aa.dor());
            AppMethodBeat.m2505o(125047);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LoginUI() {
        AppMethodBeat.m2504i(125052);
        AppMethodBeat.m2505o(125052);
    }

    /* renamed from: S */
    static /* synthetic */ void m17583S(Context context, String str) {
        AppMethodBeat.m2504i(125068);
        LoginUI.m17582R(context, str);
        AppMethodBeat.m2505o(125068);
    }

    /* renamed from: d */
    static /* synthetic */ void m17588d(LoginUI loginUI) {
        AppMethodBeat.m2504i(125070);
        loginUI.goBack();
        AppMethodBeat.m2505o(125070);
    }

    /* renamed from: e */
    static /* synthetic */ void m17589e(LoginUI loginUI) {
        AppMethodBeat.m2504i(125071);
        loginUI.aqU();
        AppMethodBeat.m2505o(125071);
    }

    public final int getLayoutId() {
        return 2130969949;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125053);
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(this.mController.ylL.getResources().getColor(C25738R.color.f12207vz));
        String str = "";
        if (C7243d.vxr) {
            str = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        this.sceneType = getIntent().getIntExtra("login_type", 0);
        setMMTitle(str);
        mo17446xE(getResources().getColor(C25738R.color.f12206vy));
        dyb();
        C24679a.gkF.mo38846BV();
        this.gsF = C42756a.m75794FP();
        initView();
        this.gCd = new C45476c();
        this.gDa = getIntent().getBooleanExtra("from_switch_account", false);
        this.gCZ = C6665av.fly.mo5292T("login_weixin_username", "");
        if (getIntent().getIntArrayExtra("kv_report_login_method_data") != null) {
            C7060h.pYm.mo8381e(14262, Integer.valueOf(r0[0]), Integer.valueOf(r0[1]), Integer.valueOf(r0[2]), Integer.valueOf(r0[3]), Integer.valueOf(r0[4]));
        }
        AppMethodBeat.m2505o(125053);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125054);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder;
        if (this.sceneType == 0) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L100_100_logout")).append(",1").toString());
            C42756a.m75798wz("L100_100_logout");
            AppMethodBeat.m2505o(125054);
            return;
        }
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L400_100_login,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L400_100_login")).append(",1").toString());
            C42756a.m75798wz("L400_100_login");
        }
        AppMethodBeat.m2505o(125054);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125055);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        StringBuilder stringBuilder;
        if (this.sceneType == 0) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L100_100_logout")).append(",2").toString());
            AppMethodBeat.m2505o(125055);
            return;
        }
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L400_100_login,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L400_100_login")).append(",2").toString());
        }
        AppMethodBeat.m2505o(125055);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125056);
        if (this.gCd != null) {
            this.gCd.close();
        }
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(125056);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125057);
        this.gCU = (MMFormInputView) findViewById(2131825289);
        this.gCV = (MMFormInputView) findViewById(2131825290);
        this.gCS = (MMClearEditText) this.gCU.getContentEditText();
        this.gCT = (MMClearEditText) this.gCV.getContentEditText();
        C7357c.m12555d(this.gCT).mo15877PM(16).mo15879a(null);
        this.gCW = (Button) findViewById(2131825292);
        this.gCW.setEnabled(false);
        this.gCX = (Button) findViewById(2131825291);
        this.gCj = (Button) findViewById(2131825293);
        this.gCY = findViewById(2131825294);
        this.gCY.setVisibility(0);
        this.gBP = (Button) findViewById(2131825295);
        this.gBR = findViewById(2131825296);
        this.gBQ = (Button) findViewById(2131825297);
        this.gBS = (Button) findViewById(2131825298);
        this.gCa = (ResizeLayout) findViewById(2131825288);
        this.gDb = (MMKeyboardUperView) findViewById(2131820921);
        this.gCa.setOnSizeChanged(new C995519());
        this.gBP.setOnClickListener(new C997520());
        this.gBQ.setOnClickListener(new C995321());
        final C36356d c36356d = new C36356d(this, 1, false);
        c36356d.rBl = new C996722();
        c36356d.zQf = new C995423();
        c36356d.rBm = new C995924();
        if (C4988aa.doo()) {
            this.gBS.setOnClickListener(new C996925());
        } else {
            this.gBR.setVisibility(8);
            this.gBS.setText(C25738R.string.co6);
            this.gBS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125027);
                    c36356d.cpD();
                    AppMethodBeat.m2505o(125027);
                }
            });
        }
        setMMTitle("");
        setBackBtn(new C99723(), C1318a.actionbar_icon_close_black);
        this.gCW.setOnClickListener(new C99734());
        this.gCX.setOnClickListener(new C99605());
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!C5046bo.isNullOrNil(this.gzO)) {
            this.gCS.setText(C5046bo.nullAsNil(C31280f.ara()));
            this.gCT.setText(C5046bo.nullAsNil(C31280f.arb()));
            new C7306ak().postDelayed(new C99566(), 500);
        }
        this.gCS.addTextChangedListener(this.arx);
        this.gCT.addTextChangedListener(this.arx);
        this.gCT.setOnEditorActionListener(new C99577());
        this.gCT.setOnKeyListener(new C99618());
        if (C5059g.xyf) {
            C24679a.gkF.mo38871p(this);
        }
        String stringExtra = getIntent().getStringExtra("login_username");
        this.gDc = getIntent().getBooleanExtra("from_deep_link", false);
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gCS.setText(stringExtra);
        }
        if (C5058f.EX_DEVICE_LOGIN) {
            this.gCj.setVisibility(0);
            this.gCj.setOnClickListener(new C99709());
        }
        AppMethodBeat.m2505o(125057);
    }

    /* renamed from: R */
    private static void m17582R(Context context, String str) {
        AppMethodBeat.m2504i(125058);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(125058);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125059);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(125059);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125059);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(125060);
        aqX();
        C42756a.m75796wA(this.gsF);
        C35799p.dhH();
        finish();
        AppMethodBeat.m2505o(125060);
    }

    /* renamed from: j */
    private boolean m17595j(int i, int i2, String str) {
        AppMethodBeat.m2504i(125061);
        if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(125061);
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    C1720g.m3540Rg().mo14539a(701, (C1202f) this);
                    C1720g.m3540Rg().mo14539a(252, (C1202f) this);
                    if (this.gue == null) {
                        this.gue = C15492a.m23811a(this, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new C996211(), null, new C996513(), this.gBT);
                    } else {
                        C4990ab.m7410d("MicroMsg.LoginUI", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + C1447g.m3075Mq());
                        this.gue.mo27573b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                    }
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -205:
                    C4990ab.m7417i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", C5046bo.anv(this.gzO), this.gBW);
                    C31280f.m50502a(this.gBT);
                    C42756a.m75796wA("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.gzO);
                    intent.putExtra("binded_mobile", this.gBV);
                    intent.putExtra("close_safe_device_style", this.gBW);
                    intent.putExtra("from_source", 1);
                    C24679a.gkE.mo38920g((Context) this, intent);
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -140:
                    if (!C5046bo.isNullOrNil(this.cOG)) {
                        C42257z.m74636o(this, str, this.cOG);
                    }
                    AppMethodBeat.m2505o(125061);
                    return true;
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
                    C30379h.m48439a(context, an, this.mController.ylL.getString(C25738R.string.f9238tz), new C996614(), new C996815());
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -75:
                    C42257z.m74634cu(this.mController.ylL);
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -72:
                    C30379h.m48467g(this.mController.ylL, C25738R.string.dmb, C25738R.string.f9238tz);
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -9:
                    C30379h.m48467g(this, C25738R.string.cof, C25738R.string.cog);
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -3:
                    C30379h.m48467g(this, C25738R.string.be9, C25738R.string.cog);
                    AppMethodBeat.m2505o(125061);
                    return true;
                case -1:
                    if (C1720g.m3540Rg().acS() == 5) {
                        C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                        AppMethodBeat.m2505o(125061);
                        return true;
                    }
                    AppMethodBeat.m2505o(125061);
                    return false;
            }
        }
        boolean a = this.gCd.mo73273a(this, new C45475ag(i, i2, str));
        AppMethodBeat.m2505o(125061);
        return a;
    }

    public void onSceneEnd(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(125062);
        C4990ab.m7416i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            int i3;
            C1720g.m3540Rg().mo14546b(252, (C1202f) this);
            C1720g.m3540Rg().mo14546b(701, (C1202f) this);
            this.cOG = ((C6686q) c1207m).ajm();
            this.gBT.guh = ((C6686q) c1207m).ajn();
            this.gBT.gug = ((C6686q) c1207m).ajo();
            this.gBT.gui = ((C6686q) c1207m).ajp();
            this.gBT.gCL = ((C6686q) c1207m).getSecCodeType();
            this.gBT.account = ((C6686q) c1207m).account;
            if (i2 == -205) {
                this.gzO = ((C6686q) c1207m).agh();
                this.gBV = ((C6686q) c1207m).ajq();
                this.gBW = ((C6686q) c1207m).ajt();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                C1720g.m3540Rg().mo14541a(new C6668bk(new C673516()), 0);
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0 || (i == 0 && i2 == 0)) {
                C1668a.unhold();
                C38033l.apX();
                C42257z.m74637vx(this.gBT.account);
                String T = C6665av.fly.mo5292T("login_weixin_username", "");
                C26529w.m42356cm(this);
                if (this.gDa) {
                    C37914bx.fnB.mo60665an(this.gCZ, T);
                    C37914bx.fnB.mo60666g(C1853r.m3846Yz(), C1853r.m3853Zg());
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(9), C37914bx.fnB.aau());
                }
                C42257z.showAddrBookUploadConfirm(this, new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(125044);
                        C4990ab.m7410d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
                        Intent bh = C24679a.gkE.mo38909bh(LoginUI.this);
                        bh.addFlags(67108864);
                        bh.putExtra("kstyle_show_bind_mobile_afterauth", ((C6686q) c1207m).ajr());
                        bh.putExtra("kstyle_bind_wording", ((C6686q) c1207m).ajs());
                        bh.putExtra("kstyle_bind_recommend_show", ((C6686q) c1207m).aju());
                        LoginUI.this.startActivity(bh);
                        LoginUI.this.finish();
                        AppMethodBeat.m2505o(125044);
                    }
                }, false, 2);
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                C1720g.m3534RN();
                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                if (this.gDc) {
                    T = C4996ah.getContext().getSharedPreferences("randomid_prefs", C1448h.m3078Mu()).getString("randomID", "");
                    C7060h.pYm.mo8381e(11930, T, Integer.valueOf(4));
                }
                AppMethodBeat.m2505o(125062);
                return;
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C42257z.m74635f(this, str, 32644);
                AppMethodBeat.m2505o(125062);
                return;
            } else if (i2 == -217) {
                C42257z.m74633a(this, C1948e.m4157a((C6686q) c1207m), i2);
                AppMethodBeat.m2505o(125062);
                return;
            } else if (m17595j(i, i2, str)) {
                AppMethodBeat.m2505o(125062);
                return;
            } else if (i2 == -5) {
                Toast.makeText(this, getString(C25738R.string.cp3), 0).show();
                AppMethodBeat.m2505o(125062);
                return;
            } else {
                C42124a jY = C42124a.m74268jY(str);
                if (jY == null || !jY.mo67668a(this, null, null)) {
                    Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.m2505o(125062);
                    return;
                }
                AppMethodBeat.m2505o(125062);
                return;
            }
        }
        AppMethodBeat.m2505o(125062);
    }

    private void aqU() {
        AppMethodBeat.m2504i(125063);
        this.gBT.account = this.gCS.getText().toString().trim();
        this.gBT.guf = this.gCT.getText().toString();
        if (this.gBT.account.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0w, C25738R.string.cog);
            AppMethodBeat.m2505o(125063);
        } else if (this.gBT.guf.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0s, C25738R.string.cog);
            AppMethodBeat.m2505o(125063);
        } else {
            aqX();
            C1720g.m3540Rg().mo14539a(252, (C1202f) this);
            C1720g.m3540Rg().mo14539a(701, (C1202f) this);
            final C1207m c6686q = new C6686q(this.gBT.account, this.gBT.guf, this.gzO, 2);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125045);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    C1720g.m3540Rg().mo14546b(252, LoginUI.this);
                    C1720g.m3540Rg().mo14546b(701, LoginUI.this);
                    AppMethodBeat.m2505o(125045);
                }
            });
            AppMethodBeat.m2505o(125063);
        }
    }

    public void finish() {
        AppMethodBeat.m2504i(125064);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(125064);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(125065);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7411d(str, str2, objArr);
        if (i2 == -1) {
            if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                str2 = "MicroMsg.LoginUI";
                String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                Object[] objArr2 = new Object[3];
                objArr2[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr2[1] = Integer.valueOf(i3);
                objArr2[2] = Integer.valueOf(intExtra);
                C4990ab.m7411d(str2, str3, objArr2);
                if (intExtra == -217) {
                    this.gBT.guf = stringExtra;
                    aqU();
                    AppMethodBeat.m2505o(125065);
                    return;
                }
                AppMethodBeat.m2505o(125065);
                return;
            } else if (i == 32644 && intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                    aqU();
                }
            }
        }
        AppMethodBeat.m2505o(125065);
    }

    /* renamed from: a */
    static /* synthetic */ void m17585a(LoginUI loginUI) {
        AppMethodBeat.m2504i(125066);
        if (C5046bo.isNullOrNil(loginUI.gCS.getText().toString()) || C5046bo.isNullOrNil(loginUI.gCT.getText().toString())) {
            loginUI.gCW.setEnabled(false);
            AppMethodBeat.m2505o(125066);
            return;
        }
        loginUI.gCW.setEnabled(true);
        AppMethodBeat.m2505o(125066);
    }

    /* renamed from: b */
    static /* synthetic */ void m17586b(LoginUI loginUI) {
        AppMethodBeat.m2504i(125067);
        View currentFocus = loginUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - loginUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                loginUI.gDb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(125035);
                        LoginUI.this.gDb.smoothScrollBy(0, height);
                        AppMethodBeat.m2505o(125035);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(125067);
    }

    /* renamed from: c */
    static /* synthetic */ void m17587c(LoginUI loginUI) {
        AppMethodBeat.m2504i(125069);
        LoginUI.m17582R(loginUI, loginUI.getString(C25738R.string.g0n) + C4988aa.dor());
        AppMethodBeat.m2505o(125069);
    }

    /* renamed from: k */
    static /* synthetic */ void m17596k(LoginUI loginUI) {
        AppMethodBeat.m2504i(125072);
        C1720g.m3537RQ().mo5257lL("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        C24679a.gkE.mo38931p(intent, loginUI);
        AppMethodBeat.m2505o(125072);
    }
}
