package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseActivityLifecycleTracker {
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$a";
    private static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    private static ActivityLifecycleCallbacks callbacks;
    private static Boolean hasBiillingActivity = null;
    private static Boolean hasBillingService = null;
    private static Object inAppBillingObj;
    private static Intent intent;
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);
    private static ServiceConnection serviceConnection;

    /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$1 */
    static class C85901 implements ServiceConnection {
        C85901() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(72179);
            InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), iBinder);
            AppMethodBeat.m2505o(72179);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2 */
    static class C85912 implements ActivityLifecycleCallbacks {

        /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2$1 */
        class C85921 implements Runnable {
            C85921() {
            }

            public void run() {
                AppMethodBeat.m2504i(72180);
                Context applicationContext = FacebookSdk.getApplicationContext();
                InAppPurchaseActivityLifecycleTracker.access$100(applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj));
                Map purchasesSubs = InAppPurchaseEventManager.getPurchasesSubs(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                Iterator it = InAppPurchaseEventManager.getPurchasesSubsExpire(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj).iterator();
                while (it.hasNext()) {
                    purchasesSubs.put((String) it.next(), SubscriptionType.EXPIRE);
                }
                InAppPurchaseActivityLifecycleTracker.access$200(applicationContext, purchasesSubs);
                AppMethodBeat.m2505o(72180);
            }
        }

        /* renamed from: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker$2$2 */
        class C85932 implements Runnable {
            C85932() {
            }

            public void run() {
                AppMethodBeat.m2504i(72181);
                Context applicationContext = FacebookSdk.getApplicationContext();
                ArrayList purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                if (purchasesInapp.isEmpty()) {
                    purchasesInapp = InAppPurchaseEventManager.getPurchaseHistoryInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                }
                InAppPurchaseActivityLifecycleTracker.access$100(applicationContext, purchasesInapp);
                AppMethodBeat.m2505o(72181);
            }
        }

        C85912() {
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.m2504i(72182);
            FacebookSdk.getExecutor().execute(new C85921());
            AppMethodBeat.m2505o(72182);
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.m2504i(72183);
            if (InAppPurchaseActivityLifecycleTracker.hasBiillingActivity.booleanValue() && activity.getLocalClassName().equals(InAppPurchaseActivityLifecycleTracker.BILLING_ACTIVITY_NAME)) {
                FacebookSdk.getExecutor().execute(new C85932());
            }
            AppMethodBeat.m2505o(72183);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    }

    static /* synthetic */ void access$100(Context context, ArrayList arrayList) {
        AppMethodBeat.m2504i(72189);
        logPurchaseInapp(context, arrayList);
        AppMethodBeat.m2505o(72189);
    }

    static /* synthetic */ void access$200(Context context, Map map) {
        AppMethodBeat.m2504i(72190);
        logPurchaseSubs(context, map);
        AppMethodBeat.m2505o(72190);
    }

    static {
        AppMethodBeat.m2504i(72191);
        AppMethodBeat.m2505o(72191);
    }

    public static void update() {
        AppMethodBeat.m2504i(72184);
        initializeIfNotInitialized();
        if (hasBillingService.booleanValue()) {
            if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                startTracking();
            }
            AppMethodBeat.m2505o(72184);
            return;
        }
        AppMethodBeat.m2505o(72184);
    }

    private static void initializeIfNotInitialized() {
        AppMethodBeat.m2504i(72185);
        if (hasBillingService != null) {
            AppMethodBeat.m2505o(72185);
            return;
        }
        try {
            Class.forName(SERVICE_INTERFACE_NAME);
            hasBillingService = Boolean.TRUE;
            try {
                Class.forName(BILLING_ACTIVITY_NAME);
                hasBiillingActivity = Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                hasBiillingActivity = Boolean.FALSE;
            }
            InAppPurchaseEventManager.clearSkuDetailsCache();
            intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
            serviceConnection = new C85901();
            callbacks = new C85912();
            AppMethodBeat.m2505o(72185);
        } catch (ClassNotFoundException e2) {
            hasBillingService = Boolean.FALSE;
            AppMethodBeat.m2505o(72185);
        }
    }

    private static void startTracking() {
        AppMethodBeat.m2504i(72186);
        if (isTracking.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(callbacks);
                applicationContext.bindService(intent, serviceConnection, 1);
            }
            AppMethodBeat.m2505o(72186);
            return;
        }
        AppMethodBeat.m2505o(72186);
    }

    private static void logPurchaseInapp(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(72187);
        if (arrayList.isEmpty()) {
            AppMethodBeat.m2505o(72187);
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                String string = new JSONObject(str).getString("productId");
                hashMap.put(string, str);
                arrayList2.add(string);
            } catch (JSONException e) {
            }
        }
        for (Entry entry : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, false).entrySet()) {
            AutomaticAnalyticsLogger.logPurchaseInapp((String) hashMap.get(entry.getKey()), (String) entry.getValue());
        }
        AppMethodBeat.m2505o(72187);
    }

    private static void logPurchaseSubs(Context context, Map<String, SubscriptionType> map) {
        AppMethodBeat.m2504i(72188);
        if (map.isEmpty()) {
            AppMethodBeat.m2505o(72188);
            return;
        }
        String str;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            try {
                String string = new JSONObject(str2).getString("productId");
                arrayList.add(string);
                hashMap.put(string, str2);
            } catch (JSONException e) {
            }
        }
        Map skuDetails = InAppPurchaseEventManager.getSkuDetails(context, arrayList, inAppBillingObj, true);
        for (String str3 : skuDetails.keySet()) {
            str2 = (String) hashMap.get(str3);
            AutomaticAnalyticsLogger.logPurchaseSubs((SubscriptionType) map.get(str2), str2, (String) skuDetails.get(str3));
        }
        AppMethodBeat.m2505o(72188);
    }
}
