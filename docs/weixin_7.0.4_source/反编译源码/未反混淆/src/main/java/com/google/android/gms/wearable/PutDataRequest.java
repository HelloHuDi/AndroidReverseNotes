package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Class(creator = "PutDataRequestCreator")
@Reserved({1})
@VisibleForTesting
public class PutDataRequest extends AbstractSafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new zzh();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final long zzt = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzu = new SecureRandom();
    @Field(getter = "getData", id = 5)
    private byte[] data;
    @Field(getter = "getUri", id = 2)
    private final Uri uri;
    @Field(getter = "getAssetsInternal", id = 4)
    private final Bundle zzv;
    @Field(getter = "getSyncDeadline", id = 6)
    private long zzw;

    static {
        AppMethodBeat.i(70888);
        AppMethodBeat.o(70888);
    }

    private PutDataRequest(Uri uri) {
        this(uri, new Bundle(), null, zzt);
        AppMethodBeat.i(70874);
        AppMethodBeat.o(70874);
    }

    @Constructor
    PutDataRequest(@Param(id = 2) Uri uri, @Param(id = 4) Bundle bundle, @Param(id = 5) byte[] bArr, @Param(id = 6) long j) {
        AppMethodBeat.i(70873);
        this.uri = uri;
        this.zzv = bundle;
        this.zzv.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.data = bArr;
        this.zzw = j;
        AppMethodBeat.o(70873);
    }

    public static PutDataRequest create(String str) {
        AppMethodBeat.i(70879);
        Asserts.checkNotNull(str, "path must not be null");
        PutDataRequest zza = zza(zza(str));
        AppMethodBeat.o(70879);
        return zza;
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        AppMethodBeat.i(70876);
        Asserts.checkNotNull(dataItem, "source must not be null");
        PutDataRequest zza = zza(dataItem.getUri());
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                String str = "Cannot create an asset for a put request without a digest: ";
                String valueOf = String.valueOf((String) entry.getKey());
                IllegalStateException illegalStateException = new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                AppMethodBeat.o(70876);
                throw illegalStateException;
            }
            zza.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        zza.setData(dataItem.getData());
        AppMethodBeat.o(70876);
        return zza;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        AppMethodBeat.i(70878);
        Asserts.checkNotNull(str, "pathPrefix must not be null");
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!str.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzu.nextLong());
        PutDataRequest putDataRequest = new PutDataRequest(zza(stringBuilder.toString()));
        AppMethodBeat.o(70878);
        return putDataRequest;
    }

    private static Uri zza(String str) {
        AppMethodBeat.i(70880);
        IllegalArgumentException illegalArgumentException;
        if (TextUtils.isEmpty(str)) {
            illegalArgumentException = new IllegalArgumentException("An empty path was supplied.");
            AppMethodBeat.o(70880);
            throw illegalArgumentException;
        } else if (!str.startsWith("/")) {
            illegalArgumentException = new IllegalArgumentException("A path must start with a single / .");
            AppMethodBeat.o(70880);
            throw illegalArgumentException;
        } else if (str.startsWith("//")) {
            illegalArgumentException = new IllegalArgumentException("A path must start with a single / .");
            AppMethodBeat.o(70880);
            throw illegalArgumentException;
        } else {
            Uri build = new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
            AppMethodBeat.o(70880);
            return build;
        }
    }

    public static PutDataRequest zza(Uri uri) {
        AppMethodBeat.i(70877);
        Asserts.checkNotNull(uri, "uri must not be null");
        PutDataRequest putDataRequest = new PutDataRequest(uri);
        AppMethodBeat.o(70877);
        return putDataRequest;
    }

    @VisibleForTesting
    public Asset getAsset(String str) {
        AppMethodBeat.i(70882);
        Asserts.checkNotNull(str, "key must not be null");
        Asset asset = (Asset) this.zzv.getParcelable(str);
        AppMethodBeat.o(70882);
        return asset;
    }

    public Map<String, Asset> getAssets() {
        AppMethodBeat.i(70881);
        HashMap hashMap = new HashMap();
        for (String str : this.zzv.keySet()) {
            hashMap.put(str, (Asset) this.zzv.getParcelable(str));
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(70881);
        return unmodifiableMap;
    }

    @VisibleForTesting
    public byte[] getData() {
        return this.data;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean hasAsset(String str) {
        AppMethodBeat.i(70883);
        Asserts.checkNotNull(str, "key must not be null");
        boolean containsKey = this.zzv.containsKey(str);
        AppMethodBeat.o(70883);
        return containsKey;
    }

    public boolean isUrgent() {
        return this.zzw == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        AppMethodBeat.i(70884);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(asset);
        this.zzv.putParcelable(str, asset);
        AppMethodBeat.o(70884);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        AppMethodBeat.i(70885);
        Asserts.checkNotNull(str, "key must not be null");
        this.zzv.remove(str);
        AppMethodBeat.o(70885);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzw = 0;
        return this;
    }

    public String toString() {
        AppMethodBeat.i(70886);
        String putDataRequest = toString(Log.isLoggable(DataMap.TAG, 3));
        AppMethodBeat.o(70886);
        return putDataRequest;
    }

    public String toString(boolean z) {
        AppMethodBeat.i(70887);
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        String valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 7).append("dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.zzv.size());
        valueOf = String.valueOf(this.uri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 6).append(", uri=").append(valueOf).toString());
        stringBuilder.append(", syncDeadline=" + this.zzw);
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String valueOf2 : this.zzv.keySet()) {
                String valueOf3 = String.valueOf(this.zzv.getParcelable(valueOf2));
                stringBuilder.append(new StringBuilder((String.valueOf(valueOf2).length() + 7) + String.valueOf(valueOf3).length()).append("\n    ").append(valueOf2).append(": ").append(valueOf3).toString());
            }
            stringBuilder.append("\n  ]");
            valueOf2 = stringBuilder.toString();
            AppMethodBeat.o(70887);
            return valueOf2;
        }
        stringBuilder.append("]");
        valueOf2 = stringBuilder.toString();
        AppMethodBeat.o(70887);
        return valueOf2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(70875);
        Asserts.checkNotNull(parcel, "dest must not be null");
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzv, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(70875);
    }
}
