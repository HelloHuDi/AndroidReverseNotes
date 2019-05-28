package com.facebook.appevents;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private static final HashSet<String> validatedIdentifiers = new HashSet();
    private final String checksum;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV2(String str, boolean z, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.checksum = str2;
        }

        private Object readResolve() {
            AppMethodBeat.i(71866);
            AppEvent appEvent = new AppEvent(this.jsonString, this.isImplicit, this.checksum);
            AppMethodBeat.o(71866);
            return appEvent;
        }
    }

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV1(String str, boolean z) {
            this.jsonString = str;
            this.isImplicit = z;
        }

        private Object readResolve() {
            AppMethodBeat.i(71865);
            AppEvent appEvent = new AppEvent(this.jsonString, this.isImplicit, null);
            AppMethodBeat.o(71865);
            return appEvent;
        }
    }

    static {
        AppMethodBeat.i(71876);
        AppMethodBeat.o(71876);
    }

    public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z, UUID uuid) {
        AppMethodBeat.i(71867);
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d, bundle, z, uuid);
        this.isImplicit = z;
        this.name = str2;
        this.checksum = calculateChecksum();
        AppMethodBeat.o(71867);
    }

    public String getName() {
        return this.name;
    }

    private AppEvent(String str, boolean z, String str2) {
        AppMethodBeat.i(71868);
        this.jsonObject = new JSONObject(str);
        this.isImplicit = z;
        this.name = this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        this.checksum = str2;
        AppMethodBeat.o(71868);
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public boolean isChecksumValid() {
        AppMethodBeat.i(71869);
        if (this.checksum == null) {
            AppMethodBeat.o(71869);
            return true;
        }
        boolean equals = calculateChecksum().equals(this.checksum);
        AppMethodBeat.o(71869);
        return equals;
    }

    private static void validateIdentifier(String str) {
        AppMethodBeat.i(71870);
        FacebookException facebookException;
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            facebookException = new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
            AppMethodBeat.o(71870);
            throw facebookException;
        }
        boolean contains;
        synchronized (validatedIdentifiers) {
            try {
                contains = validatedIdentifiers.contains(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71870);
            }
        }
        if (contains) {
            AppMethodBeat.o(71870);
        } else if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            synchronized (validatedIdentifiers) {
                try {
                    validatedIdentifiers.add(str);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(71870);
                    }
                }
            }
        } else {
            facebookException = new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
            AppMethodBeat.o(71870);
            throw facebookException;
        }
    }

    private static JSONObject getJSONObjectForAppEvent(String str, String str2, Double d, Bundle bundle, boolean z, UUID uuid) {
        AppMethodBeat.i(71871);
        validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, str2);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, md5Checksum(str2));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", "1");
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                validateIdentifier(str3);
                Object obj = bundle.get(str3);
                if ((obj instanceof String) || (obj instanceof Number)) {
                    jSONObject.put(str3, obj.toString());
                } else {
                    FacebookException facebookException = new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, str3}));
                    AppMethodBeat.o(71871);
                    throw facebookException;
                }
            }
        }
        if (!z) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        AppMethodBeat.o(71871);
        return jSONObject;
    }

    private Object writeReplace() {
        AppMethodBeat.i(71872);
        SerializationProxyV2 serializationProxyV2 = new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum);
        AppMethodBeat.o(71872);
        return serializationProxyV2;
    }

    public String toString() {
        AppMethodBeat.i(71873);
        String format = String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
        AppMethodBeat.o(71873);
        return format;
    }

    private String calculateChecksum() {
        AppMethodBeat.i(71874);
        String md5Checksum;
        if (VERSION.SDK_INT > 19) {
            md5Checksum = md5Checksum(this.jsonObject.toString());
            AppMethodBeat.o(71874);
            return md5Checksum;
        }
        ArrayList arrayList = new ArrayList();
        Iterator keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            md5Checksum = (String) it.next();
            stringBuilder.append(md5Checksum).append(" = ").append(this.jsonObject.optString(md5Checksum)).append(10);
        }
        md5Checksum = md5Checksum(stringBuilder.toString());
        AppMethodBeat.o(71874);
        return md5Checksum;
    }

    private static String md5Checksum(String str) {
        AppMethodBeat.i(71875);
        String bytesToHex;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            bytesToHex = AppEventUtility.bytesToHex(instance.digest());
            AppMethodBeat.o(71875);
            return bytesToHex;
        } catch (NoSuchAlgorithmException e) {
            Utility.logd("Failed to generate checksum: ", e);
            bytesToHex = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.o(71875);
            return bytesToHex;
        } catch (UnsupportedEncodingException e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            bytesToHex = "1";
            AppMethodBeat.o(71875);
            return bytesToHex;
        }
    }
}
