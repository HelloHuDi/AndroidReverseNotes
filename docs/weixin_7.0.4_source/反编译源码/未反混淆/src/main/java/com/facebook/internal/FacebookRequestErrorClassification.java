package com.facebook.internal;

import com.facebook.FacebookRequestError.Category;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FacebookRequestErrorClassification {
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    public static final String KEY_NAME = "name";
    public static final String KEY_OTHER = "other";
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    public static final String KEY_TRANSIENT = "transient";
    private static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    FacebookRequestErrorClassification(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    public final String getRecoveryMessage(Category category) {
        AppMethodBeat.i(72284);
        String str;
        switch (category) {
            case OTHER:
                str = this.otherRecoveryMessage;
                AppMethodBeat.o(72284);
                return str;
            case LOGIN_RECOVERABLE:
                str = this.loginRecoverableRecoveryMessage;
                AppMethodBeat.o(72284);
                return str;
            case TRANSIENT:
                str = this.transientRecoveryMessage;
                AppMethodBeat.o(72284);
                return str;
            default:
                AppMethodBeat.o(72284);
                return null;
        }
    }

    public final Category classify(int i, int i2, boolean z) {
        AppMethodBeat.i(72285);
        Category category;
        if (z) {
            category = Category.TRANSIENT;
            AppMethodBeat.o(72285);
            return category;
        }
        Set set;
        if (this.otherErrors != null && this.otherErrors.containsKey(Integer.valueOf(i))) {
            set = (Set) this.otherErrors.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                category = Category.OTHER;
                AppMethodBeat.o(72285);
                return category;
            }
        }
        if (this.loginRecoverableErrors != null && this.loginRecoverableErrors.containsKey(Integer.valueOf(i))) {
            set = (Set) this.loginRecoverableErrors.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                category = Category.LOGIN_RECOVERABLE;
                AppMethodBeat.o(72285);
                return category;
            }
        }
        if (this.transientErrors != null && this.transientErrors.containsKey(Integer.valueOf(i))) {
            set = (Set) this.transientErrors.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(i2))) {
                category = Category.TRANSIENT;
                AppMethodBeat.o(72285);
                return category;
            }
        }
        category = Category.OTHER;
        AppMethodBeat.o(72285);
        return category;
    }

    public static synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            AppMethodBeat.i(72286);
            if (defaultInstance == null) {
                defaultInstance = getDefaultErrorClassificationImpl();
            }
            facebookRequestErrorClassification = defaultInstance;
            AppMethodBeat.o(72286);
        }
        return facebookRequestErrorClassification;
    }

    private static FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
        AppMethodBeat.i(72287);
        FacebookRequestErrorClassification facebookRequestErrorClassification = new FacebookRequestErrorClassification(null, new HashMap<Integer, Set<Integer>>() {
            {
                AppMethodBeat.i(72281);
                put(Integer.valueOf(2), null);
                put(Integer.valueOf(4), null);
                put(Integer.valueOf(9), null);
                put(Integer.valueOf(17), null);
                put(Integer.valueOf(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null);
                AppMethodBeat.o(72281);
            }
        }, new HashMap<Integer, Set<Integer>>() {
            {
                AppMethodBeat.i(72282);
                put(Integer.valueOf(102), null);
                put(Integer.valueOf(FacebookRequestErrorClassification.EC_INVALID_TOKEN), null);
                put(Integer.valueOf(412), null);
                AppMethodBeat.o(72282);
            }
        }, null, null, null);
        AppMethodBeat.o(72287);
        return facebookRequestErrorClassification;
    }

    private static Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
        AppMethodBeat.i(72288);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            AppMethodBeat.o(72288);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                if (optInt != 0) {
                    Object obj;
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                        obj = null;
                    } else {
                        HashSet hashSet = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            int optInt2 = optJSONArray2.optInt(i2);
                            if (optInt2 != 0) {
                                hashSet.add(Integer.valueOf(optInt2));
                            }
                        }
                        obj = hashSet;
                    }
                    hashMap.put(Integer.valueOf(optInt), obj);
                }
            }
        }
        AppMethodBeat.o(72288);
        return hashMap;
    }

    public static FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
        AppMethodBeat.i(72289);
        if (jSONArray == null) {
            AppMethodBeat.o(72289);
            return null;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        Map map = null;
        Map map2 = null;
        Map map3 = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("name");
                if (optString != null) {
                    if (optString.equalsIgnoreCase(KEY_OTHER)) {
                        str3 = optJSONObject.optString(KEY_RECOVERY_MESSAGE, null);
                        map3 = parseJSONDefinition(optJSONObject);
                    } else if (optString.equalsIgnoreCase(KEY_TRANSIENT)) {
                        str2 = optJSONObject.optString(KEY_RECOVERY_MESSAGE, null);
                        map2 = parseJSONDefinition(optJSONObject);
                    } else if (optString.equalsIgnoreCase(KEY_LOGIN_RECOVERABLE)) {
                        str = optJSONObject.optString(KEY_RECOVERY_MESSAGE, null);
                        map = parseJSONDefinition(optJSONObject);
                    }
                }
            }
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = new FacebookRequestErrorClassification(map3, map2, map, str3, str2, str);
        AppMethodBeat.o(72289);
        return facebookRequestErrorClassification;
    }
}
