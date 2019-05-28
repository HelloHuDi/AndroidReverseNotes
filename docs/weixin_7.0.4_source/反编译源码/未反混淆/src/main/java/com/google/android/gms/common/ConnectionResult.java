package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int API_VERSION_UPDATE_REQUIRED = 21;
    public static final int CANCELED = 13;
    public static final Creator<ConnectionResult> CREATOR = new ConnectionResultCreator();
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNFINISHED = 99;
    public static final int UNKNOWN = -1;
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getErrorCode", id = 2)
    private final int zzam;
    @Field(getter = "getResolution", id = 3)
    private final PendingIntent zzan;
    @Field(getter = "getErrorMessage", id = 4)
    private final String zzao;

    static {
        AppMethodBeat.i(89348);
        AppMethodBeat.o(89348);
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    @Constructor
    ConnectionResult(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) PendingIntent pendingIntent, @Param(id = 4) String str) {
        this.zzal = i;
        this.zzam = i2;
        this.zzan = pendingIntent;
        this.zzao = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String zza(int i) {
        AppMethodBeat.i(89343);
        String str;
        switch (i) {
            case -1:
                str = "UNKNOWN";
                AppMethodBeat.o(89343);
                return str;
            case 0:
                str = "SUCCESS";
                AppMethodBeat.o(89343);
                return str;
            case 1:
                str = "SERVICE_MISSING";
                AppMethodBeat.o(89343);
                return str;
            case 2:
                str = "SERVICE_VERSION_UPDATE_REQUIRED";
                AppMethodBeat.o(89343);
                return str;
            case 3:
                str = "SERVICE_DISABLED";
                AppMethodBeat.o(89343);
                return str;
            case 4:
                str = "SIGN_IN_REQUIRED";
                AppMethodBeat.o(89343);
                return str;
            case 5:
                str = "INVALID_ACCOUNT";
                AppMethodBeat.o(89343);
                return str;
            case 6:
                str = "RESOLUTION_REQUIRED";
                AppMethodBeat.o(89343);
                return str;
            case 7:
                str = "NETWORK_ERROR";
                AppMethodBeat.o(89343);
                return str;
            case 8:
                str = "INTERNAL_ERROR";
                AppMethodBeat.o(89343);
                return str;
            case 9:
                str = "SERVICE_INVALID";
                AppMethodBeat.o(89343);
                return str;
            case 10:
                str = "DEVELOPER_ERROR";
                AppMethodBeat.o(89343);
                return str;
            case 11:
                str = "LICENSE_CHECK_FAILED";
                AppMethodBeat.o(89343);
                return str;
            case 13:
                str = "CANCELED";
                AppMethodBeat.o(89343);
                return str;
            case 14:
                str = InstanceID.ERROR_TIMEOUT;
                AppMethodBeat.o(89343);
                return str;
            case 15:
                str = "INTERRUPTED";
                AppMethodBeat.o(89343);
                return str;
            case 16:
                str = "API_UNAVAILABLE";
                AppMethodBeat.o(89343);
                return str;
            case 17:
                str = "SIGN_IN_FAILED";
                AppMethodBeat.o(89343);
                return str;
            case 18:
                str = "SERVICE_UPDATING";
                AppMethodBeat.o(89343);
                return str;
            case 19:
                str = "SERVICE_MISSING_PERMISSION";
                AppMethodBeat.o(89343);
                return str;
            case 20:
                str = "RESTRICTED_PROFILE";
                AppMethodBeat.o(89343);
                return str;
            case 21:
                str = "API_VERSION_UPDATE_REQUIRED";
                AppMethodBeat.o(89343);
                return str;
            case 99:
                str = "UNFINISHED";
                AppMethodBeat.o(89343);
                return str;
            case 1500:
                str = "DRIVE_EXTERNAL_STORAGE_REQUIRED";
                AppMethodBeat.o(89343);
                return str;
            default:
                str = "UNKNOWN_ERROR_CODE(" + i + ")";
                AppMethodBeat.o(89343);
                return str;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(89344);
        if (obj == this) {
            AppMethodBeat.o(89344);
            return true;
        } else if (obj instanceof ConnectionResult) {
            ConnectionResult connectionResult = (ConnectionResult) obj;
            if (this.zzam == connectionResult.zzam && Objects.equal(this.zzan, connectionResult.zzan) && Objects.equal(this.zzao, connectionResult.zzao)) {
                AppMethodBeat.o(89344);
                return true;
            }
            AppMethodBeat.o(89344);
            return false;
        } else {
            AppMethodBeat.o(89344);
            return false;
        }
    }

    public final int getErrorCode() {
        return this.zzam;
    }

    public final String getErrorMessage() {
        return this.zzao;
    }

    public final PendingIntent getResolution() {
        return this.zzan;
    }

    public final boolean hasResolution() {
        return (this.zzam == 0 || this.zzan == null) ? false : true;
    }

    public final int hashCode() {
        AppMethodBeat.i(89345);
        int hashCode = Objects.hashCode(Integer.valueOf(this.zzam), this.zzan, this.zzao);
        AppMethodBeat.o(89345);
        return hashCode;
    }

    public final boolean isSuccess() {
        return this.zzam == 0;
    }

    public final void startResolutionForResult(Activity activity, int i) {
        AppMethodBeat.i(89342);
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.zzan.getIntentSender(), i, null, 0, 0, 0);
            AppMethodBeat.o(89342);
            return;
        }
        AppMethodBeat.o(89342);
    }

    public final String toString() {
        AppMethodBeat.i(89346);
        String toStringHelper = Objects.toStringHelper(this).add("statusCode", zza(this.zzam)).add("resolution", this.zzan).add(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.zzao).toString();
        AppMethodBeat.o(89346);
        return toStringHelper;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89347);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCode());
        SafeParcelWriter.writeParcelable(parcel, 3, getResolution(), i, false);
        SafeParcelWriter.writeString(parcel, 4, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(89347);
    }
}
