package com.tencent.soter.core.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public class a {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());

    static {
        AppMethodBeat.i(73018);
        AppMethodBeat.o(73018);
    }

    private static void a(BufferedWriter bufferedWriter, byte[] bArr) {
        AppMethodBeat.i(73015);
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
        AppMethodBeat.o(73015);
    }

    public static String a(Certificate certificate) {
        AppMethodBeat.i(73016);
        String str = "CERTIFICATE";
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN " + str + "-----");
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        a(bufferedWriter, Base64.encode(certificate.getEncoded(), 2));
        bufferedWriter.write("-----END " + str + "-----");
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        bufferedWriter.close();
        str = stringWriter.toString();
        AppMethodBeat.o(73016);
        return str;
    }

    public static void a(X509Certificate x509Certificate, i iVar) {
        AppMethodBeat.i(73017);
        byte[] extensionValue = x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        Exception exception;
        if (extensionValue == null || extensionValue.length == 0) {
            exception = new Exception("Couldn't find the keystore attestation extension data.");
            AppMethodBeat.o(73017);
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
                    d.i("Soter.CertUtil", "soter: challenge json in attestation certificate ".concat(String.valueOf(str)), new Object[0]);
                    JSONObject jSONObject = new JSONObject(str);
                    iVar.rOh = jSONObject.getString("cpu_id");
                    iVar.uid = jSONObject.getInt("uid");
                    iVar.Avl = jSONObject.getLong("counter");
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(73017);
                    throw assertionError;
                }
            }
            AppMethodBeat.o(73017);
        } catch (Exception exception2) {
            Exception exception3 = new Exception("Couldn't parse challenge json string in the attestation certificate" + exception2.getStackTrace());
            AppMethodBeat.o(73017);
            throw exception3;
        }
    }
}
