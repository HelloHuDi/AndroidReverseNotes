package com.tencent.p177mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44141lp;
import com.tencent.p177mm.protocal.protobuf.abw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.BusiRemittanceResp */
public class BusiRemittanceResp implements Parcelable {
    public static final Creator<BusiRemittanceResp> CREATOR = new C37191();
    public int pOA;
    public String pOB;
    public String pOC;
    public List<abw> pOD = new LinkedList();
    public C44141lp pOE;
    public int pOF = 0;
    public int pOG = 0;
    public int pOH = 400;
    public int pOx = 0;
    public String pOy = "";
    public String pOz = "";

    /* renamed from: com.tencent.mm.plugin.remittance.model.BusiRemittanceResp$1 */
    static class C37191 implements Creator<BusiRemittanceResp> {
        C37191() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BusiRemittanceResp[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(44721);
            BusiRemittanceResp busiRemittanceResp = new BusiRemittanceResp(parcel);
            AppMethodBeat.m2505o(44721);
            return busiRemittanceResp;
        }
    }

    BusiRemittanceResp() {
        AppMethodBeat.m2504i(44722);
        AppMethodBeat.m2505o(44722);
    }

    BusiRemittanceResp(JSONObject jSONObject) {
        AppMethodBeat.m2504i(44723);
        this.pOx = jSONObject.optInt("show_photo", 0);
        this.pOy = jSONObject.optString("photo_url", "");
        this.pOz = jSONObject.optString("favor_desc", "");
        this.pOA = jSONObject.optInt("scan_scene", 0);
        this.pOB = jSONObject.optString("favor_req_sign", "");
        this.pOC = jSONObject.optString("favor_req_extend", "");
        this.pOF = jSONObject.optInt("get_favor_flag", 0);
        this.pOG = jSONObject.optInt("photo_style", 0);
        this.pOH = jSONObject.optInt("get_favor_interval", 400);
        this.pOD = C43452b.m77575w(jSONObject.optJSONArray("favor_list"));
        JSONObject optJSONObject = jSONObject.optJSONObject("favor_comm_resp");
        if (optJSONObject != null) {
            this.pOE = new C44141lp();
            this.pOE.vPi = optJSONObject.optString("default_fav_compose_id");
            this.pOE.vPg = C43452b.m77575w(optJSONObject.optJSONArray("favor_info_list"));
            this.pOE.vPj = optJSONObject.optString("favor_resp_sign");
            this.pOE.vPk = optJSONObject.optString("no_compose_wording");
            this.pOE.vPh = C43452b.m77574v(optJSONObject.optJSONArray("favor_compose_result_list"));
        }
        AppMethodBeat.m2505o(44723);
    }

    protected BusiRemittanceResp(Parcel parcel) {
        int readInt;
        byte[] bArr;
        AppMethodBeat.m2504i(44724);
        this.pOx = parcel.readInt();
        this.pOy = parcel.readString();
        this.pOz = parcel.readString();
        this.pOA = parcel.readInt();
        this.pOB = parcel.readString();
        this.pOC = parcel.readString();
        this.pOF = parcel.readInt();
        this.pOG = parcel.readInt();
        this.pOH = parcel.readInt();
        this.pOD = new LinkedList();
        int readInt2 = parcel.readInt();
        for (int i = 0; i < readInt2; i++) {
            readInt = parcel.readInt();
            if (readInt > 0) {
                bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                try {
                    abw abw = new abw();
                    abw.parseFrom(bArr);
                    this.pOD.add(abw);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                }
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            this.pOE = new C44141lp();
            try {
                this.pOE.parseFrom(bArr);
                AppMethodBeat.m2505o(44724);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(44724);
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte[] toByteArray;
        AppMethodBeat.m2504i(44725);
        parcel.writeInt(this.pOx);
        parcel.writeString(this.pOy);
        parcel.writeString(this.pOz);
        parcel.writeInt(this.pOA);
        parcel.writeString(this.pOB);
        parcel.writeString(this.pOC);
        parcel.writeInt(this.pOF);
        parcel.writeInt(this.pOG);
        parcel.writeInt(this.pOH);
        parcel.writeInt(this.pOD.size());
        if (this.pOD.size() > 0) {
            for (int i2 = 0; i2 < this.pOD.size(); i2++) {
                byte[] bArr = new byte[0];
                try {
                    toByteArray = ((abw) this.pOD.get(i2)).toByteArray();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                    toByteArray = bArr;
                }
                parcel.writeInt(toByteArray.length);
                if (toByteArray.length > 0) {
                    parcel.writeByteArray(toByteArray);
                }
            }
        }
        toByteArray = new byte[0];
        try {
            toByteArray = this.pOE.toByteArray();
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
        }
        parcel.writeInt(toByteArray.length);
        if (toByteArray.length > 0) {
            parcel.writeByteArray(toByteArray);
        }
        AppMethodBeat.m2505o(44725);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(44726);
        AppMethodBeat.m2505o(44726);
    }
}
