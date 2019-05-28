package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.C19835c;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C2541a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C27359f;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C36733d;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C36733d.C31333a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C38576c;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C38577e;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView */
public class AppBrandDesktopDragView extends DragFeatureView {
    private List iKa;
    private HeaderContainer iVo;
    private List iWE;
    private int iWF = 0;
    private boolean iWG = false;
    private boolean iWH = false;
    private C42707b iWI = null;
    private int iWJ = 0;
    private boolean iWK = false;
    private boolean iWL = false;
    private C42706a iWM;
    private C46898e iWN;
    private int paddingLeft = 0;
    private int paddingTop = 0;
    /* renamed from: rD */
    private ValueAnimator f17187rD;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$1 */
    class C109451 implements C31333a {
        C109451() {
        }

        /* renamed from: bz */
        public final Object mo22522bz(Object obj) {
            AppMethodBeat.m2504i(133732);
            if (obj instanceof C19835c) {
                C19835c c19835c = (C19835c) obj;
                C19835c c19835c2 = new C19835c(1);
                c19835c2.iXW = c19835c.iXW;
                c19835c2.position = c19835c.position;
                AppMethodBeat.m2505o(133732);
                return c19835c2;
            }
            AppMethodBeat.m2505o(133732);
            return obj;
        }

        /* renamed from: cv */
        public final View mo22523cv(View view) {
            AppMethodBeat.m2504i(133733);
            View findViewById = view.findViewById(2131821502);
            AppMethodBeat.m2505o(133733);
            return findViewById;
        }

        public final float aNa() {
            AppMethodBeat.m2504i(133734);
            float a = AppBrandDesktopDragView.m75645a(AppBrandDesktopDragView.this);
            AppMethodBeat.m2505o(133734);
            return a;
        }

        public final float aNb() {
            AppMethodBeat.m2504i(133735);
            float b = AppBrandDesktopDragView.m75649b(AppBrandDesktopDragView.this);
            AppMethodBeat.m2505o(133735);
            return b;
        }

        public final void aPj() {
            AppMethodBeat.m2504i(133736);
            C4990ab.m7410d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
            AppBrandDesktopDragView.this.iWG = true;
            AppMethodBeat.m2505o(133736);
        }

        public final void aPk() {
            AppMethodBeat.m2504i(133737);
            C4990ab.m7410d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
            AppBrandDesktopDragView.this.iWG = false;
            AppMethodBeat.m2505o(133737);
        }

        /* renamed from: f */
        public final void mo22524f(Object obj, int i) {
            if (obj instanceof C19835c) {
                ((C19835c) obj).position = i;
            }
        }

