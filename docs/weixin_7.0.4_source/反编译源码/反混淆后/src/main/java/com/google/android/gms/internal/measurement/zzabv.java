package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

public final class zzabv {
    private final byte[] buffer;
    private int zzbrd = 64;
    private int zzbre = 67108864;
    private int zzbri;
    private int zzbrk = BaseClientBuilder.API_PRIORITY_OTHER;
    private final int zzbwp;
    private final int zzbwq;
    private int zzbwr;
    private int zzbws;
    private int zzbwt;
    private int zzbwu;

    private zzabv(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(3444);
        this.buffer = bArr;
        this.zzbwp = i;
        int i3 = i + i2;
        this.zzbwr = i3;
        this.zzbwq = i3;
        this.zzbws = i;
        AppMethodBeat.m2505o(3444);
    }

    public static zzabv zza(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(3432);
        zzabv zzabv = new zzabv(bArr, 0, i2);
        AppMethodBeat.m2505o(3432);
        return zzabv;
    }

    private final void zzan(int i) {
        AppMethodBeat.m2504i(3451);
        zzacd zzvi;
        if (i < 0) {
            zzvi = zzacd.zzvi();
            AppMethodBeat.m2505o(3451);
            throw zzvi;
        } else if (this.zzbws + i > this.zzbrk) {
            zzan(this.zzbrk - this.zzbws);
            zzvi = zzacd.zzvh();
            AppMethodBeat.m2505o(3451);
            throw zzvi;
        } else if (i <= this.zzbwr - this.zzbws) {
            this.zzbws += i;
            AppMethodBeat.m2505o(3451);
        } else {
            zzvi = zzacd.zzvh();
            AppMethodBeat.m2505o(3451);
            throw zzvi;
        }
    }

