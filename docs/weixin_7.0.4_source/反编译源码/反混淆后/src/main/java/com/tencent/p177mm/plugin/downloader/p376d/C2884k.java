package com.tencent.p177mm.plugin.downloader.p376d;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.downloader.d.k */
public abstract class C2884k {
    /* renamed from: f */
    static Pair<ByteBuffer, Long> m5127f(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a = C2884k.m5122a(randomAccessFile, 0);
        return a == null ? C2884k.m5122a(randomAccessFile, CdnLogic.kBizGeneric) : a;
    }

    /* renamed from: a */
    private static Pair<ByteBuffer, Long> m5122a(RandomAccessFile randomAccessFile, int i) {
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
        int F = C2884k.m5118F(allocate);
        if (F == -1) {
            return null;
        }
        allocate.position(F);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(length + ((long) F)));
    }

    /* renamed from: F */
    private static int m5118F(ByteBuffer byteBuffer) {
        C2884k.m5121I(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int min = Math.min(capacity - 22, CdnLogic.kBizGeneric);
        int i = capacity - 22;
        int i2 = 0;
        while (i2 < min) {
            capacity = i - i2;
            if (byteBuffer.getInt(capacity) == 101010256 && C2884k.m5126f(byteBuffer, capacity + 20) == i2) {
                return capacity;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: c */
    public static final boolean m5125c(RandomAccessFile randomAccessFile, long j) {
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

    /* renamed from: G */
    public static long m5119G(ByteBuffer byteBuffer) {
        C2884k.m5121I(byteBuffer);
        return C2884k.m5128g(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: c */
    public static void m5124c(ByteBuffer byteBuffer, long j) {
        C2884k.m5121I(byteBuffer);
        C2884k.m5123b(byteBuffer, byteBuffer.position() + 16, j);
    }

    /* renamed from: H */
    public static long m5120H(ByteBuffer byteBuffer) {
        C2884k.m5121I(byteBuffer);
        return C2884k.m5128g(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: I */
    private static void m5121I(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* renamed from: f */
    public static int m5126f(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & CdnLogic.kBizGeneric;
    }

    /* renamed from: g */
    private static long m5128g(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    /* renamed from: b */
    private static void m5123b(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        byteBuffer.putInt(byteBuffer.position() + i, (int) j);
    }
}
