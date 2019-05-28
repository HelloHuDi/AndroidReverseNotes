package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f.b;
import com.tencent.mm.ipcinvoker.f.c;
import java.util.HashSet;
import java.util.Set;

public class f {

    static class a extends com.tencent.mm.ipcinvoker.b.b.a implements c {
        String eFV;
        c eGc;

        a(String str, c cVar) {
            AppMethodBeat.i(114026);
            this.eGc = cVar;
            this.eFV = str;
            b.a(str, this);
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", Integer.valueOf(cVar.hashCode()));
            AppMethodBeat.o(114026);
        }

        public final void l(Bundle bundle) {
            AppMethodBeat.i(114027);
            c cVar = this.eGc;
            if (cVar == null) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
                AppMethodBeat.o(114027);
            } else if (bundle == null) {
                cVar.ao(null);
                AppMethodBeat.o(114027);
            } else {
                bundle.setClassLoader(f.class.getClassLoader());
                if (bundle.getBoolean("__command_release_ref")) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", Integer.valueOf(cVar.hashCode()));
                    recycle();
                    AppMethodBeat.o(114027);
                    return;
                }
                cVar.ao(bundle.getParcelable("__remote_task_result_data"));
                AppMethodBeat.o(114027);
            }
        }

        public final void recycle() {
            AppMethodBeat.i(114028);
            this.eGc = null;
            b.b(this.eFV, this);
            AppMethodBeat.o(114028);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.i(114029);
            recycle();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", Integer.valueOf(hashCode()));
            super.finalize();
            AppMethodBeat.o(114029);
        }
    }

    static /* synthetic */ Bundle c(Parcelable parcelable) {
        AppMethodBeat.i(114034);
        Bundle b = b(parcelable);
        AppMethodBeat.o(114034);
        return b;
    }

    public static <T extends a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(final String str, final InputType inputType, final Class<T> cls, final c<ResultType> cVar) {
        AppMethodBeat.i(114030);
        if (str == null || str.length() == 0) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
            AppMethodBeat.o(114030);
            return false;
        } else if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", str);
            AppMethodBeat.o(114030);
            return false;
        } else {
            boolean s = l.s(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(114025);
                    if (e.lg(str)) {
                        a aVar = (a) k.i(cls, a.class);
                        if (aVar == null) {
                            com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", cls);
                            AppMethodBeat.o(114025);
                            return;
                        }
                        aVar.a(inputType, cVar);
                        AppMethodBeat.o(114025);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.a ld = b.PL().ld(str);
                    if (ld == null) {
                        com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        AppMethodBeat.o(114025);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.b bVar = null;
                    try {
                        if (cVar != null) {
                            bVar = new a(str, cVar);
                        }
                        ld.a(f.c(inputType), cls.getName(), bVar);
                        AppMethodBeat.o(114025);
                    } catch (RemoteException e) {
                        com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e);
                        AppMethodBeat.o(114025);
                    }
                }
            });
            AppMethodBeat.o(114030);
            return s;
        }
    }

    public static void a(String str, j jVar) {
        AppMethodBeat.i(114031);
        b PL = b.PL();
        Set set = (Set) PL.eFN.get(str);
        if (set == null) {
            set = new HashSet();
        }
        set.add(jVar);
        PL.eFN.put(str, set);
        AppMethodBeat.o(114031);
    }

    public static <T extends i<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String str, InputType inputType, Class<T> cls) {
        AppMethodBeat.i(114032);
        if (str == null || str.length() == 0) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
            AppMethodBeat.o(114032);
            return null;
        } else if (e.lg(str)) {
            Object am = ((i) k.i(cls, i.class)).am(inputType);
            if (am == null) {
                AppMethodBeat.o(114032);
                return null;
            }
            Parcelable parcelable = (Parcelable) am;
            AppMethodBeat.o(114032);
            return parcelable;
        } else {
            com.tencent.mm.ipcinvoker.b.a ld = b.PL().ld(str);
            if (ld == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                AppMethodBeat.o(114032);
                return null;
            }
            try {
                Bundle f = ld.f(b(inputType), cls.getName());
                if (f == null) {
                    AppMethodBeat.o(114032);
                    return null;
                }
                f.setClassLoader(f.class.getClassLoader());
                ResultType parcelable2 = f.getParcelable("__remote_task_result_data");
                AppMethodBeat.o(114032);
                return parcelable2;
            } catch (RemoteException e) {
                com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e);
                AppMethodBeat.o(114032);
                return null;
            }
        }
    }

    private static Bundle b(Parcelable parcelable) {
        AppMethodBeat.i(114033);
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        AppMethodBeat.o(114033);
        return bundle;
    }
}