        /* renamed from: x */
        public final boolean mo22525x(Object obj, Object obj2) {
            AppMethodBeat.m2504i(133738);
            if (obj2 == null || obj == null) {
                AppMethodBeat.m2505o(133738);
                return false;
            }
            if ((obj2 instanceof C19835c) && (obj instanceof C19835c)) {
                boolean z;
                C19835c c19835c = (C19835c) obj2;
                C19835c c19835c2 = (C19835c) obj;
                if (c19835c.iXW == null || c19835c2.iXW == null || C5046bo.isNullOrNil(c19835c.iXW.username) || C5046bo.isNullOrNil(c19835c2.iXW.username) || !c19835c2.iXW.mo53657e(c19835c.iXW)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    AppMethodBeat.m2505o(133738);
                    return true;
                }
            }
            AppMethodBeat.m2505o(133738);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$3 */
    class C198123 implements C27359f {
        C198123() {
        }

        /* renamed from: bz */
        public final Object mo22522bz(Object obj) {
            AppMethodBeat.m2504i(133745);
            if (obj instanceof C19835c) {
                C19835c c19835c = (C19835c) obj;
                C19835c c19835c2 = new C19835c(1);
                c19835c2.iXW = c19835c.iXW;
                AppMethodBeat.m2505o(133745);
                return c19835c2;
            }
            AppMethodBeat.m2505o(133745);
            return obj;
        }

        /* renamed from: cv */
        public final View mo22523cv(View view) {
            AppMethodBeat.m2504i(133746);
            View findViewById = view.findViewById(2131821502);
            AppMethodBeat.m2505o(133746);
            return findViewById;
        }

        public final float aNa() {
            AppMethodBeat.m2504i(133747);
            float a = AppBrandDesktopDragView.m75645a(AppBrandDesktopDragView.this);
            AppMethodBeat.m2505o(133747);
            return a;
        }

        public final float aNb() {
            AppMethodBeat.m2504i(133748);
            float b = AppBrandDesktopDragView.m75649b(AppBrandDesktopDragView.this);
            AppMethodBeat.m2505o(133748);
            return b;
        }

        /* renamed from: f */
        public final void mo22524f(Object obj, int i) {
            if (obj instanceof C19835c) {
                ((C19835c) obj).position = i;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$2 */
    class C335942 implements C2541a {
        C335942() {
        }

        /* renamed from: b */
        public final View mo6503b(RecyclerView recyclerView, C41531v c41531v) {
            AppMethodBeat.m2504i(133739);
            if (c41531v instanceof C46898e) {
                View a = AppBrandDesktopDragView.this.mo68118a((C46898e) c41531v);
                AppMethodBeat.m2505o(133739);
                return a;
            }
            AppMethodBeat.m2505o(133739);
            return null;
        }

        /* renamed from: a */
        public final void mo6501a(C41531v c41531v, View view, Object obj, int i) {
            AppMethodBeat.m2504i(133740);
            if (i == 6) {
                AppBrandDesktopDragView.this.iWH = true;
            } else {
                AppBrandDesktopDragView.this.iWH = false;
            }
            AppBrandDesktopDragView.m75647a(AppBrandDesktopDragView.this, c41531v, view, obj, i);
            AppMethodBeat.m2505o(133740);
        }

        /* renamed from: cu */
        public final void mo6505cu(View view) {
            AppMethodBeat.m2504i(133741);
            if (view != null) {
                View findViewById = view.findViewById(2131823276);
                if (findViewById != null) {
                    findViewById.setVisibility(4);
                }
                findViewById = view.findViewById(2131825237);
                if (findViewById != null) {
                    findViewById.setVisibility(4);
                }
            }
            AppMethodBeat.m2505o(133741);
        }

        /* renamed from: a */
        public final void mo6500a(int i, int i2, Object obj, boolean z) {
            AppMethodBeat.m2504i(133742);
            if (z && AppBrandDesktopDragView.this.iWI != null) {
                AppBrandDesktopDragView.this.iWI.mo22526bI(obj);
            }
            AppMethodBeat.m2505o(133742);
        }

        /* renamed from: a */
        public final boolean mo6502a(C41531v c41531v, Object obj) {
            AppMethodBeat.m2504i(133743);
            if (AppBrandDesktopDragView.m75646a(AppBrandDesktopDragView.this, obj) != 0) {
                C4990ab.m7412e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
                AppMethodBeat.m2505o(133743);
                return false;
            } else if (c41531v.apN == 1 || c41531v.apN == 2 || c41531v.apN == 7) {
                AppMethodBeat.m2505o(133743);
                return true;
            } else {
                AppMethodBeat.m2505o(133743);
                return false;
            }
        }

        /* renamed from: P */
        public final boolean mo6499P(C41531v c41531v) {
            return c41531v == null || c41531v.apN == 2 || c41531v.apN == 10 || c41531v.apN == 11;
        }

        /* renamed from: by */
        public final void mo6504by(Object obj) {
            AppMethodBeat.m2504i(133744);
            if (obj instanceof C19835c) {
                ((C19835c) obj).type = 2;
                if (AppBrandDesktopDragView.this.iWI != null) {
                    AppBrandDesktopDragView.this.iWI.mo22528bK(obj);
                }
            }
            AppMethodBeat.m2505o(133744);
        }

        /* renamed from: O */
        public final boolean mo6498O(C41531v c41531v) {
            return c41531v.apN == 2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$5 */
    class C427035 implements AnimatorListener {
        C427035() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133752);
            AppBrandDesktopDragView.this.iWL = false;
            AppMethodBeat.m2505o(133752);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133753);
            AppBrandDesktopDragView.this.iWL = false;
            AppMethodBeat.m2505o(133753);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$7 */
    class C427057 implements AnimatorListener {
        C427057() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133756);
            AppBrandDesktopDragView.this.mo54135ee(true);
            AppMethodBeat.m2505o(133756);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$a */
    public interface C42706a {
        int aPl();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$b */
    public interface C42707b {
        /* renamed from: bI */
        void mo22526bI(Object obj);

        /* renamed from: bJ */
        void mo22527bJ(Object obj);

        /* renamed from: bK */
        void mo22528bK(Object obj);

        /* renamed from: e */
        void mo22529e(int i, int i2, Object obj);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView$4 */
    class C427084 implements C2541a {
        C427084() {
        }

        /* renamed from: b */
        public final View mo6503b(RecyclerView recyclerView, C41531v c41531v) {
            AppMethodBeat.m2504i(133749);
            View a = AppBrandDesktopDragView.this.mo68118a((C46898e) c41531v);
            AppMethodBeat.m2505o(133749);
            return a;
        }

        /* renamed from: a */
        public final void mo6501a(C41531v c41531v, View view, Object obj, int i) {
        }

        /* renamed from: cu */
        public final void mo6505cu(View view) {
        }

        /* renamed from: a */
        public final void mo6500a(int i, int i2, Object obj, boolean z) {
            AppMethodBeat.m2504i(133750);
            if (AppBrandDesktopDragView.this.iWI != null) {
                AppBrandDesktopDragView.this.iWI.mo22529e(i, i2, obj);
            }
            AppMethodBeat.m2505o(133750);
        }

        /* renamed from: O */
        public final boolean mo6498O(C41531v c41531v) {
            return c41531v.apN == 1;
        }

        /* renamed from: a */
        public final boolean mo6502a(C41531v c41531v, Object obj) {
            return c41531v.apN == 1 || c41531v.apN == 7;
        }

        /* renamed from: P */
        public final boolean mo6499P(C41531v c41531v) {
            return false;
        }

        /* renamed from: by */
        public final void mo6504by(Object obj) {
            AppMethodBeat.m2504i(133751);
            if ((obj instanceof C19835c) && AppBrandDesktopDragView.this.iWI != null) {
                AppBrandDesktopDragView.this.iWI.mo22527bJ(obj);
            }
            AppMethodBeat.m2505o(133751);
        }
    }

    /* renamed from: b */
    static /* synthetic */ float m75649b(AppBrandDesktopDragView appBrandDesktopDragView) {
        AppMethodBeat.m2504i(133771);
        float offsetY = appBrandDesktopDragView.getOffsetY();
        AppMethodBeat.m2505o(133771);
        return offsetY;
    }

    public AppBrandDesktopDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133758);
        init();
        AppMethodBeat.m2505o(133758);
    }

    public AppBrandDesktopDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(133759);
        init();
        AppMethodBeat.m2505o(133759);
    }

    private void init() {
        AppMethodBeat.m2504i(133760);
        this.paddingTop = getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
        AppMethodBeat.m2505o(133760);
    }

    public void setHeaderContainer(HeaderContainer headerContainer) {
        this.iVo = headerContainer;
    }

    public void setCollectionStartPosition(int i) {
        this.iWF = i;
    }

    public void setAppBrandCounter(C42706a c42706a) {
        this.iWM = c42706a;
    }

    public void setList(List list) {
        this.iKa = list;
    }

    public void setCopyList(List list) {
        this.iWE = list;
    }

    public void setCollectionCallback(C42707b c42707b) {
        this.iWI = c42707b;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: N */
    public final C38576c mo54132N(C41531v c41531v) {
        AppMethodBeat.m2504i(133761);
        int dimensionPixelSize;
        int i;
        if (c41531v == null || c41531v.apN != 2) {
            this.iWG = true;
            C38576c c38577e = new C38577e(this, this.iKa, new C198123());
            c38577e.iYu = getRecyclerScrollComputer();
            c38577e.jbg = new C427084();
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            i = this.paddingLeft;
            c38577e.paddingTop = dimensionPixelSize;
            c38577e.paddingLeft = i;
            AppMethodBeat.m2505o(133761);
            return c38577e;
        }
        this.iWG = false;
        C36733d c36733d = new C36733d(this, this.iWE, this.iKa, new C109451());
        dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        i = this.paddingLeft;
        c36733d.paddingTop = dimensionPixelSize;
        c36733d.paddingLeft = i;
        c36733d.iYu = getRecyclerScrollComputer();
        c36733d.jbg = new C335942();
        AppMethodBeat.m2505o(133761);
        return c36733d;
    }

    /* renamed from: m */
    private void m75656m(final View view, boolean z) {
        AppMethodBeat.m2504i(133762);
        if (view.getVisibility() == 0 && z) {
            AppMethodBeat.m2505o(133762);
        } else if (z && this.iWL) {
            AppMethodBeat.m2505o(133762);
        } else if (view.getVisibility() != 0 && !z) {
            AppMethodBeat.m2505o(133762);
        } else if (!z && this.iWK) {
            AppMethodBeat.m2505o(133762);
        } else if (z) {
            this.iWL = true;
            view.setScaleX(0.1f);
            view.setScaleY(0.1f);
            view.setVisibility(0);
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).setListener(new C427035()).start();
            AppMethodBeat.m2505o(133762);
        } else {
            this.iWK = true;
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setVisibility(0);
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(133754);
                    AppBrandDesktopDragView.this.iWK = false;
                    view.setVisibility(4);
                    AppMethodBeat.m2505o(133754);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.m2504i(133755);
                    AppBrandDesktopDragView.this.iWK = false;
                    view.setVisibility(4);
                    AppMethodBeat.m2505o(133755);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            AppMethodBeat.m2505o(133762);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setRubbishViewVisible(int i) {
        boolean z;
        float f;
        AppMethodBeat.m2504i(133763);
        super.setRubbishViewVisible(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        float dimension = getResources().getDimension(C25738R.dimen.a7o) * 0.75f;
        if (z) {
            f = -dimension;
        } else {
            f = dimension;
        }
        final int i2 = z ? 0 : (int) f;
        C4990ab.m7419v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim isShow: %b, offset: %f, extraBottomHeight: %d", Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i2));
        float[] fArr = new float[]{0.0f, f};
        this.f17187rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("transY", fArr)});
        final int i3 = this.iVo.getBackUpFooterRect().top;
        this.f17187rD.addUpdateListener(new AnimatorUpdateListener() {
            float iWQ = 0.0f;
            float iWR = 0.0f;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(133757);
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue("transY")).floatValue();
                    this.iWR += floatValue - this.iWQ;
                    AppBrandDesktopDragView.this.iVo.getBackUpFooterRect().top = (int) (((float) i3) + floatValue);
                    C4990ab.m7419v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim totalValue: %f, top: %d", Float.valueOf(this.iWR), Integer.valueOf(AppBrandDesktopDragView.this.iVo.getBackUpFooterRect().top));
                    AppBrandDesktopDragView.this.iVo.setExtraBottomHeight(i2 - ((int) this.iWR));
                    AppBrandDesktopDragView.this.iVo.requestLayout();
                    this.iWQ = floatValue;
                    if (AppBrandDesktopDragView.this.iVo.getParent() != null) {
                        ((ViewGroup) AppBrandDesktopDragView.this.iVo.getParent()).invalidate();
                    }
                    AppMethodBeat.m2505o(133757);
                } catch (Exception e) {
                    AppMethodBeat.m2505o(133757);
                }
            }
        });
        this.f17187rD.setDuration(300);
        this.f17187rD.start();
        AppMethodBeat.m2505o(133763);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133764);
        super.onLayout(z, i, i2, i3, i4);
        getGlobalVisibleRect(this.iYo);
        this.iYo.set(this.iYo.left, ((this.iYo.bottom - this.iYi) - ((int) (((float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.a2z)) * 0.75f))) - 40, this.iYo.right, this.iYo.bottom - this.iYi);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", this.iYo);
        getRecyclerView().getGlobalVisibleRect(this.iYp);
        this.iYp.set(this.iYp.left, 0, this.iYp.right, this.iYp.top + this.iYi);
        AppMethodBeat.m2505o(133764);
    }

    public void setItemPadding(int i) {
        this.paddingLeft = i;
    }

    /* renamed from: bH */
    private int m75651bH(Object obj) {
        AppMethodBeat.m2504i(133765);
        int i = this.iWG ? (this.iWM == null || this.iWM.aPl() - 1 < C2545b.axI()) ? 0 : 1 : (this.iWM == null || this.iWM.aPl() < C2545b.axI()) ? 0 : 1;
        if (i != 0) {
            C4990ab.m7417i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", Integer.valueOf(this.iWM.aPl()), Integer.valueOf(C2545b.axI()));
            AppMethodBeat.m2505o(133765);
            return 2;
        }
        if (obj instanceof C19835c) {
            C19835c c19835c = (C19835c) obj;
            if (c19835c.iXW != null) {
                if (!C33097a.m54090np(c19835c.iXW.har)) {
                    AppMethodBeat.m2505o(133765);
                    return 0;
                } else if (c19835c.iXW.haR <= System.currentTimeMillis() / 1000) {
                    AppMethodBeat.m2505o(133765);
                    return 0;
                } else {
                    AppMethodBeat.m2505o(133765);
                    return 1;
                }
            }
        }
        AppMethodBeat.m2505o(133765);
        return 99;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final C41531v mo54134e(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(133766);
        getRecyclerView().getGlobalVisibleRect(this.mRect);
        if (this.mRect.contains((int) f, (int) f2)) {
            Object obj = null;
            C41531v c41531v = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getRecyclerView().getChildCount()) {
                    C41531v aZ = getRecyclerView().mo66337aZ(getRecyclerView().getChildAt(i2));
                    if (!(aZ.apN == 7 || aZ.apN == 3 || aZ.apN == 8)) {
                        aZ.apJ.getGlobalVisibleRect(this.mRect);
                        if (this.mRect.contains((int) f, (int) f2)) {
                            if (2 == aZ.apN) {
                                RecyclerView recyclerView = (RecyclerView) aZ.apJ.findViewById(2131821168);
                                int i3 = 0;
                                while (i3 < recyclerView.getAdapter().getItemCount()) {
                                    C41531v cf = recyclerView.mo66357cf(i3);
                                    if (!(cf == null || cf.apJ == null)) {
                                        cf.apJ.getGlobalVisibleRect(this.mRect);
                                        if (this.mRect.contains((int) f, (int) f2)) {
                                            obj = 1;
                                            i3++;
                                            c41531v = cf;
                                        }
                                    }
                                    cf = c41531v;
                                    i3++;
                                    c41531v = cf;
                                }
                                if (obj != null) {
                                    continue;
                                } else if (z) {
                                    AppMethodBeat.m2505o(133766);
                                    return null;
                                }
                            }
                            obj = 1;
                            c41531v = aZ;
                        } else {
                            continue;
                        }
                    }
                    i = i2 + 1;
                } else if (obj != null) {
                    AppMethodBeat.m2505o(133766);
                    return c41531v;
                } else {
                    if (!z) {
                        for (i = getRecyclerView().getChildCount() - 1; i >= 0; i--) {
                            c41531v = getRecyclerView().mo66337aZ(getRecyclerView().getChildAt(i));
                            if (this.iWG) {
                                if (c41531v.apN == 1) {
                                    AppMethodBeat.m2505o(133766);
                                    return c41531v;
                                }
                            } else if (c41531v.apN == 7) {
                                AppMethodBeat.m2505o(133766);
                                return c41531v;
                            }
                        }
                    }
                    AppMethodBeat.m2505o(133766);
                    return null;
                }
            }
        }
        AppMethodBeat.m2505o(133766);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final View mo68118a(C46898e c46898e) {
        AppMethodBeat.m2504i(133767);
        View inflate = C5616v.m8409hu(getContext()).inflate(2130969924, null, false);
        getResources().getDimensionPixelSize(C25738R.dimen.f10132r2);
        inflate.setLayoutParams(new LayoutParams(-2, -2));
        this.iWN = new C46898e(inflate);
        C46898e c46898e2 = this.iWN;
        View view = c46898e.apJ;
        View view2 = c46898e2.apJ;
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
        view2.setAlpha(1.0f);
        view2.setVisibility(0);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        c46898e2.iqT.setImageDrawable(c46898e.iqT.getDrawable());
        c46898e2.iqT.setBackground(c46898e.iqT.getBackground());
        c46898e2.iYf.setText(c46898e.iYf.getText());
        c46898e2.iYf.setVisibility(c46898e.iYf.getVisibility());
        c46898e2.iYg.setVisibility(4);
        float dl = C10969d.m18709dl(getContext());
        float fromDPToPix = (dl * 1.5f) + ((float) (C1338a.fromDPToPix(getContext(), 8) * 2));
        C4990ab.m7417i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", Float.valueOf(fromDPToPix));
        view2.findViewById(2131825239).getLayoutParams().height = (int) fromDPToPix;
        c46898e2.iYe.getLayoutParams().height = (int) fromDPToPix;
        c46898e2.iYe.getLayoutParams().width = ((int) dl) + ((int) (((float) (C1338a.m2857am(getContext(), C25738R.dimen.f10011nc) * 2)) * C10969d.m18710dm(getContext())));
        c46898e2.iqT.getLayoutParams().width = (int) dl;
        c46898e2.iqT.getLayoutParams().height = (int) dl;
        c46898e2.iYd.getLayoutParams().width = (int) dl;
        c46898e2.iYd.getLayoutParams().height = (int) dl;
        ViewGroup.LayoutParams layoutParams = c46898e2.iYg.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = C1338a.fromDPToPix(getContext(), 6) + ((int) ((dl * 0.5f) / 2.0f));
            layoutParams.width = (int) (((float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9948l5)) * C10969d.m18710dm(getContext()));
            layoutParams.height = (int) (((float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9948l5)) * C10969d.m18710dm(getContext()));
        }
        fromDPToPix = ((float) iArr[0]) + getOffsetX();
        float fromDPToPix2 = (((float) (iArr[1] + this.paddingTop)) - (((dl * 1.5f) - dl) / 2.0f)) - ((float) C1338a.fromDPToPix(getContext(), 48));
        view2.findViewById(2131825237).setVisibility(4);
        view2.findViewById(2131821502).animate().alpha(0.5f).setDuration(300).setListener(null).start();
        mo54135ee(false);
        view2.findViewById(2131821502).animate().scaleX(1.5f).scaleY(1.5f).setDuration(300).setListener(new C427057()).start();
        ImageView imageView = (ImageView) view2.findViewById(2131823276);
        imageView.getLayoutParams().height = (int) (((float) C1338a.fromDPToPix(getContext(), 24)) * C10969d.m18710dm(getContext()));
        imageView.getLayoutParams().width = (int) (((float) C1338a.fromDPToPix(getContext(), 24)) * C10969d.m18710dm(getContext()));
        imageView.setTranslationY(((-dl) * 0.5f) / 2.0f);
        imageView.setTranslationX((dl * 0.5f) / 2.0f);
        view2.setTranslationX(fromDPToPix);
        view2.setTranslationY(fromDPToPix2);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", Float.valueOf(getOffsetX()), Float.valueOf(fromDPToPix), Float.valueOf(fromDPToPix2));
        AppMethodBeat.m2505o(133767);
        return view2;
    }

