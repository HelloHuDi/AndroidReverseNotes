package com.tencent.soter.core.p1351c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.soter.core.c.i */
public final class C30972i {
    long Avl = -1;
    private String Avm = "";
    public String Avn = "";
    private ArrayList<String> Avo = null;
    public String rOh = "";
    public String signature = "";
    public int uid = -1;

    public final String toString() {
        AppMethodBeat.m2504i(73044);
        String str = "SoterPubKeyModel{counter=" + this.Avl + ", uid=" + this.uid + ", cpu_id='" + this.rOh + '\'' + ", pub_key_in_x509='" + this.Avm + '\'' + ", rawJson='" + this.Avn + '\'' + ", signature='" + this.signature + '\'' + '}';
        AppMethodBeat.m2505o(73044);
        return str;
    }

    public C30972i(String str, String str2) {
        AppMethodBeat.m2504i(73045);
        this.Avn = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("certs")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("certs");
                if (optJSONArray.length() < 2) {
                    C44476d.m80483e("Soter.SoterPubKeyModel", "certificates train not enough", new Object[0]);
                }
                C44476d.m80484i("Soter.SoterPubKeyModel", "certs size: [%d]", Integer.valueOf(optJSONArray.length()));
                this.Avo = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Avo.add(optJSONArray.getString(i));
                }
                m49597a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String) this.Avo.get(0)).getBytes())));
            } else {
                this.Avl = jSONObject.optLong("counter");
                this.uid = jSONObject.optInt("uid");
                this.rOh = jSONObject.optString("cpu_id");
                this.Avm = jSONObject.optString("pub_key");
            }
        } catch (Exception e) {
            C44476d.m80483e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
        AppMethodBeat.m2505o(73045);
    }

    public C30972i(Certificate[] certificateArr) {
        AppMethodBeat.m2504i(73046);
        if (certificateArr != null) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < certificateArr.length; i++) {
                    Certificate certificate = certificateArr[i];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a = C24320a.m37488a(certificate);
                    if (i == 0) {
                        m49597a((X509Certificate) certificate);
                    }
                    jSONArray.put(a);
                    arrayList.add(a);
                }
                this.Avo = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("certs", jSONArray);
                this.Avn = jSONObject.toString();
            } catch (Exception e) {
                C44476d.m80483e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
                AppMethodBeat.m2505o(73046);
                return;
            }
        }
        AppMethodBeat.m2505o(73046);
    }

    /* renamed from: a */
    private void m49597a(X509Certificate x509Certificate) {
        AppMethodBeat.m2504i(73047);
        try {
            C24320a.m37490a(x509Certificate, this);
            AppMethodBeat.m2505o(73047);
        } catch (Exception e) {
            C44476d.m80483e("Soter.SoterPubKeyModel", "soter: loadDeviceInfo from attestationCert failed" + e.getStackTrace(), new Object[0]);
            AppMethodBeat.m2505o(73047);
        }
    }
}
