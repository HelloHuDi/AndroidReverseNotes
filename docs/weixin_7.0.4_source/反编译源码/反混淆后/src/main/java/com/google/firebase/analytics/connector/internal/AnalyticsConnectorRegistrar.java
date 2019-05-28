package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.C41642a;
import com.google.firebase.analytics.connector.C41643a;
import com.google.firebase.components.C25581f;
import com.google.firebase.components.C41645a;
import com.google.firebase.components.C41648e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements C41648e {
    @Keep
    @SuppressLint({"MissingPermission"})
    @KeepForSdk
    public List<C41645a<?>> getComponents() {
        AppMethodBeat.m2504i(67875);
        List singletonList = Collections.singletonList(C41645a.m73015y(C41643a.class).mo19759a(C25581f.m40563A(C41642a.class)).mo19759a(C25581f.m40563A(Context.class)).mo19758a(C17705a.buN).mo19760uA());
        AppMethodBeat.m2505o(67875);
        return singletonList;
    }
}
