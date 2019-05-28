package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class DragFeatureView extends FrameLayout implements OnGestureListener, OnTouchListener {
    private RecyclerView aiB;
    private boolean canScroll = true;
    private Rect ckf = new Rect();
    private Vibrator iVt;
    private boolean iWH = false;
    protected int iYi;
    private Runnable iYj;
    private c iYk;
    private v iYl;
    int iYm = -1;
    private View iYn;
    protected Rect iYo = new Rect();
    protected Rect iYp = new Rect();
    private boolean iYq = true;
    private LinearLayout iYr;
    private ImageView iYs;
    private TextView iYt;
    private g iYu = null;
    private Runnable iYv;
    private AnimatorListener iYw = new AnimatorListener() {
        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133900);
            DragFeatureView.this.aPu();
            DragFeatureView.this.requestLayout();
            AppMethodBeat.o(133900);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    };
    private GestureDetector iay;
    Paint mPaint = new Paint();
    protected Rect mRect = new Rect();

    class a implements Runnable {
        final v ahR;

        a(v vVar) {
            this.ahR = vVar;
        }

        public final void run() {
            AppMethodBeat.i(133901);
            if (this.ahR == null) {
                AppMethodBeat.o(133901);
                return;
            }
            int a = DragFeatureView.this.iYm;
            int kj = this.ahR.kj();
            if (kj < 0) {
                AppMethodBeat.o(133901);
                return;
            }
            String str = "MicroMsg.DragFeatureView";
            String str2 = "alvinluo move run %b, onMove: %b, from: %d, to: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(DragFeatureView.this.iYl != this.ahR);
            c c = DragFeatureView.this.iYk;
            DragFeatureView.this.getRecyclerView();
            DragFeatureView.this.iYl;
            objArr[1] = Boolean.valueOf(c.R(this.ahR));
            objArr[2] = Integer.valueOf(a);
            objArr[3] = Integer.valueOf(kj);
            ab.i(str, str2, objArr);
            if (DragFeatureView.this.iYl != this.ahR) {
                c = DragFeatureView.this.iYk;
                DragFeatureView.this.getRecyclerView();
                DragFeatureView.this.iYl;
                if (c.R(this.ahR)) {
                    DragFeatureView.this.iYk.a(DragFeatureView.this.getRecyclerView(), DragFeatureView.this.iYl, this.ahR, a, kj);
                    DragFeatureView.this.iYm = kj;
                }
            }
            AppMethodBeat.o(133901);
        }
    }

    public abstract c N(v vVar);

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
        this.iYi = (int) getResources().getDimension(R.dimen.a7o);
        setVisibility(8);
        this.iay = new GestureDetector(context, this);
        this.iVt = (Vibrator) context.getSystemService("vibrator");
        addView(aPv());
    }

    private void setItemDragCallback(c cVar) {
        this.iYk = cVar;
    }

    public c getItemDragCallback() {
        return this.iYk;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.aiB = recyclerView;
    }

    public void setRecyclerViewScrollComputer(g gVar) {
        this.iYu = gVar;
    }

    public g getRecyclerScrollComputer() {
        return this.iYu;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* JADX WARNING: Missing block: B:64:0x018f, code skipped:
            if (r0.P(r4) != false) goto L_0x0191;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (getVisibility() == 8) {
            return false;
        }
        int i;
        v e;
        float rawX = motionEvent2.getRawX();
        float rawY = motionEvent2.getRawY();
        getRecyclerView().getGlobalVisibleRect(this.mRect);
        if (!this.mRect.contains((int) rawX, (int) rawY)) {
            if (rawX < ((float) this.mRect.left)) {
                i = 3;
            } else if (rawX > ((float) this.mRect.right)) {
                i = 4;
            }
            e = e(motionEvent2.getRawX(), motionEvent2.getRawY(), false);
            c cVar;
            if (this.canScroll) {
                cVar = this.iYk;
                getRecyclerView();
                cVar.a(this.iYn, f, f2, e, i);
                return false;
            }
            String str = "MicroMsg.DragFeatureView";
            String str2 = "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(e == null);
            objArr[2] = Float.valueOf(motionEvent2.getRawX());
            objArr[3] = Float.valueOf(motionEvent2.getRawY());
            ab.v(str, str2, objArr);
            if (i != 1 && i != 2 && i != 6) {
                if (!(i == 3 || i == 4)) {
                    cVar = this.iYk;
                    getRecyclerView();
                }
                this.iYk.m(getRecyclerView());
            } else if (getTopScrollRect().contains((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY())) {
                eV(true);
            } else if (getBottomScrollRect().contains((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY())) {
                eV(false);
            } else if (getRubbishRect().contains((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY())) {
                removeCallbacks(this.iYj);
                removeCallbacks(this.iYv);
                this.iYv = null;
            }
            cVar = this.iYk;
            getRecyclerView();
            cVar.a(this.iYn, f, f2, e, i);
            if (!(i == 1 || i == 2)) {
                removeCallbacks(this.iYv);
                this.iYv = null;
            }
            if (Math.abs(f) >= 3.0f || Math.abs(f2) >= 3.0f) {
                removeCallbacks(this.iYj);
                cVar = this.iYk;
                getRecyclerView();
                if (!cVar.P(e) || i == 2) {
                    a aVar = new a(e);
                    this.iYj = aVar;
                    postDelayed(aVar, 250);
                } else {
                    this.iYk.m(getRecyclerView());
                }
            }
            return true;
        }
        if (this.iYo.contains((int) rawX, (int) rawY)) {
            i = 2;
        } else if (this.iYp.contains((int) rawX, (int) rawY)) {
            i = 1;
        } else if (M(rawX, rawY)) {
            i = 6;
        } else {
            for (int i2 = 0; i2 < getRecyclerView().getChildCount(); i2++) {
                getRecyclerView().aZ(getRecyclerView().getChildAt(i2)).apJ.getGlobalVisibleRect(this.mRect);
                if (this.mRect.contains((int) rawX, (int) rawY)) {
                    i = 5;
                    break;
                }
            }
            i = 7;
        }
        e = e(motionEvent2.getRawX(), motionEvent2.getRawY(), false);
        if (this.canScroll) {
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        try {
            v e = e(motionEvent.getRawX(), motionEvent.getRawY(), true);
            setItemDragCallback(N(e));
            if (e != null) {
                c cVar = this.iYk;
                getRecyclerView();
                if (cVar.O(e)) {
                    this.iYn = this.iYk.d(getRecyclerView(), e);
                    this.iYm = e.kj();
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
            ab.printErrStackTrace("MicroMsg.DragFeatureView", e2, "alvinluo onLongPress exception", new Object[0]);
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
        findViewById(R.id.cg).getGlobalVisibleRect(this.ckf);
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

    private void eV(final boolean z) {
        if (this.iYv == null) {
            AnonymousClass2 anonymousClass2 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133898);
                    ab.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", Boolean.valueOf(z));
                    boolean canScrollVertically = DragFeatureView.this.getRecyclerView().canScrollVertically(z ? -10 : 10);
                    ab.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", Boolean.valueOf(canScrollVertically));
                    DragFeatureView.this.getRecyclerView().scrollBy(0, z ? -20 : 20);
                    DragFeatureView.this.post(this);
                    AppMethodBeat.o(133898);
                }
            };
            this.iYv = anonymousClass2;
            postDelayed(anonymousClass2, 250);
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
    public v e(float f, float f2, boolean z) {
        if (this.iYo.contains((int) f, (int) f2)) {
            return null;
        }
        for (int i = 0; i < getRecyclerView().getChildCount(); i++) {
            v aZ = getRecyclerView().aZ(getRecyclerView().getChildAt(i));
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

    private boolean M(float f, float f2) {
        return getRubbishRect().contains((int) f, (int) f2) || getRubbishRect().top < ((int) f2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.iYq) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!M(motionEvent.getRawX(), motionEvent.getRawY())) {
                    removeCallbacks(this.iYj);
                    removeCallbacks(this.iYv);
                    setRubbishViewVisible(8);
                    int i = this.iYm;
                    this.iYm = -1;
                    this.iWH = false;
                    this.iYk.a(getRecyclerView(), this.iYl, i, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133899);
                            DragFeatureView.this.setVisibility(8);
                            DragFeatureView.this.iYn = null;
                            DragFeatureView.this.iYv = null;
                            AppMethodBeat.o(133899);
                        }
                    });
                    break;
                }
                this.iYm = -1;
                this.iWH = false;
                this.iYk.e(getRecyclerView(), this.iYl);
                removeCallbacks(this.iYj);
                removeCallbacks(this.iYv);
                if (this.iYn != null) {
                    this.iYn.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListener() {
                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(133897);
                            DragFeatureView.this.removeView(DragFeatureView.this.iYn);
                            DragFeatureView.this.aPu();
                            DragFeatureView.this.setRubbishViewVisible(8);
                            AppMethodBeat.o(133897);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    }).setDuration(300).start();
                    break;
                }
                break;
            case 2:
                if (!M(motionEvent.getRawX(), motionEvent.getRawY())) {
                    aPu();
                    break;
                }
                this.iYr.setBackgroundColor(getContext().getResources().getColor(R.color.fc));
                this.iYt.setText(R.string.hz);
                this.iYt.setTextSize(2, getRubbishViewTextSize());
                this.iYs.setImageResource(R.drawable.aw2);
                break;
        }
        this.iay.onTouchEvent(motionEvent);
        return true;
    }

    public final void ee(boolean z) {
        ab.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", Boolean.valueOf(z));
        this.canScroll = z;
    }

    private float getRubbishViewTextSize() {
        return 12.0f * d.dm(getContext());
    }

    private void aPu() {
        try {
            this.iYt.setText(R.string.hu);
            this.iYt.setTextSize(1, getRubbishViewTextSize());
            this.iYs.setImageResource(R.drawable.aw1);
            this.iYr.setBackgroundColor(getContext().getResources().getColor(R.color.fb));
        } catch (Exception e) {
        }
    }

    private View aPv() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.fb));
        LayoutParams layoutParams = new LayoutParams(-1, this.iYi);
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setId(R.id.cg);
        linearLayout.setTranslationY((float) layoutParams.height);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.aw1);
        imageView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        ab.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", Integer.valueOf(imageView.getMeasuredWidth()), Integer.valueOf(imageView.getMeasuredHeight()));
        layoutParams2.width = (int) (((float) imageView.getMeasuredWidth()) * d.dm(getContext()));
        layoutParams2.height = (int) (((float) imageView.getMeasuredHeight()) * d.dm(getContext()));
        imageView.setLayoutParams(layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setText(R.string.hu);
        textView.setTextSize(1, getRubbishViewTextSize());
        textView.setTextColor(getContext().getResources().getColor(R.color.a69));
        textView.setPadding(0, com.tencent.mm.bz.a.fromDPToPix(getContext(), 4), 0, 0);
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
        View findViewById = findViewById(R.id.cg);
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
