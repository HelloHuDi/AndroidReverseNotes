package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private static Map<String, Class<?>> AeQ = new HashMap();
    private static SparseArray<c> AeR = new SparseArray();

    static {
        AppMethodBeat.i(49005);
        AppMethodBeat.o(49005);
    }

    public static void g(String str, Class<?> cls) {
        AppMethodBeat.i(48989);
        if (AeQ.containsKey(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("register process fail, exist process=".concat(String.valueOf(str)));
            AppMethodBeat.o(48989);
            throw illegalArgumentException;
        }
        AeQ.put(str, cls);
        AppMethodBeat.o(48989);
    }

    private static String aD(Bundle bundle) {
        AppMethodBeat.i(48990);
        String str;
        if (bundle == null) {
            str = "";
            AppMethodBeat.o(48990);
            return str;
        }
        str = bundle.toString();
        AppMethodBeat.o(48990);
        return str;
    }

    public static void remove(int i) {
        AppMethodBeat.i(48991);
        AeR.remove(i);
        AppMethodBeat.o(48991);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle) {
        AppMethodBeat.i(48992);
        a(activity, (Class) cls, bundle, null);
        AppMethodBeat.o(48992);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar) {
        AppMethodBeat.i(48993);
        ab.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", activity, cls.getSimpleName(), aD(bundle));
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
                AppMethodBeat.o(48993);
                return;
            }
        }
        if (bundle.getLong("key_SessionId", 0) == 0) {
            bundle.putLong("key_SessionId", System.currentTimeMillis());
        }
        c cVar = (c) cls.newInstance();
        cVar.aE(bundle);
        cVar.a(aVar, (Context) activity);
        cVar.a(activity, bundle);
        AeR.put(cls.hashCode(), cVar);
        AppMethodBeat.o(48993);
    }

    public static void b(Activity activity, String str, Bundle bundle) {
        AppMethodBeat.i(48994);
        a(activity, str, bundle, null);
        AppMethodBeat.o(48994);
    }

    public static void a(Activity activity, String str, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar) {
        AppMethodBeat.i(48995);
        try {
            ab.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", activity, str, aD(bundle));
            Class cls = (Class) AeQ.get(str);
            if (cls == null) {
                String format = String.format("start process=%s fail, process not register or plugin no import", new Object[]{str});
                ab.e("MicroMsg.ProcessManager", format);
                t.makeText(activity, format, 1).show();
                AppMethodBeat.o(48995);
                return;
            }
            a(activity, cls, bundle, aVar);
            AppMethodBeat.o(48995);
        } catch (Exception e) {
            ab.e("MicroMsg.ProcessManager", "plugin load failed : " + e.toString());
            ab.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
            AppMethodBeat.o(48995);
        }
    }

    public static void j(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48996);
        c aE = aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "forwardProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = aD(bundle);
        objArr[2] = aE == null ? "" : aE.bxP();
        ab.i(str, str2, objArr);
        if (aE != null) {
            aE.a(activity, 0, bundle);
        }
        AppMethodBeat.o(48996);
    }

    public static void aB(Activity activity) {
        AppMethodBeat.i(48997);
        c aE = aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s procname %s";
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = aE == null ? "" : aE.bxP();
        ab.i(str, str2, objArr);
        if (aE != null) {
            aE.c(activity, 0);
        }
        AppMethodBeat.o(48997);
    }

    public static void o(Activity activity, int i) {
        AppMethodBeat.i(48998);
        if (activity == null) {
            ab.w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        c aE = aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s errCode %s procname %s ";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = aE == null ? "" : aE.bxP();
        ab.i(str, str2, objArr);
        if (aE != null) {
            aE.c(activity, i);
            AppMethodBeat.o(48998);
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.o(48998);
    }

    public static void b(Activity activity, Bundle bundle, int i) {
        AppMethodBeat.i(48999);
        ab.i("MicroMsg.ProcessManager", "endProcess with errCode : ".concat(String.valueOf(i)));
        if (activity == null) {
            ab.w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        c aE = aE(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "endProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = aD(bundle);
        objArr[2] = aE == null ? "" : aE.bxP();
        ab.i(str, str2, objArr);
        if (aE != null) {
            aE.b(activity, bundle);
            AppMethodBeat.o(48999);
            return;
        }
        if (!activity.isFinishing()) {
            activity.finish();
        }
        AppMethodBeat.o(48999);
    }

    public static boolean aC(Activity activity) {
        AppMethodBeat.i(49000);
        if (aE(activity) != null) {
            AppMethodBeat.o(49000);
            return true;
        }
        AppMethodBeat.o(49000);
        return false;
    }

    public static Bundle aD(Activity activity) {
        AppMethodBeat.i(49001);
        c aE = aE(activity);
        Bundle bundle;
        if (aE != null) {
            bundle = aE.mqu;
            AppMethodBeat.o(49001);
            return bundle;
        }
        bundle = new Bundle();
        AppMethodBeat.o(49001);
        return bundle;
    }

    public static boolean k(Activity activity, Bundle bundle) {
        AppMethodBeat.i(49002);
        c aE = aE(activity);
        if (aE != null) {
            aE.aE(bundle);
            AppMethodBeat.o(49002);
            return true;
        }
        AppMethodBeat.o(49002);
        return false;
    }

    public static c aE(Activity activity) {
        AppMethodBeat.i(49003);
        if (activity == null) {
            ab.w("MicroMsg.ProcessManager", "hy: ac is null");
            AppMethodBeat.o(49003);
            return null;
        } else if (activity.getIntent() == null) {
            ab.w("MicroMsg.ProcessManager", "hy: get intent is null");
            AppMethodBeat.o(49003);
            return null;
        } else {
            c cVar = (c) AeR.get(activity.getIntent().getIntExtra("process_id", 0));
            AppMethodBeat.o(49003);
            return cVar;
        }
    }

    public static List<c> atm(String str) {
        AppMethodBeat.i(49004);
        ArrayList arrayList = new ArrayList();
        int size = AeR.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) AeR.valueAt(i);
            if (str.equals(cVar.bxP())) {
                arrayList.add(cVar);
            }
        }
        AppMethodBeat.o(49004);
        return arrayList;
    }
}
