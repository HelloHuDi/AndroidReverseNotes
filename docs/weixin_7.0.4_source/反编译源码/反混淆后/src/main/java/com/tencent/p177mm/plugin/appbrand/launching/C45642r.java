package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10091g;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d.C2058a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10173c;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C10598b;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19576c;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19577d;
import com.tencent.p177mm.plugin.appbrand.launching.p907c.C10595a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.r */
public class C45642r implements C27173m {
    final String appId;
    final int har;
    final List<C10173c> hil;
    final int ihg;
    private final AtomicInteger ihi = new AtomicInteger(0);
    private volatile boolean ihj = false;
    LinkedHashMap<String, C19681j<WxaPkgWrappingInfo>> ihp = new LinkedHashMap();
    private C10595a ihq;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.r$a */
    abstract class C16690a implements C10598b {
        private int iho;

        public abstract long aHp();

        public abstract String aHq();

        private C16690a() {
            this.iho = 0;
        }

        /* synthetic */ C16690a(C45642r c45642r, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo22111a(WxaPkgLoadProgress wxaPkgLoadProgress) {
            C45642r.m84279a(C45642r.this);
            C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", aHq() + " progress=" + wxaPkgLoadProgress.progress);
            long aHp = aHp();
            if (aHp == 0) {
                C45642r.this.ihi.set(100);
            } else {
                C45642r.this.ihi.addAndGet(Math.round(((float) Math.max(0, wxaPkgLoadProgress.progress - this.iho)) / ((float) aHp)));
            }
            this.iho = wxaPkgLoadProgress.progress;
            C45642r.m84282c(C45642r.this);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m84280a(C45642r c45642r, int i) {
        AppMethodBeat.m2504i(131860);
        c45642r.m84283oW(i);
        AppMethodBeat.m2505o(131860);
    }

    public /* synthetic */ Object call() {
        AppMethodBeat.m2504i(131857);
        WxaPkgWrappingInfo azZ = azZ();
        AppMethodBeat.m2505o(131857);
        return azZ;
    }

    C45642r(String str, int i, int i2, List<C10173c> list) {
        AppMethodBeat.m2504i(131854);
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
        this.appId = str;
        this.har = i;
        this.hil = list;
        this.ihg = i2;
        this.ihq = new C10595a(str, i2, i, list);
        AppMethodBeat.m2505o(131854);
    }

    public void aHe() {
    }

    public void aHj() {
    }

    public void onDownloadProgress(int i) {
    }

    private WxaPkgWrappingInfo azZ() {
        int i = 0;
        AppMethodBeat.m2504i(131855);
        Pair v = C19035as.m29615v(this.appId, this.har, this.ihg);
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        if (v.second != null) {
            C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.ihg));
            try {
                ((C2058a) C42340f.m74878E(C2058a.class)).mo5823ay(this.appId, this.ihg);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", th, "checkReportOnLocalPkgFound, appId[%s], version[%d]", this.appId, Integer.valueOf(this.ihg));
            }
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v.second;
            AppMethodBeat.m2505o(131855);
            return wxaPkgWrappingInfo;
        }
        int size = this.hil.size();
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLibList size:%d", Integer.valueOf(size));
        final CountDownLatch countDownLatch = new CountDownLatch(size + 1);
        for (int i2 = 0; i2 < size; i2++) {
            C10173c c10173c = (C10173c) this.hil.get(i2);
            if (c10173c == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codelibInfo:%d null!", Integer.valueOf(i2));
            } else {
                final String str = c10173c.bIy;
                final int i3 = c10173c.version;
                if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(c10173c.cvZ)) {
                    C4990ab.m7412e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib null or codeLib md5 null!");
                    C10595a.m18272pc(6);
                    countDownLatch.countDown();
                } else {
                    this.ihp.put(c10173c.cvZ, new C19681j());
                    C19574n b = C19577d.m30353b(str, "__CODELIB__", 0, i3, 14);
                    b.mo34782a(new C19576c() {

                        /* renamed from: com.tencent.mm.plugin.appbrand.launching.r$1$1 */
                        class C367301 implements C5681a<Void, Void> {
                            C367301() {
                            }

                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.m2504i(131840);
                                C10091g.m17687an(new C10100y(str, "__CODELIB__").toString(), i3);
                                AppMethodBeat.m2505o(131840);
                                return null;
                            }
                        }

                        public final void aHm() {
                            AppMethodBeat.m2504i(131841);
                            C45642r.m84280a(C45642r.this, 3);
                            AppMethodBeat.m2505o(131841);
                        }

                        public final void aHn() {
                            AppMethodBeat.m2504i(131842);
                            C45642r.m84280a(C45642r.this, 4);
                            AppMethodBeat.m2505o(131842);
                        }

                        public final void aHo() {
                            AppMethodBeat.m2504i(131843);
                            C45642r.m84280a(C45642r.this, 2);
                            AppMethodBeat.m2505o(131843);
                        }

                        /* renamed from: a */
                        public final void mo6282a(C37441a<arc> c37441a) {
                            AppMethodBeat.m2504i(131844);
                            C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib url result errCode:%s,errMsg:%s", Integer.valueOf(c37441a.errCode), c37441a.aIm);
                            AppMethodBeat.m2505o(131844);
                        }

                        /* renamed from: b */
                        public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.m2504i(131845);
                            if (wxaPkgWrappingInfo != null) {
                                ((C19681j) C45642r.this.ihp.get(wxaPkgWrappingInfo.cvZ)).value = wxaPkgWrappingInfo;
                            }
                            countDownLatch.countDown();
                            String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler";
                            String str2 = "codeLib pkgInfo :%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                            C4990ab.m7417i(str, str2, objArr);
                            C41930g.dOW().mo60493i(new C367301()).dMk();
                            AppMethodBeat.m2505o(131845);
                        }

                        /* renamed from: c */
                        public final void mo34787c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.m2504i(131846);
                            if (wxaPkgWrappingInfo != null) {
                                C45642r.m84284oX(0);
                                AppMethodBeat.m2505o(131846);
                                return;
                            }
                            C45642r.m84284oX(1);
                            AppMethodBeat.m2505o(131846);
                        }
                    });
                    b.mo34781a(new C16690a() {
                        /* Access modifiers changed, original: final */
                        public final long aHp() {
                            AppMethodBeat.m2504i(131847);
                            long count = countDownLatch.getCount();
                            AppMethodBeat.m2505o(131847);
                            return count;
                        }

                        /* Access modifiers changed, original: final */
                        public final String aHq() {
                            AppMethodBeat.m2504i(131848);
                            String str = "appId=" + C45642r.this.appId + " provider=" + str;
                            AppMethodBeat.m2505o(131848);
                            return str;
                        }
                    });
                    b.prepareAsync();
                }
            }
        }
        final C19681j c19681j = new C19681j();
        C19574n b2 = C19577d.m30353b(this.appId, "__WITHOUT_CODELIB__", this.har, this.ihg, 12);
        b2.mo34782a(new C19576c() {
            /* renamed from: a */
            public final void mo6282a(C37441a<arc> c37441a) {
                AppMethodBeat.m2504i(131849);
                C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule without lib url result errCode:%s,errMsg:%s", Integer.valueOf(c37441a.errCode), c37441a.aIm);
                AppMethodBeat.m2505o(131849);
            }

            /* renamed from: b */
            public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131850);
                if (wxaPkgWrappingInfo != null) {
                    c19681j.value = wxaPkgWrappingInfo;
                }
                countDownLatch.countDown();
                String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler";
                String str2 = "mainModule without codeLib pkgInfo :%s";
                Object[] objArr = new Object[1];
                objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                C4990ab.m7417i(str, str2, objArr);
                AppMethodBeat.m2505o(131850);
            }

            /* renamed from: c */
            public final void mo34787c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131851);
                if (wxaPkgWrappingInfo != null) {
                    C45642r.m84284oX(2);
                    AppMethodBeat.m2505o(131851);
                    return;
                }
                C45642r.m84284oX(3);
                AppMethodBeat.m2505o(131851);
            }
        });
        b2.mo34781a(new C16690a() {
            /* Access modifiers changed, original: final */
            public final long aHp() {
                AppMethodBeat.m2504i(131852);
                long count = countDownLatch.getCount();
                AppMethodBeat.m2505o(131852);
                return count;
            }

            /* Access modifiers changed, original: final */
            public final String aHq() {
                AppMethodBeat.m2504i(131853);
                String str = "appId=" + C45642r.this.appId + " module=__WITHOUT_CODELIB__";
                AppMethodBeat.m2505o(131853);
                return str;
            }
        });
        b2.prepareAsync();
        countDownLatch.await();
        C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "both downloaded");
        if (this.ihj) {
            aHj();
        }
        if (c19681j.value == null || this.ihp.size() <= 0) {
            C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule value or codeLibList result null!!");
            AppMethodBeat.m2505o(131855);
            return null;
        }
        this.ihq.mo22108IF();
        wxaPkgWrappingInfo = (WxaPkgWrappingInfo) c19681j.value;
        wxaPkgWrappingInfo.gSR = new PartialFile[size];
        while (true) {
            int i4 = i;
            if (i4 < this.hil.size()) {
                C10173c c10173c2 = (C10173c) this.hil.get(i4);
                wxaPkgWrappingInfo.gSR[i4] = new PartialFile();
                if (!C5046bo.isNullOrNil(((C10173c) this.hil.get(i4)).cvZ)) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) ((C19681j) this.ihp.get(((C10173c) this.hil.get(i4)).cvZ)).value;
                    if (wxaPkgWrappingInfo2 != null) {
                        wxaPkgWrappingInfo.gSR[i4].cvZ = ((C10173c) this.hil.get(i4)).cvZ;
                        wxaPkgWrappingInfo.gSR[i4].bIy = c10173c2.bIy;
                        wxaPkgWrappingInfo.gSR[i4].version = c10173c2.version;
                        wxaPkgWrappingInfo.gSR[i4].filePath = wxaPkgWrappingInfo2.gSP;
                    }
                }
                i = i4 + 1;
            } else {
                AppMethodBeat.m2505o(131855);
                return wxaPkgWrappingInfo;
            }
        }
    }

    /* renamed from: oW */
    private void m84283oW(int i) {
        AppMethodBeat.m2504i(131856);
        this.ihq.mo22109pd(i);
        AppMethodBeat.m2505o(131856);
    }

    /* renamed from: a */
    static /* synthetic */ void m84279a(C45642r c45642r) {
        AppMethodBeat.m2504i(131858);
        if (!c45642r.ihj) {
            c45642r.ihj = true;
            c45642r.aHe();
            c45642r.ihq.ijZ = true;
            c45642r.m84283oW(1);
        }
        AppMethodBeat.m2505o(131858);
    }

    /* renamed from: c */
    static /* synthetic */ void m84282c(C45642r c45642r) {
        AppMethodBeat.m2504i(131859);
        int min = Math.min(c45642r.ihi.get(), 100);
        C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "appId=" + c45642r.appId + " notifyDownloadProgress=" + min);
        c45642r.onDownloadProgress(min);
        AppMethodBeat.m2505o(131859);
    }

    /* renamed from: oX */
    static /* synthetic */ void m84284oX(int i) {
        AppMethodBeat.m2504i(131861);
        C10595a.m18272pc(i);
        AppMethodBeat.m2505o(131861);
    }
}
