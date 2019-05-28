package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.p065f.C6197a;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.C8565j;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.manager.l */
public final class C45005l implements Callback {
    private static final C45004a aGQ = new C07851();
    private volatile C8565j aGJ;
    final Map<FragmentManager, C31981k> aGK = new HashMap();
    final Map<C0336i, SupportRequestManagerFragment> aGL = new HashMap();
    private final C45004a aGM;
    private final C6197a<View, Fragment> aGN = new C6197a();
    private final C6197a<View, android.app.Fragment> aGO = new C6197a();
    private final Bundle aGP = new Bundle();
    private final Handler handler;

    /* renamed from: com.bumptech.glide.manager.l$1 */
    class C07851 implements C45004a {
        C07851() {
        }

        /* renamed from: a */
        public final C8565j mo2259a(C8555c c8555c, C0783h c0783h, C37200m c37200m, Context context) {
            AppMethodBeat.m2504i(92394);
            C8565j c8565j = new C8565j(c8555c, c0783h, c37200m, context);
            AppMethodBeat.m2505o(92394);
            return c8565j;
        }
    }

    /* renamed from: com.bumptech.glide.manager.l$a */
    public interface C45004a {
        /* renamed from: a */
        C8565j mo2259a(C8555c c8555c, C0783h c0783h, C37200m c37200m, Context context);
    }

    public C45005l(C45004a c45004a) {
        AppMethodBeat.m2504i(92395);
        if (c45004a == null) {
            c45004a = aGQ;
        }
        this.aGM = c45004a;
        this.handler = new Handler(Looper.getMainLooper(), this);
        AppMethodBeat.m2505o(92395);
    }

