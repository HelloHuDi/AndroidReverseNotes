package com.tencent.p177mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p1462b.C32704a;
import com.tencent.p177mm.ipcinvoker.p1462b.C32707b;
import com.tencent.p177mm.ipcinvoker.p1462b.C32707b.C32708a;
import com.tencent.p177mm.ipcinvoker.p1600f.C42139b;
import com.tencent.p177mm.ipcinvoker.p1600f.C42140c;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.ipcinvoker.f */
public class C9549f {

    /* renamed from: com.tencent.mm.ipcinvoker.f$a */
    static class C1630a extends C32708a implements C42140c {
        String eFV;
        C18507c eGc;

        C1630a(String str, C18507c c18507c) {
            AppMethodBeat.m2504i(114026);
            this.eGc = c18507c;
            this.eFV = str;
            C42139b.m74289a(str, this);
            C26340b.m41917i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", Integer.valueOf(c18507c.hashCode()));
            AppMethodBeat.m2505o(114026);
        }

        /* renamed from: l */
        public final void mo5087l(Bundle bundle) {
            AppMethodBeat.m2504i(114027);
            C18507c c18507c = this.eGc;
            if (c18507c == null) {
                C26340b.m41918w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
                AppMethodBeat.m2505o(114027);
            } else if (bundle == null) {
                c18507c.mo5960ao(null);
                AppMethodBeat.m2505o(114027);
            } else {
                bundle.setClassLoader(C9549f.class.getClassLoader());
                if (bundle.getBoolean("__command_release_ref")) {
                    C26340b.m41917i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", Integer.valueOf(c18507c.hashCode()));
                    recycle();
                    AppMethodBeat.m2505o(114027);
                    return;
                }
                c18507c.mo5960ao(bundle.getParcelable("__remote_task_result_data"));
                AppMethodBeat.m2505o(114027);
            }
        }

        public final void recycle() {
            AppMethodBeat.m2504i(114028);
            this.eGc = null;
            C42139b.m74292b(this.eFV, this);
            AppMethodBeat.m2505o(114028);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.m2504i(114029);
            recycle();
            C26340b.m41917i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", Integer.valueOf(hashCode()));
            super.finalize();
            AppMethodBeat.m2505o(114029);
        }
    }

    /* renamed from: c */
    static /* synthetic */ Bundle m17014c(Parcelable parcelable) {
        AppMethodBeat.m2504i(114034);
        Bundle b = C9549f.m17013b(parcelable);
        AppMethodBeat.m2505o(114034);
        return b;
    }

    /* renamed from: a */
    public static <T extends C37866a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean m17012a(final String str, final InputType inputType, final Class<T> cls, final C18507c<ResultType> c18507c) {
        AppMethodBeat.m2504i(114030);
        if (str == null || str.length() == 0) {
            C26340b.m41916e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
            AppMethodBeat.m2505o(114030);
            return false;
        } else if (cls == null) {
            C26340b.m41916e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", str);
            AppMethodBeat.m2505o(114030);
            return false;
        } else {
            boolean s = C18514l.m28821s(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(114025);
                    if (C9548e.m17008lg(str)) {
                        C37866a c37866a = (C37866a) C26341k.m41921i(cls, C37866a.class);
                        if (c37866a == null) {
                            C26340b.m41916e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", cls);
                            AppMethodBeat.m2505o(114025);
                            return;
                        }
                        c37866a.mo5958a(inputType, c18507c);
                        AppMethodBeat.m2505o(114025);
                        return;
                    }
                    C32704a ld = C32710b.m53380PL().mo53221ld(str);
                    if (ld == null) {
                        C26340b.m41916e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        AppMethodBeat.m2505o(114025);
                        return;
                    }
                    C32707b c32707b = null;
                    try {
                        if (c18507c != null) {
                            c32707b = new C1630a(str, c18507c);
                        }
                        ld.mo33746a(C9549f.m17014c(inputType), cls.getName(), c32707b);
                        AppMethodBeat.m2505o(114025);
                    } catch (RemoteException e) {
                        C26340b.m41915d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e);
                        AppMethodBeat.m2505o(114025);
                    }
                }
            });
            AppMethodBeat.m2505o(114030);
            return s;
        }
    }

    /* renamed from: a */
    public static void m17011a(String str, C42141j c42141j) {
        AppMethodBeat.m2504i(114031);
        C32710b PL = C32710b.m53380PL();
        Set set = (Set) PL.eFN.get(str);
        if (set == null) {
            set = new HashSet();
        }
        set.add(c42141j);
        PL.eFN.put(str, set);
        AppMethodBeat.m2505o(114031);
    }

    /* renamed from: a */
    public static <T extends C45413i<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType m17010a(String str, InputType inputType, Class<T> cls) {
        AppMethodBeat.m2504i(114032);
        if (str == null || str.length() == 0) {
            C26340b.m41916e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
            AppMethodBeat.m2505o(114032);
            return null;
        } else if (C9548e.m17008lg(str)) {
            Object am = ((C45413i) C26341k.m41921i(cls, C45413i.class)).mo4785am(inputType);
            if (am == null) {
                AppMethodBeat.m2505o(114032);
                return null;
            }
            Parcelable parcelable = (Parcelable) am;
            AppMethodBeat.m2505o(114032);
            return parcelable;
        } else {
            C32704a ld = C32710b.m53380PL().mo53221ld(str);
            if (ld == null) {
                C26340b.m41916e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                AppMethodBeat.m2505o(114032);
                return null;
            }
            try {
                Bundle f = ld.mo33747f(C9549f.m17013b(inputType), cls.getName());
                if (f == null) {
                    AppMethodBeat.m2505o(114032);
                    return null;
                }
                f.setClassLoader(C9549f.class.getClassLoader());
                ResultType parcelable2 = f.getParcelable("__remote_task_result_data");
                AppMethodBeat.m2505o(114032);
                return parcelable2;
            } catch (RemoteException e) {
                C26340b.m41915d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e);
                AppMethodBeat.m2505o(114032);
                return null;
            }
        }
    }

    /* renamed from: b */
    private static Bundle m17013b(Parcelable parcelable) {
        AppMethodBeat.m2504i(114033);
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        AppMethodBeat.m2505o(114033);
        return bundle;
    }
}
