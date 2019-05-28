package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.C5510e.C5498e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C11970l;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C39111g;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p974e.C20784f;
import com.tencent.p177mm.plugin.freewifi.p974e.C20787h;
import com.tencent.p177mm.plugin.freewifi.p974e.C31357g;
import com.tencent.p177mm.plugin.freewifi.p974e.C39102a;
import com.tencent.p177mm.plugin.freewifi.p974e.C43107i;
import com.tencent.p177mm.plugin.freewifi.p974e.C43110j;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI */
public class FreeWifiFrontPageUI extends MMActivity {
    protected int cdf;
    protected String className;
    protected String csB;
    protected String cuH;
    protected int cvd;
    private final C25814c fGS;
    private C7306ak fbD = new C75041();
    protected Intent intent;
    protected String jUg;
    protected int mwG;
    protected String mwH;
    protected TextView myB;
    protected TextView myC;
    protected TextView myD;
    protected ImageView myQ;
    protected TextView myR;
    protected TextView myS;
    protected Button myT;
    protected Button myU;
    protected Dialog myV;
    protected View myW;
    protected String myX;
    protected String myY;
    protected String myZ;
    private boolean myf = true;
    protected String mza;
    protected C39102a mzb;
    private Lock mzc;
    private C28089d mzd;
    protected String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$1 */
    class C75041 extends C7306ak {
        C75041() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(20959);
            C11989c c11989c = (C11989c) message.obj;
            switch (C341953.mzf[c11989c.mzd.ordinal()]) {
                case 1:
                    FreeWifiFrontPageUI.this.bzK();
                    AppMethodBeat.m2505o(20959);
                    return;
                case 2:
                    FreeWifiFrontPageUI.this.bzL();
                    AppMethodBeat.m2505o(20959);
                    return;
                case 3:
                    FreeWifiFrontPageUI.this.mo62020bS(c11989c.data);
                    AppMethodBeat.m2505o(20959);
                    return;
                case 4:
                    FreeWifiFrontPageUI.this.mo62021bT(c11989c.data);
                    break;
            }
            AppMethodBeat.m2505o(20959);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$7 */
    class C119867 implements OnClickListener {
        C119867() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20965);
            C26443d.m42103bX(FreeWifiFrontPageUI.this);
            AppMethodBeat.m2505o(20965);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$9 */
    class C119879 implements OnCancelListener {
        C119879() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(20967);
            C45957d.m85352a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", C34189m.m56063V(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4));
            AppMethodBeat.m2505o(20967);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$b */
    public static class C11988b {
        public C23391gj mzh;
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$c */
    public static class C11989c {
        Object data;
        C28089d mzd;

