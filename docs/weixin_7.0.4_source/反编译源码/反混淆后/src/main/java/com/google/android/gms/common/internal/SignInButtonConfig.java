package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "SignInButtonConfigCreator")
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR = new SignInButtonConfigCreator();
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] zzqw;
    @Field(getter = "getButtonSize", id = 2)
    private final int zzux;
    @Field(getter = "getColorScheme", id = 3)
    private final int zzuy;

    static {
        AppMethodBeat.m2504i(61374);
        AppMethodBeat.m2505o(61374);
    }

    @Constructor
    SignInButtonConfig(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) Scope[] scopeArr) {
        this.zzal = i;
        this.zzux = i2;
        this.zzuy = i3;
        this.zzqw = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    public int getButtonSize() {
        return this.zzux;
    }

    public int getColorScheme() {
        return this.zzuy;
    }

    @Deprecated
    public Scope[] getScopes() {
        return this.zzqw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61373);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeInt(parcel, 2, getButtonSize());
        SafeParcelWriter.writeInt(parcel, 3, getColorScheme());
        SafeParcelWriter.writeTypedArray(parcel, 4, getScopes(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61373);
    }
}
