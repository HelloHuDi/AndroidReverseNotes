package com.tencent.mm.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class a extends b {
    private HttpURLConnection ipF = null;

    public a(HttpURLConnection httpURLConnection) {
        this.ipF = httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x01ae A:{SYNTHETIC, EDGE_INSN: B:131:0x01ae->B:68:0x01ae ?: BREAK  , EDGE_INSN: B:131:0x01ae->B:68:0x01ae ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0101 A:{Catch:{ Exception -> 0x0109, all -> 0x0208 }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0200 A:{SYNTHETIC, Splitter:B:89:0x0200} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ba A:{Catch:{ Exception -> 0x0109, all -> 0x0208 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0137 A:{SYNTHETIC, Splitter:B:48:0x0137} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013c A:{SYNTHETIC, Splitter:B:51:0x013c} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x021b A:{SYNTHETIC, Splitter:B:100:0x021b} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0220 A:{SYNTHETIC, Splitter:B:103:0x0220} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e1 A:{Catch:{ all -> 0x0218 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01e7 A:{SYNTHETIC, Splitter:B:81:0x01e7} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ec A:{SYNTHETIC, Splitter:B:84:0x01ec} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b bVar, c cVar) {
        Throwable e;
        AppMethodBeat.i(51965);
        ab.i("MicroMsg.HttpURLConnectionWrapper", "request : %s", bVar);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int i;
        try {
            String str;
            this.ipF.setConnectTimeout(bVar.azs);
            this.ipF.setRequestMethod(bVar.pub == 0 ? "GET" : "POST");
            if (bVar.pub == 1) {
                this.ipF.setDoInput(true);
                this.ipF.setDoOutput(true);
            }
            this.ipF.setUseCaches(false);
            this.ipF.setRequestProperty("User-Agent", "weixin/android");
            this.ipF.setRequestProperty("Host", bVar.host);
            System.setProperty("http.keepAlive", "false");
            this.ipF.setRequestProperty("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ipF.setRequestProperty("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            HttpURLConnection httpURLConnection = this.ipF;
            String str2 = "Cookie";
            Map map = bVar.pud;
            if (map == null || map.size() == 0) {
                str = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                i = 0;
                for (String str3 : map.keySet()) {
                    stringBuilder.append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str3), ProtocolPackage.ServerEncoding));
                    int i2 = i + 1;
                    if (map.size() > i2) {
                        stringBuilder.append("; ");
                    }
                    i = i2;
                }
                str3 = stringBuilder.toString();
            }
            httpURLConnection.setRequestProperty(str2, str3);
            this.ipF.connect();
            if (bVar.pub == 1) {
                outputStream = this.ipF.getOutputStream();
                a(bVar, outputStream);
                outputStream.flush();
            }
            i = this.ipF.getResponseCode();
            try {
                OutputStream outputStream2;
                byte[] bArr;
                int read;
                String headerField = this.ipF.getHeaderField("set-cookie");
                str3 = this.ipF.getHeaderField("Content-Encoding");
                this.ipF.getHeaderField("Content-Disposition");
                InputStream inputStream2 = this.ipF.getInputStream();
                if (str3 != null) {
                    try {
                        if (str3.contains("gzip")) {
                            inputStream = new GZIPInputStream(inputStream2);
                            outputStream2 = null;
                            if (cVar.xxP == null && bo.isNullOrNil(cVar.xxP.filePath)) {
                                outputStream2 = new FileOutputStream(new File(cVar.xxP.filePath), true);
                            } else {
                                outputStream2 = new ByteArrayOutputStream();
                            }
                            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                read = inputStream.read(bArr);
                                if (read > 0) {
                                    break;
                                }
                                outputStream2.write(bArr, 0, read);
                                outputStream2.flush();
                            }
                            cVar.status = i;
                            cVar.pud = b.Vh(headerField);
                            cVar.content = outputStream2 instanceof ByteArrayOutputStream ? new String(((ByteArrayOutputStream) outputStream2).toByteArray()) : "";
                            outputStream2.flush();
                            outputStream2.close();
                            ab.d("MicroMsg.HttpURLConnectionWrapper", "Response: %s".concat(String.valueOf(cVar)));
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e22) {
                                    ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22, "", new Object[0]);
                                }
                            }
                            if (this.ipF != null) {
                                this.ipF.disconnect();
                                AppMethodBeat.o(51965);
                                return;
                            }
                            AppMethodBeat.o(51965);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = inputStream2;
                        try {
                            ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e, "", new Object[0]);
                            cVar.status = i != 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e222) {
                                    ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e222, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2222) {
                                    ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2222, "", new Object[0]);
                                }
                            }
                            if (this.ipF != null) {
                                this.ipF.disconnect();
                                AppMethodBeat.o(51965);
                                return;
                            }
                            AppMethodBeat.o(51965);
                        } catch (Throwable th) {
                            e = th;
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (this.ipF != null) {
                            }
                            AppMethodBeat.o(51965);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = inputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e4, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e42) {
                                ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e42, "", new Object[0]);
                            }
                        }
                        if (this.ipF != null) {
                            this.ipF.disconnect();
                        }
                        AppMethodBeat.o(51965);
                        throw e;
                    }
                }
                inputStream = inputStream2;
                outputStream2 = null;
                try {
                    if (cVar.xxP == null) {
                    }
                    outputStream2 = new ByteArrayOutputStream();
                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        read = inputStream.read(bArr);
                        if (read > 0) {
                        }
                    }
                    cVar.status = i;
                    cVar.pud = b.Vh(headerField);
                    if (outputStream2 instanceof ByteArrayOutputStream) {
                    }
                    cVar.content = outputStream2 instanceof ByteArrayOutputStream ? new String(((ByteArrayOutputStream) outputStream2).toByteArray()) : "";
                    outputStream2.flush();
                    outputStream2.close();
                } catch (Exception e5) {
                    ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e5, "", new Object[0]);
                    cVar.status = i == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500;
                    if (outputStream2 != null) {
                        outputStream2.flush();
                        outputStream2.close();
                    }
                } catch (Throwable th3) {
                    if (outputStream2 != null) {
                        outputStream2.flush();
                        outputStream2.close();
                    }
                    AppMethodBeat.o(51965);
                }
                ab.d("MicroMsg.HttpURLConnectionWrapper", "Response: %s".concat(String.valueOf(cVar)));
                if (outputStream != null) {
                }
                if (inputStream != null) {
                }
                if (this.ipF != null) {
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Exception e7) {
            e = e7;
            i = 0;
            ab.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e, "", new Object[0]);
            if (i != 0) {
            }
            cVar.status = i != 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500;
            if (outputStream != null) {
            }
            if (inputStream != null) {
            }
            if (this.ipF != null) {
            }
            AppMethodBeat.o(51965);
        }
        AppMethodBeat.o(51965);
    }

    private static void a(b bVar, OutputStream outputStream) {
        AppMethodBeat.i(51966);
        if (bVar.puc == null) {
            AppMethodBeat.o(51966);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        Iterator it = bVar.puc.keySet().iterator();
        while (true) {
            Object obj2 = obj;
            if (it.hasNext()) {
                String str = (String) it.next();
                stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) bVar.puc.get(str), ProtocolPackage.ServerEncoding));
                obj = null;
            } else {
                outputStream.write(stringBuilder.toString().getBytes());
                AppMethodBeat.o(51966);
                return;
            }
        }
    }
}
