package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C35485z;
import com.tencent.p177mm.plugin.wallet_core.model.C43804af;
import com.tencent.p177mm.plugin.wallet_core.model.C46366h;
import com.tencent.p177mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.y */
public class C35475y extends C5749m {
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
    public C46366h tuw;

    public C35475y() {
        this(null, 0);
    }

    public C35475y(String str, int i) {
        AppMethodBeat.m2504i(46547);
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
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        this.oYG.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (c30052l != null) {
            this.oYG.put("is_device_open_touch", "1");
            Map bxw = c30052l.bxw();
            if (bxw != null) {
                this.oYG.putAll(bxw);
            }
            C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            this.oYG.put("is_device_open_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        mo70323M(this.oYG);
        this.toe = new HashMap();
        C1720g.m3537RQ();
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(196612, null);
        C1720g.m3537RQ();
        String str3 = (String) C1720g.m3536RP().mo5239Ry().get(196613, null);
        this.toe.put("bind_serial", str2);
        this.toe.put("last_bind_serial", str3);
        mo70328ba(this.toe);
        AppMethodBeat.m2505o(46547);
    }

    public int bgI() {
        return 72;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46548);
        if (i != 0) {
            AppMethodBeat.m2505o(46548);
            return;
        }
        JSONObject optJSONObject;
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("real_name_info");
            ECardInfo.m68756aw(optJSONObject2);
            C4990ab.m7417i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", optJSONObject2.toString());
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
            ECardInfo.m68756aw(null);
        }
        if (jSONObject.has("paymenu_array") && this.scene == 1) {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("paymenu_array");
            if (optJSONArray2 != null) {
                C35485z.acA(optJSONArray2.toString());
            }
        }
        long optLong = jSONObject.optLong("time_stamp");
        if (optLong > 0) {
            C30862w.setTimeStamp(String.valueOf(optLong));
        } else {
            C4990ab.m7420w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
        }
        C43804af.m78521a(jSONObject, this.scene, true);
        if (C43804af.m78516Hr(this.scene) || this.scene == 1) {
            optJSONObject = jSONObject.optJSONObject("bind_card_menu");
            if (optJSONObject != null) {
                C4990ab.m7411d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", optJSONObject.toString());
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, optJSONObject.toString());
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) "");
            }
        }
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (c30052l != null) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
            c30052l.bxp();
            int cQm = C14241r.cPI().cQm();
            if (cQm == 0) {
                if (c30052l.bxn()) {
                    c30052l.mo48312hq(C14241r.cPI().cQk());
                    c30052l.mo48313hr(false);
                } else if (c30052l.bxA()) {
                    c30052l.mo48313hr(C14241r.cPI().cQk());
                    c30052l.mo48312hq(false);
                }
            } else if (cQm == 1 && c30052l.bxn()) {
                c30052l.mo48312hq(C14241r.cPI().cQk());
                c30052l.mo48313hr(false);
            } else if (cQm == 2 && c30052l.bxA()) {
                c30052l.mo48313hr(C14241r.cPI().cQk());
                c30052l.mo48312hq(false);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
        if (this.scene == 10) {
            C46366h c46366h;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("action_entry");
            if (optJSONObject3 == null) {
                c46366h = null;
            } else {
                c46366h = new C46366h();
                c46366h.f17909id = optJSONObject3.optString("id");
                c46366h.cEh = optJSONObject3.optString("wording");
                c46366h.color = optJSONObject3.optString("color");
                c46366h.type = optJSONObject3.optInt("type");
                c46366h.txZ = optJSONObject3.optString("native_url");
                c46366h.kLE = optJSONObject3.optString(MessengerShareContentUtility.BUTTON_URL_TYPE);
                c46366h.tya = optJSONObject3.optString("tiny_app_username");
                c46366h.tyb = optJSONObject3.optString("tiny_app_path");
                c46366h.tyc = optJSONObject3.optInt("entrance_type");
            }
            this.tuw = c46366h;
        }
        AppMethodBeat.m2505o(46548);
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        return 1501;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
