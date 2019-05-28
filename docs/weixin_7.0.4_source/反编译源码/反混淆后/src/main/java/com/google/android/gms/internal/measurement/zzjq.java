package com.google.android.gms.internal.measurement;

abstract class zzjq extends zzjp {
    private boolean zzvo;

    zzjq(zzjr zzjr) {
        super(zzjr);
        this.zzajp.zzb(this);
    }

    /* Access modifiers changed, original: final */
    public final boolean isInitialized() {
        return this.zzvo;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzch() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public abstract boolean zzhf();

    public final void zzm() {
        if (this.zzvo) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzhf();
        this.zzajp.zzkz();
        this.zzvo = true;
    }
}
