package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    Activity activity;
    int cIb;
    String cuH;
    Intent intent;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.b$2 */
    class AnonymousClass2 implements f {
        final /* synthetic */ String myu;
        final /* synthetic */ String myv;
        final /* synthetic */ String myw;
        final /* synthetic */ String myx;

        AnonymousClass2(String str, String str2, String str3, String str4) {
            this.myu = str;
            this.myv = str2;
            this.myw = str3;
            this.myx = str4;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20932);
            ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", com.tencent.mm.plugin.freewifi.m.V(b.this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(b.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
            a byo;
            if (i == 0 && i2 == 0) {
                byo = k.byo();
                byo.cuH = b.this.cuH;
                byo.kBq = com.tencent.mm.plugin.freewifi.m.V(b.this.intent);
                byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.muQ;
                byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.name;
                byo.cIb = b.this.cIb;
                byo.result = i2;
                byo.ehr = str;
                byo.byq().b(b.this.intent, false).byp();
                i iVar = (i) mVar;
                String bzn = iVar.bzn();
                if (com.tencent.mm.plugin.freewifi.m.isEmpty(bzn)) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", com.tencent.mm.plugin.freewifi.m.V(b.this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(b.this.intent)));
                    b.this.MN(b.this.activity.getString(R.string.c00));
                    byo = k.byo();
                    byo.cuH = b.this.cuH;
                    byo.kBq = com.tencent.mm.plugin.freewifi.m.V(b.this.intent);
                    byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.muQ;
                    byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.name;
                    byo.cIb = b.this.cIb;
                    byo.mue = com.tencent.mm.plugin.freewifi.m.X(b.this.intent);
                    byo.result = -1;
                    byo.ehr = "31 auth url is empty.";
                    byo.byq().b(b.this.intent, true).byp();
                    AppMethodBeat.o(20932);
                    return;
                }
                String Mw = com.tencent.mm.plugin.freewifi.m.Mw(iVar.bzo());
                String Mw2 = com.tencent.mm.plugin.freewifi.m.Mw(this.myu);
                String Mw3 = com.tencent.mm.plugin.freewifi.m.Mw(this.myv);
                StringBuilder stringBuilder = new StringBuilder(bzn);
                if (bzn.indexOf("?") != -1) {
                    stringBuilder.append("&extend=").append(Mw);
                } else {
                    stringBuilder.append("?extend=").append(Mw);
                }
                stringBuilder.append("&openId=").append(Mw2).append("&tid=").append(Mw3).append("&timestamp=").append(com.tencent.mm.plugin.freewifi.m.Mw(this.myw)).append("&sign=").append(com.tencent.mm.plugin.freewifi.m.Mw(this.myx));
                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", com.tencent.mm.plugin.freewifi.m.V(b.this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(b.this.intent)), stringBuilder.toString());
                b.this.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
                b.this.intent.setClass(b.this.activity, FreeWifiFrontPageUI.class);
                b.this.activity.startActivity(b.this.intent);
                b.this.activity.finish();
                b.this.activity.overridePendingTransition(R.anim.df, R.anim.dc);
                byo = k.byo();
                byo.cuH = b.this.cuH;
                byo.kBq = com.tencent.mm.plugin.freewifi.m.V(b.this.intent);
                byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.muQ;
                byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.name;
                byo.cIb = b.this.cIb;
                byo.mue = com.tencent.mm.plugin.freewifi.m.X(b.this.intent);
                byo.result = 0;
                byo.ehr = "";
                byo.byq().b(b.this.intent, true).byp();
                AppMethodBeat.o(20932);
                return;
            }
            byo = k.byo();
            byo.cuH = b.this.cuH;
            byo.kBq = com.tencent.mm.plugin.freewifi.m.V(b.this.intent);
            byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.muQ;
            byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.name;
            byo.cIb = b.this.cIb;
            byo.mue = com.tencent.mm.plugin.freewifi.m.X(b.this.intent);
            byo.result = i2;
            byo.ehr = str;
            byo.byq().b(b.this.intent, true).byp();
            if (com.tencent.mm.plugin.freewifi.m.eh(i, i2) && !com.tencent.mm.plugin.freewifi.m.isEmpty(str)) {
                b.this.MN(str + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.X(b.this.intent), com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn, i2) + ")");
                AppMethodBeat.o(20932);
            } else if (com.tencent.mm.plugin.freewifi.m.isEmpty(str)) {
                b.this.MN(b.this.activity.getString(R.string.c00));
                AppMethodBeat.o(20932);
            } else {
                b.this.MN(str);
                AppMethodBeat.o(20932);
            }
        }
    }

    public b(Activity activity, String str, int i) {
        AppMethodBeat.i(20933);
        if (bo.isNullOrNil(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("acitvity or apKey cannot be null.");
            AppMethodBeat.o(20933);
            throw illegalArgumentException;
        }
        this.activity = activity;
        this.intent = activity.getIntent();
        this.cuH = str;
        this.cIb = i;
        AppMethodBeat.o(20933);
    }

    public final void connect() {
        AppMethodBeat.i(20934);
        if (bo.isNullOrNil(this.cuH)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            this.activity.finish();
        }
        this.activity.getIntent().putExtra("free_wifi_url", this.cuH);
        this.activity.getIntent().putExtra("free_wifi_ap_key", this.cuH);
        if (bo.isNullOrNil(this.cuH)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            this.activity.finish();
            AppMethodBeat.o(20934);
            return;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", com.tencent.mm.plugin.freewifi.m.V(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(this.intent)), this.cuH, Integer.valueOf(this.cIb));
        a byo = k.byo();
        byo.cuH = this.cuH;
        byo.kBq = com.tencent.mm.plugin.freewifi.m.V(this.intent);
        byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPage.muQ;
        byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPage.name;
        byo.cIb = this.cIb;
        byo.mue = com.tencent.mm.plugin.freewifi.m.X(this.intent);
        byo.byq().b(this.intent, false).byp();
        new com.tencent.mm.plugin.freewifi.d.a(this.cuH, this.cIb, com.tencent.mm.plugin.freewifi.m.V(this.intent)).O(this.activity).c(new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(20931);
                a byo = k.byo();
                byo.cuH = b.this.cuH;
                byo.kBq = com.tencent.mm.plugin.freewifi.m.V(b.this.intent);
                byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.muQ;
                byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.name;
                byo.mue = com.tencent.mm.plugin.freewifi.m.X(b.this.intent);
                byo.cIb = b.this.cIb;
                byo.result = i2;
                byo.ehr = str;
                byo.byq().b(b.this.intent, i2 != 0).byp();
                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", com.tencent.mm.plugin.freewifi.m.V(b.this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(b.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    b bVar = b.this;
                    if (mVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) mVar;
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar.bzg());
                        acq bzh = aVar.bzh();
                        if (bzh != null) {
                            ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)), bzh.vEn, bzh.jCH, bzh.jBB, bzh.mZW, bzh.wkr, bzh.wks, bzh.vLo, bzh.vYQ, Integer.valueOf(bzh.vAO));
                            bVar.intent.putExtra("free_wifi_appid", bzh.vEn);
                            bVar.intent.putExtra("free_wifi_head_img_url", bzh.mZW);
                            bVar.intent.putExtra("free_wifi_welcome_msg", bzh.wkr);
                            bVar.intent.putExtra("free_wifi_privacy_url", bzh.wks);
                            bVar.intent.putExtra("free_wifi_app_nickname", bzh.jCH);
                            bVar.intent.putExtra("free_wifi_welcome_sub_title", bzh.wkt);
                        }
                        if (bVar.cIb != 2) {
                            bVar.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                        }
                        bns bzf = aVar.bzf();
                        if (bzf == null) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                            bVar.activity.finish();
                            byo = k.byo();
                            byo.cuH = bVar.cuH;
                            byo.kBq = com.tencent.mm.plugin.freewifi.m.V(bVar.intent);
                            byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.muQ;
                            byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                            byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                            byo.cIb = bVar.cIb;
                            byo.result = -1;
                            byo.ehr = "qstrInfo is null.";
                            byo.byq().b(bVar.intent, true).byp();
                            AppMethodBeat.o(20931);
                            return;
                        } else if (com.tencent.mm.plugin.freewifi.m.isEmpty(bzf.luG)) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                            bVar.activity.finish();
                            byo = k.byo();
                            byo.cuH = bVar.cuH;
                            byo.kBq = com.tencent.mm.plugin.freewifi.m.V(bVar.intent);
                            byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.muQ;
                            byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                            byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                            byo.cIb = bVar.cIb;
                            byo.result = -1;
                            byo.ehr = "qstrInfo.Ssid is empty.";
                            byo.byq().b(bVar.intent, true).byp();
                            AppMethodBeat.o(20931);
                            return;
                        } else {
                            bVar.intent.putExtra("free_wifi_ssid", bzf.luG);
                            ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)), Integer.valueOf(bzf.wQU), bzf.luG, bzf.wfF);
                            String bzi = aVar.bzi();
                            String Ge = aVar.Ge();
                            bVar.intent.putExtra("free_wifi_openid", bzi);
                            bVar.intent.putExtra("free_wifi_tid", Ge);
                            bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", bzh.vLo);
                            bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", bzh.vYQ);
                            ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)), bzi, Ge);
                            bVar.intent.putExtra("free_wifi_protocol_type", bzf.wQU);
                            if (bzf.wQU == 10) {
                                if (bo.isNullOrNil(bzf.luG) || bo.isNullOrNil(bzf.wfF)) {
                                    ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    bVar.activity.finish();
                                    AppMethodBeat.o(20931);
                                    return;
                                }
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                                bVar.intent.putExtra("free_wifi_auth_type", 2);
                                bVar.intent.putExtra("free_wifi_passowrd", bzf.wfF);
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.anim.df, R.anim.dc);
                                AppMethodBeat.o(20931);
                                return;
                            } else if (bzf.wQU == 11) {
                                if (bo.isNullOrNil(bzf.luG) || bo.isNullOrNil(bzf.wfF)) {
                                    ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    bVar.activity.finish();
                                    AppMethodBeat.o(20931);
                                    return;
                                }
                                bVar.intent.putExtra("free_wifi_auth_type", 2);
                                bVar.intent.putExtra("free_wifi_passowrd", bzf.wfF);
                                bVar.intent.setClass(bVar.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.anim.df, R.anim.dc);
                                AppMethodBeat.o(20931);
                                return;
                            } else if (bzf.wQU == 12) {
                                bVar.intent.putExtra("free_wifi_auth_type", 1);
                                bVar.intent.setClass(bVar.activity, FreeWifiActivateAuthStateUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.anim.df, R.anim.dc);
                                AppMethodBeat.o(20931);
                                return;
                            } else if (bzf.wQU == 31) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)));
                                String stringExtra = bVar.intent.getStringExtra("free_wifi_schema_ticket");
                                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)), stringExtra);
                                if (bo.isNullOrNil(stringExtra)) {
                                    bVar.activity.finish();
                                    byo = k.byo();
                                    byo.cuH = bVar.cuH;
                                    byo.kBq = com.tencent.mm.plugin.freewifi.m.V(bVar.intent);
                                    byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.muQ;
                                    byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                    byo.cIb = bVar.cIb;
                                    byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                                    byo.result = -1;
                                    byo.ehr = "31 ticket is empty.";
                                    byo.byq().b(bVar.intent, true).byp();
                                    AppMethodBeat.o(20931);
                                    return;
                                }
                                String str2 = bzf.luG;
                                String str3 = bzh.vLo;
                                String str4 = bzh.vYQ;
                                if (d.byM() == null) {
                                    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)));
                                    bVar.MN(bVar.activity.getString(R.string.c00));
                                    byo = k.byo();
                                    byo.cuH = bVar.cuH;
                                    byo.kBq = com.tencent.mm.plugin.freewifi.m.V(bVar.intent);
                                    byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.muQ;
                                    byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                    byo.cIb = bVar.cIb;
                                    byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                                    byo.result = -1;
                                    byo.ehr = "wifiInfo is empty.";
                                    byo.byq().b(bVar.intent, true).byp();
                                    AppMethodBeat.o(20931);
                                    return;
                                }
                                boolean MD = d.MD(str2);
                                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)), Boolean.valueOf(MD));
                                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)), bVar.cuH, at.gE(ah.getContext()), at.gF(ah.getContext()), com.tencent.mm.plugin.freewifi.m.Mz("MicroMsg.FreeWifi.FreeWifiNetCheckUI"), stringExtra);
                                byo = k.byo();
                                byo.cuH = bVar.cuH;
                                byo.kBq = com.tencent.mm.plugin.freewifi.m.V(bVar.intent);
                                byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.muQ;
                                byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                byo.cIb = bVar.cIb;
                                byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                                byo.result = 0;
                                byo.ehr = "";
                                byo.byq().b(bVar.intent, true).byp();
                                byo = k.byo();
                                byo.ssid = bVar.intent.getStringExtra("free_wifi_ssid");
                                byo.cuH = bVar.cuH;
                                byo.mud = bVar.intent.getStringExtra("free_wifi_appid");
                                byo.kBq = com.tencent.mm.plugin.freewifi.m.V(bVar.intent);
                                byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                                byo.muf = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfo.muQ;
                                byo.mug = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfo.name;
                                byo.cIb = com.tencent.mm.plugin.freewifi.m.Y(bVar.intent);
                                byo.mue = com.tencent.mm.plugin.freewifi.m.X(bVar.intent);
                                byo.byq().b(bVar.intent, false).byp();
                                new i(bVar.cuH, r4, r5, r6, stringExtra, com.tencent.mm.plugin.freewifi.m.V(bVar.intent)).O(bVar.activity).c(new AnonymousClass2(bzi, Ge, str3, str4));
                                AppMethodBeat.o(20931);
                                return;
                            } else if (bzf.wQU == 32) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                                ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", com.tencent.mm.plugin.freewifi.m.V(bVar.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(bVar.intent)));
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.anim.df, R.anim.dc);
                                AppMethodBeat.o(20931);
                                return;
                            } else if (bzf.wQU == 1) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                                bVar.intent.putExtra("free_wifi_auth_type", 1);
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.anim.df, R.anim.dc);
                                AppMethodBeat.o(20931);
                                return;
                            } else {
                                bVar.activity.finish();
                                bVar.MN(bVar.activity.getString(R.string.c05));
                                AppMethodBeat.o(20931);
                                return;
                            }
                        }
                    }
                    bVar.MN(bVar.activity.getString(R.string.c00));
                    AppMethodBeat.o(20931);
                } else if (com.tencent.mm.plugin.freewifi.m.eh(i, i2) && !com.tencent.mm.plugin.freewifi.m.isEmpty(str)) {
                    b.this.MN(str + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.X(b.this.intent), com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn, i2) + ")");
                    AppMethodBeat.o(20931);
                } else if (i2 == -30031) {
                    b.this.MN(b.this.activity.getString(R.string.c04));
                    AppMethodBeat.o(20931);
                } else {
                    b.this.MN(b.this.activity.getString(R.string.c00) + "(" + String.format("%02d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.freewifi.m.X(b.this.intent))}) + com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.muQ + Math.abs(i2) + ")");
                    AppMethodBeat.o(20931);
                }
            }
        });
        AppMethodBeat.o(20934);
    }

    /* Access modifiers changed, original: final */
    public final void MN(String str) {
        AppMethodBeat.i(20935);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        this.activity.startActivity(intent);
        AppMethodBeat.o(20935);
    }
}
