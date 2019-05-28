package android.support.p069v7.widget.p076a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C37130c;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31879f;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C37137l;
import android.support.p069v7.widget.RecyclerView.C41526d;
import android.support.p069v7.widget.RecyclerView.C41527j;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.p076a.C0674c.C0675a;
import android.support.p069v7.widget.p076a.C0674c.C0676b;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.p177mm.C25738R;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.a.a */
public final class C8452a extends C25373h implements C41527j {
    RecyclerView aiB;
    private C41526d aog = null;
    private int arL;
    private List<Integer> avA;
    View avB = null;
    int avC = -1;
    C37130c avD;
    private C0673b avE;
    private final C37137l avF = new C84542();
    long avG;
    final List<View> avj = new ArrayList();
    private final float[] avk = new float[2];
    C41531v avl = null;
    float avm;
    float avn;
    float avo;
    float avp;
    float avq;
    float avr;
    float avs;
    float avt;
    C8457a avu;
    int avv = 0;
    int avw;
    List<C8450c> avx = new ArrayList();
    final Runnable avy = new C84531();
    private List<C41531v> avz;
    int mActivePointerId = -1;
    VelocityTracker mVelocityTracker;
    /* renamed from: oT */
    Rect f2411oT;

    /* renamed from: android.support.v7.widget.a.a$b */
    class C0673b extends SimpleOnGestureListener {
        boolean avP = true;

