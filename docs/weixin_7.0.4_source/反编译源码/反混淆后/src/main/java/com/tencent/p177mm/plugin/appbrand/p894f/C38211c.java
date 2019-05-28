package com.tencent.p177mm.plugin.appbrand.p894f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;

/* renamed from: com.tencent.mm.plugin.appbrand.f.c */
public final class C38211c extends C45968a {
    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(129968);
        if (mo23703Pp()) {
            mo73835K(-104, 2);
        }
        AppMethodBeat.m2505o(129968);
    }

    public final String getTableName() {
        return "WeApp";
    }

    public final String getName() {
        return "FTS5WeAppStorage";
    }

    public final int getType() {
        return 512;
    }

    public final int getPriority() {
        return 512;
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(129969);
        if (mo73849ei(ZipJNI.UNZ_INTERNALERROR, 2)) {
            AppMethodBeat.m2505o(129969);
            return false;
        }
        AppMethodBeat.m2505o(129969);
        return true;
    }
}
