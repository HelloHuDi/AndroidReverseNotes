package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Class(creator = "DataItemParcelableCreator")
@Reserved({1})
@VisibleForTesting
public final class zzdd extends AbstractSafeParcelable implements DataItem {
    public static final Creator<zzdd> CREATOR = new zzde();
    @Field(getter = "getData", id = 5)
    private byte[] data;
    @Field(getter = "getUri", id = 2)
    private final Uri uri;
    @Field(getter = "getAssetsInternal", id = 4, type = "android.os.Bundle")
    private final Map<String, DataItemAsset> zzdo;

    static {
        AppMethodBeat.m2504i(71197);
        AppMethodBeat.m2505o(71197);
    }

    @Constructor
    zzdd(@Param(id = 2) Uri uri, @Param(id = 4) Bundle bundle, @Param(id = 5) byte[] bArr) {
        AppMethodBeat.m2504i(71194);
        this.uri = uri;
        HashMap hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.zzdo = hashMap;
        this.data = bArr;
        AppMethodBeat.m2505o(71194);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final Map<String, DataItemAsset> getAssets() {
        return this.zzdo;
    }

    @VisibleForTesting
    public final byte[] getData() {
        return this.data;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final /* synthetic */ DataItem setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public final String toString() {
        AppMethodBeat.m2504i(71196);
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        String valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 8).append(",dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.zzdo.size());
        valueOf = String.valueOf(this.uri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 6).append(", uri=").append(valueOf).toString());
        if (isLoggable) {
            stringBuilder.append("]\n  assets: ");
            for (String valueOf2 : this.zzdo.keySet()) {
                String valueOf3 = String.valueOf(this.zzdo.get(valueOf2));
                stringBuilder.append(new StringBuilder((String.valueOf(valueOf2).length() + 7) + String.valueOf(valueOf3).length()).append("\n    ").append(valueOf2).append(": ").append(valueOf3).toString());
            }
            stringBuilder.append("\n  ]");
            valueOf2 = stringBuilder.toString();
            AppMethodBeat.m2505o(71196);
            return valueOf2;
        }
        stringBuilder.append("]");
        valueOf2 = stringBuilder.toString();
        AppMethodBeat.m2505o(71196);
        return valueOf2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71195);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i, false);
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.zzdo.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        SafeParcelWriter.writeBundle(parcel, 4, bundle, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71195);
    }
}
