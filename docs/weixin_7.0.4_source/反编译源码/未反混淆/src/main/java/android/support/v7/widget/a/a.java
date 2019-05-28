package android.support.v7.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.mm.R;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.List;

public final class a extends h implements j {
    RecyclerView aiB;
    private d aog = null;
    private int arL;
    private List<Integer> avA;
    View avB = null;
    int avC = -1;
    android.support.v4.view.c avD;
    private b avE;
    private final l avF = new l() {
        public final boolean h(MotionEvent motionEvent) {
            a.this.avD.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                a.this.mActivePointerId = motionEvent.getPointerId(0);
                a.this.avm = motionEvent.getX();
                a.this.avn = motionEvent.getY();
                a aVar = a.this;
                if (aVar.mVelocityTracker != null) {
                    aVar.mVelocityTracker.recycle();
                }
                aVar.mVelocityTracker = VelocityTracker.obtain();
                if (a.this.avl == null) {
                    c cVar;
                    a aVar2 = a.this;
                    if (!aVar2.avx.isEmpty()) {
                        View k = aVar2.k(motionEvent);
                        for (int size = aVar2.avx.size() - 1; size >= 0; size--) {
                            cVar = (c) aVar2.avx.get(size);
                            if (cVar.aoM.apJ == k) {
                                break;
                            }
                        }
                    }
                    cVar = null;
                    if (cVar != null) {
                        a aVar3 = a.this;
                        aVar3.avm -= cVar.avX;
                        aVar3 = a.this;
                        aVar3.avn -= cVar.avY;
                        a.this.b(cVar.aoM, true);
                        if (a.this.avj.remove(cVar.aoM.apJ)) {
                            a.this.avu.a(a.this.aiB, cVar.aoM);
                        }
                        a.this.e(cVar.aoM, cVar.avv);
                        a.this.a(motionEvent, a.this.avw, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                a.this.mActivePointerId = -1;
                a.this.e(null, 0);
            } else if (a.this.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(a.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    a.this.a(actionMasked, motionEvent, findPointerIndex);
                }
            }
            if (a.this.mVelocityTracker != null) {
                a.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (a.this.avl != null) {
                return true;
            }
            return false;
        }

        public final void i(MotionEvent motionEvent) {
            int i = 0;
            a.this.avD.onTouchEvent(motionEvent);
            if (a.this.mVelocityTracker != null) {
                a.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (a.this.mActivePointerId != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(a.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    a.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                v vVar = a.this.avl;
                if (vVar != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                a.this.a(motionEvent, a.this.avw, findPointerIndex);
                                a.this.M(vVar);
                                a.this.aiB.removeCallbacks(a.this.avy);
                                a.this.avy.run();
                                a.this.aiB.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (a.this.mVelocityTracker != null) {
                                a.this.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 6:
                            actionMasked = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionMasked) == a.this.mActivePointerId) {
                                if (actionMasked == 0) {
                                    i = 1;
                                }
                                a.this.mActivePointerId = motionEvent.getPointerId(i);
                                a.this.a(motionEvent, a.this.avw, actionMasked);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    a.this.e(null, 0);
                    a.this.mActivePointerId = -1;
                }
            }
        }

        public final void ab(boolean z) {
            if (z) {
                a.this.e(null, 0);
            }
        }
    };
    long avG;
    final List<View> avj = new ArrayList();
    private final float[] avk = new float[2];
    v avl = null;
    float avm;
    float avn;
    float avo;
    float avp;
    float avq;
    float avr;
    float avs;
    float avt;
    a avu;
    int avv = 0;
    int avw;
    List<c> avx = new ArrayList();
    final Runnable avy = new Runnable() {
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
            if (a.this.avl != null) {
                a aVar = a.this;
                if (aVar.avl != null) {
                    long j;
                    int paddingLeft;
                    int i;
                    int paddingTop;
                    int a;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aVar.avG == Long.MIN_VALUE) {
                        j = 0;
                    } else {
                        j = currentTimeMillis - aVar.avG;
                    }
                    i layoutManager = aVar.aiB.getLayoutManager();
                    if (aVar.oT == null) {
                        aVar.oT = new Rect();
                    }
                    layoutManager.g(aVar.avl.apJ, aVar.oT);
                    if (layoutManager.iG()) {
                        int i2 = (int) (aVar.avs + aVar.avq);
                        paddingLeft = (i2 - aVar.oT.left) - aVar.aiB.getPaddingLeft();
                        if (aVar.avq >= 0.0f || paddingLeft >= 0) {
                            if (aVar.avq > 0.0f) {
                                paddingLeft = ((i2 + aVar.avl.apJ.getWidth()) + aVar.oT.right) - (aVar.aiB.getWidth() - aVar.aiB.getPaddingRight());
                            }
                        }
                        if (layoutManager.iH()) {
                            a aVar2;
                            RecyclerView recyclerView;
                            int width;
                            i = (int) (aVar.avt + aVar.avr);
                            paddingTop = (i - aVar.oT.top) - aVar.aiB.getPaddingTop();
                            if (aVar.avr >= 0.0f || paddingTop >= 0) {
                                if (aVar.avr > 0.0f) {
                                    paddingTop = ((i + aVar.avl.apJ.getHeight()) + aVar.oT.bottom) - (aVar.aiB.getHeight() - aVar.aiB.getPaddingBottom());
                                }
                            }
                            if (paddingLeft != 0) {
                                aVar2 = aVar.avu;
                                recyclerView = aVar.aiB;
                                width = aVar.avl.apJ.getWidth();
                                aVar.aiB.getWidth();
                                a = aVar2.a(recyclerView, width, paddingLeft, j);
                            } else {
                                a = paddingLeft;
                            }
                            if (paddingTop != 0) {
                                aVar2 = aVar.avu;
                                recyclerView = aVar.aiB;
                                width = aVar.avl.apJ.getHeight();
                                aVar.aiB.getHeight();
                                i = aVar2.a(recyclerView, width, paddingTop, j);
                            } else {
                                i = paddingTop;
                            }
                            if (!(a == 0 && i == 0)) {
                                if (aVar.avG == Long.MIN_VALUE) {
                                    aVar.avG = currentTimeMillis;
                                }
                                aVar.aiB.scrollBy(a, i);
                                obj = 1;
                                if (obj == null) {
                                    if (a.this.avl != null) {
                                        a.this.M(a.this.avl);
                                    }
                                    a.this.aiB.removeCallbacks(a.this.avy);
                                    s.b(a.this.aiB, (Runnable) this);
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
                        if (aVar.avG == Long.MIN_VALUE) {
                        }
                        aVar.aiB.scrollBy(a, i);
                        obj = 1;
                        if (obj == null) {
                        }
                    }
                    paddingLeft = 0;
                    if (layoutManager.iH()) {
                    }
                    paddingTop = 0;
                    if (paddingLeft != 0) {
                    }
                    if (paddingTop != 0) {
                    }
                    if (aVar.avG == Long.MIN_VALUE) {
                    }
                    aVar.aiB.scrollBy(a, i);
                    obj = 1;
                    if (obj == null) {
                    }
                }
                aVar.avG = Long.MIN_VALUE;
                if (obj == null) {
                }
            }
        }
    };
    private List<v> avz;
    int mActivePointerId = -1;
    VelocityTracker mVelocityTracker;
    Rect oT;

    class b extends SimpleOnGestureListener {
        boolean avP = true;

        b() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (this.avP) {
                View k = a.this.k(motionEvent);
                if (k != null) {
                    v aZ = a.this.aiB.aZ(k);
                    if (aZ != null) {
                        a.j(a.this.aiB);
                        if (motionEvent.getPointerId(0) == a.this.mActivePointerId) {
                            int findPointerIndex = motionEvent.findPointerIndex(a.this.mActivePointerId);
                            float x = motionEvent.getX(findPointerIndex);
                            float y = motionEvent.getY(findPointerIndex);
                            a.this.avm = x;
                            a.this.avn = y;
                            a aVar = a.this;
                            a.this.avr = 0.0f;
                            aVar.avq = 0.0f;
                            a.this.e(aZ, 2);
                        }
                    }
                }
            }
        }
    }

    static class c implements AnimatorListener {
        boolean Ag = false;
        final v aoM;
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

        c(v vVar, int i, int i2, float f, float f2, float f3, float f4) {
            this.avv = i2;
            this.avV = i;
            this.aoM = vVar;
            this.avQ = f;
            this.avR = f2;
            this.avS = f3;
            this.avT = f4;
            this.avU = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.avU.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.awa = valueAnimator.getAnimatedFraction();
                }
            });
            this.avU.setTarget(vVar.apJ);
            this.avU.addListener(this);
            this.awa = 0.0f;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.Ag) {
                this.aoM.ao(true);
            }
            this.Ag = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
            this.awa = 1.0f;
        }
    }

    /* renamed from: android.support.v7.widget.a.a$3 */
    class AnonymousClass3 extends c {
        final /* synthetic */ int avI = 0;
        final /* synthetic */ v avJ;

        AnonymousClass3(v vVar, int i, int i2, float f, float f2, float f3, float f4, int i3, v vVar2) {
            this.avJ = vVar2;
            super(vVar, i, i2, f, f2, 0.0f, 0.0f);
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.avZ) {
                if (this.avI <= 0) {
                    a.this.avu.a(a.this.aiB, this.avJ);
                } else {
                    a.this.avj.add(this.avJ.apJ);
                    this.avW = true;
                    if (this.avI > 0) {
                        a aVar = a.this;
                        aVar.aiB.post(new AnonymousClass4(this, this.avI));
                    }
                }
                if (a.this.avB == this.avJ.apJ) {
                    a.this.bY(this.avJ.apJ);
                }
            }
        }
    }

