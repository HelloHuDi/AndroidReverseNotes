package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c {
    private RandomAccessFile bqD = null;
    private String fileName = "";

    public static class a {
        public byte[] buf = null;
        public int cqs = 0;
        public int fXD = 0;
        public int ret = 0;
    }

    public c(String str) {
        this.fileName = str;
    }

    public static int uj(String str) {
        AppMethodBeat.i(25256);
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            if (length <= 0) {
                AppMethodBeat.o(25256);
                return 0;
            }
            AppMethodBeat.o(25256);
            return length;
        }
        AppMethodBeat.o(25256);
        return 0;
    }

    public final void alO() {
        AppMethodBeat.i(25257);
        if (this.bqD != null) {
            try {
                this.bqD.close();
                this.bqD = null;
                ab.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
                AppMethodBeat.o(25257);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(25257);
    }

    private boolean abj(String str) {
        boolean z;
        AppMethodBeat.i(25258);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.bqD == null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (str.equals("r") || str.equals("rw")) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ab.d("MicroMsg.SpxFileOperator", "Open file:" + this.bqD + " mode:" + str);
        try {
            this.bqD = new RandomAccessFile(this.fileName, str);
            AppMethodBeat.o(25258);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.bqD = null;
            AppMethodBeat.o(25258);
            return false;
        }
    }

    public final a Fo(int i) {
        AppMethodBeat.i(25259);
        a aVar = new a();
        if (i < 0) {
            aVar.ret = -3;
            AppMethodBeat.o(25259);
        } else if (this.bqD != null || abj("r")) {
            aVar.buf = new byte[6000];
            try {
                long length = this.bqD.length();
                this.bqD.seek((long) i);
                int read = this.bqD.read(aVar.buf, 0, 6000);
                ab.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.bqD.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                aVar.cqs = read;
                aVar.fXD = read + i;
                aVar.ret = 0;
                AppMethodBeat.o(25259);
            } catch (Exception e) {
                ab.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                alO();
                aVar.ret = -1;
                AppMethodBeat.o(25259);
            }
        } else {
            aVar.ret = -2;
            AppMethodBeat.o(25259);
        }
        return aVar;
    }
}
