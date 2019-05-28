package com.google.android.gms.internal.wearable;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

public final class zzk {
    private final byte[] buffer;
    private final int zzgr;
    private final int zzgs;
    private int zzgt;
    private int zzgu;
    private int zzgv;
    private int zzgw;
    private int zzgx = BaseClientBuilder.API_PRIORITY_OTHER;
    private int zzgy;
    private int zzgz = 64;
    private int zzha = 67108864;

    private zzk(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(70715);
        this.buffer = bArr;
        this.zzgr = i;
        int i3 = i + i2;
        this.zzgt = i3;
        this.zzgs = i3;
        this.zzgv = i;
        AppMethodBeat.m2505o(70715);
    }

    public static zzk zza(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(70704);
        zzk zzk = new zzk(bArr, 0, i2);
        AppMethodBeat.m2505o(70704);
        return zzk;
    }

    private final void zzh(int i) {
        AppMethodBeat.m2504i(70722);
        zzs zzv;
        if (i < 0) {
            zzv = zzs.zzv();
            AppMethodBeat.m2505o(70722);
            throw zzv;
        } else if (this.zzgv + i > this.zzgx) {
            zzh(this.zzgx - this.zzgv);
            zzv = zzs.zzu();
            AppMethodBeat.m2505o(70722);
            throw zzv;
        } else if (i <= this.zzgt - this.zzgv) {
            this.zzgv += i;
            AppMethodBeat.m2505o(70722);
        } else {
            zzv = zzs.zzu();
            AppMethodBeat.m2505o(70722);
            throw zzv;
        }
    }

    private final void zzo() {
        this.zzgt += this.zzgu;
        int i = this.zzgt;
        if (i > this.zzgx) {
            this.zzgu = i - this.zzgx;
            this.zzgt -= this.zzgu;
            return;
        }
        this.zzgu = 0;
    }

    private final byte zzq() {
        AppMethodBeat.m2504i(70721);
        if (this.zzgv == this.zzgt) {
            zzs zzu = zzs.zzu();
            AppMethodBeat.m2505o(70721);
            throw zzu;
        }
        byte[] bArr = this.buffer;
        int i = this.zzgv;
        this.zzgv = i + 1;
        byte b = bArr[i];
        AppMethodBeat.m2505o(70721);
        return b;
    }

    public final int getPosition() {
        return this.zzgv - this.zzgr;
    }

    public final byte[] readBytes() {
        AppMethodBeat.m2504i(70710);
        int zzk = zzk();
        zzs zzv;
        byte[] bArr;
        if (zzk < 0) {
            zzv = zzs.zzv();
            AppMethodBeat.m2505o(70710);
            throw zzv;
        } else if (zzk == 0) {
            bArr = zzw.zzhy;
            AppMethodBeat.m2505o(70710);
            return bArr;
        } else if (zzk > this.zzgt - this.zzgv) {
            zzv = zzs.zzu();
            AppMethodBeat.m2505o(70710);
            throw zzv;
        } else {
            bArr = new byte[zzk];
            System.arraycopy(this.buffer, this.zzgv, bArr, 0, zzk);
            this.zzgv = zzk + this.zzgv;
            AppMethodBeat.m2505o(70710);
            return bArr;
        }
    }

    public final String readString() {
        AppMethodBeat.m2504i(70708);
        int zzk = zzk();
        zzs zzv;
        if (zzk < 0) {
            zzv = zzs.zzv();
            AppMethodBeat.m2505o(70708);
            throw zzv;
        } else if (zzk > this.zzgt - this.zzgv) {
            zzv = zzs.zzu();
            AppMethodBeat.m2505o(70708);
            throw zzv;
        } else {
            String str = new String(this.buffer, this.zzgv, zzk, zzr.UTF_8);
            this.zzgv = zzk + this.zzgv;
            AppMethodBeat.m2505o(70708);
            return str;
        }
    }

    public final void zza(zzt zzt) {
        AppMethodBeat.m2504i(70709);
        int zzk = zzk();
        if (this.zzgy >= this.zzgz) {
            zzs zzs = new zzs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
            AppMethodBeat.m2505o(70709);
            throw zzs;
        }
        zzk = zze(zzk);
        this.zzgy++;
        zzt.zza(this);
        zzc(0);
        this.zzgy--;
        zzf(zzk);
        AppMethodBeat.m2505o(70709);
    }

