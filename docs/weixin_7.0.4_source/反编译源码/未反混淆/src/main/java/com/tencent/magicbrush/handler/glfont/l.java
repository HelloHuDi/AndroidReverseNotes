package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public static int VERSION = 5;
    public static int bTK = 0;
    public static int bTL = 1;
    public static int bTM = 2;
    public static int bTN = 3;
    public static int bTO = 4;
    public static int bTP = 6;
    Map<Integer, String> bTQ = new HashMap();

    static class c {
        int bUa;
        int length;
        String name;
        int offset;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static class b {
        int bTX;
        int bTY;
        int bTZ;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class a {
        int bTR;
        int bTS;
        int bTT;
        int bTU;
        int bTV;
        int bTW;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public l() {
        AppMethodBeat.i(115960);
        AppMethodBeat.o(115960);
    }

    /* Access modifiers changed, original: final */
    public final void b(RandomAccessFile randomAccessFile) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(115961);
        short readShort = randomAccessFile.readShort();
        short readShort2 = randomAccessFile.readShort();
        short readShort3 = randomAccessFile.readShort();
        if (readShort == (short) 1 && readShort2 == (short) 0) {
            randomAccessFile.seek(12);
            byte[] bArr = new byte[4];
            c cVar = new c();
            readShort = (short) 0;
            while (readShort < readShort3) {
                randomAccessFile.read(bArr);
                cVar.name = new String(bArr);
                cVar.bUa = randomAccessFile.readInt();
                cVar.offset = randomAccessFile.readInt();
                cVar.length = randomAccessFile.readInt();
                if (!"name".equalsIgnoreCase(cVar.name)) {
                    if (cVar.name == null || cVar.name.length() == 0) {
                        break;
                    }
                    readShort++;
                } else {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                AppMethodBeat.o(115961);
                return;
            }
            randomAccessFile.seek((long) cVar.offset);
            b bVar = new b();
            bVar.bTX = randomAccessFile.readShort();
            bVar.bTY = randomAccessFile.readShort();
            bVar.bTZ = randomAccessFile.readShort();
            a aVar = new a();
            while (i2 < bVar.bTY) {
                aVar.bTR = randomAccessFile.readShort();
                aVar.bTS = randomAccessFile.readShort();
                aVar.bTT = randomAccessFile.readShort();
                aVar.bTU = randomAccessFile.readShort();
                aVar.bTV = randomAccessFile.readShort();
                aVar.bTW = randomAccessFile.readShort();
                long filePointer = randomAccessFile.getFilePointer();
                bArr = new byte[aVar.bTV];
                randomAccessFile.seek((long) ((cVar.offset + aVar.bTW) + bVar.bTZ));
                randomAccessFile.read(bArr);
                this.bTQ.put(Integer.valueOf(aVar.bTU), new String(bArr, Charset.forName("utf-16")));
                randomAccessFile.seek(filePointer);
                i2++;
            }
            AppMethodBeat.o(115961);
            return;
        }
        AppMethodBeat.o(115961);
    }

    public final String toString() {
        AppMethodBeat.i(115962);
        String obj = this.bTQ.toString();
        AppMethodBeat.o(115962);
        return obj;
    }
}
