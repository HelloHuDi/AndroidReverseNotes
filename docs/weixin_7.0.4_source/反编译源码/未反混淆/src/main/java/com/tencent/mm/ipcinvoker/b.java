package com.tencent.mm.ipcinvoker;

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
import com.tencent.mm.ipcinvoker.h.c;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b {
    private static volatile b eFJ;
    Map<String, Class<?>> eFK = new HashMap();
    public Map<String, a> eFL = new ConcurrentHashMap();
    private volatile boolean eFM;
    Map<String, Set<j>> eFN;
    private Handler mHandler;

    public static class a {
        com.tencent.mm.ipcinvoker.b.a eFS;
        public volatile boolean eFT;
        Runnable eFU;
        ServiceConnection serviceConnection;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static b PL() {
        AppMethodBeat.i(114011);
        if (eFJ == null) {
            synchronized (b.class) {
                try {
                    if (eFJ == null) {
                        eFJ = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114011);
                    }
                }
            }
        }
        b bVar = eFJ;
        AppMethodBeat.o(114011);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(114012);
        HandlerThread handlerThread = new HandlerThread("IPCBridgeThread#" + hashCode());
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.eFN = new HashMap();
        AppMethodBeat.o(114012);
    }

    public final com.tencent.mm.ipcinvoker.b.a ld(final String str) {
        AppMethodBeat.i(114013);
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "[getIPCBridge] process:%s", str);
        a aVar = (a) this.eFL.get(str);
        if (aVar == null) {
            if (this.eFM) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", str);
                AppMethodBeat.o(114013);
                return null;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.", new Object[0]);
                AppMethodBeat.o(114013);
                return null;
            } else {
                String P = c.P(str, e.getContext().getPackageName());
                Class cls = (Class) this.eFK.get(P + IOUtils.DIR_SEPARATOR_UNIX + str);
                if (cls == null) {
                    com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", str);
                    AppMethodBeat.o(114013);
                    return null;
                }
                final a aVar2 = new a();
                synchronized (this.eFL) {
                    try {
                        this.eFL.put(str, aVar2);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(114013);
                            throw th;
                        }
                    }
                }
                synchronized (aVar2) {
                    try {
                        aVar2.eFT = true;
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(114013);
                            throw th2;
                        }
                    }
                }
                final Context context = e.getContext();
                aVar2.serviceConnection = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.i(114007);
                        if (iBinder == null) {
                            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", Integer.valueOf(aVar2.hashCode()));
                            context.unbindService(aVar2.serviceConnection);
                            b.this.eFL.remove(str);
                            aVar2.serviceConnection = null;
                            aVar2.eFS = null;
                        } else {
                            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", Integer.valueOf(aVar2.hashCode()));
                            aVar2.eFS = com.tencent.mm.ipcinvoker.b.a.a.k(iBinder);
                            try {
                                iBinder.linkToDeath(new com.tencent.mm.ipcinvoker.f.a(str), 0);
                            } catch (RemoteException e) {
                                com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "binder register linkToDeath listener error, %s", Log.getStackTraceString(e));
                            }
                        }
                        if (aVar2.eFU != null) {
                            b.this.mHandler.removeCallbacks(aVar2.eFU);
                        }
                        synchronized (aVar2) {
                            try {
                                aVar2.eFT = false;
                                aVar2.notifyAll();
                                aVar2.eFU = null;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(114007);
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(114008);
                        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                        b.this.lf(str);
                        com.tencent.mm.ipcinvoker.f.b.lk(str);
                        b.a(b.this, str);
                        AppMethodBeat.o(114008);
                    }
                };
                try {
                    long j;
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()), new Intent().setClassName(P, cls.getCanonicalName()));
                    context.bindService(r0, aVar2.serviceConnection, 33);
                    aVar2.eFU = new Runnable() {
                        /* JADX WARNING: Missing block: B:12:0x0056, code skipped:
            r1 = com.tencent.mm.ipcinvoker.b.a(r7.eFQ);
     */
                        /* JADX WARNING: Missing block: B:13:0x005c, code skipped:
            monitor-enter(r1);
     */
                        /* JADX WARNING: Missing block: B:15:?, code skipped:
            com.tencent.mm.ipcinvoker.b.a(r7.eFQ).remove(r12);
     */
                        /* JADX WARNING: Missing block: B:16:0x0068, code skipped:
            monitor-exit(r1);
     */
                        /* JADX WARNING: Missing block: B:24:0x0075, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(114009);
     */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            AppMethodBeat.i(114009);
                            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                            if (aVar2.eFT) {
                                synchronized (aVar2) {
                                    try {
                                        if (aVar2.eFT) {
                                            aVar2.eFT = false;
                                            aVar2.notifyAll();
                                            aVar2.eFU = null;
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(114009);
                                    }
                                }
                            } else {
                                AppMethodBeat.o(114009);
                            }
                        }
                    };
                    Handler handler = this.mHandler;
                    Runnable runnable = aVar2.eFU;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        j = 3000;
                    } else {
                        j = 10000;
                    }
                    handler.postDelayed(runnable, j);
                    synchronized (aVar2) {
                        if (aVar2.eFT) {
                            aVar2.wait();
                        }
                    }
                    synchronized (aVar2) {
                        try {
                            aVar2.eFT = false;
                        } catch (Throwable th22) {
                            while (true) {
                                AppMethodBeat.o(114013);
                                throw th22;
                            }
                        }
                    }
                    aVar = aVar2;
                } catch (InterruptedException e) {
                    try {
                        com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "%s", e);
                        synchronized (this.eFL) {
                            this.eFL.remove(str);
                            synchronized (aVar2) {
                                aVar2.eFT = false;
                                AppMethodBeat.o(114013);
                                return null;
                            }
                        }
                    } catch (Throwable th222) {
                        while (true) {
                            AppMethodBeat.o(114013);
                            throw th222;
                        }
                    }
                } catch (SecurityException e2) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "bindService error : %s", Log.getStackTraceString(e2));
                    synchronized (this.eFL) {
                        try {
                            this.eFL.remove(str);
                            synchronized (aVar2) {
                                aVar2.eFT = false;
                                AppMethodBeat.o(114013);
                                return null;
                            }
                        } catch (Throwable th2222) {
                            while (true) {
                                AppMethodBeat.o(114013);
                                throw th2222;
                            }
                        }
                    }
                } catch (Throwable th22222) {
                    while (true) {
                        AppMethodBeat.o(114013);
                        throw th22222;
                    }
                }
            }
        } else if (aVar.eFT) {
            try {
                synchronized (aVar) {
                    if (aVar.eFT) {
                        aVar.wait();
                    }
                }
            } catch (InterruptedException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "%s", e3);
            } catch (Throwable th3) {
                AppMethodBeat.o(114013);
                throw th3;
            }
        }
        com.tencent.mm.ipcinvoker.b.a aVar3 = aVar.eFS;
        AppMethodBeat.o(114013);
        return aVar3;
    }

    public final boolean le(String str) {
        AppMethodBeat.i(114014);
        if (e.lg(str)) {
            AppMethodBeat.o(114014);
            return false;
        } else if (this.eFL.get(str) != null) {
            AppMethodBeat.o(114014);
            return true;
        } else {
            AppMethodBeat.o(114014);
            return false;
        }
    }

    public final void lf(final String str) {
        AppMethodBeat.i(114015);
        if (e.lg(str)) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", str);
            AppMethodBeat.o(114015);
            return;
        }
        final a aVar;
        synchronized (this.eFL) {
            try {
                aVar = (a) this.eFL.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114015);
            }
        }
        if (aVar == null) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", str);
            return;
        }
        if (aVar.eFT) {
            synchronized (aVar) {
                try {
                    aVar.eFT = false;
                    aVar.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114015);
                    }
                }
            }
        }
        if (aVar.serviceConnection == null) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
            AppMethodBeat.o(114015);
            return;
        }
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114010);
                ServiceConnection serviceConnection = aVar.serviceConnection;
                if (serviceConnection == null) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
                    AppMethodBeat.o(114010);
                    return;
                }
                try {
                    e.getContext().unbindService(serviceConnection);
                } catch (Exception e) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "unbindService(%s) error, %s", str, Log.getStackTraceString(e));
                }
                synchronized (b.this.eFL) {
                    try {
                        b.this.eFL.remove(str);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(114010);
                    }
                }
                synchronized (aVar) {
                    try {
                        aVar.eFS = null;
                        aVar.eFT = false;
                        aVar.serviceConnection = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(114010);
                        }
                    }
                }
            }
        });
        AppMethodBeat.o(114015);
    }

    public final synchronized void PM() {
        this.eFM = true;
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(114016);
        Set<j> set = (Set) bVar.eFN.get(str);
        if (set != null) {
            for (j jVar : set) {
                if (jVar != null) {
                    jVar.onDisconnect();
                }
            }
        }
        AppMethodBeat.o(114016);
    }
}
