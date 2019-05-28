package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "AuthAccountResultCreator")
public class AuthAccountResult extends AbstractSafeParcelable implements Result {
    public static final Creator<AuthAccountResult> CREATOR = new AuthAccountResultCreator();
    @Field(getter = "getConnectionResultCode", id = 2)
    private int zzadn;
    @Field(getter = "getRawAuthResolutionIntent", id = 3)
    private Intent zzado;
    @VersionField(id = 1)
    private final int zzal;

    static {
        AppMethodBeat.m2504i(61653);
        AppMethodBeat.m2505o(61653);
    }

    public AuthAccountResult() {
        this(0, null);
    }

    @Constructor
    AuthAccountResult(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) Intent intent) {
        this.zzal = i;
        this.zzadn = i2;
        this.zzado = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public int getConnectionResultCode() {
        return this.zzadn;
    }

    public Intent getRawAuthResolutionIntent() {
        return this.zzado;
    }

    public Status getStatus() {
        return this.zzadn == 0 ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61652);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeInt(parcel, 2, getConnectionResultCode());
        SafeParcelWriter.writeParcelable(parcel, 3, getRawAuthResolutionIntent(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61652);
    }
}
