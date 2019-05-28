package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class zzaa extends CapabilityClient {
    private final CapabilityApi zzbw = new zzo();

    public zzaa(Activity activity, Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(70970);
        AppMethodBeat.o(70970);
    }

    public zzaa(Context context, Settings settings) {
        super(context, settings);
        AppMethodBeat.i(70969);
        AppMethodBeat.o(70969);
    }

    private final Task<Void> zza(ListenerHolder<OnCapabilityChangedListener> listenerHolder, OnCapabilityChangedListener onCapabilityChangedListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(70979);
        Task doRegisterEventListener = doRegisterEventListener(new zzaf(onCapabilityChangedListener, intentFilterArr, listenerHolder, null), new zzag(onCapabilityChangedListener, listenerHolder.getListenerKey(), null));
        AppMethodBeat.o(70979);
        return doRegisterEventListener;
    }

    public final Task<Void> addListener(OnCapabilityChangedListener onCapabilityChangedListener, Uri uri, int i) {
        AppMethodBeat.i(70977);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z, "invalid filter type");
        IntentFilter zza = zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i);
        Task zza2 = zza(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener"), onCapabilityChangedListener, new IntentFilter[]{zza});
        AppMethodBeat.o(70977);
        return zza2;
    }

    public final Task<Void> addListener(OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        String str2;
        AppMethodBeat.i(70975);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        IntentFilter zzc = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (str.startsWith("/")) {
            str2 = str;
        } else {
            String str3 = "/";
            str2 = String.valueOf(str);
            str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
        }
        zzc.addDataPath(str2, 0);
        IntentFilter[] intentFilterArr = new IntentFilter[]{zzc};
        Looper looper = getLooper();
        String str4 = "CapabilityListener:";
        String valueOf = String.valueOf(str2);
        Task zza = zza(ListenerHolders.createListenerHolder(onCapabilityChangedListener, looper, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4)), new zzae(onCapabilityChangedListener, str2), intentFilterArr);
        AppMethodBeat.o(70975);
        return zza;
    }

    public final Task<Void> addLocalCapability(String str) {
        AppMethodBeat.i(70973);
        Asserts.checkNotNull(str, "capability must not be null");
        Task toVoidTask = PendingResultUtil.toVoidTask(this.zzbw.addLocalCapability(asGoogleApiClient(), str));
        AppMethodBeat.o(70973);
        return toVoidTask;
    }

    public final Task<Map<String, CapabilityInfo>> getAllCapabilities(int i) {
        AppMethodBeat.i(70972);
        Task toTask = PendingResultUtil.toTask(this.zzbw.getAllCapabilities(asGoogleApiClient(), i), zzac.zzbx);
        AppMethodBeat.o(70972);
        return toTask;
    }

    public final Task<CapabilityInfo> getCapability(String str, int i) {
        AppMethodBeat.i(70971);
        Asserts.checkNotNull(str, "capability must not be null");
        Task toTask = PendingResultUtil.toTask(this.zzbw.getCapability(asGoogleApiClient(), str, i), zzab.zzbx);
        AppMethodBeat.o(70971);
        return toTask;
    }

    public final Task<Boolean> removeListener(OnCapabilityChangedListener onCapabilityChangedListener) {
        AppMethodBeat.i(70978);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Task doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener").getListenerKey());
        AppMethodBeat.o(70978);
        return doUnregisterEventListener;
    }

    public final Task<Boolean> removeListener(OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        String str2;
        Object str22;
        AppMethodBeat.i(70976);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        if (str.startsWith("/")) {
            str22 = str;
        } else {
            String str3 = "/";
            str22 = String.valueOf(str);
            str22 = str22.length() != 0 ? str3.concat(str22) : new String(str3);
        }
        Looper looper = getLooper();
        String str4 = "CapabilityListener:";
        str22 = String.valueOf(str22);
        Task doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onCapabilityChangedListener, looper, str22.length() != 0 ? str4.concat(str22) : new String(str4)).getListenerKey());
        AppMethodBeat.o(70976);
        return doUnregisterEventListener;
    }

    public final Task<Void> removeLocalCapability(String str) {
        AppMethodBeat.i(70974);
        Asserts.checkNotNull(str, "capability must not be null");
        Task toVoidTask = PendingResultUtil.toVoidTask(this.zzbw.removeLocalCapability(asGoogleApiClient(), str));
        AppMethodBeat.o(70974);
        return toVoidTask;
    }
}
