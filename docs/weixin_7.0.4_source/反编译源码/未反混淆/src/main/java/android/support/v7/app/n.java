package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Calendar;

final class n {
    private static n Ww;
    private final LocationManager Wx;
    private final a Wy = new a();
    private final Context mContext;

    static class a {
        long WA;
        long WB;
        long WC;
        long WD;
        long WE;
        boolean Wz;

        a() {
        }
    }

    static n W(Context context) {
        if (Ww == null) {
            Context applicationContext = context.getApplicationContext();
            Ww = new n(applicationContext, (LocationManager) applicationContext.getSystemService(b.LOCATION));
        }
        return Ww;
    }

    private n(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.Wx = locationManager;
    }

    /* Access modifiers changed, original: final */
    public final boolean fC() {
        a aVar = this.Wy;
        if (fE()) {
            return aVar.Wz;
        }
        Location fD = fD();
        if (fD != null) {
            a(fD);
            return aVar.Wz;
        }
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location fD() {
        Location P;
        Location location = null;
        if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            P = P(TencentLocation.NETWORK_PROVIDER);
        } else {
            P = null;
        }
        if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = P("gps");
        }
        if (location == null || P == null) {
            return location != null ? location : P;
        } else {
            if (location.getTime() > P.getTime()) {
                return location;
            }
            return P;
        }
    }

    private Location P(String str) {
        try {
            if (this.Wx.isProviderEnabled(str)) {
                return this.Wx.getLastKnownLocation(str);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private boolean fE() {
        return this.Wy.WE > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        a aVar = this.Wy;
        long currentTimeMillis = System.currentTimeMillis();
        m fB = m.fB();
        fB.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = fB.Wu;
        fB.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = fB.state == 1;
        long j3 = fB.Wv;
        long j4 = fB.Wu;
        fB.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = fB.Wv;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        aVar.Wz = z;
        aVar.WA = j2;
        aVar.WB = j3;
        aVar.WC = j4;
        aVar.WD = j5;
        aVar.WE = j;
    }
}
