package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
@Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new zze();
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @KeepForSdk
    @VisibleForTesting
    public static final Status RESULT_SUCCESS = new Status(0);
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    private static final Status zzdq = new Status(17);
    @VersionField(id = 1000)
    private final int zzal;
    @Field(getter = "getStatusCode", id = 1)
    private final int zzam;
    @Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent zzan;
    @Field(getter = "getStatusMessage", id = 2)
    private final String zzao;

    static {
        AppMethodBeat.i(89458);
        AppMethodBeat.o(89458);
    }

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    @Constructor
    @KeepForSdk
    Status(@Param(id = 1000) int i, @Param(id = 1) int i2, @Param(id = 2) String str, @Param(id = 3) PendingIntent pendingIntent) {
        this.zzal = i;
        this.zzam = i2;
        this.zzao = str;
        this.zzan = pendingIntent;
    }

    @KeepForSdk
    public Status(int i, String str) {
        this(1, i, str, null);
    }

    @KeepForSdk
    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(89454);
        if (obj instanceof Status) {
            Status status = (Status) obj;
            if (this.zzal == status.zzal && this.zzam == status.zzam && Objects.equal(this.zzao, status.zzao) && Objects.equal(this.zzan, status.zzan)) {
                AppMethodBeat.o(89454);
                return true;
            }
            AppMethodBeat.o(89454);
            return false;
        }
        AppMethodBeat.o(89454);
        return false;
    }

    public final PendingIntent getResolution() {
        return this.zzan;
    }

    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzam;
    }

    public final String getStatusMessage() {
        return this.zzao;
    }

    @VisibleForTesting
    public final boolean hasResolution() {
        return this.zzan != null;
    }

    public final int hashCode() {
        AppMethodBeat.i(89453);
        int hashCode = Objects.hashCode(Integer.valueOf(this.zzal), Integer.valueOf(this.zzam), this.zzao, this.zzan);
        AppMethodBeat.o(89453);
        return hashCode;
    }

    public final boolean isCanceled() {
        return this.zzam == 16;
    }

    public final boolean isInterrupted() {
        return this.zzam == 14;
    }

    public final boolean isSuccess() {
        return this.zzam <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) {
        AppMethodBeat.i(89452);
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.zzan.getIntentSender(), i, null, 0, 0, 0);
            AppMethodBeat.o(89452);
            return;
        }
        AppMethodBeat.o(89452);
    }

    public final String toString() {
        AppMethodBeat.i(89456);
        String toStringHelper = Objects.toStringHelper(this).add("statusCode", zzp()).add("resolution", this.zzan).toString();
        AppMethodBeat.o(89456);
        return toStringHelper;
    }

    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89457);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzan, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(89457);
    }

    public final String zzp() {
        AppMethodBeat.i(89455);
        String str;
        if (this.zzao != null) {
            str = this.zzao;
            AppMethodBeat.o(89455);
            return str;
        }
        str = CommonStatusCodes.getStatusCodeString(this.zzam);
        AppMethodBeat.o(89455);
        return str;
    }
}
