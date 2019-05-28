package com.tencent.p177mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.wallet_core.a */
public final class C24143a {
    private static Map<String, Class<?>> AeQ = new HashMap();
    private static SparseArray<C40931c> AeR = new SparseArray();

    static {
        AppMethodBeat.m2504i(49005);
        AppMethodBeat.m2505o(49005);
    }

    /* renamed from: g */
    public static void m37115g(String str, Class<?> cls) {
        AppMethodBeat.m2504i(48989);
        if (AeQ.containsKey(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("register process fail, exist process=".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(48989);
            throw illegalArgumentException;
        }
        AeQ.put(str, cls);
        AppMethodBeat.m2505o(48989);
    }

    /* renamed from: aD */
    private static String m37111aD(Bundle bundle) {
        AppMethodBeat.m2504i(48990);
        String str;
        if (bundle == null) {
            str = "";
            AppMethodBeat.m2505o(48990);
            return str;
        }
        str = bundle.toString();
        AppMethodBeat.m2505o(48990);
        return str;
    }

    public static void remove(int i) {
        AppMethodBeat.m2504i(48991);
        AeR.remove(i);
        AppMethodBeat.m2505o(48991);
    }

    /* renamed from: a */
    public static void m37105a(Activity activity, Class<?> cls, Bundle bundle) {
        AppMethodBeat.m2504i(48992);
        C24143a.m37106a(activity, (Class) cls, bundle, null);
        AppMethodBeat.m2505o(48992);
    }

    /* renamed from: a */
    public static void m37106a(Activity activity, Class<?> cls, Bundle bundle, C30857a c30857a) {
        AppMethodBeat.m2504i(48993);
        C4990ab.m7417i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", activity, cls.getSimpleName(), C24143a.m37111aD(bundle));
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
                AppMethodBeat.m2505o(48993);
                return;
            }
        }
        if (bundle.getLong("key_SessionId", 0) == 0) {
            bundle.putLong("key_SessionId", System.currentTimeMillis());
        }
        C40931c c40931c = (C40931c) cls.newInstance();
        c40931c.mo64568aE(bundle);
        c40931c.mo64567a(c30857a, (Context) activity);
        c40931c.mo8123a(activity, bundle);
        AeR.put(cls.hashCode(), c40931c);
        AppMethodBeat.m2505o(48993);
    }

    /* renamed from: b */
    public static void m37114b(Activity activity, String str, Bundle bundle) {
        AppMethodBeat.m2504i(48994);
        C24143a.m37107a(activity, str, bundle, null);
        AppMethodBeat.m2505o(48994);
    }

    /* renamed from: a */
    public static void m37107a(Activity activity, String str, Bundle bundle, C30857a c30857a) {
        AppMethodBeat.m2504i(48995);
        try {
            C4990ab.m7417i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", activity, str, C24143a.m37111aD(bundle));
            Class cls = (Class) AeQ.get(str);
            if (cls == null) {
                String format = String.format("start process=%s fail, process not register or plugin no import", new Object[]{str});
                C4990ab.m7412e("MicroMsg.ProcessManager", format);
                C23639t.makeText(activity, format, 1).show();
                AppMethodBeat.m2505o(48995);
                return;
            }
            C24143a.m37106a(activity, cls, bundle, c30857a);
            AppMethodBeat.m2505o(48995);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ProcessManager", "plugin load failed : " + e.toString());
            C4990ab.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(48995);
        }
    }

