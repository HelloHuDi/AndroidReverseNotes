package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public final class zzhg extends GmsClient<zzep> {
    private final ExecutorService zzew;
    private final zzer<Object> zzex;
    private final zzer<Object> zzey;
    private final zzer<ChannelListener> zzez;
    private final zzer<DataListener> zzfa;
    private final zzer<MessageListener> zzfb;
    private final zzer<Object> zzfc;
    private final zzer<Object> zzfd;
    private final zzer<CapabilityListener> zzfe;
    private final zzhp zzff;

    public zzhg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, Executors.newCachedThreadPool(), zzhp.zza(context));
        AppMethodBeat.i(71395);
        AppMethodBeat.o(71395);
    }

    @VisibleForTesting
    private zzhg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, ExecutorService executorService, zzhp zzhp) {
        super(context, looper, 14, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(71396);
        this.zzex = new zzer();
        this.zzey = new zzer();
        this.zzez = new zzer();
        this.zzfa = new zzer();
        this.zzfb = new zzer();
        this.zzfc = new zzer();
        this.zzfd = new zzer();
        this.zzfe = new zzer();
        this.zzew = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzff = zzhp;
        AppMethodBeat.o(71396);
    }

    public final void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        int i = 0;
        AppMethodBeat.i(71400);
        if (!requiresGooglePlayServices()) {
            try {
                Bundle bundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 0);
                }
                if (i < GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                    new StringBuilder(86).append("The Wear OS app is out of date. Requires API version ").append(GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(i);
                    Context context = getContext();
                    Context context2 = getContext();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    triggerNotAvailable(connectionProgressReportCallbacks, 6, PendingIntent.getActivity(context, 0, intent, 0));
                    AppMethodBeat.o(71400);
                    return;
                }
            } catch (NameNotFoundException e) {
                triggerNotAvailable(connectionProgressReportCallbacks, 16, null);
                AppMethodBeat.o(71400);
                return;
            }
        }
        super.connect(connectionProgressReportCallbacks);
        AppMethodBeat.o(71400);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(71413);
        if (iBinder == null) {
            AppMethodBeat.o(71413);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        if (queryLocalInterface instanceof zzep) {
            zzep zzep = (zzep) queryLocalInterface;
            AppMethodBeat.o(71413);
            return zzep;
        }
        zzeq zzeq = new zzeq(iBinder);
        AppMethodBeat.o(71413);
        return zzeq;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    public final String getStartServicePackage() {
        AppMethodBeat.i(71397);
        String str;
        if (this.zzff.zze("com.google.android.wearable.app.cn")) {
            str = "com.google.android.wearable.app.cn";
            AppMethodBeat.o(71397);
            return str;
        }
        str = "com.google.android.gms";
        AppMethodBeat.o(71397);
        return str;
    }

    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        AppMethodBeat.i(71399);
        if (Log.isLoggable("WearableClient", 2)) {
            new StringBuilder(41).append("onPostInitHandler: statusCode ").append(i);
        }
        if (i == 0) {
            this.zzex.zza(iBinder);
            this.zzey.zza(iBinder);
            this.zzez.zza(iBinder);
            this.zzfa.zza(iBinder);
            this.zzfb.zza(iBinder);
            this.zzfc.zza(iBinder);
            this.zzfd.zza(iBinder);
            this.zzfe.zza(iBinder);
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
        AppMethodBeat.o(71399);
    }

    public final boolean requiresGooglePlayServices() {
        AppMethodBeat.i(71398);
        if (this.zzff.zze("com.google.android.wearable.app.cn")) {
            AppMethodBeat.o(71398);
            return false;
        }
        AppMethodBeat.o(71398);
        return true;
    }

    public final void zza(ResultHolder<GetFdForAssetResult> resultHolder, Asset asset) {
        AppMethodBeat.i(71402);
        ((zzep) getService()).zza(new zzgx(resultHolder), asset);
        AppMethodBeat.o(71402);
    }

    public final void zza(ResultHolder<Status> resultHolder, CapabilityListener capabilityListener) {
        AppMethodBeat.i(71411);
        this.zzfe.zza(this, resultHolder, capabilityListener);
        AppMethodBeat.o(71411);
    }

    public final void zza(ResultHolder<Status> resultHolder, CapabilityListener capabilityListener, ListenerHolder<CapabilityListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71407);
        this.zzfe.zza(this, resultHolder, capabilityListener, zzhk.zzd(listenerHolder, intentFilterArr));
        AppMethodBeat.o(71407);
    }

    public final void zza(ResultHolder<Status> resultHolder, ChannelListener channelListener, ListenerHolder<ChannelListener> listenerHolder, @Nullable String str, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71408);
        if (str == null) {
            this.zzez.zza(this, resultHolder, channelListener, zzhk.zzc(listenerHolder, intentFilterArr));
            AppMethodBeat.o(71408);
            return;
        }
        this.zzez.zza(this, resultHolder, new zzgc(str, channelListener), zzhk.zza(listenerHolder, str, intentFilterArr));
        AppMethodBeat.o(71408);
    }

    public final void zza(ResultHolder<Status> resultHolder, ChannelListener channelListener, String str) {
        AppMethodBeat.i(71412);
        if (str == null) {
            this.zzez.zza(this, resultHolder, channelListener);
            AppMethodBeat.o(71412);
            return;
        }
        this.zzez.zza(this, resultHolder, new zzgc(str, channelListener));
        AppMethodBeat.o(71412);
    }

    public final void zza(ResultHolder<Status> resultHolder, DataListener dataListener) {
        AppMethodBeat.i(71409);
        this.zzfa.zza(this, resultHolder, dataListener);
        AppMethodBeat.o(71409);
    }

    public final void zza(ResultHolder<Status> resultHolder, DataListener dataListener, ListenerHolder<DataListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71405);
        this.zzfa.zza(this, resultHolder, dataListener, zzhk.zza(listenerHolder, intentFilterArr));
        AppMethodBeat.o(71405);
    }

    public final void zza(ResultHolder<Status> resultHolder, MessageListener messageListener) {
        AppMethodBeat.i(71410);
        this.zzfb.zza(this, resultHolder, messageListener);
        AppMethodBeat.o(71410);
    }

    public final void zza(ResultHolder<Status> resultHolder, MessageListener messageListener, ListenerHolder<MessageListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71406);
        this.zzfb.zza(this, resultHolder, messageListener, zzhk.zzb(listenerHolder, intentFilterArr));
        AppMethodBeat.o(71406);
    }

    public final void zza(ResultHolder<DataItemResult> resultHolder, PutDataRequest putDataRequest) {
        String valueOf;
        String valueOf2;
        AppMethodBeat.i(71401);
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                valueOf = String.valueOf(putDataRequest.getUri());
                valueOf2 = String.valueOf(asset);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 33) + String.valueOf(valueOf2).length()).append("Put for ").append(valueOf).append(" contains invalid asset: ").append(valueOf2).toString());
                AppMethodBeat.o(71401);
                throw illegalArgumentException;
            }
        }
        PutDataRequest zza = PutDataRequest.zza(putDataRequest.getUri());
        zza.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            zza.setUrgent();
        }
        ArrayList arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() != null) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf3 = String.valueOf(asset2);
                        String valueOf4 = String.valueOf(createPipe[0]);
                        String valueOf5 = String.valueOf(createPipe[1]);
                        new StringBuilder(((String.valueOf(valueOf3).length() + 61) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()).append("processAssets: replacing data with FD in asset: ").append(valueOf3).append(" read:").append(valueOf4).append(" write:").append(valueOf5);
                    }
                    zza.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    FutureTask futureTask = new FutureTask(new zzhh(this, createPipe[1], asset2.getData()));
                    arrayList.add(futureTask);
                    this.zzew.submit(futureTask);
                } catch (IOException e) {
                    valueOf = String.valueOf(putDataRequest);
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 60).append("Unable to create ParcelFileDescriptor for asset in request: ").append(valueOf).toString(), e);
                    AppMethodBeat.o(71401);
                    throw illegalStateException;
                }
            } else if (asset2.getUri() != null) {
                try {
                    zza.putAsset((String) value2.getKey(), Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(asset2.getUri(), "r")));
                } catch (FileNotFoundException e2) {
                    new zzhb(resultHolder, arrayList).zza(new zzfu(WearableStatusCodes.ASSET_UNAVAILABLE, null));
                    valueOf2 = String.valueOf(asset2.getUri());
                    new StringBuilder(String.valueOf(valueOf2).length() + 28).append("Couldn't resolve asset URI: ").append(valueOf2);
                    AppMethodBeat.o(71401);
                    return;
                }
            } else {
                zza.putAsset((String) value2.getKey(), asset2);
            }
        }
        ((zzep) getService()).zza(new zzhb(resultHolder, arrayList), zza);
        AppMethodBeat.o(71401);
    }

    public final void zza(ResultHolder<Status> resultHolder, String str, Uri uri, long j, long j2) {
        AppMethodBeat.i(71404);
        try {
            ExecutorService executorService = this.zzew;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            Preconditions.checkArgument(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
            Preconditions.checkArgument(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
            executorService.execute(new zzhj(this, uri, resultHolder, str, j, j2));
            AppMethodBeat.o(71404);
        } catch (RuntimeException e) {
            resultHolder.setFailedResult(new Status(8));
            AppMethodBeat.o(71404);
            throw e;
        }
    }

    public final void zza(ResultHolder<Status> resultHolder, String str, Uri uri, boolean z) {
        AppMethodBeat.i(71403);
        try {
            ExecutorService executorService = this.zzew;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            executorService.execute(new zzhi(this, uri, resultHolder, z, str));
            AppMethodBeat.o(71403);
        } catch (RuntimeException e) {
            resultHolder.setFailedResult(new Status(8));
            AppMethodBeat.o(71403);
            throw e;
        }
    }
}