        public C11989c(C28089d c28089d, Object obj) {
            this.mzd = c28089d;
            this.data = obj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$8 */
    class C280878 implements OnClickListener {
        C280878() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20966);
            C34189m.m56073dU(FreeWifiFrontPageUI.this);
            AppMethodBeat.m2505o(20966);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a */
    public static class C28088a {
        public static C28088a mzg = new C28088a();
        public int myH;
        public String myI;
        public String text;

        static {
            AppMethodBeat.m2504i(20970);
            AppMethodBeat.m2505o(20970);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$d */
    public enum C28089d {
        START,
        CONNECTING,
        FAIL,
        SUCCESS;

        static {
            AppMethodBeat.m2505o(20973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$2 */
    class C341942 implements OnClickListener {
        C341942() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20960);
            FreeWifiFrontPageUI.this.finish();
            AppMethodBeat.m2505o(20960);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$3 */
    static /* synthetic */ class C341953 {
        static final /* synthetic */ int[] mzf = new int[C28089d.values().length];

        static {
            AppMethodBeat.m2504i(20961);
            try {
                mzf[C28089d.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mzf[C28089d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mzf[C28089d.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mzf[C28089d.SUCCESS.ordinal()] = 4;
                AppMethodBeat.m2505o(20961);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(20961);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$4 */
    class C341964 implements OnMenuItemClickListener {
        C341964() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20962);
            FreeWifiFrontPageUI.m66554a(FreeWifiFrontPageUI.this);
            AppMethodBeat.m2505o(20962);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$5 */
    class C341975 implements View.OnClickListener {
        C341975() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20963);
            FreeWifiFrontPageUI.m66556b(FreeWifiFrontPageUI.this);
            AppMethodBeat.m2505o(20963);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$6 */
    class C341986 implements View.OnClickListener {
        C341986() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20964);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", FreeWifiFrontPageUI.this.mza);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiFrontPageUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(20964);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$11 */
    class C3912111 implements OnClickListener {
        C3912111() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(20969);
            FreeWifiFrontPageUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FreeWifiFrontPageUI.this.finish();
            AppMethodBeat.m2505o(20969);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FreeWifiFrontPageUI() {
        AppMethodBeat.m2504i(20974);
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePG = true;
        c17927a.ePT = C25738R.drawable.aee;
        c17927a.eQf = true;
        c17927a.eQg = 0.0f;
        this.fGS = c17927a.ahG();
        AppMethodBeat.m2505o(20974);
    }

    /* renamed from: a */
    static /* synthetic */ void m66554a(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.m2504i(20991);
        freeWifiFrontPageUI.goBack();
        AppMethodBeat.m2505o(20991);
    }

    /* renamed from: b */
    static /* synthetic */ void m66556b(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.m2504i(20992);
        freeWifiFrontPageUI.bzJ();
        AppMethodBeat.m2505o(20992);
    }

    private C28089d bzI() {
        AppMethodBeat.m2504i(20975);
        try {
            this.mzc.lock();
            C28089d c28089d = this.mzd;
            return c28089d;
        } finally {
            this.mzc.unlock();
            AppMethodBeat.m2505o(20975);
        }
    }

    /* renamed from: a */
    public final void mo62019a(C28089d c28089d, Object obj) {
        AppMethodBeat.m2504i(20976);
        try {
            this.mzc.lock();
            this.mzd = c28089d;
            Message obtain = Message.obtain();
            obtain.obj = new C11989c(c28089d, obj);
            this.fbD.sendMessage(obtain);
        } finally {
            this.mzc.unlock();
            AppMethodBeat.m2505o(20976);
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20977);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(20977);
    }

    public final void initView() {
        AppMethodBeat.m2504i(20978);
        setBackBtn(new C341964());
        if (this.myV != null) {
            this.myV.dismiss();
        }
        this.mzc = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.jUg = getIntent().getStringExtra("free_wifi_url");
        this.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        this.cdf = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.mwG = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.csB = getIntent().getStringExtra("free_wifi_appid");
        this.myX = getIntent().getStringExtra("free_wifi_head_img_url");
        this.myY = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.myZ = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.mza = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.className, this.ssid, this.jUg, this.cuH, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), Integer.valueOf(this.mwG), this.csB, this.myX, this.myY, this.mza);
        this.myW = findViewById(2131824137);
        this.myQ = (ImageView) findViewById(2131824129);
        this.myR = (TextView) findViewById(2131824130);
        this.myS = (TextView) findViewById(2131824131);
        this.myB = (TextView) findViewById(2131824132);
        this.myC = (TextView) findViewById(2131824133);
        this.myD = (TextView) findViewById(2131824134);
        this.myT = (Button) findViewById(2131824135);
        this.myT.setOnClickListener(new C341975());
        this.myU = (Button) findViewById(2131824136);
        this.myU.setOnClickListener(new C341986());
        if (C5046bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(C25738R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(C25738R.string.c0t));
        mo62019a(C28089d.START, null);
        AppMethodBeat.m2505o(20978);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        boolean z;
        AppMethodBeat.m2504i(20979);
        super.onResume();
        if (this.myf) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
            if (!C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)) {
                z = false;
                if (z) {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
                    AppMethodBeat.m2505o(20979);
                    return;
                }
                switch (this.mwG) {
                    case 1:
                        this.mzb = new C31357g(this);
                        break;
                    case 4:
                        this.mzb = new C20784f(this);
                        break;
                    case 31:
                        this.mzb = new C20787h(this);
                        this.myW.setVisibility(0);
                        bzJ();
                        break;
                    case 32:
                        this.mzb = new C43110j(this);
                        this.myW.setVisibility(0);
                        break;
                    case 33:
                        this.mzb = new C43107i(this);
                        break;
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.className, this.cuH);
                C11970l.m19874v(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
                AppMethodBeat.m2505o(20979);
                return;
            }
        }
        if (!C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            z = false;
        } else if (C26443d.agA()) {
            z = true;
        } else {
            C30379h.m48445a((Context) this, getString(C25738R.string.c9z), getString(C25738R.string.f9238tz), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C119867(), null);
            z = false;
        }
        if (z) {
        }
    }

    private void bzJ() {
        AppMethodBeat.m2504i(20980);
        C11970l.m19875w(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C28089d bzI = bzI();
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.className, bzI.name());
        if (bzI() == C28089d.START || bzI() == C28089d.FAIL) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(C34189m.byt()));
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.mwG != 33) {
                C30379h.m48432a((Context) this, (int) C25738R.string.bzl, (int) C25738R.string.bzm, new C280878(), null);
                AppMethodBeat.m2505o(20980);
                return;
            }
            this.mzd = C28089d.CONNECTING;
            bzL();
            this.mzb.connect();
        }
        AppMethodBeat.m2505o(20980);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzK() {
        AppMethodBeat.m2504i(20981);
        this.myB.setVisibility(4);
        if (this.mwG == 31) {
            this.myT.setVisibility(8);
        } else {
            this.myT.setVisibility(0);
            this.myT.setText(C25738R.string.atr);
        }
        if (!(C34189m.m56066Y(getIntent()) != 10 || C34189m.isEmpty(C1427q.eth.etR) || C34189m.isEmpty(C1427q.m3045bB(this.mController.ylL)))) {
            this.myT.setText(String.format(getString(C25738R.string.bzn), new Object[]{C1427q.m3045bB(this.mController.ylL)}));
        }
        if (!C5046bo.isNullOrNil(this.myZ)) {
            this.myS.setText(this.myZ);
        } else if (this.mwG == 33) {
            this.myS.setText(getString(C25738R.string.atn) + ": " + this.ssid);
        } else {
            this.myS.setText(getString(C25738R.string.atn));
        }
        if (!C5046bo.isNullOrNil(this.csB)) {
            if (!C5046bo.isNullOrNil(this.mwH)) {
                this.myR.setText(this.mwH);
            }
            if (!C5046bo.isNullOrNil(this.myX)) {
                C32291o.ahp().mo43766a(this.myX, this.myQ, this.fGS);
            }
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
        AppMethodBeat.m2505o(20981);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzL() {
        AppMethodBeat.m2504i(20982);
        this.myB.setVisibility(4);
        this.myC.setVisibility(4);
        this.myD.setVisibility(4);
        this.myT.setText(C25738R.string.ato);
        this.myV = FreeWifiFrontPageUI.m66555b(this.mController.ylL, new C119879());
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
        this.myV.show();
        AppMethodBeat.m2505o(20982);
    }

    /* renamed from: b */
    private static Dialog m66555b(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(20983);
        View inflate = View.inflate(context, 2130969597, null);
        C15532i c15532i = new C15532i(context, C25738R.style.f10936jc);
        c15532i.setCancelable(true);
        c15532i.setContentView(inflate);
        c15532i.setOnCancelListener(onCancelListener);
        AppMethodBeat.m2505o(20983);
        return c15532i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bS */
    public final void mo62020bS(Object obj) {
        AppMethodBeat.m2504i(20984);
        if (obj instanceof C28088a) {
            CharSequence string;
            C28088a c28088a = (C28088a) obj;
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), c28088a.myI);
            if (this.myV != null) {
                this.myV.dismiss();
            }
            this.myB.setVisibility(0);
            if (C34189m.isEmpty(c28088a.text)) {
                if (c28088a.myH == 0) {
                    c28088a.myH = C25738R.string.bzq;
                }
                string = getString(c28088a.myH);
            } else {
                string = c28088a.text;
            }
            this.myB.setText(string);
            this.myB.setVisibility(0);
            this.myC.setVisibility(0);
            this.myD.setVisibility(0);
            final String str = getString(C25738R.string.c06) + ": " + c28088a.myI;
            this.myD.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(20968);
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiFrontPageUI.this.getString(C25738R.string.bzp));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiFrontPageUI.this, FreeWifiErrorUI.class);
                    FreeWifiFrontPageUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(20968);
                }
            });
            this.myT.setVisibility(0);
            this.myT.setText(C25738R.string.c0p);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            AppMethodBeat.m2505o(20984);
            return;
        }
        AppMethodBeat.m2505o(20984);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bT */
    public final void mo62021bT(Object obj) {
        AppMethodBeat.m2504i(20985);
        if (obj instanceof C11988b) {
            C11967a byo;
            C23391gj c23391gj = ((C11988b) obj).mzh;
            if (!(this.mwG == 31 || this.myV == null)) {
                this.myV.dismiss();
            }
            this.myT.setText(C25738R.string.atl);
            this.myT.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", c23391gj.vEn);
            intent.putExtra("free_wifi_app_nickname", c23391gj.jCH);
            intent.putExtra("free_wifi_app_username", c23391gj.jBB);
            intent.putExtra("free_wifi_signature", c23391gj.guQ);
            intent.putExtra("free_wifi_finish_actioncode", c23391gj.vID);
            intent.putExtra("free_wifi_finish_url", c23391gj.vIE);
            intent.putExtra(C5498e.yfW, c23391gj.mAk);
            if (c23391gj.vID == 2) {
                if (C5046bo.isNullOrNil(c23391gj.jBB)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", c23391gj.jBB);
                    C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    C39125d.m66564IF();
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
                    byo = C11966k.byo();
                    byo.cuH = this.cuH;
                    byo.kBq = C34189m.m56063V(intent);
                    byo.muf = C11968b.FrontPageUIClosedByGoContactInfoUI.muQ;
                    byo.mug = C11968b.FrontPageUIClosedByGoContactInfoUI.name;
                    byo.cIb = C34189m.m56066Y(intent);
                    byo.mue = C34189m.m56065X(intent);
                    byo.result = 0;
                    byo.ehr = "";
                    byo.byq().mo23810b(intent, true).byp();
                    AppMethodBeat.m2505o(20985);
                    return;
                }
            } else if (C34189m.isEmpty(c23391gj.vIF)) {
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", c23391gj.vIF);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            byo = C11966k.byo();
            byo.cuH = this.cuH;
            byo.kBq = C34189m.m56063V(intent);
            byo.muf = C11968b.FrontPageUIClosedByGoSuc.muQ;
            byo.mug = C11968b.FrontPageUIClosedByGoSuc.name;
            byo.cIb = C34189m.m56066Y(intent);
            byo.mue = C34189m.m56065X(intent);
            byo.result = 0;
            byo.ehr = "";
            byo.byq().mo23810b(intent, true).byp();
            finish();
            startActivity(intent);
            C39125d.m66564IF();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", C34189m.m56063V(getIntent()), Integer.valueOf(C34189m.m56064W(getIntent())));
            AppMethodBeat.m2505o(20985);
            return;
        }
        AppMethodBeat.m2505o(20985);
    }

    public void finish() {
        AppMethodBeat.m2504i(20986);
        super.finish();
        C11967a byo = C11966k.byo();
        byo.cuH = this.cuH;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.muf = C11968b.FrontPageUIClosed.muQ;
        byo.mug = C11968b.FrontPageUIClosed.name;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.mue = C34189m.m56065X(this.intent);
        byo.result = 0;
        byo.ehr = "";
        byo.byq().mo23810b(this.intent, true).byp();
        AppMethodBeat.m2505o(20986);
    }

    public final int getLayoutId() {
        return 2130969591;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(20987);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(20987);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(20987);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(20988);
        C11970l.m19876x(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C11967a byo = C11966k.byo();
        byo.cuH = this.cuH;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.muf = C11968b.FrontPageUIClosedByGoBack.muQ;
        byo.mug = C11968b.FrontPageUIClosedByGoBack.name;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.mue = C34189m.m56065X(this.intent);
        byo.result = 0;
        byo.ehr = "";
        byo.byq().mo23810b(this.intent, true).byp();
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.m2505o(20988);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20989);
        super.onDestroy();
        C11976j.byZ().release();
        AppMethodBeat.m2505o(20989);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(20990);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(20990);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C3912111(), new C341942());
                    break;
                }
        }
        AppMethodBeat.m2505o(20990);
    }
}
