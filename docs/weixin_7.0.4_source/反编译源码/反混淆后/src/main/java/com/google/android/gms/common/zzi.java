package com.google.android.gms.common;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzi extends zzg {
    private final String packageName;
    private final CertData zzbn;
    private final boolean zzbo;
    private final boolean zzbp;

    private zzi(String str, CertData certData, boolean z, boolean z2) {
        super(false, null, null);
        this.packageName = str;
        this.zzbn = certData;
        this.zzbo = z;
        this.zzbp = z2;
    }

    /* Access modifiers changed, original: final */
    public final String getErrorMessage() {
        AppMethodBeat.m2504i(90341);
        Object obj = this.zzbp ? "debug cert rejected" : "not whitelisted";
        String str = this.packageName;
        String bytesToStringLowercase = Hex.bytesToStringLowercase(AndroidUtilsLight.getMessageDigest("SHA-1").digest(this.zzbn.getBytes()));
        String stringBuilder = new StringBuilder(((String.valueOf(obj).length() + 44) + String.valueOf(str).length()) + String.valueOf(bytesToStringLowercase).length()).append(obj).append(": pkg=").append(str).append(", sha1=").append(bytesToStringLowercase).append(", atk=").append(this.zzbo).append(", ver=12451009.false").toString();
        AppMethodBeat.m2505o(90341);
        return stringBuilder;
    }
}
