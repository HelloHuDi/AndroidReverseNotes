package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.c.e;
import c.t.m.c.f;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;

public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    private static TencentLocationManager b;
    private static Class c;
    private static Object d;
    private final byte[] a = new byte[0];
    private int e = 0;
    private Context f;

    private TencentLocationManager(Context context) {
        AppMethodBeat.i(136455);
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th) {
                this.e = 3;
                AppMethodBeat.o(136455);
                return;
            }
        }
        this.f = context;
        try {
            DexClassLoader a = f.a(context).a();
            if (a == null) {
                e.a().a("LMI", "41");
                this.e = 4;
                AppMethodBeat.o(136455);
                return;
            }
            Class loadClass = a.loadClass("com.tencent.map.geolocation.proxy.TencentLocationManagerProxy");
            c = loadClass;
            Object newInstance = loadClass.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            d = newInstance;
            if (newInstance == null) {
                this.e = 4;
                e.a().a("LMI", "42");
                AppMethodBeat.o(136455);
                return;
            }
            e.a().a("LMI", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.o(136455);
        } catch (Throwable th2) {
            this.e = 5;
            e.a().a("LMI", "5" + th2.toString());
            AppMethodBeat.o(136455);
        }
    }

    public static synchronized TencentLocationManager getInstance(Context context) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            AppMethodBeat.i(136456);
            if (b == null) {
                NullPointerException nullPointerException;
                if (context == null) {
                    nullPointerException = new NullPointerException("context is null");
                    AppMethodBeat.o(136456);
                    throw nullPointerException;
                } else if (context.getApplicationContext() == null) {
                    nullPointerException = new NullPointerException("application context is null");
                    AppMethodBeat.o(136456);
                    throw nullPointerException;
                } else {
                    System.currentTimeMillis();
                    b = new TencentLocationManager(context.getApplicationContext());
                }
            }
            tencentLocationManager = b;
            AppMethodBeat.o(136456);
        }
        return tencentLocationManager;
    }

    public final void setCoordinateType(int i) {
        AppMethodBeat.i(136457);
        if (i == 1 || i == 0) {
            try {
                synchronized (this.a) {
                    try {
                        c.getDeclaredMethod("setCoordinateType", new Class[]{Integer.TYPE}).invoke(d, new Object[]{Integer.valueOf(i)});
                    } catch (Throwable th) {
                    }
                }
                AppMethodBeat.o(136457);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(136457);
                return;
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.o(136457);
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(i)));
        AppMethodBeat.o(136457);
        throw illegalArgumentException;
    }

    public final int getCoordinateType() {
        AppMethodBeat.i(136458);
        try {
            int intValue = ((Integer) c.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(d, new Object[0])).intValue();
            AppMethodBeat.o(136458);
            return intValue;
        } catch (Throwable th) {
            AppMethodBeat.o(136458);
            return -1;
        }
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        AppMethodBeat.i(136459);
        int i;
        if (this.e > 0) {
            i = this.e;
            AppMethodBeat.o(136459);
            return i;
        }
        try {
            i = ((Integer) c.getDeclaredMethod("requestLocationUpdates", new Class[]{TencentLocationRequest.class, TencentLocationListener.class}).invoke(d, new Object[]{tencentLocationRequest, tencentLocationListener})).intValue();
            AppMethodBeat.o(136459);
            return i;
        } catch (Throwable th) {
            AppMethodBeat.o(136459);
            return 5;
        }
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        AppMethodBeat.i(136460);
        System.currentTimeMillis();
        NullPointerException nullPointerException;
        int i;
        if (tencentLocationRequest == null) {
            nullPointerException = new NullPointerException("request is null");
            AppMethodBeat.o(136460);
            throw nullPointerException;
        } else if (tencentLocationListener == null) {
            nullPointerException = new NullPointerException("listener is null");
            AppMethodBeat.o(136460);
            throw nullPointerException;
        } else if (looper == null) {
            nullPointerException = new NullPointerException("looper is null");
            AppMethodBeat.o(136460);
            throw nullPointerException;
        } else if (this.e > 0) {
            i = this.e;
            AppMethodBeat.o(136460);
            return i;
        } else {
            synchronized (this.a) {
                try {
                    Integer num = (Integer) c.getDeclaredMethod("requestLocationUpdates", new Class[]{TencentLocationRequest.class, TencentLocationListener.class, Looper.class}).invoke(d, new Object[]{tencentLocationRequest, tencentLocationListener, looper});
                    e.a().a("RLU", num.toString());
                    i = num.intValue();
                } catch (Throwable th) {
                    e.a().a("RLU", "5," + th.toString());
                    i = 5;
                    return i;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(136460);
                }
            }
            return i;
        }
    }

    public final int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        AppMethodBeat.i(136461);
        NullPointerException nullPointerException;
        int i;
        if (tencentLocationListener == null) {
            nullPointerException = new NullPointerException("listener is null");
            AppMethodBeat.o(136461);
            throw nullPointerException;
        } else if (looper == null) {
            nullPointerException = new NullPointerException("looper is null");
            AppMethodBeat.o(136461);
            throw nullPointerException;
        } else if (this.e > 0) {
            i = this.e;
            AppMethodBeat.o(136461);
            return i;
        } else {
            synchronized (this.a) {
                try {
                    i = ((Integer) c.getDeclaredMethod("requestSingleFreshLocation", new Class[]{TencentLocationRequest.class, TencentLocationListener.class, Looper.class}).invoke(d, new Object[]{tencentLocationRequest, tencentLocationListener, looper})).intValue();
                    try {
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(136461);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136461);
                    return 5;
                }
            }
            return i;
        }
    }

    public final boolean startIndoorLocation() {
        AppMethodBeat.i(136462);
        try {
            boolean booleanValue = ((Boolean) c.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(d, new Object[0])).booleanValue();
            AppMethodBeat.o(136462);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(136462);
            return false;
        }
    }

    public final boolean stopIndoorLocation() {
        AppMethodBeat.i(136463);
        try {
            boolean booleanValue = ((Boolean) c.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(d, new Object[0])).booleanValue();
            AppMethodBeat.o(136463);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(136463);
            return false;
        }
    }

    public final TencentLocation getLastKnownLocation() {
        AppMethodBeat.i(136464);
        try {
            TencentLocation tencentLocation = (TencentLocation) c.getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(d, new Object[0]);
            AppMethodBeat.o(136464);
            return tencentLocation;
        } catch (Throwable th) {
            AppMethodBeat.o(136464);
            return null;
        }
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        AppMethodBeat.i(136465);
        synchronized (this.a) {
            try {
                c.getDeclaredMethod("removeUpdates", new Class[]{TencentLocationListener.class}).invoke(d, new Object[]{tencentLocationListener});
                e.a().c();
            } catch (Throwable th) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136465);
            }
        }
    }

    public final String getBuild() {
        AppMethodBeat.i(136466);
        String str;
        try {
            str = (String) c.getDeclaredMethod("getBuild", new Class[0]).invoke(d, new Object[0]);
            AppMethodBeat.o(136466);
            return str;
        } catch (Throwable th) {
            str = "error";
            AppMethodBeat.o(136466);
            return str;
        }
    }

    public final String getVersion() {
        AppMethodBeat.i(136467);
        String str;
        try {
            str = (String) c.getDeclaredMethod("getVersion", new Class[0]).invoke(d, new Object[0]);
            AppMethodBeat.o(136467);
            return str;
        } catch (Throwable th) {
            str = "error";
            AppMethodBeat.o(136467);
            return str;
        }
    }
}
