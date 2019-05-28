package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0488u;
import android.support.p057v4.widget.C8415j;
import android.support.p057v4.widget.Space;
import android.support.p069v7.p1155e.C41521a.C17475a;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* renamed from: android.support.v7.widget.GridLayout */
public class GridLayout extends ViewGroup {
    public static final C8426a ajA = ajy;
    public static final C8426a ajB = ajx;
    public static final C8426a ajC = ajy;
    public static final C8426a ajD = GridLayout.m14852a(ajB, ajC);
    public static final C8426a ajE = GridLayout.m14852a(ajC, ajB);
    public static final C8426a ajF = new C84246();
    public static final C8426a ajG = new C84307();
    public static final C8426a ajH = new C84328();
    static final Printer ajh = new LogPrinter(3, GridLayout.class.getName());
    static final Printer aji = new C84331();
    private static final int ajj = 0;
    private static final int ajk = 1;
    private static final int ajl = 2;
    private static final int ajm = 3;
    private static final int ajn = 4;
    private static final int ajo = 5;
    private static final int ajp = 6;
    static final C8426a ajw = new C84362();
    private static final C8426a ajx = new C06513();
    private static final C8426a ajy = new C06524();
    public static final C8426a ajz = ajx;
    final C8438d ajq;
    final C8438d ajr;
    boolean ajs;
    int ajt;
    int aju;
    int ajv;
    int mOrientation;
    Printer mPrinter;

    /* renamed from: android.support.v7.widget.GridLayout$3 */
    static class C06513 extends C8426a {
        C06513() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: w */
        public final int mo1706w(View view, int i) {
            return 0;
        }

