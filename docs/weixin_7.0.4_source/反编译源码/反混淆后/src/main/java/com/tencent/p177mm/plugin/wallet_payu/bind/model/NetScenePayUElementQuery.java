package com.tencent.p177mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery */
public final class NetScenePayUElementQuery extends C36383a {
    public String tSD;
    public PayUBankcardElement tSF;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery$PayUBankcardElement */
    public static class PayUBankcardElement implements Parcelable {
        public String cEW = "";
        public String cardType = "";
        public String pcj = "";
        public String tSG = "";
        public String tSH = "";

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(48334);
            parcel.writeString(this.tSG);
            parcel.writeString(this.pcj);
            parcel.writeString(this.tSH);
            parcel.writeString(this.cardType);
            parcel.writeString(this.cEW);
            AppMethodBeat.m2505o(48334);
        }
    }

    public NetScenePayUElementQuery(String str) {
        AppMethodBeat.m2504i(48335);
        this.tSD = str;
        HashMap hashMap = new HashMap();
        hashMap.put("card_number", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48335);
    }

    public final int cOX() {
        return 22;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48336);
        this.tSF = new PayUBankcardElement();
        this.tSF.tSG = jSONObject.optString("bin");
        this.tSF.pcj = jSONObject.optString("bank_name");
        this.tSF.tSH = jSONObject.optString("issuer_type");
        this.tSF.cardType = jSONObject.optString("card_type");
        this.tSF.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48336);
    }
}
