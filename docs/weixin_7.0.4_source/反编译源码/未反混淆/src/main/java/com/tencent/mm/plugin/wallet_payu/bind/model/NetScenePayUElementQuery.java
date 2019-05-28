package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String tSD;
    public PayUBankcardElement tSF;

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
            AppMethodBeat.i(48334);
            parcel.writeString(this.tSG);
            parcel.writeString(this.pcj);
            parcel.writeString(this.tSH);
            parcel.writeString(this.cardType);
            parcel.writeString(this.cEW);
            AppMethodBeat.o(48334);
        }
    }

    public NetScenePayUElementQuery(String str) {
        AppMethodBeat.i(48335);
        this.tSD = str;
        HashMap hashMap = new HashMap();
        hashMap.put("card_number", str);
        M(hashMap);
        AppMethodBeat.o(48335);
    }

    public final int cOX() {
        return 22;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48336);
        this.tSF = new PayUBankcardElement();
        this.tSF.tSG = jSONObject.optString("bin");
        this.tSF.pcj = jSONObject.optString("bank_name");
        this.tSF.tSH = jSONObject.optString("issuer_type");
        this.tSF.cardType = jSONObject.optString("card_type");
        this.tSF.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48336);
    }
}
