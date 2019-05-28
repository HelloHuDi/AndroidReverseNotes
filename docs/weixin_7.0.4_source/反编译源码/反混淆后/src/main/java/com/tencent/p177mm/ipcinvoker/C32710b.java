package com.tencent.p177mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p1462b.C32704a;
import com.tencent.p177mm.ipcinvoker.p1462b.C32704a.C32705a;
import com.tencent.p177mm.ipcinvoker.p1600f.C42138a;
import com.tencent.p177mm.ipcinvoker.p1600f.C42139b;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.ipcinvoker.p855h.C9552c;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.ipcinvoker.b */
public class C32710b {
    private static volatile C32710b eFJ;
    Map<String, Class<?>> eFK = new HashMap();
    public Map<String, C32703a> eFL = new ConcurrentHashMap();
    private volatile boolean eFM;
    Map<String, Set<C42141j>> eFN;
    private Handler mHandler;

    /* renamed from: com.tencent.mm.ipcinvoker.b$a */
    public static class C32703a {
        C32704a eFS;
        public volatile boolean eFT;
        Runnable eFU;
        ServiceConnection serviceConnection;

        private C32703a() {
        }

        /* synthetic */ C32703a(byte b) {
            this();
        }
    }

    /* renamed from: PL */
    public static C32710b m53380PL() {
        AppMethodBeat.m2504i(114011);
        if (eFJ == null) {
            synchronized (C32710b.class) {
                try {
                    if (eFJ == null) {
                        eFJ = new C32710b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114011);
                    }
                }
            }
        }
        C32710b c32710b = eFJ;
        AppMethodBeat.m2505o(114011);
        return c32710b;
    }

    private C32710b() {
        AppMethodBeat.m2504i(114012);
        HandlerThread handlerThread = new HandlerThread("IPCBridgeThread#" + hashCode());
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.eFN = new HashMap();
        AppMethodBeat.m2505o(114012);
    }

    /* renamed from: ld */
    public final C32704a mo53221ld(final String str) {
        AppMethodBeat.m2504i(114013);
        C26340b.m41917i("IPC.IPCBridgeManager", "[getIPCBridge] process:%s", str);
        C32703a c32703a = (C32703a) this.eFL.get(str);
        if (c32703a == null) {
            if (this.eFM) {
                C26340b.m41917i("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", str);
                AppMethodBeat.m2505o(114013);
                return null;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                C26340b.m41918w("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.", new Object[0]);
                AppMethodBeat.m2505o(114013);
                return null;
            } else {
                String P = C9552c.m17015P(str, C9548e.getContext().getPackageName());
                Class cls = (Class) this.eFK.get(P + IOUtils.DIR_SEPARATOR_UNIX + str);
                if (cls == null) {
                    C26340b.m41918w("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", str);
                    AppMethodBeat.m2505o(114013);
                    return null;
                }
                final C32703a c32703a2 = new C32703a();
                synchronized (this.eFL) {
                    try {
                        this.eFL.put(str, c32703a2);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(114013);
                            throw th;
                        }
                    }
                }
                synchronized (c32703a2) {
                    try {
                        c32703a2.eFT = true;
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(114013);
                            throw th2;
                        }
                    }
                }
                final Context context = C9548e.getContext();
                c32703a2.serviceConnection = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.m2504i(114007);
                        if (iBinder == null) {
                            C26340b.m41917i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", Integer.valueOf(c32703a2.hashCode()));
                            context.unbindService(c32703a2.serviceConnection);
                            C32710b.this.eFL.remove(str);
                            c32703a2.serviceConnection = null;
                            c32703a2.eFS = null;
                        } else {
                            C26340b.m41917i("IPC.IPCBridgeManager", "onServiceConnected(%s)", Integer.valueOf(c32703a2.hashCode()));
                            c32703a2.eFS = C32705a.m53375k(iBinder);
                            try {
                                iBinder.linkToDeath(new C42138a(str), 0);
                            } catch (RemoteException e) {
                                C26340b.m41916e("IPC.IPCBridgeManager", "binder register linkToDeath listener error, %s", Log.getStackTraceString(e));
                            }
                        }
                        if (c32703a2.eFU != null) {
                            C32710b.this.mHandler.removeCallbacks(c32703a2.eFU);
                        }
                        synchronized (c32703a2) {
                            try {
                                c32703a2.eFT = false;
                                c32703a2.notifyAll();
                                c32703a2.eFU = null;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(114007);
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.m2504i(114008);
                        C26340b.m41917i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", Integer.valueOf(c32703a2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                        C32710b.this.mo53223lf(str);
                        C42139b.m74293lk(str);
                        C32710b.m53382a(C32710b.this, str);
                        AppMethodBeat.m2505o(114008);
                    }
                };
                try {
                    long j;
                    C26340b.m41917i("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s)", Integer.valueOf(c32703a2.hashCode()), Long.valueOf(Thread.currentThread().getId()), new Intent().setClassName(P, cls.getCanonicalName()));
                    context.bindService(r0, c32703a2.serviceConnection, 33);
                    c32703a2.eFU = new Runnable() {
                        /* JADX WARNING: Missing block: B:12:0x0056, code skipped:
            r1 = com.tencent.p177mm.ipcinvoker.C32710b.m53381a(r7.eFQ);
     */
                        /* JADX WARNING: Missing block: B:13:0x005c, code skipped:
            monitor-enter(r1);
     */
                        /* JADX WARNING: Missing block: B:15:?, code skipped:
            com.tencent.p177mm.ipcinvoker.C32710b.m53381a(r7.eFQ).remove(r12);
     */
                        /* JADX WARNING: Missing block: B:16:0x0068, code skipped:
            monitor-exit(r1);
     */
                        /* JADX WARNING: Missing block: B:24:0x0075, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114009);
     */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            AppMethodBeat.m2504i(114009);
                            C26340b.m41917i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", Integer.valueOf(c32703a2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                            if (c32703a2.eFT) {
                                synchronized (c32703a2) {
                                    try {
                                        if (c32703a2.eFT) {
                                            c32703a2.eFT = false;
                                            c32703a2.notifyAll();
                                            c32703a2.eFU = null;
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.m2505o(114009);
                                    }
                                }
                            } else {
                                AppMethodBeat.m2505o(114009);
                            }
                        }
                    };
                    Handler handler = this.mHandler;
                    Runnable runnable = c32703a2.eFU;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        j = 3000;
                    } else {
                        j = 10000;
                    }
                    handler.postDelayed(runnable, j);
                    synchronized (c32703a2) {
                        if (c32703a2.eFT) {
                            c32703a2.wait();
                        }
                    }
                    synchronized (c32703a2) {
                        try {
                            c32703a2.eFT = false;
                        } catch (Throwable th22) {
                            while (true) {
                                AppMethodBeat.m2505o(114013);
                                throw th22;
                            }
                        }
                    }
                    c32703a = c32703a2;
                } catch (InterruptedException e) {
                    try {
                        C26340b.m41916e("IPC.IPCBridgeManager", "%s", e);
                        synchronized (this.eFL) {
                            this.eFL.remove(str);
                            synchronized (c32703a2) {
                                c32703a2.eFT = false;
                                AppMethodBeat.m2505o(114013);
                                return null;
                            }
                        }
                    } catch (Throwable th222) {
                        while (true) {
                            AppMethodBeat.m2505o(114013);
                            throw th222;
                        }
                    }
                } catch (SecurityException e2) {
                    C26340b.m41916e("IPC.IPCBridgeManager", "bindService error : %s", Log.getStackTraceString(e2));
                    synchronized (this.eFL) {
                        try {
                            this.eFL.remove(str);
                            synchronized (c32703a2) {
                                c32703a2.eFT = false;
                                AppMethodBeat.m2505o(114013);
                                return null;
                            }
                        } catch (Throwable th2222) {
                            while (true) {
                                AppMethodBeat.m2505o(114013);
                                throw th2222;
                            }
                        }
                    }
                } catch (Throwable th22222) {
                    while (true) {
                        AppMethodBeat.m2505o(114013);
                        throw th22222;
                    }
                }
            }
        } else if (c32703a.eFT) {
            try {
                synchronized (c32703a) {
                    if (c32703a.eFT) {
                        c32703a.wait();
                    }
                }
            } catch (InterruptedException e3) {
                C26340b.m41916e("IPC.IPCBridgeManager", "%s", e3);
            } catch (Throwable th3) {
                AppMethodBeat.m2505o(114013);
                throw th3;
            }
        }
        C32704a c32704a = c32703a.eFS;
        AppMethodBeat.m2505o(114013);
        return c32704a;
    }

    /* renamed from: le */
    public final boolean mo53222le(String str) {
        AppMethodBeat.m2504i(114014);
        if (C9548e.m17008lg(str)) {
            AppMethodBeat.m2505o(114014);
            return false;
        } else if (this.eFL.get(str) != null) {
            AppMethodBeat.m2505o(114014);
            return true;
        } else {
            AppMethodBeat.m2505o(114014);
            return false;
        }
    }

    /* renamed from: lf */
    public final void mo53223lf(final String str) {
        AppMethodBeat.m2504i(114015);
        if (C9548e.m17008lg(str)) {
            C26340b.m41917i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", str);
            AppMethodBeat.m2505o(114015);
            return;
        }
        final C32703a c32703a;
        synchronized (this.eFL) {
            try {
                c32703a = (C32703a) this.eFL.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114015);
            }
        }
        if (c32703a == null) {
            C26340b.m41917i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", str);
            return;
        }
        if (c32703a.eFT) {
            synchronized (c32703a) {
                try {
                    c32703a.eFT = false;
                    c32703a.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114015);
                    }
                }
            }
        }
        if (c32703a.serviceConnection == null) {
            C26340b.m41917i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
            AppMethodBeat.m2505o(114015);
            return;
        }
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(114010);
                ServiceConnection serviceConnection = c32703a.serviceConnection;
                if (serviceConnection == null) {
                    C26340b.m41917i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
                    AppMethodBeat.m2505o(114010);
                    return;
                }
                try {
                    C9548e.getContext().unbindService(serviceConnection);
                } catch (Exception e) {
                    C26340b.m41916e("IPC.IPCBridgeManager", "unbindService(%s) error, %s", str, Log.getStackTraceString(e));
                }
                synchronized (C32710b.this.eFL) {
                    try {
                        C32710b.this.eFL.remove(str);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(114010);
                    }
                }
                synchronized (c32703a) {
                    try {
                        c32703a.eFS = null;
                        c32703a.eFT = false;
                        c32703a.serviceConnection = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(114010);
                        }
                    }
                }
            }
        });
        AppMethodBeat.m2505o(114015);
    }

    /* renamed from: PM */
    public final synchronized void mo53220PM() {
        this.eFM = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m53382a(C32710b c32710b, String str) {
        AppMethodBeat.m2504i(114016);
        Set<C42141j> set = (Set) c32710b.eFN.get(str);
        if (set != null) {
            for (C42141j c42141j : set) {
                if (c42141j != null) {
                    c42141j.onDisconnect();
                }
            }
        }
        AppMethodBeat.m2505o(114016);
    }
}
