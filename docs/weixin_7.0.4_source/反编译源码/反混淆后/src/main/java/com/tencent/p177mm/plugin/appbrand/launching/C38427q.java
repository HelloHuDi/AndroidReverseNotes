package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.C18996ai;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31284f;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C10598b;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19575a;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19576c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.q */
class C38427q implements C27173m {
    final String appId;
    final int cDB;
    final int har;
    final String hgC;
    final List<C31284f> hin;
    final String hip;
    final int ihg;
    final int ihh;
    private final AtomicInteger ihi = new AtomicInteger(0);
    private volatile boolean ihj = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.q$a */
    abstract class C38429a implements C10598b {
        private int iho;

        public abstract long aHp();

        public abstract String aHq();

        private C38429a() {
            this.iho = 0;
        }

        /* synthetic */ C38429a(C38427q c38427q, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo22111a(WxaPkgLoadProgress wxaPkgLoadProgress) {
            C38427q.m65010a(C38427q.this);
            C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", aHq() + " progress=" + wxaPkgLoadProgress.progress);
            long aHp = aHp();
            if (aHp == 0) {
                C38427q.this.ihi.set(100);
            } else {
                C38427q.this.ihi.addAndGet(Math.round(((float) Math.max(0, wxaPkgLoadProgress.progress - this.iho)) / ((float) aHp)));
            }
            this.iho = wxaPkgLoadProgress.progress;
            C38427q.m65012c(C38427q.this);
        }
    }

    C38427q(String str, int i, String str2, int i2, int i3, int i4, String str3, List<C31284f> list) {
        AppMethodBeat.m2504i(131836);
        this.appId = str;
        this.har = i;
        this.hgC = str2;
        this.cDB = i2;
        this.ihg = i3;
        this.ihh = i4;
        this.hip = str3;
        this.hin = list;
        AppMethodBeat.m2505o(131836);
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
        AppMethodBeat.m2504i(131837);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final C19681j c19681j = new C19681j();
        final C19681j c19681j2 = new C19681j();
        C19574n f = C19575a.m30349f(this.appId, "__APP__", this.har, this.ihg);
        f.mo34782a(new C19576c() {
            /* renamed from: b */
            public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131828);
                c19681j.value = wxaPkgWrappingInfo;
                countDownLatch.countDown();
                AppMethodBeat.m2505o(131828);
            }

            /* renamed from: a */
            public final void mo6282a(C37441a<arc> c37441a) {
                AppMethodBeat.m2504i(131829);
                C38427q.m65010a(C38427q.this);
                AppMethodBeat.m2505o(131829);
            }
        });
        f.mo34781a(new C38429a() {
            /* Access modifiers changed, original: final */
            public final long aHp() {
                AppMethodBeat.m2504i(131830);
                long count = countDownLatch.getCount();
                AppMethodBeat.m2505o(131830);
                return count;
            }

            /* Access modifiers changed, original: final */
            public final String aHq() {
                AppMethodBeat.m2504i(131831);
                String str = "appId=" + C38427q.this.appId + " module=__APP__";
                AppMethodBeat.m2505o(131831);
                return str;
            }
        });
        if (C5046bo.isNullOrNil(this.hgC)) {
            str = "";
        } else {
            str = C8874h.m15847bO(this.hgC);
        }
        if (C5046bo.isNullOrNil(str)) {
            obj = this.hip;
        } else {
            obj = null;
            for (C31284f c31284f : this.hin) {
                if (str.startsWith(C38114b.m64486xm(c31284f.name))) {
                    obj = c31284f.name;
                    C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call() hit module with name[%s] appId[%s], type[%d], path[%s]", c31284f.name, this.appId, Integer.valueOf(this.har), this.hgC);
                    break;
                } else if (c31284f.gSQ != null && c31284f.gSQ.length > 0) {
                    for (String startsWith : c31284f.gSQ) {
                        if (str.startsWith(startsWith)) {
                            String str2 = c31284f.name;
                            C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call() hit module with alias[%s] appId[%s], type[%d], path[%s]", startsWith, this.appId, Integer.valueOf(this.har), this.hgC);
                            obj = str2;
                            break;
                        }
                    }
                }
            }
            if (C5046bo.isNullOrNil(obj)) {
                obj = this.hip;
            }
        }
        if ("__APP__".equals(obj) || C5046bo.isNullOrNil(obj)) {
            z = false;
            countDownLatch.countDown();
            obj2 = null;
        } else {
            obj2 = 1;
            for (C31284f c31284f2 : this.hin) {
                if (obj.equals(c31284f2.name)) {
                    z = c31284f2.cta;
                    break;
                }
            }
            z = false;
            C19574n f2 = C19575a.m30349f(this.appId, obj, this.har, this.ihg);
            f2.mo34782a(new C19576c() {
                /* renamed from: a */
                public final void mo6282a(C37441a<arc> c37441a) {
                    AppMethodBeat.m2504i(131832);
                    C38427q.m65010a(C38427q.this);
                    AppMethodBeat.m2505o(131832);
                }

                /* renamed from: b */
                public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.m2504i(131833);
                    c19681j2.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(131833);
                }
            });
            f2.mo34781a(new C38429a() {
                /* Access modifiers changed, original: final */
                public final long aHp() {
                    AppMethodBeat.m2504i(131834);
                    long count = countDownLatch.getCount();
                    AppMethodBeat.m2505o(131834);
                    return count;
                }

                /* Access modifiers changed, original: final */
                public final String aHq() {
                    AppMethodBeat.m2504i(131835);
                    String str = "appId=" + C38427q.this.appId + " module=" + obj;
                    AppMethodBeat.m2505o(131835);
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
        if (c19681j.value == null && !z) {
            C4990ab.m7412e("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call(), main module not ready");
            AppMethodBeat.m2505o(131837);
            return null;
        } else if (obj2 == null || c19681j2.value != null) {
            Object obj3;
            if (z) {
                WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
                wxaPkgWrappingInfo.name = "__APP__";
                wxaPkgWrappingInfo.gVu = this.ihg;
                wxaPkgWrappingInfo.gVt = this.har;
                obj3 = wxaPkgWrappingInfo;
            } else {
                WxaPkgWrappingInfo obj32 = (WxaPkgWrappingInfo) c19681j.value;
            }
            for (C31284f c31284f22 : this.hin) {
                if (!"__APP__".equals(c31284f22.name)) {
                    ModulePkgInfo a = C18996ai.m29565a(c31284f22);
                    obj32.gVx.add(a);
                    if (obj2 != null && obj.equals(a.name)) {
                        a.gSP = ((WxaPkgWrappingInfo) c19681j2.value).gSP;
                    }
                }
            }
            AppMethodBeat.m2505o(131837);
            return obj32;
        } else {
            C4990ab.m7413e("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "call(), checkEntranceModule %s but not ready", obj);
            AppMethodBeat.m2505o(131837);
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m65010a(C38427q c38427q) {
        AppMethodBeat.m2504i(131838);
        if (!c38427q.ihj) {
            c38427q.ihj = true;
            c38427q.aHe();
        }
        AppMethodBeat.m2505o(131838);
    }

    /* renamed from: c */
    static /* synthetic */ void m65012c(C38427q c38427q) {
        AppMethodBeat.m2504i(131839);
        int min = Math.min(c38427q.ihi.get(), 100);
        C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgModularizingHandler", "appId=" + c38427q.appId + " notifyDownloadProgress=" + min);
        c38427q.onDownloadProgress(min);
        AppMethodBeat.m2505o(131839);
    }
}
