package com.tencent.p177mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p1462b.C32704a.C32705a;
import com.tencent.p177mm.ipcinvoker.p1462b.C32707b;
import com.tencent.p177mm.ipcinvoker.p1532e.C37868a;
import com.tencent.p177mm.ipcinvoker.p1532e.C42131b;
import com.tencent.p177mm.ipcinvoker.p1600f.C42139b;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ipcinvoker.BaseIPCService */
public abstract class BaseIPCService extends Service {
    private C32705a eFA = new C185041();
    private volatile boolean eFy;
    private volatile boolean eFz;

    /* renamed from: com.tencent.mm.ipcinvoker.BaseIPCService$a */
    static class C18503a implements C18507c<Parcelable>, C37868a {
        C32707b eFG;
        final List<C42131b> eFH = new LinkedList();

        /* renamed from: com.tencent.mm.ipcinvoker.BaseIPCService$a$a */
        static class C18502a implements Runnable {
            private static final Bundle eFI;
            C32707b eFG;

            static {
                AppMethodBeat.m2504i(114002);
                Bundle bundle = new Bundle();
                eFI = bundle;
                bundle.putBoolean("__command_release_ref", true);
                AppMethodBeat.m2505o(114002);
            }

            C18502a(C32707b c32707b) {
                this.eFG = c32707b;
            }

            public final void run() {
                AppMethodBeat.m2504i(114001);
                try {
                    C26340b.m41917i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", Integer.valueOf(this.eFG.hashCode()));
                    this.eFG.mo5087l(eFI);
                    C42139b.m74291at(this.eFG);
                    this.eFG = null;
                    AppMethodBeat.m2505o(114001);
                } catch (RemoteException e) {
                    C26340b.m41916e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", Log.getStackTraceString(e));
                    AppMethodBeat.m2505o(114001);
                } catch (Exception e2) {
                    C26340b.m41916e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", e2.getMessage(), Log.getStackTraceString(e2));
                    AppMethodBeat.m2505o(114001);
                }
            }
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(114006);
            Parcelable parcelable = (Parcelable) obj;
            if (this.eFG != null) {
                C26340b.m41917i("IPC.IPCInvokeCallbackProxy", "onCallback(%s)", Integer.valueOf(this.eFG.hashCode()));
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("__remote_task_result_data", parcelable);
                    this.eFG.mo5087l(bundle);
                    AppMethodBeat.m2505o(114006);
                    return;
                } catch (RemoteException e) {
                    C26340b.m41916e("IPC.IPCInvokeCallbackProxy", "%s", Log.getStackTraceString(e));
                    if (!this.eFH.isEmpty()) {
                        synchronized (this.eFH) {
                            for (C42131b d : new LinkedList(this.eFH)) {
                                d.mo67680d(r1);
                            }
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114006);
                    }
                }
            }
            AppMethodBeat.m2505o(114006);
        }

        public C18503a(C32707b c32707b) {
            AppMethodBeat.m2504i(114003);
            this.eFG = c32707b;
            if (c32707b != null) {
                C26340b.m41917i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", Integer.valueOf(c32707b.hashCode()));
                C42139b.m74290as(c32707b);
            }
            AppMethodBeat.m2505o(114003);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.m2504i(114004);
            try {
                C26340b.m41917i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", Integer.valueOf(hashCode()));
                if (this.eFG != null) {
                    C26340b.m41917i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", Integer.valueOf(this.eFG.hashCode()));
                    C18515m.post(new C18502a(this.eFG));
                    this.eFG = null;
                }
                super.finalize();
                AppMethodBeat.m2505o(114004);
            } catch (Throwable th) {
                super.finalize();
                AppMethodBeat.m2505o(114004);
            }
        }

