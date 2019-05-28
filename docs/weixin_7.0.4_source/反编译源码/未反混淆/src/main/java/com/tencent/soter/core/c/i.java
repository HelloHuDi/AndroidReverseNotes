package com.tencent.soter.core.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    long Avl = -1;
    private String Avm = "";
    public String Avn = "";
    private ArrayList<String> Avo = null;
    public String rOh = "";
    public String signature = "";
    public int uid = -1;

    public final String toString() {
        AppMethodBeat.i(73044);
        String str = "SoterPubKeyModel{counter=" + this.Avl + ", uid=" + this.uid + ", cpu_id='" + this.rOh + '\'' + ", pub_key_in_x509='" + this.Avm + '\'' + ", rawJson='" + this.Avn + '\'' + ", signature='" + this.signature + '\'' + '}';
        AppMethodBeat.o(73044);
        return str;
    }

    public i(String str, String str2) {
        AppMethodBeat.i(73045);
        this.Avn = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("certs")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("certs");
                if (optJSONArray.length() < 2) {
                    d.e("Soter.SoterPubKeyModel", "certificates train not enough", new Object[0]);
                }
                d.i("Soter.SoterPubKeyModel", "certs size: [%d]", Integer.valueOf(optJSONArray.length()));
                this.Avo = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Avo.add(optJSONArray.getString(i));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String) this.Avo.get(0)).getBytes())));
            } else {
                this.Avl = jSONObject.optLong("counter");
                this.uid = jSONObject.optInt("uid");
                this.rOh = jSONObject.optString("cpu_id");
                this.Avm = jSONObject.optString("pub_key");
            }
        } catch (Exception e) {
            d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
        AppMethodBeat.o(73045);
    }

    public i(Certificate[] certificateArr) {
        AppMethodBeat.i(73046);
        if (certificateArr != null) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < certificateArr.length; i++) {
                    Certificate certificate = certificateArr[i];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a = a.a(certificate);
                    if (i == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.put(a);
                    arrayList.add(a);
                }
                this.Avo = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("certs", jSONArray);
                this.Avn = jSONObject.toString();
            } catch (Exception e) {
                d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
                AppMethodBeat.o(73046);
                return;
            }
        }
        AppMethodBeat.o(73046);
    }

    private void a(X509Certificate x509Certificate) {
        AppMethodBeat.i(73047);
        try {
            a.a(x509Certificate, this);
            AppMethodBeat.o(73047);
        } catch (Exception e) {
            d.e("Soter.SoterPubKeyModel", "soter: loadDeviceInfo from attestationCert failed" + e.getStackTrace(), new Object[0]);
            AppMethodBeat.o(73047);
        }
    }
}
