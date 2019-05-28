package com.tencent.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class f {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String ag(File file) {
        Throwable th;
        AppMethodBeat.i(114614);
        String str = "";
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                str = bufferedReader.readLine();
                if (str != null) {
                    closeQuietly(bufferedReader);
                    AppMethodBeat.o(114614);
                    return str;
                }
                closeQuietly(bufferedReader);
                AppMethodBeat.o(114614);
                return str;
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedReader;
                if (closeable != null) {
                    closeQuietly(closeable);
                }
                AppMethodBeat.o(114614);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (closeable != null) {
            }
            AppMethodBeat.o(114614);
            throw th;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(114615);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                AppMethodBeat.o(114615);
                return;
            }
        }
        AppMethodBeat.o(114615);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A:{SYNTHETIC, Splitter:B:13:0x002e} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A:{SYNTHETIC, Splitter:B:25:0x0046} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] ah(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        AppMethodBeat.i(114616);
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        try {
            randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile2.length();
                int i = (int) length;
                if (((long) i) != length) {
                    IOException iOException = new IOException("");
                    AppMethodBeat.o(114616);
                    throw iOException;
                }
                bArr = new byte[i];
                randomAccessFile2.readFully(bArr);
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                }
                AppMethodBeat.o(114616);
                return bArr;
            } catch (Throwable th2) {
                try {
                    bArr = new byte[0];
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.o(114616);
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.o(114616);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(114616);
            throw th;
        }
    }
}
