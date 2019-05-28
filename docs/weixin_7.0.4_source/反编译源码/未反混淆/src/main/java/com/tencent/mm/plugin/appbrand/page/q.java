package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

@SuppressLint({"ViewConstructor"})
public class q extends FrameLayout {
    private static final int irH = R.id.y;
    private i gPI;
    private boolean irI = false;
    private boolean irJ = false;
    private final LinkedList<n> irK = new LinkedList();
    private final LinkedList<n> irL = new LinkedList();
    private final LinkedList<Runnable> irM = new LinkedList();
    private u irN;
    private ap irO;
    private boolean irP = true;
    private b irQ;
    private String mAppId;

    public interface a {
        void aJr();

        void cancel();

        void proceed();
    }

    public interface b {
        void atu();
    }

    public q(Context context, i iVar) {
        super(context);
        AppMethodBeat.i(87099);
        this.gPI = iVar;
        this.mAppId = iVar.mAppId;
        this.irO = new com.tencent.mm.plugin.appbrand.page.ap.a();
        AppMethodBeat.o(87099);
    }

    public ap getDecorWidgetFactory() {
        return this.irO;
    }

    public void setDecorWidgetFactory(ap apVar) {
        AppMethodBeat.i(87100);
        if (apVar == null) {
            NullPointerException nullPointerException = new NullPointerException("Should not be null");
            AppMethodBeat.o(87100);
            throw nullPointerException;
        }
        this.irO = apVar;
        AppMethodBeat.o(87100);
    }

    public void setActuallyVisible(boolean z) {
        AppMethodBeat.i(87101);
        int i = this.irI != z ? 1 : 0;
        this.irI = z;
        if (z && i != 0) {
            getCurrentPage().getCurrentPageView().aJD();
            super.setVisibility(0);
            if (this.irJ) {
                aJp();
            }
        }
        if (!(z || i == 0)) {
            super.setVisibility(4);
        }
        AppMethodBeat.o(87101);
    }

