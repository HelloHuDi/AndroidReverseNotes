package com.tencent.mm.plugin.wallet_core.c;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class y extends m {
    public String cRb;
    public String cRc;
    public String cRd;
    public String cRe;
    public String cRf;
    public String cRg;
    public int cRh;
    public String cRi;
    public String cRj;
    public String cRk;
    public String cRl;
    public LinkedList<String> cRm;
    public ECardInfo cRn;
    public Map<String, String> oYG;
    public int scene;
    public String subtitle;
    public String title;
    public Map<String, String> toe;
    public h tuw;

    public y() {
        this(null, 0);
    }

    public y(String str, int i) {
        AppMethodBeat.i(46547);
        this.cRg = "";
        this.cRh = 0;
        this.cRi = "";
        this.cRj = "";
        this.cRk = "";
        this.cRl = "";
        this.subtitle = "";
        this.title = "";
        this.cRm = new LinkedList();
        this.scene = 0;
        this.oYG = new HashMap();
        this.scene = i;
        this.oYG.put("req_key", str);
        this.oYG.put("bind_query_scene", String.valueOf(i));
        l lVar = (l) g.K(l.class);
        this.oYG.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (lVar != null) {
            this.oYG.put("is_device_open_touch", "1");
            Map bxw = lVar.bxw();
            if (bxw != null) {
                this.oYG.putAll(bxw);
            }
            ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            this.oYG.put("is_device_open_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        M(this.oYG);
        this.toe = new HashMap();
        g.RQ();
        String str2 = (String) g.RP().Ry().get(196612, null);
        g.RQ();
        String str3 = (String) g.RP().Ry().get(196613, null);
        this.toe.put("bind_serial", str2);
        this.toe.put("last_bind_serial", str3);
        ba(this.toe);
        AppMethodBeat.o(46547);
    }

    public int bgI() {
        return 72;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46548);
        if (i != 0) {
            AppMethodBeat.o(46548);
            return;
        }
        JSONObject optJSONObject;
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("real_name_info");
            ECardInfo.aw(optJSONObject2);
            ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", optJSONObject2.toString());
            this.cRb = optJSONObject2.optString("guide_flag");
            this.cRc = optJSONObject2.optString("guide_wording");
            this.cRd = optJSONObject2.optString("left_button_wording");
            this.cRe = optJSONObject2.optString("right_button_wording");
            this.cRf = optJSONObject2.optString("upload_credit_url");
            this.cRg = optJSONObject2.optString("done_button_wording");
            this.cRh = optJSONObject2.optInt("is_show_protocol", 0);
            this.cRi = optJSONObject2.optString("left_protocol_wording");
            this.cRj = optJSONObject2.optString("new_upload_credit_url");
            this.cRk = optJSONObject2.optString("protocol_url");
            this.cRl = optJSONObject2.optString("right_protocol_wording");
            this.subtitle = optJSONObject2.optString(MessengerShareContentUtility.SUBTITLE);
            this.title = optJSONObject2.optString("title");
            JSONArray optJSONArray = optJSONObject2.optJSONArray("upload_reasons");
            this.cRm.clear();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.cRm.add(optJSONArray.optString(i2));
                }
            }
            if (optJSONObject2.has("ecard_info")) {
                optJSONObject = optJSONObject2.optJSONObject("ecard_info");
                this.cRn = new ECardInfo();
                this.cRn.title = this.title;
                this.cRn.typ = new ArrayList(this.cRm);
                this.cRn.tyr = this.cRk;
                this.cRn.tys = this.cRi;
                this.cRn.tyt = this.cRl;
                this.cRn.tyq = this.cRg;
                this.cRn.jSu = optJSONObject.optInt("ecard_open_scene", 0);
                this.cRn.cvQ = optJSONObject.optString("ecard_type", "");
                this.cRn.tyj = optJSONObject.optInt("show_check_box", 0);
                this.cRn.tyk = optJSONObject.optInt("check_box_selected", 0);
                this.cRn.tyl = optJSONObject.optString("check_box_left_wording", "");
                this.cRn.tym = optJSONObject.optString("check_box_right_wording", "");
                this.cRn.tyn = optJSONObject.optString("check_box_url", "");
                this.cRn.tyo = optJSONObject.optInt("is_upload_credid", 0);
                this.cRn.cRf = optJSONObject.optString("upload_credit_url", "");
            }
        } else {
            ECardInfo.aw(null);
        }
        if (jSONObject.has("paymenu_array") && this.scene == 1) {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("paymenu_array");
            if (optJSONArray2 != null) {
                z.acA(optJSONArray2.toString());
            }
        }
        long optLong = jSONObject.optLong("time_stamp");
        if (optLong > 0) {
            w.setTimeStamp(String.valueOf(optLong));
        } else {
            ab.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
        }
        af.a(jSONObject, this.scene, true);
        if (af.Hr(this.scene) || this.scene == 1) {
            optJSONObject = jSONObject.optJSONObject("bind_card_menu");
            if (optJSONObject != null) {
                ab.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", optJSONObject.toString());
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, optJSONObject.toString());
            } else {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) "");
            }
        }
        l lVar = (l) g.K(l.class);
        if (lVar != null) {
            ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
            lVar.bxp();
            int cQm = r.cPI().cQm();
            if (cQm == 0) {
                if (lVar.bxn()) {
                    lVar.hq(r.cPI().cQk());
                    lVar.hr(false);
                } else if (lVar.bxA()) {
                    lVar.hr(r.cPI().cQk());
                    lVar.hq(false);
                }
            } else if (cQm == 1 && lVar.bxn()) {
                lVar.hq(r.cPI().cQk());
                lVar.hr(false);
            } else if (cQm == 2 && lVar.bxA()) {
                lVar.hr(r.cPI().cQk());
                lVar.hq(false);
            }
        } else {
            ab.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
        if (this.scene == 10) {
            h hVar;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("action_entry");
            if (optJSONObject3 == null) {
                hVar = null;
            } else {
                hVar = new h();
                hVar.id = optJSONObject3.optString("id");
                hVar.cEh = optJSONObject3.optString("wording");
                hVar.color = optJSONObject3.optString("color");
                hVar.type = optJSONObject3.optInt("type");
                hVar.txZ = optJSONObject3.optString("native_url");
                hVar.kLE = optJSONObject3.optString(MessengerShareContentUtility.BUTTON_URL_TYPE);
                hVar.tya = optJSONObject3.optString("tiny_app_username");
                hVar.tyb = optJSONObject3.optString("tiny_app_path");
                hVar.tyc = optJSONObject3.optInt("entrance_type");
            }
            this.tuw = hVar;
        }
        AppMethodBeat.o(46548);
    }

    public int ZU() {
        return 1501;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
