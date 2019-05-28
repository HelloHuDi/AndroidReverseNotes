package com.google.android.gms.internal.measurement;

abstract class zzhh extends zzhg {
    private boolean zzvo;

    zzhh(zzgl zzgl) {
        super(zzgl);
        this.zzacw.zzb(this);
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

    /* Access modifiers changed, original: protected */
    public void zzih() {
    }

    public final void zzjw() {
        if (this.zzvo) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzih();
        this.zzacw.zzju();
        this.zzvo = true;
    }

    public final void zzm() {
        if (this.zzvo) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzhf()) {
            this.zzacw.zzju();
            this.zzvo = true;
        }
    }
}
