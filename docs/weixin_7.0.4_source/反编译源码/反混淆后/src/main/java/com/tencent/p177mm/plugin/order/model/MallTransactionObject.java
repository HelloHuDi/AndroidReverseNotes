package com.tencent.p177mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.order.model.MallTransactionObject */
public class MallTransactionObject implements Parcelable {
    public static final Creator<MallTransactionObject> CREATOR = new C286581();
    public String cAa;
    public int cQO;
    public int coq;
    public int cuu;
    public String desc;
    public int fDG;
    public String hgW;
    public double kCJ = 0.0d;
    public List<HelpCenter> pbM = new LinkedList();
    public int pbN = -1;
    public String pbP;
    public String pbX;
    public String pbY;
    public String pbZ;
    public String pcA;
    public int pcB;
    public String pcC;
    public int pcD;
    public int pcE;
    public int pcF;
    public String pcG;
    public String pcH;
    public String pcI;
    public String pcJ;
    public String pcK;
    public String pcL;
    public double pcM;
    public String pcN;
    public String pca;
    public String pcb;
    public String pcc;
    public String pcd;
    public String pce;
    public String pcf;
    public String pcg;
    public int pch;
    public String pci;
    public String pcj;
    public String pck;
    public String pcl;
    public String pcm;
    public String pcn;
    public String pco;
    public String pcp;
    public String pcq;
    public double pcr;
    public String pcs;
    public String pct;
    public String pcu;
    public String pcv;
    public String pcw;
    public int pcx;
    public int pcy;
    public double pcz;
    public int type;

    /* renamed from: com.tencent.mm.plugin.order.model.MallTransactionObject$1 */
    static class C286581 implements Creator<MallTransactionObject> {
        C286581() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallTransactionObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(43766);
            MallTransactionObject mallTransactionObject = new MallTransactionObject(parcel);
            AppMethodBeat.m2505o(43766);
            return mallTransactionObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject() {
        AppMethodBeat.m2504i(43767);
        AppMethodBeat.m2505o(43767);
    }

