package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@KeepForSdkWithMembers
@Class(creator = "ProxyResponseCreator")
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new zze();
    public static final int STATUS_CODE_NO_CONNECTION = -1;
    @Field(id = 5)
    public final byte[] body;
    @Field(id = 1)
    public final int googlePlayServicesStatusCode;
    @Field(id = 2)
    public final PendingIntent recoveryAction;
    @Field(id = 3)
    public final int statusCode;
    @VersionField(id = 1000)
    private final int versionCode;
    @Field(id = 4)
    private final Bundle zzdw;

    static {
        AppMethodBeat.m2504i(77049);
        AppMethodBeat.m2505o(77049);
    }

    @Constructor
    ProxyResponse(@Param(id = 1000) int i, @Param(id = 1) int i2, @Param(id = 2) PendingIntent pendingIntent, @Param(id = 3) int i3, @Param(id = 4) Bundle bundle, @Param(id = 5) byte[] bArr) {
        this.versionCode = i;
        this.googlePlayServicesStatusCode = i2;
        this.statusCode = i3;
        this.zzdw = bundle;
        this.body = bArr;
        this.recoveryAction = pendingIntent;
    }

    public ProxyResponse(int i, PendingIntent pendingIntent, int i2, Bundle bundle, byte[] bArr) {
        this(1, i, pendingIntent, i2, bundle, bArr);
    }

    private ProxyResponse(int i, Bundle bundle, byte[] bArr) {
        this(1, 0, null, i, bundle, bArr);
    }

    public ProxyResponse(int i, Map<String, String> map, byte[] bArr) {
        this(i, zzd(map), bArr);
        AppMethodBeat.m2504i(77046);
        AppMethodBeat.m2505o(77046);
    }

    public static ProxyResponse createErrorProxyResponse(int i, PendingIntent pendingIntent, int i2, Map<String, String> map, byte[] bArr) {
        AppMethodBeat.m2504i(77044);
        ProxyResponse proxyResponse = new ProxyResponse(1, i, pendingIntent, i2, zzd(map), bArr);
        AppMethodBeat.m2505o(77044);
        return proxyResponse;
    }

    private static Bundle zzd(Map<String, String> map) {
        AppMethodBeat.m2504i(77045);
        Bundle bundle = new Bundle();
        if (map == null) {
            AppMethodBeat.m2505o(77045);
            return bundle;
        }
        for (Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        AppMethodBeat.m2505o(77045);
        return bundle;
    }

    public Map<String, String> getHeaders() {
        AppMethodBeat.m2504i(77047);
        if (this.zzdw == null) {
            Map emptyMap = Collections.emptyMap();
            AppMethodBeat.m2505o(77047);
            return emptyMap;
        }
        HashMap hashMap = new HashMap();
        for (String str : this.zzdw.keySet()) {
            hashMap.put(str, this.zzdw.getString(str));
        }
        AppMethodBeat.m2505o(77047);
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77048);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.googlePlayServicesStatusCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.recoveryAction, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzdw, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.body, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77048);
    }
}