    public static zzabv zzi(byte[] bArr) {
        AppMethodBeat.m2504i(3431);
        zzabv zza = zza(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(3431);
        return zza;
    }

    private final void zzta() {
        this.zzbwr += this.zzbri;
        int i = this.zzbwr;
        if (i > this.zzbrk) {
            this.zzbri = i - this.zzbrk;
            this.zzbwr -= this.zzbri;
            return;
        }
        this.zzbri = 0;
    }

    private final byte zzvd() {
        AppMethodBeat.m2504i(3450);
        if (this.zzbws == this.zzbwr) {
            zzacd zzvh = zzacd.zzvh();
            AppMethodBeat.m2505o(3450);
            throw zzvh;
        }
        byte[] bArr = this.buffer;
        int i = this.zzbws;
        this.zzbws = i + 1;
        byte b = bArr[i];
        AppMethodBeat.m2505o(3450);
        return b;
    }

    public final int getPosition() {
        return this.zzbws - this.zzbwp;
    }

    public final String readString() {
        AppMethodBeat.m2504i(3437);
        int zzuy = zzuy();
        zzacd zzvi;
        if (zzuy < 0) {
            zzvi = zzacd.zzvi();
            AppMethodBeat.m2505o(3437);
            throw zzvi;
        } else if (zzuy > this.zzbwr - this.zzbws) {
            zzvi = zzacd.zzvh();
            AppMethodBeat.m2505o(3437);
            throw zzvi;
        } else {
            String str = new String(this.buffer, this.zzbws, zzuy, zzacc.UTF_8);
            this.zzbws = zzuy + this.zzbws;
            AppMethodBeat.m2505o(3437);
            return str;
        }
    }

    public final void zza(zzace zzace) {
        AppMethodBeat.m2504i(3439);
        int zzuy = zzuy();
        if (this.zzbwu >= this.zzbrd) {
            zzacd zzvk = zzacd.zzvk();
            AppMethodBeat.m2505o(3439);
            throw zzvk;
        }
        zzuy = zzaf(zzuy);
        this.zzbwu++;
        zzace.zzb(this);
        zzaj(0);
        this.zzbwu--;
        zzal(zzuy);
        AppMethodBeat.m2505o(3439);
    }

    public final void zza(zzace zzace, int i) {
        AppMethodBeat.m2504i(3438);
        if (this.zzbwu >= this.zzbrd) {
            zzacd zzvk = zzacd.zzvk();
            AppMethodBeat.m2505o(3438);
            throw zzvk;
        }
        this.zzbwu++;
        zzace.zzb(this);
        zzaj((i << 3) | 4);
        this.zzbwu--;
        AppMethodBeat.m2505o(3438);
    }

    public final int zzaf(int i) {
        AppMethodBeat.m2504i(3445);
        zzacd zzvi;
        if (i < 0) {
            zzvi = zzacd.zzvi();
            AppMethodBeat.m2505o(3445);
            throw zzvi;
        }
        int i2 = this.zzbws + i;
        int i3 = this.zzbrk;
        if (i2 > i3) {
            zzvi = zzacd.zzvh();
            AppMethodBeat.m2505o(3445);
            throw zzvi;
        }
        this.zzbrk = i2;
        zzta();
        AppMethodBeat.m2505o(3445);
        return i3;
    }

    public final void zzaj(int i) {
        AppMethodBeat.m2504i(3434);
        if (this.zzbwt != i) {
            zzacd zzacd = new zzacd("Protocol message end-group tag did not match expected tag.");
            AppMethodBeat.m2505o(3434);
            throw zzacd;
        }
        AppMethodBeat.m2505o(3434);
    }

    public final boolean zzak(int i) {
        AppMethodBeat.m2504i(3435);
        switch (i & 7) {
            case 0:
                zzuy();
                AppMethodBeat.m2505o(3435);
                return true;
            case 1:
                zzvb();
                AppMethodBeat.m2505o(3435);
                return true;
            case 2:
                zzan(zzuy());
                AppMethodBeat.m2505o(3435);
                return true;
            case 3:
                break;
            case 4:
                AppMethodBeat.m2505o(3435);
                return false;
            case 5:
                zzva();
                AppMethodBeat.m2505o(3435);
                return true;
            default:
                zzacd zzacd = new zzacd("Protocol message tag had invalid wire type.");
                AppMethodBeat.m2505o(3435);
                throw zzacd;
        }
        int zzuw;
        do {
            zzuw = zzuw();
            if (zzuw != 0) {
            }
            zzaj(((i >>> 3) << 3) | 4);
            AppMethodBeat.m2505o(3435);
            return true;
        } while (zzak(zzuw));
        zzaj(((i >>> 3) << 3) | 4);
        AppMethodBeat.m2505o(3435);
        return true;
    }

    public final void zzal(int i) {
        AppMethodBeat.m2504i(3446);
        this.zzbrk = i;
        zzta();
        AppMethodBeat.m2505o(3446);
    }

    public final void zzam(int i) {
        AppMethodBeat.m2504i(3448);
        zzd(i, this.zzbwt);
        AppMethodBeat.m2505o(3448);
    }

    public final byte[] zzc(int i, int i2) {
        AppMethodBeat.m2504i(3447);
        byte[] bArr;
        if (i2 == 0) {
            bArr = zzach.zzbxs;
            AppMethodBeat.m2505o(3447);
            return bArr;
        }
        bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbwp + i, bArr, 0, i2);
        AppMethodBeat.m2505o(3447);
        return bArr;
    }

