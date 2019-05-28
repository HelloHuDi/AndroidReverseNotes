package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import p077c.p078t.p079m.p080c.C8477f;

public class TencentExtraKeys {
    public static final boolean ALLOW_NLP_LOCATION = true;
    public static final boolean DIDI_INTERNAL = false;
    public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
    public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
    public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
    public static final String LOCATION_KEY_LOCALITY = "locality";
    public static final String LOCATION_KEY_NATION = "nation";
    public static final String LOCATION_KEY_ROUTE = "route";
    public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
    public static final String LOCATION_SOURCE_CELL = "cell";
    public static final String LOCATION_SOURCE_GPS = "gps";
    public static final String LOCATION_SOURCE_WIFI = "wifi";
    public static final String RAW_DATA = "raw_data";
    public static final String REQUEST_RAW_DATA = "request_raw_data";
    public static final boolean STRICT_CELL_FILTER = true;
    private static final String TAG = "TencentExtraKeys";
    public static final boolean TENCENT_INTERNAL = true;
    private static Context mContext;
    private static DexClassLoader mLoader;
    private static Object mProxyObj;
    private static Class mProxyclass;

    public static void setContext(Context context) {
        mContext = context;
    }

    private static boolean initProxy() {
        AppMethodBeat.m2504i(136435);
        try {
            if (mContext == null) {
                AppMethodBeat.m2505o(136435);
                return false;
            }
            DexClassLoader a = C8477f.m15035a(mContext).mo18530a();
            if (a == null) {
                AppMethodBeat.m2505o(136435);
                return false;
            }
            if (mProxyclass == null || mProxyObj == null) {
                Class loadClass = a.loadClass("com.tencent.map.geolocation.proxy.TencentExtraKeysProxy");
                mProxyclass = loadClass;
                mProxyObj = loadClass.newInstance();
            }
            AppMethodBeat.m2505o(136435);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136435);
            return false;
        }
    }

    public static void enableMockLocationFilter(boolean z) {
        AppMethodBeat.m2504i(136436);
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("enableMockLocationFilter", new Class[]{Boolean.TYPE}).invoke(mProxyObj, new Object[]{Boolean.valueOf(z)});
                AppMethodBeat.m2505o(136436);
                return;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136436);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136436);
        }
    }

    public static byte[] getRawData(TencentLocation tencentLocation) {
        AppMethodBeat.m2504i(136437);
        try {
            if (initProxy()) {
                byte[] bArr = (byte[]) mProxyclass.getDeclaredMethod("getRawData", new Class[]{TencentLocation.class}).invoke(mProxyObj, new Object[]{tencentLocation});
                AppMethodBeat.m2505o(136437);
                return bArr;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136437);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136437);
        }
    }

    public static TencentLocation setRawData(TencentLocation tencentLocation, byte[] bArr) {
        AppMethodBeat.m2504i(136438);
        try {
            if (initProxy()) {
                TencentLocation tencentLocation2 = (TencentLocation) mProxyclass.getDeclaredMethod("setRawData", new Class[]{TencentLocation.class, byte[].class}).invoke(mProxyObj, new Object[]{tencentLocation, bArr});
                AppMethodBeat.m2505o(136438);
                return tencentLocation2;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136438);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136438);
        }
    }

    public static String getRawQuery(TencentLocation tencentLocation) {
        AppMethodBeat.m2504i(136439);
        try {
            if (initProxy()) {
                String str = (String) mProxyclass.getDeclaredMethod("getRawQuery", new Class[]{TencentLocation.class}).invoke(mProxyObj, new Object[]{tencentLocation});
                AppMethodBeat.m2505o(136439);
                return str;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136439);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136439);
        }
    }

    public static void setRawQuery(TencentLocation tencentLocation, String str) {
        AppMethodBeat.m2504i(136440);
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setRawQuery", new Class[]{TencentLocation.class, String.class}).invoke(mProxyObj, new Object[]{tencentLocation, str});
                AppMethodBeat.m2505o(136440);
                return;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136440);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136440);
        }
    }

    public static Location getRawGps(TencentLocation tencentLocation) {
        AppMethodBeat.m2504i(136441);
        try {
            if (initProxy()) {
                Location location = (Location) mProxyclass.getDeclaredMethod("getRawGps", new Class[]{TencentLocation.class}).invoke(mProxyObj, new Object[]{tencentLocation});
                AppMethodBeat.m2505o(136441);
                return location;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136441);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136441);
        }
    }

    public static void setRawGps(TencentLocation tencentLocation, Location location) {
        AppMethodBeat.m2504i(136442);
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setRawGps", new Class[]{TencentLocation.class, Location.class}).invoke(mProxyObj, new Object[]{tencentLocation, location});
                AppMethodBeat.m2505o(136442);
                return;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136442);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136442);
        }
    }

    public static TencentLocationRequest setRequestRawData(TencentLocationRequest tencentLocationRequest, boolean z) {
        AppMethodBeat.m2504i(136443);
        try {
            if (initProxy()) {
                TencentLocationRequest tencentLocationRequest2 = (TencentLocationRequest) mProxyclass.getDeclaredMethod("setRequestRawData", new Class[]{TencentLocationRequest.class, Boolean.TYPE}).invoke(mProxyObj, new Object[]{tencentLocationRequest, Boolean.valueOf(z)});
                AppMethodBeat.m2505o(136443);
                return tencentLocationRequest2;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136443);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136443);
        }
    }

    public static boolean isRequestRawData(TencentLocationRequest tencentLocationRequest) {
        AppMethodBeat.m2504i(136444);
        try {
            if (initProxy()) {
                boolean booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("isRequestRawData", new Class[]{TencentLocationRequest.class}).invoke(mProxyObj, new Object[]{tencentLocationRequest})).booleanValue();
                AppMethodBeat.m2505o(136444);
                return booleanValue;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136444);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136444);
        }
    }

    public static boolean isAllowedLevel(int i) {
        AppMethodBeat.m2504i(136445);
        try {
            if (initProxy()) {
                boolean booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("isAllowedLevel", new Class[]{Integer.TYPE}).invoke(mProxyObj, new Object[]{Integer.valueOf(i)})).booleanValue();
                AppMethodBeat.m2505o(136445);
                return booleanValue;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136445);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136445);
        }
    }

    public static int isInsIllegalApp(Context context) {
        AppMethodBeat.m2504i(136446);
        try {
            mContext = context;
            if (initProxy()) {
                int intValue = ((Integer) mProxyclass.getDeclaredMethod("isInsIllegalApp", new Class[]{Context.class}).invoke(mProxyObj, new Object[]{context})).intValue();
                AppMethodBeat.m2505o(136446);
                return intValue;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136446);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136446);
        }
    }

    public static String getLocationSource(TencentLocation tencentLocation) {
        AppMethodBeat.m2504i(136447);
        try {
            if (initProxy()) {
                String str = (String) mProxyclass.getDeclaredMethod("getLocationSource", new Class[]{TencentLocation.class}).invoke(mProxyObj, new Object[]{tencentLocation});
                AppMethodBeat.m2505o(136447);
                return str;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136447);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136447);
        }
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.m2504i(136448);
        try {
            System.load(str);
            AppMethodBeat.m2505o(136448);
        } catch (Throwable th) {
            Exception exception = new Exception(th.toString());
            AppMethodBeat.m2505o(136448);
        }
    }

    public static void setTencentLog(Context context, File file) {
        AppMethodBeat.m2504i(136449);
        try {
            mContext = context;
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setTencentLog", new Class[]{Context.class, File.class}).invoke(mProxyObj, new Object[]{context, file});
                AppMethodBeat.m2505o(136449);
                return;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136449);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136449);
        }
    }

    public static void setTencentLogCallback(LocationLogCallback locationLogCallback) {
        AppMethodBeat.m2504i(136450);
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setTencentLogCallback", new Class[]{LocationLogCallback.class}).invoke(mProxyObj, new Object[]{locationLogCallback});
                AppMethodBeat.m2505o(136450);
                return;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136450);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136450);
        }
    }

    @Deprecated
    public static synchronized boolean isDebugEnabled() {
        boolean booleanValue;
        synchronized (TencentExtraKeys.class) {
            AppMethodBeat.m2504i(136451);
            try {
                if (initProxy()) {
                    booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("isDebugEnabled", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
                    AppMethodBeat.m2505o(136451);
                } else {
                    Exception exception = new Exception("proxy is error");
                    AppMethodBeat.m2505o(136451);
                    throw exception;
                }
            } catch (Throwable th) {
                Exception exception2 = new Exception(th.toString());
                AppMethodBeat.m2505o(136451);
            }
        }
        return booleanValue;
    }

    public static synchronized void setLogDir(File file) {
        synchronized (TencentExtraKeys.class) {
            AppMethodBeat.m2504i(136452);
            try {
                if (initProxy()) {
                    mProxyclass.getDeclaredMethod("setLogDir", new Class[]{File.class}).invoke(mProxyObj, new Object[]{file});
                    AppMethodBeat.m2505o(136452);
                } else {
                    Exception exception = new Exception("proxy is error");
                    AppMethodBeat.m2505o(136452);
                    throw exception;
                }
            } catch (Throwable th) {
                Exception exception2 = new Exception(th.toString());
                AppMethodBeat.m2505o(136452);
            }
        }
    }

    public static synchronized File getLogDir() {
        File file;
        synchronized (TencentExtraKeys.class) {
            AppMethodBeat.m2504i(136453);
            try {
                if (initProxy()) {
                    file = (File) mProxyclass.getDeclaredMethod("getLogDir", new Class[0]).invoke(mProxyObj, new Object[0]);
                    AppMethodBeat.m2505o(136453);
                } else {
                    Exception exception = new Exception("proxy is error");
                    AppMethodBeat.m2505o(136453);
                    throw exception;
                }
            } catch (Throwable th) {
                Exception exception2 = new Exception(th.toString());
                AppMethodBeat.m2505o(136453);
            }
        }
        return file;
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        boolean z = false;
        AppMethodBeat.m2504i(136454);
        try {
            if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
                System.loadLibrary("tencentloc");
            }
            if (initProxy()) {
                z = ((Boolean) mProxyclass.getDeclaredMethod("wgs84ToGcj02", new Class[]{double[].class, double[].class}).invoke(mProxyObj, new Object[]{dArr, dArr2})).booleanValue();
                AppMethodBeat.m2505o(136454);
                return z;
            }
            Exception exception = new Exception("proxy is error");
            AppMethodBeat.m2505o(136454);
            throw exception;
        } catch (Throwable th) {
            Exception exception2 = new Exception(th.toString());
            AppMethodBeat.m2505o(136454);
        }
    }
}
