package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.f.f;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    private static ThreadLocal<android.support.v4.f.a<Animator, a>> Ac = new ThreadLocal();
    private static final int[] zH = new int[]{2, 1, 3, 4};
    private static final PathMotion zI = new PathMotion() {
        public final Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private ArrayList<ah> Aa;
    private ArrayList<ah> Ab;
    boolean Ad = false;
    private ArrayList<Animator> Ae = new ArrayList();
    private int Af = 0;
    private boolean Ag = false;
    af Ah;
    private b Ai;
    private android.support.v4.f.a<String, String> Aj;
    PathMotion Ak = zI;
    long mDuration = -1;
    private ArrayList<c> mListeners = null;
    private String mName = getClass().getName();
    private boolean mPaused = false;
    private ArrayList<Animator> uC = new ArrayList();
    long zJ = -1;
    private TimeInterpolator zK = null;
    ArrayList<Integer> zL = new ArrayList();
    ArrayList<View> zM = new ArrayList();
    ArrayList<String> zN = null;
    ArrayList<Class> zO = null;
    private ArrayList<Integer> zP = null;
    private ArrayList<View> zQ = null;
    private ArrayList<Class> zR = null;
    private ArrayList<String> zS = null;
    private ArrayList<Integer> zT = null;
    private ArrayList<View> zU = null;
    private ArrayList<Class> zV = null;
    private ai zW = new ai();
    private ai zX = new ai();
    TransitionSet zY = null;
    private int[] zZ = zH;
    private ViewGroup zk = null;

    public static abstract class b {
        public abstract Rect cS();
    }

    public interface c {
        void a(Transition transition);

        void cO();

        void cP();

        void cT();
    }

    static class a {
        ah An;
        be Ao;
        Transition Ap;
        String mName;
        View mView;

        a(View view, String str, Transition transition, be beVar, ah ahVar) {
            this.mView = view;
            this.mName = str;
            this.An = ahVar;
            this.Ao = beVar;
            this.Ap = transition;
        }
    }

    public abstract void a(ah ahVar);

    public abstract void b(ah ahVar);

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zy);
        XmlPullParser xmlPullParser = (XmlResourceParser) attributeSet;
        long a = (long) android.support.v4.content.a.c.a(obtainStyledAttributes, xmlPullParser, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1, -1);
        if (a >= 0) {
            g(a);
        }
        a = (long) android.support.v4.content.a.c.a(obtainStyledAttributes, xmlPullParser, "startDelay", 2, -1);
        if (a > 0) {
            h(a);
        }
        int a2 = android.support.v4.content.a.c.a(obtainStyledAttributes, xmlPullParser, "interpolator", 0);
        if (a2 > 0) {
            a(AnimationUtils.loadInterpolator(context, a2));
        }
        String b = android.support.v4.content.a.c.b(obtainStyledAttributes, xmlPullParser, "matchOrder", 3);
        if (b != null) {
            setMatchOrder(G(b));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] G(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Object obj = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                obj[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                obj[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                obj[i] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                obj[i] = 4;
            } else if (trim.isEmpty()) {
                Object obj2 = new int[(obj.length - 1)];
                System.arraycopy(obj, 0, obj2, 0, i);
                i--;
                obj = obj2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return obj;
    }

    public Transition g(long j) {
        this.mDuration = j;
        return this;
    }

    public Transition h(long j) {
        this.zJ = j;
        return this;
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.zK = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        return null;
    }

    private void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.zZ = zH;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            Object obj;
            int i2 = iArr[i];
            if (i2 <= 0 || i2 > 4) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (b(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            } else {
                i++;
            }
        }
        this.zZ = (int[]) iArr.clone();
    }

    private static boolean b(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void a(ai aiVar, ai aiVar2) {
        android.support.v4.f.a aVar = new android.support.v4.f.a(aiVar.AE);
        android.support.v4.f.a aVar2 = new android.support.v4.f.a(aiVar2.AE);
        int i = 0;
        while (true) {
            int i2 = i;
            ah ahVar;
            if (i2 < this.zZ.length) {
                View view;
                int size;
                int i3;
                View view2;
                ah ahVar2;
                ah ahVar3;
                switch (this.zZ[i2]) {
                    case 1:
                        for (int size2 = aVar.size() - 1; size2 >= 0; size2--) {
                            view = (View) aVar.keyAt(size2);
                            if (view != null && C(view)) {
                                ahVar = (ah) aVar2.remove(view);
                                if (!(ahVar == null || ahVar.view == null || !C(ahVar.view))) {
                                    this.Aa.add((ah) aVar.removeAt(size2));
                                    this.Ab.add(ahVar);
                                }
                            }
                        }
                        break;
                    case 2:
                        android.support.v4.f.a aVar3 = aiVar.AH;
                        android.support.v4.f.a aVar4 = aiVar2.AH;
                        size = aVar3.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) aVar3.valueAt(i3);
                            if (view != null && C(view)) {
                                view2 = (View) aVar4.get(aVar3.keyAt(i3));
                                if (view2 != null && C(view2)) {
                                    ahVar2 = (ah) aVar.get(view);
                                    ahVar3 = (ah) aVar2.get(view2);
                                    if (!(ahVar2 == null || ahVar3 == null)) {
                                        this.Aa.add(ahVar2);
                                        this.Ab.add(ahVar3);
                                        aVar.remove(view);
                                        aVar2.remove(view2);
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        SparseArray sparseArray = aiVar.AF;
                        SparseArray sparseArray2 = aiVar2.AF;
                        size = sparseArray.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) sparseArray.valueAt(i3);
                            if (view != null && C(view)) {
                                view2 = (View) sparseArray2.get(sparseArray.keyAt(i3));
                                if (view2 != null && C(view2)) {
                                    ahVar2 = (ah) aVar.get(view);
                                    ahVar3 = (ah) aVar2.get(view2);
                                    if (!(ahVar2 == null || ahVar3 == null)) {
                                        this.Aa.add(ahVar2);
                                        this.Ab.add(ahVar3);
                                        aVar.remove(view);
                                        aVar2.remove(view2);
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        f fVar = aiVar.AG;
                        f fVar2 = aiVar2.AG;
                        size = fVar.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) fVar.valueAt(i3);
                            if (view != null && C(view)) {
                                view2 = (View) fVar2.k(fVar.keyAt(i3));
                                if (view2 != null && C(view2)) {
                                    ahVar2 = (ah) aVar.get(view);
                                    ahVar3 = (ah) aVar2.get(view2);
                                    if (!(ahVar2 == null || ahVar3 == null)) {
                                        this.Aa.add(ahVar2);
                                        this.Ab.add(ahVar3);
                                        aVar.remove(view);
                                        aVar2.remove(view2);
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        break;
                }
                i = i2 + 1;
            } else {
                i = 0;
                while (true) {
                    int i4 = i;
                    if (i4 < aVar.size()) {
                        ahVar = (ah) aVar.valueAt(i4);
                        if (C(ahVar.view)) {
                            this.Aa.add(ahVar);
                            this.Ab.add(null);
                        }
                        i = i4 + 1;
                    } else {
                        i = 0;
                        while (true) {
                            i4 = i;
                            if (i4 < aVar2.size()) {
                                ahVar = (ah) aVar2.valueAt(i4);
                                if (C(ahVar.view)) {
                                    this.Ab.add(ahVar);
                                    this.Aa.add(null);
                                }
                                i = i4 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(ViewGroup viewGroup, ai aiVar, ai aiVar2, ArrayList<ah> arrayList, ArrayList<ah> arrayList2) {
        int i;
        android.support.v4.f.a cW = cW();
        long j = Long.MAX_VALUE;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            ah ahVar;
            ah ahVar2;
            ah ahVar3 = (ah) arrayList.get(i3);
            ah ahVar4 = (ah) arrayList2.get(i3);
            if (ahVar3 == null || ahVar3.AD.contains(this)) {
                ahVar = ahVar3;
            } else {
                ahVar = null;
            }
            if (ahVar4 == null || ahVar4.AD.contains(this)) {
                ahVar2 = ahVar4;
            } else {
                ahVar2 = null;
            }
            if (ahVar != null || ahVar2 != null) {
                Object obj = (ahVar == null || ahVar2 == null || a(ahVar, ahVar2)) ? 1 : null;
                if (obj != null) {
                    Animator a = a(viewGroup, ahVar, ahVar2);
                    if (a != null) {
                        Object obj2;
                        ah ahVar5;
                        View view;
                        ahVar3 = null;
                        Animator obj22;
                        if (ahVar2 != null) {
                            View view2 = ahVar2.view;
                            String[] transitionProperties = getTransitionProperties();
                            if (!(view2 == null || transitionProperties == null || transitionProperties.length <= 0)) {
                                ah ahVar6 = new ah();
                                ahVar6.view = view2;
                                ahVar3 = (ah) aiVar2.AE.get(view2);
                                if (ahVar3 != null) {
                                    for (i = 0; i < transitionProperties.length; i++) {
                                        ahVar6.values.put(transitionProperties[i], ahVar3.values.get(transitionProperties[i]));
                                    }
                                }
                                int size2 = cW.size();
                                for (i = 0; i < size2; i++) {
                                    a aVar = (a) cW.get((Animator) cW.keyAt(i));
                                    if (aVar.An != null && aVar.mView == view2 && aVar.mName.equals(this.mName) && aVar.An.equals(ahVar6)) {
                                        obj22 = null;
                                        ahVar5 = ahVar6;
                                        view = view2;
                                        break;
                                    }
                                }
                                ahVar3 = ahVar6;
                            }
                            obj22 = a;
                            ahVar5 = ahVar3;
                            view = view2;
                        } else {
                            view = ahVar.view;
                            obj22 = a;
                            ahVar5 = null;
                        }
                        if (obj22 != null) {
                            if (this.Ah != null) {
                                long a2 = this.Ah.a(viewGroup, this, ahVar, ahVar2);
                                sparseIntArray.put(this.uC.size(), (int) a2);
                                j = Math.min(a2, j);
                            }
                            cW.put(obj22, new a(view, this.mName, this, au.K(viewGroup), ahVar5));
                            this.uC.add(obj22);
                        }
                    }
                }
            }
            i2 = i3 + 1;
        }
        if (j != 0) {
            i2 = 0;
            while (true) {
                i = i2;
                if (i < sparseIntArray.size()) {
                    Animator animator = (Animator) this.uC.get(sparseIntArray.keyAt(i));
                    animator.setStartDelay((((long) sparseIntArray.valueAt(i)) - j) + animator.getStartDelay());
                    i2 = i + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean C(View view) {
        int id = view.getId();
        if (this.zP != null && this.zP.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.zQ != null && this.zQ.contains(view)) {
            return false;
        }
        int i;
        if (this.zR != null) {
            int size = this.zR.size();
            for (i = 0; i < size; i++) {
                if (((Class) this.zR.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.zS != null && s.ai(view) != null && this.zS.contains(s.ai(view))) {
            return false;
        }
        if (this.zL.size() == 0 && this.zM.size() == 0 && ((this.zO == null || this.zO.isEmpty()) && (this.zN == null || this.zN.isEmpty()))) {
            return true;
        }
        if (this.zL.contains(Integer.valueOf(id)) || this.zM.contains(view)) {
            return true;
        }
        if (this.zN != null && this.zN.contains(s.ai(view))) {
            return true;
        }
        if (this.zO == null) {
            return false;
        }
        for (i = 0; i < this.zO.size(); i++) {
            if (((Class) this.zO.get(i)).isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    private static android.support.v4.f.a<Animator, a> cW() {
        android.support.v4.f.a<Animator, a> aVar = (android.support.v4.f.a) Ac.get();
        if (aVar != null) {
            return aVar;
        }
        android.support.v4.f.a aVar2 = new android.support.v4.f.a();
        Ac.set(aVar2);
        return aVar2;
    }

    /* Access modifiers changed, original: protected */
    public void cX() {
        start();
        final android.support.v4.f.a cW = cW();
        Iterator it = this.uC.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (cW.containsKey(animator)) {
                start();
                if (animator != null) {
                    animator.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationStart(Animator animator) {
                            Transition.this.Ae.add(animator);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            cW.remove(animator);
                            Transition.this.Ae.remove(animator);
                        }
                    });
                    if (animator == null) {
                        end();
                    } else {
                        if (this.mDuration >= 0) {
                            animator.setDuration(this.mDuration);
                        }
                        if (this.zJ >= 0) {
                            animator.setStartDelay(this.zJ);
                        }
                        if (this.zK != null) {
                            animator.setInterpolator(this.zK);
                        }
                        animator.addListener(new AnimatorListenerAdapter() {
                            public final void onAnimationEnd(Animator animator) {
                                Transition.this.end();
                                animator.removeListener(this);
                            }
                        });
                        animator.start();
                    }
                }
            }
        }
        this.uC.clear();
        end();
    }

    public Transition D(View view) {
        this.zM.add(view);
        return this;
    }

    public Transition E(View view) {
        this.zM.remove(view);
        return this;
    }

    /* Access modifiers changed, original: final */
    public final void b(ViewGroup viewGroup, boolean z) {
        int i;
        View findViewById;
        int i2 = 0;
        v(z);
        if ((this.zL.size() > 0 || this.zM.size() > 0) && ((this.zN == null || this.zN.isEmpty()) && (this.zO == null || this.zO.isEmpty()))) {
            ah ahVar;
            for (i = 0; i < this.zL.size(); i++) {
                findViewById = viewGroup.findViewById(((Integer) this.zL.get(i)).intValue());
                if (findViewById != null) {
                    ahVar = new ah();
                    ahVar.view = findViewById;
                    if (z) {
                        a(ahVar);
                    } else {
                        b(ahVar);
                    }
                    ahVar.AD.add(this);
                    d(ahVar);
                    if (z) {
                        a(this.zW, findViewById, ahVar);
                    } else {
                        a(this.zX, findViewById, ahVar);
                    }
                }
            }
            for (i = 0; i < this.zM.size(); i++) {
                findViewById = (View) this.zM.get(i);
                ahVar = new ah();
                ahVar.view = findViewById;
                if (z) {
                    a(ahVar);
                } else {
                    b(ahVar);
                }
                ahVar.AD.add(this);
                d(ahVar);
                if (z) {
                    a(this.zW, findViewById, ahVar);
                } else {
                    a(this.zX, findViewById, ahVar);
                }
            }
        } else {
            a((View) viewGroup, z);
        }
        if (!z && this.Aj != null) {
            int size = this.Aj.size();
            ArrayList arrayList = new ArrayList(size);
            for (i = 0; i < size; i++) {
                arrayList.add(this.zW.AH.remove((String) this.Aj.keyAt(i)));
            }
            while (i2 < size) {
                findViewById = (View) arrayList.get(i2);
                if (findViewById != null) {
                    this.zW.AH.put((String) this.Aj.valueAt(i2), findViewById);
                }
                i2++;
            }
        }
    }

    private static void a(ai aiVar, View view, ah ahVar) {
        aiVar.AE.put(view, ahVar);
        int id = view.getId();
        if (id >= 0) {
            if (aiVar.AF.indexOfKey(id) >= 0) {
                aiVar.AF.put(id, null);
            } else {
                aiVar.AF.put(id, view);
            }
        }
        String ai = s.ai(view);
        if (ai != null) {
            if (aiVar.AH.containsKey(ai)) {
                aiVar.AH.put(ai, null);
            } else {
                aiVar.AH.put(ai, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (aiVar.AG.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = (View) aiVar.AG.k(itemIdAtPosition);
                    if (view2 != null) {
                        s.d(view2, false);
                        aiVar.AG.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                s.d(view, true);
                aiVar.AG.put(itemIdAtPosition, view);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void v(boolean z) {
        if (z) {
            this.zW.AE.clear();
            this.zW.AF.clear();
            this.zW.AG.clear();
            return;
        }
        this.zX.AE.clear();
        this.zX.AF.clear();
        this.zX.AG.clear();
    }

    private void a(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.zP != null && this.zP.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.zQ == null || !this.zQ.contains(view)) {
                int i;
                if (this.zR != null) {
                    int size = this.zR.size();
                    i = 0;
                    while (i < size) {
                        if (!((Class) this.zR.get(i)).isInstance(view)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ah ahVar = new ah();
                    ahVar.view = view;
                    if (z) {
                        a(ahVar);
                    } else {
                        b(ahVar);
                    }
                    ahVar.AD.add(this);
                    d(ahVar);
                    if (z) {
                        a(this.zW, view, ahVar);
                    } else {
                        a(this.zX, view, ahVar);
                    }
                }
                if (!(view instanceof ViewGroup)) {
                    return;
                }
                if (this.zT != null && this.zT.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.zU == null || !this.zU.contains(view)) {
                    if (this.zV != null) {
                        id = this.zV.size();
                        i = 0;
                        while (i < id) {
                            if (!((Class) this.zV.get(i)).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        a(viewGroup.getChildAt(i2), z);
                    }
                }
            }
        }
    }

    public final ah b(View view, boolean z) {
        while (this.zY != null) {
            this = this.zY;
        }
        return (ah) (z ? this.zW : this.zX).AE.get(view);
    }

    /* Access modifiers changed, original: final */
    public final ah c(View view, boolean z) {
        while (this.zY != null) {
            this = this.zY;
        }
        ArrayList arrayList = z ? this.Aa : this.Ab;
        if (arrayList == null) {
            return null;
        }
        ah ahVar;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            ahVar = (ah) arrayList.get(i);
            if (ahVar == null) {
                return null;
            }
            if (ahVar.view == view) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            ahVar = (ah) (z ? this.Ab : this.Aa).get(i);
        } else {
            ahVar = null;
        }
        return ahVar;
    }

    public void F(View view) {
        if (!this.Ag) {
            android.support.v4.f.a cW = cW();
            int size = cW.size();
            be K = au.K(view);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = (a) cW.valueAt(i);
                if (aVar.mView != null && K.equals(aVar.Ao)) {
                    a.b((Animator) cW.keyAt(i));
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((c) arrayList.get(i2)).cO();
                }
            }
            this.mPaused = true;
        }
    }

    public void G(View view) {
        if (this.mPaused) {
            if (!this.Ag) {
                android.support.v4.f.a cW = cW();
                int size = cW.size();
                be K = au.K(view);
                for (int i = size - 1; i >= 0; i--) {
                    a aVar = (a) cW.valueAt(i);
                    if (aVar.mView != null && K.equals(aVar.Ao)) {
                        a.c((Animator) cW.keyAt(i));
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((c) arrayList.get(i2)).cP();
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(ViewGroup viewGroup) {
        this.Aa = new ArrayList();
        this.Ab = new ArrayList();
        a(this.zW, this.zX);
        android.support.v4.f.a cW = cW();
        int size = cW.size();
        be K = au.K(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) cW.keyAt(i);
            if (animator != null) {
                a aVar = (a) cW.get(animator);
                if (!(aVar == null || aVar.mView == null || !K.equals(aVar.Ao))) {
                    ah ahVar = aVar.An;
                    View view = aVar.mView;
                    ah b = b(view, true);
                    ah c = c(view, true);
                    boolean z = !(b == null && c == null) && aVar.Ap.a(ahVar, c);
                    if (z) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            cW.remove(animator);
                        }
                    }
                }
            }
        }
        a(viewGroup, this.zW, this.zX, this.Aa, this.Ab);
        cX();
    }

    public boolean a(ah ahVar, ah ahVar2) {
        if (!(ahVar == null || ahVar2 == null)) {
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String a : transitionProperties) {
                    if (a(ahVar, ahVar2, a)) {
                        return true;
                    }
                }
                return false;
            }
            for (String a2 : ahVar.values.keySet()) {
                if (a(ahVar, ahVar2, a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(ah ahVar, ah ahVar2, String str) {
        Object obj = ahVar.values.get(str);
        Object obj2 = ahVar2.values.get(str);
        if ((obj != null || obj2 != null) && (obj == null || obj2 == null || !obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void start() {
        if (this.Af == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList.get(i)).cT();
                }
            }
            this.Ag = false;
        }
        this.Af++;
    }

    /* Access modifiers changed, original: protected|final */
    public final void end() {
        this.Af--;
        if (this.Af == 0) {
            int i;
            View view;
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList.get(i2)).a(this);
                }
            }
            for (i = 0; i < this.zW.AG.size(); i++) {
                view = (View) this.zW.AG.valueAt(i);
                if (view != null) {
                    s.d(view, false);
                }
            }
            for (i = 0; i < this.zX.AG.size(); i++) {
                view = (View) this.zX.AG.valueAt(i);
                if (view != null) {
                    s.d(view, false);
                }
            }
            this.Ag = true;
        }
    }

    public Transition a(c cVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(cVar);
        return this;
    }

    public Transition b(c cVar) {
        if (this.mListeners != null) {
            this.mListeners.remove(cVar);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    public void a(b bVar) {
        this.Ai = bVar;
    }

    public final Rect getEpicenter() {
        if (this.Ai == null) {
            return null;
        }
        return this.Ai.cS();
    }

    public void a(af afVar) {
        this.Ah = afVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void d(ah ahVar) {
        Object obj = null;
        if (this.Ah != null && !ahVar.values.isEmpty()) {
            String[] propagationProperties = this.Ah.getPropagationProperties();
            if (propagationProperties != null) {
                for (Object containsKey : propagationProperties) {
                    if (!ahVar.values.containsKey(containsKey)) {
                        break;
                    }
                }
                int obj2 = 1;
                if (obj2 == null) {
                    this.Ah.c(ahVar);
                }
            }
        }
    }

    public String toString() {
        return toString("");
    }

    /* renamed from: cY */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.uC = new ArrayList();
            transition.zW = new ai();
            transition.zX = new ai();
            transition.Aa = null;
            transition.Ab = null;
            return transition;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String toString(String str) {
        int i = 0;
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.zJ != -1) {
            str2 = str2 + "dly(" + this.zJ + ") ";
        }
        if (this.zK != null) {
            str2 = str2 + "interp(" + this.zK + ") ";
        }
        if (this.zL.size() <= 0 && this.zM.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.zL.size() > 0) {
            for (int i2 = 0; i2 < this.zL.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.zL.get(i2);
            }
        }
        if (this.zM.size() > 0) {
            while (i < this.zM.size()) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.zM.get(i);
                i++;
            }
        }
        return str3 + ")";
    }
}
