package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Deprecated
public final class ar implements SharedPreferences {
    private static ak xzO = null;
    private static final Object xzW = new Object();
    private static final LruCache<String, ar> xzY = new LruCache(5);
    private Map<String, Object> eGu = null;
    private boolean eJj = false;
    private File gUc = null;
    private int mMode = 0;
    private FLock xzP = null;
    private File xzQ = null;
    private boolean xzR = false;
    private int xzS = 0;
    private long xzT = 0;
    private long xzU = 0;
    private final Object xzV = new Object();
    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> xzX = new WeakHashMap();

    final class b implements Editor {
        private final Map<String, Object> xAc;
        private boolean xAd;

        private b() {
            AppMethodBeat.i(93423);
            this.xAc = new HashMap();
            this.xAd = false;
            AppMethodBeat.o(93423);
        }

        /* synthetic */ b(ar arVar, byte b) {
            this();
        }

        static /* synthetic */ void b(b bVar, c cVar) {
            AppMethodBeat.i(93438);
            bVar.a(cVar);
            AppMethodBeat.o(93438);
        }

        public final Editor putString(String str, String str2) {
            AppMethodBeat.i(93424);
            synchronized (this) {
                try {
                    this.xAc.put(str, str2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93424);
                }
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.i(93425);
            synchronized (this) {
                try {
                    this.xAc.put(str, set);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93425);
                }
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            AppMethodBeat.i(93426);
            synchronized (this) {
                try {
                    this.xAc.put(str, Integer.valueOf(i));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93426);
                }
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            AppMethodBeat.i(93427);
            synchronized (this) {
                try {
                    this.xAc.put(str, Long.valueOf(j));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93427);
                }
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            AppMethodBeat.i(93428);
            synchronized (this) {
                try {
                    this.xAc.put(str, Float.valueOf(f));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93428);
                }
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(93429);
            synchronized (this) {
                try {
                    this.xAc.put(str, Boolean.valueOf(z));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93429);
                }
            }
            return this;
        }

