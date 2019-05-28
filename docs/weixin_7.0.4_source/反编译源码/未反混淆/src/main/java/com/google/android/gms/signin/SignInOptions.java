package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInOptions implements Optional {
    public static final SignInOptions DEFAULT = new Builder().build();
    private final boolean zzadb;
    private final boolean zzadc;
    private final Long zzadd;
    private final Long zzade;
    private final boolean zzt;
    private final boolean zzv;
    private final String zzw;
    private final String zzx;

    public static final class Builder {
        private boolean zzadf;
        private boolean zzadg;
        private String zzadh;
        private boolean zzadi;
        private String zzadj;
        private boolean zzadk;
        private Long zzadl;
        private Long zzadm;

        private final String zza(String str) {
            AppMethodBeat.i(61650);
            Preconditions.checkNotNull(str);
            boolean z = this.zzadh == null || this.zzadh.equals(str);
            Preconditions.checkArgument(z, "two different server client ids provided");
            AppMethodBeat.o(61650);
            return str;
        }

        public final SignInOptions build() {
            AppMethodBeat.i(61645);
            SignInOptions signInOptions = new SignInOptions(this.zzadf, this.zzadg, this.zzadh, this.zzadi, this.zzadj, this.zzadk, this.zzadl, this.zzadm, null);
            AppMethodBeat.o(61645);
            return signInOptions;
        }

        public final Builder requestIdToken(String str) {
            AppMethodBeat.i(61647);
            this.zzadg = true;
            this.zzadh = zza(str);
            AppMethodBeat.o(61647);
            return this;
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            AppMethodBeat.i(61646);
            this.zzadi = z;
            this.zzadf = true;
            this.zzadh = zza(str);
            AppMethodBeat.o(61646);
            return this;
        }

        public final Builder setAuthApiSignInModuleVersion(long j) {
            AppMethodBeat.i(61648);
            this.zzadl = Long.valueOf(j);
            AppMethodBeat.o(61648);
            return this;
        }

        public final Builder setHostedDomain(String str) {
            this.zzadj = str;
            return this;
        }

        public final Builder setRealClientLibraryVersion(long j) {
            AppMethodBeat.i(61649);
            this.zzadm = Long.valueOf(j);
            AppMethodBeat.o(61649);
            return this;
        }

        public final Builder setWaitForAccessTokenRefresh(boolean z) {
            this.zzadk = z;
            return this;
        }
    }

    static {
        AppMethodBeat.i(61651);
        AppMethodBeat.o(61651);
    }

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.zzadb = z;
        this.zzt = z2;
        this.zzw = str;
        this.zzv = z3;
        this.zzadc = z4;
        this.zzx = str2;
        this.zzadd = l;
        this.zzade = l2;
    }

    /* synthetic */ SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2, zzc zzc) {
        this(z, z2, str, z3, str2, z4, l, l2);
    }

    public final Long getAuthApiSignInModuleVersion() {
        return this.zzadd;
    }

    public final String getHostedDomain() {
        return this.zzx;
    }

    public final Long getRealClientLibraryVersion() {
        return this.zzade;
    }

    public final String getServerClientId() {
        return this.zzw;
    }

    public final boolean isForceCodeForRefreshToken() {
        return this.zzv;
    }

    public final boolean isIdTokenRequested() {
        return this.zzt;
    }

    public final boolean isOfflineAccessRequested() {
        return this.zzadb;
    }

    public final boolean waitForAccessTokenRefresh() {
        return this.zzadc;
    }
}
