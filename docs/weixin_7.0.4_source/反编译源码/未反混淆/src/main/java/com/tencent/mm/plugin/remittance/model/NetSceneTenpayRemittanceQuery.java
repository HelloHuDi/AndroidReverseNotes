package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class NetSceneTenpayRemittanceQuery extends m {
    public String desc;
    public double kCJ;
    public boolean nsL;
    private String pQe = null;
    public int pQf;
    private String pQg;
    public String pQh;
    public int pQi;
    public String pQj;
    public String pQk;
    public int pQl;
    public a pQm;
    public b pQn;
    public d pQo;
    public ResendMsgInfo pQp;
    public String pQq;
    public String pQr;
    public String pcJ;
    public int pcT;
    public String pcl;
    public int status;

    public static class a {
        public String fBg;
        public String gyD;
        public String pQs;

        public final String toString() {
            AppMethodBeat.i(44776);
            String str = "AddressInfo{addressName='" + this.pQs + '\'' + ", phoneNum='" + this.gyD + '\'' + ", address='" + this.fBg + '\'' + '}';
            AppMethodBeat.o(44776);
            return str;
        }
    }

    public static class b {
        public String cEh;
        public String cIY;
        public String name;
        public int pQt;
        public String pQu;
        public c pQv;

        public final String toString() {
            AppMethodBeat.i(44777);
            String str = "ExposureInfo{icon='" + this.cIY + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.cEh + '\'' + ", isShowBtn=" + this.pQt + ", btnWording='" + this.pQu + '\'' + ", jumpInfo=" + this.pQv + '}';
            AppMethodBeat.o(44777);
            return str;
        }
    }

    public static class c {
        public String pQw;
        public int type;
        public String url;
        public String username;

        public final String toString() {
            AppMethodBeat.i(44778);
            String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.pQw + '\'' + '}';
            AppMethodBeat.o(44778);
            return str;
        }
    }

    public static class ResendMsgInfo implements Parcelable {
        public static final Creator<ResendMsgInfo> CREATOR = new Creator<ResendMsgInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResendMsgInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44779);
                ResendMsgInfo resendMsgInfo = new ResendMsgInfo(parcel);
                AppMethodBeat.o(44779);
                return resendMsgInfo;
            }
        };
        public String description;
        public String nZb;
        public String nZc;
        public String pQx;
        public String title;

        public String toString() {
            AppMethodBeat.i(44780);
            String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.pQx + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.nZb + '\'' + ", right_button_wording='" + this.nZc + '\'' + '}';
            AppMethodBeat.o(44780);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(44781);
            parcel.writeString(this.title);
            parcel.writeString(this.pQx);
            parcel.writeString(this.description);
            parcel.writeString(this.nZb);
            parcel.writeString(this.nZc);
            AppMethodBeat.o(44781);
        }

        protected ResendMsgInfo(Parcel parcel) {
            AppMethodBeat.i(44782);
            this.title = parcel.readString();
            this.pQx = parcel.readString();
            this.description = parcel.readString();
            this.nZb = parcel.readString();
            this.nZc = parcel.readString();
            AppMethodBeat.o(44782);
        }

        static {
            AppMethodBeat.i(44783);
            AppMethodBeat.o(44783);
        }
    }

    public static class d {
        public String cEh;
        public c pQv;

        public final String toString() {
            AppMethodBeat.i(44784);
            String str = "TextInfo{wording='" + this.cEh + '\'' + ", jumpInfo=" + this.pQv + '}';
            AppMethodBeat.o(44784);
            return str;
        }
    }

    public NetSceneTenpayRemittanceQuery(int i, String str, String str2, int i2) {
        AppMethodBeat.i(44785);
        this.pQe = str;
        this.pcT = i;
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        M(hashMap);
        AppMethodBeat.o(44785);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44786);
        ab.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(44786);
            return;
        }
        this.pQf = jSONObject.optInt("pay_time");
        this.kCJ = jSONObject.optDouble("fee") / 100.0d;
        this.pcl = jSONObject.optString("fee_type");
        this.status = jSONObject.optInt("trans_status");
        this.pQg = jSONObject.optString("trans_status_name");
        this.pQi = jSONObject.optInt("modify_time");
        this.nsL = jSONObject.optBoolean("is_payer");
        this.pcJ = jSONObject.optString("refund_bank_type");
        this.pQj = jSONObject.optString("status_desc");
        this.pQk = jSONObject.optString("status_supplementary");
        this.pQl = jSONObject.optInt("delay_confirm_flag");
        this.pQq = jSONObject.optString("banner_content");
        this.pQr = jSONObject.optString("banner_url");
        this.desc = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject("addr_info");
        a aVar = new a();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        aVar.pQs = optJSONObject.optString("address_name");
        aVar.gyD = optJSONObject.optString("phone_num");
        aVar.fBg = optJSONObject.optString("address");
        this.pQm = aVar;
        optJSONObject = jSONObject.optJSONObject("exposure_info");
        b bVar = new b();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        bVar.cIY = optJSONObject.optString("icon");
        bVar.name = optJSONObject.optString("name");
        bVar.cEh = optJSONObject.optString("wording");
        bVar.pQt = optJSONObject.optInt("is_show_btn");
        bVar.pQu = optJSONObject.optString("btn_wording");
        bVar.pQv = ak(optJSONObject.optJSONObject("jump_info"));
        this.pQn = bVar;
        optJSONObject = jSONObject.optJSONObject("text_info");
        d dVar = new d();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        dVar.cEh = optJSONObject.optString("wording");
        dVar.pQv = ak(optJSONObject.optJSONObject("jump_info"));
        this.pQo = dVar;
        optJSONObject = jSONObject.optJSONObject("resend_info");
        ResendMsgInfo resendMsgInfo = new ResendMsgInfo();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        resendMsgInfo.title = optJSONObject.optString("title");
        resendMsgInfo.pQx = optJSONObject.optString("pic");
        resendMsgInfo.description = optJSONObject.optString("description");
        resendMsgInfo.nZb = optJSONObject.optString("left_button_wording");
        resendMsgInfo.nZc = optJSONObject.optString("right_button_wording");
        this.pQp = resendMsgInfo;
        AppMethodBeat.o(44786);
    }

    private static c ak(JSONObject jSONObject) {
        AppMethodBeat.i(44787);
        c cVar = new c();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        cVar.type = jSONObject.optInt("type");
        cVar.url = jSONObject.optString("url");
        cVar.username = jSONObject.optString("username");
        cVar.pQw = jSONObject.optString("pagepath");
        AppMethodBeat.o(44787);
        return cVar;
    }
}
