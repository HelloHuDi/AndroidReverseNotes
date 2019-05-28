package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27539k;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C38710j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.C43925b;
import com.tencent.p177mm.protocal.protobuf.atp;
import com.tencent.p177mm.protocal.protobuf.chh;
import com.tencent.p177mm.protocal.protobuf.chi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c */
public class C27537c {
    private static volatile C27537c jTM = null;
    private ExecutorService jTN = Executors.newFixedThreadPool(1);

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c$a */
    class C11253a {
        boolean jRX;
        String jTZ;
        String jUa;
        boolean success;

        C11253a() {
        }
    }

    public C27537c() {
        AppMethodBeat.m2504i(14414);
        AppMethodBeat.m2505o(14414);
    }

    static C27537c aXE() {
        AppMethodBeat.m2504i(14415);
        if (jTM == null) {
            synchronized (C27537c.class) {
                try {
                    if (jTM == null) {
                        jTM = new C27537c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(14415);
                    }
                }
            }
        }
        C27537c c27537c = jTM;
        AppMethodBeat.m2505o(14415);
        return c27537c;
    }

    /* renamed from: a */
    public final void mo45343a(final chi chi, final int i, final Runnable runnable) {
        AppMethodBeat.m2504i(14416);
        if (chi == null || C5046bo.isNullOrNil(chi.vZm)) {
            C4990ab.m7416i("MicroMsg.Preload.TmplDownloader", "[addDownloadTask] TmplInfo is null, return");
            AppMethodBeat.m2505o(14416);
        } else if (this.jTN.isShutdown()) {
            C4990ab.m7416i("MicroMsg.Preload.TmplDownloader", "[addDownloadTask] Executor is shutdown");
            AppMethodBeat.m2505o(14416);
        } else {
            this.jTN.submit(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14413);
                    C4990ab.m7417i("MicroMsg.Preload.TmplDownloader", "Type:%d Version:%d CdnUrl:%s  start download md5:%s", Integer.valueOf(chi.jCt), Integer.valueOf(chi.Version), chi.vZm, chi.Md5);
                    final int i = chi.jCt;
                    final int i2 = chi.Version;
                    final String str = chi.vZm;
                    final boolean z = chi.xgd;
                    final HashMap hashMap = new HashMap();
                    Iterator it = chi.xgc.iterator();
                    while (it.hasNext()) {
                        chh chh = (chh) it.next();
                        if (!(C5046bo.isNullOrNil(chh.vMU) || C5046bo.isNullOrNil(chh.pXM))) {
                            hashMap.put(chh.vMU, chh.pXM);
                        }
                    }
                    final String str2 = chi.wld;
                    final int i3 = chi.wUX;
                    C41930g.dOW().mo60492h(new C5681a<String, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(14412);
                            String aXF = aXF();
                            AppMethodBeat.m2505o(14412);
                            return aXF;
                        }

                        private String aXF() {
                            AppMethodBeat.m2504i(14411);
                            String str;
                            if (z) {
                                final C5688b dMo = C5698f.dMo();
                                final C1207m c6681h = new C6681h(str, "", 0, 8, (int) System.currentTimeMillis(), new byte[0]);
                                C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, new C1202f() {
                                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                        AppMethodBeat.m2504i(14410);
                                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
                                        C4990ab.m7417i("MicroMsg.Preload.TmplDownloader", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                        if (i == 0 && i2 == 0) {
                                            String aiT = c6681h.aiT();
                                            List<atp> aja = c6681h.aja();
                                            if (!C5046bo.m7548ek(aja)) {
                                                for (atp atp : aja) {
                                                    if (!(C5046bo.isNullOrNil(atp.vMU) || C5046bo.isNullOrNil(atp.pXM))) {
                                                        hashMap.put(atp.vMU, atp.pXM);
                                                    }
                                                }
                                            }
                                            dMo.mo11581B(aiT);
                                            AppMethodBeat.m2505o(14410);
                                            return;
                                        }
                                        dMo.mo11581B("");
                                        AppMethodBeat.m2505o(14410);
                                    }
                                });
                                C1720g.m3540Rg().mo14541a(c6681h, 0);
                                str = "";
                                AppMethodBeat.m2505o(14411);
                                return str;
                            }
                            C4990ab.m7416i("MicroMsg.Preload.TmplDownloader", "not do getA8Key, return");
                            str = str;
                            AppMethodBeat.m2505o(14411);
                            return str;
                        }
                    }).mo60491g(new C5681a<Void, String>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(14409);
                            Void xQ = m31072xQ((String) obj);
                            AppMethodBeat.m2505o(14409);
                            return xQ;
                        }

                        /* renamed from: xQ */
                        private Void m31072xQ(String str) {
                            AppMethodBeat.m2504i(14408);
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "url is null, err, return");
                                AppMethodBeat.m2505o(14408);
                                return null;
                            }
                            C11253a a;
                            int i;
                            C43925b c43925b = new C43925b();
                            c43925b.startTime = System.currentTimeMillis();
                            C43924a.m78790e(i3, 3, 1, true);
                            String am = C27539k.m43701am(i, str2);
                            try {
                                a = C27537c.aXE().mo45342a(i3, str, hashMap, am);
                            } catch (Exception e) {
                                Throwable th = e;
                                a = new C11253a();
                                C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", th, "downloadTmpl", new Object[0]);
                            }
                            c43925b.jSu = i;
                            c43925b.upH = a.jTZ != null;
                            c43925b.upG = i2;
                            c43925b.jSV = i;
                            c43925b.upI = str2;
                            boolean z = false;
                            if (a.jRX) {
                                int i2 = i3;
                                if (a.success) {
                                    i = C31128d.MIC_PTU_FENGJING;
                                } else {
                                    i = C31128d.MIC_PTU_AUTOLEVEL;
                                }
                                C43924a.m78790e(i2, i, 1, true);
                            }
                            int i3;
                            if (a.success) {
                                String q;
                                boolean z2;
                                File file = new File(am);
                                c43925b.size = file.length();
                                if (a.jTZ != null) {
                                    if (a.jUa != null) {
                                        if (a.jRX) {
                                            C43924a.m78790e(i3, C31128d.MIC_PTU_LENGMEIREN, 1, true);
                                        }
                                        if (C27537c.m43695c(a.jUa, file)) {
                                            boolean a2;
                                            if (a.jRX) {
                                                q = C27539k.m43702q(i, a.jTZ, "origin.zip");
                                            } else {
                                                q = C27539k.m43699ak(i, a.jTZ);
                                            }
                                            if (new File(q).exists()) {
                                                a2 = C27537c.m43694a(a, i3, chi.Md5, file, q);
                                                if (a.jRX && !a2) {
                                                    C43924a.m78790e(i3, C31128d.MIC_PTU_SHISHANG2, 1, true);
                                                    z2 = a2;
                                                }
                                            } else {
                                                C4990ab.m7413e("MicroMsg.Preload.TmplDownloader", "patch origin file not found:%s", q);
                                                if (a.jRX) {
                                                    C43924a.m78790e(i3, C31128d.MIC_PTU_SHIGUANG, 1, true);
                                                }
                                                a2 = false;
                                            }
                                            z2 = a2;
                                        } else {
                                            C43924a.m78790e(i3, 220, 1, true);
                                            if (a.jRX) {
                                                C43924a.m78790e(i3, 236, 1, true);
                                                z2 = false;
                                            }
                                            z2 = false;
                                        }
                                    } else {
                                        C4990ab.m7413e("MicroMsg.Preload.TmplDownloader", "checkTmpl %d,%s, no patch MD5", Integer.valueOf(chi.jCt), chi.wld);
                                        C43924a.m78790e(i3, 229, 1, true);
                                        z2 = false;
                                    }
                                } else if (C27537c.m43695c(chi.Md5, file)) {
                                    C4990ab.m7416i("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] download & MD5 verify success");
                                    z2 = true;
                                } else {
                                    C43924a.m78790e(i3, 6, 1, true);
                                    C4990ab.m7413e("MicroMsg.Preload.TmplDownloader", "checkTmpl %d,%s MD5 not match", Integer.valueOf(chi.jCt), chi.wld);
                                    z2 = false;
                                }
                                if (z2) {
                                    int i4;
                                    if (a.jRX) {
                                        try {
                                            q = C27539k.m43702q(i, str2, "");
                                            C27537c.m43696di(am, q);
                                            new File(am).renameTo(new File(q + "/origin.zip"));
                                        } catch (Exception e2) {
                                            C43924a.m78790e(i3, C31128d.MIC_PTU_QINGCONG, 1, true);
                                            if (a.jTZ != null) {
                                                C43924a.m78790e(i3, 242, 1, true);
                                            }
                                            C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e2, "zip", new Object[0]);
                                        }
                                    } else {
                                        new File(am).renameTo(new File(C27539k.m43699ak(i, str2)));
                                    }
                                    c43925b.endTime = System.currentTimeMillis();
                                    long j = c43925b.endTime - c43925b.startTime;
                                    if (C5023at.isWifi(C4996ah.getContext())) {
                                        q = "wifi";
                                    } else if (C5023at.is4G(C4996ah.getContext())) {
                                        q = "4g";
                                    } else if (C5023at.is3G(C4996ah.getContext())) {
                                        q = "3g";
                                    } else if (C5023at.is2G(C4996ah.getContext())) {
                                        q = "2g";
                                    } else {
                                        q = "none";
                                    }
                                    C4990ab.m7411d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", Integer.valueOf(c43925b.upG), Boolean.valueOf(c43925b.upH), Long.valueOf(j), Long.valueOf(c43925b.size), q, Integer.valueOf(c43925b.jSV), c43925b.upI);
                                    C7060h c7060h = C7060h.pYm;
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(c43925b.upG);
                                    if (c43925b.upH) {
                                        i4 = 1;
                                    } else {
                                        i4 = 0;
                                    }
                                    objArr[1] = Integer.valueOf(i4);
                                    objArr[2] = Long.valueOf(Math.min(j, 3600000));
                                    objArr[3] = Long.valueOf(c43925b.size);
                                    objArr[4] = q;
                                    objArr[5] = Integer.valueOf(c43925b.jSV);
                                    objArr[6] = c43925b.upI;
                                    objArr[7] = Integer.valueOf(c43925b.jSu);
                                    c7060h.mo8381e(15870, objArr);
                                    chi sv = C20082b.m31068sv(i);
                                    if (sv.Version != 0) {
                                        if (sv.Version < chi.Version) {
                                            C43924a.m78790e(i3, 12, 1, true);
                                        } else if (sv.Version > chi.Version) {
                                            C43924a.m78790e(i3, 13, 1, true);
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
                                C43924a.m78790e(i, i3, 1, true);
                                C43924a.m78790e(i3, 4, 1, true);
                                z = z2;
                            } else {
                                i = i3;
                                if (a.jTZ != null) {
                                    i3 = 225;
                                } else {
                                    i3 = 227;
                                }
                                C43924a.m78790e(i, i3, 1, true);
                                C43924a.m78790e(i3, 5, 1, true);
                                C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] download fail");
                            }
                            C38710j.m65658de("MicroMsg.Preload.TmplDownloader", "isDownloadSuccess:" + z + " :" + String.format("%d,%s", new Object[]{Integer.valueOf(i), str2}));
                            AppMethodBeat.m2505o(14408);
                            return null;
                        }
                    });
                    AppMethodBeat.m2505o(14413);
                }
            });
            AppMethodBeat.m2505o(14416);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f6 A:{Catch:{ IOException -> 0x021c }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf A:{Catch:{ IOException -> 0x020d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C11253a mo45342a(int i, String str, Map<String, String> map, String str2) {
        File file;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable e;
        AppMethodBeat.m2504i(14417);
        C11253a c11253a = new C11253a();
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "downloadUrl is null, return");
            C43924a.m78790e(i, 9, 1, true);
            AppMethodBeat.m2505o(14417);
            return c11253a;
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
                        C4990ab.m7417i("MicroMsg.Preload.TmplDownloader", "headers.size:%d", Integer.valueOf(map.size()));
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
                            c11253a.success = true;
                            c11253a.jTZ = httpURLConnection.getHeaderField("X-WECHAT-MPBASEFULLVERSION");
                            c11253a.jUa = httpURLConnection.getHeaderField("X-WECHAT-MPPATCHMD5");
                            String headerField = httpURLConnection.getHeaderField("X-WECHAT-MPCONTROLFLAG");
                            if (headerField == null || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(headerField)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            c11253a.jRX = z;
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
                                C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e3, "", new Object[0]);
                            }
                            AppMethodBeat.m2505o(14417);
                            return c11253a;
                        }
                        C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "Server return code:".concat(String.valueOf(responseCode)));
                        if (responseCode > 500) {
                            C43924a.m78790e(i, 11, 1, true);
                        } else if (responseCode > 400) {
                            C43924a.m78790e(i, 10, 1, true);
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
                            C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e32, "", new Object[0]);
                        }
                        AppMethodBeat.m2505o(14417);
                        return c11253a;
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
                        C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e8, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(14417);
                    throw e;
                }
            } catch (FileNotFoundException e9) {
                C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "can not fond output folder");
                C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e9, "", new Object[0]);
                C43924a.m78790e(i, 7, 1, true);
                AppMethodBeat.m2505o(14417);
                return c11253a;
            }
        } catch (IOException e322) {
            C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "can not new file");
            C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e322, "", new Object[0]);
            C43924a.m78790e(i, 7, 1, true);
            AppMethodBeat.m2505o(14417);
            return c11253a;
        }
        try {
            C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e, "download url:".concat(String.valueOf(str)), new Object[0]);
            C43924a.m78790e(i, 7, 1, true);
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
                C4990ab.printErrStackTrace("MicroMsg.Preload.TmplDownloader", e3222, "", new Object[0]);
            }
            AppMethodBeat.m2505o(14417);
            return c11253a;
        } catch (Throwable th2) {
            e = th2;
            inputStream = inputStream2;
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.m2505o(14417);
            throw e;
        }
        AppMethodBeat.m2505o(14417);
        return c11253a;
        fileOutputStream.close();
        if (inputStream2 != null) {
        }
        AppMethodBeat.m2505o(14417);
        return c11253a;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m43695c(String str, File file) {
        AppMethodBeat.m2504i(14418);
        if (C5046bo.isNullOrNil(str) || !str.equals(C1178g.m2589v(file))) {
            C4990ab.m7413e("MicroMsg.Preload.TmplDownloader", "checkTmpl %s, MD5 not match", file.getAbsolutePath());
            AppMethodBeat.m2505o(14418);
            return false;
        }
        AppMethodBeat.m2505o(14418);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m43694a(C11253a c11253a, int i, String str, File file, String str2) {
        AppMethodBeat.m2504i(14419);
        String str3 = str2 + ".patch";
        if (((IBSPatchJNIService) C1720g.m3528K(IBSPatchJNIService.class)).bspatch(str2, str3, file.getAbsolutePath()) == 0) {
            C4990ab.m7416i("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] patch download success");
            File file2 = new File(str3);
            str3 = C1178g.m2589v(file2);
            if (C5046bo.isNullOrNil(str3) || !str3.equals(str)) {
                file2.delete();
                C43924a.m78790e(i, 228, 1, true);
                if (c11253a.jRX) {
                    C43924a.m78790e(i, 240, 1, true);
                }
                C4990ab.m7413e("MicroMsg.Preload.TmplDownloader", "checkTmpl %s MD5 not match after patch", str2);
            } else {
                C4990ab.m7416i("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] patch MD5 verify success");
                C1173e.m2567d(file2, file);
                AppMethodBeat.m2505o(14419);
                return true;
            }
        }
        C43924a.m78790e(i, 222, 1, true);
        C4990ab.m7412e("MicroMsg.Preload.TmplDownloader", "[checkTmplVer] patch fail");
        AppMethodBeat.m2505o(14419);
        return false;
    }

    /* renamed from: di */
    static /* synthetic */ boolean m43696di(String str, String str2) {
        AppMethodBeat.m2504i(14420);
        ZipFile zipFile = new ZipFile(str);
        Enumeration entries = zipFile.entries();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (name.indexOf("../") != -1) {
                C4990ab.m7413e("MicroMsg.Preload.TmplDownloader", "skip unzip break through file:%s", name);
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
        AppMethodBeat.m2505o(14420);
        return true;
    }
}
