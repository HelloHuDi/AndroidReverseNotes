package com.tencent.p127d.p132e.p133a.p134a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.p1165b.C17729a;
import com.tencent.p127d.p132e.p133a.p1165b.C17730g;
import com.tencent.p127d.p132e.p133a.p1165b.C41665e;
import com.tencent.p127d.p135f.C25603d;
import com.tencent.p127d.p135f.C32114i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.d.e.a.a.b */
public final class C8762b {
    private static final int[] AtE = new int[]{1, 5, 4, 8, 9, 2};
    private static int AtF = -1;

    /* renamed from: a */
    public static C17729a m15590a(int i, int i2, Context context, int i3, SparseArray<C8764i> sparseArray, List<C17728k> list) {
        AppMethodBeat.m2504i(114552);
        C17729a c17729a = new C17729a();
        c17729a.Aua = 0;
        c17729a.few = "";
        c17729a.uaV = C32114i.m52252cd(context, context.getPackageName()).versionCode;
        c17729a.ArS = "14D6ACDE3C2F2F48";
        c17729a.cIb = 500000;
        c17729a.requestType = i3;
        c17729a.Auc = C8762b.atO(context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.addAll(((C8764i) sparseArray.valueAt(i4)).mo19826fB(list));
        }
        if (arrayList.size() <= 0 || arrayList.get(0) == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid stateUnits");
            AppMethodBeat.m2505o(114552);
            throw illegalArgumentException;
        }
        C41665e c41665e = new C41665e();
        c41665e.Auk = ((C17730g) arrayList.get(0)).Aup;
        c41665e.Aul = arrayList;
        c41665e.Atn = i;
        c41665e.action = i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(c41665e);
        c17729a.Aub = arrayList2;
        c17729a.imei = C8762b.atO(C25603d.getIMEI(context));
        c17729a.imsi = C8762b.atO(C25603d.m40620iK(context));
        c17729a.fwM = C8762b.atO(Build.BRAND);
        c17729a.model = C8762b.atO(Build.MODEL);
        c17729a.Aud = C8762b.atO(Build.FINGERPRINT);
        c17729a.Aue = C8762b.m15591iI(context);
        c17729a.sdkVer = VERSION.SDK_INT;
        c17729a.platform = 2;
        AppMethodBeat.m2505o(114552);
        return c17729a;
    }

    private static String atO(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: iI */
    private static int m15591iI(Context context) {
        int i;
        AppMethodBeat.m2504i(114553);
        if (AtF == -1) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                i = AtF;
                AppMethodBeat.m2505o(114553);
                return i;
            }
            int i2 = 1;
            for (int i3 = 0; i3 < AtE.length; i3++) {
                int i4;
                if (sensorManager.getDefaultSensor(AtE[i3]) == null) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i2 |= i4 << i3;
            }
            AtF = i2;
        }
        i = AtF;
        AppMethodBeat.m2505o(114553);
        return i;
    }
}
