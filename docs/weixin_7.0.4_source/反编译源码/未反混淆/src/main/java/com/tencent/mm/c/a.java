package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    public a cdb;
    public b cdc = null;

    public static class a {
        static final long cdd = ((long) "Micromsg".hashCode());
        public int cde = 0;

        static {
            AppMethodBeat.i(125699);
            AppMethodBeat.o(125699);
        }

        public a(int i) {
            this.cde = i;
        }

        public static a C(byte[] bArr) {
            a aVar;
            AppMethodBeat.i(125700);
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & 255)) << (i * 8);
                }
                if ((j >> 32) == cdd) {
                    aVar = new a((int) j);
                    AppMethodBeat.o(125700);
                    return aVar;
                }
            }
            aVar = null;
            AppMethodBeat.o(125700);
            return aVar;
        }

        static byte[] aL(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public a(b bVar) {
        this.cdc = bVar;
    }

    public final int x(File file) {
        AppMethodBeat.i(125701);
        try {
            if (cL(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                AppMethodBeat.o(125701);
                return -1;
            }
            byte[] toByteArray = this.cdc.toByteArray();
            byte[] aL = a.aL((a.cdd << 32) | ((long) new a(toByteArray.length).cde));
            byte[] bArr = new byte[]{(byte) ((toByteArray.length + 8) % 256), (byte) ((toByteArray.length + 8) / 256)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(toByteArray);
            fileOutputStream.write(aL);
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(125701);
            return 0;
        } catch (Exception e) {
            AppMethodBeat.o(125701);
            return -1;
        }
    }

    public static boolean cM(String str) {
        boolean z = false;
        AppMethodBeat.i(125703);
        if (str == null) {
            AppMethodBeat.o(125703);
        } else {
            File file = new File(str);
            if (file.exists()) {
                a cL = cL(str);
                if (!(cL == null || cL.cdc == null)) {
                    try {
                        byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                        File file2 = new File(str);
                        if (file2.exists()) {
                            z = cL.cdc.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (cL.cdb.cde + 8))) - 2), bArr));
                            AppMethodBeat.o(125703);
                        }
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.o(125703);
            } else {
                AppMethodBeat.o(125703);
            }
        }
        return z;
    }

    private static byte[] f(String str, int i, int i2) {
        AppMethodBeat.i(125704);
        if (str == null) {
            AppMethodBeat.o(125704);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            int length;
            if (i2 == -1) {
                length = (int) file.length();
            } else {
                length = i2;
            }
            if (i < 0) {
                AppMethodBeat.o(125704);
                return null;
            } else if (length <= 0) {
                AppMethodBeat.o(125704);
                return null;
            } else {
                byte[] bArr;
                if (i + length > ((int) file.length())) {
                    length = ((int) file.length()) - i;
                }
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                    bArr = new byte[length];
                    try {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.readFully(bArr);
                        randomAccessFile.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    bArr = null;
                }
                AppMethodBeat.o(125704);
                return bArr;
            }
        }
        AppMethodBeat.o(125704);
        return null;
    }

    public static a cL(String str) {
        int i = 0;
        AppMethodBeat.i(125702);
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i = (int) file.length();
                }
            } catch (Exception e) {
            }
        }
        if (i < 8) {
            AppMethodBeat.o(125702);
            return null;
        }
        a C = a.C(f(str, i - 8, 8));
        if (C == null) {
            AppMethodBeat.o(125702);
            return null;
        }
        if (C.cde >= 0) {
            b bVar = new b();
            bVar.parseFrom(f(str, (i - C.cde) - 8, C.cde));
            a aVar = new a(bVar);
            aVar.cdb = C;
            AppMethodBeat.o(125702);
            return aVar;
        }
        AppMethodBeat.o(125702);
        return null;
    }
}
