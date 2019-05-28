package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.p1161auth-api-phone.zzj;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SmsRetriever {
    public static final String EXTRA_SMS_MESSAGE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE";
    public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
    public static final String SMS_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED";

    private SmsRetriever() {
    }

    public static SmsRetrieverClient getClient(Activity activity) {
        AppMethodBeat.m2504i(80422);
        zzj zzj = new zzj(activity);
        AppMethodBeat.m2505o(80422);
        return zzj;
    }

    public static SmsRetrieverClient getClient(Context context) {
        AppMethodBeat.m2504i(80421);
        zzj zzj = new zzj(context);
        AppMethodBeat.m2505o(80421);
        return zzj;
    }
}
