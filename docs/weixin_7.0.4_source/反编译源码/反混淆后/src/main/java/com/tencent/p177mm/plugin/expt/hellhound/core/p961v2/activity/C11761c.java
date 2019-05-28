package com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.C38987c;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C45900a;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.p1547a.C38989b;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C20600d;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C20602g;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C27895c;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C27896f;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C45901a;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C45902h;
import com.tencent.p177mm.plugin.expt.p394a.C20593b.C3003a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44101be;
import com.tencent.p177mm.protocal.protobuf.C44102bf;
import com.tencent.p177mm.protocal.protobuf.cgq;
import com.tencent.p177mm.protocal.protobuf.chm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.v2.activity.c */
public final class C11761c implements C38987c, C34077d, C34078e {
    private C3003a lMG;
    private C11760b lMH = new C11760b(this);
    private HellInstrumentationHijack lMI = new HellInstrumentationHijack(this);

    public C11761c() {
        AppMethodBeat.m2504i(73396);
        AppMethodBeat.m2505o(73396);
    }

    /* renamed from: a */
    public final void mo23547a(C3003a c3003a) {
        this.lMG = c3003a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6 A:{Catch:{ Exception -> 0x00fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A:{SYNTHETIC, Splitter:B:14:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A:{SYNTHETIC, Splitter:B:14:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6 A:{Catch:{ Exception -> 0x00fa }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final void mo23550g(Application application) {
        Object obj;
        Method declaredMethod;
        Field obj2 = null;
        AppMethodBeat.m2504i(73397);
        if (application == null) {
            AppMethodBeat.m2505o(73397);
            return;
        }
        Class cls;
        C11760b c11760b = this.lMH;
        C4990ab.m7416i("ActivityHijack", "ActivityHijack start hijack");
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
                            C4990ab.printErrStackTrace("ActivityHijack", e2, "AHijack._doHijackBellowApi26", new Object[0]);
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
                    C4990ab.m7412e("ActivityHijack", "ActivityHijack.gDefaultObject == null");
                } else if (cls2.isInstance(obj2)) {
                    c11760b.lMB = obj2;
                    Class cls3 = obj2.getClass();
                    ap = C45900a.m85093ap(cls3);
                    clsArr = (ap == null || ap.size() <= 0) ? new Class[0] : (Class[]) ap.toArray(new Class[ap.size()]);
                    newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), clsArr, c11760b);
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
                            c11760b.lMB = newProxyInstance;
                            cls2 = newProxyInstance.getClass();
                            ap = C45900a.m85093ap(cls2);
                            if (ap == null || ap.size() <= 0) {
                                clsArr = new Class[0];
                            } else {
                                clsArr = (Class[]) ap.toArray(new Class[ap.size()]);
                            }
                            field.set(obj2, Proxy.newProxyInstance(cls2.getClassLoader(), clsArr, c11760b));
                        }
                    }
                }
            } catch (Exception e4) {
                C4990ab.printErrStackTrace("ActivityHijack", e4, "AHijack._doHijackBellowApi26", new Object[0]);
                C7060h.pYm.mo8378a(932, 3, 1, false);
            }
        } else {
            try {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
                declaredField.setAccessible(true);
                obj2 = declaredField.get(null);
                field = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
                field.setAccessible(true);
                Object obj3 = field.get(obj2);
                c11760b.lMB = obj3;
                ap = C45900a.m85093ap(obj3.getClass());
                if (ap == null || ap.size() <= 0) {
                    clsArr = new Class[0];
                } else {
                    clsArr = (Class[]) ap.toArray(new Class[ap.size()]);
                }
                field.set(obj2, Proxy.newProxyInstance(obj3.getClass().getClassLoader(), clsArr, c11760b));
            } catch (Exception e42) {
                C4990ab.printErrStackTrace("ActivityHijack", e42, "AHijack._doHijackAboveEqualApi26", new Object[0]);
                C7060h.pYm.mo8378a(932, 4, 1, false);
            }
        }
        HellInstrumentationHijack hellInstrumentationHijack = this.lMI;
        C4990ab.m7416i("HellInstrumentationHijack", "HellInstrumentationHijack start hijack");
        try {
            cls = C45900a.bqr();
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
            AppMethodBeat.m2505o(73397);
        } catch (Exception e422) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e422, "Instru.hijack", new Object[0]);
            C7060h.pYm.mo8378a(932, 5, 1, false);
            AppMethodBeat.m2505o(73397);
        }
    }

    /* renamed from: a */
    public final void mo23546a(Activity activity, boolean z) {
        AppMethodBeat.m2504i(73398);
        C7583c K = C11761c.m19581K(activity);
        if (K == null) {
            AppMethodBeat.m2505o(73398);
            return;
        }
        String str = (String) K.get(0);
        String str2 = (String) K.get(1);
        C4990ab.m7410d("ActivityMonitor", "habbyge-mali, moveActivityTaskToBack: " + str + " / " + str2);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(73398);
            return;
        }
        C20600d.bqu();
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack: " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + z);
        C44102bf bqs = C27895c.bqs();
        C44101be c44101be = new C44101be();
        c44101be.vDg = new chm();
        c44101be.vDg.activityName = str;
        c44101be.vDg.wkp = str2;
        C7583c a = C20602g.m31831a(bqs, c44101be);
        if (a == null) {
            C4990ab.m7412e("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack tuple2 == null");
        } else {
            cgq cgq = (cgq) a.get(0);
            int intValue = ((Integer) a.get(1)).intValue();
            if (!z) {
                C4990ab.m7420w("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack nonRoot: false");
                if (!C45902h.m85094a(((C44101be) cgq.xfy.getFirst()).vDg, c44101be.vDg)) {
                    C4990ab.m7420w("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack nonRoot: 不处理直接返回");
                }
            }
            int size = bqs.vDi.size();
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack: taskPosition = " + intValue + "/" + size);
            if (intValue == size - 1) {
                bqs.vDi.remove(intValue);
                bqs.vDi.addFirst(cgq);
                C27895c.m44357a(bqs);
                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack 栈顶");
            } else {
                C4990ab.m7412e("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack 非栈顶，不合法");
            }
        }
        C11761c.m19584aD(str, false);
        if (!(TextUtils.isEmpty(str) || this.lMG == null)) {
            this.lMG.mo7213eb(str, str2);
        }
        AppMethodBeat.m2505o(73398);
    }

    /* renamed from: F */
    public final void mo23540F(Activity activity) {
        AppMethodBeat.m2504i(73399);
        C7583c K = C11761c.m19581K(activity);
        if (K == null) {
            AppMethodBeat.m2505o(73399);
            return;
        }
        String str = (String) K.get(0);
        String str2 = (String) K.get(1);
        C4990ab.m7410d("ActivityMonitor", "habbyge-mali, finish: " + str + " / " + str2);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(73399);
            return;
        }
        C20602g c20602g = C20600d.bqu().lMw.lMx;
        if (!TextUtils.isEmpty(str)) {
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, pop_String: " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
            C44102bf bqs = C27895c.bqs();
            if (!bqs.vDi.isEmpty()) {
                C44101be a = C20602g.m31830a(bqs, str, str2);
                if (a == null) {
                    C4990ab.m7412e("TaskRecordWrapper", "habbyge-mali, pop_string: realPopActivityRecord Do-Nothing !!!");
                } else {
                    C27895c.m44357a(bqs);
                    if (c20602g.lMA != null) {
                        C27896f c27896f = c20602g.lMA;
                        C20602g.bqz();
                        c27896f.mo23525a(a);
                    }
                }
            }
        }
        C11761c.m19584aD(str, true);
        if (!(TextUtils.isEmpty(str) || this.lMG == null)) {
            this.lMG.mo7212ea(str, str2);
        }
        AppMethodBeat.m2505o(73399);
    }

    /* renamed from: aD */
    private static void m19584aD(String str, boolean z) {
        AppMethodBeat.m2504i(73400);
        C27897a.m44362uX(1);
        if (z || !"com.tencent.mm.ui.LauncherUI".equals(str)) {
            C20600d.bqu();
            C44101be bqv = C20600d.bqv();
            String str2 = null;
            if (bqv != null) {
                str2 = bqv.vDg.activityName;
            }
            C27897a.m44361KP(str);
            C27897a.m44360KO(str2);
            C4990ab.m7416i("ActivityMonitor", "habbyge-mali, _finish: from/to = " + str + "/" + str2);
            AppMethodBeat.m2505o(73400);
            return;
        }
        C4990ab.m7416i("ActivityMonitor", "habbyge-mali, _quiteActivity come frome: moveActivityTaskToBack");
        AppMethodBeat.m2505o(73400);
    }

    /* renamed from: c */
    public final void mo23548c(Intent intent, Activity activity) {
        AppMethodBeat.m2504i(73402);
        if (activity == null) {
            AppMethodBeat.m2505o(73402);
            return;
        }
        C11761c.m19585e(intent, activity);
        AppMethodBeat.m2505o(73402);
    }

    /* renamed from: d */
    public final void mo23549d(Intent intent, Activity activity) {
        AppMethodBeat.m2504i(73403);
        if (activity == null) {
            AppMethodBeat.m2505o(73403);
            return;
        }
        C11761c.m19585e(intent, activity);
        AppMethodBeat.m2505o(73403);
    }

    /* renamed from: e */
    private static void m19585e(Intent intent, Activity activity) {
        AppMethodBeat.m2504i(73404);
        String canonicalName = activity.getClass().getCanonicalName();
        String valueOf = String.valueOf(activity.hashCode());
        C4990ab.m7410d("ActivityMonitor", "habbyge-mali, _onCreateEvent: /0x" + Integer.toHexString(intent.getFlags()) + "/" + canonicalName + "/" + valueOf);
        C11761c.m19582a(intent, canonicalName, valueOf);
        C11761c.m19583a(canonicalName, valueOf, C45901a.CREATE);
        AppMethodBeat.m2505o(73404);
    }

    /* renamed from: G */
    public final void mo23541G(Activity activity) {
        AppMethodBeat.m2504i(73405);
        String canonicalName = activity.getClass().getCanonicalName();
        String valueOf = String.valueOf(activity.hashCode());
        C20600d.bqu();
        if (!TextUtils.isEmpty(canonicalName)) {
            int i;
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, bringTask2FrontWhenActivityResumeIfNeed: ".concat(String.valueOf(canonicalName)));
            C44102bf bqs = C27895c.bqs();
            if (bqs == null || bqs.vDi.isEmpty() || TextUtils.isEmpty(canonicalName)) {
                i = 0;
            } else {
                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, bringTask2Front: " + canonicalName + "/" + valueOf);
                cgq cgq = (cgq) bqs.vDi.getLast();
                if (cgq == null) {
                    i = 0;
                } else if (cgq.xfy.isEmpty()) {
                    i = 0;
                } else {
                    C44101be c44101be = (C44101be) cgq.xfy.getLast();
                    if (c44101be == null) {
                        i = 0;
                    } else if (C45902h.m85095l(c44101be.vDg.activityName, c44101be.vDg.wkp, canonicalName, valueOf)) {
                        i = 0;
                    } else {
                        C7583c b = C20602g.m31833b(bqs, canonicalName, valueOf);
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
                C27895c.m44357a(bqs);
                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, bringTask2FntWhenActivityResume true");
            } else {
                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, bringTask2FrontWhenActivityResume false");
            }
        }
        C11761c.m19583a(canonicalName, valueOf, C45901a.RESUME);
        if (this.lMG != null) {
            this.lMG.mo7207B(activity);
        }
        AppMethodBeat.m2505o(73405);
    }

    /* renamed from: H */
    public final void mo23542H(Activity activity) {
        AppMethodBeat.m2504i(73406);
        if (activity == null) {
            AppMethodBeat.m2505o(73406);
            return;
        }
        C11761c.m19583a(activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()), C45901a.PAUSE);
        if (this.lMG != null) {
            this.lMG.mo7208C(activity);
        }
        AppMethodBeat.m2505o(73406);
    }

    /* renamed from: I */
    public final void mo23543I(Activity activity) {
        AppMethodBeat.m2504i(73407);
        if (activity == null) {
            AppMethodBeat.m2505o(73407);
            return;
        }
        String canonicalName = activity.getClass().getCanonicalName();
        String valueOf = String.valueOf(activity.hashCode());
        if ("com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(canonicalName)) {
            AppMethodBeat.m2505o(73407);
            return;
        }
        C11761c.m19583a(canonicalName, valueOf, C45901a.STOP);
        if (this.lMG != null) {
            this.lMG.mo7209D(activity);
        }
        AppMethodBeat.m2505o(73407);
    }

    /* renamed from: J */
    public final void mo23544J(Activity activity) {
        AppMethodBeat.m2504i(73408);
        if (activity == null) {
            AppMethodBeat.m2505o(73408);
            return;
        }
        C11761c.m19583a(activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()), C45901a.DESTROY);
        if (this.lMG != null) {
            this.lMG.mo7210E(activity);
        }
        AppMethodBeat.m2505o(73408);
    }

    /* renamed from: a */
    private static void m19582a(Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(73409);
        C20600d.bqu().mo35872a(intent, str, str2);
        AppMethodBeat.m2505o(73409);
    }

    /* renamed from: a */
    private static void m19583a(String str, String str2, C45901a c45901a) {
        AppMethodBeat.m2504i(73410);
        C20600d.bqu();
        C20600d.m31827a(str, str2, c45901a);
        AppMethodBeat.m2505o(73410);
    }

    /* renamed from: K */
    private static C7583c<String, String> m19581K(Activity activity) {
        AppMethodBeat.m2504i(73411);
        if (activity == null) {
            try {
                C20600d.bqu();
                C7583c<String, String> bqw = C20600d.bqw();
                C4990ab.m7410d("ActivityMonitor", "habbyge-mali, getActivityOnFinish: " + ((String) bqw.get(0)) + " / " + ((String) bqw.get(1)));
                AppMethodBeat.m2505o(73411);
                return bqw;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("ActivityMonitor", e, "habbyge-mali, getActivityOnFinish", new Object[0]);
                AppMethodBeat.m2505o(73411);
                return null;
            }
        }
        C7583c<String, String> F = C5710a.m8574F(activity.getClass().getCanonicalName(), String.valueOf(activity.hashCode()));
        AppMethodBeat.m2505o(73411);
        return F;
    }

    /* renamed from: a */
    public final void mo23545a(Activity activity, Intent intent) {
        Object canonicalName;
        String className;
        AppMethodBeat.m2504i(73401);
        if (activity != null) {
            canonicalName = activity.getClass().getCanonicalName();
            C4990ab.m7416i("ActivityMonitor", "habbyge-mali, startActivity, fromActivity: ".concat(String.valueOf(canonicalName)));
        } else {
            C20600d.bqu();
            C44101be bqv = C20600d.bqv();
            if (bqv != null) {
                canonicalName = bqv.vDg.activityName;
            } else {
                canonicalName = null;
            }
            C4990ab.m7416i("ActivityMonitor", "habbyge-mali, startActivity, fromActivityName: ".concat(String.valueOf(canonicalName)));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            className = component.getClassName();
        } else {
            className = null;
        }
        C11761c.m19582a(intent, className, null);
        C4990ab.m7416i("ActivityActionWrapper", "habbyge-mali, setStartActivityAction_resume: ".concat(String.valueOf(className)));
        C38989b.bqC().lMN.mo73732KQ(className);
        C4990ab.m7416i("ActivityActionWrapper", "habbyge-mali, setStartActivityAction_pause: ".concat(String.valueOf(canonicalName)));
        C38989b.bqC().lMN.mo73734KS(canonicalName);
        C27897a.m44362uX(0);
        if (!(className == null || this.lMG == null)) {
            this.lMG.mo7211KM(className);
        }
        AppMethodBeat.m2505o(73401);
    }
}