    public static abstract class a {
        private static final b avL;
        private static final Interpolator avM = new Interpolator() {
            public final float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        };
        private static final Interpolator avN = new Interpolator() {
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        };
        private int avO = -1;

        public abstract boolean a(v vVar, v vVar2);

        static {
            if (VERSION.SDK_INT >= 21) {
                avL = new a();
            } else {
                avL = new b();
            }
        }

        public static int cZ(int i) {
            if (i == 0) {
            }
            return 983055;
        }

        static int j(RecyclerView recyclerView) {
            s.T(recyclerView);
            return 983055;
        }

        public boolean lB() {
            return true;
        }

        public float lC() {
            return 0.5f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static v a(v vVar, List<v> list, int i, int i2) {
            int width = i + vVar.apJ.getWidth();
            int height = i2 + vVar.apJ.getHeight();
            int i3 = -1;
            int left = i - vVar.apJ.getLeft();
            int top = i2 - vVar.apJ.getTop();
            int size = list.size();
            int i4 = 0;
            v vVar2 = null;
            while (i4 < size) {
                int right;
                v vVar3 = (v) list.get(i4);
                if (left > 0) {
                    right = vVar3.apJ.getRight() - width;
                    if (right < 0 && vVar3.apJ.getRight() > vVar.apJ.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            vVar2 = vVar3;
                            if (left < 0) {
                                i3 = vVar3.apJ.getLeft() - i;
                                if (i3 > 0 && vVar3.apJ.getLeft() < vVar.apJ.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > right) {
                                        vVar2 = vVar3;
                                        if (top < 0) {
                                            right = vVar3.apJ.getTop() - i2;
                                            if (right > 0 && vVar3.apJ.getTop() < vVar.apJ.getTop()) {
                                                right = Math.abs(right);
                                                if (right > i3) {
                                                    vVar2 = vVar3;
                                                    if (top > 0) {
                                                        i3 = vVar3.apJ.getBottom() - height;
                                                        if (i3 < 0 && vVar3.apJ.getBottom() > vVar.apJ.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > right) {
                                                                i4++;
                                                                vVar2 = vVar3;
                                                            }
                                                        }
                                                    }
                                                    i3 = right;
                                                    vVar3 = vVar2;
                                                    i4++;
                                                    vVar2 = vVar3;
                                                }
                                            }
                                        }
                                        right = i3;
                                        if (top > 0) {
                                        }
                                        i3 = right;
                                        vVar3 = vVar2;
                                        i4++;
                                        vVar2 = vVar3;
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
                            vVar3 = vVar2;
                            i4++;
                            vVar2 = vVar3;
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
                vVar3 = vVar2;
                i4++;
                vVar2 = vVar3;
            }
            return vVar2;
        }

        public void f(v vVar, int i) {
        }

        private int k(RecyclerView recyclerView) {
            if (this.avO == -1) {
                this.avO = recyclerView.getResources().getDimensionPixelSize(R.dimen.a3m);
            }
            return this.avO;
        }

        public void a(RecyclerView recyclerView, v vVar) {
            avL.bZ(vVar.apJ);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, v vVar, float f, float f2, int i, boolean z) {
            avL.a(canvas, recyclerView, vVar.apJ, f, f2, i, z);
        }

        public static long d(RecyclerView recyclerView, int i) {
            f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            } else {
                if (i == 8) {
                    return itemAnimator.aov;
                }
                return itemAnimator.aou;
            }
        }

        public final int a(RecyclerView recyclerView, int i, int i2, long j) {
            float f = 1.0f;
            int k = (int) (((float) (k(recyclerView) * ((int) Math.signum((float) i2)))) * avN.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
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
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int avI;
        final /* synthetic */ c avK;

        AnonymousClass4(c cVar, int i) {
            this.avK = cVar;
            this.avI = i;
        }

        public final void run() {
            if (a.this.aiB != null && a.this.aiB.isAttachedToWindow() && !this.avK.avZ && this.avK.aoM.kj() != -1) {
                f itemAnimator = a.this.aiB.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.a(null)) {
                    Object obj;
                    a aVar = a.this;
                    int size = aVar.avx.size();
                    for (int i = 0; i < size; i++) {
                        if (!((c) aVar.avx.get(i)).Ag) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        return;
                    }
                }
                a.this.aiB.post(this);
            }
        }
    }

    public a(a aVar) {
        this.avu = aVar;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public final void i(RecyclerView recyclerView) {
        if (this.aiB != recyclerView) {
            RecyclerView recyclerView2;
            if (this.aiB != null) {
                this.aiB.c((h) this);
                this.aiB.b(this.avF);
                recyclerView2 = this.aiB;
                if (recyclerView2.anz != null) {
                    recyclerView2.anz.remove(this);
                }
                for (int size = this.avx.size() - 1; size >= 0; size--) {
                    this.avu.a(this.aiB, ((c) this.avx.get(0)).aoM);
                }
                this.avx.clear();
                this.avB = null;
                this.avC = -1;
                lA();
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
                this.avo = resources.getDimension(R.dimen.a3o);
                this.avp = resources.getDimension(R.dimen.a3n);
                this.arL = ViewConfiguration.get(this.aiB.getContext()).getScaledTouchSlop();
                this.aiB.a((h) this);
                this.aiB.a(this.avF);
                recyclerView2 = this.aiB;
                if (recyclerView2.anz == null) {
                    recyclerView2.anz = new ArrayList();
                }
                recyclerView2.anz.add(this);
                this.avE = new b();
                this.avD = new android.support.v4.view.c(this.aiB.getContext(), this.avE);
            }
        }
    }

    private void f(float[] fArr) {
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

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        Object obj = null;
        if (this.avl != null) {
            f(this.avk);
        }
        v vVar = this.avl;
        List list = this.avx;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i);
            canvas.restoreToCount(canvas.save());
        }
        if (vVar != null) {
            canvas.restoreToCount(canvas.save());
        }
        int i2 = size - 1;
        while (i2 >= 0) {
            Object obj2;
            c cVar = (c) list.get(i2);
            if (cVar.Ag && !cVar.avW) {
                list.remove(i2);
                obj2 = obj;
            } else if (cVar.Ag) {
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

    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        float f;
        float f2;
        int i;
        this.avC = -1;
        if (this.avl != null) {
            f(this.avk);
            float f3 = this.avk[0];
            f = this.avk[1];
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        a aVar = this.avu;
        v vVar = this.avl;
        List list = this.avx;
        int i2 = this.avv;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= size) {
                break;
            }
            c cVar = (c) list.get(i);
            if (cVar.avQ == cVar.avS) {
                cVar.avX = cVar.aoM.apJ.getTranslationX();
            } else {
                cVar.avX = cVar.avQ + (cVar.awa * (cVar.avS - cVar.avQ));
            }
            if (cVar.avR == cVar.avT) {
                cVar.avY = cVar.aoM.apJ.getTranslationY();
            } else {
                cVar.avY = cVar.avR + (cVar.awa * (cVar.avT - cVar.avR));
            }
            int save = canvas.save();
            aVar.a(canvas, recyclerView, cVar.aoM, cVar.avX, cVar.avY, cVar.avv, false);
            canvas.restoreToCount(save);
            i3 = i + 1;
        }
        if (vVar != null) {
            i = canvas.save();
            aVar.a(canvas, recyclerView, vVar, f2, f, i2, true);
            canvas.restoreToCount(i);
        }
    }

    /* Access modifiers changed, original: final */
    public final void e(v vVar, int i) {
        if (vVar != this.avl || i != this.avv) {
            this.avG = Long.MIN_VALUE;
            int i2 = this.avv;
            b(vVar, true);
            this.avv = i;
            if (i == 2) {
                this.avB = vVar.apJ;
                if (VERSION.SDK_INT < 21) {
                    if (this.aog == null) {
                        this.aog = new d() {
                            public final int az(int i, int i2) {
                                if (a.this.avB == null) {
                                    return i2;
                                }
                                int i3 = a.this.avC;
                                if (i3 == -1) {
                                    i3 = a.this.aiB.indexOfChild(a.this.avB);
                                    a.this.avC = i3;
                                }
                                if (i2 == i - 1) {
                                    return i3;
                                }
                                return i2 >= i3 ? i2 + 1 : i2;
                            }
                        };
                    }
                    this.aiB.setChildDrawingOrderCallback(this.aog);
                }
            }
            int i3 = (1 << ((i * 8) + 8)) - 1;
            Object obj = null;
            if (this.avl != null) {
                v vVar2 = this.avl;
                if (vVar2.apJ.getParent() != null) {
                    int i4;
                    if (!(i2 == 2 || this.avv == 2)) {
                        a.cZ(s.T(this.aiB));
                    }
                    lA();
                    if (i2 == 2) {
                        i4 = 8;
                    } else {
                        i4 = 4;
                    }
                    f(this.avk);
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(vVar2, i4, i2, this.avk[0], this.avk[1], 0.0f, 0.0f, 0, vVar2);
                    anonymousClass3.avU.setDuration(a.d(this.aiB, i4));
                    this.avx.add(anonymousClass3);
                    anonymousClass3.aoM.ao(false);
                    anonymousClass3.avU.start();
                    obj = 1;
                } else {
                    bY(vVar2.apJ);
                    this.avu.a(this.aiB, vVar2);
                }
                this.avl = null;
            }
            Object obj2 = obj;
            if (vVar != null) {
                this.avw = (a.j(this.aiB) & i3) >> (this.avv * 8);
                this.avs = (float) vVar.apJ.getLeft();
                this.avt = (float) vVar.apJ.getTop();
                this.avl = vVar;
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
            this.avu.f(this.avl, this.avv);
            this.aiB.invalidate();
        }
    }

    /* Access modifiers changed, original: final */
    public final void M(v vVar) {
        if (!this.aiB.isLayoutRequested() && this.avv == 2) {
            float lC = this.avu.lC();
            int i = (int) (this.avs + this.avq);
            int i2 = (int) (this.avt + this.avr);
            if (((float) Math.abs(i2 - vVar.apJ.getTop())) >= ((float) vVar.apJ.getHeight()) * lC || ((float) Math.abs(i - vVar.apJ.getLeft())) >= lC * ((float) vVar.apJ.getWidth())) {
                if (this.avz == null) {
                    this.avz = new ArrayList();
                    this.avA = new ArrayList();
                } else {
                    this.avz.clear();
                    this.avA.clear();
                }
                int round = Math.round(this.avs + this.avq) + 0;
                int round2 = Math.round(this.avt + this.avr) + 0;
                int width = (vVar.apJ.getWidth() + round) + 0;
                int height = (vVar.apJ.getHeight() + round2) + 0;
                int i3 = (round + width) / 2;
                int i4 = (round2 + height) / 2;
                i layoutManager = this.aiB.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = layoutManager.getChildAt(i5);
                    if (childAt != vVar.apJ && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        v aZ = this.aiB.aZ(childAt);
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
                    v a = a.a(vVar, list, i, i2);
                    if (a == null) {
                        this.avz.clear();
                        this.avA.clear();
                        return;
                    }
                    a.kj();
                    vVar.kj();
                    this.avu.a(vVar, a);
                }
            }
        }
    }

    public final void bH(View view) {
        bY(view);
        v aZ = this.aiB.aZ(view);
        if (aZ != null) {
            if (this.avl == null || aZ != this.avl) {
                b(aZ, false);
                if (this.avj.remove(aZ.apJ)) {
                    this.avu.a(this.aiB, aZ);
                    return;
                }
                return;
            }
            e(null, 0);
        }
    }

    /* Access modifiers changed, original: final */
    public final int b(v vVar, boolean z) {
        for (int size = this.avx.size() - 1; size >= 0; size--) {
            c cVar = (c) this.avx.get(size);
            if (cVar.aoM == vVar) {
                cVar.avZ |= z;
                if (!cVar.Ag) {
                    cVar.avU.cancel();
                }
                this.avx.remove(size);
                return cVar.avV;
            }
        }
        return 0;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.setEmpty();
    }

    private void lA() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean a(int i, MotionEvent motionEvent, int i2) {
        v vVar = null;
        if (this.avl == null && i == 2 && this.avv != 2 && this.avu.lB() && this.aiB.getScrollState() != 1) {
            i layoutManager = this.aiB.getLayoutManager();
            if (this.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex) - this.avm;
                float y = motionEvent.getY(findPointerIndex) - this.avn;
                x = Math.abs(x);
                y = Math.abs(y);
                if ((x >= ((float) this.arL) || y >= ((float) this.arL)) && ((x <= y || !layoutManager.iG()) && (y <= x || !layoutManager.iH()))) {
                    View k = k(motionEvent);
                    if (k != null) {
                        vVar = this.aiB.aZ(k);
                    }
                }
            }
            if (vVar != null) {
                a.j(this.aiB);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final View k(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.avl != null) {
            View view = this.avl.apJ;
            if (a(view, x, y, this.avs + this.avq, this.avt + this.avr)) {
                return view;
            }
        }
        for (int size = this.avx.size() - 1; size >= 0; size--) {
            c cVar = (c) this.avx.get(size);
            View view2 = cVar.aoM.apJ;
            if (a(view2, x, y, cVar.avX, cVar.avY)) {
                return view2;
            }
        }
        return this.aiB.x(x, y);
    }

    /* Access modifiers changed, original: final */
    public final void a(MotionEvent motionEvent, int i, int i2) {
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
    public final void bY(View view) {
        if (view == this.avB) {
            this.avB = null;
            if (this.aog != null) {
                this.aiB.setChildDrawingOrderCallback(null);
            }
        }
    }
}