    private float getOffsetX() {
        AppMethodBeat.m2504i(133768);
        float screenWidth = ((float) this.paddingLeft) - (((float) (C10969d.getScreenWidth(getContext()) / 2)) - (((float) C10969d.m18706di(getContext())) / 2.0f));
        AppMethodBeat.m2505o(133768);
        return screenWidth;
    }

    private float getOffsetY() {
        AppMethodBeat.m2504i(133769);
        float f = -(((float) C1338a.fromDPToPix(getContext(), 32)) + (((C10969d.m18709dl(getContext()) * 1.5f) - C10969d.m18709dl(getContext())) / 2.0f));
        AppMethodBeat.m2505o(133769);
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ void m75647a(AppBrandDesktopDragView appBrandDesktopDragView, C41531v c41531v, View view, Object obj, int i) {
        AppMethodBeat.m2504i(133772);
        if (view != null) {
            boolean z;
            boolean z2;
            if (appBrandDesktopDragView.iWH) {
                z = false;
            } else {
                z = true;
            }
            if (c41531v == null) {
                z = false;
            }
            if (c41531v != null && (c41531v.apJ instanceof RecentAppBrandViewContainer)) {
                z = false;
            }
            if (i == 2) {
                z2 = true;
            } else {
                z2 = z;
            }
            ImageView imageView = (ImageView) view.findViewById(2131823276);
            if (imageView != null) {
                if (z2 && c41531v != null && (c41531v.apN == 1 || c41531v.apN == 7)) {
                    int bH = appBrandDesktopDragView.m75651bH(obj);
                    if (bH == 0) {
                        view.findViewById(2131825237).setVisibility(4);
                        imageView.setImageResource(C1318a.app_brand_desktop_add_icon);
                        appBrandDesktopDragView.m75656m(imageView, true);
                        AppMethodBeat.m2505o(133772);
                        return;
                    } else if (bH == 1) {
                        imageView.setVisibility(4);
                        view.findViewById(2131825237).setVisibility(0);
                        ((TextView) view.findViewById(2131825238)).setText(C25738R.string.f8836gh);
                        AppMethodBeat.m2505o(133772);
                        return;
                    } else if (bH == 2) {
                        imageView.setVisibility(4);
                        view.findViewById(2131825237).setVisibility(0);
                        ((TextView) view.findViewById(2131825238)).setText(String.format(appBrandDesktopDragView.getContext().getResources().getString(C25738R.string.f8875ht), new Object[]{Integer.valueOf(C2545b.axI())}));
                        AppMethodBeat.m2505o(133772);
                        return;
                    } else {
                        imageView.setVisibility(4);
                        view.findViewById(2131825237).setVisibility(4);
                        AppMethodBeat.m2505o(133772);
                        return;
                    }
                }
                view.findViewById(2131825237).setVisibility(4);
                appBrandDesktopDragView.m75656m(imageView, false);
            }
        }
        AppMethodBeat.m2505o(133772);
    }
}
