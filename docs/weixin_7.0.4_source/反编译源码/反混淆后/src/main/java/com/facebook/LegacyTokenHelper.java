package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    static {
        AppMethodBeat.m2504i(71800);
        AppMethodBeat.m2505o(71800);
    }

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String str) {
        AppMethodBeat.m2504i(71774);
        Validate.notNull(context, "context");
        if (Utility.isNullOrEmpty(str)) {
            str = DEFAULT_CACHE_KEY;
        }
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.cache = context.getSharedPreferences(this.cacheKey, 0);
        AppMethodBeat.m2505o(71774);
    }

    public final Bundle load() {
        AppMethodBeat.m2504i(71775);
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                deserializeKey(str, bundle);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + str + "' -- " + e);
                AppMethodBeat.m2505o(71775);
                return null;
            }
        }
        AppMethodBeat.m2505o(71775);
        return bundle;
    }

    public final void save(Bundle bundle) {
        AppMethodBeat.m2504i(71776);
        Validate.notNull(bundle, "bundle");
        Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, edit);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + str + "' -- " + e);
                AppMethodBeat.m2505o(71776);
                return;
            }
        }
        edit.apply();
        AppMethodBeat.m2505o(71776);
    }

    public final void clear() {
        AppMethodBeat.m2504i(71777);
        this.cache.edit().clear().apply();
        AppMethodBeat.m2505o(71777);
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        AppMethodBeat.m2504i(71778);
        if (bundle == null) {
            AppMethodBeat.m2505o(71778);
            return false;
        }
        String string = bundle.getString(TOKEN_KEY);
        if (string == null || string.length() == 0) {
            AppMethodBeat.m2505o(71778);
            return false;
        } else if (bundle.getLong(EXPIRATION_DATE_KEY, 0) == 0) {
            AppMethodBeat.m2505o(71778);
            return false;
        } else {
            AppMethodBeat.m2505o(71778);
            return true;
        }
    }

    public static String getToken(Bundle bundle) {
        AppMethodBeat.m2504i(71779);
        Validate.notNull(bundle, "bundle");
        String string = bundle.getString(TOKEN_KEY);
        AppMethodBeat.m2505o(71779);
        return string;
    }

    public static void putToken(Bundle bundle, String str) {
        AppMethodBeat.m2504i(71780);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(str, "value");
        bundle.putString(TOKEN_KEY, str);
        AppMethodBeat.m2505o(71780);
    }

    public static Date getExpirationDate(Bundle bundle) {
        AppMethodBeat.m2504i(71781);
        Validate.notNull(bundle, "bundle");
        Date date = getDate(bundle, EXPIRATION_DATE_KEY);
        AppMethodBeat.m2505o(71781);
        return date;
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        AppMethodBeat.m2504i(71782);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, EXPIRATION_DATE_KEY, date);
        AppMethodBeat.m2505o(71782);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        AppMethodBeat.m2504i(71783);
        Validate.notNull(bundle, "bundle");
        long j = bundle.getLong(EXPIRATION_DATE_KEY);
        AppMethodBeat.m2505o(71783);
        return j;
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j) {
        AppMethodBeat.m2504i(71784);
        Validate.notNull(bundle, "bundle");
        bundle.putLong(EXPIRATION_DATE_KEY, j);
        AppMethodBeat.m2505o(71784);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        AppMethodBeat.m2504i(71785);
        Validate.notNull(bundle, "bundle");
        ArrayList stringArrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (stringArrayList == null) {
            AppMethodBeat.m2505o(71785);
            return null;
        }
        Set<String> hashSet = new HashSet(stringArrayList);
        AppMethodBeat.m2505o(71785);
        return hashSet;
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        AppMethodBeat.m2504i(71786);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList(collection));
        AppMethodBeat.m2505o(71786);
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        AppMethodBeat.m2504i(71787);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList(collection));
        AppMethodBeat.m2505o(71787);
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        AppMethodBeat.m2504i(71788);
        Validate.notNull(bundle, "bundle");
        AccessTokenSource accessTokenSource;
        if (bundle.containsKey(TOKEN_SOURCE_KEY)) {
            accessTokenSource = (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY);
            AppMethodBeat.m2505o(71788);
            return accessTokenSource;
        } else if (bundle.getBoolean(IS_SSO_KEY)) {
            accessTokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            AppMethodBeat.m2505o(71788);
            return accessTokenSource;
        } else {
            accessTokenSource = AccessTokenSource.WEB_VIEW;
            AppMethodBeat.m2505o(71788);
            return accessTokenSource;
        }
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        AppMethodBeat.m2504i(71789);
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
        AppMethodBeat.m2505o(71789);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        AppMethodBeat.m2504i(71790);
        Validate.notNull(bundle, "bundle");
        Date date = getDate(bundle, LAST_REFRESH_DATE_KEY);
        AppMethodBeat.m2505o(71790);
        return date;
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        AppMethodBeat.m2504i(71791);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
        AppMethodBeat.m2505o(71791);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        AppMethodBeat.m2504i(71792);
        Validate.notNull(bundle, "bundle");
        long j = bundle.getLong(LAST_REFRESH_DATE_KEY);
        AppMethodBeat.m2505o(71792);
        return j;
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j) {
        AppMethodBeat.m2504i(71793);
        Validate.notNull(bundle, "bundle");
        bundle.putLong(LAST_REFRESH_DATE_KEY, j);
        AppMethodBeat.m2505o(71793);
    }

    public static String getApplicationId(Bundle bundle) {
        AppMethodBeat.m2504i(71794);
        Validate.notNull(bundle, "bundle");
        String string = bundle.getString(APPLICATION_ID_KEY);
        AppMethodBeat.m2505o(71794);
        return string;
    }

    public static void putApplicationId(Bundle bundle, String str) {
        AppMethodBeat.m2504i(71795);
        Validate.notNull(bundle, "bundle");
        bundle.putString(APPLICATION_ID_KEY, str);
        AppMethodBeat.m2505o(71795);
    }

    static Date getDate(Bundle bundle, String str) {
        AppMethodBeat.m2504i(71796);
        if (bundle == null) {
            AppMethodBeat.m2505o(71796);
            return null;
        }
        long j = bundle.getLong(str, INVALID_BUNDLE_MILLISECONDS);
        if (j == INVALID_BUNDLE_MILLISECONDS) {
            AppMethodBeat.m2505o(71796);
            return null;
        }
        Date date = new Date(j);
        AppMethodBeat.m2505o(71796);
        return date;
    }

    static void putDate(Bundle bundle, String str, Date date) {
        AppMethodBeat.m2504i(71797);
        bundle.putLong(str, date.getTime());
        AppMethodBeat.m2505o(71797);
    }

    private void serializeKey(String str, Bundle bundle, Editor editor) {
        int i = 0;
        AppMethodBeat.m2504i(71798);
        Object obj = bundle.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(71798);
            return;
        }
        Object obj2;
        JSONObject jSONObject = new JSONObject();
        String str2;
        String obj22;
        if (obj instanceof Byte) {
            str2 = TYPE_BYTE;
            jSONObject.put("value", ((Byte) obj).intValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Short) {
            str2 = TYPE_SHORT;
            jSONObject.put("value", ((Short) obj).intValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Integer) {
            str2 = TYPE_INTEGER;
            jSONObject.put("value", ((Integer) obj).intValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Long) {
            str2 = TYPE_LONG;
            jSONObject.put("value", ((Long) obj).longValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Float) {
            str2 = TYPE_FLOAT;
            jSONObject.put("value", ((Float) obj).doubleValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Double) {
            str2 = TYPE_DOUBLE;
            jSONObject.put("value", ((Double) obj).doubleValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Boolean) {
            str2 = TYPE_BOOLEAN;
            jSONObject.put("value", ((Boolean) obj).booleanValue());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Character) {
            str2 = TYPE_CHAR;
            jSONObject.put("value", obj.toString());
            obj = null;
            obj22 = str2;
        } else if (obj instanceof String) {
            str2 = TYPE_STRING;
            jSONObject.put("value", (String) obj);
            obj = null;
            obj22 = str2;
        } else if (obj instanceof Enum) {
            str2 = TYPE_ENUM;
            jSONObject.put("value", obj.toString());
            jSONObject.put(JSON_VALUE_ENUM_TYPE, obj.getClass().getName());
            obj = null;
            obj22 = str2;
        } else {
            JSONArray jSONArray = new JSONArray();
            String str3;
            int length;
            JSONArray jSONArray2;
            if (obj instanceof byte[]) {
                str3 = TYPE_BYTE_ARRAY;
                byte[] bArr = (byte[]) obj;
                length = bArr.length;
                while (i < length) {
                    jSONArray.put(bArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof short[]) {
                str3 = TYPE_SHORT_ARRAY;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i < length) {
                    jSONArray.put(sArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof int[]) {
                str3 = TYPE_INTEGER_ARRAY;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i < length) {
                    jSONArray.put(iArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof long[]) {
                str3 = TYPE_LONG_ARRAY;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i < length) {
                    jSONArray.put(jArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof float[]) {
                str3 = TYPE_FLOAT_ARRAY;
                float[] fArr = (float[]) obj;
                length = fArr.length;
                while (i < length) {
                    jSONArray.put((double) fArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof double[]) {
                str3 = TYPE_DOUBLE_ARRAY;
                double[] dArr = (double[]) obj;
                length = dArr.length;
                while (i < length) {
                    jSONArray.put(dArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof boolean[]) {
                str3 = TYPE_BOOLEAN_ARRAY;
                boolean[] zArr = (boolean[]) obj;
                length = zArr.length;
                while (i < length) {
                    jSONArray.put(zArr[i]);
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof char[]) {
                str3 = TYPE_CHAR_ARRAY;
                char[] cArr = (char[]) obj;
                length = cArr.length;
                while (i < length) {
                    jSONArray.put(String.valueOf(cArr[i]));
                    i++;
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else if (obj instanceof List) {
                str3 = TYPE_STRING_LIST;
                for (Object obj3 : (List) obj3) {
                    if (obj3 == null) {
                        obj3 = JSONObject.NULL;
                    }
                    jSONArray.put(obj3);
                }
                jSONArray2 = jSONArray;
                obj22 = str3;
            } else {
                obj3 = null;
                obj22 = null;
            }
        }
        if (obj22 != null) {
            jSONObject.put(JSON_VALUE_TYPE, obj22);
            if (obj3 != null) {
                jSONObject.putOpt("value", obj3);
            }
            editor.putString(str, jSONObject.toString());
        }
        AppMethodBeat.m2505o(71798);
    }

    private void deserializeKey(String str, Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(71799);
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i2;
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i < zArr.length) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_BYTE_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[jSONArray.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) jSONArray.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_SHORT_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            short[] sArr = new short[jSONArray.length()];
            while (i < sArr.length) {
                sArr[i] = (short) jSONArray.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_INTEGER_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            int[] iArr = new int[jSONArray.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_LONG_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            long[] jArr = new long[jSONArray.length()];
            while (i < jArr.length) {
                jArr[i] = jSONArray.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_FLOAT)) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_FLOAT_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            float[] fArr = new float[jSONArray.length()];
            while (i < fArr.length) {
                fArr[i] = (float) jSONArray.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_DOUBLE_ARRAY)) {
            jSONArray = jSONObject.getJSONArray("value");
            double[] dArr = new double[jSONArray.length()];
            while (i < dArr.length) {
                dArr[i] = jSONArray.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_CHAR)) {
            string = jSONObject.getString("value");
            if (string != null && string.length() == 1) {
                bundle.putChar(str, string.charAt(0));
            }
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_CHAR_ARRAY)) {
            jSONArray2 = jSONObject.getJSONArray("value");
            char[] cArr = new char[jSONArray2.length()];
            for (i2 = 0; i2 < cArr.length; i2++) {
                String string2 = jSONArray2.getString(i2);
                if (string2 != null && string2.length() == 1) {
                    cArr[i2] = string2.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_STRING)) {
            bundle.putString(str, jSONObject.getString("value"));
            AppMethodBeat.m2505o(71799);
        } else if (string.equals(TYPE_STRING_LIST)) {
            jSONArray2 = jSONObject.getJSONArray("value");
            int length = jSONArray2.length();
            ArrayList arrayList = new ArrayList(length);
            for (i2 = 0; i2 < length; i2++) {
                Object obj = jSONArray2.get(i2);
                if (obj == JSONObject.NULL) {
                    obj = null;
                } else {
                    String str2 = (String) obj;
                }
                arrayList.add(i2, obj);
            }
            bundle.putStringArrayList(str, arrayList);
            AppMethodBeat.m2505o(71799);
        } else {
            if (string.equals(TYPE_ENUM)) {
                try {
                    bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
                    AppMethodBeat.m2505o(71799);
                    return;
                } catch (ClassNotFoundException e) {
                    AppMethodBeat.m2505o(71799);
                    return;
                } catch (IllegalArgumentException e2) {
                }
            }
            AppMethodBeat.m2505o(71799);
        }
    }
}
