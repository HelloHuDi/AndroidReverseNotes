package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.e;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceRequestsHelper {
    static final String DEVICE_INFO_DEVICE = "device";
    static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    static final String SDK_FLAVOR = "android";
    static final String SDK_HEADER = "fbsdk";
    static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    private static HashMap<String, RegistrationListener> deviceRequestsListeners = new HashMap();

    static {
        AppMethodBeat.i(96608);
        AppMethodBeat.o(96608);
    }

    public static String getDeviceInfo() {
        AppMethodBeat.i(96601);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DEVICE_INFO_DEVICE, Build.DEVICE);
            jSONObject.put(DEVICE_INFO_MODEL, Build.MODEL);
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(96601);
        return jSONObject2;
    }

    public static boolean startAdvertisementService(String str) {
        AppMethodBeat.i(96602);
        if (isAvailable()) {
            boolean startAdvertisementServiceImpl = startAdvertisementServiceImpl(str);
            AppMethodBeat.o(96602);
            return startAdvertisementServiceImpl;
        }
        AppMethodBeat.o(96602);
        return false;
    }

    public static boolean isAvailable() {
        AppMethodBeat.i(96603);
        if (VERSION.SDK_INT < 16 || !FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
            AppMethodBeat.o(96603);
            return false;
        }
        AppMethodBeat.o(96603);
        return true;
    }

    public static Bitmap generateQRCode(String str) {
        Bitmap createBitmap;
        AppMethodBeat.i(96604);
        EnumMap enumMap = new EnumMap(c.class);
        enumMap.put(c.MARGIN, Integer.valueOf(2));
        try {
            b a = new e().a(str, a.QR_CODE, 200, 200, enumMap);
            int i = a.height;
            int i2 = a.width;
            int[] iArr = new int[(i * i2)];
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * i2;
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr[i4 + i5] = a.bB(i5, i3) ? WebView.NIGHT_MODE_COLOR : -1;
                }
            }
            createBitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
            try {
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i);
            } catch (h e) {
            }
        } catch (h e2) {
            createBitmap = null;
        }
        AppMethodBeat.o(96604);
        return createBitmap;
    }

    public static void cleanUpAdvertisementService(String str) {
        AppMethodBeat.i(96605);
        cleanUpAdvertisementServiceImpl(str);
        AppMethodBeat.o(96605);
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        AppMethodBeat.i(96606);
        if (deviceRequestsListeners.containsKey(str)) {
            AppMethodBeat.o(96606);
        } else {
            String replace = FacebookSdk.getSdkVersion().replace('.', '|');
            r2 = new Object[3];
            r2[1] = String.format("%s-%s", new Object[]{"android", replace});
            r2[2] = str;
            final String format = String.format("%s_%s_%s", r2);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType(SERVICE_TYPE);
            nsdServiceInfo.setServiceName(format);
            nsdServiceInfo.setPort(80);
            NsdManager nsdManager = (NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            AnonymousClass1 anonymousClass1 = new RegistrationListener() {
                public final void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                    AppMethodBeat.i(96599);
                    if (!format.equals(nsdServiceInfo.getServiceName())) {
                        DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    }
                    AppMethodBeat.o(96599);
                }

                public final void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                }

                public final void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                    AppMethodBeat.i(96600);
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    AppMethodBeat.o(96600);
                }

                public final void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                }
            };
            deviceRequestsListeners.put(str, anonymousClass1);
            nsdManager.registerService(nsdServiceInfo, 1, anonymousClass1);
            AppMethodBeat.o(96606);
        }
        return true;
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        AppMethodBeat.i(96607);
        RegistrationListener registrationListener = (RegistrationListener) deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e) {
                Utility.logd(TAG, e);
            }
            deviceRequestsListeners.remove(str);
        }
        AppMethodBeat.o(96607);
    }
}
