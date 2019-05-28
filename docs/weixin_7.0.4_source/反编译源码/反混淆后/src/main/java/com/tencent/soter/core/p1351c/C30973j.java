package com.tencent.soter.core.p1351c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.soter.core.c.j */
public final class C30973j {
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
        AppMethodBeat.m2504i(73048);
        String str = "SoterSignatureResult{rawValue='" + this.Avp + '\'' + ", fid='" + this.Avq + '\'' + ", counter=" + this.Avl + ", TEEName='" + this.Avr + '\'' + ", TEEVersion='" + this.Avs + '\'' + ", FpName='" + this.Avt + '\'' + ", FpVersion='" + this.Avu + '\'' + ", cpuId='" + this.Avv + '\'' + ", saltLen=" + this.Avw + ", jsonValue='" + this.Avx + '\'' + ", signature='" + this.signature + '\'' + '}';
        AppMethodBeat.m2505o(73048);
        return str;
    }

    public static C30973j aue(String str) {
        AppMethodBeat.m2504i(73049);
        try {
            JSONObject jSONObject = new JSONObject(str);
            C30973j c30973j = new C30973j();
            c30973j.Avx = str;
            c30973j.Avp = jSONObject.optString("raw");
            c30973j.Avq = jSONObject.optString("fid");
            c30973j.Avl = jSONObject.optLong("counter");
            c30973j.Avr = jSONObject.optString("tee_n");
            c30973j.Avs = jSONObject.optString("tee_v");
            c30973j.Avt = jSONObject.optString("fp_n");
            c30973j.Avu = jSONObject.optString("fp_v");
            c30973j.Avv = jSONObject.optString("cpu_id");
            c30973j.Avw = jSONObject.optInt("rsa_pss_saltlen", 20);
            AppMethodBeat.m2505o(73049);
            return c30973j;
        } catch (JSONException e) {
            C44476d.m80483e("Soter.SoterSignatureResult", "soter: convert from json failed." + e.toString(), new Object[0]);
            AppMethodBeat.m2505o(73049);
            return null;
        }
    }
}
