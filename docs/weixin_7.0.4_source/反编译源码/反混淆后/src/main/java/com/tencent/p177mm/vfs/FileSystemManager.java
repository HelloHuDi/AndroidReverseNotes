package com.tencent.p177mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.vfs.C5736j.C5735a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.tencent.mm.vfs.FileSystemManager */
public final class FileSystemManager implements Callback {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context sContext = null;
    private static volatile C5716b zZj = null;
    private static volatile boolean zZk = true;
    private FileSystem Cac;
    private int Cad;
    private C5718d Cae;
    final HashMap<String, String> Caf;
    private final FileSystem Cag;
    private final FileSystem Cah;
    private final File Cai;
    final HandlerThread Caj;
    public final MaintenanceBroadcastReceiver Cak;
    private final Handler Cal;
    public volatile long Cam;
    public volatile long Can;
    public volatile boolean Cao;
    public volatile boolean Cap;
    private volatile BroadcastReceiver Caq;
    private final Object mLock;
    private HashMap<String, FileSystem> zYT;
    private TreeMap<String, String> zYU;
    private HashMap<String, String> zYW;
    private ArrayList<C5717c> zZl;

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$1 */
    class C57141 extends BroadcastReceiver {
        C57141() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(54507);
            FileSystemManager.this.Cal.sendMessageAtFrontOfQueue(Message.obtain(FileSystemManager.this.Cal, 1, intent));
            AppMethodBeat.m2505o(54507);
        }
    }

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$MaintenanceBroadcastReceiver */
    public final class MaintenanceBroadcastReceiver extends BroadcastReceiver {
        public boolean jZS;
        public boolean jZT;
        private CancellationSignal zZp;

        private MaintenanceBroadcastReceiver() {
        }

        /* synthetic */ MaintenanceBroadcastReceiver(FileSystemManager fileSystemManager, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(54514);
            String action = intent.getAction();
            if (action == null) {
                AppMethodBeat.m2505o(54514);
                return;
            }
            boolean z = true;
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        z = true;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        z = true;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        z = false;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    this.jZT = true;
                    break;
                case true:
                    this.jZT = false;
                    break;
                case true:
                    this.jZS = true;
                    break;
                case true:
                    this.jZS = false;
                    break;
            }
            C0926b.m2101d("VFS.FileSystemManager", "Idle status changed: charging = " + this.jZS + ", interactive = " + this.jZT);
            if (this.jZS && !this.jZT && this.zZp == null) {
                long a = FileSystemManager.this.Cam;
                if (a >= 0) {
                    this.zZp = new CancellationSignal();
                    FileSystemManager.this.Cal.sendMessageDelayed(Message.obtain(FileSystemManager.this.Cal, 2, this.zZp), a);
                    C0926b.m2105i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + (a / 1000) + " seconds.");
                    AppMethodBeat.m2505o(54514);
                    return;
                }
            } else if ((!this.jZS || this.jZT) && this.zZp != null) {
                FileSystemManager.this.Cal.removeMessages(2);
                this.zZp.cancel();
                this.zZp = null;
                C0926b.m2105i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
            }
            AppMethodBeat.m2505o(54514);
        }
    }

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$a */
    public final class C5715a {
        public final HashMap<String, FileSystem> zYT = new HashMap();
        public final TreeMap<String, String> zYU = new TreeMap();
        public final HashMap<String, String> zYW = new HashMap();
        public FileSystem zZn = null;
        public boolean zZo = false;

        public C5715a() {
            AppMethodBeat.m2504i(54508);
            AppMethodBeat.m2505o(54508);
        }

        /* renamed from: a */
        public final C5715a mo11624a(String str, FileSystem fileSystem) {
            AppMethodBeat.m2504i(54509);
            this.zYT.put(str, fileSystem);
            AppMethodBeat.m2505o(54509);
            return this;
        }

        /* renamed from: iq */
        public final C5715a mo11626iq(String str, String str2) {
            AppMethodBeat.m2504i(54510);
            this.zYU.put(str, str2);
            AppMethodBeat.m2505o(54510);
            return this;
        }

        /* renamed from: ir */
        public final C5715a mo11627ir(String str, String str2) {
            AppMethodBeat.m2504i(54511);
            this.zYW.put(str, str2);
            AppMethodBeat.m2505o(54511);
            return this;
        }

        public final void commit() {
            AppMethodBeat.m2504i(54512);
            mo11628ri(FileSystemManager.this.Cap);
            AppMethodBeat.m2505o(54512);
        }

        /* renamed from: ri */
        public final void mo11628ri(boolean z) {
            AppMethodBeat.m2504i(54513);
            FileSystemManager.m8601a(FileSystemManager.this, this.zYT, this.zYU, this.zYW, this.zZn, this.zZo, z);
            this.zYT.clear();
            this.zYU.clear();
            this.zYW.clear();
            this.zZo = false;
            AppMethodBeat.m2505o(54513);
        }
    }

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$b */
    public interface C5716b {
        /* renamed from: e */
        Key mo11629e(String str, Map<String, String> map);
    }

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$c */
    static final class C5717c implements Comparable<String> {
        final String zZq;
        final String zZr;
        final FileSystem zZs;
        final boolean zZt;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.m2504i(54515);
            int compareTo = this.zZq.compareTo((String) obj);
            AppMethodBeat.m2505o(54515);
            return compareTo;
        }

        C5717c(String str, String str2, FileSystem fileSystem, boolean z) {
            this.zZq = str;
            this.zZr = str2;
            this.zZs = fileSystem;
            this.zZt = z;
        }
    }

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$d */
    public static final class C5718d {
        final int bal;
        public final String path;
        public final FileSystem zZs;

        /* synthetic */ C5718d(FileSystem fileSystem, String str, int i, byte b) {
            this(fileSystem, str, i);
        }

        private C5718d(FileSystem fileSystem, String str, int i) {
            this.zZs = fileSystem;
            this.path = str;
            this.bal = i;
        }

        public final boolean valid() {
            return this.zZs != null;
        }

        public final String toString() {
            AppMethodBeat.m2504i(54516);
            String str = this.path + " -> " + this.zZs.toString();
            AppMethodBeat.m2505o(54516);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.vfs.FileSystemManager$e */
    static final class C5719e {
        @SuppressLint({"StaticFieldLeak"})
        static final FileSystemManager zZu;

        static {
            AppMethodBeat.m2504i(54517);
            FileSystemManager fileSystemManager = new FileSystemManager();
            zZu = fileSystemManager;
            FileSystemManager.m8606c(fileSystemManager);
            AppMethodBeat.m2505o(54517);
        }
    }

    /* synthetic */ FileSystemManager(byte b) {
        this();
    }

    public static FileSystemManager dMy() {
        return C5719e.zZu;
    }

    public static void setContext(Context context) {
        AppMethodBeat.m2504i(54518);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        sContext = context;
        AppMethodBeat.m2505o(54518);
    }

    /* renamed from: a */
    public static void m8600a(C5716b c5716b) {
        zZj = c5716b;
    }

    static C5716b enr() {
        return zZj;
    }

    /* renamed from: se */
    public static void m8610se(boolean z) {
        zZk = z;
    }

    /* renamed from: io */
    private void m8609io(Context context) {
        File externalCacheDir;
        AppMethodBeat.m2504i(54519);
        this.Caf.put("data", context.getCacheDir().getParent());
        this.Caf.put("dataCache", context.getCacheDir().getPath());
        try {
            externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                this.Caf.put("extData", externalCacheDir.getParent());
                this.Caf.put("extCache", externalCacheDir.getPath());
            }
        } catch (Exception e) {
            C0926b.m2098b("VFS.FileSystemManager", e, "Cannot get external cache directory.");
        }
        externalCacheDir = Environment.getExternalStorageDirectory();
        if (externalCacheDir != null) {
            this.Caf.put("storage", externalCacheDir.getPath());
        }
        C0926b.m2105i("VFS.FileSystemManager", "Static environment:");
        for (Entry entry : this.Caf.entrySet()) {
            C0926b.m2105i("VFS.FileSystemManager", "  " + ((String) entry.getKey()) + " => " + ((String) entry.getValue()));
        }
        AppMethodBeat.m2505o(54519);
    }

    private static String awW(String str) {
        AppMethodBeat.m2504i(54520);
        File file = new File(str);
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
            AppMethodBeat.m2505o(54520);
            return canonicalPath;
        } catch (IOException e) {
            canonicalPath = file.getAbsolutePath();
            AppMethodBeat.m2505o(54520);
            return canonicalPath;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:10:0x0026, code skipped:
            r3 = r13.getPath();
            r2 = r13.getScheme();
     */
    /* JADX WARNING: Missing block: B:11:0x002e, code skipped:
            if (r2 == null) goto L_0x0039;
     */
    /* JADX WARNING: Missing block: B:13:0x0037, code skipped:
            if (r2.equals("file") == false) goto L_0x00c1;
     */
    /* JADX WARNING: Missing block: B:14:0x0039, code skipped:
            if (r3 == null) goto L_0x0041;
     */
    /* JADX WARNING: Missing block: B:16:0x003f, code skipped:
            if (r3.isEmpty() == false) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:17:0x0041, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(54521);
     */
    /* JADX WARNING: Missing block: B:22:0x004b, code skipped:
            r3 = com.tencent.p177mm.vfs.FileSystemManager.awW(r3);
            r0 = java.util.Collections.binarySearch(r5, r3);
     */
    /* JADX WARNING: Missing block: B:23:0x0053, code skipped:
            if (r0 < 0) goto L_0x006a;
     */
    /* JADX WARNING: Missing block: B:24:0x0055, code skipped:
            r2 = ((com.tencent.p177mm.vfs.FileSystemManager.C5717c) r5.get(r0)).zZs;
            r1 = "";
     */
    /* JADX WARNING: Missing block: B:25:0x0061, code skipped:
            r14 = new com.tencent.p177mm.vfs.FileSystemManager.C5718d(r2, r1, r6, (byte) 0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(54521);
     */
    /* JADX WARNING: Missing block: B:26:0x006a, code skipped:
            r2 = (-r0) - 2;
     */
    /* JADX WARNING: Missing block: B:27:0x006d, code skipped:
            if (r2 < 0) goto L_0x0098;
     */
    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            r0 = (com.tencent.p177mm.vfs.FileSystemManager.C5717c) r5.get(r2);
     */
    /* JADX WARNING: Missing block: B:29:0x0075, code skipped:
            if (r0 == null) goto L_0x009c;
     */
    /* JADX WARNING: Missing block: B:31:0x007d, code skipped:
            if (r3.startsWith(r0.zZq) == false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:33:0x0089, code skipped:
            if (r3.charAt(r0.zZq.length()) == com.tencent.ttpic.baseutils.IOUtils.DIR_SEPARATOR_UNIX) goto L_0x009c;
     */
    /* JADX WARNING: Missing block: B:35:0x008d, code skipped:
            if (r0.zZt == false) goto L_0x009a;
     */
    /* JADX WARNING: Missing block: B:36:0x008f, code skipped:
            r2 = r2 - 1;
            r0 = (com.tencent.p177mm.vfs.FileSystemManager.C5717c) r5.get(r2);
     */
    /* JADX WARNING: Missing block: B:37:0x0098, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:38:0x009a, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:39:0x009c, code skipped:
            if (r0 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Missing block: B:40:0x009e, code skipped:
            r2 = r0.zZs;
            r1 = r3.substring(r0.zZq.length() + 1);
     */
    /* JADX WARNING: Missing block: B:42:0x00b2, code skipped:
            if (r3.isEmpty() != false) goto L_0x0100;
     */
    /* JADX WARNING: Missing block: B:44:0x00b8, code skipped:
            if (r3.charAt(0) != com.tencent.ttpic.baseutils.IOUtils.DIR_SEPARATOR_UNIX) goto L_0x0100;
     */
    /* JADX WARNING: Missing block: B:45:0x00ba, code skipped:
            r0 = r3.substring(1);
     */
    /* JADX WARNING: Missing block: B:46:0x00be, code skipped:
            r1 = r0;
            r2 = r4;
     */
    /* JADX WARNING: Missing block: B:48:0x00c8, code skipped:
            if (r2.equals("wcf") == false) goto L_0x00e1;
     */
    /* JADX WARNING: Missing block: B:49:0x00ca, code skipped:
            r0 = (com.tencent.p177mm.vfs.FileSystem) r0.get(r13.getAuthority());
     */
    /* JADX WARNING: Missing block: B:50:0x00d4, code skipped:
            if (r3 != null) goto L_0x00db;
     */
    /* JADX WARNING: Missing block: B:51:0x00d6, code skipped:
            r1 = "";
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:52:0x00db, code skipped:
            r1 = com.tencent.p177mm.vfs.C5736j.m8648k(r3, true, true);
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:54:0x00e8, code skipped:
            if (r2.equals("assets") == false) goto L_0x00fb;
     */
    /* JADX WARNING: Missing block: B:55:0x00ea, code skipped:
            r2 = r12.Cah;
     */
    /* JADX WARNING: Missing block: B:56:0x00ec, code skipped:
            if (r3 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Missing block: B:57:0x00ee, code skipped:
            r1 = "";
     */
    /* JADX WARNING: Missing block: B:58:0x00f4, code skipped:
            r1 = com.tencent.p177mm.vfs.C5736j.m8648k(r3, true, true);
     */
    /* JADX WARNING: Missing block: B:59:0x00fb, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(54521);
     */
    /* JADX WARNING: Missing block: B:60:0x0100, code skipped:
            r0 = r3;
     */
    /* JADX WARNING: Missing block: B:70:?, code skipped:
            return r14;
     */
    /* JADX WARNING: Missing block: B:71:?, code skipped:
            return r14;
     */
    /* JADX WARNING: Missing block: B:72:?, code skipped:
            return r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C5718d mo11633a(Uri uri, C5718d c5718d) {
        AppMethodBeat.m2504i(54521);
        synchronized (this.mLock) {
            if (c5718d != null) {
                try {
                    if (c5718d.bal == this.Cad) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(54521);
                }
            }
            HashMap hashMap = this.zYT;
            ArrayList arrayList = this.zZl;
            FileSystem fileSystem = this.Cac;
            int i = this.Cad;
            c5718d = this.Cae;
        }
        return c5718d;
    }

    /* renamed from: a */
    static String m8598a(C5718d c5718d, boolean z, boolean z2) {
        AppMethodBeat.m2504i(54522);
        int aiR = c5718d.zZs.aiR();
        if (z2 && (aiR & 4) == 0) {
            AppMethodBeat.m2505o(54522);
            return null;
        } else if (z2 || (aiR & 2) != 0) {
            String O = c5718d.zZs.mo11610O(c5718d.path, z);
            AppMethodBeat.m2505o(54522);
            return O;
        } else {
            AppMethodBeat.m2505o(54522);
            return null;
        }
    }

    /* renamed from: a */
    static RandomAccessFile m8597a(C5718d c5718d, boolean z) {
        AppMethodBeat.m2504i(54523);
        String a = FileSystemManager.m8598a(c5718d, z, false);
        if (a == null) {
            AppMethodBeat.m2505o(54523);
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(a, z ? "rw" : "r");
        AppMethodBeat.m2505o(54523);
        return randomAccessFile;
    }

    public final C5715a ens() {
        AppMethodBeat.m2504i(54524);
        C5715a c5715a = new C5715a();
        AppMethodBeat.m2505o(54524);
        return c5715a;
    }

    public final void ent() {
        HashMap hashMap;
        TreeMap treeMap;
        HashMap hashMap2;
        FileSystem fileSystem;
        AppMethodBeat.m2504i(54525);
        synchronized (this.mLock) {
            try {
                hashMap = this.zYT;
                treeMap = this.zYU;
                hashMap2 = this.zYW;
                fileSystem = this.Cac;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(54525);
            }
        }
        m8602a(hashMap, treeMap, hashMap2, fileSystem);
    }

    private FileSystemManager() {
        AppMethodBeat.m2504i(54526);
        this.mLock = new Object();
        this.Caf = new HashMap();
        Context context = sContext;
        if (context == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
            AppMethodBeat.m2505o(54526);
            throw illegalStateException;
        }
        this.Cai = new File(context.getCacheDir(), ".vfs");
        this.Caj = new HandlerThread("VFS.Maintenance", 4);
        this.Caj.start();
        this.Cal = new Handler(this.Caj.getLooper(), this);
        this.Cak = new MaintenanceBroadcastReceiver(this, (byte) 0);
        this.Cam = -1;
        this.Can = Long.MAX_VALUE;
        this.Cap = true;
        this.Cag = new RawFileSystem("", (byte) 0);
        this.Cah = new AssetsFileSystem(context);
        this.Cad = 0;
        this.zYT = new HashMap();
        this.zYU = new TreeMap();
        this.zZl = new ArrayList();
        this.zYW = new HashMap();
        this.Cac = this.Cag;
        this.Cae = new C5718d(null, null, this.Cad, (byte) 0);
        m8609io(context);
        AppMethodBeat.m2505o(54526);
    }

    /* renamed from: aC */
    private void m8604aC(Bundle bundle) {
        FileSystem fileSystem;
        AppMethodBeat.m2504i(54527);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getInt("pid") == Process.myPid()) {
            synchronized (this.mLock) {
                try {
                    if (this.Cac != null) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(54527);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("fs");
        Map hashMap = new HashMap();
        if (bundle2 != null) {
            bundle2.setClassLoader(bundle.getClassLoader());
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.getParcelable(str));
            }
        }
        bundle2 = bundle.getBundle("mp");
        Map treeMap = new TreeMap();
        if (bundle2 != null) {
            bundle2.setClassLoader(bundle.getClassLoader());
            for (String str2 : bundle2.keySet()) {
                treeMap.put(str2, bundle2.getString(str2));
            }
        }
        bundle2 = bundle.getBundle("env");
        Map hashMap2 = new HashMap();
        if (bundle2 != null) {
            for (String str22 : bundle2.keySet()) {
                hashMap2.put(str22, bundle2.getString(str22));
            }
        }
        FileSystem fileSystem2 = (FileSystem) bundle.getParcelable("root");
        if (fileSystem2 == null) {
            fileSystem = this.Cag;
        } else {
            fileSystem = fileSystem2;
        }
        Map hashMap3 = new HashMap(this.Caf);
        hashMap3.putAll(hashMap2);
        ArrayList a = FileSystemManager.m8599a((HashMap) hashMap, (TreeMap) treeMap, hashMap3);
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        synchronized (this.mLock) {
            try {
                this.zYT = hashMap;
                this.zYU = treeMap;
                this.zZl = a;
                this.zYW = hashMap2;
                this.Cac = fileSystem;
                this.Cad++;
                this.Cae = new C5718d(null, null, this.Cad, (byte) 0);
                this.Cac.mo11616p(unmodifiableMap);
                for (FileSystem fileSystem22 : hashMap.values()) {
                    fileSystem22.mo11616p(unmodifiableMap);
                }
            } finally {
                AppMethodBeat.m2505o(54527);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("[File systems]\n");
        FileSystemManager.m8603a(hashMap, stringBuilder);
        stringBuilder.append("[Mount points]\n");
        FileSystemManager.m8603a(treeMap, stringBuilder);
        stringBuilder.append("[Environment]\n");
        FileSystemManager.m8603a(hashMap2, stringBuilder);
        stringBuilder.append("[Root]\n  ").append(fileSystem.toString()).append(10);
        C0926b.m2105i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + stringBuilder.toString());
    }

    /* renamed from: e */
    private static <K, V> void m8608e(Map<K, V> map, Map<K, V> map2) {
        AppMethodBeat.m2504i(54528);
        for (Entry entry : map2.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        AppMethodBeat.m2505o(54528);
    }

    /* renamed from: a */
    private static <K, V> void m8603a(Map<K, V> map, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(54529);
        for (Entry entry : map.entrySet()) {
            stringBuilder.append("  ").append(entry.getKey().toString());
            if (entry.getValue() == null) {
                stringBuilder.append(" (deleted)\n");
            } else {
                stringBuilder.append(" => ").append(entry.getValue().toString()).append(10);
            }
        }
        AppMethodBeat.m2505o(54529);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125 A:{SYNTHETIC, Splitter:B:27:0x0125} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012f A:{SYNTHETIC, Splitter:B:33:0x012f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m8602a(HashMap<String, FileSystem> hashMap, TreeMap<String, String> treeMap, HashMap<String, String> hashMap2, FileSystem fileSystem) {
        IOException e;
        Context context;
        Intent intent;
        Throwable th;
        AppMethodBeat.m2504i(54530);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        for (Entry entry : hashMap.entrySet()) {
            bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        bundle.putBundle("fs", bundle2);
        bundle2 = new Bundle();
        for (Entry entry2 : treeMap.entrySet()) {
            bundle2.putString((String) entry2.getKey(), (String) entry2.getValue());
        }
        bundle.putBundle("mp", bundle2);
        bundle2 = new Bundle();
        for (Entry entry22 : hashMap2.entrySet()) {
            bundle2.putString((String) entry22.getKey(), (String) entry22.getValue());
        }
        bundle.putBundle("env", bundle2);
        bundle.putParcelable("root", fileSystem);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(this.Cai, "fs.bin")));
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.write(marshall);
                try {
                    dataOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C0926b.m2103e("VFS.FileSystemManager", "Cannot write parcel file: " + e.getMessage());
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    context = sContext;
                    intent = new Intent(context.getPackageName() + ".REFRESH_VFS");
                    intent.putExtras(bundle);
                    intent.putExtra("pid", Process.myPid());
                    context.sendBroadcast(intent);
                    C0926b.m2105i("VFS.FileSystemManager", "File system changes published.");
                    AppMethodBeat.m2505o(54530);
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(54530);
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            dataOutputStream = null;
            C0926b.m2103e("VFS.FileSystemManager", "Cannot write parcel file: " + e.getMessage());
            if (dataOutputStream != null) {
            }
            context = sContext;
            intent = new Intent(context.getPackageName() + ".REFRESH_VFS");
            intent.putExtras(bundle);
            intent.putExtra("pid", Process.myPid());
            context.sendBroadcast(intent);
            C0926b.m2105i("VFS.FileSystemManager", "File system changes published.");
            AppMethodBeat.m2505o(54530);
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(54530);
            throw th;
        }
        context = sContext;
        intent = new Intent(context.getPackageName() + ".REFRESH_VFS");
        intent.putExtras(bundle);
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent);
        C0926b.m2105i("VFS.FileSystemManager", "File system changes published.");
        AppMethodBeat.m2505o(54530);
    }

    /* renamed from: a */
    private static ArrayList<C5717c> m8599a(HashMap<String, FileSystem> hashMap, TreeMap<String, String> treeMap, Map<String, String> map) {
        AppMethodBeat.m2504i(54531);
        ArrayList arrayList = new ArrayList(treeMap.size());
        String str = null;
        for (Entry entry : treeMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            FileSystem fileSystem = (FileSystem) hashMap.get(str3);
            if (fileSystem == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("FileSystem '" + str3 + "' for mount point '" + str2 + "' not exist.");
                AppMethodBeat.m2505o(54531);
                throw illegalArgumentException;
            }
            str2 = C5736j.m8646H(str2, map);
            if (str2 != null) {
                boolean z = str != null && str2.startsWith(str);
                arrayList.add(new C5717c(str2, str3, fileSystem, z));
                str = str2;
            }
        }
        AppMethodBeat.m2505o(54531);
        return arrayList;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(54532);
        switch (message.what) {
            case 1:
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(FileSystem.class.getClassLoader());
                C0926b.m2105i("VFS.FileSystemManager", "Refresh file system from broadcast.");
                try {
                    m8604aC(intent.getExtras());
                } catch (RuntimeException e) {
                    C0926b.m2098b("VFS.FileSystemManager", e, "Failed to refresh file system from broadcast.");
                }
                AppMethodBeat.m2505o(54532);
                return true;
            case 2:
                CancellationSignal cancellationSignal = (CancellationSignal) message.obj;
                long j = this.Can;
                File file = new File(this.Cai, "maintain.timestamp");
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    C0926b.m2106i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(file.lastModified()), Long.valueOf(j));
                } else {
                    boolean z;
                    WakeLock newWakeLock;
                    Context context = sContext;
                    boolean z2 = this.Cao;
                    if (z2) {
                        z = context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0;
                    } else {
                        z = z2;
                    }
                    synchronized (this.mLock) {
                        try {
                            HashMap hashMap = this.zYT;
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(54532);
                                break;
                            }
                        }
                    }
                    if (z) {
                        newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");
                    } else {
                        newWakeLock = null;
                    }
                    try {
                        C0926b.m2105i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(z)));
                        if (newWakeLock != null) {
                            newWakeLock.acquire(1200000);
                        }
                        for (Entry entry : hashMap.entrySet()) {
                            FileSystem fileSystem = (FileSystem) entry.getValue();
                            C0926b.m2105i("VFS.FileSystemManager", "[Maintenance] " + ((String) entry.getKey()) + " => " + fileSystem.toString());
                            fileSystem.mo11611a(cancellationSignal);
                        }
                        file.createNewFile();
                        file.setLastModified(System.currentTimeMillis());
                        C0926b.m2105i("VFS.FileSystemManager", "Maintenance finished.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                    } catch (OperationCanceledException e2) {
                        C0926b.m2105i("VFS.FileSystemManager", "Maintenance cancelled.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                    } catch (Exception e3) {
                        C0926b.m2098b("VFS.FileSystemManager", e3, "Maintenance failed.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                    } catch (Throwable th2) {
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                        AppMethodBeat.m2505o(54532);
                    }
                }
                AppMethodBeat.m2505o(54532);
                return true;
            default:
                AppMethodBeat.m2505o(54532);
                return false;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x00e2=Splitter:B:40:0x00e2, B:24:0x00ac=Splitter:B:24:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011d A:{SYNTHETIC, Splitter:B:49:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0111 A:{SYNTHETIC, Splitter:B:43:0x0111} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    static /* synthetic */ void m8606c(FileSystemManager fileSystemManager) {
        Context context;
        BroadcastReceiver broadcastReceiver;
        Throwable th;
        Object e;
        int i = 0;
        AppMethodBeat.m2504i(54533);
        boolean z = zZk;
        fileSystemManager.Cai.mkdir();
        if (z) {
            Parcel obtain = Parcel.obtain();
            DataInputStream dataInputStream;
            C5735a c5735a;
            try {
                Bundle bundle;
                File file = new File(fileSystemManager.Cai, "fs.bin");
                long length = file.length();
                if (length > 1048576 || length <= 4) {
                    C0926b.m2103e("VFS.FileSystemManager", "Invalid parcel file size: ".concat(String.valueOf(length)));
                    bundle = null;
                } else {
                    int i2 = ((int) length) - 4;
                    byte[] bArr = new byte[i2];
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        int readInt = dataInputStream.readInt();
                        if (readInt != 1) {
                            c5735a = new C5735a(FileSystemManager.class, readInt);
                            AppMethodBeat.m2505o(54533);
                            throw c5735a;
                        }
                        while (i < i2) {
                            i += dataInputStream.read(bArr, i, i2 - i);
                        }
                        dataInputStream.close();
                        obtain.unmarshall(bArr, 0, i);
                        obtain.setDataPosition(0);
                        bundle = obtain.readBundle(FileSystem.class.getClassLoader());
                    } catch (C5735a e2) {
                        c5735a = e2;
                        try {
                            C0926b.m2105i("VFS.FileSystemManager", c5735a.getMessage());
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            obtain.recycle();
                            context = sContext;
                            broadcastReceiver = fileSystemManager.Caq;
                            if (broadcastReceiver == null) {
                            }
                            context.unregisterReceiver(broadcastReceiver);
                            fileSystemManager.Caq = null;
                            C0926b.m2105i("VFS.FileSystemManager", "Broadcast receiving disabled.");
                            AppMethodBeat.m2505o(54533);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataInputStream != null) {
                            }
                            obtain.recycle();
                            AppMethodBeat.m2505o(54533);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        C0926b.m2103e("VFS.FileSystemManager", "Cannot load file systems from parcel: [" + e.getClass().getName() + "]: " + e.getMessage());
                        if (dataInputStream != null) {
                        }
                        obtain.recycle();
                        context = sContext;
                        broadcastReceiver = fileSystemManager.Caq;
                        if (broadcastReceiver == null) {
                        }
                        context.unregisterReceiver(broadcastReceiver);
                        fileSystemManager.Caq = null;
                        C0926b.m2105i("VFS.FileSystemManager", "Broadcast receiving disabled.");
                        AppMethodBeat.m2505o(54533);
                        return;
                    }
                }
                fileSystemManager.m8604aC(bundle);
                obtain.recycle();
            } catch (C5735a e5) {
                c5735a = e5;
                dataInputStream = null;
            } catch (Exception e6) {
                e = e6;
                dataInputStream = null;
                C0926b.m2103e("VFS.FileSystemManager", "Cannot load file systems from parcel: [" + e.getClass().getName() + "]: " + e.getMessage());
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e7) {
                    }
                }
                obtain.recycle();
                context = sContext;
                broadcastReceiver = fileSystemManager.Caq;
                if (broadcastReceiver == null) {
                }
                context.unregisterReceiver(broadcastReceiver);
                fileSystemManager.Caq = null;
                C0926b.m2105i("VFS.FileSystemManager", "Broadcast receiving disabled.");
                AppMethodBeat.m2505o(54533);
                return;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e8) {
                    }
                }
                obtain.recycle();
                AppMethodBeat.m2505o(54533);
                throw th;
            }
        }
        context = sContext;
        broadcastReceiver = fileSystemManager.Caq;
        if (broadcastReceiver == null || !z) {
            if (!(broadcastReceiver == null || z)) {
                context.unregisterReceiver(broadcastReceiver);
                fileSystemManager.Caq = null;
                C0926b.m2105i("VFS.FileSystemManager", "Broadcast receiving disabled.");
            }
            AppMethodBeat.m2505o(54533);
            return;
        }
        C57141 c57141 = new C57141();
        fileSystemManager.Caq = c57141;
        context.registerReceiver(c57141, new IntentFilter(context.getPackageName() + ".REFRESH_VFS"), WXApp.WXAPP_BROADCAST_PERMISSION, null);
        C0926b.m2105i("VFS.FileSystemManager", "Broadcast receiving enabled.");
        AppMethodBeat.m2505o(54533);
    }

    /* renamed from: a */
    static /* synthetic */ void m8601a(FileSystemManager fileSystemManager, HashMap hashMap, TreeMap treeMap, HashMap hashMap2, FileSystem fileSystem, boolean z, boolean z2) {
        Map map;
        TreeMap treeMap2;
        HashMap hashMap3;
        FileSystem fileSystem2;
        int i;
        HashMap hashMap4;
        TreeMap treeMap3;
        Map hashMap5;
        FileSystem fileSystem3;
        ArrayList a;
        AppMethodBeat.m2504i(54534);
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("[CLEAN ALL]\n");
        }
        if (!hashMap.isEmpty()) {
            stringBuilder.append("[File systems]\n");
            FileSystemManager.m8603a((Map) hashMap, stringBuilder);
        }
        if (!treeMap.isEmpty()) {
            stringBuilder.append("[Mount points]\n");
            FileSystemManager.m8603a((Map) treeMap, stringBuilder);
        }
        if (!hashMap2.isEmpty()) {
            stringBuilder.append("[Environment]\n");
            FileSystemManager.m8603a((Map) hashMap2, stringBuilder);
        }
        if (fileSystem != null) {
            stringBuilder.append("[Root]\n  ").append(fileSystem).append(10);
        }
        C0926b.m2105i("VFS.FileSystemManager", "File system configuration changed:\n" + stringBuilder.toString());
        synchronized (fileSystemManager.mLock) {
            try {
                map = fileSystemManager.zYT;
                treeMap2 = fileSystemManager.zYU;
                hashMap3 = fileSystemManager.zYW;
                fileSystem2 = fileSystemManager.Cac;
                i = fileSystemManager.Cad;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(54534);
                }
            }
        }
        int i2 = i;
        Map map2 = hashMap3;
        SortedMap sortedMap = treeMap2;
        while (true) {
            if (z) {
                hashMap4 = new HashMap();
                treeMap3 = new TreeMap();
                hashMap5 = new HashMap();
                fileSystem2 = null;
            } else {
                hashMap4 = new HashMap(map);
                treeMap3 = new TreeMap(sortedMap);
                hashMap5 = new HashMap(map2);
            }
            FileSystemManager.m8608e(hashMap4, hashMap);
            FileSystemManager.m8608e(treeMap3, treeMap);
            FileSystemManager.m8608e(hashMap5, hashMap2);
            if (fileSystem != null) {
                fileSystem3 = fileSystem;
            } else if (fileSystem2 == null) {
                fileSystem3 = fileSystemManager.Cag;
            } else {
                fileSystem3 = fileSystem2;
            }
            Map hashMap6 = new HashMap(fileSystemManager.Caf);
            hashMap6.putAll(hashMap5);
            a = FileSystemManager.m8599a(hashMap4, treeMap3, hashMap6);
            map = Collections.unmodifiableMap(hashMap6);
            synchronized (fileSystemManager.mLock) {
                try {
                    if (i2 == fileSystemManager.Cad) {
                        break;
                    }
                    map = fileSystemManager.zYT;
                    treeMap2 = fileSystemManager.zYU;
                    hashMap3 = fileSystemManager.zYW;
                    fileSystem2 = fileSystemManager.Cac;
                    i = fileSystemManager.Cad;
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(54534);
                }
            }
            i2 = i;
            Object map22 = hashMap3;
            Object sortedMap2 = treeMap2;
        }
        fileSystemManager.zYT = hashMap4;
        fileSystemManager.zYU = treeMap3;
        fileSystemManager.zZl = a;
        fileSystemManager.zYW = hashMap5;
        fileSystemManager.Cac = fileSystem3;
        fileSystemManager.Cad = i2 + 1;
        fileSystemManager.Cae = new C5718d(null, null, fileSystemManager.Cad, (byte) 0);
        fileSystemManager.Cac.mo11616p(map);
        for (FileSystem fileSystem22 : hashMap4.values()) {
            fileSystem22.mo11616p(map);
        }
        if (z2) {
            fileSystemManager.m8602a(hashMap4, treeMap3, hashMap5, fileSystem3);
        }
        AppMethodBeat.m2505o(54534);
    }
}
