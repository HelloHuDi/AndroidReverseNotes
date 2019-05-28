package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.Currency;

class InternalAppEventsLogger extends AppEventsLogger {
    InternalAppEventsLogger(Context context) {
        this(Utility.getActivityName(context), null, null);
        AppMethodBeat.i(72211);
        AppMethodBeat.o(72211);
    }

    InternalAppEventsLogger(String str, String str2, AccessToken accessToken) {
        super(str, str2, accessToken);
    }

    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(72212);
        super.logPurchaseImplicitlyInternal(bigDecimal, currency, bundle);
        AppMethodBeat.o(72212);
    }

    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(72213);
        super.logEventImplicitly(str, bigDecimal, currency, bundle);
        AppMethodBeat.o(72213);
    }
}
