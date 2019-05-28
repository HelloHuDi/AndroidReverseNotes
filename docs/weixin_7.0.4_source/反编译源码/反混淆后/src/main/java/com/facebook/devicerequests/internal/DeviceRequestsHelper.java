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
import com.google.p114b.C31249e;
import com.google.p114b.C37292a;
import com.google.p114b.C37300h;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
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
        AppMethodBeat.m2504i(96608);
        AppMethodBeat.m2505o(96608);
    }

    public static String getDeviceInfo() {
        AppMethodBeat.m2504i(96601);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DEVICE_INFO_DEVICE, Build.DEVICE);
            jSONObject.put(DEVICE_INFO_MODEL, Build.MODEL);
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.m2505o(96601);
        return jSONObject2;
    }

    public static boolean startAdvertisementService(String str) {
        AppMethodBeat.m2504i(96602);
        if (isAvailable()) {
            boolean startAdvertisementServiceImpl = startAdvertisementServiceImpl(str);
            AppMethodBeat.m2505o(96602);
            return startAdvertisementServiceImpl;
        }
        AppMethodBeat.m2505o(96602);
        return false;
    }

    public static boolean isAvailable() {
        AppMethodBeat.m2504i(96603);
        if (VERSION.SDK_INT < 16 || !FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
            AppMethodBeat.m2505o(96603);
            return false;
        }
        AppMethodBeat.m2505o(96603);
        return true;
    }

    public static Bitmap generateQRCode(String str) {
        Bitmap createBitmap;
        AppMethodBeat.m2504i(96604);
        EnumMap enumMap = new EnumMap(C41638c.class);
        enumMap.put(C41638c.MARGIN, Integer.valueOf(2));
        try {
            C45061b a = new C31249e().mo3688a(str, C37292a.QR_CODE, 200, 200, enumMap);
            int i = a.height;
            int i2 = a.width;
            int[] iArr = new int[(i * i2)];
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * i2;
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr[i4 + i5] = a.mo72817bB(i5, i3) ? WebView.NIGHT_MODE_COLOR : -1;
                }
            }
            createBitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
            try {
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i);
            } catch (C37300h e) {
            }
        } catch (C37300h e2) {
            createBitmap = null;
        }
        AppMethodBeat.m2505o(96604);
        return createBitmap;
    }

    public static void cleanUpAdvertisementService(String str) {
        AppMethodBeat.m2504i(96605);
        cleanUpAdvertisementServiceImpl(str);
        AppMethodBeat.m2505o(96605);
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        AppMethodBeat.m2504i(96606);
        if (deviceRequestsListeners.containsKey(str)) {
            AppMethodBeat.m2505o(96606);
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
            C175941 c175941 = new RegistrationListener() {
                public final void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                    AppMethodBeat.m2504i(96599);
                    if (!format.equals(nsdServiceInfo.getServiceName())) {
                        DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    }
                    AppMethodBeat.m2505o(96599);
                }

                public final void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                }

                public final void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                    AppMethodBeat.m2504i(96600);
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    AppMethodBeat.m2505o(96600);
                }

                public final void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                }
            };
            deviceRequestsListeners.put(str, c175941);
            nsdManager.registerService(nsdServiceInfo, 1, c175941);
            AppMethodBeat.m2505o(96606);
        }
        return true;
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        AppMethodBeat.m2504i(96607);
        RegistrationListener registrationListener = (RegistrationListener) deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e) {
                Utility.logd(TAG, e);
            }
            deviceRequestsListeners.remove(str);
        }
        AppMethodBeat.m2505o(96607);
    }
}
