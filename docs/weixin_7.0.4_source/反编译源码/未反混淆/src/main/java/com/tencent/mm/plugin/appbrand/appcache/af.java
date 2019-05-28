package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class af extends c<ae> {
    public static final String[] fjY = new String[]{j.a(ae.fjX, "PredownloadEncryptPkgInfo")};
    private final e gTC;

    static {
        AppMethodBeat.i(59450);
        AppMethodBeat.o(59450);
    }

    public af(e eVar) {
        super(eVar, ae.fjX, "PredownloadEncryptPkgInfo", ae.diI);
        this.gTC = eVar;
    }

    public final ae r(String str, int i, int i2) {
        AppMethodBeat.i(59447);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59447);
            return null;
        }
        ae aeVar = new ae();
        aeVar.field_appId = str;
        aeVar.field_type = i;
        aeVar.field_version = i2;
        if (b(aeVar, ae.gSr)) {
            AppMethodBeat.o(59447);
            return aeVar;
        }
        AppMethodBeat.o(59447);
        return null;
    }

    public final ae s(String str, int i, int i2) {
        AppMethodBeat.i(59448);
        ae r = r(str, i, i2);
        if (r == null || !a(r)) {
            AppMethodBeat.o(59448);
            return null;
        }
        AppMethodBeat.o(59448);
        return r;
    }

    static boolean a(ae aeVar) {
        AppMethodBeat.i(59449);
        if (bo.isNullOrNil(aeVar.field_pkgPath)) {
            ab.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", aeVar.toShortString());
            AppMethodBeat.o(59449);
            return false;
        } else if (bo.isNullOrNil(aeVar.field_pkgMd5)) {
            ab.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", aeVar.toShortString());
            AppMethodBeat.o(59449);
            return false;
        } else {
            ab.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", aeVar.toShortString(), g.cz(aeVar.field_pkgPath), aeVar.field_pkgMd5);
            boolean equals = aeVar.field_pkgMd5.equals(r1);
            AppMethodBeat.o(59449);
            return equals;
        }
    }
}
