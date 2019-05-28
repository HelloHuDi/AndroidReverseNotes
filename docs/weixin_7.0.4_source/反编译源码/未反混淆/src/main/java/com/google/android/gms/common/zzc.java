package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzc extends CertData {
    private static final WeakReference<byte[]> zzbf = new WeakReference(null);
    private WeakReference<byte[]> zzbe = zzbf;

    zzc(byte[] bArr) {
        super(bArr);
    }

    /* Access modifiers changed, original: final */
    public final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzbe.get();
            if (bArr == null) {
                bArr = zzf();
                this.zzbe = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] zzf();
}
