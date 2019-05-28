package p077c.p078t.p079m.p080c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: c.t.m.c.p */
public class C0733p {
    /* renamed from: a */
    public static int f1026a = C1625i.sHCENCODEVIDEOTIMEOUT;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static byte[] m1691a(String str, byte[] bArr) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(136399);
        HttpURLConnection httpURLConnection2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(f1026a);
                httpURLConnection2.setReadTimeout(f1026a);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                httpURLConnection2.getOutputStream().write(bArr);
                if (httpURLConnection2.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[128];
                    while (true) {
                        int read = inputStream.read(bArr3);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(136399);
                    return bArr2;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                f1026a = C1625i.sHCENCODEVIDEOTIMEOUT;
                AppMethodBeat.m2505o(136399);
                return bArr2;
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            httpURLConnection2 = bArr2;
            try {
                f1026a = C1625i.sHCENCODEVIDEOTIMEOUT;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                AppMethodBeat.m2505o(136399);
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                AppMethodBeat.m2505o(136399);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = bArr2;
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(136399);
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m1690a(String str) {
        AppMethodBeat.m2504i(136400);
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = openConnection.getInputStream().read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(136400);
                    return toByteArray;
                }
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(136400);
            return null;
        }
    }
}
