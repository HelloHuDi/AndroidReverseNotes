package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.b;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseIPCService extends Service {
    private com.tencent.mm.ipcinvoker.b.a.a eFA = new com.tencent.mm.ipcinvoker.b.a.a() {
        public final void a(Bundle bundle, String str, final b bVar) {
            AppMethodBeat.i(113998);
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
                AppMethodBeat.o(113998);
            } else if (bundle == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
                AppMethodBeat.o(113998);
            } else {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                final Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                final a aVar = (a) k.b(str, a.class);
                if (aVar == null) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", str);
                    AppMethodBeat.o(113998);
                    return;
                }
                m.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(113997);
                        aVar.a(parcelable, new a(bVar));
                        AppMethodBeat.o(113997);
                    }
                });
                AppMethodBeat.o(113998);
            }
        }

        public final Bundle f(Bundle bundle, String str) {
            AppMethodBeat.i(113999);
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
                AppMethodBeat.o(113999);
                return null;
            } else if (bundle == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
                AppMethodBeat.o(113999);
                return null;
            } else {
                i iVar = (i) k.b(str, i.class);
                if (iVar == null) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", str);
                    AppMethodBeat.o(113999);
                    return null;
                }
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("__remote_task_result_data", (Parcelable) iVar.am(parcelable));
                AppMethodBeat.o(113999);
                return bundle2;
            }
        }
    };
    private volatile boolean eFy;
    private volatile boolean eFz;

    static class a implements c<Parcelable>, com.tencent.mm.ipcinvoker.e.a {
        b eFG;
        final List<com.tencent.mm.ipcinvoker.e.b> eFH = new LinkedList();

        static class a implements Runnable {
            private static final Bundle eFI;
            b eFG;

            static {
                AppMethodBeat.i(114002);
                Bundle bundle = new Bundle();
                eFI = bundle;
                bundle.putBoolean("__command_release_ref", true);
                AppMethodBeat.o(114002);
            }

            a(b bVar) {
                this.eFG = bVar;
            }

            public final void run() {
                AppMethodBeat.i(114001);
                try {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", Integer.valueOf(this.eFG.hashCode()));
                    this.eFG.l(eFI);
                    com.tencent.mm.ipcinvoker.f.b.at(this.eFG);
                    this.eFG = null;
                    AppMethodBeat.o(114001);
                } catch (RemoteException e) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", Log.getStackTraceString(e));
                    AppMethodBeat.o(114001);
                } catch (Exception e2) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", e2.getMessage(), Log.getStackTraceString(e2));
                    AppMethodBeat.o(114001);
                }
            }
        }

        public final /* synthetic */ void ao(Object obj) {
            AppMethodBeat.i(114006);
            Parcelable parcelable = (Parcelable) obj;
            if (this.eFG != null) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "onCallback(%s)", Integer.valueOf(this.eFG.hashCode()));
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("__remote_task_result_data", parcelable);
                    this.eFG.l(bundle);
                    AppMethodBeat.o(114006);
                    return;
                } catch (RemoteException e) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "%s", Log.getStackTraceString(e));
                    if (!this.eFH.isEmpty()) {
                        synchronized (this.eFH) {
                            for (com.tencent.mm.ipcinvoker.e.b d : new LinkedList(this.eFH)) {
                                d.d(r1);
                            }
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114006);
                    }
                }
            }
            AppMethodBeat.o(114006);
        }

        public a(b bVar) {
            AppMethodBeat.i(114003);
            this.eFG = bVar;
            if (bVar != null) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", Integer.valueOf(bVar.hashCode()));
                com.tencent.mm.ipcinvoker.f.b.as(bVar);
            }
            AppMethodBeat.o(114003);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.i(114004);
            try {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", Integer.valueOf(hashCode()));
                if (this.eFG != null) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", Integer.valueOf(this.eFG.hashCode()));
                    m.post(new a(this.eFG));
                    this.eFG = null;
                }
                super.finalize();
                AppMethodBeat.o(114004);
            } catch (Throwable th) {
                super.finalize();
                AppMethodBeat.o(114004);
            }
        }

        public final void a(com.tencent.mm.ipcinvoker.e.b bVar) {
            AppMethodBeat.i(114005);
            if (bVar == null) {
                AppMethodBeat.o(114005);
                return;
            }
            synchronized (this.eFH) {
                try {
                    if (this.eFH.contains(bVar)) {
                    } else {
                        this.eFH.add(bVar);
                        AppMethodBeat.o(114005);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(114005);
                }
            }
        }
    }

    public abstract String getProcessName();

    public IBinder onBind(Intent intent) {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", intent, Boolean.valueOf(this.eFy));
        if (this.eFy) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
            return null;
        }
        h PO = h.PO();
        String PN = e.PN();
        if (!(PN == null || PN.length() == 0)) {
            PO.eGf.put(PN, this);
        }
        this.eFz = true;
        return this.eFA;
    }

    public boolean onUnbind(Intent intent) {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", intent);
        boolean onUnbind = super.onUnbind(intent);
        this.eFz = false;
        return onUnbind;
    }

    public final void ci(boolean z) {
        if (!this.eFz || z) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", getProcessName());
            this.eFy = true;
            b.PL().PM();
            b PL = b.PL();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
            if (!PL.eFL.isEmpty()) {
                synchronized (PL.eFL) {
                    if (PL.eFL.isEmpty()) {
                    } else {
                        HashSet<String> hashSet = new HashSet(PL.eFL.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String lf : hashSet) {
                                PL.lf(lf);
                            }
                        }
                    }
                }
            }
            stopSelf();
            h PO = h.PO();
            PO.eGf.remove(getProcessName());
            m.t(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(114000);
                    Process.killProcess(Process.myPid());
                    AppMethodBeat.o(114000);
                }
            });
            return;
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", getProcessName());
    }
}
