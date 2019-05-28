package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension.TypeId;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "GoogleSignInOptionsExtensionCreator")
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new GoogleSignInOptionsExtensionCreator();
    @Field(getter = "getBundle", id = 3)
    private Bundle mBundle;
    @VersionField(id = 1)
    private final int versionCode;
    @Field(getter = "getType", id = 2)
    private int zzac;

    static {
        AppMethodBeat.m2504i(60388);
        AppMethodBeat.m2505o(60388);
    }

    @Constructor
    GoogleSignInOptionsExtensionParcelable(@Param(id = 1) int i, @TypeId @Param(id = 2) int i2, @Param(id = 3) Bundle bundle) {
        this.versionCode = i;
        this.zzac = i2;
        this.mBundle = bundle;
    }

    public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        this(1, googleSignInOptionsExtension.getExtensionType(), googleSignInOptionsExtension.toBundle());
        AppMethodBeat.m2504i(60386);
        AppMethodBeat.m2505o(60386);
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    @TypeId
    public int getType() {
        return this.zzac;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(60387);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeBundle(parcel, 3, getBundle(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(60387);
    }
}
