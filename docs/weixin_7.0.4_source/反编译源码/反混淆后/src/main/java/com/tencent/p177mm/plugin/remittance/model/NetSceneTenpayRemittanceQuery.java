package com.tencent.p177mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery */
public final class NetSceneTenpayRemittanceQuery extends C5749m {
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
    public C3720a pQm;
    public C3721b pQn;
    public C21643d pQo;
    public ResendMsgInfo pQp;
    public String pQq;
    public String pQr;
    public String pcJ;
    public int pcT;
    public String pcl;
    public int status;

    /* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery$a */
    public static class C3720a {
        public String fBg;
        public String gyD;
        public String pQs;

        public final String toString() {
            AppMethodBeat.m2504i(44776);
            String str = "AddressInfo{addressName='" + this.pQs + '\'' + ", phoneNum='" + this.gyD + '\'' + ", address='" + this.fBg + '\'' + '}';
            AppMethodBeat.m2505o(44776);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery$b */
    public static class C3721b {
        public String cEh;
        public String cIY;
        public String name;
        public int pQt;
        public String pQu;
        public C3722c pQv;

        public final String toString() {
            AppMethodBeat.m2504i(44777);
            String str = "ExposureInfo{icon='" + this.cIY + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.cEh + '\'' + ", isShowBtn=" + this.pQt + ", btnWording='" + this.pQu + '\'' + ", jumpInfo=" + this.pQv + '}';
            AppMethodBeat.m2505o(44777);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery$c */
    public static class C3722c {
        public String pQw;
        public int type;
        public String url;
        public String username;

        public final String toString() {
            AppMethodBeat.m2504i(44778);
            String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.pQw + '\'' + '}';
            AppMethodBeat.m2505o(44778);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery$ResendMsgInfo */
    public static class ResendMsgInfo implements Parcelable {
        public static final Creator<ResendMsgInfo> CREATOR = new C216421();
        public String description;
        public String nZb;
        public String nZc;
        public String pQx;
        public String title;

        /* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery$ResendMsgInfo$1 */
        static class C216421 implements Creator<ResendMsgInfo> {
            C216421() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResendMsgInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(44779);
                ResendMsgInfo resendMsgInfo = new ResendMsgInfo(parcel);
                AppMethodBeat.m2505o(44779);
                return resendMsgInfo;
            }
        }

        public String toString() {
            AppMethodBeat.m2504i(44780);
            String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.pQx + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.nZb + '\'' + ", right_button_wording='" + this.nZc + '\'' + '}';
            AppMethodBeat.m2505o(44780);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(44781);
            parcel.writeString(this.title);
            parcel.writeString(this.pQx);
            parcel.writeString(this.description);
            parcel.writeString(this.nZb);
            parcel.writeString(this.nZc);
            AppMethodBeat.m2505o(44781);
        }

        protected ResendMsgInfo(Parcel parcel) {
            AppMethodBeat.m2504i(44782);
            this.title = parcel.readString();
            this.pQx = parcel.readString();
            this.description = parcel.readString();
            this.nZb = parcel.readString();
            this.nZc = parcel.readString();
            AppMethodBeat.m2505o(44782);
        }

        static {
            AppMethodBeat.m2504i(44783);
            AppMethodBeat.m2505o(44783);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery$d */
    public static class C21643d {
        public String cEh;
        public C3722c pQv;

        public final String toString() {
            AppMethodBeat.m2504i(44784);
            String str = "TextInfo{wording='" + this.cEh + '\'' + ", jumpInfo=" + this.pQv + '}';
            AppMethodBeat.m2505o(44784);
            return str;
        }
    }

    public NetSceneTenpayRemittanceQuery(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(44785);
        this.pQe = str;
        this.pcT = i;
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(44785);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44786);
        C4990ab.m7410d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(44786);
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
        C3720a c3720a = new C3720a();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        c3720a.pQs = optJSONObject.optString("address_name");
        c3720a.gyD = optJSONObject.optString("phone_num");
        c3720a.fBg = optJSONObject.optString("address");
        this.pQm = c3720a;
        optJSONObject = jSONObject.optJSONObject("exposure_info");
        C3721b c3721b = new C3721b();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        c3721b.cIY = optJSONObject.optString("icon");
        c3721b.name = optJSONObject.optString("name");
        c3721b.cEh = optJSONObject.optString("wording");
        c3721b.pQt = optJSONObject.optInt("is_show_btn");
        c3721b.pQu = optJSONObject.optString("btn_wording");
        c3721b.pQv = NetSceneTenpayRemittanceQuery.m33142ak(optJSONObject.optJSONObject("jump_info"));
        this.pQn = c3721b;
        optJSONObject = jSONObject.optJSONObject("text_info");
        C21643d c21643d = new C21643d();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        c21643d.cEh = optJSONObject.optString("wording");
        c21643d.pQv = NetSceneTenpayRemittanceQuery.m33142ak(optJSONObject.optJSONObject("jump_info"));
        this.pQo = c21643d;
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
        AppMethodBeat.m2505o(44786);
    }

    /* renamed from: ak */
    private static C3722c m33142ak(JSONObject jSONObject) {
        AppMethodBeat.m2504i(44787);
        C3722c c3722c = new C3722c();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c3722c.type = jSONObject.optInt("type");
        c3722c.url = jSONObject.optString("url");
        c3722c.username = jSONObject.optString("username");
        c3722c.pQw = jSONObject.optString("pagepath");
        AppMethodBeat.m2505o(44787);
        return c3722c;
    }
}
