package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c {
    public String gtl;
    public String kWz;
    String mPackageName;
    public String mSignature;
    String tQR;
    public String tQS;
    long tQT;
    int tQU;
    public String tQV;
    public String tQW;
    public String tQX;
    public String tQY;

    public c(String str, String str2, String str3) {
        AppMethodBeat.i(48171);
        this.tQR = str;
        this.tQW = str2;
        JSONObject jSONObject = new JSONObject(this.tQW);
        this.tQS = jSONObject.optString("orderId");
        this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        this.kWz = jSONObject.optString("productId");
        this.tQT = jSONObject.optLong("purchaseTime");
        this.tQU = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList adi = adi(optString);
        if (adi.size() == 3) {
            this.tQV = (String) adi.get(0);
            this.tQY = (String) adi.get(1);
            this.tQX = (String) adi.get(2);
        } else {
            this.tQV = optString;
        }
        this.gtl = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.mSignature = str3;
        AppMethodBeat.o(48171);
    }

    public c(String str, String str2, String str3, String str4) {
        this.kWz = str;
        this.tQV = str2;
        this.tQX = str3;
        this.tQY = str4;
    }

    private static ArrayList<String> adi(String str) {
        AppMethodBeat.i(48172);
        ArrayList arrayList = new ArrayList();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        AppMethodBeat.o(48172);
        return arrayList;
    }

    public final String toString() {
        AppMethodBeat.i(48173);
        String str = "PurchaseInfo(type:" + this.tQR + "):" + this.tQW;
        AppMethodBeat.o(48173);
        return str;
    }
}
