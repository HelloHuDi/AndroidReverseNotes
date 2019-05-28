package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.p057v4.p065f.C0416l;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzez extends MessageClient {
    @VisibleForTesting
    private final MessageApi zzei = new zzeu();

    public zzez(Activity activity, Settings settings) {
        super(activity, settings);
        AppMethodBeat.m2504i(71298);
        AppMethodBeat.m2505o(71298);
    }

    public zzez(Context context, Settings settings) {
        super(context, settings);
        AppMethodBeat.m2504i(71297);
        AppMethodBeat.m2505o(71297);
    }

    private final Task<Void> zza(OnMessageReceivedListener onMessageReceivedListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.m2504i(71302);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(onMessageReceivedListener, getLooper(), "MessageListener");
        Task doRegisterEventListener = doRegisterEventListener(new zzfc(onMessageReceivedListener, intentFilterArr, createListenerHolder), new zzfd(onMessageReceivedListener, createListenerHolder.getListenerKey()));
        AppMethodBeat.m2505o(71302);
        return doRegisterEventListener;
    }

    public final Task<Void> addListener(OnMessageReceivedListener onMessageReceivedListener) {
        AppMethodBeat.m2504i(71300);
        Task zza = zza(onMessageReceivedListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED")});
        AppMethodBeat.m2505o(71300);
        return zza;
    }

    public final Task<Void> addListener(OnMessageReceivedListener onMessageReceivedListener, Uri uri, int i) {
        AppMethodBeat.m2504i(71301);
        C0416l.checkNotNull(uri, "uri must not be null");
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z, "invalid filter type");
        Task zza = zza(onMessageReceivedListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i)});
        AppMethodBeat.m2505o(71301);
        return zza;
    }

    public final Task<Boolean> removeListener(OnMessageReceivedListener onMessageReceivedListener) {
        AppMethodBeat.m2504i(71303);
        Task doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onMessageReceivedListener, getLooper(), "MessageListener").getListenerKey());
        AppMethodBeat.m2505o(71303);
        return doUnregisterEventListener;
    }

    public final Task<Integer> sendMessage(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(71299);
        Task toTask = PendingResultUtil.toTask(this.zzei.sendMessage(asGoogleApiClient(), str, str2, bArr), zzfa.zzbx);
        AppMethodBeat.m2505o(71299);
        return toTask;
    }
}
