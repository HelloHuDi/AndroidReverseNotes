package com.tencent.map.geolocation;

import android.content.Context;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p077c.p078t.p079m.p080c.C37150q;

public class TencentLocationUtils {
    private TencentLocationUtils() {
        AppMethodBeat.m2504i(136478);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(136478);
        throw unsupportedOperationException;
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        AppMethodBeat.m2504i(136479);
        if (tencentLocation == null || tencentLocation2 == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(136479);
            throw nullPointerException;
        }
        double a = C37150q.m62203a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
        AppMethodBeat.m2505o(136479);
        return a;
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        AppMethodBeat.m2504i(136480);
        double a = C37150q.m62203a(d, d2, d3, d4);
        AppMethodBeat.m2505o(136480);
        return a;
    }

    public static boolean contains(TencentLocation tencentLocation, double d, TencentLocation tencentLocation2) {
        AppMethodBeat.m2504i(136481);
        if (tencentLocation == null || tencentLocation2 == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(136481);
            throw nullPointerException;
        } else if (distanceBetween(tencentLocation, tencentLocation2) <= d) {
            AppMethodBeat.m2505o(136481);
            return true;
        } else {
            AppMethodBeat.m2505o(136481);
            return false;
        }
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        boolean z = false;
        AppMethodBeat.m2504i(136482);
        if (!(dArr == null || dArr2 == null)) {
            try {
                if (dArr.length == 2 && dArr2.length == 2) {
                    z = TencentExtraKeys.wgs84ToGcj02(dArr, dArr2);
                    AppMethodBeat.m2505o(136482);
                    return z;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(136482);
            }
        }
        AppMethodBeat.m2505o(136482);
        return z;
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        AppMethodBeat.m2504i(136483);
        if (tencentLocation == null) {
            AppMethodBeat.m2505o(136483);
            return false;
        }
        boolean equals = "gps".equals(tencentLocation.getProvider());
        AppMethodBeat.m2505o(136483);
        return equals;
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        AppMethodBeat.m2504i(136484);
        if (tencentLocation == null) {
            AppMethodBeat.m2505o(136484);
            return false;
        }
        boolean equals = TencentLocation.NETWORK_PROVIDER.equals(tencentLocation.getProvider());
        AppMethodBeat.m2505o(136484);
        return equals;
    }

    public static boolean isSupportGps(Context context) {
        AppMethodBeat.m2504i(136485);
        if (context == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(136485);
            throw nullPointerException;
        } else if ((C37150q.m62235g(context) & 16) == 0) {
            AppMethodBeat.m2505o(136485);
            return true;
        } else {
            AppMethodBeat.m2505o(136485);
            return false;
        }
    }
}
