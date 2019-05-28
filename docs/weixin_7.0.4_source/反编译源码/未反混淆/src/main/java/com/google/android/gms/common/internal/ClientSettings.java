package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.support.v4.f.b;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
public final class ClientSettings {
    public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
    private final Set<Scope> zzcv;
    private final int zzcx;
    private final View zzcy;
    private final String zzcz;
    private final String zzda;
    private final Set<Scope> zzrz;
    private final Account zzs;
    private final Map<Api<?>, OptionalApiSettings> zzsa;
    private final SignInOptions zzsb;
    private Integer zzsc;

    public static final class Builder {
        private int zzcx = 0;
        private View zzcy;
        private String zzcz;
        private String zzda;
        private Account zzs;
        private Map<Api<?>, OptionalApiSettings> zzsa;
        private SignInOptions zzsb = SignInOptions.DEFAULT;
        private b<Scope> zzsd;

        public final Builder addAllRequiredScopes(Collection<Scope> collection) {
            AppMethodBeat.i(61317);
            if (this.zzsd == null) {
                this.zzsd = new b();
            }
            this.zzsd.addAll(collection);
            AppMethodBeat.o(61317);
            return this;
        }

        public final Builder addRequiredScope(Scope scope) {
            AppMethodBeat.i(61316);
            if (this.zzsd == null) {
                this.zzsd = new b();
            }
            this.zzsd.add(scope);
            AppMethodBeat.o(61316);
            return this;
        }

        public final ClientSettings build() {
            AppMethodBeat.i(61318);
            ClientSettings clientSettings = new ClientSettings(this.zzs, this.zzsd, this.zzsa, this.zzcx, this.zzcy, this.zzcz, this.zzda, this.zzsb);
            AppMethodBeat.o(61318);
            return clientSettings;
        }

        public final Builder setAccount(Account account) {
            this.zzs = account;
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.zzcx = i;
            return this;
        }

        public final Builder setOptionalApiSettingsMap(Map<Api<?>, OptionalApiSettings> map) {
            this.zzsa = map;
            return this;
        }

        public final Builder setRealClientClassName(String str) {
            this.zzda = str;
            return this;
        }

        public final Builder setRealClientPackageName(String str) {
            this.zzcz = str;
            return this;
        }

        public final Builder setSignInOptions(SignInOptions signInOptions) {
            this.zzsb = signInOptions;
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.zzcy = view;
            return this;
        }
    }

    public static final class OptionalApiSettings {
        public final Set<Scope> mScopes;

        public OptionalApiSettings(Set<Scope> set) {
            AppMethodBeat.i(61319);
            Preconditions.checkNotNull(set);
            this.mScopes = Collections.unmodifiableSet(set);
            AppMethodBeat.o(61319);
        }
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions) {
        Map map2;
        AppMethodBeat.i(61321);
        this.zzs = account;
        this.zzcv = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map2 == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.zzsa = map2;
        this.zzcy = view;
        this.zzcx = i;
        this.zzcz = str;
        this.zzda = str2;
        this.zzsb = signInOptions;
        HashSet hashSet = new HashSet(this.zzcv);
        for (OptionalApiSettings optionalApiSettings : this.zzsa.values()) {
            hashSet.addAll(optionalApiSettings.mScopes);
        }
        this.zzrz = Collections.unmodifiableSet(hashSet);
        AppMethodBeat.o(61321);
    }

    public static ClientSettings createDefault(Context context) {
        AppMethodBeat.i(61320);
        ClientSettings buildClientSettings = new com.google.android.gms.common.api.GoogleApiClient.Builder(context).buildClientSettings();
        AppMethodBeat.o(61320);
        return buildClientSettings;
    }

    @Nullable
    public final Account getAccount() {
        return this.zzs;
    }

    @Deprecated
    @Nullable
    public final String getAccountName() {
        return this.zzs != null ? this.zzs.name : null;
    }

    public final Account getAccountOrDefault() {
        AppMethodBeat.i(61322);
        Account account;
        if (this.zzs != null) {
            account = this.zzs;
            AppMethodBeat.o(61322);
            return account;
        }
        account = new Account("<<default account>>", "com.google");
        AppMethodBeat.o(61322);
        return account;
    }

    public final Set<Scope> getAllRequestedScopes() {
        return this.zzrz;
    }

    public final Set<Scope> getApplicableScopes(Api<?> api) {
        AppMethodBeat.i(61323);
        OptionalApiSettings optionalApiSettings = (OptionalApiSettings) this.zzsa.get(api);
        if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty()) {
            Set set = this.zzcv;
            AppMethodBeat.o(61323);
            return set;
        }
        HashSet hashSet = new HashSet(this.zzcv);
        hashSet.addAll(optionalApiSettings.mScopes);
        AppMethodBeat.o(61323);
        return hashSet;
    }

    @Nullable
    public final Integer getClientSessionId() {
        return this.zzsc;
    }

    public final int getGravityForPopups() {
        return this.zzcx;
    }

    public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
        return this.zzsa;
    }

    @Nullable
    public final String getRealClientClassName() {
        return this.zzda;
    }

    @Nullable
    public final String getRealClientPackageName() {
        return this.zzcz;
    }

    public final Set<Scope> getRequiredScopes() {
        return this.zzcv;
    }

    @Nullable
    public final SignInOptions getSignInOptions() {
        return this.zzsb;
    }

    @Nullable
    public final View getViewForPopups() {
        return this.zzcy;
    }

    public final void setClientSessionId(Integer num) {
        this.zzsc = num;
    }
}