        /* renamed from: a */
        public final void mo33744a(C42131b c42131b) {
            AppMethodBeat.m2504i(114005);
            if (c42131b == null) {
                AppMethodBeat.m2505o(114005);
                return;
            }
            synchronized (this.eFH) {
                try {
                    if (this.eFH.contains(c42131b)) {
                    } else {
                        this.eFH.add(c42131b);
                        AppMethodBeat.m2505o(114005);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(114005);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.BaseIPCService$1 */
    class C185041 extends C32705a {
        C185041() {
        }

        /* renamed from: a */
        public final void mo33746a(Bundle bundle, String str, final C32707b c32707b) {
            AppMethodBeat.m2504i(113998);
            if (str == null || str.length() == 0) {
                C26340b.m41916e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
                AppMethodBeat.m2505o(113998);
            } else if (bundle == null) {
                C26340b.m41916e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
                AppMethodBeat.m2505o(113998);
            } else {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                final Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                final C37866a c37866a = (C37866a) C26341k.m41919b(str, C37866a.class);
                if (c37866a == null) {
                    C26340b.m41916e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", str);
                    AppMethodBeat.m2505o(113998);
                    return;
                }
                C18515m.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(113997);
                        c37866a.mo5958a(parcelable, new C18503a(c32707b));
                        AppMethodBeat.m2505o(113997);
                    }
                });
                AppMethodBeat.m2505o(113998);
            }
        }

        /* renamed from: f */
        public final Bundle mo33747f(Bundle bundle, String str) {
            AppMethodBeat.m2504i(113999);
            if (str == null || str.length() == 0) {
                C26340b.m41916e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
                AppMethodBeat.m2505o(113999);
                return null;
            } else if (bundle == null) {
                C26340b.m41916e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
                AppMethodBeat.m2505o(113999);
                return null;
            } else {
                C45413i c45413i = (C45413i) C26341k.m41919b(str, C45413i.class);
                if (c45413i == null) {
                    C26340b.m41916e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", str);
                    AppMethodBeat.m2505o(113999);
                    return null;
                }
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("__remote_task_result_data", (Parcelable) c45413i.mo4785am(parcelable));
                AppMethodBeat.m2505o(113999);
                return bundle2;
            }
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.BaseIPCService$2 */
    class C185052 implements Runnable {
        C185052() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114000);
            Process.killProcess(Process.myPid());
            AppMethodBeat.m2505o(114000);
        }
    }

    public abstract String getProcessName();

    public IBinder onBind(Intent intent) {
        C26340b.m41917i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", intent, Boolean.valueOf(this.eFy));
        if (this.eFy) {
            C26340b.m41917i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
            return null;
        }
        C37871h PO = C37871h.m63909PO();
        String PN = C9548e.m17007PN();
        if (!(PN == null || PN.length() == 0)) {
            PO.eGf.put(PN, this);
        }
        this.eFz = true;
        return this.eFA;
    }

    public boolean onUnbind(Intent intent) {
        C26340b.m41917i("IPC.BaseIPCService", "onUnbind(%s)", intent);
        boolean onUnbind = super.onUnbind(intent);
        this.eFz = false;
        return onUnbind;
    }

    /* renamed from: ci */
    public final void mo33740ci(boolean z) {
        if (!this.eFz || z) {
            C26340b.m41917i("IPC.BaseIPCService", "kill self(%s)", getProcessName());
            this.eFy = true;
            C32710b.m53380PL().mo53220PM();
            C32710b PL = C32710b.m53380PL();
            C26340b.m41917i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
            if (!PL.eFL.isEmpty()) {
                synchronized (PL.eFL) {
                    if (PL.eFL.isEmpty()) {
                    } else {
                        HashSet<String> hashSet = new HashSet(PL.eFL.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String lf : hashSet) {
                                PL.mo53223lf(lf);
                            }
                        }
                    }
                }
            }
            stopSelf();
            C37871h PO = C37871h.m63909PO();
            PO.eGf.remove(getProcessName());
            C18515m.m28824t(new C185052());
            return;
        }
        C26340b.m41917i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", getProcessName());
    }
}
