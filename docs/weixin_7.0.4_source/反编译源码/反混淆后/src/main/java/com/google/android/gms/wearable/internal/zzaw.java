package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ChannelEventParcelableCreator")
@Reserved({1})
public final class zzaw extends AbstractSafeParcelable {
    public static final Creator<zzaw> CREATOR = new zzax();
    @Field(id = 3)
    private final int type;
    @Field(id = 5)
    private final int zzcj;
    @Field(id = 2)
    private final zzay zzck;
    @Field(id = 4)
    private final int zzg;

    static {
        AppMethodBeat.m2504i(71041);
        AppMethodBeat.m2505o(71041);
    }

    @Constructor
    public zzaw(@Param(id = 2) zzay zzay, @Param(id = 3) int i, @Param(id = 4) int i2, @Param(id = 5) int i3) {
        this.zzck = zzay;
        this.type = i;
        this.zzg = i2;
        this.zzcj = i3;
    }

    public final String toString() {
        Object obj;
        Object obj2;
        AppMethodBeat.m2504i(71040);
        String valueOf = String.valueOf(this.zzck);
        int i = this.type;
        switch (i) {
            case 1:
                obj = "CHANNEL_OPENED";
                break;
            case 2:
                obj = "CHANNEL_CLOSED";
                break;
            case 3:
                obj = "INPUT_CLOSED";
                break;
            case 4:
                obj = "OUTPUT_CLOSED";
                break;
            default:
                obj = Integer.toString(i);
                break;
        }
        int i2 = this.zzg;
        switch (i2) {
            case 0:
                obj2 = "CLOSE_REASON_NORMAL";
                break;
            case 1:
                obj2 = "CLOSE_REASON_DISCONNECTED";
                break;
            case 2:
                obj2 = "CLOSE_REASON_REMOTE_CLOSE";
                break;
            case 3:
                obj2 = "CLOSE_REASON_LOCAL_CLOSE";
                break;
            default:
                obj2 = Integer.toString(i2);
                break;
        }
        String stringBuilder = new StringBuilder(((String.valueOf(valueOf).length() + 81) + String.valueOf(obj).length()) + String.valueOf(obj2).length()).append("ChannelEventParcelable[, channel=").append(valueOf).append(", type=").append(obj).append(", closeReason=").append(obj2).append(", appErrorCode=").append(this.zzcj).append("]").toString();
        AppMethodBeat.m2505o(71040);
        return stringBuilder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71039);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzck, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.type);
        SafeParcelWriter.writeInt(parcel, 4, this.zzg);
        SafeParcelWriter.writeInt(parcel, 5, this.zzcj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71039);
    }

    public final void zza(ChannelListener channelListener) {
        AppMethodBeat.m2504i(71038);
        switch (this.type) {
            case 1:
                channelListener.onChannelOpened(this.zzck);
                AppMethodBeat.m2505o(71038);
                return;
            case 2:
                channelListener.onChannelClosed(this.zzck, this.zzg, this.zzcj);
                AppMethodBeat.m2505o(71038);
                return;
            case 3:
                channelListener.onInputClosed(this.zzck, this.zzg, this.zzcj);
                AppMethodBeat.m2505o(71038);
                return;
            case 4:
                channelListener.onOutputClosed(this.zzck, this.zzg, this.zzcj);
                AppMethodBeat.m2505o(71038);
                return;
            default:
                new StringBuilder(25).append("Unknown type: ").append(this.type);
                AppMethodBeat.m2505o(71038);
                return;
        }
    }
}
