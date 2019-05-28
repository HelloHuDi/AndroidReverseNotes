package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.b */
public final class C41644b {
    private final String buI;
    public final String buJ;
    public final String zzs;
    private final String zzt;
    private final String zzu;
    private final String zzw;
    private final String zzx;

    private C41644b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(10596);
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.zzs = str;
        this.buI = str2;
        this.zzt = str3;
        this.zzu = str4;
        this.buJ = str5;
        this.zzw = str6;
        this.zzx = str7;
        AppMethodBeat.m2505o(10596);
    }

    /* renamed from: am */
    public static C41644b m73013am(Context context) {
        AppMethodBeat.m2504i(10597);
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            AppMethodBeat.m2505o(10597);
            return null;
        }
        C41644b c41644b = new C41644b(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
        AppMethodBeat.m2505o(10597);
        return c41644b;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(10598);
        if (obj instanceof C41644b) {
            C41644b c41644b = (C41644b) obj;
            if (Objects.equal(this.zzs, c41644b.zzs) && Objects.equal(this.buI, c41644b.buI) && Objects.equal(this.zzt, c41644b.zzt) && Objects.equal(this.zzu, c41644b.zzu) && Objects.equal(this.buJ, c41644b.buJ) && Objects.equal(this.zzw, c41644b.zzw) && Objects.equal(this.zzx, c41644b.zzx)) {
                AppMethodBeat.m2505o(10598);
                return true;
            }
            AppMethodBeat.m2505o(10598);
            return false;
        }
        AppMethodBeat.m2505o(10598);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(10599);
        int hashCode = Objects.hashCode(this.zzs, this.buI, this.zzt, this.zzu, this.buJ, this.zzw, this.zzx);
        AppMethodBeat.m2505o(10599);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(10600);
        String toStringHelper = Objects.toStringHelper(this).add("applicationId", this.zzs).add("apiKey", this.buI).add("databaseUrl", this.zzt).add("gcmSenderId", this.buJ).add("storageBucket", this.zzw).add("projectId", this.zzx).toString();
        AppMethodBeat.m2505o(10600);
        return toStringHelper;
    }
}
