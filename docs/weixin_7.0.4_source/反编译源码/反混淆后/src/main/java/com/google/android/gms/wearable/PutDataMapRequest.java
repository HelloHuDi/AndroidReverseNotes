package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzt;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class PutDataMapRequest {
    private final DataMap zzr = new DataMap();
    private final PutDataRequest zzs;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        AppMethodBeat.m2504i(70865);
        this.zzs = putDataRequest;
        if (dataMap != null) {
            this.zzr.putAll(dataMap);
        }
        AppMethodBeat.m2505o(70865);
    }

    public static PutDataMapRequest create(String str) {
        AppMethodBeat.m2504i(70868);
        Asserts.checkNotNull(str, "path must not be null");
        PutDataMapRequest putDataMapRequest = new PutDataMapRequest(PutDataRequest.create(str), null);
        AppMethodBeat.m2505o(70868);
        return putDataMapRequest;
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem dataMapItem) {
        AppMethodBeat.m2504i(70866);
        Asserts.checkNotNull(dataMapItem, "source must not be null");
        PutDataMapRequest putDataMapRequest = new PutDataMapRequest(PutDataRequest.zza(dataMapItem.getUri()), dataMapItem.getDataMap());
        AppMethodBeat.m2505o(70866);
        return putDataMapRequest;
    }

    public static PutDataMapRequest createWithAutoAppendedId(String str) {
        AppMethodBeat.m2504i(70867);
        Asserts.checkNotNull(str, "pathPrefix must not be null");
        PutDataMapRequest putDataMapRequest = new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
        AppMethodBeat.m2505o(70867);
        return putDataMapRequest;
    }

    public PutDataRequest asPutDataRequest() {
        AppMethodBeat.m2504i(70872);
        zzf zza = zze.zza(this.zzr);
        this.zzs.setData(zzt.zzb(zza.zzfw));
        int size = zza.zzfx.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) zza.zzfx.get(i);
            String valueOf;
            IllegalStateException illegalStateException;
            if (num == null) {
                valueOf = String.valueOf(asset);
                illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("asset key cannot be null: ").append(valueOf).toString());
                AppMethodBeat.m2505o(70872);
                throw illegalStateException;
            } else if (asset == null) {
                String str = "asset cannot be null: key=";
                valueOf = String.valueOf(num);
                illegalStateException = new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                AppMethodBeat.m2505o(70872);
                throw illegalStateException;
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    String valueOf2 = String.valueOf(asset);
                    new StringBuilder((String.valueOf(num).length() + 33) + String.valueOf(valueOf2).length()).append("asPutDataRequest: adding asset: ").append(num).append(" ").append(valueOf2);
                }
                this.zzs.putAsset(num, asset);
                i++;
            }
        }
        PutDataRequest putDataRequest = this.zzs;
        AppMethodBeat.m2505o(70872);
        return putDataRequest;
    }

    public DataMap getDataMap() {
        return this.zzr;
    }

    public Uri getUri() {
        AppMethodBeat.m2504i(70869);
        Uri uri = this.zzs.getUri();
        AppMethodBeat.m2505o(70869);
        return uri;
    }

    public boolean isUrgent() {
        AppMethodBeat.m2504i(70871);
        boolean isUrgent = this.zzs.isUrgent();
        AppMethodBeat.m2505o(70871);
        return isUrgent;
    }

    public PutDataMapRequest setUrgent() {
        AppMethodBeat.m2504i(70870);
        this.zzs.setUrgent();
        AppMethodBeat.m2505o(70870);
        return this;
    }
}
