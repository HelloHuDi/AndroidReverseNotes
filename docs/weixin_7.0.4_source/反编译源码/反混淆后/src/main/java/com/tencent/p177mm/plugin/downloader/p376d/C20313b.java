package com.tencent.p177mm.plugin.downloader.p376d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.downloader.d.b */
public final class C20313b {

    /* renamed from: com.tencent.mm.plugin.downloader.d.b$b */
    public static class C20314b extends Exception {
        public C20314b(String str) {
            super(str);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.d.b$a */
    static class C20315a {
        private final ByteBuffer kLY;
        private final long kLZ;
        private final long kMa;
        private final long kMb;
        private final ByteBuffer kMc;

        /* synthetic */ C20315a(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2, byte b) {
            this(byteBuffer, j, j2, j3, byteBuffer2);
        }

        private C20315a(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
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
    /* renamed from: Ik */
    public static boolean m31417Ik(String str) {
        Throwable th;
        AppMethodBeat.m2504i(2302);
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                Pair e = C20313b.m31421e(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) e.first;
                long longValue = ((Long) e.second).longValue();
                if (C2884k.m5125c(randomAccessFile2, longValue)) {
                    C20314b c20314b = new C20314b("ZIP64 APK not supported");
                    AppMethodBeat.m2505o(2302);
                    throw c20314b;
                }
                long b = C20313b.m31418b(byteBuffer, longValue);
                Pair b2 = C20313b.m31419b(randomAccessFile2, b);
                ByteBuffer byteBuffer2 = (ByteBuffer) b2.first;
                C20315a c20315a = new C20315a(C20313b.m31415C(byteBuffer2), ((Long) b2.second).longValue(), b, longValue, byteBuffer, (byte) 0);
                randomAccessFile2.close();
                AppMethodBeat.m2505o(2302);
                return true;
            } catch (C20314b e2) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(2302);
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                }
                AppMethodBeat.m2505o(2302);
                throw th;
            }
        } catch (C20314b e3) {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            AppMethodBeat.m2505o(2302);
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            AppMethodBeat.m2505o(2302);
            throw th;
        }
    }

    /* renamed from: e */
    public static Pair<ByteBuffer, Long> m31421e(RandomAccessFile randomAccessFile) {
        AppMethodBeat.m2504i(2303);
        Pair f = C2884k.m5127f(randomAccessFile);
        if (f == null) {
            C20314b c20314b = new C20314b("Not an APK file: ZIP End of Central Directory record not found");
            AppMethodBeat.m2505o(2303);
            throw c20314b;
        }
        AppMethodBeat.m2505o(2303);
        return f;
    }

    /* renamed from: b */
    public static long m31418b(ByteBuffer byteBuffer, long j) {
        AppMethodBeat.m2504i(2304);
        long G = C2884k.m5119G(byteBuffer);
        if (G >= j) {
            C20314b c20314b = new C20314b("ZIP Central Directory offset out of range: " + G + ". ZIP End of Central Directory offset: " + j);
            AppMethodBeat.m2505o(2304);
            throw c20314b;
        } else if (C2884k.m5120H(byteBuffer) + G != j) {
            C20314b c20314b2 = new C20314b("ZIP Central Directory is not immediately followed by End of Central Directory");
            AppMethodBeat.m2505o(2304);
            throw c20314b2;
        } else {
            AppMethodBeat.m2505o(2304);
            return G;
        }
    }

    /* renamed from: d */
    public static ByteBuffer m31420d(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(2305);
        if (i < 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("end < start: " + i + " < 8");
            AppMethodBeat.m2505o(2305);
            throw illegalArgumentException;
        }
        int capacity = byteBuffer.capacity();
        if (i > byteBuffer.capacity()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
            AppMethodBeat.m2505o(2305);
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
            AppMethodBeat.m2505o(2305);
        }
    }

    /* renamed from: e */
    public static ByteBuffer m31422e(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(2306);
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("size: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(2306);
            throw illegalArgumentException;
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = position + i;
        if (i2 < position || i2 > limit) {
            BufferUnderflowException bufferUnderflowException = new BufferUnderflowException();
            AppMethodBeat.m2505o(2306);
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
            AppMethodBeat.m2505o(2306);
        }
    }

    /* renamed from: b */
    public static Pair<ByteBuffer, Long> m31419b(RandomAccessFile randomAccessFile, long j) {
        AppMethodBeat.m2504i(2307);
        C20314b c20314b;
        if (j < 32) {
            c20314b = new C20314b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(2307);
            throw c20314b;
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) allocate.capacity()));
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
            long j2 = allocate.getLong(0);
            if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                c20314b = new C20314b("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                AppMethodBeat.m2505o(2307);
                throw c20314b;
            }
            int i = (int) (8 + j2);
            long j3 = j - ((long) i);
            if (j3 < 0) {
                c20314b = new C20314b("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
                AppMethodBeat.m2505o(2307);
                throw c20314b;
            }
            allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            long j4 = allocate.getLong(0);
            if (j4 != j2) {
                c20314b = new C20314b("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                AppMethodBeat.m2505o(2307);
                throw c20314b;
            }
            Pair create = Pair.create(allocate, Long.valueOf(j3));
            AppMethodBeat.m2505o(2307);
            return create;
        }
        c20314b = new C20314b("No APK Signing Block before ZIP Central Directory");
        AppMethodBeat.m2505o(2307);
        throw c20314b;
    }

    /* renamed from: C */
    private static ByteBuffer m31415C(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(2308);
        C20313b.m31416D(byteBuffer);
        ByteBuffer d = C20313b.m31420d(byteBuffer, byteBuffer.capacity() - 24);
        int i = 0;
        while (d.hasRemaining()) {
            i++;
            C20314b c20314b;
            if (d.remaining() < 8) {
                c20314b = new C20314b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(2308);
                throw c20314b;
            }
            long j = d.getLong();
            if (j < 4 || j > 2147483647L) {
                c20314b = new C20314b("APK Signing Block entry #" + i + " size out of range: " + j);
                AppMethodBeat.m2505o(2308);
                throw c20314b;
            }
            int i2 = (int) j;
            int position = d.position() + i2;
            if (i2 > d.remaining()) {
                C20314b c20314b2 = new C20314b("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + d.remaining());
                AppMethodBeat.m2505o(2308);
                throw c20314b2;
            } else if (d.getInt() == 1896449818) {
                ByteBuffer e = C20313b.m31422e(d, i2 - 4);
                AppMethodBeat.m2505o(2308);
                return e;
            } else {
                d.position(position);
            }
        }
        C20314b c20314b3 = new C20314b("No APK Signature Scheme v2 block in APK Signing Block");
        AppMethodBeat.m2505o(2308);
        throw c20314b3;
    }

    /* renamed from: D */
    public static void m31416D(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(2309);
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer byte order must be little endian");
            AppMethodBeat.m2505o(2309);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(2309);
    }
}
