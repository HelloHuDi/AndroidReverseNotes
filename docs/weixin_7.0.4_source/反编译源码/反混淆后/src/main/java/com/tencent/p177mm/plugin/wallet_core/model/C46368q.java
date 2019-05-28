package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.q */
public final class C46368q {
    public long ttW;
    public long tzN;
    public long tzO;
    public int tzP;
    public int tzQ;
    public long tzR;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.q$a */
    public static class C14239a {
        public String name;
        public String pia;
        public String title;
        public int type;
        public String tzS;
        public String tzT;
        public String url;

        /* renamed from: aA */
        public final void mo26540aA(JSONObject jSONObject) {
            AppMethodBeat.m2504i(46790);
            this.url = jSONObject.optString("url");
            this.name = jSONObject.optString("wording");
            this.pia = jSONObject.optString("icon");
            this.tzS = jSONObject.optString("btn_text");
            this.type = jSONObject.optInt("type");
            this.title = jSONObject.optString("title");
            this.tzT = jSONObject.optString("small_title");
            AppMethodBeat.m2505o(46790);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.q$b */
    public static class C29638b {
        public String ttf;
        public String ttg;
        public String tzU;
        public String tzV;
        public String tzW;
        public String tzX;
        public int tzY;

        /* renamed from: aA */
        public final void mo47885aA(JSONObject jSONObject) {
            AppMethodBeat.m2504i(46791);
            this.ttf = jSONObject.optString("tinyapp_name");
            this.tzU = jSONObject.optString("tinyapp_logo");
            this.tzV = jSONObject.optString("tinyapp_desc");
            this.tzW = jSONObject.optString("tinyapp_username");
            this.ttg = jSONObject.optString("tinyapp_path");
            this.tzX = jSONObject.optString("activity_tinyapp_btn_text");
            this.tzY = jSONObject.optInt("tinyapp_version", 0);
            AppMethodBeat.m2505o(46791);
        }
    }

    /* renamed from: aA */
    public final void mo74581aA(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46792);
        this.ttW = jSONObject.optLong("activity_id");
        this.tzN = jSONObject.optLong("activity_type", 0);
        this.tzO = jSONObject.optLong("award_id");
        this.tzP = jSONObject.optInt("send_record_id");
        this.tzQ = jSONObject.optInt("user_record_id");
        this.tzR = jSONObject.optLong("activity_mch_id", 0);
        AppMethodBeat.m2505o(46792);
    }
}
