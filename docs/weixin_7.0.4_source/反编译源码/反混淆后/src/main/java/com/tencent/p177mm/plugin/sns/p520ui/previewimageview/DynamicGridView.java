package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView */
public class DynamicGridView extends WrappingGridView {
    private List<Long> idList = new ArrayList();
    boolean lBk = false;
    private int mActivePointerId = -1;
    private int mScrollState = 0;
    private boolean rLA = true;
    private OnScrollListener rLB;
    private C13701f rLC;
    private C22137e rLD;
    private C29234g rLE;
    private OnItemClickListener rLF;
    private OnItemClickListener rLG = new C137001();
    private boolean rLH;
    private Stack<C43603a> rLI;
    private C43603a rLJ;
    private C43606h rLK;
    private View rLL;
    C29233d rLM = new C29233d(this, (byte) 0);
    int rLN = -1;
    float rLO;
    float rLP;
    private float rLQ;
    private float rLR;
    private OnScrollListener rLS = new C221322();
    private BitmapDrawable rLg;
    private Rect rLh;
    private Rect rLi;
    private Rect rLj;
    private int rLk = 0;
    private int rLl = 0;
    private int rLm = -1;
    private int rLn = -1;
    private int rLo = -1;
    private int rLp = -1;
    private int rLq;
    private long rLr = -1;
    private boolean rLs = false;
    private boolean rLt;
    private int rLu = 0;
    private boolean rLv = false;
    private List<ObjectAnimator> rLw = new LinkedList();
    boolean rLx;
    boolean rLy;
    boolean rLz = true;

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$1 */
    class C137001 implements OnItemClickListener {
        C137001() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(40343);
            if (!(DynamicGridView.this.lBk || !DynamicGridView.this.isEnabled() || DynamicGridView.this.rLF == null)) {
                DynamicGridView.this.rLF.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(40343);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$f */
    public interface C13701f {
        void cvd();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$2 */
    class C221322 implements OnScrollListener {
        private int eiY;
        private int rLU = -1;
        private int rLV = -1;
        private int rLW;
        private int rLX;

        C221322() {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int i4;
            AppMethodBeat.m2504i(40344);
            this.rLW = i;
            this.rLX = i2;
            this.rLU = this.rLU == -1 ? this.rLW : this.rLU;
            if (this.rLV == -1) {
                i4 = this.rLX;
            } else {
                i4 = this.rLV;
            }
            this.rLV = i4;
            if (!(this.rLW == this.rLU || !DynamicGridView.this.rLs || DynamicGridView.this.rLr == -1)) {
                DynamicGridView.m78002a(DynamicGridView.this, DynamicGridView.this.rLr);
                DynamicGridView.m78036p(DynamicGridView.this);
            }
            if (!(this.rLW + this.rLX == this.rLU + this.rLV || !DynamicGridView.this.rLs || DynamicGridView.this.rLr == -1)) {
                DynamicGridView.m78002a(DynamicGridView.this, DynamicGridView.this.rLr);
                DynamicGridView.m78036p(DynamicGridView.this);
            }
            this.rLU = this.rLW;
            this.rLV = this.rLX;
            if (DynamicGridView.cvn() && DynamicGridView.this.rLz) {
                for (i4 = 0; i4 < i2; i4++) {
                    View childAt = DynamicGridView.this.getChildAt(i4);
                    if (childAt != null) {
                        if (DynamicGridView.this.rLr != -1 && Boolean.TRUE != childAt.getTag(2131820591)) {
                            if (i4 % 2 == 0) {
                                DynamicGridView.m78011c(DynamicGridView.this, childAt);
                            } else {
                                DynamicGridView.m78013d(DynamicGridView.this, childAt);
                            }
                            childAt.setTag(2131820591, Boolean.TRUE);
                        } else if (DynamicGridView.this.rLr == -1 && childAt.getRotation() != 0.0f) {
                            childAt.setRotation(0.0f);
                            childAt.setTag(2131820591, Boolean.FALSE);
                        }
                    }
                }
            }
            if (DynamicGridView.this.rLB != null) {
                DynamicGridView.this.rLB.onScroll(absListView, i, i2, i3);
            }
            AppMethodBeat.m2505o(40344);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(40345);
            this.eiY = i;
            DynamicGridView.this.mScrollState = i;
            if (this.rLX > 0 && this.eiY == 0) {
                if (DynamicGridView.this.rLs && DynamicGridView.this.rLt) {
                    DynamicGridView.m78032m(DynamicGridView.this);
                } else if (DynamicGridView.this.rLv) {
                    DynamicGridView.m78035o(DynamicGridView.this);
                }
            }
            if (DynamicGridView.this.rLB != null) {
                DynamicGridView.this.rLB.onScrollStateChanged(absListView, i);
            }
            AppMethodBeat.m2505o(40345);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$e */
    public interface C22137e {
        /* renamed from: Ev */
        void mo8958Ev(int i);

        /* renamed from: Ew */
        void mo8959Ew(int i);

        void cvc();

        /* renamed from: l */
        void mo8961l(Rect rect);

        /* renamed from: m */
        boolean mo8962m(Rect rect);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$10 */
    class C2923210 extends AnimatorListenerAdapter {
        C2923210() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40355);
            DynamicGridView.this.rLy = true;
            DynamicGridView.m78007b(DynamicGridView.this);
            AppMethodBeat.m2505o(40355);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40356);
            DynamicGridView.this.rLy = false;
            DynamicGridView.m78007b(DynamicGridView.this);
            AppMethodBeat.m2505o(40356);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$d */
    class C29233d extends Handler {
        private C29233d() {
        }

        /* synthetic */ C29233d(DynamicGridView dynamicGridView, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(40365);
            switch (message.what) {
                case 1:
                    DynamicGridView dynamicGridView = DynamicGridView.this;
                    View childAt = dynamicGridView.getChildAt(dynamicGridView.rLN);
                    new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.rLN).append(",lastTouchX ").append(dynamicGridView.rLO).append(",lastTouchY ").append(dynamicGridView.rLP);
                    if (!(dynamicGridView.rLx || dynamicGridView.rLy || !C22138f.m33757d(childAt, dynamicGridView.rLO, dynamicGridView.rLP))) {
                        dynamicGridView.mo69212Ex(dynamicGridView.rLN);
                        break;
                    }
            }
            AppMethodBeat.m2505o(40365);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$g */
    public interface C29234g {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$j */
    interface C39849j {
        /* renamed from: fE */
        void mo63041fE(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$4 */
    class C435994 implements TypeEvaluator<Rect> {
        C435994() {
        }

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            AppMethodBeat.m2504i(40347);
            Rect rect = (Rect) obj;
            Rect rect2 = (Rect) obj2;
            Rect rect3 = new Rect(C435994.m77991e(rect.left, rect2.left, f), C435994.m77991e(rect.top, rect2.top, f), C435994.m77991e(rect.right, rect2.right, f), C435994.m77991e(rect.bottom, rect2.bottom, f));
            AppMethodBeat.m2505o(40347);
            return rect3;
        }

        /* renamed from: e */
        private static int m77991e(int i, int i2, float f) {
            return (int) (((float) i) + (((float) (i2 - i)) * f));
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$5 */
    class C436005 implements AnimatorUpdateListener {
        C436005() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40348);
            DynamicGridView.this.invalidate();
            AppMethodBeat.m2505o(40348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$6 */
    class C436016 extends AnimatorListenerAdapter {
        C436016() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40349);
            DynamicGridView.this.rLx = true;
            DynamicGridView.m78007b(DynamicGridView.this);
            AppMethodBeat.m2505o(40349);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40350);
            DynamicGridView.this.rLx = false;
            DynamicGridView.m78007b(DynamicGridView.this);
            AppMethodBeat.m2505o(40350);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$8 */
    class C436028 implements AnimatorUpdateListener {
        C436028() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40352);
            DynamicGridView.this.invalidate();
            AppMethodBeat.m2505o(40352);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$a */
    static class C43603a {
        List<Pair<Integer, Integer>> rLZ = new Stack();

        C43603a() {
            AppMethodBeat.m2504i(40357);
            AppMethodBeat.m2505o(40357);
        }

        /* renamed from: fD */
        public final void mo69211fD(int i, int i2) {
            AppMethodBeat.m2504i(40358);
            this.rLZ.add(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
            AppMethodBeat.m2505o(40358);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$b */
    class C43604b implements C39849j {
        static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
        /* renamed from: yH */
        private int f17214yH;
        /* renamed from: yI */
        private int f17215yI;

        /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$b$a */
        class C22135a implements OnPreDrawListener {
            private final int ape;
            private final View rMa;
            private final int rMb;

            C22135a(View view, int i, int i2) {
                this.rMa = view;
                this.rMb = i;
                this.ape = i2;
            }

            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(40359);
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.rLk = DynamicGridView.this.rLk + C43604b.this.f17215yI;
                DynamicGridView.this.rLl = DynamicGridView.this.rLl + C43604b.this.f17214yH;
                DynamicGridView.m78001a(DynamicGridView.this, this.rMb, this.ape);
                this.rMa.setVisibility(0);
                if (DynamicGridView.this.rLL != null) {
                    DynamicGridView.this.rLL.setVisibility(4);
                }
                AppMethodBeat.m2505o(40359);
                return true;
            }
        }

        static {
            AppMethodBeat.m2504i(40361);
            AppMethodBeat.m2505o(40361);
        }

        public C43604b(int i, int i2) {
            this.f17214yH = i;
            this.f17215yI = i2;
        }

        /* renamed from: fE */
        public final void mo63041fE(int i, int i2) {
            AppMethodBeat.m2504i(40360);
            if ($assertionsDisabled || DynamicGridView.this.rLL != null) {
                DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new C22135a(DynamicGridView.this.rLL, i, i2));
                DynamicGridView.this.rLL = DynamicGridView.this.mo69215kP(DynamicGridView.this.rLr);
                AppMethodBeat.m2505o(40360);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(40360);
            throw assertionError;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$c */
    class C43605c implements C39849j {
        /* renamed from: yH */
        int f17216yH;
        /* renamed from: yI */
        int f17217yI;

        /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$c$a */
        class C22136a implements OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int ape;
            private final int rMb;

            static {
                AppMethodBeat.m2504i(40363);
                AppMethodBeat.m2505o(40363);
            }

            C22136a(int i, int i2) {
                this.rMb = i;
                this.ape = i2;
            }

            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(40362);
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.rLk = DynamicGridView.this.rLk + C43605c.this.f17217yI;
                DynamicGridView.this.rLl = DynamicGridView.this.rLl + C43605c.this.f17216yH;
                DynamicGridView.m78001a(DynamicGridView.this, this.rMb, this.ape);
                new StringBuilder("id ").append(DynamicGridView.this.mo69214kO(DynamicGridView.this.rLr));
                AssertionError assertionError;
                if (DynamicGridView.this.rLL == null) {
                    AppMethodBeat.m2505o(40362);
                } else if (DynamicGridView.this.rLL == null) {
                    AppMethodBeat.m2505o(40362);
                } else if ($assertionsDisabled || DynamicGridView.this.rLL != null) {
                    DynamicGridView.this.rLL.setVisibility(0);
                    DynamicGridView.this.rLL = DynamicGridView.this.mo69215kP(DynamicGridView.this.rLr);
                    if (DynamicGridView.this.rLL == null) {
                        AppMethodBeat.m2505o(40362);
                    } else if ($assertionsDisabled || DynamicGridView.this.rLL != null) {
                        DynamicGridView.this.rLL.setVisibility(4);
                        AppMethodBeat.m2505o(40362);
                    } else {
                        assertionError = new AssertionError();
                        AppMethodBeat.m2505o(40362);
                        throw assertionError;
                    }
                } else {
                    assertionError = new AssertionError();
                    AppMethodBeat.m2505o(40362);
                    throw assertionError;
                }
                return true;
            }
        }

        public C43605c(int i, int i2) {
            this.f17216yH = i;
            this.f17217yI = i2;
        }

        /* renamed from: fE */
        public final void mo63041fE(int i, int i2) {
            AppMethodBeat.m2504i(40364);
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new C22136a(i, i2));
            AppMethodBeat.m2505o(40364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$h */
    public interface C43606h {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$7 */
    class C436077 implements TypeEvaluator<Rect> {
        C436077() {
        }

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            AppMethodBeat.m2504i(40351);
            Rect rect = (Rect) obj;
            Rect rect2 = (Rect) obj2;
            Rect rect3 = new Rect(C436077.m78041e(rect.left, rect2.left, f), C436077.m78041e(rect.top, rect2.top, f), C436077.m78041e(rect.right, rect2.right, f), C436077.m78041e(rect.bottom, rect2.bottom, f));
            AppMethodBeat.m2505o(40351);
            return rect3;
        }

        /* renamed from: e */
        private static int m78041e(int i, int i2, float f) {
            return (int) (((float) i) + (((float) (i2 - i)) * f));
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$i */
    class C43608i implements C39849j {
        /* renamed from: yH */
        private int f17218yH;
        /* renamed from: yI */
        private int f17219yI;

        public C43608i(int i, int i2) {
            this.f17218yH = i;
            this.f17219yI = i2;
        }

        /* renamed from: fE */
        public final void mo63041fE(int i, int i2) {
            AppMethodBeat.m2504i(40366);
            DynamicGridView.this.rLk = DynamicGridView.this.rLk + this.f17219yI;
            DynamicGridView.this.rLl = DynamicGridView.this.rLl + this.f17218yH;
            AppMethodBeat.m2505o(40366);
        }
    }

    static /* synthetic */ boolean cvn() {
        AppMethodBeat.m2504i(40406);
        boolean cvj = DynamicGridView.cvj();
        AppMethodBeat.m2505o(40406);
        return cvj;
    }

    /* renamed from: d */
    static /* synthetic */ void m78013d(DynamicGridView dynamicGridView, View view) {
        AppMethodBeat.m2504i(40408);
        dynamicGridView.m78015dV(view);
        AppMethodBeat.m2505o(40408);
    }

    /* renamed from: m */
    static /* synthetic */ void m78032m(DynamicGridView dynamicGridView) {
        AppMethodBeat.m2504i(40409);
        dynamicGridView.cvg();
        AppMethodBeat.m2505o(40409);
    }

    /* renamed from: o */
    static /* synthetic */ void m78035o(DynamicGridView dynamicGridView) {
        AppMethodBeat.m2504i(40410);
        dynamicGridView.cvh();
        AppMethodBeat.m2505o(40410);
    }

    /* renamed from: p */
    static /* synthetic */ void m78036p(DynamicGridView dynamicGridView) {
        AppMethodBeat.m2504i(40412);
        dynamicGridView.cvm();
        AppMethodBeat.m2505o(40412);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40367);
        init(context);
        AppMethodBeat.m2505o(40367);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40368);
        init(context);
        AppMethodBeat.m2505o(40368);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rLB = onScrollListener;
    }

    public void setOnDropListener(C13701f c13701f) {
        this.rLC = c13701f;
    }

    public void setOnDragListener(C22137e c22137e) {
        this.rLD = c22137e;
    }

    /* renamed from: Ex */
    public final void mo69212Ex(int i) {
        AppMethodBeat.m2504i(40369);
        if (this.rLA) {
            requestDisallowInterceptTouchEvent(true);
            if (DynamicGridView.cvj() && this.rLz) {
                cve();
            }
            if (i != -1) {
                this.lBk = m77997Ey(i);
                if (this.lBk) {
                    this.rLs = true;
                }
            }
            AppMethodBeat.m2505o(40369);
            return;
        }
        AppMethodBeat.m2505o(40369);
    }

    public void setEditModeEnabled(boolean z) {
        this.rLA = z;
    }

    public void setOnEditModeChangeListener(C29234g c29234g) {
        this.rLE = c29234g;
    }

    public void setWobbleInEditMode(boolean z) {
        this.rLz = z;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.m2504i(40370);
        this.rLF = onItemClickListener;
        super.setOnItemClickListener(this.rLG);
        AppMethodBeat.m2505o(40370);
    }

    public void setUndoSupportEnabled(boolean z) {
        AppMethodBeat.m2504i(40371);
        if (this.rLH != z) {
            if (z) {
                this.rLI = new Stack();
            } else {
                this.rLI = null;
            }
        }
        this.rLH = z;
        AppMethodBeat.m2505o(40371);
    }

    public void setOnSelectedItemBitmapCreationListener(C43606h c43606h) {
        this.rLK = c43606h;
    }

    @TargetApi(11)
    private void cve() {
        AppMethodBeat.m2504i(40372);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(2131820591))) {
                if (i % 2 == 0) {
                    m78014dU(childAt);
                } else {
                    m78015dV(childAt);
                }
                childAt.setTag(2131820591, Boolean.TRUE);
            }
        }
        AppMethodBeat.m2505o(40372);
    }

    /* Access modifiers changed, original: final */
    @TargetApi(11)
    /* renamed from: lo */
    public final void mo69216lo(boolean z) {
        AppMethodBeat.m2504i(40373);
        for (Animator cancel : this.rLw) {
            cancel.cancel();
        }
        this.rLw.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                if (z) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(2131820591, Boolean.FALSE);
            }
        }
        AppMethodBeat.m2505o(40373);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(40374);
        super.setOnScrollListener(this.rLS);
        this.rLu = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.rLq = getResources().getDimensionPixelSize(C25738R.dimen.f10368za);
        AppMethodBeat.m2505o(40374);
    }

    @TargetApi(11)
    /* renamed from: dU */
    private void m78014dU(View view) {
        AppMethodBeat.m2504i(40375);
        ObjectAnimator dW = m78016dW(view);
        dW.setFloatValues(new float[]{-2.0f, 2.0f});
        dW.start();
        this.rLw.add(dW);
        AppMethodBeat.m2505o(40375);
    }

    @TargetApi(11)
    /* renamed from: dV */
    private void m78015dV(View view) {
        AppMethodBeat.m2504i(40376);
        ObjectAnimator dW = m78016dW(view);
        dW.setFloatValues(new float[]{2.0f, -2.0f});
        dW.start();
        this.rLw.add(dW);
        AppMethodBeat.m2505o(40376);
    }

    @TargetApi(11)
    /* renamed from: dW */
    private ObjectAnimator m78016dW(final View view) {
        AppMethodBeat.m2504i(40377);
        if (!DynamicGridView.cvk()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40346);
                view.setLayerType(0, null);
                AppMethodBeat.m2505o(40346);
            }
        });
        AppMethodBeat.m2505o(40377);
        return objectAnimator;
    }

    /* renamed from: fC */
    private void m78024fC(int i, int i2) {
        AppMethodBeat.m2504i(40378);
        getAdapterInterface().mo25900fB(i, i2);
        AppMethodBeat.m2505o(40378);
    }

    private int getColumnCount() {
        AppMethodBeat.m2504i(40379);
        int columnCount = getAdapterInterface().getColumnCount();
        AppMethodBeat.m2505o(40379);
        return columnCount;
    }

    private C13706d getAdapterInterface() {
        AppMethodBeat.m2504i(40380);
        C13706d c13706d = (C13706d) getAdapter();
        AppMethodBeat.m2505o(40380);
        return c13706d;
    }

    /* renamed from: dX */
    private BitmapDrawable m78017dX(View view) {
        AppMethodBeat.m2504i(40381);
        int width = view.getWidth();
        int height = view.getHeight();
        int top = view.getTop();
        int left = view.getLeft();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
        this.rLi = new Rect(left, top, left + width, top + height);
        this.rLh = new Rect(this.rLi.left - ((int) (((float) width) * 0.05f)), this.rLi.top - ((int) (((float) height) * 0.05f)), ((int) (((float) width) * 0.05f)) + this.rLi.right, ((int) (((float) height) * 0.05f)) + this.rLi.bottom);
        this.rLj = new Rect(this.rLh);
        bitmapDrawable.setBounds(this.rLi);
        AppMethodBeat.m2505o(40381);
        return bitmapDrawable;
    }

    /* renamed from: kN */
    private void m78030kN(long j) {
        AppMethodBeat.m2504i(40382);
        this.idList.clear();
        int kO = mo69214kO(j);
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (kO != firstVisiblePosition && getAdapterInterface().mo25895Et(firstVisiblePosition)) {
                this.idList.add(Long.valueOf(m77998Ez(firstVisiblePosition)));
            }
            firstVisiblePosition++;
        }
        AppMethodBeat.m2505o(40382);
    }

    /* renamed from: kO */
    public final int mo69214kO(long j) {
        AppMethodBeat.m2504i(40383);
        View kP = mo69215kP(j);
        if (kP == null) {
            AppMethodBeat.m2505o(40383);
            return -1;
        }
        int positionForView = getPositionForView(kP);
        AppMethodBeat.m2505o(40383);
        return positionForView;
    }

    /* renamed from: kP */
    public final View mo69215kP(long j) {
        AppMethodBeat.m2504i(40384);
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                AppMethodBeat.m2505o(40384);
                return childAt;
            }
        }
        AppMethodBeat.m2505o(40384);
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(40385);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        AppMethodBeat.m2505o(40385);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(40386);
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.rLO = motionEvent.getX();
                this.rLP = motionEvent.getY();
                this.rLN = C22138f.m33756a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.rLN);
                if (!this.rLx && this.rLN >= 0) {
                    C29233d c29233d = this.rLM;
                    c29233d.removeMessages(1);
                    c29233d.sendEmptyMessageDelayed(1, 300);
                }
                this.rLo = -1;
                this.rLp = -1;
                this.rLm = (int) motionEvent.getX();
                this.rLn = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.lBk && isEnabled()) {
                    layoutChildren();
                    m77997Ey(pointToPosition(this.rLm, this.rLn));
                    break;
                } else if (!isEnabled()) {
                    AppMethodBeat.m2505o(40386);
                    return false;
                }
                break;
            case 1:
                cvh();
                if (this.rLH && this.rLJ != null) {
                    C43603a c43603a = this.rLJ;
                    Collections.reverse(c43603a.rLZ);
                    if (!c43603a.rLZ.isEmpty()) {
                        this.rLI.push(this.rLJ);
                        this.rLJ = new C43603a();
                        break;
                    }
                }
                break;
            case 2:
                this.rLO = motionEvent.getX();
                this.rLP = motionEvent.getY();
                if (!(!this.rLs || this.mActivePointerId == -1 || findPointerIndex == -1)) {
                    if (this.rLp == -1 && this.rLo == -1) {
                        this.rLo = (int) motionEvent.getY(findPointerIndex);
                        this.rLp = (int) motionEvent.getX(findPointerIndex);
                        this.rLm = this.rLp;
                        this.rLn = this.rLo;
                        break;
                    }
                    this.rLQ = motionEvent.getRawX();
                    this.rLR = motionEvent.getRawY();
                    this.rLo = (int) motionEvent.getY(findPointerIndex);
                    this.rLp = (int) motionEvent.getX(findPointerIndex);
                    int i = this.rLp - this.rLm;
                    this.rLh.offsetTo((i + this.rLj.left) + this.rLl, ((this.rLo - this.rLn) + this.rLj.top) + this.rLk);
                    if (this.rLg != null) {
                        this.rLg.setBounds(this.rLh);
                    }
                    invalidate();
                    cvm();
                    this.rLt = false;
                    cvg();
                    if (this.rLD != null) {
                        Rect rect = new Rect(this.rLh);
                        rect.offset(0, this.rLh.height() >>> 1);
                        this.rLD.mo8961l(rect);
                    }
                    AppMethodBeat.m2505o(40386);
                    return false;
                }
                break;
            case 3:
                cvl();
                cvh();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.mActivePointerId) {
                    cvh();
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(40386);
        return onTouchEvent;
    }

