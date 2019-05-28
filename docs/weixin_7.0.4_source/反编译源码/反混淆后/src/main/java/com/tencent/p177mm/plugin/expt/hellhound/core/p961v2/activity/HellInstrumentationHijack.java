package com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.v2.activity.HellInstrumentationHijack */
public class HellInstrumentationHijack extends Instrumentation {
    private C34078e lMJ;
    Instrumentation lMK = null;

    HellInstrumentationHijack(C34078e c34078e) {
        this.lMJ = c34078e;
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(73412);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru.callActivityOnCreate: " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23548c(activity.getIntent(), activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnCreate callback", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                this.lMK.callActivityOnCreate(activity, bundle);
                AppMethodBeat.m2505o(73412);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnCreate", new Object[0]);
                try {
                    super.callActivityOnCreate(activity, bundle);
                    AppMethodBeat.m2505o(73412);
                    return;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnCreate 1", new Object[0]);
                    C7060h.pYm.mo8378a(932, 28, 1, false);
                    AppMethodBeat.m2505o(73412);
                    return;
                }
            }
        }
        super.callActivityOnCreate(activity, bundle);
        AppMethodBeat.m2505o(73412);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        AppMethodBeat.m2504i(73413);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru.callActivityOnCreate activity: " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23548c(activity.getIntent(), activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnCreate callback ", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                if (VERSION.SDK_INT >= 21) {
                    this.lMK.callActivityOnCreate(activity, bundle, persistableBundle);
                }
                AppMethodBeat.m2505o(73413);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnCreate ", new Object[0]);
                try {
                    super.callActivityOnCreate(activity, bundle, persistableBundle);
                    AppMethodBeat.m2505o(73413);
                    return;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnCreate 2", new Object[0]);
                    C7060h.pYm.mo8378a(932, 29, 1, false);
                    AppMethodBeat.m2505o(73413);
                    return;
                }
            }
        }
        super.callActivityOnCreate(activity, bundle, persistableBundle);
        AppMethodBeat.m2505o(73413);
    }

    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        AppMethodBeat.m2504i(73414);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru.callActivityOnNewIntent = " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23549d(intent, activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnNewIntent callback", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                this.lMK.callActivityOnNewIntent(activity, intent);
                AppMethodBeat.m2505o(73414);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnNewIntent", new Object[0]);
                try {
                    super.callActivityOnNewIntent(activity, intent);
                    AppMethodBeat.m2505o(73414);
                    return;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnNewIntent 2", new Object[0]);
                    C7060h.pYm.mo8378a(932, 30, 1, false);
                    AppMethodBeat.m2505o(73414);
                    return;
                }
            }
        }
        super.callActivityOnNewIntent(activity, intent);
        AppMethodBeat.m2505o(73414);
    }

    public void callActivityOnResume(Activity activity) {
        AppMethodBeat.m2504i(73415);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru-callActivityOnResume: " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23541G(activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnResume callback", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                this.lMK.callActivityOnResume(activity);
                AppMethodBeat.m2505o(73415);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnResume", new Object[0]);
                try {
                    super.callActivityOnResume(activity);
                    AppMethodBeat.m2505o(73415);
                    return;
                } catch (Exception e22) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e22, "Instru.callActivityOnResume 2", new Object[0]);
                    C7060h.pYm.mo8378a(932, 31, 1, false);
                    C4990ab.m7410d("HellInstrumentationHijack", "Instru:sIsTopOfTaskRet = " + C11760b.lME);
                    try {
                        Class cls = Class.forName("android.app.Activity");
                        Field declaredField = cls.getDeclaredField("mActivityTransitionState");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(activity);
                        Method declaredMethod = Class.forName("android.app.ActivityTransitionState").getDeclaredMethod("onResume", new Class[]{Activity.class, Boolean.TYPE});
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(obj, new Object[]{activity, Boolean.valueOf(C11760b.lME)});
                        Field declaredField2 = cls.getDeclaredField("mCalled");
                        declaredField2.setAccessible(true);
                        declaredField2.set(activity, Boolean.TRUE);
                        AppMethodBeat.m2505o(73415);
                        return;
                    } catch (Exception e222) {
                        C4990ab.printErrStackTrace("HellInstrumentationHijack", e222, "Instru:resume-e2", new Object[0]);
                        C7060h.pYm.mo8378a(932, 81, 1, false);
                        AppMethodBeat.m2505o(73415);
                        return;
                    }
                }
            }
        }
        super.callActivityOnResume(activity);
        AppMethodBeat.m2505o(73415);
    }

    public void callActivityOnPause(Activity activity) {
        AppMethodBeat.m2504i(73416);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru-callActivityOnPause: activity = " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23542H(activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnResume callback", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                this.lMK.callActivityOnPause(activity);
                AppMethodBeat.m2505o(73416);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnResume", new Object[0]);
            }
        }
        super.callActivityOnPause(activity);
        AppMethodBeat.m2505o(73416);
    }

    public void callActivityOnStop(Activity activity) {
        AppMethodBeat.m2504i(73417);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru-callActivityOnStop: activity = " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23543I(activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnStop callback", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                this.lMK.callActivityOnStop(activity);
                AppMethodBeat.m2505o(73417);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnStop", new Object[0]);
                try {
                    super.callActivityOnStop(activity);
                    AppMethodBeat.m2505o(73417);
                    return;
                } catch (Exception e22) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e22, "Instru.callActivityOnStop 2", new Object[0]);
                    C7060h.pYm.mo8378a(932, 32, 1, false);
                    AppMethodBeat.m2505o(73417);
                    return;
                }
            }
        }
        super.callActivityOnStop(activity);
        AppMethodBeat.m2505o(73417);
    }

    public void callActivityOnDestroy(Activity activity) {
        AppMethodBeat.m2504i(73418);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru-callActivityOnDestroy: activity = " + activity.getClass().getCanonicalName());
        try {
            if (this.lMJ != null) {
                this.lMJ.mo23544J(activity);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.callActivityOnDestroy callback", new Object[0]);
        }
        if (this.lMK != null) {
            try {
                this.lMK.callActivityOnDestroy(activity);
                AppMethodBeat.m2505o(73418);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "Instru.callActivityOnDestroy", new Object[0]);
                try {
                    super.callActivityOnDestroy(activity);
                    AppMethodBeat.m2505o(73418);
                    return;
                } catch (Exception e22) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e22, "Instru.callActivityOnDestroy 2", new Object[0]);
                    AppMethodBeat.m2505o(73418);
                    return;
                }
            }
        }
        super.callActivityOnDestroy(activity);
        AppMethodBeat.m2505o(73418);
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        AppMethodBeat.m2504i(73419);
        C4990ab.m7410d("HellInstrumentationHijack", "Instru-newActivity: ".concat(String.valueOf(str)));
        Activity newActivity;
        if (this.lMK != null) {
            try {
                newActivity = this.lMK.newActivity(classLoader, str, intent);
                AppMethodBeat.m2505o(73419);
                return newActivity;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.newActivity", new Object[0]);
                try {
                    newActivity = super.newActivity(classLoader, str, intent);
                    AppMethodBeat.m2505o(73419);
                    return newActivity;
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.newActivity 1", new Object[0]);
                    C7060h.pYm.mo8378a(932, 33, 1, false);
                    AppMethodBeat.m2505o(73419);
                    return null;
                }
            }
        }
        newActivity = super.newActivity(classLoader, str, intent);
        AppMethodBeat.m2505o(73419);
        return newActivity;
    }

    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
        AppMethodBeat.m2504i(73420);
        Activity newActivity;
        if (this.lMK != null) {
            try {
                newActivity = this.lMK.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
                AppMethodBeat.m2505o(73420);
                return newActivity;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.newActivity crash", new Object[0]);
                try {
                    newActivity = super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
                    AppMethodBeat.m2505o(73420);
                    return newActivity;
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru.newActivity crash 2", new Object[0]);
                    C7060h.pYm.mo8378a(932, 34, 1, false);
                    AppMethodBeat.m2505o(73420);
                    return null;
                }
            }
        }
        newActivity = super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
        AppMethodBeat.m2505o(73420);
        return newActivity;
    }

    public ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(73421);
        C4990ab.m7416i("HellInstrumentationHijack", "execStartActivity-Activity-Target, fromActivity: " + context.getClass().getCanonicalName());
        m19577u(context, intent);
        ActivityResult a = m19574a(context, iBinder, iBinder2, activity, intent, i, bundle);
        AppMethodBeat.m2505o(73421);
        return a;
    }

    public ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(73422);
        C4990ab.m7416i("HellInstrumentationHijack", "execStartActivity-String-Target, fromActivity: " + context.getClass().getCanonicalName());
        m19577u(context, intent);
        ActivityResult a = m19575a(context, iBinder, iBinder2, str, intent, i, bundle);
        AppMethodBeat.m2505o(73422);
        return a;
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: a */
    private ActivityResult m19574a(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(73423);
        try {
            Method declaredMethod = Instrumentation.class.getDeclaredMethod("execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class});
            declaredMethod.setAccessible(true);
            if (this.lMK != null) {
                C4990ab.m7410d("HellInstrumentationHijack", "execStartActivityOfSystem-0");
                try {
                    ActivityResult activityResult = (ActivityResult) declaredMethod.invoke(this.lMK, new Object[]{context, iBinder, iBinder2, activity, intent, Integer.valueOf(i), bundle});
                    AppMethodBeat.m2505o(73423);
                    return activityResult;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "execStartActivityOfSystem-1 crash", new Object[0]);
                    C4990ab.m7412e("HellInstrumentationHijack", "gStartActivityRet-0: " + C11760b.lMF);
                    HellInstrumentationHijack.m19576j(C11760b.lMF, intent);
                    AppMethodBeat.m2505o(73423);
                    return null;
                }
            }
            AppMethodBeat.m2505o(73423);
            return null;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "execStartActivityOfSystem-0 crash", new Object[0]);
            C7060h.pYm.mo8378a(932, 27, 1, false);
            AppMethodBeat.m2505o(73423);
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: a */
    private ActivityResult m19575a(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(73424);
        try {
            Method declaredMethod = Instrumentation.class.getDeclaredMethod("execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, String.class, Intent.class, Integer.TYPE, Bundle.class});
            declaredMethod.setAccessible(true);
            if (this.lMK != null) {
                try {
                    C4990ab.m7410d("HellInstrumentationHijack", "execStartActivityOfSystem-1");
                    ActivityResult activityResult = (ActivityResult) declaredMethod.invoke(this.lMK, new Object[]{context, iBinder, iBinder2, str, intent, Integer.valueOf(i), bundle});
                    AppMethodBeat.m2505o(73424);
                    return activityResult;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "execStartActivityOfSystem-1-1", new Object[0]);
                    C4990ab.m7412e("HellInstrumentationHijack", "gStartActivityRet-1: " + C11760b.lMF);
                    HellInstrumentationHijack.m19576j(C11760b.lMF, intent);
                    AppMethodBeat.m2505o(73424);
                    return null;
                }
            }
            AppMethodBeat.m2505o(73424);
            return null;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e2, "execStartActivityOfSystem-1-0", new Object[0]);
            AppMethodBeat.m2505o(73424);
            return null;
        }
    }

    /* renamed from: j */
    private static void m19576j(int i, Object obj) {
        AppMethodBeat.m2504i(73425);
        try {
            Method declaredMethod = Instrumentation.class.getDeclaredMethod("checkStartActivityResult", new Class[]{Integer.TYPE, Object.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{Integer.valueOf(i), obj});
            AppMethodBeat.m2505o(73425);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "_checkStartActivityResult-0", new Object[0]);
            AppMethodBeat.m2505o(73425);
        }
    }

    /* renamed from: u */
    private void m19577u(Context context, Intent intent) {
        AppMethodBeat.m2504i(73426);
        if (context == null || intent == null) {
            AppMethodBeat.m2505o(73426);
            return;
        }
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        try {
            this.lMJ.mo23545a(activity, intent);
            AppMethodBeat.m2505o(73426);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellInstrumentationHijack", e, "Instru-callbackStartActivity callback exception", new Object[0]);
            AppMethodBeat.m2505o(73426);
        }
    }
}
