package com.tencent.mm.modelstat.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class b {

    /* renamed from: com.tencent.mm.modelstat.a.b$1 */
    public static class AnonymousClass1 implements a<Void, File> {
        final /* synthetic */ int bVv;

        public AnonymousClass1(int i) {
            this.bVv = i;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(78808);
            File file = (File) obj;
            b.a(file, this.bVv);
            file.delete();
            AppMethodBeat.o(78808);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2 A:{Splitter:B:1:0x000a, ExcHandler: MalformedURLException (r0_22 'e' java.net.MalformedURLException)} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0100 A:{Splitter:B:1:0x000a, ExcHandler: ProtocolException (r0_25 'e' java.net.ProtocolException)} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2 A:{Splitter:B:1:0x000a, ExcHandler: MalformedURLException (r0_22 'e' java.net.MalformedURLException)} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0100 A:{Splitter:B:1:0x000a, ExcHandler: ProtocolException (r0_25 'e' java.net.ProtocolException)} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a9 A:{SYNTHETIC, Splitter:B:20:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011f A:{SYNTHETIC, Splitter:B:43:0x011f} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:26:0x00d2, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x00d3, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.UploadX5Log", r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:35:0x0100, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:36:0x0101, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.UploadX5Log", r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:37:0x010c, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.UploadX5Log", r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:40:0x0117, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(78809);
     */
    /* JADX WARNING: Missing block: B:51:0x0135, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.UploadX5Log", r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:54:0x0140, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(78809);
     */
    /* JADX WARNING: Missing block: B:61:?, code skipped:
            return -1;
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(File file, int i) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        AppMethodBeat.i(78809);
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(i == 1 ? "https://qprostat.imtt.qq.com/x5corelog" : "https://qprostat.imtt.qq.com").openConnection();
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Content-length", file.length());
            httpsURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpsURLConnection.setRequestProperty("Charset", "UTF-8");
            g.RN();
            httpsURLConnection.setRequestProperty("q-ua2", com.tencent.mm.kernel.a.QG());
            g.RN();
            httpsURLConnection.setRequestProperty("q-guid", com.tencent.mm.kernel.a.QG());
            if (i == 1) {
                httpsURLConnection.setRequestProperty("q-log-type", "LiveLog");
                httpsURLConnection.setRequestProperty("openrandom", "wx_ipxx");
            } else {
                httpsURLConnection.setRequestProperty("q-log-type", "tbslog");
                httpsURLConnection.setRequestProperty("q-proxy-log", "tbslog");
                httpsURLConnection.setRequestProperty("openrandom", "tbslog");
            }
            httpsURLConnection.setRequestProperty("openmode", null);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            byte[] bArr = new byte[10240];
            try {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream3.read(bArr, 0, 10240);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    } catch (Exception e) {
                        fileInputStream = fileInputStream3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        AppMethodBeat.o(78809);
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream3;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        AppMethodBeat.o(78809);
                        throw th;
                    }
                }
                fileInputStream3.close();
                ab.i("MicroMsg.UploadX5Log", "responseCode %d", Integer.valueOf(httpsURLConnection.getResponseCode()));
                outputStream.close();
            } catch (Exception e2) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(78809);
                return -1;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream2 != null) {
                }
                AppMethodBeat.o(78809);
                throw th;
            }
        } catch (MalformedURLException e3) {
        } catch (ProtocolException e4) {
        } catch (IOException e5) {
            ab.e("MicroMsg.UploadX5Log", e5.getMessage());
        }
        AppMethodBeat.o(78809);
        return 0;
    }
}
