package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.firebase.components.l */
final class C37302l implements C45071m {
    private C37302l() {
    }

    /* synthetic */ C37302l(byte b) {
        this();
    }

    /* renamed from: ap */
    private static Bundle m62705ap(Context context) {
        Bundle bundle = null;
        AppMethodBeat.m2504i(10618);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.m2505o(10618);
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    AppMethodBeat.m2505o(10618);
                } else {
                    bundle = serviceInfo.metaData;
                    AppMethodBeat.m2505o(10618);
                }
            }
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(10618);
        }
        return bundle;
    }

    /* renamed from: ao */
    public final List<String> mo59989ao(Context context) {
        AppMethodBeat.m2504i(10617);
        Bundle ap = C37302l.m62705ap(context);
        if (ap == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(10617);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : ap.keySet()) {
            if ("com.google.firebase.components.ComponentRegistrar".equals(ap.get(str)) && str.startsWith("com.google.firebase.components:")) {
                arrayList.add(str.substring(31));
            }
        }
        AppMethodBeat.m2505o(10617);
        return arrayList;
    }
}