    private boolean cvf() {
        AppMethodBeat.m2504i(40387);
        int kO = mo69214kO(this.rLr);
        if (kO != -1) {
            this.rLD.mo8959Ew(kO);
            if (this.rLL == null) {
                AppMethodBeat.m2505o(40387);
                return false;
            }
            int positionForView = getPositionForView(this.rLL);
            int childCount = getChildCount() - 1;
            new StringBuilder("switch ").append(positionForView).append(",").append(childCount);
            if (positionForView == -1) {
                AppMethodBeat.m2505o(40387);
                return false;
            }
            C39849j c43604b;
            m78024fC(positionForView, childCount);
            if (this.rLH) {
                this.rLJ.mo69211fD(positionForView, childCount);
            }
            this.rLn = this.rLo;
            this.rLm = this.rLp;
            if (DynamicGridView.cvj() && DynamicGridView.cvk()) {
                c43604b = new C43604b(0, 0);
            } else if (DynamicGridView.cvk()) {
                c43604b = new C43608i(0, 0);
            } else {
                c43604b = new C43605c(0, 0);
            }
            m78030kN(this.rLr);
            c43604b.mo63041fE(positionForView, childCount);
            AppMethodBeat.m2505o(40387);
            return true;
        }
        AppMethodBeat.m2505o(40387);
        return false;
    }