        C0673b() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (this.avP) {
                View k = C8452a.this.mo18503k(motionEvent);
                if (k != null) {
                    C41531v aZ = C8452a.this.aiB.mo66337aZ(k);
                    if (aZ != null) {
                        C8457a.m14979j(C8452a.this.aiB);
                        if (motionEvent.getPointerId(0) == C8452a.this.mActivePointerId) {
                            int findPointerIndex = motionEvent.findPointerIndex(C8452a.this.mActivePointerId);
                            float x = motionEvent.getX(findPointerIndex);
                            float y = motionEvent.getY(findPointerIndex);
                            C8452a.this.avm = x;
                            C8452a.this.avn = y;
                            C8452a c8452a = C8452a.this;
                            C8452a.this.avr = 0.0f;
                            c8452a.avq = 0.0f;
                            C8452a.this.mo18501e(aZ, 2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$c */
    static class C8450c implements AnimatorListener {
        /* renamed from: Ag */
        boolean f2410Ag = false;
        final C41531v aoM;
        final float avQ;
        final float avR;
        final float avS;
        final float avT;
        final ValueAnimator avU;
        final int avV;
        public boolean avW;
        float avX;
        float avY;
        boolean avZ = false;
        final int avv;
        float awa;

        /* renamed from: android.support.v7.widget.a.a$c$1 */
        class C84511 implements AnimatorUpdateListener {
            C84511() {
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C8450c.this.awa = valueAnimator.getAnimatedFraction();
            }
        }

        C8450c(C41531v c41531v, int i, int i2, float f, float f2, float f3, float f4) {
            this.avv = i2;
            this.avV = i;
            this.aoM = c41531v;
            this.avQ = f;
            this.avR = f2;
            this.avS = f3;
            this.avT = f4;
            this.avU = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.avU.addUpdateListener(new C84511());
            this.avU.setTarget(c41531v.apJ);
            this.avU.addListener(this);
            this.awa = 0.0f;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f2410Ag) {
                this.aoM.mo66445ao(true);
            }
            this.f2410Ag = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
            this.awa = 1.0f;
        }
    }

    /* renamed from: android.support.v7.widget.a.a$1 */
    class C84531 implements Runnable {
        C84531() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0139  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0139  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
        /* JADX WARNING: Missing block: B:39:0x0109, code skipped:
            if (r3 <= 0) goto L_0x010b;
     */
        /* JADX WARNING: Missing block: B:44:0x0131, code skipped:
            if (r7 <= 0) goto L_0x0133;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Object obj = null;
            if (C8452a.this.avl != null) {
                C8452a c8452a = C8452a.this;
                if (c8452a.avl != null) {
                    long j;
                    int paddingLeft;
                    int i;
                    int paddingTop;
                    int a;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (c8452a.avG == Long.MIN_VALUE) {
                        j = 0;
                    } else {
                        j = currentTimeMillis - c8452a.avG;
                    }
                    C17480i layoutManager = c8452a.aiB.getLayoutManager();
                    if (c8452a.f2411oT == null) {
                        c8452a.f2411oT = new Rect();
                    }
                    layoutManager.mo31859g(c8452a.avl.apJ, c8452a.f2411oT);
                    if (layoutManager.mo1776iG()) {
                        int i2 = (int) (c8452a.avs + c8452a.avq);
                        paddingLeft = (i2 - c8452a.f2411oT.left) - c8452a.aiB.getPaddingLeft();
                        if (c8452a.avq >= 0.0f || paddingLeft >= 0) {
                            if (c8452a.avq > 0.0f) {
                                paddingLeft = ((i2 + c8452a.avl.apJ.getWidth()) + c8452a.f2411oT.right) - (c8452a.aiB.getWidth() - c8452a.aiB.getPaddingRight());
                            }
                        }
                        if (layoutManager.mo1777iH()) {
                            C8457a c8457a;
                            RecyclerView recyclerView;
                            int width;
                            i = (int) (c8452a.avt + c8452a.avr);
                            paddingTop = (i - c8452a.f2411oT.top) - c8452a.aiB.getPaddingTop();
                            if (c8452a.avr >= 0.0f || paddingTop >= 0) {
                                if (c8452a.avr > 0.0f) {
                                    paddingTop = ((i + c8452a.avl.apJ.getHeight()) + c8452a.f2411oT.bottom) - (c8452a.aiB.getHeight() - c8452a.aiB.getPaddingBottom());
                                }
                            }
                            if (paddingLeft != 0) {
                                c8457a = c8452a.avu;
                                recyclerView = c8452a.aiB;
                                width = c8452a.avl.apJ.getWidth();
                                c8452a.aiB.getWidth();
                                a = c8457a.mo18509a(recyclerView, width, paddingLeft, j);
                            } else {
                                a = paddingLeft;
                            }
                            if (paddingTop != 0) {
                                c8457a = c8452a.avu;
                                recyclerView = c8452a.aiB;
                                width = c8452a.avl.apJ.getHeight();
                                c8452a.aiB.getHeight();
                                i = c8457a.mo18509a(recyclerView, width, paddingTop, j);
                            } else {
                                i = paddingTop;
                            }
                            if (!(a == 0 && i == 0)) {
                                if (c8452a.avG == Long.MIN_VALUE) {
                                    c8452a.avG = currentTimeMillis;
                                }
                                c8452a.aiB.scrollBy(a, i);
                                obj = 1;
                                if (obj == null) {
                                    if (C8452a.this.avl != null) {
                                        C8452a.this.mo18493M(C8452a.this.avl);
                                    }
                                    C8452a.this.aiB.removeCallbacks(C8452a.this.avy);
                                    C0477s.m934b(C8452a.this.aiB, (Runnable) this);
                                    return;
                                }
                                return;
                            }
                        }
                        paddingTop = 0;
                        if (paddingLeft != 0) {
                        }
                        if (paddingTop != 0) {
                        }
                        if (c8452a.avG == Long.MIN_VALUE) {
                        }
                        c8452a.aiB.scrollBy(a, i);
                        obj = 1;
                        if (obj == null) {
                        }
                    }
                    paddingLeft = 0;
                    if (layoutManager.mo1777iH()) {
                    }
                    paddingTop = 0;
                    if (paddingLeft != 0) {
                    }
                    if (paddingTop != 0) {
                    }
                    if (c8452a.avG == Long.MIN_VALUE) {
                    }
                    c8452a.aiB.scrollBy(a, i);
                    obj = 1;
                    if (obj == null) {
                    }
                }
                c8452a.avG = Long.MIN_VALUE;
                if (obj == null) {
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$2 */
    class C84542 implements C37137l {
        C84542() {
        }

        /* renamed from: h */
        public final boolean mo18506h(MotionEvent motionEvent) {
            C8452a.this.avD.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                C8452a.this.mActivePointerId = motionEvent.getPointerId(0);
                C8452a.this.avm = motionEvent.getX();
                C8452a.this.avn = motionEvent.getY();
                C8452a c8452a = C8452a.this;
                if (c8452a.mVelocityTracker != null) {
                    c8452a.mVelocityTracker.recycle();
                }
                c8452a.mVelocityTracker = VelocityTracker.obtain();
                if (C8452a.this.avl == null) {
                    C8450c c8450c;
                    C8452a c8452a2 = C8452a.this;
                    if (!c8452a2.avx.isEmpty()) {
                        View k = c8452a2.mo18503k(motionEvent);
                        for (int size = c8452a2.avx.size() - 1; size >= 0; size--) {
                            c8450c = (C8450c) c8452a2.avx.get(size);
                            if (c8450c.aoM.apJ == k) {
                                break;
                            }
                        }
                    }
                    c8450c = null;
                    if (c8450c != null) {
                        C8452a c8452a3 = C8452a.this;
                        c8452a3.avm -= c8450c.avX;
                        c8452a3 = C8452a.this;
                        c8452a3.avn -= c8450c.avY;
                        C8452a.this.mo18498b(c8450c.aoM, true);
                        if (C8452a.this.avj.remove(c8450c.aoM.apJ)) {
                            C8452a.this.avu.mo7525a(C8452a.this.aiB, c8450c.aoM);
                        }
                        C8452a.this.mo18501e(c8450c.aoM, c8450c.avv);
                        C8452a.this.mo18496a(motionEvent, C8452a.this.avw, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                C8452a.this.mActivePointerId = -1;
                C8452a.this.mo18501e(null, 0);
            } else if (C8452a.this.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(C8452a.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    C8452a.this.mo18497a(actionMasked, motionEvent, findPointerIndex);
                }
            }
            if (C8452a.this.mVelocityTracker != null) {
                C8452a.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (C8452a.this.avl != null) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void mo18507i(MotionEvent motionEvent) {
            int i = 0;
            C8452a.this.avD.onTouchEvent(motionEvent);
            if (C8452a.this.mVelocityTracker != null) {
                C8452a.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (C8452a.this.mActivePointerId != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(C8452a.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    C8452a.this.mo18497a(actionMasked, motionEvent, findPointerIndex);
                }
                C41531v c41531v = C8452a.this.avl;
                if (c41531v != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                C8452a.this.mo18496a(motionEvent, C8452a.this.avw, findPointerIndex);
                                C8452a.this.mo18493M(c41531v);
                                C8452a.this.aiB.removeCallbacks(C8452a.this.avy);
                                C8452a.this.avy.run();
                                C8452a.this.aiB.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (C8452a.this.mVelocityTracker != null) {
                                C8452a.this.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 6:
                            actionMasked = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionMasked) == C8452a.this.mActivePointerId) {
                                if (actionMasked == 0) {
                                    i = 1;
                                }
                                C8452a.this.mActivePointerId = motionEvent.getPointerId(i);
                                C8452a.this.mo18496a(motionEvent, C8452a.this.avw, actionMasked);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    C8452a.this.mo18501e(null, 0);
                    C8452a.this.mActivePointerId = -1;
                }
            }
        }

        /* renamed from: ab */
        public final void mo18505ab(boolean z) {
            if (z) {
                C8452a.this.mo18501e(null, 0);
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$3 */
    class C84553 extends C8450c {
        final /* synthetic */ int avI = 0;
        final /* synthetic */ C41531v avJ;

        C84553(C41531v c41531v, int i, int i2, float f, float f2, float f3, float f4, int i3, C41531v c41531v2) {
            this.avJ = c41531v2;
            super(c41531v, i, i2, f, f2, 0.0f, 0.0f);
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.avZ) {
                if (this.avI <= 0) {
                    C8452a.this.avu.mo7525a(C8452a.this.aiB, this.avJ);
                } else {
                    C8452a.this.avj.add(this.avJ.apJ);
                    this.avW = true;
                    if (this.avI > 0) {
                        C8452a c8452a = C8452a.this;
                        c8452a.aiB.post(new C84604(this, this.avI));
                    }
                }
                if (C8452a.this.avB == this.avJ.apJ) {
                    C8452a.this.mo18500bY(this.avJ.apJ);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$5 */
    class C84565 implements C41526d {
        C84565() {
        }

        /* renamed from: az */
        public final int mo18508az(int i, int i2) {
            if (C8452a.this.avB == null) {
                return i2;
            }
            int i3 = C8452a.this.avC;
            if (i3 == -1) {
                i3 = C8452a.this.aiB.indexOfChild(C8452a.this.avB);
                C8452a.this.avC = i3;
            }
            if (i2 == i - 1) {
                return i3;
            }
            return i2 >= i3 ? i2 + 1 : i2;
        }
    }

    /* renamed from: android.support.v7.widget.a.a$a */
    public static abstract class C8457a {
        private static final C8461b avL;
        private static final Interpolator avM = new C84591();
        private static final Interpolator avN = new C84582();
        private int avO = -1;

        /* renamed from: android.support.v7.widget.a.a$a$2 */
        static class C84582 implements Interpolator {
            C84582() {
            }

            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        }

        /* renamed from: android.support.v7.widget.a.a$a$1 */
        static class C84591 implements Interpolator {
            C84591() {
            }

            public final float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        }

        /* renamed from: a */
        public abstract boolean mo7526a(C41531v c41531v, C41531v c41531v2);

        static {
            if (VERSION.SDK_INT >= 21) {
                avL = new C0675a();
            } else {
                avL = new C0676b();
            }
        }

        /* renamed from: cZ */
        public static int m14977cZ(int i) {
            if (i == 0) {
            }
            return 983055;
        }

        /* renamed from: j */
        static int m14979j(RecyclerView recyclerView) {
            C0477s.m893T(recyclerView);
            return 983055;
        }

        /* renamed from: lB */
        public boolean mo7528lB() {
            return true;
        }

        /* renamed from: lC */
        public float mo7529lC() {
            return 0.5f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public static C41531v m14976a(C41531v c41531v, List<C41531v> list, int i, int i2) {
            int width = i + c41531v.apJ.getWidth();
            int height = i2 + c41531v.apJ.getHeight();
            int i3 = -1;
            int left = i - c41531v.apJ.getLeft();
            int top = i2 - c41531v.apJ.getTop();
            int size = list.size();
            int i4 = 0;
            C41531v c41531v2 = null;
            while (i4 < size) {
                int right;
                C41531v c41531v3 = (C41531v) list.get(i4);
                if (left > 0) {
                    right = c41531v3.apJ.getRight() - width;
                    if (right < 0 && c41531v3.apJ.getRight() > c41531v.apJ.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            c41531v2 = c41531v3;
                            if (left < 0) {
                                i3 = c41531v3.apJ.getLeft() - i;
                                if (i3 > 0 && c41531v3.apJ.getLeft() < c41531v.apJ.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > right) {
                                        c41531v2 = c41531v3;
                                        if (top < 0) {
                                            right = c41531v3.apJ.getTop() - i2;
                                            if (right > 0 && c41531v3.apJ.getTop() < c41531v.apJ.getTop()) {
                                                right = Math.abs(right);
                                                if (right > i3) {
                                                    c41531v2 = c41531v3;
                                                    if (top > 0) {
                                                        i3 = c41531v3.apJ.getBottom() - height;
                                                        if (i3 < 0 && c41531v3.apJ.getBottom() > c41531v.apJ.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > right) {
                                                                i4++;
                                                                c41531v2 = c41531v3;
                                                            }
                                                        }
                                                    }
                                                    i3 = right;
                                                    c41531v3 = c41531v2;
                                                    i4++;
                                                    c41531v2 = c41531v3;
                                                }
                                            }
                                        }
                                        right = i3;
                                        if (top > 0) {
                                        }
                                        i3 = right;
                                        c41531v3 = c41531v2;
                                        i4++;
                                        c41531v2 = c41531v3;
                                    }
                                }
                            }
                            i3 = right;
                            if (top < 0) {
                            }
                            right = i3;
                            if (top > 0) {
                            }
                            i3 = right;
                            c41531v3 = c41531v2;
                            i4++;
                            c41531v2 = c41531v3;
                        }
                    }
                }
                right = i3;
                if (left < 0) {
                }
                i3 = right;
                if (top < 0) {
                }
                right = i3;
                if (top > 0) {
                }
                i3 = right;
                c41531v3 = c41531v2;
                i4++;
                c41531v2 = c41531v3;
            }
            return c41531v2;
        }

        /* renamed from: f */
        public void mo7527f(C41531v c41531v, int i) {
        }

        /* renamed from: k */
        private int m14980k(RecyclerView recyclerView) {
            if (this.avO == -1) {
                this.avO = recyclerView.getResources().getDimensionPixelSize(C25738R.dimen.a3m);
            }
            return this.avO;
        }

        /* renamed from: a */
        public void mo7525a(RecyclerView recyclerView, C41531v c41531v) {
            avL.mo1919bZ(c41531v.apJ);
        }

        /* renamed from: a */
        public void mo7524a(Canvas canvas, RecyclerView recyclerView, C41531v c41531v, float f, float f2, int i, boolean z) {
            avL.mo1918a(canvas, recyclerView, c41531v.apJ, f, f2, i, z);
        }

        /* renamed from: d */
        public static long m14978d(RecyclerView recyclerView, int i) {
            C31879f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            } else {
                if (i == 8) {
                    return itemAnimator.aov;
                }
                return itemAnimator.aou;
            }
        }

        /* renamed from: a */
        public final int mo18509a(RecyclerView recyclerView, int i, int i2, long j) {
            float f = 1.0f;
            int k = (int) (((float) (m14980k(recyclerView) * ((int) Math.signum((float) i2)))) * avN.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (avM.getInterpolation(f) * ((float) k));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            } else {
                return interpolation;
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$4 */
    class C84604 implements Runnable {
        final /* synthetic */ int avI;
        final /* synthetic */ C8450c avK;

        C84604(C8450c c8450c, int i) {
            this.avK = c8450c;
            this.avI = i;
        }

        public final void run() {
            if (C8452a.this.aiB != null && C8452a.this.aiB.isAttachedToWindow() && !this.avK.avZ && this.avK.aoM.mo66454kj() != -1) {
                C31879f itemAnimator = C8452a.this.aiB.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.mo51945a(null)) {
                    Object obj;
                    C8452a c8452a = C8452a.this;
                    int size = c8452a.avx.size();
                    for (int i = 0; i < size; i++) {
                        if (!((C8450c) c8452a.avx.get(i)).f2410Ag) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        return;
                    }
                }
                C8452a.this.aiB.post(this);
            }
        }
    }

    public C8452a(C8457a c8457a) {
        this.avu = c8457a;
    }

    /* renamed from: a */
    private static boolean m14957a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    /* renamed from: i */
    public final void mo18502i(RecyclerView recyclerView) {
        if (this.aiB != recyclerView) {
            RecyclerView recyclerView2;
            if (this.aiB != null) {
                this.aiB.mo66354c((C25373h) this);
                this.aiB.mo66347b(this.avF);
                recyclerView2 = this.aiB;
                if (recyclerView2.anz != null) {
                    recyclerView2.anz.remove(this);
                }
                for (int size = this.avx.size() - 1; size >= 0; size--) {
                    this.avu.mo7525a(this.aiB, ((C8450c) this.avx.get(0)).aoM);
                }
                this.avx.clear();
                this.avB = null;
                this.avC = -1;
                m14959lA();
                if (this.avE != null) {
                    this.avE.avP = false;
                    this.avE = null;
                }
                if (this.avD != null) {
                    this.avD = null;
                }
            }
            this.aiB = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.avo = resources.getDimension(C25738R.dimen.a3o);
                this.avp = resources.getDimension(C25738R.dimen.a3n);
                this.arL = ViewConfiguration.get(this.aiB.getContext()).getScaledTouchSlop();
                this.aiB.mo66330a((C25373h) this);
                this.aiB.mo66331a(this.avF);
                recyclerView2 = this.aiB;
                if (recyclerView2.anz == null) {
                    recyclerView2.anz = new ArrayList();
                }
                recyclerView2.anz.add(this);
                this.avE = new C0673b();
                this.avD = new C37130c(this.aiB.getContext(), this.avE);
            }
        }
    }

    /* renamed from: f */
    private void m14958f(float[] fArr) {
        if ((this.avw & 12) != 0) {
            fArr[0] = (this.avs + this.avq) - ((float) this.avl.apJ.getLeft());
        } else {
            fArr[0] = this.avl.apJ.getTranslationX();
        }
        if ((this.avw & 3) != 0) {
            fArr[1] = (this.avt + this.avr) - ((float) this.avl.apJ.getTop());
        } else {
            fArr[1] = this.avl.apJ.getTranslationY();
        }
    }

    /* renamed from: a */
    public final void mo18494a(Canvas canvas, RecyclerView recyclerView) {
        Object obj = null;
        if (this.avl != null) {
            m14958f(this.avk);
        }
        C41531v c41531v = this.avl;
        List list = this.avx;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i);
            canvas.restoreToCount(canvas.save());
        }
        if (c41531v != null) {
            canvas.restoreToCount(canvas.save());
        }
        int i2 = size - 1;
        while (i2 >= 0) {
            Object obj2;
            C8450c c8450c = (C8450c) list.get(i2);
            if (c8450c.f2410Ag && !c8450c.avW) {
                list.remove(i2);
                obj2 = obj;
            } else if (c8450c.f2410Ag) {
                obj2 = obj;
            } else {
                obj2 = 1;
            }
            i2--;
            obj = obj2;
        }
        if (obj != null) {
            recyclerView.invalidate();
        }
    }

    /* renamed from: a */
    public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
        float f;
        float f2;
        int i;
        this.avC = -1;
        if (this.avl != null) {
            m14958f(this.avk);
            float f3 = this.avk[0];
            f = this.avk[1];
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        C8457a c8457a = this.avu;
        C41531v c41531v = this.avl;
        List list = this.avx;
        int i2 = this.avv;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= size) {
                break;
            }
            C8450c c8450c = (C8450c) list.get(i);
            if (c8450c.avQ == c8450c.avS) {
                c8450c.avX = c8450c.aoM.apJ.getTranslationX();
            } else {
                c8450c.avX = c8450c.avQ + (c8450c.awa * (c8450c.avS - c8450c.avQ));
            }
            if (c8450c.avR == c8450c.avT) {
                c8450c.avY = c8450c.aoM.apJ.getTranslationY();
            } else {
                c8450c.avY = c8450c.avR + (c8450c.awa * (c8450c.avT - c8450c.avR));
            }
            int save = canvas.save();
            c8457a.mo7524a(canvas, recyclerView, c8450c.aoM, c8450c.avX, c8450c.avY, c8450c.avv, false);
            canvas.restoreToCount(save);
            i3 = i + 1;
        }
        if (c41531v != null) {
            i = canvas.save();
            c8457a.mo7524a(canvas, recyclerView, c41531v, f2, f, i2, true);
            canvas.restoreToCount(i);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo18501e(C41531v c41531v, int i) {
        if (c41531v != this.avl || i != this.avv) {
            this.avG = Long.MIN_VALUE;
            int i2 = this.avv;
            mo18498b(c41531v, true);
            this.avv = i;
            if (i == 2) {
                this.avB = c41531v.apJ;
                if (VERSION.SDK_INT < 21) {
                    if (this.aog == null) {
                        this.aog = new C84565();
                    }
                    this.aiB.setChildDrawingOrderCallback(this.aog);
                }
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (this.avl != null) {
                C41531v c41531v2 = this.avl;
                if (c41531v2.apJ.getParent() != null) {
                    int i4;
                    if (!(i2 == 2 || this.avv == 2)) {
                        C8457a.m14977cZ(C0477s.m893T(this.aiB));
                    }
                    m14959lA();
                    if (i2 == 2) {
                        i4 = 8;
                    } else {
                        i4 = 4;
                    }
                    m14958f(this.avk);
                    C84553 c84553 = new C84553(c41531v2, i4, i2, this.avk[0], this.avk[1], 0.0f, 0.0f, 0, c41531v2);
                    c84553.avU.setDuration(C8457a.m14978d(this.aiB, i4));
                    this.avx.add(c84553);
                    c84553.aoM.mo66445ao(false);
                    c84553.avU.start();
                    obj = 1;
                } else {
                    mo18500bY(c41531v2.apJ);
                    this.avu.mo7525a(this.aiB, c41531v2);
                }
                this.avl = null;
            }
            Object obj2 = obj;
            if (c41531v != null) {
                this.avw = (C8457a.m14979j(this.aiB) & i3) >> (this.avv * 8);
                this.avs = (float) c41531v.apJ.getLeft();
                this.avt = (float) c41531v.apJ.getTop();
                this.avl = c41531v;
                if (i == 2) {
                    this.avl.apJ.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.aiB.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.avl != null);
            }
            if (obj2 == null) {
                this.aiB.getLayoutManager().aoD = true;
            }
            this.avu.mo7527f(this.avl, this.avv);
            this.aiB.invalidate();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: M */
    public final void mo18493M(C41531v c41531v) {
        if (!this.aiB.isLayoutRequested() && this.avv == 2) {
            float lC = this.avu.mo7529lC();
            int i = (int) (this.avs + this.avq);
            int i2 = (int) (this.avt + this.avr);
            if (((float) Math.abs(i2 - c41531v.apJ.getTop())) >= ((float) c41531v.apJ.getHeight()) * lC || ((float) Math.abs(i - c41531v.apJ.getLeft())) >= lC * ((float) c41531v.apJ.getWidth())) {
                if (this.avz == null) {
                    this.avz = new ArrayList();
                    this.avA = new ArrayList();
                } else {
                    this.avz.clear();
                    this.avA.clear();
                }
                int round = Math.round(this.avs + this.avq) + 0;
                int round2 = Math.round(this.avt + this.avr) + 0;
                int width = (c41531v.apJ.getWidth() + round) + 0;
                int height = (c41531v.apJ.getHeight() + round2) + 0;
                int i3 = (round + width) / 2;
                int i4 = (round2 + height) / 2;
                C17480i layoutManager = this.aiB.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = layoutManager.getChildAt(i5);
                    if (childAt != c41531v.apJ && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        C41531v aZ = this.aiB.mo66337aZ(childAt);
                        int abs = Math.abs(i3 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i4 - ((childAt.getBottom() + childAt.getTop()) / 2));
                        int i6 = (abs * abs) + (abs2 * abs2);
                        int i7 = 0;
                        int size = this.avz.size();
                        abs2 = 0;
                        while (true) {
                            abs = abs2;
                            if (abs >= size || i6 <= ((Integer) this.avA.get(abs)).intValue()) {
                                this.avz.add(i7, aZ);
                                this.avA.add(i7, Integer.valueOf(i6));
                            } else {
                                i7++;
                                abs2 = abs + 1;
                            }
                        }
                        this.avz.add(i7, aZ);
                        this.avA.add(i7, Integer.valueOf(i6));
                    }
                }
                List list = this.avz;
                if (list.size() != 0) {
                    C41531v a = C8457a.m14976a(c41531v, list, i, i2);
                    if (a == null) {
                        this.avz.clear();
                        this.avA.clear();
                        return;
                    }
                    a.mo66454kj();
                    c41531v.mo66454kj();
                    this.avu.mo7526a(c41531v, a);
                }
            }
        }
    }

    /* renamed from: bH */
    public final void mo18499bH(View view) {
        mo18500bY(view);
        C41531v aZ = this.aiB.mo66337aZ(view);
        if (aZ != null) {
            if (this.avl == null || aZ != this.avl) {
                mo18498b(aZ, false);
                if (this.avj.remove(aZ.apJ)) {
                    this.avu.mo7525a(this.aiB, aZ);
                    return;
                }
                return;
            }
            mo18501e(null, 0);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final int mo18498b(C41531v c41531v, boolean z) {
        for (int size = this.avx.size() - 1; size >= 0; size--) {
            C8450c c8450c = (C8450c) this.avx.get(size);
            if (c8450c.aoM == c41531v) {
                c8450c.avZ |= z;
                if (!c8450c.f2410Ag) {
                    c8450c.avU.cancel();
                }
                this.avx.remove(size);
                return c8450c.avV;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        rect.setEmpty();
    }

    /* renamed from: lA */
    private void m14959lA() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo18497a(int i, MotionEvent motionEvent, int i2) {
        C41531v c41531v = null;
        if (this.avl == null && i == 2 && this.avv != 2 && this.avu.mo7528lB() && this.aiB.getScrollState() != 1) {
            C17480i layoutManager = this.aiB.getLayoutManager();
            if (this.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex) - this.avm;
                float y = motionEvent.getY(findPointerIndex) - this.avn;
                x = Math.abs(x);
                y = Math.abs(y);
                if ((x >= ((float) this.arL) || y >= ((float) this.arL)) && ((x <= y || !layoutManager.mo1776iG()) && (y <= x || !layoutManager.mo1777iH()))) {
                    View k = mo18503k(motionEvent);
                    if (k != null) {
                        c41531v = this.aiB.mo66337aZ(k);
                    }
                }
            }
            if (c41531v != null) {
                C8457a.m14979j(this.aiB);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: k */
    public final View mo18503k(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.avl != null) {
            View view = this.avl.apJ;
            if (C8452a.m14957a(view, x, y, this.avs + this.avq, this.avt + this.avr)) {
                return view;
            }
        }
        for (int size = this.avx.size() - 1; size >= 0; size--) {
            C8450c c8450c = (C8450c) this.avx.get(size);
            View view2 = c8450c.aoM.apJ;
            if (C8452a.m14957a(view2, x, y, c8450c.avX, c8450c.avY)) {
                return view2;
            }
        }
        return this.aiB.mo66441x(x, y);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18496a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.avq = x - this.avm;
        this.avr = y - this.avn;
        if ((i & 4) == 0) {
            this.avq = Math.max(0.0f, this.avq);
        }
        if ((i & 8) == 0) {
            this.avq = Math.min(0.0f, this.avq);
        }
        if ((i & 1) == 0) {
            this.avr = Math.max(0.0f, this.avr);
        }
        if ((i & 2) == 0) {
            this.avr = Math.min(0.0f, this.avr);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bY */
    public final void mo18500bY(View view) {
        if (view == this.avB) {
            this.avB = null;
            if (this.aog != null) {
                this.aiB.setChildDrawingOrderCallback(null);
            }
        }
    }
}
