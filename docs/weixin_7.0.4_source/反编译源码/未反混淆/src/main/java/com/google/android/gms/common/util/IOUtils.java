package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class IOUtils {

    static final class zzb {
        private final File file;

        private zzb(File file) {
            AppMethodBeat.i(90219);
            this.file = (File) Preconditions.checkNotNull(file);
            AppMethodBeat.o(90219);
        }

        /* synthetic */ zzb(File file, zzb zzb) {
            this(file);
        }

        public final byte[] zzdd() {
            Throwable th;
            AppMethodBeat.i(90220);
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(this.file);
                try {
                    byte[] zzb = IOUtils.zzb(fileInputStream, fileInputStream.getChannel().size());
                    IOUtils.closeQuietly(fileInputStream);
                    AppMethodBeat.o(90220);
                    return zzb;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(fileInputStream);
                    AppMethodBeat.o(90220);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                IOUtils.closeQuietly(fileInputStream);
                AppMethodBeat.o(90220);
                throw th;
            }
        }
    }

    static final class zza extends ByteArrayOutputStream {
        private zza() {
        }

        /* synthetic */ zza(zzb zzb) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void zza(byte[] bArr, int i) {
            AppMethodBeat.i(90218);
            System.arraycopy(this.buf, 0, bArr, i, this.count);
            AppMethodBeat.o(90218);
        }
    }

    private IOUtils() {
    }

    public static void close(@Nullable Closeable closeable, String str, String str2) {
        AppMethodBeat.i(90225);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(90225);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(90225);
    }

    public static void closeQuietly(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(90222);
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                AppMethodBeat.o(90222);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(90222);
    }

    public static void closeQuietly(@Nullable Closeable closeable) {
        AppMethodBeat.i(90221);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(90221);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(90221);
    }

    public static void closeQuietly(@Nullable ServerSocket serverSocket) {
        AppMethodBeat.i(90224);
        if (serverSocket != null) {
            try {
                serverSocket.close();
                AppMethodBeat.o(90224);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(90224);
    }

    public static void closeQuietly(@Nullable Socket socket) {
        AppMethodBeat.i(90223);
        if (socket != null) {
            try {
                socket.close();
                AppMethodBeat.o(90223);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(90223);
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(90226);
        long copyStream = copyStream(inputStream, outputStream, false);
        AppMethodBeat.o(90226);
        return copyStream;
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean z) {
        AppMethodBeat.i(90227);
        long copyStream = copyStream(inputStream, outputStream, z, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(90227);
        return copyStream;
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        AppMethodBeat.i(90228);
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    closeQuietly((Closeable) inputStream);
                    closeQuietly((Closeable) outputStream);
                }
                AppMethodBeat.o(90228);
            }
        }
        return j;
    }

    public static boolean isGzipByteBuffer(byte[] bArr) {
        return bArr.length > 1 && ((bArr[0] & 255) | ((bArr[1] & 255) << 8)) == 35615;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void lockAndTruncateFile(File file) {
        FileLock lock;
        Throwable th;
        AppMethodBeat.i(90233);
        if (file.exists()) {
            Closeable randomAccessFile;
            try {
                FileChannel channel;
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    channel = randomAccessFile.getChannel();
                    lock = channel.lock();
                } catch (Throwable th2) {
                    th = th2;
                    lock = null;
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (IOException e) {
                        }
                    }
                    if (randomAccessFile != null) {
                        closeQuietly(randomAccessFile);
                    }
                    AppMethodBeat.o(90233);
                    throw th;
                }
                try {
                    channel.truncate(0);
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (IOException e2) {
                        }
                    }
                    closeQuietly(randomAccessFile);
                    AppMethodBeat.o(90233);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    lock.release();
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(90233);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                lock = null;
                randomAccessFile = null;
                lock.release();
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(90233);
                throw th;
            }
        }
        FileNotFoundException fileNotFoundException = new FileNotFoundException();
        AppMethodBeat.o(90233);
        throw fileNotFoundException;
    }

    public static byte[] readInputStreamFully(InputStream inputStream) {
        AppMethodBeat.i(90229);
        byte[] readInputStreamFully = readInputStreamFully(inputStream, true);
        AppMethodBeat.o(90229);
        return readInputStreamFully;
    }

    public static byte[] readInputStreamFully(InputStream inputStream, boolean z) {
        AppMethodBeat.i(90230);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream, z);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(90230);
        return toByteArray;
    }

    public static byte[] toByteArray(File file) {
        AppMethodBeat.i(90231);
        byte[] zzdd = new zzb(file, null).zzdd();
        AppMethodBeat.o(90231);
        return zzdd;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        AppMethodBeat.i(90232);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zza(inputStream, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(90232);
        return toByteArray;
    }

    private static long zza(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(90235);
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                AppMethodBeat.o(90235);
                return j;
            }
        }
    }

    private static byte[] zza(InputStream inputStream, long j) {
        AppMethodBeat.i(90234);
        byte[] toByteArray;
        if (j > 2147483647L) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
            AppMethodBeat.o(90234);
            throw outOfMemoryError;
        } else if (j == 0) {
            toByteArray = toByteArray(inputStream);
            AppMethodBeat.o(90234);
            return toByteArray;
        } else {
            int i = (int) j;
            toByteArray = new byte[i];
            int i2 = i;
            while (i2 > 0) {
                int i3 = i - i2;
                int read = inputStream.read(toByteArray, i3, i2);
                if (read == -1) {
                    toByteArray = Arrays.copyOf(toByteArray, i3);
                    AppMethodBeat.o(90234);
                    return toByteArray;
                }
                i2 -= read;
            }
            i2 = inputStream.read();
            if (i2 == -1) {
                AppMethodBeat.o(90234);
                return toByteArray;
            }
            OutputStream zza = new zza();
            zza.write(i2);
            zza(inputStream, zza);
            toByteArray = Arrays.copyOf(toByteArray, zza.size() + i);
            zza.zza(toByteArray, i);
            AppMethodBeat.o(90234);
            return toByteArray;
        }
    }

    static /* synthetic */ byte[] zzb(InputStream inputStream, long j) {
        AppMethodBeat.i(90236);
        byte[] zza = zza(inputStream, j);
        AppMethodBeat.o(90236);
        return zza;
    }
}
