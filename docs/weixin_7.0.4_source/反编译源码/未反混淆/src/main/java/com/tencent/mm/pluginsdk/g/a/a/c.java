package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

final class c extends l {
    private final boolean cuA;
    final String cvZ;
    final long fileSize;
    volatile boolean ufy;
    final long vdK;
    volatile byte[] veh;

    private c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, i.aiX(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        AppMethodBeat.i(79500);
        this.cvZ = str2;
        this.vdK = j;
        this.cuA = z;
        this.fileSize = j2;
        AppMethodBeat.o(79500);
    }

    public final boolean dig() {
        return true;
    }

    public final String awa() {
        return "CheckResUpdate";
    }

    static c d(s sVar) {
        AppMethodBeat.i(79502);
        c cVar = new c(sVar.field_urlKey, bo.getInt(sVar.field_fileVersion, 0), sVar.field_md5, bo.nullAsNil(sVar.field_groupId2).equals("NewXml"), sVar.field_reportId, sVar.field_url, sVar.field_maxRetryTimes, sVar.field_fileSize, sVar.field_networkType, sVar.field_priority);
        AppMethodBeat.o(79502);
        return cVar;
    }

    public final String getFilePath() {
        AppMethodBeat.i(79501);
        String aiX = i.aiX(this.vdC);
        AppMethodBeat.o(79501);
        return aiX;
    }
}
