package android.support.p069v7.widget;

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
import android.support.p057v4.p065f.C0416l;
import android.support.p057v4.p066os.C31862f;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0467h;
import android.support.p057v4.view.C0469k;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C44962t;
import android.support.p057v4.view.C6201j;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0445b.C0444c;
import android.support.p057v4.view.p067a.C41515a;
import android.support.p057v4.widget.C0528i;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p1367f.C41522a.C25367a;
import android.support.p069v7.widget.C17497bi.C0708b;
import android.support.p069v7.widget.C31892v.C17498a;
import android.support.p069v7.widget.C31892v.C17499b;
import android.support.p069v7.widget.C41540f.C37146a;
import android.support.p069v7.widget.C41540f.C41539b;
import android.support.p069v7.widget.C44970bj.C25381a;
import android.support.p069v7.widget.C44970bj.C37144b;
import android.support.p069v7.widget.C8467af.C8469a;
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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2288t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C19403g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v7.widget.RecyclerView */
public class RecyclerView extends ViewGroup implements C6201j {
    private static final int[] amS = new int[]{16843830};
    private static final int[] amT = new int[]{16842987};
    static final boolean amU;
    static final boolean amV;
    static final boolean amW;
    private static final boolean amX;
    private static final boolean amY;
    private static final boolean amZ;
    private static final Class<?>[] ana = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final Interpolator aom = new C84413();
    /* renamed from: Rd */
    private final int[] f16847Rd;
    /* renamed from: Re */
    private final int[] f16848Re;
    /* renamed from: Yq */
    C41523a f16849Yq;
    boolean anA;
    boolean anB;
    private int anC;
    private int anD;
    private C17476e anE;
    private EdgeEffect anF;
    private EdgeEffect anG;
    private EdgeEffect anH;
    private EdgeEffect anI;
    C31879f anJ;
    private int anK;
    private int anL;
    private int anM;
    private int anN;
    private int anO;
    private C41529k anP;
    private final int anQ;
    private final int anR;
    private float anS;
    private float anT;
    private boolean anU;
    final C31882u anV;
    C8467af anW;
    C8469a anX;
    final C31880s anY;
    private C41530m anZ;
    private final C8447q anb;
    final C25374o anc;
    private SavedState and;
    C41540f ane;
    C31892v anf;
    final C44970bj ang;
    boolean anh;
    final Runnable ani;
    final RectF anj;
    C17480i ank;
    C8446p anl;
    public final ArrayList<C25373h> anm;
    private final ArrayList<C37137l> ann;
    private C37137l ano;
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
    public List<C41527j> anz;
    private List<C41530m> aoa;
    boolean aob;
    boolean aoc;
    private C17478b aod;
    boolean aoe;
    C17492ao aof;
    private C41526d aog;
    private final int[] aoh;
    private C0469k aoi;
    private final int[] aoj;
    final List<C41531v> aok;
    private Runnable aol;
    private final C37144b aon;
    /* renamed from: mP */
    private final AccessibilityManager f16850mP;
    private int mScrollState;
    final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    /* renamed from: qT */
    private final Rect f16851qT;

    /* renamed from: android.support.v7.widget.RecyclerView$3 */
    static class C84413 implements Interpolator {
        C84413() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$5 */
    class C84425 implements C17499b {
        C84425() {
        }

        public final int getChildCount() {
            return RecyclerView.this.getChildCount();
        }