    public MallTransactionObject(Parcel parcel) {
        AppMethodBeat.m2504i(43768);
        this.cuu = parcel.readInt();
        this.cQO = parcel.readInt();
        this.coq = parcel.readInt();
        this.pbX = parcel.readString();
        this.pbY = parcel.readString();
        this.pbZ = parcel.readString();
        this.pca = parcel.readString();
        this.desc = parcel.readString();
        this.pcb = parcel.readString();
        this.pcc = parcel.readString();
        this.kCJ = parcel.readDouble();
        this.pcd = parcel.readString();
        this.pce = parcel.readString();
        this.pcf = parcel.readString();
        this.pcg = parcel.readString();
        this.fDG = parcel.readInt();
        this.pch = parcel.readInt();
        this.cAa = parcel.readString();
        this.pci = parcel.readString();
        this.pcj = parcel.readString();
        this.pcl = parcel.readString();
        this.pcm = parcel.readString();
        this.pbP = parcel.readString();
        this.pcn = parcel.readString();
        this.hgW = parcel.readString();
        this.pco = parcel.readString();
        this.pcp = parcel.readString();
        this.pcq = parcel.readString();
        this.pcr = parcel.readDouble();
        this.pcs = parcel.readString();
        this.pct = parcel.readString();
        this.pcu = parcel.readString();
        this.pcv = parcel.readString();
        this.pcx = parcel.readInt();
        this.pcD = parcel.readInt();
        this.pcz = parcel.readDouble();
        this.pcA = parcel.readString();
        this.pcB = parcel.readInt();
        this.pcC = parcel.readString();
        this.pcD = parcel.readInt();
        this.pcE = parcel.readInt();
        this.pcF = parcel.readInt();
        this.pcG = parcel.readString();
        this.pcH = parcel.readString();
        this.pcI = parcel.readString();
        this.pcJ = parcel.readString();
        this.pcK = parcel.readString();
        this.pcL = parcel.readString();
        this.pcM = parcel.readDouble();
        this.pcN = parcel.readString();
        this.pcw = parcel.readString();
        this.pbN = parcel.readInt();
        int readInt = parcel.readInt();
        this.pbM = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.pbM.add((HelpCenter) parcel.readParcelable(HelpCenter.class.getClassLoader()));
        }
        AppMethodBeat.m2505o(43768);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(43769);
        parcel.writeInt(this.cuu);
        parcel.writeInt(this.cQO);
        parcel.writeInt(this.coq);
        parcel.writeString(this.pbX);
        parcel.writeString(this.pbY);
        parcel.writeString(this.pbZ);
        parcel.writeString(this.pca);
        parcel.writeString(this.desc);
        parcel.writeString(this.pcb);
        parcel.writeString(this.pcc);
        parcel.writeDouble(this.kCJ);
        parcel.writeString(this.pcd);
        parcel.writeString(this.pce);
        parcel.writeString(this.pcf);
        parcel.writeString(this.pcg);
        parcel.writeInt(this.fDG);
        parcel.writeInt(this.pch);
        parcel.writeString(this.cAa);
        parcel.writeString(this.pci);
        parcel.writeString(this.pcj);
        parcel.writeString(this.pcl);
        parcel.writeString(this.pcm);
        parcel.writeString(this.pbP);
        parcel.writeString(this.pcn);
        parcel.writeString(this.hgW);
        parcel.writeString(this.pco);
        parcel.writeString(this.pcp);
        parcel.writeString(this.pcq);
        parcel.writeDouble(this.pcr);
        parcel.writeString(this.pcs);
        parcel.writeString(this.pct);
        parcel.writeString(this.pcu);
        parcel.writeString(this.pcv);
        parcel.writeInt(this.pcx);
        parcel.writeInt(this.pcD);
        parcel.writeDouble(this.pcz);
        parcel.writeString(this.pcA);
        parcel.writeInt(this.pcB);
        parcel.writeString(this.pcC);
        parcel.writeInt(this.pcD);
        parcel.writeInt(this.pcE);
        parcel.writeInt(this.pcF);
        parcel.writeString(this.pcG);
        parcel.writeString(this.pcH);
        parcel.writeString(this.pcI);
        parcel.writeString(this.pcJ);
        parcel.writeString(this.pcK);
        parcel.writeString(this.pcL);
        parcel.writeDouble(this.pcM);
        parcel.writeString(this.pcN);
        parcel.writeString(this.pcw);
        parcel.writeInt(this.pbN);
        parcel.writeInt(this.pbM.size());
        for (HelpCenter writeParcelable : this.pbM) {
            parcel.writeParcelable(writeParcelable, i);
        }
        AppMethodBeat.m2505o(43769);
    }

    static {
        AppMethodBeat.m2504i(43772);
        AppMethodBeat.m2505o(43772);
    }

