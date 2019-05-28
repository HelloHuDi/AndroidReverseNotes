package com.tencent.p177mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import android.webkit.URLUtil;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.network.C1937v;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.model.x */
public final class C32803x {
    public C18642a flf = null;
    boolean flg = false;
    String flh = "";
    BlockingQueue<C9674c> fli = new ArrayBlockingQueue(80);
    public C26431b flj = null;
    C7306ak handler;

    /* renamed from: com.tencent.mm.model.x$c */
    class C9674c {
        String filename;
        boolean flo = false;
        String flp;
        int pos;
        String url;

        public C9674c(String str, String str2, int i, String str3) {
            AppMethodBeat.m2504i(77802);
            this.url = str;
            if (C41764q.ahs() && C32803x.this.flg) {
                this.url = C41764q.m73703sy(this.url);
            }
            this.filename = str2;
            this.pos = i;
            this.flo = false;
            this.flp = str3;
            AppMethodBeat.m2505o(77802);
        }
    }

    /* renamed from: com.tencent.mm.model.x$a */
    public class C18642a implements Runnable {
        public boolean fln = true;

        C18642a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6 A:{SYNTHETIC, Splitter:B:27:0x00b6} */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x000b A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00bb A:{Catch:{ Exception -> 0x00c0 }} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6 A:{SYNTHETIC, Splitter:B:27:0x00b6} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00bb A:{Catch:{ Exception -> 0x00c0 }} */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x000b A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0362 A:{SYNTHETIC, Splitter:B:109:0x0362} */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x0367 A:{Catch:{ Exception -> 0x0379 }} */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0362 A:{SYNTHETIC, Splitter:B:109:0x0362} */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x0367 A:{Catch:{ Exception -> 0x0379 }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            Throwable th;
            AppMethodBeat.m2504i(77801);
            this.fln = false;
            int i = 0;
            while (!this.fln) {
                if (i > 10) {
                    this.fln = true;
                    AppMethodBeat.m2505o(77801);
                    return;
                }
                OutputStream outputStream = null;
                InputStream inputStream = null;
                C9674c c9674c = null;
                try {
                    C9674c c9674c2 = (C9674c) C32803x.this.fli.poll(500, TimeUnit.MILLISECONDS);
                    if (c9674c2 != null) {
                        try {
                            if (!C5046bo.isNullOrNil(c9674c2.url)) {
                                i = 0;
                                C4990ab.m7410d("MicroMsg.GetPicService", "Thread get :" + c9674c2.url + " file:" + c9674c2.filename);
                                if (C1173e.m2561ct(c9674c2.filename)) {
                                    C4990ab.m7410d("MicroMsg.GetPicService", "Thread exist file:" + c9674c2.filename);
                                } else {
                                    C32803x.m53593a(C32803x.this, 0, 1);
                                    long anU = C5046bo.anU();
                                    C4990ab.m7411d("MicroMsg.GetPicService", "get GetPicRunnable, run, url:%s", c9674c2.url);
                                    byte[] bArr;
                                    OutputStream fileOutputStream;
                                    int read;
                                    String contentType;
                                    if (URLUtil.isHttpsUrl(c9674c2.url)) {
                                        C1937v vb = C1897b.m4023vb(c9674c2.url);
                                        if (C41764q.ahs() && C41764q.m73704sz(c9674c2.url)) {
                                            C4990ab.m7411d("MicroMsg.GetPicService", "webp referer:%s", C41764q.m73699lG(C7243d.vxo));
                                            vb.mo5665vc(r3);
                                        }
                                        if (C32803x.this.flg && !C5046bo.isNullOrNil(C32803x.this.flh)) {
                                            C4990ab.m7411d("MicroMsg.GetPicService", "isFromWebview referer:%s", C32803x.this.flh);
                                            vb.mo5665vc(C32803x.this.flh);
                                        }
                                        C4990ab.m7417i("MicroMsg.GetPicService", "getCookie = %s, url = %s", c9674c2.flp, c9674c2.url);
                                        if (!C5046bo.isNullOrNil(c9674c2.flp)) {
                                            String str = c9674c2.flp;
                                            vb.gdG.setRequestProperty("Cookie", str);
                                        }
                                        vb.anb();
                                        vb.amZ();
                                        vb.ana();
                                        inputStream = vb.gdG.getInputStream();
                                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        fileOutputStream = new FileOutputStream(c9674c2.filename + ".tmp");
                                        while (true) {
                                            try {
                                                read = inputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            } catch (Exception e2) {
                                                e = e2;
                                                c9674c = c9674c2;
                                                outputStream = fileOutputStream;
                                                try {
                                                    C4990ab.m7413e("MicroMsg.GetPicService", "exception:%s", C5046bo.m7574l(e));
                                                    C32803x.m53593a(C32803x.this, 2, 1);
                                                    C32803x.m53593a(C32803x.this, 15, 1);
                                                    if (outputStream != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (outputStream != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    AppMethodBeat.m2505o(77801);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                outputStream = fileOutputStream;
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                AppMethodBeat.m2505o(77801);
                                                throw th;
                                            }
                                        }
                                        new File(c9674c2.filename + ".tmp").renameTo(new File(c9674c2.filename));
                                        contentType = vb.gdG.getContentType();
                                        C4990ab.m7411d("MicroMsg.GetPicService", "contentType:%s", contentType);
                                        outputStream = fileOutputStream;
                                    } else {
                                        C1936u a = C1897b.m4020a(c9674c2.url, null);
                                        if (C41764q.ahs() && C41764q.m73704sz(c9674c2.url)) {
                                            C4990ab.m7411d("MicroMsg.GetPicService", "webp referer:%s", C41764q.m73699lG(C7243d.vxo));
                                            a.mo5661vc(r3);
                                        }
                                        if (C32803x.this.flg && !C5046bo.isNullOrNil(C32803x.this.flh)) {
                                            C4990ab.m7411d("MicroMsg.GetPicService", "isFromWebview referer:%s", C32803x.this.flh);
                                            a.mo5661vc(C32803x.this.flh);
                                        }
                                        C4990ab.m7417i("MicroMsg.GetPicService", "getCookie = %s, url = %s", c9674c2.flp, c9674c2.url);
                                        if (!C5046bo.isNullOrNil(c9674c2.flp)) {
                                            a.setRequestProperty("Cookie", c9674c2.flp);
                                        }
                                        a.setUseCaches(true);
                                        a.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                                        a.setReadTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                                        inputStream = a.getInputStream();
                                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        fileOutputStream = new FileOutputStream(c9674c2.filename + ".tmp");
                                        while (true) {
                                            try {
                                                read = inputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            } catch (Exception e3) {
                                                e = e3;
                                                c9674c = c9674c2;
                                                outputStream = fileOutputStream;
                                                C4990ab.m7413e("MicroMsg.GetPicService", "exception:%s", C5046bo.m7574l(e));
                                                C32803x.m53593a(C32803x.this, 2, 1);
                                                C32803x.m53593a(C32803x.this, 15, 1);
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                outputStream = fileOutputStream;
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (Exception e4) {
                                                        AppMethodBeat.m2505o(77801);
                                                        throw th;
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                AppMethodBeat.m2505o(77801);
                                                throw th;
                                            }
                                        }
                                        new File(c9674c2.filename + ".tmp").renameTo(new File(c9674c2.filename));
                                        contentType = a.connection.getContentType();
                                        C4990ab.m7411d("MicroMsg.GetPicService", "contentType:%s", contentType);
                                        outputStream = fileOutputStream;
                                    }
                                    if (C41764q.ahs() && C41764q.m73704sz(c9674c2.url) && !C5046bo.isNullOrNil(contentType) && contentType.equals("image/webp")) {
                                        C4990ab.m7410d("MicroMsg.GetPicService", "receive a webp picture");
                                        c9674c2.flo = true;
                                        C32803x.m53593a(C32803x.this, 13, 1);
                                    } else {
                                        c9674c2.flo = false;
                                    }
                                    Message message = new Message();
                                    message.obj = c9674c2;
                                    message.arg1 = c9674c2.pos;
                                    C32803x.this.handler.sendMessage(message);
                                    long anU2 = C5046bo.anU() - anU;
                                    C4990ab.m7411d("MicroMsg.GetPicService", "download image used: %dms", Long.valueOf(anU2));
                                    C32803x.m53593a(C32803x.this, 4, anU2);
                                    if (c9674c2 != null && c9674c2.flo) {
                                        C32803x.m53593a(C32803x.this, 17, anU2);
                                    }
                                    try {
                                        outputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e5) {
                                    }
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            c9674c = c9674c2;
                        }
                    }
                    i++;
                } catch (Exception th5) {
                    e = th5;
                    C4990ab.m7413e("MicroMsg.GetPicService", "exception:%s", C5046bo.m7574l(e));
                    C32803x.m53593a(C32803x.this, 2, 1);
                    if (c9674c != null && C41764q.m73704sz(c9674c.url)) {
                        C32803x.m53593a(C32803x.this, 15, 1);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
            AppMethodBeat.m2505o(77801);
        }
    }

    /* renamed from: com.tencent.mm.model.x$b */
    public interface C26431b {
        /* renamed from: d */
        void mo44194d(String str, String str2, int i);
    }

    public C32803x(boolean z, String str) {
        AppMethodBeat.m2504i(77803);
        C1720g.m3537RQ();
        this.handler = new C7306ak(C1720g.m3539RS().oAl.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(77800);
                try {
                    if (C32803x.this.flj != null) {
                        final C9674c c9674c = (C9674c) message.obj;
                        if (c9674c.flo && C41764q.ahs()) {
                            String sA = C41764q.m73701sA(c9674c.url);
                            C4990ab.m7411d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", sA, c9674c.filename, c9674c.url);
                            Bitmap aml = C5056d.aml(c9674c.filename);
                            if (aml == null) {
                                C4990ab.m7410d("MicroMsg.GetPicService", "decode webp picture failed");
                                C32803x.m53593a(C32803x.this, 14, 1);
                            } else if (!C5046bo.isNullOrNil(sA)) {
                                if (sA.toLowerCase().contains("png")) {
                                    C4990ab.m7410d("MicroMsg.GetPicService", "convert webp to png");
                                    C5056d.m7625a(aml, 100, CompressFormat.PNG, c9674c.filename, true);
                                } else {
                                    C4990ab.m7410d("MicroMsg.GetPicService", "convert webp to jpg");
                                    C5056d.m7625a(aml, 100, CompressFormat.JPEG, c9674c.filename, true);
                                }
                            }
                        }
                        int cs = C1173e.m2560cs(c9674c.filename);
                        if (cs > 0 && C1720g.m3531RK()) {
                            C26417a.flv.mo44184cm(cs, 0);
                        }
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(77799);
                                if (C32803x.this.flj != null) {
                                    C32803x.this.flj.mo44194d(c9674c.url, c9674c.filename, c9674c.pos);
                                }
                                AppMethodBeat.m2505o(77799);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(77800);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.GetPicService", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(77800);
                }
            }
        };
        this.flf = null;
        this.flg = z;
        this.flh = str;
        C4990ab.m7411d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b isFromWebViewReffer:%s", Boolean.valueOf(z), str);
        AppMethodBeat.m2505o(77803);
    }

    /* renamed from: c */
    public final String mo53360c(String str, int i, int i2, String str2) {
        String str3;
        AppMethodBeat.m2504i(77804);
        if (str == null) {
            str3 = null;
        } else if (C1720g.m3531RK()) {
            str3 = C43217c.m76863XW() + "/reader_" + i + "_" + C1178g.m2591x(str.getBytes()) + FileUtils.PIC_POSTFIX_JPEG;
        } else {
            C4990ab.m7416i("MicroMsg.GetPicService", "genFileName, account not ready");
            File file = new File(C1720g.m3536RP().eJL + "/imagecache");
            if (!file.exists()) {
                file.mkdirs();
            }
            str3 = file.getAbsolutePath() + "/reader_" + i + "_" + C1178g.m2591x(str.getBytes()) + FileUtils.PIC_POSTFIX_JPEG;
        }
        C4990ab.m7410d("MicroMsg.GetPicService", "getPicfileByUrl type:" + i + " url:" + str);
        try {
            if (C1173e.m2561ct(str3)) {
                AppMethodBeat.m2505o(77804);
                return str3;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.GetPicService", "exception:%s", C5046bo.m7574l(e));
        }
        try {
            this.fli.add(new C9674c(str, str3, i2, str2));
            if (this.flf == null || !C7305d.xDG.mo10150ao(this.flf)) {
                C7305d.xDG.remove(this.flf);
                this.flf = new C18642a();
                C7305d.post(this.flf, "GetPicService_getPic");
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.GetPicService", "exception:%s", C5046bo.m7574l(e2));
        }
        AppMethodBeat.m2505o(77804);
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m53593a(C32803x c32803x, long j, long j2) {
        AppMethodBeat.m2504i(77805);
        if (c32803x.flg) {
            C4990ab.m7411d("MicroMsg.GetPicService", "doIdKeyStat, key:%d, val:%d", Long.valueOf(j), Long.valueOf(j2));
            C7060h.pYm.mo8378a(86, j, j2, false);
        }
        AppMethodBeat.m2505o(77805);
    }
}
