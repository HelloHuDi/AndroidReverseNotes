package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

/* renamed from: com.google.firebase.analytics.connector.a */
public interface C41643a {
    @KeepForSdk
    void logEvent(String str, String str2, Bundle bundle);

    @KeepForSdk
    void setUserProperty(String str, String str2, Object obj);
}
