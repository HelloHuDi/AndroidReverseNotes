package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.p065f.C0407f;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    /* renamed from: Ac */
    private static ThreadLocal<C6197a<Animator, C37101a>> f15695Ac = new ThreadLocal();
    /* renamed from: zH */
    private static final int[] f15696zH = new int[]{2, 1, 3, 4};
    /* renamed from: zI */
    private static final PathMotion f15697zI = new C253181();
    /* renamed from: Aa */
    private ArrayList<C8368ah> f15698Aa;
    /* renamed from: Ab */
    private ArrayList<C8368ah> f15699Ab;
    /* renamed from: Ad */
    boolean f15700Ad = false;
    /* renamed from: Ae */
    private ArrayList<Animator> f15701Ae = new ArrayList();
    /* renamed from: Af */
    private int f15702Af = 0;
    /* renamed from: Ag */
    private boolean f15703Ag = false;
    /* renamed from: Ah */
    C37104af f15704Ah;
    /* renamed from: Ai */
    private C31851b f15705Ai;
    /* renamed from: Aj */
    private C6197a<String, String> f15706Aj;
    /* renamed from: Ak */
    PathMotion f15707Ak = f15697zI;
    long mDuration = -1;
    private ArrayList<C31852c> mListeners = null;
    private String mName = getClass().getName();
    private boolean mPaused = false;
    /* renamed from: uC */
    private ArrayList<Animator> f15708uC = new ArrayList();
    /* renamed from: zJ */
    long f15709zJ = -1;
    /* renamed from: zK */
    private TimeInterpolator f15710zK = null;
    /* renamed from: zL */
    ArrayList<Integer> f15711zL = new ArrayList();
    /* renamed from: zM */
    ArrayList<View> f15712zM = new ArrayList();
    /* renamed from: zN */
    ArrayList<String> f15713zN = null;
    /* renamed from: zO */
    ArrayList<Class> f15714zO = null;
    /* renamed from: zP */
    private ArrayList<Integer> f15715zP = null;
    /* renamed from: zQ */
    private ArrayList<View> f15716zQ = null;
    /* renamed from: zR */
    private ArrayList<Class> f15717zR = null;
    /* renamed from: zS */
    private ArrayList<String> f15718zS = null;
    /* renamed from: zT */
    private ArrayList<Integer> f15719zT = null;
    /* renamed from: zU */
    private ArrayList<View> f15720zU = null;
    /* renamed from: zV */
    private ArrayList<Class> f15721zV = null;
    /* renamed from: zW */
    private C25322ai f15722zW = new C25322ai();
    /* renamed from: zX */
    private C25322ai f15723zX = new C25322ai();
    /* renamed from: zY */
    TransitionSet f15724zY = null;
    /* renamed from: zZ */
    private int[] f15725zZ = f15696zH;
    /* renamed from: zk */
    private ViewGroup f15726zk = null;

    /* renamed from: android.support.transition.Transition$3 */
    class C83663 extends AnimatorListenerAdapter {
        C83663() {
        }

        public final void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    /* renamed from: android.support.transition.Transition$1 */
    static class C253181 extends PathMotion {
        C253181() {
        }

        public final Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* renamed from: android.support.transition.Transition$b */
    public static abstract class C31851b {
        /* renamed from: cS */
        public abstract Rect mo18301cS();
    }

    /* renamed from: android.support.transition.Transition$c */
    public interface C31852c {
        /* renamed from: a */
        void mo452a(Transition transition);

        /* renamed from: cO */
        void mo18279cO();

        /* renamed from: cP */
        void mo18280cP();

        /* renamed from: cT */
        void mo31631cT();
    }

    /* renamed from: android.support.transition.Transition$a */
    static class C37101a {
        /* renamed from: An */
        C8368ah f15727An;
        /* renamed from: Ao */
        C8373be f15728Ao;
        /* renamed from: Ap */
        Transition f15729Ap;
        String mName;
        View mView;

        C37101a(View view, String str, Transition transition, C8373be c8373be, C8368ah c8368ah) {
            this.mView = view;
            this.mName = str;
            this.f15727An = c8368ah;
            this.f15728Ao = c8373be;
            this.f15729Ap = transition;
        }
    }

    /* renamed from: a */
    public abstract void mo410a(C8368ah c8368ah);

    /* renamed from: b */
    public abstract void mo411b(C8368ah c8368ah);

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15740zy);
        XmlPullParser xmlPullParser = (XmlResourceParser) attributeSet;
        long a = (long) C0379c.m637a(obtainStyledAttributes, xmlPullParser, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1, -1);
        if (a >= 0) {
            mo42284g(a);
        }
        a = (long) C0379c.m637a(obtainStyledAttributes, xmlPullParser, "startDelay", 2, -1);
        if (a > 0) {
            mo42285h(a);
        }
        int a2 = C0379c.m636a(obtainStyledAttributes, xmlPullParser, "interpolator", 0);
        if (a2 > 0) {
            mo42270a(AnimationUtils.loadInterpolator(context, a2));
        }
        String b = C0379c.m643b(obtainStyledAttributes, xmlPullParser, "matchOrder", 3);
        if (b != null) {
            setMatchOrder(m62067G(b));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: G */
    private static int[] m62067G(String str) {
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

    /* renamed from: g */
    public Transition mo42284g(long j) {
        this.mDuration = j;
        return this;
    }

    /* renamed from: h */
    public Transition mo42285h(long j) {
        this.f15709zJ = j;
        return this;
    }

    /* renamed from: a */
    public Transition mo42270a(TimeInterpolator timeInterpolator) {
        this.f15710zK = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    /* renamed from: a */
    public Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        return null;
    }

    private void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f15725zZ = f15696zH;
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
            } else if (m62072b(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            } else {
                i++;
            }
        }
        this.f15725zZ = (int[]) iArr.clone();
    }

    /* renamed from: b */
    private static boolean m62072b(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m62068a(C25322ai c25322ai, C25322ai c25322ai2) {
        C6197a c6197a = new C6197a(c25322ai.f5129AE);
        C6197a c6197a2 = new C6197a(c25322ai2.f5129AE);
        int i = 0;
        while (true) {
            int i2 = i;
            C8368ah c8368ah;
            if (i2 < this.f15725zZ.length) {
                View view;
                int size;
                int i3;
                View view2;
                C8368ah c8368ah2;
                C8368ah c8368ah3;
                switch (this.f15725zZ[i2]) {
                    case 1:
                        for (int size2 = c6197a.size() - 1; size2 >= 0; size2--) {
                            view = (View) c6197a.keyAt(size2);
                            if (view != null && mo59139C(view)) {
                                c8368ah = (C8368ah) c6197a2.remove(view);
                                if (!(c8368ah == null || c8368ah.view == null || !mo59139C(c8368ah.view))) {
                                    this.f15698Aa.add((C8368ah) c6197a.removeAt(size2));
                                    this.f15699Ab.add(c8368ah);
                                }
                            }
                        }
                        break;
                    case 2:
                        C6197a c6197a3 = c25322ai.f5132AH;
                        C6197a c6197a4 = c25322ai2.f5132AH;
                        size = c6197a3.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) c6197a3.valueAt(i3);
                            if (view != null && mo59139C(view)) {
                                view2 = (View) c6197a4.get(c6197a3.keyAt(i3));
                                if (view2 != null && mo59139C(view2)) {
                                    c8368ah2 = (C8368ah) c6197a.get(view);
                                    c8368ah3 = (C8368ah) c6197a2.get(view2);
                                    if (!(c8368ah2 == null || c8368ah3 == null)) {
                                        this.f15698Aa.add(c8368ah2);
                                        this.f15699Ab.add(c8368ah3);
                                        c6197a.remove(view);
                                        c6197a2.remove(view2);
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        SparseArray sparseArray = c25322ai.f5130AF;
                        SparseArray sparseArray2 = c25322ai2.f5130AF;
                        size = sparseArray.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) sparseArray.valueAt(i3);
                            if (view != null && mo59139C(view)) {
                                view2 = (View) sparseArray2.get(sparseArray.keyAt(i3));
                                if (view2 != null && mo59139C(view2)) {
                                    c8368ah2 = (C8368ah) c6197a.get(view);
                                    c8368ah3 = (C8368ah) c6197a2.get(view2);
                                    if (!(c8368ah2 == null || c8368ah3 == null)) {
                                        this.f15698Aa.add(c8368ah2);
                                        this.f15699Ab.add(c8368ah3);
                                        c6197a.remove(view);
                                        c6197a2.remove(view2);
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        C0407f c0407f = c25322ai.f5131AG;
                        C0407f c0407f2 = c25322ai2.f5131AG;
                        size = c0407f.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) c0407f.valueAt(i3);
                            if (view != null && mo59139C(view)) {
                                view2 = (View) c0407f2.mo742k(c0407f.keyAt(i3));
                                if (view2 != null && mo59139C(view2)) {
                                    c8368ah2 = (C8368ah) c6197a.get(view);
                                    c8368ah3 = (C8368ah) c6197a2.get(view2);
                                    if (!(c8368ah2 == null || c8368ah3 == null)) {
                                        this.f15698Aa.add(c8368ah2);
                                        this.f15699Ab.add(c8368ah3);
                                        c6197a.remove(view);
                                        c6197a2.remove(view2);
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
                    if (i4 < c6197a.size()) {
                        c8368ah = (C8368ah) c6197a.valueAt(i4);
                        if (mo59139C(c8368ah.view)) {
                            this.f15698Aa.add(c8368ah);
                            this.f15699Ab.add(null);
                        }
                        i = i4 + 1;
                    } else {
                        i = 0;
                        while (true) {
                            i4 = i;
                            if (i4 < c6197a2.size()) {
                                c8368ah = (C8368ah) c6197a2.valueAt(i4);
                                if (mo59139C(c8368ah.view)) {
                                    this.f15699Ab.add(c8368ah);
                                    this.f15698Aa.add(null);
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
    /* renamed from: a */
    public void mo42274a(ViewGroup viewGroup, C25322ai c25322ai, C25322ai c25322ai2, ArrayList<C8368ah> arrayList, ArrayList<C8368ah> arrayList2) {
        int i;
        C6197a cW = m62074cW();
        long j = Long.MAX_VALUE;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            C8368ah c8368ah;
            C8368ah c8368ah2;
            C8368ah c8368ah3 = (C8368ah) arrayList.get(i3);
            C8368ah c8368ah4 = (C8368ah) arrayList2.get(i3);
            if (c8368ah3 == null || c8368ah3.f2315AD.contains(this)) {
                c8368ah = c8368ah3;
            } else {
                c8368ah = null;
            }
            if (c8368ah4 == null || c8368ah4.f2315AD.contains(this)) {
                c8368ah2 = c8368ah4;
            } else {
                c8368ah2 = null;
            }
            if (c8368ah != null || c8368ah2 != null) {
                Object obj = (c8368ah == null || c8368ah2 == null || mo31632a(c8368ah, c8368ah2)) ? 1 : null;
                if (obj != null) {
                    Animator a = mo409a(viewGroup, c8368ah, c8368ah2);
                    if (a != null) {
                        Object obj2;
                        C8368ah c8368ah5;
                        View view;
                        c8368ah3 = null;
                        Animator obj22;
                        if (c8368ah2 != null) {
                            View view2 = c8368ah2.view;
                            String[] transitionProperties = getTransitionProperties();
                            if (!(view2 == null || transitionProperties == null || transitionProperties.length <= 0)) {
                                C8368ah c8368ah6 = new C8368ah();
                                c8368ah6.view = view2;
                                c8368ah3 = (C8368ah) c25322ai2.f5129AE.get(view2);
                                if (c8368ah3 != null) {
                                    for (i = 0; i < transitionProperties.length; i++) {
                                        c8368ah6.values.put(transitionProperties[i], c8368ah3.values.get(transitionProperties[i]));
                                    }
                                }
                                int size2 = cW.size();
                                for (i = 0; i < size2; i++) {
                                    C37101a c37101a = (C37101a) cW.get((Animator) cW.keyAt(i));
                                    if (c37101a.f15727An != null && c37101a.mView == view2 && c37101a.mName.equals(this.mName) && c37101a.f15727An.equals(c8368ah6)) {
                                        obj22 = null;
                                        c8368ah5 = c8368ah6;
                                        view = view2;
                                        break;
                                    }
                                }
                                c8368ah3 = c8368ah6;
                            }
                            obj22 = a;
                            c8368ah5 = c8368ah3;
                            view = view2;
                        } else {
                            view = c8368ah.view;
                            obj22 = a;
                            c8368ah5 = null;
                        }
                        if (obj22 != null) {
                            if (this.f15704Ah != null) {
                                long a2 = this.f15704Ah.mo30425a(viewGroup, this, c8368ah, c8368ah2);
                                sparseIntArray.put(this.f15708uC.size(), (int) a2);
                                j = Math.min(a2, j);
                            }
                            cW.put(obj22, new C37101a(view, this.mName, this, C41495au.m72475K(viewGroup), c8368ah5));
                            this.f15708uC.add(obj22);
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
                    Animator animator = (Animator) this.f15708uC.get(sparseIntArray.keyAt(i));
                    animator.setStartDelay((((long) sparseIntArray.valueAt(i)) - j) + animator.getStartDelay());
                    i2 = i + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: C */
    public final boolean mo59139C(View view) {
        int id = view.getId();
        if (this.f15715zP != null && this.f15715zP.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.f15716zQ != null && this.f15716zQ.contains(view)) {
            return false;
        }
        int i;
        if (this.f15717zR != null) {
            int size = this.f15717zR.size();
            for (i = 0; i < size; i++) {
                if (((Class) this.f15717zR.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f15718zS != null && C0477s.m917ai(view) != null && this.f15718zS.contains(C0477s.m917ai(view))) {
            return false;
        }
        if (this.f15711zL.size() == 0 && this.f15712zM.size() == 0 && ((this.f15714zO == null || this.f15714zO.isEmpty()) && (this.f15713zN == null || this.f15713zN.isEmpty()))) {
            return true;
        }
        if (this.f15711zL.contains(Integer.valueOf(id)) || this.f15712zM.contains(view)) {
            return true;
        }
        if (this.f15713zN != null && this.f15713zN.contains(C0477s.m917ai(view))) {
            return true;
        }
        if (this.f15714zO == null) {
            return false;
        }
        for (i = 0; i < this.f15714zO.size(); i++) {
            if (((Class) this.f15714zO.get(i)).isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: cW */
    private static C6197a<Animator, C37101a> m62074cW() {
        C6197a<Animator, C37101a> c6197a = (C6197a) f15695Ac.get();
        if (c6197a != null) {
            return c6197a;
        }
        C6197a c6197a2 = new C6197a();
        f15695Ac.set(c6197a2);
        return c6197a2;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cX */
    public void mo42279cX() {
        start();
        final C6197a cW = m62074cW();
        Iterator it = this.f15708uC.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (cW.containsKey(animator)) {
                start();
                if (animator != null) {
                    animator.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationStart(Animator animator) {
                            Transition.this.f15701Ae.add(animator);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            cW.remove(animator);
                            Transition.this.f15701Ae.remove(animator);
                        }
                    });
                    if (animator == null) {
                        end();
                    } else {
                        if (this.mDuration >= 0) {
                            animator.setDuration(this.mDuration);
                        }
                        if (this.f15709zJ >= 0) {
                            animator.setStartDelay(this.f15709zJ);
                        }
                        if (this.f15710zK != null) {
                            animator.setInterpolator(this.f15710zK);
                        }
                        animator.addListener(new C83663());
                        animator.start();
                    }
                }
            }
        }
        this.f15708uC.clear();
        end();
    }

    /* renamed from: D */
    public Transition mo42266D(View view) {
        this.f15712zM.add(view);
        return this;
    }

    /* renamed from: E */
    public Transition mo42267E(View view) {
        this.f15712zM.remove(view);
        return this;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo59142b(ViewGroup viewGroup, boolean z) {
        int i;
        View findViewById;
        int i2 = 0;
        mo59148v(z);
        if ((this.f15711zL.size() > 0 || this.f15712zM.size() > 0) && ((this.f15713zN == null || this.f15713zN.isEmpty()) && (this.f15714zO == null || this.f15714zO.isEmpty()))) {
            C8368ah c8368ah;
            for (i = 0; i < this.f15711zL.size(); i++) {
                findViewById = viewGroup.findViewById(((Integer) this.f15711zL.get(i)).intValue());
                if (findViewById != null) {
                    c8368ah = new C8368ah();
                    c8368ah.view = findViewById;
                    if (z) {
                        mo410a(c8368ah);
                    } else {
                        mo411b(c8368ah);
                    }
                    c8368ah.f2315AD.add(this);
                    mo42283d(c8368ah);
                    if (z) {
                        m62069a(this.f15722zW, findViewById, c8368ah);
                    } else {
                        m62069a(this.f15723zX, findViewById, c8368ah);
                    }
                }
            }
            for (i = 0; i < this.f15712zM.size(); i++) {
                findViewById = (View) this.f15712zM.get(i);
                c8368ah = new C8368ah();
                c8368ah.view = findViewById;
                if (z) {
                    mo410a(c8368ah);
                } else {
                    mo411b(c8368ah);
                }
                c8368ah.f2315AD.add(this);
                mo42283d(c8368ah);
                if (z) {
                    m62069a(this.f15722zW, findViewById, c8368ah);
                } else {
                    m62069a(this.f15723zX, findViewById, c8368ah);
                }
            }
        } else {
            m62070a((View) viewGroup, z);
        }
        if (!z && this.f15706Aj != null) {
            int size = this.f15706Aj.size();
            ArrayList arrayList = new ArrayList(size);
            for (i = 0; i < size; i++) {
                arrayList.add(this.f15722zW.f5132AH.remove((String) this.f15706Aj.keyAt(i)));
            }
            while (i2 < size) {
                findViewById = (View) arrayList.get(i2);
                if (findViewById != null) {
                    this.f15722zW.f5132AH.put((String) this.f15706Aj.valueAt(i2), findViewById);
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    private static void m62069a(C25322ai c25322ai, View view, C8368ah c8368ah) {
        c25322ai.f5129AE.put(view, c8368ah);
        int id = view.getId();
        if (id >= 0) {
            if (c25322ai.f5130AF.indexOfKey(id) >= 0) {
                c25322ai.f5130AF.put(id, null);
            } else {
                c25322ai.f5130AF.put(id, view);
            }
        }
        String ai = C0477s.m917ai(view);
        if (ai != null) {
            if (c25322ai.f5132AH.containsKey(ai)) {
                c25322ai.f5132AH.put(ai, null);
            } else {
                c25322ai.f5132AH.put(ai, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c25322ai.f5131AG.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = (View) c25322ai.f5131AG.mo742k(itemIdAtPosition);
                    if (view2 != null) {
                        C0477s.m940d(view2, false);
                        c25322ai.f5131AG.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                C0477s.m940d(view, true);
                c25322ai.f5131AG.put(itemIdAtPosition, view);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: v */
    public final void mo59148v(boolean z) {
        if (z) {
            this.f15722zW.f5129AE.clear();
            this.f15722zW.f5130AF.clear();
            this.f15722zW.f5131AG.clear();
            return;
        }
        this.f15723zX.f5129AE.clear();
        this.f15723zX.f5130AF.clear();
        this.f15723zX.f5131AG.clear();
    }

    /* renamed from: a */
    private void m62070a(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.f15715zP != null && this.f15715zP.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.f15716zQ == null || !this.f15716zQ.contains(view)) {
                int i;
                if (this.f15717zR != null) {
                    int size = this.f15717zR.size();
                    i = 0;
                    while (i < size) {
                        if (!((Class) this.f15717zR.get(i)).isInstance(view)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C8368ah c8368ah = new C8368ah();
                    c8368ah.view = view;
                    if (z) {
                        mo410a(c8368ah);
                    } else {
                        mo411b(c8368ah);
                    }
                    c8368ah.f2315AD.add(this);
                    mo42283d(c8368ah);
                    if (z) {
                        m62069a(this.f15722zW, view, c8368ah);
                    } else {
                        m62069a(this.f15723zX, view, c8368ah);
                    }
                }
                if (!(view instanceof ViewGroup)) {
                    return;
                }
                if (this.f15719zT != null && this.f15719zT.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.f15720zU == null || !this.f15720zU.contains(view)) {
                    if (this.f15721zV != null) {
                        id = this.f15721zV.size();
                        i = 0;
                        while (i < id) {
                            if (!((Class) this.f15721zV.get(i)).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        m62070a(viewGroup.getChildAt(i2), z);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final C8368ah mo59140b(View view, boolean z) {
        while (this.f15724zY != null) {
            this = this.f15724zY;
        }
        return (C8368ah) (z ? this.f15722zW : this.f15723zX).f5129AE.get(view);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final C8368ah mo59143c(View view, boolean z) {
        while (this.f15724zY != null) {
            this = this.f15724zY;
        }
        ArrayList arrayList = z ? this.f15698Aa : this.f15699Ab;
        if (arrayList == null) {
            return null;
        }
        C8368ah c8368ah;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            c8368ah = (C8368ah) arrayList.get(i);
            if (c8368ah == null) {
                return null;
            }
            if (c8368ah.view == view) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            c8368ah = (C8368ah) (z ? this.f15699Ab : this.f15698Aa).get(i);
        } else {
            c8368ah = null;
        }
        return c8368ah;
    }

    /* renamed from: F */
    public void mo42268F(View view) {
        if (!this.f15703Ag) {
            C6197a cW = m62074cW();
            int size = cW.size();
            C8373be K = C41495au.m72475K(view);
            for (int i = size - 1; i >= 0; i--) {
                C37101a c37101a = (C37101a) cW.valueAt(i);
                if (c37101a.mView != null && K.equals(c37101a.f15728Ao)) {
                    C37102a.m62101b((Animator) cW.keyAt(i));
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C31852c) arrayList.get(i2)).mo18279cO();
                }
            }
            this.mPaused = true;
        }
    }

    /* renamed from: G */
    public void mo42269G(View view) {
        if (this.mPaused) {
            if (!this.f15703Ag) {
                C6197a cW = m62074cW();
                int size = cW.size();
                C8373be K = C41495au.m72475K(view);
                for (int i = size - 1; i >= 0; i--) {
                    C37101a c37101a = (C37101a) cW.valueAt(i);
                    if (c37101a.mView != null && K.equals(c37101a.f15728Ao)) {
                        C37102a.m62102c((Animator) cW.keyAt(i));
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C31852c) arrayList.get(i2)).mo18280cP();
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo59141b(ViewGroup viewGroup) {
        this.f15698Aa = new ArrayList();
        this.f15699Ab = new ArrayList();
        m62068a(this.f15722zW, this.f15723zX);
        C6197a cW = m62074cW();
        int size = cW.size();
        C8373be K = C41495au.m72475K(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) cW.keyAt(i);
            if (animator != null) {
                C37101a c37101a = (C37101a) cW.get(animator);
                if (!(c37101a == null || c37101a.mView == null || !K.equals(c37101a.f15728Ao))) {
                    C8368ah c8368ah = c37101a.f15727An;
                    View view = c37101a.mView;
                    C8368ah b = mo59140b(view, true);
                    C8368ah c = mo59143c(view, true);
                    boolean z = !(b == null && c == null) && c37101a.f15729Ap.mo31632a(c8368ah, c);
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
        mo42274a(viewGroup, this.f15722zW, this.f15723zX, this.f15698Aa, this.f15699Ab);
        mo42279cX();
    }

    /* renamed from: a */
    public boolean mo31632a(C8368ah c8368ah, C8368ah c8368ah2) {
        if (!(c8368ah == null || c8368ah2 == null)) {
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String a : transitionProperties) {
                    if (m62071a(c8368ah, c8368ah2, a)) {
                        return true;
                    }
                }
                return false;
            }
            for (String a2 : c8368ah.values.keySet()) {
                if (m62071a(c8368ah, c8368ah2, a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m62071a(C8368ah c8368ah, C8368ah c8368ah2, String str) {
        Object obj = c8368ah.values.get(str);
        Object obj2 = c8368ah2.values.get(str);
        if ((obj != null || obj2 != null) && (obj == null || obj2 == null || !obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void start() {
        if (this.f15702Af == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C31852c) arrayList.get(i)).mo31631cT();
                }
            }
            this.f15703Ag = false;
        }
        this.f15702Af++;
    }

    /* Access modifiers changed, original: protected|final */
    public final void end() {
        this.f15702Af--;
        if (this.f15702Af == 0) {
            int i;
            View view;
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((C31852c) arrayList.get(i2)).mo452a(this);
                }
            }
            for (i = 0; i < this.f15722zW.f5131AG.size(); i++) {
                view = (View) this.f15722zW.f5131AG.valueAt(i);
                if (view != null) {
                    C0477s.m940d(view, false);
                }
            }
            for (i = 0; i < this.f15723zX.f5131AG.size(); i++) {
                view = (View) this.f15723zX.f5131AG.valueAt(i);
                if (view != null) {
                    C0477s.m940d(view, false);
                }
            }
            this.f15703Ag = true;
        }
    }

    /* renamed from: a */
    public Transition mo42271a(C31852c c31852c) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(c31852c);
        return this;
    }

    /* renamed from: b */
    public Transition mo42277b(C31852c c31852c) {
        if (this.mListeners != null) {
            this.mListeners.remove(c31852c);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    /* renamed from: a */
    public void mo42272a(C31851b c31851b) {
        this.f15705Ai = c31851b;
    }

    public final Rect getEpicenter() {
        if (this.f15705Ai == null) {
            return null;
        }
        return this.f15705Ai.mo18301cS();
    }

    /* renamed from: a */
    public void mo42273a(C37104af c37104af) {
        this.f15704Ah = c37104af;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo42283d(C8368ah c8368ah) {
        Object obj = null;
        if (this.f15704Ah != null && !c8368ah.values.isEmpty()) {
            String[] propagationProperties = this.f15704Ah.getPropagationProperties();
            if (propagationProperties != null) {
                for (Object containsKey : propagationProperties) {
                    if (!c8368ah.values.containsKey(containsKey)) {
                        break;
                    }
                }
                int obj2 = 1;
                if (obj2 == null) {
                    this.f15704Ah.mo18298c(c8368ah);
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
            transition.f15708uC = new ArrayList();
            transition.f15722zW = new C25322ai();
            transition.f15723zX = new C25322ai();
            transition.f15698Aa = null;
            transition.f15699Ab = null;
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
        if (this.f15709zJ != -1) {
            str2 = str2 + "dly(" + this.f15709zJ + ") ";
        }
        if (this.f15710zK != null) {
            str2 = str2 + "interp(" + this.f15710zK + ") ";
        }
        if (this.f15711zL.size() <= 0 && this.f15712zM.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f15711zL.size() > 0) {
            for (int i2 = 0; i2 < this.f15711zL.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f15711zL.get(i2);
            }
        }
        if (this.f15712zM.size() > 0) {
            while (i < this.f15712zM.size()) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f15712zM.get(i);
                i++;
            }
        }
        return str3 + ")";
    }
}
