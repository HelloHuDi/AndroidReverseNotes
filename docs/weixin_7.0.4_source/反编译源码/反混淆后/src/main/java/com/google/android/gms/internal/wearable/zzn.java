package com.google.android.gms.internal.wearable;

public abstract class zzn<M extends zzn<M>> extends zzt {
    protected zzp zzhc;

    public /* synthetic */ Object clone() {
        zzn zzn = (zzn) super.clone();
        zzr.zza(this, zzn);
        return zzn;
    }

    public void zza(zzl zzl) {
        if (this.zzhc != null) {
            for (int i = 0; i < this.zzhc.size(); i++) {
                this.zzhc.zzp(i).zza(zzl);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zza(zzk zzk, int i) {
        int position = zzk.getPosition();
        if (!zzk.zzd(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzv zzv = new zzv(i, zzk.zzb(position, zzk.getPosition() - position));
        zzq zzq = null;
        if (this.zzhc == null) {
            this.zzhc = new zzp();
        } else {
            zzq = this.zzhc.zzo(i2);
        }
        if (zzq == null) {
            zzq = new zzq();
            this.zzhc.zza(i2, zzq);
        }
        zzq.zza(zzv);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public int zzg() {
        int i = 0;
        if (this.zzhc == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.zzhc.size()) {
                return i3;
            }
            i = this.zzhc.zzp(i2).zzg() + i3;
            i2++;
        }
    }

    public final /* synthetic */ zzt zzs() {
        return (zzn) clone();
    }
}
