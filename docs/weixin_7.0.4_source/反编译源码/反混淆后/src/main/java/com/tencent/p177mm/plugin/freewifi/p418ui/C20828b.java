package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.plugin.freewifi.p416d.C28076i;
import com.tencent.p177mm.protocal.protobuf.acq;
import com.tencent.p177mm.protocal.protobuf.bns;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.b */
public final class C20828b {
    Activity activity;
    int cIb;
    String cuH;
    Intent intent;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.b$1 */
    class C208291 implements C1202f {
        C208291() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20931);
            C11967a byo = C11966k.byo();
            byo.cuH = C20828b.this.cuH;
            byo.kBq = C34189m.m56063V(C20828b.this.intent);
            byo.muf = C11968b.GetFrontPageReturn.muQ;
            byo.mug = C11968b.GetFrontPageReturn.name;
            byo.mue = C34189m.m56065X(C20828b.this.intent);
            byo.cIb = C20828b.this.cIb;
            byo.result = i2;
            byo.ehr = str;
            byo.byq().mo23810b(C20828b.this.intent, i2 != 0).byp();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(C20828b.this.intent), Integer.valueOf(C34189m.m56064W(C20828b.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C20828b c20828b = C20828b.this;
                if (c1207m instanceof C28075a) {
                    C28075a c28075a = (C28075a) c1207m;
                    c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", c28075a.bzg());
                    acq bzh = c28075a.bzh();
                    if (bzh != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)), bzh.vEn, bzh.jCH, bzh.jBB, bzh.mZW, bzh.wkr, bzh.wks, bzh.vLo, bzh.vYQ, Integer.valueOf(bzh.vAO));
                        c20828b.intent.putExtra("free_wifi_appid", bzh.vEn);
                        c20828b.intent.putExtra("free_wifi_head_img_url", bzh.mZW);
                        c20828b.intent.putExtra("free_wifi_welcome_msg", bzh.wkr);
                        c20828b.intent.putExtra("free_wifi_privacy_url", bzh.wks);
                        c20828b.intent.putExtra("free_wifi_app_nickname", bzh.jCH);
                        c20828b.intent.putExtra("free_wifi_welcome_sub_title", bzh.wkt);
                    }
                    if (c20828b.cIb != 2) {
                        c20828b.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                    }
                    bns bzf = c28075a.bzf();
                    if (bzf == null) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                        c20828b.activity.finish();
                        byo = C11966k.byo();
                        byo.cuH = c20828b.cuH;
                        byo.kBq = C34189m.m56063V(c20828b.intent);
                        byo.muf = C11968b.GetFrontPageReturnDataCheck.muQ;
                        byo.mug = C11968b.GetFrontPageReturnDataCheck.name;
                        byo.mue = C34189m.m56065X(c20828b.intent);
                        byo.cIb = c20828b.cIb;
                        byo.result = -1;
                        byo.ehr = "qstrInfo is null.";
                        byo.byq().mo23810b(c20828b.intent, true).byp();
                        AppMethodBeat.m2505o(20931);
                        return;
                    } else if (C34189m.isEmpty(bzf.luG)) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                        c20828b.activity.finish();
                        byo = C11966k.byo();
                        byo.cuH = c20828b.cuH;
                        byo.kBq = C34189m.m56063V(c20828b.intent);
                        byo.muf = C11968b.GetFrontPageReturnDataCheck.muQ;
                        byo.mug = C11968b.GetFrontPageReturnDataCheck.name;
                        byo.mue = C34189m.m56065X(c20828b.intent);
                        byo.cIb = c20828b.cIb;
                        byo.result = -1;
                        byo.ehr = "qstrInfo.Ssid is empty.";
                        byo.byq().mo23810b(c20828b.intent, true).byp();
                        AppMethodBeat.m2505o(20931);
                        return;
                    } else {
                        c20828b.intent.putExtra("free_wifi_ssid", bzf.luG);
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)), Integer.valueOf(bzf.wQU), bzf.luG, bzf.wfF);
                        String bzi = c28075a.bzi();
                        String Ge = c28075a.mo45998Ge();
                        c20828b.intent.putExtra("free_wifi_openid", bzi);
                        c20828b.intent.putExtra("free_wifi_tid", Ge);
                        c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", bzh.vLo);
                        c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", bzh.vYQ);
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)), bzi, Ge);
                        c20828b.intent.putExtra("free_wifi_protocol_type", bzf.wQU);
                        if (bzf.wQU == 10) {
                            if (C5046bo.isNullOrNil(bzf.luG) || C5046bo.isNullOrNil(bzf.wfF)) {
                                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                c20828b.activity.finish();
                                AppMethodBeat.m2505o(20931);
                                return;
                            }
                            c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                            c20828b.intent.putExtra("free_wifi_auth_type", 2);
                            c20828b.intent.putExtra("free_wifi_passowrd", bzf.wfF);
                            c20828b.intent.setClass(c20828b.activity, FreeWifiFrontPageUI.class);
                            c20828b.activity.startActivity(c20828b.intent);
                            c20828b.activity.finish();
                            c20828b.activity.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                            AppMethodBeat.m2505o(20931);
                            return;
                        } else if (bzf.wQU == 11) {
                            if (C5046bo.isNullOrNil(bzf.luG) || C5046bo.isNullOrNil(bzf.wfF)) {
                                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                c20828b.activity.finish();
                                AppMethodBeat.m2505o(20931);
                                return;
                            }
                            c20828b.intent.putExtra("free_wifi_auth_type", 2);
                            c20828b.intent.putExtra("free_wifi_passowrd", bzf.wfF);
                            c20828b.intent.setClass(c20828b.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                            c20828b.activity.startActivity(c20828b.intent);
                            c20828b.activity.finish();
                            c20828b.activity.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                            AppMethodBeat.m2505o(20931);
                            return;
                        } else if (bzf.wQU == 12) {
                            c20828b.intent.putExtra("free_wifi_auth_type", 1);
                            c20828b.intent.setClass(c20828b.activity, FreeWifiActivateAuthStateUI.class);
                            c20828b.activity.startActivity(c20828b.intent);
                            c20828b.activity.finish();
                            c20828b.activity.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                            AppMethodBeat.m2505o(20931);
                            return;
                        } else if (bzf.wQU == 31) {
                            c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)));
                            String stringExtra = c20828b.intent.getStringExtra("free_wifi_schema_ticket");
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)), stringExtra);
                            if (C5046bo.isNullOrNil(stringExtra)) {
                                c20828b.activity.finish();
                                byo = C11966k.byo();
                                byo.cuH = c20828b.cuH;
                                byo.kBq = C34189m.m56063V(c20828b.intent);
                                byo.muf = C11968b.GetFrontPageReturnDataCheck.muQ;
                                byo.mug = C11968b.GetFrontPageReturnDataCheck.name;
                                byo.cIb = c20828b.cIb;
                                byo.mue = C34189m.m56065X(c20828b.intent);
                                byo.result = -1;
                                byo.ehr = "31 ticket is empty.";
                                byo.byq().mo23810b(c20828b.intent, true).byp();
                                AppMethodBeat.m2505o(20931);
                                return;
                            }
                            String str2 = bzf.luG;
                            String str3 = bzh.vLo;
                            String str4 = bzh.vYQ;
                            if (C45957d.byM() == null) {
                                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)));
                                c20828b.mo36107MN(c20828b.activity.getString(C25738R.string.c00));
                                byo = C11966k.byo();
                                byo.cuH = c20828b.cuH;
                                byo.kBq = C34189m.m56063V(c20828b.intent);
                                byo.muf = C11968b.GetFrontPageReturnDataCheck.muQ;
                                byo.mug = C11968b.GetFrontPageReturnDataCheck.name;
                                byo.cIb = c20828b.cIb;
                                byo.mue = C34189m.m56065X(c20828b.intent);
                                byo.result = -1;
                                byo.ehr = "wifiInfo is empty.";
                                byo.byq().mo23810b(c20828b.intent, true).byp();
                                AppMethodBeat.m2505o(20931);
                                return;
                            }
                            boolean MD = C45957d.m85348MD(str2);
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)), Boolean.valueOf(MD));
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)), c20828b.cuH, C5023at.m7474gE(C4996ah.getContext()), C5023at.m7475gF(C4996ah.getContext()), C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiNetCheckUI"), stringExtra);
                            byo = C11966k.byo();
                            byo.cuH = c20828b.cuH;
                            byo.kBq = C34189m.m56063V(c20828b.intent);
                            byo.muf = C11968b.GetFrontPageReturnDataCheck.muQ;
                            byo.mug = C11968b.GetFrontPageReturnDataCheck.name;
                            byo.cIb = c20828b.cIb;
                            byo.mue = C34189m.m56065X(c20828b.intent);
                            byo.result = 0;
                            byo.ehr = "";
                            byo.byq().mo23810b(c20828b.intent, true).byp();
                            byo = C11966k.byo();
                            byo.ssid = c20828b.intent.getStringExtra("free_wifi_ssid");
                            byo.cuH = c20828b.cuH;
                            byo.mud = c20828b.intent.getStringExtra("free_wifi_appid");
                            byo.kBq = C34189m.m56063V(c20828b.intent);
                            byo.mue = C34189m.m56065X(c20828b.intent);
                            byo.muf = C11968b.GetPortalApInfo.muQ;
                            byo.mug = C11968b.GetPortalApInfo.name;
                            byo.cIb = C34189m.m56066Y(c20828b.intent);
                            byo.mue = C34189m.m56065X(c20828b.intent);
                            byo.byq().mo23810b(c20828b.intent, false).byp();
                            new C28076i(c20828b.cuH, r4, r5, r6, stringExtra, C34189m.m56063V(c20828b.intent)).mo68618O(c20828b.activity).mo68619c(new C208302(bzi, Ge, str3, str4));
                            AppMethodBeat.m2505o(20931);
                            return;
                        } else if (bzf.wQU == 32) {
                            c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", C34189m.m56063V(c20828b.intent), Integer.valueOf(C34189m.m56064W(c20828b.intent)));
                            c20828b.intent.setClass(c20828b.activity, FreeWifiFrontPageUI.class);
                            c20828b.activity.startActivity(c20828b.intent);
                            c20828b.activity.finish();
                            c20828b.activity.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                            AppMethodBeat.m2505o(20931);
                            return;
                        } else if (bzf.wQU == 1) {
                            c20828b.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                            c20828b.intent.putExtra("free_wifi_auth_type", 1);
                            c20828b.intent.setClass(c20828b.activity, FreeWifiFrontPageUI.class);
                            c20828b.activity.startActivity(c20828b.intent);
                            c20828b.activity.finish();
                            c20828b.activity.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                            AppMethodBeat.m2505o(20931);
                            return;
                        } else {
                            c20828b.activity.finish();
                            c20828b.mo36107MN(c20828b.activity.getString(C25738R.string.c05));
                            AppMethodBeat.m2505o(20931);
                            return;
                        }
                    }
                }
                c20828b.mo36107MN(c20828b.activity.getString(C25738R.string.c00));
                AppMethodBeat.m2505o(20931);
            } else if (C34189m.m56075eh(i, i2) && !C34189m.isEmpty(str)) {
                C20828b.this.mo36107MN(str + "(" + C34189m.m56068a(C34189m.m56065X(C20828b.this.intent), C11968b.GetFrontPageReturn, i2) + ")");
                AppMethodBeat.m2505o(20931);
            } else if (i2 == -30031) {
                C20828b.this.mo36107MN(C20828b.this.activity.getString(C25738R.string.c04));
                AppMethodBeat.m2505o(20931);
            } else {
                C20828b.this.mo36107MN(C20828b.this.activity.getString(C25738R.string.c00) + "(" + String.format("%02d", new Object[]{Integer.valueOf(C34189m.m56065X(C20828b.this.intent))}) + C11968b.GetFrontPageReturn.muQ + Math.abs(i2) + ")");
                AppMethodBeat.m2505o(20931);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.b$2 */
    class C208302 implements C1202f {
        final /* synthetic */ String myu;
        final /* synthetic */ String myv;
        final /* synthetic */ String myw;
        final /* synthetic */ String myx;

        C208302(String str, String str2, String str3, String str4) {
            this.myu = str;
            this.myv = str2;
            this.myw = str3;
            this.myx = str4;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20932);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(C20828b.this.intent), Integer.valueOf(C34189m.m56064W(C20828b.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
            C11967a byo;
            if (i == 0 && i2 == 0) {
                byo = C11966k.byo();
                byo.cuH = C20828b.this.cuH;
                byo.kBq = C34189m.m56063V(C20828b.this.intent);
                byo.muf = C11968b.GetPortalApInfoReturn.muQ;
                byo.mug = C11968b.GetPortalApInfoReturn.name;
                byo.cIb = C20828b.this.cIb;
                byo.result = i2;
                byo.ehr = str;
                byo.byq().mo23810b(C20828b.this.intent, false).byp();
                C28076i c28076i = (C28076i) c1207m;
                String bzn = c28076i.bzn();
                if (C34189m.isEmpty(bzn)) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", C34189m.m56063V(C20828b.this.intent), Integer.valueOf(C34189m.m56064W(C20828b.this.intent)));
                    C20828b.this.mo36107MN(C20828b.this.activity.getString(C25738R.string.c00));
                    byo = C11966k.byo();
                    byo.cuH = C20828b.this.cuH;
                    byo.kBq = C34189m.m56063V(C20828b.this.intent);
                    byo.muf = C11968b.GetPortalApInfoReturnDataCheck.muQ;
                    byo.mug = C11968b.GetPortalApInfoReturnDataCheck.name;
                    byo.cIb = C20828b.this.cIb;
                    byo.mue = C34189m.m56065X(C20828b.this.intent);
                    byo.result = -1;
                    byo.ehr = "31 auth url is empty.";
                    byo.byq().mo23810b(C20828b.this.intent, true).byp();
                    AppMethodBeat.m2505o(20932);
                    return;
                }
                String Mw = C34189m.m56058Mw(c28076i.bzo());
                String Mw2 = C34189m.m56058Mw(this.myu);
                String Mw3 = C34189m.m56058Mw(this.myv);
                StringBuilder stringBuilder = new StringBuilder(bzn);
                if (bzn.indexOf("?") != -1) {
                    stringBuilder.append("&extend=").append(Mw);
                } else {
                    stringBuilder.append("?extend=").append(Mw);
                }
                stringBuilder.append("&openId=").append(Mw2).append("&tid=").append(Mw3).append("&timestamp=").append(C34189m.m56058Mw(this.myw)).append("&sign=").append(C34189m.m56058Mw(this.myx));
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", C34189m.m56063V(C20828b.this.intent), Integer.valueOf(C34189m.m56064W(C20828b.this.intent)), stringBuilder.toString());
                C20828b.this.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
                C20828b.this.intent.setClass(C20828b.this.activity, FreeWifiFrontPageUI.class);
                C20828b.this.activity.startActivity(C20828b.this.intent);
                C20828b.this.activity.finish();
                C20828b.this.activity.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                byo = C11966k.byo();
                byo.cuH = C20828b.this.cuH;
                byo.kBq = C34189m.m56063V(C20828b.this.intent);
                byo.muf = C11968b.GetPortalApInfoReturnDataCheck.muQ;
                byo.mug = C11968b.GetPortalApInfoReturnDataCheck.name;
                byo.cIb = C20828b.this.cIb;
                byo.mue = C34189m.m56065X(C20828b.this.intent);
                byo.result = 0;
                byo.ehr = "";
                byo.byq().mo23810b(C20828b.this.intent, true).byp();
                AppMethodBeat.m2505o(20932);
                return;
            }
            byo = C11966k.byo();
            byo.cuH = C20828b.this.cuH;
            byo.kBq = C34189m.m56063V(C20828b.this.intent);
            byo.muf = C11968b.GetPortalApInfoReturn.muQ;
            byo.mug = C11968b.GetPortalApInfoReturn.name;
            byo.cIb = C20828b.this.cIb;
            byo.mue = C34189m.m56065X(C20828b.this.intent);
            byo.result = i2;
            byo.ehr = str;
            byo.byq().mo23810b(C20828b.this.intent, true).byp();
            if (C34189m.m56075eh(i, i2) && !C34189m.isEmpty(str)) {
                C20828b.this.mo36107MN(str + "(" + C34189m.m56068a(C34189m.m56065X(C20828b.this.intent), C11968b.GetPortalApInfoReturn, i2) + ")");
                AppMethodBeat.m2505o(20932);
            } else if (C34189m.isEmpty(str)) {
                C20828b.this.mo36107MN(C20828b.this.activity.getString(C25738R.string.c00));
                AppMethodBeat.m2505o(20932);
            } else {
                C20828b.this.mo36107MN(str);
                AppMethodBeat.m2505o(20932);
            }
        }
    }

    public C20828b(Activity activity, String str, int i) {
        AppMethodBeat.m2504i(20933);
        if (C5046bo.isNullOrNil(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("acitvity or apKey cannot be null.");
            AppMethodBeat.m2505o(20933);
            throw illegalArgumentException;
        }
        this.activity = activity;
        this.intent = activity.getIntent();
        this.cuH = str;
        this.cIb = i;
        AppMethodBeat.m2505o(20933);
    }

    public final void connect() {
        AppMethodBeat.m2504i(20934);
        if (C5046bo.isNullOrNil(this.cuH)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            this.activity.finish();
        }
        this.activity.getIntent().putExtra("free_wifi_url", this.cuH);
        this.activity.getIntent().putExtra("free_wifi_ap_key", this.cuH);
        if (C5046bo.isNullOrNil(this.cuH)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            this.activity.finish();
            AppMethodBeat.m2505o(20934);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.cuH, Integer.valueOf(this.cIb));
        C11967a byo = C11966k.byo();
        byo.cuH = this.cuH;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.muf = C11968b.GetFrontPage.muQ;
        byo.mug = C11968b.GetFrontPage.name;
        byo.cIb = this.cIb;
        byo.mue = C34189m.m56065X(this.intent);
        byo.byq().mo23810b(this.intent, false).byp();
        new C28075a(this.cuH, this.cIb, C34189m.m56063V(this.intent)).mo68618O(this.activity).mo68619c(new C208291());
        AppMethodBeat.m2505o(20934);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: MN */
    public final void mo36107MN(String str) {
        AppMethodBeat.m2504i(20935);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        this.activity.startActivity(intent);
        AppMethodBeat.m2505o(20935);
    }
}
