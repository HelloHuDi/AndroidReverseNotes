package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C11970l;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C34189m.C34190a;
import com.tencent.p177mm.plugin.freewifi.C39111g;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14832a;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI */
public class FreeWifiCopyPwdUI extends MMActivity {
    public static int myy = 111;
    private String appId;
    private int cdf;
    private String cuH;
    private C7306ak fbD = new C119844();
    private Intent intent;
    private int mwG;
    private int myA = 2;
    protected TextView myB;
    protected TextView myC;
    protected TextView myD;
    private int myz = 1;
    private String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI$4 */
    class C119844 extends C7306ak {
        C119844() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(20939);
            C20805b c20805b = (C20805b) message.obj;
            if (c20805b.myJ == FreeWifiCopyPwdUI.this.myz) {
                FreeWifiCopyPwdUI.m76650a(FreeWifiCopyPwdUI.this, c20805b.data);
                AppMethodBeat.m2505o(20939);
                return;
            }
            FreeWifiCopyPwdUI.m76652b(FreeWifiCopyPwdUI.this, c20805b.data);
            AppMethodBeat.m2505o(20939);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI$a */
    public static class C20804a {
        public static C20804a myG = new C20804a();
        private int myH;
        String myI;
        String text;

        static {
            AppMethodBeat.m2504i(20941);
            AppMethodBeat.m2505o(20941);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI$b */
    public class C20805b {
        Object data;
        int myJ;

        public C20805b(int i, Object obj) {
            this.myJ = i;
            this.data = obj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI$3 */
    class C280853 implements C34190a {
        C280853() {
        }

        /* renamed from: h */
        public final void mo46010h(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20938);
            FreeWifiCopyPwdUI freeWifiCopyPwdUI;
            FreeWifiCopyPwdUI freeWifiCopyPwdUI2;
            int c;
            C20804a c20804a;
            if (i == 0 && i2 == 0) {
                if (c1207m instanceof C28075a) {
                    C23391gj bzj = ((C28075a) c1207m).bzj();
                    if (bzj != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ, bzj.vIF);
                        FreeWifiCopyPwdUI.m76649a(FreeWifiCopyPwdUI.this, new C20805b(FreeWifiCopyPwdUI.this.myz, bzj));
                        AppMethodBeat.m2505o(20938);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                    freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                    freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                    c = FreeWifiCopyPwdUI.this.myA;
                    c20804a = new C20804a();
                    c20804a.myI = C34189m.m56068a(FreeWifiCopyPwdUI.this.mwG, C11968b.GetBackPageReturn, 21);
                    FreeWifiCopyPwdUI.m76649a(freeWifiCopyPwdUI, new C20805b(c, c20804a));
                    AppMethodBeat.m2505o(20938);
                    return;
                }
                AppMethodBeat.m2505o(20938);
            } else if (!C34189m.m56075eh(i, i2) || C34189m.isEmpty(str)) {
                freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                c = FreeWifiCopyPwdUI.this.myA;
                c20804a = new C20804a();
                c20804a.myI = C34189m.m56068a(FreeWifiCopyPwdUI.this.mwG, C11968b.GetBackPageReturn, i2);
                FreeWifiCopyPwdUI.m76649a(freeWifiCopyPwdUI, new C20805b(c, c20804a));
                AppMethodBeat.m2505o(20938);
            } else {
                freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                c = FreeWifiCopyPwdUI.this.myA;
                c20804a = new C20804a();
                c20804a.text = str;
                c20804a.myI = C34189m.m56068a(FreeWifiCopyPwdUI.this.mwG, C11968b.GetBackPageReturn, i2);
                FreeWifiCopyPwdUI.m76649a(freeWifiCopyPwdUI, new C20805b(c, c20804a));
                AppMethodBeat.m2505o(20938);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI$2 */
    class C391182 implements OnClickListener {
        C391182() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20937);
            FreeWifiCopyPwdUI.this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), FreeWifiCopyPwdUI.myy);
            AppMethodBeat.m2505o(20937);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI$1 */
    class C431141 implements OnMenuItemClickListener {
        C431141() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20936);
            FreeWifiCopyPwdUI.m76648a(FreeWifiCopyPwdUI.this);
            AppMethodBeat.m2505o(20936);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FreeWifiCopyPwdUI() {
        AppMethodBeat.m2504i(20942);
        AppMethodBeat.m2505o(20942);
    }

    /* renamed from: a */
    static /* synthetic */ void m76648a(FreeWifiCopyPwdUI freeWifiCopyPwdUI) {
        AppMethodBeat.m2504i(20947);
        freeWifiCopyPwdUI.goBack();
        AppMethodBeat.m2505o(20947);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20943);
        super.onCreate(bundle);
        setBackBtn(new C431141());
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.cuH = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.cdf = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.mwG = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(2131824120)).setText(this.ssid);
        C14832a.m23084b("wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(2131824124)).setOnClickListener(new C391182());
        this.myB = (TextView) findViewById(2131824121);
        this.myC = (TextView) findViewById(2131824122);
        this.myD = (TextView) findViewById(2131824123);
        String byN = C45957d.byN();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        C7060h.pYm.mo8381e(12651, Integer.valueOf(6), byN, Integer.valueOf(0), stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra));
        AppMethodBeat.m2505o(20943);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(20944);
        if (i == myy && C34189m.byu() && !C5046bo.isNullOrNil(this.ssid) && this.ssid.equals(C45957d.byO())) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)));
            C11967a byo = C11966k.byo();
            byo.ssid = this.ssid;
            byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            byo.cuH = this.cuH;
            byo.mud = this.appId;
            byo.kBq = C34189m.m56063V(this.intent);
            byo.mue = C34189m.m56065X(this.intent);
            byo.muf = C11968b.AddNetwork.muQ;
            byo.mug = C11968b.AddNetwork.name;
            byo.result = 0;
            byo.cIb = C34189m.m56066Y(this.intent);
            byo.byq().byp();
            C34189m.m56070a(this.intent, this.cuH, this.mwG, this.cdf, new C280853(), "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
        }
        AppMethodBeat.m2505o(20944);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(20945);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(20945);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(20945);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(20946);
        C11970l.m19876x(C45957d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        C11967a byo = C11966k.byo();
        byo.cuH = this.cuH;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.muf = C11968b.CopyPwdPageUIClosedByGoBack.muQ;
        byo.mug = C11968b.CopyPwdPageUIClosedByGoBack.name;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.mue = C34189m.m56065X(this.intent);
        byo.result = 0;
        byo.ehr = "";
        byo.byq().mo23810b(this.intent, true).byp();
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.m2505o(20946);
    }

