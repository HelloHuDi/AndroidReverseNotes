package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.C18996ai;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10091g;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C2050aq;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10173c;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31284f;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C10598b;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19576c;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19577d;
import com.tencent.p177mm.plugin.appbrand.launching.p907c.C10595a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.s */
public class C42616s implements C27173m {
    final String appId;
    final int har;
    List<C31284f> hin;
    final int ihg;
    private final AtomicInteger ihi = new AtomicInteger(0);
    private volatile boolean ihj = false;
    LinkedHashMap<String, C19681j<WxaPkgWrappingInfo>> ihp = new LinkedHashMap();
    private C10595a ihq;
    List<C10173c> ihu;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.s$a */
    abstract class C16691a implements C10598b {
        private int iho;

        public abstract long aHp();

        public abstract String aHq();

        private C16691a() {
            this.iho = 0;
        }

        /* synthetic */ C16691a(C42616s c42616s, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo22111a(WxaPkgLoadProgress wxaPkgLoadProgress) {
            C42616s.m75459a(C42616s.this);
            C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", aHq() + " progress=" + wxaPkgLoadProgress.progress);
            long aHp = aHp();
            if (aHp == 0) {
                C42616s.this.ihi.set(100);
            } else {
                C42616s.this.ihi.addAndGet(Math.round(((float) Math.max(0, wxaPkgLoadProgress.progress - this.iho)) / ((float) aHp)));
            }
            this.iho = wxaPkgLoadProgress.progress;
            C42616s.m75463c(C42616s.this);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m75460a(C42616s c42616s, int i) {
        AppMethodBeat.m2504i(131883);
        c42616s.m75464oW(i);
        AppMethodBeat.m2505o(131883);
    }

    C42616s(String str, int i, int i2, List<C31284f> list) {
        AppMethodBeat.m2504i(131876);
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
        this.appId = str;
        this.har = i;
        this.ihg = i2;
        this.hin = list;
        for (C31284f c31284f : list) {
            if (!C5046bo.isNullOrNil(c31284f.name) && c31284f.name.equals("__APP__")) {
                this.ihu = c31284f.hir;
                break;
            }
        }
        this.ihq = new C10595a(str, i2, i, this.ihu);
        AppMethodBeat.m2505o(131876);
    }

    public void aHe() {
    }

    public void aHj() {
    }

    public void onDownloadProgress(int i) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: J */
    private static WxaPkgWrappingInfo m75458J(String str, int i, int i2) {
        Throwable th;
        Closeable closeable;
        AppMethodBeat.m2504i(131877);
        C10100y c10100y = new C10100y(str, "__APP__");
        WxaPkgWrappingInfo bo;
        if (C33097a.m54090np(i)) {
            C38105ax auV = C42340f.auV();
            if (auV == null) {
                AppMethodBeat.m2505o(131877);
                return null;
            }
            C31281at a = auV.mo60841a(c10100y.toString(), i2, i, new String[0]);
            if (a == null) {
                AppMethodBeat.m2505o(131877);
                return null;
            } else if (C5046bo.isNullOrNil(a.field_versionMd5)) {
                AppMethodBeat.m2505o(131877);
                return null;
            } else {
                Closeable openRead;
                try {
                    openRead = C5730e.openRead(a.field_pkgPath);
                    C31281at a2;
                    try {
                        if (a.field_versionMd5.equals(C1178g.m2585b(openRead, 4096))) {
                            C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appid:%s release main module already exist codeType:%d,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
                            bo = C42616s.m75462bo(a.field_pkgPath, i2);
                            C5046bo.m7527b(openRead);
                            AppMethodBeat.m2505o(131877);
                            return bo;
                        }
                        C5046bo.m7527b(openRead);
                        C5730e.deleteFile(a.field_pkgPath);
                        a2 = C19573h.m30344a(c10100y, i, i2, a.field_versionMd5);
                        if (a2 != null) {
                            String aq = C2050aq.m4207aq(c10100y.toString(), i2);
                            C5730e.m8644y(a2.field_pkgPath, aq);
                            C42340f.auV().mo60864d(c10100y.toString(), i, i2, aq);
                            bo = C42616s.m75462bo(aq, i2);
                            AppMethodBeat.m2505o(131877);
                            return bo;
                        }
                    } catch (FileNotFoundException e) {
                        try {
                            C4990ab.m7413e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "file not found appid:%s,pkgPath:%s", str, a.field_pkgPath);
                            C5046bo.m7527b(openRead);
                            C5730e.deleteFile(a.field_pkgPath);
                            a2 = C19573h.m30344a(c10100y, i, i2, a.field_versionMd5);
                            if (a2 != null) {
                            }
                            AppMethodBeat.m2505o(131877);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = openRead;
                            C5046bo.m7527b(closeable);
                            AppMethodBeat.m2505o(131877);
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    openRead = null;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(131877);
                    throw th;
                }
            }
        }
        Pair v = C19035as.m29615v(c10100y.toString(), i, 1);
        if (v.second != null) {
            ((WxaPkgWrappingInfo) v.second).name = "__APP__";
            C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId:%s,test main module already exist codeType:%d,desirePkgVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
            bo = (WxaPkgWrappingInfo) v.second;
            AppMethodBeat.m2505o(131877);
            return bo;
        }
        AppMethodBeat.m2505o(131877);
        return null;
    }

    /* renamed from: bo */
    private static WxaPkgWrappingInfo m75462bo(String str, int i) {
        AppMethodBeat.m2504i(131878);
        WxaPkgWrappingInfo xM = WxaPkgWrappingInfo.m54056xM(str);
        xM.gVu = i;
        AppMethodBeat.m2505o(131878);
        return xM;
    }

    /* renamed from: oW */
    private void m75464oW(int i) {
        AppMethodBeat.m2504i(131879);
        this.ihq.mo22109pd(i);
        AppMethodBeat.m2505o(131879);
    }

    public /* synthetic */ Object call() {
        int i = 0;
        AppMethodBeat.m2504i(131880);
        WxaPkgWrappingInfo J = C42616s.m75458J(this.appId, this.har, this.ihg);
        if (J != null) {
            for (C31284f c31284f : this.hin) {
                if (!"__APP__".equals(c31284f.name)) {
                    J.gVx.add(C18996ai.m29565a(c31284f));
                }
            }
            AppMethodBeat.m2505o(131880);
            return J;
        }
        int size = this.ihu.size();
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codeLibList size:%d", Integer.valueOf(size));
        final CountDownLatch countDownLatch = new CountDownLatch(size + 1);
        for (int i2 = 0; i2 < size; i2++) {
            C10173c c10173c = (C10173c) this.ihu.get(i2);
            if (c10173c == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codelibInfo:%d null!", Integer.valueOf(i2));
            } else {
                final String str = c10173c.bIy;
                final int i3 = c10173c.version;
                if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(c10173c.cvZ)) {
                    C4990ab.m7412e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codeLib null or codeLib md5 null!");
                    C10595a.m18272pc(6);
                    countDownLatch.countDown();
                } else {
                    this.ihp.put(c10173c.cvZ, new C19681j());
                    C19574n b = C19577d.m30353b(str, "__CODELIB__", 0, i3, 14);
                    b.mo34782a(new C19576c() {

                        /* renamed from: com.tencent.mm.plugin.appbrand.launching.s$1$1 */
                        class C426181 implements C5681a<Void, Void> {
                            C426181() {
                            }

                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.m2504i(131862);
                                C10091g.m17687an(new C10100y(str, "__CODELIB__").toString(), i3);
                                AppMethodBeat.m2505o(131862);
                                return null;
                            }
                        }

                        public final void aHm() {
                            AppMethodBeat.m2504i(131863);
                            C42616s.m75460a(C42616s.this, 3);
                            AppMethodBeat.m2505o(131863);
                        }

                        public final void aHn() {
                            AppMethodBeat.m2504i(131864);
                            C42616s.m75460a(C42616s.this, 4);
                            AppMethodBeat.m2505o(131864);
                        }

                        public final void aHo() {
                            AppMethodBeat.m2504i(131865);
                            C42616s.m75460a(C42616s.this, 2);
                            AppMethodBeat.m2505o(131865);
                        }

                        /* renamed from: a */
                        public final void mo6282a(C37441a<arc> c37441a) {
                            AppMethodBeat.m2504i(131866);
                            C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "codeLib url result errCode:%s,errMsg:%s", Integer.valueOf(c37441a.errCode), c37441a.aIm);
                            AppMethodBeat.m2505o(131866);
                        }

                        /* renamed from: b */
                        public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.m2504i(131867);
                            if (wxaPkgWrappingInfo != null) {
                                ((C19681j) C42616s.this.ihp.get(wxaPkgWrappingInfo.cvZ)).value = wxaPkgWrappingInfo;
                            }
                            countDownLatch.countDown();
                            String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler";
                            String str2 = "codeLib pkgInfo :%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                            C4990ab.m7417i(str, str2, objArr);
                            C41930g.dOW().mo60493i(new C426181()).dMk();
                            AppMethodBeat.m2505o(131867);
                        }

                        /* renamed from: c */
                        public final void mo34787c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                            AppMethodBeat.m2504i(131868);
                            if (wxaPkgWrappingInfo != null) {
                                C42616s.m75465oY(0);
                                AppMethodBeat.m2505o(131868);
                                return;
                            }
                            C42616s.m75465oY(1);
                            AppMethodBeat.m2505o(131868);
                        }
                    });
                    b.mo34781a(new C16691a() {
                        /* Access modifiers changed, original: final */
                        public final long aHp() {
                            AppMethodBeat.m2504i(131869);
                            long count = countDownLatch.getCount();
                            AppMethodBeat.m2505o(131869);
                            return count;
                        }

                        /* Access modifiers changed, original: final */
                        public final String aHq() {
                            AppMethodBeat.m2504i(131870);
                            String str = "appId=" + C42616s.this.appId + " provider=" + str;
                            AppMethodBeat.m2505o(131870);
                            return str;
                        }
                    });
                    b.prepareAsync();
                }
            }
        }
        final C19681j c19681j = new C19681j();
        C19574n b2 = C19577d.m30353b(this.appId, "__APP__", this.har, this.ihg, 13);
        b2.mo34782a(new C19576c() {
            /* renamed from: a */
            public final void mo6282a(C37441a<arc> c37441a) {
                AppMethodBeat.m2504i(131871);
                C4990ab.m7417i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "mainModule without lib url result errCode:%s,errMsg:%s", Integer.valueOf(c37441a.errCode), c37441a.aIm);
                AppMethodBeat.m2505o(131871);
            }

            /* renamed from: b */
            public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131872);
                if (wxaPkgWrappingInfo != null) {
                    c19681j.value = wxaPkgWrappingInfo;
                }
                countDownLatch.countDown();
                String str = "MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler";
                String str2 = "mainModule without codeLib pkgInfo :%s";
                Object[] objArr = new Object[1];
                objArr[0] = wxaPkgWrappingInfo != null ? wxaPkgWrappingInfo.toString() : BuildConfig.COMMAND;
                C4990ab.m7417i(str, str2, objArr);
                AppMethodBeat.m2505o(131872);
            }

            /* renamed from: c */
            public final void mo34787c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131873);
                if (wxaPkgWrappingInfo != null) {
                    C42616s.m75465oY(4);
                    AppMethodBeat.m2505o(131873);
                    return;
                }
                C42616s.m75465oY(5);
                AppMethodBeat.m2505o(131873);
            }
        });
        b2.mo34781a(new C16691a() {
            /* Access modifiers changed, original: final */
            public final long aHp() {
                AppMethodBeat.m2504i(131874);
                long count = countDownLatch.getCount();
                AppMethodBeat.m2505o(131874);
                return count;
            }

            /* Access modifiers changed, original: final */
            public final String aHq() {
                AppMethodBeat.m2504i(131875);
                String str = "appId=" + C42616s.this.appId + " modulename= __APP__ module=__WITHOUT_CODELIB__";
                AppMethodBeat.m2505o(131875);
                return str;
            }
        });
        b2.prepareAsync();
        countDownLatch.await();
        C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "both downloaded!");
        if (this.ihj) {
            aHj();
        }
        if (c19681j.value == null || this.ihp.size() <= 0) {
            C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "mainModule value or codeLibList result null!!");
            AppMethodBeat.m2505o(131880);
            return null;
        }
        this.ihq.mo22108IF();
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) c19681j.value;
        wxaPkgWrappingInfo.gSR = new PartialFile[size];
        while (true) {
            int i4 = i;
            if (i4 >= this.ihu.size()) {
                break;
            }
            C10173c c10173c2 = (C10173c) this.ihu.get(i4);
            wxaPkgWrappingInfo.gSR[i4] = new PartialFile();
            if (!C5046bo.isNullOrNil(((C10173c) this.ihu.get(i4)).cvZ)) {
                WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) ((C19681j) this.ihp.get(((C10173c) this.ihu.get(i4)).cvZ)).value;
                if (wxaPkgWrappingInfo2 != null) {
                    wxaPkgWrappingInfo.gSR[i4].cvZ = ((C10173c) this.ihu.get(i4)).cvZ;
                    wxaPkgWrappingInfo.gSR[i4].bIy = c10173c2.bIy;
                    wxaPkgWrappingInfo.gSR[i4].version = c10173c2.version;
                    wxaPkgWrappingInfo.gSR[i4].filePath = wxaPkgWrappingInfo2.gSP;
                }
            }
            i = i4 + 1;
        }
        for (C31284f c31284f2 : this.hin) {
            if (!"__APP__".equals(c31284f2.name)) {
                wxaPkgWrappingInfo.gVx.add(C18996ai.m29565a(c31284f2));
            }
        }
        AppMethodBeat.m2505o(131880);
        return wxaPkgWrappingInfo;
    }

    /* renamed from: a */
    static /* synthetic */ void m75459a(C42616s c42616s) {
        AppMethodBeat.m2504i(131881);
        if (!c42616s.ihj) {
            c42616s.ihj = true;
            c42616s.aHe();
            c42616s.ihq.ijZ = true;
            c42616s.m75464oW(1);
        }
        AppMethodBeat.m2505o(131881);
    }

    /* renamed from: c */
    static /* synthetic */ void m75463c(C42616s c42616s) {
        AppMethodBeat.m2504i(131882);
        int min = Math.min(c42616s.ihi.get(), 100);
        C4990ab.m7416i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId=" + c42616s.appId + " notifyDownloadProgress=" + min);
        c42616s.onDownloadProgress(min);
        AppMethodBeat.m2505o(131882);
    }

    /* renamed from: oY */
    static /* synthetic */ void m75465oY(int i) {
        AppMethodBeat.m2504i(131884);
        C10595a.m18272pc(i);
        AppMethodBeat.m2505o(131884);
    }
}
