package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class k implements ab {
    public Activity gNy;
    FrameLayout gOA;
    public final LinkedList<i> gOB;
    public final HashMap<String, i> gOC;
    public final i gOD;
    private Class<? extends i> gOE;
    boolean gOF = false;
    boolean gOG = false;

    public k(i iVar, Class<? extends i> cls) {
        AppMethodBeat.i(86718);
        this.gNy = iVar.getContext();
        this.gOB = new LinkedList();
        this.gOC = new HashMap();
        this.gOA = iVar.aLY();
        this.gOD = iVar;
        this.gOE = cls;
        this.gNy.getApplication().registerActivityLifecycleCallbacks(new a() {
            public final void onActivityResumed(Activity activity) {
                if (k.this.gNy == activity) {
                    k.this.gOF = true;
                    k.this.gOG = false;
                }
            }

            public final void onActivityPaused(Activity activity) {
                if (k.this.gNy == activity) {
                    k.this.gOF = false;
                    k.this.gOG = true;
                }
            }

            public final void onActivityDestroyed(Activity activity) {
                AppMethodBeat.i(86710);
                k.this.gNy.getApplication().unregisterActivityLifecycleCallbacks(this);
                AppMethodBeat.o(86710);
            }
        });
        AppMethodBeat.o(86718);
    }

    public i e(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(86720);
        i iVar = (i) org.a.a.be(this.gOE).ab(this.gNy, this).object;
        AppMethodBeat.o(86720);
        return iVar;
    }

    public void b(i iVar, i iVar2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(86721);
        i(iVar2);
        h(iVar2);
        iVar2.gNA = iVar;
        iVar2.a(appBrandInitConfig);
        if (iVar != null) {
            iVar.atk();
            iVar2.atl();
        }
        AppMethodBeat.o(86721);
    }

    public void a(final i iVar, final MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        AppMethodBeat.i(86722);
        if (iVar == null) {
            AppMethodBeat.o(86722);
            return;
        }
        this.gOD.getContext().runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86712);
                if (k.this.g(iVar)) {
                    String str;
                    final i d = k.this.d(iVar);
                    if (d != null) {
                        d.a(iVar.yf(), miniProgramNavigationBackResult);
                    }
                    String str2 = "MicroMsg.AppBrandRuntimeContainer";
                    String str3 = "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = iVar.mAppId;
                    if (d == null) {
                        str = BuildConfig.COMMAND;
                    } else {
                        str = d.mAppId;
                    }
                    objArr[1] = str;
                    objArr[2] = Boolean.valueOf(k.this.gOF);
                    d.i(str2, str3, objArr);
                    k.this.b(d, iVar, new Runnable() {
                        public final void run() {
                            String str;
                            AppMethodBeat.i(86711);
                            iVar.gNE.setVisibility(8);
                            k.this.gOB.remove(iVar);
                            k.this.gOC.put(iVar.mAppId, iVar);
                            if (d != null) {
                                k.this.i(d);
                                k.this.h(d);
                            }
                            iVar.atk();
                            if (k.this.gOF && d != null) {
                                d.atl();
                            }
                            String str2 = "MicroMsg.AppBrandRuntimeContainer";
                            String str3 = "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]";
                            Object[] objArr = new Object[3];
                            objArr[0] = iVar.mAppId;
                            if (d == null) {
                                str = BuildConfig.COMMAND;
                            } else {
                                str = d.mAppId;
                            }
                            objArr[1] = str;
                            objArr[2] = Boolean.valueOf(k.this.gOF);
                            d.i(str2, str3, objArr);
                            AppMethodBeat.o(86711);
                        }
                    });
                    AppMethodBeat.o(86712);
                    return;
                }
                d.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", iVar.mAppId);
                AppMethodBeat.o(86712);
            }
        });
        AppMethodBeat.o(86722);
    }

    /* Access modifiers changed, original: protected */
    public void b(i iVar, i iVar2, Runnable runnable) {
        String str;
        AppMethodBeat.i(86723);
        String str2 = "MicroMsg.AppBrandRuntimeContainer";
        String str3 = "onRuntimeClose entered, in.appId[%s], out.appId[%s]";
        Object[] objArr = new Object[2];
        if (iVar == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = iVar.mAppId;
        }
        objArr[0] = str;
        objArr[1] = iVar2.mAppId;
        d.i(str2, str3, objArr);
        runnable.run();
        AppMethodBeat.o(86723);
    }

    public final i atv() {
        AppMethodBeat.i(86724);
        i iVar = (i) this.gOB.peek();
        AppMethodBeat.o(86724);
        return iVar;
    }

    public final i d(i iVar) {
        AppMethodBeat.i(86725);
        if (iVar == null) {
            NullPointerException nullPointerException = new NullPointerException("Null runtime");
            AppMethodBeat.o(86725);
            throw nullPointerException;
        }
        ListIterator listIterator = this.gOB.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            i iVar2 = (i) listIterator.next();
            if (iVar2 == iVar) {
                i = 1;
            } else if (i != 0) {
                AppMethodBeat.o(86725);
                return iVar2;
            }
        }
        if (i == 0) {
            IllegalAccessError illegalAccessError = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[]{iVar.mAppId}));
            AppMethodBeat.o(86725);
            throw illegalAccessError;
        }
        AppMethodBeat.o(86725);
        return null;
    }

    public final int atw() {
        AppMethodBeat.i(86726);
        int size = this.gOB.size();
        AppMethodBeat.o(86726);
        return size;
    }

    public final boolean e(i iVar) {
        AppMethodBeat.i(86727);
        boolean contains = this.gOB.contains(iVar);
        AppMethodBeat.o(86727);
        return contains;
    }

    public final void onResume() {
        AppMethodBeat.i(86728);
        d.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", Long.valueOf(Thread.currentThread().getId()));
        this.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86714);
                i atv = k.this.atv();
                if (atv != null) {
                    atv.atl();
                }
                AppMethodBeat.o(86714);
            }
        });
        AppMethodBeat.o(86728);
    }

    public void onBackPressed() {
        AppMethodBeat.i(86729);
        i atv = atv();
        if (atv != null) {
            try {
                if (atv.gNF != null) {
                    g.a(atv.mAppId, g.d.BACK);
                    atv.finish();
                } else if (!(atv.gNG.wY() || atv.gND == null)) {
                    atv.gND.onBackPressed();
                    AppMethodBeat.o(86729);
                    return;
                }
                AppMethodBeat.o(86729);
                return;
            } catch (Exception e) {
                d.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", e);
                al.d(new Runnable() {
                    public final void run() {
                        throw e;
                    }
                });
            }
        }
        AppMethodBeat.o(86729);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(86730);
        if (this.gOB != null) {
            Iterator it = this.gOB.iterator();
            while (it.hasNext()) {
                ((i) it.next()).onConfigurationChanged(configuration);
            }
        }
        AppMethodBeat.o(86730);
    }

    public final void f(final i iVar) {
        AppMethodBeat.i(86731);
        if (iVar == null) {
            AppMethodBeat.o(86731);
            return;
        }
        this.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86715);
                k.a(k.this, iVar);
                AppMethodBeat.o(86715);
            }
        });
        AppMethodBeat.o(86731);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean g(i iVar) {
        AppMethodBeat.i(86732);
        if (this.gOB.peekFirst() == iVar) {
            AppMethodBeat.o(86732);
            return true;
        }
        AppMethodBeat.o(86732);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void h(i iVar) {
        AppMethodBeat.i(86733);
        this.gOB.remove(iVar);
        this.gOB.push(iVar);
        iVar.gNE.setVisibility(0);
        this.gOA.bringChildToFront(iVar.gNE);
        AppMethodBeat.o(86733);
    }

    /* Access modifiers changed, original: final */
    public final void i(i iVar) {
        AppMethodBeat.i(86734);
        if (this.gOB.contains(iVar)) {
            AppMethodBeat.o(86734);
            return;
        }
        this.gOB.push(iVar);
        if (this.gOA.indexOfChild(iVar.gNE) == -1) {
            this.gOA.addView(iVar.gNE);
        }
        this.gOC.remove(iVar.mAppId);
        AppMethodBeat.o(86734);
    }

    public final void atx() {
        AppMethodBeat.i(86735);
        Iterator it = this.gOB.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            iVar.gNE.setVisibility(8);
            this.gOC.put(iVar.mAppId, iVar);
            iVar.atp();
        }
        this.gOB.clear();
        AppMethodBeat.o(86735);
    }

    public final void j(i iVar) {
        AppMethodBeat.i(86736);
        if (iVar == null) {
            AppMethodBeat.o(86736);
            return;
        }
        this.gOB.remove(iVar);
        AppMethodBeat.o(86736);
    }

    /* Access modifiers changed, original: protected|final */
    public final LinkedList<i> aty() {
        AppMethodBeat.i(86737);
        LinkedList linkedList = new LinkedList(this.gOB);
        AppMethodBeat.o(86737);
        return linkedList;
    }

    public final i atz() {
        return this.gOD;
    }

    public void a(i iVar, i iVar2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(86719);
        iVar2.gNA = iVar;
        iVar2.c(appBrandInitConfig);
        this.gOB.push(iVar2);
        this.gOA.addView(iVar2.gNE);
        if (iVar != null) {
            iVar.atk();
        }
        iVar2.asS();
        AppMethodBeat.o(86719);
    }
}
