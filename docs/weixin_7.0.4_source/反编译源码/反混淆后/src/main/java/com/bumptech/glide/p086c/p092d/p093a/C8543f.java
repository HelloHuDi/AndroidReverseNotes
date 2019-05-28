package com.bumptech.glide.p086c.p092d.p093a;

import android.util.Log;
import com.bumptech.glide.p086c.C0776f;
import com.bumptech.glide.p086c.C0776f.C0777a;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.c.d.a.f */
public final class C8543f implements C0776f {
    static final byte[] aEW = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] aEX = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: com.bumptech.glide.c.d.a.f$a */
    static final class C8544a implements C8547c {
        private final ByteBuffer byteBuffer;

        C8544a(ByteBuffer byteBuffer) {
            AppMethodBeat.m2504i(92193);
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            AppMethodBeat.m2505o(92193);
        }

        /* renamed from: nn */
        public final int mo18644nn() {
            AppMethodBeat.m2504i(92194);
            int np = ((mo18646np() << 8) & 65280) | (mo18646np() & 255);
            AppMethodBeat.m2505o(92194);
            return np;
        }

        /* renamed from: no */
        public final short mo18645no() {
            AppMethodBeat.m2504i(92195);
            short np = (short) (mo18646np() & 255);
            AppMethodBeat.m2505o(92195);
            return np;
        }

        public final long skip(long j) {
            AppMethodBeat.m2504i(92196);
            int min = (int) Math.min((long) this.byteBuffer.remaining(), j);
            this.byteBuffer.position(this.byteBuffer.position() + min);
            long j2 = (long) min;
            AppMethodBeat.m2505o(92196);
            return j2;
        }

        public final int read(byte[] bArr, int i) {
            AppMethodBeat.m2504i(92197);
            int min = Math.min(i, this.byteBuffer.remaining());
            if (min == 0) {
                AppMethodBeat.m2505o(92197);
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            AppMethodBeat.m2505o(92197);
            return min;
        }

        /* renamed from: np */
        public final int mo18646np() {
            AppMethodBeat.m2504i(92198);
            if (this.byteBuffer.remaining() <= 0) {
                AppMethodBeat.m2505o(92198);
                return -1;
            }
            int i = this.byteBuffer.get();
            AppMethodBeat.m2505o(92198);
            return i;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.f$b */
    static final class C8545b {
        final ByteBuffer aEY;

        C8545b(byte[] bArr, int i) {
            AppMethodBeat.m2504i(92199);
            this.aEY = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
            AppMethodBeat.m2505o(92199);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dg */
        public final int mo18649dg(int i) {
            AppMethodBeat.m2504i(92200);
            if (m15183aS(i, 4)) {
                int i2 = this.aEY.getInt(i);
                AppMethodBeat.m2505o(92200);
                return i2;
            }
            AppMethodBeat.m2505o(92200);
            return -1;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dh */
        public final short mo18650dh(int i) {
            AppMethodBeat.m2504i(92201);
            if (m15183aS(i, 2)) {
                short s = this.aEY.getShort(i);
                AppMethodBeat.m2505o(92201);
                return s;
            }
            AppMethodBeat.m2505o(92201);
            return (short) -1;
        }

        /* renamed from: aS */
        private boolean m15183aS(int i, int i2) {
            AppMethodBeat.m2504i(92202);
            if (this.aEY.remaining() - i >= i2) {
                AppMethodBeat.m2505o(92202);
                return true;
            }
            AppMethodBeat.m2505o(92202);
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.f$d */
    static final class C8546d implements C8547c {
        private final InputStream aEZ;

        C8546d(InputStream inputStream) {
            this.aEZ = inputStream;
        }

        /* renamed from: nn */
        public final int mo18644nn() {
            AppMethodBeat.m2504i(92203);
            int read = ((this.aEZ.read() << 8) & 65280) | (this.aEZ.read() & 255);
            AppMethodBeat.m2505o(92203);
            return read;
        }

        /* renamed from: no */
        public final short mo18645no() {
            AppMethodBeat.m2504i(92204);
            short read = (short) (this.aEZ.read() & 255);
            AppMethodBeat.m2505o(92204);
            return read;
        }

        public final long skip(long j) {
            AppMethodBeat.m2504i(92205);
            if (j < 0) {
                AppMethodBeat.m2505o(92205);
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.aEZ.skip(j2);
                if (skip <= 0) {
                    if (this.aEZ.read() == -1) {
                        break;
                    }
                    j2--;
                } else {
                    j2 -= skip;
                }
            }
            long j3 = j - j2;
            AppMethodBeat.m2505o(92205);
            return j3;
        }

        public final int read(byte[] bArr, int i) {
            AppMethodBeat.m2504i(92206);
            int i2 = i;
            while (i2 > 0) {
                int read = this.aEZ.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            i2 = i - i2;
            AppMethodBeat.m2505o(92206);
            return i2;
        }

        /* renamed from: np */
        public final int mo18646np() {
            AppMethodBeat.m2504i(92207);
            int read = this.aEZ.read();
            AppMethodBeat.m2505o(92207);
            return read;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.f$c */
    interface C8547c {
        /* renamed from: nn */
        int mo18644nn();

        /* renamed from: no */
        short mo18645no();

        /* renamed from: np */
        int mo18646np();

        int read(byte[] bArr, int i);

        long skip(long j);
    }

    static {
        AppMethodBeat.m2504i(92214);
        AppMethodBeat.m2505o(92214);
    }

    /* renamed from: c */
    public final C0777a mo2241c(InputStream inputStream) {
        AppMethodBeat.m2504i(92208);
        C0777a a = C8543f.m15175a(new C8546d((InputStream) C8561i.m15217d(inputStream, "Argument must not be null")));
        AppMethodBeat.m2505o(92208);
        return a;
    }

    /* renamed from: b */
    public final C0777a mo2240b(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(92209);
        C0777a a = C8543f.m15175a(new C8544a((ByteBuffer) C8561i.m15217d(byteBuffer, "Argument must not be null")));
        AppMethodBeat.m2505o(92209);
        return a;
    }

    /* renamed from: a */
    public final int mo2239a(InputStream inputStream, C8515b c8515b) {
        AppMethodBeat.m2504i(92210);
        int a = C8543f.m15174a(new C8546d((InputStream) C8561i.m15217d(inputStream, "Argument must not be null")), (C8515b) C8561i.m15217d(c8515b, "Argument must not be null"));
        AppMethodBeat.m2505o(92210);
        return a;
    }

    /* renamed from: a */
    private static C0777a m15175a(C8547c c8547c) {
        AppMethodBeat.m2504i(92211);
        int nn = c8547c.mo18644nn();
        C0777a c0777a;
        if (nn == 65496) {
            c0777a = C0777a.JPEG;
            AppMethodBeat.m2505o(92211);
            return c0777a;
        }
        nn = ((nn << 16) & -65536) | (c8547c.mo18644nn() & CdnLogic.kBizGeneric);
        if (nn == -1991225785) {
            c8547c.skip(21);
            if (c8547c.mo18646np() >= 3) {
                c0777a = C0777a.PNG_A;
                AppMethodBeat.m2505o(92211);
                return c0777a;
            }
            c0777a = C0777a.PNG;
            AppMethodBeat.m2505o(92211);
            return c0777a;
        } else if ((nn >> 8) == 4671814) {
            c0777a = C0777a.GIF;
            AppMethodBeat.m2505o(92211);
            return c0777a;
        } else if (nn != 1380533830) {
            c0777a = C0777a.UNKNOWN;
            AppMethodBeat.m2505o(92211);
            return c0777a;
        } else {
            c8547c.skip(4);
            if ((((c8547c.mo18644nn() << 16) & -65536) | (c8547c.mo18644nn() & CdnLogic.kBizGeneric)) != 1464156752) {
                c0777a = C0777a.UNKNOWN;
                AppMethodBeat.m2505o(92211);
                return c0777a;
            }
            nn = ((c8547c.mo18644nn() << 16) & -65536) | (c8547c.mo18644nn() & CdnLogic.kBizGeneric);
            if ((nn & -256) != 1448097792) {
                c0777a = C0777a.UNKNOWN;
                AppMethodBeat.m2505o(92211);
                return c0777a;
            } else if ((nn & 255) == 88) {
                c8547c.skip(4);
                if ((c8547c.mo18646np() & 16) != 0) {
                    c0777a = C0777a.WEBP_A;
                    AppMethodBeat.m2505o(92211);
                    return c0777a;
                }
                c0777a = C0777a.WEBP;
                AppMethodBeat.m2505o(92211);
                return c0777a;
            } else if ((nn & 255) == 76) {
                c8547c.skip(4);
                if ((c8547c.mo18646np() & 8) != 0) {
                    c0777a = C0777a.WEBP_A;
                    AppMethodBeat.m2505o(92211);
                    return c0777a;
                }
                c0777a = C0777a.WEBP;
                AppMethodBeat.m2505o(92211);
                return c0777a;
            } else {
                c0777a = C0777a.WEBP;
                AppMethodBeat.m2505o(92211);
                return c0777a;
            }
        }
    }

    /* renamed from: a */
    private static int m15174a(C8547c c8547c, C8515b c8515b) {
        Object obj;
        int i = -1;
        AppMethodBeat.m2504i(92212);
        int nn = c8547c.mo18644nn();
        if ((nn & 65496) == 65496 || nn == 19789 || nn == 18761) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            AppMethodBeat.m2505o(92212);
        } else {
            int i2;
            while (c8547c.mo18645no() == (short) 255) {
                short no = c8547c.mo18645no();
                if (no != (short) 218) {
                    if (no != (short) 217) {
                        nn = c8547c.mo18644nn() - 2;
                        if (no == (short) 225) {
                            i2 = nn;
                            break;
                        }
                        long skip = c8547c.skip((long) nn);
                        if (skip != ((long) nn)) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                new StringBuilder("Unable to skip enough data, type: ").append(no).append(", wanted to skip: ").append(nn).append(", but actually skipped: ").append(skip);
                            }
                            i2 = -1;
                        }
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        i2 = -1;
                        break;
                    }
                }
                i2 = -1;
                break;
            }
            Log.isLoggable("DfltImageHeaderParser", 3);
            i2 = -1;
            if (i2 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                AppMethodBeat.m2505o(92212);
            } else {
                byte[] bArr = (byte[]) c8515b.mo18608a(i2, byte[].class);
                try {
                    int read = c8547c.read(bArr, i2);
                    if (read != i2) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Unable to read exif segment data, length: ").append(i2).append(", actually read: ").append(read);
                        }
                    } else if (C8543f.m15176c(bArr, i2)) {
                        i = C8543f.m15173a(new C8545b(bArr, i2));
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    }
                    c8515b.put(bArr);
                    AppMethodBeat.m2505o(92212);
                } catch (Throwable th) {
                    c8515b.put(bArr);
                    AppMethodBeat.m2505o(92212);
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    private static boolean m15176c(byte[] bArr, int i) {
        boolean z = bArr != null && i > aEW.length;
        if (z) {
            for (int i2 = 0; i2 < aEW.length; i2++) {
                if (bArr[i2] != aEW[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static int m15173a(C8545b c8545b) {
        ByteOrder byteOrder;
        AppMethodBeat.m2504i(92213);
        switch (c8545b.mo18650dh(6)) {
            case (short) 18761:
                byteOrder = ByteOrder.LITTLE_ENDIAN;
                break;
            case (short) 19789:
                byteOrder = ByteOrder.BIG_ENDIAN;
                break;
            default:
                Log.isLoggable("DfltImageHeaderParser", 3);
                byteOrder = ByteOrder.BIG_ENDIAN;
                break;
        }
        c8545b.aEY.order(byteOrder);
        int dg = c8545b.mo18649dg(10) + 6;
        short dh = c8545b.mo18650dh(dg);
        for (short s = (short) 0; s < dh; s++) {
            int i = (dg + 2) + (s * 12);
            short dh2 = c8545b.mo18650dh(i);
            if (dh2 == (short) 274) {
                short dh3 = c8545b.mo18650dh(i + 2);
                if (dh3 > (short) 0 && dh3 <= (short) 12) {
                    int dg2 = c8545b.mo18649dg(i + 4);
                    if (dg2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Got tagIndex=").append(s).append(" tagType=").append(dh2).append(" formatCode=").append(dh3).append(" componentCount=").append(dg2);
                        }
                        int i2 = aEX[dh3] + dg2;
                        if (i2 <= 4) {
                            i += 8;
                            if (i < 0 || i > c8545b.aEY.remaining()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    new StringBuilder("Illegal tagValueOffset=").append(i).append(" tagType=").append(dh2);
                                }
                            } else if (i2 >= 0 && i + i2 <= c8545b.aEY.remaining()) {
                                s = c8545b.mo18650dh(i);
                                AppMethodBeat.m2505o(92213);
                                return s;
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                }
            }
        }
        AppMethodBeat.m2505o(92213);
        return -1;
    }
}
