package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.ab;

public class e {
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

    public e(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.i(20806);
        this.mwF = freeWifiFrontPageUI;
        this.intent = freeWifiFrontPageUI.getIntent();
        ab.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.ssid, this.jUg, this.cuH, Integer.valueOf(this.cvd), Integer.valueOf(this.cdf), this.appId, this.mwH, Integer.valueOf(this.mwG));
        AppMethodBeat.o(20806);
    }
}
