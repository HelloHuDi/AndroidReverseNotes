package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.f;
import com.tencent.mm.plugin.appbrand.launching.n.b;
import com.tencent.mm.plugin.appbrand.launching.n.d;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class s implements m {
    final String appId;
    final int har;
    List<f> hin;
    final int ihg;
    private final AtomicInteger ihi = new AtomicInteger(0);
    private volatile boolean ihj = false;
    LinkedHashMap<String, j<WxaPkgWrappingInfo>> ihp = new LinkedHashMap();
    private com.tencent.mm.plugin.appbrand.launching.c.a ihq;
    List<c> ihu;

    abstract class a implements b {
        private int iho;

        public abstract long aHp();

        public abstract String aHq();

        private a() {
            this.iho = 0;
        }

        /* synthetic */ a(s sVar, byte b) {
            this();
        }

        public final void a(WxaPkgLoadProgress wxaPkgLoadProgress) {
            s.a(s.this);
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", aHq() + " progress=" + wxaPkgLoadProgress.progress);
            long aHp = aHp();
            if (aHp == 0) {
                s.this.ihi.set(100);
            } else {
                s.this.ihi.addAndGet(Math.round(((float) Math.max(0, wxaPkgLoadProgress.progress - this.iho)) / ((float) aHp)));
            }
            this.iho = wxaPkgLoadProgress.progress;
            s.c(s.this);
        }
    }

    static /* synthetic */ void a(s sVar, int i) {
        AppMethodBeat.i(131883);
        sVar.oW(i);
        AppMethodBeat.o(131883);
    }

    s(String str, int i, int i2, List<f> list) {
        AppMethodBeat.i(131876);
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
        this.appId = str;
        this.har = i;
        this.ihg = i2;
        this.hin = list;
        for (f fVar : list) {
            if (!bo.isNullOrNil(fVar.name) && fVar.name.equals("__APP__")) {
                this.ihu = fVar.hir;
                break;
            }
        }
        this.ihq = new com.tencent.mm.plugin.appbrand.launching.c.a(str, i2, i, this.ihu);
        AppMethodBeat.o(131876);
    }

    public void aHe() {
    }

    public void aHj() {
    }

    public void onDownloadProgress(int i) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static WxaPkgWrappingInfo J(String str, int i, int i2) {
        Throwable th;
        Closeable closeable;
        AppMethodBeat.i(131877);
        y yVar = new y(str, "__APP__");
        WxaPkgWrappingInfo bo;
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
            ax auV = com.tencent.mm.plugin.appbrand.app.f.auV();
            if (auV == null) {
                AppMethodBeat.o(131877);
                return null;
            }
            at a = auV.a(yVar.toString(), i2, i, new String[0]);
            if (a == null) {
                AppMethodBeat.o(131877);
                return null;
            } else if (bo.isNullOrNil(a.field_versionMd5)) {
                AppMethodBeat.o(131877);
                return null;
            } else {
                Closeable openRead;
                try {
                    openRead = e.openRead(a.field_pkgPath);
                    at a2;
                    try {
                        if (a.field_versionMd5.equals(g.b(openRead, 4096))) {
                            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appid:%s release main module already exist codeType:%d,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
                            bo = bo(a.field_pkgPath, i2);
                            bo.b(openRead);
                            AppMethodBeat.o(131877);
                            return bo;
                        }
                        bo.b(openRead);
                        e.deleteFile(a.field_pkgPath);
                        a2 = h.a(yVar, i, i2, a.field_versionMd5);
                        if (a2 != null) {
                            String aq = aq.aq(yVar.toString(), i2);
                            e.y(a2.field_pkgPath, aq);
                            com.tencent.mm.plugin.appbrand.app.f.auV().d(yVar.toString(), i, i2, aq);
                            bo = bo(aq, i2);
                            AppMethodBeat.o(131877);
                            return bo;
                        }
                    } catch (FileNotFoundException e) {
                        try {
                            ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "file not found appid:%s,pkgPath:%s", str, a.field_pkgPath);
                            bo.b(openRead);
                            e.deleteFile(a.field_pkgPath);
                            a2 = h.a(yVar, i, i2, a.field_versionMd5);
                            if (a2 != null) {
                            }
                            AppMethodBeat.o(131877);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = openRead;
                            bo.b(closeable);
                            AppMethodBeat.o(131877);
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    openRead = null;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    bo.b(closeable);
                    AppMethodBeat.o(131877);
                    throw th;
                }
            }
        }
        Pair v = as.v(yVar.toString(), i, 1);
        if (v.second != null) {
            ((WxaPkgWrappingInfo) v.second).name = "__APP__";
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId:%s,test main module already exist codeType:%d,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
            bo = (WxaPkgWrappingInfo) v.second;
            AppMethodBeat.o(131877);
            return bo;
        }
        AppMethodBeat.o(131877);
        return null;
    }

    private static WxaPkgWrappingInfo bo(String str, int i) {
        AppMethodBeat.i(131878);
        WxaPkgWrappingInfo xM = WxaPkgWrappingInfo.xM(str);
        xM.gVu = i;
        AppMethodBeat.o(131878);
        return xM;
    }

    private void oW(int i) {
        AppMethodBeat.i(131879);
        this.ihq.pd(i);
        AppMethodBeat.o(131879);
    }

    public /* synthetic */ Object call() {
        int i = 0;
        AppMethodBeat.i(131880);
        WxaPkgWrappingInfo J = J(this.appId, this.har, this.ihg);
        if (J != null) {
            for (f fVar : this.hin) {
                if (!"__APP__".equals(fVar.name)) {
                    J.gVx.add(ai.a(fVar));
                }
            }
            AppMethodBeat.o(131880);
            return J;
        }
        int size = this.ihu.size();
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codeLibList size:%d", Integer.valueOf(size));
        final CountDownLatch countDownLatch = new CountDownLatch(size + 1);
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = (c) this.ihu.get(i2);
            if (cVar == null) {
                ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codelibInfo:%d null!", Integer.valueOf(i2));
            } else {
                final String str = cVar.bIy;
                final int i3 = cVar.version;
                if (bo.isNullOrNil(str) || bo.isNullOrNil(cVar.cvZ)) {
                    ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codeLib null or codeLib md5 null!");
                    com.tencent.mm.plugin.appbrand.launching.c.a.pc(6);
                    countDownLatch.countDown();
                } else {
                    this.ihp.put(cVar.cvZ, new j());
                    n b = d.b(str, "__CODELIB__", 0, i3, 14);
                    b.a(new n.c() {
                        public final void aHm() {
                            AppMethodBeat.i(131863);
                            s.a(s.this, 3);
                            AppMethodBeat.o(131863);
                        }

                        public final void aHn() {
                            AppMethodBeat.i(131864);
                            s.a(s.this, 4);
                            AppMethodBeat.o(131864);
                        }

                        public final void aHo() {
                            AppMethodBeat.i(131865);
                            s.a(s.this, 2);
                            AppMethodBeat.o(131865);
                        }

                        public final void a(com.tencent.mm.ai.a.a<arc> aVar) {
                            AppMethodBeat.i(131866);
                            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codeLib url result errCode:%s,errMsg:%s", Integer.valueOf(aVar.errCode), aVar.aIm);
                            AppMethodBeat.o(131866);
                        }

                        public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.i(131867);
                            if (wxaPkgWrappingInfo != null) {
                                ((j) s.this.ihp.get(wxaPkgWrappingInfo.cvZ)).value = wxaPkgWrappingInfo;
                            }
                            countDownLatch.countDown();
                            String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler";
                            String str2 = "codeLib pkgInfo :%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                            ab.i(str, str2, objArr);
                            com.tencent.mm.ci.g.dOW().i(new com.tencent.mm.vending.c.a<Void, Void>() {
                                public final /* synthetic */ Object call(Object obj) {
                                    AppMethodBeat.i(131862);
                                    com.tencent.mm.plugin.appbrand.appcache.g.an(new y(str, "__CODELIB__").toString(), i3);
                                    AppMethodBeat.o(131862);
                                    return null;
                                }
                            }).dMk();
                            AppMethodBeat.o(131867);
                        }

                        public final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.i(131868);
                            if (wxaPkgWrappingInfo != null) {
                                s.oY(0);
                                AppMethodBeat.o(131868);
                                return;
                            }
                            s.oY(1);
                            AppMethodBeat.o(131868);
                        }
                    });
                    b.a(new a() {
                        /* Access modifiers changed, original: final */
                        public final long aHp() {
                            AppMethodBeat.i(131869);
                            long count = countDownLatch.getCount();
                            AppMethodBeat.o(131869);
                            return count;
                        }

                        /* Access modifiers changed, original: final */
                        public final String aHq() {
                            AppMethodBeat.i(131870);
                            String str = "appId=" + s.this.appId + " provider=" + str;
                            AppMethodBeat.o(131870);
                            return str;
                        }
                    });
                    b.prepareAsync();
                }
            }
        }
        final j jVar = new j();
        n b2 = d.b(this.appId, "__APP__", this.har, this.ihg, 13);
        b2.a(new n.c() {
            public final void a(com.tencent.mm.ai.a.a<arc> aVar) {
                AppMethodBeat.i(131871);
                ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "mainModule without lib url result errCode:%s,errMsg:%s", Integer.valueOf(aVar.errCode), aVar.aIm);
                AppMethodBeat.o(131871);
            }

            public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.i(131872);
                if (wxaPkgWrappingInfo != null) {
                    jVar.value = wxaPkgWrappingInfo;
                }
                countDownLatch.countDown();
                String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler";
                String str2 = "mainModule without codeLib pkgInfo :%s";
                Object[] objArr = new Object[1];
                objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                ab.i(str, str2, objArr);
                AppMethodBeat.o(131872);
            }

            public final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.i(131873);
                if (wxaPkgWrappingInfo != null) {
                    s.oY(4);
                    AppMethodBeat.o(131873);
                    return;
                }
                s.oY(5);
                AppMethodBeat.o(131873);
            }
        });
        b2.a(new a() {
            /* Access modifiers changed, original: final */
            public final long aHp() {
                AppMethodBeat.i(131874);
                long count = countDownLatch.getCount();
                AppMethodBeat.o(131874);
                return count;
            }

            /* Access modifiers changed, original: final */
            public final String aHq() {
                AppMethodBeat.i(131875);
                String str = "appId=" + s.this.appId + " modulename= __APP__ module=__WITHOUT_CODELIB__";
                AppMethodBeat.o(131875);
                return str;
            }
        });
        b2.prepareAsync();
        countDownLatch.await();
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "both downloaded!");
        if (this.ihj) {
            aHj();
        }
        if (jVar.value == null || this.ihp.size() <= 0) {
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "mainModule value or codeLibList result null!!");
            AppMethodBeat.o(131880);
            return null;
        }
        this.ihq.IF();
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) jVar.value;
        wxaPkgWrappingInfo.gSR = new PartialFile[size];
        while (true) {
            int i4 = i;
            if (i4 >= this.ihu.size()) {
                break;
            }
            c cVar2 = (c) this.ihu.get(i4);
            wxaPkgWrappingInfo.gSR[i4] = new PartialFile();
            if (!bo.isNullOrNil(((c) this.ihu.get(i4)).cvZ)) {
                WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) ((j) this.ihp.get(((c) this.ihu.get(i4)).cvZ)).value;
                if (wxaPkgWrappingInfo2 != null) {
                    wxaPkgWrappingInfo.gSR[i4].cvZ = ((c) this.ihu.get(i4)).cvZ;
                    wxaPkgWrappingInfo.gSR[i4].bIy = cVar2.bIy;
                    wxaPkgWrappingInfo.gSR[i4].version = cVar2.version;
                    wxaPkgWrappingInfo.gSR[i4].filePath = wxaPkgWrappingInfo2.gSP;
                }
            }
            i = i4 + 1;
        }
        for (f fVar2 : this.hin) {
            if (!"__APP__".equals(fVar2.name)) {
                wxaPkgWrappingInfo.gVx.add(ai.a(fVar2));
            }
        }
        AppMethodBeat.o(131880);
        return wxaPkgWrappingInfo;
    }

    static /* synthetic */ void a(s sVar) {
        AppMethodBeat.i(131881);
        if (!sVar.ihj) {
            sVar.ihj = true;
            sVar.aHe();
            sVar.ihq.ijZ = true;
            sVar.oW(1);
        }
        AppMethodBeat.o(131881);
    }

    static /* synthetic */ void c(s sVar) {
        AppMethodBeat.i(131882);
        int min = Math.min(sVar.ihi.get(), 100);
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId=" + sVar.appId + " notifyDownloadProgress=" + min);
        sVar.onDownloadProgress(min);
        AppMethodBeat.o(131882);
    }

    static /* synthetic */ void oY(int i) {
        AppMethodBeat.i(131884);
        com.tencent.mm.plugin.appbrand.launching.c.a.pc(i);
        AppMethodBeat.o(131884);
    }
}
