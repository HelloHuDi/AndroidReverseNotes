package com.google.android.gms.internal.measurement;

public abstract class zzaby<M extends zzaby<M>> extends zzace {
    protected zzaca zzbww;

    public /* synthetic */ Object clone() {
        zzaby zzaby = (zzaby) super.clone();
        zzacc.zza(this, zzaby);
        return zzaby;
    }

    /* Access modifiers changed, original: protected */
    public int zza() {
        int i = 0;
        if (this.zzbww == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.zzbww.size()) {
                return i3;
            }
            i = this.zzbww.zzau(i2).zza() + i3;
            i2++;
        }
    }

    public final <T> T zza(zzabz<M, T> zzabz) {
        if (this.zzbww == null) {
            return null;
        }
        zzacb zzat = this.zzbww.zzat(zzabz.tag >>> 3);
        return zzat != null ? zzat.zzb(zzabz) : null;
    }

    public void zza(zzabw zzabw) {
        if (this.zzbww != null) {
            for (int i = 0; i < this.zzbww.size(); i++) {
                this.zzbww.zzau(i).zza(zzabw);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zza(zzabv zzabv, int i) {
        int position = zzabv.getPosition();
        if (!zzabv.zzak(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzacg zzacg = new zzacg(i, zzabv.zzc(position, zzabv.getPosition() - position));
        zzacb zzacb = null;
        if (this.zzbww == null) {
            this.zzbww = new zzaca();
        } else {
            zzacb = this.zzbww.zzat(i2);
        }
        if (zzacb == null) {
            zzacb = new zzacb();
            this.zzbww.zza(i2, zzacb);
        }
        zzacb.zza(zzacg);
        return true;
    }

    public final /* synthetic */ zzace zzvf() {
        return (zzaby) clone();
    }
}
