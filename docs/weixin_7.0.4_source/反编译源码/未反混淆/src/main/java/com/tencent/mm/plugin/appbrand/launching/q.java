package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.f;
import com.tencent.mm.plugin.appbrand.launching.n.b;
import com.tencent.mm.plugin.appbrand.launching.n.c;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class q implements m {
    final String appId;
    final int cDB;
    final int har;
    final String hgC;
    final List<f> hin;
    final String hip;
    final int ihg;
    final int ihh;
    private final AtomicInteger ihi = new AtomicInteger(0);
    private volatile boolean ihj = false;

    abstract class a implements b {
        private int iho;

        public abstract long aHp();

        public abstract String aHq();

        private a() {
            this.iho = 0;
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        public final void a(WxaPkgLoadProgress wxaPkgLoadProgress) {
            q.a(q.this);
            ab.i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", aHq() + " progress=" + wxaPkgLoadProgress.progress);
            long aHp = aHp();
            if (aHp == 0) {
                q.this.ihi.set(100);
            } else {
                q.this.ihi.addAndGet(Math.round(((float) Math.max(0, wxaPkgLoadProgress.progress - this.iho)) / ((float) aHp)));
            }
            this.iho = wxaPkgLoadProgress.progress;
            q.c(q.this);
        }
    }

    q(String str, int i, String str2, int i2, int i3, int i4, String str3, List<f> list) {
        AppMethodBeat.i(131836);
        this.appId = str;
        this.har = i;
        this.hgC = str2;
        this.cDB = i2;
        this.ihg = i3;
        this.ihh = i4;
        this.hip = str3;
        this.hin = list;
        AppMethodBeat.o(131836);
    }

    public void aHe() {
    }

    public void aHj() {
    }

    public void onDownloadProgress(int i) {
    }

    public /* synthetic */ Object call() {
        String str;
        Object obj;
        boolean z;
        Object obj2;
        AppMethodBeat.i(131837);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final j jVar = new j();
        final j jVar2 = new j();
        n f = com.tencent.mm.plugin.appbrand.launching.n.a.f(this.appId, "__APP__", this.har, this.ihg);
        f.a(new c() {
            public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.i(131828);
                jVar.value = wxaPkgWrappingInfo;
                countDownLatch.countDown();
                AppMethodBeat.o(131828);
            }

            public final void a(com.tencent.mm.ai.a.a<arc> aVar) {
                AppMethodBeat.i(131829);
                q.a(q.this);
                AppMethodBeat.o(131829);
            }
        });
        f.a(new a() {
            /* Access modifiers changed, original: final */
            public final long aHp() {
                AppMethodBeat.i(131830);
                long count = countDownLatch.getCount();
                AppMethodBeat.o(131830);
                return count;
            }

            /* Access modifiers changed, original: final */
            public final String aHq() {
                AppMethodBeat.i(131831);
                String str = "appId=" + q.this.appId + " module=__APP__";
                AppMethodBeat.o(131831);
                return str;
            }
        });
        if (bo.isNullOrNil(this.hgC)) {
            str = "";
        } else {
            str = h.bO(this.hgC);
        }
        if (bo.isNullOrNil(str)) {
            obj = this.hip;
        } else {
            obj = null;
            for (f fVar : this.hin) {
                if (str.startsWith(com.tencent.mm.plugin.appbrand.appcache.b.xm(fVar.name))) {
                    obj = fVar.name;
                    ab.i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call() hit module with name[%s] appId[%s], type[%d], path[%s]", fVar.name, this.appId, Integer.valueOf(this.har), this.hgC);
                    break;
                } else if (fVar.gSQ != null && fVar.gSQ.length > 0) {
                    for (String startsWith : fVar.gSQ) {
                        if (str.startsWith(startsWith)) {
                            String str2 = fVar.name;
                            ab.i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call() hit module with alias[%s] appId[%s], type[%d], path[%s]", startsWith, this.appId, Integer.valueOf(this.har), this.hgC);
                            obj = str2;
                            break;
                        }
                    }
                }
            }
            if (bo.isNullOrNil(obj)) {
                obj = this.hip;
            }
        }
        if ("__APP__".equals(obj) || bo.isNullOrNil(obj)) {
            z = false;
            countDownLatch.countDown();
            obj2 = null;
        } else {
            obj2 = 1;
            for (f fVar2 : this.hin) {
                if (obj.equals(fVar2.name)) {
                    z = fVar2.cta;
                    break;
                }
            }
            z = false;
            n f2 = com.tencent.mm.plugin.appbrand.launching.n.a.f(this.appId, obj, this.har, this.ihg);
            f2.a(new c() {
                public final void a(com.tencent.mm.ai.a.a<arc> aVar) {
                    AppMethodBeat.i(131832);
                    q.a(q.this);
                    AppMethodBeat.o(131832);
                }

                public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(131833);
                    jVar2.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.o(131833);
                }
            });
            f2.a(new a() {
                /* Access modifiers changed, original: final */
                public final long aHp() {
                    AppMethodBeat.i(131834);
                    long count = countDownLatch.getCount();
                    AppMethodBeat.o(131834);
                    return count;
                }

                /* Access modifiers changed, original: final */
                public final String aHq() {
                    AppMethodBeat.i(131835);
                    String str = "appId=" + q.this.appId + " module=" + obj;
                    AppMethodBeat.o(131835);
                    return str;
                }
            });
            f2.prepareAsync();
        }
        if (z) {
            countDownLatch.countDown();
        } else {
            f.prepareAsync();
        }
        countDownLatch.await();
        if (this.ihj) {
            aHj();
        }
        if (jVar.value == null && !z) {
            ab.e("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call(), main module not ready");
            AppMethodBeat.o(131837);
            return null;
        } else if (obj2 == null || jVar2.value != null) {
            Object obj3;
            if (z) {
                WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
                wxaPkgWrappingInfo.name = "__APP__";
                wxaPkgWrappingInfo.gVu = this.ihg;
                wxaPkgWrappingInfo.gVt = this.har;
                obj3 = wxaPkgWrappingInfo;
            } else {
                WxaPkgWrappingInfo obj32 = (WxaPkgWrappingInfo) jVar.value;
            }
            for (f fVar22 : this.hin) {
                if (!"__APP__".equals(fVar22.name)) {
                    ModulePkgInfo a = ai.a(fVar22);
                    obj32.gVx.add(a);
                    if (obj2 != null && obj.equals(a.name)) {
                        a.gSP = ((WxaPkgWrappingInfo) jVar2.value).gSP;
                    }
                }
            }
            AppMethodBeat.o(131837);
            return obj32;
        } else {
            ab.e("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call(), checkEntranceModule %s but not ready", obj);
            AppMethodBeat.o(131837);
            return null;
        }
    }

    static /* synthetic */ void a(q qVar) {
        AppMethodBeat.i(131838);
        if (!qVar.ihj) {
            qVar.ihj = true;
            qVar.aHe();
        }
        AppMethodBeat.o(131838);
    }

    static /* synthetic */ void c(q qVar) {
        AppMethodBeat.i(131839);
        int min = Math.min(qVar.ihi.get(), 100);
        ab.i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "appId=" + qVar.appId + " notifyDownloadProgress=" + min);
        qVar.onDownloadProgress(min);
        AppMethodBeat.o(131839);
    }
}
