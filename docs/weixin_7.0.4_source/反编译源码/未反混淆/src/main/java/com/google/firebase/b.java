package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private final String buI;
    public final String buJ;
    public final String zzs;
    private final String zzt;
    private final String zzu;
    private final String zzw;
    private final String zzx;

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(10596);
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.zzs = str;
        this.buI = str2;
        this.zzt = str3;
        this.zzu = str4;
        this.buJ = str5;
        this.zzw = str6;
        this.zzx = str7;
        AppMethodBeat.o(10596);
    }

    public static b am(Context context) {
        AppMethodBeat.i(10597);
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            AppMethodBeat.o(10597);
            return null;
        }
        b bVar = new b(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
        AppMethodBeat.o(10597);
        return bVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(10598);
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (Objects.equal(this.zzs, bVar.zzs) && Objects.equal(this.buI, bVar.buI) && Objects.equal(this.zzt, bVar.zzt) && Objects.equal(this.zzu, bVar.zzu) && Objects.equal(this.buJ, bVar.buJ) && Objects.equal(this.zzw, bVar.zzw) && Objects.equal(this.zzx, bVar.zzx)) {
                AppMethodBeat.o(10598);
                return true;
            }
            AppMethodBeat.o(10598);
            return false;
        }
        AppMethodBeat.o(10598);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(10599);
        int hashCode = Objects.hashCode(this.zzs, this.buI, this.zzt, this.zzu, this.buJ, this.zzw, this.zzx);
        AppMethodBeat.o(10599);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(10600);
        String toStringHelper = Objects.toStringHelper(this).add("applicationId", this.zzs).add("apiKey", this.buI).add("databaseUrl", this.zzt).add("gcmSenderId", this.buJ).add("storageBucket", this.zzw).add("projectId", this.zzx).toString();
        AppMethodBeat.o(10600);
        return toStringHelper;
    }
}
