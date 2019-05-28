package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension.TypeId;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new GoogleSignInOptionsCreator();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES_LITE, new Scope[0]).build();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    @VisibleForTesting
    public static final Scope SCOPE_EMAIL = new Scope(Scopes.EMAIL);
    @VisibleForTesting
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    @VisibleForTesting
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    @VisibleForTesting
    public static final Scope SCOPE_OPEN_ID = new Scope(Scopes.OPEN_ID);
    @VisibleForTesting
    public static final Scope SCOPE_PROFILE = new Scope(Scopes.PROFILE);
    private static Comparator<Scope> zzaa = new zzb();
    @VersionField(id = 1)
    private final int versionCode;
    @Field(getter = "getScopes", id = 2)
    private final ArrayList<Scope> zzr;
    @Field(getter = "getAccount", id = 3)
    private Account zzs;
    @Field(getter = "isIdTokenRequested", id = 4)
    private boolean zzt;
    @Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean zzu;
    @Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean zzv;
    @Field(getter = "getServerClientId", id = 7)
    private String zzw;
    @Field(getter = "getHostedDomain", id = 8)
    private String zzx;
    @Field(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zzy;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzz;

    public static final class Builder {
        private Set<Scope> mScopes = new HashSet();
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzab = new HashMap();
        private Account zzs;
        private boolean zzt;
        private boolean zzu;
        private boolean zzv;
        private String zzw;
        private String zzx;

        public Builder() {
            AppMethodBeat.i(60349);
            AppMethodBeat.o(60349);
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            AppMethodBeat.i(60350);
            Preconditions.checkNotNull(googleSignInOptions);
            this.mScopes = new HashSet(googleSignInOptions.zzr);
            this.zzu = googleSignInOptions.zzu;
            this.zzv = googleSignInOptions.zzv;
            this.zzt = googleSignInOptions.zzt;
            this.zzw = googleSignInOptions.zzw;
            this.zzs = googleSignInOptions.zzs;
            this.zzx = googleSignInOptions.zzx;
            this.zzab = GoogleSignInOptions.zzb(googleSignInOptions.zzy);
            AppMethodBeat.o(60350);
        }

        private final String zza(String str) {
            AppMethodBeat.i(60364);
            Preconditions.checkNotEmpty(str);
            boolean z = this.zzw == null || this.zzw.equals(str);
            Preconditions.checkArgument(z, "two different server client ids provided");
            AppMethodBeat.o(60364);
            return str;
        }

        public final Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            AppMethodBeat.i(60362);
            if (this.zzab.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                IllegalStateException illegalStateException = new IllegalStateException("Only one extension per type may be added");
                AppMethodBeat.o(60362);
                throw illegalStateException;
            }
            if (googleSignInOptionsExtension.getImpliedScopes() != null) {
                this.mScopes.addAll(googleSignInOptionsExtension.getImpliedScopes());
            }
            this.zzab.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
            AppMethodBeat.o(60362);
            return this;
        }

        public final GoogleSignInOptions build() {
            AppMethodBeat.i(60363);
            if (this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES) && this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES_LITE)) {
                this.mScopes.remove(GoogleSignInOptions.SCOPE_GAMES_LITE);
            }
            if (this.zzt && (this.zzs == null || !this.mScopes.isEmpty())) {
                requestId();
            }
            GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList(this.mScopes), this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx, this.zzab, null);
            AppMethodBeat.o(60363);
            return googleSignInOptions;
        }

        public final Builder requestEmail() {
            AppMethodBeat.i(60352);
            this.mScopes.add(GoogleSignInOptions.SCOPE_EMAIL);
            AppMethodBeat.o(60352);
            return this;
        }

        public final Builder requestId() {
            AppMethodBeat.i(60351);
            this.mScopes.add(GoogleSignInOptions.SCOPE_OPEN_ID);
            AppMethodBeat.o(60351);
            return this;
        }

        public final Builder requestIdToken(String str) {
            AppMethodBeat.i(60355);
            this.zzt = true;
            this.zzw = zza(str);
            AppMethodBeat.o(60355);
            return this;
        }

        public final Builder requestPhatIdToken(String str) {
            AppMethodBeat.i(60356);
            Builder requestEmail = requestIdToken(str).requestProfile().requestEmail();
            AppMethodBeat.o(60356);
            return requestEmail;
        }

        public final Builder requestProfile() {
            AppMethodBeat.i(60353);
            this.mScopes.add(GoogleSignInOptions.SCOPE_PROFILE);
            AppMethodBeat.o(60353);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            AppMethodBeat.i(60354);
            this.mScopes.add(scope);
            this.mScopes.addAll(Arrays.asList(scopeArr));
            AppMethodBeat.o(60354);
            return this;
        }

        public final Builder requestServerAuthCode(String str) {
            AppMethodBeat.i(60357);
            Builder requestServerAuthCode = requestServerAuthCode(str, false);
            AppMethodBeat.o(60357);
            return requestServerAuthCode;
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            AppMethodBeat.i(60358);
            this.zzu = true;
            this.zzw = zza(str);
            this.zzv = z;
            AppMethodBeat.o(60358);
            return this;
        }

        public final Builder setAccount(Account account) {
            AppMethodBeat.i(60360);
            this.zzs = (Account) Preconditions.checkNotNull(account);
            AppMethodBeat.o(60360);
            return this;
        }

        public final Builder setAccountName(String str) {
            AppMethodBeat.i(60359);
            this.zzs = new Account(Preconditions.checkNotEmpty(str), "com.google");
            AppMethodBeat.o(60359);
            return this;
        }

        public final Builder setHostedDomain(String str) {
            AppMethodBeat.i(60361);
            this.zzx = Preconditions.checkNotEmpty(str);
            AppMethodBeat.o(60361);
            return this;
        }
    }

    static {
        AppMethodBeat.i(60379);
        AppMethodBeat.o(60379);
    }

    @Constructor
    GoogleSignInOptions(@Param(id = 1) int i, @Param(id = 2) ArrayList<Scope> arrayList, @Param(id = 3) Account account, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) boolean z3, @Param(id = 7) String str, @Param(id = 8) String str2, @Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, zza((List) arrayList2));
        AppMethodBeat.i(60366);
        AppMethodBeat.o(60366);
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        AppMethodBeat.i(60367);
        this.versionCode = i;
        this.zzr = arrayList;
        this.zzs = account;
        this.zzt = z;
        this.zzu = z2;
        this.zzv = z3;
        this.zzw = str;
        this.zzx = str2;
        this.zzy = new ArrayList(map.values());
        this.zzz = map;
        AppMethodBeat.o(60367);
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, zzb zzb) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }

    public static GoogleSignInOptions fromJsonString(String str) {
        AppMethodBeat.i(60365);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(60365);
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(Constants.KEY_SCOPES);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
        AppMethodBeat.o(60365);
        return googleSignInOptions;
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zza(List<GoogleSignInOptionsExtensionParcelable> list) {
        AppMethodBeat.i(60372);
        HashMap hashMap = new HashMap();
        if (list == null) {
            AppMethodBeat.o(60372);
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        AppMethodBeat.o(60372);
        return hashMap;
    }

    private final JSONObject zza() {
        AppMethodBeat.i(60377);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzr, zzaa);
            ArrayList arrayList = this.zzr;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).getScopeUri());
            }
            jSONObject.put(Constants.KEY_SCOPES, jSONArray);
            if (this.zzs != null) {
                jSONObject.put("accountName", this.zzs.name);
            }
            jSONObject.put("idTokenRequested", this.zzt);
            jSONObject.put("forceCodeForRefreshToken", this.zzv);
            jSONObject.put("serverAuthRequested", this.zzu);
            if (!TextUtils.isEmpty(this.zzw)) {
                jSONObject.put("serverClientId", this.zzw);
            }
            if (!TextUtils.isEmpty(this.zzx)) {
                jSONObject.put("hostedDomain", this.zzx);
            }
            AppMethodBeat.o(60377);
            return jSONObject;
        } catch (JSONException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(60377);
            throw runtimeException;
        }
    }

    /* JADX WARNING: Missing block: B:23:0x005d, code skipped:
            if (android.text.TextUtils.isEmpty(r5.getServerClientId()) != false) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:36:0x009b, code skipped:
            if (r4.zzw.equals(r5.getServerClientId()) != false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(Object obj) {
        AppMethodBeat.i(60374);
        if (obj == null) {
            AppMethodBeat.o(60374);
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzy.size() > 0 || googleSignInOptions.zzy.size() > 0) {
                AppMethodBeat.o(60374);
                return false;
            } else if (this.zzr.size() == googleSignInOptions.getScopes().size() && this.zzr.containsAll(googleSignInOptions.getScopes())) {
                if (this.zzs != null ? this.zzs.equals(googleSignInOptions.getAccount()) : googleSignInOptions.getAccount() == null) {
                    if (TextUtils.isEmpty(this.zzw)) {
                    }
                    if (this.zzv == googleSignInOptions.isForceCodeForRefreshToken() && this.zzt == googleSignInOptions.isIdTokenRequested() && this.zzu == googleSignInOptions.isServerAuthCodeRequested()) {
                        AppMethodBeat.o(60374);
                        return true;
                    }
                }
                AppMethodBeat.o(60374);
                return false;
            } else {
                AppMethodBeat.o(60374);
                return false;
            }
        } catch (ClassCastException e) {
            AppMethodBeat.o(60374);
            return false;
        }
    }

    public Account getAccount() {
        return this.zzs;
    }

    public GoogleSignInOptionsExtensionParcelable getExtension(@TypeId int i) {
        AppMethodBeat.i(60371);
        GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) this.zzz.get(Integer.valueOf(i));
        AppMethodBeat.o(60371);
        return googleSignInOptionsExtensionParcelable;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zzy;
    }

    public String getHostedDomain() {
        return this.zzx;
    }

    public Scope[] getScopeArray() {
        AppMethodBeat.i(60369);
        Scope[] scopeArr = (Scope[]) this.zzr.toArray(new Scope[this.zzr.size()]);
        AppMethodBeat.o(60369);
        return scopeArr;
    }

    public ArrayList<Scope> getScopes() {
        AppMethodBeat.i(60368);
        ArrayList arrayList = new ArrayList(this.zzr);
        AppMethodBeat.o(60368);
        return arrayList;
    }

    public String getServerClientId() {
        return this.zzw;
    }

    public boolean hasExtension(@TypeId int i) {
        AppMethodBeat.i(60370);
        boolean containsKey = this.zzz.containsKey(Integer.valueOf(i));
        AppMethodBeat.o(60370);
        return containsKey;
    }

    public int hashCode() {
        AppMethodBeat.i(60375);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zzr;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).getScopeUri());
        }
        Collections.sort(arrayList);
        int hash = new HashAccumulator().addObject(arrayList).addObject(this.zzs).addObject(this.zzw).addBoolean(this.zzv).addBoolean(this.zzt).addBoolean(this.zzu).hash();
        AppMethodBeat.o(60375);
        return hash;
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zzv;
    }

    public boolean isIdTokenRequested() {
        return this.zzt;
    }

    public boolean isServerAuthCodeRequested() {
        return this.zzu;
    }

    public String toJson() {
        AppMethodBeat.i(60376);
        String jSONObject = zza().toString();
        AppMethodBeat.o(60376);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(60373);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, getHostedDomain(), false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(60373);
    }
}
