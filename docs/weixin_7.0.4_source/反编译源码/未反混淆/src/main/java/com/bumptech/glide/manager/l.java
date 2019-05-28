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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.i;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class l implements Callback {
    private static final a aGQ = new a() {
        public final j a(c cVar, h hVar, m mVar, Context context) {
            AppMethodBeat.i(92394);
            j jVar = new j(cVar, hVar, mVar, context);
            AppMethodBeat.o(92394);
            return jVar;
        }
    };
    private volatile j aGJ;
    final Map<FragmentManager, k> aGK = new HashMap();
    final Map<i, SupportRequestManagerFragment> aGL = new HashMap();
    private final a aGM;
    private final android.support.v4.f.a<View, Fragment> aGN = new android.support.v4.f.a();
    private final android.support.v4.f.a<View, android.app.Fragment> aGO = new android.support.v4.f.a();
    private final Bundle aGP = new Bundle();
    private final Handler handler;

    public interface a {
        j a(c cVar, h hVar, m mVar, Context context);
    }

    public l(a aVar) {
        AppMethodBeat.i(92395);
        if (aVar == null) {
            aVar = aGQ;
        }
        this.aGM = aVar;
        this.handler = new Handler(Looper.getMainLooper(), this);
        AppMethodBeat.o(92395);
    }

    private j ag(Context context) {
        AppMethodBeat.i(92396);
        if (this.aGJ == null) {
            synchronized (this) {
                try {
                    if (this.aGJ == null) {
                        this.aGJ = this.aGM.a(c.ae(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(92396);
                    }
                }
            }
        }
        j jVar = this.aGJ;
        AppMethodBeat.o(92396);
        return jVar;
    }

    public final j ah(Context context) {
        AppMethodBeat.i(92397);
        Context context2 = context;
        while (context2 != null) {
            j a;
            if (com.bumptech.glide.h.j.on() && !(context2 instanceof Application)) {
                if (context2 instanceof FragmentActivity) {
                    a = a((FragmentActivity) context2);
                    AppMethodBeat.o(92397);
                    return a;
                } else if (context2 instanceof Activity) {
                    a = h((Activity) context2);
                    AppMethodBeat.o(92397);
                    return a;
                } else if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            a = ag(context2);
            AppMethodBeat.o(92397);
            return a;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot start a load on a null Context");
        AppMethodBeat.o(92397);
        throw illegalArgumentException;
    }

    private j a(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(92398);
        j ah;
        if (com.bumptech.glide.h.j.oo()) {
            ah = ah(fragmentActivity.getApplicationContext());
            AppMethodBeat.o(92398);
            return ah;
        }
        i(fragmentActivity);
        ah = a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), j(fragmentActivity));
        AppMethodBeat.o(92398);
        return ah;
    }

    private j h(Activity activity) {
        AppMethodBeat.i(92399);
        j ah;
        if (com.bumptech.glide.h.j.oo()) {
            ah = ah(activity.getApplicationContext());
            AppMethodBeat.o(92399);
            return ah;
        }
        i(activity);
        ah = a((Context) activity, activity.getFragmentManager(), j(activity));
        AppMethodBeat.o(92399);
        return ah;
    }

    @TargetApi(17)
    private static void i(Activity activity) {
        AppMethodBeat.i(92400);
        if (VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            AppMethodBeat.o(92400);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot start a load for a destroyed activity");
        AppMethodBeat.o(92400);
        throw illegalArgumentException;
    }

    /* Access modifiers changed, original: final */
    public final k a(FragmentManager fragmentManager, boolean z) {
        AppMethodBeat.i(92401);
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null) {
            kVar = (k) this.aGK.get(fragmentManager);
            if (kVar == null) {
                kVar = new k();
                kVar.aGH = null;
                if (z) {
                    kVar.aGD.onStart();
                }
                this.aGK.put(fragmentManager, kVar);
                fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.handler.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        AppMethodBeat.o(92401);
        return kVar;
    }

    @Deprecated
    private j a(Context context, FragmentManager fragmentManager, boolean z) {
        AppMethodBeat.i(92402);
        k a = a(fragmentManager, z);
        j jVar = a.awX;
        if (jVar == null) {
            jVar = this.aGM.a(c.ae(context), a.aGD, a.aGE, context);
            a.awX = jVar;
        }
        AppMethodBeat.o(92402);
        return jVar;
    }

    static boolean j(Activity activity) {
        AppMethodBeat.i(92403);
        if (activity.isFinishing()) {
            AppMethodBeat.o(92403);
            return false;
        }
        AppMethodBeat.o(92403);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final SupportRequestManagerFragment a(i iVar, boolean z) {
        AppMethodBeat.i(92404);
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) iVar.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            supportRequestManagerFragment = (SupportRequestManagerFragment) this.aGL.get(iVar);
            if (supportRequestManagerFragment == null) {
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                supportRequestManagerFragment.aGU = null;
                if (z) {
                    supportRequestManagerFragment.aGD.onStart();
                }
                this.aGL.put(iVar, supportRequestManagerFragment);
                iVar.beginTransaction().a((Fragment) supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.handler.obtainMessage(2, iVar).sendToTarget();
            }
        }
        AppMethodBeat.o(92404);
        return supportRequestManagerFragment;
    }

    private j a(Context context, i iVar, boolean z) {
        AppMethodBeat.i(92405);
        SupportRequestManagerFragment a = a(iVar, z);
        j jVar = a.awX;
        if (jVar == null) {
            jVar = this.aGM.a(c.ae(context), a.aGD, a.aGE, context);
            a.awX = jVar;
        }
        AppMethodBeat.o(92405);
        return jVar;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        AppMethodBeat.i(92406);
        boolean z = true;
        Object remove;
        switch (message.what) {
            case 1:
                FragmentManager obj2 = (FragmentManager) message.obj;
                remove = this.aGK.remove(obj2);
                break;
            case 2:
                i obj22 = (i) message.obj;
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
        AppMethodBeat.o(92406);
        return z;
    }

    static {
        AppMethodBeat.i(92407);
        AppMethodBeat.o(92407);
    }
}
