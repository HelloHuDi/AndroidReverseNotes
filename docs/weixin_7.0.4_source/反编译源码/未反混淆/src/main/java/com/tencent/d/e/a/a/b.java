package com.tencent.d.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.d.e.a.b.a;
import com.tencent.d.e.a.b.e;
import com.tencent.d.e.a.b.g;
import com.tencent.d.f.d;
import com.tencent.d.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static final int[] AtE = new int[]{1, 5, 4, 8, 9, 2};
    private static int AtF = -1;

    public static a a(int i, int i2, Context context, int i3, SparseArray<i> sparseArray, List<k> list) {
        AppMethodBeat.i(114552);
        a aVar = new a();
        aVar.Aua = 0;
        aVar.few = "";
        aVar.uaV = i.cd(context, context.getPackageName()).versionCode;
        aVar.ArS = "14D6ACDE3C2F2F48";
        aVar.cIb = 500000;
        aVar.requestType = i3;
        aVar.Auc = atO(context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.addAll(((i) sparseArray.valueAt(i4)).fB(list));
        }
        if (arrayList.size() <= 0 || arrayList.get(0) == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid stateUnits");
            AppMethodBeat.o(114552);
            throw illegalArgumentException;
        }
        e eVar = new e();
        eVar.Auk = ((g) arrayList.get(0)).Aup;
        eVar.Aul = arrayList;
        eVar.Atn = i;
        eVar.action = i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(eVar);
        aVar.Aub = arrayList2;
        aVar.imei = atO(d.getIMEI(context));
        aVar.imsi = atO(d.iK(context));
        aVar.fwM = atO(Build.BRAND);
        aVar.model = atO(Build.MODEL);
        aVar.Aud = atO(Build.FINGERPRINT);
        aVar.Aue = iI(context);
        aVar.sdkVer = VERSION.SDK_INT;
        aVar.platform = 2;
        AppMethodBeat.o(114552);
        return aVar;
    }

    private static String atO(String str) {
        return str == null ? "" : str;
    }

    private static int iI(Context context) {
        int i;
        AppMethodBeat.i(114553);
        if (AtF == -1) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                i = AtF;
                AppMethodBeat.o(114553);
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
        AppMethodBeat.o(114553);
        return i;
    }
}
