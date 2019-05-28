package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.view.C31128d;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzl {
    private final ByteBuffer zzhb;

    private zzl(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(70724);
        this.zzhb = byteBuffer;
        this.zzhb.order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.m2505o(70724);
    }

    private zzl(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
        AppMethodBeat.m2504i(70723);
        AppMethodBeat.m2505o(70723);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.m2504i(70732);
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
                                AppMethodBeat.m2505o(70732);
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
                    AppMethodBeat.m2505o(70732);
                    throw illegalArgumentException2;
                }
                AppMethodBeat.m2505o(70732);
                return i;
            }
        }
        i = i3;
        if (i >= length) {
        }
    }

    private final void zza(long j) {
        AppMethodBeat.m2504i(70747);
        while ((-128 & j) != 0) {
            zzj((((int) j) & C31128d.MIC_SketchMark) | 128);
            j >>>= 7;
        }
        zzj((int) j);
        AppMethodBeat.m2505o(70747);
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i = 0;
        AppMethodBeat.m2504i(70733);
        int position;
        int remaining;
        if (byteBuffer.isReadOnly()) {
            ReadOnlyBufferException readOnlyBufferException = new ReadOnlyBufferException();
            AppMethodBeat.m2505o(70733);
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
                            AppMethodBeat.m2505o(70733);
                            throw illegalArgumentException;
                        } else {
                            arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                            AppMethodBeat.m2505o(70733);
                            throw arrayIndexOutOfBoundsException;
                        }
                        remaining++;
                        position = i;
                    }
                    i = position;
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
                AppMethodBeat.m2505o(70733);
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(arrayIndexOutOfBoundsException2);
                AppMethodBeat.m2505o(70733);
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
                    AppMethodBeat.m2505o(70733);
                    throw illegalArgumentException2;
                }
                i++;
            }
            AppMethodBeat.m2505o(70733);
        }
    }

    public static int zzb(int i, long j) {
        AppMethodBeat.m2504i(70734);
        int zzk = zzk(i);
        int i2 = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
        i2 += zzk;
        AppMethodBeat.m2505o(70734);
        return i2;
    }

    public static int zzb(int i, zzt zzt) {
        AppMethodBeat.m2504i(70737);
        int zzk = zzk(i);
        int zzx = zzt.zzx();
        zzk += zzx + zzm(zzx);
        AppMethodBeat.m2505o(70737);
        return zzk;
    }

    public static int zzb(int i, String str) {
        AppMethodBeat.m2504i(70736);
        int zzk = zzk(i) + zzg(str);
        AppMethodBeat.m2505o(70736);
        return zzk;
    }

    public static zzl zzb(byte[] bArr) {
        AppMethodBeat.m2504i(70725);
        zzl zzb = zzb(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(70725);
        return zzb;
    }

    public static zzl zzb(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(70726);
        zzl zzl = new zzl(bArr, 0, i2);
        AppMethodBeat.m2505o(70726);
        return zzl;
    }

    public static int zze(int i, int i2) {
        AppMethodBeat.m2504i(70735);
        int zzk = zzk(i) + zzi(i2);
        AppMethodBeat.m2505o(70735);
        return zzk;
    }

    public static int zzg(String str) {
        AppMethodBeat.m2504i(70739);
        int zza = zza((CharSequence) str);
        zza += zzm(zza);
        AppMethodBeat.m2505o(70739);
        return zza;
    }

    public static int zzi(int i) {
        AppMethodBeat.m2504i(70738);
        if (i >= 0) {
            int zzm = zzm(i);
            AppMethodBeat.m2505o(70738);
            return zzm;
        }
        AppMethodBeat.m2505o(70738);
        return 10;
    }

    private final void zzj(int i) {
        AppMethodBeat.m2504i(70742);
        byte b = (byte) i;
        if (this.zzhb.hasRemaining()) {
            this.zzhb.put(b);
            AppMethodBeat.m2505o(70742);
            return;
        }
        zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
        AppMethodBeat.m2505o(70742);
        throw zzm;
    }

    public static int zzk(int i) {
        AppMethodBeat.m2504i(70745);
        int zzm = zzm(i << 3);
        AppMethodBeat.m2505o(70745);
        return zzm;
    }

    public static int zzm(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzn(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public final void zza(byte b) {
        AppMethodBeat.m2504i(70741);
        if (this.zzhb.hasRemaining()) {
            this.zzhb.put(b);
            AppMethodBeat.m2505o(70741);
            return;
        }
        zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
        AppMethodBeat.m2505o(70741);
        throw zzm;
    }

    public final void zza(int i, float f) {
        AppMethodBeat.m2504i(70727);
        zzf(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzhb.remaining() < 4) {
            zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
            AppMethodBeat.m2505o(70727);
            throw zzm;
        }
        this.zzhb.putInt(floatToIntBits);
        AppMethodBeat.m2505o(70727);
    }

    public final void zza(int i, long j) {
        AppMethodBeat.m2504i(70728);
        zzf(i, 0);
        zza(j);
        AppMethodBeat.m2505o(70728);
    }

    public final void zza(int i, zzt zzt) {
        AppMethodBeat.m2504i(70731);
        zzf(i, 2);
        if (zzt.zzhl < 0) {
            zzt.zzx();
        }
        zzl(zzt.zzhl);
        zzt.zza(this);
        AppMethodBeat.m2505o(70731);
    }

    public final void zza(int i, String str) {
        AppMethodBeat.m2504i(70730);
        zzf(i, 2);
        try {
            int zzm = zzm(str.length());
            if (zzm == zzm(str.length() * 3)) {
                int position = this.zzhb.position();
                if (this.zzhb.remaining() < zzm) {
                    zzm zzm2 = new zzm(zzm + position, this.zzhb.limit());
                    AppMethodBeat.m2505o(70730);
                    throw zzm2;
                }
                this.zzhb.position(position + zzm);
                zza((CharSequence) str, this.zzhb);
                int position2 = this.zzhb.position();
                this.zzhb.position(position);
                zzl((position2 - position) - zzm);
                this.zzhb.position(position2);
                AppMethodBeat.m2505o(70730);
                return;
            }
            zzl(zza((CharSequence) str));
            zza((CharSequence) str, this.zzhb);
            AppMethodBeat.m2505o(70730);
        } catch (BufferOverflowException e) {
            zzm zzm3 = new zzm(this.zzhb.position(), this.zzhb.limit());
            zzm3.initCause(e);
            AppMethodBeat.m2505o(70730);
            throw zzm3;
        }
    }

    public final void zzb(long j) {
        AppMethodBeat.m2504i(70748);
        if (this.zzhb.remaining() < 8) {
            zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
            AppMethodBeat.m2505o(70748);
            throw zzm;
        }
        this.zzhb.putLong(j);
        AppMethodBeat.m2505o(70748);
    }

    public final void zzc(byte[] bArr) {
        AppMethodBeat.m2504i(70743);
        int length = bArr.length;
        if (this.zzhb.remaining() >= length) {
            this.zzhb.put(bArr, 0, length);
            AppMethodBeat.m2505o(70743);
            return;
        }
        zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
        AppMethodBeat.m2505o(70743);
        throw zzm;
    }

    public final void zzd(int i, int i2) {
        AppMethodBeat.m2504i(70729);
        zzf(i, 0);
        if (i2 >= 0) {
            zzl(i2);
            AppMethodBeat.m2505o(70729);
            return;
        }
        zza((long) i2);
        AppMethodBeat.m2505o(70729);
    }

    public final void zzf(int i, int i2) {
        AppMethodBeat.m2504i(70744);
        zzl((i << 3) | i2);
        AppMethodBeat.m2505o(70744);
    }

    public final void zzl(int i) {
        AppMethodBeat.m2504i(70746);
        while ((i & -128) != 0) {
            zzj((i & C31128d.MIC_SketchMark) | 128);
            i >>>= 7;
        }
        zzj(i);
        AppMethodBeat.m2505o(70746);
    }

    public final void zzr() {
        AppMethodBeat.m2504i(70740);
        if (this.zzhb.remaining() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzhb.remaining())}));
            AppMethodBeat.m2505o(70740);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(70740);
    }
}
