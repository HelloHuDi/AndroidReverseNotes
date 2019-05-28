package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4719b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.a */
public final class C14836a implements C4719b {
    final int cut;
    final int cuu;
    final int cuv;
    final boolean cuw;
    final String filePath;
    final String url;
    final String vdC;
    final boolean vdD;
    final boolean vdE;
    final String vdF;
    final int vdG;
    final byte[] vdH;
    final String vdI;
    final boolean vdJ;
    final long vdK;
    final String vdL;
    final int vdM;
    final int vdN;

    private C14836a(String str, int i, int i2, int i3, boolean z, String str2, boolean z2, boolean z3, String str3, int i4, byte[] bArr, String str4, boolean z4, long j, String str5, String str6, int i5, int i6) {
        this.vdC = str;
        this.cut = i;
        this.cuu = i2;
        this.cuv = i3;
        this.cuw = z;
        this.filePath = str2;
        this.vdD = z2;
        this.vdE = z3;
        this.vdF = str3;
        this.vdG = i4;
        this.vdH = bArr;
        this.vdI = str4;
        this.vdJ = z4;
        this.vdK = j;
        this.vdL = str5;
        this.url = str6;
        this.vdM = i5;
        this.vdN = i6;
    }

    public final String dib() {
        return this.vdC;
    }

    /* renamed from: a */
    public static C14836a m23093a(C44049s c44049s) {
        AppMethodBeat.m2504i(79466);
        C14836a c14836a = new C14836a(c44049s.field_urlKey, c44049s.field_resType, c44049s.field_subType, C5046bo.getInt(c44049s.field_fileVersion, 0), c44049s.field_fileUpdated, c44049s.field_filePath, c44049s.field_fileEncrypt, c44049s.field_fileCompress, c44049s.field_encryptKey, c44049s.field_keyVersion, c44049s.field_eccSignature, c44049s.field_originalMd5, C5046bo.nullAsNil(c44049s.field_groupId2).equals("NewXml"), c44049s.field_reportId, c44049s.field_sampleId, c44049s.field_url, c44049s.field_maxRetryTimes, c44049s.field_retryTimes);
        AppMethodBeat.m2505o(79466);
        return c14836a;
    }
}
