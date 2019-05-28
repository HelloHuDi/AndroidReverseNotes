package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nullable;

@VisibleForTesting
public final class zzhk<T> extends zzen {
    private final IntentFilter[] zzba;
    @Nullable
    private final String zzbb;
    private ListenerHolder<Object> zzfj;
    private ListenerHolder<Object> zzfk;
    private ListenerHolder<DataListener> zzfl;
    private ListenerHolder<MessageListener> zzfm;
    private ListenerHolder<Object> zzfn;
    private ListenerHolder<Object> zzfo;
    private ListenerHolder<ChannelListener> zzfp;
    private ListenerHolder<CapabilityListener> zzfq;

    private zzhk(IntentFilter[] intentFilterArr, @Nullable String str) {
        AppMethodBeat.i(71423);
        this.zzba = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
        this.zzbb = str;
        AppMethodBeat.o(71423);
    }

    public static zzhk<ChannelListener> zza(ListenerHolder<ChannelListener> listenerHolder, String str, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71421);
        zzhk zzhk = new zzhk(intentFilterArr, (String) Preconditions.checkNotNull(str));
        zzhk.zzfp = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(71421);
        return zzhk;
    }

    public static zzhk<DataListener> zza(ListenerHolder<DataListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71418);
        zzhk zzhk = new zzhk(intentFilterArr, null);
        zzhk.zzfl = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(71418);
        return zzhk;
    }

    private static void zza(ListenerHolder<?> listenerHolder) {
        AppMethodBeat.i(71429);
        if (listenerHolder != null) {
            listenerHolder.clear();
        }
        AppMethodBeat.o(71429);
    }

    public static zzhk<MessageListener> zzb(ListenerHolder<MessageListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71419);
        zzhk zzhk = new zzhk(intentFilterArr, null);
        zzhk.zzfm = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(71419);
        return zzhk;
    }

    public static zzhk<ChannelListener> zzc(ListenerHolder<ChannelListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71420);
        zzhk zzhk = new zzhk(intentFilterArr, null);
        zzhk.zzfp = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(71420);
        return zzhk;
    }

    public static zzhk<CapabilityListener> zzd(ListenerHolder<CapabilityListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71422);
        zzhk zzhk = new zzhk(intentFilterArr, null);
        zzhk.zzfq = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(71422);
        return zzhk;
    }

    public final void clear() {
        AppMethodBeat.i(71424);
        zza(null);
        this.zzfj = null;
        zza(null);
        this.zzfk = null;
        zza(this.zzfl);
        this.zzfl = null;
        zza(this.zzfm);
        this.zzfm = null;
        zza(null);
        this.zzfn = null;
        zza(null);
        this.zzfo = null;
        zza(this.zzfp);
        this.zzfp = null;
        zza(this.zzfq);
        this.zzfq = null;
        AppMethodBeat.o(71424);
    }

    public final void onConnectedNodes(List<zzfo> list) {
    }

    public final void zza(DataHolder dataHolder) {
        AppMethodBeat.i(71425);
        if (this.zzfl != null) {
            this.zzfl.notifyListener(new zzhl(dataHolder));
            AppMethodBeat.o(71425);
            return;
        }
        dataHolder.close();
        AppMethodBeat.o(71425);
    }

    public final void zza(zzah zzah) {
        AppMethodBeat.i(71428);
        if (this.zzfq != null) {
            this.zzfq.notifyListener(new zzho(zzah));
        }
        AppMethodBeat.o(71428);
    }

    public final void zza(zzaw zzaw) {
        AppMethodBeat.i(71427);
        if (this.zzfp != null) {
            this.zzfp.notifyListener(new zzhn(zzaw));
        }
        AppMethodBeat.o(71427);
    }

    public final void zza(zzfe zzfe) {
        AppMethodBeat.i(71426);
        if (this.zzfm != null) {
            this.zzfm.notifyListener(new zzhm(zzfe));
        }
        AppMethodBeat.o(71426);
    }

    public final void zza(zzfo zzfo) {
    }

    public final void zza(zzi zzi) {
    }

    public final void zza(zzl zzl) {
    }

    public final void zzb(zzfo zzfo) {
    }

    public final IntentFilter[] zze() {
        return this.zzba;
    }

    @Nullable
    public final String zzf() {
        return this.zzbb;
    }
}
