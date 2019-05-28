package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class h implements b {
    private RandomAccessFile bqD = null;
    private String fileName = "";

    public h(String str) {
        this.fileName = str;
    }

    public final void alO() {
        AppMethodBeat.i(55788);
        if (this.bqD != null) {
            try {
                this.bqD.close();
                this.bqD = null;
                ab.d("MicroMsg.SilkFileOperator", "Close :" + this.fileName);
                AppMethodBeat.o(55788);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(55788);
    }

    private boolean cY(boolean z) {
        boolean z2;
        AppMethodBeat.i(55789);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.bqD == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        ab.d("MicroMsg.SilkFileOperator", "Open file:" + this.bqD + " forWrite:" + z);
        try {
            this.bqD = e.ck(this.fileName, z);
            AppMethodBeat.o(55789);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.SilkFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.bqD = null;
            AppMethodBeat.o(55789);
            return false;
        }
    }

    public final g cF(int i, int i2) {
        AppMethodBeat.i(55790);
        g gVar = new g();
        if (i < 0 || i2 <= 0) {
            gVar.ret = -3;
            AppMethodBeat.o(55790);
        } else if (this.bqD != null || cY(false)) {
            gVar.buf = new byte[i2];
            try {
                long length = this.bqD.length();
                this.bqD.seek((long) i);
                int read = this.bqD.read(gVar.buf, 0, i2);
                ab.d("MicroMsg.SilkFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.bqD.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.cqs = read;
                gVar.fXD = read + i;
                gVar.ret = 0;
                AppMethodBeat.o(55790);
            } catch (Exception e) {
                ab.e("MicroMsg.SilkFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                alO();
                gVar.ret = -1;
                AppMethodBeat.o(55790);
            }
        } else {
            gVar.ret = -2;
            AppMethodBeat.o(55790);
        }
        return gVar;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(55791);
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.bqD != null || cY(true)) {
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
                AppMethodBeat.o(55791);
                return i3;
            } catch (Exception e) {
                ab.e("MicroMsg.SilkFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i2 + " failed:[" + e.getMessage() + "]");
                alO();
                AppMethodBeat.o(55791);
                return -3;
            }
        }
        AppMethodBeat.o(55791);
        return -1;
    }

    public final int getSampleRate() {
        AppMethodBeat.i(55792);
        int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(cF(0, 1).buf);
        AppMethodBeat.o(55792);
        return SilkGetEncSampleRate;
    }

    public final int getFormat() {
        return 4;
    }
}
