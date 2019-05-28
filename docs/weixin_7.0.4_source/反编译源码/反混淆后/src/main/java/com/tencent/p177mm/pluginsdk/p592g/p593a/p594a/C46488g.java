package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40429a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40429a.C14855a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.g */
final class C46488g extends C40429a {
    final boolean cuA;
    final int cut;
    final int cuu;
    private final boolean cuw;
    final long fileSize;
    private final String vdF;
    final int vdG;
    private final byte[] vdH;
    final String vdI;
    final long vdK;
    private final String vdL;
    final byte[] veh;
    final boolean vei;
    final boolean vej;
    private final int vek;

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.g$a */
    public static final class C40425a extends C14855a<C46488g> {
        boolean cuA;
        int cut;
        int cuu;
        int cuv;
        private boolean cuw;
        long fileSize = 0;
        String vdF;
        int vdG;
        byte[] vdH;
        String vdI;
        long vdK;
        String vdL;
        byte[] veh;
        boolean vei;
        boolean vej;
        int vek;

        public C40425a(String str) {
            super(str);
        }

        public final C46488g dii() {
            AppMethodBeat.m2504i(79515);
            C46488g c46488g = new C46488g(this.url, this.vdC, this.cuv, this.networkType, this.vdM, this.fRS, this.cvZ, this.cut, this.cuu, this.vdK, this.vdL, this.vdH, this.vdI, this.vei, this.vej, this.vdF, this.vdG, this.vek, this.veh, this.fileSize, this.cuA, this.cuw, this.priority);
            AppMethodBeat.m2505o(79515);
            return c46488g;
        }
    }

    public C46488g(String str, String str2, int i, int i2, int i3, long j, String str3, int i4, int i5, long j2, String str4, byte[] bArr, String str5, boolean z, boolean z2, String str6, int i6, int i7, byte[] bArr2, long j3, boolean z3, boolean z4, int i8) {
        super(str, str2, String.valueOf(i), i2, i3, C30039i.aiX(str2), j, str3, "CheckResUpdate", z3 ? "NewXml" : "CGI", i8);
        AppMethodBeat.m2504i(79516);
        this.cut = i4;
        this.cuu = i5;
        this.vdK = j2;
        this.vdL = str4;
        this.vdH = bArr;
        this.vdI = str5;
        this.vei = z;
        this.vej = z2;
        this.vdF = str6;
        this.vdG = i6;
        this.vek = i7;
        this.veh = bArr2;
        this.fileSize = j3;
        this.cuA = z3;
        this.cuw = z4;
        AppMethodBeat.m2505o(79516);
    }

    public final String toString() {
        AppMethodBeat.m2504i(79517);
        String str = "CheckResUpdateRequest | fileUpdated=" + this.cuw + ", resType=" + this.cut + ", subType=" + this.cuu + ", reportId=" + this.vdK + ", sampleId='" + this.vdL + '\'' + ", originalMd5='" + this.vdI + '\'' + ", fileCompress=" + this.vei + ", fileEncrypt=" + this.vej + ", encryptKey='" + this.vdF + '\'' + ", keyVersion=" + this.vdG + ", EID=" + this.vek + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.cuA + " | " + super.toString();
        AppMethodBeat.m2505o(79517);
        return str;
    }

    public final C44049s dih() {
        AppMethodBeat.m2504i(79518);
        C44049s dih = super.dih();
        dih.field_fileUpdated = this.cuw;
        dih.field_resType = this.cut;
        dih.field_subType = this.cuu;
        dih.field_reportId = this.vdK;
        dih.field_sampleId = this.vdL;
        dih.field_eccSignature = this.vdH;
        dih.field_originalMd5 = this.vdI;
        dih.field_fileCompress = this.vei;
        dih.field_fileEncrypt = this.vej;
        dih.field_encryptKey = this.vdF;
        dih.field_keyVersion = this.vdG;
        dih.field_fileSize = this.fileSize;
        dih.field_EID = this.vek;
        AppMethodBeat.m2505o(79518);
        return dih;
    }

    public final int aiW(String str) {
        AppMethodBeat.m2504i(79519);
        int i = C5046bo.getInt(this.veW, 0) - C5046bo.getInt(str, 0);
        AppMethodBeat.m2505o(79519);
        return i;
    }
}
