package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b {

    public static class b extends Exception {
        public b(String str) {
            super(str);
        }
    }

    static class a {
        private final ByteBuffer kLY;
        private final long kLZ;
        private final long kMa;
        private final long kMb;
        private final ByteBuffer kMc;

        /* synthetic */ a(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2, byte b) {
            this(byteBuffer, j, j2, j3, byteBuffer2);
        }

        private a(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            this.kLY = byteBuffer;
            this.kLZ = j;
            this.kMa = j2;
            this.kMb = j3;
            this.kMc = byteBuffer2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Ik(String str) {
        Throwable th;
        AppMethodBeat.i(2302);
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                Pair e = e(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) e.first;
                long longValue = ((Long) e.second).longValue();
                if (k.c(randomAccessFile2, longValue)) {
                    b bVar = new b("ZIP64 APK not supported");
                    AppMethodBeat.o(2302);
                    throw bVar;
                }
                long b = b(byteBuffer, longValue);
                Pair b2 = b(randomAccessFile2, b);
                ByteBuffer byteBuffer2 = (ByteBuffer) b2.first;
                a aVar = new a(C(byteBuffer2), ((Long) b2.second).longValue(), b, longValue, byteBuffer, (byte) 0);
                randomAccessFile2.close();
                AppMethodBeat.o(2302);
                return true;
            } catch (b e2) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(2302);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                }
                AppMethodBeat.o(2302);
                throw th;
            }
        } catch (b e3) {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            AppMethodBeat.o(2302);
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            AppMethodBeat.o(2302);
            throw th;
        }
    }

    public static Pair<ByteBuffer, Long> e(RandomAccessFile randomAccessFile) {
        AppMethodBeat.i(2303);
        Pair f = k.f(randomAccessFile);
        if (f == null) {
            b bVar = new b("Not an APK file: ZIP End of Central Directory record not found");
            AppMethodBeat.o(2303);
            throw bVar;
        }
        AppMethodBeat.o(2303);
        return f;
    }

    public static long b(ByteBuffer byteBuffer, long j) {
        AppMethodBeat.i(2304);
        long G = k.G(byteBuffer);
        if (G >= j) {
            b bVar = new b("ZIP Central Directory offset out of range: " + G + ". ZIP End of Central Directory offset: " + j);
            AppMethodBeat.o(2304);
            throw bVar;
        } else if (k.H(byteBuffer) + G != j) {
            b bVar2 = new b("ZIP Central Directory is not immediately followed by End of Central Directory");
            AppMethodBeat.o(2304);
            throw bVar2;
        } else {
            AppMethodBeat.o(2304);
            return G;
        }
    }

    public static ByteBuffer d(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(2305);
        if (i < 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("end < start: " + i + " < 8");
            AppMethodBeat.o(2305);
            throw illegalArgumentException;
        }
        int capacity = byteBuffer.capacity();
        if (i > byteBuffer.capacity()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
            AppMethodBeat.o(2305);
            throw illegalArgumentException2;
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
            AppMethodBeat.o(2305);
        }
    }

    public static ByteBuffer e(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(2306);
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("size: ".concat(String.valueOf(i)));
            AppMethodBeat.o(2306);
            throw illegalArgumentException;
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = position + i;
        if (i2 < position || i2 > limit) {
            BufferUnderflowException bufferUnderflowException = new BufferUnderflowException();
            AppMethodBeat.o(2306);
            throw bufferUnderflowException;
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
            AppMethodBeat.o(2306);
        }
    }

    public static Pair<ByteBuffer, Long> b(RandomAccessFile randomAccessFile, long j) {
        AppMethodBeat.i(2307);
        b bVar;
        if (j < 32) {
            bVar = new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
            AppMethodBeat.o(2307);
            throw bVar;
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) allocate.capacity()));
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
            long j2 = allocate.getLong(0);
            if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                bVar = new b("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                AppMethodBeat.o(2307);
                throw bVar;
            }
            int i = (int) (8 + j2);
            long j3 = j - ((long) i);
            if (j3 < 0) {
                bVar = new b("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
                AppMethodBeat.o(2307);
                throw bVar;
            }
            allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            long j4 = allocate.getLong(0);
            if (j4 != j2) {
                bVar = new b("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                AppMethodBeat.o(2307);
                throw bVar;
            }
            Pair create = Pair.create(allocate, Long.valueOf(j3));
            AppMethodBeat.o(2307);
            return create;
        }
        bVar = new b("No APK Signing Block before ZIP Central Directory");
        AppMethodBeat.o(2307);
        throw bVar;
    }

    private static ByteBuffer C(ByteBuffer byteBuffer) {
        AppMethodBeat.i(2308);
        D(byteBuffer);
        ByteBuffer d = d(byteBuffer, byteBuffer.capacity() - 24);
        int i = 0;
        while (d.hasRemaining()) {
            i++;
            b bVar;
            if (d.remaining() < 8) {
                bVar = new b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
                AppMethodBeat.o(2308);
                throw bVar;
            }
            long j = d.getLong();
            if (j < 4 || j > 2147483647L) {
                bVar = new b("APK Signing Block entry #" + i + " size out of range: " + j);
                AppMethodBeat.o(2308);
                throw bVar;
            }
            int i2 = (int) j;
            int position = d.position() + i2;
            if (i2 > d.remaining()) {
                b bVar2 = new b("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + d.remaining());
                AppMethodBeat.o(2308);
                throw bVar2;
            } else if (d.getInt() == 1896449818) {
                ByteBuffer e = e(d, i2 - 4);
                AppMethodBeat.o(2308);
                return e;
            } else {
                d.position(position);
            }
        }
        b bVar3 = new b("No APK Signature Scheme v2 block in APK Signing Block");
        AppMethodBeat.o(2308);
        throw bVar3;
    }

    public static void D(ByteBuffer byteBuffer) {
        AppMethodBeat.i(2309);
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer byte order must be little endian");
            AppMethodBeat.o(2309);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(2309);
    }
}
