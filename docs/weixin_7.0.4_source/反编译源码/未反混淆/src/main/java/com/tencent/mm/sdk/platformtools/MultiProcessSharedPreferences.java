package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    private static String AUTHORITY;
    private static volatile Uri AUTHORITY_URI;
    private BroadcastReceiver jIA;
    private Context mContext;
    private int mMode;
    private String mName;
    private List<SoftReference<OnSharedPreferenceChangeListener>> mq;
    private boolean xAp;
    private UriMatcher xAq;
    private Map<String, Integer> xAr;

    static final class a extends MatrixCursor {
        private Bundle mBundle;

        public a(Bundle bundle) {
            super(new String[0], 0);
            AppMethodBeat.i(93543);
            this.mBundle = bundle;
            AppMethodBeat.o(93543);
        }

        public final Bundle getExtras() {
            return this.mBundle;
        }

        public final Bundle respond(Bundle bundle) {
            this.mBundle = bundle;
            return this.mBundle;
        }
    }

    public final class b implements Editor {
        private final Map<String, Object> xAc = new HashMap();
        private boolean xAd = false;

        public b() {
            AppMethodBeat.i(93544);
            AppMethodBeat.o(93544);
        }

        public final Editor putString(String str, String str2) {
            AppMethodBeat.i(93545);
            synchronized (this) {
                try {
                    this.xAc.put(str, str2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93545);
                }
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.i(93546);
            synchronized (this) {
                try {
                    this.xAc.put(str, set == null ? null : new HashSet(set));
                } finally {
                    AppMethodBeat.o(93546);
                }
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            AppMethodBeat.i(93547);
            synchronized (this) {
                try {
                    this.xAc.put(str, Integer.valueOf(i));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93547);
                }
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            AppMethodBeat.i(93548);
            synchronized (this) {
                try {
                    this.xAc.put(str, Long.valueOf(j));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93548);
                }
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            AppMethodBeat.i(93549);
            synchronized (this) {
                try {
                    this.xAc.put(str, Float.valueOf(f));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93549);
                }
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(93550);
            synchronized (this) {
                try {
                    this.xAc.put(str, Boolean.valueOf(z));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93550);
                }
            }
            return this;
        }

        public final Editor remove(String str) {
            AppMethodBeat.i(93551);
            synchronized (this) {
                try {
                    this.xAc.put(str, null);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93551);
                }
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.xAd = true;
            }
            return this;
        }

        public final void apply() {
            AppMethodBeat.i(93552);
            setValue("apply");
            AppMethodBeat.o(93552);
        }

        public final boolean commit() {
            AppMethodBeat.i(93553);
            boolean value = setValue("commit");
            AppMethodBeat.o(93553);
            return value;
        }

        private boolean setValue(String str) {
            int i = 0;
            int i2 = 93554;
            AppMethodBeat.i(93554);
            if (MultiProcessSharedPreferences.this.xAp) {
                AppMethodBeat.o(93554);
                return false;
            }
            boolean z;
            synchronized (MultiProcessSharedPreferences.this) {
                try {
                    MultiProcessSharedPreferences.a(MultiProcessSharedPreferences.this, MultiProcessSharedPreferences.this.mContext);
                    String[] strArr = new String[]{String.valueOf(MultiProcessSharedPreferences.this.mMode), String.valueOf(this.xAd)};
                    synchronized (this) {
                        z = MultiProcessSharedPreferences.this.mContext.getContentResolver().update(Uri.withAppendedPath(Uri.withAppendedPath(MultiProcessSharedPreferences.AUTHORITY_URI, MultiProcessSharedPreferences.this.mName), str), c.r((HashMap) this.xAc), null, strArr) > 0;
                    }
                } catch (Throwable th) {
                    while (true) {
                        z = th;
                    }
                    i = 93554;
                } finally {
                    AppMethodBeat.o(
/*
Method generation error in method: com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.b.setValue(java.lang.String):boolean, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007c: INVOKE  (wrap: int
  ?: MERGE  (r8_1 int) = (r8_0 'i2' int), (r1_3 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.b.setValue(java.lang.String):boolean, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:234)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r8_1 int) = (r8_0 'i2' int), (r1_3 'i' int) in method: com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.b.setValue(java.lang.String):boolean, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 34 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 39 more

*/
    }

    static class c {
        public static ContentValues r(HashMap<String, Object> hashMap) {
            RuntimeException runtimeException;
            AppMethodBeat.i(93555);
            try {
                Constructor declaredConstructor = ContentValues.class.getDeclaredConstructor(new Class[]{HashMap.class});
                declaredConstructor.setAccessible(true);
                ContentValues contentValues = (ContentValues) declaredConstructor.newInstance(new Object[]{hashMap});
                AppMethodBeat.o(93555);
                return contentValues;
            } catch (IllegalArgumentException e) {
                runtimeException = new RuntimeException(e);
                AppMethodBeat.o(93555);
                throw runtimeException;
            } catch (IllegalAccessException e2) {
                runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(93555);
                throw runtimeException;
            } catch (InvocationTargetException e3) {
                runtimeException = new RuntimeException(e3);
                AppMethodBeat.o(93555);
                throw runtimeException;
            } catch (NoSuchMethodException e4) {
                runtimeException = new RuntimeException(e4);
                AppMethodBeat.o(93555);
                throw runtimeException;
            } catch (InstantiationException e5) {
                runtimeException = new RuntimeException(e5);
                AppMethodBeat.o(93555);
                throw runtimeException;
            }
        }

        public static Editor a(Editor editor, String str, Set<String> set) {
            RuntimeException runtimeException;
            AppMethodBeat.i(93556);
            try {
                Editor editor2 = (Editor) editor.getClass().getDeclaredMethod("putStringSet", new Class[]{String.class, Set.class}).invoke(editor, new Object[]{str, set});
                AppMethodBeat.o(93556);
                return editor2;
            } catch (IllegalArgumentException e) {
                runtimeException = new RuntimeException(e);
                AppMethodBeat.o(93556);
                throw runtimeException;
            } catch (IllegalAccessException e2) {
                runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(93556);
                throw runtimeException;
            } catch (InvocationTargetException e3) {
                runtimeException = new RuntimeException(e3);
                AppMethodBeat.o(93556);
                throw runtimeException;
            } catch (NoSuchMethodException e4) {
                runtimeException = new RuntimeException(e4);
                AppMethodBeat.o(93556);
                throw runtimeException;
            }
        }
    }

    static /* synthetic */ void a(MultiProcessSharedPreferences multiProcessSharedPreferences, Context context) {
        AppMethodBeat.i(93584);
        multiProcessSharedPreferences.gy(context);
        AppMethodBeat.o(93584);
    }

    private void gy(Context context) {
        AppMethodBeat.i(93557);
        if (AUTHORITY_URI == null) {
            String str = null;
            Uri uri = AUTHORITY_URI;
            synchronized (this) {
                if (uri == null) {
                    try {
                        str = gz(context);
                        uri = Uri.parse("content://".concat(String.valueOf(str)));
                    } catch (Throwable th) {
                        AppMethodBeat.o(93557);
                    }
                }
                if (str == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("'AUTHORITY' initialize failed.");
                    AppMethodBeat.o(93557);
                    throw illegalArgumentException;
                }
            }
            AUTHORITY = str;
            AUTHORITY_URI = uri;
        }
        AppMethodBeat.o(93557);
    }

    private static String gz(Context context) {
        PackageInfo packageInfo;
        AppMethodBeat.i(93558);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (!(packageInfo == null || packageInfo.providers == null)) {
            for (ProviderInfo providerInfo : packageInfo.providers) {
                if (providerInfo.name.equals(MultiProcessSharedPreferences.class.getName())) {
                    String str = providerInfo.authority;
                    AppMethodBeat.o(93558);
                    return str;
                }
            }
        }
        AppMethodBeat.o(93558);
        return null;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        AppMethodBeat.i(93559);
        as amF = as.amF(str);
        as.a(new MultiProcessSharedPreferences(context, str, i), amF);
        AppMethodBeat.o(93559);
        return amF;
    }

    private MultiProcessSharedPreferences(Context context, String str, int i) {
        AppMethodBeat.i(93560);
        this.mContext = context;
        this.mName = str;
        this.mMode = i;
        this.xAp = context.getPackageManager().isSafeMode();
        AppMethodBeat.o(93560);
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.i(93561);
        Map map = (Map) c("getAll", null, null);
        AppMethodBeat.o(93561);
        return map;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(93562);
        String str3 = (String) c("getString", str, str2);
        if (str3 != null) {
            AppMethodBeat.o(93562);
            return str3;
        }
        AppMethodBeat.o(93562);
        return str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        AppMethodBeat.i(93563);
        synchronized (this) {
            try {
                set2 = (Set) c("getString", str, set);
                if (set2 == null) {
                    set2 = set;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93563);
            }
        }
        return set2;
    }

    public int getInt(String str, int i) {
        AppMethodBeat.i(93564);
        Integer num = (Integer) c("getInt", str, Integer.valueOf(i));
        if (num != null) {
            i = num.intValue();
            AppMethodBeat.o(93564);
            return i;
        }
        AppMethodBeat.o(93564);
        return i;
    }

    public long getLong(String str, long j) {
        AppMethodBeat.i(93565);
        Long l = (Long) c("getLong", str, Long.valueOf(j));
        if (l != null) {
            j = l.longValue();
            AppMethodBeat.o(93565);
            return j;
        }
        AppMethodBeat.o(93565);
        return j;
    }

    public float getFloat(String str, float f) {
        AppMethodBeat.i(93566);
        Float f2 = (Float) c("getFloat", str, Float.valueOf(f));
        if (f2 != null) {
            f = f2.floatValue();
            AppMethodBeat.o(93566);
            return f;
        }
        AppMethodBeat.o(93566);
        return f;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(93567);
        Boolean bool = (Boolean) c("getBoolean", str, Boolean.valueOf(z));
        if (bool != null) {
            z = bool.booleanValue();
            AppMethodBeat.o(93567);
            return z;
        }
        AppMethodBeat.o(93567);
        return z;
    }

    public boolean contains(String str) {
        AppMethodBeat.i(93568);
        Boolean bool = (Boolean) c("contains", str, null);
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(93568);
            return booleanValue;
        }
        AppMethodBeat.o(93568);
        return false;
    }

    public Editor edit() {
        AppMethodBeat.i(93569);
        b bVar = new b();
        AppMethodBeat.o(93569);
        return bVar;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(93570);
        synchronized (this) {
            try {
                if (this.mq == null) {
                    this.mq = new ArrayList();
                }
                Boolean bool = (Boolean) c("registerOnSharedPreferenceChangeListener", null, Boolean.FALSE);
                if (bool != null && bool.booleanValue()) {
                    this.mq.add(new SoftReference(onSharedPreferenceChangeListener));
                    if (this.jIA == null) {
                        this.jIA = new BroadcastReceiver() {
                            public final void onReceive(Context context, Intent intent) {
                                AppMethodBeat.i(93542);
                                List list = (List) intent.getSerializableExtra("value");
                                if (MultiProcessSharedPreferences.this.mName.equals(intent.getStringExtra("name")) && list != null) {
                                    List b;
                                    synchronized (MultiProcessSharedPreferences.this) {
                                        try {
                                            b = MultiProcessSharedPreferences.this.mq;
                                        } catch (Throwable th) {
                                            while (true) {
                                                AppMethodBeat.o(93542);
                                            }
                                        }
                                    }
                                    ArrayList<SoftReference> arrayList = new ArrayList(b);
                                    for (int size = list.size() - 1; size >= 0; size--) {
                                        String str = (String) list.get(size);
                                        for (SoftReference softReference : arrayList) {
                                            OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (OnSharedPreferenceChangeListener) softReference.get();
                                            if (onSharedPreferenceChangeListener != null) {
                                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(MultiProcessSharedPreferences.this, str);
                                            }
                                        }
                                    }
                                }
                                AppMethodBeat.o(93542);
                            }
                        };
                        this.mContext.registerReceiver(this.jIA, new IntentFilter(amL(this.mName)));
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93570);
            }
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(93571);
        synchronized (this) {
            try {
                c("unregisterOnSharedPreferenceChangeListener", null, Boolean.FALSE);
                if (this.mq != null) {
                    ArrayList<SoftReference> arrayList = new ArrayList();
                    for (SoftReference softReference : this.mq) {
                        OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = (OnSharedPreferenceChangeListener) softReference.get();
                        if (onSharedPreferenceChangeListener2 != null && onSharedPreferenceChangeListener2.equals(onSharedPreferenceChangeListener)) {
                            arrayList.add(softReference);
                        }
                    }
                    for (SoftReference softReference2 : arrayList) {
                        this.mq.remove(softReference2);
                    }
                    if (this.mq.isEmpty() && this.jIA != null) {
                        this.mContext.unregisterReceiver(this.jIA);
                        this.jIA = null;
                        this.mq = null;
                    }
                }
            } finally {
                AppMethodBeat.o(93571);
            }
        }
    }

    private Object c(String str, String str2, Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(93572);
        if (this.xAp) {
            AppMethodBeat.o(93572);
            return null;
        }
        gy(this.mContext);
        Uri withAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), str);
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(this.mMode);
        strArr[1] = str2;
        strArr[2] = obj == null ? null : String.valueOf(obj);
        Cursor query = this.mContext.getContentResolver().query(withAppendedPath, null, null, strArr, null);
        if (query != null) {
            try {
                Bundle extras = query.getExtras();
                if (extras != null) {
                    obj2 = extras.get("value");
                    extras.clear();
                }
            } catch (Exception e) {
            }
            query.close();
        }
        if (obj2 != null) {
            AppMethodBeat.o(93572);
            return obj2;
        }
        AppMethodBeat.o(93572);
        return obj;
    }

    private static String amL(String str) {
        AppMethodBeat.i(93573);
        String format = String.format("%1$s_%2$s", new Object[]{MultiProcessSharedPreferences.class.getName(), str});
        AppMethodBeat.o(93573);
        return format;
    }

    public boolean onCreate() {
        AppMethodBeat.i(93574);
        gy(getContext());
        this.xAq = new UriMatcher(-1);
        this.xAq.addURI(AUTHORITY, "*/getAll", 1);
        this.xAq.addURI(AUTHORITY, "*/getString", 2);
        this.xAq.addURI(AUTHORITY, "*/getInt", 3);
        this.xAq.addURI(AUTHORITY, "*/getLong", 4);
        this.xAq.addURI(AUTHORITY, "*/getFloat", 5);
        this.xAq.addURI(AUTHORITY, "*/getBoolean", 6);
        this.xAq.addURI(AUTHORITY, "*/contains", 7);
        this.xAq.addURI(AUTHORITY, "*/apply", 8);
        this.xAq.addURI(AUTHORITY, "*/commit", 9);
        this.xAq.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
        this.xAq.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
        AppMethodBeat.o(93574);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(93575);
        String str3 = (String) uri.getPathSegments().get(0);
        int parseInt = Integer.parseInt(strArr2[0]);
        String str4 = strArr2[1];
        String str5 = strArr2[2];
        Bundle bundle = new Bundle();
        Integer num;
        Integer num2;
        switch (this.xAq.match(uri)) {
            case 1:
                bundle.putSerializable("value", (HashMap) getContext().getSharedPreferences(str3, parseInt).getAll());
                break;
            case 2:
                bundle.putString("value", getContext().getSharedPreferences(str3, parseInt).getString(str4, str5));
                break;
            case 3:
                bundle.putInt("value", getContext().getSharedPreferences(str3, parseInt).getInt(str4, Integer.parseInt(str5)));
                break;
            case 4:
                bundle.putLong("value", getContext().getSharedPreferences(str3, parseInt).getLong(str4, Long.parseLong(str5)));
                break;
            case 5:
                bundle.putFloat("value", getContext().getSharedPreferences(str3, parseInt).getFloat(str4, Float.parseFloat(str5)));
                break;
            case 6:
                bundle.putBoolean("value", getContext().getSharedPreferences(str3, parseInt).getBoolean(str4, Boolean.parseBoolean(str5)));
                break;
            case 7:
                bundle.putBoolean("value", getContext().getSharedPreferences(str3, parseInt).contains(str4));
                break;
            case 10:
                dpb();
                num = (Integer) this.xAr.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) + 1;
                this.xAr.put(str3, Integer.valueOf(parseInt));
                num2 = (Integer) this.xAr.get(str3);
                bundle.putBoolean("value", parseInt == (num2 == null ? 0 : num2.intValue()));
                break;
            case 11:
                dpb();
                num = (Integer) this.xAr.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) - 1;
                if (parseInt > 0) {
                    this.xAr.put(str3, Integer.valueOf(parseInt));
                    num2 = (Integer) this.xAr.get(str3);
                    bundle.putBoolean("value", parseInt == (num2 == null ? 0 : num2.intValue()));
                    break;
                }
                this.xAr.remove(str3);
                bundle.putBoolean("value", !this.xAr.containsKey(str3));
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This is Unknown Uri：".concat(String.valueOf(uri)));
                AppMethodBeat.o(93575);
                throw illegalArgumentException;
        }
        a aVar = new a(bundle);
        AppMethodBeat.o(93575);
        return aVar;
    }

    public String getType(Uri uri) {
        AppMethodBeat.i(93576);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external call");
        AppMethodBeat.o(93576);
        throw unsupportedOperationException;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(93577);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external insert");
        AppMethodBeat.o(93577);
        throw unsupportedOperationException;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(93578);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external delete");
        AppMethodBeat.o(93578);
        throw unsupportedOperationException;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        RuntimeException runtimeException;
        IllegalArgumentException e;
        AppMethodBeat.i(93579);
        String str2 = (String) uri.getPathSegments().get(0);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(str2, Integer.parseInt(strArr[0]));
        int match = this.xAq.match(uri);
        switch (match) {
            case 8:
            case 9:
                Object obj;
                ArrayList arrayList;
                int i;
                if (this.xAr == null || this.xAr.get(str2) == null || ((Integer) this.xAr.get(str2)).intValue() <= 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                HashMap hashMap = new HashMap();
                if (obj != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Map all = sharedPreferences.getAll();
                    arrayList = arrayList2;
                } else {
                    Object all2 = hashMap;
                    arrayList = null;
                }
                Editor edit = sharedPreferences.edit();
                if (Boolean.parseBoolean(strArr[1])) {
                    if (!(obj == null || all2 == null || all2.isEmpty())) {
                        for (Entry key : all2.entrySet()) {
                            arrayList.add(key.getKey());
                        }
                    }
                    edit.clear();
                }
                for (Entry key2 : contentValues.valueSet()) {
                    String str3 = (String) key2.getKey();
                    Object value = key2.getValue();
                    if ((value instanceof b) || value == null) {
                        edit.remove(str3);
                        if (!(obj == null || all2 == null || !all2.containsKey(str3))) {
                            arrayList.add(str3);
                        }
                    } else if (!(obj == null || all2 == null || (all2.containsKey(str3) && (!all2.containsKey(str3) || value.equals(all2.get(str3)))))) {
                        arrayList.add(str3);
                    }
                    if (value instanceof String) {
                        edit.putString(str3, (String) value);
                    } else if (value instanceof Set) {
                        c.a(edit, str3, (Set) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str3, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str3, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str3, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str3, ((Boolean) value).booleanValue());
                    }
                }
                if (obj == null || !arrayList.isEmpty()) {
                    switch (match) {
                        case 8:
                            try {
                                edit.getClass().getDeclaredMethod("apply", new Class[0]).invoke(edit, new Object[0]);
                                l(str2, arrayList);
                                i = 1;
                                break;
                            } catch (IllegalArgumentException e2) {
                                runtimeException = new RuntimeException(e2);
                                AppMethodBeat.o(93579);
                                throw runtimeException;
                            } catch (IllegalAccessException e3) {
                                runtimeException = new RuntimeException(e3);
                                AppMethodBeat.o(93579);
                                throw runtimeException;
                            } catch (InvocationTargetException e4) {
                                runtimeException = new RuntimeException(e4);
                                AppMethodBeat.o(93579);
                                throw runtimeException;
                            } catch (NoSuchMethodException e5) {
                                runtimeException = new RuntimeException(e5);
                                AppMethodBeat.o(93579);
                                throw runtimeException;
                            }
                        case 9:
                            if (edit.commit()) {
                                l(str2, arrayList);
                                i = 1;
                                break;
                            }
                        default:
                            i = 0;
                            break;
                    }
                }
                i = 1;
                contentValues.clear();
                AppMethodBeat.o(93579);
                return i;
            default:
                e2 = new IllegalArgumentException("This is Unknown Uri：".concat(String.valueOf(uri)));
                AppMethodBeat.o(93579);
                throw e2;
        }
    }

    public void onLowMemory() {
        AppMethodBeat.i(93580);
        if (this.xAr != null) {
            this.xAr.clear();
        }
        super.onLowMemory();
        AppMethodBeat.o(93580);
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.i(93581);
        if (this.xAr != null) {
            this.xAr.clear();
        }
        super.onTrimMemory(i);
        AppMethodBeat.o(93581);
    }

    private void dpb() {
        AppMethodBeat.i(93582);
        if (this.xAr == null) {
            this.xAr = new HashMap();
        }
        AppMethodBeat.o(93582);
    }

    private void l(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(93583);
        if (!(arrayList == null || arrayList.isEmpty())) {
            Intent intent = new Intent();
            intent.setAction(amL(str));
            intent.setPackage(getContext().getPackageName());
            intent.putExtra("name", str);
            intent.putExtra("value", arrayList);
            getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(93583);
    }
}
