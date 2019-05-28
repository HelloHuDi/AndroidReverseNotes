package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.protocal.protobuf.C15378qm;
import com.tencent.p177mm.protocal.protobuf.C46576qn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.model.app.z */
public final class C44062z extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private final C35801a vcq;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.z$a */
    public interface C35801a {
        /* renamed from: a */
        void mo9874a(String str, String str2, String str3, String str4, String str5, long j);
    }

    public C44062z(C8910b c8910b, String str, String str2, C35801a c35801a) {
        AppMethodBeat.m2504i(27355);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15378qm();
        c1196a.fsK = new C46576qn();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        this.ehh = c1196a.acD();
        C15378qm c15378qm = (C15378qm) this.ehh.fsG.fsP;
        if (c8910b == null || C5046bo.isNullOrNil(c8910b.eyr) || C5046bo.isNullOrNil(c8910b.filemd5)) {
            String str3;
            C37461f.afy();
            c15378qm.vRw = C8941a.afp();
            C37461f.afy();
            c15378qm.vXw = C8941a.m16128rH(str);
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
            c15378qm.fMd = str3;
            c15378qm.vXx = C1173e.m2563cv(str);
            c15378qm.vXv = (long) C1173e.m2560cs(str);
        } else {
            c15378qm.vRw = c8910b.eyr;
            c15378qm.vXw = c8910b.filemd5;
            c15378qm.fMd = c8910b.title;
            c15378qm.vXx = c8910b.fgp;
            c15378qm.vXv = (long) c8910b.fgo;
        }
        c15378qm.vHo = C42129a.efE;
        c15378qm.ndF = str2;
        c15378qm.ndG = C1853r.m3846Yz();
        this.vcq = c35801a;
        C4990ab.m7417i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", c8910b, c15378qm.vRw, c15378qm.vXw, c15378qm.fMd, Long.valueOf(c15378qm.vXv), c15378qm.vXx, c15378qm.ndF, c15378qm.ndG, C5046bo.dpG());
        AppMethodBeat.m2505o(27355);
    }

    public final int getType() {
        return 727;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(27356);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(27356);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(27357);
        C4990ab.m7411d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C15378qm c15378qm = (C15378qm) ((C7472b) c1929q).fsG.fsP;
            C46576qn c46576qn = (C46576qn) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7411d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", c46576qn.guQ, Integer.valueOf(c46576qn.vXy), c46576qn.vXz, c46576qn.vXA);
            if (this.vcq != null) {
                this.vcq.mo9874a(c15378qm.vXw, c15378qm.vRw, c46576qn.guQ, c46576qn.vXz, c46576qn.vXA, c15378qm.vXv);
            }
            AppMethodBeat.m2505o(27357);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.vcq != null) {
            this.vcq.mo9874a("", "", "", "", "", 0);
        }
        AppMethodBeat.m2505o(27357);
    }
}