        /* renamed from: k */
        public final int mo1705k(View view, int i, int i2) {
            return 0;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: in */
        public final String mo1704in() {
            return "LEADING";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$4 */
    static class C06524 extends C8426a {
        C06524() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: w */
        public final int mo1706w(View view, int i) {
            return i;
        }

        /* renamed from: k */
        public final int mo1705k(View view, int i, int i2) {
            return i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: in */
        public final String mo1704in() {
            return "TRAILING";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        private static final int akA = 3;
        private static final int akB = 4;
        private static final int akC = 5;
        private static final int akD = 6;
        private static final int akE = 10;
        private static final int akF = 11;
        private static final int akG = 12;
        private static final int akH = 7;
        private static final int akI = 8;
        private static final int akJ = 9;
        private static final int akK = 13;
        private static final C8427f akx;
        private static final int aky;
        private static final int akz = 2;
        public C8429i akL;
        public C8429i akM;

        static {
            C8427f c8427f = new C8427f(C8415j.INVALID_ID, -2147483647);
            akx = c8427f;
            aky = c8427f.size();
        }

        private LayoutParams(C8429i c8429i, C8429i c8429i2) {
            super(-2, -2);
            this.akL = C8429i.akQ;
            this.akM = C8429i.akQ;
            setMargins(C8415j.INVALID_ID, C8415j.INVALID_ID, C8415j.INVALID_ID, C8415j.INVALID_ID);
            this.akL = c8429i;
            this.akM = c8429i2;
        }

        private LayoutParams(C8429i c8429i, C8429i c8429i2, byte b) {
            this(c8429i, c8429i2);
        }

        public LayoutParams() {
            C8429i c8429i = C8429i.akQ;
            this(c8429i, c8429i, (byte) 0);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.akL = C8429i.akQ;
            this.akM = C8429i.akQ;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.akL = C8429i.akQ;
            this.akM = C8429i.akQ;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.akL = C8429i.akQ;
            this.akM = C8429i.akQ;
            this.akL = layoutParams.akL;
            this.akM = layoutParams.akM;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.akL = C8429i.akQ;
            this.akM = C8429i.akQ;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C17475a.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(akz, C8415j.INVALID_ID);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(akA, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(akB, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(akC, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(akD, dimensionPixelSize);
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C17475a.GridLayout_Layout);
                try {
                    dimensionPixelSize = obtainStyledAttributes.getInt(akK, 0);
                    this.akM = GridLayout.m14853a(obtainStyledAttributes.getInt(akE, C8415j.INVALID_ID), obtainStyledAttributes.getInt(akF, aky), GridLayout.m14870n(dimensionPixelSize, true), obtainStyledAttributes.getFloat(akG, 0.0f));
                    this.akL = GridLayout.m14853a(obtainStyledAttributes.getInt(akH, C8415j.INVALID_ID), obtainStyledAttributes.getInt(akI, aky), GridLayout.m14870n(dimensionPixelSize, false), obtainStyledAttributes.getFloat(akJ, 0.0f));
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        /* Access modifiers changed, original: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, -2);
            this.height = typedArray.getLayoutDimension(i2, -2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            if (!this.akM.equals(layoutParams.akM)) {
                return false;
            }
            if (this.akL.equals(layoutParams.akL)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.akL.hashCode() * 31) + this.akM.hashCode();
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$6 */
    static class C84246 extends C8426a {
        C84246() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: w */
        public final int mo1706w(View view, int i) {
            return i >> 1;
        }

        /* renamed from: k */
        public final int mo1705k(View view, int i, int i2) {
            return i >> 1;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: in */
        public final String mo1704in() {
            return "CENTER";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$h */
    static final class C8425h<K, V> {
        public final int[] akN;
        public final K[] akO;
        public final V[] akP;

        C8425h(K[] kArr, V[] vArr) {
            this.akN = C8425h.m14848c(kArr);
            this.akO = C8425h.m14847a(kArr, this.akN);
            this.akP = C8425h.m14847a(vArr, this.akN);
        }

        /* renamed from: bR */
        public final V mo18398bR(int i) {
            return this.akP[this.akN[i]];
        }

        /* renamed from: c */
        private static <K> int[] m14848c(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap hashMap = new HashMap();
            for (int i = 0; i < length; i++) {
                Object obj = kArr[i];
                Integer num = (Integer) hashMap.get(obj);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(obj, num);
                }
                iArr[i] = num.intValue();
            }
            return iArr;
        }

        /* renamed from: a */
        private static <K> K[] m14847a(K[] kArr, int[] iArr) {
            int length = kArr.length;
            Object[] objArr = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.m14861g(iArr) + 1);
            for (int i = 0; i < length; i++) {
                objArr[iArr[i]] = kArr[i];
            }
            return objArr;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$a */
    public static abstract class C8426a {
        /* renamed from: in */
        public abstract String mo1704in();

        /* renamed from: k */
        public abstract int mo1705k(View view, int i, int i2);

        /* renamed from: w */
        public abstract int mo1706w(View view, int i);

        C8426a() {
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: W */
        public int mo18422W(int i, int i2) {
            return i;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: io */
        public C8435e mo18423io() {
            return new C8435e();
        }

        public String toString() {
            return "Alignment:" + mo1704in();
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$f */
    static final class C8427f {
        public final int max;
        public final int min;

        public C8427f(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        /* Access modifiers changed, original: final */
        public final int size() {
            return this.max - this.min;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C8427f c8427f = (C8427f) obj;
            if (this.max != c8427f.max) {
                return false;
            }
            if (this.min != c8427f.min) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.min * 31) + this.max;
        }

        public final String toString() {
            return "[" + this.min + ", " + this.max + "]";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$g */
    static final class C8428g {
        public int value;

        public C8428g() {
            this.value = C8415j.INVALID_ID;
        }

        public C8428g(int i) {
            this.value = i;
        }

        public final String toString() {
            return Integer.toString(this.value);
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$i */
    public static class C8429i {
        static final C8429i akQ = GridLayout.m14869im();
        final C8427f ajL;
        final boolean akR;
        final C8426a akS;
        final float weight;

        private C8429i(boolean z, C8427f c8427f, C8426a c8426a, float f) {
            this.akR = z;
            this.ajL = c8427f;
            this.akS = c8426a;
            this.weight = f;
        }

        C8429i(boolean z, int i, int i2, C8426a c8426a, float f) {
            this(z, new C8427f(i, i + i2), c8426a, f);
        }

        /* renamed from: ag */
        public final C8426a mo18431ag(boolean z) {
            if (this.akS != GridLayout.ajw) {
                return this.akS;
            }
            if (this.weight == 0.0f) {
                return z ? GridLayout.ajB : GridLayout.ajG;
            } else {
                return GridLayout.ajH;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final C8429i mo18430a(C8427f c8427f) {
            return new C8429i(this.akR, c8427f, this.akS, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C8429i c8429i = (C8429i) obj;
            if (!this.akS.equals(c8429i.akS)) {
                return false;
            }
            if (this.ajL.equals(c8429i.ajL)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.ajL.hashCode() * 31) + this.akS.hashCode();
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$7 */
    static class C84307 extends C8426a {

        /* renamed from: android.support.v7.widget.GridLayout$7$1 */
        class C84311 extends C8435e {
            private int size;

            C84311() {
            }

            /* Access modifiers changed, original: protected|final */
            public final void reset() {
                super.reset();
                this.size = C8415j.INVALID_ID;
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: V */
            public final void mo18434V(int i, int i2) {
                super.mo18434V(i, i2);
                this.size = Math.max(this.size, i + i2);
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: ac */
            public final int mo18436ac(boolean z) {
                return Math.max(super.mo18436ac(z), this.size);
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: a */
            public final int mo18435a(GridLayout gridLayout, View view, C8426a c8426a, int i, boolean z) {
                return Math.max(0, super.mo18435a(gridLayout, view, c8426a, i, z));
            }
        }

        C84307() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: w */
        public final int mo1706w(View view, int i) {
            return 0;
        }

        /* renamed from: k */
        public final int mo1705k(View view, int i, int i2) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            return baseline == -1 ? C8415j.INVALID_ID : baseline;
        }

        /* renamed from: io */
        public final C8435e mo18423io() {
            return new C84311();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: in */
        public final String mo1704in() {
            return "BASELINE";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$8 */
    static class C84328 extends C8426a {
        C84328() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: w */
        public final int mo1706w(View view, int i) {
            return 0;
        }

        /* renamed from: k */
        public final int mo1705k(View view, int i, int i2) {
            return C8415j.INVALID_ID;
        }

        /* renamed from: W */
        public final int mo18422W(int i, int i2) {
            return i2;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: in */
        public final String mo1704in() {
            return "FILL";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$1 */
    static class C84331 implements Printer {
        C84331() {
        }

        public final void println(String str) {
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$c */
    static final class C8434c<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> ajO;
        private final Class<V> ajP;

        private C8434c(Class<K> cls, Class<V> cls2) {
            this.ajO = cls;
            this.ajP = cls2;
        }

        /* renamed from: a */
        public static <K, V> C8434c<K, V> m14891a(Class<K> cls, Class<V> cls2) {
            return new C8434c(cls, cls2);
        }

        /* renamed from: f */
        public final void mo18439f(K k, V v) {
            add(Pair.create(k, v));
        }

        /* renamed from: ip */
        public final C8425h<K, V> mo18440ip() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.ajO, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.ajP, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = ((Pair) get(i)).first;
                objArr2[i] = ((Pair) get(i)).second;
            }
            return new C8425h(objArr, objArr2);
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$e */
    static class C8435e {
        public int aku;
        public int akv;
        public int akw;

        C8435e() {
            reset();
        }

        /* Access modifiers changed, original: protected */
        public void reset() {
            this.aku = C8415j.INVALID_ID;
            this.akv = C8415j.INVALID_ID;
            this.akw = 2;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: V */
        public void mo18434V(int i, int i2) {
            this.aku = Math.max(this.aku, i);
            this.akv = Math.max(this.akv, i2);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: ac */
        public int mo18436ac(boolean z) {
            if (z || !GridLayout.m14858bN(this.akw)) {
                return this.aku + this.akv;
            }
            return 100000;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public int mo18435a(GridLayout gridLayout, View view, C8426a c8426a, int i, boolean z) {
            return this.aku - c8426a.mo1705k(view, i, C0488u.m1010d(gridLayout));
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo18441a(GridLayout gridLayout, View view, C8429i c8429i, C8438d c8438d, int i) {
            int i2;
            int i3 = this.akw;
            if (c8429i.akS == GridLayout.ajw && c8429i.weight == 0.0f) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            this.akw = i2 & i3;
            i2 = c8429i.mo18431ag(c8438d.ajQ).mo1705k(view, i, C0488u.m1010d(gridLayout));
            mo18434V(i2, i - i2);
        }

        public String toString() {
            return "Bounds{before=" + this.aku + ", after=" + this.akv + '}';
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$2 */
    static class C84362 extends C8426a {
        C84362() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: w */
        public final int mo1706w(View view, int i) {
            return C8415j.INVALID_ID;
        }

        /* renamed from: k */
        public final int mo1705k(View view, int i, int i2) {
            return C8415j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: in */
        public final String mo1704in() {
            return "UNDEFINED";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$b */
    static final class C8437b {
        public final C8427f ajL;
        public final C8428g ajM;
        public boolean ajN = true;

        public C8437b(C8427f c8427f, C8428g c8428g) {
            this.ajL = c8427f;
            this.ajM = c8428g;
        }

        public final String toString() {
            return this.ajL + " " + (!this.ajN ? "+>" : "->") + " " + this.ajM;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$d */
    final class C8438d {
        static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
        public final boolean ajQ;
        public int ajR = C8415j.INVALID_ID;
        private int ajS = C8415j.INVALID_ID;
        C8425h<C8429i, C8435e> ajT;
        public boolean ajU = false;
        C8425h<C8427f, C8428g> ajV;
        public boolean ajW = false;
        C8425h<C8427f, C8428g> ajX;
        public boolean ajY = false;
        public int[] ajZ;
        public boolean aka = false;
        public int[] akb;
        public boolean akc = false;
        public C8437b[] akd;
        public boolean ake = false;
        public int[] akf;
        public boolean akg = false;
        public boolean akh;
        public boolean aki = false;
        public int[] akj;
        boolean akk = true;
        private C8428g akl = new C8428g(0);
        private C8428g akm = new C8428g(-100000);

        C8438d(boolean z) {
            this.ajQ = z;
        }

        /* renamed from: iq */
        private int m14913iq() {
            if (this.ajS == C8415j.INVALID_ID) {
                int childCount = GridLayout.this.getChildCount();
                int i = -1;
                for (int i2 = 0; i2 < childCount; i2++) {
                    LayoutParams bc = GridLayout.m14859bc(GridLayout.this.getChildAt(i2));
                    C8427f c8427f = (this.ajQ ? bc.akM : bc.akL).ajL;
                    i = Math.max(Math.max(Math.max(i, c8427f.min), c8427f.max), c8427f.size());
                }
                this.ajS = Math.max(0, i == -1 ? C8415j.INVALID_ID : i);
            }
            return this.ajS;
        }

        public final int getCount() {
            return Math.max(this.ajR, m14913iq());
        }

        public final void setCount(int i) {
            if (i != C8415j.INVALID_ID && i < m14913iq()) {
                GridLayout.m14850S((this.ajQ ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
            }
            this.ajR = i;
        }

        /* renamed from: ad */
        public final void mo18445ad(boolean z) {
            this.akk = z;
            mo18450ii();
        }

        /* renamed from: ir */
        private C8425h<C8429i, C8435e> m14914ir() {
            C8434c a = C8434c.m14891a(C8429i.class, C8435e.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams bc = GridLayout.m14859bc(GridLayout.this.getChildAt(i));
                C8429i c8429i = this.ajQ ? bc.akM : bc.akL;
                a.mo18439f(c8429i, c8429i.mo18431ag(this.ajQ).mo18423io());
            }
            return a.mo18440ip();
        }

        /* renamed from: is */
        private void m14915is() {
            int i;
            C8435e[] c8435eArr = (C8435e[]) this.ajT.akP;
            for (C8435e reset : c8435eArr) {
                reset.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                int i3;
                View childAt = GridLayout.this.getChildAt(i2);
                LayoutParams bc = GridLayout.m14859bc(childAt);
                C8429i c8429i = this.ajQ ? bc.akM : bc.akL;
                GridLayout gridLayout = GridLayout.this;
                boolean z = this.ajQ;
                if (childAt.getVisibility() == 8) {
                    i3 = 0;
                } else {
                    i3 = gridLayout.mo18401g(childAt, z) + GridLayout.m14863h(childAt, z);
                }
                if (c8429i.weight == 0.0f) {
                    i = 0;
                } else {
                    i = m14920iy()[i2];
                }
                ((C8435e) this.ajT.mo18398bR(i2)).mo18441a(GridLayout.this, childAt, c8429i, this, i3 + i);
            }
        }

        /* renamed from: it */
        public final C8425h<C8429i, C8435e> mo18452it() {
            if (this.ajT == null) {
                this.ajT = m14914ir();
            }
            if (!this.ajU) {
                m14915is();
                this.ajU = true;
            }
            return this.ajT;
        }

        /* renamed from: ae */
        private C8425h<C8427f, C8428g> m14909ae(boolean z) {
            C8434c a = C8434c.m14891a(C8427f.class, C8428g.class);
            C8429i[] c8429iArr = (C8429i[]) mo18452it().akO;
            int length = c8429iArr.length;
            for (int i = 0; i < length; i++) {
                Object obj;
                if (z) {
                    obj = c8429iArr[i].ajL;
                } else {
                    C8427f c8427f = c8429iArr[i].ajL;
                    obj = new C8427f(c8427f.max, c8427f.min);
                }
                a.mo18439f(obj, new C8428g());
            }
            return a.mo18440ip();
        }

        /* renamed from: a */
        private void m14903a(C8425h<C8427f, C8428g> c8425h, boolean z) {
            int i = 0;
            C8428g[] c8428gArr = (C8428g[]) c8425h.akP;
            for (C8428g c8428g : c8428gArr) {
                c8428g.value = C8415j.INVALID_ID;
            }
            C8435e[] c8435eArr = (C8435e[]) mo18452it().akP;
            while (i < c8435eArr.length) {
                int ac = c8435eArr[i].mo18436ac(z);
                C8428g c8428g2 = (C8428g) c8425h.mo18398bR(i);
                int i2 = c8428g2.value;
                if (!z) {
                    ac = -ac;
                }
                c8428g2.value = Math.max(i2, ac);
                i++;
            }
        }

        /* renamed from: iu */
        private C8425h<C8427f, C8428g> m14916iu() {
            if (this.ajV == null) {
                this.ajV = m14909ae(true);
            }
            if (!this.ajW) {
                m14903a(this.ajV, true);
                this.ajW = true;
            }
            return this.ajV;
        }

        /* renamed from: iv */
        private C8425h<C8427f, C8428g> m14917iv() {
            if (this.ajX == null) {
                this.ajX = m14909ae(false);
            }
            if (!this.ajY) {
                m14903a(this.ajX, false);
                this.ajY = true;
            }
            return this.ajX;
        }

        /* renamed from: a */
        private static void m14905a(List<C8437b> list, C8427f c8427f, C8428g c8428g, boolean z) {
            if (c8427f.size() != 0) {
                if (z) {
                    for (C8437b c8437b : list) {
                        if (c8437b.ajL.equals(c8427f)) {
                            return;
                        }
                    }
                }
                list.add(new C8437b(c8427f, c8428g));
            }
        }

        /* renamed from: a */
        private static void m14904a(List<C8437b> list, C8427f c8427f, C8428g c8428g) {
            C8438d.m14905a(list, c8427f, c8428g, true);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final C8437b[][] mo18444a(C8437b[] c8437bArr) {
            int i;
            int i2 = 0;
            int count = getCount() + 1;
            C8437b[][] c8437bArr2 = new C8437b[count][];
            int[] iArr = new int[count];
            for (C8437b c8437b : c8437bArr) {
                i = c8437b.ajL.min;
                iArr[i] = iArr[i] + 1;
            }
            for (count = 0; count < iArr.length; count++) {
                c8437bArr2[count] = new C8437b[iArr[count]];
            }
            Arrays.fill(iArr, 0);
            count = c8437bArr.length;
            while (i2 < count) {
                C8437b c8437b2 = c8437bArr[i2];
                i = c8437b2.ajL.min;
                C8437b[] c8437bArr3 = c8437bArr2[i];
                int i3 = iArr[i];
                iArr[i] = i3 + 1;
                c8437bArr3[i3] = c8437b2;
                i2++;
            }
            return c8437bArr2;
        }

        /* renamed from: p */
        private C8437b[] m14921p(List<C8437b> list) {
            final C8437b[] c8437bArr = (C8437b[]) list.toArray(new C8437b[list.size()]);
            C84391 c84391 = new Object() {
                static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
                C8437b[] ako = new C8437b[c8437bArr.length];
                int akp = (this.ako.length - 1);
                C8437b[][] akq = C8438d.this.mo18444a(c8437bArr);
                int[] akr = new int[(C8438d.this.getCount() + 1)];

                /* Access modifiers changed, original: final */
                /* renamed from: bQ */
                public final void mo18455bQ(int i) {
                    switch (this.akr[i]) {
                        case 0:
                            this.akr[i] = 1;
                            for (C8437b c8437b : this.akq[i]) {
                                mo18455bQ(c8437b.ajL.max);
                                C8437b[] c8437bArr = this.ako;
                                int i2 = this.akp;
                                this.akp = i2 - 1;
                                c8437bArr[i2] = c8437b;
                            }
                            this.akr[i] = 2;
                            return;
                        case 1:
                            if (!$assertionsDisabled) {
                                throw new AssertionError();
                            }
                            return;
                        default:
                            return;
                    }
                }
            };
            int length = c84391.akq.length;
            for (int i = 0; i < length; i++) {
                c84391.mo18455bQ(i);
            }
            if (C84391.$assertionsDisabled || c84391.akp == -1) {
                return c84391.ako;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        private static void m14906a(List<C8437b> list, C8425h<C8427f, C8428g> c8425h) {
            for (int i = 0; i < ((C8427f[]) c8425h.akO).length; i++) {
                C8438d.m14905a(list, ((C8427f[]) c8425h.akO)[i], ((C8428g[]) c8425h.akP)[i], false);
            }
        }

        /* renamed from: iw */
        private void m14918iw() {
            m14916iu();
            m14917iv();
        }

        /* renamed from: ix */
        private C8437b[] m14919ix() {
            if (this.akd == null) {
                int i;
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                C8438d.m14906a(arrayList, m14916iu());
                C8438d.m14906a(arrayList2, m14917iv());
                if (this.akk) {
                    for (i = 0; i < getCount(); i++) {
                        C8438d.m14904a(arrayList, new C8427f(i, i + 1), new C8428g(0));
                    }
                }
                i = getCount();
                C8438d.m14905a(arrayList, new C8427f(0, i), this.akl, false);
                C8438d.m14905a(arrayList2, new C8427f(i, 0), this.akm, false);
                this.akd = (C8437b[]) GridLayout.m14856a(m14921p(arrayList), m14921p(arrayList2));
            }
            if (!this.ake) {
                m14918iw();
                this.ake = true;
            }
            return this.akd;
        }

        /* renamed from: a */
        private static boolean m14907a(int[] iArr, C8437b c8437b) {
            if (!c8437b.ajN) {
                return false;
            }
            C8427f c8427f = c8437b.ajL;
            int i = c8427f.min;
            int i2 = c8427f.max;
            i = iArr[i] + c8437b.ajM.value;
            if (i <= iArr[i2]) {
                return false;
            }
            iArr[i2] = i;
            return true;
        }

        /* renamed from: q */
        private String m14922q(List<C8437b> list) {
            String str = this.ajQ ? VideoMaterialUtil.CRAZYFACE_X : VideoMaterialUtil.CRAZYFACE_Y;
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (C8437b c8437b : list) {
                String str2;
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder = stringBuilder.append(", ");
                }
                int i = c8437b.ajL.min;
                int i2 = c8437b.ajL.max;
                int i3 = c8437b.ajM.value;
                if (i < i2) {
                    str2 = str + i2 + "-" + str + i + ">=" + i3;
                } else {
                    str2 = str + i + "-" + str + i2 + "<=" + (-i3);
                }
                stringBuilder.append(str2);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private boolean m14908a(C8437b[] c8437bArr, int[] iArr, boolean z) {
            int i = 0;
            String str = this.ajQ ? MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i2 = 0; i2 < c8437bArr.length; i2++) {
                int i3;
                int i4;
                Arrays.fill(iArr, 0);
                for (i3 = 0; i3 < count; i3++) {
                    i4 = 0;
                    for (C8437b a : c8437bArr) {
                        i4 |= C8438d.m14907a(iArr, a);
                    }
                    if (i4 == 0) {
                        if (zArr != null) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            while (i < c8437bArr.length) {
                                Object obj = c8437bArr[i];
                                if (zArr[i]) {
                                    arrayList.add(obj);
                                }
                                if (!obj.ajN) {
                                    arrayList2.add(obj);
                                }
                                i++;
                            }
                            GridLayout.this.mPrinter.println(str + " constraints: " + m14922q(arrayList) + " are inconsistent; permanently removing: " + m14922q(arrayList2) + ". ");
                        }
                        return true;
                    }
                }
                if (!z) {
                    return false;
                }
                boolean[] zArr2 = new boolean[c8437bArr.length];
                for (i3 = 0; i3 < count; i3++) {
                    int length = c8437bArr.length;
                    for (i4 = 0; i4 < length; i4++) {
                        zArr2[i4] = zArr2[i4] | C8438d.m14907a(iArr, c8437bArr[i4]);
                    }
                }
                if (i2 == 0) {
                    zArr = zArr2;
                }
                for (i4 = 0; i4 < c8437bArr.length; i4++) {
                    if (zArr2[i4]) {
                        C8437b c8437b = c8437bArr[i4];
                        if (c8437b.ajL.min >= c8437b.ajL.max) {
                            c8437b.ajN = false;
                            break;
                        }
                    }
                }
            }
            return true;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: af */
        public final void mo18446af(boolean z) {
            int[] iArr = z ? this.ajZ : this.akb;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams bc = GridLayout.m14859bc(childAt);
                    C8427f c8427f = (this.ajQ ? bc.akM : bc.akL).ajL;
                    int i2 = z ? c8427f.min : c8427f.max;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.mo18399a(childAt, this.ajQ, z));
                }
            }
        }

        /* renamed from: h */
        private boolean m14911h(int[] iArr) {
            return m14908a(m14919ix(), iArr, true);
        }

        /* renamed from: iy */
        private int[] m14920iy() {
            if (this.akj == null) {
                this.akj = new int[GridLayout.this.getChildCount()];
            }
            return this.akj;
        }

        /* renamed from: f */
        private void m14910f(int i, float f) {
            Arrays.fill(this.akj, 0);
            int childCount = GridLayout.this.getChildCount();
            int i2 = 0;
            float f2 = f;
            int i3 = i;
            while (i2 < childCount) {
                float f3;
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams bc = GridLayout.m14859bc(childAt);
                    f3 = (this.ajQ ? bc.akM : bc.akL).weight;
                    if (f3 != 0.0f) {
                        int round = Math.round((((float) i3) * f3) / f2);
                        this.akj[i2] = round;
                        i3 -= round;
                        f3 = f2 - f3;
                        i2++;
                        f2 = f3;
                    }
                }
                f3 = f2;
                i2++;
                f2 = f3;
            }
        }

        /* renamed from: i */
        private void m14912i(int[] iArr) {
            int childCount;
            int i;
            View childAt;
            LayoutParams bc;
            int i2;
            float f = 0.0f;
            boolean z = true;
            int i3 = 0;
            if (!this.aki) {
                boolean z2;
                childCount = GridLayout.this.getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = GridLayout.this.getChildAt(i);
                    if (childAt.getVisibility() != 8) {
                        bc = GridLayout.m14859bc(childAt);
                        if ((this.ajQ ? bc.akM : bc.akL).weight != 0.0f) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                this.akh = z2;
                this.aki = true;
            }
            if (this.akh) {
                Arrays.fill(m14920iy(), 0);
                m14911h(iArr);
                i = (this.akl.value * GridLayout.this.getChildCount()) + 1;
                if (i >= 2) {
                    int childCount2 = GridLayout.this.getChildCount();
                    childCount = 0;
                    while (childCount < childCount2) {
                        float f2;
                        childAt = GridLayout.this.getChildAt(childCount);
                        if (childAt.getVisibility() != 8) {
                            bc = GridLayout.m14859bc(childAt);
                            f2 = (this.ajQ ? bc.akM : bc.akL).weight + f;
                        } else {
                            f2 = f;
                        }
                        childCount++;
                        f = f2;
                    }
                    i2 = -1;
                    childCount = 0;
                    childCount2 = i;
                    while (childCount < childCount2) {
                        i = (int) ((((long) childCount) + ((long) childCount2)) / 2);
                        mo18451ij();
                        m14910f(i, f);
                        z = m14908a(m14919ix(), iArr, false);
                        if (z) {
                            childCount = i + 1;
                            i2 = i;
                        } else {
                            childCount2 = i;
                        }
                    }
                    if (i2 > 0 && !z) {
                        mo18451ij();
                        m14910f(i2, f);
                        m14911h(iArr);
                    }
                }
            } else {
                m14911h(iArr);
            }
            if (!this.akk) {
                i2 = iArr[0];
                int length = iArr.length;
                while (i3 < length) {
                    iArr[i3] = iArr[i3] - i2;
                    i3++;
                }
            }
        }

        /* renamed from: iz */
        public final int[] mo18453iz() {
            if (this.akf == null) {
                this.akf = new int[(getCount() + 1)];
            }
            if (!this.akg) {
                m14912i(this.akf);
                this.akg = true;
            }
            return this.akf;
        }

        /* renamed from: X */
        private void m14901X(int i, int i2) {
            this.akl.value = i;
            this.akm.value = -i2;
            this.akg = false;
        }

        /* renamed from: Y */
        private int m14902Y(int i, int i2) {
            m14901X(i, i2);
            return mo18453iz()[getCount()];
        }

        /* renamed from: bO */
        public final int mo18447bO(int i) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case C8415j.INVALID_ID /*-2147483648*/:
                    return m14902Y(0, size);
                case 0:
                    return m14902Y(0, 100000);
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    return m14902Y(size, size);
                default:
                    if ($assertionsDisabled) {
                        return 0;
                    }
                    throw new AssertionError();
            }
        }

        /* renamed from: bP */
        public final void mo18448bP(int i) {
            m14901X(i, i);
            mo18453iz();
        }

        /* renamed from: ii */
        public final void mo18450ii() {
            this.ajS = C8415j.INVALID_ID;
            this.ajT = null;
            this.ajV = null;
            this.ajX = null;
            this.ajZ = null;
            this.akb = null;
            this.akd = null;
            this.akf = null;
            this.akj = null;
            this.aki = false;
            mo18451ij();
        }

        /* renamed from: ij */
        public final void mo18451ij() {
            this.ajU = false;
            this.ajW = false;
            this.ajY = false;
            this.aka = false;
            this.akc = false;
            this.ake = false;
            this.akg = false;
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajq = new C8438d(true);
        this.ajr = new C8438d(false);
        this.mOrientation = 0;
        this.ajs = false;
        this.ajt = 1;
        this.ajv = 0;
        this.mPrinter = ajh;
        this.aju = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10333yb);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C17475a.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(ajk, C8415j.INVALID_ID));
            setColumnCount(obtainStyledAttributes.getInt(ajl, C8415j.INVALID_ID));
            setOrientation(obtainStyledAttributes.getInt(ajj, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(ajm, false));
            setAlignmentMode(obtainStyledAttributes.getInt(ajn, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(ajo, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(ajp, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            m14865ii();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.ajr.getCount();
    }

    public void setRowCount(int i) {
        this.ajr.setCount(i);
        m14865ii();
        requestLayout();
    }

    public int getColumnCount() {
        return this.ajq.getCount();
    }

    public void setColumnCount(int i) {
        this.ajq.setCount(i);
        m14865ii();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.ajs;
    }

    public void setUseDefaultMargins(boolean z) {
        this.ajs = z;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.ajt;
    }

    public void setAlignmentMode(int i) {
        this.ajt = i;
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z) {
        this.ajr.mo18445ad(z);
        m14865ii();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.ajq.mo18445ad(z);
        m14865ii();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = aji;
        }
        this.mPrinter = printer;
    }

    /* renamed from: g */
    static int m14861g(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    /* renamed from: a */
    static <T> T[] m14856a(T[] tArr, T[] tArr2) {
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        System.arraycopy(tArr2, 0, objArr, tArr.length, tArr2.length);
        return objArr;
    }

    /* renamed from: n */
    static C8426a m14870n(int i, boolean z) {
        switch (((z ? 7 : 112) & i) >> (z ? 0 : 4)) {
            case 1:
                return ajF;
            case 3:
                return z ? ajD : ajz;
            case 5:
                return z ? ajE : ajA;
            case 7:
                return ajH;
            case 8388611:
                return ajB;
            case 8388613:
                return ajC;
            default:
                return ajw;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo18399a(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        if (i != C8415j.INVALID_ID) {
            return i;
        }
        if (!this.ajs) {
            return 0;
        }
        C8429i c8429i = z ? layoutParams.akM : layoutParams.akL;
        C8438d c8438d = z ? this.ajq : this.ajr;
        C8427f c8427f = c8429i.ajL;
        if (z && m14864ih()) {
            if (z2) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            c8438d.getCount();
        } else if (c8427f.min != 0) {
        }
        if (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) {
            return 0;
        }
        return this.aju / 2;
    }

    /* renamed from: ih */
    private boolean m14864ih() {
        return C0477s.m893T(this) == 1;
    }

    /* renamed from: b */
    private int m14857b(View view, boolean z, boolean z2) {
        if (this.ajt == 1) {
            return mo18399a(view, z, z2);
        }
        int[] iArr;
        C8438d c8438d = z ? this.ajq : this.ajr;
        if (z2) {
            if (c8438d.ajZ == null) {
                c8438d.ajZ = new int[(c8438d.getCount() + 1)];
            }
            if (!c8438d.aka) {
                c8438d.mo18446af(true);
                c8438d.aka = true;
            }
            iArr = c8438d.ajZ;
        } else {
            if (c8438d.akb == null) {
                c8438d.akb = new int[(c8438d.getCount() + 1)];
            }
            if (!c8438d.akc) {
                c8438d.mo18446af(false);
                c8438d.akc = true;
            }
            iArr = c8438d.akb;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        C8429i c8429i = z ? layoutParams.akM : layoutParams.akL;
        return iArr[z2 ? c8429i.ajL.min : c8429i.ajL.max];
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final int mo18401g(View view, boolean z) {
        return m14857b(view, z, true) + m14857b(view, z, false);
    }

    /* renamed from: a */
    private static void m14854a(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.akL = layoutParams.akL.mo18430a(new C8427f(i, i + i2));
        layoutParams.akM = layoutParams.akM.mo18430a(new C8427f(i3, i3 + i4));
    }

    /* renamed from: ii */
    private void m14865ii() {
        this.ajv = 0;
        if (this.ajq != null) {
            this.ajq.mo18450ii();
        }
        if (this.ajr != null) {
            this.ajr.mo18450ii();
        }
        m14866ij();
    }

    /* renamed from: ij */
    private void m14866ij() {
        if (this.ajq != null && this.ajr != null) {
            this.ajq.mo18451ij();
            this.ajr.mo18451ij();
        }
    }

    /* renamed from: bc */
    static LayoutParams m14859bc(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    /* renamed from: S */
    static void m14850S(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    /* renamed from: a */
    private void m14855a(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        C8427f c8427f = (z ? layoutParams.akM : layoutParams.akL).ajL;
        if (c8427f.min != C8415j.INVALID_ID && c8427f.min < 0) {
            GridLayout.m14850S(str + " indices must be positive");
        }
        int i = (z ? this.ajq : this.ajr).ajR;
        if (i != C8415j.INVALID_ID) {
            if (c8427f.max > i) {
                GridLayout.m14850S(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (c8427f.size() > i) {
                GridLayout.m14850S(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        m14855a(layoutParams2, true);
        m14855a(layoutParams2, false);
        return true;
    }

    /* renamed from: ik */
    private int m14867ik() {
        int i = 1;
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            int hashCode;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                hashCode = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (i * 31);
            } else {
                hashCode = i;
            }
            i2++;
            i = hashCode;
        }
        return i;
    }

    /* renamed from: il */
    private void m14868il() {
        while (this.ajv != 0) {
            if (this.ajv != m14867ik()) {
                this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
                m14865ii();
            } else {
                return;
            }
        }
        Object obj = this.mOrientation == 0 ? 1 : null;
        C8438d c8438d = obj != null ? this.ajq : this.ajr;
        int i = c8438d.ajR != C8415j.INVALID_ID ? c8438d.ajR : 0;
        int i2 = 0;
        int i3 = 0;
        int[] iArr = new int[i];
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            C8429i c8429i = obj != null ? layoutParams.akL : layoutParams.akM;
            C8427f c8427f = c8429i.ajL;
            boolean z = c8429i.akR;
            int size = c8427f.size();
            if (z) {
                i2 = c8427f.min;
            }
            c8429i = obj != null ? layoutParams.akM : layoutParams.akL;
            C8427f c8427f2 = c8429i.ajL;
            boolean z2 = c8429i.akR;
            int size2 = c8427f2.size();
            if (i != 0) {
                size2 = Math.min(size2, i - (z2 ? Math.min(c8427f2.min, i) : 0));
            }
            if (z2) {
                i5 = c8427f2.min;
            } else {
                i5 = i3;
            }
            if (i != 0) {
                int i6;
                if (!z || !z2) {
                    while (true) {
                        Object obj2;
                        i6 = i5 + size2;
                        if (i6 > iArr.length) {
                            obj2 = null;
                        } else {
                            for (i3 = i5; i3 < i6; i3++) {
                                if (iArr[i3] > i2) {
                                    obj2 = null;
                                    break;
                                }
                            }
                            obj2 = 1;
                        }
                        if (obj2 != null) {
                            break;
                        } else if (z2) {
                            i2++;
                        } else if (i5 + size2 <= i) {
                            i5++;
                        } else {
                            i5 = 0;
                            i2++;
                        }
                    }
                }
                i3 = i5 + size2;
                i6 = i2 + size;
                int length = iArr.length;
                Arrays.fill(iArr, Math.min(i5, length), Math.min(i3, length), i6);
            }
            if (obj != null) {
                GridLayout.m14854a(layoutParams, i2, size, i5, size2);
            } else {
                GridLayout.m14854a(layoutParams, i5, size2, i2, size);
            }
            i3 = i5 + size2;
        }
        this.ajv = m14867ik();
    }

    /* renamed from: g */
    private void m14862g(View view, int i, int i2, int i3, int i4) {
        view.measure(GridLayout.getChildMeasureSpec(i, mo18401g(view, true), i3), GridLayout.getChildMeasureSpec(i2, mo18401g(view, false), i4));
    }

    /* renamed from: d */
    private void m14860d(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    m14862g(childAt, i, i2, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0;
                    C8429i c8429i = z2 ? layoutParams.akM : layoutParams.akL;
                    if (c8429i.mo18431ag(z2) == ajH) {
                        C8427f c8427f = c8429i.ajL;
                        int[] iz = (z2 ? this.ajq : this.ajr).mo18453iz();
                        int g = (iz[c8427f.max] - iz[c8427f.min]) - mo18401g(childAt, z2);
                        if (z2) {
                            m14862g(childAt, i, i2, g, layoutParams.height);
                        } else {
                            m14862g(childAt, i, i2, layoutParams.width, g);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: U */
    private static int m14851U(int i, int i2) {
        return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i + i2), MeasureSpec.getMode(i));
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int bO;
        int bO2;
        m14868il();
        m14866ij();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int U = GridLayout.m14851U(i, -paddingLeft);
        int U2 = GridLayout.m14851U(i2, -paddingTop);
        m14860d(U, U2, true);
        if (this.mOrientation == 0) {
            bO = this.ajq.mo18447bO(U);
            m14860d(U, U2, false);
            bO2 = this.ajr.mo18447bO(U2);
        } else {
            bO2 = this.ajr.mo18447bO(U2);
            m14860d(U, U2, false);
            bO = this.ajq.mo18447bO(U);
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(bO + paddingLeft, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(Math.max(bO2 + paddingTop, getSuggestedMinimumHeight()), i2, 0));
    }

    /* renamed from: h */
    static int m14863h(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public void requestLayout() {
        super.requestLayout();
        m14865ii();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m14868il();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.ajq.mo18448bP((i5 - paddingLeft) - paddingRight);
        this.ajr.mo18448bP((i6 - paddingTop) - paddingBottom);
        int[] iz = this.ajq.mo18453iz();
        int[] iz2 = this.ajr.mo18453iz();
        i6 = 0;
        int childCount = getChildCount();
        while (true) {
            int i7 = i6;
            if (i7 < childCount) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    C8429i c8429i = layoutParams.akM;
                    C8429i c8429i2 = layoutParams.akL;
                    C8427f c8427f = c8429i.ajL;
                    C8427f c8427f2 = c8429i2.ajL;
                    int i8 = iz[c8427f.min];
                    int i9 = iz2[c8427f2.min];
                    int i10 = iz[c8427f.max] - i8;
                    int i11 = iz2[c8427f2.max] - i9;
                    int h = GridLayout.m14863h(childAt, true);
                    int h2 = GridLayout.m14863h(childAt, false);
                    C8426a ag = c8429i.mo18431ag(true);
                    C8426a ag2 = c8429i2.mo18431ag(false);
                    C8435e c8435e = (C8435e) this.ajq.mo18452it().mo18398bR(i7);
                    C8435e c8435e2 = (C8435e) this.ajr.mo18452it().mo18398bR(i7);
                    int w = ag.mo1706w(childAt, i10 - c8435e.mo18436ac(true));
                    int w2 = ag2.mo1706w(childAt, i11 - c8435e2.mo18436ac(true));
                    int b = m14857b(childAt, true, true);
                    int b2 = m14857b(childAt, false, true);
                    int b3 = m14857b(childAt, true, false);
                    int i12 = b + b3;
                    int b4 = b2 + m14857b(childAt, false, false);
                    i6 = c8435e.mo18435a(this, childAt, ag, h + i12, true);
                    paddingBottom = c8435e2.mo18435a(this, childAt, ag2, h2 + b4, false);
                    int W = ag.mo18422W(h, i10 - i12);
                    int W2 = ag2.mo18422W(h2, i11 - b4);
                    i6 += i8 + w;
                    i6 = !m14864ih() ? i6 + (paddingLeft + b) : (((i5 - W) - paddingRight) - b3) - i6;
                    paddingBottom = (paddingBottom + ((paddingTop + i9) + w2)) + b2;
                    if (!(W == childAt.getMeasuredWidth() && W2 == childAt.getMeasuredHeight())) {
                        childAt.measure(MeasureSpec.makeMeasureSpec(W, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(W2, ErrorDialogData.SUPPRESSED));
                    }
                    childAt.layout(i6, paddingBottom, W + i6, W2 + paddingBottom);
                }
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static C8429i m14853a(int i, int i2, C8426a c8426a, float f) {
        return new C8429i(i != C8415j.INVALID_ID, i, i2, c8426a, f);
    }

    /* renamed from: im */
    public static C8429i m14869im() {
        return GridLayout.m14853a(C8415j.INVALID_ID, 1, ajw, 0.0f);
    }

    /* renamed from: a */
    private static C8426a m14852a(final C8426a c8426a, final C8426a c8426a2) {
        return new C8426a() {
            /* Access modifiers changed, original: final */
            /* renamed from: w */
            public final int mo1706w(View view, int i) {
                Object obj = 1;
                if (C0477s.m893T(view) != 1) {
                    obj = null;
                }
                return (obj == null ? c8426a : c8426a2).mo1706w(view, i);
            }

            /* renamed from: k */
            public final int mo1705k(View view, int i, int i2) {
                Object obj = 1;
                if (C0477s.m893T(view) != 1) {
                    obj = null;
                }
                return (obj == null ? c8426a : c8426a2).mo1705k(view, i, i2);
            }

            /* Access modifiers changed, original: final */
            /* renamed from: in */
            public final String mo1704in() {
                return "SWITCHING[L:" + c8426a.mo1704in() + ", R:" + c8426a2.mo1704in() + "]";
            }
        };
    }

    /* renamed from: bN */
    static boolean m14858bN(int i) {
        return (i & 2) != 0;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
