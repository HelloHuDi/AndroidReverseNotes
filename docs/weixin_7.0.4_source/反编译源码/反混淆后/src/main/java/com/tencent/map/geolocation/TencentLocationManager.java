package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import p077c.p078t.p079m.p080c.C25383e;
import p077c.p078t.p079m.p080c.C8477f;

public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    /* renamed from: b */
    private static TencentLocationManager f17121b;
    /* renamed from: c */
    private static Class f17122c;
    /* renamed from: d */
    private static Object f17123d;
    /* renamed from: a */
    private final byte[] f17124a = new byte[0];
    /* renamed from: e */
    private int f17125e = 0;
    /* renamed from: f */
    private Context f17126f;

    private TencentLocationManager(Context context) {
        AppMethodBeat.m2504i(136455);
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th) {
                this.f17125e = 3;
                AppMethodBeat.m2505o(136455);
                return;
            }
        }
        this.f17126f = context;
        try {
            DexClassLoader a = C8477f.m15035a(context).mo18530a();
            if (a == null) {
                C25383e.m40075a().mo42397a("LMI", "41");
                this.f17125e = 4;
                AppMethodBeat.m2505o(136455);
                return;
            }
            Class loadClass = a.loadClass("com.tencent.map.geolocation.proxy.TencentLocationManagerProxy");
            f17122c = loadClass;
            Object newInstance = loadClass.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            f17123d = newInstance;
            if (newInstance == null) {
                this.f17125e = 4;
                C25383e.m40075a().mo42397a("LMI", "42");
                AppMethodBeat.m2505o(136455);
                return;
            }
            C25383e.m40075a().mo42397a("LMI", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.m2505o(136455);
        } catch (Throwable th2) {
            this.f17125e = 5;
            C25383e.m40075a().mo42397a("LMI", "5" + th2.toString());
            AppMethodBeat.m2505o(136455);
        }
    }

    public static synchronized TencentLocationManager getInstance(Context context) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            AppMethodBeat.m2504i(136456);
            if (f17121b == null) {
                NullPointerException nullPointerException;
                if (context == null) {
                    nullPointerException = new NullPointerException("context is null");
                    AppMethodBeat.m2505o(136456);
                    throw nullPointerException;
                } else if (context.getApplicationContext() == null) {
                    nullPointerException = new NullPointerException("application context is null");
                    AppMethodBeat.m2505o(136456);
                    throw nullPointerException;
                } else {
                    System.currentTimeMillis();
                    f17121b = new TencentLocationManager(context.getApplicationContext());
                }
            }
            tencentLocationManager = f17121b;
            AppMethodBeat.m2505o(136456);
        }
        return tencentLocationManager;
    }

    public final void setCoordinateType(int i) {
        AppMethodBeat.m2504i(136457);
        if (i == 1 || i == 0) {
            try {
                synchronized (this.f17124a) {
                    try {
                        f17122c.getDeclaredMethod("setCoordinateType", new Class[]{Integer.TYPE}).invoke(f17123d, new Object[]{Integer.valueOf(i)});
                    } catch (Throwable th) {
                    }
                }
                AppMethodBeat.m2505o(136457);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(136457);
                return;
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.m2505o(136457);
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(136457);
        throw illegalArgumentException;
    }

    public final int getCoordinateType() {
        AppMethodBeat.m2504i(136458);
        try {
            int intValue = ((Integer) f17122c.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(f17123d, new Object[0])).intValue();
            AppMethodBeat.m2505o(136458);
            return intValue;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136458);
            return -1;
        }
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        AppMethodBeat.m2504i(136459);
        int i;
        if (this.f17125e > 0) {
            i = this.f17125e;
            AppMethodBeat.m2505o(136459);
            return i;
        }
        try {
            i = ((Integer) f17122c.getDeclaredMethod("requestLocationUpdates", new Class[]{TencentLocationRequest.class, TencentLocationListener.class}).invoke(f17123d, new Object[]{tencentLocationRequest, tencentLocationListener})).intValue();
            AppMethodBeat.m2505o(136459);
            return i;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136459);
            return 5;
        }
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        AppMethodBeat.m2504i(136460);
        System.currentTimeMillis();
        NullPointerException nullPointerException;
        int i;
        if (tencentLocationRequest == null) {
            nullPointerException = new NullPointerException("request is null");
            AppMethodBeat.m2505o(136460);
            throw nullPointerException;
        } else if (tencentLocationListener == null) {
            nullPointerException = new NullPointerException("listener is null");
            AppMethodBeat.m2505o(136460);
            throw nullPointerException;
        } else if (looper == null) {
            nullPointerException = new NullPointerException("looper is null");
            AppMethodBeat.m2505o(136460);
            throw nullPointerException;
        } else if (this.f17125e > 0) {
            i = this.f17125e;
            AppMethodBeat.m2505o(136460);
            return i;
        } else {
            synchronized (this.f17124a) {
                try {
                    Integer num = (Integer) f17122c.getDeclaredMethod("requestLocationUpdates", new Class[]{TencentLocationRequest.class, TencentLocationListener.class, Looper.class}).invoke(f17123d, new Object[]{tencentLocationRequest, tencentLocationListener, looper});
                    C25383e.m40075a().mo42397a("RLU", num.toString());
                    i = num.intValue();
                } catch (Throwable th) {
                    C25383e.m40075a().mo42397a("RLU", "5," + th.toString());
                    i = 5;
                    return i;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(136460);
                }
            }
            return i;
        }
    }

    public final int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        AppMethodBeat.m2504i(136461);
        NullPointerException nullPointerException;
        int i;
        if (tencentLocationListener == null) {
            nullPointerException = new NullPointerException("listener is null");
            AppMethodBeat.m2505o(136461);
            throw nullPointerException;
        } else if (looper == null) {
            nullPointerException = new NullPointerException("looper is null");
            AppMethodBeat.m2505o(136461);
            throw nullPointerException;
        } else if (this.f17125e > 0) {
            i = this.f17125e;
            AppMethodBeat.m2505o(136461);
            return i;
        } else {
            synchronized (this.f17124a) {
                try {
                    i = ((Integer) f17122c.getDeclaredMethod("requestSingleFreshLocation", new Class[]{TencentLocationRequest.class, TencentLocationListener.class, Looper.class}).invoke(f17123d, new Object[]{tencentLocationRequest, tencentLocationListener, looper})).intValue();
                    try {
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(136461);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(136461);
                    return 5;
                }
            }
            return i;
        }
    }

    public final boolean startIndoorLocation() {
        AppMethodBeat.m2504i(136462);
        try {
            boolean booleanValue = ((Boolean) f17122c.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(f17123d, new Object[0])).booleanValue();
            AppMethodBeat.m2505o(136462);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136462);
            return false;
        }
    }

    public final boolean stopIndoorLocation() {
        AppMethodBeat.m2504i(136463);
        try {
            boolean booleanValue = ((Boolean) f17122c.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(f17123d, new Object[0])).booleanValue();
            AppMethodBeat.m2505o(136463);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136463);
            return false;
        }
    }

    public final TencentLocation getLastKnownLocation() {
        AppMethodBeat.m2504i(136464);
        try {
            TencentLocation tencentLocation = (TencentLocation) f17122c.getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(f17123d, new Object[0]);
            AppMethodBeat.m2505o(136464);
            return tencentLocation;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136464);
            return null;
        }
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        AppMethodBeat.m2504i(136465);
        synchronized (this.f17124a) {
            try {
                f17122c.getDeclaredMethod("removeUpdates", new Class[]{TencentLocationListener.class}).invoke(f17123d, new Object[]{tencentLocationListener});
                C25383e.m40075a().mo42400c();
            } catch (Throwable th) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136465);
            }
        }
    }

    public final String getBuild() {
        AppMethodBeat.m2504i(136466);
        String str;
        try {
            str = (String) f17122c.getDeclaredMethod("getBuild", new Class[0]).invoke(f17123d, new Object[0]);
            AppMethodBeat.m2505o(136466);
            return str;
        } catch (Throwable th) {
            str = "error";
            AppMethodBeat.m2505o(136466);
            return str;
        }
    }

    public final String getVersion() {
        AppMethodBeat.m2504i(136467);
        String str;
        try {
            str = (String) f17122c.getDeclaredMethod("getVersion", new Class[0]).invoke(f17123d, new Object[0]);
            AppMethodBeat.m2505o(136467);
            return str;
        } catch (Throwable th) {
            str = "error";
            AppMethodBeat.m2505o(136467);
            return str;
        }
    }
}