    /* Access modifiers changed, original: protected|final */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(87102);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            AppMethodBeat.o(87102);
            return;
        }
        post(runnable);
        AppMethodBeat.o(87102);
    }

    public int getPageCount() {
        AppMethodBeat.i(87103);
        int size = this.irK.size() + this.irL.size();
        AppMethodBeat.o(87103);
        return size;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void Az(final String str) {
        AppMethodBeat.i(87104);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87077);
                q.a(q.this, str, aq.APP_LAUNCH);
                AppMethodBeat.o(87077);
            }
        });
        AppMethodBeat.o(87104);
    }

    public final void CZ(final String str) {
        AppMethodBeat.i(87105);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87089);
                q.a(q.this, str, aq.NAVIGATE_TO);
                AppMethodBeat.o(87089);
            }
        });
        AppMethodBeat.o(87105);
    }

    public void af(final String str, final boolean z) {
        AppMethodBeat.i(87106);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87092);
                q.a(q.this, str, z ? aq.AUTO_RE_LAUNCH : aq.RE_LAUNCH);
                AppMethodBeat.o(87092);
            }
        });
        AppMethodBeat.o(87106);
    }

    public final void Da(final String str) {
        AppMethodBeat.i(87107);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87093);
                q.a(q.this, str, aq.REDIRECT_TO);
                AppMethodBeat.o(87093);
            }
        });
        AppMethodBeat.o(87107);
    }

    public final void Db(final String str) {
        AppMethodBeat.i(87108);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87094);
                q.a(q.this, str, aq.SWITCH_TAB);
                AppMethodBeat.o(87094);
            }
        });
        AppMethodBeat.o(87108);
    }

    /* Access modifiers changed, original: protected */
    public boolean a(String str, aq aqVar, a aVar) {
        return false;
    }

    public void aAU() {
        AppMethodBeat.i(87109);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87096);
                q.this.nU(1);
                AppMethodBeat.o(87096);
            }
        });
        AppMethodBeat.o(87109);
    }

    public void nU(final int i) {
        AppMethodBeat.i(87110);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87097);
                q.a(q.this, i);
                AppMethodBeat.o(87097);
            }
        });
        AppMethodBeat.o(87110);
    }

    public final void c(final n nVar) {
        AppMethodBeat.i(87111);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87098);
                q.a(q.this, q.this.irK.indexOf(nVar) + 1);
                AppMethodBeat.o(87098);
            }
        });
        AppMethodBeat.o(87111);
    }

    /* Access modifiers changed, original: protected */
    public void a(n nVar, n nVar2) {
        AppMethodBeat.i(87112);
        if (this.irI) {
            nVar2.getCurrentPageView().aJD();
        }
        if (nVar != null) {
            nVar.aqX();
        }
        AppMethodBeat.o(87112);
    }

    /* Access modifiers changed, original: protected */
    public void a(n nVar, n nVar2, aq aqVar, String str) {
        AppMethodBeat.i(87114);
        if (nVar != null) {
            nVar.aqX();
        }
        AppMethodBeat.o(87114);
    }

    /* Access modifiers changed, original: protected */
    public void a(n nVar, n nVar2, aq aqVar) {
        AppMethodBeat.i(87115);
        if (this.irI) {
            nVar2.getCurrentPageView().aJD();
        }
        AppMethodBeat.o(87115);
    }

    private static boolean b(aq aqVar) {
        return aqVar == aq.REDIRECT_TO || aqVar == aq.SWITCH_TAB || aqVar == aq.RE_LAUNCH || aqVar == aq.AUTO_RE_LAUNCH;
    }

    private static boolean c(aq aqVar) {
        AppMethodBeat.i(87116);
        boolean contains = com.tencent.mm.compatible.loader.a.contains(new aq[]{aq.SWITCH_TAB, aq.RE_LAUNCH, aq.AUTO_RE_LAUNCH}, (Object) aqVar);
        AppMethodBeat.o(87116);
        return contains;
    }

    private void aJo() {
        AppMethodBeat.i(87117);
        Iterator descendingIterator = this.irM.descendingIterator();
        while (descendingIterator.hasNext()) {
            ((Runnable) descendingIterator.next()).run();
            descendingIterator.remove();
        }
        this.irL.clear();
        AppMethodBeat.o(87117);
    }

    private void b(n nVar, n nVar2) {
        AppMethodBeat.i(87118);
        Iterator it = this.irK.iterator();
        Object obj = null;
        while (it.hasNext()) {
            n nVar3 = (n) it.next();
            if (nVar3 != nVar) {
                if (nVar3 == nVar2) {
                    break;
                } else if (obj != null) {
                    d(nVar3);
                    it.remove();
                }
            } else {
                obj = 1;
            }
        }
        AppMethodBeat.o(87118);
    }

    private void b(final n nVar, final n nVar2, aq aqVar) {
        AppMethodBeat.i(87119);
        this.irK.remove(nVar2);
        int i = !nVar2.mSwiping ? 1 : 0;
        if (i != 0) {
            a(nVar2, i(nVar2), new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87080);
                    q.b(q.this, nVar2);
                    AppMethodBeat.o(87080);
                }
            });
        } else {
            d(nVar2);
        }
        ab.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", nVar.getCurrentUrl(), nVar2.getCurrentUrl());
        nVar.a(aqVar);
        nVar.aJj();
        if (i != 0) {
            a(nVar, h(nVar), new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87081);
                    nVar.aJl();
                    AppMethodBeat.o(87081);
                }
            });
            AppMethodBeat.o(87119);
            return;
        }
        nVar.aJl();
        AppMethodBeat.o(87119);
    }

    private synchronized void b(final n nVar, boolean z) {
        AppMethodBeat.i(87120);
        if (nVar == null) {
            AppMethodBeat.o(87120);
        } else {
            this.irK.remove(nVar);
            this.irK.push(nVar);
            this.irL.remove(nVar);
            nVar.bringToFront();
            requestLayout();
            invalidate();
            nVar.aJj();
            Runnable anonymousClass7 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87083);
                    q.this.aJp();
                    nVar.aJl();
                    AppMethodBeat.o(87083);
                }
            };
            if (z) {
                a(nVar, f(nVar), anonymousClass7);
                AppMethodBeat.o(87120);
            } else {
                anonymousClass7.run();
                AppMethodBeat.o(87120);
            }
        }
    }

    private n Dc(String str) {
        AppMethodBeat.i(87121);
        if (this.irK.size() == 0) {
            AppMethodBeat.o(87121);
            return null;
        } else if ((this.irK.getFirst() instanceof g) && ((n) this.irK.getFirst()).Ay(str)) {
            n nVar = (n) this.irK.getFirst();
            AppMethodBeat.o(87121);
            return nVar;
        } else {
            AppMethodBeat.o(87121);
            return null;
        }
    }

    private n Dd(String str) {
        AppMethodBeat.i(87122);
        if (this.irK.size() < 2) {
            AppMethodBeat.o(87122);
            return null;
        }
        ListIterator listIterator = this.irK.listIterator(1);
        while (listIterator.hasNext()) {
            n nVar = (n) listIterator.next();
            if ((nVar instanceof g) && nVar.Ay(str)) {
                AppMethodBeat.o(87122);
                return nVar;
            }
        }
        AppMethodBeat.o(87122);
        return null;
    }

    private void d(n nVar) {
        AppMethodBeat.i(87123);
        nVar.setVisibility(8);
        nVar.aJk();
        nVar.performDestroy();
        removeView(nVar);
        nVar.xN();
        AppMethodBeat.o(87123);
    }

    public void c(final String str, final String str2, final int[] iArr) {
        AppMethodBeat.i(87124);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87084);
                q.a(q.this, str, str2, iArr);
                AppMethodBeat.o(87084);
            }
        });
        AppMethodBeat.o(87124);
    }

    public synchronized n getCurrentPage() {
        n nVar;
        AppMethodBeat.i(87125);
        if (this.irL.isEmpty()) {
            nVar = (n) this.irK.peekFirst();
            AppMethodBeat.o(87125);
        } else {
            nVar = (n) this.irL.getFirst();
            AppMethodBeat.o(87125);
        }
        return nVar;
    }

    public final synchronized n e(n nVar) {
        n nVar2;
        AppMethodBeat.i(87126);
        int indexOf = this.irK.indexOf(nVar);
        if (indexOf >= this.irK.size() - 1) {
            nVar2 = null;
            AppMethodBeat.o(87126);
        } else {
            nVar2 = (n) this.irK.get(indexOf + 1);
            AppMethodBeat.o(87126);
        }
        return nVar2;
    }

    public synchronized String getCurrentUrl() {
        String currentUrl;
        AppMethodBeat.i(87127);
        n currentPage = getCurrentPage();
        if (currentPage != null) {
            currentUrl = currentPage.getCurrentUrl();
            AppMethodBeat.o(87127);
        } else {
            currentUrl = null;
            AppMethodBeat.o(87127);
        }
        return currentUrl;
    }

    public void cleanup() {
        AppMethodBeat.i(87128);
        onDestroy();
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.irK);
        linkedList.addAll(this.irL);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            nVar.aJk();
            nVar.performDestroy();
            nVar.xN();
            j(nVar);
        }
        linkedList.clear();
        if (this.irN != null) {
            try {
                this.irN.onDestroy();
            } catch (Exception e) {
            }
            try {
                this.irN.cleanup();
            } catch (Exception e2) {
            }
        }
        this.irK.clear();
        this.irL.clear();
        removeAllViews();
        this.irQ = null;
        this.gPI = null;
        AppMethodBeat.o(87128);
    }

    /* Access modifiers changed, original: 0000 */
    public u getPageViewPrivate() {
        u aHV;
        AppMethodBeat.i(87129);
        if (this.irN == null) {
            aHV = aHV();
            if (aHV == null) {
                aHV = new u();
            }
            aHV.irO = getDecorWidgetFactory();
            aHV.a(getContext(), this.gPI);
            AppMethodBeat.o(87129);
        } else {
            aHV = this.irN;
            this.irN = null;
            View contentView = aHV.getContentView();
            if (contentView != null) {
                contentView.setVisibility(0);
            }
            removeView(aHV.getContentView());
            AppMethodBeat.o(87129);
        }
        return aHV;
    }

    public u aHV() {
        return null;
    }

    public u getPageView() {
        AppMethodBeat.i(87130);
        n currentPage = getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.o(87130);
            return null;
        }
        u currentPageView = currentPage.getCurrentPageView();
        AppMethodBeat.o(87130);
        return currentPageView;
    }

    public final void aJp() {
        AppMethodBeat.i(87131);
        if (this.irI) {
            this.irJ = false;
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87085);
                    if (q.this.getRuntime() == null || !q.this.getRuntime().eMP || q.this.getRuntime().mFinished) {
                        AppMethodBeat.o(87085);
                    } else if (q.this.irN != null) {
                        AppMethodBeat.o(87085);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        u aHV = q.this.aHV();
                        if (aHV == null) {
                            aHV = new u();
                        }
                        aHV.irO = q.this.getDecorWidgetFactory();
                        aHV.a(q.this.getContext(), q.this.gPI);
                        View contentView = aHV.getContentView();
                        if (contentView != null) {
                            contentView.setVisibility(4);
                        }
                        q.this.addView(aHV.getContentView(), 0);
                        q.this.irN = aHV;
                        ab.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(87085);
                    }
                }
            }, 200);
            AppMethodBeat.o(87131);
            return;
        }
        this.irJ = true;
        AppMethodBeat.o(87131);
    }

    public com.tencent.mm.plugin.appbrand.config.a getAppConfig() {
        AppMethodBeat.i(87132);
        com.tencent.mm.plugin.appbrand.config.a appConfig = this.gPI.getAppConfig();
        AppMethodBeat.o(87132);
        return appConfig;
    }

    public i getRuntime() {
        return this.gPI;
    }

    public void wU() {
        AppMethodBeat.i(87133);
        if (this.irK.size() == 0) {
            AppMethodBeat.o(87133);
            return;
        }
        ((n) this.irK.getFirst()).aJj();
        if (this.irI) {
            ((n) this.irK.getFirst()).getCurrentPageView().aJD();
        }
        AppMethodBeat.o(87133);
    }

    public void wW() {
        AppMethodBeat.i(87134);
        if (this.irK.size() == 0) {
            AppMethodBeat.o(87134);
            return;
        }
        ((n) this.irK.getFirst()).aJk();
        AppMethodBeat.o(87134);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJq() {
        AppMethodBeat.i(87135);
        if (this.gPI == null) {
            AppMethodBeat.o(87135);
            return;
        }
        if (this.irP) {
            onReady();
            this.irP = false;
        }
        AppMethodBeat.o(87135);
    }

    /* Access modifiers changed, original: protected */
    public void onReady() {
        AppMethodBeat.i(87136);
        if (this.irQ != null) {
            this.irQ.atu();
        }
        AppMethodBeat.o(87136);
    }

    public void setOnReadyListener(b bVar) {
        this.irQ = bVar;
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
    }

    public Object f(n nVar) {
        AppMethodBeat.i(87137);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", new float[]{(float) nVar.getWidth(), 0.0f});
        ofFloat.setDuration(250);
        AppMethodBeat.o(87137);
        return ofFloat;
    }

    public Object g(n nVar) {
        AppMethodBeat.i(87138);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", new float[]{0.0f, -(((float) nVar.getWidth()) * 0.25f)});
        ofFloat.setDuration(250);
        ObjectAnimator.ofFloat(nVar, "translationX", new float[]{0.0f}).setDuration(0);
        new AnimatorSet().playSequentially(new Animator[]{ofFloat, r1});
        AppMethodBeat.o(87138);
        return ofFloat;
    }

    public Object h(n nVar) {
        AppMethodBeat.i(87139);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", new float[]{-(((float) nVar.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        AppMethodBeat.o(87139);
        return ofFloat;
    }

    public Object i(n nVar) {
        AppMethodBeat.i(87140);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nVar, "translationX", new float[]{0.0f, (float) nVar.getWidth()});
        ofFloat.setDuration(250);
        AppMethodBeat.o(87140);
        return ofFloat;
    }

    private static void j(n nVar) {
        AppMethodBeat.i(87141);
        nVar.clearAnimation();
        Object tag = nVar.getTag(irH);
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            animator.cancel();
            animator.removeAllListeners();
        }
        AppMethodBeat.o(87141);
    }

    private void a(final n nVar, Object obj, final Runnable runnable) {
        AppMethodBeat.i(87142);
        if (obj instanceof Animator) {
            Animator animator = (Animator) obj;
            j(nVar);
            nVar.setTag(irH, animator);
            animator.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(87086);
                    nVar.setTag(q.irH, null);
                    AppMethodBeat.o(87086);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(87087);
                    nVar.setTag(q.irH, null);
                    AppMethodBeat.o(87087);
                }
            });
            animator.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(87088);
                    if (runnable != null) {
                        q.this.post(runnable);
                    }
                    AppMethodBeat.o(87088);
                }
            });
            animator.start();
            AppMethodBeat.o(87142);
        } else if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            animation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(87091);
                    if (runnable != null) {
                        q.this.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(87090);
                                runnable.run();
                                nVar.setTag(q.irH, null);
                                AppMethodBeat.o(87090);
                            }
                        });
                        AppMethodBeat.o(87091);
                        return;
                    }
                    nVar.setTag(q.irH, null);
                    AppMethodBeat.o(87091);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            j(nVar);
            nVar.setTag(irH, animation);
            nVar.startAnimation(animation);
            AppMethodBeat.o(87142);
        } else if (obj == null) {
            runnable.run();
            AppMethodBeat.o(87142);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Page animation should be Animator or Animation");
            AppMethodBeat.o(87142);
            throw illegalArgumentException;
        }
    }

    public void onBackPressed() {
        AppMethodBeat.i(87143);
        if (getCurrentPage() == null) {
            AppMethodBeat.o(87143);
        } else if (getCurrentPage().getCurrentPageView().wY()) {
            AppMethodBeat.o(87143);
        } else if (this.irL.isEmpty() && getCurrentPage().getTag(irH) == null) {
            aAU();
            AppMethodBeat.o(87143);
        } else {
            ab.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
            AppMethodBeat.o(87143);
        }
    }

    public boolean aAV() {
        AppMethodBeat.i(87144);
        if (this.irK.size() > 1 || getRuntime().gNS) {
            AppMethodBeat.o(87144);
            return true;
        }
        AppMethodBeat.o(87144);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public n b(String str, aq aqVar) {
        boolean z = true;
        AppMethodBeat.i(87113);
        if (aqVar != aq.SWITCH_TAB) {
            if (aqVar == aq.RE_LAUNCH || aqVar == aq.AUTO_RE_LAUNCH) {
                z = this.gPI.getAppConfig().heV.yU(str);
            } else {
                int i;
                int size = this.irK.size() + 1;
                if (aqVar == aq.REDIRECT_TO) {
                    i = 1;
                } else {
                    i = 0;
                }
                i = size - i;
                if (!(this.gPI.getAppConfig().heV.yU(str) && i == 1)) {
                    z = false;
                }
            }
        }
        if (z) {
            g gVar = new g(getContext(), this);
            AppMethodBeat.o(87113);
            return gVar;
        }
        n zVar = new z(getContext(), this);
        AppMethodBeat.o(87113);
        return zVar;
    }
}
