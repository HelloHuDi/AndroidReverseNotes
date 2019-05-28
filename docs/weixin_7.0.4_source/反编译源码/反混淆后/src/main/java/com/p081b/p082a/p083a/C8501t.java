package com.p081b.p082a.p083a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.p081b.p082a.p083a.C31911n.C0736a;
import com.p081b.p082a.p083a.C31911n.C8490b;
import com.p081b.p082a.p083a.C31911n.C8491c;
import com.p081b.p082a.p083a.C8493s.C8498e;
import com.p081b.p082a.p083a.C8493s.C8499g;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* renamed from: com.b.a.a.t */
public final class C8501t {
    private static final C8500a bGA = new C8500a();
    private static Context bGv;
    private static WeakReference<C8504b> bGw;
    private static WeakReference<C8503d> bGx;
    private static WeakReference<C8502c> bGy;
    private static WeakReference<C8505e> bGz;
    private static String imei;
    private static boolean isRunning = false;

    /* renamed from: com.b.a.a.t$a */
    static class C8500a implements C0735m {
        private C8500a() {
        }

        /* synthetic */ C8500a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo2178a(C31914p c31914p) {
            AppMethodBeat.m2504i(55577);
            C8502c c8502c;
            switch (c31914p.what) {
                case 8901:
                    if (C8501t.bGy != null) {
                        c8502c = (C8502c) C8501t.bGy.get();
                        if (c8502c != null) {
                            c8502c.onRefAdded(((C8498e) c31914p).bGt);
                            AppMethodBeat.m2505o(55577);
                            return;
                        }
                    }
                    break;
                case 8902:
                    if (C8501t.bGy != null) {
                        c8502c = (C8502c) C8501t.bGy.get();
                        if (c8502c != null) {
                            c8502c.onTrackProcessed(((C8499g) c31914p).bGu);
                            break;
                        }
                    }
                    break;
                case 9901:
                    if (C8501t.bGw != null) {
                        C8504b c8504b = (C8504b) C8501t.bGw.get();
                        if (c8504b != null) {
                            C0736a c0736a = (C0736a) c31914p;
                            c8504b.onLocationUpdate(c0736a.lat, c0736a.lng, c0736a.bFm, c0736a.bFn, c0736a.bFo);
                            AppMethodBeat.m2505o(55577);
                            return;
                        }
                    }
                    break;
                case 9902:
                    if (C8501t.bGx != null) {
                        C8503d c8503d = (C8503d) C8501t.bGx.get();
                        if (c8503d != null) {
                            C8490b c8490b = (C8490b) c31914p;
                            c8503d.onMessage(c8490b.code, c8490b.message);
                            AppMethodBeat.m2505o(55577);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(55577);
        }
    }

    /* renamed from: com.b.a.a.t$c */
    public interface C8502c {
        void onRefAdded(int i);

        void onTrackProcessed(boolean z);
    }

    /* renamed from: com.b.a.a.t$d */
    public interface C8503d {
        void onMessage(int i, String str);
    }

    /* renamed from: com.b.a.a.t$b */
    public interface C8504b {
        void onLocationUpdate(double d, double d2, int i, int i2, long j);
    }

    /* renamed from: com.b.a.a.t$e */
    public interface C8505e {
    }

    static {
        AppMethodBeat.m2504i(55578);
        AppMethodBeat.m2505o(55578);
    }

    /* renamed from: a */
    public static void m15103a(Context context, C31915q c31915q) {
        AppMethodBeat.m2504i(55579);
        bGv = context.getApplicationContext();
        try {
            C44977w.m82353wC().mo18558a(context, bGA);
            C37155r.m62256wg().bFP = c31915q;
            C37155r.m62256wg().bFQ = imei;
            AppMethodBeat.m2505o(55579);
        } catch (Exception e) {
            AppMethodBeat.m2505o(55579);
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    /* renamed from: a */
    public static boolean m15104a(Handler handler, long j, C8504b c8504b, C8503d c8503d) {
        AppMethodBeat.m2504i(55580);
        if (bGv == null) {
            AppMethodBeat.m2505o(55580);
            return false;
        } else if (isRunning) {
            AppMethodBeat.m2505o(55580);
            return true;
        } else {
            bGw = new WeakReference(c8504b);
            bGx = new WeakReference(c8503d);
            bGy = new WeakReference(null);
            try {
                C44977w wC = C44977w.m82353wC();
                if (handler == null) {
                    handler = new Handler(bGv.getMainLooper());
                }
                wC.mo18559a(handler, new C8491c(j, 5000));
                if (C44978y.bIM) {
                    C44978y.bIT = C31913o.m51803wf();
                    C31913o.m51802s("filter_input_log_" + C44978y.bIT, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                    C31913o.m51802s("filter_output_log_" + C44978y.bIT, "time,lat,lng,err,speed");
                    C31913o.m51802s("gps_log_" + C44978y.bIT, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                    C31913o.m51802s("post_processing_log_" + C44978y.bIT, "tag,lat,lng");
                }
                if (!(bGz == null || ((C8505e) bGz.get()) == null)) {
                    boolean isProviderEnabled;
                    LocationManager locationManager = (LocationManager) bGv.getSystemService(C8741b.LOCATION);
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
                AppMethodBeat.m2505o(55580);
                return true;
            } catch (Exception e3) {
                isRunning = false;
                AppMethodBeat.m2505o(55580);
                return false;
            }
        }
    }

    /* renamed from: wt */
    public static void m15105wt() {
        AppMethodBeat.m2504i(55581);
        try {
            C44977w.m82353wC().stop();
        } catch (Exception e) {
        } finally {
            isRunning = false;
            AppMethodBeat.m2505o(55581);
        }
    }

    public static void finish() {
        AppMethodBeat.m2504i(55582);
        try {
            C44977w.m82353wC().mo18565vY();
            AppMethodBeat.m2505o(55582);
        } catch (Exception e) {
            AppMethodBeat.m2505o(55582);
        }
    }
}
