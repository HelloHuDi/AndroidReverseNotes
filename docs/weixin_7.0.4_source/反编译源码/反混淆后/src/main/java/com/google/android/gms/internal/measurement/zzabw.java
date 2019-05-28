package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.view.C31128d;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzabw {
    private final ByteBuffer zzbwv;

    private zzabw(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(3453);
        this.zzbwv = byteBuffer;
        this.zzbwv.order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.m2505o(3453);
    }

    private zzabw(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
        AppMethodBeat.m2504i(3452);
        AppMethodBeat.m2505o(3452);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.m2504i(3464);
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unpaired surrogate at index " + i2);
                                AppMethodBeat.m2505o(3464);
                                throw illegalArgumentException;
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i += i3;
                if (i >= length) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
                    AppMethodBeat.m2505o(3464);
                    throw illegalArgumentException2;
                }
                AppMethodBeat.m2505o(3464);
                return i;
            }
        }
        i = i3;
        if (i >= length) {
        }
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i = 0;
        AppMethodBeat.m2504i(3465);
        int position;
        int remaining;
        if (byteBuffer.isReadOnly()) {
            ReadOnlyBufferException readOnlyBufferException = new ReadOnlyBufferException();
            AppMethodBeat.m2505o(3465);
            throw readOnlyBufferException;
        } else if (byteBuffer.hasArray()) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
            try {
                char charAt;
                byte[] array = byteBuffer.array();
                position = byteBuffer.position() + byteBuffer.arrayOffset();
                remaining = byteBuffer.remaining();
                int length = charSequence.length();
                int i2 = position + remaining;
                remaining = 0;
                while (remaining < length && remaining + position < i2) {
                    charAt = charSequence.charAt(remaining);
                    if (charAt >= 128) {
                        break;
                    }
                    array[position + remaining] = (byte) charAt;
                    remaining++;
                }
                if (remaining == length) {
                    i = position + length;
                } else {
                    position += remaining;
                    while (remaining < length) {
                        char charAt2 = charSequence.charAt(remaining);
                        int i3;
                        if (charAt2 < 128 && position < i2) {
                            i = position + 1;
                            array[position] = (byte) charAt2;
                        } else if (charAt2 < 2048 && position <= i2 - 2) {
                            i3 = position + 1;
                            array[position] = (byte) ((charAt2 >>> 6) | VideoFilterUtil.IMAGE_HEIGHT);
                            i = i3 + 1;
                            array[i3] = (byte) ((charAt2 & 63) | 128);
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && position <= i2 - 3) {
                            i = position + 1;
                            array[position] = (byte) ((charAt2 >>> 12) | 480);
                            position = i + 1;
                            array[i] = (byte) (((charAt2 >>> 6) & 63) | 128);
                            i = position + 1;
                            array[position] = (byte) ((charAt2 & 63) | 128);
                        } else if (position <= i2 - 4) {
                            if (remaining + 1 != charSequence.length()) {
                                remaining++;
                                charAt = charSequence.charAt(remaining);
                                if (Character.isSurrogatePair(charAt2, charAt)) {
                                    int toCodePoint = Character.toCodePoint(charAt2, charAt);
                                    i = position + 1;
                                    array[position] = (byte) ((toCodePoint >>> 18) | 240);
                                    position = i + 1;
                                    array[i] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                                    i3 = position + 1;
                                    array[position] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                                    i = i3 + 1;
                                    array[i3] = (byte) ((toCodePoint & 63) | 128);
                                }
                            }
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unpaired surrogate at index " + (remaining - 1));
                            AppMethodBeat.m2505o(3465);
                            throw illegalArgumentException;
                        } else {
                            arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                            AppMethodBeat.m2505o(3465);
                            throw arrayIndexOutOfBoundsException;
                        }
                        remaining++;
                        position = i;
                    }
                    i = position;
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
                AppMethodBeat.m2505o(3465);
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(arrayIndexOutOfBoundsException2);
                AppMethodBeat.m2505o(3465);
                throw bufferOverflowException;
            }
        } else {
            remaining = charSequence.length();
            while (i < remaining) {
                char charAt3 = charSequence.charAt(i);
                if (charAt3 < 128) {
                    byteBuffer.put((byte) charAt3);
                } else if (charAt3 < 2048) {
                    byteBuffer.put((byte) ((charAt3 >>> 6) | VideoFilterUtil.IMAGE_HEIGHT));
                    byteBuffer.put((byte) ((charAt3 & 63) | 128));
                } else if (charAt3 < 55296 || 57343 < charAt3) {
                    byteBuffer.put((byte) ((charAt3 >>> 12) | 480));
                    byteBuffer.put((byte) (((charAt3 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((charAt3 & 63) | 128));
                } else {
                    if (i + 1 != charSequence.length()) {
                        i++;
                        char charAt4 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            position = Character.toCodePoint(charAt3, charAt4);
                            byteBuffer.put((byte) ((position >>> 18) | 240));
                            byteBuffer.put((byte) (((position >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((position >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((position & 63) | 128));
                        }
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
                    AppMethodBeat.m2505o(3465);
                    throw illegalArgumentException2;
                }
                i++;
            }
            AppMethodBeat.m2505o(3465);
        }
    }

    private final void zzan(long j) {
        AppMethodBeat.m2504i(3479);
        while ((-128 & j) != 0) {
            zzap((((int) j) & C31128d.MIC_SketchMark) | 128);
            j >>>= 7;
        }
        zzap((int) j);
        AppMethodBeat.m2505o(3479);
    }

    public static int zzao(int i) {
        AppMethodBeat.m2504i(3471);
        if (i >= 0) {
            int zzas = zzas(i);
            AppMethodBeat.m2505o(3471);
            return zzas;
        }
        AppMethodBeat.m2505o(3471);
        return 10;
    }

    public static int zzao(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private final void zzap(int i) {
        AppMethodBeat.m2504i(3474);
        byte b = (byte) i;
        if (this.zzbwv.hasRemaining()) {
            this.zzbwv.put(b);
            AppMethodBeat.m2505o(3474);
            return;
        }
        zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
        AppMethodBeat.m2505o(3474);
        throw zzabx;
    }

    public static int zzaq(int i) {
        AppMethodBeat.m2504i(3477);
        int zzas = zzas(i << 3);
        AppMethodBeat.m2505o(3477);
        return zzas;
    }

    public static int zzas(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzb(int i, zzace zzace) {
        AppMethodBeat.m2504i(3470);
        int zzaq = zzaq(i);
        int zzvm = zzace.zzvm();
        zzaq += zzvm + zzas(zzvm);
        AppMethodBeat.m2505o(3470);
        return zzaq;
    }

    public static zzabw zzb(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(3455);
        zzabw zzabw = new zzabw(bArr, 0, i2);
        AppMethodBeat.m2505o(3455);
        return zzabw;
    }

    public static int zzc(int i, long j) {
        AppMethodBeat.m2504i(3467);
        int zzaq = zzaq(i) + zzao(j);
        AppMethodBeat.m2505o(3467);
        return zzaq;
    }

    public static int zzc(int i, String str) {
        AppMethodBeat.m2504i(3469);
        int zzaq = zzaq(i) + zzfm(str);
        AppMethodBeat.m2505o(3469);
        return zzaq;
    }

    public static int zzf(int i, int i2) {
        AppMethodBeat.m2504i(3468);
        int zzaq = zzaq(i) + zzao(i2);
        AppMethodBeat.m2505o(3468);
        return zzaq;
    }

    public static int zzfm(String str) {
        AppMethodBeat.m2504i(3472);
        int zza = zza(str);
        zza += zzas(zza);
        AppMethodBeat.m2505o(3472);
        return zza;
    }

    public static zzabw zzj(byte[] bArr) {
        AppMethodBeat.m2504i(3454);
        zzabw zzb = zzb(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(3454);
        return zzb;
    }

    public final void zza(int i, double d) {
        AppMethodBeat.m2504i(3456);
        zzg(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.zzbwv.remaining() < 8) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            AppMethodBeat.m2505o(3456);
            throw zzabx;
        }
        this.zzbwv.putLong(doubleToLongBits);
        AppMethodBeat.m2505o(3456);
    }

    public final void zza(int i, float f) {
        AppMethodBeat.m2504i(3457);
        zzg(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzbwv.remaining() < 4) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            AppMethodBeat.m2505o(3457);
            throw zzabx;
        }
        this.zzbwv.putInt(floatToIntBits);
        AppMethodBeat.m2505o(3457);
    }

    public final void zza(int i, long j) {
        AppMethodBeat.m2504i(3458);
        zzg(i, 0);
        zzan(j);
        AppMethodBeat.m2505o(3458);
    }

    public final void zza(int i, zzace zzace) {
        AppMethodBeat.m2504i(3463);
        zzg(i, 2);
        zzb(zzace);
        AppMethodBeat.m2505o(3463);
    }

    public final void zza(int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(3461);
        zzg(i, 0);
        if (z) {
            i2 = 1;
        }
        byte b = (byte) i2;
        if (this.zzbwv.hasRemaining()) {
            this.zzbwv.put(b);
            AppMethodBeat.m2505o(3461);
            return;
        }
        zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
        AppMethodBeat.m2505o(3461);
        throw zzabx;
    }

    public final void zzar(int i) {
        AppMethodBeat.m2504i(3478);
        while ((i & -128) != 0) {
            zzap((i & C31128d.MIC_SketchMark) | 128);
            i >>>= 7;
        }
        zzap(i);
        AppMethodBeat.m2505o(3478);
    }

    public final void zzb(int i, long j) {
        AppMethodBeat.m2504i(3459);
        zzg(i, 0);
        zzan(j);
        AppMethodBeat.m2505o(3459);
    }

    public final void zzb(int i, String str) {
        AppMethodBeat.m2504i(3462);
        zzg(i, 2);
        try {
            int zzas = zzas(str.length());
            if (zzas == zzas(str.length() * 3)) {
                int position = this.zzbwv.position();
                if (this.zzbwv.remaining() < zzas) {
                    zzabx zzabx = new zzabx(zzas + position, this.zzbwv.limit());
                    AppMethodBeat.m2505o(3462);
                    throw zzabx;
                }
                this.zzbwv.position(position + zzas);
                zza((CharSequence) str, this.zzbwv);
                int position2 = this.zzbwv.position();
                this.zzbwv.position(position);
                zzar((position2 - position) - zzas);
                this.zzbwv.position(position2);
                AppMethodBeat.m2505o(3462);
                return;
            }
            zzar(zza(str));
            zza((CharSequence) str, this.zzbwv);
            AppMethodBeat.m2505o(3462);
        } catch (BufferOverflowException e) {
            zzabx zzabx2 = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            zzabx2.initCause(e);
            AppMethodBeat.m2505o(3462);
            throw zzabx2;
        }
    }

    public final void zzb(zzace zzace) {
        AppMethodBeat.m2504i(3466);
        zzar(zzace.zzvl());
        zzace.zza(this);
        AppMethodBeat.m2505o(3466);
    }

    public final void zze(int i, int i2) {
        AppMethodBeat.m2504i(3460);
        zzg(i, 0);
        if (i2 >= 0) {
            zzar(i2);
            AppMethodBeat.m2505o(3460);
            return;
        }
        zzan((long) i2);
        AppMethodBeat.m2505o(3460);
    }

    public final void zzg(int i, int i2) {
        AppMethodBeat.m2504i(3476);
        zzar((i << 3) | i2);
        AppMethodBeat.m2505o(3476);
    }

    public final void zzk(byte[] bArr) {
        AppMethodBeat.m2504i(3475);
        int length = bArr.length;
        if (this.zzbwv.remaining() >= length) {
            this.zzbwv.put(bArr, 0, length);
            AppMethodBeat.m2505o(3475);
            return;
        }
        zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
        AppMethodBeat.m2505o(3475);
        throw zzabx;
    }

    public final void zzve() {
        AppMethodBeat.m2504i(3473);
        if (this.zzbwv.remaining() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzbwv.remaining())}));
            AppMethodBeat.m2505o(3473);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(3473);
    }
}
