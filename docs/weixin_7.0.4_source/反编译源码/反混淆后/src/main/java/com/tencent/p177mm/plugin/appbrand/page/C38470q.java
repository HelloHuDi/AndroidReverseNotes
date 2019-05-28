package com.tencent.p177mm.plugin.appbrand.page;

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
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import com.tencent.p177mm.plugin.appbrand.page.C2410ap.C2411a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.q */
public class C38470q extends FrameLayout {
    private static final int irH = 2131820568;
    private C6750i gPI;
    private boolean irI = false;
    private boolean irJ = false;
    private final LinkedList<C19640n> irK = new LinkedList();
    private final LinkedList<C19640n> irL = new LinkedList();
    private final LinkedList<Runnable> irM = new LinkedList();
    private C44709u irN;
    private C2410ap irO;
    private boolean irP = true;
    private C38469b irQ;
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.q$18 */
    class C241818 implements Runnable {
        C241818() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87096);
            C38470q.this.mo21677nU(1);
            AppMethodBeat.m2505o(87096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.q$9 */
    class C272349 implements Runnable {
        C272349() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87085);
            if (C38470q.this.getRuntime() == null || !C38470q.this.getRuntime().eMP || C38470q.this.getRuntime().mFinished) {
                AppMethodBeat.m2505o(87085);
            } else if (C38470q.this.irN != null) {
                AppMethodBeat.m2505o(87085);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                C44709u aHV = C38470q.this.aHV();
                if (aHV == null) {
                    aHV = new C44709u();
                }
                aHV.irO = C38470q.this.getDecorWidgetFactory();
                aHV.mo44895a(C38470q.this.getContext(), C38470q.this.gPI);
                View contentView = aHV.getContentView();
                if (contentView != null) {
                    contentView.setVisibility(4);
                }
                C38470q.this.addView(aHV.getContentView(), 0);
                C38470q.this.irN = aHV;
                C4990ab.m7417i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(87085);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.q$a */
    public interface C38468a {
        void aJr();

        void cancel();

        void proceed();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.q$b */
    public interface C38469b {
        void atu();
    }

    public C38470q(Context context, C6750i c6750i) {
        super(context);
        AppMethodBeat.m2504i(87099);
        this.gPI = c6750i;
        this.mAppId = c6750i.mAppId;
        this.irO = new C2411a();
        AppMethodBeat.m2505o(87099);
    }

    public C2410ap getDecorWidgetFactory() {
        return this.irO;
    }

    public void setDecorWidgetFactory(C2410ap c2410ap) {
        AppMethodBeat.m2504i(87100);
        if (c2410ap == null) {
            NullPointerException nullPointerException = new NullPointerException("Should not be null");
            AppMethodBeat.m2505o(87100);
            throw nullPointerException;
        }
        this.irO = c2410ap;
        AppMethodBeat.m2505o(87100);
    }

    public void setActuallyVisible(boolean z) {
        AppMethodBeat.m2504i(87101);
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
        AppMethodBeat.m2505o(87101);
    }

    /* Access modifiers changed, original: protected|final */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(87102);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            AppMethodBeat.m2505o(87102);
            return;
        }
        post(runnable);
        AppMethodBeat.m2505o(87102);
    }

    public int getPageCount() {
        AppMethodBeat.m2504i(87103);
        int size = this.irK.size() + this.irL.size();
        AppMethodBeat.m2505o(87103);
        return size;
    }

    public String getAppId() {
        return this.mAppId;
    }

    /* renamed from: Az */
    public void mo21667Az(final String str) {
        AppMethodBeat.m2504i(87104);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87077);
                C38470q.m65078a(C38470q.this, str, C2412aq.APP_LAUNCH);
                AppMethodBeat.m2505o(87077);
            }
        });
        AppMethodBeat.m2505o(87104);
    }

    /* renamed from: CZ */
    public final void mo61154CZ(final String str) {
        AppMethodBeat.m2504i(87105);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87089);
                C38470q.m65078a(C38470q.this, str, C2412aq.NAVIGATE_TO);
                AppMethodBeat.m2505o(87089);
            }
        });
        AppMethodBeat.m2505o(87105);
    }

    /* renamed from: af */
    public void mo21671af(final String str, final boolean z) {
        AppMethodBeat.m2504i(87106);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87092);
                C38470q.m65078a(C38470q.this, str, z ? C2412aq.AUTO_RE_LAUNCH : C2412aq.RE_LAUNCH);
                AppMethodBeat.m2505o(87092);
            }
        });
        AppMethodBeat.m2505o(87106);
    }

    /* renamed from: Da */
    public final void mo61155Da(final String str) {
        AppMethodBeat.m2504i(87107);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87093);
                C38470q.m65078a(C38470q.this, str, C2412aq.REDIRECT_TO);
                AppMethodBeat.m2505o(87093);
            }
        });
        AppMethodBeat.m2505o(87107);
    }

    /* renamed from: Db */
    public final void mo61156Db(final String str) {
        AppMethodBeat.m2504i(87108);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87094);
                C38470q.m65078a(C38470q.this, str, C2412aq.SWITCH_TAB);
                AppMethodBeat.m2505o(87094);
            }
        });
        AppMethodBeat.m2505o(87108);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo61160a(String str, C2412aq c2412aq, C38468a c38468a) {
        return false;
    }

    public void aAU() {
        AppMethodBeat.m2504i(87109);
        runOnUiThread(new C241818());
        AppMethodBeat.m2505o(87109);
    }

    /* renamed from: nU */
    public void mo21677nU(final int i) {
        AppMethodBeat.m2504i(87110);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87097);
                C38470q.m65074a(C38470q.this, i);
                AppMethodBeat.m2505o(87097);
            }
        });
        AppMethodBeat.m2505o(87110);
    }

    /* renamed from: c */
    public final void mo61164c(final C19640n c19640n) {
        AppMethodBeat.m2504i(87111);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87098);
                C38470q.m65074a(C38470q.this, C38470q.this.irK.indexOf(c19640n) + 1);
                AppMethodBeat.m2505o(87098);
            }
        });
        AppMethodBeat.m2505o(87111);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo61157a(C19640n c19640n, C19640n c19640n2) {
        AppMethodBeat.m2504i(87112);
        if (this.irI) {
            c19640n2.getCurrentPageView().aJD();
        }
        if (c19640n != null) {
            c19640n.aqX();
        }
        AppMethodBeat.m2505o(87112);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo61159a(C19640n c19640n, C19640n c19640n2, C2412aq c2412aq, String str) {
        AppMethodBeat.m2504i(87114);
        if (c19640n != null) {
            c19640n.aqX();
        }
        AppMethodBeat.m2505o(87114);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo61158a(C19640n c19640n, C19640n c19640n2, C2412aq c2412aq) {
        AppMethodBeat.m2504i(87115);
        if (this.irI) {
            c19640n2.getCurrentPageView().aJD();
        }
        AppMethodBeat.m2505o(87115);
    }

    /* renamed from: b */
    private static boolean m65086b(C2412aq c2412aq) {
        return c2412aq == C2412aq.REDIRECT_TO || c2412aq == C2412aq.SWITCH_TAB || c2412aq == C2412aq.RE_LAUNCH || c2412aq == C2412aq.AUTO_RE_LAUNCH;
    }

    /* renamed from: c */
    private static boolean m65088c(C2412aq c2412aq) {
        AppMethodBeat.m2504i(87116);
        boolean contains = C32473a.contains(new C2412aq[]{C2412aq.SWITCH_TAB, C2412aq.RE_LAUNCH, C2412aq.AUTO_RE_LAUNCH}, (Object) c2412aq);
        AppMethodBeat.m2505o(87116);
        return contains;
    }

    private void aJo() {
        AppMethodBeat.m2504i(87117);
        Iterator descendingIterator = this.irM.descendingIterator();
        while (descendingIterator.hasNext()) {
            ((Runnable) descendingIterator.next()).run();
            descendingIterator.remove();
        }
        this.irL.clear();
        AppMethodBeat.m2505o(87117);
    }

    /* renamed from: b */
    private void m65082b(C19640n c19640n, C19640n c19640n2) {
        AppMethodBeat.m2504i(87118);
        Iterator it = this.irK.iterator();
        Object obj = null;
        while (it.hasNext()) {
            C19640n c19640n3 = (C19640n) it.next();
            if (c19640n3 != c19640n) {
                if (c19640n3 == c19640n2) {
                    break;
                } else if (obj != null) {
                    m65089d(c19640n3);
                    it.remove();
                }
            } else {
                obj = 1;
            }
        }
        AppMethodBeat.m2505o(87118);
    }

    /* renamed from: b */
    private void m65083b(final C19640n c19640n, final C19640n c19640n2, C2412aq c2412aq) {
        AppMethodBeat.m2504i(87119);
        this.irK.remove(c19640n2);
        int i = !c19640n2.mSwiping ? 1 : 0;
        if (i != 0) {
            m65073a(c19640n2, mo61176i(c19640n2), new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87080);
                    C38470q.m65085b(C38470q.this, c19640n2);
                    AppMethodBeat.m2505o(87080);
                }
            });
        } else {
            m65089d(c19640n2);
        }
        C4990ab.m7417i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", c19640n.getCurrentUrl(), c19640n2.getCurrentUrl());
        c19640n.mo34865a(c2412aq);
        c19640n.aJj();
        if (i != 0) {
            m65073a(c19640n, mo61175h(c19640n), new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87081);
                    c19640n.aJl();
                    AppMethodBeat.m2505o(87081);
                }
            });
            AppMethodBeat.m2505o(87119);
            return;
        }
        c19640n.aJl();
        AppMethodBeat.m2505o(87119);
    }

    /* renamed from: b */
    private synchronized void m65084b(final C19640n c19640n, boolean z) {
        AppMethodBeat.m2504i(87120);
        if (c19640n == null) {
            AppMethodBeat.m2505o(87120);
        } else {
            this.irK.remove(c19640n);
            this.irK.push(c19640n);
            this.irL.remove(c19640n);
            c19640n.bringToFront();
            requestLayout();
            invalidate();
            c19640n.aJj();
            Runnable c384747 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87083);
                    C38470q.this.aJp();
                    c19640n.aJl();
                    AppMethodBeat.m2505o(87083);
                }
            };
            if (z) {
                m65073a(c19640n, mo61166f(c19640n), c384747);
                AppMethodBeat.m2505o(87120);
            } else {
                c384747.run();
                AppMethodBeat.m2505o(87120);
            }
        }
    }

    /* renamed from: Dc */
    private C19640n m65069Dc(String str) {
        AppMethodBeat.m2504i(87121);
        if (this.irK.size() == 0) {
            AppMethodBeat.m2505o(87121);
            return null;
        } else if ((this.irK.getFirst() instanceof C27224g) && ((C19640n) this.irK.getFirst()).mo21657Ay(str)) {
            C19640n c19640n = (C19640n) this.irK.getFirst();
            AppMethodBeat.m2505o(87121);
            return c19640n;
        } else {
            AppMethodBeat.m2505o(87121);
            return null;
        }
    }

    /* renamed from: Dd */
    private C19640n m65070Dd(String str) {
        AppMethodBeat.m2504i(87122);
        if (this.irK.size() < 2) {
            AppMethodBeat.m2505o(87122);
            return null;
        }
        ListIterator listIterator = this.irK.listIterator(1);
        while (listIterator.hasNext()) {
            C19640n c19640n = (C19640n) listIterator.next();
            if ((c19640n instanceof C27224g) && c19640n.mo21657Ay(str)) {
                AppMethodBeat.m2505o(87122);
                return c19640n;
            }
        }
        AppMethodBeat.m2505o(87122);
        return null;
    }

    /* renamed from: d */
    private void m65089d(C19640n c19640n) {
        AppMethodBeat.m2504i(87123);
        c19640n.setVisibility(8);
        c19640n.aJk();
        c19640n.performDestroy();
        removeView(c19640n);
        c19640n.mo34878xN();
        AppMethodBeat.m2505o(87123);
    }

    /* renamed from: c */
    public void mo21672c(final String str, final String str2, final int[] iArr) {
        AppMethodBeat.m2504i(87124);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87084);
                C38470q.m65080a(C38470q.this, str, str2, iArr);
                AppMethodBeat.m2505o(87084);
            }
        });
        AppMethodBeat.m2505o(87124);
    }

    public synchronized C19640n getCurrentPage() {
        C19640n c19640n;
        AppMethodBeat.m2504i(87125);
        if (this.irL.isEmpty()) {
            c19640n = (C19640n) this.irK.peekFirst();
            AppMethodBeat.m2505o(87125);
        } else {
            c19640n = (C19640n) this.irL.getFirst();
            AppMethodBeat.m2505o(87125);
        }
        return c19640n;
    }

    /* renamed from: e */
    public final synchronized C19640n mo61165e(C19640n c19640n) {
        C19640n c19640n2;
        AppMethodBeat.m2504i(87126);
        int indexOf = this.irK.indexOf(c19640n);
        if (indexOf >= this.irK.size() - 1) {
            c19640n2 = null;
            AppMethodBeat.m2505o(87126);
        } else {
            c19640n2 = (C19640n) this.irK.get(indexOf + 1);
            AppMethodBeat.m2505o(87126);
        }
        return c19640n2;
    }

    public synchronized String getCurrentUrl() {
        String currentUrl;
        AppMethodBeat.m2504i(87127);
        C19640n currentPage = getCurrentPage();
        if (currentPage != null) {
            currentUrl = currentPage.getCurrentUrl();
            AppMethodBeat.m2505o(87127);
        } else {
            currentUrl = null;
            AppMethodBeat.m2505o(87127);
        }
        return currentUrl;
    }

    public void cleanup() {
        AppMethodBeat.m2504i(87128);
        onDestroy();
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.irK);
        linkedList.addAll(this.irL);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C19640n c19640n = (C19640n) it.next();
            c19640n.aJk();
            c19640n.performDestroy();
            c19640n.mo34878xN();
            C38470q.m65093j(c19640n);
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
        AppMethodBeat.m2505o(87128);
    }

    /* Access modifiers changed, original: 0000 */
    public C44709u getPageViewPrivate() {
        C44709u aHV;
        AppMethodBeat.m2504i(87129);
        if (this.irN == null) {
            aHV = aHV();
            if (aHV == null) {
                aHV = new C44709u();
            }
            aHV.irO = getDecorWidgetFactory();
            aHV.mo44895a(getContext(), this.gPI);
            AppMethodBeat.m2505o(87129);
        } else {
            aHV = this.irN;
            this.irN = null;
            View contentView = aHV.getContentView();
            if (contentView != null) {
                contentView.setVisibility(0);
            }
            removeView(aHV.getContentView());
            AppMethodBeat.m2505o(87129);
        }
        return aHV;
    }

    public C44709u aHV() {
        return null;
    }

    public C44709u getPageView() {
        AppMethodBeat.m2504i(87130);
        C19640n currentPage = getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.m2505o(87130);
            return null;
        }
        C44709u currentPageView = currentPage.getCurrentPageView();
        AppMethodBeat.m2505o(87130);
        return currentPageView;
    }

    public final void aJp() {
        AppMethodBeat.m2504i(87131);
        if (this.irI) {
            this.irJ = false;
            postDelayed(new C272349(), 200);
            AppMethodBeat.m2505o(87131);
            return;
        }
        this.irJ = true;
        AppMethodBeat.m2505o(87131);
    }

    public C38163a getAppConfig() {
        AppMethodBeat.m2504i(87132);
        C38163a appConfig = this.gPI.getAppConfig();
        AppMethodBeat.m2505o(87132);
        return appConfig;
    }

    public C6750i getRuntime() {
        return this.gPI;
    }

    /* renamed from: wU */
    public void mo21679wU() {
        AppMethodBeat.m2504i(87133);
        if (this.irK.size() == 0) {
            AppMethodBeat.m2505o(87133);
            return;
        }
        ((C19640n) this.irK.getFirst()).aJj();
        if (this.irI) {
            ((C19640n) this.irK.getFirst()).getCurrentPageView().aJD();
        }
        AppMethodBeat.m2505o(87133);
    }

    /* renamed from: wW */
    public void mo21680wW() {
        AppMethodBeat.m2504i(87134);
        if (this.irK.size() == 0) {
            AppMethodBeat.m2505o(87134);
            return;
        }
        ((C19640n) this.irK.getFirst()).aJk();
        AppMethodBeat.m2505o(87134);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJq() {
        AppMethodBeat.m2504i(87135);
        if (this.gPI == null) {
            AppMethodBeat.m2505o(87135);
            return;
        }
        if (this.irP) {
            onReady();
            this.irP = false;
        }
        AppMethodBeat.m2505o(87135);
    }

    /* Access modifiers changed, original: protected */
    public void onReady() {
        AppMethodBeat.m2504i(87136);
        if (this.irQ != null) {
            this.irQ.atu();
        }
        AppMethodBeat.m2505o(87136);
    }

    public void setOnReadyListener(C38469b c38469b) {
        this.irQ = c38469b;
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
    }

    /* renamed from: f */
    public Object mo61166f(C19640n c19640n) {
        AppMethodBeat.m2504i(87137);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c19640n, "translationX", new float[]{(float) c19640n.getWidth(), 0.0f});
        ofFloat.setDuration(250);
        AppMethodBeat.m2505o(87137);
        return ofFloat;
    }

    /* renamed from: g */
    public Object mo61167g(C19640n c19640n) {
        AppMethodBeat.m2504i(87138);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c19640n, "translationX", new float[]{0.0f, -(((float) c19640n.getWidth()) * 0.25f)});
        ofFloat.setDuration(250);
        ObjectAnimator.ofFloat(c19640n, "translationX", new float[]{0.0f}).setDuration(0);
        new AnimatorSet().playSequentially(new Animator[]{ofFloat, r1});
        AppMethodBeat.m2505o(87138);
        return ofFloat;
    }

    /* renamed from: h */
    public Object mo61175h(C19640n c19640n) {
        AppMethodBeat.m2504i(87139);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c19640n, "translationX", new float[]{-(((float) c19640n.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        AppMethodBeat.m2505o(87139);
        return ofFloat;
    }

    /* renamed from: i */
    public Object mo61176i(C19640n c19640n) {
        AppMethodBeat.m2504i(87140);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c19640n, "translationX", new float[]{0.0f, (float) c19640n.getWidth()});
        ofFloat.setDuration(250);
        AppMethodBeat.m2505o(87140);
        return ofFloat;
    }

    /* renamed from: j */
    private static void m65093j(C19640n c19640n) {
        AppMethodBeat.m2504i(87141);
        c19640n.clearAnimation();
        Object tag = c19640n.getTag(irH);
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            animator.cancel();
            animator.removeAllListeners();
        }
        AppMethodBeat.m2505o(87141);
    }

    /* renamed from: a */
    private void m65073a(final C19640n c19640n, Object obj, final Runnable runnable) {
        AppMethodBeat.m2504i(87142);
        if (obj instanceof Animator) {
            Animator animator = (Animator) obj;
            C38470q.m65093j(c19640n);
            c19640n.setTag(irH, animator);
            animator.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.m2504i(87086);
                    c19640n.setTag(C38470q.irH, null);
                    AppMethodBeat.m2505o(87086);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(87087);
                    c19640n.setTag(C38470q.irH, null);
                    AppMethodBeat.m2505o(87087);
                }
            });
            animator.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(87088);
                    if (runnable != null) {
                        C38470q.this.post(runnable);
                    }
                    AppMethodBeat.m2505o(87088);
                }
            });
            animator.start();
            AppMethodBeat.m2505o(87142);
        } else if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            animation.setAnimationListener(new AnimationListener() {

                /* renamed from: com.tencent.mm.plugin.appbrand.page.q$13$1 */
                class C334701 implements Runnable {
                    C334701() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(87090);
                        runnable.run();
                        c19640n.setTag(C38470q.irH, null);
                        AppMethodBeat.m2505o(87090);
                    }
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(87091);
                    if (runnable != null) {
                        C38470q.this.post(new C334701());
                        AppMethodBeat.m2505o(87091);
                        return;
                    }
                    c19640n.setTag(C38470q.irH, null);
                    AppMethodBeat.m2505o(87091);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            C38470q.m65093j(c19640n);
            c19640n.setTag(irH, animation);
            c19640n.startAnimation(animation);
            AppMethodBeat.m2505o(87142);
        } else if (obj == null) {
            runnable.run();
            AppMethodBeat.m2505o(87142);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Page animation should be Animator or Animation");
            AppMethodBeat.m2505o(87142);
            throw illegalArgumentException;
        }
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(87143);
        if (getCurrentPage() == null) {
            AppMethodBeat.m2505o(87143);
        } else if (getCurrentPage().getCurrentPageView().mo53753wY()) {
            AppMethodBeat.m2505o(87143);
        } else if (this.irL.isEmpty() && getCurrentPage().getTag(irH) == null) {
            aAU();
            AppMethodBeat.m2505o(87143);
        } else {
            C4990ab.m7420w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
            AppMethodBeat.m2505o(87143);
        }
    }

    public boolean aAV() {
        AppMethodBeat.m2504i(87144);
        if (this.irK.size() > 1 || getRuntime().gNS) {
            AppMethodBeat.m2505o(87144);
            return true;
        }
        AppMethodBeat.m2505o(87144);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public C19640n mo61163b(String str, C2412aq c2412aq) {
        boolean z = true;
        AppMethodBeat.m2504i(87113);
        if (c2412aq != C2412aq.SWITCH_TAB) {
            if (c2412aq == C2412aq.RE_LAUNCH || c2412aq == C2412aq.AUTO_RE_LAUNCH) {
                z = this.gPI.getAppConfig().heV.mo60906yU(str);
            } else {
                int i;
                int size = this.irK.size() + 1;
                if (c2412aq == C2412aq.REDIRECT_TO) {
                    i = 1;
                } else {
                    i = 0;
                }
                i = size - i;
                if (!(this.gPI.getAppConfig().heV.mo60906yU(str) && i == 1)) {
                    z = false;
                }
            }
        }
        if (z) {
            C27224g c27224g = new C27224g(getContext(), this);
            AppMethodBeat.m2505o(87113);
            return c27224g;
        }
        C19640n c38482z = new C38482z(getContext(), this);
        AppMethodBeat.m2505o(87113);
        return c38482z;
    }
}