    /* renamed from: ag */
    private C8565j m82433ag(Context context) {
        AppMethodBeat.m2504i(92396);
        if (this.aGJ == null) {
            synchronized (this) {
                try {
                    if (this.aGJ == null) {
                        this.aGJ = this.aGM.mo2259a(C8555c.m15204ae(context.getApplicationContext()), new C31978b(), new C0782g(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92396);
                    }
                }
            }
        }
        C8565j c8565j = this.aGJ;
        AppMethodBeat.m2505o(92396);
        return c8565j;
    }

    /* renamed from: ah */
    public final C8565j mo72290ah(Context context) {
        AppMethodBeat.m2504i(92397);
        Context context2 = context;
        while (context2 != null) {
            C8565j a;
            if (C45002j.m82427on() && !(context2 instanceof Application)) {
                if (context2 instanceof FragmentActivity) {
                    a = m82432a((FragmentActivity) context2);
                    AppMethodBeat.m2505o(92397);
                    return a;
                } else if (context2 instanceof Activity) {
                    a = m82434h((Activity) context2);
                    AppMethodBeat.m2505o(92397);
                    return a;
                } else if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            a = m82433ag(context2);
            AppMethodBeat.m2505o(92397);
            return a;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot start a load on a null Context");
        AppMethodBeat.m2505o(92397);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private C8565j m82432a(FragmentActivity fragmentActivity) {
        AppMethodBeat.m2504i(92398);
        C8565j ah;
        if (C45002j.m82428oo()) {
            ah = mo72290ah(fragmentActivity.getApplicationContext());
            AppMethodBeat.m2505o(92398);
            return ah;
        }
        C45005l.m82435i(fragmentActivity);
        ah = m82431a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), C45005l.m82436j(fragmentActivity));
        AppMethodBeat.m2505o(92398);
        return ah;
    }

    /* renamed from: h */
    private C8565j m82434h(Activity activity) {
        AppMethodBeat.m2504i(92399);
        C8565j ah;
        if (C45002j.m82428oo()) {
            ah = mo72290ah(activity.getApplicationContext());
            AppMethodBeat.m2505o(92399);
            return ah;
        }
        C45005l.m82435i(activity);
        ah = m82430a((Context) activity, activity.getFragmentManager(), C45005l.m82436j(activity));
        AppMethodBeat.m2505o(92399);
        return ah;
    }

    @TargetApi(17)
    /* renamed from: i */
    private static void m82435i(Activity activity) {
        AppMethodBeat.m2504i(92400);
        if (VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            AppMethodBeat.m2505o(92400);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot start a load for a destroyed activity");
        AppMethodBeat.m2505o(92400);
        throw illegalArgumentException;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C31981k mo72289a(FragmentManager fragmentManager, boolean z) {
        AppMethodBeat.m2504i(92401);
        C31981k c31981k = (C31981k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (c31981k == null) {
            c31981k = (C31981k) this.aGK.get(fragmentManager);
            if (c31981k == null) {
                c31981k = new C31981k();
                c31981k.aGH = null;
                if (z) {
                    c31981k.aGD.onStart();
                }
                this.aGK.put(fragmentManager, c31981k);
                fragmentManager.beginTransaction().add(c31981k, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.handler.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        AppMethodBeat.m2505o(92401);
        return c31981k;
    }

    @Deprecated
    /* renamed from: a */
    private C8565j m82430a(Context context, FragmentManager fragmentManager, boolean z) {
        AppMethodBeat.m2504i(92402);
        C31981k a = mo72289a(fragmentManager, z);
        C8565j c8565j = a.awX;
        if (c8565j == null) {
            c8565j = this.aGM.mo2259a(C8555c.m15204ae(context), a.aGD, a.aGE, context);
            a.awX = c8565j;
        }
        AppMethodBeat.m2505o(92402);
        return c8565j;
    }

    /* renamed from: j */
    static boolean m82436j(Activity activity) {
        AppMethodBeat.m2504i(92403);
        if (activity.isFinishing()) {
            AppMethodBeat.m2505o(92403);
            return false;
        }
        AppMethodBeat.m2505o(92403);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final SupportRequestManagerFragment mo72288a(C0336i c0336i, boolean z) {
        AppMethodBeat.m2504i(92404);
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) c0336i.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            supportRequestManagerFragment = (SupportRequestManagerFragment) this.aGL.get(c0336i);
            if (supportRequestManagerFragment == null) {
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                supportRequestManagerFragment.aGU = null;
                if (z) {
                    supportRequestManagerFragment.aGD.onStart();
                }
                this.aGL.put(c0336i, supportRequestManagerFragment);
                c0336i.beginTransaction().mo555a((Fragment) supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.handler.obtainMessage(2, c0336i).sendToTarget();
            }
        }
        AppMethodBeat.m2505o(92404);
        return supportRequestManagerFragment;
    }

    /* renamed from: a */
    private C8565j m82431a(Context context, C0336i c0336i, boolean z) {
        AppMethodBeat.m2504i(92405);
        SupportRequestManagerFragment a = mo72288a(c0336i, z);
        C8565j c8565j = a.awX;
        if (c8565j == null) {
            c8565j = this.aGM.mo2259a(C8555c.m15204ae(context), a.aGD, a.aGE, context);
            a.awX = c8565j;
        }
        AppMethodBeat.m2505o(92405);
        return c8565j;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        AppMethodBeat.m2504i(92406);
        boolean z = true;
        Object remove;
        switch (message.what) {
            case 1:
                FragmentManager obj2 = (FragmentManager) message.obj;
                remove = this.aGK.remove(obj2);
                break;
            case 2:
                C0336i obj22 = (C0336i) message.obj;
                remove = this.aGL.remove(obj22);
                break;
            default:
                z = false;
                obj22 = null;
                remove = null;
                break;
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            new StringBuilder("Failed to remove expected request manager fragment, manager: ").append(obj22);
        }
        AppMethodBeat.m2505o(92406);
        return z;
    }

    static {
        AppMethodBeat.m2504i(92407);
        AppMethodBeat.m2505o(92407);
    }
}
