package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.e.g;
import com.tencent.mm.plugin.freewifi.e.h;
import com.tencent.mm.plugin.freewifi.e.i;
import com.tencent.mm.plugin.freewifi.e.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.e;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected int cdf;
    protected String className;
    protected String csB;
    protected String cuH;
    protected int cvd;
    private final com.tencent.mm.at.a.a.c fGS;
    private ak fbD = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(20959);
            c cVar = (c) message.obj;
            switch (AnonymousClass3.mzf[cVar.mzd.ordinal()]) {
                case 1:
                    FreeWifiFrontPageUI.this.bzK();
                    AppMethodBeat.o(20959);
                    return;
                case 2:
                    FreeWifiFrontPageUI.this.bzL();
                    AppMethodBeat.o(20959);
                    return;
                case 3:
                    FreeWifiFrontPageUI.this.bS(cVar.data);
                    AppMethodBeat.o(20959);
                    return;
                case 4:
                    FreeWifiFrontPageUI.this.bT(cVar.data);
                    break;
            }
            AppMethodBeat.o(20959);
        }
    };
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
    protected com.tencent.mm.plugin.freewifi.e.a mzb;
    private Lock mzc;
    private d mzd;
    protected String ssid;

    public static class b {
        public gj mzh;
    }

    public static class c {
        Object data;
        d mzd;

        public c(d dVar, Object obj) {
            this.mzd = dVar;
            this.data = obj;
        }
    }

    public static class a {
        public static a mzg = new a();
        public int myH;
        public String myI;
        public String text;

        static {
            AppMethodBeat.i(20970);
            AppMethodBeat.o(20970);
        }
    }

    public enum d {
        START,
        CONNECTING,
        FAIL,
        SUCCESS;

        static {
            AppMethodBeat.o(20973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] mzf = new int[d.values().length];

        static {
            AppMethodBeat.i(20961);
            try {
                mzf[d.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mzf[d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mzf[d.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mzf[d.SUCCESS.ordinal()] = 4;
                AppMethodBeat.o(20961);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(20961);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiFrontPageUI() {
        AppMethodBeat.i(20974);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePF = true;
        aVar.ePG = true;
        aVar.ePT = R.drawable.aee;
        aVar.eQf = true;
        aVar.eQg = 0.0f;
        this.fGS = aVar.ahG();
        AppMethodBeat.o(20974);
    }

    static /* synthetic */ void a(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.i(20991);
        freeWifiFrontPageUI.goBack();
        AppMethodBeat.o(20991);
    }

    static /* synthetic */ void b(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.i(20992);
        freeWifiFrontPageUI.bzJ();
        AppMethodBeat.o(20992);
    }

    private d bzI() {
        AppMethodBeat.i(20975);
        try {
            this.mzc.lock();
            d dVar = this.mzd;
            return dVar;
        } finally {
            this.mzc.unlock();
            AppMethodBeat.o(20975);
        }
    }

    public final void a(d dVar, Object obj) {
        AppMethodBeat.i(20976);
        try {
            this.mzc.lock();
            this.mzd = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.fbD.sendMessage(obtain);
        } finally {
            this.mzc.unlock();
            AppMethodBeat.o(20976);
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20977);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(20977);
    }

    public final void initView() {
        AppMethodBeat.i(20978);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20962);
                FreeWifiFrontPageUI.a(FreeWifiFrontPageUI.this);
                AppMethodBeat.o(20962);
                return true;
            }
        });
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
        ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.className, this.ssid, this.jUg, this.cuH, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), Integer.valueOf(this.mwG), this.csB, this.myX, this.myY, this.mza);
        this.myW = findViewById(R.id.bw4);
        this.myQ = (ImageView) findViewById(R.id.bvw);
        this.myR = (TextView) findViewById(R.id.bvx);
        this.myS = (TextView) findViewById(R.id.bvy);
        this.myB = (TextView) findViewById(R.id.bvz);
        this.myC = (TextView) findViewById(R.id.bw0);
        this.myD = (TextView) findViewById(R.id.bw1);
        this.myT = (Button) findViewById(R.id.bw2);
        this.myT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20963);
                FreeWifiFrontPageUI.b(FreeWifiFrontPageUI.this);
                AppMethodBeat.o(20963);
            }
        });
        this.myU = (Button) findViewById(R.id.bw3);
        this.myU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20964);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiFrontPageUI.this.mza);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bp.d.b(FreeWifiFrontPageUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(20964);
            }
        });
        if (bo.isNullOrNil(this.ssid)) {
            this.myS.setText(getString(R.string.c0r));
            this.myT.setVisibility(4);
        }
        setMMTitle(getString(R.string.c0t));
        a(d.START, null);
        AppMethodBeat.o(20978);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        boolean z;
        AppMethodBeat.i(20979);
        super.onResume();
        if (this.myf) {
            ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
            if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)) {
                z = false;
                if (z) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "check permission not passed!");
                    AppMethodBeat.o(20979);
                    return;
                }
                switch (this.mwG) {
                    case 1:
                        this.mzb = new g(this);
                        break;
                    case 4:
                        this.mzb = new f(this);
                        break;
                    case 31:
                        this.mzb = new h(this);
                        this.myW.setVisibility(0);
                        bzJ();
                        break;
                    case 32:
                        this.mzb = new j(this);
                        this.myW.setVisibility(0);
                        break;
                    case 33:
                        this.mzb = new i(this);
                        break;
                }
                ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.className, this.cuH);
                l.v(com.tencent.mm.plugin.freewifi.model.d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
                AppMethodBeat.o(20979);
                return;
            }
        }
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            z = false;
        } else if (com.tencent.mm.modelgeo.d.agA()) {
            z = true;
        } else {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.c9z), getString(R.string.tz), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(20965);
                    com.tencent.mm.modelgeo.d.bX(FreeWifiFrontPageUI.this);
                    AppMethodBeat.o(20965);
                }
            }, null);
            z = false;
        }
        if (z) {
        }
    }

    private void bzJ() {
        AppMethodBeat.i(20980);
        l.w(com.tencent.mm.plugin.freewifi.model.d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        d bzI = bzI();
        ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.className, bzI.name());
        if (bzI() == d.START || bzI() == d.FAIL) {
            ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", m.V(getIntent()), Integer.valueOf(m.W(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(m.byt()));
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.mwG != 33) {
                com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.bzl, (int) R.string.bzm, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(20966);
                        m.dU(FreeWifiFrontPageUI.this);
                        AppMethodBeat.o(20966);
                    }
                }, null);
                AppMethodBeat.o(20980);
                return;
            }
            this.mzd = d.CONNECTING;
            bzL();
            this.mzb.connect();
        }
        AppMethodBeat.o(20980);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzK() {
        AppMethodBeat.i(20981);
        this.myB.setVisibility(4);
        if (this.mwG == 31) {
            this.myT.setVisibility(8);
        } else {
            this.myT.setVisibility(0);
            this.myT.setText(R.string.atr);
        }
        if (!(m.Y(getIntent()) != 10 || m.isEmpty(q.eth.etR) || m.isEmpty(q.bB(this.mController.ylL)))) {
            this.myT.setText(String.format(getString(R.string.bzn), new Object[]{q.bB(this.mController.ylL)}));
        }
        if (!bo.isNullOrNil(this.myZ)) {
            this.myS.setText(this.myZ);
        } else if (this.mwG == 33) {
            this.myS.setText(getString(R.string.atn) + ": " + this.ssid);
        } else {
            this.myS.setText(getString(R.string.atn));
        }
        if (!bo.isNullOrNil(this.csB)) {
            if (!bo.isNullOrNil(this.mwH)) {
                this.myR.setText(this.mwH);
            }
            if (!bo.isNullOrNil(this.myX)) {
                o.ahp().a(this.myX, this.myQ, this.fGS);
            }
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
        AppMethodBeat.o(20981);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzL() {
        AppMethodBeat.i(20982);
        this.myB.setVisibility(4);
        this.myC.setVisibility(4);
        this.myD.setVisibility(4);
        this.myT.setText(R.string.ato);
        this.myV = b(this.mController.ylL, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(20967);
                com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
                ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.V(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(m.W(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4));
                AppMethodBeat.o(20967);
            }
        });
        ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
        this.myV.show();
        AppMethodBeat.o(20982);
    }

    private static Dialog b(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.i(20983);
        View inflate = View.inflate(context, R.layout.a0s, null);
        com.tencent.mm.ui.base.i iVar = new com.tencent.mm.ui.base.i(context, R.style.jc);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        AppMethodBeat.o(20983);
        return iVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bS(Object obj) {
        AppMethodBeat.i(20984);
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), aVar.myI);
            if (this.myV != null) {
                this.myV.dismiss();
            }
            this.myB.setVisibility(0);
            if (m.isEmpty(aVar.text)) {
                if (aVar.myH == 0) {
                    aVar.myH = R.string.bzq;
                }
                string = getString(aVar.myH);
            } else {
                string = aVar.text;
            }
            this.myB.setText(string);
            this.myB.setVisibility(0);
            this.myC.setVisibility(0);
            this.myD.setVisibility(0);
            final String str = getString(R.string.c06) + ": " + aVar.myI;
            this.myD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(20968);
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiFrontPageUI.this.getString(R.string.bzp));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiFrontPageUI.this, FreeWifiErrorUI.class);
                    FreeWifiFrontPageUI.this.startActivity(intent);
                    AppMethodBeat.o(20968);
                }
            });
            this.myT.setVisibility(0);
            this.myT.setText(R.string.c0p);
            ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            AppMethodBeat.o(20984);
            return;
        }
        AppMethodBeat.o(20984);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bT(Object obj) {
        AppMethodBeat.i(20985);
        if (obj instanceof b) {
            com.tencent.mm.plugin.freewifi.k.a byo;
            gj gjVar = ((b) obj).mzh;
            if (!(this.mwG == 31 || this.myV == null)) {
                this.myV.dismiss();
            }
            this.myT.setText(R.string.atl);
            this.myT.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", gjVar.vEn);
            intent.putExtra("free_wifi_app_nickname", gjVar.jCH);
            intent.putExtra("free_wifi_app_username", gjVar.jBB);
            intent.putExtra("free_wifi_signature", gjVar.guQ);
            intent.putExtra("free_wifi_finish_actioncode", gjVar.vID);
            intent.putExtra("free_wifi_finish_url", gjVar.vIE);
            intent.putExtra(e.yfW, gjVar.mAk);
            if (gjVar.vID == 2) {
                if (bo.isNullOrNil(gjVar.jBB)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", gjVar.jBB);
                    com.tencent.mm.bp.d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    d.IF();
                    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
                    byo = k.byo();
                    byo.cuH = this.cuH;
                    byo.kBq = m.V(intent);
                    byo.muf = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.muQ;
                    byo.mug = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.name;
                    byo.cIb = m.Y(intent);
                    byo.mue = m.X(intent);
                    byo.result = 0;
                    byo.ehr = "";
                    byo.byq().b(intent, true).byp();
                    AppMethodBeat.o(20985);
                    return;
                }
            } else if (m.isEmpty(gjVar.vIF)) {
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", gjVar.vIF);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            byo = k.byo();
            byo.cuH = this.cuH;
            byo.kBq = m.V(intent);
            byo.muf = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.muQ;
            byo.mug = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.name;
            byo.cIb = m.Y(intent);
            byo.mue = m.X(intent);
            byo.result = 0;
            byo.ehr = "";
            byo.byq().b(intent, true).byp();
            finish();
            startActivity(intent);
            d.IF();
            ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.V(getIntent()), Integer.valueOf(m.W(getIntent())));
            AppMethodBeat.o(20985);
            return;
        }
        AppMethodBeat.o(20985);
    }

    public void finish() {
        AppMethodBeat.i(20986);
        super.finish();
        com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
        byo.cuH = this.cuH;
        byo.kBq = m.V(this.intent);
        byo.muf = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.muQ;
        byo.mug = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.name;
        byo.cIb = m.Y(this.intent);
        byo.mue = m.X(this.intent);
        byo.result = 0;
        byo.ehr = "";
        byo.byq().b(this.intent, true).byp();
        AppMethodBeat.o(20986);
    }

    public final int getLayoutId() {
        return R.layout.a0m;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(20987);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(20987);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(20987);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(20988);
        l.x(com.tencent.mm.plugin.freewifi.model.d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
        byo.cuH = this.cuH;
        byo.kBq = m.V(this.intent);
        byo.muf = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.muQ;
        byo.mug = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.name;
        byo.cIb = m.Y(this.intent);
        byo.mue = m.X(this.intent);
        byo.result = 0;
        byo.ehr = "";
        byo.byq().b(this.intent, true).byp();
        com.tencent.mm.plugin.freewifi.g.gkE.h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.o(20988);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(20989);
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.byZ().release();
        AppMethodBeat.o(20989);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(20990);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(20990);
            return;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(20969);
                            FreeWifiFrontPageUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FreeWifiFrontPageUI.this.finish();
                            AppMethodBeat.o(20969);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(20960);
                            FreeWifiFrontPageUI.this.finish();
                            AppMethodBeat.o(20960);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(20990);
    }
}
