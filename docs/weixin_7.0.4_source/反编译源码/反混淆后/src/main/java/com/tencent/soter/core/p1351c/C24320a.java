package com.tencent.soter.core.p1351c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* renamed from: com.tencent.soter.core.c.a */
public class C24320a {
    static final /* synthetic */ boolean $assertionsDisabled = (!C24320a.class.desiredAssertionStatus());

    static {
        AppMethodBeat.m2504i(73018);
        AppMethodBeat.m2505o(73018);
    }

    /* renamed from: a */
    private static void m37489a(BufferedWriter bufferedWriter, byte[] bArr) {
        AppMethodBeat.m2504i(73015);
        char[] cArr = new char[64];
        int i = 0;
        while (i < bArr.length) {
            int i2 = 0;
            while (i2 != 64 && i + i2 < bArr.length) {
                cArr[i2] = (char) bArr[i + i2];
                i2++;
            }
            bufferedWriter.write(cArr, 0, i2);
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            i += 64;
        }
        AppMethodBeat.m2505o(73015);
    }

    /* renamed from: a */
    public static String m37488a(Certificate certificate) {
        AppMethodBeat.m2504i(73016);
        String str = "CERTIFICATE";
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN " + str + "-----");
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        C24320a.m37489a(bufferedWriter, Base64.encode(certificate.getEncoded(), 2));
        bufferedWriter.write("-----END " + str + "-----");
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        bufferedWriter.close();
        str = stringWriter.toString();
        AppMethodBeat.m2505o(73016);
        return str;
    }

    /* renamed from: a */
    public static void m37490a(X509Certificate x509Certificate, C30972i c30972i) {
        AppMethodBeat.m2504i(73017);
        byte[] extensionValue = x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        Exception exception;
        if (extensionValue == null || extensionValue.length == 0) {
            exception = new Exception("Couldn't find the keystore attestation extension data.");
            AppMethodBeat.m2505o(73017);
            throw exception;
        }
        try {
            byte b = "{".getBytes()[0];
            byte b2 = "}".getBytes()[0];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < extensionValue.length; i3++) {
                byte b3 = extensionValue[i3];
                if (b3 == b) {
                    i2 = i3;
                } else if (b3 == b2) {
                    i = i3;
                }
            }
            if (i2 > 0 && i2 < i) {
                if ($assertionsDisabled || extensionValue[i2 - 1] == (i - i2) + 1) {
                    i = (i - i2) + 1;
                    byte[] bArr = new byte[i];
                    System.arraycopy(extensionValue, i2, bArr, 0, i);
                    String str = new String(bArr);
                    C44476d.m80484i("Soter.CertUtil", "soter: challenge json in attestation certificate ".concat(String.valueOf(str)), new Object[0]);
                    JSONObject jSONObject = new JSONObject(str);
                    c30972i.rOh = jSONObject.getString("cpu_id");
                    c30972i.uid = jSONObject.getInt("uid");
                    c30972i.Avl = jSONObject.getLong("counter");
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.m2505o(73017);
                    throw assertionError;
                }
            }
            AppMethodBeat.m2505o(73017);
        } catch (Exception exception2) {
            Exception exception3 = new Exception("Couldn't parse challenge json string in the attestation certificate" + exception2.getStackTrace());
            AppMethodBeat.m2505o(73017);
            throw exception3;
        }
    }
}
