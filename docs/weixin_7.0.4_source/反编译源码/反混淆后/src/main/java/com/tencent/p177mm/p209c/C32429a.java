package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.c.a */
public final class C32429a {
    public C32430a cdb;
    public C37624b cdc = null;

    /* renamed from: com.tencent.mm.c.a$a */
    public static class C32430a {
        static final long cdd = ((long) "Micromsg".hashCode());
        public int cde = 0;

        static {
            AppMethodBeat.m2504i(125699);
            AppMethodBeat.m2505o(125699);
        }

        public C32430a(int i) {
            this.cde = i;
        }

        /* renamed from: C */
        public static C32430a m53090C(byte[] bArr) {
            C32430a c32430a;
            AppMethodBeat.m2504i(125700);
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & 255)) << (i * 8);
                }
                if ((j >> 32) == cdd) {
                    c32430a = new C32430a((int) j);
                    AppMethodBeat.m2505o(125700);
                    return c32430a;
                }
            }
            c32430a = null;
            AppMethodBeat.m2505o(125700);
            return c32430a;
        }

        /* renamed from: aL */
        static byte[] m53091aL(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public C32429a(C37624b c37624b) {
        this.cdc = c37624b;
    }

    /* renamed from: x */
    public final int mo53071x(File file) {
        AppMethodBeat.m2504i(125701);
        try {
            if (C32429a.m53086cL(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                AppMethodBeat.m2505o(125701);
                return -1;
            }
            byte[] toByteArray = this.cdc.toByteArray();
            byte[] aL = C32430a.m53091aL((C32430a.cdd << 32) | ((long) new C32430a(toByteArray.length).cde));
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
            AppMethodBeat.m2505o(125701);
            return 0;
        } catch (Exception e) {
            AppMethodBeat.m2505o(125701);
            return -1;
        }
    }

    /* renamed from: cM */
    public static boolean m53087cM(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(125703);
        if (str == null) {
            AppMethodBeat.m2505o(125703);
        } else {
            File file = new File(str);
            if (file.exists()) {
                C32429a cL = C32429a.m53086cL(str);
                if (!(cL == null || cL.cdc == null)) {
                    try {
                        byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                        File file2 = new File(str);
                        if (file2.exists()) {
                            z = cL.cdc.apkMd5.equalsIgnoreCase(C25998g.m41486a(file2, (int) ((file.length() - ((long) (cL.cdb.cde + 8))) - 2), bArr));
                            AppMethodBeat.m2505o(125703);
                        }
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.m2505o(125703);
            } else {
                AppMethodBeat.m2505o(125703);
            }
        }
        return z;
    }

    /* renamed from: f */
    private static byte[] m53088f(String str, int i, int i2) {
        AppMethodBeat.m2504i(125704);
        if (str == null) {
            AppMethodBeat.m2505o(125704);
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
                AppMethodBeat.m2505o(125704);
                return null;
            } else if (length <= 0) {
                AppMethodBeat.m2505o(125704);
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
                AppMethodBeat.m2505o(125704);
                return bArr;
            }
        }
        AppMethodBeat.m2505o(125704);
        return null;
    }

    /* renamed from: cL */
    public static C32429a m53086cL(String str) {
        int i = 0;
        AppMethodBeat.m2504i(125702);
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
            AppMethodBeat.m2505o(125702);
            return null;
        }
        C32430a C = C32430a.m53090C(C32429a.m53088f(str, i - 8, 8));
        if (C == null) {
            AppMethodBeat.m2505o(125702);
            return null;
        }
        if (C.cde >= 0) {
            C37624b c37624b = new C37624b();
            c37624b.parseFrom(C32429a.m53088f(str, (i - C.cde) - 8, C.cde));
            C32429a c32429a = new C32429a(c37624b);
            c32429a.cdb = C;
            AppMethodBeat.m2505o(125702);
            return c32429a;
        }
        AppMethodBeat.m2505o(125702);
        return null;
    }
}
