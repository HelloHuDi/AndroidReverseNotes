package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class zzgn extends zzez {
    private final zzjr zzajp;
    private Boolean zzanc;
    private String zzand;

    public zzgn(zzjr zzjr) {
        this(zzjr, null);
    }

    private zzgn(zzjr zzjr, String str) {
        AppMethodBeat.i(69090);
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
        this.zzand = null;
        AppMethodBeat.o(69090);
    }

    private final void zzb(zzdz zzdz, boolean z) {
        AppMethodBeat.i(69098);
        Preconditions.checkNotNull(zzdz);
        zzc(zzdz.packageName, false);
        this.zzajp.zzgb().zzcg(zzdz.zzadm);
        AppMethodBeat.o(69098);
    }

    /* JADX WARNING: Missing block: B:17:0x006c, code skipped:
            if (r5.zzanc.booleanValue() == false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(69099);
        SecurityException securityException;
        if (TextUtils.isEmpty(str)) {
            this.zzajp.zzge().zzim().log("Measurement Service called without app package");
            securityException = new SecurityException("Measurement Service called without app package");
            AppMethodBeat.o(69099);
            throw securityException;
        }
        if (z) {
            try {
                if (this.zzanc == null) {
                    if ("com.google.android.gms".equals(this.zzand) || UidVerifier.isGooglePlayServicesUid(this.zzajp.getContext(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zzajp.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = true;
                    }
                    this.zzanc = Boolean.valueOf(z2);
                }
            } catch (SecurityException securityException2) {
                this.zzajp.zzge().zzim().zzg("Measurement Service called with invalid calling package. appId", zzfg.zzbm(str));
                AppMethodBeat.o(69099);
                throw securityException2;
            }
        }
        if (this.zzand == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zzajp.getContext(), Binder.getCallingUid(), str)) {
            this.zzand = str;
        }
        if (!str.equals(this.zzand)) {
            securityException2 = new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            AppMethodBeat.o(69099);
            throw securityException2;
        }
        AppMethodBeat.o(69099);
    }

    @VisibleForTesting
    private final void zze(Runnable runnable) {
        AppMethodBeat.i(69109);
        Preconditions.checkNotNull(runnable);
        if (((Boolean) zzew.zzaia.get()).booleanValue() && this.zzajp.zzgd().zzjk()) {
            runnable.run();
            AppMethodBeat.o(69109);
            return;
        }
        this.zzajp.zzgd().zzc(runnable);
        AppMethodBeat.o(69109);
    }

    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        AppMethodBeat.i(69096);
        zzb(zzdz, false);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzhd(this, zzdz)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            AppMethodBeat.o(69096);
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(zzdz.packageName), e);
            AppMethodBeat.o(69096);
            return null;
        }
    }

    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        AppMethodBeat.i(69106);
        zzb(zzdz, false);
        List list;
        try {
            list = (List) this.zzajp.zzgd().zzb(new zzgv(this, zzdz, str, str2)).get();
            AppMethodBeat.o(69106);
            return list;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", e);
            list = Collections.emptyList();
            AppMethodBeat.o(69106);
            return list;
        }
    }

    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(69105);
        zzc(str, true);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzgu(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            AppMethodBeat.o(69105);
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(str), e);
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(69105);
            return emptyList;
        }
    }

    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        AppMethodBeat.i(69104);
        zzb(zzdz, false);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzgt(this, zzdz, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            AppMethodBeat.o(69104);
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(zzdz.packageName), e);
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(69104);
            return emptyList;
        }
    }

    public final void zza(long j, String str, String str2, String str3) {
        AppMethodBeat.i(69100);
        zze(new zzhf(this, str2, str3, str, j));
        AppMethodBeat.o(69100);
    }

    public final void zza(zzdz zzdz) {
        AppMethodBeat.i(69097);
        zzb(zzdz, false);
        zze(new zzhe(this, zzdz));
        AppMethodBeat.o(69097);
    }

    public final void zza(zzed zzed, zzdz zzdz) {
        AppMethodBeat.i(69102);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotNull(zzed.zzaep);
        zzb(zzdz, false);
        zzed zzed2 = new zzed(zzed);
        zzed2.packageName = zzdz.packageName;
        if (zzed.zzaep.getValue() == null) {
            zze(new zzgp(this, zzed2, zzdz));
            AppMethodBeat.o(69102);
            return;
        }
        zze(new zzgq(this, zzed2, zzdz));
        AppMethodBeat.o(69102);
    }

    public final void zza(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.i(69092);
        Preconditions.checkNotNull(zzeu);
        zzb(zzdz, false);
        zze(new zzgy(this, zzeu, zzdz));
        AppMethodBeat.o(69092);
    }

    public final void zza(zzeu zzeu, String str, String str2) {
        AppMethodBeat.i(69093);
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzc(str, true);
        zze(new zzgz(this, zzeu, str));
        AppMethodBeat.o(69093);
    }

    public final void zza(zzjx zzjx, zzdz zzdz) {
        AppMethodBeat.i(69095);
        Preconditions.checkNotNull(zzjx);
        zzb(zzdz, false);
        if (zzjx.getValue() == null) {
            zze(new zzhb(this, zzjx, zzdz));
            AppMethodBeat.o(69095);
            return;
        }
        zze(new zzhc(this, zzjx, zzdz));
        AppMethodBeat.o(69095);
    }

    public final byte[] zza(zzeu zzeu, String str) {
        AppMethodBeat.i(69094);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeu);
        zzc(str, true);
        this.zzajp.zzge().zzis().zzg("Log and bundle. event", this.zzajp.zzga().zzbj(zzeu.name));
        long nanoTime = this.zzajp.zzbt().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzajp.zzgd().zzc(new zzha(this, zzeu, str)).get();
            if (bArr == null) {
                this.zzajp.zzge().zzim().zzg("Log and bundle returned null. appId", zzfg.zzbm(str));
                bArr = new byte[0];
            }
            this.zzajp.zzge().zzis().zzd("Log and bundle processed. event, size, time_ms", this.zzajp.zzga().zzbj(zzeu.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzajp.zzbt().nanoTime() / 1000000) - nanoTime));
            AppMethodBeat.o(69094);
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zzd("Failed to log and bundle. appId, event, error", zzfg.zzbm(str), this.zzajp.zzga().zzbj(zzeu.name), e);
            AppMethodBeat.o(69094);
            return null;
        }
    }

    public final void zzb(zzdz zzdz) {
        AppMethodBeat.i(69091);
        zzb(zzdz, false);
        zze(new zzgo(this, zzdz));
        AppMethodBeat.o(69091);
    }

    public final void zzb(zzed zzed) {
        AppMethodBeat.i(69103);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotNull(zzed.zzaep);
        zzc(zzed.packageName, true);
        zzed zzed2 = new zzed(zzed);
        if (zzed.zzaep.getValue() == null) {
            zze(new zzgr(this, zzed2));
            AppMethodBeat.o(69103);
            return;
        }
        zze(new zzgs(this, zzed2));
        AppMethodBeat.o(69103);
    }

    public final String zzc(zzdz zzdz) {
        AppMethodBeat.i(69101);
        zzb(zzdz, false);
        String zzh = this.zzajp.zzh(zzdz);
        AppMethodBeat.o(69101);
        return zzh;
    }

    public final void zzd(zzdz zzdz) {
        AppMethodBeat.i(69108);
        zzc(zzdz.packageName, false);
        zze(new zzgx(this, zzdz));
        AppMethodBeat.o(69108);
    }

    public final List<zzed> zze(String str, String str2, String str3) {
        AppMethodBeat.i(69107);
        zzc(str, true);
        List list;
        try {
            list = (List) this.zzajp.zzgd().zzb(new zzgw(this, str, str2, str3)).get();
            AppMethodBeat.o(69107);
            return list;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", e);
            list = Collections.emptyList();
            AppMethodBeat.o(69107);
            return list;
        }
    }
}
