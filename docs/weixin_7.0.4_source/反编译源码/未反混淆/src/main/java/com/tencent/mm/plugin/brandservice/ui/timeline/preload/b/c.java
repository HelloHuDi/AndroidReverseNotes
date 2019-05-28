package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.ci.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class c {
    private static volatile c jTM = null;
    private ExecutorService jTN = Executors.newFixedThreadPool(1);

    class a {
        boolean jRX;
        String jTZ;
        String jUa;
        boolean success;

        a() {
        }
    }

    public c() {
        AppMethodBeat.i(14414);
        AppMethodBeat.o(14414);
    }

    static c aXE() {
        AppMethodBeat.i(14415);
        if (jTM == null) {
            synchronized (c.class) {
                try {
                    if (jTM == null) {
                        jTM = new c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(14415);
                    }
                }
            }
        }
        c cVar = jTM;
        AppMethodBeat.o(14415);
        return cVar;
    }

    public final void a(final chi chi, final int i, final Runnable runnable) {
        AppMethodBeat.i(14416);
        if (chi == null || bo.isNullOrNil(chi.vZm)) {
            ab.i("MicroMsg.Preload.TmplDownloader", "[addDownloadTask] TmplInfo is null, return");
            AppMethodBeat.o(14416);
        } else if (this.jTN.isShutdown()) {
            ab.i("MicroMsg.Preload.TmplDownloader", "[addDownloadTask] Executor is shutdown");
            AppMethodBeat.o(14416);
        } else {
            this.jTN.submit(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14413);
                    ab.i("MicroMsg.Preload.TmplDownloader", "Type:%d Version:%d CdnUrl:%s  start download md5:%s", Integer.valueOf(chi.jCt), Integer.valueOf(chi.Version), chi.vZm, chi.Md5);
                    final int i = chi.jCt;
                    final int i2 = chi.Version;
                    final String str = chi.vZm;
                    final boolean z = chi.xgd;
                    final HashMap hashMap = new HashMap();
                    Iterator it = chi.xgc.iterator();
                    while (it.hasNext()) {
                        chh chh = (chh) it.next();
                        if (!(bo.isNullOrNil(chh.vMU) || bo.isNullOrNil(chh.pXM))) {
                            hashMap.put(chh.vMU, chh.pXM);
                        }
                    }
                    final String str2 = chi.wld;
                    final int i3 = chi.wUX;
                    g.dOW().h(new com.tencent.mm.vending.c.a<String, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(14412);
                            String aXF = aXF();
                            AppMethodBeat.o(14412);
                            return aXF;
                        }

                        private String aXF() {
                            AppMethodBeat.i(14411);
                            String str;
                            if (z) {
                                final b dMo = f.dMo();
                                final m hVar = new h(str, "", 0, 8, (int) System.currentTimeMillis(), new byte[0]);
                                com.tencent.mm.kernel.g.Rg().a((int) d.MIC_PTU_MEISHI, new com.tencent.mm.ai.f() {
                                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                        AppMethodBeat.i(14410);
                                        com.tencent.mm.kernel.g.Rg().b((int) d.MIC_PTU_MEISHI, (com.tencent.mm.ai.f) this);
                                        ab.i("MicroMsg.Preload.TmplDownloader", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                        if (i == 0 && i2 == 0) {
                                            String aiT = hVar.aiT();
                                            List<atp> aja = hVar.aja();
                                            if (!bo.ek(aja)) {
                                                for (atp atp : aja) {
                                                    if (!(bo.isNullOrNil(atp.vMU) || bo.isNullOrNil(atp.pXM))) {
                                                        hashMap.put(atp.vMU, atp.pXM);
                                                    }
                                                }
                                            }
                                            dMo.B(aiT);
                                            AppMethodBeat.o(14410);
                                            return;
                                        }
                                        dMo.B("");
                                        AppMethodBeat.o(14410);
                                    }
                                });
                                com.tencent.mm.kernel.g.Rg().a(hVar, 0);
                                str = "";
                                AppMethodBeat.o(14411);
                                return str;
                            }
                            ab.i("MicroMsg.Preload.TmplDownloader", "not do getA8Key, return");
                            str = str;
                            AppMethodBeat.o(14411);
                            return str;
                        }
                    }).g(new com.tencent.mm.vending.c.a<Void, String>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(14409);
                            Void xQ = xQ((String) obj);
                            AppMethodBeat.o(14409);
                            return xQ;
                        }

                        private Void xQ(String str) {
                            AppMethodBeat.i(14408);
                            if (bo.isNullOrNil(str)) {
                                ab.e("MicroMsg.Preload.TmplDownloader", "url is null, err, return");
                                AppMethodBeat.o(14408);
                                return null;
                            }
                            a a;
                            int i;
                            com.tencent.mm.plugin.webview.preload.b bVar = new com.tencent.mm.plugin.webview.preload.b();
                            bVar.startTime = System.currentTimeMillis();
                            com.tencent.mm.plugin.webview.preload.a.e(i3, 3, 1, true);
                            String am = k.am(i, str2);
                            try {
                                a = c.aXE().a(i3, str, hashMap, am);
                            } catch (Exception e) {
                                Throwable th = e;
                                a = new a();
                                ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", th, "downloadTmpl", new Object[0]);
                            }
                            bVar.jSu = i;
                            bVar.upH = a.jTZ != null;
                            bVar.upG = i2;
                            bVar.jSV = i;
                            bVar.upI = str2;
                            boolean z = false;
                            if (a.jRX) {
                                int i2 = i3;
                                if (a.success) {
                                    i = d.MIC_PTU_FENGJING;
                                } else {
                                    i = d.MIC_PTU_AUTOLEVEL;
                                }
                                com.tencent.mm.plugin.webview.preload.a.e(i2, i, 1, true);
                            }
                            int i3;
                            if (a.success) {
                                String q;
                                boolean z2;
                                File file = new File(am);
                                bVar.size = file.length();
                                if (a.jTZ != null) {
                                    if (a.jUa != null) {
                                        if (a.jRX) {
                                            com.tencent.mm.plugin.webview.preload.a.e(i3, d.MIC_PTU_LENGMEIREN, 1, true);
                                        }
                                        if (c.c(a.jUa, file)) {
                                            boolean a2;
                                            if (a.jRX) {
                                                q = k.q(i, a.jTZ, "origin.zip");
                                            } else {
                                                q = k.ak(i, a.jTZ);
                                            }
                                            if (new File(q).exists()) {
                                                a2 = c.a(a, i3, chi.Md5, file, q);
                                                if (a.jRX && !a2) {
                                                    com.tencent.mm.plugin.webview.preload.a.e(i3, d.MIC_PTU_SHISHANG2, 1, true);
                                                    z2 = a2;
                                                }
                                            } else {
                                                ab.e("MicroMsg.Preload.TmplDownloader", "patch origin file not found:%s", q);
                                                if (a.jRX) {
                                                    com.tencent.mm.plugin.webview.preload.a.e(i3, d.MIC_PTU_SHIGUANG, 1, true);
                                                }
                                                a2 = false;
                                            }
                                            z2 = a2;
                                        } else {
                                            com.tencent.mm.plugin.webview.preload.a.e(i3, 220, 1, true);
                                            if (a.jRX) {
                                                com.tencent.mm.plugin.webview.preload.a.e(i3, 236, 1, true);
                                                z2 = false;
                                            }
                                            z2 = false;
                                        }
                                    } else {
                                        ab.e("MicroMsg.Preload.TmplDownloader", "checkTmpl %d,%s, no patch MD5", Integer.valueOf(chi.jCt), chi.wld);
                                        com.tencent.mm.plugin.webview.preload.a.e(i3, 229, 1, true);
                                        z2 = false;
                                    }
                                } else if (c.c(chi.Md5, file)) {
                                    ab.i("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] download & MD5 verify success");
                                    z2 = true;
                                } else {
                                    com.tencent.mm.plugin.webview.preload.a.e(i3, 6, 1, true);
                                    ab.e("MicroMsg.Preload.TmplDownloader", "checkTmpl %d,%s MD5 not match", Integer.valueOf(chi.jCt), chi.wld);
                                    z2 = false;
                                }
                                if (z2) {
                                    int i4;
                                    if (a.jRX) {
                                        try {
                                            q = k.q(i, str2, "");
                                            c.di(am, q);
                                            new File(am).renameTo(new File(q + "/origin.zip"));
                                        } catch (Exception e2) {
                                            com.tencent.mm.plugin.webview.preload.a.e(i3, d.MIC_PTU_QINGCONG, 1, true);
                                            if (a.jTZ != null) {
                                                com.tencent.mm.plugin.webview.preload.a.e(i3, 242, 1, true);
                                            }
                                            ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e2, "zip", new Object[0]);
                                        }
                                    } else {
                                        new File(am).renameTo(new File(k.ak(i, str2)));
                                    }
                                    bVar.endTime = System.currentTimeMillis();
                                    long j = bVar.endTime - bVar.startTime;
                                    if (at.isWifi(ah.getContext())) {
                                        q = "wifi";
                                    } else if (at.is4G(ah.getContext())) {
                                        q = "4g";
                                    } else if (at.is3G(ah.getContext())) {
                                        q = "3g";
                                    } else if (at.is2G(ah.getContext())) {
                                        q = "2g";
                                    } else {
                                        q = "none";
                                    }
                                    ab.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", Integer.valueOf(bVar.upG), Boolean.valueOf(bVar.upH), Long.valueOf(j), Long.valueOf(bVar.size), q, Integer.valueOf(bVar.jSV), bVar.upI);
                                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(bVar.upG);
                                    if (bVar.upH) {
                                        i4 = 1;
                                    } else {
                                        i4 = 0;
                                    }
                                    objArr[1] = Integer.valueOf(i4);
                                    objArr[2] = Long.valueOf(Math.min(j, 3600000));
                                    objArr[3] = Long.valueOf(bVar.size);
                                    objArr[4] = q;
                                    objArr[5] = Integer.valueOf(bVar.jSV);
                                    objArr[6] = bVar.upI;
                                    objArr[7] = Integer.valueOf(bVar.jSu);
                                    hVar.e(15870, objArr);
                                    chi sv = b.sv(i);
                                    if (sv.Version != 0) {
                                        if (sv.Version < chi.Version) {
                                            com.tencent.mm.plugin.webview.preload.a.e(i3, 12, 1, true);
                                        } else if (sv.Version > chi.Version) {
                                            com.tencent.mm.plugin.webview.preload.a.e(i3, 13, 1, true);
                                        }
                                    }
                                    if (runnable != null) {
                                        runnable.run();
                                    }
                                }
                                i = i3;
                                if (a.jTZ != null) {
                                    i3 = 224;
                                } else {
                                    i3 = 226;
                                }
                                com.tencent.mm.plugin.webview.preload.a.e(i, i3, 1, true);
                                com.tencent.mm.plugin.webview.preload.a.e(i3, 4, 1, true);
                                z = z2;
                            } else {
                                i = i3;
                                if (a.jTZ != null) {
                                    i3 = 225;
                                } else {
                                    i3 = 227;
                                }
                                com.tencent.mm.plugin.webview.preload.a.e(i, i3, 1, true);
                                com.tencent.mm.plugin.webview.preload.a.e(i3, 5, 1, true);
                                ab.e("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] download fail");
                            }
                            j.de("MicroMsg.Preload.TmplDownloader", "isDownloadSuccess:" + z + " :" + String.format("%d,%s", new Object[]{Integer.valueOf(i), str2}));
                            AppMethodBeat.o(14408);
                            return null;
                        }
                    });
                    AppMethodBeat.o(14413);
                }
            });
            AppMethodBeat.o(14416);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f6 A:{Catch:{ IOException -> 0x021c }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf A:{Catch:{ IOException -> 0x020d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a a(int i, String str, Map<String, String> map, String str2) {
        File file;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable e;
        AppMethodBeat.i(14417);
        a aVar = new a();
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.Preload.TmplDownloader", "downloadUrl is null, return");
            com.tencent.mm.plugin.webview.preload.a.e(i, 9, 1, true);
            AppMethodBeat.o(14417);
            return aVar;
        }
        file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            try {
                fileOutputStream = new FileOutputStream(file);
                inputStream = null;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                    httpURLConnection.setRequestProperty("Cache-Control", "no-store");
                    httpURLConnection.setDefaultUseCaches(false);
                    if (map != null && map.size() > 0) {
                        ab.i("MicroMsg.Preload.TmplDownloader", "headers.size:%d", Integer.valueOf(map.size()));
                        for (String str3 : map.keySet()) {
                            httpURLConnection.setRequestProperty(str3, (String) map.get(str3));
                        }
                    }
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                    httpURLConnection.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    httpURLConnection.connect();
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            boolean z;
                            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            aVar.success = true;
                            aVar.jTZ = httpURLConnection.getHeaderField("X-WECHAT-MPBASEFULLVERSION");
                            aVar.jUa = httpURLConnection.getHeaderField("X-WECHAT-MPPATCHMD5");
                            String headerField = httpURLConnection.getHeaderField("X-WECHAT-MPCONTROLFLAG");
                            if (headerField == null || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(headerField)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            aVar.jRX = z;
                            try {
                                fileOutputStream.getFD().sync();
                            } catch (Exception e2) {
                            }
                            try {
                                fileOutputStream.close();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                            } catch (IOException e3) {
                                ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e3, "", new Object[0]);
                            }
                            AppMethodBeat.o(14417);
                            return aVar;
                        }
                        ab.e("MicroMsg.Preload.TmplDownloader", "Server return code:".concat(String.valueOf(responseCode)));
                        if (responseCode > 500) {
                            com.tencent.mm.plugin.webview.preload.a.e(i, 11, 1, true);
                        } else if (responseCode > 400) {
                            com.tencent.mm.plugin.webview.preload.a.e(i, 10, 1, true);
                        }
                        try {
                            fileOutputStream.getFD().sync();
                        } catch (Exception e4) {
                        }
                        try {
                            fileOutputStream.close();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                        } catch (IOException e32) {
                            ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e32, "", new Object[0]);
                        }
                        AppMethodBeat.o(14417);
                        return aVar;
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (IOException e6) {
                    e = e6;
                    inputStream2 = null;
                } catch (Throwable th) {
                    e = th;
                    try {
                        fileOutputStream.getFD().sync();
                    } catch (Exception e7) {
                    }
                    try {
                        fileOutputStream.close();
                        if (inputStream != null) {
                        }
                    } catch (IOException e8) {
                        ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e8, "", new Object[0]);
                    }
                    AppMethodBeat.o(14417);
                    throw e;
                }
            } catch (FileNotFoundException e9) {
                ab.e("MicroMsg.Preload.TmplDownloader", "can not fond output folder");
                ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e9, "", new Object[0]);
                com.tencent.mm.plugin.webview.preload.a.e(i, 7, 1, true);
                AppMethodBeat.o(14417);
                return aVar;
            }
        } catch (IOException e322) {
            ab.e("MicroMsg.Preload.TmplDownloader", "can not new file");
            ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e322, "", new Object[0]);
            com.tencent.mm.plugin.webview.preload.a.e(i, 7, 1, true);
            AppMethodBeat.o(14417);
            return aVar;
        }
        try {
            ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e, "download url:".concat(String.valueOf(str)), new Object[0]);
            com.tencent.mm.plugin.webview.preload.a.e(i, 7, 1, true);
            if (file.exists()) {
                file.delete();
            }
            try {
                fileOutputStream.getFD().sync();
            } catch (Exception e10) {
            }
            try {
                fileOutputStream.close();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (IOException e3222) {
                ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e3222, "", new Object[0]);
            }
            AppMethodBeat.o(14417);
            return aVar;
        } catch (Throwable th2) {
            e = th2;
            inputStream = inputStream2;
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.o(14417);
            throw e;
        }
        AppMethodBeat.o(14417);
        return aVar;
        fileOutputStream.close();
        if (inputStream2 != null) {
        }
        AppMethodBeat.o(14417);
        return aVar;
    }

    static /* synthetic */ boolean c(String str, File file) {
        AppMethodBeat.i(14418);
        if (bo.isNullOrNil(str) || !str.equals(com.tencent.mm.a.g.v(file))) {
            ab.e("MicroMsg.Preload.TmplDownloader", "checkTmpl %s, MD5 not match", file.getAbsolutePath());
            AppMethodBeat.o(14418);
            return false;
        }
        AppMethodBeat.o(14418);
        return true;
    }

    static /* synthetic */ boolean a(a aVar, int i, String str, File file, String str2) {
        AppMethodBeat.i(14419);
        String str3 = str2 + ".patch";
        if (((IBSPatchJNIService) com.tencent.mm.kernel.g.K(IBSPatchJNIService.class)).bspatch(str2, str3, file.getAbsolutePath()) == 0) {
            ab.i("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] patch download success");
            File file2 = new File(str3);
            str3 = com.tencent.mm.a.g.v(file2);
            if (bo.isNullOrNil(str3) || !str3.equals(str)) {
                file2.delete();
                com.tencent.mm.plugin.webview.preload.a.e(i, 228, 1, true);
                if (aVar.jRX) {
                    com.tencent.mm.plugin.webview.preload.a.e(i, 240, 1, true);
                }
                ab.e("MicroMsg.Preload.TmplDownloader", "checkTmpl %s MD5 not match after patch", str2);
            } else {
                ab.i("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] patch MD5 verify success");
                e.d(file2, file);
                AppMethodBeat.o(14419);
                return true;
            }
        }
        com.tencent.mm.plugin.webview.preload.a.e(i, 222, 1, true);
        ab.e("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] patch fail");
        AppMethodBeat.o(14419);
        return false;
    }

    static /* synthetic */ boolean di(String str, String str2) {
        AppMethodBeat.i(14420);
        ZipFile zipFile = new ZipFile(str);
        Enumeration entries = zipFile.entries();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (name.indexOf("../") != -1) {
                ab.e("MicroMsg.Preload.TmplDownloader", "skip unzip break through file:%s", name);
            } else {
                File file = new File(str2 + name);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!zipEntry.isDirectory()) {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    inputStream.close();
                } else if (!file.exists()) {
                    file.mkdir();
                }
            }
        }
        AppMethodBeat.o(14420);
        return true;
    }
}