    public final byte[] zzb(int i, int i2) {
        AppMethodBeat.m2504i(70718);
        byte[] bArr;
        if (i2 == 0) {
            bArr = zzw.zzhy;
            AppMethodBeat.m2505o(70718);
            return bArr;
        }
        bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzgr + i, bArr, 0, i2);
        AppMethodBeat.m2505o(70718);
        return bArr;
    }

    public final void zzc(int i) {
        AppMethodBeat.m2504i(70706);
        if (this.zzgw != i) {
            zzs zzs = new zzs("Protocol message end-group tag did not match expected tag.");
            AppMethodBeat.m2505o(70706);
            throw zzs;
        }
        AppMethodBeat.m2505o(70706);
    }

    /* Access modifiers changed, original: final */
    public final void zzc(int i, int i2) {
        AppMethodBeat.m2504i(70720);
        IllegalArgumentException illegalArgumentException;
        if (i > this.zzgv - this.zzgr) {
            illegalArgumentException = new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzgv - this.zzgr));
            AppMethodBeat.m2505o(70720);
            throw illegalArgumentException;
        } else if (i < 0) {
            illegalArgumentException = new IllegalArgumentException("Bad position " + i);
            AppMethodBeat.m2505o(70720);
            throw illegalArgumentException;
        } else {
            this.zzgv = this.zzgr + i;
            this.zzgw = i2;
            AppMethodBeat.m2505o(70720);
        }
    }

    public final boolean zzd(int i) {
        AppMethodBeat.m2504i(70707);
        switch (i & 7) {
            case 0:
                zzk();
                AppMethodBeat.m2505o(70707);
                return true;
            case 1:
                zzn();
                AppMethodBeat.m2505o(70707);
                return true;
            case 2:
                zzh(zzk());
                AppMethodBeat.m2505o(70707);
                return true;
            case 3:
                break;
            case 4:
                AppMethodBeat.m2505o(70707);
                return false;
            case 5:
                zzm();
                AppMethodBeat.m2505o(70707);
                return true;
            default:
                zzs zzs = new zzs("Protocol message tag had invalid wire type.");
                AppMethodBeat.m2505o(70707);
                throw zzs;
        }
        int zzj;
        do {
            zzj = zzj();
            if (zzj != 0) {
            }
            zzc(((i >>> 3) << 3) | 4);
            AppMethodBeat.m2505o(70707);
            return true;
        } while (zzd(zzj));
        zzc(((i >>> 3) << 3) | 4);
        AppMethodBeat.m2505o(70707);
        return true;
    }

    public final int zze(int i) {
        AppMethodBeat.m2504i(70716);
        zzs zzv;
        if (i < 0) {
            zzv = zzs.zzv();
            AppMethodBeat.m2505o(70716);
            throw zzv;
        }
        int i2 = this.zzgv + i;
        int i3 = this.zzgx;
        if (i2 > i3) {
            zzv = zzs.zzu();
            AppMethodBeat.m2505o(70716);
            throw zzv;
        }
        this.zzgx = i2;
        zzo();
        AppMethodBeat.m2505o(70716);
        return i3;
    }

    public final void zzf(int i) {
        AppMethodBeat.m2504i(70717);
        this.zzgx = i;
        zzo();
        AppMethodBeat.m2505o(70717);
    }

    public final void zzg(int i) {
        AppMethodBeat.m2504i(70719);
        zzc(i, this.zzgw);
        AppMethodBeat.m2505o(70719);
    }

    public final int zzj() {
        AppMethodBeat.m2504i(70705);
        if (this.zzgv == this.zzgt) {
            this.zzgw = 0;
            AppMethodBeat.m2505o(70705);
            return 0;
        }
        this.zzgw = zzk();
        if (this.zzgw == 0) {
            zzs zzs = new zzs("Protocol message contained an invalid tag (zero).");
            AppMethodBeat.m2505o(70705);
            throw zzs;
        }
        int i = this.zzgw;
        AppMethodBeat.m2505o(70705);
        return i;
    }

    public final int zzk() {
        AppMethodBeat.m2504i(70711);
        int zzq = zzq();
        if (zzq >= 0) {
            AppMethodBeat.m2505o(70711);
        } else {
            zzq &= C31128d.MIC_SketchMark;
            byte zzq2 = zzq();
            if (zzq2 >= (byte) 0) {
                zzq |= zzq2 << 7;
            } else {
                zzq |= (zzq2 & C31128d.MIC_SketchMark) << 7;
                zzq2 = zzq();
                if (zzq2 >= (byte) 0) {
                    zzq |= zzq2 << 14;
                } else {
                    zzq |= (zzq2 & C31128d.MIC_SketchMark) << 14;
                    zzq2 = zzq();
                    if (zzq2 >= (byte) 0) {
                        zzq |= zzq2 << 21;
                    } else {
                        zzq |= (zzq2 & C31128d.MIC_SketchMark) << 21;
                        zzq2 = zzq();
                        zzq |= zzq2 << 28;
                        if (zzq2 < (byte) 0) {
                            int i = 0;
                            while (i < 5) {
                                if (zzq() >= (byte) 0) {
                                    AppMethodBeat.m2505o(70711);
                                } else {
                                    i++;
                                }
                            }
                            zzs zzw = zzs.zzw();
                            AppMethodBeat.m2505o(70711);
                            throw zzw;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(70711);
        }
        return zzq;
    }

    public final long zzl() {
        AppMethodBeat.m2504i(70712);
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzq = zzq();
            j |= ((long) (zzq & C31128d.MIC_SketchMark)) << i;
            if ((zzq & 128) == 0) {
                AppMethodBeat.m2505o(70712);
                return j;
            }
        }
        zzs zzw = zzs.zzw();
        AppMethodBeat.m2505o(70712);
        throw zzw;
    }

    public final int zzm() {
        AppMethodBeat.m2504i(70713);
        int zzq = (((zzq() & 255) | ((zzq() & 255) << 8)) | ((zzq() & 255) << 16)) | ((zzq() & 255) << 24);
        AppMethodBeat.m2505o(70713);
        return zzq;
    }

    public final long zzn() {
        AppMethodBeat.m2504i(70714);
        byte zzq = zzq();
        byte zzq2 = zzq();
        long j = (((long) zzq2) & 255) << 8;
        j = ((((((j | (((long) zzq) & 255)) | ((((long) zzq()) & 255) << 16)) | ((((long) zzq()) & 255) << 24)) | ((((long) zzq()) & 255) << 32)) | ((((long) zzq()) & 255) << 40)) | ((((long) zzq()) & 255) << 48)) | ((((long) zzq()) & 255) << 56);
        AppMethodBeat.m2505o(70714);
        return j;
    }

    public final int zzp() {
        if (this.zzgx == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.zzgx - this.zzgv;
    }
}
