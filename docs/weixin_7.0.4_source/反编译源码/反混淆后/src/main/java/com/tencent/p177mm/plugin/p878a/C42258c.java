package com.tencent.p177mm.plugin.p878a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.a.c */
public final class C42258c {
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b A:{SYNTHETIC, Splitter:B:43:0x009b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vC */
    public static boolean m74643vC(String str) {
        Throwable e;
        AppMethodBeat.m2504i(117831);
        if (C42258c.isNullOrNil(str)) {
            AppMethodBeat.m2505o(117831);
            return false;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                if (fileInputStream.read(bArr, 0, 8) < 8) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(117831);
                    return false;
                }
                int readInt = C42258c.readInt(bArr, 0);
                if (C42258c.readInt(bArr, 4) != C37990a.aVH || readInt <= 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e22, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(117831);
                    return false;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e222) {
                    C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                }
                AppMethodBeat.m2505o(117831);
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            try {
                C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2222) {
                        C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(117831);
                return false;
            } catch (Throwable th) {
                e = th;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(117831);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(117831);
            throw e;
        }
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.m2504i(117832);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(117832);
            return true;
        }
        AppMethodBeat.m2505o(117832);
        return false;
    }

    /* renamed from: aT */
    public static int m74641aT(String str) {
        AppMethodBeat.m2504i(117833);
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i++;
            i2 = (i2 << 8) | str.charAt(i);
        }
        AppMethodBeat.m2505o(117833);
        return i2;
    }

    public static int readInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & 255) << 16) | ((bArr[i] & 255) << 24)) | ((bArr[i3] & 255) << 8)) | (bArr[i3 + 1] & 255);
    }

    /* renamed from: B */
    public static long m74638B(byte[] bArr, int i) {
        AppMethodBeat.m2504i(117834);
        byte[] bArr2 = new byte[8];
        Arrays.fill(bArr2, (byte) 0);
        System.arraycopy(bArr, i, bArr2, 4, 4);
        long af = C42258c.m74642af(bArr2);
        AppMethodBeat.m2505o(117834);
        return af;
    }

    /* renamed from: af */
    public static long m74642af(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    /* renamed from: a */
    public static C37990a m74639a(RandomAccessFile randomAccessFile, byte[] bArr, int i) {
        C37990a c45480i;
        AppMethodBeat.m2504i(117835);
        try {
            int read = randomAccessFile.read(bArr);
            while (read >= 8) {
                int readInt = C42258c.readInt(bArr, 0);
                int readInt2 = C42258c.readInt(bArr, 4);
                if (readInt2 != i) {
                    if (readInt2 != C37990a.aWi && readInt2 != C37990a.aWm) {
                        if (!C42258c.m74640a(randomAccessFile, (long) (readInt - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    long filePointer = randomAccessFile.getFilePointer() - ((long) read);
                    if (readInt2 == C37990a.aWk) {
                        c45480i = new C45480i(readInt, filePointer, readInt2);
                    } else if (readInt2 == C37990a.aWl) {
                        c45480i = new C26532e(readInt, filePointer, readInt2);
                    } else if (readInt2 == C37990a.aWn) {
                        c45480i = new C41215h(readInt, filePointer, readInt2);
                    } else {
                        c45480i = new C37990a(readInt, filePointer, readInt2, 0);
                    }
                    AppMethodBeat.m2505o(117835);
                    return c45480i;
                }
            }
            c45480i = null;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.AtomUtil", "find Atom error: " + e.toString());
            c45480i = null;
        }
        AppMethodBeat.m2505o(117835);
        return c45480i;
    }

    /* renamed from: a */
    public static boolean m74640a(RandomAccessFile randomAccessFile, long j) {
        AppMethodBeat.m2504i(117836);
        long j2 = 0;
        while (j > 2147483647L) {
            j2 += (long) randomAccessFile.skipBytes(BaseClientBuilder.API_PRIORITY_OTHER);
            j -= 2147483647L;
        }
        j2 += (long) randomAccessFile.skipBytes((int) j);
        if (j2 != j) {
            C4990ab.m7420w("MicroMsg.AtomUtil", "can not skip.skip: " + j + " trueSkip : " + j2);
            AppMethodBeat.m2505o(117836);
            return false;
        }
        AppMethodBeat.m2505o(117836);
        return true;
    }
}
