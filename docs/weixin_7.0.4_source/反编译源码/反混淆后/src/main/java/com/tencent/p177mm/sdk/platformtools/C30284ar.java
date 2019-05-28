package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
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
/* renamed from: com.tencent.mm.sdk.platformtools.ar */
public final class C30284ar implements SharedPreferences {
    private static C7306ak xzO = null;
    private static final Object xzW = new Object();
    private static final LruCache<String, C30284ar> xzY = new LruCache(5);
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

    /* renamed from: com.tencent.mm.sdk.platformtools.ar$1 */
    class C302831 implements Runnable {
        C302831() {
        }

        public final void run() {
            AppMethodBeat.m2504i(93412);
            synchronized (C30284ar.this) {
                try {
                    C30284ar.m48169a(C30284ar.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93412);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ar$b */
    final class C30285b implements Editor {
        private final Map<String, Object> xAc;
        private boolean xAd;

        private C30285b() {
            AppMethodBeat.m2504i(93423);
            this.xAc = new HashMap();
            this.xAd = false;
            AppMethodBeat.m2505o(93423);
        }

        /* synthetic */ C30285b(C30284ar c30284ar, byte b) {
            this();
        }

        /* renamed from: b */
        static /* synthetic */ void m48188b(C30285b c30285b, C30289c c30289c) {
            AppMethodBeat.m2504i(93438);
            c30285b.m48186a(c30289c);
            AppMethodBeat.m2505o(93438);
        }

        public final Editor putString(String str, String str2) {
            AppMethodBeat.m2504i(93424);
            synchronized (this) {
                try {
                    this.xAc.put(str, str2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93424);
                }
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.m2504i(93425);
            synchronized (this) {
                try {
                    this.xAc.put(str, set);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93425);
                }
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            AppMethodBeat.m2504i(93426);
            synchronized (this) {
                try {
                    this.xAc.put(str, Integer.valueOf(i));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93426);
                }
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            AppMethodBeat.m2504i(93427);
            synchronized (this) {
                try {
                    this.xAc.put(str, Long.valueOf(j));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93427);
                }
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            AppMethodBeat.m2504i(93428);
            synchronized (this) {
                try {
                    this.xAc.put(str, Float.valueOf(f));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93428);
                }
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            AppMethodBeat.m2504i(93429);
            synchronized (this) {
                try {
                    this.xAc.put(str, Boolean.valueOf(z));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93429);
                }
            }
            return this;
        }

        public final Editor remove(String str) {
            AppMethodBeat.m2504i(93430);
            synchronized (this) {
                try {
                    this.xAc.put(str, this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93430);
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
            AppMethodBeat.m2504i(93431);
            C30289c doY = doY();
            m48187a(doY, null);
            try {
                doY.xAl.await();
                m48186a(doY);
                boolean z = doY.xAm;
                AppMethodBeat.m2505o(93431);
                return z;
            } catch (InterruptedException e) {
                AppMethodBeat.m2505o(93431);
                return false;
            }
        }

        public final void apply() {
            AppMethodBeat.m2504i(93432);
            final C30289c doY = doY();
            final C154201 c154201 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(93419);
                    try {
                        doY.xAl.await();
                        AppMethodBeat.m2505o(93419);
                    } catch (InterruptedException e) {
                        AppMethodBeat.m2505o(93419);
                    }
                }
            };
            C46613ba.m88167ah(c154201);
            m48187a(doY, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(93420);
                    c154201.run();
                    C46613ba.m88168ai(c154201);
                    AppMethodBeat.m2505o(93420);
                }
            });
            m48186a(doY);
            AppMethodBeat.m2505o(93432);
        }

        private C30289c doY() {
            int i = (byte) 0;
            int i2 = 93433;
            AppMethodBeat.m2504i(93433);
            C30289c c30289c = new C30289c();
            synchronized (C30284ar.this) {
                try {
                    if (C30284ar.this.xzS > 0) {
                        C30284ar.this.eGu = new HashMap(C30284ar.this.eGu);
                    }
                    c30289c.xAk = C30284ar.this.eGu;
                    C30284ar.this.xzS = C30284ar.this.xzS + 1;
                    byte b = C30284ar.this.xzX.size() > 0 ? (byte) 1 : (byte) 0;
                    if (b != (byte) 0) {
                        c30289c.xAj = new ArrayList();
                        i = C30284ar.this.xzX.keySet();
                        c30289c.epg = new HashSet(i);
                    }
                    synchronized (this) {
                        if (this.xAd) {
                            if (!C30284ar.this.eGu.isEmpty()) {
                                c30289c.xAi = true;
                                C30284ar.this.eGu.clear();
                            }
                            this.xAd = false;
                        }
                        for (Entry entry : this.xAc.entrySet()) {
                            String str = (String) entry.getKey();
                            C30285b value = entry.getValue();
                            if (value != this) {
                                if (C30284ar.this.eGu.containsKey(str)) {
                                    Object obj = C30284ar.this.eGu.get(str);
                                    if (obj != null && obj.equals(value)) {
                                    }
                                }
                                C30284ar.this.eGu.put(str, value);
                            } else if (C30284ar.this.eGu.containsKey(str)) {
                                C30284ar.this.eGu.remove(str);
                            }
                            c30289c.xAi = true;
                            if (b != (byte) 0) {
                                c30289c.xAj.add(str);
                            }
                        }
                        this.xAc.clear();
                    }
                } catch (Throwable th) {
                    i = 93433;
                } finally {
                    AppMethodBeat.m2505o(
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

        /* renamed from: a */
        private void m48187a(final C30289c c30289c, final Runnable runnable) {
            Object obj = 1;
            AppMethodBeat.m2504i(93434);
            C302873 c302873 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(93421);
                    synchronized (C30284ar.this.xzV) {
                        try {
                            C30285b.m48185a(C30285b.this, c30289c);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(93421);
                            }
                        }
                    }
                    synchronized (C30284ar.this) {
                        try {
                            C30284ar.this.xzS = C30284ar.this.xzS - 1;
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(93421);
                            }
                        }
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.m2505o(93421);
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (C30284ar.this) {
                    try {
                        if (C30284ar.this.xzS != 1) {
                            obj = null;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(93434);
                    }
                }
                if (obj != null) {
                    c302873.run();
                    return;
                }
            }
            C46613ba.dph().execute(c302873);
            AppMethodBeat.m2505o(93434);
        }

        /* renamed from: Y */
        private FileOutputStream m48184Y(File file) {
            FileOutputStream fileOutputStream;
            AppMethodBeat.m2504i(93435);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    C30284ar.m48176f(parentFile, C30284ar.this.mMode);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        C4990ab.m7413e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file ".concat(String.valueOf(file)), e2);
                        fileOutputStream = null;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(file)));
                    AppMethodBeat.m2505o(93435);
                    return null;
                }
            }
            AppMethodBeat.m2505o(93435);
            return fileOutputStream;
        }

        /* renamed from: a */
        private void m48186a(final C30289c c30289c) {
            AppMethodBeat.m2504i(93436);
            if (c30289c.epg == null || c30289c.xAj == null || c30289c.xAj.size() == 0) {
                AppMethodBeat.m2505o(93436);
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                for (int size = c30289c.xAj.size() - 1; size >= 0; size--) {
                    String str = (String) c30289c.xAj.get(size);
                    for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : c30289c.epg) {
                        if (onSharedPreferenceChangeListener != null) {
                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(C30284ar.this, str);
                        }
                    }
                }
                AppMethodBeat.m2505o(93436);
            } else {
                C30284ar.xzO.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(93422);
                        C30285b.m48188b(C30285b.this, c30289c);
                        AppMethodBeat.m2505o(93422);
                    }
                });
                AppMethodBeat.m2505o(93436);
            }
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ar$c */
    static class C30289c {
        public Set<OnSharedPreferenceChangeListener> epg;
        public boolean xAi;
        public List<String> xAj;
        public Map<String, Object> xAk;
        public final CountDownLatch xAl;
        public volatile boolean xAm;

        private C30289c() {
            AppMethodBeat.m2504i(93439);
            this.xAi = false;
            this.xAj = null;
            this.epg = null;
            this.xAk = null;
            this.xAl = new CountDownLatch(1);
            this.xAm = false;
            AppMethodBeat.m2505o(93439);
        }

        /* synthetic */ C30289c(byte b) {
            this();
        }

        /* renamed from: pj */
        public final void mo48495pj(boolean z) {
            AppMethodBeat.m2504i(93440);
            this.xAm = z;
            this.xAl.countDown();
            AppMethodBeat.m2505o(93440);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ar$a */
    public static class C30290a {
        private static SharedPreferences ubh = C4996ah.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String xAa = "pref_key_is_enable_MultiProcSP";
        public static String xAb = "pref_key_is_disabled_MultiProcSP_manually";

        static {
            AppMethodBeat.m2504i(93418);
            AppMethodBeat.m2505o(93418);
        }

        /* renamed from: pi */
        public static void m48190pi(boolean z) {
            AppMethodBeat.m2504i(93413);
            C30290a.setValue(xAb, z);
            AppMethodBeat.m2505o(93413);
        }

        private static void reload() {
            AppMethodBeat.m2504i(93415);
            ubh = C4996ah.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            AppMethodBeat.m2505o(93415);
        }

        private static boolean amE(String str) {
            AppMethodBeat.m2504i(93416);
            C30290a.reload();
            if (ubh == null) {
                C4990ab.m7420w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                AppMethodBeat.m2505o(93416);
                return false;
            }
            C4990ab.m7411d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(ubh.getBoolean(str, false)));
            AppMethodBeat.m2505o(93416);
            return ubh.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            AppMethodBeat.m2504i(93417);
            if (ubh == null) {
                C4990ab.m7420w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                AppMethodBeat.m2505o(93417);
                return;
            }
            Editor edit = ubh.edit();
            edit.putBoolean(str, z);
            edit.commit();
            AppMethodBeat.m2505o(93417);
        }

        public static boolean doX() {
            AppMethodBeat.m2504i(93414);
            if (C30290a.amE(xAb) || !C30290a.amE(xAa)) {
                AppMethodBeat.m2505o(93414);
                return false;
            }
            AppMethodBeat.m2505o(93414);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(93459);
        AppMethodBeat.m2505o(93459);
    }

    /* renamed from: s */
    public static SharedPreferences m48183s(Context context, String str, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(93441);
        C5018as amF = C5018as.amF(str);
        SharedPreferences sharedPreferences;
        if (C30290a.doX()) {
            C4990ab.m7417i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            sharedPreferences = (C30284ar) xzY.get(str);
            if (sharedPreferences == null) {
                sharedPreferences = new C30284ar(context, str, i);
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
                        AppMethodBeat.m2505o(93441);
                    }
                }
            }
            C5018as.m7464a(sharedPreferences, amF);
            AppMethodBeat.m2505o(93441);
            return amF;
        }
        C4990ab.m7417i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        sharedPreferences = context.getSharedPreferences(str, i);
        AppMethodBeat.m2505o(93441);
        return sharedPreferences;
    }

    private C30284ar() {
        AppMethodBeat.m2504i(93442);
        RuntimeException runtimeException = new RuntimeException("Not supported.");
        AppMethodBeat.m2505o(93442);
        throw runtimeException;
    }

    private C30284ar(Context context, String str, int i) {
        AppMethodBeat.m2504i(93443);
        Context applicationContext = context.getApplicationContext();
        if (xzO == null) {
            xzO = new C7306ak(Looper.getMainLooper());
        }
        Object obj = applicationContext.getApplicationInfo().dataDir;
        if (obj == null || obj.length() == 0) {
            C4990ab.m7420w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            obj = "/data/data/" + applicationContext.getPackageName();
        }
        C4990ab.m7416i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: ".concat(String.valueOf(obj)));
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
        AppMethodBeat.m2505o(93443);
    }

    private void doU() {
        AppMethodBeat.m2504i(93444);
        synchronized (this) {
            try {
                this.eJj = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93444);
            }
        }
        C7305d.m12301h(new C302831(), "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.m2504i(93445);
        synchronized (this) {
            try {
                this.xzX.put(onSharedPreferenceChangeListener, xzW);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93445);
            }
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.m2504i(93446);
        synchronized (this) {
            try {
                this.xzX.remove(onSharedPreferenceChangeListener);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93446);
            }
        }
    }

    private void doV() {
        AppMethodBeat.m2504i(93447);
        while (!this.eJj) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        AppMethodBeat.m2505o(93447);
    }

    public final Map<String, ?> getAll() {
        Map<String, ?> hashMap;
        AppMethodBeat.m2504i(93448);
        synchronized (this) {
            try {
                doV();
                hashMap = new HashMap(this.eGu);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93448);
            }
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(93449);
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
                AppMethodBeat.m2505o(93449);
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        AppMethodBeat.m2504i(93450);
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
                AppMethodBeat.m2505o(93450);
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        AppMethodBeat.m2504i(93451);
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
                AppMethodBeat.m2505o(93451);
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        AppMethodBeat.m2504i(93452);
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
                AppMethodBeat.m2505o(93452);
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        AppMethodBeat.m2504i(93453);
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
                AppMethodBeat.m2505o(93453);
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(93454);
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
                AppMethodBeat.m2505o(93454);
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        AppMethodBeat.m2504i(93455);
        synchronized (this) {
            try {
                doV();
                containsKey = this.eGu.containsKey(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93455);
            }
        }
        return containsKey;
    }

    public final Editor edit() {
        AppMethodBeat.m2504i(93456);
        synchronized (this) {
            try {
                doV();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93456);
            }
        }
        Editor c30285b = new C30285b(this, (byte) 0);
        return c30285b;
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
    /* renamed from: a */
    static /* synthetic */ void m48169a(C30284ar c30284ar) {
        XmlPullParserException e;
        Object obj;
        FileNotFoundException e2;
        IOException e3;
        Map obj2 = null;
        AppMethodBeat.m2504i(93457);
        if (c30284ar.xzR) {
            try {
                c30284ar.xzP.lockRead();
            } catch (Exception e4) {
                C4990ab.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e4, "", new Object[0]);
            }
        }
        try {
            if (c30284ar.eJj) {
                if (c30284ar.xzR) {
                    try {
                        c30284ar.xzP.unlock();
                        AppMethodBeat.m2505o(93457);
                        return;
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.m2505o(93457);
                return;
            }
            if (c30284ar.xzQ.exists()) {
                c30284ar.gUc.delete();
                c30284ar.xzQ.renameTo(c30284ar.gUc);
            }
            if (c30284ar.gUc.exists() && !c30284ar.gUc.canRead()) {
                C4990ab.m7420w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + c30284ar.gUc + " without permission");
            }
            if (c30284ar.gUc.canRead()) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(c30284ar.gUc), 16384);
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(bufferedInputStream, null);
                HashMap hashMap = (HashMap) C35994bs.m59205a(newPullParser, new String[1]);
                try {
                    bufferedInputStream.close();
                    obj2 = hashMap;
                } catch (XmlPullParserException e6) {
                    e = e6;
                    obj2 = hashMap;
                    C4990ab.m7421w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
                    c30284ar.eJj = true;
                    if (obj2 != null) {
                    }
                    c30284ar.notifyAll();
                    if (c30284ar.xzR) {
                    }
                } catch (FileNotFoundException e7) {
                    e2 = e7;
                    obj2 = hashMap;
                    C4990ab.m7421w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
                    c30284ar.eJj = true;
                    if (obj2 != null) {
                    }
                    c30284ar.notifyAll();
                    if (c30284ar.xzR) {
                    }
                } catch (IOException e8) {
                    e3 = e8;
                    obj2 = hashMap;
                    C4990ab.m7421w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
                    c30284ar.eJj = true;
                    if (obj2 != null) {
                    }
                    c30284ar.notifyAll();
                    if (c30284ar.xzR) {
                    }
                }
            }
            c30284ar.eJj = true;
            if (obj2 != null) {
                c30284ar.eGu = obj2;
                c30284ar.xzT = c30284ar.gUc.lastModified();
                c30284ar.xzU = c30284ar.gUc.length();
            } else {
                c30284ar.eGu = new HashMap();
            }
            c30284ar.notifyAll();
            if (c30284ar.xzR) {
                try {
                    c30284ar.xzP.unlock();
                    AppMethodBeat.m2505o(93457);
                    return;
                } catch (Exception e9) {
                    AppMethodBeat.m2505o(93457);
                    return;
                }
            }
            AppMethodBeat.m2505o(93457);
        } catch (XmlPullParserException e10) {
            e = e10;
            C4990ab.m7421w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
            c30284ar.eJj = true;
            if (obj2 != null) {
            }
            c30284ar.notifyAll();
            if (c30284ar.xzR) {
            }
        } catch (FileNotFoundException e11) {
            e2 = e11;
            C4990ab.m7421w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
            c30284ar.eJj = true;
            if (obj2 != null) {
            }
            c30284ar.notifyAll();
            if (c30284ar.xzR) {
            }
        } catch (IOException e12) {
            e3 = e12;
            C4990ab.m7421w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
            c30284ar.eJj = true;
            if (obj2 != null) {
            }
            c30284ar.notifyAll();
            if (c30284ar.xzR) {
            }
        } catch (Throwable th) {
            if (c30284ar.xzR) {
                try {
                    c30284ar.xzP.unlock();
                } catch (Exception e13) {
                }
            }
            AppMethodBeat.m2505o(93457);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m48176f(File file, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(93458);
        file.setReadable(true, (i & 1) == 0);
        if ((i & 2) == 0) {
            z = true;
        }
        file.setWritable(true, z);
        AppMethodBeat.m2505o(93458);
    }
}
