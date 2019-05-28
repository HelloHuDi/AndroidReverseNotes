package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final int GINGERBREAD_MR1 = 10;
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    private static String carrierName = noCarrierConstant;
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static final String noCarrierConstant = "NoCarrier";
    private static int numCPUCores = 0;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    public interface Mapper<T, K> {
        K apply(T t);
    }

    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    public static class PermissionsPair {
        List<String> declinedPermissions;
        List<String> grantedPermissions;

        public PermissionsPair(List<String> list, List<String> list2) {
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
        }

        public List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }
    }

    public interface Predicate<T> {
        boolean apply(T t);
    }

    /* renamed from: com.facebook.internal.Utility$2 */
    static class C08102 implements FilenameFilter {
        C08102() {
        }

        public final boolean accept(File file, String str) {
            AppMethodBeat.m2504i(72491);
            boolean matches = Pattern.matches("cpu[0-9]+", str);
            AppMethodBeat.m2505o(72491);
            return matches;
        }
    }

    public static int[] intersectRanges(int[] iArr, int[] iArr2) {
        AppMethodBeat.m2504i(72492);
        if (iArr == null) {
            AppMethodBeat.m2505o(72492);
            return iArr2;
        } else if (iArr2 == null) {
            AppMethodBeat.m2505o(72492);
            return iArr;
        } else {
            int[] iArr3 = new int[(iArr.length + iArr2.length)];
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i2 < iArr.length && i < iArr2.length) {
                int i4;
                int i5;
                int i6;
                int i7 = iArr[i2];
                int i8 = iArr2[i];
                if (i2 < iArr.length - 1) {
                    i4 = iArr[i2 + 1];
                } else {
                    i4 = Integer.MAX_VALUE;
                }
                if (i < iArr2.length - 1) {
                    i5 = iArr2[i + 1];
                } else {
                    i5 = Integer.MAX_VALUE;
                }
                if (i7 < i8) {
                    if (i4 <= i8) {
                        i6 = i2 + 2;
                        i4 = Integer.MAX_VALUE;
                        i8 = Integer.MIN_VALUE;
                    } else if (i4 <= i5) {
                        i6 = i2 + 2;
                    } else {
                        i6 = i8;
                        i4 = i5;
                        i8 = i6;
                        i += 2;
                        i6 = i2;
                    }
                } else if (i5 <= i7) {
                    i4 = Integer.MAX_VALUE;
                    i8 = Integer.MIN_VALUE;
                    i += 2;
                    i6 = i2;
                } else if (i5 > i4) {
                    i6 = i2 + 2;
                    i8 = i7;
                } else {
                    i6 = i7;
                    i4 = i5;
                    i8 = i6;
                    i += 2;
                    i6 = i2;
                }
                if (i8 != Integer.MIN_VALUE) {
                    i2 = i3 + 1;
                    iArr3[i3] = i8;
                    if (i4 == Integer.MAX_VALUE) {
                        i3 = i2;
                        break;
                    }
                    i3 = i2 + 1;
                    iArr3[i2] = i4;
                }
                i2 = i6;
            }
            iArr2 = Arrays.copyOf(iArr3, i3);
            AppMethodBeat.m2505o(72492);
            return iArr2;
        }
    }

    public static <T> boolean isSubset(Collection<T> collection, Collection<T> collection2) {
        AppMethodBeat.m2504i(72493);
        if (collection2 != null && collection2.size() != 0) {
            HashSet hashSet = new HashSet(collection2);
            for (T contains : collection) {
                if (!hashSet.contains(contains)) {
                    AppMethodBeat.m2505o(72493);
                    return false;
                }
            }
            AppMethodBeat.m2505o(72493);
            return true;
        } else if (collection == null || collection.size() == 0) {
            AppMethodBeat.m2505o(72493);
            return true;
        } else {
            AppMethodBeat.m2505o(72493);
            return false;
        }
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        AppMethodBeat.m2504i(72494);
        if (collection == null || collection.size() == 0) {
            AppMethodBeat.m2505o(72494);
            return true;
        }
        AppMethodBeat.m2505o(72494);
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        AppMethodBeat.m2504i(72495);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(72495);
            return true;
        }
        AppMethodBeat.m2505o(72495);
        return false;
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        AppMethodBeat.m2504i(72496);
        if (isNullOrEmpty(str)) {
            AppMethodBeat.m2505o(72496);
            return str2;
        }
        AppMethodBeat.m2505o(72496);
        return str;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        AppMethodBeat.m2504i(72497);
        Collection unmodifiableCollection = Collections.unmodifiableCollection(Arrays.asList(tArr));
        AppMethodBeat.m2505o(72497);
        return unmodifiableCollection;
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        AppMethodBeat.m2504i(72498);
        ArrayList arrayList = new ArrayList(tArr.length);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        AppMethodBeat.m2505o(72498);
        return arrayList;
    }

    public static <T> HashSet<T> hashSet(T... tArr) {
        AppMethodBeat.m2504i(72499);
        HashSet hashSet = new HashSet(tArr.length);
        for (Object add : tArr) {
            hashSet.add(add);
        }
        AppMethodBeat.m2505o(72499);
        return hashSet;
    }

    public static String md5hash(String str) {
        AppMethodBeat.m2504i(72500);
        String hashWithAlgorithm = hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
        AppMethodBeat.m2505o(72500);
        return hashWithAlgorithm;
    }

    public static String sha1hash(String str) {
        AppMethodBeat.m2504i(72501);
        String hashWithAlgorithm = hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
        AppMethodBeat.m2505o(72501);
        return hashWithAlgorithm;
    }

    public static String sha1hash(byte[] bArr) {
        AppMethodBeat.m2504i(72502);
        String hashWithAlgorithm = hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
        AppMethodBeat.m2505o(72502);
        return hashWithAlgorithm;
    }

    private static String hashWithAlgorithm(String str, String str2) {
        AppMethodBeat.m2504i(72503);
        String hashWithAlgorithm = hashWithAlgorithm(str, str2.getBytes());
        AppMethodBeat.m2505o(72503);
        return hashWithAlgorithm;
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        AppMethodBeat.m2504i(72504);
        try {
            String hashBytes = hashBytes(MessageDigest.getInstance(str), bArr);
            AppMethodBeat.m2505o(72504);
            return hashBytes;
        } catch (NoSuchAlgorithmException e) {
            AppMethodBeat.m2505o(72504);
            return null;
        }
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        AppMethodBeat.m2504i(72505);
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString((b >> 0) & 15));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(72505);
        return stringBuilder2;
    }

    public static Uri buildUri(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(72506);
        Builder builder = new Builder();
        builder.scheme(URL_SCHEME);
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        AppMethodBeat.m2505o(72506);
        return build;
    }

    public static Bundle parseUrlQueryString(String str) {
        AppMethodBeat.m2504i(72507);
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], UTF8), URLDecoder.decode(split2[1], UTF8));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], UTF8), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    logd(LOG_TAG, e);
                }
            }
        }
        AppMethodBeat.m2505o(72507);
        return bundle;
    }

    public static void putNonEmptyString(Bundle bundle, String str, String str2) {
        AppMethodBeat.m2504i(72508);
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
        AppMethodBeat.m2505o(72508);
    }

    public static void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        AppMethodBeat.m2504i(72509);
        if (list != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : list) {
                stringBuilder.append(append);
                stringBuilder.append(",");
            }
            String append2 = "";
            if (stringBuilder.length() > 0) {
                append2 = stringBuilder.substring(0, stringBuilder.length() - 1);
            }
            bundle.putString(str, append2);
        }
        AppMethodBeat.m2505o(72509);
    }

    public static void putUri(Bundle bundle, String str, Uri uri) {
        AppMethodBeat.m2504i(72510);
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
        AppMethodBeat.m2505o(72510);
    }

    public static boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        AppMethodBeat.m2504i(72511);
        if (obj == null) {
            bundle.remove(str);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
        } else if (obj instanceof JSONObject) {
            bundle.putString(str, obj.toString());
        } else {
            AppMethodBeat.m2505o(72511);
            return false;
        }
        AppMethodBeat.m2505o(72511);
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.m2504i(72512);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                AppMethodBeat.m2505o(72512);
                return;
            }
        }
        AppMethodBeat.m2505o(72512);
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        AppMethodBeat.m2504i(72513);
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
        AppMethodBeat.m2505o(72513);
    }

    public static String getMetadataApplicationId(Context context) {
        AppMethodBeat.m2504i(72514);
        Validate.notNull(context, "context");
        FacebookSdk.sdkInitialize(context);
        String applicationId = FacebookSdk.getApplicationId();
        AppMethodBeat.m2505o(72514);
        return applicationId;
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        AppMethodBeat.m2504i(72515);
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < names.length()) {
                try {
                    String string = names.getString(i2);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = convertJSONObjectToHashMap((JSONObject) obj);
                    }
                    hashMap.put(string, obj);
                } catch (JSONException e) {
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(72515);
                return hashMap;
            }
        }
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) {
        Object obj;
        AppMethodBeat.m2504i(72516);
        Object opt = jSONObject.opt(str);
        if (opt == null || !(opt instanceof String)) {
            obj = opt;
        } else {
            obj = new JSONTokener((String) opt).nextValue();
        }
        if (obj == null || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            AppMethodBeat.m2505o(72516);
            return obj;
        } else if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, obj);
            AppMethodBeat.m2505o(72516);
            return jSONObject2;
        } else {
            FacebookException facebookException = new FacebookException("Got an unexpected non-JSON object.");
            AppMethodBeat.m2505o(72516);
            throw facebookException;
        }
    }

    public static String readStreamToString(InputStream inputStream) {
        Throwable th;
        AppMethodBeat.m2504i(72517);
        Closeable bufferedInputStream;
        Closeable inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringBuilder.append(cArr, 0, read);
                        } else {
                            String stringBuilder2 = stringBuilder.toString();
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            AppMethodBeat.m2505o(72517);
                            return stringBuilder2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    AppMethodBeat.m2505o(72517);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                AppMethodBeat.m2505o(72517);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            AppMethodBeat.m2505o(72517);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(72518);
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i += read;
                }
                bufferedInputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.m2505o(72518);
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                }
                if (inputStream != null) {
                }
                AppMethodBeat.m2505o(72518);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.m2505o(72518);
            throw th;
        }
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        AppMethodBeat.m2504i(72519);
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            AppMethodBeat.m2505o(72519);
            return true;
        } else if (isEmpty || isEmpty2) {
            AppMethodBeat.m2505o(72519);
            return false;
        } else {
            isEmpty = str.equals(str2);
            AppMethodBeat.m2505o(72519);
            return isEmpty;
        }
    }

    private static void clearCookiesForDomain(Context context, String str) {
        AppMethodBeat.m2504i(72520);
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie == null) {
            AppMethodBeat.m2505o(72520);
            return;
        }
        for (String split : cookie.split(";")) {
            String[] split2 = split.split("=");
            if (split2.length > 0) {
                instance.setCookie(str, split2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        instance.removeExpiredCookie();
        AppMethodBeat.m2505o(72520);
    }

    public static void clearFacebookCookies(Context context) {
        AppMethodBeat.m2504i(72521);
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
        AppMethodBeat.m2505o(72521);
    }

    public static void logd(String str, Exception exception) {
        AppMethodBeat.m2504i(72522);
        if (!(!FacebookSdk.isDebugEnabled() || str == null || exception == null)) {
            new StringBuilder().append(exception.getClass().getSimpleName()).append(": ").append(exception.getMessage());
        }
        AppMethodBeat.m2505o(72522);
    }

    public static void logd(String str, String str2) {
        AppMethodBeat.m2504i(72523);
        FacebookSdk.isDebugEnabled();
        AppMethodBeat.m2505o(72523);
    }

    public static void logd(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(72524);
        if (FacebookSdk.isDebugEnabled()) {
            isNullOrEmpty(str);
        }
        AppMethodBeat.m2505o(72524);
    }

    public static <T> boolean areObjectsEqual(T t, T t2) {
        AppMethodBeat.m2504i(72525);
        if (t != null) {
            boolean equals = t.equals(t2);
            AppMethodBeat.m2505o(72525);
            return equals;
        } else if (t2 == null) {
            AppMethodBeat.m2505o(72525);
            return true;
        } else {
            AppMethodBeat.m2505o(72525);
            return false;
        }
    }

    public static boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.m2504i(72526);
        if (jSONObject == null || jSONObject2 == null || !jSONObject.has("id") || !jSONObject2.has("id")) {
            AppMethodBeat.m2505o(72526);
            return false;
        } else if (jSONObject.equals(jSONObject2)) {
            AppMethodBeat.m2505o(72526);
            return true;
        } else {
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject2.optString("id");
            if (optString == null || optString2 == null) {
                AppMethodBeat.m2505o(72526);
                return false;
            }
            boolean equals = optString.equals(optString2);
            AppMethodBeat.m2505o(72526);
            return equals;
        }
    }

    public static String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(72527);
        String optString;
        if (jSONObject != null) {
            optString = jSONObject.optString(str, "");
            AppMethodBeat.m2505o(72527);
            return optString;
        }
        optString = "";
        AppMethodBeat.m2505o(72527);
        return optString;
    }

    public static JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(72528);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            AppMethodBeat.m2505o(72528);
            return optJSONObject;
        }
        AppMethodBeat.m2505o(72528);
        return null;
    }

    public static JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(72529);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            AppMethodBeat.m2505o(72529);
            return optJSONArray;
        }
        AppMethodBeat.m2505o(72529);
        return null;
    }

    public static void clearCaches(Context context) {
        AppMethodBeat.m2504i(72530);
        ImageDownloader.clearCache(context);
        AppMethodBeat.m2505o(72530);
    }

    public static void deleteDirectory(File file) {
        AppMethodBeat.m2504i(72531);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleteDirectory : listFiles) {
                        deleteDirectory(deleteDirectory);
                    }
                }
            }
            file.delete();
            AppMethodBeat.m2505o(72531);
            return;
        }
        AppMethodBeat.m2505o(72531);
    }

    public static <T> List<T> asListNoNulls(T... tArr) {
        AppMethodBeat.m2504i(72532);
        ArrayList arrayList = new ArrayList();
        for (Object obj : tArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        AppMethodBeat.m2505o(72532);
        return arrayList;
    }

    public static List<String> jsonArrayToStringList(JSONArray jSONArray) {
        AppMethodBeat.m2504i(72533);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        AppMethodBeat.m2505o(72533);
        return arrayList;
    }

    public static Set<String> jsonArrayToSet(JSONArray jSONArray) {
        AppMethodBeat.m2504i(72534);
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        AppMethodBeat.m2505o(72534);
        return hashSet;
    }

    public static void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(72535);
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAttributionId() == null)) {
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
            jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidInstallerPackage() == null)) {
            jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
        }
        jSONObject.put("anon_id", str);
        String str2 = "application_tracking_enabled";
        if (z) {
            z2 = false;
        }
        jSONObject.put(str2, z2);
        AppMethodBeat.m2505o(72535);
    }

    public static void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) {
        Locale locale;
        int i;
        int i2;
        double d;
        AppMethodBeat.m2504i(72536);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i3 = -1;
        Object obj = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i3 = packageInfo.versionCode;
            obj = packageInfo.versionName;
        } catch (NameNotFoundException e) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i3);
        jSONArray.put(obj);
        jSONArray.put(VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception e2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                try {
                    i2 = displayMetrics.heightPixels;
                } catch (Exception e3) {
                    i2 = 0;
                    d = 0.0d;
                    jSONArray.put(i);
                    jSONArray.put(i2);
                    jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
                    jSONArray.put(refreshBestGuessNumberOfCPUCores());
                    jSONArray.put(totalExternalStorageGB);
                    jSONArray.put(availableExternalStorageGB);
                    jSONArray.put(deviceTimeZoneName);
                    jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                    AppMethodBeat.m2505o(72536);
                }
                try {
                    d = (double) displayMetrics.density;
                } catch (Exception e4) {
                    d = 0.0d;
                    jSONArray.put(i);
                    jSONArray.put(i2);
                    jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
                    jSONArray.put(refreshBestGuessNumberOfCPUCores());
                    jSONArray.put(totalExternalStorageGB);
                    jSONArray.put(availableExternalStorageGB);
                    jSONArray.put(deviceTimeZoneName);
                    jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                    AppMethodBeat.m2505o(72536);
                }
            }
            d = 0.0d;
            i2 = 0;
            i = 0;
        } catch (Exception e5) {
            i2 = 0;
            i = 0;
            d = 0.0d;
            jSONArray.put(i);
            jSONArray.put(i2);
            jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
            jSONArray.put(refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            jSONObject.put(Constants.EXTINFO, jSONArray.toString());
            AppMethodBeat.m2505o(72536);
        }
        jSONArray.put(i);
        jSONArray.put(i2);
        jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
        jSONArray.put(refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        jSONObject.put(Constants.EXTINFO, jSONArray.toString());
        AppMethodBeat.m2505o(72536);
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.m2504i(72537);
        try {
            Method method = cls.getMethod(str, clsArr);
            AppMethodBeat.m2505o(72537);
            return method;
        } catch (NoSuchMethodException e) {
            AppMethodBeat.m2505o(72537);
            return null;
        }
    }

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        AppMethodBeat.m2504i(72538);
        try {
            Method methodQuietly = getMethodQuietly(Class.forName(str), str2, (Class[]) clsArr);
            AppMethodBeat.m2505o(72538);
            return methodQuietly;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.m2505o(72538);
            return null;
        }
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Object obj2 = null;
        AppMethodBeat.m2504i(72539);
        try {
            obj2 = method.invoke(obj, objArr);
            AppMethodBeat.m2505o(72539);
        } catch (IllegalAccessException e) {
            AppMethodBeat.m2505o(72539);
        } catch (InvocationTargetException e2) {
            AppMethodBeat.m2505o(72539);
        }
        return obj2;
    }

    public static String getActivityName(Context context) {
        AppMethodBeat.m2504i(72540);
        String str;
        if (context == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(72540);
            return str;
        } else if (context == context.getApplicationContext()) {
            str = "unknown";
            AppMethodBeat.m2505o(72540);
            return str;
        } else {
            str = context.getClass().getSimpleName();
            AppMethodBeat.m2505o(72540);
            return str;
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        AppMethodBeat.m2504i(72541);
        if (list == null) {
            AppMethodBeat.m2505o(72541);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (predicate.apply(next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(72541);
            return null;
        }
        AppMethodBeat.m2505o(72541);
        return arrayList;
    }

    public static <T, K> List<K> map(List<T> list, Mapper<T, K> mapper) {
        AppMethodBeat.m2504i(72542);
        if (list == null) {
            AppMethodBeat.m2505o(72542);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T apply : list) {
            Object apply2 = mapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(72542);
            return null;
        }
        AppMethodBeat.m2505o(72542);
        return arrayList;
    }

    public static String getUriString(Uri uri) {
        AppMethodBeat.m2504i(72543);
        if (uri == null) {
            AppMethodBeat.m2505o(72543);
            return null;
        }
        String uri2 = uri.toString();
        AppMethodBeat.m2505o(72543);
        return uri2;
    }

    public static boolean isWebUri(Uri uri) {
        AppMethodBeat.m2504i(72544);
        if (uri == null || !("http".equalsIgnoreCase(uri.getScheme()) || URL_SCHEME.equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()))) {
            AppMethodBeat.m2505o(72544);
            return false;
        }
        AppMethodBeat.m2505o(72544);
        return true;
    }

    public static boolean isContentUri(Uri uri) {
        AppMethodBeat.m2504i(72545);
        if (uri == null || !C8741b.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            AppMethodBeat.m2505o(72545);
            return false;
        }
        AppMethodBeat.m2505o(72545);
        return true;
    }

    public static boolean isFileUri(Uri uri) {
        AppMethodBeat.m2504i(72546);
        if (uri == null || !"file".equalsIgnoreCase(uri.getScheme())) {
            AppMethodBeat.m2505o(72546);
            return false;
        }
        AppMethodBeat.m2505o(72546);
        return true;
    }

    public static long getContentSize(Uri uri) {
        Cursor query;
        Throwable th;
        AppMethodBeat.m2504i(72547);
        try {
            query = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            try {
                int columnIndex = query.getColumnIndex("_size");
                query.moveToFirst();
                long j = query.getLong(columnIndex);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(72547);
                return j;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
        }
        if (query != null) {
            query.close();
        }
        AppMethodBeat.m2505o(72547);
        throw th;
    }

    public static Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        AppMethodBeat.m2504i(72548);
        if (bundle == null) {
            AppMethodBeat.m2505o(72548);
            return null;
        }
        long longValue;
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            longValue = ((Long) obj).longValue();
        } else if (obj instanceof String) {
            try {
                longValue = Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(72548);
                return null;
            }
        } else {
            AppMethodBeat.m2505o(72548);
            return null;
        }
        Date date2;
        if (longValue == 0) {
            date2 = new Date(Long.MAX_VALUE);
            AppMethodBeat.m2505o(72548);
            return date2;
        }
        date2 = new Date((longValue * 1000) + date.getTime());
        AppMethodBeat.m2505o(72548);
        return date2;
    }

    public static void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        AppMethodBeat.m2504i(72549);
        if (map == null) {
            parcel.writeInt(-1);
            AppMethodBeat.m2505o(72549);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
        AppMethodBeat.m2505o(72549);
    }

    public static Map<String, String> readStringMapFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(72550);
        int readInt = parcel.readInt();
        if (readInt < 0) {
            AppMethodBeat.m2505o(72550);
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        AppMethodBeat.m2505o(72550);
        return hashMap;
    }

    public static boolean isCurrentAccessToken(AccessToken accessToken) {
        AppMethodBeat.m2504i(72551);
        if (accessToken == null || !accessToken.equals(AccessToken.getCurrentAccessToken())) {
            AppMethodBeat.m2505o(72551);
            return false;
        }
        AppMethodBeat.m2505o(72551);
        return true;
    }

    public static void getGraphMeRequestWithCacheAsync(final String str, final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        AppMethodBeat.m2504i(72552);
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            AppMethodBeat.m2505o(72552);
            return;
        }
        C08091 c08091 = new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.m2504i(72490);
                if (graphResponse.getError() != null) {
                    graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
                    AppMethodBeat.m2505o(72490);
                    return;
                }
                ProfileInformationCache.putProfileInformation(str, graphResponse.getJSONObject());
                graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJSONObject());
                AppMethodBeat.m2505o(72490);
            }
        };
        GraphRequest graphMeRequestWithCache = getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(c08091);
        graphMeRequestWithCache.executeAsync();
        AppMethodBeat.m2505o(72552);
    }

    public static JSONObject awaitGetGraphMeRequestWithCache(String str) {
        AppMethodBeat.m2504i(72553);
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            AppMethodBeat.m2505o(72553);
            return profileInformation;
        }
        GraphResponse executeAndWait = getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            AppMethodBeat.m2505o(72553);
            return null;
        }
        profileInformation = executeAndWait.getJSONObject();
        AppMethodBeat.m2505o(72553);
        return profileInformation;
    }

    private static GraphRequest getGraphMeRequestWithCache(String str) {
        AppMethodBeat.m2504i(72554);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        GraphRequest graphRequest = new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
        AppMethodBeat.m2505o(72554);
        return graphRequest;
    }

    private static int refreshBestGuessNumberOfCPUCores() {
        AppMethodBeat.m2504i(72555);
        int i;
        if (numCPUCores > 0) {
            i = numCPUCores;
            AppMethodBeat.m2505o(72555);
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C08102());
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception e) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        i = numCPUCores;
        AppMethodBeat.m2505o(72555);
        return i;
    }

    private static void refreshPeriodicExtendedDeviceInfo(Context context) {
        AppMethodBeat.m2504i(72556);
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
        AppMethodBeat.m2505o(72556);
    }

    private static void refreshTimezone() {
        AppMethodBeat.m2504i(72557);
        try {
            TimeZone timeZone = TimeZone.getDefault();
            deviceTimezoneAbbreviation = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            deviceTimeZoneName = timeZone.getID();
            AppMethodBeat.m2505o(72557);
        } catch (AssertionError e) {
            AppMethodBeat.m2505o(72557);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(72557);
        }
    }

    private static void refreshCarrierName(Context context) {
        AppMethodBeat.m2504i(72558);
        if (carrierName.equals(noCarrierConstant)) {
            try {
                carrierName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
                AppMethodBeat.m2505o(72558);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(72558);
    }

    private static boolean externalStorageExists() {
        AppMethodBeat.m2504i(72559);
        boolean equals = "mounted".equals(Environment.getExternalStorageState());
        AppMethodBeat.m2505o(72559);
        return equals;
    }

    private static void refreshAvailableExternalStorage() {
        AppMethodBeat.m2504i(72560);
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
            AppMethodBeat.m2505o(72560);
        } catch (Exception e) {
            AppMethodBeat.m2505o(72560);
        }
    }

    private static void refreshTotalExternalStorage() {
        AppMethodBeat.m2504i(72561);
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
            AppMethodBeat.m2505o(72561);
        } catch (Exception e) {
            AppMethodBeat.m2505o(72561);
        }
    }

    private static long convertBytesToGB(double d) {
        AppMethodBeat.m2504i(72562);
        long round = Math.round(d / 1.073741824E9d);
        AppMethodBeat.m2505o(72562);
        return round;
    }

    public static PermissionsPair handlePermissionResponse(JSONObject jSONObject) {
        AppMethodBeat.m2504i(72563);
        JSONArray jSONArray = jSONObject.getJSONObject(NativeProtocol.RESULT_ARGS_PERMISSIONS).getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("permission");
            if (!(optString == null || optString.equals("installed"))) {
                String optString2 = optJSONObject.optString("status");
                if (optString2 != null) {
                    if (optString2.equals("granted")) {
                        arrayList.add(optString);
                    } else if (optString2.equals("declined")) {
                        arrayList2.add(optString);
                    }
                }
            }
        }
        PermissionsPair permissionsPair = new PermissionsPair(arrayList, arrayList2);
        AppMethodBeat.m2505o(72563);
        return permissionsPair;
    }

    public static String generateRandomString(int i) {
        AppMethodBeat.m2504i(72564);
        String bigInteger = new BigInteger(i * 5, new Random()).toString(32);
        AppMethodBeat.m2505o(72564);
        return bigInteger;
    }

    public static boolean mustFixWindowParamsForAutofill(Context context) {
        AppMethodBeat.m2504i(72565);
        boolean isAutofillAvailable = isAutofillAvailable(context);
        AppMethodBeat.m2505o(72565);
        return isAutofillAvailable;
    }

    public static boolean isAutofillAvailable(Context context) {
        AppMethodBeat.m2504i(72566);
        if (VERSION.SDK_INT < 26) {
            AppMethodBeat.m2505o(72566);
            return false;
        }
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            AppMethodBeat.m2505o(72566);
            return true;
        }
        AppMethodBeat.m2505o(72566);
        return false;
    }

    public static boolean isChromeOS(Context context) {
        AppMethodBeat.m2504i(72567);
        if (VERSION.SDK_INT >= 27) {
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
            AppMethodBeat.m2505o(72567);
            return hasSystemFeature;
        } else if (Build.DEVICE == null || !Build.DEVICE.matches(ARC_DEVICE_PATTERN)) {
            AppMethodBeat.m2505o(72567);
            return false;
        } else {
            AppMethodBeat.m2505o(72567);
            return true;
        }
    }

    public static Locale getCurrentLocale() {
        Locale locale;
        AppMethodBeat.m2504i(72568);
        try {
            locale = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception e) {
            locale = Locale.getDefault();
        }
        AppMethodBeat.m2505o(72568);
        return locale;
    }
}
