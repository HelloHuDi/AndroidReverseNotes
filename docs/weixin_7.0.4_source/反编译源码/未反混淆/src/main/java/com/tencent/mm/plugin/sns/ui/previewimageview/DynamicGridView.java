package com.tencent.mm.plugin.sns.ui.previewimageview;

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
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView extends WrappingGridView {
    private List<Long> idList = new ArrayList();
    boolean lBk = false;
    private int mActivePointerId = -1;
    private int mScrollState = 0;
    private boolean rLA = true;
    private OnScrollListener rLB;
    private f rLC;
    private e rLD;
    private g rLE;
    private OnItemClickListener rLF;
    private OnItemClickListener rLG = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(40343);
            if (!(DynamicGridView.this.lBk || !DynamicGridView.this.isEnabled() || DynamicGridView.this.rLF == null)) {
                DynamicGridView.this.rLF.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.o(40343);
        }
    };
    private boolean rLH;
    private Stack<a> rLI;
    private a rLJ;
    private h rLK;
    private View rLL;
    d rLM = new d(this, (byte) 0);
    int rLN = -1;
    float rLO;
    float rLP;
    private float rLQ;
    private float rLR;
    private OnScrollListener rLS = new OnScrollListener() {
        private int eiY;
        private int rLU = -1;
        private int rLV = -1;
        private int rLW;
        private int rLX;

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int i4;
            AppMethodBeat.i(40344);
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
                DynamicGridView.a(DynamicGridView.this, DynamicGridView.this.rLr);
                DynamicGridView.p(DynamicGridView.this);
            }
            if (!(this.rLW + this.rLX == this.rLU + this.rLV || !DynamicGridView.this.rLs || DynamicGridView.this.rLr == -1)) {
                DynamicGridView.a(DynamicGridView.this, DynamicGridView.this.rLr);
                DynamicGridView.p(DynamicGridView.this);
            }
            this.rLU = this.rLW;
            this.rLV = this.rLX;
            if (DynamicGridView.cvn() && DynamicGridView.this.rLz) {
                for (i4 = 0; i4 < i2; i4++) {
                    View childAt = DynamicGridView.this.getChildAt(i4);
                    if (childAt != null) {
                        if (DynamicGridView.this.rLr != -1 && Boolean.TRUE != childAt.getTag(R.id.ak)) {
                            if (i4 % 2 == 0) {
                                DynamicGridView.c(DynamicGridView.this, childAt);
                            } else {
                                DynamicGridView.d(DynamicGridView.this, childAt);
                            }
                            childAt.setTag(R.id.ak, Boolean.TRUE);
                        } else if (DynamicGridView.this.rLr == -1 && childAt.getRotation() != 0.0f) {
                            childAt.setRotation(0.0f);
                            childAt.setTag(R.id.ak, Boolean.FALSE);
                        }
                    }
                }
            }
            if (DynamicGridView.this.rLB != null) {
                DynamicGridView.this.rLB.onScroll(absListView, i, i2, i3);
            }
            AppMethodBeat.o(40344);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(40345);
            this.eiY = i;
            DynamicGridView.this.mScrollState = i;
            if (this.rLX > 0 && this.eiY == 0) {
                if (DynamicGridView.this.rLs && DynamicGridView.this.rLt) {
                    DynamicGridView.m(DynamicGridView.this);
                } else if (DynamicGridView.this.rLv) {
                    DynamicGridView.o(DynamicGridView.this);
                }
            }
            if (DynamicGridView.this.rLB != null) {
                DynamicGridView.this.rLB.onScrollStateChanged(absListView, i);
            }
            AppMethodBeat.o(40345);
        }
    };
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

    public interface f {
        void cvd();
    }

    public interface e {
        void Ev(int i);

        void Ew(int i);

        void cvc();

        void l(Rect rect);

        boolean m(Rect rect);
    }

    class d extends Handler {
        private d() {
        }

        /* synthetic */ d(DynamicGridView dynamicGridView, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(40365);
            switch (message.what) {
                case 1:
                    DynamicGridView dynamicGridView = DynamicGridView.this;
                    View childAt = dynamicGridView.getChildAt(dynamicGridView.rLN);
                    new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.rLN).append(",lastTouchX ").append(dynamicGridView.rLO).append(",lastTouchY ").append(dynamicGridView.rLP);
                    if (!(dynamicGridView.rLx || dynamicGridView.rLy || !f.d(childAt, dynamicGridView.rLO, dynamicGridView.rLP))) {
                        dynamicGridView.Ex(dynamicGridView.rLN);
                        break;
                    }
            }
            AppMethodBeat.o(40365);
        }
    }

    public interface g {
    }

    interface j {
        void fE(int i, int i2);
    }

    static class a {
        List<Pair<Integer, Integer>> rLZ = new Stack();

        a() {
            AppMethodBeat.i(40357);
            AppMethodBeat.o(40357);
        }

        public final void fD(int i, int i2) {
            AppMethodBeat.i(40358);
            this.rLZ.add(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
            AppMethodBeat.o(40358);
        }
    }

    class b implements j {
        static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
        private int yH;
        private int yI;

        class a implements OnPreDrawListener {
            private final int ape;
            private final View rMa;
            private final int rMb;

            a(View view, int i, int i2) {
                this.rMa = view;
                this.rMb = i;
                this.ape = i2;
            }

            public final boolean onPreDraw() {
                AppMethodBeat.i(40359);
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.rLk = DynamicGridView.this.rLk + b.this.yI;
                DynamicGridView.this.rLl = DynamicGridView.this.rLl + b.this.yH;
                DynamicGridView.a(DynamicGridView.this, this.rMb, this.ape);
                this.rMa.setVisibility(0);
                if (DynamicGridView.this.rLL != null) {
                    DynamicGridView.this.rLL.setVisibility(4);
                }
                AppMethodBeat.o(40359);
                return true;
            }
        }

        static {
            AppMethodBeat.i(40361);
            AppMethodBeat.o(40361);
        }

        public b(int i, int i2) {
            this.yH = i;
            this.yI = i2;
        }

        public final void fE(int i, int i2) {
            AppMethodBeat.i(40360);
            if ($assertionsDisabled || DynamicGridView.this.rLL != null) {
                DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.this.rLL, i, i2));
                DynamicGridView.this.rLL = DynamicGridView.this.kP(DynamicGridView.this.rLr);
                AppMethodBeat.o(40360);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(40360);
            throw assertionError;
        }
    }

    class c implements j {
        int yH;
        int yI;

        class a implements OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int ape;
            private final int rMb;

            static {
                AppMethodBeat.i(40363);
                AppMethodBeat.o(40363);
            }

            a(int i, int i2) {
                this.rMb = i;
                this.ape = i2;
            }

            public final boolean onPreDraw() {
                AppMethodBeat.i(40362);
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.rLk = DynamicGridView.this.rLk + c.this.yI;
                DynamicGridView.this.rLl = DynamicGridView.this.rLl + c.this.yH;
                DynamicGridView.a(DynamicGridView.this, this.rMb, this.ape);
                new StringBuilder("id ").append(DynamicGridView.this.kO(DynamicGridView.this.rLr));
                AssertionError assertionError;
                if (DynamicGridView.this.rLL == null) {
                    AppMethodBeat.o(40362);
                } else if (DynamicGridView.this.rLL == null) {
                    AppMethodBeat.o(40362);
                } else if ($assertionsDisabled || DynamicGridView.this.rLL != null) {
                    DynamicGridView.this.rLL.setVisibility(0);
                    DynamicGridView.this.rLL = DynamicGridView.this.kP(DynamicGridView.this.rLr);
                    if (DynamicGridView.this.rLL == null) {
                        AppMethodBeat.o(40362);
                    } else if ($assertionsDisabled || DynamicGridView.this.rLL != null) {
                        DynamicGridView.this.rLL.setVisibility(4);
                        AppMethodBeat.o(40362);
                    } else {
                        assertionError = new AssertionError();
                        AppMethodBeat.o(40362);
                        throw assertionError;
                    }
                } else {
                    assertionError = new AssertionError();
                    AppMethodBeat.o(40362);
                    throw assertionError;
                }
                return true;
            }
        }

        public c(int i, int i2) {
            this.yH = i;
            this.yI = i2;
        }

        public final void fE(int i, int i2) {
            AppMethodBeat.i(40364);
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(i, i2));
            AppMethodBeat.o(40364);
        }
    }

    public interface h {
    }

    class i implements j {
        private int yH;
        private int yI;

        public i(int i, int i2) {
            this.yH = i;
            this.yI = i2;
        }

        public final void fE(int i, int i2) {
            AppMethodBeat.i(40366);
            DynamicGridView.this.rLk = DynamicGridView.this.rLk + this.yI;
            DynamicGridView.this.rLl = DynamicGridView.this.rLl + this.yH;
            AppMethodBeat.o(40366);
        }
    }

    static /* synthetic */ boolean cvn() {
        AppMethodBeat.i(40406);
        boolean cvj = cvj();
        AppMethodBeat.o(40406);
        return cvj;
    }

    static /* synthetic */ void d(DynamicGridView dynamicGridView, View view) {
        AppMethodBeat.i(40408);
        dynamicGridView.dV(view);
        AppMethodBeat.o(40408);
    }

    static /* synthetic */ void m(DynamicGridView dynamicGridView) {
        AppMethodBeat.i(40409);
        dynamicGridView.cvg();
        AppMethodBeat.o(40409);
    }

    static /* synthetic */ void o(DynamicGridView dynamicGridView) {
        AppMethodBeat.i(40410);
        dynamicGridView.cvh();
        AppMethodBeat.o(40410);
    }

    static /* synthetic */ void p(DynamicGridView dynamicGridView) {
        AppMethodBeat.i(40412);
        dynamicGridView.cvm();
        AppMethodBeat.o(40412);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40367);
        init(context);
        AppMethodBeat.o(40367);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40368);
        init(context);
        AppMethodBeat.o(40368);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rLB = onScrollListener;
    }

    public void setOnDropListener(f fVar) {
        this.rLC = fVar;
    }

    public void setOnDragListener(e eVar) {
        this.rLD = eVar;
    }

    public final void Ex(int i) {
        AppMethodBeat.i(40369);
        if (this.rLA) {
            requestDisallowInterceptTouchEvent(true);
            if (cvj() && this.rLz) {
                cve();
            }
            if (i != -1) {
                this.lBk = Ey(i);
                if (this.lBk) {
                    this.rLs = true;
                }
            }
            AppMethodBeat.o(40369);
            return;
        }
        AppMethodBeat.o(40369);
    }

    public void setEditModeEnabled(boolean z) {
        this.rLA = z;
    }

    public void setOnEditModeChangeListener(g gVar) {
        this.rLE = gVar;
    }

    public void setWobbleInEditMode(boolean z) {
        this.rLz = z;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(40370);
        this.rLF = onItemClickListener;
        super.setOnItemClickListener(this.rLG);
        AppMethodBeat.o(40370);
    }

    public void setUndoSupportEnabled(boolean z) {
        AppMethodBeat.i(40371);
        if (this.rLH != z) {
            if (z) {
                this.rLI = new Stack();
            } else {
                this.rLI = null;
            }
        }
        this.rLH = z;
        AppMethodBeat.o(40371);
    }

    public void setOnSelectedItemBitmapCreationListener(h hVar) {
        this.rLK = hVar;
    }

    @TargetApi(11)
    private void cve() {
        AppMethodBeat.i(40372);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(R.id.ak))) {
                if (i % 2 == 0) {
                    dU(childAt);
                } else {
                    dV(childAt);
                }
                childAt.setTag(R.id.ak, Boolean.TRUE);
            }
        }
        AppMethodBeat.o(40372);
    }

    /* Access modifiers changed, original: final */
    @TargetApi(11)
    public final void lo(boolean z) {
        AppMethodBeat.i(40373);
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
                childAt.setTag(R.id.ak, Boolean.FALSE);
            }
        }
        AppMethodBeat.o(40373);
    }

    private void init(Context context) {
        AppMethodBeat.i(40374);
        super.setOnScrollListener(this.rLS);
        this.rLu = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.rLq = getResources().getDimensionPixelSize(R.dimen.za);
        AppMethodBeat.o(40374);
    }

    @TargetApi(11)
    private void dU(View view) {
        AppMethodBeat.i(40375);
        ObjectAnimator dW = dW(view);
        dW.setFloatValues(new float[]{-2.0f, 2.0f});
        dW.start();
        this.rLw.add(dW);
        AppMethodBeat.o(40375);
    }

    @TargetApi(11)
    private void dV(View view) {
        AppMethodBeat.i(40376);
        ObjectAnimator dW = dW(view);
        dW.setFloatValues(new float[]{2.0f, -2.0f});
        dW.start();
        this.rLw.add(dW);
        AppMethodBeat.o(40376);
    }

    @TargetApi(11)
    private ObjectAnimator dW(final View view) {
        AppMethodBeat.i(40377);
        if (!cvk()) {
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
                AppMethodBeat.i(40346);
                view.setLayerType(0, null);
                AppMethodBeat.o(40346);
            }
        });
        AppMethodBeat.o(40377);
        return objectAnimator;
    }

    private void fC(int i, int i2) {
        AppMethodBeat.i(40378);
        getAdapterInterface().fB(i, i2);
        AppMethodBeat.o(40378);
    }

    private int getColumnCount() {
        AppMethodBeat.i(40379);
        int columnCount = getAdapterInterface().getColumnCount();
        AppMethodBeat.o(40379);
        return columnCount;
    }

    private d getAdapterInterface() {
        AppMethodBeat.i(40380);
        d dVar = (d) getAdapter();
        AppMethodBeat.o(40380);
        return dVar;
    }

    private BitmapDrawable dX(View view) {
        AppMethodBeat.i(40381);
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
        AppMethodBeat.o(40381);
        return bitmapDrawable;
    }

    private void kN(long j) {
        AppMethodBeat.i(40382);
        this.idList.clear();
        int kO = kO(j);
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (kO != firstVisiblePosition && getAdapterInterface().Et(firstVisiblePosition)) {
                this.idList.add(Long.valueOf(Ez(firstVisiblePosition)));
            }
            firstVisiblePosition++;
        }
        AppMethodBeat.o(40382);
    }

    public final int kO(long j) {
        AppMethodBeat.i(40383);
        View kP = kP(j);
        if (kP == null) {
            AppMethodBeat.o(40383);
            return -1;
        }
        int positionForView = getPositionForView(kP);
        AppMethodBeat.o(40383);
        return positionForView;
    }

    public final View kP(long j) {
        AppMethodBeat.i(40384);
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                AppMethodBeat.o(40384);
                return childAt;
            }
        }
        AppMethodBeat.o(40384);
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(40385);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        AppMethodBeat.o(40385);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(40386);
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.rLO = motionEvent.getX();
                this.rLP = motionEvent.getY();
                this.rLN = f.a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.rLN);
                if (!this.rLx && this.rLN >= 0) {
                    d dVar = this.rLM;
                    dVar.removeMessages(1);
                    dVar.sendEmptyMessageDelayed(1, 300);
                }
                this.rLo = -1;
                this.rLp = -1;
                this.rLm = (int) motionEvent.getX();
                this.rLn = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.lBk && isEnabled()) {
                    layoutChildren();
                    Ey(pointToPosition(this.rLm, this.rLn));
                    break;
                } else if (!isEnabled()) {
                    AppMethodBeat.o(40386);
                    return false;
                }
                break;
            case 1:
                cvh();
                if (this.rLH && this.rLJ != null) {
                    a aVar = this.rLJ;
                    Collections.reverse(aVar.rLZ);
                    if (!aVar.rLZ.isEmpty()) {
                        this.rLI.push(this.rLJ);
                        this.rLJ = new a();
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
                        this.rLD.l(rect);
                    }
                    AppMethodBeat.o(40386);
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
        AppMethodBeat.o(40386);
        return onTouchEvent;
    }

    private boolean cvf() {
        AppMethodBeat.i(40387);
        int kO = kO(this.rLr);
        if (kO != -1) {
            this.rLD.Ew(kO);
            if (this.rLL == null) {
                AppMethodBeat.o(40387);
                return false;
            }
            int positionForView = getPositionForView(this.rLL);
            int childCount = getChildCount() - 1;
            new StringBuilder("switch ").append(positionForView).append(",").append(childCount);
            if (positionForView == -1) {
                AppMethodBeat.o(40387);
                return false;
            }
            j bVar;
            fC(positionForView, childCount);
            if (this.rLH) {
                this.rLJ.fD(positionForView, childCount);
            }
            this.rLn = this.rLo;
            this.rLm = this.rLp;
            if (cvj() && cvk()) {
                bVar = new b(0, 0);
            } else if (cvk()) {
                bVar = new i(0, 0);
            } else {
                bVar = new c(0, 0);
            }
            kN(this.rLr);
            bVar.fE(positionForView, childCount);
            AppMethodBeat.o(40387);
            return true;
        }
        AppMethodBeat.o(40387);
        return false;
    }

    private boolean Ey(int i) {
        AppMethodBeat.i(40388);
        if (getAdapterInterface().Es(i)) {
            this.rLk = 0;
            this.rLl = 0;
            View childAt = getChildAt(i - getFirstVisiblePosition());
            if (childAt != null) {
                this.rLr = getAdapter().getItemId(i);
                this.rLg = dX(childAt);
                cvi();
                if (cvj()) {
                    childAt.setVisibility(4);
                }
                kN(this.rLr);
                if (this.rLD != null) {
                    this.rLD.Ev(i);
                }
                AppMethodBeat.o(40388);
                return true;
            }
            AppMethodBeat.o(40388);
            return false;
        }
        AppMethodBeat.o(40388);
        return false;
    }

    private void cvg() {
        AppMethodBeat.i(40389);
        this.rLt = n(this.rLh);
        AppMethodBeat.o(40389);
    }

    private boolean n(Rect rect) {
        AppMethodBeat.i(40390);
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.rLu, 0);
            AppMethodBeat.o(40390);
            return true;
        } else if (i + height2 < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            AppMethodBeat.o(40390);
            return false;
        } else {
            smoothScrollBy(this.rLu, 0);
            AppMethodBeat.o(40390);
            return true;
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(40391);
        super.setAdapter(listAdapter);
        AppMethodBeat.o(40391);
    }

    private void cvh() {
        AppMethodBeat.i(40392);
        this.rLM.removeMessages(1);
        View kP = kP(this.rLr);
        Rect rect;
        if (this.rLh != null) {
            rect = new Rect(this.rLh);
            rect.offset(0, this.rLh.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.rLD != null && this.rLD.m(rect) && cvf()) {
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
                dY(kP);
            } else {
                this.rLg.setBounds(this.rLh);
                invalidate();
                dZ(kP);
            }
        }
        if (this.rLD != null) {
            this.rLD.cvc();
        }
        AppMethodBeat.o(40392);
    }

    @TargetApi(11)
    private void cvi() {
        AppMethodBeat.i(40393);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rLg, "bounds", new TypeEvaluator<Rect>() {
            public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
                AppMethodBeat.i(40347);
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                Rect rect3 = new Rect(AnonymousClass4.e(rect.left, rect2.left, f), AnonymousClass4.e(rect.top, rect2.top, f), AnonymousClass4.e(rect.right, rect2.right, f), AnonymousClass4.e(rect.bottom, rect2.bottom, f));
                AppMethodBeat.o(40347);
                return rect3;
            }

            private static int e(int i, int i2, float f) {
                return (int) (((float) i) + (((float) (i2 - i)) * f));
            }
        }, new Object[]{this.rLh});
        ofObject.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40348);
                DynamicGridView.this.invalidate();
                AppMethodBeat.o(40348);
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40349);
                DynamicGridView.this.rLx = true;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(40349);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40350);
                DynamicGridView.this.rLx = false;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(40350);
            }
        });
        ofObject.setDuration(10);
        ofObject.start();
        AppMethodBeat.o(40393);
    }

    @TargetApi(11)
    private void dY(final View view) {
        AppMethodBeat.i(40394);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rLg, "bounds", new TypeEvaluator<Rect>() {
            public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
                AppMethodBeat.i(40351);
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                Rect rect3 = new Rect(AnonymousClass7.e(rect.left, rect2.left, f), AnonymousClass7.e(rect.top, rect2.top, f), AnonymousClass7.e(rect.right, rect2.right, f), AnonymousClass7.e(rect.bottom, rect2.bottom, f));
                AppMethodBeat.o(40351);
                return rect3;
            }

            private static int e(int i, int i2, float f) {
                return (int) (((float) i) + (((float) (i2 - i)) * f));
            }
        }, new Object[]{this.rLh});
        ofObject.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40352);
                DynamicGridView.this.invalidate();
                AppMethodBeat.o(40352);
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40353);
                DynamicGridView.this.rLx = true;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(40353);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40354);
                DynamicGridView.this.rLx = false;
                DynamicGridView.b(DynamicGridView.this);
                if (!(DynamicGridView.this.rLg == null || DynamicGridView.this.rLC == null)) {
                    DynamicGridView.this.rLC.cvd();
                }
                DynamicGridView.a(DynamicGridView.this, view);
                AppMethodBeat.o(40354);
            }
        });
        ofObject.setDuration(200);
        ofObject.start();
        AppMethodBeat.o(40394);
    }

    private void dZ(View view) {
        AppMethodBeat.i(40395);
        this.idList.clear();
        this.rLr = -1;
        view.setVisibility(0);
        this.rLg = null;
        if (cvj() && this.rLz) {
            if (this.lBk) {
                lo(false);
                cve();
            } else {
                lo(true);
            }
        }
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
        AppMethodBeat.o(40395);
    }

    static boolean cvj() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean cvk() {
        return VERSION.SDK_INT < 21;
    }

    private void cvl() {
        AppMethodBeat.i(40396);
        View kP = kP(this.rLr);
        if (kP == null) {
            AppMethodBeat.o(40396);
            return;
        }
        if (this.rLs) {
            dZ(kP);
        }
        this.rLs = false;
        this.rLt = false;
        this.mActivePointerId = -1;
        AppMethodBeat.o(40396);
    }

    /* JADX WARNING: Missing block: B:79:0x012e, code skipped:
            if (r9 < (r5.getRight() - r14.rLq)) goto L_0x0130;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cvm() {
        AppMethodBeat.i(40397);
        int i = this.rLo - this.rLn;
        int i2 = this.rLp - this.rLm;
        int centerY = (this.rLi.centerY() + this.rLk) + i;
        int centerX = (this.rLi.centerX() + this.rLl) + i2;
        this.rLL = kP(this.rLr);
        if (this.rLL == null) {
            AppMethodBeat.o(40397);
            return;
        }
        View view = null;
        float f = 0.0f;
        float f2 = 0.0f;
        Point ea = ea(this.rLL);
        for (Long longValue : this.idList) {
            float abs;
            View kP = kP(longValue.longValue());
            if (kP != null) {
                Object obj;
                Point ea2 = ea(kP);
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
                float abs2 = Math.abs(f.dS(kP) - f.dS(this.rLL));
                abs = Math.abs(f.dT(kP) - f.dT(this.rLL));
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
            d adapterInterface = getAdapterInterface();
            if (positionForView2 != -1 && adapterInterface.Et(positionForView) && adapterInterface.Et(positionForView2)) {
                j bVar;
                fC(positionForView, positionForView2);
                if (this.rLH) {
                    this.rLJ.fD(positionForView, positionForView2);
                }
                this.rLn = this.rLo;
                this.rLm = this.rLp;
                if (cvj() && cvk()) {
                    bVar = new b(i2, i);
                } else if (cvk()) {
                    bVar = new i(i2, i);
                } else {
                    bVar = new c(i2, i);
                }
                kN(this.rLr);
                bVar.fE(positionForView, positionForView2);
            } else {
                kN(this.rLr);
                AppMethodBeat.o(40397);
                return;
            }
        }
        AppMethodBeat.o(40397);
    }

    private Point ea(View view) {
        AppMethodBeat.i(40398);
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        Point point = new Point(positionForView % columnCount, positionForView / columnCount);
        AppMethodBeat.o(40398);
        return point;
    }

    private long Ez(int i) {
        AppMethodBeat.i(40399);
        long itemId = getAdapter().getItemId(i);
        AppMethodBeat.o(40399);
        return itemId;
    }

    @TargetApi(11)
    private static AnimatorSet e(View view, float f, float f2) {
        AppMethodBeat.i(40400);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        AppMethodBeat.o(40400);
        return animatorSet;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(40401);
        super.dispatchDraw(canvas);
        if (this.rLg != null) {
            this.rLg.draw(canvas);
        }
        AppMethodBeat.o(40401);
    }

    static /* synthetic */ void b(DynamicGridView dynamicGridView) {
        boolean z;
        AppMethodBeat.i(40403);
        if (dynamicGridView.rLx || dynamicGridView.rLy) {
            z = false;
        } else {
            z = true;
        }
        dynamicGridView.setEnabled(z);
        AppMethodBeat.o(40403);
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, int i, int i2) {
        AppMethodBeat.i(40405);
        Object obj = i2 > i ? 1 : null;
        LinkedList linkedList = new LinkedList();
        int min;
        View kP;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                kP = dynamicGridView.kP(dynamicGridView.Ez(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(e(kP, (float) ((-kP.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) kP.getHeight()));
                } else {
                    linkedList.add(e(kP, (float) kP.getWidth(), 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                kP = dynamicGridView.kP(dynamicGridView.Ez(min));
                if ((dynamicGridView.getColumnCount() + min) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(e(kP, (float) (kP.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-kP.getHeight())));
                } else {
                    linkedList.add(e(kP, (float) (-kP.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40355);
                DynamicGridView.this.rLy = true;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(40355);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40356);
                DynamicGridView.this.rLy = false;
                DynamicGridView.b(DynamicGridView.this);
                AppMethodBeat.o(40356);
            }
        });
        animatorSet.start();
        AppMethodBeat.o(40405);
    }
}
