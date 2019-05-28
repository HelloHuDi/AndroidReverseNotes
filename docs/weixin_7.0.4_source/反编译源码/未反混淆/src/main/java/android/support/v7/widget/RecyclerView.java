package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements android.support.v4.view.j {
    private static final int[] amS = new int[]{16843830};
    private static final int[] amT = new int[]{16842987};
    static final boolean amU;
    static final boolean amV;
    static final boolean amW;
    private static final boolean amX;
    private static final boolean amY;
    private static final boolean amZ;
    private static final Class<?>[] ana = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final Interpolator aom = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private final int[] Rd;
    private final int[] Re;
    a Yq;
    boolean anA;
    boolean anB;
    private int anC;
    private int anD;
    private e anE;
    private EdgeEffect anF;
    private EdgeEffect anG;
    private EdgeEffect anH;
    private EdgeEffect anI;
    f anJ;
    private int anK;
    private int anL;
    private int anM;
    private int anN;
    private int anO;
    private k anP;
    private final int anQ;
    private final int anR;
    private float anS;
    private float anT;
    private boolean anU;
    final u anV;
    af anW;
    a anX;
    final s anY;
    private m anZ;
    private final q anb;
    final o anc;
    private SavedState and;
    f ane;
    v anf;
    final bj ang;
    boolean anh;
    final Runnable ani;
    final RectF anj;
    i ank;
    p anl;
    public final ArrayList<h> anm;
    private final ArrayList<l> ann;
    private l ano;
    boolean anp;
    boolean anq;
    boolean anr;
    boolean ans;
    private int ant;
    boolean anu;
    public boolean anv;
    private boolean anw;
    private int anx;
    boolean any;
    public List<j> anz;
    private List<m> aoa;
    boolean aob;
    boolean aoc;
    private b aod;
    boolean aoe;
    ao aof;
    private d aog;
    private final int[] aoh;
    private android.support.v4.view.k aoi;
    private final int[] aoj;
    final List<v> aok;
    private Runnable aol;
    private final b aon;
    private final AccessibilityManager mP;
    private int mScrollState;
    final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final Rect qT;

    class g implements b {
        g() {
        }

        public final void n(v vVar) {
            boolean z = true;
            vVar.ao(true);
            if (vVar.apP != null && vVar.apQ == null) {
                vVar.apP = null;
            }
            vVar.apQ = null;
            if (!v.z(vVar)) {
                boolean z2;
                RecyclerView recyclerView = RecyclerView.this;
                View view = vVar.apJ;
                recyclerView.jl();
                v vVar2 = recyclerView.anf;
                int indexOfChild = vVar2.aha.indexOfChild(view);
                if (indexOfChild == -1) {
                    vVar2.aX(view);
                    z2 = true;
                } else if (vVar2.ahb.get(indexOfChild)) {
                    vVar2.ahb.bJ(indexOfChild);
                    vVar2.aX(view);
                    vVar2.aha.removeViewAt(indexOfChild);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    v bn = RecyclerView.bn(view);
                    recyclerView.anc.t(bn);
                    recyclerView.anc.s(bn);
                }
                if (z2) {
                    z = false;
                }
                recyclerView.ak(z);
                if (!z2 && vVar.ks()) {
                    RecyclerView.this.removeDetachedView(vVar.apJ, false);
                }
            }
        }
    }

    public interface p {
    }

    class q extends c {
        q() {
        }

        public final void onChanged() {
            RecyclerView.this.T(null);
            RecyclerView.this.anY.apu = true;
            RecyclerView.this.am(true);
            if (!RecyclerView.this.ane.hw()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0023, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0025;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(int i, int i2, Object obj) {
            Object obj2 = 1;
            RecyclerView.this.T(null);
            f fVar = RecyclerView.this.ane;
            if (i2 > 0) {
                fVar.aeX.add(fVar.a(4, i, i2, obj));
                fVar.afd |= 4;
            }
            obj2 = null;
            if (obj2 != null) {
                kd();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0022, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0024;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void aw(int i, int i2) {
            int i3 = 1;
            RecyclerView.this.T(null);
            f fVar = RecyclerView.this.ane;
            if (i2 > 0) {
                fVar.aeX.add(fVar.a(1, i, i2, null));
                fVar.afd |= 1;
            }
            i3 = 0;
            if (i3 != 0) {
                kd();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0023, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0025;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ax(int i, int i2) {
            Object obj = 1;
            RecyclerView.this.T(null);
            f fVar = RecyclerView.this.ane;
            if (i2 > 0) {
                fVar.aeX.add(fVar.a(2, i, i2, null));
                fVar.afd |= 2;
            }
            obj = null;
            if (obj != null) {
                kd();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0024, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0026;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ay(int i, int i2) {
            Object obj = 1;
            RecyclerView.this.T(null);
            f fVar = RecyclerView.this.ane;
            if (i != i2) {
                fVar.aeX.add(fVar.a(8, i, i2, null));
                fVar.afd |= 8;
            }
            obj = null;
            if (obj != null) {
                kd();
            }
        }

        private void kd() {
            if (RecyclerView.amW && RecyclerView.this.anq && RecyclerView.this.anp) {
                android.support.v4.view.s.b(RecyclerView.this, RecyclerView.this.ani);
                return;
            }
            RecyclerView.this.any = true;
            RecyclerView.this.requestLayout();
        }
    }

    public static class e {
        protected static EdgeEffect d(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class i {
        protected RecyclerView aiB;
        v anf;
        bi aoA = new bi(this.aoy);
        bi aoB = new bi(this.aoz);
        r aoC;
        public boolean aoD = false;
        protected boolean aoE = false;
        protected boolean aoF = true;
        boolean aoG = true;
        int aoH;
        boolean aoI;
        protected int aoJ;
        protected int aoK;
        private final b aoy = new b() {
            public final View getChildAt(int i) {
                return i.this.getChildAt(i);
            }

            public final int jY() {
                return i.this.getPaddingLeft();
            }

            public final int jZ() {
                return i.this.mWidth - i.this.getPaddingRight();
            }

            public final int bF(View view) {
                return i.bx(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int bG(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + i.bz(view);
            }
        };
        private final b aoz = new b() {
            public final View getChildAt(int i) {
                return i.this.getChildAt(i);
            }

            public final int jY() {
                return i.this.getPaddingTop();
            }

            public final int jZ() {
                return i.this.mHeight - i.this.getPaddingBottom();
            }

            public final int bF(View view) {
                return i.by(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int bG(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + i.bA(view);
            }
        };
        public int mHeight;
        public int mWidth;
        boolean pv = false;

        public interface a {
            void T(int i, int i2);
        }

        public abstract LayoutParams iA();

        /* Access modifiers changed, original: final */
        public final void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.aiB = null;
                this.anf = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.aiB = recyclerView;
                this.anf = recyclerView.anf;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.aoJ = ErrorDialogData.SUPPRESSED;
            this.aoK = ErrorDialogData.SUPPRESSED;
        }

        /* Access modifiers changed, original: final */
        public final void aA(int i, int i2) {
            this.mWidth = MeasureSpec.getSize(i);
            this.aoJ = MeasureSpec.getMode(i);
            if (this.aoJ == 0 && !RecyclerView.amV) {
                this.mWidth = 0;
            }
            this.mHeight = MeasureSpec.getSize(i2);
            this.aoK = MeasureSpec.getMode(i2);
            if (this.aoK == 0 && !RecyclerView.amV) {
                this.mHeight = 0;
            }
        }

        /* Access modifiers changed, original: final */
        public final void aB(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.aiB.an(i, i2);
                return;
            }
            int i3 = android.support.v4.widget.j.INVALID_ID;
            int i4 = android.support.v4.widget.j.INVALID_ID;
            int i5 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i6 = BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.aiB.mTempRect;
                RecyclerView.e(childAt, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i4) {
                    i4 = rect.right;
                }
                if (rect.top < i5) {
                    i5 = rect.top;
                }
                if (rect.bottom > i3) {
                    i3 = rect.bottom;
                }
            }
            this.aiB.mTempRect.set(i6, i5, i4, i3);
            a(this.aiB.mTempRect, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            setMeasuredDimension(l(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), android.support.v4.view.s.Z(this.aiB)), l(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), android.support.v4.view.s.aa(this.aiB)));
        }

        public final void requestLayout() {
            if (this.aiB != null) {
                this.aiB.requestLayout();
            }
        }

        public static int l(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case android.support.v4.widget.j.INVALID_ID /*-2147483648*/:
                    return Math.min(size, Math.max(i2, i3));
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void T(String str) {
            if (this.aiB != null) {
                this.aiB.T(str);
            }
        }

        @Deprecated
        public final void jU() {
            this.aoE = true;
        }

        public boolean iF() {
            return this.aoE;
        }

        public boolean iE() {
            return false;
        }

        public final void an(boolean z) {
            if (z != this.aoG) {
                this.aoG = z;
                this.aoH = 0;
                if (this.aiB != null) {
                    this.aiB.anc.kb();
                }
            }
        }

        public void a(int i, int i2, s sVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        /* Access modifiers changed, original: final */
        public final void e(RecyclerView recyclerView) {
            this.pv = true;
            f(recyclerView);
        }

        /* Access modifiers changed, original: final */
        public final void b(RecyclerView recyclerView, o oVar) {
            this.pv = false;
            a(recyclerView, oVar);
        }

        public final boolean removeCallbacks(Runnable runnable) {
            if (this.aiB != null) {
                return this.aiB.removeCallbacks(runnable);
            }
            return false;
        }

        public void f(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, o oVar) {
        }

        public final boolean getClipToPadding() {
            return this.aiB != null && this.aiB.anh;
        }

        public void c(o oVar, s sVar) {
        }

        public void a(s sVar) {
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int a(int i, o oVar, s sVar) {
            return 0;
        }

        public int b(int i, o oVar, s sVar) {
            return 0;
        }

        public boolean iG() {
            return false;
        }

        public boolean iH() {
            return false;
        }

        public void bY(int i) {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public final void a(r rVar) {
            if (!(this.aoC == null || rVar == this.aoC || !this.aoC.apg)) {
                this.aoC.stop();
            }
            this.aoC = rVar;
            r rVar2 = this.aoC;
            rVar2.aiB = this.aiB;
            rVar2.amP = this;
            if (rVar2.ape == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            rVar2.aiB.anY.ape = rVar2.ape;
            rVar2.apg = true;
            rVar2.apf = true;
            rVar2.aph = rVar2.aiB.ank.bW(rVar2.ape);
            rVar2.aiB.anV.ke();
        }

        public final boolean jV() {
            return this.aoC != null && this.aoC.apg;
        }

        public final void z(View view, int i) {
            c(view, i, true);
        }

        public final void addView(View view, int i) {
            c(view, i, false);
        }

        private void c(View view, int i, boolean z) {
            v bn = RecyclerView.bn(view);
            if (z || bn.isRemoved()) {
                this.aiB.ang.J(bn);
            } else {
                this.aiB.ang.K(bn);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (bn.kn() || bn.kl()) {
                if (bn.kl()) {
                    bn.km();
                } else {
                    bn.ko();
                }
                this.anf.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.aiB) {
                int indexOfChild = this.anf.indexOfChild(view);
                if (i == -1) {
                    i = this.anf.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.aiB.indexOfChild(view) + this.aiB.ji());
                } else if (indexOfChild != i) {
                    this.aiB.ank.aC(indexOfChild, i);
                }
            } else {
                this.anf.a(view, i, false);
                layoutParams.aoN = true;
                if (this.aoC != null && this.aoC.apg) {
                    this.aoC.bL(view);
                }
            }
            if (layoutParams.aoO) {
                bn.apJ.invalidate();
                layoutParams.aoO = false;
            }
        }

        private void removeView(View view) {
            v vVar = this.anf;
            int indexOfChild = vVar.aha.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (vVar.ahb.bJ(indexOfChild)) {
                    vVar.aX(view);
                }
                vVar.aha.removeViewAt(indexOfChild);
            }
        }

        private void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.anf.removeViewAt(i);
            }
        }

        public final void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.anf.removeViewAt(childCount);
            }
        }

        public static int bt(View view) {
            return ((LayoutParams) view.getLayoutParams()).aoM.ki();
        }

        public final View bl(View view) {
            if (this.aiB == null) {
                return null;
            }
            View bl = this.aiB.bl(view);
            if (bl == null || this.anf.aY(bl)) {
                return null;
            }
            return bl;
        }

        public View bW(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                v bn = RecyclerView.bn(childAt);
                if (bn != null && bn.ki() == i && !bn.kh() && (this.aiB.anY.apv || !bn.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        private void cj(int i) {
            getChildAt(i);
            this.anf.detachViewFromParent(i);
        }

        private void A(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            v bn = RecyclerView.bn(view);
            if (bn.isRemoved()) {
                this.aiB.ang.J(bn);
            } else {
                this.aiB.ang.K(bn);
            }
            this.anf.a(view, i, layoutParams, bn.isRemoved());
        }

        private void aC(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.aiB.toString());
            }
            cj(i);
            A(childAt, i2);
        }

        public final void a(View view, o oVar) {
            removeView(view);
            oVar.bI(view);
        }

        public final void a(int i, o oVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            oVar.bI(childAt);
        }

        public final int getChildCount() {
            return this.anf != null ? this.anf.getChildCount() : 0;
        }

        public final View getChildAt(int i) {
            return this.anf != null ? this.anf.getChildAt(i) : null;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            return this.aiB != null ? this.aiB.getPaddingLeft() : 0;
        }

        public int getPaddingTop() {
            return this.aiB != null ? this.aiB.getPaddingTop() : 0;
        }

        public int getPaddingRight() {
            return this.aiB != null ? this.aiB.getPaddingRight() : 0;
        }

        public int getPaddingBottom() {
            return this.aiB != null ? this.aiB.getPaddingBottom() : 0;
        }

        public int getPaddingStart() {
            return this.aiB != null ? android.support.v4.view.s.W(this.aiB) : 0;
        }

        public int getPaddingEnd() {
            return this.aiB != null ? android.support.v4.view.s.X(this.aiB) : 0;
        }

        public final View getFocusedChild() {
            if (this.aiB == null) {
                return null;
            }
            View focusedChild = this.aiB.getFocusedChild();
            if (focusedChild == null || this.anf.aY(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public final int getItemCount() {
            a adapter = this.aiB != null ? this.aiB.getAdapter() : null;
            return adapter != null ? adapter.getItemCount() : 0;
        }

        public void ck(int i) {
            if (this.aiB != null) {
                RecyclerView recyclerView = this.aiB;
                int childCount = recyclerView.anf.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.anf.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void cl(int i) {
            if (this.aiB != null) {
                RecyclerView recyclerView = this.aiB;
                int childCount = recyclerView.anf.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.anf.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        public final void b(o oVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                a(oVar, childCount, getChildAt(childCount));
            }
        }

        private void a(o oVar, int i, View view) {
            v bn = RecyclerView.bn(view);
            if (!bn.kh()) {
                if (!bn.kq() || bn.isRemoved() || this.aiB.Yq.aoq) {
                    cj(i);
                    oVar.bK(view);
                    this.aiB.ang.K(bn);
                    return;
                }
                removeViewAt(i);
                oVar.s(bn);
            }
        }

        /* Access modifiers changed, original: final */
        public final void c(o oVar) {
            int size = oVar.aoV.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((v) oVar.aoV.get(i)).apJ;
                v bn = RecyclerView.bn(view);
                if (!bn.kh()) {
                    bn.ao(false);
                    if (bn.ks()) {
                        this.aiB.removeDetachedView(view, false);
                    }
                    if (this.aiB.anJ != null) {
                        this.aiB.anJ.d(bn);
                    }
                    bn.ao(true);
                    oVar.bJ(view);
                }
            }
            oVar.aoV.clear();
            if (oVar.aoW != null) {
                oVar.aoW.clear();
            }
            if (size > 0) {
                this.aiB.invalidate();
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.aoF && m(view.getMeasuredWidth(), i, layoutParams.width) && m(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* Access modifiers changed, original: final */
        public final boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.aoF && m(view.getWidth(), i, layoutParams.width) && m(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        private static boolean m(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case android.support.v4.widget.j.INVALID_ID /*-2147483648*/:
                    if (size >= i) {
                        return true;
                    }
                    return false;
                case 0:
                    return true;
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    if (size == i) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        public final void bu(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect bq = this.aiB.bq(view);
            int i = (bq.left + bq.right) + 0;
            int i2 = (bq.bottom + bq.top) + 0;
            i = c(this.mWidth, this.aoJ, i + (((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, iG());
            i2 = c(this.mHeight, this.aoK, i2 + (((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, iH());
            if (b(view, i, i2, layoutParams)) {
                view.measure(i, i2);
            }
        }

        public static int c(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = ErrorDialogData.SUPPRESSED;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case android.support.v4.widget.j.INVALID_ID /*-2147483648*/:
                        case ErrorDialogData.SUPPRESSED /*1073741824*/:
                            break;
                        default:
                            i2 = 0;
                            max = 0;
                            break;
                    }
                } else {
                    if (i4 == -2) {
                        max = 0;
                        i2 = 0;
                    }
                    i2 = 0;
                    max = 0;
                }
            } else if (i4 >= 0) {
                i2 = ErrorDialogData.SUPPRESSED;
                max = i4;
            } else if (i4 != -1) {
                if (i4 == -2) {
                    if (i2 == android.support.v4.widget.j.INVALID_ID || i2 == ErrorDialogData.SUPPRESSED) {
                        i2 = android.support.v4.widget.j.INVALID_ID;
                    }
                    i2 = 0;
                }
                i2 = 0;
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i2);
        }

        public static int bv(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ala;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public static int bw(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ala;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public static void j(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ala;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public static void k(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.ala;
            view.layout((rect.left + i) + layoutParams.leftMargin, (rect.top + i2) + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public final void f(View view, Rect rect) {
            Rect rect2 = ((LayoutParams) view.getLayoutParams()).ala;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            if (this.aiB != null) {
                Matrix matrix = view.getMatrix();
                if (!(matrix == null || matrix.isIdentity())) {
                    RectF rectF = this.aiB.anj;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public static void d(View view, Rect rect) {
            RecyclerView.e(view, rect);
        }

        public static int bx(View view) {
            return view.getLeft() - bD(view);
        }

        public static int by(View view) {
            return view.getTop() - bB(view);
        }

        public static int bz(View view) {
            return view.getRight() + bE(view);
        }

        public static int bA(View view) {
            return view.getBottom() + bC(view);
        }

        public final void g(View view, Rect rect) {
            if (this.aiB == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.aiB.bq(view));
            }
        }

        public static int bB(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.top;
        }

        public static int bC(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.bottom;
        }

        public static int bD(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.left;
        }

        public static int bE(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.right;
        }

        public View a(View view, int i, o oVar, s sVar) {
            return null;
        }

        private int[] h(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.mWidth - getPaddingRight();
            int paddingBottom = this.mHeight - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - paddingLeft);
            int min2 = Math.min(0, top - paddingTop);
            int max = Math.max(0, width - paddingRight);
            paddingBottom = Math.max(0, height - paddingBottom);
            if (android.support.v4.view.s.T(this.aiB) == 1) {
                if (max == 0) {
                    max = Math.max(min, width - paddingRight);
                }
                min = max;
            } else {
                if (min != 0) {
                    max = min;
                } else {
                    max = Math.min(left - paddingLeft, max);
                }
                min = max;
            }
            if (min2 != 0) {
                max = min2;
            } else {
                max = Math.min(top - paddingTop, paddingBottom);
            }
            iArr[0] = min;
            iArr[1] = max;
            return iArr;
        }

        public final boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] h = h(view, rect);
            int i = h[0];
            int i2 = h[1];
            if (z2 && !f(recyclerView, i, i2)) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.a(i, i2, null);
            }
            return true;
        }

        private boolean f(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.mWidth - getPaddingRight();
            int paddingBottom = this.mHeight - getPaddingBottom();
            Rect rect = this.aiB.mTempRect;
            RecyclerView.e(focusedChild, rect);
            if (rect.left - i >= paddingRight || rect.right - i <= paddingLeft || rect.top - i2 >= paddingBottom || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        public void jW() {
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void a(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public void d(RecyclerView recyclerView, int i, int i2) {
        }

        public void g(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            g(recyclerView, i, i2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int f(s sVar) {
            return 0;
        }

        public int d(s sVar) {
            return 0;
        }

        public int h(s sVar) {
            return 0;
        }

        public int g(s sVar) {
            return 0;
        }

        public int e(s sVar) {
            return 0;
        }

        public int i(s sVar) {
            return 0;
        }

        public final void aD(int i, int i2) {
            this.aiB.an(i, i2);
        }

        public final void setMeasuredDimension(int i, int i2) {
            this.aiB.setMeasuredDimension(i, i2);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        /* Access modifiers changed, original: final */
        public final void jX() {
            if (this.aoC != null) {
                this.aoC.stop();
            }
        }

        public void cm(int i) {
        }

        public final void d(o oVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.bn(getChildAt(childCount)).kh()) {
                    a(childCount, oVar);
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            if (this.aiB != null && accessibilityEvent != null) {
                if (!(this.aiB.canScrollVertically(1) || this.aiB.canScrollVertically(-1) || this.aiB.canScrollHorizontally(-1) || this.aiB.canScrollHorizontally(1))) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.aiB.Yq != null) {
                    accessibilityEvent.setItemCount(this.aiB.Yq.getItemCount());
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(View view, android.support.v4.view.a.b bVar) {
            v bn = RecyclerView.bn(view);
            if (bn != null && !bn.isRemoved() && !this.anf.aY(bn.apJ)) {
                a(this.aiB.anc, this.aiB.anY, view, bVar);
            }
        }

        public void a(o oVar, s sVar, View view, android.support.v4.view.a.b bVar) {
            int bt;
            int bt2 = iH() ? bt(view) : 0;
            if (iG()) {
                bt = bt(view);
            } else {
                bt = 0;
            }
            bVar.H(android.support.v4.view.a.b.c.b(bt2, 1, bt, 1, false));
        }

        public int a(o oVar, s sVar) {
            if (this.aiB == null || this.aiB.Yq == null || !iH()) {
                return 1;
            }
            return this.aiB.Yq.getItemCount();
        }

        public int b(o oVar, s sVar) {
            if (this.aiB == null || this.aiB.Yq == null || !iG()) {
                return 1;
            }
            return this.aiB.Yq.getItemCount();
        }

        /* Access modifiers changed, original: final */
        public final void g(RecyclerView recyclerView) {
            aA(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), ErrorDialogData.SUPPRESSED));
        }

        /* Access modifiers changed, original: 0000 */
        public boolean iL() {
            return false;
        }

        public final void addView(View view) {
            c(view, -1, false);
        }
    }

    public static class n {
        SparseArray<a> aoP = new SparseArray();
        int aoQ = 0;

        static class a {
            final ArrayList<v> aoR = new ArrayList();
            int aoS = 5;
            long aoT = 0;
            long aoU = 0;

            a() {
            }
        }

        public final void aF(int i, int i2) {
            a co = co(i);
            co.aoS = i2;
            ArrayList arrayList = co.aoR;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public final v cn(int i) {
            a aVar = (a) this.aoP.get(i);
            if (aVar == null || aVar.aoR.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.aoR;
            return (v) arrayList.remove(arrayList.size() - 1);
        }

        static long c(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* Access modifiers changed, original: final */
        public final void d(int i, long j) {
            a co = co(i);
            co.aoT = c(co.aoT, j);
        }

        /* Access modifiers changed, original: final */
        public final boolean b(int i, long j, long j2) {
            long j3 = co(i).aoT;
            return j3 == 0 || j3 + j < j2;
        }

        /* Access modifiers changed, original: final */
        public final void ka() {
            this.aoQ++;
        }

        /* Access modifiers changed, original: final */
        public final void detach() {
            this.aoQ--;
        }

        /* Access modifiers changed, original: final */
        public final a co(int i) {
            a aVar = (a) this.aoP.get(i);
            if (aVar != null) {
                return aVar;
            }
            aVar = new a();
            this.aoP.put(i, aVar);
            return aVar;
        }

        public final void p(v vVar) {
            int i = vVar.apN;
            ArrayList arrayList = co(i).aoR;
            if (((a) this.aoP.get(i)).aoS > arrayList.size()) {
                vVar.resetInternal();
                arrayList.add(vVar);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        Parcelable apd;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = i.class.getClassLoader();
            }
            this.apd = parcel.readParcelable(classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.apd, 0);
        }
    }

    public static abstract class h {
        public void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            view.getLayoutParams();
            rect.set(0, 0, 0, 0);
        }
    }

    public final class o {
        final ArrayList<v> aoV = new ArrayList();
        ArrayList<v> aoW = null;
        final ArrayList<v> aoX = new ArrayList();
        final List<v> aoY = Collections.unmodifiableList(this.aoV);
        int aoZ = 2;
        int apa = 2;
        n apb;
        t apc;

        public final void clear() {
            this.aoV.clear();
            kc();
        }

        /* Access modifiers changed, original: final */
        public final void kb() {
            this.apa = (RecyclerView.this.ank != null ? RecyclerView.this.ank.aoH : 0) + this.aoZ;
            for (int size = this.aoX.size() - 1; size >= 0 && this.aoX.size() > this.apa; size--) {
                cs(size);
            }
        }

        private boolean q(v vVar) {
            if (vVar.isRemoved()) {
                return RecyclerView.this.anY.apv;
            }
            if (vVar.mPosition < 0 || vVar.mPosition >= RecyclerView.this.Yq.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.ji());
            } else if (!RecyclerView.this.anY.apv && RecyclerView.this.Yq.getItemViewType(vVar.mPosition) != vVar.apN) {
                return false;
            } else {
                if (!RecyclerView.this.Yq.aoq) {
                    return true;
                }
                if (vVar.apM == RecyclerView.this.Yq.getItemId(vVar.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        private boolean a(v vVar, int i, int i2, long j) {
            long j2;
            vVar.apZ = RecyclerView.this;
            int i3 = vVar.apN;
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE) {
                boolean z;
                j2 = this.apb.co(i3).aoU;
                if (j2 == 0 || j2 + nanoTime < j) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            a aVar = RecyclerView.this.Yq;
            vVar.mPosition = i;
            if (aVar.aoq) {
                vVar.apM = aVar.getItemId(i);
            }
            vVar.setFlags(1, com.tencent.mm.plugin.appbrand.jsapi.j.g.CTRL_INDEX);
            android.support.v4.os.f.beginSection("RV OnBindView");
            aVar.a(vVar, i, vVar.kv());
            vVar.ku();
            android.view.ViewGroup.LayoutParams layoutParams = vVar.apJ.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).aoN = true;
            }
            android.support.v4.os.f.endSection();
            j2 = RecyclerView.this.getNanoTime() - nanoTime;
            a co = this.apb.co(vVar.apN);
            co.aoU = n.c(co.aoU, j2);
            if (RecyclerView.this.jx()) {
                View view = vVar.apJ;
                if (android.support.v4.view.s.S(view) == 0) {
                    android.support.v4.view.s.o(view, 1);
                }
                if (!android.support.v4.view.s.P(view)) {
                    vVar.addFlags(16384);
                    android.support.v4.view.s.a(view, RecyclerView.this.aof.aqa);
                }
            }
            if (RecyclerView.this.anY.apv) {
                vVar.apO = i2;
            }
            return true;
        }

        public final int cp(int i) {
            if (i >= 0 && i < RecyclerView.this.anY.getItemCount()) {
                return !RecyclerView.this.anY.apv ? i : RecyclerView.this.ane.bA(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.anY.getItemCount() + RecyclerView.this.ji());
            }
        }

        public final View cq(int i) {
            return cr(i);
        }

        /* Access modifiers changed, original: final */
        public final View cr(int i) {
            return e(i, Long.MAX_VALUE).apJ;
        }

        /* Access modifiers changed, original: final */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x010a  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0120  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final v e(int i, long j) {
            boolean z = true;
            if (i < 0 || i >= RecyclerView.this.anY.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.anY.getItemCount() + RecyclerView.this.ji());
            }
            v ct;
            boolean z2;
            v cu;
            boolean z3;
            LayoutParams layoutParams;
            if (RecyclerView.this.anY.apv) {
                ct = ct(i);
                z2 = ct != null;
            } else {
                ct = null;
                z2 = false;
            }
            if (ct == null) {
                cu = cu(i);
                if (cu != null) {
                    if (q(cu)) {
                        z2 = true;
                    } else {
                        cu.addFlags(4);
                        if (cu.kl()) {
                            RecyclerView.this.removeDetachedView(cu.apJ, false);
                            cu.km();
                        } else if (cu.kn()) {
                            cu.ko();
                        }
                        s(cu);
                        cu = null;
                    }
                }
            } else {
                cu = ct;
            }
            if (cu == null) {
                int bA = RecyclerView.this.ane.bA(i);
                if (bA < 0 || bA >= RecyclerView.this.Yq.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + bA + ").state:" + RecyclerView.this.anY.getItemCount() + RecyclerView.this.ji());
                }
                boolean z4;
                int itemViewType = RecyclerView.this.Yq.getItemViewType(bA);
                if (RecyclerView.this.Yq.aoq) {
                    cu = b(RecyclerView.this.Yq.getItemId(bA), itemViewType);
                    if (cu != null) {
                        cu.mPosition = bA;
                        z4 = true;
                        if (cu == null) {
                            cu = getRecycledViewPool().cn(itemViewType);
                            if (cu != null) {
                                cu.resetInternal();
                                if (RecyclerView.amU) {
                                    r(cu);
                                }
                            }
                        }
                        if (cu == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j != Long.MAX_VALUE && !this.apb.b(itemViewType, nanoTime, j)) {
                                return null;
                            }
                            cu = RecyclerView.this.Yq.c(RecyclerView.this, itemViewType);
                            if (RecyclerView.amX) {
                                RecyclerView br = RecyclerView.br(cu.apJ);
                                if (br != null) {
                                    cu.apK = new WeakReference(br);
                                }
                            }
                            this.apb.d(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                        }
                        ct = cu;
                        z3 = z4;
                    }
                }
                z4 = z2;
                if (cu == null) {
                }
                if (cu == null) {
                }
                ct = cu;
                z3 = z4;
            } else {
                ct = cu;
                z3 = z2;
            }
            if (z3 && !RecyclerView.this.anY.apv && ct.cx(Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                ct.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                if (RecyclerView.this.anY.apy) {
                    RecyclerView.this.a(ct, RecyclerView.this.anJ.a(RecyclerView.this.anY, ct, f.l(ct) | 4096, ct.kv()));
                }
            }
            if (RecyclerView.this.anY.apv && ct.isBound()) {
                ct.apO = i;
                z2 = false;
            } else if (!ct.isBound() || ct.kr() || ct.kq()) {
                z2 = a(ct, RecyclerView.this.ane.bA(i), i, j);
            } else {
                z2 = false;
            }
            android.view.ViewGroup.LayoutParams layoutParams2 = ct.apJ.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                ct.apJ.setLayoutParams(layoutParams);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                ct.apJ.setLayoutParams(layoutParams);
            }
            layoutParams.aoM = ct;
            if (!(z3 && r2)) {
                z = false;
            }
            layoutParams.aoO = z;
            return ct;
        }

        private void r(v vVar) {
            if (vVar.apJ instanceof ViewGroup) {
                d((ViewGroup) vVar.apJ, false);
            }
        }

        private void d(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    d((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public final void bI(View view) {
            v bn = RecyclerView.bn(view);
            if (bn.ks()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (bn.kl()) {
                bn.km();
            } else if (bn.kn()) {
                bn.ko();
            }
            s(bn);
        }

        private void kc() {
            for (int size = this.aoX.size() - 1; size >= 0; size--) {
                cs(size);
            }
            this.aoX.clear();
            if (RecyclerView.amX) {
                RecyclerView.this.anX.ig();
            }
        }

        /* Access modifiers changed, original: final */
        public final void cs(int i) {
            a((v) this.aoX.get(i), true);
            this.aoX.remove(i);
        }

        /* Access modifiers changed, original: final */
        public final void s(v vVar) {
            boolean z = true;
            if (vVar.kl() || vVar.apJ.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + vVar.kl() + " isAttached:" + (vVar.apJ.getParent() != null) + RecyclerView.this.ji());
            } else if (vVar.ks()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.ji());
            } else if (vVar.kh()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.ji());
            } else {
                boolean z2;
                boolean v = v.v(vVar);
                if (vVar.kw()) {
                    if (this.apa <= 0 || vVar.cx(com.tencent.mm.plugin.appbrand.jsapi.g.t.CTRL_INDEX)) {
                        z2 = false;
                    } else {
                        int size = this.aoX.size();
                        if (size >= this.apa && size > 0) {
                            cs(0);
                            size--;
                        }
                        if (RecyclerView.amX && size > 0 && !RecyclerView.this.anX.bM(vVar.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.anX.bM(((v) this.aoX.get(i)).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.aoX.add(size, vVar);
                        z2 = true;
                    }
                    if (z2) {
                        z = false;
                    } else {
                        a(vVar, true);
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                RecyclerView.this.ang.L(vVar);
                if (!z2 && !z && v) {
                    vVar.apZ = null;
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(v vVar, boolean z) {
            RecyclerView.h(vVar);
            if (vVar.cx(16384)) {
                vVar.setFlags(0, 16384);
                android.support.v4.view.s.a(vVar.apJ, null);
            }
            if (z) {
                u(vVar);
            }
            vVar.apZ = null;
            getRecycledViewPool().p(vVar);
        }

        /* Access modifiers changed, original: final */
        public final void bJ(View view) {
            v bn = RecyclerView.bn(view);
            bn.apV = null;
            bn.apW = false;
            bn.ko();
            s(bn);
        }

        /* Access modifiers changed, original: final */
        public final void bK(View view) {
            v bn = RecyclerView.bn(view);
            if (!bn.cx(12) && bn.kx()) {
                boolean z;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.anJ == null || recyclerView.anJ.a(bn, bn.kv())) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (this.aoW == null) {
                        this.aoW = new ArrayList();
                    }
                    bn.a(this, true);
                    this.aoW.add(bn);
                    return;
                }
            }
            if (!bn.kq() || bn.isRemoved() || RecyclerView.this.Yq.aoq) {
                bn.a(this, false);
                this.aoV.add(bn);
                return;
            }
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.ji());
        }

        /* Access modifiers changed, original: final */
        public final void t(v vVar) {
            if (vVar.apW) {
                this.aoW.remove(vVar);
            } else {
                this.aoV.remove(vVar);
            }
            vVar.apV = null;
            vVar.apW = false;
            vVar.ko();
        }

        private v ct(int i) {
            int i2 = 0;
            if (this.aoW != null) {
                int size = this.aoW.size();
                if (size != 0) {
                    v vVar;
                    int i3 = 0;
                    while (i3 < size) {
                        vVar = (v) this.aoW.get(i3);
                        if (vVar.kn() || vVar.ki() != i) {
                            i3++;
                        } else {
                            vVar.addFlags(32);
                            return vVar;
                        }
                    }
                    if (RecyclerView.this.Yq.aoq) {
                        int N = RecyclerView.this.ane.N(i, 0);
                        if (N > 0 && N < RecyclerView.this.Yq.getItemCount()) {
                            long itemId = RecyclerView.this.Yq.getItemId(N);
                            while (i2 < size) {
                                vVar = (v) this.aoW.get(i2);
                                if (vVar.kn() || vVar.apM != itemId) {
                                    i2++;
                                } else {
                                    vVar.addFlags(32);
                                    return vVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private v cu(int i) {
            v vVar;
            View view;
            int i2 = 0;
            int size = this.aoV.size();
            int i3 = 0;
            while (i3 < size) {
                vVar = (v) this.aoV.get(i3);
                if (vVar.kn() || vVar.ki() != i || vVar.kq() || (!RecyclerView.this.anY.apv && vVar.isRemoved())) {
                    i3++;
                } else {
                    vVar.addFlags(32);
                    return vVar;
                }
            }
            v vVar2 = RecyclerView.this.anf;
            int size2 = vVar2.ahc.size();
            for (i3 = 0; i3 < size2; i3++) {
                View view2 = (View) vVar2.ahc.get(i3);
                v aZ = vVar2.aha.aZ(view2);
                if (aZ.ki() == i && !aZ.kq() && !aZ.isRemoved()) {
                    view = view2;
                    break;
                }
            }
            view = null;
            if (view != null) {
                vVar = RecyclerView.bn(view);
                v vVar3 = RecyclerView.this.anf;
                i2 = vVar3.aha.indexOfChild(view);
                if (i2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
                } else if (vVar3.ahb.get(i2)) {
                    vVar3.ahb.clear(i2);
                    vVar3.aX(view);
                    int indexOfChild = RecyclerView.this.anf.indexOfChild(view);
                    if (indexOfChild == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + vVar + RecyclerView.this.ji());
                    }
                    RecyclerView.this.anf.detachViewFromParent(indexOfChild);
                    bK(view);
                    vVar.addFlags(8224);
                    return vVar;
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
                }
            }
            i3 = this.aoX.size();
            while (i2 < i3) {
                vVar = (v) this.aoX.get(i2);
                if (vVar.kq() || vVar.ki() != i) {
                    i2++;
                } else {
                    this.aoX.remove(i2);
                    return vVar;
                }
            }
            return null;
        }

        private v b(long j, int i) {
            int size;
            v vVar;
            for (size = this.aoV.size() - 1; size >= 0; size--) {
                vVar = (v) this.aoV.get(size);
                if (vVar.apM == j && !vVar.kn()) {
                    if (i == vVar.apN) {
                        vVar.addFlags(32);
                        if (!vVar.isRemoved() || RecyclerView.this.anY.apv) {
                            return vVar;
                        }
                        vVar.setFlags(2, 14);
                        return vVar;
                    }
                    this.aoV.remove(size);
                    RecyclerView.this.removeDetachedView(vVar.apJ, false);
                    bJ(vVar.apJ);
                }
            }
            size = this.aoX.size() - 1;
            while (size >= 0) {
                vVar = (v) this.aoX.get(size);
                if (vVar.apM != j) {
                    size--;
                } else if (i == vVar.apN) {
                    this.aoX.remove(size);
                    return vVar;
                } else {
                    cs(size);
                    return null;
                }
            }
            return null;
        }

        private void u(v vVar) {
            if (RecyclerView.this.Yq != null) {
                RecyclerView.this.Yq.a(vVar);
            }
            if (RecyclerView.this.anY != null) {
                RecyclerView.this.ang.L(vVar);
            }
        }

        /* Access modifiers changed, original: final */
        public final n getRecycledViewPool() {
            if (this.apb == null) {
                this.apb = new n();
            }
            return this.apb;
        }

        /* Access modifiers changed, original: final */
        public final void jN() {
            int size = this.aoX.size();
            for (int i = 0; i < size; i++) {
                v vVar = (v) this.aoX.get(i);
                if (vVar != null) {
                    vVar.addFlags(6);
                    vVar.O(null);
                }
            }
            if (RecyclerView.this.Yq == null || !RecyclerView.this.Yq.aoq) {
                kc();
            }
        }

        /* Access modifiers changed, original: final */
        public final void jM() {
            int i;
            int i2 = 0;
            int size = this.aoX.size();
            for (i = 0; i < size; i++) {
                ((v) this.aoX.get(i)).kf();
            }
            size = this.aoV.size();
            for (i = 0; i < size; i++) {
                ((v) this.aoV.get(i)).kf();
            }
            if (this.aoW != null) {
                i = this.aoW.size();
                while (i2 < i) {
                    ((v) this.aoW.get(i2)).kf();
                    i2++;
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void jK() {
            int size = this.aoX.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) ((v) this.aoX.get(i)).apJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.aoN = true;
                }
            }
        }
    }

    public static abstract class f {
        b aor = null;
        private ArrayList<a> aos = new ArrayList();
        public long aot = 200;
        public long aou = 200;
        public long aov = 200;
        public long aow = 200;

        public interface a {
            void jT();
        }

        interface b {
            void n(v vVar);
        }

        public static class c {
            public int aox;
            public int bottom;
            public int left;
            public int right;
            public int top;

            public c c(v vVar, int i) {
                View view = vVar.apJ;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public abstract boolean a(v vVar, v vVar2, c cVar, c cVar2);

        public abstract void d(v vVar);

        public abstract boolean d(v vVar, c cVar, c cVar2);

        public abstract boolean e(v vVar, c cVar, c cVar2);

        public abstract boolean f(v vVar, c cVar, c cVar2);

        public abstract void hX();

        public abstract void hZ();

        public abstract boolean isRunning();

        static int l(v vVar) {
            int A = vVar.Dj & 14;
            if (vVar.kq()) {
                return 4;
            }
            if ((A & 4) != 0) {
                return A;
            }
            int i = vVar.apL;
            int kj = vVar.kj();
            if (i == -1 || kj == -1 || i == kj) {
                return A;
            }
            return A | 2048;
        }

        public final void m(v vVar) {
            n(vVar);
            if (this.aor != null) {
                this.aor.n(vVar);
            }
        }

        public void n(v vVar) {
        }

        public final boolean a(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (isRunning) {
                    this.aos.add(aVar);
                } else {
                    aVar.jT();
                }
            }
            return isRunning;
        }

        public boolean o(v vVar) {
            return true;
        }

        public boolean a(v vVar, List<Object> list) {
            return o(vVar);
        }

        public final void jS() {
            int size = this.aos.size();
            for (int i = 0; i < size; i++) {
                ((a) this.aos.get(i)).jT();
            }
            this.aos.clear();
        }

        public c a(s sVar, v vVar, int i, List<Object> list) {
            return new c().c(vVar, 0);
        }
    }

    public static class s {
        int apA;
        long apB;
        int apC;
        int apD;
        int apE;
        int ape = -1;
        private SparseArray<Object> apo;
        int apq = 0;
        int apr = 0;
        int aps = 1;
        int apt = 0;
        boolean apu = false;
        public boolean apv = false;
        boolean apw = false;
        boolean apx = false;
        boolean apy = false;
        boolean apz = false;

        /* Access modifiers changed, original: final */
        public final void cw(int i) {
            if ((this.aps & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.aps));
            }
        }

        public final int getItemCount() {
            return this.apv ? this.apq - this.apr : this.apt;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.ape + ", mData=" + this.apo + ", mItemCount=" + this.apt + ", mIsMeasuring=" + this.apx + ", mPreviousLayoutItemCount=" + this.apq + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.apr + ", mStructureChanged=" + this.apu + ", mInPreLayout=" + this.apv + ", mRunSimpleAnimations=" + this.apy + ", mRunPredictiveAnimations=" + this.apz + '}';
        }
    }

    public static abstract class t {
    }

    class u implements Runnable {
        int apF;
        int apG;
        private boolean apH = false;
        private boolean apI = false;
        Interpolator mInterpolator = RecyclerView.aom;
        OverScroller qN;

        u() {
            this.qN = new OverScroller(RecyclerView.this.getContext(), RecyclerView.aom);
        }

        public final void run() {
            if (RecyclerView.this.ank == null) {
                stop();
                return;
            }
            this.apI = false;
            this.apH = true;
            RecyclerView.this.jk();
            OverScroller overScroller = this.qN;
            r rVar = RecyclerView.this.ank.aoC;
            if (overScroller.computeScrollOffset()) {
                int i;
                int i2;
                int a;
                int i3;
                int i4;
                int i5;
                int[] b = RecyclerView.this.Re;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.apF;
                int i7 = currY - this.apG;
                this.apF = currX;
                this.apG = currY;
                if (RecyclerView.this.a(i6, i7, b, null, 1)) {
                    i = i7 - b[1];
                    i2 = i6 - b[0];
                } else {
                    i = i7;
                    i2 = i6;
                }
                if (RecyclerView.this.Yq != null) {
                    RecyclerView.this.jl();
                    RecyclerView.this.jw();
                    android.support.v4.os.f.beginSection("RV Scroll");
                    RecyclerView.this.m(RecyclerView.this.anY);
                    if (i2 != 0) {
                        a = RecyclerView.this.ank.a(i2, RecyclerView.this.anc, RecyclerView.this.anY);
                        i3 = i2 - a;
                    } else {
                        i3 = 0;
                        a = 0;
                    }
                    if (i != 0) {
                        i6 = RecyclerView.this.ank.b(i, RecyclerView.this.anc, RecyclerView.this.anY);
                        i4 = i - i6;
                        i7 = i6;
                    } else {
                        i4 = 0;
                        i7 = 0;
                    }
                    android.support.v4.os.f.endSection();
                    RecyclerView.this.jP();
                    RecyclerView.this.al(true);
                    RecyclerView.this.ak(false);
                    if (!(rVar == null || rVar.apf || !rVar.apg)) {
                        i6 = RecyclerView.this.anY.getItemCount();
                        if (i6 == 0) {
                            rVar.stop();
                            i5 = i4;
                            i6 = a;
                        } else {
                            if (rVar.ape >= i6) {
                                rVar.ape = i6 - 1;
                            }
                            r.a(rVar, i2 - i3, i - i4);
                        }
                    }
                    i5 = i4;
                    i6 = a;
                } else {
                    i5 = 0;
                    i3 = 0;
                    i7 = 0;
                    i6 = 0;
                }
                if (!RecyclerView.this.anm.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.al(i2, i);
                }
                if (!(RecyclerView.this.a(i6, i7, i3, i5, null, 1) || (i3 == 0 && i5 == 0))) {
                    int i8;
                    a = (int) overScroller.getCurrVelocity();
                    if (i3 != currX) {
                        i4 = i3 < 0 ? -a : i3 > 0 ? a : 0;
                        i8 = i4;
                    } else {
                        i8 = 0;
                    }
                    if (i5 == currY) {
                        a = 0;
                    } else if (i5 < 0) {
                        a = -a;
                    } else if (i5 <= 0) {
                        a = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.am(i8, a);
                    }
                    if ((i8 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (a != 0 || i5 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (!(i6 == 0 && i7 == 0)) {
                    RecyclerView.this.aq(i6, i7);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                Object obj = (i != 0 && RecyclerView.this.ank.iH() && i7 == i) ? 1 : null;
                Object obj2 = (i2 != 0 && RecyclerView.this.ank.iG() && i6 == i2) ? 1 : null;
                obj2 = (!(i2 == 0 && i == 0) && obj2 == null && obj == null) ? null : 1;
                if (overScroller.isFinished() || (obj2 == null && !RecyclerView.this.getScrollingChildHelper().aI(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.amX) {
                        RecyclerView.this.anX.ig();
                    }
                    RecyclerView.this.aJ(1);
                } else {
                    ke();
                    if (RecyclerView.this.anW != null) {
                        RecyclerView.this.anW.b(RecyclerView.this, i2, i);
                    }
                }
            }
            if (rVar != null) {
                if (rVar.apf) {
                    r.a(rVar, 0, 0);
                }
                if (!this.apI) {
                    rVar.stop();
                }
            }
            this.apH = false;
            if (this.apI) {
                ke();
            }
        }

        /* Access modifiers changed, original: final */
        public final void ke() {
            if (this.apH) {
                this.apI = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            android.support.v4.view.s.b(RecyclerView.this, (Runnable) this);
        }

        /* Access modifiers changed, original: final */
        public final void aG(int i, int i2) {
            n(i, i2, aH(i, i2));
        }

        private static float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        private int aH(int i, int i2) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i3 = width / 2;
            float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i3)) + ((float) i3);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) sqrt))) * 4;
            } else {
                if (obj != null) {
                    round = abs;
                } else {
                    round = abs2;
                }
                round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        public final void n(int i, int i2, int i3) {
            b(i, i2, i3, RecyclerView.aom);
        }

        public final void a(int i, int i2, Interpolator interpolator) {
            int aH = aH(i, i2);
            if (interpolator == null) {
                interpolator = RecyclerView.aom;
            }
            b(i, i2, aH, interpolator);
        }

        public final void b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.qN = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.apG = 0;
            this.apF = 0;
            this.qN.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.qN.computeScrollOffset();
            }
            ke();
        }

        public final void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.qN.abortAnimation();
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        final Rect ala = new Rect();
        public v aoM;
        boolean aoN = true;
        boolean aoO = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface l {
        void ab(boolean z);

        boolean h(MotionEvent motionEvent);

        void i(MotionEvent motionEvent);
    }

    public static abstract class r {
        RecyclerView aiB;
        i amP;
        public int ape = -1;
        boolean apf;
        boolean apg;
        View aph;
        private final a api = new a();

        public static class a {
            private int apj;
            private int apk;
            int apl;
            private boolean apm;
            private int apn;
            private int mDuration;
            private Interpolator mInterpolator;

            public a() {
                this((byte) 0);
            }

            private a(byte b) {
                this.apl = -1;
                this.apm = false;
                this.apn = 0;
                this.apj = 0;
                this.apk = 0;
                this.mDuration = android.support.v4.widget.j.INVALID_ID;
                this.mInterpolator = null;
            }

            /* Access modifiers changed, original: final */
            public final void h(RecyclerView recyclerView) {
                if (this.apl >= 0) {
                    int i = this.apl;
                    this.apl = -1;
                    recyclerView.cd(i);
                    this.apm = false;
                } else if (this.apm) {
                    validate();
                    if (this.mInterpolator != null) {
                        recyclerView.anV.b(this.apj, this.apk, this.mDuration, this.mInterpolator);
                    } else if (this.mDuration == android.support.v4.widget.j.INVALID_ID) {
                        recyclerView.anV.aG(this.apj, this.apk);
                    } else {
                        recyclerView.anV.n(this.apj, this.apk, this.mDuration);
                    }
                    this.apn++;
                    this.apm = false;
                } else {
                    this.apn = 0;
                }
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.mDuration <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public final void a(int i, int i2, int i3, Interpolator interpolator) {
                this.apj = i;
                this.apk = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.apm = true;
            }
        }

        public interface b {
            PointF bX(int i);
        }

        public abstract void a(int i, int i2, a aVar);

        public abstract void a(View view, a aVar);

        public abstract void onStop();

        public final void cv(int i) {
            this.ape = i;
        }

        /* Access modifiers changed, original: protected|final */
        public final void stop() {
            if (this.apg) {
                this.apg = false;
                onStop();
                this.aiB.anY.ape = -1;
                this.aph = null;
                this.ape = -1;
                this.apf = false;
                i.a(this.amP, this);
                this.amP = null;
                this.aiB = null;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void bL(View view) {
            if (RecyclerView.bp(view) == this.ape) {
                this.aph = view;
            }
        }
    }

    public static abstract class a<VH extends v> {
        public final b aop = new b();
        protected boolean aoq = false;

        public abstract VH a(ViewGroup viewGroup, int i);

        public abstract void a(VH vh, int i);

        public abstract int getItemCount();

        public void a(VH vh, int i, List<Object> list) {
            a((v) vh, i);
        }

        public final VH c(ViewGroup viewGroup, int i) {
            try {
                android.support.v4.os.f.beginSection("RV CreateView");
                VH a = a(viewGroup, i);
                if (a.apJ.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                a.apN = i;
                return a;
            } finally {
                android.support.v4.os.f.endSection();
            }
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public long getItemId(int i) {
            return -1;
        }

        public void a(VH vh) {
        }

        public void k(VH vh) {
        }

        public final void a(c cVar) {
            this.aop.registerObserver(cVar);
        }

        public final void b(c cVar) {
            this.aop.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.aop.notifyChanged();
        }

        public final void cg(int i) {
            this.aop.ar(i, 1);
        }

        public final void b(int i, Object obj) {
            this.aop.c(i, 1, obj);
        }

        public final void ar(int i, int i2) {
            this.aop.ar(i, i2);
        }

        public final void c(int i, int i2, Object obj) {
            this.aop.c(i, i2, obj);
        }

        public final void ch(int i) {
            this.aop.at(i, 1);
        }

        public final void as(int i, int i2) {
            this.aop.as(i, i2);
        }

        public final void at(int i, int i2) {
            this.aop.at(i, i2);
        }

        public final void ci(int i) {
            this.aop.au(i, 1);
        }

        public final void au(int i, int i2) {
            this.aop.au(i, i2);
        }

        public final void jR() {
            if (this.aop.hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.aoq = true;
        }
    }

    public static class b extends Observable<c> {
        b() {
        }

        public final boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void ar(int i, int i2) {
            c(i, i2, null);
        }

        public final void c(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).d(i, i2, obj);
            }
        }

        public final void at(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).aw(i, i2);
            }
        }

        public final void au(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).ax(i, i2);
            }
        }

        public final void as(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).ay(i, i2);
            }
        }
    }

    public static abstract class c {
        public void onChanged() {
        }

        public void av(int i, int i2) {
        }

        public void d(int i, int i2, Object obj) {
            av(i, i2);
        }

        public void aw(int i, int i2) {
        }

        public void ax(int i, int i2) {
        }

        public void ay(int i, int i2) {
        }
    }

    public interface d {
        int az(int i, int i2);
    }

    public interface j {
        void bH(View view);
    }

    public static abstract class k {
        public abstract boolean aE(int i, int i2);
    }

    public static abstract class m {
        public void c(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static abstract class v {
        private static final List<Object> apR = Collections.EMPTY_LIST;
        private int Dj;
        public final View apJ;
        WeakReference<RecyclerView> apK;
        int apL = -1;
        public long apM = -1;
        public int apN = -1;
        int apO = -1;
        v apP = null;
        v apQ = null;
        List<Object> apS = null;
        List<Object> apT = null;
        private int apU = 0;
        private o apV = null;
        private boolean apW = false;
        private int apX = 0;
        int apY = -1;
        RecyclerView apZ;
        int mPosition = -1;

        public v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.apJ = view;
        }

        /* Access modifiers changed, original: final */
        public final void o(int i, boolean z) {
            if (this.apL == -1) {
                this.apL = this.mPosition;
            }
            if (this.apO == -1) {
                this.apO = this.mPosition;
            }
            if (z) {
                this.apO += i;
            }
            this.mPosition += i;
            if (this.apJ.getLayoutParams() != null) {
                ((LayoutParams) this.apJ.getLayoutParams()).aoN = true;
            }
        }

        /* Access modifiers changed, original: final */
        public final void kf() {
            this.apL = -1;
            this.apO = -1;
        }

        /* Access modifiers changed, original: final */
        public final void kg() {
            if (this.apL == -1) {
                this.apL = this.mPosition;
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean kh() {
            return (this.Dj & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.apO == -1 ? this.mPosition : this.apO;
        }

        public final int ki() {
            return this.apO == -1 ? this.mPosition : this.apO;
        }

        public final int kj() {
            if (this.apZ == null) {
                return -1;
            }
            return this.apZ.i(this);
        }

        public final int kk() {
            return this.apN;
        }

        /* Access modifiers changed, original: final */
        public final boolean kl() {
            return this.apV != null;
        }

        /* Access modifiers changed, original: final */
        public final void km() {
            this.apV.t(this);
        }

        /* Access modifiers changed, original: final */
        public final boolean kn() {
            return (this.Dj & 32) != 0;
        }

        /* Access modifiers changed, original: final */
        public final void ko() {
            this.Dj &= -33;
        }

        /* Access modifiers changed, original: final */
        public final void kp() {
            this.Dj &= -257;
        }

        /* Access modifiers changed, original: final */
        public final void a(o oVar, boolean z) {
            this.apV = oVar;
            this.apW = z;
        }

        /* Access modifiers changed, original: final */
        public final boolean kq() {
            return (this.Dj & 4) != 0;
        }

        /* Access modifiers changed, original: final */
        public final boolean kr() {
            return (this.Dj & 2) != 0;
        }

        /* Access modifiers changed, original: final */
        public final boolean isBound() {
            return (this.Dj & 1) != 0;
        }

        public final boolean isRemoved() {
            return (this.Dj & 8) != 0;
        }

        /* Access modifiers changed, original: final */
        public final boolean cx(int i) {
            return (this.Dj & i) != 0;
        }

        /* Access modifiers changed, original: final */
        public final boolean ks() {
            return (this.Dj & 256) != 0;
        }

        /* Access modifiers changed, original: final */
        public final void setFlags(int i, int i2) {
            this.Dj = (this.Dj & (i2 ^ -1)) | (i & i2);
        }

        /* Access modifiers changed, original: final */
        public final void addFlags(int i) {
            this.Dj |= i;
        }

        /* Access modifiers changed, original: final */
        public final void O(Object obj) {
            if (obj == null) {
                addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } else if ((this.Dj & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                kt();
                this.apS.add(obj);
            }
        }

        private void kt() {
            if (this.apS == null) {
                this.apS = new ArrayList();
                this.apT = Collections.unmodifiableList(this.apS);
            }
        }

        /* Access modifiers changed, original: final */
        public final void ku() {
            if (this.apS != null) {
                this.apS.clear();
            }
            this.Dj &= -1025;
        }

        /* Access modifiers changed, original: final */
        public final List<Object> kv() {
            if ((this.Dj & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                return apR;
            }
            if (this.apS == null || this.apS.size() == 0) {
                return apR;
            }
            return this.apT;
        }

        /* Access modifiers changed, original: final */
        public final void resetInternal() {
            this.Dj = 0;
            this.mPosition = -1;
            this.apL = -1;
            this.apM = -1;
            this.apO = -1;
            this.apU = 0;
            this.apP = null;
            this.apQ = null;
            ku();
            this.apX = 0;
            this.apY = -1;
            RecyclerView.h(this);
        }

        public String toString() {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.apM + ", oldPos=" + this.apL + ", pLpos:" + this.apO);
            if (kl()) {
                stringBuilder.append(" scrap ").append(this.apW ? "[changeScrap]" : "[attachedScrap]");
            }
            if (kq()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (kr()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (kh()) {
                stringBuilder.append(" ignored");
            }
            if (ks()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!kw()) {
                stringBuilder.append(" not recyclable(" + this.apU + ")");
            }
            if ((this.Dj & 512) != 0 || kq()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.apJ.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void ao(boolean z) {
            this.apU = z ? this.apU - 1 : this.apU + 1;
            if (this.apU < 0) {
                this.apU = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && this.apU == 1) {
                this.Dj |= 16;
            } else if (z && this.apU == 0) {
                this.Dj &= -17;
            }
        }

        public final boolean kw() {
            return (this.Dj & 16) == 0 && !android.support.v4.view.s.Q(this.apJ);
        }

        /* Access modifiers changed, original: final */
        public final boolean kx() {
            return (this.Dj & 2) != 0;
        }

        static /* synthetic */ void b(v vVar, RecyclerView recyclerView) {
            recyclerView.b(vVar, vVar.apX);
            vVar.apX = 0;
        }

        static /* synthetic */ boolean v(v vVar) {
            return (vVar.Dj & 16) == 0 && android.support.v4.view.s.Q(vVar.apJ);
        }

        static /* synthetic */ boolean z(v vVar) {
            return (vVar.Dj & 16) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        amU = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        amV = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        amW = z;
        if (VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        amX = z;
        if (VERSION.SDK_INT <= 15) {
            z = true;
        } else {
            z = false;
        }
        amY = z;
        if (VERSION.SDK_INT <= 15) {
            z = true;
        } else {
            z = false;
        }
        amZ = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.anb = new q();
        this.anc = new o();
        this.ang = new bj();
        this.ani = new Runnable() {
            public final void run() {
                if (RecyclerView.this.ans && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.anp) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.anv) {
                        RecyclerView.this.anu = true;
                    } else {
                        RecyclerView.this.jk();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.qT = new Rect();
        this.anj = new RectF();
        this.anm = new ArrayList();
        this.ann = new ArrayList();
        this.ant = 0;
        this.anA = false;
        this.anB = false;
        this.anC = 0;
        this.anD = 0;
        this.anE = new e();
        this.anJ = new y();
        this.mScrollState = 0;
        this.anK = -1;
        this.anS = Float.MIN_VALUE;
        this.anT = Float.MIN_VALUE;
        this.anU = true;
        this.anV = new u();
        this.anX = amX ? new a() : null;
        this.anY = new s();
        this.aob = false;
        this.aoc = false;
        this.aod = new g();
        this.aoe = false;
        this.aoh = new int[2];
        this.Rd = new int[2];
        this.Re = new int[2];
        this.aoj = new int[2];
        this.aok = new ArrayList();
        this.aol = new Runnable() {
            public final void run() {
                if (RecyclerView.this.anJ != null) {
                    RecyclerView.this.anJ.hX();
                }
                RecyclerView.this.aoe = false;
            }
        };
        this.aon = new b() {
            public final void a(v vVar, c cVar, c cVar2) {
                RecyclerView.this.anc.t(vVar);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f(vVar);
                vVar.ao(false);
                if (recyclerView.anJ.d(vVar, cVar, cVar2)) {
                    recyclerView.jA();
                }
            }

            public final void b(v vVar, c cVar, c cVar2) {
                RecyclerView recyclerView = RecyclerView.this;
                vVar.ao(false);
                if (recyclerView.anJ.e(vVar, cVar, cVar2)) {
                    recyclerView.jA();
                }
            }

            public final void c(v vVar, c cVar, c cVar2) {
                vVar.ao(false);
                if (RecyclerView.this.anA) {
                    if (RecyclerView.this.anJ.a(vVar, vVar, cVar, cVar2)) {
                        RecyclerView.this.jA();
                    }
                } else if (RecyclerView.this.anJ.f(vVar, cVar, cVar2)) {
                    RecyclerView.this.jA();
                }
            }

            public final void j(v vVar) {
                RecyclerView.this.ank.a(vVar.apJ, RecyclerView.this.anc);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, amT, i, 0);
            this.anh = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.anh = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.anS = android.support.v4.view.t.a(viewConfiguration, context);
        this.anT = android.support.v4.view.t.b(viewConfiguration, context);
        this.anQ = viewConfiguration.getScaledMinimumFlingVelocity();
        this.anR = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.anJ.aor = this.aod;
        this.ane = new f(new a() {
            public final v bC(int i) {
                v bn;
                RecyclerView recyclerView = RecyclerView.this;
                int hU = recyclerView.anf.hU();
                int i2 = 0;
                v vVar = null;
                while (i2 < hU) {
                    bn = RecyclerView.bn(recyclerView.anf.bI(i2));
                    if (bn != null && !bn.isRemoved() && bn.mPosition == i) {
                        if (!recyclerView.anf.aY(bn.apJ)) {
                            break;
                        }
                    } else {
                        bn = vVar;
                    }
                    i2++;
                    vVar = bn;
                }
                bn = vVar;
                if (bn == null) {
                    return null;
                }
                if (RecyclerView.this.anf.aY(bn.apJ)) {
                    return null;
                }
                return bn;
            }

            public final void O(int i, int i2) {
                RecyclerView.this.e(i, i2, true);
                RecyclerView.this.aob = true;
                s sVar = RecyclerView.this.anY;
                sVar.apr += i2;
            }

            public final void P(int i, int i2) {
                RecyclerView.this.e(i, i2, false);
                RecyclerView.this.aob = true;
            }

            public final void b(int i, int i2, Object obj) {
                int i3;
                RecyclerView recyclerView = RecyclerView.this;
                int hU = recyclerView.anf.hU();
                int i4 = i + i2;
                for (i3 = 0; i3 < hU; i3++) {
                    View bI = recyclerView.anf.bI(i3);
                    v bn = RecyclerView.bn(bI);
                    if (bn != null && !bn.kh() && bn.mPosition >= i && bn.mPosition < i4) {
                        bn.addFlags(2);
                        bn.O(obj);
                        ((LayoutParams) bI.getLayoutParams()).aoN = true;
                    }
                }
                o oVar = recyclerView.anc;
                hU = i + i2;
                for (i3 = oVar.aoX.size() - 1; i3 >= 0; i3--) {
                    v vVar = (v) oVar.aoX.get(i3);
                    if (vVar != null) {
                        i4 = vVar.mPosition;
                        if (i4 >= i && i4 < hU) {
                            vVar.addFlags(2);
                            oVar.cs(i3);
                        }
                    }
                }
                RecyclerView.this.aoc = true;
            }

            public final void d(b bVar) {
                f(bVar);
            }

            private void f(b bVar) {
                switch (bVar.Cn) {
                    case 1:
                        RecyclerView.this.ank.c(RecyclerView.this, bVar.afe, bVar.afg);
                        return;
                    case 2:
                        RecyclerView.this.ank.d(RecyclerView.this, bVar.afe, bVar.afg);
                        return;
                    case 4:
                        RecyclerView.this.ank.a(RecyclerView.this, bVar.afe, bVar.afg, bVar.aff);
                        return;
                    case 8:
                        RecyclerView.this.ank.a(RecyclerView.this, bVar.afe, bVar.afg, 1);
                        return;
                    default:
                        return;
                }
            }

            public final void e(b bVar) {
                f(bVar);
            }

            public final void Q(int i, int i2) {
                int i3;
                RecyclerView recyclerView = RecyclerView.this;
                int hU = recyclerView.anf.hU();
                for (i3 = 0; i3 < hU; i3++) {
                    v bn = RecyclerView.bn(recyclerView.anf.bI(i3));
                    if (!(bn == null || bn.kh() || bn.mPosition < i)) {
                        bn.o(i2, false);
                        recyclerView.anY.apu = true;
                    }
                }
                o oVar = recyclerView.anc;
                int size = oVar.aoX.size();
                for (i3 = 0; i3 < size; i3++) {
                    v vVar = (v) oVar.aoX.get(i3);
                    if (vVar != null && vVar.mPosition >= i) {
                        vVar.o(i2, true);
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.aob = true;
            }

            public final void R(int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7 = -1;
                RecyclerView recyclerView = RecyclerView.this;
                int hU = recyclerView.anf.hU();
                if (i < i2) {
                    i3 = -1;
                    i4 = i2;
                    i5 = i;
                } else {
                    i3 = 1;
                    i4 = i;
                    i5 = i2;
                }
                for (i6 = 0; i6 < hU; i6++) {
                    v bn = RecyclerView.bn(recyclerView.anf.bI(i6));
                    if (bn != null && bn.mPosition >= i5 && bn.mPosition <= i4) {
                        if (bn.mPosition == i) {
                            bn.o(i2 - i, false);
                        } else {
                            bn.o(i3, false);
                        }
                        recyclerView.anY.apu = true;
                    }
                }
                o oVar = recyclerView.anc;
                if (i < i2) {
                    i4 = i2;
                    i5 = i;
                } else {
                    i7 = 1;
                    i4 = i;
                    i5 = i2;
                }
                int size = oVar.aoX.size();
                for (i6 = 0; i6 < size; i6++) {
                    v vVar = (v) oVar.aoX.get(i6);
                    if (vVar != null && vVar.mPosition >= r4 && vVar.mPosition <= r3) {
                        if (vVar.mPosition == i) {
                            vVar.o(i2 - i, false);
                        } else {
                            vVar.o(i7, false);
                        }
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.aob = true;
            }
        });
        this.anf = new v(new b() {
            public final int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public final void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView recyclerView = RecyclerView.this;
                v bn = RecyclerView.bn(view);
                if (!(recyclerView.Yq == null || bn == null)) {
                    recyclerView.Yq.k(bn);
                }
                if (recyclerView.anz != null) {
                    for (int size = recyclerView.anz.size() - 1; size >= 0; size--) {
                        recyclerView.anz.get(size);
                    }
                }
            }

            public final int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public final void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.bs(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            public final View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public final v aZ(View view) {
                return RecyclerView.bn(view);
            }

            public final void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
                v bn = RecyclerView.bn(view);
                if (bn != null) {
                    if (bn.ks() || bn.kh()) {
                        bn.kp();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + bn + RecyclerView.this.ji());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public final void detachViewFromParent(int i) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    v bn = RecyclerView.bn(childAt);
                    if (bn != null) {
                        if (!bn.ks() || bn.kh()) {
                            bn.addFlags(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + bn + RecyclerView.this.ji());
                        }
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public final void ba(View view) {
                v bn = RecyclerView.bn(view);
                if (bn != null) {
                    v.a(bn, RecyclerView.this);
                }
            }

            public final void bb(View view) {
                v bn = RecyclerView.bn(view);
                if (bn != null) {
                    v.b(bn, RecyclerView.this);
                }
            }

            public final void removeAllViews() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RecyclerView.this.bs(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }
        });
        if (android.support.v4.view.s.S(this) == 0) {
            android.support.v4.view.s.o(this, 1);
        }
        this.mP = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ao(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, android.support.v7.f.a.a.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(2);
            if (obtainStyledAttributes2.getInt(1, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.anr = obtainStyledAttributes2.getBoolean(6, false);
            if (this.anr) {
                StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes2.getDrawable(7);
                Drawable drawable = obtainStyledAttributes2.getDrawable(8);
                StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes2.getDrawable(9);
                Drawable drawable2 = obtainStyledAttributes2.getDrawable(10);
                if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                    throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + ji());
                }
                Resources resources = getContext().getResources();
                ac acVar = new ac(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.a20), resources.getDimensionPixelSize(R.dimen.a22), resources.getDimensionPixelOffset(R.dimen.a21));
            }
            obtainStyledAttributes2.recycle();
            if (string != null) {
                String trim = string.trim();
                if (!trim.isEmpty()) {
                    String str;
                    if (trim.charAt(0) == '.') {
                        str = context.getPackageName() + trim;
                    } else if (trim.contains(".")) {
                        str = trim;
                    } else {
                        str = RecyclerView.class.getPackage().getName() + '.' + trim;
                    }
                    try {
                        ClassLoader classLoader;
                        Constructor constructor;
                        Object[] objArr;
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            classLoader = context.getClassLoader();
                        }
                        Class asSubclass = classLoader.loadClass(str).asSubclass(i.class);
                        try {
                            constructor = asSubclass.getConstructor(ana);
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                        } catch (NoSuchMethodException e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((i) constructor.newInstance(objArr));
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                    } catch (ClassNotFoundException e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e3);
                    } catch (InvocationTargetException e4) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e4);
                    } catch (InstantiationException e5) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e5);
                    } catch (IllegalAccessException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                    } catch (ClassCastException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e7);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, amS, i, 0);
                z = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
            }
            z = true;
        } else {
            setDescendantFocusability(262144);
            z = true;
        }
        setNestedScrollingEnabled(z);
    }

    /* Access modifiers changed, original: final */
    public final String ji() {
        return " " + super.toString() + ", adapter:" + this.Yq + ", layout:" + this.ank + ", context:" + getContext();
    }

    public ao getCompatAccessibilityDelegate() {
        return this.aof;
    }

    public void setAccessibilityDelegateCompat(ao aoVar) {
        this.aof = aoVar;
        android.support.v4.view.s.a((View) this, this.aof);
    }

    public void setHasFixedSize(boolean z) {
        this.anq = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.anh) {
            jt();
        }
        this.anh = z;
        super.setClipToPadding(z);
        if (this.ans) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.anh;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                new StringBuilder("setScrollingTouchSlop(): bad argument constant ").append(i).append("; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        if (this.Yq != null) {
            this.Yq.b(this.anb);
        }
        jj();
        this.ane.reset();
        a aVar2 = this.Yq;
        this.Yq = aVar;
        if (aVar != null) {
            aVar.a(this.anb);
        }
        if (this.ank != null) {
            this.ank.jW();
        }
        o oVar = this.anc;
        a aVar3 = this.Yq;
        oVar.clear();
        n recycledViewPool = oVar.getRecycledViewPool();
        if (aVar2 != null) {
            recycledViewPool.detach();
        }
        if (recycledViewPool.aoQ == 0) {
            for (int i = 0; i < recycledViewPool.aoP.size(); i++) {
                ((a) recycledViewPool.aoP.valueAt(i)).aoR.clear();
            }
        }
        if (aVar3 != null) {
            recycledViewPool.ka();
        }
        this.anY.apu = true;
        am(false);
        requestLayout();
    }

    /* Access modifiers changed, original: final */
    public final void jj() {
        if (this.anJ != null) {
            this.anJ.hZ();
        }
        if (this.ank != null) {
            this.ank.d(this.anc);
            this.ank.c(this.anc);
        }
        this.anc.clear();
    }

    public a getAdapter() {
        return this.Yq;
    }

    public void setRecyclerListener(p pVar) {
        this.anl = pVar;
    }

    public int getBaseline() {
        if (this.ank != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.ank) {
            jm();
            if (this.ank != null) {
                if (this.anJ != null) {
                    this.anJ.hZ();
                }
                this.ank.d(this.anc);
                this.ank.c(this.anc);
                this.anc.clear();
                if (this.anp) {
                    this.ank.b(this, this.anc);
                }
                this.ank.setRecyclerView(null);
                this.ank = null;
            } else {
                this.anc.clear();
            }
            v vVar = this.anf;
            a aVar = vVar.ahb;
            while (true) {
                aVar.ahd = 0;
                if (aVar.ahe == null) {
                    break;
                }
                aVar = aVar.ahe;
            }
            for (int size = vVar.ahc.size() - 1; size >= 0; size--) {
                vVar.aha.bb((View) vVar.ahc.get(size));
                vVar.ahc.remove(size);
            }
            vVar.aha.removeAllViews();
            this.ank = iVar;
            if (iVar != null) {
                if (iVar.aiB != null) {
                    throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.aiB.ji());
                }
                this.ank.setRecyclerView(this);
                if (this.anp) {
                    this.ank.e(this);
                }
            }
            this.anc.kb();
            requestLayout();
        }
    }

    public void setOnFlingListener(k kVar) {
        this.anP = kVar;
    }

    public k getOnFlingListener() {
        return this.anP;
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.and != null) {
            savedState.apd = this.and.apd;
        } else if (this.ank != null) {
            savedState.apd = this.ank.onSaveInstanceState();
        } else {
            savedState.apd = null;
        }
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.and = (SavedState) parcelable;
            super.onRestoreInstanceState(this.and.LC);
            if (this.ank != null && this.and.apd != null) {
                this.ank.onRestoreInstanceState(this.and.apd);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* Access modifiers changed, original: final */
    public final void f(v vVar) {
        View view = vVar.apJ;
        boolean z = view.getParent() == this;
        this.anc.t(aZ(view));
        if (vVar.ks()) {
            this.anf.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            v vVar2 = this.anf;
            int indexOfChild = vVar2.aha.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
            }
            vVar2.ahb.set(indexOfChild);
            vVar2.aW(view);
        } else {
            this.anf.a(view, -1, true);
        }
    }

    public i getLayoutManager() {
        return this.ank;
    }

    public n getRecycledViewPool() {
        return this.anc.getRecycledViewPool();
    }

    public void setRecycledViewPool(n nVar) {
        o oVar = this.anc;
        if (oVar.apb != null) {
            oVar.apb.detach();
        }
        oVar.apb = nVar;
        if (nVar != null) {
            n nVar2 = oVar.apb;
            RecyclerView.this.getAdapter();
            nVar2.ka();
        }
    }

    public void setViewCacheExtension(t tVar) {
        this.anc.apc = tVar;
    }

    public void setItemViewCacheSize(int i) {
        o oVar = this.anc;
        oVar.aoZ = i;
        oVar.kb();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                jn();
            }
            if (this.ank != null) {
                this.ank.cm(i);
            }
            if (this.anZ != null) {
                this.anZ.c(this, i);
            }
            if (this.aoa != null) {
                for (int size = this.aoa.size() - 1; size >= 0; size--) {
                    ((m) this.aoa.get(size)).c(this, i);
                }
            }
        }
    }

    public final void a(h hVar) {
        if (this.ank != null) {
            this.ank.T("Cannot add item decoration during a scroll  or layout");
        }
        if (this.anm.isEmpty()) {
            setWillNotDraw(false);
        }
        this.anm.add(hVar);
        jK();
        requestLayout();
    }

    public final void b(h hVar) {
        a(hVar);
    }

    public int getItemDecorationCount() {
        return this.anm.size();
    }

    public final void c(h hVar) {
        if (this.ank != null) {
            this.ank.T("Cannot remove item decoration during a scroll  or layout");
        }
        this.anm.remove(hVar);
        if (this.anm.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        jK();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.aog) {
            this.aog = dVar;
            setChildrenDrawingOrderEnabled(this.aog != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.anZ = mVar;
    }

    public final void a(m mVar) {
        if (this.aoa == null) {
            this.aoa = new ArrayList();
        }
        this.aoa.add(mVar);
    }

    public final void b(m mVar) {
        if (this.aoa != null) {
            this.aoa.remove(mVar);
        }
    }

    public void bY(int i) {
        if (!this.anv) {
            jm();
            if (this.ank != null) {
                this.ank.bY(i);
                awakenScrollBars();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void cd(int i) {
        if (this.ank != null) {
            this.ank.bY(i);
            awakenScrollBars();
        }
    }

    public final void smoothScrollToPosition(int i) {
        if (!this.anv && this.ank != null) {
            this.ank.a(this, i);
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.ank != null && !this.anv) {
            boolean iG = this.ank.iG();
            boolean iH = this.ank.iH();
            if (iG || iH) {
                if (!iG) {
                    i = 0;
                }
                if (!iH) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void jk() {
        boolean z = false;
        if (!this.ans || this.anA) {
            android.support.v4.os.f.beginSection("RV FullInvalidate");
            jD();
            android.support.v4.os.f.endSection();
        } else if (!this.ane.hw()) {
        } else {
            if (this.ane.bz(4) && !this.ane.bz(11)) {
                android.support.v4.os.f.beginSection("RV PartialInvalidate");
                jl();
                jw();
                this.ane.hu();
                if (!this.anu) {
                    int childCount = this.anf.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        v bn = bn(this.anf.getChildAt(i));
                        if (bn != null && !bn.kh() && bn.kx()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        jD();
                    } else {
                        this.ane.hv();
                    }
                }
                ak(true);
                al(true);
                android.support.v4.os.f.endSection();
            } else if (this.ane.hw()) {
                android.support.v4.os.f.beginSection("RV FullInvalidate");
                jD();
                android.support.v4.os.f.endSection();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        jk();
        if (this.Yq != null) {
            int a;
            int b;
            jl();
            jw();
            android.support.v4.os.f.beginSection("RV Scroll");
            m(this.anY);
            if (i != 0) {
                a = this.ank.a(i, this.anc, this.anY);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.ank.b(i2, this.anc, this.anY);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            android.support.v4.os.f.endSection();
            jP();
            al(true);
            ak(false);
            i5 = b;
            i6 = a;
        } else {
            i5 = 0;
            i6 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.anm.isEmpty()) {
            invalidate();
        }
        if (a(i6, i5, i3, i4, this.Rd, 0)) {
            this.anN -= this.Rd[0];
            this.anO -= this.Rd[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.Rd[0], (float) this.Rd[1]);
            }
            int[] iArr = this.aoj;
            iArr[0] = iArr[0] + this.Rd[0];
            iArr = this.aoj;
            iArr[1] = iArr[1] + this.Rd[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || android.support.v4.view.h.d(motionEvent))) {
                e(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i4);
            }
            al(i, i2);
        }
        if (!(i6 == 0 && i5 == 0)) {
            aq(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i6 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.ank != null && this.ank.iG()) {
            return this.ank.d(this.anY);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.ank != null && this.ank.iG()) {
            return this.ank.f(this.anY);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.ank != null && this.ank.iG()) {
            return this.ank.h(this.anY);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.ank != null && this.ank.iH()) {
            return this.ank.e(this.anY);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.ank != null && this.ank.iH()) {
            return this.ank.g(this.anY);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.ank != null && this.ank.iH()) {
            return this.ank.i(this.anY);
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final void jl() {
        this.ant++;
        if (this.ant == 1 && !this.anv) {
            this.anu = false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void ak(boolean z) {
        if (this.ant <= 0) {
            this.ant = 1;
        }
        if (!(z || this.anv)) {
            this.anu = false;
        }
        if (this.ant == 1) {
            if (!(!z || !this.anu || this.anv || this.ank == null || this.Yq == null)) {
                jD();
            }
            if (!this.anv) {
                this.anu = false;
            }
        }
        this.ant--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.anv) {
            T("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.anv = true;
                this.anw = true;
                jm();
                return;
            }
            this.anv = false;
            if (!(!this.anu || this.ank == null || this.Yq == null)) {
                requestLayout();
            }
            this.anu = false;
        }
    }

    public final void ce(int i) {
        a(0, i, null);
    }

    public final void a(int i, int i2, Interpolator interpolator) {
        int i3 = 0;
        if (this.ank != null && !this.anv) {
            if (!this.ank.iG()) {
                i = 0;
            }
            if (this.ank.iH()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.anV.a(i, i3, interpolator);
            }
        }
    }

    public boolean ak(int i, int i2) {
        if (this.ank == null || this.anv) {
            return false;
        }
        boolean iG = this.ank.iG();
        boolean iH = this.ank.iH();
        if (!iG || Math.abs(i) < this.anQ) {
            i = 0;
        }
        if (!iH || Math.abs(i2) < this.anQ) {
            i2 = 0;
        }
        if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
            return false;
        }
        boolean z;
        if (iG || iH) {
            z = true;
        } else {
            z = false;
        }
        dispatchNestedFling((float) i, (float) i2, z);
        if (this.anP != null && this.anP.aE(i, i2)) {
            return true;
        }
        if (!z) {
            return false;
        }
        int i3;
        if (iG) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (iH) {
            i3 |= 2;
        }
        w(i3, 1);
        int max = Math.max(-this.anR, Math.min(i, this.anR));
        int max2 = Math.max(-this.anR, Math.min(i2, this.anR));
        u uVar = this.anV;
        RecyclerView.this.setScrollState(2);
        uVar.apG = 0;
        uVar.apF = 0;
        uVar.qN.fling(0, 0, max, max2, android.support.v4.widget.j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, android.support.v4.widget.j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        uVar.ke();
        return true;
    }

    public final void jm() {
        setScrollState(0);
        jn();
    }

    private void jn() {
        this.anV.stop();
        if (this.ank != null) {
            this.ank.jX();
        }
    }

    public int getMinFlingVelocity() {
        return this.anQ;
    }

    public int getMaxFlingVelocity() {
        return this.anR;
    }

    private void e(float f, float f2, float f3, float f4) {
        Object obj = 1;
        Object obj2 = null;
        if (f2 < 0.0f) {
            jp();
            android.support.v4.widget.i.a(this.anF, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
            obj2 = 1;
        } else if (f2 > 0.0f) {
            jq();
            android.support.v4.widget.i.a(this.anH, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
            int obj22 = 1;
        }
        if (f4 < 0.0f) {
            jr();
            android.support.v4.widget.i.a(this.anG, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
        } else if (f4 > 0.0f) {
            js();
            android.support.v4.widget.i.a(this.anI, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
        } else {
            obj = obj22;
        }
        if (obj != null || f2 != 0.0f || f4 != 0.0f) {
            android.support.v4.view.s.R(this);
        }
    }

    private void jo() {
        int i = 0;
        if (this.anF != null) {
            this.anF.onRelease();
            i = this.anF.isFinished();
        }
        if (this.anG != null) {
            this.anG.onRelease();
            i |= this.anG.isFinished();
        }
        if (this.anH != null) {
            this.anH.onRelease();
            i |= this.anH.isFinished();
        }
        if (this.anI != null) {
            this.anI.onRelease();
            i |= this.anI.isFinished();
        }
        if (i != 0) {
            android.support.v4.view.s.R(this);
        }
    }

    /* Access modifiers changed, original: final */
    public final void al(int i, int i2) {
        int i3 = 0;
        if (!(this.anF == null || this.anF.isFinished() || i <= 0)) {
            this.anF.onRelease();
            i3 = this.anF.isFinished();
        }
        if (!(this.anH == null || this.anH.isFinished() || i >= 0)) {
            this.anH.onRelease();
            i3 |= this.anH.isFinished();
        }
        if (!(this.anG == null || this.anG.isFinished() || i2 <= 0)) {
            this.anG.onRelease();
            i3 |= this.anG.isFinished();
        }
        if (!(this.anI == null || this.anI.isFinished() || i2 >= 0)) {
            this.anI.onRelease();
            i3 |= this.anI.isFinished();
        }
        if (i3 != 0) {
            android.support.v4.view.s.R(this);
        }
    }

    /* Access modifiers changed, original: final */
    public final void am(int i, int i2) {
        if (i < 0) {
            jp();
            this.anF.onAbsorb(-i);
        } else if (i > 0) {
            jq();
            this.anH.onAbsorb(i);
        }
        if (i2 < 0) {
            jr();
            this.anG.onAbsorb(-i2);
        } else if (i2 > 0) {
            js();
            this.anI.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            android.support.v4.view.s.R(this);
        }
    }

    private void jp() {
        if (this.anF == null) {
            this.anF = e.d(this);
            if (this.anh) {
                this.anF.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.anF.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private void jq() {
        if (this.anH == null) {
            this.anH = e.d(this);
            if (this.anh) {
                this.anH.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.anH.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private void jr() {
        if (this.anG == null) {
            this.anG = e.d(this);
            if (this.anh) {
                this.anG.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.anG.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void js() {
        if (this.anI == null) {
            this.anI = e.d(this);
            if (this.anh) {
                this.anI.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.anI.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void jt() {
        this.anI = null;
        this.anG = null;
        this.anH = null;
        this.anF = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        android.support.v4.f.l.checkNotNull(eVar);
        this.anE = eVar;
        jt();
    }

    public e getEdgeEffectFactory() {
        return this.anE;
    }

    public View focusSearch(View view, int i) {
        int i2;
        int i3;
        View findNextFocus;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (this.Yq == null || this.ank == null || jz() || this.anv) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z3 && (i == 2 || i == 1)) {
            boolean z4;
            if (this.ank.iH()) {
                i2 = i == 2 ? 130 : 33;
                if (instance.findNextFocus(this, view, i2) == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (amY) {
                    i = i2;
                }
            } else {
                z4 = false;
            }
            if (!z4 && this.ank.iG()) {
                if (android.support.v4.view.s.T(this.ank.aiB) == 1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i == 2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i2 = (i2 ^ i3) != 0 ? 66 : 17;
                if (instance.findNextFocus(this, view, i2) == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (amY) {
                    i = i2;
                }
            }
            if (z4) {
                jk();
                if (bl(view) == null) {
                    return null;
                }
                jl();
                this.ank.a(view, i, this.anc, this.anY);
                ak(false);
            }
            findNextFocus = instance.findNextFocus(this, view, i);
        } else {
            findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z3) {
                jk();
                if (bl(view) == null) {
                    return null;
                }
                jl();
                findNextFocus = this.ank.a(view, i, this.anc, this.anY);
                ak(false);
            }
        }
        if (findNextFocus == null || findNextFocus.hasFocusable()) {
            if (!(findNextFocus == null || findNextFocus == this || bl(findNextFocus) == null)) {
                if (view == null) {
                    z2 = true;
                } else if (bl(view) == null) {
                    z2 = true;
                } else {
                    this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
                    this.qT.set(0, 0, findNextFocus.getWidth(), findNextFocus.getHeight());
                    offsetDescendantRectToMyCoords(view, this.mTempRect);
                    offsetDescendantRectToMyCoords(findNextFocus, this.qT);
                    i2 = android.support.v4.view.s.T(this.ank.aiB) == 1 ? -1 : 1;
                    if ((this.mTempRect.left < this.qT.left || this.mTempRect.right <= this.qT.left) && this.mTempRect.right < this.qT.right) {
                        i3 = 1;
                    } else if ((this.mTempRect.right > this.qT.right || this.mTempRect.left >= this.qT.right) && this.mTempRect.left > this.qT.left) {
                        i3 = -1;
                    } else {
                        i3 = 0;
                    }
                    if ((this.mTempRect.top < this.qT.top || this.mTempRect.bottom <= this.qT.top) && this.mTempRect.bottom < this.qT.bottom) {
                        z = true;
                    } else if ((this.mTempRect.bottom <= this.qT.bottom && this.mTempRect.top < this.qT.bottom) || this.mTempRect.top <= this.qT.top) {
                        z = false;
                    }
                    switch (i) {
                        case 1:
                            if (z >= false || (!z && i2 * i3 <= 0)) {
                                z2 = true;
                                break;
                            }
                        case 2:
                            if (z <= false || (!z && i2 * i3 >= 0)) {
                                z2 = true;
                                break;
                            }
                        case 17:
                            if (i3 < 0) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 33:
                            if (z >= false) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 66:
                            if (i3 > 0) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 130:
                            if (z <= false) {
                                z2 = true;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid direction: " + i + ji());
                    }
                }
            }
            if (z2) {
                return findNextFocus;
            }
            return super.focusSearch(view, i);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            d(findNextFocus, null);
            return view;
        }
    }

    public void requestChildFocus(View view, View view2) {
        Object obj;
        if (this.ank.jV() || jz()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && view2 != null) {
            d(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void d(View view, View view2) {
        boolean z = true;
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.aoN) {
                Rect rect = layoutParams2.ala;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2 = this.mTempRect;
                rect2.right += rect.right;
                rect2 = this.mTempRect;
                rect2.top -= rect.top;
                rect2 = this.mTempRect;
                rect2.bottom = rect.bottom + rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        i iVar = this.ank;
        Rect rect3 = this.mTempRect;
        boolean z2 = !this.ans;
        if (view2 != null) {
            z = false;
        }
        iVar.a(this, view, rect3, z2, z);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.ank.a(this, view, rect, z, false);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.ank == null || !this.ank.a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (jz()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:15:0x004f, code skipped:
            if (r0 >= 30.0f) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        boolean z = true;
        super.onAttachedToWindow();
        this.anC = 0;
        this.anp = true;
        if (!this.ans || isLayoutRequested()) {
            z = false;
        }
        this.ans = z;
        if (this.ank != null) {
            this.ank.e(this);
        }
        this.aoe = false;
        if (amX) {
            this.anW = (af) af.aiU.get();
            if (this.anW == null) {
                float refreshRate;
                this.anW = new af();
                Display ax = android.support.v4.view.s.ax(this);
                if (!(isInEditMode() || ax == null)) {
                    refreshRate = ax.getRefreshRate();
                }
                refreshRate = 60.0f;
                this.anW.aiX = (long) (1.0E9f / refreshRate);
                af.aiU.set(this.anW);
            }
            this.anW.aiV.add(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.anJ != null) {
            this.anJ.hZ();
        }
        jm();
        this.anp = false;
        if (this.ank != null) {
            this.ank.b(this, this.anc);
        }
        this.aok.clear();
        removeCallbacks(this.aol);
        a.lz();
        if (amX && this.anW != null) {
            this.anW.aiV.remove(this);
            this.anW = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.anp;
    }

    /* Access modifiers changed, original: final */
    public final void T(String str) {
        if (jz()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + ji());
            }
            throw new IllegalStateException(str);
        } else if (this.anD > 0) {
            IllegalStateException illegalStateException = new IllegalStateException(ji());
        }
    }

    public final void a(l lVar) {
        this.ann.add(lVar);
    }

    public final void b(l lVar) {
        this.ann.remove(lVar);
        if (this.ano == lVar) {
            this.ano = null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.anv) {
            return false;
        }
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.ano = null;
        }
        int size = this.ann.size();
        for (int i = 0; i < size; i++) {
            l lVar = (l) this.ann.get(i);
            if (lVar.h(motionEvent) && action != 3) {
                this.ano = lVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            jv();
            return true;
        } else if (this.ank == null) {
            return false;
        } else {
            z = this.ank.iG();
            boolean iH = this.ank.iH();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            action = motionEvent.getActionMasked();
            size = motionEvent.getActionIndex();
            int i2;
            switch (action) {
                case 0:
                    if (this.anw) {
                        this.anw = false;
                    }
                    this.anK = motionEvent.getPointerId(0);
                    action = (int) (motionEvent.getX() + 0.5f);
                    this.anN = action;
                    this.anL = action;
                    action = (int) (motionEvent.getY() + 0.5f);
                    this.anO = action;
                    this.anM = action;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aoj;
                    this.aoj[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (iH) {
                        i2 |= 2;
                    }
                    w(i2, 0);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    aJ(0);
                    break;
                case 2:
                    action = motionEvent.findPointerIndex(this.anK);
                    if (action >= 0) {
                        size = (int) (motionEvent.getX(action) + 0.5f);
                        action = (int) (motionEvent.getY(action) + 0.5f);
                        if (this.mScrollState != 1) {
                            int i3 = size - this.anL;
                            int i4 = action - this.anM;
                            if (!z || Math.abs(i3) <= this.mTouchSlop) {
                                z = false;
                            } else {
                                this.anN = size;
                                z = true;
                            }
                            if (iH && Math.abs(i4) > this.mTouchSlop) {
                                this.anO = action;
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.anK).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    jv();
                    break;
                case 5:
                    this.anK = motionEvent.getPointerId(size);
                    i2 = (int) (motionEvent.getX(size) + 0.5f);
                    this.anN = i2;
                    this.anL = i2;
                    i2 = (int) (motionEvent.getY(size) + 0.5f);
                    this.anO = i2;
                    this.anM = i2;
                    break;
                case 6:
                    j(motionEvent);
                    break;
            }
            if (this.mScrollState == 1) {
                return true;
            }
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.ann.size();
        for (int i = 0; i < size; i++) {
            ((l) this.ann.get(i)).ab(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.anv || this.anw) {
            return false;
        }
        int actionIndex;
        int i;
        int action = motionEvent.getAction();
        if (this.ano != null) {
            if (action == 0) {
                this.ano = null;
            } else {
                this.ano.i(motionEvent);
                if (action == 3 || action == 1) {
                    this.ano = null;
                }
                action = 1;
                if (action == 0) {
                    jv();
                    return true;
                } else if (this.ank == null) {
                    return false;
                } else {
                    boolean iG = this.ank.iG();
                    boolean iH = this.ank.iH();
                    if (this.mVelocityTracker == null) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    action = motionEvent.getActionMasked();
                    actionIndex = motionEvent.getActionIndex();
                    if (action == 0) {
                        int[] iArr = this.aoj;
                        this.aoj[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.aoj[0], (float) this.aoj[1]);
                    switch (action) {
                        case 0:
                            this.anK = motionEvent.getPointerId(0);
                            action = (int) (motionEvent.getX() + 0.5f);
                            this.anN = action;
                            this.anL = action;
                            action = (int) (motionEvent.getY() + 0.5f);
                            this.anO = action;
                            this.anM = action;
                            if (iG) {
                                action = 1;
                            } else {
                                action = 0;
                            }
                            if (iH) {
                                action |= 2;
                            }
                            w(action, 0);
                            break;
                        case 1:
                            this.mVelocityTracker.addMovement(obtain);
                            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.anR);
                            float f = iG ? -this.mVelocityTracker.getXVelocity(this.anK) : 0.0f;
                            float f2;
                            if (iH) {
                                f2 = -this.mVelocityTracker.getYVelocity(this.anK);
                            } else {
                                f2 = 0.0f;
                            }
                            if ((f == 0.0f && f2 == 0.0f) || !ak((int) f, (int) f2)) {
                                setScrollState(0);
                            }
                            ju();
                            z = true;
                            break;
                        case 2:
                            action = motionEvent.findPointerIndex(this.anK);
                            if (action >= 0) {
                                int x = (int) (motionEvent.getX(action) + 0.5f);
                                int y = (int) (motionEvent.getY(action) + 0.5f);
                                int i2 = this.anN - x;
                                actionIndex = this.anO - y;
                                if (a(i2, actionIndex, this.Re, this.Rd, 0)) {
                                    i2 -= this.Re[0];
                                    actionIndex -= this.Re[1];
                                    obtain.offsetLocation((float) this.Rd[0], (float) this.Rd[1]);
                                    int[] iArr2 = this.aoj;
                                    iArr2[0] = iArr2[0] + this.Rd[0];
                                    iArr2 = this.aoj;
                                    iArr2[1] = iArr2[1] + this.Rd[1];
                                }
                                if (this.mScrollState != 1) {
                                    if (!iG || Math.abs(i2) <= this.mTouchSlop) {
                                        boolean i3 = false;
                                    } else {
                                        if (i2 > 0) {
                                            action = i2 - this.mTouchSlop;
                                        } else {
                                            action = this.mTouchSlop + i2;
                                        }
                                        i3 = 1;
                                        i2 = action;
                                    }
                                    if (iH && Math.abs(actionIndex) > this.mTouchSlop) {
                                        if (actionIndex > 0) {
                                            action = actionIndex - this.mTouchSlop;
                                        } else {
                                            action = this.mTouchSlop + actionIndex;
                                        }
                                        i3 = 1;
                                        actionIndex = action;
                                    }
                                    if (i3 != 0) {
                                        setScrollState(1);
                                    }
                                }
                                if (this.mScrollState == 1) {
                                    this.anN = x - this.Rd[0];
                                    this.anO = y - this.Rd[1];
                                    i3 = iG ? i2 : 0;
                                    if (iH) {
                                        action = actionIndex;
                                    } else {
                                        action = 0;
                                    }
                                    if (a(i3, action, obtain)) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                    }
                                    if (!(this.anW == null || (i2 == 0 && actionIndex == 0))) {
                                        this.anW.b(this, i2, actionIndex);
                                        break;
                                    }
                                }
                            }
                            new StringBuilder("Error processing scroll; pointer index for id ").append(this.anK).append(" not found. Did any MotionEvents get skipped?");
                            return false;
                            break;
                        case 3:
                            jv();
                            break;
                        case 5:
                            this.anK = motionEvent.getPointerId(actionIndex);
                            action = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.anN = action;
                            this.anL = action;
                            action = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.anO = action;
                            this.anM = action;
                            break;
                        case 6:
                            j(motionEvent);
                            break;
                    }
                    if (!z) {
                        this.mVelocityTracker.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        if (action != 0) {
            i3 = this.ann.size();
            for (actionIndex = 0; actionIndex < i3; actionIndex++) {
                l lVar = (l) this.ann.get(actionIndex);
                if (lVar.h(motionEvent)) {
                    this.ano = lVar;
                    action = 1;
                    break;
                }
            }
        }
        boolean z2 = false;
        if (action == 0) {
        }
    }

    private void ju() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        aJ(0);
        jo();
    }

    private void jv() {
        ju();
        setScrollState(0);
    }

    private void j(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.anK) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.anK = motionEvent.getPointerId(actionIndex);
            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.anN = x;
            this.anL = x;
            actionIndex = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.anO = actionIndex;
            this.anM = actionIndex;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.ank == null || this.anv || motionEvent.getAction() != 8)) {
            float axisValue;
            float f;
            float f2;
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.ank.iH()) {
                    f2 = -motionEvent.getAxisValue(9);
                } else {
                    f2 = 0.0f;
                }
                if (this.ank.iG()) {
                    axisValue = motionEvent.getAxisValue(10);
                    f = f2;
                } else {
                    axisValue = 0.0f;
                    f = f2;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                f2 = motionEvent.getAxisValue(26);
                if (this.ank.iH()) {
                    axisValue = 0.0f;
                    f = -f2;
                } else if (this.ank.iG()) {
                    axisValue = f2;
                    f = 0.0f;
                } else {
                    axisValue = 0.0f;
                    f = 0.0f;
                }
            } else {
                axisValue = 0.0f;
                f = 0.0f;
            }
            if (!(f == 0.0f && axisValue == 0.0f)) {
                a((int) (this.anS * axisValue), (int) (this.anT * f), motionEvent);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.ank == null) {
            an(i, i2);
        } else if (this.ank.iF()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.ank.aD(i, i2);
            if (mode == ErrorDialogData.SUPPRESSED && mode2 == ErrorDialogData.SUPPRESSED) {
                z = true;
            }
            if (!z && this.Yq != null) {
                if (this.anY.aps == 1) {
                    jH();
                }
                this.ank.aA(i, i2);
                this.anY.apx = true;
                jI();
                this.ank.aB(i, i2);
                if (this.ank.iL()) {
                    this.ank.aA(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), ErrorDialogData.SUPPRESSED));
                    this.anY.apx = true;
                    jI();
                    this.ank.aB(i, i2);
                }
            }
        } else if (this.anq) {
            this.ank.aD(i, i2);
        } else {
            if (this.any) {
                jl();
                jw();
                jC();
                al(true);
                if (this.anY.apz) {
                    this.anY.apv = true;
                } else {
                    this.ane.hx();
                    this.anY.apv = false;
                }
                this.any = false;
                ak(false);
            } else if (this.anY.apz) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.Yq != null) {
                this.anY.apt = this.Yq.getItemCount();
            } else {
                this.anY.apt = 0;
            }
            jl();
            this.ank.aD(i, i2);
            ak(false);
            this.anY.apv = false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void an(int i, int i2) {
        setMeasuredDimension(i.l(i, getPaddingLeft() + getPaddingRight(), android.support.v4.view.s.Z(this)), i.l(i2, getPaddingTop() + getPaddingBottom(), android.support.v4.view.s.aa(this)));
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            jt();
        }
    }

    public void setItemAnimator(f fVar) {
        if (this.anJ != null) {
            this.anJ.hZ();
            this.anJ.aor = null;
        }
        this.anJ = fVar;
        if (this.anJ != null) {
            this.anJ.aor = this.aod;
        }
    }

    /* Access modifiers changed, original: final */
    public final void jw() {
        this.anC++;
    }

    /* Access modifiers changed, original: final */
    public final void al(boolean z) {
        this.anC--;
        if (this.anC <= 0) {
            this.anC = 0;
            if (z) {
                jy();
                jQ();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean jx() {
        return this.mP != null && this.mP.isEnabled();
    }

    private void jy() {
        int i = this.anx;
        this.anx = 0;
        if (i != 0 && jx()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            android.support.v4.view.a.a.a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public final boolean jz() {
        return this.anC > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (jz()) {
            int i2;
            if (accessibilityEvent == null) {
                i2 = 0;
            } else if (VERSION.SDK_INT >= 19) {
                i2 = accessibilityEvent.getContentChangeTypes();
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                i = i2;
            }
            this.anx |= i;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public f getItemAnimator() {
        return this.anJ;
    }

    /* Access modifiers changed, original: final */
    public final void jA() {
        if (!this.aoe && this.anp) {
            android.support.v4.view.s.b((View) this, this.aol);
            this.aoe = true;
        }
    }

    private boolean jB() {
        return this.anJ != null && this.ank.iE();
    }

    private void jC() {
        boolean z;
        boolean z2 = true;
        if (this.anA) {
            this.ane.reset();
            if (this.anB) {
                this.ank.a(this);
            }
        }
        if (jB()) {
            this.ane.hu();
        } else {
            this.ane.hx();
        }
        boolean z3;
        if (this.aob || this.aoc) {
            z3 = true;
        } else {
            z3 = false;
        }
        s sVar = this.anY;
        if (!this.ans || this.anJ == null || (!(this.anA || z3 || this.ank.aoD) || (this.anA && !this.Yq.aoq))) {
            z = false;
        } else {
            z = true;
        }
        sVar.apy = z;
        s sVar2 = this.anY;
        if (!(this.anY.apy && z3 && !this.anA && jB())) {
            z2 = false;
        }
        sVar2.apz = z2;
    }

    private void jD() {
        if (this.Yq != null && this.ank != null) {
            this.anY.apx = false;
            if (this.anY.aps == 1) {
                jH();
                this.ank.g(this);
                jI();
            } else if (!this.ane.hy() && this.ank.mWidth == getWidth() && this.ank.mHeight == getHeight()) {
                this.ank.g(this);
            } else {
                this.ank.g(this);
                jI();
            }
            jJ();
        }
    }

    private void jE() {
        View focusedChild;
        if (this.anU && hasFocus() && this.Yq != null) {
            focusedChild = getFocusedChild();
        } else {
            focusedChild = null;
        }
        v bm = focusedChild == null ? null : bm(focusedChild);
        if (bm == null) {
            jF();
            return;
        }
        long j;
        int i;
        s sVar = this.anY;
        if (this.Yq.aoq) {
            j = bm.apM;
        } else {
            j = -1;
        }
        sVar.apB = j;
        s sVar2 = this.anY;
        if (this.anA) {
            i = -1;
        } else if (bm.isRemoved()) {
            i = bm.apL;
        } else {
            i = bm.kj();
        }
        sVar2.apA = i;
        sVar = this.anY;
        View view = bm.apJ;
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        sVar.apC = id;
    }

    private void jF() {
        this.anY.apB = -1;
        this.anY.apA = -1;
        this.anY.apC = -1;
    }

    /* JADX WARNING: Missing block: B:58:0x00ce, code skipped:
            if (r0.isFocusable() != false) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void jG() {
        View view = null;
        if (this.anU && this.Yq != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || !isFocused()) {
                View focusedChild;
                v vVar;
                View view2;
                if (!isFocused()) {
                    focusedChild = getFocusedChild();
                    if (!amZ || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.anf.aY(focusedChild)) {
                            return;
                        }
                    } else if (this.anf.getChildCount() == 0) {
                        requestFocus();
                        return;
                    }
                }
                if (this.anY.apB == -1 || !this.Yq.aoq) {
                    vVar = null;
                } else {
                    long j = this.anY.apB;
                    if (this.Yq == null || !this.Yq.aoq) {
                        vVar = null;
                    } else {
                        Object obj;
                        int hU = this.anf.hU();
                        int i = 0;
                        view2 = null;
                        while (i < hU) {
                            vVar = bn(this.anf.bI(i));
                            if (vVar != null && !vVar.isRemoved() && vVar.apM == j) {
                                if (!this.anf.aY(vVar.apJ)) {
                                    break;
                                }
                            } else {
                                obj = view2;
                            }
                            i++;
                            Object view22 = vVar;
                        }
                        obj = view22;
                    }
                }
                if (vVar != null && !this.anf.aY(vVar.apJ) && vVar.apJ.hasFocusable()) {
                    view22 = vVar.apJ;
                } else if (this.anf.getChildCount() > 0) {
                    int i2 = this.anY.apA != -1 ? this.anY.apA : 0;
                    int itemCount = this.anY.getItemCount();
                    int i3 = i2;
                    while (i3 < itemCount) {
                        v cf = cf(i3);
                        if (cf == null) {
                            break;
                        } else if (cf.apJ.hasFocusable()) {
                            view = cf.apJ;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i2 = Math.min(itemCount, i2) - 1;
                    while (i2 >= 0) {
                        v cf2 = cf(i2);
                        if (cf2 == null) {
                            break;
                        } else if (cf2.apJ.hasFocusable()) {
                            view = cf2.apJ;
                            break;
                        } else {
                            i2--;
                        }
                    }
                    view22 = view;
                } else {
                    view22 = null;
                }
                if (view22 != null) {
                    if (((long) this.anY.apC) != -1) {
                        focusedChild = view22.findViewById(this.anY.apC);
                        if (focusedChild != null) {
                        }
                    }
                    focusedChild = view22;
                    focusedChild.requestFocus();
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void m(s sVar) {
        if (getScrollState() == 2) {
            OverScroller a = this.anV.qN;
            sVar.apD = a.getFinalX() - a.getCurrX();
            sVar.apE = a.getFinalY() - a.getCurrY();
            return;
        }
        sVar.apD = 0;
        sVar.apE = 0;
    }

    private void jH() {
        int childCount;
        int i;
        v bn;
        this.anY.cw(1);
        m(this.anY);
        this.anY.apx = false;
        jl();
        this.ang.clear();
        jw();
        jC();
        jE();
        s sVar = this.anY;
        boolean z = this.anY.apy && this.aoc;
        sVar.apw = z;
        this.aoc = false;
        this.aob = false;
        this.anY.apv = this.anY.apz;
        this.anY.apt = this.Yq.getItemCount();
        j(this.aoh);
        if (this.anY.apy) {
            childCount = this.anf.getChildCount();
            for (i = 0; i < childCount; i++) {
                bn = bn(this.anf.getChildAt(i));
                if (!bn.kh() && (!bn.kq() || this.Yq.aoq)) {
                    this.ang.b(bn, this.anJ.a(this.anY, bn, f.l(bn), bn.kv()));
                    if (!(!this.anY.apw || !bn.kx() || bn.isRemoved() || bn.kh() || bn.kq())) {
                        this.ang.a(g(bn), bn);
                    }
                }
            }
        }
        if (this.anY.apz) {
            jL();
            z = this.anY.apu;
            this.anY.apu = false;
            this.ank.c(this.anc, this.anY);
            this.anY.apu = z;
            for (i = 0; i < this.anf.getChildCount(); i++) {
                bn = bn(this.anf.getChildAt(i));
                if (!(bn.kh() || this.ang.I(bn))) {
                    childCount = f.l(bn);
                    boolean cx = bn.cx(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (!cx) {
                        childCount |= 4096;
                    }
                    c a = this.anJ.a(this.anY, bn, childCount, bn.kv());
                    if (cx) {
                        a(bn, a);
                    } else {
                        this.ang.c(bn, a);
                    }
                }
            }
            jM();
        } else {
            jM();
        }
        al(true);
        ak(false);
        this.anY.aps = 2;
    }

    private void jI() {
        boolean z;
        jl();
        jw();
        this.anY.cw(6);
        this.ane.hx();
        this.anY.apt = this.Yq.getItemCount();
        this.anY.apr = 0;
        this.anY.apv = false;
        this.ank.c(this.anc, this.anY);
        this.anY.apu = false;
        this.and = null;
        s sVar = this.anY;
        if (!this.anY.apy || this.anJ == null) {
            z = false;
        } else {
            z = true;
        }
        sVar.apy = z;
        this.anY.aps = 4;
        al(true);
        ak(false);
    }

    private void jJ() {
        this.anY.cw(4);
        jl();
        jw();
        this.anY.aps = 1;
        if (this.anY.apy) {
            for (int childCount = this.anf.getChildCount() - 1; childCount >= 0; childCount--) {
                v bn = bn(this.anf.getChildAt(childCount));
                if (!bn.kh()) {
                    long g = g(bn);
                    c c = new c().c(bn, 0);
                    v o = this.ang.o(g);
                    if (!(o == null || o.kh())) {
                        boolean H = this.ang.H(o);
                        boolean H2 = this.ang.H(bn);
                        if (!(H && o == bn)) {
                            c d = this.ang.d(o, 4);
                            this.ang.d(bn, c);
                            c d2 = this.ang.d(bn, 8);
                            if (d == null) {
                                a(g, bn, o);
                            } else {
                                a(o, bn, d, d2, H, H2);
                            }
                        }
                    }
                    this.ang.d(bn, c);
                }
            }
            this.ang.a(this.aon);
        }
        this.ank.c(this.anc);
        this.anY.apq = this.anY.apt;
        this.anA = false;
        this.anB = false;
        this.anY.apy = false;
        this.anY.apz = false;
        this.ank.aoD = false;
        if (this.anc.aoW != null) {
            this.anc.aoW.clear();
        }
        if (this.ank.aoI) {
            this.ank.aoH = 0;
            this.ank.aoI = false;
            this.anc.kb();
        }
        this.ank.a(this.anY);
        al(true);
        ak(false);
        this.ang.clear();
        if (ao(this.aoh[0], this.aoh[1])) {
            aq(0, 0);
        }
        jG();
        jF();
    }

    private void a(long j, v vVar, v vVar2) {
        int childCount = this.anf.getChildCount();
        int i = 0;
        while (i < childCount) {
            v bn = bn(this.anf.getChildAt(i));
            if (bn == vVar || g(bn) != j) {
                i++;
            } else if (this.Yq == null || !this.Yq.aoq) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + bn + " \n View Holder 2:" + vVar + ji());
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + bn + " \n View Holder 2:" + vVar + ji());
            }
        }
        new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(vVar2).append(" cannot be found but it is necessary for ").append(vVar).append(ji());
    }

    /* Access modifiers changed, original: final */
    public final void a(v vVar, c cVar) {
        vVar.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.anY.apw && vVar.kx() && !vVar.isRemoved() && !vVar.kh()) {
            this.ang.a(g(vVar), vVar);
        }
        this.ang.b(vVar, cVar);
    }

    private void j(int[] iArr) {
        int childCount = this.anf.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = android.support.v4.widget.j.INVALID_ID;
        int i3 = 0;
        while (i3 < childCount) {
            int ki;
            v bn = bn(this.anf.getChildAt(i3));
            if (!bn.kh()) {
                ki = bn.ki();
                if (ki < i) {
                    i = ki;
                }
                if (ki > i2) {
                    i3++;
                    i2 = ki;
                }
            }
            ki = i2;
            i3++;
            i2 = ki;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean ao(int i, int i2) {
        j(this.aoh);
        if (this.aoh[0] == i && this.aoh[1] == i2) {
            return false;
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void removeDetachedView(View view, boolean z) {
        v bn = bn(view);
        if (bn != null) {
            if (bn.ks()) {
                bn.kp();
            } else if (!bn.kh()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + bn + ji());
            }
        }
        view.clearAnimation();
        bs(view);
        super.removeDetachedView(view, z);
    }

    private long g(v vVar) {
        if (this.Yq.aoq) {
            return vVar.apM;
        }
        return (long) vVar.mPosition;
    }

    private void a(v vVar, v vVar2, c cVar, c cVar2, boolean z, boolean z2) {
        vVar.ao(false);
        if (z) {
            f(vVar);
        }
        if (vVar != vVar2) {
            if (z2) {
                f(vVar2);
            }
            vVar.apP = vVar2;
            f(vVar);
            this.anc.t(vVar);
            vVar2.ao(false);
            vVar2.apQ = vVar;
        }
        if (this.anJ.a(vVar, vVar2, cVar, cVar2)) {
            jA();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.os.f.beginSection("RV OnLayout");
        jD();
        android.support.v4.os.f.endSection();
        this.ans = true;
    }

    public void requestLayout() {
        if (this.ant != 0 || this.anv) {
            this.anu = true;
        } else {
            super.requestLayout();
        }
    }

    private void jK() {
        int hU = this.anf.hU();
        for (int i = 0; i < hU; i++) {
            ((LayoutParams) this.anf.bI(i).getLayoutParams()).aoN = true;
        }
        this.anc.jK();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.anm.size();
        for (i = 0; i < size; i++) {
            ((h) this.anm.get(i)).a(canvas, this);
        }
        if (this.anF == null || this.anF.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.anh ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.anF == null || !this.anF.draw(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.anG == null || this.anG.isFinished())) {
            size = canvas.save();
            if (this.anh) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.anG == null || !this.anG.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.anH == null || this.anH.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            if (this.anh) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.anH == null || !this.anH.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.anI == null || this.anI.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.anh) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.anI != null && this.anI.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.anJ == null || this.anm.size() <= 0 || !this.anJ.isRunning()) {
            i3 = i2;
        }
        if (i3 != 0) {
            android.support.v4.view.s.R(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.anm.size();
        for (int i = 0; i < size; i++) {
            ((h) this.anm.get(i)).a(canvas, this, this.anY);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.ank.a((LayoutParams) layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.ank != null) {
            return this.ank.iA();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + ji());
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.ank != null) {
            return this.ank.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + ji());
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.ank != null) {
            return this.ank.d(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + ji());
    }

    private void jL() {
        int hU = this.anf.hU();
        for (int i = 0; i < hU; i++) {
            v bn = bn(this.anf.bI(i));
            if (!bn.kh()) {
                bn.kg();
            }
        }
    }

    private void jM() {
        int hU = this.anf.hU();
        for (int i = 0; i < hU; i++) {
            v bn = bn(this.anf.bI(i));
            if (!bn.kh()) {
                bn.kf();
            }
        }
        this.anc.jM();
    }

    /* Access modifiers changed, original: final */
    public final void e(int i, int i2, boolean z) {
        int i3 = i + i2;
        int hU = this.anf.hU();
        for (int i4 = 0; i4 < hU; i4++) {
            v bn = bn(this.anf.bI(i4));
            if (!(bn == null || bn.kh())) {
                if (bn.mPosition >= i3) {
                    bn.o(-i2, z);
                    this.anY.apu = true;
                } else if (bn.mPosition >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    bn.addFlags(8);
                    bn.o(i6, z);
                    bn.mPosition = i5;
                    this.anY.apu = true;
                }
            }
        }
        o oVar = this.anc;
        int i7 = i + i2;
        for (i3 = oVar.aoX.size() - 1; i3 >= 0; i3--) {
            v vVar = (v) oVar.aoX.get(i3);
            if (vVar != null) {
                if (vVar.mPosition >= i7) {
                    vVar.o(-i2, z);
                } else if (vVar.mPosition >= i) {
                    vVar.addFlags(8);
                    oVar.cs(i3);
                }
            }
        }
        requestLayout();
    }

    /* Access modifiers changed, original: final */
    public final void am(boolean z) {
        this.anB |= z;
        this.anA = true;
        jN();
    }

    private void jN() {
        int hU = this.anf.hU();
        for (int i = 0; i < hU; i++) {
            v bn = bn(this.anf.bI(i));
            if (!(bn == null || bn.kh())) {
                bn.addFlags(6);
            }
        }
        jK();
        this.anc.jN();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.anU;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.anU = z;
    }

    public final v aZ(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return bn(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final View bl(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            view2 = parent;
            parent = view2.getParent();
        }
        return parent == this ? view2 : null;
    }

    public final v bm(View view) {
        View bl = bl(view);
        return bl == null ? null : aZ(bl);
    }

    static v bn(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).aoM;
    }

    public static int bo(View view) {
        v bn = bn(view);
        return bn != null ? bn.kj() : -1;
    }

    public static int bp(View view) {
        v bn = bn(view);
        return bn != null ? bn.ki() : -1;
    }

    public final v cf(int i) {
        if (this.anA) {
            return null;
        }
        int hU = this.anf.hU();
        int i2 = 0;
        v vVar = null;
        while (i2 < hU) {
            v bn = bn(this.anf.bI(i2));
            if (bn == null || bn.isRemoved() || i(bn) != i) {
                bn = vVar;
            } else if (!this.anf.aY(bn.apJ)) {
                return bn;
            }
            i2++;
            vVar = bn;
        }
        return vVar;
    }

    public final View x(float f, float f2) {
        for (int childCount = this.anf.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.anf.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= ((float) childAt.getLeft()) + translationX && f <= translationX + ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) + translationY && f2 <= ((float) childAt.getBottom()) + translationY) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public static void d(View view, Rect rect) {
        e(view, rect);
    }

    static void e(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.ala;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, (view.getRight() + rect2.right) + layoutParams.rightMargin, layoutParams.bottomMargin + (rect2.bottom + view.getBottom()));
    }

    /* Access modifiers changed, original: final */
    public final Rect bq(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.aoN) {
            return layoutParams.ala;
        }
        if (this.anY.apv && (layoutParams.aoM.kx() || layoutParams.aoM.kq())) {
            return layoutParams.ala;
        }
        Rect rect = layoutParams.ala;
        rect.set(0, 0, 0, 0);
        int size = this.anm.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            ((h) this.anm.get(i)).a(this.mTempRect, view, this, this.anY);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.aoN = false;
        return rect;
    }

    public void ap(int i, int i2) {
    }

    /* Access modifiers changed, original: final */
    public final void aq(int i, int i2) {
        this.anD++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        ap(i, i2);
        if (this.anZ != null) {
            this.anZ.a(this, i, i2);
        }
        if (this.aoa != null) {
            for (scrollY = this.aoa.size() - 1; scrollY >= 0; scrollY--) {
                ((m) this.aoa.get(scrollY)).a(this, i, i2);
            }
        }
        this.anD--;
    }

    public final boolean jO() {
        return !this.ans || this.anA || this.ane.hw();
    }

    /* Access modifiers changed, original: final */
    public final void jP() {
        int childCount = this.anf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.anf.getChildAt(i);
            v aZ = aZ(childAt);
            if (!(aZ == null || aZ.apQ == null)) {
                View view = aZ.apQ.apJ;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView br(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView br = br(viewGroup.getChildAt(i));
            if (br != null) {
                return br;
            }
        }
        return null;
    }

    static void h(v vVar) {
        if (vVar.apK != null) {
            View view = (View) vVar.apK.get();
            while (view != null) {
                if (view != vVar.apJ) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            vVar.apK = null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public long getNanoTime() {
        if (amX) {
            return System.nanoTime();
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final void bs(View view) {
        bn(view);
        if (this.anz != null) {
            for (int size = this.anz.size() - 1; size >= 0; size--) {
                ((j) this.anz.get(size)).bH(view);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean b(v vVar, int i) {
        if (jz()) {
            vVar.apY = i;
            this.aok.add(vVar);
            return false;
        }
        android.support.v4.view.s.o(vVar.apJ, i);
        return true;
    }

    private void jQ() {
        for (int size = this.aok.size() - 1; size >= 0; size--) {
            v vVar = (v) this.aok.get(size);
            if (vVar.apJ.getParent() == this && !vVar.kh()) {
                int i = vVar.apY;
                if (i != -1) {
                    android.support.v4.view.s.o(vVar.apJ, i);
                    vVar.apY = -1;
                }
            }
        }
        this.aok.clear();
    }

    /* Access modifiers changed, original: final */
    public final int i(v vVar) {
        if (vVar.cx(524) || !vVar.isBound()) {
            return -1;
        }
        return this.ane.bB(vVar.mPosition);
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().Mp;
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().w(i, 0);
    }

    private boolean w(int i, int i2) {
        return getScrollingChildHelper().w(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().aJ(0);
    }

    public final void aJ(int i) {
        getScrollingChildHelper().aJ(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().aI(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public final boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public final boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    /* Access modifiers changed, original: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.aog == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.aog.az(i, i2);
    }

    /* Access modifiers changed, original: 0000 */
    public android.support.v4.view.k getScrollingChildHelper() {
        if (this.aoi == null) {
            this.aoi = new android.support.v4.view.k(this);
        }
        return this.aoi;
    }
}
