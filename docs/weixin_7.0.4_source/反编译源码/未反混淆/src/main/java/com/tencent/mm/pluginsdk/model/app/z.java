package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class z extends m implements k {
    private b ehh;
    private f ehi;
    private final a vcq;

    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, long j);
    }

    public z(j.b bVar, String str, String str2, a aVar) {
        AppMethodBeat.i(27355);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new qm();
        aVar2.fsK = new qn();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        this.ehh = aVar2.acD();
        qm qmVar = (qm) this.ehh.fsG.fsP;
        if (bVar == null || bo.isNullOrNil(bVar.eyr) || bo.isNullOrNil(bVar.filemd5)) {
            String str3;
            com.tencent.mm.al.f.afy();
            qmVar.vRw = com.tencent.mm.al.a.afp();
            com.tencent.mm.al.f.afy();
            qmVar.vXw = com.tencent.mm.al.a.rH(str);
            if (str == null || str.length() <= 0) {
                str3 = "";
            } else {
                str3 = new File(str).getName();
                int lastIndexOf = str3.lastIndexOf(46);
                if (lastIndexOf < 0) {
                    str3 = str;
                } else if (lastIndexOf == 0) {
                    str3 = "";
                } else {
                    str3 = str3.substring(0, lastIndexOf);
                }
            }
            qmVar.fMd = str3;
            qmVar.vXx = e.cv(str);
            qmVar.vXv = (long) e.cs(str);
        } else {
            qmVar.vRw = bVar.eyr;
            qmVar.vXw = bVar.filemd5;
            qmVar.fMd = bVar.title;
            qmVar.vXx = bVar.fgp;
            qmVar.vXv = (long) bVar.fgo;
        }
        qmVar.vHo = com.tencent.mm.i.a.efE;
        qmVar.ndF = str2;
        qmVar.ndG = r.Yz();
        this.vcq = aVar;
        ab.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", bVar, qmVar.vRw, qmVar.vXw, qmVar.fMd, Long.valueOf(qmVar.vXv), qmVar.vXx, qmVar.ndF, qmVar.ndG, bo.dpG());
        AppMethodBeat.o(27355);
    }

    public final int getType() {
        return 727;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(27356);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(27356);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(27357);
        ab.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            qm qmVar = (qm) ((b) qVar).fsG.fsP;
            qn qnVar = (qn) ((b) qVar).fsH.fsP;
            ab.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", qnVar.guQ, Integer.valueOf(qnVar.vXy), qnVar.vXz, qnVar.vXA);
            if (this.vcq != null) {
                this.vcq.a(qmVar.vXw, qmVar.vRw, qnVar.guQ, qnVar.vXz, qnVar.vXA, qmVar.vXv);
            }
            AppMethodBeat.o(27357);
            return;
        }
        ab.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.vcq != null) {
            this.vcq.a("", "", "", "", "", 0);
        }
        AppMethodBeat.o(27357);
    }
}
