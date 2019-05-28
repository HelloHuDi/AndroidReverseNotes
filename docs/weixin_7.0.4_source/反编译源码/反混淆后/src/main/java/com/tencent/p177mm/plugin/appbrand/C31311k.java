package com.tencent.p177mm.plugin.appbrand;

import android.app.Activity;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.p328r.C27276a;
import com.tencent.p177mm.plugin.appbrand.task.C38520i;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.p1430a.C41166a;

/* renamed from: com.tencent.mm.plugin.appbrand.k */
public class C31311k implements C26719ab {
    public Activity gNy;
    FrameLayout gOA;
    public final LinkedList<C6750i> gOB;
    public final HashMap<String, C6750i> gOC;
    public final C38520i gOD;
    private Class<? extends C6750i> gOE;
    boolean gOF = false;
    boolean gOG = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.k$4 */
    class C195324 implements Runnable {
        C195324() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86714);
            C6750i atv = C31311k.this.atv();
            if (atv != null) {
                atv.atl();
            }
            AppMethodBeat.m2505o(86714);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.k$1 */
    class C313141 extends C27276a {
        C313141() {
        }

        public final void onActivityResumed(Activity activity) {
            if (C31311k.this.gNy == activity) {
                C31311k.this.gOF = true;
                C31311k.this.gOG = false;
            }
        }

        public final void onActivityPaused(Activity activity) {
            if (C31311k.this.gNy == activity) {
                C31311k.this.gOF = false;
                C31311k.this.gOG = true;
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.m2504i(86710);
            C31311k.this.gNy.getApplication().unregisterActivityLifecycleCallbacks(this);
            AppMethodBeat.m2505o(86710);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.k$3 */
    public class C313153 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(86713);
            C6750i atv = C31311k.this.atv();
            if (atv != null) {
                atv.atk();
            }
            AppMethodBeat.m2505o(86713);
        }
    }

    public C31311k(C38520i c38520i, Class<? extends C6750i> cls) {
        AppMethodBeat.m2504i(86718);
        this.gNy = c38520i.getContext();
        this.gOB = new LinkedList();
        this.gOC = new HashMap();
        this.gOA = c38520i.aLY();
        this.gOD = c38520i;
        this.gOE = cls;
        this.gNy.getApplication().registerActivityLifecycleCallbacks(new C313141());
        AppMethodBeat.m2505o(86718);
    }

    /* renamed from: e */
    public C6750i mo34757e(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(86720);
        C6750i c6750i = (C6750i) C41166a.m71619be(this.gOE).mo65755ab(this.gNy, this).object;
        AppMethodBeat.m2505o(86720);
        return c6750i;
    }

    /* renamed from: b */
    public void mo34755b(C6750i c6750i, C6750i c6750i2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(86721);
        mo51272i(c6750i2);
        mo51271h(c6750i2);
        c6750i2.gNA = c6750i;
        c6750i2.mo14980a(appBrandInitConfig);
        if (c6750i != null) {
            c6750i.atk();
            c6750i2.atl();
        }
        AppMethodBeat.m2505o(86721);
    }