        public final void addView(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView recyclerView = RecyclerView.this;
            C41531v bn = RecyclerView.m72546bn(view);
            if (!(recyclerView.f16849Yq == null || bn == null)) {
                recyclerView.f16849Yq.mo26080k(bn);
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
                RecyclerView.this.mo66353bs(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        public final View getChildAt(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        /* renamed from: aZ */
        public final C41531v mo18461aZ(View view) {
            return RecyclerView.m72546bn(view);
        }

        public final void attachViewToParent(View view, int i, LayoutParams layoutParams) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (bn != null) {
                if (bn.mo66463ks() || bn.mo66452kh()) {
                    bn.mo66460kp();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + bn + RecyclerView.this.mo66399ji());
                }
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        public final void detachViewFromParent(int i) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                C41531v bn = RecyclerView.m72546bn(childAt);
                if (bn != null) {
                    if (!bn.mo66463ks() || bn.mo66452kh()) {
                        bn.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + bn + RecyclerView.this.mo66399ji());
                    }
                }
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        /* renamed from: ba */
        public final void mo18464ba(View view) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (bn != null) {
                C41531v.m72646a(bn, RecyclerView.this);
            }
        }

        /* renamed from: bb */
        public final void mo18465bb(View view) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (bn != null) {
                C41531v.m72647b(bn, RecyclerView.this);
            }
        }

        public final void removeAllViews() {
            int childCount = RecyclerView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                RecyclerView.this.mo66353bs(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$g */
    class C8443g implements C17478b {
        C8443g() {
        }

        /* renamed from: n */
        public final void mo18472n(C41531v c41531v) {
            boolean z = true;
            c41531v.mo66445ao(true);
            if (c41531v.apP != null && c41531v.apQ == null) {
                c41531v.apP = null;
            }
            c41531v.apQ = null;
            if (!C41531v.m72653z(c41531v)) {
                boolean z2;
                RecyclerView recyclerView = RecyclerView.this;
                View view = c41531v.apJ;
                recyclerView.mo66402jl();
                C31892v c31892v = recyclerView.anf;
                int indexOfChild = c31892v.aha.indexOfChild(view);
                if (indexOfChild == -1) {
                    c31892v.mo51990aX(view);
                    z2 = true;
                } else if (c31892v.ahb.get(indexOfChild)) {
                    c31892v.ahb.mo31925bJ(indexOfChild);
                    c31892v.mo51990aX(view);
                    c31892v.aha.removeViewAt(indexOfChild);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    C41531v bn = RecyclerView.m72546bn(view);
                    recyclerView.anc.mo42382t(bn);
                    recyclerView.anc.mo42381s(bn);
                }
                if (z2) {
                    z = false;
                }
                recyclerView.mo66339ak(z);
                if (!z2 && c41531v.mo66463ks()) {
                    RecyclerView.this.removeDetachedView(c41531v.apJ, false);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$p */
    public interface C8446p {
    }

    /* renamed from: android.support.v7.widget.RecyclerView$q */
    class C8447q extends C41525c {
        C8447q() {
        }

        public final void onChanged() {
            RecyclerView.this.mo66328T(null);
            RecyclerView.this.anY.apu = true;
            RecyclerView.this.mo66343am(true);
            if (!RecyclerView.this.ane.mo66569hw()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0023, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0025;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: d */
        public final void mo18475d(int i, int i2, Object obj) {
            Object obj2 = 1;
            RecyclerView.this.mo66328T(null);
            C41540f c41540f = RecyclerView.this.ane;
            if (i2 > 0) {
                c41540f.aeX.add(c41540f.mo1957a(4, i, i2, obj));
                c41540f.afd |= 4;
            }
            obj2 = null;
            if (obj2 != null) {
                m14949kd();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0022, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0024;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: aw */
        public final void mo18473aw(int i, int i2) {
            int i3 = 1;
            RecyclerView.this.mo66328T(null);
            C41540f c41540f = RecyclerView.this.ane;
            if (i2 > 0) {
                c41540f.aeX.add(c41540f.mo1957a(1, i, i2, null));
                c41540f.afd |= 1;
            }
            i3 = 0;
            if (i3 != 0) {
                m14949kd();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0023, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0025;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: ax */
        public final void mo6644ax(int i, int i2) {
            Object obj = 1;
            RecyclerView.this.mo66328T(null);
            C41540f c41540f = RecyclerView.this.ane;
            if (i2 > 0) {
                c41540f.aeX.add(c41540f.mo1957a(2, i, i2, null));
                c41540f.afd |= 2;
            }
            obj = null;
            if (obj != null) {
                m14949kd();
            }
        }

        /* JADX WARNING: Missing block: B:3:0x0024, code skipped:
            if (r1.aeX.size() == 1) goto L_0x0026;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: ay */
        public final void mo18474ay(int i, int i2) {
            Object obj = 1;
            RecyclerView.this.mo66328T(null);
            C41540f c41540f = RecyclerView.this.ane;
            if (i != i2) {
                c41540f.aeX.add(c41540f.mo1957a(8, i, i2, null));
                c41540f.afd |= 8;
            }
            obj = null;
            if (obj != null) {
                m14949kd();
            }
        }

        /* renamed from: kd */
        private void m14949kd() {
            if (RecyclerView.amW && RecyclerView.this.anq && RecyclerView.this.anp) {
                C0477s.m934b(RecyclerView.this, RecyclerView.this.ani);
                return;
            }
            RecyclerView.this.any = true;
            RecyclerView.this.requestLayout();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$e */
    public static class C17476e {
        /* renamed from: d */
        protected static EdgeEffect m27135d(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$i */
    public static abstract class C17480i {
        protected RecyclerView aiB;
        C31892v anf;
        C17497bi aoA = new C17497bi(this.aoy);
        C17497bi aoB = new C17497bi(this.aoz);
        C37139r aoC;
        public boolean aoD = false;
        protected boolean aoE = false;
        protected boolean aoF = true;
        boolean aoG = true;
        int aoH;
        boolean aoI;
        protected int aoJ;
        protected int aoK;
        private final C0708b aoy = new C84441();
        private final C0708b aoz = new C84452();
        public int mHeight;
        public int mWidth;
        /* renamed from: pv */
        boolean f4036pv = false;

        /* renamed from: android.support.v7.widget.RecyclerView$i$1 */
        class C84441 implements C0708b {
            C84441() {
            }

            public final View getChildAt(int i) {
                return C17480i.this.getChildAt(i);
            }

            /* renamed from: jY */
            public final int mo2060jY() {
                return C17480i.this.getPaddingLeft();
            }

            /* renamed from: jZ */
            public final int mo2061jZ() {
                return C17480i.this.mWidth - C17480i.this.getPaddingRight();
            }

            /* renamed from: bF */
            public final int mo2057bF(View view) {
                return C17480i.m27151bx(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: bG */
            public final int mo2058bG(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + C17480i.m27153bz(view);
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$i$2 */
        class C84452 implements C0708b {
            C84452() {
            }

            public final View getChildAt(int i) {
                return C17480i.this.getChildAt(i);
            }

            /* renamed from: jY */
            public final int mo2060jY() {
                return C17480i.this.getPaddingTop();
            }

            /* renamed from: jZ */
            public final int mo2061jZ() {
                return C17480i.this.mHeight - C17480i.this.getPaddingBottom();
            }

            /* renamed from: bF */
            public final int mo2057bF(View view) {
                return C17480i.m27152by(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            /* renamed from: bG */
            public final int mo2058bG(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + C17480i.m27143bA(view);
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$i$a */
        public interface C17481a {
            /* renamed from: T */
            void mo18521T(int i, int i2);
        }

        /* renamed from: iA */
        public abstract LayoutParams mo1773iA();

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
        /* renamed from: aA */
        public final void mo31838aA(int i, int i2) {
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
        /* renamed from: aB */
        public final void mo31839aB(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.aiB.mo66344an(i, i2);
                return;
            }
            int i3 = C8415j.INVALID_ID;
            int i4 = C8415j.INVALID_ID;
            int i5 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i6 = BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.aiB.mTempRect;
                RecyclerView.m72555e(childAt, rect);
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
            mo31827a(this.aiB.mTempRect, i, i2);
        }

        /* renamed from: a */
        public void mo31827a(Rect rect, int i, int i2) {
            setMeasuredDimension(C17480i.m27162l(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), C0477s.m899Z(this.aiB)), C17480i.m27162l(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), C0477s.m909aa(this.aiB)));
        }

        public final void requestLayout() {
            if (this.aiB != null) {
                this.aiB.requestLayout();
            }
        }

        /* renamed from: l */
        public static int m27162l(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case C8415j.INVALID_ID /*-2147483648*/:
                    return Math.min(size, Math.max(i2, i3));
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        /* renamed from: T */
        public void mo1745T(String str) {
            if (this.aiB != null) {
                this.aiB.mo66328T(str);
            }
        }

        @Deprecated
        /* renamed from: jU */
        public final void mo31873jU() {
            this.aoE = true;
        }

        /* renamed from: iF */
        public boolean mo1775iF() {
            return this.aoE;
        }

        /* renamed from: iE */
        public boolean mo1774iE() {
            return false;
        }

        /* renamed from: an */
        public final void mo31843an(boolean z) {
            if (z != this.aoG) {
                this.aoG = z;
                this.aoH = 0;
                if (this.aiB != null) {
                    this.aiB.anc.mo42380kb();
                }
            }
        }

        /* renamed from: a */
        public void mo1749a(int i, int i2, C31880s c31880s, C17481a c17481a) {
        }

        /* renamed from: a */
        public void mo1750a(int i, C17481a c17481a) {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: e */
        public final void mo31855e(RecyclerView recyclerView) {
            this.f4036pv = true;
            mo31856f(recyclerView);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final void mo31846b(RecyclerView recyclerView, C25374o c25374o) {
            this.f4036pv = false;
            mo1756a(recyclerView, c25374o);
        }

        public final boolean removeCallbacks(Runnable runnable) {
            if (this.aiB != null) {
                return this.aiB.removeCallbacks(runnable);
            }
            return false;
        }

        /* renamed from: f */
        public void mo31856f(RecyclerView recyclerView) {
        }

        /* renamed from: a */
        public void mo1756a(RecyclerView recyclerView, C25374o c25374o) {
        }

        public final boolean getClipToPadding() {
            return this.aiB != null && this.aiB.anh;
        }

        /* renamed from: c */
        public void mo1765c(C25374o c25374o, C31880s c31880s) {
        }

        /* renamed from: a */
        public void mo1753a(C31880s c31880s) {
        }

        /* renamed from: a */
        public boolean mo31834a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        /* renamed from: d */
        public LayoutParams mo31853d(LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        /* renamed from: a */
        public LayoutParams mo31825a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        /* renamed from: a */
        public int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
            return 0;
        }

        /* renamed from: b */
        public int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
            return 0;
        }

        /* renamed from: iG */
        public boolean mo1776iG() {
            return false;
        }

        /* renamed from: iH */
        public boolean mo1777iH() {
            return false;
        }

        /* renamed from: bY */
        public void mo1762bY(int i) {
        }

        /* renamed from: a */
        public void mo1755a(RecyclerView recyclerView, int i) {
        }

        /* renamed from: a */
        public final void mo31829a(C37139r c37139r) {
            if (!(this.aoC == null || c37139r == this.aoC || !this.aoC.apg)) {
                this.aoC.stop();
            }
            this.aoC = c37139r;
            C37139r c37139r2 = this.aoC;
            c37139r2.aiB = this.aiB;
            c37139r2.amP = this;
            if (c37139r2.ape == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            c37139r2.aiB.anY.ape = c37139r2.ape;
            c37139r2.apg = true;
            c37139r2.apf = true;
            c37139r2.aph = c37139r2.aiB.ank.mo1760bW(c37139r2.ape);
            c37139r2.aiB.anV.mo51955ke();
        }

        /* renamed from: jV */
        public final boolean mo31874jV() {
            return this.aoC != null && this.aoC.apg;
        }

        /* renamed from: z */
        public final void mo31882z(View view, int i) {
            m27155c(view, i, true);
        }

        public final void addView(View view, int i) {
            m27155c(view, i, false);
        }

        /* renamed from: c */
        private void m27155c(View view, int i, boolean z) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (z || bn.isRemoved()) {
                this.aiB.ang.mo72241J(bn);
            } else {
                this.aiB.ang.mo72242K(bn);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (bn.mo66458kn() || bn.mo66456kl()) {
                if (bn.mo66456kl()) {
                    bn.mo66457km();
                } else {
                    bn.mo66459ko();
                }
                this.anf.mo51987a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.aiB) {
                int indexOfChild = this.anf.indexOfChild(view);
                if (i == -1) {
                    i = this.anf.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.aiB.indexOfChild(view) + this.aiB.mo66399ji());
                } else if (indexOfChild != i) {
                    this.aiB.ank.m27142aC(indexOfChild, i);
                }
            } else {
                this.anf.mo51988a(view, i, false);
                layoutParams.aoN = true;
                if (this.aoC != null && this.aoC.apg) {
                    this.aoC.mo59206bL(view);
                }
            }
            if (layoutParams.aoO) {
                bn.apJ.invalidate();
                layoutParams.aoO = false;
            }
        }

        private void removeView(View view) {
            C31892v c31892v = this.anf;
            int indexOfChild = c31892v.aha.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (c31892v.ahb.mo31925bJ(indexOfChild)) {
                    c31892v.mo51990aX(view);
                }
                c31892v.aha.removeViewAt(indexOfChild);
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

        /* renamed from: bt */
        public static int m27148bt(View view) {
            return ((LayoutParams) view.getLayoutParams()).aoM.mo66453ki();
        }

        /* renamed from: bl */
        public final View mo31848bl(View view) {
            if (this.aiB == null) {
                return null;
            }
            View bl = this.aiB.mo66350bl(view);
            if (bl == null || this.anf.mo51991aY(bl)) {
                return null;
            }
            return bl;
        }

        /* renamed from: bW */
        public View mo1760bW(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C41531v bn = RecyclerView.m72546bn(childAt);
                if (bn != null && bn.mo66453ki() == i && !bn.mo66452kh() && (this.aiB.anY.apv || !bn.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: cj */
        private void m27156cj(int i) {
            getChildAt(i);
            this.anf.detachViewFromParent(i);
        }

        /* renamed from: A */
        private void m27139A(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            C41531v bn = RecyclerView.m72546bn(view);
            if (bn.isRemoved()) {
                this.aiB.ang.mo72241J(bn);
            } else {
                this.aiB.ang.mo72242K(bn);
            }
            this.anf.mo51987a(view, i, layoutParams, bn.isRemoved());
        }

        /* renamed from: aC */
        private void m27142aC(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.aiB.toString());
            }
            m27156cj(i);
            m27139A(childAt, i2);
        }

        /* renamed from: a */
        public final void mo31833a(View view, C25374o c25374o) {
            removeView(view);
            c25374o.mo42367bI(view);
        }

        /* renamed from: a */
        public final void mo31826a(int i, C25374o c25374o) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            c25374o.mo42367bI(childAt);
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
            return this.aiB != null ? C0477s.m896W(this.aiB) : 0;
        }

        public int getPaddingEnd() {
            return this.aiB != null ? C0477s.m897X(this.aiB) : 0;
        }

        public final View getFocusedChild() {
            if (this.aiB == null) {
                return null;
            }
            View focusedChild = this.aiB.getFocusedChild();
            if (focusedChild == null || this.anf.mo51991aY(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public final int getItemCount() {
            C41523a adapter = this.aiB != null ? this.aiB.getAdapter() : null;
            return adapter != null ? adapter.getItemCount() : 0;
        }

        /* renamed from: ck */
        public void mo31851ck(int i) {
            if (this.aiB != null) {
                RecyclerView recyclerView = this.aiB;
                int childCount = recyclerView.anf.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.anf.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        /* renamed from: cl */
        public void mo31852cl(int i) {
            if (this.aiB != null) {
                RecyclerView recyclerView = this.aiB;
                int childCount = recyclerView.anf.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.anf.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        /* renamed from: b */
        public final void mo31845b(C25374o c25374o) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                m27141a(c25374o, childCount, getChildAt(childCount));
            }
        }

        /* renamed from: a */
        private void m27141a(C25374o c25374o, int i, View view) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (!bn.mo66452kh()) {
                if (!bn.mo66461kq() || bn.isRemoved() || this.aiB.f16849Yq.aoq) {
                    m27156cj(i);
                    c25374o.mo42369bK(view);
                    this.aiB.ang.mo72242K(bn);
                    return;
                }
                removeViewAt(i);
                c25374o.mo42381s(bn);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final void mo31850c(C25374o c25374o) {
            int size = c25374o.aoV.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((C41531v) c25374o.aoV.get(i)).apJ;
                C41531v bn = RecyclerView.m72546bn(view);
                if (!bn.mo66452kh()) {
                    bn.mo66445ao(false);
                    if (bn.mo66463ks()) {
                        this.aiB.removeDetachedView(view, false);
                    }
                    if (this.aiB.anJ != null) {
                        this.aiB.anJ.mo22570d(bn);
                    }
                    bn.mo66445ao(true);
                    c25374o.mo42368bJ(view);
                }
            }
            c25374o.aoV.clear();
            if (c25374o.aoW != null) {
                c25374o.aoW.clear();
            }
            if (size > 0) {
                this.aiB.invalidate();
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo31837a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.aoF && C17480i.m27163m(view.getMeasuredWidth(), i, layoutParams.width) && C17480i.m27163m(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final boolean mo31847b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.aoF && C17480i.m27163m(view.getWidth(), i, layoutParams.width) && C17480i.m27163m(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* renamed from: m */
        private static boolean m27163m(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case C8415j.INVALID_ID /*-2147483648*/:
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

        /* renamed from: bu */
        public final void mo31849bu(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect bq = this.aiB.mo66352bq(view);
            int i = (bq.left + bq.right) + 0;
            int i2 = (bq.bottom + bq.top) + 0;
            i = C17480i.m27154c(this.mWidth, this.aoJ, i + (((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, mo1776iG());
            i2 = C17480i.m27154c(this.mHeight, this.aoK, i2 + (((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, mo1777iH());
            if (mo31847b(view, i, i2, layoutParams)) {
                view.measure(i, i2);
            }
        }

        /* renamed from: c */
        public static int m27154c(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = ErrorDialogData.SUPPRESSED;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case C8415j.INVALID_ID /*-2147483648*/:
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
                    if (i2 == C8415j.INVALID_ID || i2 == ErrorDialogData.SUPPRESSED) {
                        i2 = C8415j.INVALID_ID;
                    }
                    i2 = 0;
                }
                i2 = 0;
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i2);
        }

        /* renamed from: bv */
        public static int m27149bv(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ala;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        /* renamed from: bw */
        public static int m27150bw(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ala;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        /* renamed from: j */
        public static void m27160j(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).ala;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        /* renamed from: k */
        public static void m27161k(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.ala;
            view.layout((rect.left + i) + layoutParams.leftMargin, (rect.top + i2) + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        /* renamed from: f */
        public final void mo31857f(View view, Rect rect) {
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

        /* renamed from: d */
        public static void m27157d(View view, Rect rect) {
            RecyclerView.m72555e(view, rect);
        }

        /* renamed from: bx */
        public static int m27151bx(View view) {
            return view.getLeft() - C17480i.m27146bD(view);
        }

        /* renamed from: by */
        public static int m27152by(View view) {
            return view.getTop() - C17480i.m27144bB(view);
        }

        /* renamed from: bz */
        public static int m27153bz(View view) {
            return view.getRight() + C17480i.m27147bE(view);
        }

        /* renamed from: bA */
        public static int m27143bA(View view) {
            return view.getBottom() + C17480i.m27145bC(view);
        }

        /* renamed from: g */
        public final void mo31859g(View view, Rect rect) {
            if (this.aiB == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.aiB.mo66352bq(view));
            }
        }

        /* renamed from: bB */
        public static int m27144bB(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.top;
        }

        /* renamed from: bC */
        public static int m27145bC(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.bottom;
        }

        /* renamed from: bD */
        public static int m27146bD(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.left;
        }

        /* renamed from: bE */
        public static int m27147bE(View view) {
            return ((LayoutParams) view.getLayoutParams()).ala.right;
        }

        /* renamed from: a */
        public View mo1748a(View view, int i, C25374o c25374o, C31880s c31880s) {
            return null;
        }

        /* renamed from: h */
        private int[] m27159h(View view, Rect rect) {
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
            if (C0477s.m893T(this.aiB) == 1) {
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

        /* renamed from: a */
        public final boolean mo31835a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] h = m27159h(view, rect);
            int i = h[0];
            int i2 = h[1];
            if (z2 && !m27158f(recyclerView, i, i2)) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.mo66329a(i, i2, null);
            }
            return true;
        }

        /* renamed from: f */
        private boolean m27158f(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.mWidth - getPaddingRight();
            int paddingBottom = this.mHeight - getPaddingBottom();
            Rect rect = this.aiB.mTempRect;
            RecyclerView.m72555e(focusedChild, rect);
            if (rect.left - i >= paddingRight || rect.right - i <= paddingLeft || rect.top - i2 >= paddingBottom || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        /* renamed from: jW */
        public void mo31875jW() {
        }

        /* renamed from: a */
        public boolean mo31836a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* renamed from: a */
        public void mo15122a(RecyclerView recyclerView) {
        }

        /* renamed from: c */
        public void mo15123c(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: d */
        public void mo15125d(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: g */
        public void mo15126g(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: a */
        public void mo31831a(RecyclerView recyclerView, int i, int i2, Object obj) {
            mo15126g(recyclerView, i, i2);
        }

        /* renamed from: a */
        public void mo31830a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* renamed from: f */
        public int mo1768f(C31880s c31880s) {
            return 0;
        }

        /* renamed from: d */
        public int mo1766d(C31880s c31880s) {
            return 0;
        }

        /* renamed from: h */
        public int mo1771h(C31880s c31880s) {
            return 0;
        }

        /* renamed from: g */
        public int mo1769g(C31880s c31880s) {
            return 0;
        }

        /* renamed from: e */
        public int mo1767e(C31880s c31880s) {
            return 0;
        }

        /* renamed from: i */
        public int mo1772i(C31880s c31880s) {
            return 0;
        }

        /* renamed from: aD */
        public final void mo31840aD(int i, int i2) {
            this.aiB.mo66344an(i, i2);
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
        /* renamed from: jX */
        public final void mo31876jX() {
            if (this.aoC != null) {
                this.aoC.stop();
            }
        }

        /* renamed from: cm */
        public void mo15124cm(int i) {
        }

        /* renamed from: d */
        public final void mo31854d(C25374o c25374o) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.m72546bn(getChildAt(childCount)).mo66452kh()) {
                    mo31826a(childCount, c25374o);
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
                if (this.aiB.f16849Yq != null) {
                    accessibilityEvent.setItemCount(this.aiB.f16849Yq.getItemCount());
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo31832a(View view, C0445b c0445b) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (bn != null && !bn.isRemoved() && !this.anf.mo51991aY(bn.apJ)) {
                mo31828a(this.aiB.anc, this.aiB.anY, view, c0445b);
            }
        }

        /* renamed from: a */
        public void mo31828a(C25374o c25374o, C31880s c31880s, View view, C0445b c0445b) {
            int bt;
            int bt2 = mo1777iH() ? C17480i.m27148bt(view) : 0;
            if (mo1776iG()) {
                bt = C17480i.m27148bt(view);
            } else {
                bt = 0;
            }
            c0445b.mo985H(C0444c.m769b(bt2, 1, bt, 1, false));
        }

        /* renamed from: a */
        public int mo31824a(C25374o c25374o, C31880s c31880s) {
            if (this.aiB == null || this.aiB.f16849Yq == null || !mo1777iH()) {
                return 1;
            }
            return this.aiB.f16849Yq.getItemCount();
        }

        /* renamed from: b */
        public int mo31844b(C25374o c25374o, C31880s c31880s) {
            if (this.aiB == null || this.aiB.f16849Yq == null || !mo1776iG()) {
                return 1;
            }
            return this.aiB.f16849Yq.getItemCount();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: g */
        public final void mo31858g(RecyclerView recyclerView) {
            mo31838aA(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), ErrorDialogData.SUPPRESSED));
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: iL */
        public boolean mo1779iL() {
            return false;
        }

        public final void addView(View view) {
            m27155c(view, -1, false);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$n */
    public static class C17482n {
        SparseArray<C17483a> aoP = new SparseArray();
        int aoQ = 0;

        /* renamed from: android.support.v7.widget.RecyclerView$n$a */
        static class C17483a {
            final ArrayList<C41531v> aoR = new ArrayList();
            int aoS = 5;
            long aoT = 0;
            long aoU = 0;

            C17483a() {
            }
        }

        /* renamed from: aF */
        public final void mo31883aF(int i, int i2) {
            C17483a co = mo31886co(i);
            co.aoS = i2;
            ArrayList arrayList = co.aoR;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        /* renamed from: cn */
        public final C41531v mo31885cn(int i) {
            C17483a c17483a = (C17483a) this.aoP.get(i);
            if (c17483a == null || c17483a.aoR.isEmpty()) {
                return null;
            }
            ArrayList arrayList = c17483a.aoR;
            return (C41531v) arrayList.remove(arrayList.size() - 1);
        }

        /* renamed from: c */
        static long m27233c(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: d */
        public final void mo31887d(int i, long j) {
            C17483a co = mo31886co(i);
            co.aoT = C17482n.m27233c(co.aoT, j);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final boolean mo31884b(int i, long j, long j2) {
            long j3 = mo31886co(i).aoT;
            return j3 == 0 || j3 + j < j2;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ka */
        public final void mo31889ka() {
            this.aoQ++;
        }

        /* Access modifiers changed, original: final */
        public final void detach() {
            this.aoQ--;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: co */
        public final C17483a mo31886co(int i) {
            C17483a c17483a = (C17483a) this.aoP.get(i);
            if (c17483a != null) {
                return c17483a;
            }
            c17483a = new C17483a();
            this.aoP.put(i, c17483a);
            return c17483a;
        }

        /* renamed from: p */
        public final void mo31890p(C41531v c41531v) {
            int i = c41531v.apN;
            ArrayList arrayList = mo31886co(i).aoR;
            if (((C17483a) this.aoP.get(i)).aoS > arrayList.size()) {
                c41531v.resetInternal();
                arrayList.add(c41531v);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$1 */
    class C253691 implements Runnable {
        C253691() {
        }

        public final void run() {
            if (RecyclerView.this.ans && !RecyclerView.this.isLayoutRequested()) {
                if (!RecyclerView.this.anp) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.anv) {
                    RecyclerView.this.anu = true;
                } else {
                    RecyclerView.this.mo66401jk();
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$2 */
    class C253702 implements Runnable {
        C253702() {
        }

        public final void run() {
            if (RecyclerView.this.anJ != null) {
                RecyclerView.this.anJ.mo22571hX();
            }
            RecyclerView.this.aoe = false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$4 */
    class C253714 implements C37144b {
        C253714() {
        }

        /* renamed from: a */
        public final void mo42359a(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
            RecyclerView.this.anc.mo42382t(c41531v);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mo66374f(c41531v);
            c41531v.mo66445ao(false);
            if (recyclerView.anJ.mo31918d(c41531v, c17479c, c17479c2)) {
                recyclerView.mo66396jA();
            }
        }

        /* renamed from: b */
        public final void mo42360b(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
            RecyclerView recyclerView = RecyclerView.this;
            c41531v.mo66445ao(false);
            if (recyclerView.anJ.mo31919e(c41531v, c17479c, c17479c2)) {
                recyclerView.mo66396jA();
            }
        }

        /* renamed from: c */
        public final void mo42361c(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
            c41531v.mo66445ao(false);
            if (RecyclerView.this.anA) {
                if (RecyclerView.this.anJ.mo31917a(c41531v, c41531v, c17479c, c17479c2)) {
                    RecyclerView.this.mo66396jA();
                }
            } else if (RecyclerView.this.anJ.mo31920f(c41531v, c17479c, c17479c2)) {
                RecyclerView.this.mo66396jA();
            }
        }

        /* renamed from: j */
        public final void mo42362j(C41531v c41531v) {
            RecyclerView.this.ank.mo31833a(c41531v.apJ, RecyclerView.this.anc);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$SavedState */
    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C253721();
        Parcelable apd;

        /* renamed from: android.support.v7.widget.RecyclerView$SavedState$1 */
        static class C253721 implements ClassLoaderCreator<SavedState> {
            C253721() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = C17480i.class.getClassLoader();
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

    /* renamed from: android.support.v7.widget.RecyclerView$h */
    public static abstract class C25373h {
        /* renamed from: a */
        public void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
        }

        /* renamed from: a */
        public void mo18494a(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: a */
        public void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            view.getLayoutParams();
            rect.set(0, 0, 0, 0);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$o */
    public final class C25374o {
        final ArrayList<C41531v> aoV = new ArrayList();
        ArrayList<C41531v> aoW = null;
        final ArrayList<C41531v> aoX = new ArrayList();
        final List<C41531v> aoY = Collections.unmodifiableList(this.aoV);
        int aoZ = 2;
        int apa = 2;
        C17482n apb;
        C31881t apc;

        public final void clear() {
            this.aoV.clear();
            m40036kc();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kb */
        public final void mo42380kb() {
            this.apa = (RecyclerView.this.ank != null ? RecyclerView.this.ank.aoH : 0) + this.aoZ;
            for (int size = this.aoX.size() - 1; size >= 0 && this.aoX.size() > this.apa; size--) {
                mo42374cs(size);
            }
        }

        /* renamed from: q */
        private boolean m40037q(C41531v c41531v) {
            if (c41531v.isRemoved()) {
                return RecyclerView.this.anY.apv;
            }
            if (c41531v.mPosition < 0 || c41531v.mPosition >= RecyclerView.this.f16849Yq.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c41531v + RecyclerView.this.mo66399ji());
            } else if (!RecyclerView.this.anY.apv && RecyclerView.this.f16849Yq.getItemViewType(c41531v.mPosition) != c41531v.apN) {
                return false;
            } else {
                if (!RecyclerView.this.f16849Yq.aoq) {
                    return true;
                }
                if (c41531v.apM == RecyclerView.this.f16849Yq.getItemId(c41531v.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        /* renamed from: a */
        private boolean m40031a(C41531v c41531v, int i, int i2, long j) {
            long j2;
            c41531v.apZ = RecyclerView.this;
            int i3 = c41531v.apN;
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE) {
                boolean z;
                j2 = this.apb.mo31886co(i3).aoU;
                if (j2 == 0 || j2 + nanoTime < j) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            C41523a c41523a = RecyclerView.this.f16849Yq;
            c41531v.mPosition = i;
            if (c41523a.aoq) {
                c41531v.apM = c41523a.getItemId(i);
            }
            c41531v.setFlags(1, C19403g.CTRL_INDEX);
            C31862f.beginSection("RV OnBindView");
            c41523a.mo27742a(c41531v, i, c41531v.mo66465kv());
            c41531v.mo66464ku();
            LayoutParams layoutParams = c41531v.apJ.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).aoN = true;
            }
            C31862f.endSection();
            j2 = RecyclerView.this.getNanoTime() - nanoTime;
            C17483a co = this.apb.mo31886co(c41531v.apN);
            co.aoU = C17482n.m27233c(co.aoU, j2);
            if (RecyclerView.this.mo66405jx()) {
                View view = c41531v.apJ;
                if (C0477s.m892S(view) == 0) {
                    C0477s.m949o(view, 1);
                }
                if (!C0477s.m889P(view)) {
                    c41531v.addFlags(16384);
                    C0477s.m905a(view, RecyclerView.this.aof.aqa);
                }
            }
            if (RecyclerView.this.anY.apv) {
                c41531v.apO = i2;
            }
            return true;
        }

        /* renamed from: cp */
        public final int mo42371cp(int i) {
            if (i >= 0 && i < RecyclerView.this.anY.getItemCount()) {
                return !RecyclerView.this.anY.apv ? i : RecyclerView.this.ane.mo66564bA(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.anY.getItemCount() + RecyclerView.this.mo66399ji());
            }
        }

        /* renamed from: cq */
        public final View mo42372cq(int i) {
            return mo42373cr(i);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cr */
        public final View mo42373cr(int i) {
            return mo42375e(i, Long.MAX_VALUE).apJ;
        }

        /* Access modifiers changed, original: final */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x010a  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0120  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: e */
        public final C41531v mo42375e(int i, long j) {
            boolean z = true;
            if (i < 0 || i >= RecyclerView.this.anY.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.anY.getItemCount() + RecyclerView.this.mo66399ji());
            }
            C41531v ct;
            boolean z2;
            C41531v cu;
            boolean z3;
            LayoutParams layoutParams;
            if (RecyclerView.this.anY.apv) {
                ct = m40033ct(i);
                z2 = ct != null;
            } else {
                ct = null;
                z2 = false;
            }
            if (ct == null) {
                cu = m40034cu(i);
                if (cu != null) {
                    if (m40037q(cu)) {
                        z2 = true;
                    } else {
                        cu.addFlags(4);
                        if (cu.mo66456kl()) {
                            RecyclerView.this.removeDetachedView(cu.apJ, false);
                            cu.mo66457km();
                        } else if (cu.mo66458kn()) {
                            cu.mo66459ko();
                        }
                        mo42381s(cu);
                        cu = null;
                    }
                }
            } else {
                cu = ct;
            }
            if (cu == null) {
                int bA = RecyclerView.this.ane.mo66564bA(i);
                if (bA < 0 || bA >= RecyclerView.this.f16849Yq.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + bA + ").state:" + RecyclerView.this.anY.getItemCount() + RecyclerView.this.mo66399ji());
                }
                boolean z4;
                int itemViewType = RecyclerView.this.f16849Yq.getItemViewType(bA);
                if (RecyclerView.this.f16849Yq.aoq) {
                    cu = m40032b(RecyclerView.this.f16849Yq.getItemId(bA), itemViewType);
                    if (cu != null) {
                        cu.mPosition = bA;
                        z4 = true;
                        if (cu == null) {
                            cu = getRecycledViewPool().mo31885cn(itemViewType);
                            if (cu != null) {
                                cu.resetInternal();
                                if (RecyclerView.amU) {
                                    m40038r(cu);
                                }
                            }
                        }
                        if (cu == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j != Long.MAX_VALUE && !this.apb.mo31884b(itemViewType, nanoTime, j)) {
                                return null;
                            }
                            cu = RecyclerView.this.f16849Yq.mo66314c(RecyclerView.this, itemViewType);
                            if (RecyclerView.amX) {
                                RecyclerView br = RecyclerView.m72549br(cu.apJ);
                                if (br != null) {
                                    cu.apK = new WeakReference(br);
                                }
                            }
                            this.apb.mo31887d(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
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
            if (z3 && !RecyclerView.this.anY.apv && ct.mo66446cx(Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                ct.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                if (RecyclerView.this.anY.apy) {
                    RecyclerView.this.mo66333a(ct, RecyclerView.this.anJ.mo51944a(RecyclerView.this.anY, ct, C31879f.m51693l(ct) | 4096, ct.mo66465kv()));
                }
            }
            if (RecyclerView.this.anY.apv && ct.isBound()) {
                ct.apO = i;
                z2 = false;
            } else if (!ct.isBound() || ct.mo66462kr() || ct.mo66461kq()) {
                z2 = m40031a(ct, RecyclerView.this.ane.mo66564bA(i), i, j);
            } else {
                z2 = false;
            }
            LayoutParams layoutParams2 = ct.apJ.getLayoutParams();
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

        /* renamed from: r */
        private void m40038r(C41531v c41531v) {
            if (c41531v.apJ instanceof ViewGroup) {
                m40035d((ViewGroup) c41531v.apJ, false);
            }
        }

        /* renamed from: d */
        private void m40035d(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m40035d((ViewGroup) childAt, true);
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

        /* renamed from: bI */
        public final void mo42367bI(View view) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (bn.mo66463ks()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (bn.mo66456kl()) {
                bn.mo66457km();
            } else if (bn.mo66458kn()) {
                bn.mo66459ko();
            }
            mo42381s(bn);
        }

        /* renamed from: kc */
        private void m40036kc() {
            for (int size = this.aoX.size() - 1; size >= 0; size--) {
                mo42374cs(size);
            }
            this.aoX.clear();
            if (RecyclerView.amX) {
                RecyclerView.this.anX.mo18524ig();
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cs */
        public final void mo42374cs(int i) {
            mo42366a((C41531v) this.aoX.get(i), true);
            this.aoX.remove(i);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: s */
        public final void mo42381s(C41531v c41531v) {
            boolean z = true;
            if (c41531v.mo66456kl() || c41531v.apJ.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + c41531v.mo66456kl() + " isAttached:" + (c41531v.apJ.getParent() != null) + RecyclerView.this.mo66399ji());
            } else if (c41531v.mo66463ks()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c41531v + RecyclerView.this.mo66399ji());
            } else if (c41531v.mo66452kh()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.mo66399ji());
            } else {
                boolean z2;
                boolean v = C41531v.m72649v(c41531v);
                if (c41531v.mo66466kw()) {
                    if (this.apa <= 0 || c41531v.mo66446cx(C2288t.CTRL_INDEX)) {
                        z2 = false;
                    } else {
                        int size = this.aoX.size();
                        if (size >= this.apa && size > 0) {
                            mo42374cs(0);
                            size--;
                        }
                        if (RecyclerView.amX && size > 0 && !RecyclerView.this.anX.mo18523bM(c41531v.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.anX.mo18523bM(((C41531v) this.aoX.get(i)).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.aoX.add(size, c41531v);
                        z2 = true;
                    }
                    if (z2) {
                        z = false;
                    } else {
                        mo42366a(c41531v, true);
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                RecyclerView.this.ang.mo72243L(c41531v);
                if (!z2 && !z && v) {
                    c41531v.apZ = null;
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo42366a(C41531v c41531v, boolean z) {
            RecyclerView.m72557h(c41531v);
            if (c41531v.mo66446cx(16384)) {
                c41531v.setFlags(0, 16384);
                C0477s.m905a(c41531v.apJ, null);
            }
            if (z) {
                m40039u(c41531v);
            }
            c41531v.apZ = null;
            getRecycledViewPool().mo31890p(c41531v);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bJ */
        public final void mo42368bJ(View view) {
            C41531v bn = RecyclerView.m72546bn(view);
            bn.apV = null;
            bn.apW = false;
            bn.mo66459ko();
            mo42381s(bn);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bK */
        public final void mo42369bK(View view) {
            C41531v bn = RecyclerView.m72546bn(view);
            if (!bn.mo66446cx(12) && bn.mo66467kx()) {
                boolean z;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.anJ == null || recyclerView.anJ.mo22567a(bn, bn.mo66465kv())) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (this.aoW == null) {
                        this.aoW = new ArrayList();
                    }
                    bn.mo66443a(this, true);
                    this.aoW.add(bn);
                    return;
                }
            }
            if (!bn.mo66461kq() || bn.isRemoved() || RecyclerView.this.f16849Yq.aoq) {
                bn.mo66443a(this, false);
                this.aoV.add(bn);
                return;
            }
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.mo66399ji());
        }

        /* Access modifiers changed, original: final */
        /* renamed from: t */
        public final void mo42382t(C41531v c41531v) {
            if (c41531v.apW) {
                this.aoW.remove(c41531v);
            } else {
                this.aoV.remove(c41531v);
            }
            c41531v.apV = null;
            c41531v.apW = false;
            c41531v.mo66459ko();
        }

        /* renamed from: ct */
        private C41531v m40033ct(int i) {
            int i2 = 0;
            if (this.aoW != null) {
                int size = this.aoW.size();
                if (size != 0) {
                    C41531v c41531v;
                    int i3 = 0;
                    while (i3 < size) {
                        c41531v = (C41531v) this.aoW.get(i3);
                        if (c41531v.mo66458kn() || c41531v.mo66453ki() != i) {
                            i3++;
                        } else {
                            c41531v.addFlags(32);
                            return c41531v;
                        }
                    }
                    if (RecyclerView.this.f16849Yq.aoq) {
                        int N = RecyclerView.this.ane.mo66563N(i, 0);
                        if (N > 0 && N < RecyclerView.this.f16849Yq.getItemCount()) {
                            long itemId = RecyclerView.this.f16849Yq.getItemId(N);
                            while (i2 < size) {
                                c41531v = (C41531v) this.aoW.get(i2);
                                if (c41531v.mo66458kn() || c41531v.apM != itemId) {
                                    i2++;
                                } else {
                                    c41531v.addFlags(32);
                                    return c41531v;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        /* renamed from: cu */
        private C41531v m40034cu(int i) {
            C41531v c41531v;
            View view;
            int i2 = 0;
            int size = this.aoV.size();
            int i3 = 0;
            while (i3 < size) {
                c41531v = (C41531v) this.aoV.get(i3);
                if (c41531v.mo66458kn() || c41531v.mo66453ki() != i || c41531v.mo66461kq() || (!RecyclerView.this.anY.apv && c41531v.isRemoved())) {
                    i3++;
                } else {
                    c41531v.addFlags(32);
                    return c41531v;
                }
            }
            C31892v c31892v = RecyclerView.this.anf;
            int size2 = c31892v.ahc.size();
            for (i3 = 0; i3 < size2; i3++) {
                View view2 = (View) c31892v.ahc.get(i3);
                C41531v aZ = c31892v.aha.mo18461aZ(view2);
                if (aZ.mo66453ki() == i && !aZ.mo66461kq() && !aZ.isRemoved()) {
                    view = view2;
                    break;
                }
            }
            view = null;
            if (view != null) {
                c41531v = RecyclerView.m72546bn(view);
                C31892v c31892v2 = RecyclerView.this.anf;
                i2 = c31892v2.aha.indexOfChild(view);
                if (i2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
                } else if (c31892v2.ahb.get(i2)) {
                    c31892v2.ahb.clear(i2);
                    c31892v2.mo51990aX(view);
                    int indexOfChild = RecyclerView.this.anf.indexOfChild(view);
                    if (indexOfChild == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c41531v + RecyclerView.this.mo66399ji());
                    }
                    RecyclerView.this.anf.detachViewFromParent(indexOfChild);
                    mo42369bK(view);
                    c41531v.addFlags(8224);
                    return c41531v;
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
                }
            }
            i3 = this.aoX.size();
            while (i2 < i3) {
                c41531v = (C41531v) this.aoX.get(i2);
                if (c41531v.mo66461kq() || c41531v.mo66453ki() != i) {
                    i2++;
                } else {
                    this.aoX.remove(i2);
                    return c41531v;
                }
            }
            return null;
        }

        /* renamed from: b */
        private C41531v m40032b(long j, int i) {
            int size;
            C41531v c41531v;
            for (size = this.aoV.size() - 1; size >= 0; size--) {
                c41531v = (C41531v) this.aoV.get(size);
                if (c41531v.apM == j && !c41531v.mo66458kn()) {
                    if (i == c41531v.apN) {
                        c41531v.addFlags(32);
                        if (!c41531v.isRemoved() || RecyclerView.this.anY.apv) {
                            return c41531v;
                        }
                        c41531v.setFlags(2, 14);
                        return c41531v;
                    }
                    this.aoV.remove(size);
                    RecyclerView.this.removeDetachedView(c41531v.apJ, false);
                    mo42368bJ(c41531v.apJ);
                }
            }
            size = this.aoX.size() - 1;
            while (size >= 0) {
                c41531v = (C41531v) this.aoX.get(size);
                if (c41531v.apM != j) {
                    size--;
                } else if (i == c41531v.apN) {
                    this.aoX.remove(size);
                    return c41531v;
                } else {
                    mo42374cs(size);
                    return null;
                }
            }
            return null;
        }

        /* renamed from: u */
        private void m40039u(C41531v c41531v) {
            if (RecyclerView.this.f16849Yq != null) {
                RecyclerView.this.f16849Yq.mo51794a(c41531v);
            }
            if (RecyclerView.this.anY != null) {
                RecyclerView.this.ang.mo72243L(c41531v);
            }
        }

        /* Access modifiers changed, original: final */
        public final C17482n getRecycledViewPool() {
            if (this.apb == null) {
                this.apb = new C17482n();
            }
            return this.apb;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: jN */
        public final void mo42379jN() {
            int size = this.aoX.size();
            for (int i = 0; i < size; i++) {
                C41531v c41531v = (C41531v) this.aoX.get(i);
                if (c41531v != null) {
                    c41531v.addFlags(6);
                    c41531v.mo66442O(null);
                }
            }
            if (RecyclerView.this.f16849Yq == null || !RecyclerView.this.f16849Yq.aoq) {
                m40036kc();
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: jM */
        public final void mo42378jM() {
            int i;
            int i2 = 0;
            int size = this.aoX.size();
            for (i = 0; i < size; i++) {
                ((C41531v) this.aoX.get(i)).mo66450kf();
            }
            size = this.aoV.size();
            for (i = 0; i < size; i++) {
                ((C41531v) this.aoV.get(i)).mo66450kf();
            }
            if (this.aoW != null) {
                i = this.aoW.size();
                while (i2 < i) {
                    ((C41531v) this.aoW.get(i2)).mo66450kf();
                    i2++;
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: jK */
        public final void mo42377jK() {
            int size = this.aoX.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) ((C41531v) this.aoX.get(i)).apJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.aoN = true;
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$f */
    public static abstract class C31879f {
        C17478b aor = null;
        private ArrayList<C17477a> aos = new ArrayList();
        public long aot = 200;
        public long aou = 200;
        public long aov = 200;
        public long aow = 200;

        /* renamed from: android.support.v7.widget.RecyclerView$f$a */
        public interface C17477a {
            /* renamed from: jT */
            void mo22448jT();
        }

        /* renamed from: android.support.v7.widget.RecyclerView$f$b */
        interface C17478b {
            /* renamed from: n */
            void mo18472n(C41531v c41531v);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$f$c */
        public static class C17479c {
            public int aox;
            public int bottom;
            public int left;
            public int right;
            public int top;

            /* renamed from: c */
            public C17479c mo31823c(C41531v c41531v, int i) {
                View view = c41531v.apJ;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        /* renamed from: a */
        public abstract boolean mo31917a(C41531v c41531v, C41531v c41531v2, C17479c c17479c, C17479c c17479c2);

        /* renamed from: d */
        public abstract void mo22570d(C41531v c41531v);

        /* renamed from: d */
        public abstract boolean mo31918d(C41531v c41531v, C17479c c17479c, C17479c c17479c2);

        /* renamed from: e */
        public abstract boolean mo31919e(C41531v c41531v, C17479c c17479c, C17479c c17479c2);

        /* renamed from: f */
        public abstract boolean mo31920f(C41531v c41531v, C17479c c17479c, C17479c c17479c2);

        /* renamed from: hX */
        public abstract void mo22571hX();

        /* renamed from: hZ */
        public abstract void mo22573hZ();

        public abstract boolean isRunning();

        /* renamed from: l */
        static int m51693l(C41531v c41531v) {
            int A = c41531v.f16852Dj & 14;
            if (c41531v.mo66461kq()) {
                return 4;
            }
            if ((A & 4) != 0) {
                return A;
            }
            int i = c41531v.apL;
            int kj = c41531v.mo66454kj();
            if (i == -1 || kj == -1 || i == kj) {
                return A;
            }
            return A | 2048;
        }

        /* renamed from: m */
        public final void mo51947m(C41531v c41531v) {
            mo51948n(c41531v);
            if (this.aor != null) {
                this.aor.mo18472n(c41531v);
            }
        }

        /* renamed from: n */
        public void mo51948n(C41531v c41531v) {
        }

        /* renamed from: a */
        public final boolean mo51945a(C17477a c17477a) {
            boolean isRunning = isRunning();
            if (c17477a != null) {
                if (isRunning) {
                    this.aos.add(c17477a);
                } else {
                    c17477a.mo22448jT();
                }
            }
            return isRunning;
        }

        /* renamed from: o */
        public boolean mo31922o(C41531v c41531v) {
            return true;
        }

        /* renamed from: a */
        public boolean mo22567a(C41531v c41531v, List<Object> list) {
            return mo31922o(c41531v);
        }

        /* renamed from: jS */
        public final void mo51946jS() {
            int size = this.aos.size();
            for (int i = 0; i < size; i++) {
                ((C17477a) this.aos.get(i)).mo22448jT();
            }
            this.aos.clear();
        }

        /* renamed from: a */
        public C17479c mo51944a(C31880s c31880s, C41531v c41531v, int i, List<Object> list) {
            return new C17479c().mo31823c(c41531v, 0);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$s */
    public static class C31880s {
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
        /* renamed from: cw */
        public final void mo51949cw(int i) {
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

    /* renamed from: android.support.v7.widget.RecyclerView$t */
    public static abstract class C31881t {
    }

    /* renamed from: android.support.v7.widget.RecyclerView$u */
    class C31882u implements Runnable {
        int apF;
        int apG;
        private boolean apH = false;
        private boolean apI = false;
        Interpolator mInterpolator = RecyclerView.aom;
        /* renamed from: qN */
        OverScroller f14656qN;

        C31882u() {
            this.f14656qN = new OverScroller(RecyclerView.this.getContext(), RecyclerView.aom);
        }

        public final void run() {
            if (RecyclerView.this.ank == null) {
                stop();
                return;
            }
            this.apI = false;
            this.apH = true;
            RecyclerView.this.mo66401jk();
            OverScroller overScroller = this.f14656qN;
            C37139r c37139r = RecyclerView.this.ank.aoC;
            if (overScroller.computeScrollOffset()) {
                int i;
                int i2;
                int a;
                int i3;
                int i4;
                int i5;
                int[] b = RecyclerView.this.f16848Re;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.apF;
                int i7 = currY - this.apG;
                this.apF = currX;
                this.apG = currY;
                if (RecyclerView.this.mo66335a(i6, i7, b, null, 1)) {
                    i = i7 - b[1];
                    i2 = i6 - b[0];
                } else {
                    i = i7;
                    i2 = i6;
                }
                if (RecyclerView.this.f16849Yq != null) {
                    RecyclerView.this.mo66402jl();
                    RecyclerView.this.mo66404jw();
                    C31862f.beginSection("RV Scroll");
                    RecyclerView.this.mo66407m(RecyclerView.this.anY);
                    if (i2 != 0) {
                        a = RecyclerView.this.ank.mo1746a(i2, RecyclerView.this.anc, RecyclerView.this.anY);
                        i3 = i2 - a;
                    } else {
                        i3 = 0;
                        a = 0;
                    }
                    if (i != 0) {
                        i6 = RecyclerView.this.ank.mo1759b(i, RecyclerView.this.anc, RecyclerView.this.anY);
                        i4 = i - i6;
                        i7 = i6;
                    } else {
                        i4 = 0;
                        i7 = 0;
                    }
                    C31862f.endSection();
                    RecyclerView.this.mo66398jP();
                    RecyclerView.this.mo66341al(true);
                    RecyclerView.this.mo66339ak(false);
                    if (!(c37139r == null || c37139r.apf || !c37139r.apg)) {
                        i6 = RecyclerView.this.anY.getItemCount();
                        if (i6 == 0) {
                            c37139r.stop();
                            i5 = i4;
                            i6 = a;
                        } else {
                            if (c37139r.ape >= i6) {
                                c37139r.ape = i6 - 1;
                            }
                            C37139r.m62163a(c37139r, i2 - i3, i - i4);
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
                    RecyclerView.this.mo66340al(i2, i);
                }
                if (!(RecyclerView.this.mo66334a(i6, i7, i3, i5, null, 1) || (i3 == 0 && i5 == 0))) {
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
                        RecyclerView.this.mo66342am(i8, a);
                    }
                    if ((i8 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (a != 0 || i5 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (!(i6 == 0 && i7 == 0)) {
                    RecyclerView.this.mo66345aq(i6, i7);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                Object obj = (i != 0 && RecyclerView.this.ank.mo1777iH() && i7 == i) ? 1 : null;
                Object obj2 = (i2 != 0 && RecyclerView.this.ank.mo1776iG() && i6 == i2) ? 1 : null;
                obj2 = (!(i2 == 0 && i == 0) && obj2 == null && obj == null) ? null : 1;
                if (overScroller.isFinished() || (obj2 == null && !RecyclerView.this.getScrollingChildHelper().mo1068aI(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.amX) {
                        RecyclerView.this.anX.mo18524ig();
                    }
                    RecyclerView.this.mo66336aJ(1);
                } else {
                    mo51955ke();
                    if (RecyclerView.this.anW != null) {
                        RecyclerView.this.anW.mo18518b(RecyclerView.this, i2, i);
                    }
                }
            }
            if (c37139r != null) {
                if (c37139r.apf) {
                    C37139r.m62163a(c37139r, 0, 0);
                }
                if (!this.apI) {
                    c37139r.stop();
                }
            }
            this.apH = false;
            if (this.apI) {
                mo51955ke();
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ke */
        public final void mo51955ke() {
            if (this.apH) {
                this.apI = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            C0477s.m934b(RecyclerView.this, (Runnable) this);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aG */
        public final void mo51953aG(int i, int i2) {
            mo51956n(i, i2, m51710aH(i, i2));
        }

        private static float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: aH */
        private int m51710aH(int i, int i2) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i3 = width / 2;
            float distanceInfluenceForSnapDuration = (C31882u.distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i3)) + ((float) i3);
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

        /* renamed from: n */
        public final void mo51956n(int i, int i2, int i3) {
            mo51954b(i, i2, i3, RecyclerView.aom);
        }

        /* renamed from: a */
        public final void mo51952a(int i, int i2, Interpolator interpolator) {
            int aH = m51710aH(i, i2);
            if (interpolator == null) {
                interpolator = RecyclerView.aom;
            }
            mo51954b(i, i2, aH, interpolator);
        }

        /* renamed from: b */
        public final void mo51954b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.f14656qN = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.apG = 0;
            this.apF = 0;
            this.f14656qN.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.f14656qN.computeScrollOffset();
            }
            mo51955ke();
        }

        public final void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.f14656qN.abortAnimation();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        final Rect ala = new Rect();
        public C41531v aoM;
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

    /* renamed from: android.support.v7.widget.RecyclerView$l */
    public interface C37137l {
        /* renamed from: ab */
        void mo18505ab(boolean z);

        /* renamed from: h */
        boolean mo18506h(MotionEvent motionEvent);

        /* renamed from: i */
        void mo18507i(MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$r */
    public static abstract class C37139r {
        RecyclerView aiB;
        C17480i amP;
        public int ape = -1;
        boolean apf;
        boolean apg;
        View aph;
        private final C37138a api = new C37138a();

        /* renamed from: android.support.v7.widget.RecyclerView$r$a */
        public static class C37138a {
            private int apj;
            private int apk;
            int apl;
            private boolean apm;
            private int apn;
            private int mDuration;
            private Interpolator mInterpolator;

            public C37138a() {
                this((byte) 0);
            }

            private C37138a(byte b) {
                this.apl = -1;
                this.apm = false;
                this.apn = 0;
                this.apj = 0;
                this.apk = 0;
                this.mDuration = C8415j.INVALID_ID;
                this.mInterpolator = null;
            }

            /* Access modifiers changed, original: final */
            /* renamed from: h */
            public final void mo59204h(RecyclerView recyclerView) {
                if (this.apl >= 0) {
                    int i = this.apl;
                    this.apl = -1;
                    recyclerView.mo66355cd(i);
                    this.apm = false;
                } else if (this.apm) {
                    validate();
                    if (this.mInterpolator != null) {
                        recyclerView.anV.mo51954b(this.apj, this.apk, this.mDuration, this.mInterpolator);
                    } else if (this.mDuration == C8415j.INVALID_ID) {
                        recyclerView.anV.mo51953aG(this.apj, this.apk);
                    } else {
                        recyclerView.anV.mo51956n(this.apj, this.apk, this.mDuration);
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

            /* renamed from: a */
            public final void mo59203a(int i, int i2, int i3, Interpolator interpolator) {
                this.apj = i;
                this.apk = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.apm = true;
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$r$b */
        public interface C37140b {
            /* renamed from: bX */
            PointF mo1761bX(int i);
        }

        /* renamed from: a */
        public abstract void mo59205a(int i, int i2, C37138a c37138a);

        /* renamed from: a */
        public abstract void mo9234a(View view, C37138a c37138a);

        public abstract void onStop();

        /* renamed from: cv */
        public final void mo59207cv(int i) {
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
                C17480i.m27140a(this.amP, this);
                this.amP = null;
                this.aiB = null;
            }
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: bL */
        public final void mo59206bL(View view) {
            if (RecyclerView.m72548bp(view) == this.ape) {
                this.aph = view;
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$a */
    public static abstract class C41523a<VH extends C41531v> {
        public final C41524b aop = new C41524b();
        protected boolean aoq = false;

        /* renamed from: a */
        public abstract VH mo4976a(ViewGroup viewGroup, int i);

        /* renamed from: a */
        public abstract void mo4977a(VH vh, int i);

        public abstract int getItemCount();

        /* renamed from: a */
        public void mo27742a(VH vh, int i, List<Object> list) {
            mo4977a((C41531v) vh, i);
        }

        /* renamed from: c */
        public final VH mo66314c(ViewGroup viewGroup, int i) {
            try {
                C31862f.beginSection("RV CreateView");
                VH a = mo4976a(viewGroup, i);
                if (a.apJ.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                a.apN = i;
                return a;
            } finally {
                C31862f.endSection();
            }
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public long getItemId(int i) {
            return -1;
        }

        /* renamed from: a */
        public void mo51794a(VH vh) {
        }

        /* renamed from: k */
        public void mo26080k(VH vh) {
        }

        /* renamed from: a */
        public final void mo66307a(C41525c c41525c) {
            this.aop.registerObserver(c41525c);
        }

        /* renamed from: b */
        public final void mo66313b(C41525c c41525c) {
            this.aop.unregisterObserver(c41525c);
        }

        public final void notifyDataSetChanged() {
            this.aop.notifyChanged();
        }

        /* renamed from: cg */
        public final void mo66316cg(int i) {
            this.aop.mo66321ar(i, 1);
        }

        /* renamed from: b */
        public final void mo66312b(int i, Object obj) {
            this.aop.mo66325c(i, 1, obj);
        }

        /* renamed from: ar */
        public final void mo66308ar(int i, int i2) {
            this.aop.mo66321ar(i, i2);
        }

        /* renamed from: c */
        public final void mo66315c(int i, int i2, Object obj) {
            this.aop.mo66325c(i, i2, obj);
        }

        /* renamed from: ch */
        public final void mo66317ch(int i) {
            this.aop.mo66323at(i, 1);
        }

        /* renamed from: as */
        public final void mo66309as(int i, int i2) {
            this.aop.mo66322as(i, i2);
        }

        /* renamed from: at */
        public final void mo66310at(int i, int i2) {
            this.aop.mo66323at(i, i2);
        }

        /* renamed from: ci */
        public final void mo66318ci(int i) {
            this.aop.mo66324au(i, 1);
        }

        /* renamed from: au */
        public final void mo66311au(int i, int i2) {
            this.aop.mo66324au(i, i2);
        }

        /* renamed from: jR */
        public final void mo66319jR() {
            if (this.aop.hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.aoq = true;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$b */
    public static class C41524b extends Observable<C41525c> {
        C41524b() {
        }

        public final boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C41525c) this.mObservers.get(size)).onChanged();
            }
        }

        /* renamed from: ar */
        public final void mo66321ar(int i, int i2) {
            mo66325c(i, i2, null);
        }

        /* renamed from: c */
        public final void mo66325c(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C41525c) this.mObservers.get(size)).mo18475d(i, i2, obj);
            }
        }

        /* renamed from: at */
        public final void mo66323at(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C41525c) this.mObservers.get(size)).mo18473aw(i, i2);
            }
        }

        /* renamed from: au */
        public final void mo66324au(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C41525c) this.mObservers.get(size)).mo6644ax(i, i2);
            }
        }

        /* renamed from: as */
        public final void mo66322as(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C41525c) this.mObservers.get(size)).mo18474ay(i, i2);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$c */
    public static abstract class C41525c {
        public void onChanged() {
        }

        /* renamed from: av */
        public void mo35178av(int i, int i2) {
        }

        /* renamed from: d */
        public void mo18475d(int i, int i2, Object obj) {
            mo35178av(i, i2);
        }

        /* renamed from: aw */
        public void mo18473aw(int i, int i2) {
        }

        /* renamed from: ax */
        public void mo6644ax(int i, int i2) {
        }

        /* renamed from: ay */
        public void mo18474ay(int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$d */
    public interface C41526d {
        /* renamed from: az */
        int mo18508az(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$j */
    public interface C41527j {
        /* renamed from: bH */
        void mo18499bH(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$6 */
    class C415286 implements C37146a {
        C415286() {
        }

        /* renamed from: bC */
        public final C41531v mo59227bC(int i) {
            C41531v bn;
            RecyclerView recyclerView = RecyclerView.this;
            int hU = recyclerView.anf.mo51996hU();
            int i2 = 0;
            C41531v c41531v = null;
            while (i2 < hU) {
                bn = RecyclerView.m72546bn(recyclerView.anf.mo51992bI(i2));
                if (bn != null && !bn.isRemoved() && bn.mPosition == i) {
                    if (!recyclerView.anf.mo51991aY(bn.apJ)) {
                        break;
                    }
                } else {
                    bn = c41531v;
                }
                i2++;
                c41531v = bn;
            }
            bn = c41531v;
            if (bn == null) {
                return null;
            }
            if (RecyclerView.this.anf.mo51991aY(bn.apJ)) {
                return null;
            }
            return bn;
        }

        /* renamed from: O */
        public final void mo59222O(int i, int i2) {
            RecyclerView.this.mo66373e(i, i2, true);
            RecyclerView.this.aob = true;
            C31880s c31880s = RecyclerView.this.anY;
            c31880s.apr += i2;
        }

        /* renamed from: P */
        public final void mo59223P(int i, int i2) {
            RecyclerView.this.mo66373e(i, i2, false);
            RecyclerView.this.aob = true;
        }

        /* renamed from: b */
        public final void mo59226b(int i, int i2, Object obj) {
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            int hU = recyclerView.anf.mo51996hU();
            int i4 = i + i2;
            for (i3 = 0; i3 < hU; i3++) {
                View bI = recyclerView.anf.mo51992bI(i3);
                C41531v bn = RecyclerView.m72546bn(bI);
                if (bn != null && !bn.mo66452kh() && bn.mPosition >= i && bn.mPosition < i4) {
                    bn.addFlags(2);
                    bn.mo66442O(obj);
                    ((LayoutParams) bI.getLayoutParams()).aoN = true;
                }
            }
            C25374o c25374o = recyclerView.anc;
            hU = i + i2;
            for (i3 = c25374o.aoX.size() - 1; i3 >= 0; i3--) {
                C41531v c41531v = (C41531v) c25374o.aoX.get(i3);
                if (c41531v != null) {
                    i4 = c41531v.mPosition;
                    if (i4 >= i && i4 < hU) {
                        c41531v.addFlags(2);
                        c25374o.mo42374cs(i3);
                    }
                }
            }
            RecyclerView.this.aoc = true;
        }

        /* renamed from: d */
        public final void mo59228d(C41539b c41539b) {
            m72633f(c41539b);
        }

        /* renamed from: f */
        private void m72633f(C41539b c41539b) {
            switch (c41539b.f16871Cn) {
                case 1:
                    RecyclerView.this.ank.mo15123c(RecyclerView.this, c41539b.afe, c41539b.afg);
                    return;
                case 2:
                    RecyclerView.this.ank.mo15125d(RecyclerView.this, c41539b.afe, c41539b.afg);
                    return;
                case 4:
                    RecyclerView.this.ank.mo31831a(RecyclerView.this, c41539b.afe, c41539b.afg, c41539b.aff);
                    return;
                case 8:
                    RecyclerView.this.ank.mo31830a(RecyclerView.this, c41539b.afe, c41539b.afg, 1);
                    return;
                default:
                    return;
            }
        }

        /* renamed from: e */
        public final void mo59229e(C41539b c41539b) {
            m72633f(c41539b);
        }

        /* renamed from: Q */
        public final void mo59224Q(int i, int i2) {
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            int hU = recyclerView.anf.mo51996hU();
            for (i3 = 0; i3 < hU; i3++) {
                C41531v bn = RecyclerView.m72546bn(recyclerView.anf.mo51992bI(i3));
                if (!(bn == null || bn.mo66452kh() || bn.mPosition < i)) {
                    bn.mo66468o(i2, false);
                    recyclerView.anY.apu = true;
                }
            }
            C25374o c25374o = recyclerView.anc;
            int size = c25374o.aoX.size();
            for (i3 = 0; i3 < size; i3++) {
                C41531v c41531v = (C41531v) c25374o.aoX.get(i3);
                if (c41531v != null && c41531v.mPosition >= i) {
                    c41531v.mo66468o(i2, true);
                }
            }
            recyclerView.requestLayout();
            RecyclerView.this.aob = true;
        }

        /* renamed from: R */
        public final void mo59225R(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7 = -1;
            RecyclerView recyclerView = RecyclerView.this;
            int hU = recyclerView.anf.mo51996hU();
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
                C41531v bn = RecyclerView.m72546bn(recyclerView.anf.mo51992bI(i6));
                if (bn != null && bn.mPosition >= i5 && bn.mPosition <= i4) {
                    if (bn.mPosition == i) {
                        bn.mo66468o(i2 - i, false);
                    } else {
                        bn.mo66468o(i3, false);
                    }
                    recyclerView.anY.apu = true;
                }
            }
            C25374o c25374o = recyclerView.anc;
            if (i < i2) {
                i4 = i2;
                i5 = i;
            } else {
                i7 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = c25374o.aoX.size();
            for (i6 = 0; i6 < size; i6++) {
                C41531v c41531v = (C41531v) c25374o.aoX.get(i6);
                if (c41531v != null && c41531v.mPosition >= r4 && c41531v.mPosition <= r3) {
                    if (c41531v.mPosition == i) {
                        c41531v.mo66468o(i2 - i, false);
                    } else {
                        c41531v.mo66468o(i7, false);
                    }
                }
            }
            recyclerView.requestLayout();
            RecyclerView.this.aob = true;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$k */
    public static abstract class C41529k {
        /* renamed from: aE */
        public abstract boolean mo26235aE(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$m */
    public static abstract class C41530m {
        /* renamed from: c */
        public void mo6643c(RecyclerView recyclerView, int i) {
        }

        /* renamed from: a */
        public void mo6642a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$v */
    public static abstract class C41531v {
        private static final List<Object> apR = Collections.EMPTY_LIST;
        /* renamed from: Dj */
        private int f16852Dj;
        public final View apJ;
        WeakReference<RecyclerView> apK;
        int apL = -1;
        public long apM = -1;
        public int apN = -1;
        int apO = -1;
        C41531v apP = null;
        C41531v apQ = null;
        List<Object> apS = null;
        List<Object> apT = null;
        private int apU = 0;
        private C25374o apV = null;
        private boolean apW = false;
        private int apX = 0;
        int apY = -1;
        RecyclerView apZ;
        int mPosition = -1;

        public C41531v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.apJ = view;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: o */
        public final void mo66468o(int i, boolean z) {
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
        /* renamed from: kf */
        public final void mo66450kf() {
            this.apL = -1;
            this.apO = -1;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kg */
        public final void mo66451kg() {
            if (this.apL == -1) {
                this.apL = this.mPosition;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kh */
        public final boolean mo66452kh() {
            return (this.f16852Dj & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.apO == -1 ? this.mPosition : this.apO;
        }

        /* renamed from: ki */
        public final int mo66453ki() {
            return this.apO == -1 ? this.mPosition : this.apO;
        }

        /* renamed from: kj */
        public final int mo66454kj() {
            if (this.apZ == null) {
                return -1;
            }
            return this.apZ.mo66394i(this);
        }

        /* renamed from: kk */
        public final int mo66455kk() {
            return this.apN;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kl */
        public final boolean mo66456kl() {
            return this.apV != null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: km */
        public final void mo66457km() {
            this.apV.mo42382t(this);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kn */
        public final boolean mo66458kn() {
            return (this.f16852Dj & 32) != 0;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ko */
        public final void mo66459ko() {
            this.f16852Dj &= -33;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kp */
        public final void mo66460kp() {
            this.f16852Dj &= -257;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo66443a(C25374o c25374o, boolean z) {
            this.apV = c25374o;
            this.apW = z;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kq */
        public final boolean mo66461kq() {
            return (this.f16852Dj & 4) != 0;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kr */
        public final boolean mo66462kr() {
            return (this.f16852Dj & 2) != 0;
        }

        /* Access modifiers changed, original: final */
        public final boolean isBound() {
            return (this.f16852Dj & 1) != 0;
        }

        public final boolean isRemoved() {
            return (this.f16852Dj & 8) != 0;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cx */
        public final boolean mo66446cx(int i) {
            return (this.f16852Dj & i) != 0;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ks */
        public final boolean mo66463ks() {
            return (this.f16852Dj & 256) != 0;
        }

        /* Access modifiers changed, original: final */
        public final void setFlags(int i, int i2) {
            this.f16852Dj = (this.f16852Dj & (i2 ^ -1)) | (i & i2);
        }

        /* Access modifiers changed, original: final */
        public final void addFlags(int i) {
            this.f16852Dj |= i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: O */
        public final void mo66442O(Object obj) {
            if (obj == null) {
                addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } else if ((this.f16852Dj & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                m72648kt();
                this.apS.add(obj);
            }
        }

        /* renamed from: kt */
        private void m72648kt() {
            if (this.apS == null) {
                this.apS = new ArrayList();
                this.apT = Collections.unmodifiableList(this.apS);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ku */
        public final void mo66464ku() {
            if (this.apS != null) {
                this.apS.clear();
            }
            this.f16852Dj &= -1025;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kv */
        public final List<Object> mo66465kv() {
            if ((this.f16852Dj & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                return apR;
            }
            if (this.apS == null || this.apS.size() == 0) {
                return apR;
            }
            return this.apT;
        }

        /* Access modifiers changed, original: final */
        public final void resetInternal() {
            this.f16852Dj = 0;
            this.mPosition = -1;
            this.apL = -1;
            this.apM = -1;
            this.apO = -1;
            this.apU = 0;
            this.apP = null;
            this.apQ = null;
            mo66464ku();
            this.apX = 0;
            this.apY = -1;
            RecyclerView.m72557h(this);
        }

        public String toString() {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.apM + ", oldPos=" + this.apL + ", pLpos:" + this.apO);
            if (mo66456kl()) {
                stringBuilder.append(" scrap ").append(this.apW ? "[changeScrap]" : "[attachedScrap]");
            }
            if (mo66461kq()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (mo66462kr()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (mo66452kh()) {
                stringBuilder.append(" ignored");
            }
            if (mo66463ks()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!mo66466kw()) {
                stringBuilder.append(" not recyclable(" + this.apU + ")");
            }
            if ((this.f16852Dj & 512) != 0 || mo66461kq()) {
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

        /* renamed from: ao */
        public final void mo66445ao(boolean z) {
            this.apU = z ? this.apU - 1 : this.apU + 1;
            if (this.apU < 0) {
                this.apU = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && this.apU == 1) {
                this.f16852Dj |= 16;
            } else if (z && this.apU == 0) {
                this.f16852Dj &= -17;
            }
        }

        /* renamed from: kw */
        public final boolean mo66466kw() {
            return (this.f16852Dj & 16) == 0 && !C0477s.m890Q(this.apJ);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: kx */
        public final boolean mo66467kx() {
            return (this.f16852Dj & 2) != 0;
        }

        /* renamed from: b */
        static /* synthetic */ void m72647b(C41531v c41531v, RecyclerView recyclerView) {
            recyclerView.mo66349b(c41531v, c41531v.apX);
            c41531v.apX = 0;
        }

        /* renamed from: v */
        static /* synthetic */ boolean m72649v(C41531v c41531v) {
            return (c41531v.f16852Dj & 16) == 0 && C0477s.m890Q(c41531v.apJ);
        }

        /* renamed from: z */
        static /* synthetic */ boolean m72653z(C41531v c41531v) {
            return (c41531v.f16852Dj & 16) != 0;
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
        this.anb = new C8447q();
        this.anc = new C25374o();
        this.ang = new C44970bj();
        this.ani = new C253691();
        this.mTempRect = new Rect();
        this.f16851qT = new Rect();
        this.anj = new RectF();
        this.anm = new ArrayList();
        this.ann = new ArrayList();
        this.ant = 0;
        this.anA = false;
        this.anB = false;
        this.anC = 0;
        this.anD = 0;
        this.anE = new C17476e();
        this.anJ = new C31895y();
        this.mScrollState = 0;
        this.anK = -1;
        this.anS = Float.MIN_VALUE;
        this.anT = Float.MIN_VALUE;
        this.anU = true;
        this.anV = new C31882u();
        this.anX = amX ? new C8469a() : null;
        this.anY = new C31880s();
        this.aob = false;
        this.aoc = false;
        this.aod = new C8443g();
        this.aoe = false;
        this.aoh = new int[2];
        this.f16847Rd = new int[2];
        this.f16848Re = new int[2];
        this.aoj = new int[2];
        this.aok = new ArrayList();
        this.aol = new C253702();
        this.aon = new C253714();
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
        this.anS = C44962t.m82263a(viewConfiguration, context);
        this.anT = C44962t.m82265b(viewConfiguration, context);
        this.anQ = viewConfiguration.getScaledMinimumFlingVelocity();
        this.anR = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.anJ.aor = this.aod;
        this.ane = new C41540f(new C415286());
        this.anf = new C31892v(new C84425());
        if (C0477s.m892S(this) == 0) {
            C0477s.m949o(this, 1);
        }
        this.f16850mP = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C17492ao(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C25367a.RecyclerView, i, 0);
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
                    throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + mo66399ji());
                }
                Resources resources = getContext().getResources();
                C8463ac c8463ac = new C8463ac(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C25738R.dimen.a20), resources.getDimensionPixelSize(C25738R.dimen.a22), resources.getDimensionPixelOffset(C25738R.dimen.a21));
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
                        Class asSubclass = classLoader.loadClass(str).asSubclass(C17480i.class);
                        try {
                            constructor = asSubclass.getConstructor(ana);
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                        } catch (NoSuchMethodException e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((C17480i) constructor.newInstance(objArr));
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
    /* renamed from: ji */
    public final String mo66399ji() {
        return " " + super.toString() + ", adapter:" + this.f16849Yq + ", layout:" + this.ank + ", context:" + getContext();
    }

    public C17492ao getCompatAccessibilityDelegate() {
        return this.aof;
    }

    public void setAccessibilityDelegateCompat(C17492ao c17492ao) {
        this.aof = c17492ao;
        C0477s.m905a((View) this, this.aof);
    }

    public void setHasFixedSize(boolean z) {
        this.anq = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.anh) {
            m72580jt();
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

    public void setAdapter(C41523a c41523a) {
        setLayoutFrozen(false);
        if (this.f16849Yq != null) {
            this.f16849Yq.mo66313b(this.anb);
        }
        mo66400jj();
        this.ane.reset();
        C41523a c41523a2 = this.f16849Yq;
        this.f16849Yq = c41523a;
        if (c41523a != null) {
            c41523a.mo66307a(this.anb);
        }
        if (this.ank != null) {
            this.ank.mo31875jW();
        }
        C25374o c25374o = this.anc;
        C41523a c41523a3 = this.f16849Yq;
        c25374o.clear();
        C17482n recycledViewPool = c25374o.getRecycledViewPool();
        if (c41523a2 != null) {
            recycledViewPool.detach();
        }
        if (recycledViewPool.aoQ == 0) {
            for (int i = 0; i < recycledViewPool.aoP.size(); i++) {
                ((C17483a) recycledViewPool.aoP.valueAt(i)).aoR.clear();
            }
        }
        if (c41523a3 != null) {
            recycledViewPool.mo31889ka();
        }
        this.anY.apu = true;
        mo66343am(false);
        requestLayout();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jj */
    public final void mo66400jj() {
        if (this.anJ != null) {
            this.anJ.mo22573hZ();
        }
        if (this.ank != null) {
            this.ank.mo31854d(this.anc);
            this.ank.mo31850c(this.anc);
        }
        this.anc.clear();
    }

    public C41523a getAdapter() {
        return this.f16849Yq;
    }

    public void setRecyclerListener(C8446p c8446p) {
        this.anl = c8446p;
    }

    public int getBaseline() {
        if (this.ank != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void setLayoutManager(C17480i c17480i) {
        if (c17480i != this.ank) {
            mo66403jm();
            if (this.ank != null) {
                if (this.anJ != null) {
                    this.anJ.mo22573hZ();
                }
                this.ank.mo31854d(this.anc);
                this.ank.mo31850c(this.anc);
                this.anc.clear();
                if (this.anp) {
                    this.ank.mo31846b(this, this.anc);
                }
                this.ank.setRecyclerView(null);
                this.ank = null;
            } else {
                this.anc.clear();
            }
            C31892v c31892v = this.anf;
            C17498a c17498a = c31892v.ahb;
            while (true) {
                c17498a.ahd = 0;
                if (c17498a.ahe == null) {
                    break;
                }
                c17498a = c17498a.ahe;
            }
            for (int size = c31892v.ahc.size() - 1; size >= 0; size--) {
                c31892v.aha.mo18465bb((View) c31892v.ahc.get(size));
                c31892v.ahc.remove(size);
            }
            c31892v.aha.removeAllViews();
            this.ank = c17480i;
            if (c17480i != null) {
                if (c17480i.aiB != null) {
                    throw new IllegalArgumentException("LayoutManager " + c17480i + " is already attached to a RecyclerView:" + c17480i.aiB.mo66399ji());
                }
                this.ank.setRecyclerView(this);
                if (this.anp) {
                    this.ank.mo31855e(this);
                }
            }
            this.anc.mo42380kb();
            requestLayout();
        }
    }

    public void setOnFlingListener(C41529k c41529k) {
        this.anP = c41529k;
    }

    public C41529k getOnFlingListener() {
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
            super.onRestoreInstanceState(this.and.f507LC);
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
    /* renamed from: f */
    public final void mo66374f(C41531v c41531v) {
        View view = c41531v.apJ;
        boolean z = view.getParent() == this;
        this.anc.mo42382t(mo66337aZ(view));
        if (c41531v.mo66463ks()) {
            this.anf.mo51987a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            C31892v c31892v = this.anf;
            int indexOfChild = c31892v.aha.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
            }
            c31892v.ahb.set(indexOfChild);
            c31892v.mo51989aW(view);
        } else {
            this.anf.mo51988a(view, -1, true);
        }
    }

    public C17480i getLayoutManager() {
        return this.ank;
    }

    public C17482n getRecycledViewPool() {
        return this.anc.getRecycledViewPool();
    }

    public void setRecycledViewPool(C17482n c17482n) {
        C25374o c25374o = this.anc;
        if (c25374o.apb != null) {
            c25374o.apb.detach();
        }
        c25374o.apb = c17482n;
        if (c17482n != null) {
            C17482n c17482n2 = c25374o.apb;
            RecyclerView.this.getAdapter();
            c17482n2.mo31889ka();
        }
    }

    public void setViewCacheExtension(C31881t c31881t) {
        this.anc.apc = c31881t;
    }

    public void setItemViewCacheSize(int i) {
        C25374o c25374o = this.anc;
        c25374o.aoZ = i;
        c25374o.mo42380kb();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                m72574jn();
            }
            if (this.ank != null) {
                this.ank.mo15124cm(i);
            }
            if (this.anZ != null) {
                this.anZ.mo6643c(this, i);
            }
            if (this.aoa != null) {
                for (int size = this.aoa.size() - 1; size >= 0; size--) {
                    ((C41530m) this.aoa.get(size)).mo6643c(this, i);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo66330a(C25373h c25373h) {
        if (this.ank != null) {
            this.ank.mo1745T("Cannot add item decoration during a scroll  or layout");
        }
        if (this.anm.isEmpty()) {
            setWillNotDraw(false);
        }
        this.anm.add(c25373h);
        m72569jK();
        requestLayout();
    }

    /* renamed from: b */
    public final void mo66346b(C25373h c25373h) {
        mo66330a(c25373h);
    }

    public int getItemDecorationCount() {
        return this.anm.size();
    }

    /* renamed from: c */
    public final void mo66354c(C25373h c25373h) {
        if (this.ank != null) {
            this.ank.mo1745T("Cannot remove item decoration during a scroll  or layout");
        }
        this.anm.remove(c25373h);
        if (this.anm.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        m72569jK();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C41526d c41526d) {
        if (c41526d != this.aog) {
            this.aog = c41526d;
            setChildrenDrawingOrderEnabled(this.aog != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C41530m c41530m) {
        this.anZ = c41530m;
    }

    /* renamed from: a */
    public final void mo66332a(C41530m c41530m) {
        if (this.aoa == null) {
            this.aoa = new ArrayList();
        }
        this.aoa.add(c41530m);
    }

    /* renamed from: b */
    public final void mo66348b(C41530m c41530m) {
        if (this.aoa != null) {
            this.aoa.remove(c41530m);
        }
    }

    /* renamed from: bY */
    public void mo61465bY(int i) {
        if (!this.anv) {
            mo66403jm();
            if (this.ank != null) {
                this.ank.mo1762bY(i);
                awakenScrollBars();
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cd */
    public final void mo66355cd(int i) {
        if (this.ank != null) {
            this.ank.mo1762bY(i);
            awakenScrollBars();
        }
    }

    public final void smoothScrollToPosition(int i) {
        if (!this.anv && this.ank != null) {
            this.ank.mo1755a(this, i);
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.ank != null && !this.anv) {
            boolean iG = this.ank.mo1776iG();
            boolean iH = this.ank.mo1777iH();
            if (iG || iH) {
                if (!iG) {
                    i = 0;
                }
                if (!iH) {
                    i2 = 0;
                }
                m72542a(i, i2, null);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jk */
    public final void mo66401jk() {
        boolean z = false;
        if (!this.ans || this.anA) {
            C31862f.beginSection("RV FullInvalidate");
            m72562jD();
            C31862f.endSection();
        } else if (!this.ane.mo66569hw()) {
        } else {
            if (this.ane.mo66566bz(4) && !this.ane.mo66566bz(11)) {
                C31862f.beginSection("RV PartialInvalidate");
                mo66402jl();
                mo66404jw();
                this.ane.mo66567hu();
                if (!this.anu) {
                    int childCount = this.anf.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        C41531v bn = RecyclerView.m72546bn(this.anf.getChildAt(i));
                        if (bn != null && !bn.mo66452kh() && bn.mo66467kx()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        m72562jD();
                    } else {
                        this.ane.mo66568hv();
                    }
                }
                mo66339ak(true);
                mo66341al(true);
                C31862f.endSection();
            } else if (this.ane.mo66569hw()) {
                C31862f.beginSection("RV FullInvalidate");
                m72562jD();
                C31862f.endSection();
            }
        }
    }

    /* renamed from: a */
    private boolean m72542a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        mo66401jk();
        if (this.f16849Yq != null) {
            int a;
            int b;
            mo66402jl();
            mo66404jw();
            C31862f.beginSection("RV Scroll");
            mo66407m(this.anY);
            if (i != 0) {
                a = this.ank.mo1746a(i, this.anc, this.anY);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.ank.mo1759b(i2, this.anc, this.anY);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            C31862f.endSection();
            mo66398jP();
            mo66341al(true);
            mo66339ak(false);
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
        if (mo66334a(i6, i5, i3, i4, this.f16847Rd, 0)) {
            this.anN -= this.f16847Rd[0];
            this.anO -= this.f16847Rd[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.f16847Rd[0], (float) this.f16847Rd[1]);
            }
            int[] iArr = this.aoj;
            iArr[0] = iArr[0] + this.f16847Rd[0];
            iArr = this.aoj;
            iArr[1] = iArr[1] + this.f16847Rd[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || C0467h.m826d(motionEvent))) {
                m72553e(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i4);
            }
            mo66340al(i, i2);
        }
        if (!(i6 == 0 && i5 == 0)) {
            mo66345aq(i6, i5);
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
        if (this.ank != null && this.ank.mo1776iG()) {
            return this.ank.mo1766d(this.anY);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.ank != null && this.ank.mo1776iG()) {
            return this.ank.mo1768f(this.anY);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.ank != null && this.ank.mo1776iG()) {
            return this.ank.mo1771h(this.anY);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.ank != null && this.ank.mo1777iH()) {
            return this.ank.mo1767e(this.anY);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.ank != null && this.ank.mo1777iH()) {
            return this.ank.mo1769g(this.anY);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.ank != null && this.ank.mo1777iH()) {
            return this.ank.mo1772i(this.anY);
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jl */
    public final void mo66402jl() {
        this.ant++;
        if (this.ant == 1 && !this.anv) {
            this.anu = false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ak */
    public final void mo66339ak(boolean z) {
        if (this.ant <= 0) {
            this.ant = 1;
        }
        if (!(z || this.anv)) {
            this.anu = false;
        }
        if (this.ant == 1) {
            if (!(!z || !this.anu || this.anv || this.ank == null || this.f16849Yq == null)) {
                m72562jD();
            }
            if (!this.anv) {
                this.anu = false;
            }
        }
        this.ant--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.anv) {
            mo66328T("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.anv = true;
                this.anw = true;
                mo66403jm();
                return;
            }
            this.anv = false;
            if (!(!this.anu || this.ank == null || this.f16849Yq == null)) {
                requestLayout();
            }
            this.anu = false;
        }
    }

    /* renamed from: ce */
    public final void mo66356ce(int i) {
        mo66329a(0, i, null);
    }

    /* renamed from: a */
    public final void mo66329a(int i, int i2, Interpolator interpolator) {
        int i3 = 0;
        if (this.ank != null && !this.anv) {
            if (!this.ank.mo1776iG()) {
                i = 0;
            }
            if (this.ank.mo1777iH()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.anV.mo51952a(i, i3, interpolator);
            }
        }
    }

    /* renamed from: ak */
    public boolean mo45329ak(int i, int i2) {
        if (this.ank == null || this.anv) {
            return false;
        }
        boolean iG = this.ank.mo1776iG();
        boolean iH = this.ank.mo1777iH();
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
        if (this.anP != null && this.anP.mo26235aE(i, i2)) {
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
        m72584w(i3, 1);
        int max = Math.max(-this.anR, Math.min(i, this.anR));
        int max2 = Math.max(-this.anR, Math.min(i2, this.anR));
        C31882u c31882u = this.anV;
        RecyclerView.this.setScrollState(2);
        c31882u.apG = 0;
        c31882u.apF = 0;
        c31882u.f14656qN.fling(0, 0, max, max2, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        c31882u.mo51955ke();
        return true;
    }

    /* renamed from: jm */
    public final void mo66403jm() {
        setScrollState(0);
        m72574jn();
    }

    /* renamed from: jn */
    private void m72574jn() {
        this.anV.stop();
        if (this.ank != null) {
            this.ank.mo31876jX();
        }
    }

    public int getMinFlingVelocity() {
        return this.anQ;
    }

    public int getMaxFlingVelocity() {
        return this.anR;
    }

    /* renamed from: e */
    private void m72553e(float f, float f2, float f3, float f4) {
        Object obj = 1;
        Object obj2 = null;
        if (f2 < 0.0f) {
            m72576jp();
            C0528i.m1133a(this.anF, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
            obj2 = 1;
        } else if (f2 > 0.0f) {
            m72577jq();
            C0528i.m1133a(this.anH, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
            int obj22 = 1;
        }
        if (f4 < 0.0f) {
            m72578jr();
            C0528i.m1133a(this.anG, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
        } else if (f4 > 0.0f) {
            m72579js();
            C0528i.m1133a(this.anI, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
        } else {
            obj = obj22;
        }
        if (obj != null || f2 != 0.0f || f4 != 0.0f) {
            C0477s.m891R(this);
        }
    }

    /* renamed from: jo */
    private void m72575jo() {
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
            C0477s.m891R(this);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: al */
    public final void mo66340al(int i, int i2) {
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
            C0477s.m891R(this);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: am */
    public final void mo66342am(int i, int i2) {
        if (i < 0) {
            m72576jp();
            this.anF.onAbsorb(-i);
        } else if (i > 0) {
            m72577jq();
            this.anH.onAbsorb(i);
        }
        if (i2 < 0) {
            m72578jr();
            this.anG.onAbsorb(-i2);
        } else if (i2 > 0) {
            m72579js();
            this.anI.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            C0477s.m891R(this);
        }
    }

    /* renamed from: jp */
    private void m72576jp() {
        if (this.anF == null) {
            this.anF = C17476e.m27135d(this);
            if (this.anh) {
                this.anF.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.anF.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* renamed from: jq */
    private void m72577jq() {
        if (this.anH == null) {
            this.anH = C17476e.m27135d(this);
            if (this.anh) {
                this.anH.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.anH.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* renamed from: jr */
    private void m72578jr() {
        if (this.anG == null) {
            this.anG = C17476e.m27135d(this);
            if (this.anh) {
                this.anG.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.anG.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* renamed from: js */
    private void m72579js() {
        if (this.anI == null) {
            this.anI = C17476e.m27135d(this);
            if (this.anh) {
                this.anI.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.anI.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* renamed from: jt */
    private void m72580jt() {
        this.anI = null;
        this.anG = null;
        this.anH = null;
        this.anF = null;
    }

    public void setEdgeEffectFactory(C17476e c17476e) {
        C0416l.checkNotNull(c17476e);
        this.anE = c17476e;
        m72580jt();
    }

    public C17476e getEdgeEffectFactory() {
        return this.anE;
    }

    public View focusSearch(View view, int i) {
        int i2;
        int i3;
        View findNextFocus;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (this.f16849Yq == null || this.ank == null || mo66406jz() || this.anv) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z3 && (i == 2 || i == 1)) {
            boolean z4;
            if (this.ank.mo1777iH()) {
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
            if (!z4 && this.ank.mo1776iG()) {
                if (C0477s.m893T(this.ank.aiB) == 1) {
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
                mo66401jk();
                if (mo66350bl(view) == null) {
                    return null;
                }
                mo66402jl();
                this.ank.mo1748a(view, i, this.anc, this.anY);
                mo66339ak(false);
            }
            findNextFocus = instance.findNextFocus(this, view, i);
        } else {
            findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z3) {
                mo66401jk();
                if (mo66350bl(view) == null) {
                    return null;
                }
                mo66402jl();
                findNextFocus = this.ank.mo1748a(view, i, this.anc, this.anY);
                mo66339ak(false);
            }
        }
        if (findNextFocus == null || findNextFocus.hasFocusable()) {
            if (!(findNextFocus == null || findNextFocus == this || mo66350bl(findNextFocus) == null)) {
                if (view == null) {
                    z2 = true;
                } else if (mo66350bl(view) == null) {
                    z2 = true;
                } else {
                    this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
                    this.f16851qT.set(0, 0, findNextFocus.getWidth(), findNextFocus.getHeight());
                    offsetDescendantRectToMyCoords(view, this.mTempRect);
                    offsetDescendantRectToMyCoords(findNextFocus, this.f16851qT);
                    i2 = C0477s.m893T(this.ank.aiB) == 1 ? -1 : 1;
                    if ((this.mTempRect.left < this.f16851qT.left || this.mTempRect.right <= this.f16851qT.left) && this.mTempRect.right < this.f16851qT.right) {
                        i3 = 1;
                    } else if ((this.mTempRect.right > this.f16851qT.right || this.mTempRect.left >= this.f16851qT.right) && this.mTempRect.left > this.f16851qT.left) {
                        i3 = -1;
                    } else {
                        i3 = 0;
                    }
                    if ((this.mTempRect.top < this.f16851qT.top || this.mTempRect.bottom <= this.f16851qT.top) && this.mTempRect.bottom < this.f16851qT.bottom) {
                        z = true;
                    } else if ((this.mTempRect.bottom <= this.f16851qT.bottom && this.mTempRect.top < this.f16851qT.bottom) || this.mTempRect.top <= this.f16851qT.top) {
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
                            throw new IllegalArgumentException("Invalid direction: " + i + mo66399ji());
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
            m72552d(findNextFocus, null);
            return view;
        }
    }

    public void requestChildFocus(View view, View view2) {
        Object obj;
        if (this.ank.mo31874jV() || mo66406jz()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && view2 != null) {
            m72552d(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    /* renamed from: d */
    private void m72552d(View view, View view2) {
        boolean z = true;
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        LayoutParams layoutParams = view3.getLayoutParams();
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
        C17480i c17480i = this.ank;
        Rect rect3 = this.mTempRect;
        boolean z2 = !this.ans;
        if (view2 != null) {
            z = false;
        }
        c17480i.mo31835a(this, view, rect3, z2, z);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.ank.mo31835a(this, view, rect, z, false);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.ank == null || !this.ank.mo31836a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (mo66406jz()) {
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
            this.ank.mo31855e(this);
        }
        this.aoe = false;
        if (amX) {
            this.anW = (C8467af) C8467af.aiU.get();
            if (this.anW == null) {
                float refreshRate;
                this.anW = new C8467af();
                Display ax = C0477s.m932ax(this);
                if (!(isInEditMode() || ax == null)) {
                    refreshRate = ax.getRefreshRate();
                }
                refreshRate = 60.0f;
                this.anW.aiX = (long) (1.0E9f / refreshRate);
                C8467af.aiU.set(this.anW);
            }
            this.anW.aiV.add(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.anJ != null) {
            this.anJ.mo22573hZ();
        }
        mo66403jm();
        this.anp = false;
        if (this.ank != null) {
            this.ank.mo31846b(this, this.anc);
        }
        this.aok.clear();
        removeCallbacks(this.aol);
        C25381a.m40073lz();
        if (amX && this.anW != null) {
            this.anW.aiV.remove(this);
            this.anW = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.anp;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: T */
    public final void mo66328T(String str) {
        if (mo66406jz()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + mo66399ji());
            }
            throw new IllegalStateException(str);
        } else if (this.anD > 0) {
            IllegalStateException illegalStateException = new IllegalStateException(mo66399ji());
        }
    }

    /* renamed from: a */
    public final void mo66331a(C37137l c37137l) {
        this.ann.add(c37137l);
    }

    /* renamed from: b */
    public final void mo66347b(C37137l c37137l) {
        this.ann.remove(c37137l);
        if (this.ano == c37137l) {
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
            C37137l c37137l = (C37137l) this.ann.get(i);
            if (c37137l.mo18506h(motionEvent) && action != 3) {
                this.ano = c37137l;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            m72582jv();
            return true;
        } else if (this.ank == null) {
            return false;
        } else {
            z = this.ank.mo1776iG();
            boolean iH = this.ank.mo1777iH();
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
                    m72584w(i2, 0);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    mo66336aJ(0);
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
                    m72582jv();
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
                    m72558j(motionEvent);
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
            ((C37137l) this.ann.get(i)).mo18505ab(z);
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
                this.ano.mo18507i(motionEvent);
                if (action == 3 || action == 1) {
                    this.ano = null;
                }
                action = 1;
                if (action == 0) {
                    m72582jv();
                    return true;
                } else if (this.ank == null) {
                    return false;
                } else {
                    boolean iG = this.ank.mo1776iG();
                    boolean iH = this.ank.mo1777iH();
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
                            m72584w(action, 0);
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
                            if ((f == 0.0f && f2 == 0.0f) || !mo45329ak((int) f, (int) f2)) {
                                setScrollState(0);
                            }
                            m72581ju();
                            z = true;
                            break;
                        case 2:
                            action = motionEvent.findPointerIndex(this.anK);
                            if (action >= 0) {
                                int x = (int) (motionEvent.getX(action) + 0.5f);
                                int y = (int) (motionEvent.getY(action) + 0.5f);
                                int i2 = this.anN - x;
                                actionIndex = this.anO - y;
                                if (mo66335a(i2, actionIndex, this.f16848Re, this.f16847Rd, 0)) {
                                    i2 -= this.f16848Re[0];
                                    actionIndex -= this.f16848Re[1];
                                    obtain.offsetLocation((float) this.f16847Rd[0], (float) this.f16847Rd[1]);
                                    int[] iArr2 = this.aoj;
                                    iArr2[0] = iArr2[0] + this.f16847Rd[0];
                                    iArr2 = this.aoj;
                                    iArr2[1] = iArr2[1] + this.f16847Rd[1];
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
                                    this.anN = x - this.f16847Rd[0];
                                    this.anO = y - this.f16847Rd[1];
                                    i3 = iG ? i2 : 0;
                                    if (iH) {
                                        action = actionIndex;
                                    } else {
                                        action = 0;
                                    }
                                    if (m72542a(i3, action, obtain)) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                    }
                                    if (!(this.anW == null || (i2 == 0 && actionIndex == 0))) {
                                        this.anW.mo18518b(this, i2, actionIndex);
                                        break;
                                    }
                                }
                            }
                            new StringBuilder("Error processing scroll; pointer index for id ").append(this.anK).append(" not found. Did any MotionEvents get skipped?");
                            return false;
                            break;
                        case 3:
                            m72582jv();
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
                            m72558j(motionEvent);
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
                C37137l c37137l = (C37137l) this.ann.get(actionIndex);
                if (c37137l.mo18506h(motionEvent)) {
                    this.ano = c37137l;
                    action = 1;
                    break;
                }
            }
        }
        boolean z2 = false;
        if (action == 0) {
        }
    }

    /* renamed from: ju */
    private void m72581ju() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        mo66336aJ(0);
        m72575jo();
    }

    /* renamed from: jv */
    private void m72582jv() {
        m72581ju();
        setScrollState(0);
    }

    /* renamed from: j */
    private void m72558j(MotionEvent motionEvent) {
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
                if (this.ank.mo1777iH()) {
                    f2 = -motionEvent.getAxisValue(9);
                } else {
                    f2 = 0.0f;
                }
                if (this.ank.mo1776iG()) {
                    axisValue = motionEvent.getAxisValue(10);
                    f = f2;
                } else {
                    axisValue = 0.0f;
                    f = f2;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                f2 = motionEvent.getAxisValue(26);
                if (this.ank.mo1777iH()) {
                    axisValue = 0.0f;
                    f = -f2;
                } else if (this.ank.mo1776iG()) {
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
                m72542a((int) (this.anS * axisValue), (int) (this.anT * f), motionEvent);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.ank == null) {
            mo66344an(i, i2);
        } else if (this.ank.mo1775iF()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.ank.mo31840aD(i, i2);
            if (mode == ErrorDialogData.SUPPRESSED && mode2 == ErrorDialogData.SUPPRESSED) {
                z = true;
            }
            if (!z && this.f16849Yq != null) {
                if (this.anY.aps == 1) {
                    m72566jH();
                }
                this.ank.mo31838aA(i, i2);
                this.anY.apx = true;
                m72567jI();
                this.ank.mo31839aB(i, i2);
                if (this.ank.mo1779iL()) {
                    this.ank.mo31838aA(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), ErrorDialogData.SUPPRESSED));
                    this.anY.apx = true;
                    m72567jI();
                    this.ank.mo31839aB(i, i2);
                }
            }
        } else if (this.anq) {
            this.ank.mo31840aD(i, i2);
        } else {
            if (this.any) {
                mo66402jl();
                mo66404jw();
                m72561jC();
                mo66341al(true);
                if (this.anY.apz) {
                    this.anY.apv = true;
                } else {
                    this.ane.mo66570hx();
                    this.anY.apv = false;
                }
                this.any = false;
                mo66339ak(false);
            } else if (this.anY.apz) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.f16849Yq != null) {
                this.anY.apt = this.f16849Yq.getItemCount();
            } else {
                this.anY.apt = 0;
            }
            mo66402jl();
            this.ank.mo31840aD(i, i2);
            mo66339ak(false);
            this.anY.apv = false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: an */
    public final void mo66344an(int i, int i2) {
        setMeasuredDimension(C17480i.m27162l(i, getPaddingLeft() + getPaddingRight(), C0477s.m899Z(this)), C17480i.m27162l(i2, getPaddingTop() + getPaddingBottom(), C0477s.m909aa(this)));
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m72580jt();
        }
    }

    public void setItemAnimator(C31879f c31879f) {
        if (this.anJ != null) {
            this.anJ.mo22573hZ();
            this.anJ.aor = null;
        }
        this.anJ = c31879f;
        if (this.anJ != null) {
            this.anJ.aor = this.aod;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jw */
    public final void mo66404jw() {
        this.anC++;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: al */
    public final void mo66341al(boolean z) {
        this.anC--;
        if (this.anC <= 0) {
            this.anC = 0;
            if (z) {
                m72583jy();
                m72573jQ();
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jx */
    public final boolean mo66405jx() {
        return this.f16850mP != null && this.f16850mP.isEnabled();
    }

    /* renamed from: jy */
    private void m72583jy() {
        int i = this.anx;
        this.anx = 0;
        if (i != 0 && mo66405jx()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C41515a.m72498a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    /* renamed from: jz */
    public final boolean mo66406jz() {
        return this.anC > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (mo66406jz()) {
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

    public C31879f getItemAnimator() {
        return this.anJ;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jA */
    public final void mo66396jA() {
        if (!this.aoe && this.anp) {
            C0477s.m934b((View) this, this.aol);
            this.aoe = true;
        }
    }

    /* renamed from: jB */
    private boolean m72560jB() {
        return this.anJ != null && this.ank.mo1774iE();
    }

    /* renamed from: jC */
    private void m72561jC() {
        boolean z;
        boolean z2 = true;
        if (this.anA) {
            this.ane.reset();
            if (this.anB) {
                this.ank.mo15122a(this);
            }
        }
        if (m72560jB()) {
            this.ane.mo66567hu();
        } else {
            this.ane.mo66570hx();
        }
        boolean z3;
        if (this.aob || this.aoc) {
            z3 = true;
        } else {
            z3 = false;
        }
        C31880s c31880s = this.anY;
        if (!this.ans || this.anJ == null || (!(this.anA || z3 || this.ank.aoD) || (this.anA && !this.f16849Yq.aoq))) {
            z = false;
        } else {
            z = true;
        }
        c31880s.apy = z;
        C31880s c31880s2 = this.anY;
        if (!(this.anY.apy && z3 && !this.anA && m72560jB())) {
            z2 = false;
        }
        c31880s2.apz = z2;
    }

    /* renamed from: jD */
    private void m72562jD() {
        if (this.f16849Yq != null && this.ank != null) {
            this.anY.apx = false;
            if (this.anY.aps == 1) {
                m72566jH();
                this.ank.mo31858g(this);
                m72567jI();
            } else if (!this.ane.mo66571hy() && this.ank.mWidth == getWidth() && this.ank.mHeight == getHeight()) {
                this.ank.mo31858g(this);
            } else {
                this.ank.mo31858g(this);
                m72567jI();
            }
            m72568jJ();
        }
    }

    /* renamed from: jE */
    private void m72563jE() {
        View focusedChild;
        if (this.anU && hasFocus() && this.f16849Yq != null) {
            focusedChild = getFocusedChild();
        } else {
            focusedChild = null;
        }
        C41531v bm = focusedChild == null ? null : mo66351bm(focusedChild);
        if (bm == null) {
            m72564jF();
            return;
        }
        long j;
        int i;
        C31880s c31880s = this.anY;
        if (this.f16849Yq.aoq) {
            j = bm.apM;
        } else {
            j = -1;
        }
        c31880s.apB = j;
        C31880s c31880s2 = this.anY;
        if (this.anA) {
            i = -1;
        } else if (bm.isRemoved()) {
            i = bm.apL;
        } else {
            i = bm.mo66454kj();
        }
        c31880s2.apA = i;
        c31880s = this.anY;
        View view = bm.apJ;
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        c31880s.apC = id;
    }

    /* renamed from: jF */
    private void m72564jF() {
        this.anY.apB = -1;
        this.anY.apA = -1;
        this.anY.apC = -1;
    }

    /* JADX WARNING: Missing block: B:58:0x00ce, code skipped:
            if (r0.isFocusable() != false) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: jG */
    private void m72565jG() {
        View view = null;
        if (this.anU && this.f16849Yq != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || !isFocused()) {
                View focusedChild;
                C41531v c41531v;
                View view2;
                if (!isFocused()) {
                    focusedChild = getFocusedChild();
                    if (!amZ || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.anf.mo51991aY(focusedChild)) {
                            return;
                        }
                    } else if (this.anf.getChildCount() == 0) {
                        requestFocus();
                        return;
                    }
                }
                if (this.anY.apB == -1 || !this.f16849Yq.aoq) {
                    c41531v = null;
                } else {
                    long j = this.anY.apB;
                    if (this.f16849Yq == null || !this.f16849Yq.aoq) {
                        c41531v = null;
                    } else {
                        Object obj;
                        int hU = this.anf.mo51996hU();
                        int i = 0;
                        view2 = null;
                        while (i < hU) {
                            c41531v = RecyclerView.m72546bn(this.anf.mo51992bI(i));
                            if (c41531v != null && !c41531v.isRemoved() && c41531v.apM == j) {
                                if (!this.anf.mo51991aY(c41531v.apJ)) {
                                    break;
                                }
                            } else {
                                obj = view2;
                            }
                            i++;
                            Object view22 = c41531v;
                        }
                        obj = view22;
                    }
                }
                if (c41531v != null && !this.anf.mo51991aY(c41531v.apJ) && c41531v.apJ.hasFocusable()) {
                    view22 = c41531v.apJ;
                } else if (this.anf.getChildCount() > 0) {
                    int i2 = this.anY.apA != -1 ? this.anY.apA : 0;
                    int itemCount = this.anY.getItemCount();
                    int i3 = i2;
                    while (i3 < itemCount) {
                        C41531v cf = mo66357cf(i3);
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
                        C41531v cf2 = mo66357cf(i2);
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
    /* renamed from: m */
    public final void mo66407m(C31880s c31880s) {
        if (getScrollState() == 2) {
            OverScroller a = this.anV.f14656qN;
            c31880s.apD = a.getFinalX() - a.getCurrX();
            c31880s.apE = a.getFinalY() - a.getCurrY();
            return;
        }
        c31880s.apD = 0;
        c31880s.apE = 0;
    }

    /* renamed from: jH */
    private void m72566jH() {
        int childCount;
        int i;
        C41531v bn;
        this.anY.mo51949cw(1);
        mo66407m(this.anY);
        this.anY.apx = false;
        mo66402jl();
        this.ang.clear();
        mo66404jw();
        m72561jC();
        m72563jE();
        C31880s c31880s = this.anY;
        boolean z = this.anY.apy && this.aoc;
        c31880s.apw = z;
        this.aoc = false;
        this.aob = false;
        this.anY.apv = this.anY.apz;
        this.anY.apt = this.f16849Yq.getItemCount();
        m72559j(this.aoh);
        if (this.anY.apy) {
            childCount = this.anf.getChildCount();
            for (i = 0; i < childCount; i++) {
                bn = RecyclerView.m72546bn(this.anf.getChildAt(i));
                if (!bn.mo66452kh() && (!bn.mo66461kq() || this.f16849Yq.aoq)) {
                    this.ang.mo72246b(bn, this.anJ.mo51944a(this.anY, bn, C31879f.m51693l(bn), bn.mo66465kv()));
                    if (!(!this.anY.apw || !bn.mo66467kx() || bn.isRemoved() || bn.mo66452kh() || bn.mo66461kq())) {
                        this.ang.mo72244a(m72556g(bn), bn);
                    }
                }
            }
        }
        if (this.anY.apz) {
            m72570jL();
            z = this.anY.apu;
            this.anY.apu = false;
            this.ank.mo1765c(this.anc, this.anY);
            this.anY.apu = z;
            for (i = 0; i < this.anf.getChildCount(); i++) {
                bn = RecyclerView.m72546bn(this.anf.getChildAt(i));
                if (!(bn.mo66452kh() || this.ang.mo72240I(bn))) {
                    childCount = C31879f.m51693l(bn);
                    boolean cx = bn.mo66446cx(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (!cx) {
                        childCount |= 4096;
                    }
                    C17479c a = this.anJ.mo51944a(this.anY, bn, childCount, bn.mo66465kv());
                    if (cx) {
                        mo66333a(bn, a);
                    } else {
                        this.ang.mo72247c(bn, a);
                    }
                }
            }
            m72571jM();
        } else {
            m72571jM();
        }
        mo66341al(true);
        mo66339ak(false);
        this.anY.aps = 2;
    }

    /* renamed from: jI */
    private void m72567jI() {
        boolean z;
        mo66402jl();
        mo66404jw();
        this.anY.mo51949cw(6);
        this.ane.mo66570hx();
        this.anY.apt = this.f16849Yq.getItemCount();
        this.anY.apr = 0;
        this.anY.apv = false;
        this.ank.mo1765c(this.anc, this.anY);
        this.anY.apu = false;
        this.and = null;
        C31880s c31880s = this.anY;
        if (!this.anY.apy || this.anJ == null) {
            z = false;
        } else {
            z = true;
        }
        c31880s.apy = z;
        this.anY.aps = 4;
        mo66341al(true);
        mo66339ak(false);
    }

    /* renamed from: jJ */
    private void m72568jJ() {
        this.anY.mo51949cw(4);
        mo66402jl();
        mo66404jw();
        this.anY.aps = 1;
        if (this.anY.apy) {
            for (int childCount = this.anf.getChildCount() - 1; childCount >= 0; childCount--) {
                C41531v bn = RecyclerView.m72546bn(this.anf.getChildAt(childCount));
                if (!bn.mo66452kh()) {
                    long g = m72556g(bn);
                    C17479c c = new C17479c().mo31823c(bn, 0);
                    C41531v o = this.ang.mo72251o(g);
                    if (!(o == null || o.mo66452kh())) {
                        boolean H = this.ang.mo72239H(o);
                        boolean H2 = this.ang.mo72239H(bn);
                        if (!(H && o == bn)) {
                            C17479c d = this.ang.mo72249d(o, 4);
                            this.ang.mo72250d(bn, c);
                            C17479c d2 = this.ang.mo72249d(bn, 8);
                            if (d == null) {
                                m72539a(g, bn, o);
                            } else {
                                m72540a(o, bn, d, d2, H, H2);
                            }
                        }
                    }
                    this.ang.mo72250d(bn, c);
                }
            }
            this.ang.mo72245a(this.aon);
        }
        this.ank.mo31850c(this.anc);
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
            this.anc.mo42380kb();
        }
        this.ank.mo1753a(this.anY);
        mo66341al(true);
        mo66339ak(false);
        this.ang.clear();
        if (m72543ao(this.aoh[0], this.aoh[1])) {
            mo66345aq(0, 0);
        }
        m72565jG();
        m72564jF();
    }

    /* renamed from: a */
    private void m72539a(long j, C41531v c41531v, C41531v c41531v2) {
        int childCount = this.anf.getChildCount();
        int i = 0;
        while (i < childCount) {
            C41531v bn = RecyclerView.m72546bn(this.anf.getChildAt(i));
            if (bn == c41531v || m72556g(bn) != j) {
                i++;
            } else if (this.f16849Yq == null || !this.f16849Yq.aoq) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + bn + " \n View Holder 2:" + c41531v + mo66399ji());
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + bn + " \n View Holder 2:" + c41531v + mo66399ji());
            }
        }
        new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(c41531v2).append(" cannot be found but it is necessary for ").append(c41531v).append(mo66399ji());
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo66333a(C41531v c41531v, C17479c c17479c) {
        c41531v.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.anY.apw && c41531v.mo66467kx() && !c41531v.isRemoved() && !c41531v.mo66452kh()) {
            this.ang.mo72244a(m72556g(c41531v), c41531v);
        }
        this.ang.mo72246b(c41531v, c17479c);
    }

    /* renamed from: j */
    private void m72559j(int[] iArr) {
        int childCount = this.anf.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = C8415j.INVALID_ID;
        int i3 = 0;
        while (i3 < childCount) {
            int ki;
            C41531v bn = RecyclerView.m72546bn(this.anf.getChildAt(i3));
            if (!bn.mo66452kh()) {
                ki = bn.mo66453ki();
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

    /* renamed from: ao */
    private boolean m72543ao(int i, int i2) {
        m72559j(this.aoh);
        if (this.aoh[0] == i && this.aoh[1] == i2) {
            return false;
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void removeDetachedView(View view, boolean z) {
        C41531v bn = RecyclerView.m72546bn(view);
        if (bn != null) {
            if (bn.mo66463ks()) {
                bn.mo66460kp();
            } else if (!bn.mo66452kh()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + bn + mo66399ji());
            }
        }
        view.clearAnimation();
        mo66353bs(view);
        super.removeDetachedView(view, z);
    }

    /* renamed from: g */
    private long m72556g(C41531v c41531v) {
        if (this.f16849Yq.aoq) {
            return c41531v.apM;
        }
        return (long) c41531v.mPosition;
    }

    /* renamed from: a */
    private void m72540a(C41531v c41531v, C41531v c41531v2, C17479c c17479c, C17479c c17479c2, boolean z, boolean z2) {
        c41531v.mo66445ao(false);
        if (z) {
            mo66374f(c41531v);
        }
        if (c41531v != c41531v2) {
            if (z2) {
                mo66374f(c41531v2);
            }
            c41531v.apP = c41531v2;
            mo66374f(c41531v);
            this.anc.mo42382t(c41531v);
            c41531v2.mo66445ao(false);
            c41531v2.apQ = c41531v;
        }
        if (this.anJ.mo31917a(c41531v, c41531v2, c17479c, c17479c2)) {
            mo66396jA();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C31862f.beginSection("RV OnLayout");
        m72562jD();
        C31862f.endSection();
        this.ans = true;
    }

    public void requestLayout() {
        if (this.ant != 0 || this.anv) {
            this.anu = true;
        } else {
            super.requestLayout();
        }
    }

    /* renamed from: jK */
    private void m72569jK() {
        int hU = this.anf.mo51996hU();
        for (int i = 0; i < hU; i++) {
            ((LayoutParams) this.anf.mo51992bI(i).getLayoutParams()).aoN = true;
        }
        this.anc.mo42377jK();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.anm.size();
        for (i = 0; i < size; i++) {
            ((C25373h) this.anm.get(i)).mo18494a(canvas, this);
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
            C0477s.m891R(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.anm.size();
        for (int i = 0; i < size; i++) {
            ((C25373h) this.anm.get(i)).mo6920a(canvas, this, this.anY);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.ank.mo31834a((LayoutParams) layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.ank != null) {
            return this.ank.mo1773iA();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo66399ji());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.ank != null) {
            return this.ank.mo31825a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo66399ji());
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.ank != null) {
            return this.ank.mo31853d(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo66399ji());
    }

    /* renamed from: jL */
    private void m72570jL() {
        int hU = this.anf.mo51996hU();
        for (int i = 0; i < hU; i++) {
            C41531v bn = RecyclerView.m72546bn(this.anf.mo51992bI(i));
            if (!bn.mo66452kh()) {
                bn.mo66451kg();
            }
        }
    }

    /* renamed from: jM */
    private void m72571jM() {
        int hU = this.anf.mo51996hU();
        for (int i = 0; i < hU; i++) {
            C41531v bn = RecyclerView.m72546bn(this.anf.mo51992bI(i));
            if (!bn.mo66452kh()) {
                bn.mo66450kf();
            }
        }
        this.anc.mo42378jM();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo66373e(int i, int i2, boolean z) {
        int i3 = i + i2;
        int hU = this.anf.mo51996hU();
        for (int i4 = 0; i4 < hU; i4++) {
            C41531v bn = RecyclerView.m72546bn(this.anf.mo51992bI(i4));
            if (!(bn == null || bn.mo66452kh())) {
                if (bn.mPosition >= i3) {
                    bn.mo66468o(-i2, z);
                    this.anY.apu = true;
                } else if (bn.mPosition >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    bn.addFlags(8);
                    bn.mo66468o(i6, z);
                    bn.mPosition = i5;
                    this.anY.apu = true;
                }
            }
        }
        C25374o c25374o = this.anc;
        int i7 = i + i2;
        for (i3 = c25374o.aoX.size() - 1; i3 >= 0; i3--) {
            C41531v c41531v = (C41531v) c25374o.aoX.get(i3);
            if (c41531v != null) {
                if (c41531v.mPosition >= i7) {
                    c41531v.mo66468o(-i2, z);
                } else if (c41531v.mPosition >= i) {
                    c41531v.addFlags(8);
                    c25374o.mo42374cs(i3);
                }
            }
        }
        requestLayout();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: am */
    public final void mo66343am(boolean z) {
        this.anB |= z;
        this.anA = true;
        m72572jN();
    }

    /* renamed from: jN */
    private void m72572jN() {
        int hU = this.anf.mo51996hU();
        for (int i = 0; i < hU; i++) {
            C41531v bn = RecyclerView.m72546bn(this.anf.mo51992bI(i));
            if (!(bn == null || bn.mo66452kh())) {
                bn.addFlags(6);
            }
        }
        m72569jK();
        this.anc.mo42379jN();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.anU;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.anU = z;
    }

    /* renamed from: aZ */
    public final C41531v mo66337aZ(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return RecyclerView.m72546bn(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* renamed from: bl */
    public final View mo66350bl(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            view2 = parent;
            parent = view2.getParent();
        }
        return parent == this ? view2 : null;
    }

    /* renamed from: bm */
    public final C41531v mo66351bm(View view) {
        View bl = mo66350bl(view);
        return bl == null ? null : mo66337aZ(bl);
    }

    /* renamed from: bn */
    static C41531v m72546bn(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).aoM;
    }

    /* renamed from: bo */
    public static int m72547bo(View view) {
        C41531v bn = RecyclerView.m72546bn(view);
        return bn != null ? bn.mo66454kj() : -1;
    }

    /* renamed from: bp */
    public static int m72548bp(View view) {
        C41531v bn = RecyclerView.m72546bn(view);
        return bn != null ? bn.mo66453ki() : -1;
    }

    /* renamed from: cf */
    public final C41531v mo66357cf(int i) {
        if (this.anA) {
            return null;
        }
        int hU = this.anf.mo51996hU();
        int i2 = 0;
        C41531v c41531v = null;
        while (i2 < hU) {
            C41531v bn = RecyclerView.m72546bn(this.anf.mo51992bI(i2));
            if (bn == null || bn.isRemoved() || mo66394i(bn) != i) {
                bn = c41531v;
            } else if (!this.anf.mo51991aY(bn.apJ)) {
                return bn;
            }
            i2++;
            c41531v = bn;
        }
        return c41531v;
    }

    /* renamed from: x */
    public final View mo66441x(float f, float f2) {
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

    /* renamed from: d */
    public static void m72551d(View view, Rect rect) {
        RecyclerView.m72555e(view, rect);
    }

    /* renamed from: e */
    static void m72555e(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.ala;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, (view.getRight() + rect2.right) + layoutParams.rightMargin, layoutParams.bottomMargin + (rect2.bottom + view.getBottom()));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bq */
    public final Rect mo66352bq(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.aoN) {
            return layoutParams.ala;
        }
        if (this.anY.apv && (layoutParams.aoM.mo66467kx() || layoutParams.aoM.mo66461kq())) {
            return layoutParams.ala;
        }
        Rect rect = layoutParams.ala;
        rect.set(0, 0, 0, 0);
        int size = this.anm.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            ((C25373h) this.anm.get(i)).mo18495a(this.mTempRect, view, this, this.anY);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.aoN = false;
        return rect;
    }

    /* renamed from: ap */
    public void mo64552ap(int i, int i2) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aq */
    public final void mo66345aq(int i, int i2) {
        this.anD++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        mo64552ap(i, i2);
        if (this.anZ != null) {
            this.anZ.mo6642a(this, i, i2);
        }
        if (this.aoa != null) {
            for (scrollY = this.aoa.size() - 1; scrollY >= 0; scrollY--) {
                ((C41530m) this.aoa.get(scrollY)).mo6642a(this, i, i2);
            }
        }
        this.anD--;
    }

    /* renamed from: jO */
    public final boolean mo66397jO() {
        return !this.ans || this.anA || this.ane.mo66569hw();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jP */
    public final void mo66398jP() {
        int childCount = this.anf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.anf.getChildAt(i);
            C41531v aZ = mo66337aZ(childAt);
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

    /* renamed from: br */
    static RecyclerView m72549br(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView br = RecyclerView.m72549br(viewGroup.getChildAt(i));
            if (br != null) {
                return br;
            }
        }
        return null;
    }

    /* renamed from: h */
    static void m72557h(C41531v c41531v) {
        if (c41531v.apK != null) {
            View view = (View) c41531v.apK.get();
            while (view != null) {
                if (view != c41531v.apJ) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            c41531v.apK = null;
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
    /* renamed from: bs */
    public final void mo66353bs(View view) {
        RecyclerView.m72546bn(view);
        if (this.anz != null) {
            for (int size = this.anz.size() - 1; size >= 0; size--) {
                ((C41527j) this.anz.get(size)).mo18499bH(view);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo66349b(C41531v c41531v, int i) {
        if (mo66406jz()) {
            c41531v.apY = i;
            this.aok.add(c41531v);
            return false;
        }
        C0477s.m949o(c41531v.apJ, i);
        return true;
    }

    /* renamed from: jQ */
    private void m72573jQ() {
        for (int size = this.aok.size() - 1; size >= 0; size--) {
            C41531v c41531v = (C41531v) this.aok.get(size);
            if (c41531v.apJ.getParent() == this && !c41531v.mo66452kh()) {
                int i = c41531v.apY;
                if (i != -1) {
                    C0477s.m949o(c41531v.apJ, i);
                    c41531v.apY = -1;
                }
            }
        }
        this.aok.clear();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final int mo66394i(C41531v c41531v) {
        if (c41531v.mo66446cx(524) || !c41531v.isBound()) {
            return -1;
        }
        return this.ane.mo66565bB(c41531v.mPosition);
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f562Mp;
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().mo1075w(i, 0);
    }

    /* renamed from: w */
    private boolean m72584w(int i, int i2) {
        return getScrollingChildHelper().mo1075w(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().mo1069aJ(0);
    }

    /* renamed from: aJ */
    public final void mo66336aJ(int i) {
        getScrollingChildHelper().mo1069aJ(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().mo1068aI(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* renamed from: a */
    public final boolean mo66334a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().mo1066a(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    /* renamed from: a */
    public final boolean mo66335a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().mo1067a(i, i2, iArr, iArr2, i3);
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
        return this.aog.mo18508az(i, i2);
    }

    /* Access modifiers changed, original: 0000 */
    public C0469k getScrollingChildHelper() {
        if (this.aoi == null) {
            this.aoi = new C0469k(this);
        }
        return this.aoi;
    }
}
