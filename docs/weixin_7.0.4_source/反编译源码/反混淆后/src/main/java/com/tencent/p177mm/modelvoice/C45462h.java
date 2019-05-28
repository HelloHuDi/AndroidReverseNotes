package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.h */
public final class C45462h implements C26497b {
    private RandomAccessFile bqD = null;
    private String fileName = "";

    public C45462h(String str) {
        this.fileName = str;
    }

    public final void alO() {
        AppMethodBeat.m2504i(55788);
        if (this.bqD != null) {
            try {
                this.bqD.close();
                this.bqD = null;
                C4990ab.m7410d("MicroMsg.SilkFileOperator", "Close :" + this.fileName);
                AppMethodBeat.m2505o(55788);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(55788);
    }

    /* renamed from: cY */
    private boolean m83770cY(boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(55789);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.bqD == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        C4990ab.m7410d("MicroMsg.SilkFileOperator", "Open file:" + this.bqD + " forWrite:" + z);
        try {
            this.bqD = C5730e.m8626ck(this.fileName, z);
            AppMethodBeat.m2505o(55789);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SilkFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.bqD = null;
            AppMethodBeat.m2505o(55789);
            return false;
        }
    }

    /* renamed from: cF */
    public final C37965g mo5461cF(int i, int i2) {
        AppMethodBeat.m2504i(55790);
        C37965g c37965g = new C37965g();
        if (i < 0 || i2 <= 0) {
            c37965g.ret = -3;
            AppMethodBeat.m2505o(55790);
        } else if (this.bqD != null || m83770cY(false)) {
            c37965g.buf = new byte[i2];
            try {
                long length = this.bqD.length();
                this.bqD.seek((long) i);
                int read = this.bqD.read(c37965g.buf, 0, i2);
                C4990ab.m7410d("MicroMsg.SilkFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.bqD.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                c37965g.cqs = read;
                c37965g.fXD = read + i;
                c37965g.ret = 0;
                AppMethodBeat.m2505o(55790);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SilkFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                alO();
                c37965g.ret = -1;
                AppMethodBeat.m2505o(55790);
            }
        } else {
            c37965g.ret = -2;
            AppMethodBeat.m2505o(55790);
        }
        return c37965g;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        AppMethodBeat.m2504i(55791);
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.bqD != null || m83770cY(true)) {
            try {
                this.bqD.seek((long) i2);
                this.bqD.write(bArr, 0, i);
                int i3 = i2 + i;
                if (((int) this.bqD.getFilePointer()) == i3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assert.assertTrue(z2);
                if (i3 < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                AppMethodBeat.m2505o(55791);
                return i3;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SilkFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i2 + " failed:[" + e.getMessage() + "]");
                alO();
                AppMethodBeat.m2505o(55791);
                return -3;
            }
        }
        AppMethodBeat.m2505o(55791);
        return -1;
    }

    public final int getSampleRate() {
        AppMethodBeat.m2504i(55792);
        int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(mo5461cF(0, 1).buf);
        AppMethodBeat.m2505o(55792);
        return SilkGetEncSampleRate;
    }

    public final int getFormat() {
        return 4;
    }
}
