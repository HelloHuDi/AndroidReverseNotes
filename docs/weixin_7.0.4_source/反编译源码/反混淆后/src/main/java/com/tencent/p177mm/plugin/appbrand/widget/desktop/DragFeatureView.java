package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C38576c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView */
public abstract class DragFeatureView extends FrameLayout implements OnGestureListener, OnTouchListener {
    private RecyclerView aiB;
    private boolean canScroll = true;
    private Rect ckf = new Rect();
    private Vibrator iVt;
    private boolean iWH = false;
    protected int iYi;
    private Runnable iYj;
    private C38576c iYk;
    private C41531v iYl;
    int iYm = -1;
    private View iYn;
    protected Rect iYo = new Rect();
    protected Rect iYp = new Rect();
    private boolean iYq = true;
    private LinearLayout iYr;
    private ImageView iYs;
    private TextView iYt;
    private C42712g iYu = null;
    private Runnable iYv;
    private AnimatorListener iYw = new C335984();
    private GestureDetector iay;
    Paint mPaint = new Paint();
    protected Rect mRect = new Rect();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView$a */
    class C2540a implements Runnable {
        final C41531v ahR;

        C2540a(C41531v c41531v) {
            this.ahR = c41531v;
        }

        public final void run() {
            AppMethodBeat.m2504i(133901);
            if (this.ahR == null) {
                AppMethodBeat.m2505o(133901);
                return;
            }
            int a = DragFeatureView.this.iYm;
            int kj = this.ahR.mo66454kj();
            if (kj < 0) {
                AppMethodBeat.m2505o(133901);
                return;
            }
            String str = "MicroMsg.DragFeatureView";
            String str2 = "alvinluo move run %b, onMove: %b, from: %d, to: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(DragFeatureView.this.iYl != this.ahR);
            C38576c c = DragFeatureView.this.iYk;
            DragFeatureView.this.getRecyclerView();
            DragFeatureView.this.iYl;
            objArr[1] = Boolean.valueOf(c.mo58583R(this.ahR));
            objArr[2] = Integer.valueOf(a);
            objArr[3] = Integer.valueOf(kj);
            C4990ab.m7417i(str, str2, objArr);
            if (DragFeatureView.this.iYl != this.ahR) {
                c = DragFeatureView.this.iYk;
                DragFeatureView.this.getRecyclerView();
                DragFeatureView.this.iYl;
                if (c.mo58583R(this.ahR)) {
                    DragFeatureView.this.iYk.mo58586a(DragFeatureView.this.getRecyclerView(), DragFeatureView.this.iYl, this.ahR, a, kj);
                    DragFeatureView.this.iYm = kj;
                }
            }
            AppMethodBeat.m2505o(133901);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView$3 */
    class C335953 implements Runnable {
        C335953() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133899);
            DragFeatureView.this.setVisibility(8);
            DragFeatureView.this.iYn = null;
            DragFeatureView.this.iYv = null;
            AppMethodBeat.m2505o(133899);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView$1 */
    class C335961 implements AnimatorListener {
        C335961() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133897);
            DragFeatureView.this.removeView(DragFeatureView.this.iYn);
            DragFeatureView.this.aPu();
            DragFeatureView.this.setRubbishViewVisible(8);
            AppMethodBeat.m2505o(133897);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView$4 */
    class C335984 implements AnimatorListener {
        C335984() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133900);
            DragFeatureView.this.aPu();
            DragFeatureView.this.requestLayout();
            AppMethodBeat.m2505o(133900);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: N */
    public abstract C38576c mo54132N(C41531v c41531v);

    public DragFeatureView(Context context) {
        super(context);
        init(context);
    }

    public DragFeatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DragFeatureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setTouchEnabled(boolean z) {
        this.iYq = z;
    }

    private void init(Context context) {
        this.iYi = (int) getResources().getDimension(C25738R.dimen.a7o);
        setVisibility(8);
        this.iay = new GestureDetector(context, this);
        this.iVt = (Vibrator) context.getSystemService("vibrator");
        addView(aPv());
    }

    private void setItemDragCallback(C38576c c38576c) {
        this.iYk = c38576c;
    }

    public C38576c getItemDragCallback() {
        return this.iYk;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.aiB = recyclerView;
    }

    public void setRecyclerViewScrollComputer(C42712g c42712g) {
        this.iYu = c42712g;
    }

    public C42712g getRecyclerScrollComputer() {
        return this.iYu;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* JADX WARNING: Missing block: B:64:0x018f, code skipped:
            if (r0.mo58582P(r4) != false) goto L_0x0191;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (getVisibility() == 8) {
            return false;
        }
        int i;
        C41531v e;
        float rawX = motionEvent2.getRawX();
        float rawY = motionEvent2.getRawY();
        getRecyclerView().getGlobalVisibleRect(this.mRect);
        if (!this.mRect.contains((int) rawX, (int) rawY)) {
            if (rawX < ((float) this.mRect.left)) {
                i = 3;
            } else if (rawX > ((float) this.mRect.right)) {
                i = 4;
            }
            e = mo54134e(motionEvent2.getRawX(), motionEvent2.getRawY(), false);
            C38576c c38576c;
            if (this.canScroll) {
                c38576c = this.iYk;
                getRecyclerView();
                c38576c.mo58585a(this.iYn, f, f2, e, i);
                return false;
            }
            String str = "MicroMsg.DragFeatureView";
            String str2 = "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(e == null);
            objArr[2] = Float.valueOf(motionEvent2.getRawX());
            objArr[3] = Float.valueOf(motionEvent2.getRawY());
            C4990ab.m7419v(str, str2, objArr);
            if (i != 1 && i != 2 && i != 6) {
                if (!(i == 3 || i == 4)) {
                    c38576c = this.iYk;
                    getRecyclerView();
                }
                this.iYk.mo58589m(getRecyclerView());
            } else if (getTopScrollRect().contains((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY())) {
                m54870eV(true);
            } else if (getBottomScrollRect().contains((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY())) {
                m54870eV(false);
            } else if (getRubbishRect().contains((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY())) {
                removeCallbacks(this.iYj);
                removeCallbacks(this.iYv);
                this.iYv = null;
            }
            c38576c = this.iYk;
            getRecyclerView();
            c38576c.mo58585a(this.iYn, f, f2, e, i);
            if (!(i == 1 || i == 2)) {
                removeCallbacks(this.iYv);
                this.iYv = null;
            }
            if (Math.abs(f) >= 3.0f || Math.abs(f2) >= 3.0f) {
                removeCallbacks(this.iYj);
                c38576c = this.iYk;
                getRecyclerView();
                if (!c38576c.mo58582P(e) || i == 2) {
                    C2540a c2540a = new C2540a(e);
                    this.iYj = c2540a;
                    postDelayed(c2540a, 250);
                } else {
                    this.iYk.mo58589m(getRecyclerView());
                }
            }
            return true;
        }
        if (this.iYo.contains((int) rawX, (int) rawY)) {
            i = 2;
        } else if (this.iYp.contains((int) rawX, (int) rawY)) {
            i = 1;
        } else if (m54863M(rawX, rawY)) {
            i = 6;
        } else {
            for (int i2 = 0; i2 < getRecyclerView().getChildCount(); i2++) {
                getRecyclerView().mo66337aZ(getRecyclerView().getChildAt(i2)).apJ.getGlobalVisibleRect(this.mRect);
                if (this.mRect.contains((int) rawX, (int) rawY)) {
                    i = 5;
                    break;
                }
            }
            i = 7;
        }
        e = mo54134e(motionEvent2.getRawX(), motionEvent2.getRawY(), false);
        if (this.canScroll) {
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        try {
            C41531v e = mo54134e(motionEvent.getRawX(), motionEvent.getRawY(), true);
            setItemDragCallback(mo54132N(e));
            if (e != null) {
                C38576c c38576c = this.iYk;
                getRecyclerView();
                if (c38576c.mo58581O(e)) {
                    this.iYn = this.iYk.mo58587d(getRecyclerView(), e);
                    this.iYm = e.mo66454kj();
                    this.iYl = e;
                    this.iVt.vibrate(30);
                    setRubbishViewVisible(0);
                    setVisibility(0);
                    motionEvent.setAction(0);
                    this.iay.onTouchEvent(motionEvent);
                    motionEvent.setAction(3);
                    this.iay.onTouchEvent(motionEvent);
                }
            }
            setVisibility(8);
            motionEvent.setAction(0);
            this.iay.onTouchEvent(motionEvent);
            motionEvent.setAction(3);
            this.iay.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.DragFeatureView", e2, "alvinluo onLongPress exception", new Object[0]);
            motionEvent.setAction(0);
            this.iay.onTouchEvent(motionEvent);
            motionEvent.setAction(3);
            this.iay.onTouchEvent(motionEvent);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getGlobalVisibleRect(this.iYo);
        this.iYo.set(this.iYo.left, this.iYo.bottom - (this.iYi * 2), this.iYo.right, this.iYo.bottom - this.iYi);
        getRecyclerView().getGlobalVisibleRect(this.iYp);
        this.iYp.set(this.iYp.left, 0, this.iYp.right, this.iYp.top + this.iYi);
        findViewById(2131820661).getGlobalVisibleRect(this.ckf);
    }

    public Rect getRubbishRect() {
        return this.ckf;
    }

    public Rect getTopScrollRect() {
        return this.iYp;
    }

    public Rect getBottomScrollRect() {
        return this.iYo;
    }

    /* renamed from: eV */
    private void m54870eV(final boolean z) {
        if (this.iYv == null) {
            C335972 c335972 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133898);
                    C4990ab.m7417i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", Boolean.valueOf(z));
                    boolean canScrollVertically = DragFeatureView.this.getRecyclerView().canScrollVertically(z ? -10 : 10);
                    C4990ab.m7417i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", Boolean.valueOf(canScrollVertically));
                    DragFeatureView.this.getRecyclerView().scrollBy(0, z ? -20 : 20);
                    DragFeatureView.this.post(this);
                    AppMethodBeat.m2505o(133898);
                }
            };
            this.iYv = c335972;
            postDelayed(c335972, 250);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(-65536);
        if (this.iYo != null) {
            canvas.drawRect(this.iYo, this.mPaint);
        }
        this.mPaint.setColor(-16711936);
        if (this.iYp != null) {
            canvas.drawRect(this.iYp, this.mPaint);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public C41531v mo54134e(float f, float f2, boolean z) {
        if (this.iYo.contains((int) f, (int) f2)) {
            return null;
        }
        for (int i = 0; i < getRecyclerView().getChildCount(); i++) {
            C41531v aZ = getRecyclerView().mo66337aZ(getRecyclerView().getChildAt(i));
            aZ.apJ.getGlobalVisibleRect(this.mRect);
            if (this.mRect.contains((int) f, (int) f2)) {
                return aZ;
            }
        }
        if (this.iYp.contains((int) f, (int) f2)) {
            return null;
        }
        return null;
    }

    public RecyclerView getRecyclerView() {
        return this.aiB;
    }

    /* renamed from: M */
    private boolean m54863M(float f, float f2) {
        return getRubbishRect().contains((int) f, (int) f2) || getRubbishRect().top < ((int) f2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.iYq) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!m54863M(motionEvent.getRawX(), motionEvent.getRawY())) {
                    removeCallbacks(this.iYj);
                    removeCallbacks(this.iYv);
                    setRubbishViewVisible(8);
                    int i = this.iYm;
                    this.iYm = -1;
                    this.iWH = false;
                    this.iYk.mo58584a(getRecyclerView(), this.iYl, i, new C335953());
                    break;
                }
                this.iYm = -1;
                this.iWH = false;
                this.iYk.mo58588e(getRecyclerView(), this.iYl);
                removeCallbacks(this.iYj);
                removeCallbacks(this.iYv);
                if (this.iYn != null) {
                    this.iYn.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new C335961()).setDuration(300).start();
                    break;
                }
                break;
            case 2:
                if (!m54863M(motionEvent.getRawX(), motionEvent.getRawY())) {
                    aPu();
                    break;
                }
                this.iYr.setBackgroundColor(getContext().getResources().getColor(C25738R.color.f11739fc));
                this.iYt.setText(C25738R.string.f8881hz);
                this.iYt.setTextSize(2, getRubbishViewTextSize());
                this.iYs.setImageResource(C25738R.drawable.aw2);
                break;
        }
        this.iay.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: ee */
    public final void mo54135ee(boolean z) {
        C4990ab.m7417i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", Boolean.valueOf(z));
        this.canScroll = z;
    }

    private float getRubbishViewTextSize() {
        return 12.0f * C10969d.m18710dm(getContext());
    }

    private void aPu() {
        try {
            this.iYt.setText(C25738R.string.f8876hu);
            this.iYt.setTextSize(1, getRubbishViewTextSize());
            this.iYs.setImageResource(C25738R.drawable.aw1);
            this.iYr.setBackgroundColor(getContext().getResources().getColor(C25738R.color.f11738fb));
        } catch (Exception e) {
        }
    }

    private View aPv() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(C25738R.color.f11738fb));
        LayoutParams layoutParams = new LayoutParams(-1, this.iYi);
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setId(2131820661);
        linearLayout.setTranslationY((float) layoutParams.height);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(C25738R.drawable.aw1);
        imageView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        C4990ab.m7417i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", Integer.valueOf(imageView.getMeasuredWidth()), Integer.valueOf(imageView.getMeasuredHeight()));
        layoutParams2.width = (int) (((float) imageView.getMeasuredWidth()) * C10969d.m18710dm(getContext()));
        layoutParams2.height = (int) (((float) imageView.getMeasuredHeight()) * C10969d.m18710dm(getContext()));
        imageView.setLayoutParams(layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setText(C25738R.string.f8876hu);
        textView.setTextSize(1, getRubbishViewTextSize());
        textView.setTextColor(getContext().getResources().getColor(C25738R.color.a69));
        textView.setPadding(0, C1338a.fromDPToPix(getContext(), 4), 0, 0);
        textView.setGravity(17);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        this.iYr = linearLayout;
        this.iYs = imageView;
        this.iYt = textView;
        return linearLayout;
    }

    /* Access modifiers changed, original: protected */
    public void setRubbishViewVisible(int i) {
        View findViewById = findViewById(2131820661);
        if (findViewById != null) {
            if (i == 0) {
                findViewById.animate().translationY(0.0f).setDuration(300).setListener(this.iYw).start();
            } else {
                findViewById.animate().translationY((float) findViewById.getHeight()).setDuration(300).setListener(this.iYw).start();
            }
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
