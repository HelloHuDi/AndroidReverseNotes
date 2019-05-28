package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzao extends ChannelClient {
    private final zzaj zzcg = new zzaj();

    public zzao(Activity activity, Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(71007);
        AppMethodBeat.o(71007);
    }

    public zzao(Context context, Settings settings) {
        super(context, settings);
        AppMethodBeat.i(71006);
        AppMethodBeat.o(71006);
    }

    private static zzay zza(Channel channel) {
        AppMethodBeat.i(71012);
        Preconditions.checkNotNull(channel, "channel must not be null");
        zzay zzay = (zzay) channel;
        AppMethodBeat.o(71012);
        return zzay;
    }

    private static zzay zza(ChannelClient.Channel channel) {
        AppMethodBeat.i(71011);
        Preconditions.checkNotNull(channel, "channel must not be null");
        zzay zzay = (zzay) channel;
        AppMethodBeat.o(71011);
        return zzay;
    }

    static /* synthetic */ zzay zzb(Channel channel) {
        AppMethodBeat.i(71023);
        zzay zza = zza(channel);
        AppMethodBeat.o(71023);
        return zza;
    }

    public final Task<Void> close(ChannelClient.Channel channel) {
        AppMethodBeat.i(71013);
        Task toVoidTask = PendingResultUtil.toVoidTask(zza(channel).close(asGoogleApiClient()));
        AppMethodBeat.o(71013);
        return toVoidTask;
    }

    public final Task<Void> close(ChannelClient.Channel channel, int i) {
        AppMethodBeat.i(71014);
        Task toVoidTask = PendingResultUtil.toVoidTask(zza(channel).close(asGoogleApiClient(), i));
        AppMethodBeat.o(71014);
        return toVoidTask;
    }

    public final Task<InputStream> getInputStream(ChannelClient.Channel channel) {
        AppMethodBeat.i(71015);
        Task toTask = PendingResultUtil.toTask(zza(channel).getInputStream(asGoogleApiClient()), zzaq.zzbx);
        AppMethodBeat.o(71015);
        return toTask;
    }

    public final Task<OutputStream> getOutputStream(ChannelClient.Channel channel) {
        AppMethodBeat.i(71016);
        Task toTask = PendingResultUtil.toTask(zza(channel).getOutputStream(asGoogleApiClient()), zzar.zzbx);
        AppMethodBeat.o(71016);
        return toTask;
    }

    public final Task<ChannelClient.Channel> openChannel(String str, String str2) {
        AppMethodBeat.i(71008);
        Task toTask = PendingResultUtil.toTask(this.zzcg.openChannel(asGoogleApiClient(), str, str2), zzap.zzbx);
        AppMethodBeat.o(71008);
        return toTask;
    }

    public final Task<Void> receiveFile(ChannelClient.Channel channel, Uri uri, boolean z) {
        AppMethodBeat.i(71017);
        Task toVoidTask = PendingResultUtil.toVoidTask(zza(channel).receiveFile(asGoogleApiClient(), uri, z));
        AppMethodBeat.o(71017);
        return toVoidTask;
    }

    public final Task<Void> registerChannelCallback(ChannelClient.Channel channel, ChannelCallback channelCallback) {
        AppMethodBeat.i(71020);
        String zzc = ((zzay) channel).zzc();
        Preconditions.checkNotNull(channelCallback, "listener is null");
        Looper looper = getLooper();
        String str = "ChannelListener:";
        String valueOf = String.valueOf(zzc);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(channelCallback, looper, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        IntentFilter[] intentFilterArr = new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")};
        zzas zzas = new zzas(channelCallback);
        Task doRegisterEventListener = doRegisterEventListener(new zzat(zzas, zzc, intentFilterArr, createListenerHolder, ListenerHolders.createListenerHolder(zzas, getLooper(), "ChannelListener")), new zzau(zzas, zzc, createListenerHolder.getListenerKey()));
        AppMethodBeat.o(71020);
        return doRegisterEventListener;
    }

    public final Task<Void> registerChannelCallback(ChannelCallback channelCallback) {
        AppMethodBeat.i(71009);
        Preconditions.checkNotNull(channelCallback, "listener is null");
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener");
        IntentFilter[] intentFilterArr = new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")};
        zzas zzas = new zzas(channelCallback);
        Task doRegisterEventListener = doRegisterEventListener(new zzat(zzas, null, intentFilterArr, createListenerHolder, ListenerHolders.createListenerHolder(zzas, getLooper(), "ChannelListener")), new zzau(zzas, null, createListenerHolder.getListenerKey()));
        AppMethodBeat.o(71009);
        return doRegisterEventListener;
    }

    public final Task<Void> sendFile(ChannelClient.Channel channel, Uri uri) {
        AppMethodBeat.i(71018);
        Task toVoidTask = PendingResultUtil.toVoidTask(zza(channel).sendFile(asGoogleApiClient(), uri));
        AppMethodBeat.o(71018);
        return toVoidTask;
    }

    public final Task<Void> sendFile(ChannelClient.Channel channel, Uri uri, long j, long j2) {
        AppMethodBeat.i(71019);
        Task toVoidTask = PendingResultUtil.toVoidTask(zza(channel).sendFile(asGoogleApiClient(), uri, j, j2));
        AppMethodBeat.o(71019);
        return toVoidTask;
    }

    public final Task<Boolean> unregisterChannelCallback(ChannelClient.Channel channel, ChannelCallback channelCallback) {
        AppMethodBeat.i(71021);
        String zzc = zza(channel).zzc();
        Looper looper = getLooper();
        String str = "ChannelListener:";
        zzc = String.valueOf(zzc);
        Task doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(channelCallback, looper, zzc.length() != 0 ? str.concat(zzc) : new String(str)).getListenerKey());
        AppMethodBeat.o(71021);
        return doUnregisterEventListener;
    }

    public final Task<Boolean> unregisterChannelCallback(ChannelCallback channelCallback) {
        AppMethodBeat.i(71010);
        Task doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener").getListenerKey());
        AppMethodBeat.o(71010);
        return doUnregisterEventListener;
    }
}
