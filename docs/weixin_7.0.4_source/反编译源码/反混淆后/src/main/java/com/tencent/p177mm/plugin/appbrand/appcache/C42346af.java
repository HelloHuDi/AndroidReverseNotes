package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.p911q.C19678c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.af */
public class C42346af extends C19678c<C41220ae> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C41220ae.fjX, "PredownloadEncryptPkgInfo")};
    private final C4927e gTC;

    static {
        AppMethodBeat.m2504i(59450);
        AppMethodBeat.m2505o(59450);
    }

    public C42346af(C4927e c4927e) {
        super(c4927e, C41220ae.fjX, "PredownloadEncryptPkgInfo", C41220ae.diI);
        this.gTC = c4927e;
    }

    /* renamed from: r */
    public final C41220ae mo67859r(String str, int i, int i2) {
        AppMethodBeat.m2504i(59447);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59447);
            return null;
        }
        C41220ae c41220ae = new C41220ae();
        c41220ae.field_appId = str;
        c41220ae.field_type = i;
        c41220ae.field_version = i2;
        if (mo10102b(c41220ae, C41220ae.gSr)) {
            AppMethodBeat.m2505o(59447);
            return c41220ae;
        }
        AppMethodBeat.m2505o(59447);
        return null;
    }

    /* renamed from: s */
    public final C41220ae mo67860s(String str, int i, int i2) {
        AppMethodBeat.m2504i(59448);
        C41220ae r = mo67859r(str, i, i2);
        if (r == null || !C42346af.m74892a(r)) {
            AppMethodBeat.m2505o(59448);
            return null;
        }
        AppMethodBeat.m2505o(59448);
        return r;
    }

    /* renamed from: a */
    static boolean m74892a(C41220ae c41220ae) {
        AppMethodBeat.m2504i(59449);
        if (C5046bo.isNullOrNil(c41220ae.field_pkgPath)) {
            C4990ab.m7417i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", c41220ae.toShortString());
            AppMethodBeat.m2505o(59449);
            return false;
        } else if (C5046bo.isNullOrNil(c41220ae.field_pkgMd5)) {
            C4990ab.m7417i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", c41220ae.toShortString());
            AppMethodBeat.m2505o(59449);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", c41220ae.toShortString(), C1178g.m2587cz(c41220ae.field_pkgPath), c41220ae.field_pkgMd5);
            boolean equals = c41220ae.field_pkgMd5.equals(r1);
            AppMethodBeat.m2505o(59449);
            return equals;
        }
    }
}