    /* renamed from: ae */
    public static MallTransactionObject m45542ae(JSONObject jSONObject) {
        AppMethodBeat.m2504i(43770);
        if (jSONObject != null) {
            MallTransactionObject mallTransactionObject = new MallTransactionObject();
            mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
            mallTransactionObject.cuu = jSONObject.optInt("sub_pay_type", 0);
            mallTransactionObject.cQO = jSONObject.optInt("pay_scene");
            mallTransactionObject.coq = jSONObject.optInt("user_type");
            mallTransactionObject.pbX = jSONObject.optString("buy_uin");
            mallTransactionObject.pbY = jSONObject.optString("buy_name");
            mallTransactionObject.pbZ = jSONObject.optString("sale_uin");
            mallTransactionObject.pca = jSONObject.optString("sale_name");
            mallTransactionObject.cAa = jSONObject.optString("trans_id");
            mallTransactionObject.pci = jSONObject.optString("sp_billno");
            mallTransactionObject.desc = jSONObject.optString("goods_name");
            mallTransactionObject.pcb = jSONObject.optString("goods_detail");
            mallTransactionObject.kCJ = jSONObject.optDouble("fee") / 100.0d;
            mallTransactionObject.pcd = jSONObject.optString("fee_color");
            mallTransactionObject.pce = jSONObject.optString("trade_state");
            mallTransactionObject.pcf = jSONObject.optString("trade_state_name");
            mallTransactionObject.pcg = jSONObject.optString("trade_state_color");
            mallTransactionObject.pcj = jSONObject.optString("buy_bank_name");
            mallTransactionObject.pck = jSONObject.optString("card_tail");
            mallTransactionObject.fDG = jSONObject.optInt("create_timestamp");
            mallTransactionObject.pch = jSONObject.optInt("modify_timestamp");
            mallTransactionObject.pcl = jSONObject.optString("fee_type");
            JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
            if (optJSONObject != null) {
                mallTransactionObject.pcm = optJSONObject.optString("app_username");
                mallTransactionObject.pbP = optJSONObject.optString("app_telephone");
                mallTransactionObject.pcn = optJSONObject.optString("app_nickname");
                mallTransactionObject.hgW = optJSONObject.optString("app_icon_url");
                mallTransactionObject.pcv = optJSONObject.optString("safeguard_url");
                mallTransactionObject.pcw = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
            }
            mallTransactionObject.pco = jSONObject.optString("deliver_price");
            mallTransactionObject.pcp = jSONObject.optString("preferential_price");
            mallTransactionObject.pcq = jSONObject.optString("discount");
            mallTransactionObject.pcr = jSONObject.optDouble("original_total_fee") / 100.0d;
            mallTransactionObject.pcs = jSONObject.optString("total_price");
            mallTransactionObject.pct = jSONObject.optString("receipt_company");
            mallTransactionObject.pcu = jSONObject.optString("biz_pledge");
            mallTransactionObject.pcx = jSONObject.optInt("pre_fetch_timestamp");
            mallTransactionObject.pcy = jSONObject.optInt("arrived_timestamp");
            mallTransactionObject.pcz = jSONObject.optDouble("transfer_fee") / 100.0d;
            mallTransactionObject.pcA = jSONObject.optString("receiver_name");
            mallTransactionObject.pcB = jSONObject.optInt("allow_resend_msg");
            mallTransactionObject.pcC = jSONObject.optString("charge_fee");
            mallTransactionObject.pcD = jSONObject.optInt("receive_timestamp");
            mallTransactionObject.pcE = jSONObject.optInt("refund_timestamp");
            mallTransactionObject.pcF = jSONObject.optInt("create_timestamp");
            mallTransactionObject.pcG = jSONObject.optString("buy_bank_type");
            mallTransactionObject.pcH = jSONObject.optString("payer_name");
            mallTransactionObject.pcI = jSONObject.optString("true_name");
            mallTransactionObject.pcJ = jSONObject.optString("refund_bank_type");
            mallTransactionObject.pcK = jSONObject.optString("rateinfo");
            mallTransactionObject.pcL = jSONObject.optString("original_feeinfo");
            mallTransactionObject.pcM = jSONObject.optDouble("fetch_total_fee") / 100.0d;
            mallTransactionObject.pcN = jSONObject.optString("fetch_total_fee_color");
            mallTransactionObject.pbN = jSONObject.optInt("userroll_type");
            mallTransactionObject.pbM = MallTransactionObject.m45543af(jSONObject);
            AppMethodBeat.m2505o(43770);
            return mallTransactionObject;
        }
        AppMethodBeat.m2505o(43770);
        return null;
    }

    /* renamed from: af */
    private static List<HelpCenter> m45543af(JSONObject jSONObject) {
        AppMethodBeat.m2504i(43771);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i = 0; i < jSONArray.length(); i++) {
                HelpCenter helpCenter = new HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                helpCenter.cui = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString("url");
                linkedList.add(helpCenter);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MallTransactionObject", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", e.getMessage());
        }
        AppMethodBeat.m2505o(43771);
        return linkedList;
    }
}
