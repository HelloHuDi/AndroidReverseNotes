package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzwn {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbmh = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbmi = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbmj = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbmk = new AtomicBoolean();
    private static HashMap<String, String> zzbml;
    private static final HashMap<String, Boolean> zzbmm = new HashMap();
    private static final HashMap<String, Integer> zzbmn = new HashMap();
    private static final HashMap<String, Long> zzbmo = new HashMap();
    private static final HashMap<String, Float> zzbmp = new HashMap();
    private static Object zzbmq;
    private static boolean zzbmr;
    private static String[] zzbms = new String[0];

    static {
        AppMethodBeat.m2504i(69751);
        AppMethodBeat.m2505o(69751);
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        T t2;
        AppMethodBeat.m2504i(69750);
        synchronized (zzwn.class) {
            try {
                if (hashMap.containsKey(str)) {
                    t2 = hashMap.get(str);
                    if (t2 == null) {
                        t2 = t;
                    }
                } else {
                    AppMethodBeat.m2505o(69750);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69750);
            }
        }
        return t2;
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(69745);
        synchronized (zzwn.class) {
            try {
                zza(contentResolver);
                Object obj = zzbmq;
                String str4;
                if (zzbml.containsKey(str)) {
                    str4 = (String) zzbml.get(str);
                    if (str4 != null) {
                        str3 = str4;
                    }
                } else {
                    String[] strArr = zzbms;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        if (str.startsWith(strArr[i])) {
                            if (!zzbmr || zzbml.isEmpty()) {
                                zzbml.putAll(zza(contentResolver, zzbms));
                                zzbmr = true;
                                if (zzbml.containsKey(str)) {
                                    str4 = (String) zzbml.get(str);
                                    if (str4 != null) {
                                        str3 = str4;
                                    }
                                    AppMethodBeat.m2505o(69745);
                                }
                            }
                            AppMethodBeat.m2505o(69745);
                        } else {
                            i++;
                        }
                    }
                    Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                str4 = query.getString(1);
                                if (str4 != null && str4.equals(null)) {
                                    str4 = null;
                                }
                                zza(obj, str, str4);
                                if (str4 != null) {
                                    str3 = str4;
                                }
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.m2505o(69745);
                            }
                        } catch (Throwable th) {
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(69745);
                        }
                    }
                    zza(obj, str, null);
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(69745);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69745);
            }
        }
        return str3;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        AppMethodBeat.m2504i(69748);
        Cursor query = contentResolver.query(zzbmh, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query == null) {
            AppMethodBeat.m2505o(69748);
        } else {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                    AppMethodBeat.m2505o(69748);
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        AppMethodBeat.m2504i(69744);
        if (zzbml == null) {
            zzbmk.set(false);
            zzbml = new HashMap();
            zzbmq = new Object();
            zzbmr = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzwo(null));
            AppMethodBeat.m2505o(69744);
            return;
        }
        if (zzbmk.getAndSet(false)) {
            zzbml.clear();
            zzbmm.clear();
            zzbmn.clear();
            zzbmo.clear();
            zzbmp.clear();
            zzbmq = new Object();
            zzbmr = false;
        }
        AppMethodBeat.m2505o(69744);
    }

    private static void zza(Object obj, String str, String str2) {
        AppMethodBeat.m2504i(69746);
        synchronized (zzwn.class) {
            try {
                if (obj == zzbmq) {
                    zzbml.put(str, str2);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69746);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        AppMethodBeat.m2504i(69747);
        Object zzb = zzb(contentResolver);
        Object obj = (Boolean) zza(zzbmm, str, Boolean.valueOf(z));
        if (obj != null) {
            z = obj.booleanValue();
            AppMethodBeat.m2505o(69747);
            return z;
        }
        String zza = zza(contentResolver, str, null);
        if (!(zza == null || zza.equals(""))) {
            if (zzbmi.matcher(zza).matches()) {
                z = true;
                obj = Boolean.TRUE;
            } else if (zzbmj.matcher(zza).matches()) {
                z = false;
                obj = Boolean.FALSE;
            } else {
                new StringBuilder("attempt to read gservices key ").append(str).append(" (value \"").append(zza).append("\") as boolean");
            }
        }
        HashMap hashMap = zzbmm;
        synchronized (zzwn.class) {
            try {
                if (zzb == zzbmq) {
                    hashMap.put(str, obj);
                    zzbml.remove(str);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69747);
            }
        }
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        AppMethodBeat.m2504i(69749);
        synchronized (zzwn.class) {
            try {
                zza(contentResolver);
                obj = zzbmq;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69749);
            }
        }
        return obj;
    }
}
