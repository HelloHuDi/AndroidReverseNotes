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

final class l implements m {
    private l() {
    }

    /* synthetic */ l(byte b) {
        this();
    }

    private static Bundle ap(Context context) {
        Bundle bundle = null;
        AppMethodBeat.i(10618);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.o(10618);
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    AppMethodBeat.o(10618);
                } else {
                    bundle = serviceInfo.metaData;
                    AppMethodBeat.o(10618);
                }
            }
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(10618);
        }
        return bundle;
    }

    public final List<String> ao(Context context) {
        AppMethodBeat.i(10617);
        Bundle ap = ap(context);
        if (ap == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(10617);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : ap.keySet()) {
            if ("com.google.firebase.components.ComponentRegistrar".equals(ap.get(str)) && str.startsWith("com.google.firebase.components:")) {
                arrayList.add(str.substring(31));
            }
        }
        AppMethodBeat.o(10617);
        return arrayList;
    }
}