    public final int getLayoutId() {
        return 2130969589;
    }

    /* renamed from: b */
    static /* synthetic */ void m76652b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        AppMethodBeat.m2504i(20950);
        if (obj instanceof C20804a) {
            CharSequence string;
            C20804a c20804a = (C20804a) obj;
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", C34189m.m56063V(freeWifiCopyPwdUI.intent), Integer.valueOf(C34189m.m56064W(freeWifiCopyPwdUI.intent)), c20804a.myI);
            freeWifiCopyPwdUI.myB.setVisibility(0);
            if (C34189m.isEmpty(c20804a.text)) {
                if (c20804a.myH == 0) {
                    c20804a.myH = C25738R.string.bzq;
                }
                string = freeWifiCopyPwdUI.getString(c20804a.myH);
            } else {
                string = c20804a.text;
            }
            freeWifiCopyPwdUI.myB.setText(string);
            freeWifiCopyPwdUI.myB.setVisibility(0);
            freeWifiCopyPwdUI.myC.setVisibility(0);
            freeWifiCopyPwdUI.myD.setVisibility(0);
            final String str = freeWifiCopyPwdUI.getString(C25738R.string.c06) + ": " + c20804a.myI;
            freeWifiCopyPwdUI.myD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(20940);
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiCopyPwdUI.this.getString(C25738R.string.bzp));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiCopyPwdUI.this, FreeWifiErrorUI.class);
                    FreeWifiCopyPwdUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(20940);
                }
            });
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", C34189m.m56063V(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(C34189m.m56064W(freeWifiCopyPwdUI.getIntent())));
        }
        AppMethodBeat.m2505o(20950);
    }
}
