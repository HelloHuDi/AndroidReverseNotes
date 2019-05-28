package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.facebook.internal.Utility;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.json.JSONObject;

public final class o extends a {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        String str;
        AppMethodBeat.i(102785);
        final String optString = jSONObject.optString("filePath", "");
        if ("sha1".equalsIgnoreCase(jSONObject.optString("digestAlgorithm", "md5"))) {
            str = "sha1";
        } else {
            str = "md5";
        }
        if (bo.isNullOrNil(optString)) {
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(102785);
            return;
        }
        final c cVar2 = cVar;
        final int i2 = i;
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102784);
                File yg = cVar2.asE().yg(optString);
                if (yg == null) {
                    cVar2.M(i2, o.this.j("fail:file doesn't exist", null));
                    AppMethodBeat.o(102784);
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
                        obj = g.v(file);
                        break;
                    case 1:
                        obj = o.H(file);
                        break;
                    default:
                        obj = "";
                        break;
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("size", Long.valueOf(file.length()));
                hashMap.put("digest", obj);
                cVar2.M(i2, o.this.j("ok", hashMap));
                AppMethodBeat.o(102784);
            }
        }, "AppBrandJsApiGetFileInfo");
        AppMethodBeat.o(102785);
    }

    static String H(File file) {
        AppMethodBeat.i(102786);
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
                            ab.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e2);
                        }
                        AppMethodBeat.o(102786);
                    }
                }
                str = bytesToHexString(instance.digest());
                return str;
            } catch (FileNotFoundException e3) {
                ab.e("MicroMsg.JsApiGetFileInfo", "Exception while getting FileInputStream", e3);
                str = "";
                AppMethodBeat.o(102786);
                return str;
            }
        } catch (NoSuchAlgorithmException e4) {
            ab.e("MicroMsg.JsApiGetFileInfo", "Exception while getting Digest", e4);
            str = "";
            AppMethodBeat.o(102786);
            return str;
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        AppMethodBeat.i(102787);
        if (bArr == null) {
            AppMethodBeat.o(102787);
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
        AppMethodBeat.o(102787);
        return stringBuffer2;
    }
}
