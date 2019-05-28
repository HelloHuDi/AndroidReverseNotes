package com.tencent.p177mm.plugin.backup.bakoldlogic.p343c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.jniinterface.AesEcb;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p921i.C27495x;
import com.tencent.p177mm.plugin.backup.p921i.C38665y;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.C46545gv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.c.c */
public final class C45740c extends C19978b {
    private static int progress;
    private String filePath;
    private int frO = 0;
    private C32231g jAi = null;
    private byte[] jAj;
    public C27495x jxp = new C27495x();
    private C38665y jxq = new C38665y();
    private byte[] key;
    private int offset = 0;
    private int start = 0;
    private int type;

    public C45740c(String str, int i, LinkedList<C40522gu> linkedList, String str2, C32231g c32231g, byte[] bArr) {
        AppMethodBeat.m2504i(17883);
        this.jxp.jCx = str;
        this.jxp.jCy = i;
        this.type = i;
        if (i == 1) {
            C46545gv c46545gv = new C46545gv();
            c46545gv.jBw = linkedList;
            c46545gv.jBv = linkedList.size();
            try {
                this.jAj = c46545gv.toByteArray();
                this.frO = this.jAj.length;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                C4990ab.printErrStackTrace("MicroMsg.BakSceneDataPush", e, "", new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.frO = C1173e.m2560cs(str2);
        }
        int i2 = this.frO % 16;
        this.jxp.jCz = (16 - i2) + this.frO;
        C4990ab.m7417i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", this.jxp.jCx, Integer.valueOf(this.jxp.jCy), Integer.valueOf(this.frO), Integer.valueOf(this.jxp.jCz));
        this.jAi = c32231g;
        this.key = bArr;
        AppMethodBeat.m2505o(17883);
    }

    public static void setProgress(int i) {
        AppMethodBeat.m2504i(17884);
        C4990ab.m7417i("MicroMsg.BakSceneDataPush", "setProgress %d", Integer.valueOf(i));
        progress = i;
        AppMethodBeat.m2505o(17884);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aUc() {
        int i;
        boolean z;
        AppMethodBeat.m2504i(17885);
        byte[] bArr = null;
        if (this.type == 1) {
            i = this.frO;
            bArr = this.jAj;
        } else {
            long j;
            if (((long) (this.frO - this.offset)) > C1625i.ACTION_MINI_PROGRAM_LAUNCH) {
                j = C1625i.ACTION_MINI_PROGRAM_LAUNCH;
            } else {
                j = (long) (this.frO - this.offset);
            }
            int i2 = (int) j;
            i = 3;
            while (true) {
                int i3 = i - 1;
                if (i > 0 && bArr == null) {
                    if (!C5046bo.isNullOrNil(this.filePath)) {
                        String str = this.filePath;
                        C9638aw.m17190ZK();
                        if (str.startsWith(C18628c.m29093Yb())) {
                            C4990ab.m7417i("MicroMsg.BakSceneDataPush", "md5:%s", this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                            EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(r2);
                            if (Jd == null || (Jd.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                                bArr = C1173e.m2569e(this.filePath, this.offset, i2);
                                i = i3;
                            } else {
                                byte[] l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(Jd);
                                bArr = new byte[i2];
                                System.arraycopy(l, this.offset, bArr, 0, i2);
                                i = i3;
                            }
                        }
                    }
                    bArr = C1173e.m2569e(this.filePath, this.offset, i2);
                    i = i3;
                } else if (bArr == null) {
                    C4990ab.m7413e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", Integer.valueOf(this.offset), Integer.valueOf(i2));
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
        this.jxp.jBi = new C1332b(bArr);
        this.jxp.jCD = progress;
        C4990ab.m7417i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", this.jxp.jCx, Integer.valueOf(this.frO), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jxp.jCB));
        z = super.aUc();
        AppMethodBeat.m2505o(17885);
        return z;
    }

    public final C1331a aTS() {
        return this.jxq;
    }

    public final C1331a aTT() {
        return this.jxp;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17886);
        C4990ab.m7417i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.jxq.jCx, Integer.valueOf(this.jxq.jCy), Integer.valueOf(this.jxq.jCA), Integer.valueOf(this.jxq.jCB), Integer.valueOf(this.jxq.jBT));
        if (this.jxq.jBT != 0) {
            C4990ab.m7413e("MicroMsg.BakSceneDataPush", "status:%d", Integer.valueOf(this.jxq.jBT));
            mo35227l(4, this.jxq.jBT, "error");
            AppMethodBeat.m2505o(17886);
            return;
        }
        this.jAi.mo8280a(this.jxp.jCB - this.jxp.jCA, this.frO, this);
        if (this.offset == this.frO) {
            C4990ab.m7417i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", this.jxp.jCx, Integer.valueOf(this.frO));
            mo35227l(0, 0, "success");
            AppMethodBeat.m2505o(17886);
            return;
        }
        aUc();
        AppMethodBeat.m2505o(17886);
    }

    public final int getType() {
        return 5;
    }
}
