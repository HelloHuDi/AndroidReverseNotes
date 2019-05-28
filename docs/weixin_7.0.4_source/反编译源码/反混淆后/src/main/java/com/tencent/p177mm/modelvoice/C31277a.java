package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.a */
public final class C31277a implements C26497b {
    private RandomAccessFile bqD = null;
    private String fileName = "";

    public C31277a(String str) {
        this.fileName = str;
    }

    public final void alO() {
        AppMethodBeat.m2504i(55784);
        if (this.bqD != null) {
            try {
                this.bqD.close();
                this.bqD = null;
                C4990ab.m7410d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
                AppMethodBeat.m2505o(55784);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(55784);
    }

    /* renamed from: cY */
    private boolean m50498cY(boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(55785);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.bqD == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        C4990ab.m7410d("MicroMsg.AmrFileOperator", "Open file:" + this.bqD + " forWrite:" + z);
        try {
            this.bqD = C5730e.m8626ck(this.fileName, z);
            AppMethodBeat.m2505o(55785);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.bqD = null;
            AppMethodBeat.m2505o(55785);
            return false;
        }
    }

    /* renamed from: cF */
    public final C37965g mo5461cF(int i, int i2) {
        AppMethodBeat.m2504i(55786);
        C37965g c37965g = new C37965g();
        if (i < 0 || i2 <= 0) {
            c37965g.ret = -3;
            AppMethodBeat.m2505o(55786);
        } else if (this.bqD != null || m50498cY(false)) {
            int i3 = i + 6;
            c37965g.buf = new byte[i2];
            try {
                long length = this.bqD.length();
                this.bqD.seek((long) i3);
                int read = this.bqD.read(c37965g.buf, 0, i2);
                C4990ab.m7410d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i3 + " readRet:" + read + " fileNow:" + this.bqD.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                c37965g.cqs = read;
                c37965g.fXD = (read + i3) - 6;
                c37965g.ret = 0;
                AppMethodBeat.m2505o(55786);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i3 + "  failed:[" + e.getMessage() + "] ");
                alO();
                c37965g.ret = -1;
                AppMethodBeat.m2505o(55786);
            }
        } else {
            c37965g.ret = -2;
            AppMethodBeat.m2505o(55786);
        }
        return c37965g;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        AppMethodBeat.m2504i(55787);
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.bqD != null || m50498cY(true)) {
            if (i2 == 0) {
                try {
                    this.bqD.write("#!AMR\n".getBytes(), 0, 6);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
                    alO();
                    AppMethodBeat.m2505o(55787);
                    return -2;
                }
            }
            int i3 = i2 + 6;
            try {
                this.bqD.seek((long) i3);
                this.bqD.write(bArr, 0, i);
                i3 += i;
                if (((int) this.bqD.getFilePointer()) == i3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assert.assertTrue(z2);
                int i4 = i3 - 6;
                if (i4 < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                AppMethodBeat.m2505o(55787);
                return i4;
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i3 + " failed:[" + e2.getMessage() + "]");
                alO();
                AppMethodBeat.m2505o(55787);
                return -3;
            }
        }
        AppMethodBeat.m2505o(55787);
        return -1;
    }

    public final int getFormat() {
        return 0;
    }
}
