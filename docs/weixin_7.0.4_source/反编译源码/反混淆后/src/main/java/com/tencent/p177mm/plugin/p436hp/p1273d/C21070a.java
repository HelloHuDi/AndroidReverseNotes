package com.tencent.p177mm.plugin.p436hp.p1273d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

/* renamed from: com.tencent.mm.plugin.hp.d.a */
public final class C21070a implements Runnable {
    public boolean aAR = true;
    public String cvZ;
    public boolean gbH = true;
    public String ghD;
    public String url;

    public C21070a(String str, String str2, String str3) {
        this.url = str;
        this.ghD = str2;
        this.cvZ = str3;
        this.gbH = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A:{SYNTHETIC, Splitter:B:26:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{Catch:{ Exception -> 0x01da }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{Catch:{ Exception -> 0x01da }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Throwable e;
        InputStream inputStream;
        OutputStream outputStream;
        C1936u c1936u;
        AppMethodBeat.m2504i(90673);
        C1936u c1936u2 = null;
        OutputStream outputStream2 = null;
        InputStream inputStream2 = null;
        try {
            c1936u2 = C1897b.m4020a(this.url, null);
            try {
                c1936u2.setRequestMethod("GET");
                c1936u2.setConnectTimeout(15000);
                c1936u2.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                if (C1897b.m4017a(c1936u2) != 0) {
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "checkHttpConnection failed! url:%s", this.url);
                    AppMethodBeat.m2505o(90673);
                    return;
                }
                inputStream2 = c1936u2.getInputStream();
                if (inputStream2 == null) {
                    try {
                        C4990ab.m7411d("Tinker.TinkerDownloadTask", "getInputStream failed. url:%s", this.url);
                        AppMethodBeat.m2505o(90673);
                        return;
                    } catch (InterruptedException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                    } catch (UnknownHostException e3) {
                        e = e3;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 33, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SSLHandshakeException e4) {
                        e = e4;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 34, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SocketException e5) {
                        e = e5;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 35, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SocketTimeoutException e6) {
                        e = e6;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 36, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (IOException e7) {
                        e = e7;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 37, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (Exception e8) {
                        e = e8;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 38, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    }
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                outputStream2 = C5730e.m8617L(this.ghD, false);
                while (true) {
                    try {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                    } catch (InterruptedException e9) {
                        e = e9;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 32, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (UnknownHostException e10) {
                        e = e10;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 33, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SSLHandshakeException e11) {
                        e = e11;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 34, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SocketException e12) {
                        e = e12;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 35, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SocketTimeoutException e13) {
                        e = e13;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 36, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (IOException e14) {
                        e = e14;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 37, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (Exception e15) {
                        e = e15;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        c1936u = c1936u2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 38, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    }
                }
                this.aAR = false;
                outputStream2.close();
                outputStream = null;
                try {
                    c1936u2.connection.disconnect();
                    c1936u = null;
                    try {
                        inputStream2.close();
                        inputStream = null;
                    } catch (InterruptedException e16) {
                        e = e16;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 32, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (UnknownHostException e17) {
                        e = e17;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 33, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SSLHandshakeException e18) {
                        e = e18;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 34, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SocketException e19) {
                        e = e19;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 35, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (SocketTimeoutException e20) {
                        e = e20;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 36, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (IOException e21) {
                        e = e21;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 37, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    } catch (Exception e22) {
                        e = e22;
                        inputStream = inputStream2;
                        this.aAR = true;
                        C7060h.pYm.mo8378a(614, 38, 1, false);
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
                        if (c1936u != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(90673);
                    }
                } catch (InterruptedException e23) {
                    e = e23;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 32, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (UnknownHostException e24) {
                    e = e24;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 33, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (SSLHandshakeException e25) {
                    e = e25;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 34, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (SocketException e26) {
                    e = e26;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 35, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (SocketTimeoutException e27) {
                    e = e27;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 36, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (IOException e28) {
                    e = e28;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 37, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (Exception e29) {
                    e = e29;
                    inputStream = inputStream2;
                    c1936u = c1936u2;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 38, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                }
                try {
                    if (!C5730e.atg(this.ghD).equalsIgnoreCase(this.cvZ)) {
                        C4990ab.m7410d("Tinker.TinkerDownloadTask", "hp_apply md5 mismatched, ignored");
                        C7060h.pYm.mo8378a(614, 30, 1, false);
                        this.aAR = true;
                    }
                } catch (InterruptedException e30) {
                    e = e30;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 32, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (UnknownHostException e31) {
                    e = e31;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 33, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (SSLHandshakeException e32) {
                    e = e32;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 34, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (SocketException e33) {
                    e = e33;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 35, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (SocketTimeoutException e34) {
                    e = e34;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 36, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (IOException e35) {
                    e = e35;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 37, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                } catch (Exception e36) {
                    e = e36;
                    this.aAR = true;
                    C7060h.pYm.mo8378a(614, 38, 1, false);
                    C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
                    if (c1936u != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(90673);
                }
                if (c1936u != null) {
                    try {
                        c1936u.connection.disconnect();
                    } catch (Exception e37) {
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e37));
                        C4990ab.m7413e("Tinker.TinkerDownloadTask", "close conn failed : %s", e37.getMessage());
                        AppMethodBeat.m2505o(90673);
                        return;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.m2505o(90673);
            } catch (InterruptedException e38) {
                e = e38;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
            } catch (UnknownHostException e39) {
                e = e39;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
                this.aAR = true;
                C7060h.pYm.mo8378a(614, 33, 1, false);
                C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(90673);
            } catch (SSLHandshakeException e40) {
                e = e40;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
                this.aAR = true;
                C7060h.pYm.mo8378a(614, 34, 1, false);
                C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(90673);
            } catch (SocketException e41) {
                e = e41;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
                this.aAR = true;
                C7060h.pYm.mo8378a(614, 35, 1, false);
                C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(90673);
            } catch (SocketTimeoutException e42) {
                e = e42;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
                this.aAR = true;
                C7060h.pYm.mo8378a(614, 36, 1, false);
                C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(90673);
            } catch (IOException e43) {
                e = e43;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
                this.aAR = true;
                C7060h.pYm.mo8378a(614, 37, 1, false);
                C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(90673);
            } catch (Exception e44) {
                e = e44;
                inputStream = inputStream2;
                outputStream = outputStream2;
                c1936u = c1936u2;
                this.aAR = true;
                C7060h.pYm.mo8378a(614, 38, 1, false);
                C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(90673);
            }
        } catch (InterruptedException e45) {
            e = e45;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
        } catch (UnknownHostException e46) {
            e = e46;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
            this.aAR = true;
            C7060h.pYm.mo8378a(614, 33, 1, false);
            C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(90673);
        } catch (SSLHandshakeException e47) {
            e = e47;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
            this.aAR = true;
            C7060h.pYm.mo8378a(614, 34, 1, false);
            C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(90673);
        } catch (SocketException e48) {
            e = e48;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
            this.aAR = true;
            C7060h.pYm.mo8378a(614, 35, 1, false);
            C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(90673);
        } catch (SocketTimeoutException e49) {
            e = e49;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
            this.aAR = true;
            C7060h.pYm.mo8378a(614, 36, 1, false);
            C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(90673);
        } catch (IOException e50) {
            e = e50;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
            this.aAR = true;
            C7060h.pYm.mo8378a(614, 37, 1, false);
            C4990ab.m7413e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(90673);
        } catch (Exception e51) {
            e = e51;
            inputStream = inputStream2;
            outputStream = outputStream2;
            c1936u = c1936u2;
            this.aAR = true;
            C7060h.pYm.mo8378a(614, 38, 1, false);
            C4990ab.m7413e("Tinker.TinkerDownloadTask", "exception:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(90673);
        }
    }
}
