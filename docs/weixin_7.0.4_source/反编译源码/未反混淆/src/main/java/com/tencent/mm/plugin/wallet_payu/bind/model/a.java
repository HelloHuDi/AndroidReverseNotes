package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String cQY;
    public String description;
    public String pin;
    public String tDI;
    public String tSC;
    public String tSD;
    public String tSE;
    public String tSs;

    public final int cOX() {
        return 0;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(48333);
        this.tSC = str;
        this.tDI = str2;
        this.cQY = str3;
        this.tSD = str4;
        this.tSE = str5;
        this.description = str6;
        this.tSs = str7;
        this.pin = str8;
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("information", str2);
        hashMap.put("name_on_card", str3);
        hashMap.put("card_number", str4);
        hashMap.put("card_expiry", str5);
        hashMap.put("description", str6);
        hashMap.put("cvv", str7);
        hashMap.put("pin", str8);
        M(hashMap);
        AppMethodBeat.o(48333);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
