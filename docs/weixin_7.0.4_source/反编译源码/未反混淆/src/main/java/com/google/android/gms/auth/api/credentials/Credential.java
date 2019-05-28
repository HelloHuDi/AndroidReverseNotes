package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
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
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

@Class(creator = "CredentialCreator")
@Reserved({1000})
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Credential> CREATOR = new zzd();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    @Field(getter = "getName", id = 2)
    private final String mName;
    @Field(getter = "getAccountType", id = 6)
    private final String zzbx;
    @Field(getter = "getId", id = 1)
    @Nonnull
    private final String zzci;
    @Field(getter = "getProfilePictureUri", id = 3)
    private final Uri zzcj;
    @Field(getter = "getIdTokens", id = 4)
    @Nonnull
    private final List<IdToken> zzck;
    @Field(getter = "getPassword", id = 5)
    private final String zzcl;
    @Field(getter = "getGeneratedPassword", id = 7)
    private final String zzcm;
    @Field(getter = "getGeneratedHintId", id = 8)
    private final String zzcn;
    @Field(getter = "getGivenName", id = 9)
    private final String zzco;
    @Field(getter = "getFamilyName", id = 10)
    private final String zzcp;

    public static class Builder {
        private String mName;
        private String zzbx;
        private final String zzci;
        private Uri zzcj;
        private List<IdToken> zzck;
        private String zzcl;
        private String zzcm;
        private String zzcn;
        private String zzco;
        private String zzcp;

        public Builder(Credential credential) {
            AppMethodBeat.i(50308);
            this.zzci = credential.zzci;
            this.mName = credential.mName;
            this.zzcj = credential.zzcj;
            this.zzck = credential.zzck;
            this.zzcl = credential.zzcl;
            this.zzbx = credential.zzbx;
            this.zzcm = credential.zzcm;
            this.zzcn = credential.zzcn;
            this.zzco = credential.zzco;
            this.zzcp = credential.zzcp;
            AppMethodBeat.o(50308);
        }

        public Builder(String str) {
            this.zzci = str;
        }

        public Credential build() {
            AppMethodBeat.i(50309);
            Credential credential = new Credential(this.zzci, this.mName, this.zzcj, this.zzck, this.zzcl, this.zzbx, this.zzcm, this.zzcn, this.zzco, this.zzcp);
            AppMethodBeat.o(50309);
            return credential;
        }

        public Builder setAccountType(String str) {
            this.zzbx = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzcl = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzcj = uri;
            return this;
        }
    }

    static {
        AppMethodBeat.i(50314);
        AppMethodBeat.o(50314);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Constructor
    Credential(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) Uri uri, @Param(id = 4) List<IdToken> list, @Param(id = 5) String str3, @Param(id = 6) String str4, @Param(id = 7) String str5, @Param(id = 8) String str6, @Param(id = 9) String str7, @Param(id = 10) String str8) {
        AppMethodBeat.i(50310);
        String trim = ((String) Preconditions.checkNotNull(str, "credential identifier cannot be null")).trim();
        Preconditions.checkNotEmpty(trim, "credential identifier cannot be empty");
        IllegalArgumentException illegalArgumentException;
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                Object obj;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (!parse.isAbsolute() || !parse.isHierarchical() || TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getAuthority())) {
                        obj = null;
                        if (obj == null) {
                            illegalArgumentException = new IllegalArgumentException("Account type must be a valid Http/Https URI");
                            AppMethodBeat.o(50310);
                            throw illegalArgumentException;
                        }
                    } else if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
                        obj = 1;
                        if (obj == null) {
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.mName = str2;
                this.zzcj = uri;
                this.zzck = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
                this.zzci = trim;
                this.zzcl = str3;
                this.zzbx = str4;
                this.zzcm = str5;
                this.zzcn = str6;
                this.zzco = str7;
                this.zzcp = str8;
                AppMethodBeat.o(50310);
                return;
            }
            illegalArgumentException = new IllegalArgumentException("Password and AccountType are mutually exclusive");
            AppMethodBeat.o(50310);
            throw illegalArgumentException;
        }
        illegalArgumentException = new IllegalArgumentException("Password must not be empty if set");
        AppMethodBeat.o(50310);
        throw illegalArgumentException;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(50312);
        if (this == obj) {
            AppMethodBeat.o(50312);
            return true;
        } else if (obj instanceof Credential) {
            Credential credential = (Credential) obj;
            if (TextUtils.equals(this.zzci, credential.zzci) && TextUtils.equals(this.mName, credential.mName) && Objects.equal(this.zzcj, credential.zzcj) && TextUtils.equals(this.zzcl, credential.zzcl) && TextUtils.equals(this.zzbx, credential.zzbx) && TextUtils.equals(this.zzcm, credential.zzcm)) {
                AppMethodBeat.o(50312);
                return true;
            }
            AppMethodBeat.o(50312);
            return false;
        } else {
            AppMethodBeat.o(50312);
            return false;
        }
    }

    public String getAccountType() {
        return this.zzbx;
    }

    public String getFamilyName() {
        return this.zzcp;
    }

    public String getGeneratedPassword() {
        return this.zzcm;
    }

    public String getGivenName() {
        return this.zzco;
    }

    @Nonnull
    public String getId() {
        return this.zzci;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.zzck;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzcl;
    }

    public Uri getProfilePictureUri() {
        return this.zzcj;
    }

    public int hashCode() {
        AppMethodBeat.i(50313);
        int hashCode = Objects.hashCode(this.zzci, this.mName, this.zzcj, this.zzcl, this.zzbx, this.zzcm);
        AppMethodBeat.o(50313);
        return hashCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(50311);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 7, getGeneratedPassword(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcn, false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(50311);
    }
}
