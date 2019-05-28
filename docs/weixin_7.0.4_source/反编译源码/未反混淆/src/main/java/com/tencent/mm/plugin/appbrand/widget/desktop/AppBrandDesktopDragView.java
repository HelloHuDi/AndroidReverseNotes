package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.f;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class AppBrandDesktopDragView extends DragFeatureView {
    private List iKa;
    private HeaderContainer iVo;
    private List iWE;
    private int iWF = 0;
    private boolean iWG = false;
    private boolean iWH = false;
    private b iWI = null;
    private int iWJ = 0;
    private boolean iWK = false;
    private boolean iWL = false;
    private a iWM;
    private e iWN;
    private int paddingLeft = 0;
    private int paddingTop = 0;
    private ValueAnimator rD;

    public interface a {
        int aPl();
    }

    public interface b {
        void bI(Object obj);

        void bJ(Object obj);

        void bK(Object obj);

        void e(int i, int i2, Object obj);
    }

    static /* synthetic */ float b(AppBrandDesktopDragView appBrandDesktopDragView) {
        AppMethodBeat.i(133771);
        float offsetY = appBrandDesktopDragView.getOffsetY();
        AppMethodBeat.o(133771);
        return offsetY;
    }

    public AppBrandDesktopDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133758);
        init();
        AppMethodBeat.o(133758);
    }

    public AppBrandDesktopDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133759);
        init();
        AppMethodBeat.o(133759);
    }

    private void init() {
        AppMethodBeat.i(133760);
        this.paddingTop = getResources().getDimensionPixelOffset(R.dimen.l5);
        AppMethodBeat.o(133760);
    }

    public void setHeaderContainer(HeaderContainer headerContainer) {
        this.iVo = headerContainer;
    }

    public void setCollectionStartPosition(int i) {
        this.iWF = i;
    }

    public void setAppBrandCounter(a aVar) {
        this.iWM = aVar;
    }

    public void setList(List list) {
        this.iKa = list;
    }

    public void setCopyList(List list) {
        this.iWE = list;
    }

    public void setCollectionCallback(b bVar) {
        this.iWI = bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final c N(v vVar) {
        AppMethodBeat.i(133761);
        int dimensionPixelSize;
        int i;
        if (vVar == null || vVar.apN != 2) {
            this.iWG = true;
            c eVar = new e(this, this.iKa, new f() {
                public final Object bz(Object obj) {
                    AppMethodBeat.i(133745);
                    if (obj instanceof AppBrandDesktopView.c) {
                        AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj;
                        AppBrandDesktopView.c cVar2 = new AppBrandDesktopView.c(1);
                        cVar2.iXW = cVar.iXW;
                        AppMethodBeat.o(133745);
                        return cVar2;
                    }
                    AppMethodBeat.o(133745);
                    return obj;
                }

                public final View cv(View view) {
                    AppMethodBeat.i(133746);
                    View findViewById = view.findViewById(R.id.yv);
                    AppMethodBeat.o(133746);
                    return findViewById;
                }

                public final float aNa() {
                    AppMethodBeat.i(133747);
                    float a = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
                    AppMethodBeat.o(133747);
                    return a;
                }

                public final float aNb() {
                    AppMethodBeat.i(133748);
                    float b = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
                    AppMethodBeat.o(133748);
                    return b;
                }

                public final void f(Object obj, int i) {
                    if (obj instanceof AppBrandDesktopView.c) {
                        ((AppBrandDesktopView.c) obj).position = i;
                    }
                }
            });
            eVar.iYu = getRecyclerScrollComputer();
            eVar.jbg = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a() {
                public final View b(RecyclerView recyclerView, v vVar) {
                    AppMethodBeat.i(133749);
                    View a = AppBrandDesktopDragView.this.a((e) vVar);
                    AppMethodBeat.o(133749);
                    return a;
                }

                public final void a(v vVar, View view, Object obj, int i) {
                }

                public final void cu(View view) {
                }

                public final void a(int i, int i2, Object obj, boolean z) {
                    AppMethodBeat.i(133750);
                    if (AppBrandDesktopDragView.this.iWI != null) {
                        AppBrandDesktopDragView.this.iWI.e(i, i2, obj);
                    }
                    AppMethodBeat.o(133750);
                }

                public final boolean O(v vVar) {
                    return vVar.apN == 1;
                }

                public final boolean a(v vVar, Object obj) {
                    return vVar.apN == 1 || vVar.apN == 7;
                }

                public final boolean P(v vVar) {
                    return false;
                }

                public final void by(Object obj) {
                    AppMethodBeat.i(133751);
                    if ((obj instanceof AppBrandDesktopView.c) && AppBrandDesktopDragView.this.iWI != null) {
                        AppBrandDesktopDragView.this.iWI.bJ(obj);
                    }
                    AppMethodBeat.o(133751);
                }
            };
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nc);
            i = this.paddingLeft;
            eVar.paddingTop = dimensionPixelSize;
            eVar.paddingLeft = i;
            AppMethodBeat.o(133761);
            return eVar;
        }
        this.iWG = false;
        d dVar = new d(this, this.iWE, this.iKa, new com.tencent.mm.plugin.appbrand.widget.desktop.a.d.a() {
            public final Object bz(Object obj) {
                AppMethodBeat.i(133732);
                if (obj instanceof AppBrandDesktopView.c) {
                    AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj;
                    AppBrandDesktopView.c cVar2 = new AppBrandDesktopView.c(1);
                    cVar2.iXW = cVar.iXW;
                    cVar2.position = cVar.position;
                    AppMethodBeat.o(133732);
                    return cVar2;
                }
                AppMethodBeat.o(133732);
                return obj;
            }

            public final View cv(View view) {
                AppMethodBeat.i(133733);
                View findViewById = view.findViewById(R.id.yv);
                AppMethodBeat.o(133733);
                return findViewById;
            }

            public final float aNa() {
                AppMethodBeat.i(133734);
                float a = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
                AppMethodBeat.o(133734);
                return a;
            }

            public final float aNb() {
                AppMethodBeat.i(133735);
                float b = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
                AppMethodBeat.o(133735);
                return b;
            }

            public final void aPj() {
                AppMethodBeat.i(133736);
                ab.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
                AppBrandDesktopDragView.this.iWG = true;
                AppMethodBeat.o(133736);
            }

            public final void aPk() {
                AppMethodBeat.i(133737);
                ab.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
                AppBrandDesktopDragView.this.iWG = false;
                AppMethodBeat.o(133737);
            }

            public final void f(Object obj, int i) {
                if (obj instanceof AppBrandDesktopView.c) {
                    ((AppBrandDesktopView.c) obj).position = i;
                }
            }

            public final boolean x(Object obj, Object obj2) {
                AppMethodBeat.i(133738);
                if (obj2 == null || obj == null) {
                    AppMethodBeat.o(133738);
                    return false;
                }
                if ((obj2 instanceof AppBrandDesktopView.c) && (obj instanceof AppBrandDesktopView.c)) {
                    boolean z;
                    AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj2;
                    AppBrandDesktopView.c cVar2 = (AppBrandDesktopView.c) obj;
                    if (cVar.iXW == null || cVar2.iXW == null || bo.isNullOrNil(cVar.iXW.username) || bo.isNullOrNil(cVar2.iXW.username) || !cVar2.iXW.e(cVar.iXW)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        AppMethodBeat.o(133738);
                        return true;
                    }
                }
                AppMethodBeat.o(133738);
                return false;
            }
        });
        dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nc);
        i = this.paddingLeft;
        dVar.paddingTop = dimensionPixelSize;
        dVar.paddingLeft = i;
        dVar.iYu = getRecyclerScrollComputer();
        dVar.jbg = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a() {
            public final View b(RecyclerView recyclerView, v vVar) {
                AppMethodBeat.i(133739);
                if (vVar instanceof e) {
                    View a = AppBrandDesktopDragView.this.a((e) vVar);
                    AppMethodBeat.o(133739);
                    return a;
                }
                AppMethodBeat.o(133739);
                return null;
            }

            public final void a(v vVar, View view, Object obj, int i) {
                AppMethodBeat.i(133740);
                if (i == 6) {
                    AppBrandDesktopDragView.this.iWH = true;
                } else {
                    AppBrandDesktopDragView.this.iWH = false;
                }
                AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, vVar, view, obj, i);
                AppMethodBeat.o(133740);
            }

            public final void cu(View view) {
                AppMethodBeat.i(133741);
                if (view != null) {
                    View findViewById = view.findViewById(R.id.b9u);
                    if (findViewById != null) {
                        findViewById.setVisibility(4);
                    }
                    findViewById = view.findViewById(R.id.cov);
                    if (findViewById != null) {
                        findViewById.setVisibility(4);
                    }
                }
                AppMethodBeat.o(133741);
            }

            public final void a(int i, int i2, Object obj, boolean z) {
                AppMethodBeat.i(133742);
                if (z && AppBrandDesktopDragView.this.iWI != null) {
                    AppBrandDesktopDragView.this.iWI.bI(obj);
                }
                AppMethodBeat.o(133742);
            }

            public final boolean a(v vVar, Object obj) {
                AppMethodBeat.i(133743);
                if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, obj) != 0) {
                    ab.e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
                    AppMethodBeat.o(133743);
                    return false;
                } else if (vVar.apN == 1 || vVar.apN == 2 || vVar.apN == 7) {
                    AppMethodBeat.o(133743);
                    return true;
                } else {
                    AppMethodBeat.o(133743);
                    return false;
                }
            }

            public final boolean P(v vVar) {
                return vVar == null || vVar.apN == 2 || vVar.apN == 10 || vVar.apN == 11;
            }

            public final void by(Object obj) {
                AppMethodBeat.i(133744);
                if (obj instanceof AppBrandDesktopView.c) {
                    ((AppBrandDesktopView.c) obj).type = 2;
                    if (AppBrandDesktopDragView.this.iWI != null) {
                        AppBrandDesktopDragView.this.iWI.bK(obj);
                    }
                }
                AppMethodBeat.o(133744);
            }

            public final boolean O(v vVar) {
                return vVar.apN == 2;
            }
        };
        AppMethodBeat.o(133761);
        return dVar;
    }

    private void m(final View view, boolean z) {
        AppMethodBeat.i(133762);
        if (view.getVisibility() == 0 && z) {
            AppMethodBeat.o(133762);
        } else if (z && this.iWL) {
            AppMethodBeat.o(133762);
        } else if (view.getVisibility() != 0 && !z) {
            AppMethodBeat.o(133762);
        } else if (!z && this.iWK) {
            AppMethodBeat.o(133762);
        } else if (z) {
            this.iWL = true;
            view.setScaleX(0.1f);
            view.setScaleY(0.1f);
            view.setVisibility(0);
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133752);
                    AppBrandDesktopDragView.this.iWL = false;
                    AppMethodBeat.o(133752);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(133753);
                    AppBrandDesktopDragView.this.iWL = false;
                    AppMethodBeat.o(133753);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            AppMethodBeat.o(133762);
        } else {
            this.iWK = true;
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setVisibility(0);
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133754);
                    AppBrandDesktopDragView.this.iWK = false;
                    view.setVisibility(4);
                    AppMethodBeat.o(133754);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(133755);
                    AppBrandDesktopDragView.this.iWK = false;
                    view.setVisibility(4);
                    AppMethodBeat.o(133755);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            AppMethodBeat.o(133762);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setRubbishViewVisible(int i) {
        boolean z;
        float f;
        AppMethodBeat.i(133763);
        super.setRubbishViewVisible(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        float dimension = getResources().getDimension(R.dimen.a7o) * 0.75f;
        if (z) {
            f = -dimension;
        } else {
            f = dimension;
        }
        final int i2 = z ? 0 : (int) f;
        ab.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim isShow: %b, offset: %f, extraBottomHeight: %d", Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i2));
        float[] fArr = new float[]{0.0f, f};
        this.rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("transY", fArr)});
        final int i3 = this.iVo.getBackUpFooterRect().top;
        this.rD.addUpdateListener(new AnimatorUpdateListener() {
            float iWQ = 0.0f;
            float iWR = 0.0f;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(133757);
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue("transY")).floatValue();
                    this.iWR += floatValue - this.iWQ;
                    AppBrandDesktopDragView.this.iVo.getBackUpFooterRect().top = (int) (((float) i3) + floatValue);
                    ab.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim totalValue: %f, top: %d", Float.valueOf(this.iWR), Integer.valueOf(AppBrandDesktopDragView.this.iVo.getBackUpFooterRect().top));
                    AppBrandDesktopDragView.this.iVo.setExtraBottomHeight(i2 - ((int) this.iWR));
                    AppBrandDesktopDragView.this.iVo.requestLayout();
                    this.iWQ = floatValue;
                    if (AppBrandDesktopDragView.this.iVo.getParent() != null) {
                        ((ViewGroup) AppBrandDesktopDragView.this.iVo.getParent()).invalidate();
                    }
                    AppMethodBeat.o(133757);
                } catch (Exception e) {
                    AppMethodBeat.o(133757);
                }
            }
        });
        this.rD.setDuration(300);
        this.rD.start();
        AppMethodBeat.o(133763);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133764);
        super.onLayout(z, i, i2, i3, i4);
        getGlobalVisibleRect(this.iYo);
        this.iYo.set(this.iYo.left, ((this.iYo.bottom - this.iYi) - ((int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.a2z)) * 0.75f))) - 40, this.iYo.right, this.iYo.bottom - this.iYi);
        ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", this.iYo);
        getRecyclerView().getGlobalVisibleRect(this.iYp);
        this.iYp.set(this.iYp.left, 0, this.iYp.right, this.iYp.top + this.iYi);
        AppMethodBeat.o(133764);
    }

    public void setItemPadding(int i) {
        this.paddingLeft = i;
    }

    private int bH(Object obj) {
        AppMethodBeat.i(133765);
        int i = this.iWG ? (this.iWM == null || this.iWM.aPl() - 1 < b.axI()) ? 0 : 1 : (this.iWM == null || this.iWM.aPl() < b.axI()) ? 0 : 1;
        if (i != 0) {
            ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", Integer.valueOf(this.iWM.aPl()), Integer.valueOf(b.axI()));
            AppMethodBeat.o(133765);
            return 2;
        }
        if (obj instanceof AppBrandDesktopView.c) {
            AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj;
            if (cVar.iXW != null) {
                if (!com.tencent.mm.plugin.appbrand.appcache.j.a.np(cVar.iXW.har)) {
                    AppMethodBeat.o(133765);
                    return 0;
                } else if (cVar.iXW.haR <= System.currentTimeMillis() / 1000) {
                    AppMethodBeat.o(133765);
                    return 0;
                } else {
                    AppMethodBeat.o(133765);
                    return 1;
                }
            }
        }
        AppMethodBeat.o(133765);
        return 99;
    }

    /* Access modifiers changed, original: protected|final */
    public final v e(float f, float f2, boolean z) {
        AppMethodBeat.i(133766);
        getRecyclerView().getGlobalVisibleRect(this.mRect);
        if (this.mRect.contains((int) f, (int) f2)) {
            Object obj = null;
            v vVar = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getRecyclerView().getChildCount()) {
                    v aZ = getRecyclerView().aZ(getRecyclerView().getChildAt(i2));
                    if (!(aZ.apN == 7 || aZ.apN == 3 || aZ.apN == 8)) {
                        aZ.apJ.getGlobalVisibleRect(this.mRect);
                        if (this.mRect.contains((int) f, (int) f2)) {
                            if (2 == aZ.apN) {
                                RecyclerView recyclerView = (RecyclerView) aZ.apJ.findViewById(R.id.q6);
                                int i3 = 0;
                                while (i3 < recyclerView.getAdapter().getItemCount()) {
                                    v cf = recyclerView.cf(i3);
                                    if (!(cf == null || cf.apJ == null)) {
                                        cf.apJ.getGlobalVisibleRect(this.mRect);
                                        if (this.mRect.contains((int) f, (int) f2)) {
                                            obj = 1;
                                            i3++;
                                            vVar = cf;
                                        }
                                    }
                                    cf = vVar;
                                    i3++;
                                    vVar = cf;
                                }
                                if (obj != null) {
                                    continue;
                                } else if (z) {
                                    AppMethodBeat.o(133766);
                                    return null;
                                }
                            }
                            obj = 1;
                            vVar = aZ;
                        } else {
                            continue;
                        }
                    }
                    i = i2 + 1;
                } else if (obj != null) {
                    AppMethodBeat.o(133766);
                    return vVar;
                } else {
                    if (!z) {
                        for (i = getRecyclerView().getChildCount() - 1; i >= 0; i--) {
                            vVar = getRecyclerView().aZ(getRecyclerView().getChildAt(i));
                            if (this.iWG) {
                                if (vVar.apN == 1) {
                                    AppMethodBeat.o(133766);
                                    return vVar;
                                }
                            } else if (vVar.apN == 7) {
                                AppMethodBeat.o(133766);
                                return vVar;
                            }
                        }
                    }
                    AppMethodBeat.o(133766);
                    return null;
                }
            }
        }
        AppMethodBeat.o(133766);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final View a(e eVar) {
        AppMethodBeat.i(133767);
        View inflate = com.tencent.mm.ui.v.hu(getContext()).inflate(R.layout.a9m, null, false);
        getResources().getDimensionPixelSize(R.dimen.r2);
        inflate.setLayoutParams(new LayoutParams(-2, -2));
        this.iWN = new e(inflate);
        e eVar2 = this.iWN;
        View view = eVar.apJ;
        View view2 = eVar2.apJ;
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
        view2.setAlpha(1.0f);
        view2.setVisibility(0);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        eVar2.iqT.setImageDrawable(eVar.iqT.getDrawable());
        eVar2.iqT.setBackground(eVar.iqT.getBackground());
        eVar2.iYf.setText(eVar.iYf.getText());
        eVar2.iYf.setVisibility(eVar.iYf.getVisibility());
        eVar2.iYg.setVisibility(4);
        float dl = d.dl(getContext());
        float fromDPToPix = (dl * 1.5f) + ((float) (com.tencent.mm.bz.a.fromDPToPix(getContext(), 8) * 2));
        ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", Float.valueOf(fromDPToPix));
        view2.findViewById(R.id.cox).getLayoutParams().height = (int) fromDPToPix;
        eVar2.iYe.getLayoutParams().height = (int) fromDPToPix;
        eVar2.iYe.getLayoutParams().width = ((int) dl) + ((int) (((float) (com.tencent.mm.bz.a.am(getContext(), R.dimen.nc) * 2)) * d.dm(getContext())));
        eVar2.iqT.getLayoutParams().width = (int) dl;
        eVar2.iqT.getLayoutParams().height = (int) dl;
        eVar2.iYd.getLayoutParams().width = (int) dl;
        eVar2.iYd.getLayoutParams().height = (int) dl;
        ViewGroup.LayoutParams layoutParams = eVar2.iYg.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = com.tencent.mm.bz.a.fromDPToPix(getContext(), 6) + ((int) ((dl * 0.5f) / 2.0f));
            layoutParams.width = (int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.l5)) * d.dm(getContext()));
            layoutParams.height = (int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.l5)) * d.dm(getContext()));
        }
        fromDPToPix = ((float) iArr[0]) + getOffsetX();
        float fromDPToPix2 = (((float) (iArr[1] + this.paddingTop)) - (((dl * 1.5f) - dl) / 2.0f)) - ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 48));
        view2.findViewById(R.id.cov).setVisibility(4);
        view2.findViewById(R.id.yv).animate().alpha(0.5f).setDuration(300).setListener(null).start();
        ee(false);
        view2.findViewById(R.id.yv).animate().scaleX(1.5f).scaleY(1.5f).setDuration(300).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(133756);
                AppBrandDesktopDragView.this.ee(true);
                AppMethodBeat.o(133756);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        ImageView imageView = (ImageView) view2.findViewById(R.id.b9u);
        imageView.getLayoutParams().height = (int) (((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 24)) * d.dm(getContext()));
        imageView.getLayoutParams().width = (int) (((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 24)) * d.dm(getContext()));
        imageView.setTranslationY(((-dl) * 0.5f) / 2.0f);
        imageView.setTranslationX((dl * 0.5f) / 2.0f);
        view2.setTranslationX(fromDPToPix);
        view2.setTranslationY(fromDPToPix2);
        ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", Float.valueOf(getOffsetX()), Float.valueOf(fromDPToPix), Float.valueOf(fromDPToPix2));
        AppMethodBeat.o(133767);
        return view2;
    }

    private float getOffsetX() {
        AppMethodBeat.i(133768);
        float screenWidth = ((float) this.paddingLeft) - (((float) (d.getScreenWidth(getContext()) / 2)) - (((float) d.di(getContext())) / 2.0f));
        AppMethodBeat.o(133768);
        return screenWidth;
    }

    private float getOffsetY() {
        AppMethodBeat.i(133769);
        float f = -(((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 32)) + (((d.dl(getContext()) * 1.5f) - d.dl(getContext())) / 2.0f));
        AppMethodBeat.o(133769);
        return f;
    }

    static /* synthetic */ void a(AppBrandDesktopDragView appBrandDesktopDragView, v vVar, View view, Object obj, int i) {
        AppMethodBeat.i(133772);
        if (view != null) {
            boolean z;
            boolean z2;
            if (appBrandDesktopDragView.iWH) {
                z = false;
            } else {
                z = true;
            }
            if (vVar == null) {
                z = false;
            }
            if (vVar != null && (vVar.apJ instanceof RecentAppBrandViewContainer)) {
                z = false;
            }
            if (i == 2) {
                z2 = true;
            } else {
                z2 = z;
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.b9u);
            if (imageView != null) {
                if (z2 && vVar != null && (vVar.apN == 1 || vVar.apN == 7)) {
                    int bH = appBrandDesktopDragView.bH(obj);
                    if (bH == 0) {
                        view.findViewById(R.id.cov).setVisibility(4);
                        imageView.setImageResource(R.raw.app_brand_desktop_add_icon);
                        appBrandDesktopDragView.m(imageView, true);
                        AppMethodBeat.o(133772);
                        return;
                    } else if (bH == 1) {
                        imageView.setVisibility(4);
                        view.findViewById(R.id.cov).setVisibility(0);
                        ((TextView) view.findViewById(R.id.cow)).setText(R.string.gh);
                        AppMethodBeat.o(133772);
                        return;
                    } else if (bH == 2) {
                        imageView.setVisibility(4);
                        view.findViewById(R.id.cov).setVisibility(0);
                        ((TextView) view.findViewById(R.id.cow)).setText(String.format(appBrandDesktopDragView.getContext().getResources().getString(R.string.ht), new Object[]{Integer.valueOf(b.axI())}));
                        AppMethodBeat.o(133772);
                        return;
                    } else {
                        imageView.setVisibility(4);
                        view.findViewById(R.id.cov).setVisibility(4);
                        AppMethodBeat.o(133772);
                        return;
                    }
                }
                view.findViewById(R.id.cov).setVisibility(4);
                appBrandDesktopDragView.m(imageView, false);
            }
        }
        AppMethodBeat.o(133772);
    }
}
