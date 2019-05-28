package com.tencent.p177mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p638d.C30834a;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.p177mm.vending.p639e.C7359c;
import com.tencent.p177mm.vending.p640f.C5687a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.app.c */
public final class C40919c implements C5685b {
    /* renamed from: d */
    private int f16223d = 0;
    private C30831b zXh = C30831b.dMb();
    private C16025a zXj;
    private C24135b<? extends C16025a> zXk;
    private C7359c zXl = new C7359c();

    public C40919c() {
        AppMethodBeat.m2504i(126081);
        AppMethodBeat.m2505o(126081);
    }

    /* renamed from: aI */
    private synchronized <T extends C24135b<? extends C16025a>> T m70933aI(Class<? extends C24135b<? extends C16025a>> cls) {
        T t;
        AppMethodBeat.m2504i(126082);
        if (this.zXk == null) {
            try {
                this.zXk = (C24135b) cls.newInstance();
                if (this.zXj == null) {
                    this.zXj = (C16025a) this.zXk.aog();
                }
                m70932a();
                t = this.zXk;
                AppMethodBeat.m2505o(126082);
            } catch (IllegalAccessException | InstantiationException e) {
                InternalError internalError = new InternalError("Could not create interactor api instance : " + cls.toString());
                AppMethodBeat.m2505o(126082);
                throw internalError;
            }
        } else if (cls.isInstance(this.zXk)) {
            t = this.zXk;
            AppMethodBeat.m2505o(126082);
        } else {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
            AppMethodBeat.m2505o(126082);
            throw illegalAccessError;
        }
        return t;
    }

    /* renamed from: aJ */
    private synchronized <T extends C16025a> T m70934aJ(Class<? extends C16025a> cls) {
        T t;
        AppMethodBeat.m2504i(126083);
        if (this.zXk != null) {
            t = (C16025a) this.zXk.aog();
            AppMethodBeat.m2505o(126083);
        } else if (this.zXj == null) {
            try {
                this.zXj = (C16025a) cls.newInstance();
                m70932a();
                t = this.zXj;
                AppMethodBeat.m2505o(126083);
            } catch (IllegalAccessException | InstantiationException e) {
                InternalError internalError = new InternalError("Could not create interactor instance : " + cls.toString());
                AppMethodBeat.m2505o(126083);
                throw internalError;
            }
        } else if (cls.isInstance(this.zXj)) {
            t = this.zXj;
            AppMethodBeat.m2505o(126083);
        } else {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
            AppMethodBeat.m2505o(126083);
            throw illegalAccessError;
        }
        return t;
    }

    /* renamed from: a */
    private void m70932a() {
        AppMethodBeat.m2504i(126084);
        if (this.zXh != null) {
            this.zXh.mo49321a(this, this.zXj);
        }
        AppMethodBeat.m2505o(126084);
    }

    /* renamed from: z */
    private synchronized void m70935z(Intent intent, Context context) {
        AppMethodBeat.m2504i(126085);
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zXj);
        this.zXj.f3004j = context;
        this.zXj.zXe = new C30834a(intent);
        AppMethodBeat.m2505o(126085);
    }

    /* renamed from: SK */
    public final synchronized C16025a mo64540SK() {
        C16025a c16025a;
        AppMethodBeat.m2504i(126086);
        if (this.zXj == null && this.zXh != null) {
            this.zXj = (C16025a) this.zXh.f13766b.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zXj);
        c16025a = this.zXj;
        AppMethodBeat.m2505o(126086);
        return c16025a;
    }

    /* renamed from: a */
    public final <T extends C24135b<? extends C16025a>> T mo64541a(Activity activity, Class<? extends C24135b<? extends C16025a>> cls) {
        AppMethodBeat.m2504i(126087);
        if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            C5687a.m8541e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
            AppMethodBeat.m2505o(126087);
            return null;
        }
        T aI = m70933aI(cls);
        AppMethodBeat.m2505o(126087);
        return aI;
    }

    /* renamed from: b */
    public final <T extends C16025a> T mo64543b(Activity activity, Class<? extends C16025a> cls) {
        AppMethodBeat.m2504i(126088);
        if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            C5687a.m8541e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
            AppMethodBeat.m2505o(126088);
            return null;
        }
        T aJ = m70934aJ(cls);
        AppMethodBeat.m2505o(126088);
        return aJ;
    }

    /* renamed from: a */
    public final void mo64542a(int i) {
        AppMethodBeat.m2504i(126089);
        this.f16223d = i;
        C30831b c30831b = this.zXh;
        C16025a c16025a = (C16025a) c30831b.f13766b.get(this);
        if (c16025a != null) {
            switch (i) {
                case 1:
                    C5687a.m8542i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", c16025a, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    C5687a.m8542i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", c16025a, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    c30831b.f13766b.remove(this);
                    break;
                default:
                    C5687a.m8542i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", Integer.valueOf(i), c16025a, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    AppMethodBeat.m2505o(126089);
                    return;
            }
            c30831b.f13767d.sendMessage(c30831b.f13767d.obtainMessage(i, c16025a));
        }
        c30831b.zXi.put(hashCode(), i);
        AppMethodBeat.m2505o(126089);
    }

    /* renamed from: A */
    public final void mo64539A(Intent intent, Context context) {
        AppMethodBeat.m2504i(126090);
        m70935z(intent, context);
        mo64542a(1);
        AppMethodBeat.m2505o(126090);
    }

    public final void keep(C5684a c5684a) {
        AppMethodBeat.m2504i(126091);
        Assert.assertTrue("target must be a ILifeCycle", c5684a instanceof C5684a);
        this.zXl.keep(c5684a);
        AppMethodBeat.m2505o(126091);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(126092);
        this.zXl.dead();
        mo64542a(4);
        AppMethodBeat.m2505o(126092);
    }
}
