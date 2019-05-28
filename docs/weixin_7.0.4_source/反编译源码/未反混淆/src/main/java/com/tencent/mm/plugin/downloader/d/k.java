package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class k {
    static Pair<ByteBuffer, Long> f(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a = a(randomAccessFile, 0);
        return a == null ? a(randomAccessFile, CdnLogic.kBizGeneric) : a;
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i) {
        if (i < 0 || i > CdnLogic.kBizGeneric) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        length -= (long) allocate.capacity();
        randomAccessFile.seek(length);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int F = F(allocate);
        if (F == -1) {
            return null;
        }
        allocate.position(F);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(length + ((long) F)));
    }

    private static int F(ByteBuffer byteBuffer) {
        I(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int min = Math.min(capacity - 22, CdnLogic.kBizGeneric);
        int i = capacity - 22;
        int i2 = 0;
        while (i2 < min) {
            capacity = i - i2;
            if (byteBuffer.getInt(capacity) == 101010256 && f(byteBuffer, capacity + 20) == i2) {
                return capacity;
            }
            i2++;
        }
        return -1;
    }

    public static final boolean c(RandomAccessFile randomAccessFile, long j) {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        if (randomAccessFile.readInt() == 1347094023) {
            return true;
        }
        return false;
    }

    public static long G(ByteBuffer byteBuffer) {
        I(byteBuffer);
        return g(byteBuffer, byteBuffer.position() + 16);
    }

    public static void c(ByteBuffer byteBuffer, long j) {
        I(byteBuffer);
        b(byteBuffer, byteBuffer.position() + 16, j);
    }

    public static long H(ByteBuffer byteBuffer) {
        I(byteBuffer);
        return g(byteBuffer, byteBuffer.position() + 12);
    }

    private static void I(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int f(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & CdnLogic.kBizGeneric;
    }

    private static long g(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static void b(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        byteBuffer.putInt(byteBuffer.position() + i, (int) j);
    }
}
