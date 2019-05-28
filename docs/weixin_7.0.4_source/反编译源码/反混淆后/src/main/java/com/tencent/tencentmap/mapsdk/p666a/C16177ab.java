package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ab */
public class C16177ab {
    /* renamed from: a */
    private static String f3068a = "fdea30d4-c4f3-11e7-ae5f-6c0b84ab3a9e";

    /* renamed from: a */
    public static final byte[] m24551a(String str) {
        AppMethodBeat.m2504i(101256);
        byte[] bArr = null;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(f3068a.getBytes("UTF-8"), "HmacSHA256"));
            bArr = instance.doFinal(str.getBytes());
        } catch (UnsupportedEncodingException e) {
            C36478i.m60315a("sha256Encode failed with error:" + e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            C36478i.m60315a("sha256Encode failed with error:" + e2.getMessage());
        } catch (InvalidKeyException e3) {
            C36478i.m60315a("sha256Encode failed with error:" + e3.getMessage());
        }
        AppMethodBeat.m2505o(101256);
        return bArr;
    }
}
