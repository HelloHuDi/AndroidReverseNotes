package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.launching.n.b;
import com.tencent.mm.plugin.appbrand.launching.n.d;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class r implements m {
    final String appId;
    final int har;
    final List<c> hil;
    final int ihg;
    private final AtomicInteger ihi = new AtomicInteger(0);
    private volatile boolean ihj = false;
    LinkedHashMap<String, j<WxaPkgWrappingInfo>> ihp = new LinkedHashMap();
    private com.tencent.mm.plugin.appbrand.launching.c.a ihq;

    abstract class a implements b {
        private int iho;

        public abstract long aHp();

        public abstract String aHq();

        private a() {
            this.iho = 0;
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        public final void a(WxaPkgLoadProgress wxaPkgLoadProgress) {
            r.a(r.this);
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", aHq() + " progress=" + wxaPkgLoadProgress.progress);
            long aHp = aHp();
            if (aHp == 0) {
                r.this.ihi.set(100);
            } else {
                r.this.ihi.addAndGet(Math.round(((float) Math.max(0, wxaPkgLoadProgress.progress - this.iho)) / ((float) aHp)));
            }
            this.iho = wxaPkgLoadProgress.progress;
            r.c(r.this);
        }
    }

    static /* synthetic */ void a(r rVar, int i) {
        AppMethodBeat.i(131860);
        rVar.oW(i);
        AppMethodBeat.o(131860);
    }

    public /* synthetic */ Object call() {
        AppMethodBeat.i(131857);
        WxaPkgWrappingInfo azZ = azZ();
        AppMethodBeat.o(131857);
        return azZ;
    }

    r(String str, int i, int i2, List<c> list) {
        AppMethodBeat.i(131854);
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
        this.appId = str;
        this.har = i;
        this.hil = list;
        this.ihg = i2;
        this.ihq = new com.tencent.mm.plugin.appbrand.launching.c.a(str, i2, i, list);
        AppMethodBeat.o(131854);
    }

    public void aHe() {
    }

    public void aHj() {
    }

    public void onDownloadProgress(int i) {
    }

    private WxaPkgWrappingInfo azZ() {
        int i = 0;
        AppMethodBeat.i(131855);
        Pair v = as.v(this.appId, this.har, this.ihg);
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        if (v.second != null) {
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.ihg));
            try {
                ((com.tencent.mm.plugin.appbrand.appcache.b.d.a) f.E(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).ay(this.appId, this.ihg);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", th, "checkReportOnLocalPkgFound, appId[%s], version[%d]", this.appId, Integer.valueOf(this.ihg));
            }
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v.second;
            AppMethodBeat.o(131855);
            return wxaPkgWrappingInfo;
        }
        int size = this.hil.size();
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLibList size:%d", Integer.valueOf(size));
        final CountDownLatch countDownLatch = new CountDownLatch(size + 1);
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = (c) this.hil.get(i2);
            if (cVar == null) {
                ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codelibInfo:%d null!", Integer.valueOf(i2));
            } else {
                final String str = cVar.bIy;
                final int i3 = cVar.version;
                if (bo.isNullOrNil(str) || bo.isNullOrNil(cVar.cvZ)) {
                    ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib null or codeLib md5 null!");
                    com.tencent.mm.plugin.appbrand.launching.c.a.pc(6);
                    countDownLatch.countDown();
                } else {
                    this.ihp.put(cVar.cvZ, new j());
                    n b = d.b(str, "__CODELIB__", 0, i3, 14);
                    b.a(new n.c() {
                        public final void aHm() {
                            AppMethodBeat.i(131841);
                            r.a(r.this, 3);
                            AppMethodBeat.o(131841);
                        }

                        public final void aHn() {
                            AppMethodBeat.i(131842);
                            r.a(r.this, 4);
                            AppMethodBeat.o(131842);
                        }

                        public final void aHo() {
                            AppMethodBeat.i(131843);
                            r.a(r.this, 2);
                            AppMethodBeat.o(131843);
                        }

                        public final void a(com.tencent.mm.ai.a.a<arc> aVar) {
                            AppMethodBeat.i(131844);
                            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib url result errCode:%s,errMsg:%s", Integer.valueOf(aVar.errCode), aVar.aIm);
                            AppMethodBeat.o(131844);
                        }

                        public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.i(131845);
                            if (wxaPkgWrappingInfo != null) {
                                ((j) r.this.ihp.get(wxaPkgWrappingInfo.cvZ)).value = wxaPkgWrappingInfo;
                            }
                            countDownLatch.countDown();
                            String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler";
                            String str2 = "codeLib pkgInfo :%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                            ab.i(str, str2, objArr);
                            g.dOW().i(new com.tencent.mm.vending.c.a<Void, Void>() {
                                public final /* synthetic */ Object call(Object obj) {
                                    AppMethodBeat.i(131840);
                                    com.tencent.mm.plugin.appbrand.appcache.g.an(new y(str, "__CODELIB__").toString(), i3);
                                    AppMethodBeat.o(131840);
                                    return null;
                                }
                            }).dMk();
                            AppMethodBeat.o(131845);
                        }

                        public final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.i(131846);
                            if (wxaPkgWrappingInfo != null) {
                                r.oX(0);
                                AppMethodBeat.o(131846);
                                return;
                            }
                            r.oX(1);
                            AppMethodBeat.o(131846);
                        }
                    });
                    b.a(new a() {
                        /* Access modifiers changed, original: final */
                        public final long aHp() {
                            AppMethodBeat.i(131847);
                            long count = countDownLatch.getCount();
                            AppMethodBeat.o(131847);
                            return count;
                        }

                        /* Access modifiers changed, original: final */
                        public final String aHq() {
                            AppMethodBeat.i(131848);
                            String str = "appId=" + r.this.appId + " provider=" + str;
                            AppMethodBeat.o(131848);
                            return str;
                        }
                    });
                    b.prepareAsync();
                }
            }
        }
        final j jVar = new j();
        n b2 = d.b(this.appId, "__WITHOUT_CODELIB__", this.har, this.ihg, 12);
        b2.a(new n.c() {
            public final void a(com.tencent.mm.ai.a.a<arc> aVar) {
                AppMethodBeat.i(131849);
                ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule without lib url result errCode:%s,errMsg:%s", Integer.valueOf(aVar.errCode), aVar.aIm);
                AppMethodBeat.o(131849);
            }

            public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.i(131850);
                if (wxaPkgWrappingInfo != null) {
                    jVar.value = wxaPkgWrappingInfo;
                }
                countDownLatch.countDown();
                String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler";
                String str2 = "mainModule without codeLib pkgInfo :%s";
                Object[] objArr = new Object[1];
                objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                ab.i(str, str2, objArr);
                AppMethodBeat.o(131850);
            }

            public final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.i(131851);
                if (wxaPkgWrappingInfo != null) {
                    r.oX(2);
                    AppMethodBeat.o(131851);
                    return;
                }
                r.oX(3);
                AppMethodBeat.o(131851);
            }
        });
        b2.a(new a() {
            /* Access modifiers changed, original: final */
            public final long aHp() {
                AppMethodBeat.i(131852);
                long count = countDownLatch.getCount();
                AppMethodBeat.o(131852);
                return count;
            }

            /* Access modifiers changed, original: final */
            public final String aHq() {
                AppMethodBeat.i(131853);
                String str = "appId=" + r.this.appId + " module=__WITHOUT_CODELIB__";
                AppMethodBeat.o(131853);
                return str;
            }
        });
        b2.prepareAsync();
        countDownLatch.await();
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "both downloaded");
        if (this.ihj) {
            aHj();
        }
        if (jVar.value == null || this.ihp.size() <= 0) {
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule value or codeLibList result null!!");
            AppMethodBeat.o(131855);
            return null;
        }
        this.ihq.IF();
        wxaPkgWrappingInfo = (WxaPkgWrappingInfo) jVar.value;
        wxaPkgWrappingInfo.gSR = new PartialFile[size];
        while (true) {
            int i4 = i;
            if (i4 < this.hil.size()) {
                c cVar2 = (c) this.hil.get(i4);
                wxaPkgWrappingInfo.gSR[i4] = new PartialFile();
                if (!bo.isNullOrNil(((c) this.hil.get(i4)).cvZ)) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) ((j) this.ihp.get(((c) this.hil.get(i4)).cvZ)).value;
                    if (wxaPkgWrappingInfo2 != null) {
                        wxaPkgWrappingInfo.gSR[i4].cvZ = ((c) this.hil.get(i4)).cvZ;
                        wxaPkgWrappingInfo.gSR[i4].bIy = cVar2.bIy;
                        wxaPkgWrappingInfo.gSR[i4].version = cVar2.version;
                        wxaPkgWrappingInfo.gSR[i4].filePath = wxaPkgWrappingInfo2.gSP;
                    }
                }
                i = i4 + 1;
            } else {
                AppMethodBeat.o(131855);
                return wxaPkgWrappingInfo;
            }
        }
    }

    private void oW(int i) {
        AppMethodBeat.i(131856);
        this.ihq.pd(i);
        AppMethodBeat.o(131856);
    }

    static /* synthetic */ void a(r rVar) {
        AppMethodBeat.i(131858);
        if (!rVar.ihj) {
            rVar.ihj = true;
            rVar.aHe();
            rVar.ihq.ijZ = true;
            rVar.oW(1);
        }
        AppMethodBeat.o(131858);
    }

    static /* synthetic */ void c(r rVar) {
        AppMethodBeat.i(131859);
        int min = Math.min(rVar.ihi.get(), 100);
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "appId=" + rVar.appId + " notifyDownloadProgress=" + min);
        rVar.onDownloadProgress(min);
        AppMethodBeat.o(131859);
    }

    static /* synthetic */ void oX(int i) {
        AppMethodBeat.i(131861);
        com.tencent.mm.plugin.appbrand.launching.c.a.pc(i);
        AppMethodBeat.o(131861);
    }
}
