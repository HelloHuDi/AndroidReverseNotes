package com.tencent.mm.plugin.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b A:{SYNTHETIC, Splitter:B:43:0x009b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean vC(String str) {
        Throwable e;
        AppMethodBeat.i(117831);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(117831);
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
                        ab.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
                    }
                    AppMethodBeat.o(117831);
                    return false;
                }
                int readInt = readInt(bArr, 0);
                if (readInt(bArr, 4) != a.aVH || readInt <= 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.AtomUtil", e22, "", new Object[0]);
                    }
                    AppMethodBeat.o(117831);
                    return false;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e222) {
                    ab.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                }
                AppMethodBeat.o(117831);
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            try {
                ab.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2222) {
                        ab.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(117831);
                return false;
            } catch (Throwable th) {
                e = th;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(117831);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    ab.printErrStackTrace("MicroMsg.AtomUtil", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(117831);
            throw e;
        }
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(117832);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(117832);
            return true;
        }
        AppMethodBeat.o(117832);
        return false;
    }

    public static int aT(String str) {
        AppMethodBeat.i(117833);
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i++;
            i2 = (i2 << 8) | str.charAt(i);
        }
        AppMethodBeat.o(117833);
        return i2;
    }

    public static int readInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & 255) << 16) | ((bArr[i] & 255) << 24)) | ((bArr[i3] & 255) << 8)) | (bArr[i3 + 1] & 255);
    }

    public static long B(byte[] bArr, int i) {
        AppMethodBeat.i(117834);
        byte[] bArr2 = new byte[8];
        Arrays.fill(bArr2, (byte) 0);
        System.arraycopy(bArr, i, bArr2, 4, 4);
        long af = af(bArr2);
        AppMethodBeat.o(117834);
        return af;
    }

    public static long af(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    public static a a(RandomAccessFile randomAccessFile, byte[] bArr, int i) {
        a iVar;
        AppMethodBeat.i(117835);
        try {
            int read = randomAccessFile.read(bArr);
            while (read >= 8) {
                int readInt = readInt(bArr, 0);
                int readInt2 = readInt(bArr, 4);
                if (readInt2 != i) {
                    if (readInt2 != a.aWi && readInt2 != a.aWm) {
                        if (!a(randomAccessFile, (long) (readInt - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    long filePointer = randomAccessFile.getFilePointer() - ((long) read);
                    if (readInt2 == a.aWk) {
                        iVar = new i(readInt, filePointer, readInt2);
                    } else if (readInt2 == a.aWl) {
                        iVar = new e(readInt, filePointer, readInt2);
                    } else if (readInt2 == a.aWn) {
                        iVar = new h(readInt, filePointer, readInt2);
                    } else {
                        iVar = new a(readInt, filePointer, readInt2, 0);
                    }
                    AppMethodBeat.o(117835);
                    return iVar;
                }
            }
            iVar = null;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
            ab.e("MicroMsg.AtomUtil", "find Atom error: " + e.toString());
            iVar = null;
        }
        AppMethodBeat.o(117835);
        return iVar;
    }

    public static boolean a(RandomAccessFile randomAccessFile, long j) {
        AppMethodBeat.i(117836);
        long j2 = 0;
        while (j > 2147483647L) {
            j2 += (long) randomAccessFile.skipBytes(BaseClientBuilder.API_PRIORITY_OTHER);
            j -= 2147483647L;
        }
        j2 += (long) randomAccessFile.skipBytes((int) j);
        if (j2 != j) {
            ab.w("MicroMsg.AtomUtil", "can not skip.skip: " + j + " trueSkip : " + j2);
            AppMethodBeat.o(117836);
            return false;
        }
        AppMethodBeat.o(117836);
        return true;
    }
}