        public final Editor remove(String str) {
            AppMethodBeat.i(93430);
            synchronized (this) {
                try {
                    this.xAc.put(str, this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93430);
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

        public final boolean commit() {
            AppMethodBeat.i(93431);
            c doY = doY();
            a(doY, null);
            try {
                doY.xAl.await();
                a(doY);
                boolean z = doY.xAm;
                AppMethodBeat.o(93431);
                return z;
            } catch (InterruptedException e) {
                AppMethodBeat.o(93431);
                return false;
            }
        }

        public final void apply() {
            AppMethodBeat.i(93432);
            final c doY = doY();
            final AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93419);
                    try {
                        doY.xAl.await();
                        AppMethodBeat.o(93419);
                    } catch (InterruptedException e) {
                        AppMethodBeat.o(93419);
                    }
                }
            };
            ba.ah(anonymousClass1);
            a(doY, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93420);
                    anonymousClass1.run();
                    ba.ai(anonymousClass1);
                    AppMethodBeat.o(93420);
                }
            });
            a(doY);
            AppMethodBeat.o(93432);
        }

        private c doY() {
            int i = (byte) 0;
            int i2 = 93433;
            AppMethodBeat.i(93433);
            c cVar = new c();
            synchronized (ar.this) {
                try {
                    if (ar.this.xzS > 0) {
                        ar.this.eGu = new HashMap(ar.this.eGu);
                    }
                    cVar.xAk = ar.this.eGu;
                    ar.this.xzS = ar.this.xzS + 1;
                    byte b = ar.this.xzX.size() > 0 ? (byte) 1 : (byte) 0;
                    if (b != (byte) 0) {
                        cVar.xAj = new ArrayList();
                        i = ar.this.xzX.keySet();
                        cVar.epg = new HashSet(i);
                    }
                    synchronized (this) {
                        if (this.xAd) {
                            if (!ar.this.eGu.isEmpty()) {
                                cVar.xAi = true;
                                ar.this.eGu.clear();
                            }
                            this.xAd = false;
                        }
                        for (Entry entry : this.xAc.entrySet()) {
                            String str = (String) entry.getKey();
                            b value = entry.getValue();
                            if (value != this) {
                                if (ar.this.eGu.containsKey(str)) {
                                    Object obj = ar.this.eGu.get(str);
                                    if (obj != null && obj.equals(value)) {
                                    }
                                }
                                ar.this.eGu.put(str, value);
                            } else if (ar.this.eGu.containsKey(str)) {
                                ar.this.eGu.remove(str);
                            }
                            cVar.xAi = true;
                            if (b != (byte) 0) {
                                cVar.xAj.add(str);
                            }
                        }
                        this.xAc.clear();
                    }
                } catch (Throwable th) {
                    i = 93433;
                } finally {
                    AppMethodBeat.o(
/*
Method generation error in method: com.tencent.mm.sdk.platformtools.ar.b.doY():com.tencent.mm.sdk.platformtools.ar$c, dex: classes5.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c9: INVOKE  (wrap: int
  ?: MERGE  (r7_1 int) = (r7_0 'i2' int), (r1_10 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.sdk.platformtools.ar.b.doY():com.tencent.mm.sdk.platformtools.ar$c, dex: classes5.dex
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
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r7_1 int) = (r7_0 'i2' int), (r1_10 'i' int) in method: com.tencent.mm.sdk.platformtools.ar.b.doY():com.tencent.mm.sdk.platformtools.ar$c, dex: classes5.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 30 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 35 more

*/

        private void a(final c cVar, final Runnable runnable) {
            Object obj = 1;
            AppMethodBeat.i(93434);
            AnonymousClass3 anonymousClass3 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93421);
                    synchronized (ar.this.xzV) {
                        try {
                            b.a(b.this, cVar);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(93421);
                            }
                        }
                    }
                    synchronized (ar.this) {
                        try {
                            ar.this.xzS = ar.this.xzS - 1;
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.o(93421);
                            }
                        }
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(93421);
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (ar.this) {
                    try {
                        if (ar.this.xzS != 1) {
                            obj = null;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(93434);
                    }
                }
                if (obj != null) {
                    anonymousClass3.run();
                    return;
                }
            }
            ba.dph().execute(anonymousClass3);
            AppMethodBeat.o(93434);
        }

        private FileOutputStream Y(File file) {
            FileOutputStream fileOutputStream;
            AppMethodBeat.i(93435);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    ar.f(parentFile, ar.this.mMode);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        ab.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file ".concat(String.valueOf(file)), e2);
                        fileOutputStream = null;
                    }
                } else {
                    ab.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(file)));
                    AppMethodBeat.o(93435);
                    return null;
                }
            }
            AppMethodBeat.o(93435);
            return fileOutputStream;
        }

        private void a(final c cVar) {
            AppMethodBeat.i(93436);
            if (cVar.epg == null || cVar.xAj == null || cVar.xAj.size() == 0) {
                AppMethodBeat.o(93436);
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                for (int size = cVar.xAj.size() - 1; size >= 0; size--) {
                    String str = (String) cVar.xAj.get(size);
                    for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : cVar.epg) {
                        if (onSharedPreferenceChangeListener != null) {
                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(ar.this, str);
                        }
                    }
                }
                AppMethodBeat.o(93436);
            } else {
                ar.xzO.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(93422);
                        b.b(b.this, cVar);
                        AppMethodBeat.o(93422);
                    }
                });
                AppMethodBeat.o(93436);
            }
        }
    }

    static class c {
        public Set<OnSharedPreferenceChangeListener> epg;
        public boolean xAi;
        public List<String> xAj;
        public Map<String, Object> xAk;
        public final CountDownLatch xAl;
        public volatile boolean xAm;

        private c() {
            AppMethodBeat.i(93439);
            this.xAi = false;
            this.xAj = null;
            this.epg = null;
            this.xAk = null;
            this.xAl = new CountDownLatch(1);
            this.xAm = false;
            AppMethodBeat.o(93439);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void pj(boolean z) {
            AppMethodBeat.i(93440);
            this.xAm = z;
            this.xAl.countDown();
            AppMethodBeat.o(93440);
        }
    }

    public static class a {
        private static SharedPreferences ubh = ah.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String xAa = "pref_key_is_enable_MultiProcSP";
        public static String xAb = "pref_key_is_disabled_MultiProcSP_manually";

        static {
            AppMethodBeat.i(93418);
            AppMethodBeat.o(93418);
        }

        public static void pi(boolean z) {
            AppMethodBeat.i(93413);
            setValue(xAb, z);
            AppMethodBeat.o(93413);
        }

        private static void reload() {
            AppMethodBeat.i(93415);
            ubh = ah.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            AppMethodBeat.o(93415);
        }

        private static boolean amE(String str) {
            AppMethodBeat.i(93416);
            reload();
            if (ubh == null) {
                ab.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                AppMethodBeat.o(93416);
                return false;
            }
            ab.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(ubh.getBoolean(str, false)));
            AppMethodBeat.o(93416);
            return ubh.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            AppMethodBeat.i(93417);
            if (ubh == null) {
                ab.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                AppMethodBeat.o(93417);
                return;
            }
            Editor edit = ubh.edit();
            edit.putBoolean(str, z);
            edit.commit();
            AppMethodBeat.o(93417);
        }

        public static boolean doX() {
            AppMethodBeat.i(93414);
            if (amE(xAb) || !amE(xAa)) {
                AppMethodBeat.o(93414);
                return false;
            }
            AppMethodBeat.o(93414);
            return true;
        }
    }

    static {
        AppMethodBeat.i(93459);
        AppMethodBeat.o(93459);
    }

    public static SharedPreferences s(Context context, String str, int i) {
        int i2 = 1;
        AppMethodBeat.i(93441);
        as amF = as.amF(str);
        SharedPreferences sharedPreferences;
        if (a.doX()) {
            ab.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            sharedPreferences = (ar) xzY.get(str);
            if (sharedPreferences == null) {
                sharedPreferences = new ar(context, str, i);
                xzY.put(str, sharedPreferences);
            } else if ((i & 4) != 0) {
                synchronized (sharedPreferences) {
                    try {
                        if (sharedPreferences.xzS > 0 || (sharedPreferences.xzT == sharedPreferences.gUc.lastModified() && sharedPreferences.xzU == sharedPreferences.gUc.length())) {
                            i2 = 0;
                        }
                        if (i2 == 0) {
                        } else {
                            sharedPreferences.doU();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(93441);
                    }
                }
            }
            as.a(sharedPreferences, amF);
            AppMethodBeat.o(93441);
            return amF;
        }
        ab.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        sharedPreferences = context.getSharedPreferences(str, i);
        AppMethodBeat.o(93441);
        return sharedPreferences;
    }

    private ar() {
        AppMethodBeat.i(93442);
        RuntimeException runtimeException = new RuntimeException("Not supported.");
        AppMethodBeat.o(93442);
        throw runtimeException;
    }

    private ar(Context context, String str, int i) {
        AppMethodBeat.i(93443);
        Context applicationContext = context.getApplicationContext();
        if (xzO == null) {
            xzO = new ak(Looper.getMainLooper());
        }
        Object obj = applicationContext.getApplicationInfo().dataDir;
        if (obj == null || obj.length() == 0) {
            ab.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            obj = "/data/data/" + applicationContext.getPackageName();
        }
        ab.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: ".concat(String.valueOf(obj)));
        File file = new File(obj, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!(file.canRead() && file.canWrite())) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        this.gUc = new File(file, str + ".xml");
        this.xzQ = new File(this.gUc.getPath() + ".bak");
        this.mMode = i;
        this.xzR = (i & 4) != 0;
        if (this.xzR) {
            this.xzP = new FLock(this.gUc.getPath() + ".lock");
        }
        doU();
        AppMethodBeat.o(93443);
    }

    private void doU() {
        AppMethodBeat.i(93444);
        synchronized (this) {
            try {
                this.eJj = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93444);
            }
        }
        d.h(new Runnable() {
            public final void run() {
                AppMethodBeat.i(93412);
                synchronized (ar.this) {
                    try {
                        ar.a(ar.this);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(93412);
                    }
                }
            }
        }, "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(93445);
        synchronized (this) {
            try {
                this.xzX.put(onSharedPreferenceChangeListener, xzW);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93445);
            }
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(93446);
        synchronized (this) {
            try {
                this.xzX.remove(onSharedPreferenceChangeListener);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93446);
            }
        }
    }

    private void doV() {
        AppMethodBeat.i(93447);
        while (!this.eJj) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        AppMethodBeat.o(93447);
    }

    public final Map<String, ?> getAll() {
        Map<String, ?> hashMap;
        AppMethodBeat.i(93448);
        synchronized (this) {
            try {
                doV();
                hashMap = new HashMap(this.eGu);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93448);
            }
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        AppMethodBeat.i(93449);
        synchronized (this) {
            try {
                doV();
                str3 = (String) this.eGu.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93449);
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        AppMethodBeat.i(93450);
        synchronized (this) {
            try {
                doV();
                set2 = (Set) this.eGu.get(str);
                if (set2 == null) {
                    set2 = set;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93450);
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        AppMethodBeat.i(93451);
        synchronized (this) {
            try {
                doV();
                Integer num = (Integer) this.eGu.get(str);
                if (num != null) {
                    i = num.intValue();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93451);
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        AppMethodBeat.i(93452);
        synchronized (this) {
            try {
                doV();
                Long l = (Long) this.eGu.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93452);
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        AppMethodBeat.i(93453);
        synchronized (this) {
            try {
                doV();
                Float f2 = (Float) this.eGu.get(str);
                if (f2 != null) {
                    f = f2.floatValue();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93453);
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(93454);
        synchronized (this) {
            try {
                doV();
                Boolean bool = (Boolean) this.eGu.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93454);
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        AppMethodBeat.i(93455);
        synchronized (this) {
            try {
                doV();
                containsKey = this.eGu.containsKey(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93455);
            }
        }
        return containsKey;
    }

    public final Editor edit() {
        AppMethodBeat.i(93456);
        synchronized (this) {
            try {
                doV();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93456);
            }
        }
        Editor bVar = new b(this, (byte) 0);
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A:{SYNTHETIC, Splitter:B:40:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A:{SYNTHETIC, Splitter:B:40:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A:{SYNTHETIC, Splitter:B:40:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A:{SYNTHETIC, Splitter:B:40:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A:{SYNTHETIC, Splitter:B:40:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A:{Catch:{ XmlPullParserException -> 0x00ca, FileNotFoundException -> 0x00ea, IOException -> 0x00fc, all -> 0x00dc }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A:{SYNTHETIC, Splitter:B:40:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(ar arVar) {
        XmlPullParserException e;
        Object obj;
        FileNotFoundException e2;
        IOException e3;
        Map obj2 = null;
        AppMethodBeat.i(93457);
        if (arVar.xzR) {
            try {
                arVar.xzP.lockRead();
            } catch (Exception e4) {
                ab.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e4, "", new Object[0]);
            }
        }
        try {
            if (arVar.eJj) {
                if (arVar.xzR) {
                    try {
                        arVar.xzP.unlock();
                        AppMethodBeat.o(93457);
                        return;
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(93457);
                return;
            }
            if (arVar.xzQ.exists()) {
                arVar.gUc.delete();
                arVar.xzQ.renameTo(arVar.gUc);
            }
            if (arVar.gUc.exists() && !arVar.gUc.canRead()) {
                ab.w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + arVar.gUc + " without permission");
            }
            if (arVar.gUc.canRead()) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(arVar.gUc), 16384);
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(bufferedInputStream, null);
                HashMap hashMap = (HashMap) bs.a(newPullParser, new String[1]);
                try {
                    bufferedInputStream.close();
                    obj2 = hashMap;
                } catch (XmlPullParserException e6) {
                    e = e6;
                    obj2 = hashMap;
                    ab.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
                    arVar.eJj = true;
                    if (obj2 != null) {
                    }
                    arVar.notifyAll();
                    if (arVar.xzR) {
                    }
                } catch (FileNotFoundException e7) {
                    e2 = e7;
                    obj2 = hashMap;
                    ab.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
                    arVar.eJj = true;
                    if (obj2 != null) {
                    }
                    arVar.notifyAll();
                    if (arVar.xzR) {
                    }
                } catch (IOException e8) {
                    e3 = e8;
                    obj2 = hashMap;
                    ab.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
                    arVar.eJj = true;
                    if (obj2 != null) {
                    }
                    arVar.notifyAll();
                    if (arVar.xzR) {
                    }
                }
            }
            arVar.eJj = true;
            if (obj2 != null) {
                arVar.eGu = obj2;
                arVar.xzT = arVar.gUc.lastModified();
                arVar.xzU = arVar.gUc.length();
            } else {
                arVar.eGu = new HashMap();
            }
            arVar.notifyAll();
            if (arVar.xzR) {
                try {
                    arVar.xzP.unlock();
                    AppMethodBeat.o(93457);
                    return;
                } catch (Exception e9) {
                    AppMethodBeat.o(93457);
                    return;
                }
            }
            AppMethodBeat.o(93457);
        } catch (XmlPullParserException e10) {
            e = e10;
            ab.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
            arVar.eJj = true;
            if (obj2 != null) {
            }
            arVar.notifyAll();
            if (arVar.xzR) {
            }
        } catch (FileNotFoundException e11) {
            e2 = e11;
            ab.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
            arVar.eJj = true;
            if (obj2 != null) {
            }
            arVar.notifyAll();
            if (arVar.xzR) {
            }
        } catch (IOException e12) {
            e3 = e12;
            ab.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
            arVar.eJj = true;
            if (obj2 != null) {
            }
            arVar.notifyAll();
            if (arVar.xzR) {
            }
        } catch (Throwable th) {
            if (arVar.xzR) {
                try {
                    arVar.xzP.unlock();
                } catch (Exception e13) {
                }
            }
            AppMethodBeat.o(93457);
        }
    }

    static /* synthetic */ void f(File file, int i) {
        boolean z = false;
        AppMethodBeat.i(93458);
        file.setReadable(true, (i & 1) == 0);
        if ((i & 2) == 0) {
            z = true;
        }
        file.setWritable(true, z);
        AppMethodBeat.o(93458);
    }
}
