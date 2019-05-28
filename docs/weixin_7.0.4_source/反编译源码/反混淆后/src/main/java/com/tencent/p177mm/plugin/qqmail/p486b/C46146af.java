package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C28742a;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C39538b;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C43402c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: com.tencent.mm.plugin.qqmail.b.af */
public final class C46146af extends C43403n {
    private C1936u pvF;

    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b5 A:{Catch:{ Exception -> 0x015f, all -> 0x025d }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011a A:{SYNTHETIC, Splitter:B:31:0x011a} */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01bc A:{SYNTHETIC, EDGE_INSN: B:150:0x01bc->B:67:0x01bc ?: BREAK  , EDGE_INSN: B:150:0x01bc->B:67:0x01bc ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0154 A:{Catch:{ Exception -> 0x015f, all -> 0x025d }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0210 A:{SYNTHETIC, Splitter:B:83:0x0210} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c4 A:{Catch:{ Exception -> 0x015f, all -> 0x025d }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f5 A:{SYNTHETIC, Splitter:B:74:0x01f5} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01fa A:{SYNTHETIC, Splitter:B:77:0x01fa} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0108 A:{SYNTHETIC, Splitter:B:24:0x0108} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011a A:{SYNTHETIC, Splitter:B:31:0x011a} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b5 A:{Catch:{ Exception -> 0x015f, all -> 0x025d }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0154 A:{Catch:{ Exception -> 0x015f, all -> 0x025d }} */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01bc A:{SYNTHETIC, EDGE_INSN: B:150:0x01bc->B:67:0x01bc ?: BREAK  , EDGE_INSN: B:150:0x01bc->B:67:0x01bc ?: BREAK  , EDGE_INSN: B:150:0x01bc->B:67:0x01bc ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c4 A:{Catch:{ Exception -> 0x015f, all -> 0x025d }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0210 A:{SYNTHETIC, Splitter:B:83:0x0210} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f5 A:{SYNTHETIC, Splitter:B:74:0x01f5} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01fa A:{SYNTHETIC, Splitter:B:77:0x01fa} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x027f A:{Catch:{ all -> 0x02fb }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0288 A:{SYNTHETIC, Splitter:B:109:0x0288} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028d A:{SYNTHETIC, Splitter:B:112:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02c5 A:{SYNTHETIC, Splitter:B:125:0x02c5} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02ca A:{SYNTHETIC, Splitter:B:128:0x02ca} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x027f A:{Catch:{ all -> 0x02fb }} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0288 A:{SYNTHETIC, Splitter:B:109:0x0288} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028d A:{SYNTHETIC, Splitter:B:112:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02c5 A:{SYNTHETIC, Splitter:B:125:0x02c5} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02ca A:{SYNTHETIC, Splitter:B:128:0x02ca} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C43402c mo36997a(String str, String str2, C39538b c39538b, C28742a c28742a) {
        int responseCode;
        Throwable e;
        int i;
        C43402c c43402c;
        OutputStream outputStream;
        AppMethodBeat.m2504i(68070);
        C4990ab.m7410d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + c39538b);
        OutputStream outputStream2 = null;
        InputStream inputStream = null;
        OutputStream outputStream3;
        try {
            Map map;
            if (c39538b.pub == 0) {
                map = c39538b.puc;
            } else {
                map = null;
            }
            this.pvF = C1897b.m4020a(C43403n.m77463f(str, str2, map), null);
            this.pvF.setConnectTimeout(azs);
            this.pvF.setRequestMethod(c39538b.pub == 0 ? "GET" : "POST");
            this.pvF.amX();
            this.pvF.amY();
            this.pvF.setUseCaches(false);
            this.pvF.setRequestProperty("User-Agent", userAgent);
            this.pvF.setRequestProperty("Host", host);
            System.setProperty("http.keepAlive", "false");
            this.pvF.setRequestProperty("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.pvF.setRequestProperty("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.pvF.setRequestProperty("Cookie", C43403n.m77462W(c39538b.pud));
            this.pvF.connect();
            outputStream3 = this.pvF.getOutputStream();
            try {
                if (c39538b.pub == 1) {
                    C46146af.m86136a(c39538b, outputStream3);
                }
                outputStream3.flush();
                responseCode = this.pvF.getResponseCode();
            } catch (Exception e2) {
                e = e2;
                i = 0;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e, "", new Object[0]);
                    if (i == 0) {
                    }
                    c43402c = new C43402c(i == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500, null, null);
                    if (outputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (this.pvF != null) {
                    }
                    AppMethodBeat.m2505o(68070);
                    return c43402c;
                } catch (Throwable th) {
                    e = th;
                    outputStream2 = outputStream3;
                    if (outputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (this.pvF != null) {
                    }
                    AppMethodBeat.m2505o(68070);
                    throw e;
                }
            }
            try {
                Object obj;
                InputStream inputStream2;
                byte[] bArr;
                Map Vh;
                C43402c c43402c2;
                String headerField = this.pvF.getHeaderField("set-cookie");
                String headerField2 = this.pvF.getHeaderField("Content-Encoding");
                String headerField3 = this.pvF.getHeaderField("Content-Disposition");
                if (headerField3 != null && headerField3.contains("attachment;")) {
                    if (str2.contains("download")) {
                        obj = 1;
                        inputStream2 = this.pvF.getInputStream();
                        if (headerField2 != null) {
                            try {
                                if (headerField2.contains("gzip")) {
                                    inputStream = new GZIPInputStream(inputStream2);
                                    outputStream = null;
                                    if (obj != null) {
                                        try {
                                            Object valueOf;
                                            String str3 = pua;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            if (c39538b.puc.get("default_attach_name") == null) {
                                                valueOf = Long.valueOf(System.currentTimeMillis());
                                            } else {
                                                Serializable valueOf2 = (Serializable) c39538b.puc.get("default_attach_name");
                                            }
                                            outputStream = new FileOutputStream(new File(str3, stringBuilder.append(valueOf2).toString()), true);
                                        } catch (Exception e3) {
                                            C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e3, "", new Object[0]);
                                            c43402c = new C43402c(responseCode == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500, null, null);
                                            if (outputStream != null) {
                                                outputStream.flush();
                                                outputStream.close();
                                            }
                                            if (outputStream3 != null) {
                                                try {
                                                    outputStream3.close();
                                                } catch (IOException e4) {
                                                    C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e4, "", new Object[0]);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e42) {
                                                    C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e42, "", new Object[0]);
                                                }
                                            }
                                            if (this.pvF != null) {
                                                this.pvF.connection.disconnect();
                                            }
                                            AppMethodBeat.m2505o(68070);
                                            return c43402c;
                                        } catch (Throwable th2) {
                                            if (outputStream != null) {
                                                outputStream.flush();
                                                outputStream.close();
                                            }
                                            AppMethodBeat.m2505o(68070);
                                        }
                                    } else {
                                        outputStream = new ByteArrayOutputStream();
                                    }
                                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                    while (true) {
                                        i = inputStream.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        outputStream.write(bArr, 0, i);
                                        outputStream.flush();
                                        c28742a.ccp();
                                    }
                                    Vh = C43403n.m77461Vh(headerField);
                                    if (obj != null) {
                                        headerField3 = "";
                                    } else {
                                        headerField3 = new String(((ByteArrayOutputStream) outputStream).toByteArray());
                                    }
                                    c43402c2 = new C43402c(responseCode, Vh, headerField3);
                                    C4990ab.m7410d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + c43402c2);
                                    outputStream.flush();
                                    outputStream.close();
                                    if (outputStream3 != null) {
                                        try {
                                            outputStream3.close();
                                        } catch (IOException e5) {
                                            C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e5, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e52) {
                                            C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e52, "", new Object[0]);
                                        }
                                    }
                                    if (this.pvF != null) {
                                        this.pvF.connection.disconnect();
                                    }
                                    AppMethodBeat.m2505o(68070);
                                    return c43402c2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                i = responseCode;
                                inputStream = inputStream2;
                                C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e, "", new Object[0]);
                                if (i == 0) {
                                }
                                c43402c = new C43402c(i == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500, null, null);
                                if (outputStream3 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (this.pvF != null) {
                                }
                                AppMethodBeat.m2505o(68070);
                                return c43402c;
                            } catch (Throwable th3) {
                                e = th3;
                                inputStream = inputStream2;
                                outputStream2 = outputStream3;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e422) {
                                        C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e422, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e4222) {
                                        C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e4222, "", new Object[0]);
                                    }
                                }
                                if (this.pvF != null) {
                                    this.pvF.connection.disconnect();
                                }
                                AppMethodBeat.m2505o(68070);
                                throw e;
                            }
                        }
                        inputStream = inputStream2;
                        outputStream = null;
                        if (obj != null) {
                        }
                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i <= 0) {
                            }
                        }
                        Vh = C43403n.m77461Vh(headerField);
                        if (obj != null) {
                        }
                        c43402c2 = new C43402c(responseCode, Vh, headerField3);
                        C4990ab.m7410d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + c43402c2);
                        outputStream.flush();
                        outputStream.close();
                        if (outputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (this.pvF != null) {
                        }
                        AppMethodBeat.m2505o(68070);
                        return c43402c2;
                    }
                }
                obj = null;
                inputStream2 = this.pvF.getInputStream();
                if (headerField2 != null) {
                }
                inputStream = inputStream2;
                outputStream = null;
                if (obj != null) {
                }
                bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    i = inputStream.read(bArr);
                    if (i <= 0) {
                    }
                }
                Vh = C43403n.m77461Vh(headerField);
                if (obj != null) {
                }
                c43402c2 = new C43402c(responseCode, Vh, headerField3);
                C4990ab.m7410d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + c43402c2);
                outputStream.flush();
                outputStream.close();
                if (outputStream3 != null) {
                }
                if (inputStream != null) {
                }
                if (this.pvF != null) {
                }
                AppMethodBeat.m2505o(68070);
                return c43402c2;
            } catch (Exception e7) {
                e = e7;
                i = responseCode;
                C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e, "", new Object[0]);
                c43402c = new C43402c(i == 0 ? ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS : 500, null, null);
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (IOException e42222) {
                        C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e42222, "", new Object[0]);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e422222) {
                        C4990ab.printErrStackTrace("MicroMsg.URLConnectionUtil", e422222, "", new Object[0]);
                    }
                }
                if (this.pvF != null) {
                    this.pvF.connection.disconnect();
                }
                AppMethodBeat.m2505o(68070);
                return c43402c;
            }
        } catch (Exception e8) {
            e = e8;
            i = 0;
            outputStream3 = null;
        } catch (Throwable th4) {
            e = th4;
            if (outputStream2 != null) {
            }
            if (inputStream != null) {
            }
            if (this.pvF != null) {
            }
            AppMethodBeat.m2505o(68070);
            throw e;
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(68071);
        C4990ab.m7410d("MicroMsg.URLConnectionUtil", "cancel conection.");
        if (this.pvF != null) {
            this.pvF.connection.disconnect();
        }
        AppMethodBeat.m2505o(68071);
    }

    /* renamed from: a */
    private static void m86136a(C39538b c39538b, OutputStream outputStream) {
        AppMethodBeat.m2504i(68072);
        if (c39538b.puc == null) {
            AppMethodBeat.m2505o(68072);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        Iterator it = c39538b.puc.keySet().iterator();
        while (true) {
            Object obj2 = obj;
            if (it.hasNext()) {
                String str = (String) it.next();
                stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) c39538b.puc.get(str), ProtocolPackage.ServerEncoding));
                obj = null;
            } else {
                outputStream.write(stringBuilder.toString().getBytes());
                AppMethodBeat.m2505o(68072);
                return;
            }
        }
    }
}
