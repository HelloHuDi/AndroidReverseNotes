package com.p081b.p082a.p083a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.b.a.a.k */
final class C8487k extends C25391c implements Listener, LocationListener {
    private static C8487k bEC;
    /* renamed from: Gn */
    private Context f2419Gn;
    /* renamed from: Wx */
    private LocationManager f2420Wx;
    private boolean bED;
    private GpsStatus bEE;
    private C8488a bEF;
    private final C0734l bEG = new C0734l();
    private Looper mLooper;

    /* renamed from: com.b.a.a.k$a */
    static class C8488a extends C8483a {
        final int bEH = 0;

        C8488a(long j) {
            super(j);
        }
    }

    /* renamed from: com.b.a.a.k$b */
    static class C8489b extends C31914p {
        final double bEI;
        final float bEJ;
        final float bEK;
        final int bEL;
        final int bEM;
        final long bEN;
        final double lat;
        final double lng;
        final float speed;

        /* synthetic */ C8489b(double d, double d2, double d3, float f, float f2, int i, int i2, float f3, long j, byte b) {
            this(d, d2, d3, f, f2, i, i2, f3, j);
        }

        private C8489b(double d, double d2, double d3, float f, float f2, int i, int i2, float f3, long j) {
            super(401);
            this.lat = d;
            this.lng = d2;
            this.bEI = d3;
            this.bEJ = f;
            this.speed = f2;
            this.bEL = i;
            this.bEM = i2;
            this.bEK = f3;
            this.bEN = j;
        }
    }

    private C8487k() {
        AppMethodBeat.m2504i(55593);
        AppMethodBeat.m2505o(55593);
    }

    /* renamed from: wc */
    static C8487k m15084wc() {
        AppMethodBeat.m2504i(55594);
        if (bEC == null) {
            bEC = new C8487k();
        }
        C8487k c8487k = bEC;
        AppMethodBeat.m2505o(55594);
        return c8487k;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: at */
    public final void mo18560at(Context context) {
        AppMethodBeat.m2504i(55596);
        this.f2419Gn = context;
        this.f2420Wx = (LocationManager) context.getSystemService(C8741b.LOCATION);
        boolean z = (this.f2420Wx == null || this.f2420Wx.getProvider("gps") == null) ? false : true;
        this.bED = z;
        AppMethodBeat.m2505o(55596);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vV */
    public final void mo18564vV() {
    }

    public final void onLocationChanged(Location location) {
        int i;
        int i2;
        AppMethodBeat.m2504i(55599);
        if (!C44978y.bIM) {
            Object obj;
            if (Secure.getString(this.f2419Gn.getContentResolver(), "mock_location").equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(55599);
                return;
            }
        }
        int i3 = 0;
        if (this.bEE != null) {
            int i4 = 0;
            for (GpsSatellite usedInFix : this.bEE.getSatellites()) {
                i3++;
                if (usedInFix.usedInFix()) {
                    i4++;
                }
            }
            i = i4;
            i2 = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        this.bEG.mo2177a(location.getAccuracy(), i, location.getTime());
        mo18562c(new C8489b(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getSpeed(), i2, i, this.bEG.bEK, this.bEG.bES / 1000, (byte) 0));
        AppMethodBeat.m2505o(55599);
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onGpsStatusChanged(int i) {
        AppMethodBeat.m2504i(55600);
        if (i == 4) {
            if (this.bEE == null) {
                this.bEE = this.f2420Wx.getGpsStatus(null);
                AppMethodBeat.m2505o(55600);
                return;
            }
            this.f2420Wx.getGpsStatus(this.bEE);
        }
        AppMethodBeat.m2505o(55600);
    }

    /* renamed from: a */
    private void m15083a(long j, float f) {
        AppMethodBeat.m2504i(55601);
        this.f2420Wx.requestLocationUpdates("gps", j, f, this, this.mLooper);
        AppMethodBeat.m2505o(55601);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18559a(Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55595);
        if (c8483a == null) {
            c8483a = new C8488a(30000);
        } else if (c8483a instanceof C8488a) {
            C8488a c8488a = (C8488a) c8483a;
        } else {
            c8483a = new C8488a(c8483a.bCP);
        }
        super.mo18559a(handler, c8483a);
        AppMethodBeat.m2505o(55595);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18557a(Context context, Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55597);
        if (this.bED) {
            this.bEF = (C8488a) c8483a;
            this.mLooper = handler != null ? handler.getLooper() : null;
            m15083a(this.bEF.bCP, (float) this.bEF.bEH);
            this.f2420Wx.addGpsStatusListener(this);
            this.bEG.bEO = Math.max(5000, Math.min(this.bEF.bCP + 5000, 65000));
            AppMethodBeat.m2505o(55597);
            return;
        }
        AppMethodBeat.m2505o(55597);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: au */
    public final void mo18561au(Context context) {
        AppMethodBeat.m2504i(55598);
        if (this.bED) {
            this.f2420Wx.removeUpdates(this);
            this.f2420Wx.removeGpsStatusListener(this);
            AppMethodBeat.m2505o(55598);
            return;
        }
        AppMethodBeat.m2505o(55598);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vW */
    public final void mo18576vW() {
        AppMethodBeat.m2504i(55602);
        if (this.bED && this.isRunning && this.bEF.bCP < 300000) {
            m15083a(300000, (float) this.bEF.bEH);
            AppMethodBeat.m2505o(55602);
            return;
        }
        AppMethodBeat.m2505o(55602);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vX */
    public final void mo18577vX() {
        AppMethodBeat.m2504i(55603);
        if (this.bED && this.isRunning && this.bEF.bCP < 300000) {
            m15083a(this.bEF.bCP, (float) this.bEF.bEH);
            AppMethodBeat.m2505o(55603);
            return;
        }
        AppMethodBeat.m2505o(55603);
    }
}
