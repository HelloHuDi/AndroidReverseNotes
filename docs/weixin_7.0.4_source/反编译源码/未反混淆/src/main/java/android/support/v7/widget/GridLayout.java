package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.s;
import android.support.v4.view.u;
import android.support.v4.widget.Space;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GridLayout extends ViewGroup {
    public static final a ajA = ajy;
    public static final a ajB = ajx;
    public static final a ajC = ajy;
    public static final a ajD = a(ajB, ajC);
    public static final a ajE = a(ajC, ajB);
    public static final a ajF = new a() {
        /* Access modifiers changed, original: final */
        public final int w(View view, int i) {
            return i >> 1;
        }

        public final int k(View view, int i, int i2) {
            return i >> 1;
        }

        /* Access modifiers changed, original: final */
        public final String in() {
            return "CENTER";
        }
    };
    public static final a ajG = new a() {
        /* Access modifiers changed, original: final */
        public final int w(View view, int i) {
            return 0;
        }

        public final int k(View view, int i, int i2) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            return baseline == -1 ? j.INVALID_ID : baseline;
        }

        public final e io() {
            return new e() {
                private int size;

                /* Access modifiers changed, original: protected|final */
                public final void reset() {
                    super.reset();
                    this.size = j.INVALID_ID;
                }

                /* Access modifiers changed, original: protected|final */
                public final void V(int i, int i2) {
                    super.V(i, i2);
                    this.size = Math.max(this.size, i + i2);
                }

                /* Access modifiers changed, original: protected|final */
                public final int ac(boolean z) {
                    return Math.max(super.ac(z), this.size);
                }

                /* Access modifiers changed, original: protected|final */
                public final int a(GridLayout gridLayout, View view, a aVar, int i, boolean z) {
                    return Math.max(0, super.a(gridLayout, view, aVar, i, z));
                }
            };
        }

        /* Access modifiers changed, original: final */
        public final String in() {
            return "BASELINE";
        }
    };
    public static final a ajH = new a() {
        /* Access modifiers changed, original: final */
        public final int w(View view, int i) {
            return 0;
        }

        public final int k(View view, int i, int i2) {
            return j.INVALID_ID;
        }

        public final int W(int i, int i2) {
            return i2;
        }

        /* Access modifiers changed, original: final */
        public final String in() {
            return "FILL";
        }
    };
    static final Printer ajh = new LogPrinter(3, GridLayout.class.getName());
    static final Printer aji = new Printer() {
        public final void println(String str) {
        }
    };
    private static final int ajj = 0;
    private static final int ajk = 1;
    private static final int ajl = 2;
    private static final int ajm = 3;
    private static final int ajn = 4;
    private static final int ajo = 5;
    private static final int ajp = 6;
    static final a ajw = new a() {
        /* Access modifiers changed, original: final */
        public final int w(View view, int i) {
            return j.INVALID_ID;
        }

        public final int k(View view, int i, int i2) {
            return j.INVALID_ID;
        }

        /* Access modifiers changed, original: final */
        public final String in() {
            return "UNDEFINED";
        }
    };
    private static final a ajx = new a() {
        /* Access modifiers changed, original: final */
        public final int w(View view, int i) {
            return 0;
        }

        public final int k(View view, int i, int i2) {
            return 0;
        }

        /* Access modifiers changed, original: final */
        public final String in() {
            return "LEADING";
        }
    };
    private static final a ajy = new a() {
        /* Access modifiers changed, original: final */
        public final int w(View view, int i) {
            return i;
        }

        public final int k(View view, int i, int i2) {
            return i;
        }

        /* Access modifiers changed, original: final */
        public final String in() {
            return "TRAILING";
        }
    };
    public static final a ajz = ajx;
    final d ajq;
    final d ajr;
    boolean ajs;
    int ajt;
    int aju;
    int ajv;
    int mOrientation;
    Printer mPrinter;

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
        private static final f akx;
        private static final int aky;
        private static final int akz = 2;
        public i akL;
        public i akM;

        static {
            f fVar = new f(j.INVALID_ID, -2147483647);
            akx = fVar;
            aky = fVar.size();
        }

        private LayoutParams(i iVar, i iVar2) {
            super(-2, -2);
            this.akL = i.akQ;
            this.akM = i.akQ;
            setMargins(j.INVALID_ID, j.INVALID_ID, j.INVALID_ID, j.INVALID_ID);
            this.akL = iVar;
            this.akM = iVar2;
        }

        private LayoutParams(i iVar, i iVar2, byte b) {
            this(iVar, iVar2);
        }

        public LayoutParams() {
            i iVar = i.akQ;
            this(iVar, iVar, (byte) 0);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.akL = i.akQ;
            this.akM = i.akQ;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.akL = i.akQ;
            this.akM = i.akQ;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.akL = i.akQ;
            this.akM = i.akQ;
            this.akL = layoutParams.akL;
            this.akM = layoutParams.akM;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.akL = i.akQ;
            this.akM = i.akQ;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.e.a.a.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(akz, j.INVALID_ID);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(akA, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(akB, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(akC, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(akD, dimensionPixelSize);
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.e.a.a.GridLayout_Layout);
                try {
                    dimensionPixelSize = obtainStyledAttributes.getInt(akK, 0);
                    this.akM = GridLayout.a(obtainStyledAttributes.getInt(akE, j.INVALID_ID), obtainStyledAttributes.getInt(akF, aky), GridLayout.n(dimensionPixelSize, true), obtainStyledAttributes.getFloat(akG, 0.0f));
                    this.akL = GridLayout.a(obtainStyledAttributes.getInt(akH, j.INVALID_ID), obtainStyledAttributes.getInt(akI, aky), GridLayout.n(dimensionPixelSize, false), obtainStyledAttributes.getFloat(akJ, 0.0f));
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

    static final class h<K, V> {
        public final int[] akN;
        public final K[] akO;
        public final V[] akP;

        h(K[] kArr, V[] vArr) {
            this.akN = c(kArr);
            this.akO = a(kArr, this.akN);
            this.akP = a(vArr, this.akN);
        }

        public final V bR(int i) {
            return this.akP[this.akN[i]];
        }

        private static <K> int[] c(K[] kArr) {
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

        private static <K> K[] a(K[] kArr, int[] iArr) {
            int length = kArr.length;
            Object[] objArr = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.g(iArr) + 1);
            for (int i = 0; i < length; i++) {
                objArr[iArr[i]] = kArr[i];
            }
            return objArr;
        }
    }

    public static abstract class a {
        public abstract String in();

        public abstract int k(View view, int i, int i2);

        public abstract int w(View view, int i);

        a() {
        }

        /* Access modifiers changed, original: 0000 */
        public int W(int i, int i2) {
            return i;
        }

        /* Access modifiers changed, original: 0000 */
        public e io() {
            return new e();
        }

        public String toString() {
            return "Alignment:" + in();
        }
    }

    static final class f {
        public final int max;
        public final int min;

        public f(int i, int i2) {
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
            f fVar = (f) obj;
            if (this.max != fVar.max) {
                return false;
            }
            if (this.min != fVar.min) {
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

    static final class g {
        public int value;

        public g() {
            this.value = j.INVALID_ID;
        }

        public g(int i) {
            this.value = i;
        }

        public final String toString() {
            return Integer.toString(this.value);
        }
    }

    public static class i {
        static final i akQ = GridLayout.im();
        final f ajL;
        final boolean akR;
        final a akS;
        final float weight;

        private i(boolean z, f fVar, a aVar, float f) {
            this.akR = z;
            this.ajL = fVar;
            this.akS = aVar;
            this.weight = f;
        }

        i(boolean z, int i, int i2, a aVar, float f) {
            this(z, new f(i, i + i2), aVar, f);
        }

        public final a ag(boolean z) {
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
        public final i a(f fVar) {
            return new i(this.akR, fVar, this.akS, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            i iVar = (i) obj;
            if (!this.akS.equals(iVar.akS)) {
                return false;
            }
            if (this.ajL.equals(iVar.ajL)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.ajL.hashCode() * 31) + this.akS.hashCode();
        }
    }

    static final class c<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> ajO;
        private final Class<V> ajP;

        private c(Class<K> cls, Class<V> cls2) {
            this.ajO = cls;
            this.ajP = cls2;
        }

        public static <K, V> c<K, V> a(Class<K> cls, Class<V> cls2) {
            return new c(cls, cls2);
        }

        public final void f(K k, V v) {
            add(Pair.create(k, v));
        }

        public final h<K, V> ip() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.ajO, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.ajP, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = ((Pair) get(i)).first;
                objArr2[i] = ((Pair) get(i)).second;
            }
            return new h(objArr, objArr2);
        }
    }

    static class e {
        public int aku;
        public int akv;
        public int akw;

        e() {
            reset();
        }

        /* Access modifiers changed, original: protected */
        public void reset() {
            this.aku = j.INVALID_ID;
            this.akv = j.INVALID_ID;
            this.akw = 2;
        }

        /* Access modifiers changed, original: protected */
        public void V(int i, int i2) {
            this.aku = Math.max(this.aku, i);
            this.akv = Math.max(this.akv, i2);
        }

        /* Access modifiers changed, original: protected */
        public int ac(boolean z) {
            if (z || !GridLayout.bN(this.akw)) {
                return this.aku + this.akv;
            }
            return 100000;
        }

        /* Access modifiers changed, original: protected */
        public int a(GridLayout gridLayout, View view, a aVar, int i, boolean z) {
            return this.aku - aVar.k(view, i, u.d(gridLayout));
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(GridLayout gridLayout, View view, i iVar, d dVar, int i) {
            int i2;
            int i3 = this.akw;
            if (iVar.akS == GridLayout.ajw && iVar.weight == 0.0f) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            this.akw = i2 & i3;
            i2 = iVar.ag(dVar.ajQ).k(view, i, u.d(gridLayout));
            V(i2, i - i2);
        }

        public String toString() {
            return "Bounds{before=" + this.aku + ", after=" + this.akv + '}';
        }
    }

    static final class b {
        public final f ajL;
        public final g ajM;
        public boolean ajN = true;

        public b(f fVar, g gVar) {
            this.ajL = fVar;
            this.ajM = gVar;
        }

        public final String toString() {
            return this.ajL + " " + (!this.ajN ? "+>" : "->") + " " + this.ajM;
        }
    }

    final class d {
        static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
        public final boolean ajQ;
        public int ajR = j.INVALID_ID;
        private int ajS = j.INVALID_ID;
        h<i, e> ajT;
        public boolean ajU = false;
        h<f, g> ajV;
        public boolean ajW = false;
        h<f, g> ajX;
        public boolean ajY = false;
        public int[] ajZ;
        public boolean aka = false;
        public int[] akb;
        public boolean akc = false;
        public b[] akd;
        public boolean ake = false;
        public int[] akf;
        public boolean akg = false;
        public boolean akh;
        public boolean aki = false;
        public int[] akj;
        boolean akk = true;
        private g akl = new g(0);
        private g akm = new g(-100000);

        d(boolean z) {
            this.ajQ = z;
        }

        private int iq() {
            if (this.ajS == j.INVALID_ID) {
                int childCount = GridLayout.this.getChildCount();
                int i = -1;
                for (int i2 = 0; i2 < childCount; i2++) {
                    LayoutParams bc = GridLayout.bc(GridLayout.this.getChildAt(i2));
                    f fVar = (this.ajQ ? bc.akM : bc.akL).ajL;
                    i = Math.max(Math.max(Math.max(i, fVar.min), fVar.max), fVar.size());
                }
                this.ajS = Math.max(0, i == -1 ? j.INVALID_ID : i);
            }
            return this.ajS;
        }

        public final int getCount() {
            return Math.max(this.ajR, iq());
        }

        public final void setCount(int i) {
            if (i != j.INVALID_ID && i < iq()) {
                GridLayout.S((this.ajQ ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
            }
            this.ajR = i;
        }

        public final void ad(boolean z) {
            this.akk = z;
            ii();
        }

        private h<i, e> ir() {
            c a = c.a(i.class, e.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams bc = GridLayout.bc(GridLayout.this.getChildAt(i));
                i iVar = this.ajQ ? bc.akM : bc.akL;
                a.f(iVar, iVar.ag(this.ajQ).io());
            }
            return a.ip();
        }

        private void is() {
            int i;
            e[] eVarArr = (e[]) this.ajT.akP;
            for (e reset : eVarArr) {
                reset.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                int i3;
                View childAt = GridLayout.this.getChildAt(i2);
                LayoutParams bc = GridLayout.bc(childAt);
                i iVar = this.ajQ ? bc.akM : bc.akL;
                GridLayout gridLayout = GridLayout.this;
                boolean z = this.ajQ;
                if (childAt.getVisibility() == 8) {
                    i3 = 0;
                } else {
                    i3 = gridLayout.g(childAt, z) + GridLayout.h(childAt, z);
                }
                if (iVar.weight == 0.0f) {
                    i = 0;
                } else {
                    i = iy()[i2];
                }
                ((e) this.ajT.bR(i2)).a(GridLayout.this, childAt, iVar, this, i3 + i);
            }
        }

        public final h<i, e> it() {
            if (this.ajT == null) {
                this.ajT = ir();
            }
            if (!this.ajU) {
                is();
                this.ajU = true;
            }
            return this.ajT;
        }

        private h<f, g> ae(boolean z) {
            c a = c.a(f.class, g.class);
            i[] iVarArr = (i[]) it().akO;
            int length = iVarArr.length;
            for (int i = 0; i < length; i++) {
                Object obj;
                if (z) {
                    obj = iVarArr[i].ajL;
                } else {
                    f fVar = iVarArr[i].ajL;
                    obj = new f(fVar.max, fVar.min);
                }
                a.f(obj, new g());
            }
            return a.ip();
        }

        private void a(h<f, g> hVar, boolean z) {
            int i = 0;
            g[] gVarArr = (g[]) hVar.akP;
            for (g gVar : gVarArr) {
                gVar.value = j.INVALID_ID;
            }
            e[] eVarArr = (e[]) it().akP;
            while (i < eVarArr.length) {
                int ac = eVarArr[i].ac(z);
                g gVar2 = (g) hVar.bR(i);
                int i2 = gVar2.value;
                if (!z) {
                    ac = -ac;
                }
                gVar2.value = Math.max(i2, ac);
                i++;
            }
        }

        private h<f, g> iu() {
            if (this.ajV == null) {
                this.ajV = ae(true);
            }
            if (!this.ajW) {
                a(this.ajV, true);
                this.ajW = true;
            }
            return this.ajV;
        }

        private h<f, g> iv() {
            if (this.ajX == null) {
                this.ajX = ae(false);
            }
            if (!this.ajY) {
                a(this.ajX, false);
                this.ajY = true;
            }
            return this.ajX;
        }

        private static void a(List<b> list, f fVar, g gVar, boolean z) {
            if (fVar.size() != 0) {
                if (z) {
                    for (b bVar : list) {
                        if (bVar.ajL.equals(fVar)) {
                            return;
                        }
                    }
                }
                list.add(new b(fVar, gVar));
            }
        }

        private static void a(List<b> list, f fVar, g gVar) {
            a(list, fVar, gVar, true);
        }

        /* Access modifiers changed, original: final */
        public final b[][] a(b[] bVarArr) {
            int i;
            int i2 = 0;
            int count = getCount() + 1;
            b[][] bVarArr2 = new b[count][];
            int[] iArr = new int[count];
            for (b bVar : bVarArr) {
                i = bVar.ajL.min;
                iArr[i] = iArr[i] + 1;
            }
            for (count = 0; count < iArr.length; count++) {
                bVarArr2[count] = new b[iArr[count]];
            }
            Arrays.fill(iArr, 0);
            count = bVarArr.length;
            while (i2 < count) {
                b bVar2 = bVarArr[i2];
                i = bVar2.ajL.min;
                b[] bVarArr3 = bVarArr2[i];
                int i3 = iArr[i];
                iArr[i] = i3 + 1;
                bVarArr3[i3] = bVar2;
                i2++;
            }
            return bVarArr2;
        }

        private b[] p(List<b> list) {
            final b[] bVarArr = (b[]) list.toArray(new b[list.size()]);
            AnonymousClass1 anonymousClass1 = new Object() {
                static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
                b[] ako = new b[bVarArr.length];
                int akp = (this.ako.length - 1);
                b[][] akq = d.this.a(bVarArr);
                int[] akr = new int[(d.this.getCount() + 1)];

                /* Access modifiers changed, original: final */
                public final void bQ(int i) {
                    switch (this.akr[i]) {
                        case 0:
                            this.akr[i] = 1;
                            for (b bVar : this.akq[i]) {
                                bQ(bVar.ajL.max);
                                b[] bVarArr = this.ako;
                                int i2 = this.akp;
                                this.akp = i2 - 1;
                                bVarArr[i2] = bVar;
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
            int length = anonymousClass1.akq.length;
            for (int i = 0; i < length; i++) {
                anonymousClass1.bQ(i);
            }
            if (AnonymousClass1.$assertionsDisabled || anonymousClass1.akp == -1) {
                return anonymousClass1.ako;
            }
            throw new AssertionError();
        }

        private static void a(List<b> list, h<f, g> hVar) {
            for (int i = 0; i < ((f[]) hVar.akO).length; i++) {
                a(list, ((f[]) hVar.akO)[i], ((g[]) hVar.akP)[i], false);
            }
        }

        private void iw() {
            iu();
            iv();
        }

        private b[] ix() {
            if (this.akd == null) {
                int i;
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                a(arrayList, iu());
                a(arrayList2, iv());
                if (this.akk) {
                    for (i = 0; i < getCount(); i++) {
                        a(arrayList, new f(i, i + 1), new g(0));
                    }
                }
                i = getCount();
                a(arrayList, new f(0, i), this.akl, false);
                a(arrayList2, new f(i, 0), this.akm, false);
                this.akd = (b[]) GridLayout.a(p(arrayList), p(arrayList2));
            }
            if (!this.ake) {
                iw();
                this.ake = true;
            }
            return this.akd;
        }

        private static boolean a(int[] iArr, b bVar) {
            if (!bVar.ajN) {
                return false;
            }
            f fVar = bVar.ajL;
            int i = fVar.min;
            int i2 = fVar.max;
            i = iArr[i] + bVar.ajM.value;
            if (i <= iArr[i2]) {
                return false;
            }
            iArr[i2] = i;
            return true;
        }

        private String q(List<b> list) {
            String str = this.ajQ ? VideoMaterialUtil.CRAZYFACE_X : VideoMaterialUtil.CRAZYFACE_Y;
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (b bVar : list) {
                String str2;
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder = stringBuilder.append(", ");
                }
                int i = bVar.ajL.min;
                int i2 = bVar.ajL.max;
                int i3 = bVar.ajM.value;
                if (i < i2) {
                    str2 = str + i2 + "-" + str + i + ">=" + i3;
                } else {
                    str2 = str + i + "-" + str + i2 + "<=" + (-i3);
                }
                stringBuilder.append(str2);
            }
            return stringBuilder.toString();
        }

        private boolean a(b[] bVarArr, int[] iArr, boolean z) {
            int i = 0;
            String str = this.ajQ ? MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                int i3;
                int i4;
                Arrays.fill(iArr, 0);
                for (i3 = 0; i3 < count; i3++) {
                    i4 = 0;
                    for (b a : bVarArr) {
                        i4 |= a(iArr, a);
                    }
                    if (i4 == 0) {
                        if (zArr != null) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            while (i < bVarArr.length) {
                                Object obj = bVarArr[i];
                                if (zArr[i]) {
                                    arrayList.add(obj);
                                }
                                if (!obj.ajN) {
                                    arrayList2.add(obj);
                                }
                                i++;
                            }
                            GridLayout.this.mPrinter.println(str + " constraints: " + q(arrayList) + " are inconsistent; permanently removing: " + q(arrayList2) + ". ");
                        }
                        return true;
                    }
                }
                if (!z) {
                    return false;
                }
                boolean[] zArr2 = new boolean[bVarArr.length];
                for (i3 = 0; i3 < count; i3++) {
                    int length = bVarArr.length;
                    for (i4 = 0; i4 < length; i4++) {
                        zArr2[i4] = zArr2[i4] | a(iArr, bVarArr[i4]);
                    }
                }
                if (i2 == 0) {
                    zArr = zArr2;
                }
                for (i4 = 0; i4 < bVarArr.length; i4++) {
                    if (zArr2[i4]) {
                        b bVar = bVarArr[i4];
                        if (bVar.ajL.min >= bVar.ajL.max) {
                            bVar.ajN = false;
                            break;
                        }
                    }
                }
            }
            return true;
        }

        /* Access modifiers changed, original: final */
        public final void af(boolean z) {
            int[] iArr = z ? this.ajZ : this.akb;
            int childCount = GridLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GridLayout.this.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams bc = GridLayout.bc(childAt);
                    f fVar = (this.ajQ ? bc.akM : bc.akL).ajL;
                    int i2 = z ? fVar.min : fVar.max;
                    iArr[i2] = Math.max(iArr[i2], GridLayout.this.a(childAt, this.ajQ, z));
                }
            }
        }

        private boolean h(int[] iArr) {
            return a(ix(), iArr, true);
        }

        private int[] iy() {
            if (this.akj == null) {
                this.akj = new int[GridLayout.this.getChildCount()];
            }
            return this.akj;
        }

        private void f(int i, float f) {
            Arrays.fill(this.akj, 0);
            int childCount = GridLayout.this.getChildCount();
            int i2 = 0;
            float f2 = f;
            int i3 = i;
            while (i2 < childCount) {
                float f3;
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams bc = GridLayout.bc(childAt);
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

        private void i(int[] iArr) {
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
                        bc = GridLayout.bc(childAt);
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
                Arrays.fill(iy(), 0);
                h(iArr);
                i = (this.akl.value * GridLayout.this.getChildCount()) + 1;
                if (i >= 2) {
                    int childCount2 = GridLayout.this.getChildCount();
                    childCount = 0;
                    while (childCount < childCount2) {
                        float f2;
                        childAt = GridLayout.this.getChildAt(childCount);
                        if (childAt.getVisibility() != 8) {
                            bc = GridLayout.bc(childAt);
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
                        ij();
                        f(i, f);
                        z = a(ix(), iArr, false);
                        if (z) {
                            childCount = i + 1;
                            i2 = i;
                        } else {
                            childCount2 = i;
                        }
                    }
                    if (i2 > 0 && !z) {
                        ij();
                        f(i2, f);
                        h(iArr);
                    }
                }
            } else {
                h(iArr);
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

        public final int[] iz() {
            if (this.akf == null) {
                this.akf = new int[(getCount() + 1)];
            }
            if (!this.akg) {
                i(this.akf);
                this.akg = true;
            }
            return this.akf;
        }

        private void X(int i, int i2) {
            this.akl.value = i;
            this.akm.value = -i2;
            this.akg = false;
        }

        private int Y(int i, int i2) {
            X(i, i2);
            return iz()[getCount()];
        }

        public final int bO(int i) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case j.INVALID_ID /*-2147483648*/:
                    return Y(0, size);
                case 0:
                    return Y(0, 100000);
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    return Y(size, size);
                default:
                    if ($assertionsDisabled) {
                        return 0;
                    }
                    throw new AssertionError();
            }
        }

        public final void bP(int i) {
            X(i, i);
            iz();
        }

        public final void ii() {
            this.ajS = j.INVALID_ID;
            this.ajT = null;
            this.ajV = null;
            this.ajX = null;
            this.ajZ = null;
            this.akb = null;
            this.akd = null;
            this.akf = null;
            this.akj = null;
            this.aki = false;
            ij();
        }

        public final void ij() {
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
        this.ajq = new d(true);
        this.ajr = new d(false);
        this.mOrientation = 0;
        this.ajs = false;
        this.ajt = 1;
        this.ajv = 0;
        this.mPrinter = ajh;
        this.aju = context.getResources().getDimensionPixelOffset(R.dimen.yb);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.e.a.a.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(ajk, j.INVALID_ID));
            setColumnCount(obtainStyledAttributes.getInt(ajl, j.INVALID_ID));
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
            ii();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.ajr.getCount();
    }

    public void setRowCount(int i) {
        this.ajr.setCount(i);
        ii();
        requestLayout();
    }

    public int getColumnCount() {
        return this.ajq.getCount();
    }

    public void setColumnCount(int i) {
        this.ajq.setCount(i);
        ii();
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
        this.ajr.ad(z);
        ii();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.ajq.ad(z);
        ii();
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

    static int g(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    static <T> T[] a(T[] tArr, T[] tArr2) {
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        System.arraycopy(tArr2, 0, objArr, tArr.length, tArr2.length);
        return objArr;
    }

    static a n(int i, boolean z) {
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
    public final int a(View view, boolean z, boolean z2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i = z ? z2 ? layoutParams.leftMargin : layoutParams.rightMargin : z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        if (i != j.INVALID_ID) {
            return i;
        }
        if (!this.ajs) {
            return 0;
        }
        i iVar = z ? layoutParams.akM : layoutParams.akL;
        d dVar = z ? this.ajq : this.ajr;
        f fVar = iVar.ajL;
        if (z && ih()) {
            if (z2) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            dVar.getCount();
        } else if (fVar.min != 0) {
        }
        if (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) {
            return 0;
        }
        return this.aju / 2;
    }

    private boolean ih() {
        return s.T(this) == 1;
    }

    private int b(View view, boolean z, boolean z2) {
        if (this.ajt == 1) {
            return a(view, z, z2);
        }
        int[] iArr;
        d dVar = z ? this.ajq : this.ajr;
        if (z2) {
            if (dVar.ajZ == null) {
                dVar.ajZ = new int[(dVar.getCount() + 1)];
            }
            if (!dVar.aka) {
                dVar.af(true);
                dVar.aka = true;
            }
            iArr = dVar.ajZ;
        } else {
            if (dVar.akb == null) {
                dVar.akb = new int[(dVar.getCount() + 1)];
            }
            if (!dVar.akc) {
                dVar.af(false);
                dVar.akc = true;
            }
            iArr = dVar.akb;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i iVar = z ? layoutParams.akM : layoutParams.akL;
        return iArr[z2 ? iVar.ajL.min : iVar.ajL.max];
    }

    /* Access modifiers changed, original: final */
    public final int g(View view, boolean z) {
        return b(view, z, true) + b(view, z, false);
    }

    private static void a(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.akL = layoutParams.akL.a(new f(i, i + i2));
        layoutParams.akM = layoutParams.akM.a(new f(i3, i3 + i4));
    }

    private void ii() {
        this.ajv = 0;
        if (this.ajq != null) {
            this.ajq.ii();
        }
        if (this.ajr != null) {
            this.ajr.ii();
        }
        ij();
    }

    private void ij() {
        if (this.ajq != null && this.ajr != null) {
            this.ajq.ij();
            this.ajr.ij();
        }
    }

    static LayoutParams bc(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    static void S(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void a(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        f fVar = (z ? layoutParams.akM : layoutParams.akL).ajL;
        if (fVar.min != j.INVALID_ID && fVar.min < 0) {
            S(str + " indices must be positive");
        }
        int i = (z ? this.ajq : this.ajr).ajR;
        if (i != j.INVALID_ID) {
            if (fVar.max > i) {
                S(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (fVar.size() > i) {
                S(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        a(layoutParams2, true);
        a(layoutParams2, false);
        return true;
    }

    private int ik() {
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

    private void il() {
        while (this.ajv != 0) {
            if (this.ajv != ik()) {
                this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
                ii();
            } else {
                return;
            }
        }
        Object obj = this.mOrientation == 0 ? 1 : null;
        d dVar = obj != null ? this.ajq : this.ajr;
        int i = dVar.ajR != j.INVALID_ID ? dVar.ajR : 0;
        int i2 = 0;
        int i3 = 0;
        int[] iArr = new int[i];
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            i iVar = obj != null ? layoutParams.akL : layoutParams.akM;
            f fVar = iVar.ajL;
            boolean z = iVar.akR;
            int size = fVar.size();
            if (z) {
                i2 = fVar.min;
            }
            iVar = obj != null ? layoutParams.akM : layoutParams.akL;
            f fVar2 = iVar.ajL;
            boolean z2 = iVar.akR;
            int size2 = fVar2.size();
            if (i != 0) {
                size2 = Math.min(size2, i - (z2 ? Math.min(fVar2.min, i) : 0));
            }
            if (z2) {
                i5 = fVar2.min;
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
                a(layoutParams, i2, size, i5, size2);
            } else {
                a(layoutParams, i5, size2, i2, size);
            }
            i3 = i5 + size2;
        }
        this.ajv = ik();
    }

    private void g(View view, int i, int i2, int i3, int i4) {
        view.measure(getChildMeasureSpec(i, g(view, true), i3), getChildMeasureSpec(i2, g(view, false), i4));
    }

    private void d(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    g(childAt, i, i2, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0;
                    i iVar = z2 ? layoutParams.akM : layoutParams.akL;
                    if (iVar.ag(z2) == ajH) {
                        f fVar = iVar.ajL;
                        int[] iz = (z2 ? this.ajq : this.ajr).iz();
                        int g = (iz[fVar.max] - iz[fVar.min]) - g(childAt, z2);
                        if (z2) {
                            g(childAt, i, i2, g, layoutParams.height);
                        } else {
                            g(childAt, i, i2, layoutParams.width, g);
                        }
                    }
                }
            }
        }
    }

    private static int U(int i, int i2) {
        return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i + i2), MeasureSpec.getMode(i));
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int bO;
        int bO2;
        il();
        ij();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int U = U(i, -paddingLeft);
        int U2 = U(i2, -paddingTop);
        d(U, U2, true);
        if (this.mOrientation == 0) {
            bO = this.ajq.bO(U);
            d(U, U2, false);
            bO2 = this.ajr.bO(U2);
        } else {
            bO2 = this.ajr.bO(U2);
            d(U, U2, false);
            bO = this.ajq.bO(U);
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(bO + paddingLeft, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(Math.max(bO2 + paddingTop, getSuggestedMinimumHeight()), i2, 0));
    }

    static int h(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public void requestLayout() {
        super.requestLayout();
        ii();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        il();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.ajq.bP((i5 - paddingLeft) - paddingRight);
        this.ajr.bP((i6 - paddingTop) - paddingBottom);
        int[] iz = this.ajq.iz();
        int[] iz2 = this.ajr.iz();
        i6 = 0;
        int childCount = getChildCount();
        while (true) {
            int i7 = i6;
            if (i7 < childCount) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    i iVar = layoutParams.akM;
                    i iVar2 = layoutParams.akL;
                    f fVar = iVar.ajL;
                    f fVar2 = iVar2.ajL;
                    int i8 = iz[fVar.min];
                    int i9 = iz2[fVar2.min];
                    int i10 = iz[fVar.max] - i8;
                    int i11 = iz2[fVar2.max] - i9;
                    int h = h(childAt, true);
                    int h2 = h(childAt, false);
                    a ag = iVar.ag(true);
                    a ag2 = iVar2.ag(false);
                    e eVar = (e) this.ajq.it().bR(i7);
                    e eVar2 = (e) this.ajr.it().bR(i7);
                    int w = ag.w(childAt, i10 - eVar.ac(true));
                    int w2 = ag2.w(childAt, i11 - eVar2.ac(true));
                    int b = b(childAt, true, true);
                    int b2 = b(childAt, false, true);
                    int b3 = b(childAt, true, false);
                    int i12 = b + b3;
                    int b4 = b2 + b(childAt, false, false);
                    i6 = eVar.a(this, childAt, ag, h + i12, true);
                    paddingBottom = eVar2.a(this, childAt, ag2, h2 + b4, false);
                    int W = ag.W(h, i10 - i12);
                    int W2 = ag2.W(h2, i11 - b4);
                    i6 += i8 + w;
                    i6 = !ih() ? i6 + (paddingLeft + b) : (((i5 - W) - paddingRight) - b3) - i6;
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

    public static i a(int i, int i2, a aVar, float f) {
        return new i(i != j.INVALID_ID, i, i2, aVar, f);
    }

    public static i im() {
        return a(j.INVALID_ID, 1, ajw, 0.0f);
    }

    private static a a(final a aVar, final a aVar2) {
        return new a() {
            /* Access modifiers changed, original: final */
            public final int w(View view, int i) {
                Object obj = 1;
                if (s.T(view) != 1) {
                    obj = null;
                }
                return (obj == null ? aVar : aVar2).w(view, i);
            }

            public final int k(View view, int i, int i2) {
                Object obj = 1;
                if (s.T(view) != 1) {
                    obj = null;
                }
                return (obj == null ? aVar : aVar2).k(view, i, i2);
            }

            /* Access modifiers changed, original: final */
            public final String in() {
                return "SWITCHING[L:" + aVar.in() + ", R:" + aVar2.in() + "]";
            }
        };
    }

    static boolean bN(int i) {
        return (i & 2) != 0;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
