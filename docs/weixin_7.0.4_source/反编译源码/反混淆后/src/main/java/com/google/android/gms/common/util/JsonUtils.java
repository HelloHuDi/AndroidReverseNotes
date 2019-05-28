package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
public final class JsonUtils {
    private static final Pattern zzaae = Pattern.compile("\\\\.");
    private static final Pattern zzaaf = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    static {
        AppMethodBeat.m2504i(90246);
        AppMethodBeat.m2505o(90246);
    }

    private JsonUtils() {
    }

    public static boolean areJsonStringsEquivalent(String str, String str2) {
        boolean z = false;
        AppMethodBeat.m2504i(90244);
        if (str == null && str2 == null) {
            AppMethodBeat.m2505o(90244);
            return true;
        } else if (str == null || str2 == null) {
            AppMethodBeat.m2505o(90244);
            return z;
        } else {
            try {
                z = areJsonValuesEquivalent(new JSONObject(str), new JSONObject(str2));
                AppMethodBeat.m2505o(90244);
                return z;
            } catch (JSONException e) {
                try {
                    z = areJsonValuesEquivalent(new JSONArray(str), new JSONArray(str2));
                    AppMethodBeat.m2505o(90244);
                    return z;
                } catch (JSONException e2) {
                    AppMethodBeat.m2505o(90244);
                    return z;
                }
            }
        }
    }

    public static boolean areJsonValuesEquivalent(Object obj, Object obj2) {
        AppMethodBeat.m2504i(90245);
        if (obj == null && obj2 == null) {
            AppMethodBeat.m2505o(90245);
            return true;
        } else if (obj == null || obj2 == null) {
            AppMethodBeat.m2505o(90245);
            return false;
        } else if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                AppMethodBeat.m2505o(90245);
                return false;
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (jSONObject2.has(str)) {
                    try {
                        if (!areJsonValuesEquivalent(jSONObject.get(str), jSONObject2.get(str))) {
                            AppMethodBeat.m2505o(90245);
                            return false;
                        }
                    } catch (JSONException e) {
                        AppMethodBeat.m2505o(90245);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(90245);
                return false;
            }
            AppMethodBeat.m2505o(90245);
            return true;
        } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray.length() != jSONArray2.length()) {
                AppMethodBeat.m2505o(90245);
                return false;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    if (areJsonValuesEquivalent(jSONArray.get(i), jSONArray2.get(i))) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(90245);
                        return false;
                    }
                } catch (JSONException e2) {
                    AppMethodBeat.m2505o(90245);
                    return false;
                }
            }
            AppMethodBeat.m2505o(90245);
            return true;
        } else {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.m2505o(90245);
            return equals;
        }
    }

    public static String escapeString(String str) {
        AppMethodBeat.m2504i(90243);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90243);
            return str;
        }
        Matcher matcher = zzaaf.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case 8:
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case 9:
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case 10:
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case 12:
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case 13:
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case '\"':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case '\\':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            AppMethodBeat.m2505o(90243);
            return str;
        }
        matcher.appendTail(stringBuffer);
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(90243);
        return str;
    }

    public static String unescapeString(String str) {
        AppMethodBeat.m2504i(90242);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90242);
            return str;
        }
        str = UnicodeUtils.unescape(str);
        Matcher matcher = zzaae.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(1)) {
                case '\"':
                    matcher.appendReplacement(stringBuffer, "\"");
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    matcher.appendReplacement(stringBuffer, "/");
                    break;
                case '\\':
                    matcher.appendReplacement(stringBuffer, "\\\\");
                    break;
                case 'b':
                    matcher.appendReplacement(stringBuffer, "\b");
                    break;
                case 'f':
                    matcher.appendReplacement(stringBuffer, "\f");
                    break;
                case 'n':
                    matcher.appendReplacement(stringBuffer, IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                case 'r':
                    matcher.appendReplacement(stringBuffer, "\r");
                    break;
                case 't':
                    matcher.appendReplacement(stringBuffer, "\t");
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Found an escaped character that should never be.");
                    AppMethodBeat.m2505o(90242);
                    throw illegalStateException;
            }
        }
        if (stringBuffer == null) {
            AppMethodBeat.m2505o(90242);
            return str;
        }
        matcher.appendTail(stringBuffer);
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(90242);
        return str;
    }
}
