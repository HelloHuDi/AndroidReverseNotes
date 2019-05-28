package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public final class c implements com.tencent.mm.plugin.expt.hellhound.core.c, d, e {
    private a lMG;
    private b lMH = new b(this);
    private HellInstrumentationHijack lMI = new HellInstrumentationHijack(this);

    public c() {
        AppMethodBeat.i(73396);
        AppMethodBeat.o(73396);
    }

    public final void a(a aVar) {
        this.lMG = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6 A:{Catch:{ Exception -> 0x00fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A:{SYNTHETIC, Splitter:B:14:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A:{SYNTHETIC, Splitter:B:14:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6 A:{Catch:{ Exception -> 0x00fa }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(Application application) {
        Object obj;
        Method declaredMethod;
        Field obj2 = null;
        AppMethodBeat.i(73397);
        if (application == null) {
            AppMethodBeat.o(73397);
            return;
        }
        Class cls;
        b bVar = this.lMH;
        ab.i("ActivityHijack", "ActivityHijack start hijack");
        Field declaredField;
        Field field;
        List ap;
        Class[] clsArr;
        if (VERSION.SDK_INT < 26) {
            try {
                Class cls2 = Class.forName("android.app.ActivityManagerNative");
                try {
                    declaredField = cls2.getDeclaredField("gDefault");
                    try {
                        declaredField.setAccessible(true);
                        obj2 = declaredField.get(null);
                        field = declaredField;
                    } catch (NoSuchFieldException e) {
                        try {
                            declaredMethod = cls2.getDeclaredMethod("getDefault", new Class[0]);
                            declaredMethod.setAccessible(true);
                            obj2 = declaredMethod.invoke(null, new Object[0]);
                            field = declaredField;
                        } catch (Exception e2) {
                            ab.printErrStackTrace("ActivityHijack", e2, "AHijack._doHijackBellowApi26", new Object[0]);
                            field = declaredField;
                        }
                        if (obj2 == null) {
                        }
                    }
                } catch (NoSuchFieldException e3) {
                    declaredField = obj2;
                    declaredMethod = cls2.getDeclaredMethod("getDefault", new Class[0]);
                    declaredMethod.setAccessible(true);
                    obj2 = declaredMethod.invoke(null, new Object[0]);
                    field = declaredField;
                    if (obj2 == null) {
                    }
                }
                Object newProxyInstance;
                if (obj2 == null) {
                    ab.e("ActivityHijack", "ActivityHijack.gDefaultObject == null");
                } else if (cls2.isInstance(obj2)) {
                    bVar.lMB = obj2;
                    Class cls3 = obj2.getClass();
                    ap = com.tencent.mm.plugin.expt.hellhound.core.a.a.ap(cls3);
                    clsArr = (ap == null || ap.size() <= 0) ? new Class[0] : (Class[]) ap.toArray(new Class[ap.size()]);
                    newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), clsArr, bVar);
                    if (field != null) {
                        field.set(null, newProxyInstance);
                    }
                } else {
                    cls = Class.forName("android.util.Singleton");
                    if (cls.isInstance(obj2)) {
                        field = cls.getDeclaredField("mInstance");
                        field.setAccessible(true);
                        newProxyInstance = field.get(obj2);
                        if (newProxyInstance != null) {
                            bVar.lMB = newProxyInstance;
                            cls2 = newProxyInstance.getClass();
                            ap = com.tencent.mm.plugin.expt.hellhound.core.a.a.ap(cls2);
                            if (ap == null || ap.size() <= 0) {
                                clsArr = new Class[0];
                            } else {
                                clsArr = (Class[]) ap.toArray(new Class[ap.size()]);
                            }
                            field.set(obj2, Proxy.newProxyInstance(cls2.getClassLoader(), clsArr, bVar));
                        }
                    }
                }
            } catch (Exception e4) {
                ab.printErrStackTrace("ActivityHijack", e4, "AHijack._doHijackBellowApi26", new Object[0]);
                h.pYm.a(932, 3, 1, false);
            }
        } else {
            try {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
                declaredField.setAccessible(true);
                obj2 = declaredField.get(null);
                field = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
                field.setAccessible(true);
                Object obj3 = field.get(obj2);
                bVar.lMB = obj3;
                ap = com.tencent.mm.plugin.expt.hellhound.core.a.a.ap(obj3.getClass());
                if (ap == null || ap.size() <= 0) {
                    clsArr = new Class[0];
                } else {
                    clsArr = (Class[]) ap.toArray(new Class[ap.size()]);
                }
                field.set(obj2, Proxy.newProxyInstance(obj3.getClass().getClassLoader(), clsArr, bVar));
            } catch (Exception e42) {
                ab.printErrStackTrace("ActivityHijack", e42, "AHijack._doHijackAboveEqualApi26", new Object[0]);
                h.pYm.a(932, 4, 1, false);
            }
        }
        HellInstrumentationHijack hellInstrumentationHijack = this.lMI;
        ab.i("HellInstrumentationHijack", "HellInstrumentationHijack start hijack");
        try {
            cls = com.tencent.mm.plugin.expt.hellhound.core.a.a.bqr();
            declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField2 = cls.getDeclaredField("mInstrumentation");
            declaredField2.setAccessible(true);
            hellInstrumentationHijack.lMK = (Instrumentation) declaredField2.get(invoke);
            Field[] declaredFields = Instrumentation.class.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                declaredFields[i].set(hellInstrumentationHijack, declaredFields[i].get(hellInstrumentationHijack.lMK));
            }
            declaredField2.set(invoke, hellInstrumentationHijack);
            AppMethodBeat.o(73397);
        } catch (Exception e422) {
            ab.printErrStackTrace("HellInstrumentationHijack", e422, "Instru.hijack", new Object[0]);
            h.pYm.a(932, 5, 1, false);
            AppMethodBeat.o(73397);
        }
    }

    public final void a(Activity activity, boolean z) {
        AppMethodBeat.i(73398);
        com.tencent.mm.vending.j.c K = K(activity);
        if (K == null) {
            AppMethodBeat.o(73398);
            return;
        }
        String str = (String) K.get(0);
        String str2 = (String) K.get(1);
        ab.d("ActivityMonitor", "habbyge-mali, moveActivityTaskToBack: " + str + " / " + str2);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73398);
            return;
        }
        d.bqu();
        ab.d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack: " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + z);
        bf bqs = com.tencent.mm.plugin.expt.hellhound.core.stack.c.bqs();
        be beVar = new be();
        beVar.vDg = new chm();
        beVar.vDg.activityName = str;
        beVar.vDg.wkp = str2;
        com.tencent.mm.vending.j.c a = g.a(bqs, beVar);
        if (a == null) {
            ab.e("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack tuple2 == null");
        } else {
            cgq cgq = (cgq) a.get(0);
            int intValue = ((Integer) a.get(1)).intValue();
            if (!z) {
                ab.w("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack nonRoot: false");
                if (!com.tencent.mm.plugin.expt.hellhound.core.stack.h.a(((be) cgq.xfy.getFirst()).vDg, beVar.vDg)) {
                    ab.w("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack nonRoot: 不处理直接返回");
                }
            }
            int size = bqs.vDi.size();
            ab.d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack: taskPosition = " + intValue + "/" + size);
            if (intValue == size - 1) {
                bqs.vDi.remove(intValue);
                bqs.vDi.addFirst(cgq);
                com.tencent.mm.plugin.expt.hellhound.core.stack.c.a(bqs);
                ab.d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack 栈顶");
            } else {
                ab.e("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack 非栈顶，不合法");
            }
        }
        aD(str, false);
        if (!(TextUtils.isEmpty(str) || this.lMG == null)) {
            this.lMG.eb(str, str2);
        }
        AppMethodBeat.o(73398);
    }

    public final void F(Activity activity) {
        AppMethodBeat.i(73399);
        com.tencent.mm.vending.j.c K = K(activity);
        if (K == null) {
            AppMethodBeat.o(73399);
            return;
        }
        String str = (String) K.get(0);
        String str2 = (String) K.get(1);
        ab.d("ActivityMonitor", "habbyge-mali, finish: " + str + " / " + str2);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73399);
            return;
        }
        g gVar = d.bqu().lMw.lMx;
        if (!TextUtils.isEmpty(str)) {
            ab.d("TaskRecordWrapper", "habbyge-mali, pop_String: " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
            bf bqs = com.tencent.mm.plugin.expt.hellhound.core.stack.c.bqs();
            if (!bqs.vDi.isEmpty()) {
                be a = g.a(bqs, str, str2);
                if (a == null) {
                    ab.e("TaskRecordWrapper", "habbyge-mali, pop_string: realPopActivityRecord Do-Nothing !!!");
                } else {
                    com.tencent.mm.plugin.expt.hellhound.core.stack.c.a(bqs);
                    if (gVar.lMA != null) {
                        f fVar = gVar.lMA;
                        g.bqz();
                        fVar.a(a);
                    }
                }
            }
        }
        aD(str, true);
        if (!(TextUtils.isEmpty(str) || this.lMG == null)) {
            this.lMG.ea(str, str2);
        }
        AppMethodBeat.o(73399);
    }

    private static void aD(String str, boolean z) {
        AppMethodBeat.i(73400);
        a.uX(1);
        if (z || !"com.tencent.mm.ui.LauncherUI".equals(str)) {
            d.bqu();
            be bqv = d.bqv();
            String str2 = null;
            if (bqv != null) {
                str2 = bqv.vDg.activityName;
            }
            a.KP(str);
            a.KO(str2);
            ab.i("ActivityMonitor", "habbyge-mali, _finish: from/to = " + str + "/" + str2);
            AppMethodBeat.o(73400);
            return;
        }
        ab.i("ActivityMonitor", "habbyge-mali, _quiteActivity come frome: moveActivityTaskToBack");
        AppMethodBeat.o(73400);
    }

    public final void c(Intent intent, Activity activity) {
        AppMethodBeat.i(73402);
        if (activity == null) {
            AppMethodBeat.o(73402);
            return;
        }
        e(intent, activity);
        AppMethodBeat.o(73402);
    }

    public final void d(Intent intent, Activity activity) {
        AppMethodBeat.i(73403);
        if (activity == null) {
            AppMethodBeat.o(73403);
            return;
        }
        e(intent, activity);
        AppMethodBeat.o(73403);
    }

    private static void e(Intent intent, Activity activity) {
        AppMethodBeat.i(73404);
        String canonicalName = activity.getClass().getCanonicalName();
        String valueOf = String.valueOf(activity.hashCode());
        ab.d("ActivityMonitor", "habbyge-mali, _onCreateEvent: /0x" + Integer.toHexString(intent.getFlags()) + "/" + canonicalName + "/" + valueOf);
        a(intent, canonicalName, valueOf);
        a(canonicalName, valueOf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.CREATE);
        AppMethodBeat.o(73404);
    }

    public final void G(Activity activity) {
        AppMethodBeat.i(73405);
        String canonicalName = activity.getClass().getCanonicalName();
        String valueOf = String.valueOf(activity.hashCode());
        d.bqu();
        if (!TextUtils.isEmpty(canonicalName)) {
            int i;
            ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2FrontWhenActivityResumeIfNeed: ".concat(String.valueOf(canonicalName)));
            bf bqs = com.tencent.mm.plugin.expt.hellhound.core.stack.c.bqs();
            if (bqs == null || bqs.vDi.isEmpty() || TextUtils.isEmpty(canonicalName)) {
                i = 0;
            } else {
                ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2Front: " + canonicalName + "/" + valueOf);
                cgq cgq = (cgq) bqs.vDi.getLast();
                if (cgq == null) {
                    i = 0;
                } else if (cgq.xfy.isEmpty()) {
                    i = 0;
                } else {
                    be beVar = (be) cgq.xfy.getLast();
                    if (beVar == null) {
                        i = 0;
                    } else if (com.tencent.mm.plugin.expt.hellhound.core.stack.h.l(beVar.vDg.activityName, beVar.vDg.wkp, canonicalName, valueOf)) {
                        i = 0;
                    } else {
                        com.tencent.mm.vending.j.c b = g.b(bqs, canonicalName, valueOf);
                        int intValue = ((Integer) b.get(0)).intValue();
                        int intValue2 = ((Integer) b.get(1)).intValue();
                        if (intValue < 0) {
                            i = 0;
                        } else {
                            cgq = (cgq) bqs.vDi.remove(intValue);
                            int size = cgq.xfy.size();
                            if (intValue2 < size - 1) {
                                for (size--; size > intValue2; size--) {
                                    cgq.xfy.remove(size);
                                }
                            }
                            bqs.vDi.addLast(cgq);
                            i = 1;
                        }
                    }
                }
            }
            if (i != 0) {
                com.tencent.mm.plugin.expt.hellhound.core.stack.c.a(bqs);
                ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2FntWhenActivityResume true");
            } else {
                ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2FrontWhenActivityResume false");
            }
        }
        a(canonicalName, valueOf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.RESUME);
        if (this.lMG != null) {
            this.lMG.B(activity);
        }
        AppMethodBeat.o(73405);
    }

    public final void H(Activity activity) {
        AppMethodBeat.i(73406);
        if (activity == null) {
            AppMethodBeat.o(73406);
            return;
        }
        a(activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()), com.tencent.mm.plugin.expt.hellhound.core.stack.a.PAUSE);
        if (this.lMG != null) {
            this.lMG.C(activity);
        }
        AppMethodBeat.o(73406);
    }

    public final void I(Activity activity) {
        AppMethodBeat.i(73407);
        if (activity == null) {
            AppMethodBeat.o(73407);
            return;
        }
        String canonicalName = activity.getClass().getCanonicalName();
        String valueOf = String.valueOf(activity.hashCode());
        if ("com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(canonicalName)) {
            AppMethodBeat.o(73407);
            return;
        }
        a(canonicalName, valueOf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.STOP);
        if (this.lMG != null) {
            this.lMG.D(activity);
        }
        AppMethodBeat.o(73407);
    }

    public final void J(Activity activity) {
        AppMethodBeat.i(73408);
        if (activity == null) {
            AppMethodBeat.o(73408);
            return;
        }
        a(activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()), com.tencent.mm.plugin.expt.hellhound.core.stack.a.DESTROY);
        if (this.lMG != null) {
            this.lMG.E(activity);
        }
        AppMethodBeat.o(73408);
    }

    private static void a(Intent intent, String str, String str2) {
        AppMethodBeat.i(73409);
        d.bqu().a(intent, str, str2);
        AppMethodBeat.o(73409);
    }

    private static void a(String str, String str2, com.tencent.mm.plugin.expt.hellhound.core.stack.a aVar) {
        AppMethodBeat.i(73410);
        d.bqu();
        d.a(str, str2, aVar);
        AppMethodBeat.o(73410);
    }

    private static com.tencent.mm.vending.j.c<String, String> K(Activity activity) {
        AppMethodBeat.i(73411);
        if (activity == null) {
            try {
                d.bqu();
                com.tencent.mm.vending.j.c<String, String> bqw = d.bqw();
                ab.d("ActivityMonitor", "habbyge-mali, getActivityOnFinish: " + ((String) bqw.get(0)) + " / " + ((String) bqw.get(1)));
                AppMethodBeat.o(73411);
                return bqw;
            } catch (Exception e) {
                ab.printErrStackTrace("ActivityMonitor", e, "habbyge-mali, getActivityOnFinish", new Object[0]);
                AppMethodBeat.o(73411);
                return null;
            }
        }
        com.tencent.mm.vending.j.c<String, String> F = com.tencent.mm.vending.j.a.F(activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()));
        AppMethodBeat.o(73411);
        return F;
    }

    public final void a(Activity activity, Intent intent) {
        Object canonicalName;
        String className;
        AppMethodBeat.i(73401);
        if (activity != null) {
            canonicalName = activity.getClass().getCanonicalName();
            ab.i("ActivityMonitor", "habbyge-mali, startActivity, fromActivity: ".concat(String.valueOf(canonicalName)));
        } else {
            d.bqu();
            be bqv = d.bqv();
            if (bqv != null) {
                canonicalName = bqv.vDg.activityName;
            } else {
                canonicalName = null;
            }
            ab.i("ActivityMonitor", "habbyge-mali, startActivity, fromActivityName: ".concat(String.valueOf(canonicalName)));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            className = component.getClassName();
        } else {
            className = null;
        }
        a(intent, className, null);
        ab.i("ActivityActionWrapper", "habbyge-mali, setStartActivityAction_resume: ".concat(String.valueOf(className)));
        b.bqC().lMN.KQ(className);
        ab.i("ActivityActionWrapper", "habbyge-mali, setStartActivityAction_pause: ".concat(String.valueOf(canonicalName)));
        b.bqC().lMN.KS(canonicalName);
        a.uX(0);
        if (!(className == null || this.lMG == null)) {
            this.lMG.KM(className);
        }
        AppMethodBeat.o(73401);
    }
}
