package com.tencent.p177mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a.C10066a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C45508b;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.t */
public enum C42360t implements C45508b {
    ;
    
    private int gTl;
    private String gTm;

    private C42360t(String str) {
        this.gTl = -1;
        this.gTm = null;
    }

    static {
        AppMethodBeat.m2505o(129396);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: E */
    public final void mo67865E(int i, String str) {
        this.gTl = i;
        this.gTm = str;
    }

    /* renamed from: dy */
    public final void mo67866dy(boolean z) {
        AppMethodBeat.m2504i(129395);
        Pair p = C19035as.m29614p(z, true);
        if (p.second != null) {
            AppMethodBeat.m2505o(129395);
            return;
        }
        if (p.first == C19036a.gUM) {
            final C31281at a = C42340f.auV().mo60842a("@LibraryAppId", z ? 0 : 999, "downloadURL", "version");
            if (!(a == null || C5046bo.isNullOrNil(a.field_downloadURL))) {
                int i;
                if (z) {
                    i = a.field_version;
                } else {
                    i = 0;
                }
                C2057a c100991 = new C2057a() {
                    /* renamed from: bl */
                    public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
                    }

                    /* renamed from: a */
                    public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                        AppMethodBeat.m2504i(129391);
                        if (C10067a.OK == c10067a) {
                            C45694h.m84430pN(2);
                        }
                        AppMethodBeat.m2505o(129391);
                    }
                };
                if (z) {
                    if (this.gTl > 0 && !C5046bo.isNullOrNil(this.gTm)) {
                        C4990ab.m7417i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", Boolean.valueOf(C19071r.avE()));
                        if (C19071r.avE()) {
                            if (C19035as.m29615v("@LibraryAppId", 0, this.gTl).first == C19036a.gUI) {
                                C4990ab.m7416i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
                                C19063p.m29630a("@LibraryAppId", this.gTl, a.field_version, this.gTm, c100991);
                                AppMethodBeat.m2505o(129395);
                                return;
                            }
                            C4990ab.m7413e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", Integer.valueOf(this.gTl), this.gTm);
                        }
                    }
                    C2055az.m4221a(a.field_downloadURL, a.field_version, c100991);
                    AppMethodBeat.m2505o(129395);
                    return;
                }
                C2055az.m4223a("@LibraryAppId", 999, a.field_downloadURL, c100991, new C10066a() {
                    public final String avJ() {
                        AppMethodBeat.m2504i(129392);
                        String str = "_" + a.field_versionMd5;
                        AppMethodBeat.m2505o(129392);
                        return str;
                    }
                });
            }
        }
        AppMethodBeat.m2505o(129395);
    }
}
