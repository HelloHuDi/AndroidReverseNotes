package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class q {
    public long ttW;
    public long tzN;
    public long tzO;
    public int tzP;
    public int tzQ;
    public long tzR;

    public static class a {
        public String name;
        public String pia;
        public String title;
        public int type;
        public String tzS;
        public String tzT;
        public String url;

        public final void aA(JSONObject jSONObject) {
            AppMethodBeat.i(46790);
            this.url = jSONObject.optString("url");
            this.name = jSONObject.optString("wording");
            this.pia = jSONObject.optString("icon");
            this.tzS = jSONObject.optString("btn_text");
            this.type = jSONObject.optInt("type");
            this.title = jSONObject.optString("title");
            this.tzT = jSONObject.optString("small_title");
            AppMethodBeat.o(46790);
        }
    }

    public static class b {
        public String ttf;
        public String ttg;
        public String tzU;
        public String tzV;
        public String tzW;
        public String tzX;
        public int tzY;

        public final void aA(JSONObject jSONObject) {
            AppMethodBeat.i(46791);
            this.ttf = jSONObject.optString("tinyapp_name");
            this.tzU = jSONObject.optString("tinyapp_logo");
            this.tzV = jSONObject.optString("tinyapp_desc");
            this.tzW = jSONObject.optString("tinyapp_username");
            this.ttg = jSONObject.optString("tinyapp_path");
            this.tzX = jSONObject.optString("activity_tinyapp_btn_text");
            this.tzY = jSONObject.optInt("tinyapp_version", 0);
            AppMethodBeat.o(46791);
        }
    }

    public final void aA(JSONObject jSONObject) {
        AppMethodBeat.i(46792);
        this.ttW = jSONObject.optLong("activity_id");
        this.tzN = jSONObject.optLong("activity_type", 0);
        this.tzO = jSONObject.optLong("award_id");
        this.tzP = jSONObject.optInt("send_record_id");
        this.tzQ = jSONObject.optInt("user_record_id");
        this.tzR = jSONObject.optLong("activity_mch_id", 0);
        AppMethodBeat.o(46792);
    }
}