    /* renamed from: Ey */
    private boolean m77997Ey(int i) {
        AppMethodBeat.m2504i(40388);
        if (getAdapterInterface().mo25894Es(i)) {
            this.rLk = 0;
            this.rLl = 0;
            View childAt = getChildAt(i - getFirstVisiblePosition());
            if (childAt != null) {
                this.rLr = getAdapter().getItemId(i);
                this.rLg = m78017dX(childAt);
                cvi();
                if (DynamicGridView.cvj()) {
                    childAt.setVisibility(4);
                }
                m78030kN(this.rLr);
                if (this.rLD != null) {
                    this.rLD.mo8958Ev(i);
                }
                AppMethodBeat.m2505o(40388);
                return true;
            }
            AppMethodBeat.m2505o(40388);
            return false;
        }
        AppMethodBeat.m2505o(40388);
        return false;
    }

    private void cvg() {
        AppMethodBeat.m2504i(40389);
        this.rLt = m78033n(this.rLh);
        AppMethodBeat.m2505o(40389);
    }

    /* renamed from: n */
    private boolean m78033n(Rect rect) {
        AppMethodBeat.m2504i(40390);
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.rLu, 0);
            AppMethodBeat.m2505o(40390);
            return true;
        } else if (i + height2 < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            AppMethodBeat.m2505o(40390);
            return false;
        } else {
            smoothScrollBy(this.rLu, 0);
            AppMethodBeat.m2505o(40390);
            return true;
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(40391);
        super.setAdapter(listAdapter);
        AppMethodBeat.m2505o(40391);
    }

