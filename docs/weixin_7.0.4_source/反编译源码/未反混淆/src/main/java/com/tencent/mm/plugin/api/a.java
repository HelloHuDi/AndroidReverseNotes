package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.api.a.b;
import com.tencent.mm.plugin.mmsight.model.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a implements b {
    public final com.tencent.mm.plugin.mmsight.api.a b(String str, String str2, int i, int i2, int i3, int i4) {
        com.tencent.mm.plugin.mmsight.api.a cVar;
        AppMethodBeat.i(76300);
        int i5 = q.etj.etI;
        ab.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", Integer.valueOf(i5));
        if (i5 != -1) {
            if (i5 == 1) {
                com.tencent.mm.plugin.mmsight.model.b.b bVar = new com.tencent.mm.plugin.mmsight.model.b.b(str, str2, i, i2, i3, i4);
                AppMethodBeat.o(76300);
                return bVar;
            } else if (i5 == 2) {
                cVar = new c(str, str2, i, i2, i3, i4);
                AppMethodBeat.o(76300);
                return cVar;
            }
        }
        if (d.iW(19)) {
            cVar = new com.tencent.mm.plugin.mmsight.model.b.b(str, str2, i, i2, i3, i4);
            AppMethodBeat.o(76300);
            return cVar;
        }
        cVar = new c(str, str2, i, i2, i3, i4);
        AppMethodBeat.o(76300);
        return cVar;
    }

    public final com.tencent.mm.plugin.mmsight.api.a a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        com.tencent.mm.plugin.mmsight.api.a cVar;
        AppMethodBeat.i(76301);
        int i5 = q.etj.etI;
        ab.i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", Integer.valueOf(i5));
        if (i5 != -1) {
            if (i5 == 1) {
                com.tencent.mm.plugin.mmsight.model.b.b bVar = new com.tencent.mm.plugin.mmsight.model.b.b(str, str2, i, i2, i3, i4, j, j2);
                AppMethodBeat.o(76301);
                return bVar;
            } else if (i5 == 2) {
                cVar = new c(str, str2, i, i2, i3, i4, j, j2);
                AppMethodBeat.o(76301);
                return cVar;
            }
        }
        if (d.iW(19)) {
            cVar = new com.tencent.mm.plugin.mmsight.model.b.b(str, str2, i, i2, i3, i4, j, j2);
            AppMethodBeat.o(76301);
            return cVar;
        }
        cVar = new c(str, str2, i, i2, i3, i4, j, j2);
        AppMethodBeat.o(76301);
        return cVar;
    }

    public final com.tencent.mm.plugin.mmsight.api.a a(int i, String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(76302);
        if (i == 1) {
            com.tencent.mm.plugin.mmsight.model.b.b bVar = new com.tencent.mm.plugin.mmsight.model.b.b(str, str2, i2, i3, i4, i5);
            AppMethodBeat.o(76302);
            return bVar;
        } else if (i == 2) {
            com.tencent.mm.plugin.mmsight.api.a cVar = new c(str, str2, i2, i3, i4, i5);
            AppMethodBeat.o(76302);
            return cVar;
        } else {
            AppMethodBeat.o(76302);
            return null;
        }
    }

    public final com.tencent.mm.plugin.mmsight.api.a a(int i, String str, String str2, int i2, int i3, int i4, int i5, long j, long j2) {
        AppMethodBeat.i(76303);
        if (i == 1) {
            com.tencent.mm.plugin.mmsight.model.b.b bVar = new com.tencent.mm.plugin.mmsight.model.b.b(str, str2, i2, i3, i4, i5, j, j2);
            AppMethodBeat.o(76303);
            return bVar;
        } else if (i == 2) {
            com.tencent.mm.plugin.mmsight.api.a cVar = new c(str, str2, i2, i3, i4, i5, j, j2);
            AppMethodBeat.o(76303);
            return cVar;
        } else {
            AppMethodBeat.o(76303);
            return null;
        }
    }
}
