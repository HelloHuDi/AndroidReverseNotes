package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_LOGGED_TIME_SEC = "LAST_LOGGED_TIME_SEC";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 43200;
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String PURCHASE_SUBS_STORE = "com.facebook.internal.PURCHASE_SUBS";
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final long SUBSCRIPTION_HARTBEAT_INTERVAL = 86400;
    private static final String TAG = InAppPurchaseEventManager.class.getCanonicalName();
    private static final HashMap<String, Class<?>> classMap = new HashMap();
    private static final HashMap<String, Method> methodMap = new HashMap();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences purchaseSubsSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_SUBS_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    InAppPurchaseEventManager() {
    }

    static {
        AppMethodBeat.m2504i(72210);
        AppMethodBeat.m2505o(72210);
    }

    public static Object asInterface(Context context, IBinder iBinder) {
        AppMethodBeat.m2504i(72192);
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
        AppMethodBeat.m2505o(72192);
        return invokeMethod;
    }

    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        AppMethodBeat.m2504i(72193);
        Map readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!readSkuDetailsFromCache.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        AppMethodBeat.m2505o(72193);
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        AppMethodBeat.m2504i(72194);
        HashMap hashMap = new HashMap();
        if (obj == null || arrayList.isEmpty()) {
            AppMethodBeat.m2505o(72194);
            return hashMap;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = PACKAGE_NAME;
        objArr[2] = z ? SUBSCRIPTION : INAPP;
        objArr[3] = bundle;
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
        if (invokeMethod != null) {
            Bundle bundle2 = (Bundle) invokeMethod;
            if (bundle2.getInt(RESPONSE_CODE) == 0) {
                ArrayList stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        hashMap.put(arrayList.get(i), stringArrayList.get(i));
                    }
                }
                writeSkuDetailsToCache(hashMap);
            }
        }
        AppMethodBeat.m2505o(72194);
        return hashMap;
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(72195);
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String string = skuDetailSharedPrefs.getString(str, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(str, split[1]);
                }
            }
        }
        AppMethodBeat.m2505o(72195);
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        AppMethodBeat.m2504i(72196);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Editor edit = skuDetailSharedPrefs.edit();
        for (Entry entry : map.entrySet()) {
            edit.putString((String) entry.getKey(), currentTimeMillis + ";" + ((String) entry.getValue()));
        }
        edit.apply();
        AppMethodBeat.m2505o(72196);
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        AppMethodBeat.m2504i(72197);
        Boolean bool;
        if (obj == null) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(72197);
            return bool;
        }
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{Integer.valueOf(3), PACKAGE_NAME, str});
        boolean z = invokeMethod != null && ((Integer) invokeMethod).intValue() == 0;
        bool = Boolean.valueOf(z);
        AppMethodBeat.m2505o(72197);
        return bool;
    }

    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        AppMethodBeat.m2504i(72198);
        ArrayList filterPurchasesInapp = filterPurchasesInapp(getPurchases(context, obj, INAPP));
        AppMethodBeat.m2505o(72198);
        return filterPurchasesInapp;
    }

    public static ArrayList<String> getPurchasesSubsExpire(Context context, Object obj) {
        AppMethodBeat.m2504i(72199);
        ArrayList<String> arrayList = new ArrayList();
        Map all = purchaseSubsSharedPrefs.getAll();
        if (all.isEmpty()) {
            AppMethodBeat.m2505o(72199);
            return arrayList;
        }
        String str;
        ArrayList purchases = getPurchases(context, obj, SUBSCRIPTION);
        HashSet hashSet = new HashSet();
        Iterator it = purchases.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(new JSONObject((String) it.next()).getString("productId"));
            } catch (JSONException e) {
            }
        }
        HashSet<String> hashSet2 = new HashSet();
        for (Entry key : all.entrySet()) {
            str = (String) key.getKey();
            if (!hashSet.contains(str)) {
                hashSet2.add(str);
            }
        }
        Editor edit = purchaseSubsSharedPrefs.edit();
        for (String str2 : hashSet2) {
            String string = purchaseSubsSharedPrefs.getString(str2, "");
            edit.remove(str2);
            if (!string.isEmpty()) {
                arrayList.add(purchaseSubsSharedPrefs.getString(str2, ""));
            }
        }
        edit.apply();
        AppMethodBeat.m2505o(72199);
        return arrayList;
    }

    public static Map<String, SubscriptionType> getPurchasesSubs(Context context, Object obj) {
        AppMethodBeat.m2504i(72200);
        HashMap hashMap = new HashMap();
        Iterator it = getPurchases(context, obj, SUBSCRIPTION).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            SubscriptionType subsType = getSubsType(str);
            if (!(subsType == SubscriptionType.DUPLICATED || subsType == SubscriptionType.UNKNOWN)) {
                hashMap.put(str, subsType);
            }
        }
        AppMethodBeat.m2505o(72200);
        return hashMap;
    }

    private static SubscriptionType getSubsType(String str) {
        AppMethodBeat.m2504i(72201);
        SubscriptionType subscriptionType = null;
        try {
            JSONObject jSONObject;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("productId");
            String string2 = purchaseSubsSharedPrefs.getString(string, "");
            if (string2.isEmpty()) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string2);
            }
            if (!jSONObject.optString("purchaseToken").equals(jSONObject2.get("purchaseToken"))) {
                subscriptionType = currentTimeMillis - (jSONObject2.getLong("purchaseTime") / 1000) < 43200 ? SubscriptionType.NEW : SubscriptionType.HEARTBEAT;
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                boolean z = jSONObject.getBoolean("autoRenewing");
                boolean z2 = jSONObject2.getBoolean("autoRenewing");
                if (!z2 && z) {
                    subscriptionType = SubscriptionType.CANCEL;
                } else if (!z && z2) {
                    subscriptionType = SubscriptionType.RESTORE;
                }
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                if (currentTimeMillis - jSONObject.getLong(LAST_LOGGED_TIME_SEC) > 86400) {
                    subscriptionType = SubscriptionType.HEARTBEAT;
                } else {
                    subscriptionType = SubscriptionType.DUPLICATED;
                }
            }
            if (subscriptionType != SubscriptionType.DUPLICATED) {
                jSONObject2.put(LAST_LOGGED_TIME_SEC, currentTimeMillis);
                purchaseSubsSharedPrefs.edit().putString(string, jSONObject2.toString()).apply();
            }
            AppMethodBeat.m2505o(72201);
            return subscriptionType;
        } catch (JSONException e) {
            subscriptionType = SubscriptionType.UNKNOWN;
            AppMethodBeat.m2505o(72201);
            return subscriptionType;
        }
    }

    private static ArrayList<String> getPurchases(Context context, Object obj, String str) {
        AppMethodBeat.m2504i(72202);
        ArrayList<String> arrayList = new ArrayList();
        if (obj == null) {
            AppMethodBeat.m2505o(72202);
            return arrayList;
        }
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i = 0;
            String str2 = null;
            while (true) {
                int i2;
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASES, obj, new Object[]{Integer.valueOf(3), PACKAGE_NAME, str, str2});
                if (invokeMethod != null) {
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        ArrayList stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                        if (stringArrayList == null) {
                            break;
                        }
                        i += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        i2 = i;
                        if (i2 >= 30 || str2 == null) {
                            break;
                        }
                        i = i2;
                    }
                }
                i2 = i;
                str2 = null;
                i = i2;
            }
        }
        AppMethodBeat.m2505o(72202);
        return arrayList;
    }

    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        AppMethodBeat.m2504i(72203);
        ArrayList<String> arrayList = new ArrayList();
        if (obj == null) {
            AppMethodBeat.m2505o(72203);
            return arrayList;
        }
        Class cls = getClass(context, IN_APP_BILLING_SERVICE);
        if (cls == null) {
            AppMethodBeat.m2505o(72203);
            return arrayList;
        } else if (getMethod(cls, GET_PURCHASE_HISTORY) == null) {
            AppMethodBeat.m2505o(72203);
            return arrayList;
        } else {
            arrayList = filterPurchasesInapp(getPurchaseHistory(context, obj, INAPP));
            AppMethodBeat.m2505o(72203);
            return arrayList;
        }
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        AppMethodBeat.m2504i(72204);
        ArrayList arrayList = new ArrayList();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i = 0;
            Boolean bool = Boolean.FALSE;
            Object obj2 = null;
            while (true) {
                int i2;
                String obj22;
                Object[] objArr = new Object[]{Integer.valueOf(6), PACKAGE_NAME, str, obj22, new Bundle()};
                String str2 = null;
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, objArr);
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        Boolean bool2;
                        Iterator it = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST).iterator();
                        int i3 = i;
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(str3).getLong("purchaseTime") / 1000) > 1200) {
                                    bool2 = Boolean.TRUE;
                                    break;
                                }
                                arrayList.add(str3);
                                i3++;
                            } catch (JSONException e) {
                            }
                        }
                        bool2 = bool;
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        bool = bool2;
                        i2 = i3;
                        if (i2 >= 30 || str2 == null || bool.booleanValue()) {
                            break;
                        }
                        i = i2;
                        obj22 = str2;
                    }
                }
                i2 = i;
                i = i2;
                obj22 = str2;
            }
        }
        AppMethodBeat.m2505o(72204);
        return arrayList;
    }

    private static ArrayList<String> filterPurchasesInapp(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(72205);
        ArrayList arrayList2 = new ArrayList();
        Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 43200 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(str);
                }
            } catch (JSONException e) {
            }
        }
        edit.apply();
        AppMethodBeat.m2505o(72205);
        return arrayList2;
    }

    /* JADX WARNING: Missing block: B:9:0x0026, code skipped:
            switch(r2) {
                case 0: goto L_0x006f;
                case 1: goto L_0x0098;
                case 2: goto L_0x00b1;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00de;
                default: goto L_0x0029;
            };
     */
    /* JADX WARNING: Missing block: B:10:0x0029, code skipped:
            r0 = r9.getDeclaredMethod(r10, r1);
            methodMap.put(r10, r0);
     */
    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            r1 = new java.lang.Class[]{android.os.IBinder.class};
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            r1 = new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class, android.os.Bundle.class};
     */
    /* JADX WARNING: Missing block: B:34:0x00b1, code skipped:
            r1 = new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class};
     */
    /* JADX WARNING: Missing block: B:35:0x00c5, code skipped:
            r1 = new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class, java.lang.String.class};
     */
    /* JADX WARNING: Missing block: B:36:0x00de, code skipped:
            r1 = new java.lang.Class[]{java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class, java.lang.String.class, android.os.Bundle.class};
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Method getMethod(Class<?> cls, String str) {
        Object obj = null;
        AppMethodBeat.m2504i(72206);
        Method method = (Method) methodMap.get(str);
        if (method != null) {
            AppMethodBeat.m2505o(72206);
        } else {
            Class[] clsArr = null;
            try {
                int obj2;
                switch (str.hashCode()) {
                    case -1801122596:
                        if (str.equals(GET_PURCHASES)) {
                            obj2 = 3;
                            break;
                        }
                    case -1450694211:
                        if (str.equals(IS_BILLING_SUPPORTED)) {
                            obj2 = 2;
                            break;
                        }
                    case -1123215065:
                        if (str.equals(AS_INTERFACE)) {
                            break;
                        }
                        obj2 = -1;
                        break;
                    case -594356707:
                        if (str.equals(GET_PURCHASE_HISTORY)) {
                            obj2 = 4;
                            break;
                        }
                    case -573310373:
                        if (str.equals(GET_SKU_DETAILS)) {
                            obj2 = 1;
                            break;
                        }
                }
            } catch (NoSuchMethodException e) {
                new StringBuilder().append(cls.getName()).append(".").append(str).append(" method not found");
            }
        }
        return method;
        AppMethodBeat.m2505o(72206);
        return method;
    }

    private static Class<?> getClass(Context context, String str) {
        AppMethodBeat.m2504i(72207);
        Class<?> cls = (Class) classMap.get(str);
        if (cls != null) {
            AppMethodBeat.m2505o(72207);
        } else {
            try {
                cls = context.getClassLoader().loadClass(str);
                classMap.put(str, cls);
            } catch (ClassNotFoundException e) {
                new StringBuilder().append(str).append(" is not available, please add ").append(str).append(" to the project.");
            }
            AppMethodBeat.m2505o(72207);
        }
        return cls;
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Object obj2 = null;
        AppMethodBeat.m2504i(72208);
        Class cls = getClass(context, str);
        if (cls == null) {
            AppMethodBeat.m2505o(72208);
        } else {
            Method method = getMethod(cls, str2);
            if (method == null) {
                AppMethodBeat.m2505o(72208);
            } else {
                if (obj != null) {
                    obj = cls.cast(obj);
                }
                try {
                    obj2 = method.invoke(obj, objArr);
                    AppMethodBeat.m2505o(72208);
                } catch (IllegalAccessException e) {
                    new StringBuilder("Illegal access to method ").append(cls.getName()).append(".").append(method.getName());
                    AppMethodBeat.m2505o(72208);
                    return obj2;
                } catch (InvocationTargetException e2) {
                    new StringBuilder("Invocation target exception in ").append(cls.getName()).append(".").append(method.getName());
                    AppMethodBeat.m2505o(72208);
                    return obj2;
                }
            }
        }
        return obj2;
    }

    public static void clearSkuDetailsCache() {
        AppMethodBeat.m2504i(72209);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0);
        if (j == 0) {
            skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            AppMethodBeat.m2505o(72209);
            return;
        }
        if (currentTimeMillis - j > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
        AppMethodBeat.m2505o(72209);
    }
}
