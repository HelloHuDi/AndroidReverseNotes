package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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

@Class(creator = "SignInConfigurationCreator")
@Reserved({1})
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzy();
    @Field(getter = "getConsumerPkgName", id = 2)
    private final String zzfe;
    @Field(getter = "getGoogleConfig", id = 5)
    private GoogleSignInOptions zzff;

    static {
        AppMethodBeat.i(50406);
        AppMethodBeat.o(50406);
    }

    @Constructor
    public SignInConfiguration(@Param(id = 2) String str, @Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(50402);
        this.zzfe = Preconditions.checkNotEmpty(str);
        this.zzff = googleSignInOptions;
        AppMethodBeat.o(50402);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(50404);
        if (obj == null) {
            AppMethodBeat.o(50404);
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.zzfe.equals(signInConfiguration.zzfe) || (this.zzff != null ? this.zzff.equals(signInConfiguration.zzff) : signInConfiguration.zzff == null)) {
                AppMethodBeat.o(50404);
                return false;
            }
            AppMethodBeat.o(50404);
            return true;
        } catch (ClassCastException e) {
            AppMethodBeat.o(50404);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(50405);
        int hash = new HashAccumulator().addObject(this.zzfe).addObject(this.zzff).hash();
        AppMethodBeat.o(50405);
        return hash;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(50403);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzfe, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzff, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(50403);
    }

    public final GoogleSignInOptions zzt() {
        return this.zzff;
    }
}