    /* renamed from: j */
    public static void m37116j(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48996);
        C40931c aE = C24143a.m37112aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "forwardProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = C24143a.m37111aD(bundle);
        objArr[2] = aE == null ? "" : aE.bxP();
        C4990ab.m7417i(str, str2, objArr);
        if (aE != null) {
            aE.mo8124a(activity, 0, bundle);
        }
        AppMethodBeat.m2505o(48996);
    }

    /* renamed from: aB */
    public static void m37108aB(Activity activity) {
        AppMethodBeat.m2504i(48997);
        C40931c aE = C24143a.m37112aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s procname %s";
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = aE == null ? "" : aE.bxP();
        C4990ab.m7417i(str, str2, objArr);
        if (aE != null) {
            aE.mo8127c(activity, 0);
        }
        AppMethodBeat.m2505o(48997);
    }

    /* renamed from: o */
    public static void m37118o(Activity activity, int i) {
        AppMethodBeat.m2504i(48998);
        if (activity == null) {
            C4990ab.m7420w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        C40931c aE = C24143a.m37112aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s errCode %s procname %s ";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = aE == null ? "" : aE.bxP();
        C4990ab.m7417i(str, str2, objArr);
        if (aE != null) {
            aE.mo8127c(activity, i);
            AppMethodBeat.m2505o(48998);
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.m2505o(48998);
    }

    /* renamed from: b */
    public static void m37113b(Activity activity, Bundle bundle, int i) {
        AppMethodBeat.m2504i(48999);
        C4990ab.m7416i("MicroMsg.ProcessManager", "endProcess with errCode : ".concat(String.valueOf(i)));
        if (activity == null) {
            C4990ab.m7420w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        C40931c aE = C24143a.m37112aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "endProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = C24143a.m37111aD(bundle);
        objArr[2] = aE == null ? "" : aE.bxP();
        C4990ab.m7417i(str, str2, objArr);
        if (aE != null) {
            aE.mo8125b(activity, bundle);
            AppMethodBeat.m2505o(48999);
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.m2505o(48999);
    }

    /* renamed from: aC */
    public static boolean m37109aC(Activity activity) {
        AppMethodBeat.m2504i(49000);
        if (C24143a.m37112aE(activity) != null) {
            AppMethodBeat.m2505o(49000);
            return true;
        }
        AppMethodBeat.m2505o(49000);
        return false;
    }

    /* renamed from: aD */
    public static Bundle m37110aD(Activity activity) {
        AppMethodBeat.m2504i(49001);
        C40931c aE = C24143a.m37112aE(activity);
        Bundle bundle;
        if (aE != null) {
            bundle = aE.mqu;
            AppMethodBeat.m2505o(49001);
            return bundle;
        }
        bundle = new Bundle();
        AppMethodBeat.m2505o(49001);
        return bundle;
    }

    /* renamed from: k */
    public static boolean m37117k(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(49002);
        C40931c aE = C24143a.m37112aE(activity);
        if (aE != null) {
            aE.mo64568aE(bundle);
            AppMethodBeat.m2505o(49002);
            return true;
        }
        AppMethodBeat.m2505o(49002);
        return false;
    }

    /* renamed from: aE */
    public static C40931c m37112aE(Activity activity) {
        AppMethodBeat.m2504i(49003);
        if (activity == null) {
            C4990ab.m7420w("MicroMsg.ProcessManager", "hy: ac is null");
            AppMethodBeat.m2505o(49003);
            return null;
        } else if (activity.getIntent() == null) {
            C4990ab.m7420w("MicroMsg.ProcessManager", "hy: get intent is null");
            AppMethodBeat.m2505o(49003);
            return null;
        } else {
            C40931c c40931c = (C40931c) AeR.get(activity.getIntent().getIntExtra("process_id", 0));
            AppMethodBeat.m2505o(49003);
            return c40931c;
        }
    }

    public static List<C40931c> atm(String str) {
        AppMethodBeat.m2504i(49004);
        ArrayList arrayList = new ArrayList();
        int size = AeR.size();
        for (int i = 0; i < size; i++) {
            C40931c c40931c = (C40931c) AeR.valueAt(i);
            if (str.equals(c40931c.bxP())) {
                arrayList.add(c40931c);
            }
        }
        AppMethodBeat.m2505o(49004);
        return arrayList;
    }
}
