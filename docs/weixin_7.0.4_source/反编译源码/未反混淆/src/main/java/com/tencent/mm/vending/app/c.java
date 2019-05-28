package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.d.a;
import com.tencent.mm.vending.e.b;
import junit.framework.Assert;

public final class c implements b {
    private int d = 0;
    private b zXh = b.dMb();
    private a zXj;
    private com.tencent.mm.vending.c.b<? extends a> zXk;
    private com.tencent.mm.vending.e.c zXl = new com.tencent.mm.vending.e.c();

    public c() {
        AppMethodBeat.i(126081);
        AppMethodBeat.o(126081);
    }

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T aI(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        AppMethodBeat.i(126082);
        if (this.zXk == null) {
            try {
                this.zXk = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.zXj == null) {
                    this.zXj = (a) this.zXk.aog();
                }
                a();
                t = this.zXk;
                AppMethodBeat.o(126082);
            } catch (IllegalAccessException | InstantiationException e) {
                InternalError internalError = new InternalError("Could not create interactor api instance : " + cls.toString());
                AppMethodBeat.o(126082);
                throw internalError;
            }
        } else if (cls.isInstance(this.zXk)) {
            t = this.zXk;
            AppMethodBeat.o(126082);
        } else {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
            AppMethodBeat.o(126082);
            throw illegalAccessError;
        }
        return t;
    }

    private synchronized <T extends a> T aJ(Class<? extends a> cls) {
        T t;
        AppMethodBeat.i(126083);
        if (this.zXk != null) {
            t = (a) this.zXk.aog();
            AppMethodBeat.o(126083);
        } else if (this.zXj == null) {
            try {
                this.zXj = (a) cls.newInstance();
                a();
                t = this.zXj;
                AppMethodBeat.o(126083);
            } catch (IllegalAccessException | InstantiationException e) {
                InternalError internalError = new InternalError("Could not create interactor instance : " + cls.toString());
                AppMethodBeat.o(126083);
                throw internalError;
            }
        } else if (cls.isInstance(this.zXj)) {
            t = this.zXj;
            AppMethodBeat.o(126083);
        } else {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
            AppMethodBeat.o(126083);
            throw illegalAccessError;
        }
        return t;
    }

    private void a() {
        AppMethodBeat.i(126084);
        if (this.zXh != null) {
            this.zXh.a(this, this.zXj);
        }
        AppMethodBeat.o(126084);
    }

    private synchronized void z(Intent intent, Context context) {
        AppMethodBeat.i(126085);
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zXj);
        this.zXj.j = context;
        this.zXj.zXe = new a(intent);
        AppMethodBeat.o(126085);
    }

    public final synchronized a SK() {
        a aVar;
        AppMethodBeat.i(126086);
        if (this.zXj == null && this.zXh != null) {
            this.zXj = (a) this.zXh.b.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zXj);
        aVar = this.zXj;
        AppMethodBeat.o(126086);
        return aVar;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        AppMethodBeat.i(126087);
        if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
            AppMethodBeat.o(126087);
            return null;
        }
        T aI = aI(cls);
        AppMethodBeat.o(126087);
        return aI;
    }

    public final <T extends a> T b(Activity activity, Class<? extends a> cls) {
        AppMethodBeat.i(126088);
        if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
            AppMethodBeat.o(126088);
            return null;
        }
        T aJ = aJ(cls);
        AppMethodBeat.o(126088);
        return aJ;
    }

    public final void a(int i) {
        AppMethodBeat.i(126089);
        this.d = i;
        b bVar = this.zXh;
        a aVar = (a) bVar.b.get(this);
        if (aVar != null) {
            switch (i) {
                case 1:
                    com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    bVar.b.remove(this);
                    break;
                default:
                    com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", Integer.valueOf(i), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    AppMethodBeat.o(126089);
                    return;
            }
            bVar.d.sendMessage(bVar.d.obtainMessage(i, aVar));
        }
        bVar.zXi.put(hashCode(), i);
        AppMethodBeat.o(126089);
    }

    public final void A(Intent intent, Context context) {
        AppMethodBeat.i(126090);
        z(intent, context);
        a(1);
        AppMethodBeat.o(126090);
    }

    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(126091);
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.zXl.keep(aVar);
        AppMethodBeat.o(126091);
    }

    public final void onDestroy() {
        AppMethodBeat.i(126092);
        this.zXl.dead();
        a(4);
        AppMethodBeat.o(126092);
    }
}
