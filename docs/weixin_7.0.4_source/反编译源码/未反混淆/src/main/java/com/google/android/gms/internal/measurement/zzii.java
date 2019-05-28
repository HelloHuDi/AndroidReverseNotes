package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzii extends zzhh {
    private final zziw zzaox;
    private zzey zzaoy;
    private volatile Boolean zzaoz;
    private final zzem zzapa;
    private final zzjm zzapb;
    private final List<Runnable> zzapc = new ArrayList();
    private final zzem zzapd;

    protected zzii(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(69276);
        this.zzapb = new zzjm(zzgl.zzbt());
        this.zzaox = new zziw(this);
        this.zzapa = new zzij(this, zzgl);
        this.zzapd = new zzio(this, zzgl);
        AppMethodBeat.o(69276);
    }

    private final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(69294);
        zzab();
        if (this.zzaoy != null) {
            this.zzaoy = null;
            zzge().zzit().zzg("Disconnected from device MeasurementService", componentName);
            zzab();
            zzdf();
        }
        AppMethodBeat.o(69294);
    }

    static /* synthetic */ void zzc(zzii zzii) {
        AppMethodBeat.i(69320);
        zzii.zzcv();
        AppMethodBeat.o(69320);
    }

    private final void zzcu() {
        AppMethodBeat.i(69290);
        zzab();
        this.zzapb.start();
        this.zzapa.zzh(((Long) zzew.zzaho.get()).longValue());
        AppMethodBeat.o(69290);
    }

    private final void zzcv() {
        AppMethodBeat.i(69295);
        zzab();
        if (isConnected()) {
            zzge().zzit().log("Inactivity, disconnecting from the service");
            disconnect();
            AppMethodBeat.o(69295);
            return;
        }
        AppMethodBeat.o(69295);
    }

    static /* synthetic */ void zze(zzii zzii) {
        AppMethodBeat.i(69321);
        zzii.zzcu();
        AppMethodBeat.o(69321);
    }

    private final void zzf(Runnable runnable) {
        AppMethodBeat.i(69296);
        zzab();
        if (isConnected()) {
            runnable.run();
            AppMethodBeat.o(69296);
        } else if (((long) this.zzapc.size()) >= 1000) {
            zzge().zzim().log("Discarding data. Max runnable queue size reached");
            AppMethodBeat.o(69296);
        } else {
            this.zzapc.add(runnable);
            this.zzapd.zzh(60000);
            zzdf();
            AppMethodBeat.o(69296);
        }
    }

    private final zzdz zzk(boolean z) {
        AppMethodBeat.i(69298);
        zzdz zzbi = zzfv().zzbi(z ? zzge().zziv() : null);
        AppMethodBeat.o(69298);
        return zzbi;
    }

    private final void zzkg() {
        AppMethodBeat.i(69297);
        zzab();
        zzge().zzit().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapc.size()));
        for (Runnable run : this.zzapc) {
            try {
                run.run();
            } catch (Exception e) {
                zzge().zzim().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzapc.clear();
        this.zzapd.cancel();
        AppMethodBeat.o(69297);
    }

    public final void disconnect() {
        AppMethodBeat.i(69293);
        zzab();
        zzch();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzaox);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.zzaoy = null;
        AppMethodBeat.o(69293);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(69309);
        Context context = super.getContext();
        AppMethodBeat.o(69309);
        return context;
    }

    public final boolean isConnected() {
        AppMethodBeat.i(69277);
        zzab();
        zzch();
        if (this.zzaoy != null) {
            AppMethodBeat.o(69277);
            return true;
        }
        AppMethodBeat.o(69277);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void resetAnalyticsData() {
        AppMethodBeat.i(69286);
        zzab();
        zzch();
        zzdz zzk = zzk(false);
        zzfz().resetAnalyticsData();
        zzf(new zzik(this, zzk));
        AppMethodBeat.o(69286);
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final void zza(zzey zzey) {
        AppMethodBeat.i(69292);
        zzab();
        Preconditions.checkNotNull(zzey);
        this.zzaoy = zzey;
        zzcu();
        zzkg();
        AppMethodBeat.o(69292);
    }

    /* Access modifiers changed, original: final */
    @VisibleForTesting
    public final void zza(zzey zzey, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdz) {
        AppMethodBeat.i(69279);
        zzab();
        zzch();
        int i = 100;
        for (int i2 = 0; i2 < 1001 && i == 100; i2++) {
            ArrayList arrayList = new ArrayList();
            List zzp = zzfz().zzp(100);
            if (zzp != null) {
                arrayList.addAll(zzp);
                i = zzp.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            arrayList = arrayList;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        zzey.zza((zzeu) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e) {
                        zzge().zzim().zzg("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        zzey.zza((zzjx) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e2) {
                        zzge().zzim().zzg("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        zzey.zza((zzed) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e22) {
                        zzge().zzim().zzg("Failed to send conditional property to the service", e22);
                    }
                } else {
                    zzge().zzim().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
        AppMethodBeat.o(69279);
    }

    public final void zza(AtomicReference<String> atomicReference) {
        AppMethodBeat.i(69287);
        zzab();
        zzch();
        zzf(new zzil(this, atomicReference, zzk(false)));
        AppMethodBeat.o(69287);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        AppMethodBeat.i(69282);
        zzab();
        zzch();
        zzf(new zzis(this, atomicReference, str, str2, str3, zzk(false)));
        AppMethodBeat.o(69282);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(69283);
        zzab();
        zzch();
        zzf(new zzit(this, atomicReference, str, str2, str3, z, zzk(false)));
        AppMethodBeat.o(69283);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(AtomicReference<List<zzjx>> atomicReference, boolean z) {
        AppMethodBeat.i(69285);
        zzab();
        zzch();
        zzf(new zziv(this, atomicReference, zzk(false), z));
        AppMethodBeat.o(69285);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(69301);
        super.zzab();
        AppMethodBeat.o(69301);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzb(zzeu zzeu, String str) {
        AppMethodBeat.i(69280);
        Preconditions.checkNotNull(zzeu);
        zzab();
        zzch();
        zzf(new zziq(this, true, zzfz().zza(zzeu), zzeu, zzk(true), str));
        AppMethodBeat.o(69280);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzb(zzie zzie) {
        AppMethodBeat.i(69289);
        zzab();
        zzch();
        zzf(new zzin(this, zzie));
        AppMethodBeat.o(69289);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzb(zzjx zzjx) {
        AppMethodBeat.i(69284);
        zzab();
        zzch();
        zzf(new zziu(this, zzfz().zza(zzjx), zzjx, zzk(true)));
        AppMethodBeat.o(69284);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(69308);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(69308);
        return zzbt;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(zzed zzed) {
        AppMethodBeat.i(69281);
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        zzf(new zzir(this, true, zzfz().zzc(zzed), new zzed(zzed), zzk(true), zzed));
        AppMethodBeat.o(69281);
    }

    /* Access modifiers changed, original: final */
    public final void zzdf() {
        Object obj = 1;
        AppMethodBeat.i(69291);
        zzab();
        zzch();
        if (isConnected()) {
            AppMethodBeat.o(69291);
            return;
        }
        if (this.zzaoz == null) {
            boolean z;
            zzab();
            zzch();
            Boolean zzjb = zzgf().zzjb();
            if (zzjb == null || !zzjb.booleanValue()) {
                Object obj2;
                if (zzfv().zzik() != 1) {
                    zzge().zzit().log("Checking service availability");
                    int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzgb().getContext(), 12451);
                    int obj22;
                    switch (isGooglePlayServicesAvailable) {
                        case 0:
                            zzge().zzit().log("Service available");
                            z = true;
                            obj22 = 1;
                            break;
                        case 1:
                            zzge().zzit().log("Service missing");
                            z = false;
                            obj22 = 1;
                            break;
                        case 2:
                            zzge().zzis().log("Service container out of date");
                            if (zzgb().zzld() >= 12600) {
                                zzjb = zzgf().zzjb();
                                z = zzjb == null || zzjb.booleanValue();
                                obj22 = null;
                                break;
                            }
                            z = false;
                            obj22 = 1;
                            break;
                            break;
                        case 3:
                            zzge().zzip().log("Service disabled");
                            z = false;
                            obj22 = null;
                            break;
                        case 9:
                            zzge().zzip().log("Service invalid");
                            z = false;
                            obj22 = null;
                            break;
                        case 18:
                            zzge().zzip().log("Service updating");
                            z = true;
                            obj22 = 1;
                            break;
                        default:
                            zzge().zzip().zzg("Unexpected service status", Integer.valueOf(isGooglePlayServicesAvailable));
                            z = false;
                            obj22 = null;
                            break;
                    }
                }
                z = true;
                obj22 = 1;
                if (obj22 != null) {
                    zzgf().zzf(z);
                }
            } else {
                z = true;
            }
            this.zzaoz = Boolean.valueOf(z);
        }
        if (this.zzaoz.booleanValue()) {
            this.zzaox.zzkh();
            AppMethodBeat.o(69291);
            return;
        }
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            obj = null;
        }
        if (obj != null) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.zzaox.zzc(intent);
            AppMethodBeat.o(69291);
            return;
        }
        zzge().zzim().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        AppMethodBeat.o(69291);
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(69299);
        super.zzfr();
        AppMethodBeat.o(69299);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(69300);
        super.zzfs();
        AppMethodBeat.o(69300);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(69302);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(69302);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(69303);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(69303);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(69304);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(69304);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(69305);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(69305);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(69306);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(69306);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(69307);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(69307);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(69310);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(69310);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(69311);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(69311);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(69312);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(69312);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(69313);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(69313);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(69314);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(69314);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(69315);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(69315);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(69316);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(69316);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(69317);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(69317);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzkb() {
        AppMethodBeat.i(69288);
        zzab();
        zzch();
        zzf(new zzim(this, zzk(true)));
        AppMethodBeat.o(69288);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzke() {
        AppMethodBeat.i(69278);
        zzab();
        zzch();
        zzf(new zzip(this, zzk(true)));
        AppMethodBeat.o(69278);
    }

    /* Access modifiers changed, original: final */
    public final Boolean zzkf() {
        return this.zzaoz;
    }
}
