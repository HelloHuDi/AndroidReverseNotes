package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends m implements k {
    private RandomAccessFile bqD = null;
    private f ehi;
    private String filePath = null;
    private int frO = 0;
    private int ssK = 0;
    String url;

    public a(String str) {
        this.url = str;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25236);
        this.ehi = fVar;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new alu();
        aVar.fsK = new alv();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.fsI = 141;
        aVar.fsL = 29;
        aVar.fsM = 1000000029;
        b acD = aVar.acD();
        alu alu = (alu) acD.fsG.fsP;
        alu.URL = this.url;
        alu.vOq = this.ssK;
        ab.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.ssK + " totallen:" + this.frO);
        int a = a(eVar, acD, this);
        AppMethodBeat.o(25236);
        return a;
    }

    public final m.b b(q qVar) {
        Object obj;
        AppMethodBeat.i(25237);
        String str = ((alu) ((b) qVar).fsG.fsP).URL;
        if (str == null) {
            obj = null;
        } else if (str.indexOf("weixin://") != 0) {
            obj = null;
        } else {
            obj = 1;
        }
        m.b bVar;
        if (obj == null) {
            ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            bVar = m.b.EFailed;
            AppMethodBeat.o(25237);
            return bVar;
        } else if (this.ssK < 0 || this.frO < 0) {
            ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ssK + " total:" + this.frO);
            bVar = m.b.EFailed;
            AppMethodBeat.o(25237);
            return bVar;
        } else {
            if (this.ssK == 0) {
                if (this.frO != 0) {
                    ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ssK + " total:" + this.frO);
                    bVar = m.b.EFailed;
                    AppMethodBeat.o(25237);
                    return bVar;
                }
            } else if (this.ssK >= this.frO) {
                ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ssK + " total:" + this.frO);
                bVar = m.b.EFailed;
                AppMethodBeat.o(25237);
                return bVar;
            }
            bVar = m.b.EOk;
            AppMethodBeat.o(25237);
            return bVar;
        }
    }

    public final int acn() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25238);
        if (i2 == 0 && i3 == 0) {
            alv alv = (alv) ((b) qVar).fsH.fsP;
            ab.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.ssK + " Resp[ totallen:" + alv.vOp + " bufSize:" + alv.ptz.getILen() + " ]");
            if (alv.vOp > 0) {
                this.frO = alv.vOp;
            }
            if (d(this.url, alv.ptz.getBuffer().wR, this.ssK)) {
                this.ssK = alv.ptz.getILen() + this.ssK;
                if (this.frO <= this.ssK) {
                    ab.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.frO);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(25238);
                    return;
                }
                if (a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                }
                AppMethodBeat.o(25238);
                return;
            }
            this.ehi.onSceneEnd(3, -1, str, this);
            AppMethodBeat.o(25238);
            return;
        }
        ab.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25238);
    }

    private boolean d(String str, byte[] bArr, int i) {
        AppMethodBeat.i(25239);
        if (i == 0) {
            if (this.bqD == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.h.a.a.ajk(str);
                if (this.filePath == null) {
                    ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    AppMethodBeat.o(25239);
                    return false;
                }
                try {
                    this.bqD = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    AppMethodBeat.o(25239);
                    return false;
                }
            }
            ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            AppMethodBeat.o(25239);
            return false;
        }
        try {
            this.bqD.seek((long) i);
            this.bqD.write(bArr, 0, bArr.length);
            AppMethodBeat.o(25239);
            return true;
        } catch (IOException e2) {
            ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            AppMethodBeat.o(25239);
            return false;
        }
    }

    public final int getType() {
        return 141;
    }
}
