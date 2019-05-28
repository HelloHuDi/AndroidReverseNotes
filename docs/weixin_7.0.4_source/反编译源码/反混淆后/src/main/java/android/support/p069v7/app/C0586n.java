package android.support.p069v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.p057v4.content.C0384f;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Calendar;

/* renamed from: android.support.v7.app.n */
final class C0586n {
    /* renamed from: Ww */
    private static C0586n f901Ww;
    /* renamed from: Wx */
    private final LocationManager f902Wx;
    /* renamed from: Wy */
    private final C0585a f903Wy = new C0585a();
    private final Context mContext;

    /* renamed from: android.support.v7.app.n$a */
    static class C0585a {
        /* renamed from: WA */
        long f895WA;
        /* renamed from: WB */
        long f896WB;
        /* renamed from: WC */
        long f897WC;
        /* renamed from: WD */
        long f898WD;
        /* renamed from: WE */
        long f899WE;
        /* renamed from: Wz */
        boolean f900Wz;

        C0585a() {
        }
    }

    /* renamed from: W */
    static C0586n m1269W(Context context) {
        if (f901Ww == null) {
            Context applicationContext = context.getApplicationContext();
            f901Ww = new C0586n(applicationContext, (LocationManager) applicationContext.getSystemService(C8741b.LOCATION));
        }
        return f901Ww;
    }

    private C0586n(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.f902Wx = locationManager;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fC */
    public final boolean mo1427fC() {
        C0585a c0585a = this.f903Wy;
        if (m1272fE()) {
            return c0585a.f900Wz;
        }
        Location fD = m1271fD();
        if (fD != null) {
            m1270a(fD);
            return c0585a.f900Wz;
        }
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: fD */
    private Location m1271fD() {
        Location P;
        Location location = null;
        if (C0384f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            P = m1268P(TencentLocation.NETWORK_PROVIDER);
        } else {
            P = null;
        }
        if (C0384f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m1268P("gps");
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

    /* renamed from: P */
    private Location m1268P(String str) {
        try {
            if (this.f902Wx.isProviderEnabled(str)) {
                return this.f902Wx.getLastKnownLocation(str);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: fE */
    private boolean m1272fE() {
        return this.f903Wy.f899WE > System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m1270a(Location location) {
        long j;
        C0585a c0585a = this.f903Wy;
        long currentTimeMillis = System.currentTimeMillis();
        C0584m fB = C0584m.m1266fB();
        fB.mo1426a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = fB.f893Wu;
        fB.mo1426a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = fB.state == 1;
        long j3 = fB.f894Wv;
        long j4 = fB.f893Wu;
        fB.mo1426a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = fB.f894Wv;
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
        c0585a.f900Wz = z;
        c0585a.f895WA = j2;
        c0585a.f896WB = j3;
        c0585a.f897WC = j4;
        c0585a.f898WD = j5;
        c0585a.f899WE = j;
    }
}
