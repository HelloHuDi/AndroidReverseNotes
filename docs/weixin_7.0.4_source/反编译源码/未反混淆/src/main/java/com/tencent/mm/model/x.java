package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import android.webkit.URLUtil;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.at.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class x {
    public a flf = null;
    boolean flg = false;
    String flh = "";
    BlockingQueue<c> fli = new ArrayBlockingQueue(80);
    public b flj = null;
    ak handler;

    class c {
        String filename;
        boolean flo = false;
        String flp;
        int pos;
        String url;

        public c(String str, String str2, int i, String str3) {
            AppMethodBeat.i(77802);
            this.url = str;
            if (q.ahs() && x.this.flg) {
                this.url = q.sy(this.url);
            }
            this.filename = str2;
            this.pos = i;
            this.flo = false;
            this.flp = str3;
            AppMethodBeat.o(77802);
        }
    }

    public class a implements Runnable {
        public boolean fln = true;

        a() {
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
            AppMethodBeat.i(77801);
            this.fln = false;
            int i = 0;
            while (!this.fln) {
                if (i > 10) {
                    this.fln = true;
                    AppMethodBeat.o(77801);
                    return;
                }
                OutputStream outputStream = null;
                InputStream inputStream = null;
                c cVar = null;
                try {
                    c cVar2 = (c) x.this.fli.poll(500, TimeUnit.MILLISECONDS);
                    if (cVar2 != null) {
                        try {
                            if (!bo.isNullOrNil(cVar2.url)) {
                                i = 0;
                                ab.d("MicroMsg.GetPicService", "Thread get :" + cVar2.url + " file:" + cVar2.filename);
                                if (e.ct(cVar2.filename)) {
                                    ab.d("MicroMsg.GetPicService", "Thread exist file:" + cVar2.filename);
                                } else {
                                    x.a(x.this, 0, 1);
                                    long anU = bo.anU();
                                    ab.d("MicroMsg.GetPicService", "get GetPicRunnable, run, url:%s", cVar2.url);
                                    byte[] bArr;
                                    OutputStream fileOutputStream;
                                    int read;
                                    String contentType;
                                    if (URLUtil.isHttpsUrl(cVar2.url)) {
                                        v vb = com.tencent.mm.network.b.vb(cVar2.url);
                                        if (q.ahs() && q.sz(cVar2.url)) {
                                            ab.d("MicroMsg.GetPicService", "webp referer:%s", q.lG(d.vxo));
                                            vb.vc(r3);
                                        }
                                        if (x.this.flg && !bo.isNullOrNil(x.this.flh)) {
                                            ab.d("MicroMsg.GetPicService", "isFromWebview referer:%s", x.this.flh);
                                            vb.vc(x.this.flh);
                                        }
                                        ab.i("MicroMsg.GetPicService", "getCookie = %s, url = %s", cVar2.flp, cVar2.url);
                                        if (!bo.isNullOrNil(cVar2.flp)) {
                                            String str = cVar2.flp;
                                            vb.gdG.setRequestProperty("Cookie", str);
                                        }
                                        vb.anb();
                                        vb.amZ();
                                        vb.ana();
                                        inputStream = vb.gdG.getInputStream();
                                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        fileOutputStream = new FileOutputStream(cVar2.filename + ".tmp");
                                        while (true) {
                                            try {
                                                read = inputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            } catch (Exception e2) {
                                                e = e2;
                                                cVar = cVar2;
                                                outputStream = fileOutputStream;
                                                try {
                                                    ab.e("MicroMsg.GetPicService", "exception:%s", bo.l(e));
                                                    x.a(x.this, 2, 1);
                                                    x.a(x.this, 15, 1);
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
                                                    AppMethodBeat.o(77801);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                outputStream = fileOutputStream;
                                                if (outputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                AppMethodBeat.o(77801);
                                                throw th;
                                            }
                                        }
                                        new File(cVar2.filename + ".tmp").renameTo(new File(cVar2.filename));
                                        contentType = vb.gdG.getContentType();
                                        ab.d("MicroMsg.GetPicService", "contentType:%s", contentType);
                                        outputStream = fileOutputStream;
                                    } else {
                                        u a = com.tencent.mm.network.b.a(cVar2.url, null);
                                        if (q.ahs() && q.sz(cVar2.url)) {
                                            ab.d("MicroMsg.GetPicService", "webp referer:%s", q.lG(d.vxo));
                                            a.vc(r3);
                                        }
                                        if (x.this.flg && !bo.isNullOrNil(x.this.flh)) {
                                            ab.d("MicroMsg.GetPicService", "isFromWebview referer:%s", x.this.flh);
                                            a.vc(x.this.flh);
                                        }
                                        ab.i("MicroMsg.GetPicService", "getCookie = %s, url = %s", cVar2.flp, cVar2.url);
                                        if (!bo.isNullOrNil(cVar2.flp)) {
                                            a.setRequestProperty("Cookie", cVar2.flp);
                                        }
                                        a.setUseCaches(true);
                                        a.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                                        a.setReadTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                                        inputStream = a.getInputStream();
                                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        fileOutputStream = new FileOutputStream(cVar2.filename + ".tmp");
                                        while (true) {
                                            try {
                                                read = inputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            } catch (Exception e3) {
                                                e = e3;
                                                cVar = cVar2;
                                                outputStream = fileOutputStream;
                                                ab.e("MicroMsg.GetPicService", "exception:%s", bo.l(e));
                                                x.a(x.this, 2, 1);
                                                x.a(x.this, 15, 1);
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
                                                        AppMethodBeat.o(77801);
                                                        throw th;
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                AppMethodBeat.o(77801);
                                                throw th;
                                            }
                                        }
                                        new File(cVar2.filename + ".tmp").renameTo(new File(cVar2.filename));
                                        contentType = a.connection.getContentType();
                                        ab.d("MicroMsg.GetPicService", "contentType:%s", contentType);
                                        outputStream = fileOutputStream;
                                    }
                                    if (q.ahs() && q.sz(cVar2.url) && !bo.isNullOrNil(contentType) && contentType.equals("image/webp")) {
                                        ab.d("MicroMsg.GetPicService", "receive a webp picture");
                                        cVar2.flo = true;
                                        x.a(x.this, 13, 1);
                                    } else {
                                        cVar2.flo = false;
                                    }
                                    Message message = new Message();
                                    message.obj = cVar2;
                                    message.arg1 = cVar2.pos;
                                    x.this.handler.sendMessage(message);
                                    long anU2 = bo.anU() - anU;
                                    ab.d("MicroMsg.GetPicService", "download image used: %dms", Long.valueOf(anU2));
                                    x.a(x.this, 4, anU2);
                                    if (cVar2 != null && cVar2.flo) {
                                        x.a(x.this, 17, anU2);
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
                            cVar = cVar2;
                        }
                    }
                    i++;
                } catch (Exception th5) {
                    e = th5;
                    ab.e("MicroMsg.GetPicService", "exception:%s", bo.l(e));
                    x.a(x.this, 2, 1);
                    if (cVar != null && q.sz(cVar.url)) {
                        x.a(x.this, 15, 1);
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
            AppMethodBeat.o(77801);
        }
    }

    public interface b {
        void d(String str, String str2, int i);
    }

    public x(boolean z, String str) {
        AppMethodBeat.i(77803);
        g.RQ();
        this.handler = new ak(g.RS().oAl.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(77800);
                try {
                    if (x.this.flj != null) {
                        final c cVar = (c) message.obj;
                        if (cVar.flo && q.ahs()) {
                            String sA = q.sA(cVar.url);
                            ab.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", sA, cVar.filename, cVar.url);
                            Bitmap aml = com.tencent.mm.sdk.platformtools.d.aml(cVar.filename);
                            if (aml == null) {
                                ab.d("MicroMsg.GetPicService", "decode webp picture failed");
                                x.a(x.this, 14, 1);
                            } else if (!bo.isNullOrNil(sA)) {
                                if (sA.toLowerCase().contains("png")) {
                                    ab.d("MicroMsg.GetPicService", "convert webp to png");
                                    com.tencent.mm.sdk.platformtools.d.a(aml, 100, CompressFormat.PNG, cVar.filename, true);
                                } else {
                                    ab.d("MicroMsg.GetPicService", "convert webp to jpg");
                                    com.tencent.mm.sdk.platformtools.d.a(aml, 100, CompressFormat.JPEG, cVar.filename, true);
                                }
                            }
                        }
                        int cs = e.cs(cVar.filename);
                        if (cs > 0 && g.RK()) {
                            com.tencent.mm.model.ao.a.flv.cm(cs, 0);
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(77799);
                                if (x.this.flj != null) {
                                    x.this.flj.d(cVar.url, cVar.filename, cVar.pos);
                                }
                                AppMethodBeat.o(77799);
                            }
                        });
                    }
                    AppMethodBeat.o(77800);
                } catch (Exception e) {
                    ab.e("MicroMsg.GetPicService", "exception:%s", bo.l(e));
                    AppMethodBeat.o(77800);
                }
            }
        };
        this.flf = null;
        this.flg = z;
        this.flh = str;
        ab.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b isFromWebViewReffer:%s", Boolean.valueOf(z), str);
        AppMethodBeat.o(77803);
    }

    public final String c(String str, int i, int i2, String str2) {
        String str3;
        AppMethodBeat.i(77804);
        if (str == null) {
            str3 = null;
        } else if (g.RK()) {
            str3 = com.tencent.mm.plugin.i.c.XW() + "/reader_" + i + "_" + com.tencent.mm.a.g.x(str.getBytes()) + FileUtils.PIC_POSTFIX_JPEG;
        } else {
            ab.i("MicroMsg.GetPicService", "genFileName, account not ready");
            File file = new File(g.RP().eJL + "/imagecache");
            if (!file.exists()) {
                file.mkdirs();
            }
            str3 = file.getAbsolutePath() + "/reader_" + i + "_" + com.tencent.mm.a.g.x(str.getBytes()) + FileUtils.PIC_POSTFIX_JPEG;
        }
        ab.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + i + " url:" + str);
        try {
            if (e.ct(str3)) {
                AppMethodBeat.o(77804);
                return str3;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.GetPicService", "exception:%s", bo.l(e));
        }
        try {
            this.fli.add(new c(str, str3, i2, str2));
            if (this.flf == null || !com.tencent.mm.sdk.g.d.xDG.ao(this.flf)) {
                com.tencent.mm.sdk.g.d.xDG.remove(this.flf);
                this.flf = new a();
                com.tencent.mm.sdk.g.d.post(this.flf, "GetPicService_getPic");
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.GetPicService", "exception:%s", bo.l(e2));
        }
        AppMethodBeat.o(77804);
        return null;
    }

    static /* synthetic */ void a(x xVar, long j, long j2) {
        AppMethodBeat.i(77805);
        if (xVar.flg) {
            ab.d("MicroMsg.GetPicService", "doIdKeyStat, key:%d, val:%d", Long.valueOf(j), Long.valueOf(j2));
            h.pYm.a(86, j, j2, false);
        }
        AppMethodBeat.o(77805);
    }
}
