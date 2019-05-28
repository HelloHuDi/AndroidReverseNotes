package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class e implements a {
    private static final String TAG = e.class.getSimpleName();
    private int ayA;
    private Boolean ayB;
    private Config ayC;
    private byte[] ayl;
    private ByteBuffer aym;
    private c ayn;
    private int[] ayo;
    private final int[] ayp;
    private final a ayq;
    private short[] ayr;
    private byte[] ays;
    private byte[] ayt;
    private byte[] ayu;
    private int[] ayv;
    private int ayw;
    private Bitmap ayx;
    private boolean ayy;
    private int ayz;
    private int sampleSize;
    private int status;

    static {
        AppMethodBeat.i(123391);
        AppMethodBeat.o(123391);
    }

    public e(a aVar, c cVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        AppMethodBeat.i(123380);
        a(cVar, byteBuffer, i);
        AppMethodBeat.o(123380);
    }

    private e(a aVar) {
        AppMethodBeat.i(123381);
        this.ayp = new int[256];
        this.ayC = Config.ARGB_8888;
        this.ayq = aVar;
        this.ayn = new c();
        AppMethodBeat.o(123381);
    }

    public final ByteBuffer getData() {
        return this.aym;
    }

    public final void advance() {
        this.ayw = (this.ayw + 1) % this.ayn.frameCount;
    }

    public final int lT() {
        AppMethodBeat.i(123382);
        if (this.ayn.frameCount <= 0 || this.ayw < 0) {
            AppMethodBeat.o(123382);
            return 0;
        }
        int i = this.ayw;
        int i2 = -1;
        if (i >= 0 && i < this.ayn.frameCount) {
            i2 = ((b) this.ayn.ayf.get(i)).delay;
        }
        AppMethodBeat.o(123382);
        return i2;
    }

    public final int getFrameCount() {
        return this.ayn.frameCount;
    }

    public final int lU() {
        return this.ayw;
    }

    public final void lV() {
        this.ayw = -1;
    }

    public final int lW() {
        AppMethodBeat.i(123383);
        int limit = (this.aym.limit() + this.ayu.length) + (this.ayv.length * 4);
        AppMethodBeat.o(123383);
        return limit;
    }

    public final synchronized Bitmap lX() {
        Bitmap bitmap;
        AppMethodBeat.i(123384);
        if (this.ayn.frameCount <= 0 || this.ayw < 0) {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Unable to decode frame, frameCount=").append(this.ayn.frameCount).append(", framePointer=").append(this.ayw);
            }
            this.status = 1;
        }
        if (this.status == 1 || this.status == 2) {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Unable to decode frame, status=").append(this.status);
            }
            AppMethodBeat.o(123384);
            bitmap = null;
        } else {
            b bVar;
            int[] iArr;
            this.status = 0;
            if (this.ayl == null) {
                this.ayl = this.ayq.da(255);
            }
            b bVar2 = (b) this.ayn.ayf.get(this.ayw);
            int i = this.ayw - 1;
            if (i >= 0) {
                bVar = (b) this.ayn.ayf.get(i);
            } else {
                bVar = null;
            }
            if (bVar2.ayc != null) {
                iArr = bVar2.ayc;
            } else {
                iArr = this.ayn.ayd;
            }
            this.ayo = iArr;
            if (this.ayo == null) {
                if (Log.isLoggable(TAG, 3)) {
                    new StringBuilder("No valid color table found for frame #").append(this.ayw);
                }
                this.status = 1;
                AppMethodBeat.o(123384);
                bitmap = null;
            } else {
                if (bVar2.axY) {
                    System.arraycopy(this.ayo, 0, this.ayp, 0, this.ayo.length);
                    this.ayo = this.ayp;
                    this.ayo[bVar2.aya] = 0;
                }
                bitmap = a(bVar2, bVar);
                AppMethodBeat.o(123384);
            }
        }
        return bitmap;
    }

    public final void clear() {
        AppMethodBeat.i(123385);
        this.ayn = null;
        if (this.ayu != null) {
            this.ayq.g(this.ayu);
        }
        if (this.ayv != null) {
            this.ayq.k(this.ayv);
        }
        if (this.ayx != null) {
            this.ayq.f(this.ayx);
        }
        this.ayx = null;
        this.aym = null;
        this.ayB = null;
        if (this.ayl != null) {
            this.ayq.g(this.ayl);
        }
        AppMethodBeat.o(123385);
    }

    private synchronized void a(c cVar, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(123386);
        if (i <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sample size must be >=0, not: ".concat(String.valueOf(i)));
            AppMethodBeat.o(123386);
            throw illegalArgumentException;
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.status = 0;
        this.ayn = cVar;
        this.ayw = -1;
        this.aym = byteBuffer.asReadOnlyBuffer();
        this.aym.position(0);
        this.aym.order(ByteOrder.LITTLE_ENDIAN);
        this.ayy = false;
        for (b bVar : cVar.ayf) {
            if (bVar.axZ == 3) {
                this.ayy = true;
                break;
            }
        }
        this.sampleSize = highestOneBit;
        this.ayA = cVar.width / highestOneBit;
        this.ayz = cVar.height / highestOneBit;
        this.ayu = this.ayq.da(cVar.width * cVar.height);
        this.ayv = this.ayq.db(this.ayA * this.ayz);
        AppMethodBeat.o(123386);
    }

    public final void a(Config config) {
        AppMethodBeat.i(123387);
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.ayC = config;
            AppMethodBeat.o(123387);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Config.ARGB_8888 + " or " + Config.RGB_565);
        AppMethodBeat.o(123387);
        throw illegalArgumentException;
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(123388);
        int[] iArr = this.ayv;
        if (bVar2 == null) {
            if (this.ayx != null) {
                this.ayq.f(this.ayx);
            }
            this.ayx = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.axZ == 3 && this.ayx == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.axZ > 0) {
            if (bVar2.axZ == 2) {
                i = 0;
                if (!bVar.axY) {
                    i = this.ayn.bgColor;
                    if (bVar.ayc != null && this.ayn.ayi == bVar.aya) {
                        i = 0;
                    }
                } else if (this.ayw == 0) {
                    this.ayB = Boolean.TRUE;
                }
                i2 = bVar2.axV / this.sampleSize;
                i3 = ((bVar2.axU / this.sampleSize) * this.ayA) + (bVar2.axT / this.sampleSize);
                i4 = i3 + ((bVar2.axW / this.sampleSize) * this.ayA);
                while (i3 < i4) {
                    i5 = i3 + i2;
                    for (i6 = i3; i6 < i5; i6++) {
                        iArr[i6] = i;
                    }
                    i3 += this.ayA;
                }
            } else if (bVar2.axZ == 3 && this.ayx != null) {
                this.ayx.getPixels(iArr, 0, this.ayA, 0, 0, this.ayA, this.ayz);
            }
        }
        if (bVar != null) {
            this.aym.position(bVar.ayb);
        }
        if (bVar == null) {
            i = this.ayn.width * this.ayn.height;
        } else {
            i = bVar.axV * bVar.axW;
        }
        if (this.ayu == null || this.ayu.length < i) {
            this.ayu = this.ayq.da(i);
        }
        byte[] bArr = this.ayu;
        if (this.ayr == null) {
            this.ayr = new short[4096];
        }
        short[] sArr = this.ayr;
        if (this.ays == null) {
            this.ays = new byte[4096];
        }
        byte[] bArr2 = this.ays;
        if (this.ayt == null) {
            this.ayt = new byte[4097];
        }
        byte[] bArr3 = this.ayt;
        int me = me();
        int i9 = 1 << me;
        int i10 = i9 + 1;
        i5 = i9 + 2;
        int i11 = -1;
        i2 = me + 1;
        i4 = (1 << i2) - 1;
        for (i6 = 0; i6 < i9; i6++) {
            sArr[i6] = (short) 0;
            bArr2[i6] = (byte) i6;
        }
        byte[] bArr4 = this.ayl;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        i6 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        i3 = 0;
        while (i12 < i) {
            if (i6 == 0) {
                i6 = me();
                if (i6 > 0) {
                    this.aym.get(this.ayl, 0, Math.min(i6, this.aym.remaining()));
                }
                if (i6 <= 0) {
                    this.status = 3;
                    break;
                }
                i3 = 0;
            }
            i7 = i3 + 1;
            int i18 = i6 - 1;
            i13 = ((bArr4[i3] & 255) << i14) + i13;
            i14 += 8;
            while (i14 >= i2) {
                i8 = i13 & i4;
                i13 >>= i2;
                i14 -= i2;
                if (i8 != i9) {
                    if (i8 == i10) {
                        break;
                    } else if (i11 == -1) {
                        bArr[i17] = bArr2[i8];
                        i12++;
                        i15 = i8;
                        i17++;
                        i11 = i8;
                    } else {
                        if (i8 >= i5) {
                            bArr3[i16] = (byte) i15;
                            i3 = i16 + 1;
                            i6 = i11;
                        } else {
                            i3 = i16;
                            i6 = i8;
                        }
                        while (i6 >= i9) {
                            bArr3[i3] = bArr2[i6];
                            i3++;
                            i6 = sArr[i6];
                        }
                        i15 = bArr2[i6] & 255;
                        bArr[i17] = (byte) i15;
                        int i19 = i17 + 1;
                        i12++;
                        i16 = i3;
                        while (i16 > 0) {
                            i3 = i16 - 1;
                            bArr[i19] = bArr3[i3];
                            i19++;
                            i12++;
                            i16 = i3;
                        }
                        if (i5 < 4096) {
                            sArr[i5] = (short) i11;
                            bArr2[i5] = (byte) i15;
                            i5++;
                            if ((i5 & i4) == 0 && i5 < 4096) {
                                i6 = i2 + 1;
                                i3 = i4 + i5;
                                i17 = i19;
                                i2 = i6;
                                i11 = i8;
                                i4 = i3;
                            }
                        }
                        i6 = i2;
                        i3 = i4;
                        i17 = i19;
                        i2 = i6;
                        i11 = i8;
                        i4 = i3;
                    }
                } else {
                    i2 = me + 1;
                    i4 = (1 << i2) - 1;
                    i5 = i9 + 2;
                    i11 = -1;
                }
            }
            i6 = i18;
            i3 = i7;
        }
        Arrays.fill(bArr, i17, i, (byte) 0);
        int[] iArr2;
        Object obj;
        boolean z;
        if (bVar.axX || this.sampleSize != 1) {
            iArr2 = this.ayv;
            i7 = bVar.axW / this.sampleSize;
            int i20 = bVar.axU / this.sampleSize;
            int i21 = bVar.axV / this.sampleSize;
            int i22 = bVar.axT / this.sampleSize;
            i2 = 1;
            i6 = 8;
            i3 = 0;
            obj = this.ayw == 0 ? 1 : null;
            int i23 = this.sampleSize;
            me = this.ayA;
            i9 = this.ayz;
            byte[] bArr5 = this.ayu;
            int[] iArr3 = this.ayo;
            Boolean bool = this.ayB;
            i13 = 0;
            while (i13 < i7) {
                Object obj2;
                if (bVar.axX) {
                    if (i3 >= i7) {
                        i2++;
                        switch (i2) {
                            case 2:
                                i3 = 4;
                                break;
                            case 3:
                                i3 = 2;
                                i6 = 4;
                                break;
                            case 4:
                                i3 = 1;
                                i6 = 2;
                                break;
                        }
                    }
                    i8 = i6;
                    i4 = i3;
                    i14 = i3 + i6;
                    i15 = i2;
                } else {
                    i8 = i6;
                    i4 = i13;
                    i14 = i3;
                    i15 = i2;
                }
                i2 = i4 + i20;
                if (i23 == 1) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (i2 < i9) {
                    i2 *= me;
                    i4 = i2 + i22;
                    i6 = i4 + i21;
                    if (i2 + me < i6) {
                        i11 = i2 + me;
                    } else {
                        i11 = i6;
                    }
                    i2 = bVar.axV * (i13 * i23);
                    Boolean bool2;
                    if (obj2 != null) {
                        bool2 = bool;
                        while (i4 < i11) {
                            i3 = iArr3[bArr5[i2] & 255];
                            if (i3 != 0) {
                                iArr2[i4] = i3;
                            } else if (obj != null && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i2 += i23;
                            i4++;
                        }
                        bool = bool2;
                    } else {
                        int i24 = i2 + ((i11 - i4) * i23);
                        i3 = i2;
                        for (i17 = i4; i17 < i11; i17++) {
                            int i25;
                            int i26 = bVar.axV;
                            i16 = 0;
                            i12 = 0;
                            i5 = 0;
                            i4 = 0;
                            i2 = 0;
                            i6 = i3;
                            while (i6 < this.sampleSize + i3 && i6 < this.ayu.length && i6 < i24) {
                                i25 = this.ayo[this.ayu[i6] & 255];
                                if (i25 != 0) {
                                    i16 += (i25 >> 24) & 255;
                                    i12 += (i25 >> 16) & 255;
                                    i5 += (i25 >> 8) & 255;
                                    i4 += i25 & 255;
                                    i2++;
                                }
                                i6++;
                            }
                            i6 = i3 + i26;
                            while (i6 < (i3 + i26) + this.sampleSize && i6 < this.ayu.length && i6 < i24) {
                                i25 = this.ayo[this.ayu[i6] & 255];
                                if (i25 != 0) {
                                    i16 += (i25 >> 24) & 255;
                                    i12 += (i25 >> 16) & 255;
                                    i5 += (i25 >> 8) & 255;
                                    i4 += i25 & 255;
                                    i2++;
                                }
                                i6++;
                            }
                            if (i2 == 0) {
                                i6 = 0;
                            } else {
                                i6 = ((((i16 / i2) << 24) | ((i12 / i2) << 16)) | ((i5 / i2) << 8)) | (i4 / i2);
                            }
                            if (i6 != 0) {
                                iArr2[i17] = i6;
                                bool2 = bool;
                            } else if (obj == null || bool != null) {
                                bool2 = bool;
                            } else {
                                bool2 = Boolean.TRUE;
                            }
                            i3 += i23;
                            bool = bool2;
                        }
                    }
                }
                i13++;
                i6 = i8;
                i3 = i14;
                i2 = i15;
            }
            if (this.ayB == null) {
                if (bool == null) {
                    z = false;
                } else {
                    z = bool.booleanValue();
                }
                this.ayB = Boolean.valueOf(z);
            }
        } else {
            int[] iArr4 = this.ayv;
            i11 = bVar.axW;
            i8 = bVar.axU;
            i13 = bVar.axV;
            i14 = bVar.axT;
            obj = this.ayw == 0 ? 1 : null;
            i15 = this.ayA;
            byte[] bArr6 = this.ayu;
            iArr2 = this.ayo;
            i4 = 0;
            i5 = -1;
            while (i4 < i11) {
                i3 = (i4 + i8) * i15;
                i16 = i3 + i14;
                i6 = i16 + i13;
                if (i3 + i15 < i6) {
                    i2 = i3 + i15;
                } else {
                    i2 = i6;
                }
                i12 = i4 * bVar.axV;
                i6 = i5;
                while (i16 < i2) {
                    byte b = bArr6[i12];
                    i5 = b & 255;
                    if (i5 != i6) {
                        i5 = iArr2[i5];
                        if (i5 != 0) {
                            iArr4[i16] = i5;
                        } else {
                            byte b2 = b;
                        }
                    }
                    i12++;
                    i16++;
                }
                i4++;
                i5 = i6;
            }
            z = (this.ayB != null || obj == null || i5 == -1) ? false : true;
            this.ayB = Boolean.valueOf(z);
        }
        if (this.ayy && (bVar.axZ == 0 || bVar.axZ == 1)) {
            if (this.ayx == null) {
                this.ayx = mf();
            }
            this.ayx.setPixels(iArr, 0, this.ayA, 0, 0, this.ayA, this.ayz);
        }
        Bitmap mf = mf();
        mf.setPixels(iArr, 0, this.ayA, 0, 0, this.ayA, this.ayz);
        AppMethodBeat.o(123388);
        return mf;
    }

    private int me() {
        AppMethodBeat.i(123389);
        int i = this.aym.get() & 255;
        AppMethodBeat.o(123389);
        return i;
    }

    private Bitmap mf() {
        AppMethodBeat.i(123390);
        Config config = (this.ayB == null || this.ayB.booleanValue()) ? Config.ARGB_8888 : this.ayC;
        Bitmap b = this.ayq.b(this.ayA, this.ayz, config);
        b.setHasAlpha(true);
        AppMethodBeat.o(123390);
        return b;
    }
}
