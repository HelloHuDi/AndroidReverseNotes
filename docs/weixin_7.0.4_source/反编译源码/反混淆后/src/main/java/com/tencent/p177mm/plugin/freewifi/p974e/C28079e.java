package com.tencent.p177mm.plugin.freewifi.p974e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.freewifi.e.e */
public class C28079e {
    protected String appId = this.intent.getStringExtra("free_wifi_appid");
    protected int cdf = this.intent.getIntExtra("free_wifi_channel_id", 0);
    protected String cuH = this.intent.getStringExtra("free_wifi_ap_key");
    protected int cvd = this.intent.getIntExtra("free_wifi_source", 1);
    protected final Intent intent;
    protected String jUg = this.intent.getStringExtra("free_wifi_url");
    protected FreeWifiFrontPageUI mwF;
    protected int mwG = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    protected String mwH = this.intent.getStringExtra("free_wifi_app_nickname");
    protected String ssid = this.intent.getStringExtra("free_wifi_ssid");

    public C28079e(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.m2504i(20806);
        this.mwF = freeWifiFrontPageUI;
        this.intent = freeWifiFrontPageUI.getIntent();
        C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.ssid, this.jUg, this.cuH, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), this.appId, this.mwH, Integer.valueOf(this.mwG));
        AppMethodBeat.m2505o(20806);
    }
}
