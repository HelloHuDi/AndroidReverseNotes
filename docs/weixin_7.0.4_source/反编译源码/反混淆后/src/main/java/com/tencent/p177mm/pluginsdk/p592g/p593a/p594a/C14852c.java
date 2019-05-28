package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35792l;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.c */
final class C14852c extends C35792l {
    private final boolean cuA;
    final String cvZ;
    final long fileSize;
    volatile boolean ufy;
    final long vdK;
    volatile byte[] veh;

    private C14852c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, C30039i.aiX(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        AppMethodBeat.m2504i(79500);
        this.cvZ = str2;
        this.vdK = j;
        this.cuA = z;
        this.fileSize = j2;
        AppMethodBeat.m2505o(79500);
    }

    public final boolean dig() {
        return true;
    }

    public final String awa() {
        return "CheckResUpdate";
    }

    /* renamed from: d */
    static C14852c m23110d(C44049s c44049s) {
        AppMethodBeat.m2504i(79502);
        C14852c c14852c = new C14852c(c44049s.field_urlKey, C5046bo.getInt(c44049s.field_fileVersion, 0), c44049s.field_md5, C5046bo.nullAsNil(c44049s.field_groupId2).equals("NewXml"), c44049s.field_reportId, c44049s.field_url, c44049s.field_maxRetryTimes, c44049s.field_fileSize, c44049s.field_networkType, c44049s.field_priority);
        AppMethodBeat.m2505o(79502);
        return c14852c;
    }

    public final String getFilePath() {
        AppMethodBeat.m2504i(79501);
        String aiX = C30039i.aiX(this.vdC);
        AppMethodBeat.m2505o(79501);
        return aiX;
    }
}
