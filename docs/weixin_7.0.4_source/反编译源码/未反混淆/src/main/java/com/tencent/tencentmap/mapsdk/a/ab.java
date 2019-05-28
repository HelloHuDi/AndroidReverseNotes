package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ab {
    private static String a = "fdea30d4-c4f3-11e7-ae5f-6c0b84ab3a9e";

    public static final byte[] a(String str) {
        AppMethodBeat.i(101256);
        byte[] bArr = null;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(a.getBytes("UTF-8"), "HmacSHA256"));
            bArr = instance.doFinal(str.getBytes());
        } catch (UnsupportedEncodingException e) {
            i.a("sha256Encode failed with error:" + e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            i.a("sha256Encode failed with error:" + e2.getMessage());
        } catch (InvalidKeyException e3) {
            i.a("sha256Encode failed with error:" + e3.getMessage());
        }
        AppMethodBeat.o(101256);
        return bArr;
    }
}
