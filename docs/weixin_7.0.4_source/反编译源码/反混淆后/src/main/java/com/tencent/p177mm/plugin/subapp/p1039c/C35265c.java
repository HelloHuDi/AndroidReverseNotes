package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.c.c */
public final class C35265c {
    private RandomAccessFile bqD = null;
    private String fileName = "";

    /* renamed from: com.tencent.mm.plugin.subapp.c.c$a */
    public static class C13899a {
        public byte[] buf = null;
        public int cqs = 0;
        public int fXD = 0;
        public int ret = 0;
    }

    public C35265c(String str) {
        this.fileName = str;
    }

    /* renamed from: uj */
    public static int m57937uj(String str) {
        AppMethodBeat.m2504i(25256);
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            if (length <= 0) {
                AppMethodBeat.m2505o(25256);
                return 0;
            }
            AppMethodBeat.m2505o(25256);
            return length;
        }
        AppMethodBeat.m2505o(25256);
        return 0;
    }

    public final void alO() {
        AppMethodBeat.m2504i(25257);
        if (this.bqD != null) {
            try {
                this.bqD.close();
                this.bqD = null;
                C4990ab.m7410d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
                AppMethodBeat.m2505o(25257);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(25257);
    }

    private boolean abj(String str) {
        boolean z;
        AppMethodBeat.m2504i(25258);
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
        C4990ab.m7410d("MicroMsg.SpxFileOperator", "Open file:" + this.bqD + " mode:" + str);
        try {
            this.bqD = new RandomAccessFile(this.fileName, str);
            AppMethodBeat.m2505o(25258);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.bqD = null;
            AppMethodBeat.m2505o(25258);
            return false;
        }
    }

    /* renamed from: Fo */
    public final C13899a mo55981Fo(int i) {
        AppMethodBeat.m2504i(25259);
        C13899a c13899a = new C13899a();
        if (i < 0) {
            c13899a.ret = -3;
            AppMethodBeat.m2505o(25259);
        } else if (this.bqD != null || abj("r")) {
            c13899a.buf = new byte[6000];
            try {
                long length = this.bqD.length();
                this.bqD.seek((long) i);
                int read = this.bqD.read(c13899a.buf, 0, 6000);
                C4990ab.m7410d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.bqD.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                c13899a.cqs = read;
                c13899a.fXD = read + i;
                c13899a.ret = 0;
                AppMethodBeat.m2505o(25259);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                alO();
                c13899a.ret = -1;
                AppMethodBeat.m2505o(25259);
            }
        } else {
            c13899a.ret = -2;
            AppMethodBeat.m2505o(25259);
        }
        return c13899a;
    }
}
