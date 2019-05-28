package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.facebook.internal.Utility;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.o */
public final class C19379o extends C10296a {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        String str;
        AppMethodBeat.m2504i(102785);
        final String optString = jSONObject.optString("filePath", "");
        if ("sha1".equalsIgnoreCase(jSONObject.optString("digestAlgorithm", "md5"))) {
            str = "sha1";
        } else {
            str = "md5";
        }
        if (C5046bo.isNullOrNil(optString)) {
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(102785);
            return;
        }
        final C2241c c2241c2 = c2241c;
        final int i2 = i;
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102784);
                File yg = c2241c2.asE().mo34314yg(optString);
                if (yg == null) {
                    c2241c2.mo6107M(i2, C19379o.this.mo73394j("fail:file doesn't exist", null));
                    AppMethodBeat.m2505o(102784);
                    return;
                }
                File file = new File(yg.getAbsolutePath());
                String str = str;
                Object obj = -1;
                switch (str.hashCode()) {
                    case 107902:
                        if (str.equals("md5")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 3528965:
                        if (str.equals("sha1")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        obj = C1178g.m2589v(file);
                        break;
                    case 1:
                        obj = C19379o.m30060H(file);
                        break;
                    default:
                        obj = "";
                        break;
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("size", Long.valueOf(file.length()));
                hashMap.put("digest", obj);
                c2241c2.mo6107M(i2, C19379o.this.mo73394j("ok", hashMap));
                AppMethodBeat.m2505o(102784);
            }
        }, "AppBrandJsApiGetFileInfo");
        AppMethodBeat.m2505o(102785);
    }

    /* renamed from: H */
    static String m30060H(File file) {
        AppMethodBeat.m2504i(102786);
        String str;
        try {
            MessageDigest instance = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        str = "";
                    } finally {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            C4990ab.m7413e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e2);
                        }
                        AppMethodBeat.m2505o(102786);
                    }
                }
                str = C19379o.bytesToHexString(instance.digest());
                return str;
            } catch (FileNotFoundException e3) {
                C4990ab.m7413e("MicroMsg.JsApiGetFileInfo", "Exception while getting FileInputStream", e3);
                str = "";
                AppMethodBeat.m2505o(102786);
                return str;
            }
        } catch (NoSuchAlgorithmException e4) {
            C4990ab.m7413e("MicroMsg.JsApiGetFileInfo", "Exception while getting Digest", e4);
            str = "";
            AppMethodBeat.m2505o(102786);
            return str;
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        AppMethodBeat.m2504i(102787);
        if (bArr == null) {
            AppMethodBeat.m2505o(102787);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(toHexString.toLowerCase());
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(102787);
        return stringBuffer2;
    }
}
