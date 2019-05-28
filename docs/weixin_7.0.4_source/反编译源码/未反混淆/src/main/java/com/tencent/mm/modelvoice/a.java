package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a implements b {
    private RandomAccessFile bqD = null;
    private String fileName = "";

    public a(String str) {
        this.fileName = str;
    }

    public final void alO() {
        AppMethodBeat.i(55784);
        if (this.bqD != null) {
            try {
                this.bqD.close();
                this.bqD = null;
                ab.d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
                AppMethodBeat.o(55784);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(55784);
    }

    private boolean cY(boolean z) {
        boolean z2;
        AppMethodBeat.i(55785);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.bqD == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        ab.d("MicroMsg.AmrFileOperator", "Open file:" + this.bqD + " forWrite:" + z);
        try {
            this.bqD = e.ck(this.fileName, z);
            AppMethodBeat.o(55785);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.bqD = null;
            AppMethodBeat.o(55785);
            return false;
        }
    }

    public final g cF(int i, int i2) {
        AppMethodBeat.i(55786);
        g gVar = new g();
        if (i < 0 || i2 <= 0) {
            gVar.ret = -3;
            AppMethodBeat.o(55786);
        } else if (this.bqD != null || cY(false)) {
            int i3 = i + 6;
            gVar.buf = new byte[i2];
            try {
                long length = this.bqD.length();
                this.bqD.seek((long) i3);
                int read = this.bqD.read(gVar.buf, 0, i2);
                ab.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i3 + " readRet:" + read + " fileNow:" + this.bqD.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.cqs = read;
                gVar.fXD = (read + i3) - 6;
                gVar.ret = 0;
                AppMethodBeat.o(55786);
            } catch (Exception e) {
                ab.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i3 + "  failed:[" + e.getMessage() + "] ");
                alO();
                gVar.ret = -1;
                AppMethodBeat.o(55786);
            }
        } else {
            gVar.ret = -2;
            AppMethodBeat.o(55786);
        }
        return gVar;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(55787);
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.bqD != null || cY(true)) {
            if (i2 == 0) {
                try {
                    this.bqD.write("#!AMR\n".getBytes(), 0, 6);
                } catch (Exception e) {
                    ab.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
                    alO();
                    AppMethodBeat.o(55787);
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
                AppMethodBeat.o(55787);
                return i4;
            } catch (Exception e2) {
                ab.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i3 + " failed:[" + e2.getMessage() + "]");
                alO();
                AppMethodBeat.o(55787);
                return -3;
            }
        }
        AppMethodBeat.o(55787);
        return -1;
    }

    public final int getFormat() {
        return 0;
    }
}
