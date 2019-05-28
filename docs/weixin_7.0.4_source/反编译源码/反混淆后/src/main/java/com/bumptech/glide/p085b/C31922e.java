package com.bumptech.glide.p085b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.p085b.C25400a.C25401a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.bumptech.glide.b.e */
public class C31922e implements C25400a {
    private static final String TAG = C31922e.class.getSimpleName();
    private int ayA;
    private Boolean ayB;
    private Config ayC;
    private byte[] ayl;
    private ByteBuffer aym;
    private C0741c ayn;
    private int[] ayo;
    private final int[] ayp;
    private final C25401a ayq;
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
        AppMethodBeat.m2504i(123391);
        AppMethodBeat.m2505o(123391);
    }

    public C31922e(C25401a c25401a, C0741c c0741c, ByteBuffer byteBuffer, int i) {
        this(c25401a);
        AppMethodBeat.m2504i(123380);
        m51836a(c0741c, byteBuffer, i);
        AppMethodBeat.m2505o(123380);
    }

    private C31922e(C25401a c25401a) {
        AppMethodBeat.m2504i(123381);
        this.ayp = new int[256];
        this.ayC = Config.ARGB_8888;
        this.ayq = c25401a;
        this.ayn = new C0741c();
        AppMethodBeat.m2505o(123381);
    }

    public final ByteBuffer getData() {
        return this.aym;
    }

    public final void advance() {
        this.ayw = (this.ayw + 1) % this.ayn.frameCount;
    }

    /* renamed from: lT */
    public final int mo42435lT() {
        AppMethodBeat.m2504i(123382);
        if (this.ayn.frameCount <= 0 || this.ayw < 0) {
            AppMethodBeat.m2505o(123382);
            return 0;
        }
        int i = this.ayw;
        int i2 = -1;
        if (i >= 0 && i < this.ayn.frameCount) {
            i2 = ((C17512b) this.ayn.ayf.get(i)).delay;
        }
        AppMethodBeat.m2505o(123382);
        return i2;
    }

    public final int getFrameCount() {
        return this.ayn.frameCount;
    }

    /* renamed from: lU */
    public final int mo42436lU() {
        return this.ayw;
    }

    /* renamed from: lV */
    public final void mo42437lV() {
        this.ayw = -1;
    }

    /* renamed from: lW */
    public final int mo42438lW() {
        AppMethodBeat.m2504i(123383);
        int limit = (this.aym.limit() + this.ayu.length) + (this.ayv.length * 4);
        AppMethodBeat.m2505o(123383);
        return limit;
    }

    /* renamed from: lX */
    public final synchronized Bitmap mo42439lX() {
        Bitmap bitmap;
        AppMethodBeat.m2504i(123384);
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
            AppMethodBeat.m2505o(123384);
            bitmap = null;
        } else {
            C17512b c17512b;
            int[] iArr;
            this.status = 0;
            if (this.ayl == null) {
                this.ayl = this.ayq.mo42441da(255);
            }
            C17512b c17512b2 = (C17512b) this.ayn.ayf.get(this.ayw);
            int i = this.ayw - 1;
            if (i >= 0) {
                c17512b = (C17512b) this.ayn.ayf.get(i);
            } else {
                c17512b = null;
            }
            if (c17512b2.ayc != null) {
                iArr = c17512b2.ayc;
            } else {
                iArr = this.ayn.ayd;
            }
            this.ayo = iArr;
            if (this.ayo == null) {
                if (Log.isLoggable(TAG, 3)) {
                    new StringBuilder("No valid color table found for frame #").append(this.ayw);
                }
                this.status = 1;
                AppMethodBeat.m2505o(123384);
                bitmap = null;
            } else {
                if (c17512b2.axY) {
                    System.arraycopy(this.ayo, 0, this.ayp, 0, this.ayo.length);
                    this.ayo = this.ayp;
                    this.ayo[c17512b2.aya] = 0;
                }
                bitmap = m51835a(c17512b2, c17512b);
                AppMethodBeat.m2505o(123384);
            }
        }
        return bitmap;
    }

    public final void clear() {
        AppMethodBeat.m2504i(123385);
        this.ayn = null;
        if (this.ayu != null) {
            this.ayq.mo42444g(this.ayu);
        }
        if (this.ayv != null) {
            this.ayq.mo42445k(this.ayv);
        }
        if (this.ayx != null) {
            this.ayq.mo42443f(this.ayx);
        }
        this.ayx = null;
        this.aym = null;
        this.ayB = null;
        if (this.ayl != null) {
            this.ayq.mo42444g(this.ayl);
        }
        AppMethodBeat.m2505o(123385);
    }

    /* renamed from: a */
    private synchronized void m51836a(C0741c c0741c, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(123386);
        if (i <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sample size must be >=0, not: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(123386);
            throw illegalArgumentException;
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.status = 0;
        this.ayn = c0741c;
        this.ayw = -1;
        this.aym = byteBuffer.asReadOnlyBuffer();
        this.aym.position(0);
        this.aym.order(ByteOrder.LITTLE_ENDIAN);
        this.ayy = false;
        for (C17512b c17512b : c0741c.ayf) {
            if (c17512b.axZ == 3) {
                this.ayy = true;
                break;
            }
        }
        this.sampleSize = highestOneBit;
        this.ayA = c0741c.width / highestOneBit;
        this.ayz = c0741c.height / highestOneBit;
        this.ayu = this.ayq.mo42441da(c0741c.width * c0741c.height);
        this.ayv = this.ayq.mo42442db(this.ayA * this.ayz);
        AppMethodBeat.m2505o(123386);
    }

    /* renamed from: a */
    public final void mo42430a(Config config) {
        AppMethodBeat.m2504i(123387);
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.ayC = config;
            AppMethodBeat.m2505o(123387);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Config.ARGB_8888 + " or " + Config.RGB_565);
        AppMethodBeat.m2505o(123387);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private Bitmap m51835a(C17512b c17512b, C17512b c17512b2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.m2504i(123388);
        int[] iArr = this.ayv;
        if (c17512b2 == null) {
            if (this.ayx != null) {
                this.ayq.mo42443f(this.ayx);
            }
            this.ayx = null;
            Arrays.fill(iArr, 0);
        }
        if (c17512b2 != null && c17512b2.axZ == 3 && this.ayx == null) {
            Arrays.fill(iArr, 0);
        }
        if (c17512b2 != null && c17512b2.axZ > 0) {
            if (c17512b2.axZ == 2) {
                i = 0;
                if (!c17512b.axY) {
                    i = this.ayn.bgColor;
                    if (c17512b.ayc != null && this.ayn.ayi == c17512b.aya) {
                        i = 0;
                    }
                } else if (this.ayw == 0) {
                    this.ayB = Boolean.TRUE;
                }
                i2 = c17512b2.axV / this.sampleSize;
                i3 = ((c17512b2.axU / this.sampleSize) * this.ayA) + (c17512b2.axT / this.sampleSize);
                i4 = i3 + ((c17512b2.axW / this.sampleSize) * this.ayA);
                while (i3 < i4) {
                    i5 = i3 + i2;
                    for (i6 = i3; i6 < i5; i6++) {
                        iArr[i6] = i;
                    }
                    i3 += this.ayA;
                }
            } else if (c17512b2.axZ == 3 && this.ayx != null) {
                this.ayx.getPixels(iArr, 0, this.ayA, 0, 0, this.ayA, this.ayz);
            }
        }
        if (c17512b != null) {
            this.aym.position(c17512b.ayb);
        }
        if (c17512b == null) {
            i = this.ayn.width * this.ayn.height;
        } else {
            i = c17512b.axV * c17512b.axW;
        }
        if (this.ayu == null || this.ayu.length < i) {
            this.ayu = this.ayq.mo42441da(i);
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
        int me = m51837me();
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
                i6 = m51837me();
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
        if (c17512b.axX || this.sampleSize != 1) {
            iArr2 = this.ayv;
            i7 = c17512b.axW / this.sampleSize;
            int i20 = c17512b.axU / this.sampleSize;
            int i21 = c17512b.axV / this.sampleSize;
            int i22 = c17512b.axT / this.sampleSize;
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
                if (c17512b.axX) {
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
                    i2 = c17512b.axV * (i13 * i23);
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
                            int i26 = c17512b.axV;
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
            i11 = c17512b.axW;
            i8 = c17512b.axU;
            i13 = c17512b.axV;
            i14 = c17512b.axT;
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
                i12 = i4 * c17512b.axV;
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
        if (this.ayy && (c17512b.axZ == 0 || c17512b.axZ == 1)) {
            if (this.ayx == null) {
                this.ayx = m51838mf();
            }
            this.ayx.setPixels(iArr, 0, this.ayA, 0, 0, this.ayA, this.ayz);
        }
        Bitmap mf = m51838mf();
        mf.setPixels(iArr, 0, this.ayA, 0, 0, this.ayA, this.ayz);
        AppMethodBeat.m2505o(123388);
        return mf;
    }

    /* renamed from: me */
    private int m51837me() {
        AppMethodBeat.m2504i(123389);
        int i = this.aym.get() & 255;
        AppMethodBeat.m2505o(123389);
        return i;
    }

    /* renamed from: mf */
    private Bitmap m51838mf() {
        AppMethodBeat.m2504i(123390);
        Config config = (this.ayB == null || this.ayB.booleanValue()) ? Config.ARGB_8888 : this.ayC;
        Bitmap b = this.ayq.mo42440b(this.ayA, this.ayz, config);
        b.setHasAlpha(true);
        AppMethodBeat.m2505o(123390);
        return b;
    }
}
