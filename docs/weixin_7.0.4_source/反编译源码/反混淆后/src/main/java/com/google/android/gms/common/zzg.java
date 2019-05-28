package com.google.android.gms.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzg {
    private static final zzg zzbk = new zzg(true, null, null);
    private final Throwable cause;
    final boolean zzbl;
    private final String zzbm;

    static {
        AppMethodBeat.m2504i(90340);
        AppMethodBeat.m2505o(90340);
    }

    zzg(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zzbl = z;
        this.zzbm = str;
        this.cause = th;
    }

    static zzg zza(String str, CertData certData, boolean z, boolean z2) {
        AppMethodBeat.m2504i(90335);
        zzi zzi = new zzi(str, certData, z, z2);
        AppMethodBeat.m2505o(90335);
        return zzi;
    }

    static zzg zza(String str, Throwable th) {
        AppMethodBeat.m2504i(90337);
        zzg zzg = new zzg(false, str, th);
        AppMethodBeat.m2505o(90337);
        return zzg;
    }

    static zzg zze(String str) {
        AppMethodBeat.m2504i(90336);
        zzg zzg = new zzg(false, str, null);
        AppMethodBeat.m2505o(90336);
        return zzg;
    }

    static zzg zzg() {
        return zzbk;
    }

    /* Access modifiers changed, original: 0000 */
    @Nullable
    public String getErrorMessage() {
        return this.zzbm;
    }

    /* Access modifiers changed, original: final */
    public final void zzh() {
        AppMethodBeat.m2504i(90338);
        if (this.zzbl) {
            AppMethodBeat.m2505o(90338);
            return;
        }
        String valueOf = String.valueOf("GoogleCertificatesRslt: ");
        String valueOf2 = String.valueOf(getErrorMessage());
        valueOf2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        SecurityException securityException;
        if (this.cause != null) {
            securityException = new SecurityException(valueOf2, this.cause);
            AppMethodBeat.m2505o(90338);
            throw securityException;
        }
        securityException = new SecurityException(valueOf2);
        AppMethodBeat.m2505o(90338);
        throw securityException;
    }

    /* Access modifiers changed, original: final */
    public final void zzi() {
        AppMethodBeat.m2504i(90339);
        if (!this.zzbl) {
            if (this.cause != null) {
                getErrorMessage();
                AppMethodBeat.m2505o(90339);
                return;
            }
            getErrorMessage();
        }
        AppMethodBeat.m2505o(90339);
    }
}
