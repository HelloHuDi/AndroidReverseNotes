package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzit implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ boolean zzanz;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzit(zzii zzii, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzdz zzdz) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
        this.zzanz = z;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69332);
        synchronized (this.zzapf) {
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().zzd("Failed to get user properties", zzfg.zzbm(this.zzanj), this.zzanh, this.zzani);
                    this.zzapf.set(Collections.emptyList());
                    this.zzapf.notify();
                    AppMethodBeat.m2505o(69332);
                    return;
                }
                if (TextUtils.isEmpty(this.zzanj)) {
                    this.zzapf.set(zzd.zza(this.zzanh, this.zzani, this.zzanz, this.zzane));
                } else {
                    this.zzapf.set(zzd.zza(this.zzanj, this.zzanh, this.zzani, this.zzanz));
                }
                zzii.zze(this.zzape);
                this.zzapf.notify();
            } catch (RemoteException e) {
                this.zzape.zzge().zzim().zzd("Failed to get user properties", zzfg.zzbm(this.zzanj), this.zzanh, e);
                this.zzapf.set(Collections.emptyList());
                this.zzapf.notify();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(69332);
            }
        }
        AppMethodBeat.m2505o(69332);
    }
}
