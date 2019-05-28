package com.b.a.a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k extends c implements Listener, LocationListener {
    private static k bEC;
    private Context Gn;
    private LocationManager Wx;
    private boolean bED;
    private GpsStatus bEE;
    private a bEF;
    private final l bEG = new l();
    private Looper mLooper;

    static class a extends a {
        final int bEH = 0;

        a(long j) {
            super(j);
        }
    }

    static class b extends p {
        final double bEI;
        final float bEJ;
        final float bEK;
        final int bEL;
        final int bEM;
        final long bEN;
        final double lat;
        final double lng;
        final float speed;

        /* synthetic */ b(double d, double d2, double d3, float f, float f2, int i, int i2, float f3, long j, byte b) {
            this(d, d2, d3, f, f2, i, i2, f3, j);
        }

        private b(double d, double d2, double d3, float f, float f2, int i, int i2, float f3, long j) {
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

    private k() {
        AppMethodBeat.i(55593);
        AppMethodBeat.o(55593);
    }

    static k wc() {
        AppMethodBeat.i(55594);
        if (bEC == null) {
            bEC = new k();
        }
        k kVar = bEC;
        AppMethodBeat.o(55594);
        return kVar;
    }

    /* Access modifiers changed, original: final */
    public final void at(Context context) {
        AppMethodBeat.i(55596);
        this.Gn = context;
        this.Wx = (LocationManager) context.getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        boolean z = (this.Wx == null || this.Wx.getProvider("gps") == null) ? false : true;
        this.bED = z;
        AppMethodBeat.o(55596);
    }

    /* Access modifiers changed, original: final */
    public final void vV() {
    }

    public final void onLocationChanged(Location location) {
        int i;
        int i2;
        AppMethodBeat.i(55599);
        if (!y.bIM) {
            Object obj;
            if (Secure.getString(this.Gn.getContentResolver(), "mock_location").equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                AppMethodBeat.o(55599);
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
        this.bEG.a(location.getAccuracy(), i, location.getTime());
        c(new b(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getSpeed(), i2, i, this.bEG.bEK, this.bEG.bES / 1000, (byte) 0));
        AppMethodBeat.o(55599);
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onGpsStatusChanged(int i) {
        AppMethodBeat.i(55600);
        if (i == 4) {
            if (this.bEE == null) {
                this.bEE = this.Wx.getGpsStatus(null);
                AppMethodBeat.o(55600);
                return;
            }
            this.Wx.getGpsStatus(this.bEE);
        }
        AppMethodBeat.o(55600);
    }

    private void a(long j, float f) {
        AppMethodBeat.i(55601);
        this.Wx.requestLocationUpdates("gps", j, f, this, this.mLooper);
        AppMethodBeat.o(55601);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(Handler handler, a aVar) {
        AppMethodBeat.i(55595);
        if (aVar == null) {
            aVar = new a(30000);
        } else if (aVar instanceof a) {
            a aVar2 = (a) aVar;
        } else {
            aVar = new a(aVar.bCP);
        }
        super.a(handler, aVar);
        AppMethodBeat.o(55595);
    }

    /* Access modifiers changed, original: final */
    public final void a(Context context, Handler handler, a aVar) {
        AppMethodBeat.i(55597);
        if (this.bED) {
            this.bEF = (a) aVar;
            this.mLooper = handler != null ? handler.getLooper() : null;
            a(this.bEF.bCP, (float) this.bEF.bEH);
            this.Wx.addGpsStatusListener(this);
            this.bEG.bEO = Math.max(5000, Math.min(this.bEF.bCP + 5000, 65000));
            AppMethodBeat.o(55597);
            return;
        }
        AppMethodBeat.o(55597);
    }

    /* Access modifiers changed, original: final */
    public final void au(Context context) {
        AppMethodBeat.i(55598);
        if (this.bED) {
            this.Wx.removeUpdates(this);
            this.Wx.removeGpsStatusListener(this);
            AppMethodBeat.o(55598);
            return;
        }
        AppMethodBeat.o(55598);
    }

    /* Access modifiers changed, original: final */
    public final void vW() {
        AppMethodBeat.i(55602);
        if (this.bED && this.isRunning && this.bEF.bCP < 300000) {
            a(300000, (float) this.bEF.bEH);
            AppMethodBeat.o(55602);
            return;
        }
        AppMethodBeat.o(55602);
    }

    /* Access modifiers changed, original: final */
    public final void vX() {
        AppMethodBeat.i(55603);
        if (this.bED && this.isRunning && this.bEF.bCP < 300000) {
            a(this.bEF.bCP, (float) this.bEF.bEH);
            AppMethodBeat.o(55603);
            return;
        }
        AppMethodBeat.o(55603);
    }
}
