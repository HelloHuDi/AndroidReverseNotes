package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ConnectionInfoCreator")
public class ConnectionInfo extends AbstractSafeParcelable {
    public static final Creator<ConnectionInfo> CREATOR = new ConnectionInfoCreator();
    @Field(id = 1)
    private Bundle zzsf;
    @Field(id = 2)
    private Feature[] zzsg;

    static {
        AppMethodBeat.i(89586);
        AppMethodBeat.o(89586);
    }

    @Constructor
    ConnectionInfo(@Param(id = 1) Bundle bundle, @Param(id = 2) Feature[] featureArr) {
        this.zzsf = bundle;
        this.zzsg = featureArr;
    }

    public Feature[] getAvailableFeatures() {
        return this.zzsg;
    }

    public Bundle getResolutionBundle() {
        return this.zzsf;
    }

    public ConnectionInfo setAvailableFeatures(Feature[] featureArr) {
        this.zzsg = featureArr;
        return this;
    }

    public ConnectionInfo setResolutionBundle(Bundle bundle) {
        this.zzsf = bundle;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89585);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzsf, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzsg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(89585);
    }
}