    private void cvh() {
        AppMethodBeat.m2504i(40392);
        this.rLM.removeMessages(1);
        View kP = mo69215kP(this.rLr);
        Rect rect;
        if (this.rLh != null) {
            rect = new Rect(this.rLh);
            rect.offset(0, this.rLh.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.rLD != null && this.rLD.mo8962m(rect) && cvf()) {
            this.rLg = null;
            cvl();
            if (this.rLC != null) {
                this.rLC.cvd();
            }
        } else if (kP == null || !(this.rLs || this.rLv)) {
            cvl();
        } else {
            this.rLs = false;
            this.rLv = false;
            this.rLt = false;
            this.mActivePointerId = -1;
            this.rLh.set(kP.getLeft(), kP.getTop(), kP.getRight(), kP.getBottom());
            new StringBuilder("animating to  ").append(this.rLh);
            if (VERSION.SDK_INT > 11) {
                m78018dY(kP);
            } else {
                this.rLg.setBounds(this.rLh);
                invalidate();
                m78019dZ(kP);
            }
        }
        if (this.rLD != null) {
            this.rLD.cvc();
        }
        AppMethodBeat.m2505o(40392);
    }

    @TargetApi(11)
    private void cvi() {
        AppMethodBeat.m2504i(40393);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rLg, "bounds", new C435994(), new Object[]{this.rLh});
        ofObject.addUpdateListener(new C436005());
        ofObject.addListener(new C436016());
        ofObject.setDuration(10);
        ofObject.start();
        AppMethodBeat.m2505o(40393);
    }

