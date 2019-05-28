package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.magicbrush.handler.glfont.l */
public final class C32201l {
    public static int VERSION = 5;
    public static int bTK = 0;
    public static int bTL = 1;
    public static int bTM = 2;
    public static int bTN = 3;
    public static int bTO = 4;
    public static int bTP = 6;
    Map<Integer, String> bTQ = new HashMap();

    /* renamed from: com.tencent.magicbrush.handler.glfont.l$c */
    static class C25717c {
        int bUa;
        int length;
        String name;
        int offset;

        private C25717c() {
        }

        /* synthetic */ C25717c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.glfont.l$b */
    static class C32202b {
        int bTX;
        int bTY;
        int bTZ;

        private C32202b() {
        }

        /* synthetic */ C32202b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.glfont.l$a */
    static class C32203a {
        int bTR;
        int bTS;
        int bTT;
        int bTU;
        int bTV;
        int bTW;

        private C32203a() {
        }

        /* synthetic */ C32203a(byte b) {
            this();
        }
    }

    public C32201l() {
        AppMethodBeat.m2504i(115960);
        AppMethodBeat.m2505o(115960);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo52868b(RandomAccessFile randomAccessFile) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.m2504i(115961);
        short readShort = randomAccessFile.readShort();
        short readShort2 = randomAccessFile.readShort();
        short readShort3 = randomAccessFile.readShort();
        if (readShort == (short) 1 && readShort2 == (short) 0) {
            randomAccessFile.seek(12);
            byte[] bArr = new byte[4];
            C25717c c25717c = new C25717c();
            readShort = (short) 0;
            while (readShort < readShort3) {
                randomAccessFile.read(bArr);
                c25717c.name = new String(bArr);
                c25717c.bUa = randomAccessFile.readInt();
                c25717c.offset = randomAccessFile.readInt();
                c25717c.length = randomAccessFile.readInt();
                if (!"name".equalsIgnoreCase(c25717c.name)) {
                    if (c25717c.name == null || c25717c.name.length() == 0) {
                        break;
                    }
                    readShort++;
                } else {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                AppMethodBeat.m2505o(115961);
                return;
            }
            randomAccessFile.seek((long) c25717c.offset);
            C32202b c32202b = new C32202b();
            c32202b.bTX = randomAccessFile.readShort();
            c32202b.bTY = randomAccessFile.readShort();
            c32202b.bTZ = randomAccessFile.readShort();
            C32203a c32203a = new C32203a();
            while (i2 < c32202b.bTY) {
                c32203a.bTR = randomAccessFile.readShort();
                c32203a.bTS = randomAccessFile.readShort();
                c32203a.bTT = randomAccessFile.readShort();
                c32203a.bTU = randomAccessFile.readShort();
                c32203a.bTV = randomAccessFile.readShort();
                c32203a.bTW = randomAccessFile.readShort();
                long filePointer = randomAccessFile.getFilePointer();
                bArr = new byte[c32203a.bTV];
                randomAccessFile.seek((long) ((c25717c.offset + c32203a.bTW) + c32202b.bTZ));
                randomAccessFile.read(bArr);
                this.bTQ.put(Integer.valueOf(c32203a.bTU), new String(bArr, Charset.forName("utf-16")));
                randomAccessFile.seek(filePointer);
                i2++;
            }
            AppMethodBeat.m2505o(115961);
            return;
        }
        AppMethodBeat.m2505o(115961);
    }

    public final String toString() {
        AppMethodBeat.m2504i(115962);
        String obj = this.bTQ.toString();
        AppMethodBeat.m2505o(115962);
        return obj;
    }
}