    /* renamed from: a */
    public void mo34752a(final C6750i c6750i, final MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        AppMethodBeat.m2504i(86722);
        if (c6750i == null) {
            AppMethodBeat.m2505o(86722);
            return;
        }
        this.gOD.getContext().runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(86712);
                if (C31311k.this.mo51270g(c6750i)) {
                    String str;
                    final C6750i d = C31311k.this.mo44513d(c6750i);
                    if (d != null) {
                        d.mo14981a(c6750i.mo15035yf(), miniProgramNavigationBackResult);
                    }
                    String str2 = "MicroMsg.AppBrandRuntimeContainer";
                    String str3 = "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = c6750i.mAppId;
                    if (d == null) {
                        str = BuildConfig.COMMAND;
                    } else {
                        str = d.mAppId;
                    }
                    objArr[1] = str;
                    objArr[2] = Boolean.valueOf(C31311k.this.gOF);
                    C45124d.m82930i(str2, str3, objArr);
                    C31311k.this.mo34756b(d, c6750i, new Runnable() {
                        public final void run() {
                            String str;
                            AppMethodBeat.m2504i(86711);
                            c6750i.gNE.setVisibility(8);
                            C31311k.this.gOB.remove(c6750i);
                            C31311k.this.gOC.put(c6750i.mAppId, c6750i);
                            if (d != null) {
                                C31311k.this.mo51272i(d);
                                C31311k.this.mo51271h(d);
                            }
                            c6750i.atk();
                            if (C31311k.this.gOF && d != null) {
                                d.atl();
                            }
                            String str2 = "MicroMsg.AppBrandRuntimeContainer";
                            String str3 = "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]";
                            Object[] objArr = new Object[3];
                            objArr[0] = c6750i.mAppId;
                            if (d == null) {
                                str = BuildConfig.COMMAND;
                            } else {
                                str = d.mAppId;
                            }
                            objArr[1] = str;
                            objArr[2] = Boolean.valueOf(C31311k.this.gOF);
                            C45124d.m82930i(str2, str3, objArr);
                            AppMethodBeat.m2505o(86711);
                        }
                    });
                    AppMethodBeat.m2505o(86712);
                    return;
                }
                C45124d.m82928e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", c6750i.mAppId);
                AppMethodBeat.m2505o(86712);
            }
        });
        AppMethodBeat.m2505o(86722);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo34756b(C6750i c6750i, C6750i c6750i2, Runnable runnable) {
        String str;
        AppMethodBeat.m2504i(86723);
        String str2 = "MicroMsg.AppBrandRuntimeContainer";
        String str3 = "onRuntimeClose entered, in.appId[%s], out.appId[%s]";
        Object[] objArr = new Object[2];
        if (c6750i == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = c6750i.mAppId;
        }
        objArr[0] = str;
        objArr[1] = c6750i2.mAppId;
        C45124d.m82930i(str2, str3, objArr);
        runnable.run();
        AppMethodBeat.m2505o(86723);
    }

    public final C6750i atv() {
        AppMethodBeat.m2504i(86724);
        C6750i c6750i = (C6750i) this.gOB.peek();
        AppMethodBeat.m2505o(86724);
        return c6750i;
    }

    /* renamed from: d */
    public final C6750i mo44513d(C6750i c6750i) {
        AppMethodBeat.m2504i(86725);
        if (c6750i == null) {
            NullPointerException nullPointerException = new NullPointerException("Null runtime");
            AppMethodBeat.m2505o(86725);
            throw nullPointerException;
        }
        ListIterator listIterator = this.gOB.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            C6750i c6750i2 = (C6750i) listIterator.next();
            if (c6750i2 == c6750i) {
                i = 1;
            } else if (i != 0) {
                AppMethodBeat.m2505o(86725);
                return c6750i2;
            }
        }
        if (i == 0) {
            IllegalAccessError illegalAccessError = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[]{c6750i.mAppId}));
            AppMethodBeat.m2505o(86725);
            throw illegalAccessError;
        }
        AppMethodBeat.m2505o(86725);
        return null;
    }

    public final int atw() {
        AppMethodBeat.m2504i(86726);
        int size = this.gOB.size();
        AppMethodBeat.m2505o(86726);
        return size;
    }

    /* renamed from: e */
    public final boolean mo51269e(C6750i c6750i) {
        AppMethodBeat.m2504i(86727);
        boolean contains = this.gOB.contains(c6750i);
        AppMethodBeat.m2505o(86727);
        return contains;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(86728);
        C45124d.m82930i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", Long.valueOf(Thread.currentThread().getId()));
        this.gNy.runOnUiThread(new C195324());
        AppMethodBeat.m2505o(86728);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(86729);
        C6750i atv = atv();
        if (atv != null) {
            try {
                if (atv.gNF != null) {
                    C33183g.m54275a(atv.mAppId, C33184d.BACK);
                    atv.finish();
                } else if (!(atv.gNG.mo6474wY() || atv.gND == null)) {
                    atv.gND.onBackPressed();
                    AppMethodBeat.m2505o(86729);
                    return;
                }
                AppMethodBeat.m2505o(86729);
                return;
            } catch (Exception e) {
                C45124d.m82928e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", e);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        throw e;
                    }
                });
            }
        }
        AppMethodBeat.m2505o(86729);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(86730);
        if (this.gOB != null) {
            Iterator it = this.gOB.iterator();
            while (it.hasNext()) {
                ((C6750i) it.next()).onConfigurationChanged(configuration);
            }
        }
        AppMethodBeat.m2505o(86730);
    }

    /* renamed from: f */
    public final void mo44514f(final C6750i c6750i) {
        AppMethodBeat.m2504i(86731);
        if (c6750i == null) {
            AppMethodBeat.m2505o(86731);
            return;
        }
        this.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(86715);
                C31311k.m50572a(C31311k.this, c6750i);
                AppMethodBeat.m2505o(86715);
            }
        });
        AppMethodBeat.m2505o(86731);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final boolean mo51270g(C6750i c6750i) {
        AppMethodBeat.m2504i(86732);
        if (this.gOB.peekFirst() == c6750i) {
            AppMethodBeat.m2505o(86732);
            return true;
        }
        AppMethodBeat.m2505o(86732);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final void mo51271h(C6750i c6750i) {
        AppMethodBeat.m2504i(86733);
        this.gOB.remove(c6750i);
        this.gOB.push(c6750i);
        c6750i.gNE.setVisibility(0);
        this.gOA.bringChildToFront(c6750i.gNE);
        AppMethodBeat.m2505o(86733);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final void mo51272i(C6750i c6750i) {
        AppMethodBeat.m2504i(86734);
        if (this.gOB.contains(c6750i)) {
            AppMethodBeat.m2505o(86734);
            return;
        }
        this.gOB.push(c6750i);
        if (this.gOA.indexOfChild(c6750i.gNE) == -1) {
            this.gOA.addView(c6750i.gNE);
        }
        this.gOC.remove(c6750i.mAppId);
        AppMethodBeat.m2505o(86734);
    }

    public final void atx() {
        AppMethodBeat.m2504i(86735);
        Iterator it = this.gOB.iterator();
        while (it.hasNext()) {
            C6750i c6750i = (C6750i) it.next();
            c6750i.gNE.setVisibility(8);
            this.gOC.put(c6750i.mAppId, c6750i);
            c6750i.atp();
        }
        this.gOB.clear();
        AppMethodBeat.m2505o(86735);
    }

    /* renamed from: j */
    public final void mo44515j(C6750i c6750i) {
        AppMethodBeat.m2504i(86736);
        if (c6750i == null) {
            AppMethodBeat.m2505o(86736);
            return;
        }
        this.gOB.remove(c6750i);
        AppMethodBeat.m2505o(86736);
    }

    /* Access modifiers changed, original: protected|final */
    public final LinkedList<C6750i> aty() {
        AppMethodBeat.m2504i(86737);
        LinkedList linkedList = new LinkedList(this.gOB);
        AppMethodBeat.m2505o(86737);
        return linkedList;
    }

    public final C38520i atz() {
        return this.gOD;
    }

    /* renamed from: a */
    public void mo34753a(C6750i c6750i, C6750i c6750i2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(86719);
        c6750i2.gNA = c6750i;
        c6750i2.mo15017c(appBrandInitConfig);
        this.gOB.push(c6750i2);
        this.gOA.addView(c6750i2.gNE);
        if (c6750i != null) {
            c6750i.atk();
        }
        c6750i2.asS();
        AppMethodBeat.m2505o(86719);
    }
}
