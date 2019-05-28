package com.tencent.mm.plugin.freewifi.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI extends MMActivity {
    public static int myy = 111;
    private String appId;
    private int cdf;
    private String cuH;
    private ak fbD = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(20939);
            b bVar = (b) message.obj;
            if (bVar.myJ == FreeWifiCopyPwdUI.this.myz) {
                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, bVar.data);
                AppMethodBeat.o(20939);
                return;
            }
            FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, bVar.data);
            AppMethodBeat.o(20939);
        }
    };
    private Intent intent;
    private int mwG;
    private int myA = 2;
    protected TextView myB;
    protected TextView myC;
    protected TextView myD;
    private int myz = 1;
    private String ssid;

    public static class a {
        public static a myG = new a();
        private int myH;
        String myI;
        String text;

        static {
            AppMethodBeat.i(20941);
            AppMethodBeat.o(20941);
        }
    }

    public class b {
        Object data;
        int myJ;

        public b(int i, Object obj) {
            this.myJ = i;
            this.data = obj;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiCopyPwdUI() {
        AppMethodBeat.i(20942);
        AppMethodBeat.o(20942);
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI) {
        AppMethodBeat.i(20947);
        freeWifiCopyPwdUI.goBack();
        AppMethodBeat.o(20947);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20943);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20936);
                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this);
                AppMethodBeat.o(20936);
                return true;
            }
        });
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.cuH = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.cdf = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.mwG = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(R.id.bvn)).setText(this.ssid);
        com.tencent.mm.pluginsdk.f.a.b("wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(R.id.bvr)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20937);
                FreeWifiCopyPwdUI.this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), FreeWifiCopyPwdUI.myy);
                AppMethodBeat.o(20937);
            }
        });
        this.myB = (TextView) findViewById(R.id.bvo);
        this.myC = (TextView) findViewById(R.id.bvp);
        this.myD = (TextView) findViewById(R.id.bvq);
        String byN = d.byN();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        h.pYm.e(12651, Integer.valueOf(6), byN, Integer.valueOf(0), stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra));
        AppMethodBeat.o(20943);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(20944);
        if (i == myy && m.byu() && !bo.isNullOrNil(this.ssid) && this.ssid.equals(d.byO())) {
            ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", m.V(this.intent), Integer.valueOf(m.W(this.intent)));
            com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
            byo.ssid = this.ssid;
            byo.bssid = m.My("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            byo.cuI = m.Mz("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            byo.cuH = this.cuH;
            byo.mud = this.appId;
            byo.kBq = m.V(this.intent);
            byo.mue = m.X(this.intent);
            byo.muf = com.tencent.mm.plugin.freewifi.k.b.AddNetwork.muQ;
            byo.mug = com.tencent.mm.plugin.freewifi.k.b.AddNetwork.name;
            byo.result = 0;
            byo.cIb = m.Y(this.intent);
            byo.byq().byp();
            m.a(this.intent, this.cuH, this.mwG, this.cdf, new com.tencent.mm.plugin.freewifi.m.a() {
                public final void h(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(20938);
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI;
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI2;
                    int c;
                    a aVar;
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                            gj bzj = ((com.tencent.mm.plugin.freewifi.d.a) mVar).bzj();
                            if (bzj != null) {
                                ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ, bzj.vIF);
                                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new b(FreeWifiCopyPwdUI.this.myz, bzj));
                                AppMethodBeat.o(20938);
                                return;
                            }
                            ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                            freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                            freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                            c = FreeWifiCopyPwdUI.this.myA;
                            aVar = new a();
                            aVar.myI = m.a(FreeWifiCopyPwdUI.this.mwG, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, 21);
                            FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(c, aVar));
                            AppMethodBeat.o(20938);
                            return;
                        }
                        AppMethodBeat.o(20938);
                    } else if (!m.eh(i, i2) || m.isEmpty(str)) {
                        freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        c = FreeWifiCopyPwdUI.this.myA;
                        aVar = new a();
                        aVar.myI = m.a(FreeWifiCopyPwdUI.this.mwG, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(c, aVar));
                        AppMethodBeat.o(20938);
                    } else {
                        freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        c = FreeWifiCopyPwdUI.this.myA;
                        aVar = new a();
                        aVar.text = str;
                        aVar.myI = m.a(FreeWifiCopyPwdUI.this.mwG, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(c, aVar));
                        AppMethodBeat.o(20938);
                    }
                }
            }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
        }
        AppMethodBeat.o(20944);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(20945);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(20945);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(20945);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(20946);
        l.x(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
        byo.cuH = this.cuH;
        byo.kBq = m.V(this.intent);
        byo.muf = com.tencent.mm.plugin.freewifi.k.b.CopyPwdPageUIClosedByGoBack.muQ;
        byo.mug = com.tencent.mm.plugin.freewifi.k.b.CopyPwdPageUIClosedByGoBack.name;
        byo.cIb = m.Y(this.intent);
        byo.mue = m.X(this.intent);
        byo.result = 0;
        byo.ehr = "";
        byo.byq().b(this.intent, true).byp();
        g.gkE.h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.o(20946);
    }

    public final int getLayoutId() {
        return R.layout.a0k;
    }

    static /* synthetic */ void b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        AppMethodBeat.i(20950);
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", m.V(freeWifiCopyPwdUI.intent), Integer.valueOf(m.W(freeWifiCopyPwdUI.intent)), aVar.myI);
            freeWifiCopyPwdUI.myB.setVisibility(0);
            if (m.isEmpty(aVar.text)) {
                if (aVar.myH == 0) {
                    aVar.myH = R.string.bzq;
                }
                string = freeWifiCopyPwdUI.getString(aVar.myH);
            } else {
                string = aVar.text;
            }
            freeWifiCopyPwdUI.myB.setText(string);
            freeWifiCopyPwdUI.myB.setVisibility(0);
            freeWifiCopyPwdUI.myC.setVisibility(0);
            freeWifiCopyPwdUI.myD.setVisibility(0);
            final String str = freeWifiCopyPwdUI.getString(R.string.c06) + ": " + aVar.myI;
            freeWifiCopyPwdUI.myD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(20940);
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiCopyPwdUI.this.getString(R.string.bzp));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiCopyPwdUI.this, FreeWifiErrorUI.class);
                    FreeWifiCopyPwdUI.this.startActivity(intent);
                    AppMethodBeat.o(20940);
                }
            });
            ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", m.V(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.W(freeWifiCopyPwdUI.getIntent())));
        }
        AppMethodBeat.o(20950);
    }
}
