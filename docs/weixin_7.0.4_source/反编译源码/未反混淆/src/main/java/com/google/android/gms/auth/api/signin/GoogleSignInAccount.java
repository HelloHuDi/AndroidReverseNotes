package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new GoogleSignInAccountCreator();
    @VisibleForTesting
    public static Clock sClock = DefaultClock.getInstance();
    @VersionField(id = 1)
    private final int versionCode;
    @Field(getter = "getId", id = 2)
    private String zze;
    @Field(getter = "getIdToken", id = 3)
    private String zzf;
    @Field(getter = "getEmail", id = 4)
    private String zzg;
    @Field(getter = "getDisplayName", id = 5)
    private String zzh;
    @Field(getter = "getPhotoUrl", id = 6)
    private Uri zzi;
    @Field(getter = "getServerAuthCode", id = 7)
    private String zzj;
    @Field(getter = "getExpirationTimeSecs", id = 8)
    private long zzk;
    @Field(getter = "getObfuscatedIdentifier", id = 9)
    private String zzl;
    @Field(id = 10)
    private List<Scope> zzm;
    @Field(getter = "getGivenName", id = 11)
    private String zzn;
    @Field(getter = "getFamilyName", id = 12)
    private String zzo;
    private Set<Scope> zzp = new HashSet();

    static {
        AppMethodBeat.i(60345);
        AppMethodBeat.o(60345);
    }

    @Constructor
    GoogleSignInAccount(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) Uri uri, @Param(id = 7) String str5, @Param(id = 8) long j, @Param(id = 9) String str6, @Param(id = 10) List<Scope> list, @Param(id = 11) String str7, @Param(id = 12) String str8) {
        AppMethodBeat.i(60332);
        this.versionCode = i;
        this.zze = str;
        this.zzf = str2;
        this.zzg = str3;
        this.zzh = str4;
        this.zzi = uri;
        this.zzj = str5;
        this.zzk = j;
        this.zzl = str6;
        this.zzm = list;
        this.zzn = str7;
        this.zzo = str8;
        AppMethodBeat.o(60332);
    }

    public static GoogleSignInAccount create(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        AppMethodBeat.i(60328);
        GoogleSignInAccount create = create(str, str2, str3, str4, null, null, uri, l, str5, set);
        AppMethodBeat.o(60328);
        return create;
    }

    public static GoogleSignInAccount create(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        AppMethodBeat.i(60327);
        if (l == null) {
            l = Long.valueOf(sClock.currentTimeMillis() / 1000);
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
        AppMethodBeat.o(60327);
        return googleSignInAccount;
    }

    public static GoogleSignInAccount createDefault() {
        AppMethodBeat.i(60330);
        GoogleSignInAccount zza = zza(new Account("<<default account>>", "com.google"), new HashSet());
        AppMethodBeat.o(60330);
        return zza;
    }

    public static GoogleSignInAccount fromAccountAndScopes(Account account, Scope scope, Scope... scopeArr) {
        AppMethodBeat.i(60329);
        Preconditions.checkNotNull(account);
        Preconditions.checkNotNull(scope);
        Set hashSet = new HashSet();
        hashSet.add(scope);
        hashSet.addAll(Arrays.asList(scopeArr));
        GoogleSignInAccount zza = zza(account, hashSet);
        AppMethodBeat.o(60329);
        return zza;
    }

    public static GoogleSignInAccount fromJsonString(String str) {
        AppMethodBeat.i(60326);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(60326);
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount serverAuthCode = create(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString(Scopes.EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).setServerAuthCode(jSONObject.optString("serverAuthCode", null));
        AppMethodBeat.o(60326);
        return serverAuthCode;
    }

    private static GoogleSignInAccount zza(Account account, Set<Scope> set) {
        AppMethodBeat.i(60331);
        GoogleSignInAccount create = create(null, null, account.name, null, null, null, null, Long.valueOf(0), account.name, set);
        AppMethodBeat.o(60331);
        return create;
    }

    private final JSONObject zza() {
        AppMethodBeat.i(60343);
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(Scopes.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzk);
            jSONObject.put("obfuscatedIdentifier", getObfuscatedIdentifier());
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.zzm.toArray(new Scope[this.zzm.size()]);
            Arrays.sort(scopeArr, zza.zzq);
            for (Scope scopeUri : scopeArr) {
                jSONArray.put(scopeUri.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            AppMethodBeat.o(60343);
            return jSONObject;
        } catch (JSONException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(60343);
            throw runtimeException;
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(60340);
        if (obj == this) {
            AppMethodBeat.o(60340);
            return true;
        } else if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            if (googleSignInAccount.getObfuscatedIdentifier().equals(getObfuscatedIdentifier()) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes())) {
                AppMethodBeat.o(60340);
                return true;
            }
            AppMethodBeat.o(60340);
            return false;
        } else {
            AppMethodBeat.o(60340);
            return false;
        }
    }

    public Account getAccount() {
        AppMethodBeat.i(60333);
        if (this.zzg == null) {
            AppMethodBeat.o(60333);
            return null;
        }
        Account account = new Account(this.zzg, "com.google");
        AppMethodBeat.o(60333);
        return account;
    }

    public String getDisplayName() {
        return this.zzh;
    }

    public String getEmail() {
        return this.zzg;
    }

    public long getExpirationTimeSecs() {
        return this.zzk;
    }

    public String getFamilyName() {
        return this.zzo;
    }

    public String getGivenName() {
        return this.zzn;
    }

    public Set<Scope> getGrantedScopes() {
        AppMethodBeat.i(60336);
        HashSet hashSet = new HashSet(this.zzm);
        AppMethodBeat.o(60336);
        return hashSet;
    }

    public String getId() {
        return this.zze;
    }

    public String getIdToken() {
        return this.zzf;
    }

    public String getObfuscatedIdentifier() {
        return this.zzl;
    }

    public Uri getPhotoUrl() {
        return this.zzi;
    }

    public Set<Scope> getRequestedScopes() {
        AppMethodBeat.i(60337);
        HashSet hashSet = new HashSet(this.zzm);
        hashSet.addAll(this.zzp);
        AppMethodBeat.o(60337);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.zzj;
    }

    public int hashCode() {
        AppMethodBeat.i(60339);
        int hashCode = ((getObfuscatedIdentifier().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + getRequestedScopes().hashCode();
        AppMethodBeat.o(60339);
        return hashCode;
    }

    public boolean isExpired() {
        AppMethodBeat.i(60335);
        if (sClock.currentTimeMillis() / 1000 >= this.zzk - 300) {
            AppMethodBeat.o(60335);
            return true;
        }
        AppMethodBeat.o(60335);
        return false;
    }

    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        AppMethodBeat.i(60334);
        if (scopeArr != null) {
            Collections.addAll(this.zzp, scopeArr);
        }
        AppMethodBeat.o(60334);
        return this;
    }

    public GoogleSignInAccount setServerAuthCode(String str) {
        this.zzj = str;
        return this;
    }

    public String toJson() {
        AppMethodBeat.i(60341);
        String jSONObject = zza().toString();
        AppMethodBeat.o(60341);
        return jSONObject;
    }

    public String toJsonForStorage() {
        AppMethodBeat.i(60342);
        JSONObject zza = zza();
        zza.remove("serverAuthCode");
        String jSONObject = zza.toString();
        AppMethodBeat.o(60342);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(60338);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, getExpirationTimeSecs());
        SafeParcelWriter.writeString(parcel, 9, getObfuscatedIdentifier(), false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(60338);
    }
}
