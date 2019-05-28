package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.f.b;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

public final class a implements b {
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

    private a(String str, int i, int i2, int i3, boolean z, String str2, boolean z2, boolean z3, String str3, int i4, byte[] bArr, String str4, boolean z4, long j, String str5, String str6, int i5, int i6) {
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

    public static a a(s sVar) {
        AppMethodBeat.i(79466);
        a aVar = new a(sVar.field_urlKey, sVar.field_resType, sVar.field_subType, bo.getInt(sVar.field_fileVersion, 0), sVar.field_fileUpdated, sVar.field_filePath, sVar.field_fileEncrypt, sVar.field_fileCompress, sVar.field_encryptKey, sVar.field_keyVersion, sVar.field_eccSignature, sVar.field_originalMd5, bo.nullAsNil(sVar.field_groupId2).equals("NewXml"), sVar.field_reportId, sVar.field_sampleId, sVar.field_url, sVar.field_maxRetryTimes, sVar.field_retryTimes);
        AppMethodBeat.o(79466);
        return aVar;
    }
}
