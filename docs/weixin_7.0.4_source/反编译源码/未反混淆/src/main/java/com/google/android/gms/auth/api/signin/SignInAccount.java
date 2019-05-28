package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@Class(creator = "SignInAccountCreator")
@Reserved({1})
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new zze();
    @Field(defaultValue = "", id = 4)
    @Deprecated
    private String zzeo;
    @Field(getter = "getGoogleSignInAccount", id = 7)
    private GoogleSignInAccount zzep;
    @Field(defaultValue = "", id = 8)
    @Deprecated
    private String zzeq;

    static {
        AppMethodBeat.i(50401);
        AppMethodBeat.o(50401);
    }

    @Constructor
    SignInAccount(@Param(id = 4) String str, @Param(id = 7) GoogleSignInAccount googleSignInAccount, @Param(id = 8) String str2) {
        AppMethodBeat.i(50399);
        this.zzep = googleSignInAccount;
        this.zzeo = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzeq = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
        AppMethodBeat.o(50399);
    }

    @Nullable
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzep;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(50400);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.zzeo, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzep, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzeq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(50400);
    }
}
