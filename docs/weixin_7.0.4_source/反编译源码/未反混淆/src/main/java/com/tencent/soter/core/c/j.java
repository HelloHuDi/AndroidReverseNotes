package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    private long Avl = -1;
    private String Avp = null;
    public String Avq = null;
    private String Avr = "";
    private String Avs = "";
    private String Avt = "";
    private String Avu = "";
    private String Avv = "";
    public int Avw = 20;
    public String Avx = "";
    public String signature = "";

    public final String toString() {
        AppMethodBeat.i(73048);
        String str = "SoterSignatureResult{rawValue='" + this.Avp + '\'' + ", fid='" + this.Avq + '\'' + ", counter=" + this.Avl + ", TEEName='" + this.Avr + '\'' + ", TEEVersion='" + this.Avs + '\'' + ", FpName='" + this.Avt + '\'' + ", FpVersion='" + this.Avu + '\'' + ", cpuId='" + this.Avv + '\'' + ", saltLen=" + this.Avw + ", jsonValue='" + this.Avx + '\'' + ", signature='" + this.signature + '\'' + '}';
        AppMethodBeat.o(73048);
        return str;
    }

    public static j aue(String str) {
        AppMethodBeat.i(73049);
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.Avx = str;
            jVar.Avp = jSONObject.optString("raw");
            jVar.Avq = jSONObject.optString("fid");
            jVar.Avl = jSONObject.optLong("counter");
            jVar.Avr = jSONObject.optString("tee_n");
            jVar.Avs = jSONObject.optString("tee_v");
            jVar.Avt = jSONObject.optString("fp_n");
            jVar.Avu = jSONObject.optString("fp_v");
            jVar.Avv = jSONObject.optString("cpu_id");
            jVar.Avw = jSONObject.optInt("rsa_pss_saltlen", 20);
            AppMethodBeat.o(73049);
            return jVar;
        } catch (JSONException e) {
            d.e("Soter.SoterSignatureResult", "soter: convert from json failed." + e.toString(), new Object[0]);
            AppMethodBeat.o(73049);
            return null;
        }
    }
}
