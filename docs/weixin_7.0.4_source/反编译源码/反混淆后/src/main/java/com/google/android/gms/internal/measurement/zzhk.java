package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p057v4.p065f.C6197a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhk extends zzhh {
    @VisibleForTesting
    protected zzid zzanp;
    private EventInterceptor zzanq;
    private final Set<OnEventListener> zzanr = new CopyOnWriteArraySet();
    private boolean zzans;
    private final AtomicReference<String> zzant = new AtomicReference();
    @VisibleForTesting
    protected boolean zzanu = true;

    protected zzhk(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.m2504i(69149);
        AppMethodBeat.m2505o(69149);
    }

    static /* synthetic */ void zza(zzhk zzhk, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        AppMethodBeat.m2504i(69213);
        zzhk.zzb(str, str2, j, bundle, z, z2, z3, str3);
        AppMethodBeat.m2505o(69213);
    }

    static /* synthetic */ void zza(zzhk zzhk, String str, String str2, Object obj, long j) {
        AppMethodBeat.m2504i(69214);
        zzhk.zza(str, str2, obj, j);
        AppMethodBeat.m2505o(69214);
    }

    private final void zza(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69181);
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgb().zzcf(str) != 0) {
            zzge().zzim().zzg("Invalid conditional user property name", zzga().zzbl(str));
            AppMethodBeat.m2505o(69181);
        } else if (zzgb().zzi(str, obj) != 0) {
            zzge().zzim().zze("Invalid conditional user property value", zzga().zzbl(str), obj);
            AppMethodBeat.m2505o(69181);
        } else {
            Object zzj = zzgb().zzj(str, obj);
            if (zzj == null) {
                zzge().zzim().zze("Unable to normalize conditional user property value", zzga().zzbl(str), obj);
                AppMethodBeat.m2505o(69181);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j > 15552000000L || j < 1) {
                    zzge().zzim().zze("Invalid conditional user property time to live", zzga().zzbl(str), Long.valueOf(j));
                    AppMethodBeat.m2505o(69181);
                    return;
                }
                zzgd().zzc(new zzhr(this, conditionalUserProperty));
                AppMethodBeat.m2505o(69181);
                return;
            }
            zzge().zzim().zze("Invalid conditional user property timeout", zzga().zzbl(str), Long.valueOf(j));
            AppMethodBeat.m2505o(69181);
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        AppMethodBeat.m2504i(69164);
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                int i;
                int i2;
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= parcelableArr.length) {
                            break;
                        }
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i = i2 + 1;
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        Object obj2 = arrayList.get(i2);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(i2, new Bundle((Bundle) obj2));
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        zzgd().zzc(new zzic(this, str, str2, j, bundle2, z, z2, z3, str3));
        AppMethodBeat.m2505o(69164);
    }

    private final void zza(String str, String str2, long j, Object obj) {
        AppMethodBeat.m2504i(69167);
        zzgd().zzc(new zzhm(this, str, str2, obj, j));
        AppMethodBeat.m2505o(69167);
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        AppMethodBeat.m2504i(69163);
        zza(str, str2, zzbt().currentTimeMillis(), bundle, true, z2, z3, null);
        AppMethodBeat.m2505o(69163);
    }

    private final void zza(String str, String str2, Object obj, long j) {
        AppMethodBeat.m2504i(69168);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("User property not set since app measurement is disabled");
            AppMethodBeat.m2505o(69168);
        } else if (this.zzacw.zzjv()) {
            zzge().zzis().zze("Setting user property (FE)", zzga().zzbj(str2), obj);
            zzfx().zzb(new zzjx(str2, j, obj, str));
            AppMethodBeat.m2505o(69168);
        } else {
            AppMethodBeat.m2505o(69168);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        AppMethodBeat.m2504i(69184);
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgd().zzc(new zzhs(this, conditionalUserProperty));
        AppMethodBeat.m2505o(69184);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(69192);
        Map emptyMap;
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get user properties from analytics worker thread");
            emptyMap = Collections.emptyMap();
            AppMethodBeat.m2505o(69192);
            return emptyMap;
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get user properties from main thread");
            emptyMap = Collections.emptyMap();
            AppMethodBeat.m2505o(69192);
            return emptyMap;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                this.zzacw.zzgd().zzc(new zzhu(this, atomicReference, str, str2, str3, z));
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().zzip().zzg("Interrupted waiting for get user properties", e);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(69192);
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().log("Timed out waiting for get user properties");
            emptyMap = Collections.emptyMap();
            AppMethodBeat.m2505o(69192);
            return emptyMap;
        }
        C6197a c6197a = new C6197a(list.size());
        for (zzjx zzjx : list) {
            c6197a.put(zzjx.name, zzjx.getValue());
        }
        AppMethodBeat.m2505o(69192);
        return c6197a;
    }

    static /* synthetic */ void zzb(zzhk zzhk, ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69216);
        zzhk.zzc(conditionalUserProperty);
        AppMethodBeat.m2505o(69216);
    }

    private final void zzb(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69185);
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        if (this.zzacw.isEnabled()) {
            zzjx zzjx = new zzjx(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
            try {
                zzeu zza = zzgb().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                zzfx().zzd(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzgb().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzgb().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
                AppMethodBeat.m2505o(69185);
                return;
            } catch (IllegalArgumentException e) {
                AppMethodBeat.m2505o(69185);
                return;
            }
        }
        zzge().zzis().log("Conditional property not sent since Firebase Analytics is disabled");
        AppMethodBeat.m2505o(69185);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        AppMethodBeat.m2504i(69165);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(bundle);
        zzab();
        zzch();
        if (this.zzacw.isEnabled()) {
            if (!this.zzans) {
                this.zzans = true;
                try {
                    try {
                        Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                    } catch (Exception e) {
                        zzge().zzip().zzg("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException e2) {
                    zzge().zzir().log("Tag Manager is not found and thus will not be used");
                }
            }
            if (z3 && !"_iap".equals(str2)) {
                zzka zzgb = this.zzacw.zzgb();
                int i = !zzgb.zzq("event", str2) ? 2 : !zzgb.zza("event", Event.zzacx, str2) ? 13 : !zzgb.zza("event", 40, str2) ? 2 : 0;
                if (i != 0) {
                    zzge().zzio().zzg("Invalid public event name. Event will not be logged (FE)", zzga().zzbj(str2));
                    this.zzacw.zzgb();
                    this.zzacw.zzgb().zza(i, "_ev", zzka.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                    AppMethodBeat.m2505o(69165);
                    return;
                }
            }
            zzie zzkc = zzfy().zzkc();
            if (zzkc != null) {
                if (!bundle.containsKey("_sc")) {
                    zzkc.zzaok = true;
                }
            }
            boolean z4 = z && z3;
            zzif.zza(zzkc, bundle, z4);
            boolean equals = "am".equals(str);
            z4 = zzka.zzci(str2);
            if (z && this.zzanq != null && !z4 && !equals) {
                zzge().zzis().zze("Passing event to registered event handler (FE)", zzga().zzbj(str2), zzga().zzb(bundle));
                this.zzanq.interceptEvent(str, str2, bundle, j);
                AppMethodBeat.m2505o(69165);
                return;
            } else if (this.zzacw.zzjv()) {
                int zzcd = zzgb().zzcd(str2);
                if (zzcd != 0) {
                    zzge().zzio().zzg("Invalid event name. Event will not be logged (FE)", zzga().zzbj(str2));
                    zzgb();
                    this.zzacw.zzgb().zza(str3, zzcd, "_ev", zzka.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                    AppMethodBeat.m2505o(69165);
                    return;
                }
                int i2;
                Bundle zza;
                List listOf = CollectionUtils.listOf("_o", "_sn", "_sc", "_si");
                Bundle zza2 = zzgb().zza(str2, bundle, listOf, z3, true);
                zzie zzie = (zza2 != null && zza2.containsKey("_sc") && zza2.containsKey("_si")) ? new zzie(zza2.getString("_sn"), zza2.getString("_sc"), Long.valueOf(zza2.getLong("_si")).longValue()) : null;
                zzie zzie2 = zzie == null ? zzkc : zzie;
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza2);
                long nextLong = zzgb().zzlc().nextLong();
                int i3 = 0;
                String[] strArr = (String[]) zza2.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i4 = 0;
                while (i4 < length) {
                    String str4 = strArr[i4];
                    Object obj = zza2.get(str4);
                    zzgb();
                    Bundle[] zze = zzka.zze(obj);
                    if (zze != null) {
                        zza2.putInt(str4, zze.length);
                        i2 = 0;
                        while (true) {
                            int i5 = i2;
                            if (i5 >= zze.length) {
                                break;
                            }
                            Bundle bundle2 = zze[i5];
                            zzif.zza(zzie2, bundle2, true);
                            zza = zzgb().zza("_ep", bundle2, listOf, z3, false);
                            zza.putString("_en", str2);
                            zza.putLong("_eid", nextLong);
                            zza.putString("_gn", str4);
                            zza.putInt("_ll", zze.length);
                            zza.putInt("_i", i5);
                            arrayList.add(zza);
                            i2 = i5 + 1;
                        }
                        i2 = zze.length + i3;
                    } else {
                        i2 = i3;
                    }
                    i4++;
                    i3 = i2;
                }
                if (i3 != 0) {
                    zza2.putLong("_eid", nextLong);
                    zza2.putInt("_epc", i3);
                }
                i2 = 0;
                while (true) {
                    int i6 = i2;
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    zza = (Bundle) arrayList.get(i6);
                    String str5 = (i6 != 0 ? 1 : null) != null ? "_ep" : str2;
                    zza.putString("_o", str);
                    Bundle zzd = z2 ? zzgb().zzd(zza) : zza;
                    zzge().zzis().zze("Logging event (FE)", zzga().zzbj(str2), zzga().zzb(zzd));
                    zzfx().zzb(new zzeu(str5, new zzer(zzd), str, j), str3);
                    if (!equals) {
                        for (OnEventListener onEvent : this.zzanr) {
                            onEvent.onEvent(str, str2, new Bundle(zzd), j);
                        }
                    }
                    i2 = i6 + 1;
                }
                if (zzfy().zzkc() != null && Event.APP_EXCEPTION.equals(str2)) {
                    zzgc().zzl(true);
                }
                AppMethodBeat.m2505o(69165);
                return;
            } else {
                AppMethodBeat.m2505o(69165);
                return;
            }
        }
        zzge().zzis().log("Event not sent since app measurement is disabled");
        AppMethodBeat.m2505o(69165);
    }

    private final void zzc(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69186);
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        if (this.zzacw.isEnabled()) {
            zzjx zzjx = new zzjx(conditionalUserProperty.mName, 0, null, null);
            try {
                zzfx().zzd(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zzgb().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
                AppMethodBeat.m2505o(69186);
                return;
            } catch (IllegalArgumentException e) {
                AppMethodBeat.m2505o(69186);
                return;
            }
        }
        zzge().zzis().log("Conditional property not cleared since Firebase Analytics is disabled");
        AppMethodBeat.m2505o(69186);
    }

    @VisibleForTesting
    private final List<ConditionalUserProperty> zzf(String str, String str2, String str3) {
        AppMethodBeat.m2504i(69189);
        List emptyList;
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get conditional user properties from analytics worker thread");
            emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(69189);
            return emptyList;
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get conditional user properties from main thread");
            emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(69189);
            return emptyList;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                this.zzacw.zzgd().zzc(new zzht(this, atomicReference, str, str2, str3));
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().zzip().zze("Interrupted waiting for get conditional user properties", str, e);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(69189);
            }
        }
        List<zzed> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().zzg("Timed out waiting for get conditional user properties", str);
            emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(69189);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzed zzed : list) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzed.creationTimestamp;
            conditionalUserProperty.mName = zzed.zzaep.name;
            conditionalUserProperty.mValue = zzed.zzaep.getValue();
            conditionalUserProperty.mActive = zzed.active;
            conditionalUserProperty.mTriggerEventName = zzed.triggerEventName;
            if (zzed.zzaeq != null) {
                conditionalUserProperty.mTimedOutEventName = zzed.zzaeq.name;
                if (zzed.zzaeq.zzafq != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzed.zzaeq.zzafq.zzif();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzed.triggerTimeout;
            if (zzed.zzaer != null) {
                conditionalUserProperty.mTriggeredEventName = zzed.zzaer.name;
                if (zzed.zzaer.zzafq != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzed.zzaer.zzafq.zzif();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzed.zzaep.zzaqz;
            conditionalUserProperty.mTimeToLive = zzed.timeToLive;
            if (zzed.zzaes != null) {
                conditionalUserProperty.mExpiredEventName = zzed.zzaes.name;
                if (zzed.zzaes.zzafq != null) {
                    conditionalUserProperty.mExpiredEventParams = zzed.zzaes.zzafq.zzif();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        AppMethodBeat.m2505o(69189);
        return arrayList;
    }

    private final void zzi(boolean z) {
        AppMethodBeat.m2504i(69156);
        zzab();
        zzch();
        zzge().zzis().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgf().setMeasurementEnabled(z);
        if (!zzgg().zzaz(zzfv().zzah())) {
            zzfx().zzke();
            AppMethodBeat.m2505o(69156);
        } else if (this.zzacw.isEnabled() && this.zzanu) {
            zzge().zzis().log("Recording app launch after enabling measurement for the first time (FE)");
            zzkb();
            AppMethodBeat.m2505o(69156);
        } else {
            zzfx().zzke();
            AppMethodBeat.m2505o(69156);
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(69182);
        zza(null, str, str2, bundle);
        AppMethodBeat.m2505o(69182);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        AppMethodBeat.m2504i(69183);
        Preconditions.checkNotEmpty(str);
        zzfr();
        zza(str, str2, str3, bundle);
        AppMethodBeat.m2505o(69183);
    }

    public final Task<String> getAppInstanceId() {
        AppMethodBeat.m2504i(69170);
        Task forResult;
        try {
            String zzja = zzgf().zzja();
            if (zzja != null) {
                forResult = Tasks.forResult(zzja);
                AppMethodBeat.m2505o(69170);
                return forResult;
            }
            forResult = Tasks.call(zzgd().zzjl(), new zzho(this));
            AppMethodBeat.m2505o(69170);
            return forResult;
        } catch (Exception e) {
            zzge().zzip().log("Failed to schedule task for getAppInstanceId");
            forResult = Tasks.forException(e);
            AppMethodBeat.m2505o(69170);
            return forResult;
        }
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        AppMethodBeat.m2504i(69187);
        List zzf = zzf(null, str, str2);
        AppMethodBeat.m2505o(69187);
        return zzf;
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        AppMethodBeat.m2504i(69188);
        Preconditions.checkNotEmpty(str);
        zzfr();
        List zzf = zzf(str, str2, str3);
        AppMethodBeat.m2505o(69188);
        return zzf;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(69203);
        Context context = super.getContext();
        AppMethodBeat.m2505o(69203);
        return context;
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(69190);
        Map zzb = zzb(null, str, str2, z);
        AppMethodBeat.m2505o(69190);
        return zzb;
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(69191);
        Preconditions.checkNotEmpty(str);
        zzfr();
        Map zzb = zzb(str, str2, str3, z);
        AppMethodBeat.m2505o(69191);
        return zzb;
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(69160);
        boolean z = this.zzanq == null || zzka.zzci(str2);
        zza(str, str2, bundle, true, z, false, null);
        AppMethodBeat.m2505o(69160);
    }

    public final void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        AppMethodBeat.m2504i(69177);
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.add(onEventListener)) {
            zzge().zzip().log("OnEventListener already registered");
        }
        AppMethodBeat.m2505o(69177);
    }

    public final void resetAnalyticsData() {
        AppMethodBeat.m2504i(69174);
        zzgd().zzc(new zzhq(this, zzbt().currentTimeMillis()));
        AppMethodBeat.m2505o(69174);
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69179);
        Preconditions.checkNotNull(conditionalUserProperty);
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzge().zzip().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
        AppMethodBeat.m2505o(69179);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69180);
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzfr();
        zza(new ConditionalUserProperty(conditionalUserProperty));
        AppMethodBeat.m2505o(69180);
    }

    public final void setEventInterceptor(EventInterceptor eventInterceptor) {
        AppMethodBeat.m2504i(69176);
        zzab();
        zzch();
        if (!(eventInterceptor == null || eventInterceptor == this.zzanq)) {
            Preconditions.checkState(this.zzanq == null, "EventInterceptor already set.");
        }
        this.zzanq = eventInterceptor;
        AppMethodBeat.m2505o(69176);
    }

    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.m2504i(69155);
        zzch();
        zzgd().zzc(new zzhz(this, z));
        AppMethodBeat.m2505o(69155);
    }

    public final void setMinimumSessionDuration(long j) {
        AppMethodBeat.m2504i(69157);
        zzgd().zzc(new zzia(this, j));
        AppMethodBeat.m2505o(69157);
    }

    public final void setSessionTimeoutDuration(long j) {
        AppMethodBeat.m2504i(69158);
        zzgd().zzc(new zzib(this, j));
        AppMethodBeat.m2505o(69158);
    }

    public final void setUserProperty(String str, String str2, Object obj) {
        int i = 0;
        AppMethodBeat.m2504i(69166);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int zzcf = zzgb().zzcf(str2);
        String zza;
        if (zzcf != 0) {
            zzgb();
            zza = zzka.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzacw.zzgb().zza(zzcf, "_ev", zza, i);
            AppMethodBeat.m2505o(69166);
        } else if (obj != null) {
            zzcf = zzgb().zzi(str2, obj);
            if (zzcf != 0) {
                zzgb();
                zza = zzka.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzacw.zzgb().zza(zzcf, "_ev", zza, i);
                AppMethodBeat.m2505o(69166);
                return;
            }
            Object zzj = zzgb().zzj(str2, obj);
            if (zzj != null) {
                zza(str, str2, currentTimeMillis, zzj);
            }
            AppMethodBeat.m2505o(69166);
        } else {
            zza(str, str2, currentTimeMillis, null);
            AppMethodBeat.m2505o(69166);
        }
    }

    public final void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        AppMethodBeat.m2504i(69178);
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.remove(onEventListener)) {
            zzge().zzip().log("OnEventListener had not been registered");
        }
        AppMethodBeat.m2505o(69178);
    }

    /* Access modifiers changed, original: final */
    public final void zza(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(69161);
        zzab();
        boolean z = this.zzanq == null || zzka.zzci(str2);
        zzb(str, str2, zzbt().currentTimeMillis(), bundle, true, z, false, null);
        AppMethodBeat.m2505o(69161);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        AppMethodBeat.m2504i(69162);
        zza(str, str2, j, bundle, false, true, true, null);
        AppMethodBeat.m2505o(69162);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(69159);
        boolean z2 = this.zzanq == null || zzka.zzci(str2);
        zza(str, str2, bundle, true, z2, true, null);
        AppMethodBeat.m2505o(69159);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(69195);
        super.zzab();
        AppMethodBeat.m2505o(69195);
    }

    /* Access modifiers changed, original: final */
    public final String zzae(long j) {
        String str;
        AppMethodBeat.m2504i(69173);
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                zzgd().zzc(new zzhp(this, atomicReference));
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzge().zzip().log("Interrupted waiting for app instance id");
                str = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69173);
            }
        }
        str = (String) atomicReference.get();
        return str;
    }

    /* Access modifiers changed, original: final */
    public final void zzbr(String str) {
        AppMethodBeat.m2504i(69172);
        this.zzant.set(str);
        AppMethodBeat.m2505o(69172);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(69202);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(69202);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(69193);
        super.zzfr();
        AppMethodBeat.m2505o(69193);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(69194);
        super.zzfs();
        AppMethodBeat.m2505o(69194);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(69196);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(69196);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(69197);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(69197);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(69198);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(69198);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(69199);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(69199);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(69200);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(69200);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(69201);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(69201);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(69204);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(69204);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(69205);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(69205);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(69206);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(69206);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(69207);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(69207);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(69208);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(69208);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(69209);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(69209);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(69210);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(69210);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(69211);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(69211);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    public final String zzhm() {
        AppMethodBeat.m2504i(69151);
        AtomicReference atomicReference = new AtomicReference();
        String str = (String) zzgd().zza(atomicReference, 15000, "String test flag value", new zzhv(this, atomicReference));
        AppMethodBeat.m2505o(69151);
        return str;
    }

    public final List<zzjx> zzj(boolean z) {
        AppMethodBeat.m2504i(69169);
        zzch();
        zzge().zzis().log("Fetching user attributes (FE)");
        List emptyList;
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get all user properties from analytics worker thread");
            emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(69169);
            return emptyList;
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get all user properties from main thread");
            emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(69169);
            return emptyList;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                this.zzacw.zzgd().zzc(new zzhn(this, atomicReference, z));
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().zzip().zzg("Interrupted waiting for get user properties", e);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(69169);
            }
        }
        emptyList = (List) atomicReference.get();
        if (emptyList == null) {
            zzge().zzip().log("Timed out waiting for get user properties");
            emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(69169);
            return emptyList;
        }
        AppMethodBeat.m2505o(69169);
        return emptyList;
    }

    public final String zzja() {
        AppMethodBeat.m2504i(69171);
        String str = (String) this.zzant.get();
        AppMethodBeat.m2505o(69171);
        return str;
    }

    public final Boolean zzjx() {
        AppMethodBeat.m2504i(69150);
        AtomicReference atomicReference = new AtomicReference();
        Boolean bool = (Boolean) zzgd().zza(atomicReference, 15000, "boolean test flag value", new zzhl(this, atomicReference));
        AppMethodBeat.m2505o(69150);
        return bool;
    }

    public final Long zzjy() {
        AppMethodBeat.m2504i(69152);
        AtomicReference atomicReference = new AtomicReference();
        Long l = (Long) zzgd().zza(atomicReference, 15000, "long test flag value", new zzhw(this, atomicReference));
        AppMethodBeat.m2505o(69152);
        return l;
    }

    public final Integer zzjz() {
        AppMethodBeat.m2504i(69153);
        AtomicReference atomicReference = new AtomicReference();
        Integer num = (Integer) zzgd().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
        AppMethodBeat.m2505o(69153);
        return num;
    }

    public final Double zzka() {
        AppMethodBeat.m2504i(69154);
        AtomicReference atomicReference = new AtomicReference();
        Double d = (Double) zzgd().zza(atomicReference, 15000, "double test flag value", new zzhy(this, atomicReference));
        AppMethodBeat.m2505o(69154);
        return d;
    }

    public final void zzkb() {
        AppMethodBeat.m2504i(69175);
        zzab();
        zzch();
        if (this.zzacw.zzjv()) {
            zzfx().zzkb();
            this.zzanu = false;
            String zzjd = zzgf().zzjd();
            if (!TextUtils.isEmpty(zzjd)) {
                zzfw().zzch();
                if (!zzjd.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzjd);
                    logEvent("auto", "_ou", bundle);
                }
            }
            AppMethodBeat.m2505o(69175);
            return;
        }
        AppMethodBeat.m2505o(69175);
    }
}
