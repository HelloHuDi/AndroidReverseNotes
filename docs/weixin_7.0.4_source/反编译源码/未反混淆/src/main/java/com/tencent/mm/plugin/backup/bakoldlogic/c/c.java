package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.g;
import com.tencent.mm.bt.a;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.LinkedList;

public final class c extends b {
    private static int progress;
    private String filePath;
    private int frO = 0;
    private g jAi = null;
    private byte[] jAj;
    public x jxp = new x();
    private y jxq = new y();
    private byte[] key;
    private int offset = 0;
    private int start = 0;
    private int type;

    public c(String str, int i, LinkedList<gu> linkedList, String str2, g gVar, byte[] bArr) {
        AppMethodBeat.i(17883);
        this.jxp.jCx = str;
        this.jxp.jCy = i;
        this.type = i;
        if (i == 1) {
            gv gvVar = new gv();
            gvVar.jBw = linkedList;
            gvVar.jBv = linkedList.size();
            try {
                this.jAj = gvVar.toByteArray();
                this.frO = this.jAj.length;
            } catch (IOException e) {
                ab.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                ab.printErrStackTrace("MicroMsg.BakSceneDataPush", e, "", new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.frO = e.cs(str2);
        }
        int i2 = this.frO % 16;
        this.jxp.jCz = (16 - i2) + this.frO;
        ab.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", this.jxp.jCx, Integer.valueOf(this.jxp.jCy), Integer.valueOf(this.frO), Integer.valueOf(this.jxp.jCz));
        this.jAi = gVar;
        this.key = bArr;
        AppMethodBeat.o(17883);
    }

    public static void setProgress(int i) {
        AppMethodBeat.i(17884);
        ab.i("MicroMsg.BakSceneDataPush", "setProgress %d", Integer.valueOf(i));
        progress = i;
        AppMethodBeat.o(17884);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aUc() {
        int i;
        boolean z;
        AppMethodBeat.i(17885);
        byte[] bArr = null;
        if (this.type == 1) {
            i = this.frO;
            bArr = this.jAj;
        } else {
            long j;
            if (((long) (this.frO - this.offset)) > i.ACTION_MINI_PROGRAM_LAUNCH) {
                j = i.ACTION_MINI_PROGRAM_LAUNCH;
            } else {
                j = (long) (this.frO - this.offset);
            }
            int i2 = (int) j;
            i = 3;
            while (true) {
                int i3 = i - 1;
                if (i > 0 && bArr == null) {
                    if (!bo.isNullOrNil(this.filePath)) {
                        String str = this.filePath;
                        aw.ZK();
                        if (str.startsWith(com.tencent.mm.model.c.Yb())) {
                            ab.i("MicroMsg.BakSceneDataPush", "md5:%s", this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                            EmojiInfo Jd = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().Jd(r2);
                            if (Jd == null || (Jd.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                                bArr = e.e(this.filePath, this.offset, i2);
                                i = i3;
                            } else {
                                byte[] l = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().l(Jd);
                                bArr = new byte[i2];
                                System.arraycopy(l, this.offset, bArr, 0, i2);
                                i = i3;
                            }
                        }
                    }
                    bArr = e.e(this.filePath, this.offset, i2);
                    i = i3;
                } else if (bArr == null) {
                    ab.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", Integer.valueOf(this.offset), Integer.valueOf(i2));
                }
            }
            if (bArr == null) {
            }
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        if (this.key != null) {
            byte[] bArr2 = this.key;
            if (this.offset == this.frO) {
                z = true;
            } else {
                z = false;
            }
            bArr = AesEcb.aesCryptEcb(bArr, bArr2, true, z);
        }
        this.jxp.jCA = this.start;
        this.jxp.jCB = (bArr == null ? 0 : bArr.length) + this.start;
        this.jxp.jBi = new com.tencent.mm.bt.b(bArr);
        this.jxp.jCD = progress;
        ab.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", this.jxp.jCx, Integer.valueOf(this.frO), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jxp.jCB));
        z = super.aUc();
        AppMethodBeat.o(17885);
        return z;
    }

    public final a aTS() {
        return this.jxq;
    }

    public final a aTT() {
        return this.jxp;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17886);
        ab.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.jxq.jCx, Integer.valueOf(this.jxq.jCy), Integer.valueOf(this.jxq.jCA), Integer.valueOf(this.jxq.jCB), Integer.valueOf(this.jxq.jBT));
        if (this.jxq.jBT != 0) {
            ab.e("MicroMsg.BakSceneDataPush", "status:%d", Integer.valueOf(this.jxq.jBT));
            l(4, this.jxq.jBT, "error");
            AppMethodBeat.o(17886);
            return;
        }
        this.jAi.a(this.jxp.jCB - this.jxp.jCA, this.frO, this);
        if (this.offset == this.frO) {
            ab.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", this.jxp.jCx, Integer.valueOf(this.frO));
            l(0, 0, "success");
            AppMethodBeat.o(17886);
            return;
        }
        aUc();
        AppMethodBeat.o(17886);
    }

    public final int getType() {
        return 5;
    }
}
