package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ChannelImplCreator")
@Reserved({1})
public final class zzay extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Creator<zzay> CREATOR = new zzbi();
    @Field(getter = "getToken", id = 2)
    private final String zzce;
    @Field(getter = "getPath", id = 4)
    private final String zzcl;
    @Field(getter = "getNodeId", id = 3)
    private final String zzo;

    static {
        AppMethodBeat.m2504i(71057);
        AppMethodBeat.m2505o(71057);
    }

    @Constructor
    public zzay(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3) {
        AppMethodBeat.m2504i(71043);
        this.zzce = (String) Preconditions.checkNotNull(str);
        this.zzo = (String) Preconditions.checkNotNull(str2);
        this.zzcl = (String) Preconditions.checkNotNull(str3);
        AppMethodBeat.m2505o(71043);
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelListener channelListener) {
        AppMethodBeat.m2504i(71055);
        PendingResult zza = zzb.zza(googleApiClient, new zzbf(this.zzce, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")}), channelListener);
        AppMethodBeat.m2505o(71055);
        return zza;
    }

    public final PendingResult<Status> close(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(71048);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzaz(this, googleApiClient));
        AppMethodBeat.m2505o(71048);
        return enqueue;
    }

    public final PendingResult<Status> close(GoogleApiClient googleApiClient, int i) {
        AppMethodBeat.m2504i(71049);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzba(this, googleApiClient, i));
        AppMethodBeat.m2505o(71049);
        return enqueue;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(71046);
        if (obj == this) {
            AppMethodBeat.m2505o(71046);
            return true;
        } else if (obj instanceof zzay) {
            zzay zzay = (zzay) obj;
            if (this.zzce.equals(zzay.zzce) && Objects.equal(zzay.zzo, this.zzo) && Objects.equal(zzay.zzcl, this.zzcl)) {
                AppMethodBeat.m2505o(71046);
                return true;
            }
            AppMethodBeat.m2505o(71046);
            return false;
        } else {
            AppMethodBeat.m2505o(71046);
            return false;
        }
    }

    public final PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(71050);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbb(this, googleApiClient));
        AppMethodBeat.m2505o(71050);
        return enqueue;
    }

    public final String getNodeId() {
        return this.zzo;
    }

    public final PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(71051);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbc(this, googleApiClient));
        AppMethodBeat.m2505o(71051);
        return enqueue;
    }

    public final String getPath() {
        return this.zzcl;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(71047);
        int hashCode = this.zzce.hashCode();
        AppMethodBeat.m2505o(71047);
        return hashCode;
    }

    public final PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, Uri uri, boolean z) {
        AppMethodBeat.m2504i(71052);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(uri, "uri is null");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbd(this, googleApiClient, uri, z));
        AppMethodBeat.m2505o(71052);
        return enqueue;
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelListener channelListener) {
        AppMethodBeat.m2504i(71056);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzan(googleApiClient, channelListener, this.zzce));
        AppMethodBeat.m2505o(71056);
        return enqueue;
    }

    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.m2504i(71053);
        PendingResult sendFile = sendFile(googleApiClient, uri, 0, -1);
        AppMethodBeat.m2505o(71053);
        return sendFile;
    }

    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
        AppMethodBeat.m2504i(71054);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(this.zzce, "token is null");
        Preconditions.checkNotNull(uri, "uri is null");
        Preconditions.checkArgument(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        boolean z = j2 >= 0 || j2 == -1;
        Preconditions.checkArgument(z, "invalid length: %s", Long.valueOf(j2));
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbe(this, googleApiClient, uri, j, j2));
        AppMethodBeat.m2505o(71054);
        return enqueue;
    }

    public final String toString() {
        String substring;
        String substring2;
        AppMethodBeat.m2504i(71045);
        int i = 0;
        for (char c : this.zzce.toCharArray()) {
            i += c;
        }
        Object trim = this.zzce.trim();
        int length = trim.length();
        if (length > 25) {
            substring = trim.substring(0, 10);
            substring2 = trim.substring(length - 10, length);
            trim = new StringBuilder((String.valueOf(substring).length() + 16) + String.valueOf(substring2).length()).append(substring).append("...").append(substring2).append("::").append(i).toString();
        }
        substring = this.zzo;
        String str = this.zzcl;
        substring2 = new StringBuilder(((String.valueOf(trim).length() + 31) + String.valueOf(substring).length()) + String.valueOf(str).length()).append("Channel{token=").append(trim).append(", nodeId=").append(substring).append(", path=").append(str).append("}").toString();
        AppMethodBeat.m2505o(71045);
        return substring2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71044);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 3, getNodeId(), false);
        SafeParcelWriter.writeString(parcel, 4, getPath(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71044);
    }

    public final String zzc() {
        return this.zzce;
    }
}