    @TargetApi(11)
    /* renamed from: dY */
    private void m78018dY(final View view) {
        AppMethodBeat.m2504i(40394);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rLg, "bounds", new C436077(), new Object[]{this.rLh});
        ofObject.addUpdateListener(new C436028());
        ofObject.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40353);
                DynamicGridView.this.rLx = true;
                DynamicGridView.m78007b(DynamicGridView.this);
                AppMethodBeat.m2505o(40353);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40354);
                DynamicGridView.this.rLx = false;
                DynamicGridView.m78007b(DynamicGridView.this);
                if (!(DynamicGridView.this.rLg == null || DynamicGridView.this.rLC == null)) {
                    DynamicGridView.this.rLC.cvd();
                }
                DynamicGridView.m78003a(DynamicGridView.this, view);
                AppMethodBeat.m2505o(40354);
            }
        });
        ofObject.setDuration(200);
        ofObject.start();
        AppMethodBeat.m2505o(40394);
    }

    /* renamed from: dZ */
    private void m78019dZ(View view) {
        AppMethodBeat.m2504i(40395);
        this.idList.clear();
        this.rLr = -1;
        view.setVisibility(0);
        this.rLg = null;
        if (DynamicGridView.cvj() && this.rLz) {
            if (this.lBk) {
                mo69216lo(false);
                cve();
            } else {
                mo69216lo(true);
            }
        }
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
        AppMethodBeat.m2505o(40395);
    }

    static boolean cvj() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean cvk() {
        return VERSION.SDK_INT < 21;
    }

    private void cvl() {
        AppMethodBeat.m2504i(40396);
        View kP = mo69215kP(this.rLr);
        if (kP == null) {
            AppMethodBeat.m2505o(40396);
            return;
        }
        if (this.rLs) {
            m78019dZ(kP);
        }
        this.rLs = false;
        this.rLt = false;
        this.mActivePointerId = -1;
        AppMethodBeat.m2505o(40396);
    }

    /* JADX WARNING: Missing block: B:79:0x012e, code skipped:
            if (r9 < (r5.getRight() - r14.rLq)) goto L_0x0130;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cvm() {
        AppMethodBeat.m2504i(40397);
        int i = this.rLo - this.rLn;
        int i2 = this.rLp - this.rLm;
        int centerY = (this.rLi.centerY() + this.rLk) + i;
        int centerX = (this.rLi.centerX() + this.rLl) + i2;
        this.rLL = mo69215kP(this.rLr);
        if (this.rLL == null) {
            AppMethodBeat.m2505o(40397);
            return;
        }
        View view = null;
        float f = 0.0f;
        float f2 = 0.0f;
        Point ea = m78022ea(this.rLL);
        for (Long longValue : this.idList) {
            float abs;
            View kP = mo69215kP(longValue.longValue());
            if (kP != null) {
                Object obj;
                Point ea2 = m78022ea(kP);
                if (ea2.y >= ea.y || ea2.x <= ea.x) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null || centerY >= kP.getBottom() || centerX <= kP.getLeft()) {
                    if (ea2.y >= ea.y || ea2.x >= ea.x) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null || centerY >= kP.getBottom() || centerX >= kP.getRight()) {
                        if (ea2.y <= ea.y || ea2.x <= ea.x) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null || centerY <= kP.getTop() || centerX <= kP.getLeft()) {
                            if (ea2.y <= ea.y || ea2.x >= ea.x) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj == null || centerY <= kP.getTop() || centerX >= kP.getRight()) {
                                if (ea2.y >= ea.y || ea2.x != ea.x) {
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                                if (obj == null || centerY >= kP.getBottom() - this.rLq) {
                                    if (ea2.y <= ea.y || ea2.x != ea.x) {
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                    if (obj == null || centerY <= kP.getTop() + this.rLq) {
                                        if (ea2.y != ea.y || ea2.x <= ea.x) {
                                            obj = null;
                                        } else {
                                            obj = 1;
                                        }
                                        if (obj == null || centerX <= kP.getLeft() + this.rLq) {
                                            if (ea2.y != ea.y || ea2.x >= ea.x) {
                                                obj = null;
                                            } else {
                                                obj = 1;
                                            }
                                            if (obj != null) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                float abs2 = Math.abs(C22138f.m33758dS(kP) - C22138f.m33758dS(this.rLL));
                abs = Math.abs(C22138f.m33759dT(kP) - C22138f.m33759dT(this.rLL));
                if (abs2 >= f && abs >= f2) {
                    f = abs2;
                    view = kP;
                    f2 = abs;
                }
            }
            abs = f2;
            f2 = abs;
        }
        if (view != null) {
            int positionForView = getPositionForView(this.rLL);
            int positionForView2 = getPositionForView(view);
            new StringBuilder("switch ").append(positionForView).append(",").append(positionForView2);
            C13706d adapterInterface = getAdapterInterface();
            if (positionForView2 != -1 && adapterInterface.mo25895Et(positionForView) && adapterInterface.mo25895Et(positionForView2)) {
                C39849j c43604b;
                m78024fC(positionForView, positionForView2);
                if (this.rLH) {
                    this.rLJ.mo69211fD(positionForView, positionForView2);
                }
                this.rLn = this.rLo;
                this.rLm = this.rLp;
                if (DynamicGridView.cvj() && DynamicGridView.cvk()) {
                    c43604b = new C43604b(i2, i);
                } else if (DynamicGridView.cvk()) {
                    c43604b = new C43608i(i2, i);
                } else {
                    c43604b = new C43605c(i2, i);
                }
                m78030kN(this.rLr);
                c43604b.mo63041fE(positionForView, positionForView2);
            } else {
                m78030kN(this.rLr);
                AppMethodBeat.m2505o(40397);
                return;
            }
        }
        AppMethodBeat.m2505o(40397);
    }

    /* renamed from: ea */
    private Point m78022ea(View view) {
        AppMethodBeat.m2504i(40398);
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        Point point = new Point(positionForView % columnCount, positionForView / columnCount);
        AppMethodBeat.m2505o(40398);
        return point;
    }

    /* renamed from: Ez */
    private long m77998Ez(int i) {
        AppMethodBeat.m2504i(40399);
        long itemId = getAdapter().getItemId(i);
        AppMethodBeat.m2505o(40399);
        return itemId;
    }

    @TargetApi(11)
    /* renamed from: e */
    private static AnimatorSet m78021e(View view, float f, float f2) {
        AppMethodBeat.m2504i(40400);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        AppMethodBeat.m2505o(40400);
        return animatorSet;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(40401);
        super.dispatchDraw(canvas);
        if (this.rLg != null) {
            this.rLg.draw(canvas);
        }
        AppMethodBeat.m2505o(40401);
    }

    /* renamed from: b */
    static /* synthetic */ void m78007b(DynamicGridView dynamicGridView) {
        boolean z;
        AppMethodBeat.m2504i(40403);
        if (dynamicGridView.rLx || dynamicGridView.rLy) {
            z = false;
        } else {
            z = true;
        }
        dynamicGridView.setEnabled(z);
        AppMethodBeat.m2505o(40403);
    }

    /* renamed from: a */
    static /* synthetic */ void m78001a(DynamicGridView dynamicGridView, int i, int i2) {
        AppMethodBeat.m2504i(40405);
        Object obj = i2 > i ? 1 : null;
        LinkedList linkedList = new LinkedList();
        int min;
        View kP;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                kP = dynamicGridView.mo69215kP(dynamicGridView.m77998Ez(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(DynamicGridView.m78021e(kP, (float) ((-kP.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) kP.getHeight()));
                } else {
                    linkedList.add(DynamicGridView.m78021e(kP, (float) kP.getWidth(), 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                kP = dynamicGridView.mo69215kP(dynamicGridView.m77998Ez(min));
                if ((dynamicGridView.getColumnCount() + min) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(DynamicGridView.m78021e(kP, (float) (kP.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-kP.getHeight())));
                } else {
                    linkedList.add(DynamicGridView.m78021e(kP, (float) (-kP.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new C2923210());
        animatorSet.start();
        AppMethodBeat.m2505o(40405);
    }
}
