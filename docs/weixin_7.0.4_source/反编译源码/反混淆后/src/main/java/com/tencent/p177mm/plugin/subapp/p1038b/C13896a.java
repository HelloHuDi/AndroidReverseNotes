package com.tencent.p177mm.plugin.subapp.p1038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.pluginsdk.p1080h.p1081a.C14859a;
import com.tencent.p177mm.protocal.protobuf.alu;
import com.tencent.p177mm.protocal.protobuf.alv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.subapp.b.a */
public final class C13896a extends C1207m implements C1918k {
    private RandomAccessFile bqD = null;
    private C1202f ehi;
    private String filePath = null;
    private int frO = 0;
    private int ssK = 0;
    String url;

    public C13896a(String str) {
        this.url = str;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25236);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new alu();
        c1196a.fsK = new alv();
        c1196a.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        c1196a.fsI = 141;
        c1196a.fsL = 29;
        c1196a.fsM = 1000000029;
        C7472b acD = c1196a.acD();
        alu alu = (alu) acD.fsG.fsP;
        alu.URL = this.url;
        alu.vOq = this.ssK;
        C4990ab.m7418v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.ssK + " totallen:" + this.frO);
        int a = mo4457a(c1902e, acD, this);
        AppMethodBeat.m2505o(25236);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        Object obj;
        AppMethodBeat.m2504i(25237);
        String str = ((alu) ((C7472b) c1929q).fsG.fsP).URL;
        if (str == null) {
            obj = null;
        } else if (str.indexOf("weixin://") != 0) {
            obj = null;
        } else {
            obj = 1;
        }
        C1206b c1206b;
        if (obj == null) {
            C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(25237);
            return c1206b;
        } else if (this.ssK < 0 || this.frO < 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ssK + " total:" + this.frO);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(25237);
            return c1206b;
        } else {
            if (this.ssK == 0) {
                if (this.frO != 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ssK + " total:" + this.frO);
                    c1206b = C1206b.EFailed;
                    AppMethodBeat.m2505o(25237);
                    return c1206b;
                }
            } else if (this.ssK >= this.frO) {
                C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ssK + " total:" + this.frO);
                c1206b = C1206b.EFailed;
                AppMethodBeat.m2505o(25237);
                return c1206b;
            }
            c1206b = C1206b.EOk;
            AppMethodBeat.m2505o(25237);
            return c1206b;
        }
    }

    public final int acn() {
        return 10;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25238);
        if (i2 == 0 && i3 == 0) {
            alv alv = (alv) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7410d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.ssK + " Resp[ totallen:" + alv.vOp + " bufSize:" + alv.ptz.getILen() + " ]");
            if (alv.vOp > 0) {
                this.frO = alv.vOp;
            }
            if (m22037d(this.url, alv.ptz.getBuffer().f1226wR, this.ssK)) {
                this.ssK = alv.ptz.getILen() + this.ssK;
                if (this.frO <= this.ssK) {
                    C4990ab.m7410d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.frO);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(25238);
                    return;
                }
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                }
                AppMethodBeat.m2505o(25238);
                return;
            }
            this.ehi.onSceneEnd(3, -1, str, this);
            AppMethodBeat.m2505o(25238);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25238);
    }

    /* renamed from: d */
    private boolean m22037d(String str, byte[] bArr, int i) {
        AppMethodBeat.m2504i(25239);
        if (i == 0) {
            if (this.bqD == null && this.filePath == null) {
                this.filePath = C14859a.ajk(str);
                if (this.filePath == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    AppMethodBeat.m2505o(25239);
                    return false;
                }
                try {
                    this.bqD = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    AppMethodBeat.m2505o(25239);
                    return false;
                }
            }
            C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            AppMethodBeat.m2505o(25239);
            return false;
        }
        try {
            this.bqD.seek((long) i);
            this.bqD.write(bArr, 0, bArr.length);
            AppMethodBeat.m2505o(25239);
            return true;
        } catch (IOException e2) {
            C4990ab.m7412e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            AppMethodBeat.m2505o(25239);
            return false;
        }
    }

    public final int getType() {
        return 141;
    }
}
