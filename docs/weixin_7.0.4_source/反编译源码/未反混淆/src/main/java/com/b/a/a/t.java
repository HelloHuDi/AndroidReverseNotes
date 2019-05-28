package com.b.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class t {
    private static final a bGA = new a();
    private static Context bGv;
    private static WeakReference<b> bGw;
    private static WeakReference<d> bGx;
    private static WeakReference<c> bGy;
    private static WeakReference<e> bGz;
    private static String imei;
    private static boolean isRunning = false;

    static class a implements m {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(p pVar) {
            AppMethodBeat.i(55577);
            c cVar;
            switch (pVar.what) {
                case 8901:
                    if (t.bGy != null) {
                        cVar = (c) t.bGy.get();
                        if (cVar != null) {
                            cVar.onRefAdded(((e) pVar).bGt);
                            AppMethodBeat.o(55577);
                            return;
                        }
                    }
                    break;
                case 8902:
                    if (t.bGy != null) {
                        cVar = (c) t.bGy.get();
                        if (cVar != null) {
                            cVar.onTrackProcessed(((g) pVar).bGu);
                            break;
                        }
                    }
                    break;
                case 9901:
                    if (t.bGw != null) {
                        b bVar = (b) t.bGw.get();
                        if (bVar != null) {
                            a aVar = (a) pVar;
                            bVar.onLocationUpdate(aVar.lat, aVar.lng, aVar.bFm, aVar.bFn, aVar.bFo);
                            AppMethodBeat.o(55577);
                            return;
                        }
                    }
                    break;
                case 9902:
                    if (t.bGx != null) {
                        d dVar = (d) t.bGx.get();
                        if (dVar != null) {
                            b bVar2 = (b) pVar;
                            dVar.onMessage(bVar2.code, bVar2.message);
                            AppMethodBeat.o(55577);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(55577);
        }
    }

    public interface c {
        void onRefAdded(int i);

        void onTrackProcessed(boolean z);
    }

    public interface d {
        void onMessage(int i, String str);
    }

    public interface b {
        void onLocationUpdate(double d, double d2, int i, int i2, long j);
    }

    public interface e {
    }

    static {
        AppMethodBeat.i(55578);
        AppMethodBeat.o(55578);
    }

    public static void a(Context context, q qVar) {
        AppMethodBeat.i(55579);
        bGv = context.getApplicationContext();
        try {
            w.wC().a(context, bGA);
            r.wg().bFP = qVar;
            r.wg().bFQ = imei;
            AppMethodBeat.o(55579);
        } catch (Exception e) {
            AppMethodBeat.o(55579);
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j, b bVar, d dVar) {
        AppMethodBeat.i(55580);
        if (bGv == null) {
            AppMethodBeat.o(55580);
            return false;
        } else if (isRunning) {
            AppMethodBeat.o(55580);
            return true;
        } else {
            bGw = new WeakReference(bVar);
            bGx = new WeakReference(dVar);
            bGy = new WeakReference(null);
            try {
                w wC = w.wC();
                if (handler == null) {
                    handler = new Handler(bGv.getMainLooper());
                }
                wC.a(handler, new c(j, 5000));
                if (y.bIM) {
                    y.bIT = o.wf();
                    o.s("filter_input_log_" + y.bIT, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                    o.s("filter_output_log_" + y.bIT, "time,lat,lng,err,speed");
                    o.s("gps_log_" + y.bIT, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                    o.s("post_processing_log_" + y.bIT, "tag,lat,lng");
                }
                if (!(bGz == null || ((e) bGz.get()) == null)) {
                    boolean isProviderEnabled;
                    LocationManager locationManager = (LocationManager) bGv.getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
                    try {
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                    } catch (SecurityException e) {
                        isProviderEnabled = false;
                    }
                    if (!isProviderEnabled) {
                        try {
                            locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        } catch (SecurityException e2) {
                        }
                    }
                }
                isRunning = true;
                AppMethodBeat.o(55580);
                return true;
            } catch (Exception e3) {
                isRunning = false;
                AppMethodBeat.o(55580);
                return false;
            }
        }
    }

    public static void wt() {
        AppMethodBeat.i(55581);
        try {
            w.wC().stop();
        } catch (Exception e) {
        } finally {
            isRunning = false;
            AppMethodBeat.o(55581);
        }
    }

    public static void finish() {
        AppMethodBeat.i(55582);
        try {
            w.wC().vY();
            AppMethodBeat.o(55582);
        } catch (Exception e) {
            AppMethodBeat.o(55582);
        }
    }
}
