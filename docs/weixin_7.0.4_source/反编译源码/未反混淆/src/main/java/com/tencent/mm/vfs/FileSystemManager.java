package com.tencent.mm.vfs;

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
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
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

public final class FileSystemManager implements Callback {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context sContext = null;
    private static volatile b zZj = null;
    private static volatile boolean zZk = true;
    private FileSystem Cac;
    private int Cad;
    private d Cae;
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
    private ArrayList<c> zZl;

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
            AppMethodBeat.i(54514);
            String action = intent.getAction();
            if (action == null) {
                AppMethodBeat.o(54514);
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
            com.tencent.e.a.b.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.jZS + ", interactive = " + this.jZT);
            if (this.jZS && !this.jZT && this.zZp == null) {
                long a = FileSystemManager.this.Cam;
                if (a >= 0) {
                    this.zZp = new CancellationSignal();
                    FileSystemManager.this.Cal.sendMessageDelayed(Message.obtain(FileSystemManager.this.Cal, 2, this.zZp), a);
                    com.tencent.e.a.b.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + (a / 1000) + " seconds.");
                    AppMethodBeat.o(54514);
                    return;
                }
            } else if ((!this.jZS || this.jZT) && this.zZp != null) {
                FileSystemManager.this.Cal.removeMessages(2);
                this.zZp.cancel();
                this.zZp = null;
                com.tencent.e.a.b.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
            }
            AppMethodBeat.o(54514);
        }
    }

    public final class a {
        public final HashMap<String, FileSystem> zYT = new HashMap();
        public final TreeMap<String, String> zYU = new TreeMap();
        public final HashMap<String, String> zYW = new HashMap();
        public FileSystem zZn = null;
        public boolean zZo = false;

        public a() {
            AppMethodBeat.i(54508);
            AppMethodBeat.o(54508);
        }

        public final a a(String str, FileSystem fileSystem) {
            AppMethodBeat.i(54509);
            this.zYT.put(str, fileSystem);
            AppMethodBeat.o(54509);
            return this;
        }

        public final a iq(String str, String str2) {
            AppMethodBeat.i(54510);
            this.zYU.put(str, str2);
            AppMethodBeat.o(54510);
            return this;
        }

        public final a ir(String str, String str2) {
            AppMethodBeat.i(54511);
            this.zYW.put(str, str2);
            AppMethodBeat.o(54511);
            return this;
        }

        public final void commit() {
            AppMethodBeat.i(54512);
            ri(FileSystemManager.this.Cap);
            AppMethodBeat.o(54512);
        }

        public final void ri(boolean z) {
            AppMethodBeat.i(54513);
            FileSystemManager.a(FileSystemManager.this, this.zYT, this.zYU, this.zYW, this.zZn, this.zZo, z);
            this.zYT.clear();
            this.zYU.clear();
            this.zYW.clear();
            this.zZo = false;
            AppMethodBeat.o(54513);
        }
    }

    public interface b {
        Key e(String str, Map<String, String> map);
    }

    static final class c implements Comparable<String> {
        final String zZq;
        final String zZr;
        final FileSystem zZs;
        final boolean zZt;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.i(54515);
            int compareTo = this.zZq.compareTo((String) obj);
            AppMethodBeat.o(54515);
            return compareTo;
        }

        c(String str, String str2, FileSystem fileSystem, boolean z) {
            this.zZq = str;
            this.zZr = str2;
            this.zZs = fileSystem;
            this.zZt = z;
        }
    }

    public static final class d {
        final int bal;
        public final String path;
        public final FileSystem zZs;

        /* synthetic */ d(FileSystem fileSystem, String str, int i, byte b) {
            this(fileSystem, str, i);
        }

        private d(FileSystem fileSystem, String str, int i) {
            this.zZs = fileSystem;
            this.path = str;
            this.bal = i;
        }

        public final boolean valid() {
            return this.zZs != null;
        }

        public final String toString() {
            AppMethodBeat.i(54516);
            String str = this.path + " -> " + this.zZs.toString();
            AppMethodBeat.o(54516);
            return str;
        }
    }

    static final class e {
        @SuppressLint({"StaticFieldLeak"})
        static final FileSystemManager zZu;

        static {
            AppMethodBeat.i(54517);
            FileSystemManager fileSystemManager = new FileSystemManager();
            zZu = fileSystemManager;
            FileSystemManager.c(fileSystemManager);
            AppMethodBeat.o(54517);
        }
    }

    /* synthetic */ FileSystemManager(byte b) {
        this();
    }

    public static FileSystemManager dMy() {
        return e.zZu;
    }

    public static void setContext(Context context) {
        AppMethodBeat.i(54518);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        sContext = context;
        AppMethodBeat.o(54518);
    }

    public static void a(b bVar) {
        zZj = bVar;
    }

    static b enr() {
        return zZj;
    }

    public static void se(boolean z) {
        zZk = z;
    }

    private void io(Context context) {
        File externalCacheDir;
        AppMethodBeat.i(54519);
        this.Caf.put("data", context.getCacheDir().getParent());
        this.Caf.put("dataCache", context.getCacheDir().getPath());
        try {
            externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                this.Caf.put("extData", externalCacheDir.getParent());
                this.Caf.put("extCache", externalCacheDir.getPath());
            }
        } catch (Exception e) {
            com.tencent.e.a.b.b("VFS.FileSystemManager", e, "Cannot get external cache directory.");
        }
        externalCacheDir = Environment.getExternalStorageDirectory();
        if (externalCacheDir != null) {
            this.Caf.put("storage", externalCacheDir.getPath());
        }
        com.tencent.e.a.b.i("VFS.FileSystemManager", "Static environment:");
        for (Entry entry : this.Caf.entrySet()) {
            com.tencent.e.a.b.i("VFS.FileSystemManager", "  " + ((String) entry.getKey()) + " => " + ((String) entry.getValue()));
        }
        AppMethodBeat.o(54519);
    }

    private static String awW(String str) {
        AppMethodBeat.i(54520);
        File file = new File(str);
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
            AppMethodBeat.o(54520);
            return canonicalPath;
        } catch (IOException e) {
            canonicalPath = file.getAbsolutePath();
            AppMethodBeat.o(54520);
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(54521);
     */
    /* JADX WARNING: Missing block: B:22:0x004b, code skipped:
            r3 = awW(r3);
            r0 = java.util.Collections.binarySearch(r5, r3);
     */
    /* JADX WARNING: Missing block: B:23:0x0053, code skipped:
            if (r0 < 0) goto L_0x006a;
     */
    /* JADX WARNING: Missing block: B:24:0x0055, code skipped:
            r2 = ((com.tencent.mm.vfs.FileSystemManager.c) r5.get(r0)).zZs;
            r1 = "";
     */
    /* JADX WARNING: Missing block: B:25:0x0061, code skipped:
            r14 = new com.tencent.mm.vfs.FileSystemManager.d(r2, r1, r6, (byte) 0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(54521);
     */
    /* JADX WARNING: Missing block: B:26:0x006a, code skipped:
            r2 = (-r0) - 2;
     */
    /* JADX WARNING: Missing block: B:27:0x006d, code skipped:
            if (r2 < 0) goto L_0x0098;
     */
    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            r0 = (com.tencent.mm.vfs.FileSystemManager.c) r5.get(r2);
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
            r0 = (com.tencent.mm.vfs.FileSystemManager.c) r5.get(r2);
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
            r0 = (com.tencent.mm.vfs.FileSystem) r0.get(r13.getAuthority());
     */
    /* JADX WARNING: Missing block: B:50:0x00d4, code skipped:
            if (r3 != null) goto L_0x00db;
     */
    /* JADX WARNING: Missing block: B:51:0x00d6, code skipped:
            r1 = "";
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:52:0x00db, code skipped:
            r1 = com.tencent.mm.vfs.j.k(r3, true, true);
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
            r1 = com.tencent.mm.vfs.j.k(r3, true, true);
     */
    /* JADX WARNING: Missing block: B:59:0x00fb, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(54521);
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
    public final d a(Uri uri, d dVar) {
        AppMethodBeat.i(54521);
        synchronized (this.mLock) {
            if (dVar != null) {
                try {
                    if (dVar.bal == this.Cad) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(54521);
                }
            }
            HashMap hashMap = this.zYT;
            ArrayList arrayList = this.zZl;
            FileSystem fileSystem = this.Cac;
            int i = this.Cad;
            dVar = this.Cae;
        }
        return dVar;
    }

    static String a(d dVar, boolean z, boolean z2) {
        AppMethodBeat.i(54522);
        int aiR = dVar.zZs.aiR();
        if (z2 && (aiR & 4) == 0) {
            AppMethodBeat.o(54522);
            return null;
        } else if (z2 || (aiR & 2) != 0) {
            String O = dVar.zZs.O(dVar.path, z);
            AppMethodBeat.o(54522);
            return O;
        } else {
            AppMethodBeat.o(54522);
            return null;
        }
    }

    static RandomAccessFile a(d dVar, boolean z) {
        AppMethodBeat.i(54523);
        String a = a(dVar, z, false);
        if (a == null) {
            AppMethodBeat.o(54523);
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(a, z ? "rw" : "r");
        AppMethodBeat.o(54523);
        return randomAccessFile;
    }

    public final a ens() {
        AppMethodBeat.i(54524);
        a aVar = new a();
        AppMethodBeat.o(54524);
        return aVar;
    }

    public final void ent() {
        HashMap hashMap;
        TreeMap treeMap;
        HashMap hashMap2;
        FileSystem fileSystem;
        AppMethodBeat.i(54525);
        synchronized (this.mLock) {
            try {
                hashMap = this.zYT;
                treeMap = this.zYU;
                hashMap2 = this.zYW;
                fileSystem = this.Cac;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(54525);
            }
        }
        a(hashMap, treeMap, hashMap2, fileSystem);
    }

    private FileSystemManager() {
        AppMethodBeat.i(54526);
        this.mLock = new Object();
        this.Caf = new HashMap();
        Context context = sContext;
        if (context == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
            AppMethodBeat.o(54526);
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
        this.Cae = new d(null, null, this.Cad, (byte) 0);
        io(context);
        AppMethodBeat.o(54526);
    }

    private void aC(Bundle bundle) {
        FileSystem fileSystem;
        AppMethodBeat.i(54527);
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
                    AppMethodBeat.o(54527);
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
        ArrayList a = a((HashMap) hashMap, (TreeMap) treeMap, hashMap3);
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        synchronized (this.mLock) {
            try {
                this.zYT = hashMap;
                this.zYU = treeMap;
                this.zZl = a;
                this.zYW = hashMap2;
                this.Cac = fileSystem;
                this.Cad++;
                this.Cae = new d(null, null, this.Cad, (byte) 0);
                this.Cac.p(unmodifiableMap);
                for (FileSystem fileSystem22 : hashMap.values()) {
                    fileSystem22.p(unmodifiableMap);
                }
            } finally {
                AppMethodBeat.o(54527);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("[File systems]\n");
        a(hashMap, stringBuilder);
        stringBuilder.append("[Mount points]\n");
        a(treeMap, stringBuilder);
        stringBuilder.append("[Environment]\n");
        a(hashMap2, stringBuilder);
        stringBuilder.append("[Root]\n  ").append(fileSystem.toString()).append(10);
        com.tencent.e.a.b.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + stringBuilder.toString());
    }

    private static <K, V> void e(Map<K, V> map, Map<K, V> map2) {
        AppMethodBeat.i(54528);
        for (Entry entry : map2.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        AppMethodBeat.o(54528);
    }

    private static <K, V> void a(Map<K, V> map, StringBuilder stringBuilder) {
        AppMethodBeat.i(54529);
        for (Entry entry : map.entrySet()) {
            stringBuilder.append("  ").append(entry.getKey().toString());
            if (entry.getValue() == null) {
                stringBuilder.append(" (deleted)\n");
            } else {
                stringBuilder.append(" => ").append(entry.getValue().toString()).append(10);
            }
        }
        AppMethodBeat.o(54529);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125 A:{SYNTHETIC, Splitter:B:27:0x0125} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012f A:{SYNTHETIC, Splitter:B:33:0x012f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(HashMap<String, FileSystem> hashMap, TreeMap<String, String> treeMap, HashMap<String, String> hashMap2, FileSystem fileSystem) {
        IOException e;
        Context context;
        Intent intent;
        Throwable th;
        AppMethodBeat.i(54530);
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
                    com.tencent.e.a.b.e("VFS.FileSystemManager", "Cannot write parcel file: " + e.getMessage());
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
                    com.tencent.e.a.b.i("VFS.FileSystemManager", "File system changes published.");
                    AppMethodBeat.o(54530);
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream != null) {
                    }
                    AppMethodBeat.o(54530);
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            dataOutputStream = null;
            com.tencent.e.a.b.e("VFS.FileSystemManager", "Cannot write parcel file: " + e.getMessage());
            if (dataOutputStream != null) {
            }
            context = sContext;
            intent = new Intent(context.getPackageName() + ".REFRESH_VFS");
            intent.putExtras(bundle);
            intent.putExtra("pid", Process.myPid());
            context.sendBroadcast(intent);
            com.tencent.e.a.b.i("VFS.FileSystemManager", "File system changes published.");
            AppMethodBeat.o(54530);
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(54530);
            throw th;
        }
        context = sContext;
        intent = new Intent(context.getPackageName() + ".REFRESH_VFS");
        intent.putExtras(bundle);
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent);
        com.tencent.e.a.b.i("VFS.FileSystemManager", "File system changes published.");
        AppMethodBeat.o(54530);
    }

    private static ArrayList<c> a(HashMap<String, FileSystem> hashMap, TreeMap<String, String> treeMap, Map<String, String> map) {
        AppMethodBeat.i(54531);
        ArrayList arrayList = new ArrayList(treeMap.size());
        String str = null;
        for (Entry entry : treeMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            FileSystem fileSystem = (FileSystem) hashMap.get(str3);
            if (fileSystem == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("FileSystem '" + str3 + "' for mount point '" + str2 + "' not exist.");
                AppMethodBeat.o(54531);
                throw illegalArgumentException;
            }
            str2 = j.H(str2, map);
            if (str2 != null) {
                boolean z = str != null && str2.startsWith(str);
                arrayList.add(new c(str2, str3, fileSystem, z));
                str = str2;
            }
        }
        AppMethodBeat.o(54531);
        return arrayList;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(54532);
        switch (message.what) {
            case 1:
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(FileSystem.class.getClassLoader());
                com.tencent.e.a.b.i("VFS.FileSystemManager", "Refresh file system from broadcast.");
                try {
                    aC(intent.getExtras());
                } catch (RuntimeException e) {
                    com.tencent.e.a.b.b("VFS.FileSystemManager", e, "Failed to refresh file system from broadcast.");
                }
                AppMethodBeat.o(54532);
                return true;
            case 2:
                CancellationSignal cancellationSignal = (CancellationSignal) message.obj;
                long j = this.Can;
                File file = new File(this.Cai, "maintain.timestamp");
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    com.tencent.e.a.b.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(file.lastModified()), Long.valueOf(j));
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
                                AppMethodBeat.o(54532);
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
                        com.tencent.e.a.b.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(z)));
                        if (newWakeLock != null) {
                            newWakeLock.acquire(1200000);
                        }
                        for (Entry entry : hashMap.entrySet()) {
                            FileSystem fileSystem = (FileSystem) entry.getValue();
                            com.tencent.e.a.b.i("VFS.FileSystemManager", "[Maintenance] " + ((String) entry.getKey()) + " => " + fileSystem.toString());
                            fileSystem.a(cancellationSignal);
                        }
                        file.createNewFile();
                        file.setLastModified(System.currentTimeMillis());
                        com.tencent.e.a.b.i("VFS.FileSystemManager", "Maintenance finished.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                    } catch (OperationCanceledException e2) {
                        com.tencent.e.a.b.i("VFS.FileSystemManager", "Maintenance cancelled.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                    } catch (Exception e3) {
                        com.tencent.e.a.b.b("VFS.FileSystemManager", e3, "Maintenance failed.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                    } catch (Throwable th2) {
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                        AppMethodBeat.o(54532);
                    }
                }
                AppMethodBeat.o(54532);
                return true;
            default:
                AppMethodBeat.o(54532);
                return false;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x00e2=Splitter:B:40:0x00e2, B:24:0x00ac=Splitter:B:24:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011d A:{SYNTHETIC, Splitter:B:49:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0111 A:{SYNTHETIC, Splitter:B:43:0x0111} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(FileSystemManager fileSystemManager) {
        Context context;
        BroadcastReceiver broadcastReceiver;
        Throwable th;
        Object e;
        int i = 0;
        AppMethodBeat.i(54533);
        boolean z = zZk;
        fileSystemManager.Cai.mkdir();
        if (z) {
            Parcel obtain = Parcel.obtain();
            DataInputStream dataInputStream;
            a aVar;
            try {
                Bundle bundle;
                File file = new File(fileSystemManager.Cai, "fs.bin");
                long length = file.length();
                if (length > 1048576 || length <= 4) {
                    com.tencent.e.a.b.e("VFS.FileSystemManager", "Invalid parcel file size: ".concat(String.valueOf(length)));
                    bundle = null;
                } else {
                    int i2 = ((int) length) - 4;
                    byte[] bArr = new byte[i2];
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        int readInt = dataInputStream.readInt();
                        if (readInt != 1) {
                            aVar = new a(FileSystemManager.class, readInt);
                            AppMethodBeat.o(54533);
                            throw aVar;
                        }
                        while (i < i2) {
                            i += dataInputStream.read(bArr, i, i2 - i);
                        }
                        dataInputStream.close();
                        obtain.unmarshall(bArr, 0, i);
                        obtain.setDataPosition(0);
                        bundle = obtain.readBundle(FileSystem.class.getClassLoader());
                    } catch (a e2) {
                        aVar = e2;
                        try {
                            com.tencent.e.a.b.i("VFS.FileSystemManager", aVar.getMessage());
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
                            com.tencent.e.a.b.i("VFS.FileSystemManager", "Broadcast receiving disabled.");
                            AppMethodBeat.o(54533);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataInputStream != null) {
                            }
                            obtain.recycle();
                            AppMethodBeat.o(54533);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.tencent.e.a.b.e("VFS.FileSystemManager", "Cannot load file systems from parcel: [" + e.getClass().getName() + "]: " + e.getMessage());
                        if (dataInputStream != null) {
                        }
                        obtain.recycle();
                        context = sContext;
                        broadcastReceiver = fileSystemManager.Caq;
                        if (broadcastReceiver == null) {
                        }
                        context.unregisterReceiver(broadcastReceiver);
                        fileSystemManager.Caq = null;
                        com.tencent.e.a.b.i("VFS.FileSystemManager", "Broadcast receiving disabled.");
                        AppMethodBeat.o(54533);
                        return;
                    }
                }
                fileSystemManager.aC(bundle);
                obtain.recycle();
            } catch (a e5) {
                aVar = e5;
                dataInputStream = null;
            } catch (Exception e6) {
                e = e6;
                dataInputStream = null;
                com.tencent.e.a.b.e("VFS.FileSystemManager", "Cannot load file systems from parcel: [" + e.getClass().getName() + "]: " + e.getMessage());
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
                com.tencent.e.a.b.i("VFS.FileSystemManager", "Broadcast receiving disabled.");
                AppMethodBeat.o(54533);
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
                AppMethodBeat.o(54533);
                throw th;
            }
        }
        context = sContext;
        broadcastReceiver = fileSystemManager.Caq;
        if (broadcastReceiver == null || !z) {
            if (!(broadcastReceiver == null || z)) {
                context.unregisterReceiver(broadcastReceiver);
                fileSystemManager.Caq = null;
                com.tencent.e.a.b.i("VFS.FileSystemManager", "Broadcast receiving disabled.");
            }
            AppMethodBeat.o(54533);
            return;
        }
        AnonymousClass1 anonymousClass1 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(54507);
                FileSystemManager.this.Cal.sendMessageAtFrontOfQueue(Message.obtain(FileSystemManager.this.Cal, 1, intent));
                AppMethodBeat.o(54507);
            }
        };
        fileSystemManager.Caq = anonymousClass1;
        context.registerReceiver(anonymousClass1, new IntentFilter(context.getPackageName() + ".REFRESH_VFS"), WXApp.WXAPP_BROADCAST_PERMISSION, null);
        com.tencent.e.a.b.i("VFS.FileSystemManager", "Broadcast receiving enabled.");
        AppMethodBeat.o(54533);
    }

    static /* synthetic */ void a(FileSystemManager fileSystemManager, HashMap hashMap, TreeMap treeMap, HashMap hashMap2, FileSystem fileSystem, boolean z, boolean z2) {
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
        AppMethodBeat.i(54534);
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("[CLEAN ALL]\n");
        }
        if (!hashMap.isEmpty()) {
            stringBuilder.append("[File systems]\n");
            a((Map) hashMap, stringBuilder);
        }
        if (!treeMap.isEmpty()) {
            stringBuilder.append("[Mount points]\n");
            a((Map) treeMap, stringBuilder);
        }
        if (!hashMap2.isEmpty()) {
            stringBuilder.append("[Environment]\n");
            a((Map) hashMap2, stringBuilder);
        }
        if (fileSystem != null) {
            stringBuilder.append("[Root]\n  ").append(fileSystem).append(10);
        }
        com.tencent.e.a.b.i("VFS.FileSystemManager", "File system configuration changed:\n" + stringBuilder.toString());
        synchronized (fileSystemManager.mLock) {
            try {
                map = fileSystemManager.zYT;
                treeMap2 = fileSystemManager.zYU;
                hashMap3 = fileSystemManager.zYW;
                fileSystem2 = fileSystemManager.Cac;
                i = fileSystemManager.Cad;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(54534);
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
            e(hashMap4, hashMap);
            e(treeMap3, treeMap);
            e(hashMap5, hashMap2);
            if (fileSystem != null) {
                fileSystem3 = fileSystem;
            } else if (fileSystem2 == null) {
                fileSystem3 = fileSystemManager.Cag;
            } else {
                fileSystem3 = fileSystem2;
            }
            Map hashMap6 = new HashMap(fileSystemManager.Caf);
            hashMap6.putAll(hashMap5);
            a = a(hashMap4, treeMap3, hashMap6);
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
                    AppMethodBeat.o(54534);
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
        fileSystemManager.Cae = new d(null, null, fileSystemManager.Cad, (byte) 0);
        fileSystemManager.Cac.p(map);
        for (FileSystem fileSystem22 : hashMap4.values()) {
            fileSystem22.p(map);
        }
        if (z2) {
            fileSystemManager.a(hashMap4, treeMap3, hashMap5, fileSystem3);
        }
        AppMethodBeat.o(54534);
    }
}
