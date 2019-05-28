package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzi {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static HashMap<String, String> zzagq;
    private static final Uri zzagv = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern zzagw = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzagx = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzagy = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzagz = new HashMap();
    private static final HashMap<String, Integer> zzaha = new HashMap();
    private static final HashMap<String, Long> zzahb = new HashMap();
    private static final HashMap<String, Float> zzahc = new HashMap();
    private static Object zzahd;
    private static boolean zzahe;
    private static String[] zzahf = new String[0];

    static {
        AppMethodBeat.m2504i(90491);
        AppMethodBeat.m2505o(90491);
    }

    public static int getInt(ContentResolver contentResolver, String str, int i) {
        AppMethodBeat.m2504i(90484);
        Object zzb = zzb(contentResolver);
        Object obj = (Integer) zza(zzaha, str, Integer.valueOf(i));
        if (obj != null) {
            i = obj.intValue();
            AppMethodBeat.m2505o(90484);
            return i;
        }
        String zza = zza(contentResolver, str, null);
        if (zza != null) {
            try {
                int parseInt = Integer.parseInt(zza);
                obj = Integer.valueOf(parseInt);
                i = parseInt;
            } catch (NumberFormatException e) {
            }
        }
        zza(zzb, zzaha, str, obj);
        AppMethodBeat.m2505o(90484);
        return i;
    }

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        AppMethodBeat.m2504i(90485);
        Object zzb = zzb(contentResolver);
        Object obj = (Long) zza(zzahb, str, Long.valueOf(j));
        if (obj != null) {
            j = obj.longValue();
            AppMethodBeat.m2505o(90485);
            return j;
        }
        String zza = zza(contentResolver, str, null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                obj = Long.valueOf(parseLong);
                j = parseLong;
            } catch (NumberFormatException e) {
            }
        }
        zza(zzb, zzahb, str, obj);
        AppMethodBeat.m2505o(90485);
        return j;
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        T t2;
        AppMethodBeat.m2504i(90489);
        synchronized (zzi.class) {
            try {
                if (hashMap.containsKey(str)) {
                    t2 = hashMap.get(str);
                    if (t2 == null) {
                        t2 = t;
                    }
                } else {
                    AppMethodBeat.m2505o(90489);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(90489);
            }
        }
        return t2;
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        AppMethodBeat.m2504i(90482);
        synchronized (zzi.class) {
            try {
                zza(contentResolver);
                Object obj = zzahd;
                String str3;
                if (zzagq.containsKey(str)) {
                    str3 = (String) zzagq.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } else {
                    String[] strArr = zzahf;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        if (str.startsWith(strArr[i])) {
                            if (!zzahe || zzagq.isEmpty()) {
                                zzagq.putAll(zza(contentResolver, zzahf));
                                zzahe = true;
                                if (zzagq.containsKey(str)) {
                                    str3 = (String) zzagq.get(str);
                                    if (str3 != null) {
                                        str2 = str3;
                                    }
                                    AppMethodBeat.m2505o(90482);
                                }
                            }
                            AppMethodBeat.m2505o(90482);
                        } else {
                            i++;
                        }
                    }
                    Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                str3 = query.getString(1);
                                if (str3 != null && str3.equals(str2)) {
                                    str3 = str2;
                                }
                                zza(obj, str, str3);
                                if (str3 != null) {
                                    str2 = str3;
                                }
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.m2505o(90482);
                            }
                        } catch (Throwable th) {
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(90482);
                        }
                    }
                    zza(obj, str, null);
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(90482);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(90482);
            }
        }
        return str2;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        AppMethodBeat.m2504i(90487);
        Cursor query = contentResolver.query(zzagv, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query == null) {
            AppMethodBeat.m2505o(90487);
        } else {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                    AppMethodBeat.m2505o(90487);
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        AppMethodBeat.m2504i(90481);
        if (zzagq == null) {
            zzagy.set(false);
            zzagq = new HashMap();
            zzahd = new Object();
            zzahe = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzj(null));
            AppMethodBeat.m2505o(90481);
            return;
        }
        if (zzagy.getAndSet(false)) {
            zzagq.clear();
            zzagz.clear();
            zzaha.clear();
            zzahb.clear();
            zzahc.clear();
            zzahd = new Object();
            zzahe = false;
        }
        AppMethodBeat.m2505o(90481);
    }

    private static void zza(Object obj, String str, String str2) {
        AppMethodBeat.m2504i(90483);
        synchronized (zzi.class) {
            try {
                if (obj == zzahd) {
                    zzagq.put(str, str2);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(90483);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        AppMethodBeat.m2504i(90490);
        synchronized (zzi.class) {
            try {
                if (obj == zzahd) {
                    hashMap.put(str, t);
                    zzagq.remove(str);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(90490);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        AppMethodBeat.m2504i(90486);
        Object zzb = zzb(contentResolver);
        Object obj = (Boolean) zza(zzagz, str, Boolean.valueOf(z));
        if (obj != null) {
            z = obj.booleanValue();
            AppMethodBeat.m2505o(90486);
            return z;
        }
        String zza = zza(contentResolver, str, null);
        if (!(zza == null || zza.equals(""))) {
            if (zzagw.matcher(zza).matches()) {
                z = true;
                obj = Boolean.TRUE;
            } else if (zzagx.matcher(zza).matches()) {
                z = false;
                obj = Boolean.FALSE;
            } else {
                new StringBuilder("attempt to read gservices key ").append(str).append(" (value \"").append(zza).append("\") as boolean");
            }
        }
        zza(zzb, zzagz, str, obj);
        AppMethodBeat.m2505o(90486);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        AppMethodBeat.m2504i(90488);
        synchronized (zzi.class) {
            try {
                zza(contentResolver);
                obj = zzahd;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(90488);
            }
        }
        return obj;
    }
}
