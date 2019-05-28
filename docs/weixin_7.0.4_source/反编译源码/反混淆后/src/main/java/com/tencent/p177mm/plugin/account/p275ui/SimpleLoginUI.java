package com.tencent.p177mm.plugin.account.p275ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMClearEditText;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.model.C42284c;
import com.tencent.p177mm.plugin.account.model.C42284c.C26602a;
import com.tencent.p177mm.plugin.account.model.C42284c.C422831;
import com.tencent.p177mm.plugin.account.p275ui.ResizeLayout.C33029a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C14887t;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C46495w;
import com.tencent.p177mm.pluginsdk.model.app.C46495w.C23248a;
import com.tencent.p177mm.pluginsdk.model.app.C46495w.C440601;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.xlog.app.XLogSetup;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI */
public class SimpleLoginUI extends MMWizardActivity implements C1202f {
    private TextWatcher arx = new C189561();
    private String cOG = "";
    private ProgressDialog ehJ = null;
    private C4884c gAY = new C1895312();
    private C31280f gBT = new C31280f();
    private String gBV;
    private String gBW;
    private MMClearEditText gCS;
    private MMClearEditText gCT;
    private MMFormInputView gCU;
    private MMFormInputView gCV;
    private Button gCW;
    private ResizeLayout gCa;
    private MMKeyboardUperView gDb;
    private SecurityImage gue = null;
    private String gzO;

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$6 */
    class C100006 implements OnClickListener {
        C100006() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125602);
            C4990ab.m7410d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.this.gBT.guh + " img len" + SimpleLoginUI.this.gBT.gug.length + " " + C1447g.m3075Mq());
            final C1207m c6686q = new C6686q(SimpleLoginUI.this.gBT.account, SimpleLoginUI.this.gBT.guf, SimpleLoginUI.this.gBT.gCL, SimpleLoginUI.this.gue.getSecImgCode(), SimpleLoginUI.this.gue.getSecImgSid(), SimpleLoginUI.this.gue.getSecImgEncryptKey(), 0, "", false, false);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            SimpleLoginUI simpleLoginUI = SimpleLoginUI.this;
            Context context = SimpleLoginUI.this;
            SimpleLoginUI.this.getString(C25738R.string.f9238tz);
            simpleLoginUI.ehJ = C30379h.m48458b(context, SimpleLoginUI.this.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125601);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(125601);
                }
            });
            AppMethodBeat.m2505o(125602);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$7 */
    class C100017 implements OnDismissListener {
        C100017() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125603);
            SimpleLoginUI.this.gue = null;
            AppMethodBeat.m2505o(125603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$9 */
    class C100029 implements OnCancelListener {
        C100029() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$15 */
    class C1893915 implements OnTouchListener {
        C1893915() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(125611);
            SimpleLoginUI.this.gCT.setFocusableInTouchMode(true);
            SimpleLoginUI.this.gCS.setFocusableInTouchMode(false);
            boolean onTouch = SimpleLoginUI.this.gCT.getDefaultOnTouchListener().onTouch(view, motionEvent);
            AppMethodBeat.m2505o(125611);
            return onTouch;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$16 */
    class C1894016 implements OnEditorActionListener {
        C1894016() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125612);
            if (i == 6 || i == 5) {
                SimpleLoginUI.m29530b(SimpleLoginUI.this);
                AppMethodBeat.m2505o(125612);
                return true;
            }
            AppMethodBeat.m2505o(125612);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$14 */
    class C1894114 implements OnTouchListener {
        C1894114() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(125610);
            SimpleLoginUI.this.gCS.setFocusableInTouchMode(true);
            boolean onTouch = SimpleLoginUI.this.gCS.getDefaultOnTouchListener().onTouch(view, motionEvent);
            AppMethodBeat.m2505o(125610);
            return onTouch;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$17 */
    class C1894217 implements OnKeyListener {
        C1894217() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125613);
            if (66 == i && keyEvent.getAction() == 0) {
                SimpleLoginUI.m29530b(SimpleLoginUI.this);
                AppMethodBeat.m2505o(125613);
                return true;
            }
            AppMethodBeat.m2505o(125613);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$8 */
    class C189438 implements OnClickListener {
        C189438() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$3 */
    class C189443 implements Runnable {
        C189443() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125598);
            SimpleLoginUI.m29530b(SimpleLoginUI.this);
            AppMethodBeat.m2505o(125598);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$4 */
    class C189454 implements View.OnClickListener {
        C189454() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125599);
            SimpleLoginUI.m29530b(SimpleLoginUI.this);
            AppMethodBeat.m2505o(125599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$18 */
    class C1894718 implements C33029a {

        /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$18$1 */
        class C189481 implements Runnable {
            C189481() {
            }

            public final void run() {
                AppMethodBeat.m2504i(125614);
                SimpleLoginUI.this.gDb.fullScroll(130);
                AppMethodBeat.m2505o(125614);
            }
        }

        C1894718() {
        }

        public final void aqZ() {
            AppMethodBeat.m2504i(125615);
            SimpleLoginUI.this.gDb.post(new C189481());
            AppMethodBeat.m2505o(125615);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$2 */
    class C189492 implements OnMenuItemClickListener {
        C189492() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125597);
            SimpleLoginUI.m29534f(SimpleLoginUI.this);
            AppMethodBeat.m2505o(125597);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$10 */
    class C1895010 implements C1835a {
        C1895010() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(125604);
            if (c1902e == null) {
                AppMethodBeat.m2505o(125604);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(125604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$11 */
    class C1895111 implements C26602a {

        /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$11$1 */
        class C189521 implements C23248a {
            C189521() {
            }

            public final void arL() {
                AppMethodBeat.m2504i(125605);
                SimpleLoginUI.this.finish();
                AppMethodBeat.m2505o(125605);
            }
        }

        C1895111() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void aqC() {
            LinkedList linkedList;
            LinkedList linkedList2;
            Iterator it;
            LinkedList linkedList3 = null;
            AppMethodBeat.m2504i(125606);
            C14887t c46495w = new C46495w(SimpleLoginUI.this, new C189521());
            SharedPreferences doB = C4996ah.doB();
            if (doB != null) {
                String string = doB.getString("key_app_ids_registion_while_not_login", "");
                if (C5046bo.isNullOrNil(string)) {
                    C4990ab.m7416i("MicroMsg.AppUtil", "no saved appids while not login");
                } else {
                    String[] split = string.split("\\|");
                    if (split != null && split.length > 0) {
                        linkedList = new LinkedList();
                        int i = 1;
                        for (String str : split) {
                            if (!C5046bo.isNullOrNil(str)) {
                                linkedList.add(str);
                                i++;
                            }
                            if (i > 5) {
                                break;
                            }
                        }
                        linkedList2 = linkedList;
                        if (!(linkedList2 == null || linkedList2.isEmpty())) {
                            linkedList = new LinkedList();
                            it = linkedList2.iterator();
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                C40439f bT = C46494g.m87739bT(str2, false);
                                if (bT == null || bT.field_status == 0) {
                                    linkedList.add(str2);
                                }
                            }
                            linkedList3 = linkedList;
                        }
                        if (linkedList3 != null || linkedList3.isEmpty()) {
                            C4990ab.m7416i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
                            C35799p.dhI();
                            if (c46495w.vcm != null) {
                                c46495w.vcm.arL();
                            }
                            AppMethodBeat.m2505o(125606);
                        }
                        C4990ab.m7417i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", Integer.valueOf(linkedList3.size()));
                        C34832a.bYM().mo27202a(7, c46495w);
                        C34832a.bYI().mo65992aC(linkedList3);
                        if (c46495w.mContext == null || ((Activity) c46495w.mContext).isFinishing()) {
                            if (c46495w.vcm != null) {
                                c46495w.vcm.arL();
                            }
                            C4990ab.m7412e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
                            AppMethodBeat.m2505o(125606);
                            return;
                        }
                        Context context = c46495w.mContext;
                        c46495w.mContext.getString(C25738R.string.f9238tz);
                        c46495w.tipDialog = C30379h.m48458b(context, c46495w.mContext.getString(C25738R.string.f9260un), true, new C440601());
                        AppMethodBeat.m2505o(125606);
                        return;
                    }
                }
            }
            linkedList2 = null;
            linkedList = new LinkedList();
            it = linkedList2.iterator();
            while (it.hasNext()) {
            }
            linkedList3 = linkedList;
            if (linkedList3 != null) {
            }
            C4990ab.m7416i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
            C35799p.dhI();
            if (c46495w.vcm != null) {
            }
            AppMethodBeat.m2505o(125606);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$12 */
    class C1895312 extends C4884c<C37745jk> {
        C1895312() {
            AppMethodBeat.m2504i(125607);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(125607);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(125608);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(125608);
                return false;
            }
            C4990ab.m7417i("MicroMsg.SimpleLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(125608);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$13 */
    class C1895413 implements Runnable {
        C1895413() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125609);
            SimpleLoginUI.m29530b(SimpleLoginUI.this);
            AppMethodBeat.m2505o(125609);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$19 */
    class C1895519 implements OnTouchListener {
        C1895519() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(125616);
            SimpleLoginUI.this.aqX();
            AppMethodBeat.m2505o(125616);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SimpleLoginUI$1 */
    class C189561 implements TextWatcher {
        C189561() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125596);
            SimpleLoginUI.m29529a(SimpleLoginUI.this);
            AppMethodBeat.m2505o(125596);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SimpleLoginUI() {
        AppMethodBeat.m2504i(125617);
        AppMethodBeat.m2505o(125617);
    }

    /* renamed from: b */
    static /* synthetic */ void m29530b(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.m2504i(125630);
        simpleLoginUI.aqU();
        AppMethodBeat.m2505o(125630);
    }

    /* renamed from: f */
    static /* synthetic */ void m29534f(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.m2504i(125631);
        simpleLoginUI.aoZ();
        AppMethodBeat.m2505o(125631);
    }

    public final int getLayoutId() {
        return 2130969949;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125618);
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", C1448h.m3078Mu());
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        setMMTitle((int) C25738R.string.f9176ru);
        if (C24679a.gkF != null) {
            C24679a.gkF.mo38846BV();
        }
        initView();
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        if (!C35805b.m58708ai(this)) {
            new Intent().addFlags(67108864);
            C24679a.gkE.mo38931p(new Intent(), this);
        }
        AppMethodBeat.m2505o(125618);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125619);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        AppMethodBeat.m2505o(125619);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125620);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(125620);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(125621);
        super.onNewIntent(intent);
        this.gzO = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.gzO = extras.getString("auth_ticket");
        }
        if (!C5046bo.isNullOrNil(this.gzO)) {
            this.gCS.setText(C5046bo.nullAsNil(C31280f.ara()));
            this.gCT.setText(C5046bo.nullAsNil(C31280f.arb()));
            new C7306ak().postDelayed(new C1895413(), 500);
        }
        AppMethodBeat.m2505o(125621);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125622);
        this.gCU = (MMFormInputView) findViewById(2131825289);
        this.gCV = (MMFormInputView) findViewById(2131825290);
        this.gCS = (MMClearEditText) this.gCU.getContentEditText();
        this.gCS.setFocusableInTouchMode(false);
        this.gCS.setOnTouchListener(new C1894114());
        this.gCT = (MMClearEditText) this.gCV.getContentEditText();
        this.gCT.setFocusableInTouchMode(false);
        this.gCT.setOnTouchListener(new C1893915());
        C7357c.m12555d(this.gCT).mo15877PM(16).mo15879a(null);
        this.gCW = (Button) findViewById(2131825292);
        this.gCW.setEnabled(false);
        this.gCS.addTextChangedListener(this.arx);
        this.gCT.addTextChangedListener(this.arx);
        this.gCT.setOnEditorActionListener(new C1894016());
        this.gCT.setOnKeyListener(new C1894217());
        this.gCa = (ResizeLayout) findViewById(2131825288);
        this.gDb = (MMKeyboardUperView) findViewById(2131820921);
        this.gCa.setOnSizeChanged(new C1894718());
        this.gDb.setOnTouchListener(new C1895519());
        findViewById(2131825291).setVisibility(8);
        setMMTitle((int) C25738R.string.cp0);
        setBackBtn(new C189492());
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!C5046bo.isNullOrNil(this.gzO)) {
            this.gCS.setText(C5046bo.nullAsNil(C31280f.ara()));
            this.gCT.setText(C5046bo.nullAsNil(C31280f.arb()));
            new C7306ak().postDelayed(new C189443(), 500);
        }
        if (C5059g.xyf) {
            C24679a.gkF.mo38871p(this);
        }
        this.gCW.setOnClickListener(new C189454());
        AppMethodBeat.m2505o(125622);
    }

    private void aoZ() {
        AppMethodBeat.m2504i(125623);
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        mo27541Ni(1);
        if (booleanExtra) {
            exit(1);
        }
        AppMethodBeat.m2505o(125623);
    }

    private void aqU() {
        AppMethodBeat.m2504i(125624);
        this.gBT.account = this.gCS.getText().toString().trim();
        this.gBT.guf = this.gCT.getText().toString();
        if (this.gBT.account.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0w, C25738R.string.cog);
            AppMethodBeat.m2505o(125624);
        } else if (this.gBT.guf.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0s, C25738R.string.cog);
            AppMethodBeat.m2505o(125624);
        } else {
            aqX();
            final C1207m c6686q = new C6686q(this.gBT.account, this.gBT.guf, this.gzO, 0);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125600);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(125600);
                }
            });
            AppMethodBeat.m2505o(125624);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125625);
        if (i == 4) {
            aoZ();
            AppMethodBeat.m2505o(125625);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125625);
        return onKeyDown;
    }

    public void onPause() {
        AppMethodBeat.m2504i(125626);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        AppMethodBeat.m2505o(125626);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        Object obj;
        C1202f c42284c;
        AppMethodBeat.m2504i(125627);
        C4990ab.m7416i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        C4990ab.m7410d("MicroMsg.SimpleLoginUI", "Scene Type " + c1207m.getType());
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        this.cOG = ((C6686q) c1207m).ajm();
        if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            this.gBT.gCL = ((C6686q) c1207m).getSecCodeType();
            this.gBT.guh = ((C6686q) c1207m).ajn();
            this.gBT.gug = ((C6686q) c1207m).ajo();
            this.gBT.gui = ((C6686q) c1207m).ajp();
            if (i2 == -205) {
                this.gzO = ((C6686q) c1207m).agh();
                this.gBV = ((C6686q) c1207m).ajq();
                this.gBW = ((C6686q) c1207m).ajt();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                obj = 1;
                C1720g.m3540Rg().mo14541a(new C6668bk(new C1895010()), 0);
                if (obj == null || (i == 0 && i2 == 0)) {
                    C1668a.unhold();
                    C26529w.m42356cm(this);
                    C42257z.m74637vx(this.gBT.account);
                    c42284c = new C42284c(this.mController.ylL, new C1895111());
                    c42284c.cwn = C24679a.gkF.mo38852a((C32231g) c42284c);
                    if (c42284c.cwn != null) {
                        if (c42284c.gyH != null) {
                            c42284c.gyH.aqC();
                        }
                        AppMethodBeat.m2505o(125627);
                        return;
                    }
                    if (c42284c.cwn.getType() == C33333a.CTRL_INDEX) {
                        C1720g.m3540Rg().mo14539a((int) C33333a.CTRL_INDEX, c42284c);
                    } else if (c42284c.cwn.getType() == 138) {
                        C1720g.m3540Rg().mo14539a(138, c42284c);
                    }
                    C1720g.m3540Rg().mo14541a(c42284c.cwn, 0);
                    Context context = c42284c.context;
                    c42284c.context.getString(C25738R.string.f9238tz);
                    c42284c.tipDialog = C30379h.m48458b(context, c42284c.context.getString(C25738R.string.f9161re), true, new C422831());
                    AppMethodBeat.m2505o(125627);
                    return;
                } else if (i2 == -217) {
                    C42257z.m74633a(this, C1948e.m4157a((C6686q) c1207m), i2);
                    AppMethodBeat.m2505o(125627);
                    return;
                } else {
                    if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
                        obj = 1;
                    } else {
                        if (i == 4) {
                            switch (i2) {
                                case -311:
                                case -310:
                                case -6:
                                    if (this.gue == null) {
                                        this.gue = C15492a.m23811a(this.mController.ylL, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new C100006(), null, new C100017(), this.gBT);
                                    } else {
                                        C4990ab.m7410d("MicroMsg.SimpleLoginUI", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + C1447g.m3075Mq());
                                        this.gue.mo27573b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                                    }
                                    obj = 1;
                                    break;
                                case -205:
                                    C4990ab.m7417i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", C5046bo.anv(this.gzO), this.gBW);
                                    C31280f.m50502a(this.gBT);
                                    Intent intent = new Intent();
                                    intent.putExtra("auth_ticket", this.gzO);
                                    intent.putExtra("binded_mobile", this.gBV);
                                    intent.putExtra("close_safe_device_style", this.gBW);
                                    intent.putExtra("from_source", 3);
                                    C24679a.gkE.mo38920g((Context) this, intent);
                                    obj = 1;
                                    break;
                                case -140:
                                    if (!C5046bo.isNullOrNil(this.cOG)) {
                                        C42257z.m74636o(this, str, this.cOG);
                                    }
                                    obj = 1;
                                    break;
                                case ZipJNI.UNZ_ERR_OPEN_WRITE /*-106*/:
                                    C42257z.m74635f(this, str, 0);
                                    obj = 1;
                                    break;
                                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                                    C1668a.hold();
                                    C1720g.m3534RN();
                                    C30379h.m48439a((Context) this, C1668a.m3385QH(), getString(C25738R.string.f9238tz), new C189438(), new C100029());
                                    obj = 1;
                                    break;
                                case -75:
                                    C42257z.m74634cu(this.mController.ylL);
                                    obj = 1;
                                    break;
                                case -72:
                                    C30379h.m48467g(this.mController.ylL, C25738R.string.dmb, C25738R.string.f9238tz);
                                    obj = 1;
                                    break;
                                case -30:
                                case -4:
                                case -3:
                                    C30379h.m48467g(this, C25738R.string.be9, C25738R.string.cog);
                                    obj = 1;
                                    break;
                                case -9:
                                    C30379h.m48467g(this, C25738R.string.cof, C25738R.string.cog);
                                    obj = 1;
                                    break;
                                case -1:
                                    if (C1720g.m3540Rg().acS() == 5) {
                                        C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                                        obj = 1;
                                        break;
                                    }
                            }
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        AppMethodBeat.m2505o(125627);
                        return;
                    }
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY == null || !jY.mo67668a(this, null, null)) {
                        Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        AppMethodBeat.m2505o(125627);
                        return;
                    }
                    AppMethodBeat.m2505o(125627);
                    return;
                }
            }
        }
        obj = null;
        if (obj == null) {
        }
        C1668a.unhold();
        C26529w.m42356cm(this);
        C42257z.m74637vx(this.gBT.account);
        c42284c = new C42284c(this.mController.ylL, new C1895111());
        c42284c.cwn = C24679a.gkF.mo38852a((C32231g) c42284c);
        if (c42284c.cwn != null) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(125628);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7411d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
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
                aqU();
                AppMethodBeat.m2505o(125628);
                return;
            }
        }
        AppMethodBeat.m2505o(125628);
    }

    /* renamed from: a */
    static /* synthetic */ void m29529a(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.m2504i(125629);
        if (C5046bo.isNullOrNil(simpleLoginUI.gCS.getText().toString()) || C5046bo.isNullOrNil(simpleLoginUI.gCT.getText().toString())) {
            simpleLoginUI.gCW.setEnabled(false);
            AppMethodBeat.m2505o(125629);
            return;
        }
        simpleLoginUI.gCW.setEnabled(true);
        AppMethodBeat.m2505o(125629);
    }
}