    /* Access modifiers changed, original: final */
    public final void zzd(int i, int i2) {
        AppMethodBeat.m2504i(3449);
        IllegalArgumentException illegalArgumentException;
        if (i > this.zzbws - this.zzbwp) {
            illegalArgumentException = new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbws - this.zzbwp));
            AppMethodBeat.m2505o(3449);
            throw illegalArgumentException;
        } else if (i < 0) {
            illegalArgumentException = new IllegalArgumentException("Bad position " + i);
            AppMethodBeat.m2505o(3449);
            throw illegalArgumentException;
        } else {
            this.zzbws = this.zzbwp + i;
            this.zzbwt = i2;
            AppMethodBeat.m2505o(3449);
        }
    }

    public final int zzuw() {
        AppMethodBeat.m2504i(3433);
        if (this.zzbws == this.zzbwr) {
            this.zzbwt = 0;
            AppMethodBeat.m2505o(3433);
            return 0;
        }
        this.zzbwt = zzuy();
        if (this.zzbwt == 0) {
            zzacd zzacd = new zzacd("Protocol message contained an invalid tag (zero).");
            AppMethodBeat.m2505o(3433);
            throw zzacd;
        }
        int i = this.zzbwt;
        AppMethodBeat.m2505o(3433);
        return i;
    }

    public final boolean zzux() {
        AppMethodBeat.m2504i(3436);
        if (zzuy() != 0) {
            AppMethodBeat.m2505o(3436);
            return true;
        }
        AppMethodBeat.m2505o(3436);
        return false;
    }

    public final int zzuy() {
        AppMethodBeat.m2504i(3440);
        int zzvd = zzvd();
        if (zzvd >= 0) {
            AppMethodBeat.m2505o(3440);
        } else {
            zzvd &= C31128d.MIC_SketchMark;
            byte zzvd2 = zzvd();
            if (zzvd2 >= (byte) 0) {
                zzvd |= zzvd2 << 7;
            } else {
                zzvd |= (zzvd2 & C31128d.MIC_SketchMark) << 7;
                zzvd2 = zzvd();
                if (zzvd2 >= (byte) 0) {
                    zzvd |= zzvd2 << 14;
                } else {
                    zzvd |= (zzvd2 & C31128d.MIC_SketchMark) << 14;
                    zzvd2 = zzvd();
                    if (zzvd2 >= (byte) 0) {
                        zzvd |= zzvd2 << 21;
                    } else {
                        zzvd |= (zzvd2 & C31128d.MIC_SketchMark) << 21;
                        zzvd2 = zzvd();
                        zzvd |= zzvd2 << 28;
                        if (zzvd2 < (byte) 0) {
                            int i = 0;
                            while (i < 5) {
                                if (zzvd() >= (byte) 0) {
                                    AppMethodBeat.m2505o(3440);
                                } else {
                                    i++;
                                }
                            }
                            zzacd zzvj = zzacd.zzvj();
                            AppMethodBeat.m2505o(3440);
                            throw zzvj;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(3440);
        }
        return zzvd;
    }

    public final long zzuz() {
        AppMethodBeat.m2504i(3441);
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvd = zzvd();
            j |= ((long) (zzvd & C31128d.MIC_SketchMark)) << i;
            if ((zzvd & 128) == 0) {
                AppMethodBeat.m2505o(3441);
                return j;
            }
        }
        zzacd zzvj = zzacd.zzvj();
        AppMethodBeat.m2505o(3441);
        throw zzvj;
    }

    public final int zzva() {
        AppMethodBeat.m2504i(3442);
        int zzvd = (((zzvd() & 255) | ((zzvd() & 255) << 8)) | ((zzvd() & 255) << 16)) | ((zzvd() & 255) << 24);
        AppMethodBeat.m2505o(3442);
        return zzvd;
    }

    public final long zzvb() {
        AppMethodBeat.m2504i(3443);
        byte zzvd = zzvd();
        byte zzvd2 = zzvd();
        long j = (((long) zzvd2) & 255) << 8;
        j = ((((((j | (((long) zzvd) & 255)) | ((((long) zzvd()) & 255) << 16)) | ((((long) zzvd()) & 255) << 24)) | ((((long) zzvd()) & 255) << 32)) | ((((long) zzvd()) & 255) << 40)) | ((((long) zzvd()) & 255) << 48)) | ((((long) zzvd()) & 255) << 56);
        AppMethodBeat.m2505o(3443);
        return j;
    }

    public final int zzvc() {
        if (this.zzbrk == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.zzbrk - this.zzbws;
    }
}
