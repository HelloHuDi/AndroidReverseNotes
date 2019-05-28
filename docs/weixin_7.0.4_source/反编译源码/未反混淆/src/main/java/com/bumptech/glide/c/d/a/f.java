package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.bumptech.glide.h.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class f implements com.bumptech.glide.c.f {
    static final byte[] aEW = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] aEX = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    static final class a implements c {
        private final ByteBuffer byteBuffer;

        a(ByteBuffer byteBuffer) {
            AppMethodBeat.i(92193);
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            AppMethodBeat.o(92193);
        }

        public final int nn() {
            AppMethodBeat.i(92194);
            int np = ((np() << 8) & 65280) | (np() & 255);
            AppMethodBeat.o(92194);
            return np;
        }

        public final short no() {
            AppMethodBeat.i(92195);
            short np = (short) (np() & 255);
            AppMethodBeat.o(92195);
            return np;
        }

        public final long skip(long j) {
            AppMethodBeat.i(92196);
            int min = (int) Math.min((long) this.byteBuffer.remaining(), j);
            this.byteBuffer.position(this.byteBuffer.position() + min);
            long j2 = (long) min;
            AppMethodBeat.o(92196);
            return j2;
        }

        public final int read(byte[] bArr, int i) {
            AppMethodBeat.i(92197);
            int min = Math.min(i, this.byteBuffer.remaining());
            if (min == 0) {
                AppMethodBeat.o(92197);
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            AppMethodBeat.o(92197);
            return min;
        }

        public final int np() {
            AppMethodBeat.i(92198);
            if (this.byteBuffer.remaining() <= 0) {
                AppMethodBeat.o(92198);
                return -1;
            }
            int i = this.byteBuffer.get();
            AppMethodBeat.o(92198);
            return i;
        }
    }

    static final class b {
        final ByteBuffer aEY;

        b(byte[] bArr, int i) {
            AppMethodBeat.i(92199);
            this.aEY = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
            AppMethodBeat.o(92199);
        }

        /* Access modifiers changed, original: final */
        public final int dg(int i) {
            AppMethodBeat.i(92200);
            if (aS(i, 4)) {
                int i2 = this.aEY.getInt(i);
                AppMethodBeat.o(92200);
                return i2;
            }
            AppMethodBeat.o(92200);
            return -1;
        }

        /* Access modifiers changed, original: final */
        public final short dh(int i) {
            AppMethodBeat.i(92201);
            if (aS(i, 2)) {
                short s = this.aEY.getShort(i);
                AppMethodBeat.o(92201);
                return s;
            }
            AppMethodBeat.o(92201);
            return (short) -1;
        }

        private boolean aS(int i, int i2) {
            AppMethodBeat.i(92202);
            if (this.aEY.remaining() - i >= i2) {
                AppMethodBeat.o(92202);
                return true;
            }
            AppMethodBeat.o(92202);
            return false;
        }
    }

    static final class d implements c {
        private final InputStream aEZ;

        d(InputStream inputStream) {
            this.aEZ = inputStream;
        }

        public final int nn() {
            AppMethodBeat.i(92203);
            int read = ((this.aEZ.read() << 8) & 65280) | (this.aEZ.read() & 255);
            AppMethodBeat.o(92203);
            return read;
        }

        public final short no() {
            AppMethodBeat.i(92204);
            short read = (short) (this.aEZ.read() & 255);
            AppMethodBeat.o(92204);
            return read;
        }

        public final long skip(long j) {
            AppMethodBeat.i(92205);
            if (j < 0) {
                AppMethodBeat.o(92205);
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
            AppMethodBeat.o(92205);
            return j3;
        }

        public final int read(byte[] bArr, int i) {
            AppMethodBeat.i(92206);
            int i2 = i;
            while (i2 > 0) {
                int read = this.aEZ.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            i2 = i - i2;
            AppMethodBeat.o(92206);
            return i2;
        }

        public final int np() {
            AppMethodBeat.i(92207);
            int read = this.aEZ.read();
            AppMethodBeat.o(92207);
            return read;
        }
    }

    interface c {
        int nn();

        short no();

        int np();

        int read(byte[] bArr, int i);

        long skip(long j);
    }

    static {
        AppMethodBeat.i(92214);
        AppMethodBeat.o(92214);
    }

    public final com.bumptech.glide.c.f.a c(InputStream inputStream) {
        AppMethodBeat.i(92208);
        com.bumptech.glide.c.f.a a = a(new d((InputStream) i.d(inputStream, "Argument must not be null")));
        AppMethodBeat.o(92208);
        return a;
    }

    public final com.bumptech.glide.c.f.a b(ByteBuffer byteBuffer) {
        AppMethodBeat.i(92209);
        com.bumptech.glide.c.f.a a = a(new a((ByteBuffer) i.d(byteBuffer, "Argument must not be null")));
        AppMethodBeat.o(92209);
        return a;
    }

    public final int a(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        AppMethodBeat.i(92210);
        int a = a(new d((InputStream) i.d(inputStream, "Argument must not be null")), (com.bumptech.glide.c.b.a.b) i.d(bVar, "Argument must not be null"));
        AppMethodBeat.o(92210);
        return a;
    }

    private static com.bumptech.glide.c.f.a a(c cVar) {
        AppMethodBeat.i(92211);
        int nn = cVar.nn();
        com.bumptech.glide.c.f.a aVar;
        if (nn == 65496) {
            aVar = com.bumptech.glide.c.f.a.JPEG;
            AppMethodBeat.o(92211);
            return aVar;
        }
        nn = ((nn << 16) & -65536) | (cVar.nn() & CdnLogic.kBizGeneric);
        if (nn == -1991225785) {
            cVar.skip(21);
            if (cVar.np() >= 3) {
                aVar = com.bumptech.glide.c.f.a.PNG_A;
                AppMethodBeat.o(92211);
                return aVar;
            }
            aVar = com.bumptech.glide.c.f.a.PNG;
            AppMethodBeat.o(92211);
            return aVar;
        } else if ((nn >> 8) == 4671814) {
            aVar = com.bumptech.glide.c.f.a.GIF;
            AppMethodBeat.o(92211);
            return aVar;
        } else if (nn != 1380533830) {
            aVar = com.bumptech.glide.c.f.a.UNKNOWN;
            AppMethodBeat.o(92211);
            return aVar;
        } else {
            cVar.skip(4);
            if ((((cVar.nn() << 16) & -65536) | (cVar.nn() & CdnLogic.kBizGeneric)) != 1464156752) {
                aVar = com.bumptech.glide.c.f.a.UNKNOWN;
                AppMethodBeat.o(92211);
                return aVar;
            }
            nn = ((cVar.nn() << 16) & -65536) | (cVar.nn() & CdnLogic.kBizGeneric);
            if ((nn & -256) != 1448097792) {
                aVar = com.bumptech.glide.c.f.a.UNKNOWN;
                AppMethodBeat.o(92211);
                return aVar;
            } else if ((nn & 255) == 88) {
                cVar.skip(4);
                if ((cVar.np() & 16) != 0) {
                    aVar = com.bumptech.glide.c.f.a.WEBP_A;
                    AppMethodBeat.o(92211);
                    return aVar;
                }
                aVar = com.bumptech.glide.c.f.a.WEBP;
                AppMethodBeat.o(92211);
                return aVar;
            } else if ((nn & 255) == 76) {
                cVar.skip(4);
                if ((cVar.np() & 8) != 0) {
                    aVar = com.bumptech.glide.c.f.a.WEBP_A;
                    AppMethodBeat.o(92211);
                    return aVar;
                }
                aVar = com.bumptech.glide.c.f.a.WEBP;
                AppMethodBeat.o(92211);
                return aVar;
            } else {
                aVar = com.bumptech.glide.c.f.a.WEBP;
                AppMethodBeat.o(92211);
                return aVar;
            }
        }
    }

    private static int a(c cVar, com.bumptech.glide.c.b.a.b bVar) {
        Object obj;
        int i = -1;
        AppMethodBeat.i(92212);
        int nn = cVar.nn();
        if ((nn & 65496) == 65496 || nn == 19789 || nn == 18761) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            AppMethodBeat.o(92212);
        } else {
            int i2;
            while (cVar.no() == (short) 255) {
                short no = cVar.no();
                if (no != (short) 218) {
                    if (no != (short) 217) {
                        nn = cVar.nn() - 2;
                        if (no == (short) 225) {
                            i2 = nn;
                            break;
                        }
                        long skip = cVar.skip((long) nn);
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
                AppMethodBeat.o(92212);
            } else {
                byte[] bArr = (byte[]) bVar.a(i2, byte[].class);
                try {
                    int read = cVar.read(bArr, i2);
                    if (read != i2) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Unable to read exif segment data, length: ").append(i2).append(", actually read: ").append(read);
                        }
                    } else if (c(bArr, i2)) {
                        i = a(new b(bArr, i2));
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    }
                    bVar.put(bArr);
                    AppMethodBeat.o(92212);
                } catch (Throwable th) {
                    bVar.put(bArr);
                    AppMethodBeat.o(92212);
                }
            }
        }
        return i;
    }

    private static boolean c(byte[] bArr, int i) {
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

    private static int a(b bVar) {
        ByteOrder byteOrder;
        AppMethodBeat.i(92213);
        switch (bVar.dh(6)) {
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
        bVar.aEY.order(byteOrder);
        int dg = bVar.dg(10) + 6;
        short dh = bVar.dh(dg);
        for (short s = (short) 0; s < dh; s++) {
            int i = (dg + 2) + (s * 12);
            short dh2 = bVar.dh(i);
            if (dh2 == (short) 274) {
                short dh3 = bVar.dh(i + 2);
                if (dh3 > (short) 0 && dh3 <= (short) 12) {
                    int dg2 = bVar.dg(i + 4);
                    if (dg2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Got tagIndex=").append(s).append(" tagType=").append(dh2).append(" formatCode=").append(dh3).append(" componentCount=").append(dg2);
                        }
                        int i2 = aEX[dh3] + dg2;
                        if (i2 <= 4) {
                            i += 8;
                            if (i < 0 || i > bVar.aEY.remaining()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    new StringBuilder("Illegal tagValueOffset=").append(i).append(" tagType=").append(dh2);
                                }
                            } else if (i2 >= 0 && i + i2 <= bVar.aEY.remaining()) {
                                s = bVar.dh(i);
                                AppMethodBeat.o(92213);
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
        AppMethodBeat.o(92213);
        return -1;
    }
}
