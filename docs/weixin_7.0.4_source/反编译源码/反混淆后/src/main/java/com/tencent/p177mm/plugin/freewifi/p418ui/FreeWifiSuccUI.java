package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5510e.C5498e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C11970l;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11972i;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI */
public class FreeWifiSuccUI extends MMActivity implements C1202f {
    private String cBb;
    private String csB;
    private Button ixU;
    private CheckBox koj;
    private String mAa;
    private View mAf;
    private TextView mAg;
    private View mAh;
    private TextView mAi;
    private View mAj;
    private int mAk;
    private boolean mAl = false;
    private boolean mAm = false;
    private String mwH;
    private TextView mzS;
    private int mzZ;
    private String signature;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI$1 */
    class C208071 implements OnClickListener {
        C208071() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21085);
            FreeWifiSuccUI.this.finish();
            FreeWifiSuccUI.m76655a(FreeWifiSuccUI.this);
            AppMethodBeat.m2505o(21085);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI$2 */
    class C341992 implements OnClickListener {
        C341992() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21086);
            if (!C5046bo.isNullOrNil(FreeWifiSuccUI.this.cBb)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", FreeWifiSuccUI.this.cBb);
                C25985d.m41467b(FreeWifiSuccUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            AppMethodBeat.m2505o(21086);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI$3 */
    class C391223 implements OnCheckedChangeListener {
        C391223() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(21087);
            if (z) {
                FreeWifiSuccUI.this.mAl = true;
                AppMethodBeat.m2505o(21087);
                return;
            }
            FreeWifiSuccUI.this.mAl = false;
            AppMethodBeat.m2505o(21087);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21089);
        super.onCreate(bundle);
        this.csB = getIntent().getStringExtra("free_wifi_appid");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        this.cBb = getIntent().getStringExtra("free_wifi_app_username");
        this.mzZ = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mAa = getIntent().getStringExtra("free_wifi_finish_url");
        this.mAk = getIntent().getIntExtra(C5498e.yfW, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.csB, this.mwH, this.cBb, Integer.valueOf(this.mzZ), this.mAa, this.signature);
        C11967a byo = C11966k.byo();
        String Mz = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiSuccUI");
        byo.ssid = C5023at.m7474gE(C4996ah.getContext());
        byo.bssid = C5023at.m7475gF(C4996ah.getContext());
        byo.cuI = Mz;
        byo.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        byo.mud = this.csB;
        byo.kBq = C34189m.m56063V(getIntent());
        byo.mue = C34189m.m56065X(getIntent());
        byo.muf = C11968b.GetBackPage.muQ;
        byo.mug = C11968b.GetBackPage.name;
        byo.cIb = C34189m.m56066Y(getIntent());
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.m2505o(21089);
    }

    public void onResume() {
        AppMethodBeat.m2504i(21090);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(21090);
    }

    public void finish() {
        AppMethodBeat.m2504i(21091);
        super.finish();
        bzT();
        AppMethodBeat.m2505o(21091);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21092);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            AppMethodBeat.m2505o(21092);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21092);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(21093);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        C9638aw.m17182Rg().mo14546b(1703, (C1202f) this);
        AppMethodBeat.m2505o(21093);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969599;
    }

    public final void initView() {
        AppMethodBeat.m2504i(21094);
        setMMTitle((int) C25738R.string.c0t);
        mo17427pP(false);
        this.mAf = findViewById(2131824157);
        this.mAg = (TextView) findViewById(2131824159);
        this.koj = (CheckBox) findViewById(2131824160);
        this.mAh = findViewById(2131824161);
        this.mAi = (TextView) findViewById(2131824162);
        this.mAj = findViewById(2131824163);
        this.mzS = (TextView) findViewById(2131824164);
        this.ixU = (Button) findViewById(2131824166);
        this.ixU.setOnClickListener(new C208071());
        if (C5046bo.isNullOrNil(this.csB) || C5046bo.isNullOrNil(this.cBb) || C5046bo.isNullOrNil(this.mwH)) {
            this.mAf.setVisibility(8);
            this.mAh.setVisibility(8);
            this.mAj.setVisibility(8);
        } else if (C1855t.m3913mZ(this.cBb) && C1855t.m3912mY(this.cBb)) {
            C11970l.m19872a(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.mAf.setVisibility(8);
            this.mAh.setVisibility(8);
            this.mAj.setVisibility(0);
            this.mzS.setText(this.mwH);
            this.mAj.setOnClickListener(new C341992());
        } else {
            C11970l.m19872a(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.mAj.setVisibility(8);
            this.mAf.setVisibility(0);
            if (C5046bo.isNullOrNil(this.signature)) {
                this.mAh.setVisibility(8);
                findViewById(2131824158).setBackgroundColor(getResources().getColor(C25738R.color.a69));
            } else {
                this.mAh.setVisibility(0);
                this.mAi.setText(this.signature);
            }
            this.mAg.setText(getString(C25738R.string.c09, new Object[]{this.mwH}));
            if (this.mAk == 1) {
                this.koj.setChecked(true);
                this.mAl = true;
            } else {
                this.koj.setChecked(false);
                this.mAl = false;
            }
            this.koj.setOnCheckedChangeListener(new C391223());
        }
        if (C34189m.m56066Y(getIntent()) == 10) {
            final String str = C1427q.eth.etR;
            if (!(C34189m.isEmpty(str) || C34189m.isEmpty(C1427q.m3045bB(this.mController.ylL)))) {
                Button button = (Button) findViewById(2131824167);
                button.setText(String.format(getString(C25738R.string.c0s), new Object[]{C1427q.m3045bB(this.mController.ylL)}));
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(21088);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        C25985d.m41467b(FreeWifiSuccUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        AppMethodBeat.m2505o(21088);
                    }
                });
                button.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(21094);
    }

    private void bzT() {
        AppMethodBeat.m2504i(21095);
        if (this.mAm) {
            AppMethodBeat.m2505o(21095);
            return;
        }
        this.mAm = true;
        if (!(!this.mAl || C5046bo.isNullOrNil(this.csB) || (C1855t.m3913mZ(this.cBb) && C1855t.m3912mY(this.cBb)))) {
            C9638aw.m17182Rg().mo14539a(1703, (C1202f) this);
            C9638aw.m17182Rg().mo14541a(new C11972i(this.csB, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), C34189m.m56063V(getIntent())), 0);
        }
        C11970l.m19873b(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.mAl);
        AppMethodBeat.m2505o(21095);
    }

    /* renamed from: a */
    static /* synthetic */ void m76655a(FreeWifiSuccUI freeWifiSuccUI) {
        AppMethodBeat.m2504i(21096);
        freeWifiSuccUI.bzT();
        C11967a byo = C11966k.byo();
        String Mz = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiSuccUI");
        byo.ssid = C5023at.m7474gE(C4996ah.getContext());
        byo.bssid = C5023at.m7475gF(C4996ah.getContext());
        byo.cuI = Mz;
        byo.cuH = C34189m.m56067Z(freeWifiSuccUI.getIntent());
        byo.mud = freeWifiSuccUI.csB;
        byo.kBq = C34189m.m56063V(freeWifiSuccUI.getIntent());
        byo.mue = C34189m.m56065X(freeWifiSuccUI.getIntent());
        byo.muf = C11968b.BackpageFinished.muQ;
        byo.mug = C11968b.BackpageFinished.name;
        byo.cIb = C34189m.m56066Y(freeWifiSuccUI.getIntent());
        byo.muh = freeWifiSuccUI.cBb;
        byo.byq().byp();
        if (freeWifiSuccUI.mzZ != 1 || C5046bo.isNullOrNil(freeWifiSuccUI.mAa)) {
            if (!(freeWifiSuccUI.mzZ == 0 || freeWifiSuccUI.mzZ != 3 || C5046bo.isNullOrNil(freeWifiSuccUI.mAa))) {
                ((C42687f) C1720g.m3528K(C42687f.class)).mo68090b(freeWifiSuccUI, freeWifiSuccUI.mAa, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL, null);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to wxa after connect wifi success, url is : %s", freeWifiSuccUI.mAa);
            }
            AppMethodBeat.m2505o(21096);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.mAa).buildUpon().appendQueryParameter("lang", C4988aa.m7402g(freeWifiSuccUI.getSharedPreferences(C4996ah.doA(), 0))).build().toString());
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        C25985d.m41467b((Context) freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        AppMethodBeat.m2505o(21096);
    }
}
