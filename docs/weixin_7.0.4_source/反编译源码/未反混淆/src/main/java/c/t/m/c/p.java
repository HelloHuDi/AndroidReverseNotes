package c.t.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class p {
    public static int a = i.sHCENCODEVIDEOTIMEOUT;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(String str, byte[] bArr) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        byte[] bArr2 = null;
        AppMethodBeat.i(136399);
        HttpURLConnection httpURLConnection2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(a);
                httpURLConnection2.setReadTimeout(a);
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
                    AppMethodBeat.o(136399);
                    return bArr2;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                a = i.sHCENCODEVIDEOTIMEOUT;
                AppMethodBeat.o(136399);
                return bArr2;
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            httpURLConnection2 = bArr2;
            try {
                a = i.sHCENCODEVIDEOTIMEOUT;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                AppMethodBeat.o(136399);
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                AppMethodBeat.o(136399);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = bArr2;
            if (httpURLConnection != null) {
            }
            AppMethodBeat.o(136399);
            throw th;
        }
    }

    public static byte[] a(String str) {
        AppMethodBeat.i(136400);
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
                    AppMethodBeat.o(136400);
                    return toByteArray;
                }
            }
        } catch (Exception e) {
            AppMethodBeat.o(136400);
            return null;
        }
    }
}
