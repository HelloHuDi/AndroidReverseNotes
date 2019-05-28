package android.support.p057v4.app;

import android.support.p057v4.app.C0336i.C0333a;
import android.support.p057v4.app.Fragment.C0297c;
import android.support.p057v4.app.FragmentManagerImpl.C0310g;
import android.support.p057v4.p065f.C0406e;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.b */
final class C6185b extends C0338m implements C0310g, C0333a {
    /* renamed from: BU */
    final FragmentManagerImpl f1749BU;
    /* renamed from: BV */
    ArrayList<C0330a> f1750BV = new ArrayList();
    /* renamed from: BW */
    int f1751BW;
    /* renamed from: BX */
    int f1752BX;
    /* renamed from: BY */
    int f1753BY;
    /* renamed from: BZ */
    int f1754BZ;
    /* renamed from: Ca */
    int f1755Ca;
    /* renamed from: Cb */
    int f1756Cb;
    /* renamed from: Cc */
    boolean f1757Cc;
    /* renamed from: Cd */
    boolean f1758Cd = true;
    /* renamed from: Ce */
    boolean f1759Ce;
    /* renamed from: Cf */
    int f1760Cf;
    /* renamed from: Cg */
    CharSequence f1761Cg;
    /* renamed from: Ch */
    int f1762Ch;
    /* renamed from: Ci */
    CharSequence f1763Ci;
    /* renamed from: Cj */
    ArrayList<String> f1764Cj;
    /* renamed from: Ck */
    ArrayList<String> f1765Ck;
    /* renamed from: Cl */
    boolean f1766Cl = false;
    /* renamed from: Cm */
    ArrayList<Runnable> f1767Cm;
    int mIndex = -1;
    String mName;

    /* renamed from: android.support.v4.app.b$a */
    static final class C0330a {
        /* renamed from: Cn */
        int f285Cn;
        /* renamed from: Co */
        int f286Co;
        /* renamed from: Cp */
        int f287Cp;
        /* renamed from: Cq */
        int f288Cq;
        /* renamed from: Cr */
        int f289Cr;
        Fragment fragment;

        C0330a() {
        }

        C0330a(int i, Fragment fragment) {
            this.f285Cn = i;
            this.fragment = fragment;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public final void mo13989a(String str, PrintWriter printWriter) {
        mo13990a(str, printWriter, true);
    }

    /* renamed from: a */
    public final void mo13990a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1759Ce);
            if (this.f1755Ca != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1755Ca));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1756Cb));
            }
            if (!(this.f1751BW == 0 && this.f1752BX == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1751BW));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1752BX));
            }
            if (!(this.f1753BY == 0 && this.f1754BZ == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1753BY));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1754BZ));
            }
            if (!(this.f1760Cf == 0 && this.f1761Cg == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1760Cf));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1761Cg);
            }
            if (!(this.f1762Ch == 0 && this.f1763Ci == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1762Ch));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1763Ci);
            }
        }
        if (!this.f1750BV.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            new StringBuilder().append(str).append("    ");
            int size = this.f1750BV.size();
            for (int i = 0; i < size; i++) {
                String str2;
                C0330a c0330a = (C0330a) this.f1750BV.get(i);
                switch (c0330a.f285Cn) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + c0330a.f285Cn;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0330a.fragment);
                if (z) {
                    if (!(c0330a.f286Co == 0 && c0330a.f287Cp == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0330a.f286Co));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0330a.f287Cp));
                    }
                    if (c0330a.f288Cq != 0 || c0330a.f289Cr != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0330a.f288Cq));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0330a.f289Cr));
                    }
                }
            }
        }
    }

    public C6185b(FragmentManagerImpl fragmentManagerImpl) {
        this.f1749BU = fragmentManagerImpl;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo13988a(C0330a c0330a) {
        this.f1750BV.add(c0330a);
        c0330a.f286Co = this.f1751BW;
        c0330a.f287Cp = this.f1752BX;
        c0330a.f288Cq = this.f1753BY;
        c0330a.f289Cr = this.f1754BZ;
    }

    /* renamed from: a */
    public final C0338m mo555a(Fragment fragment, String str) {
        m9888a(0, fragment, str, 1);
        return this;
    }

    /* renamed from: a */
    public final C0338m mo552a(int i, Fragment fragment) {
        m9888a(i, fragment, null, 1);
        return this;
    }

    /* renamed from: a */
    public final C0338m mo553a(int i, Fragment fragment, String str) {
        m9888a(i, fragment, str, 1);
        return this;
    }

    /* renamed from: a */
    private void m9888a(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.mFragmentManager = this.f1749BU;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        mo13988a(new C0330a(i2, fragment));
    }

    /* renamed from: a */
    public final C0338m mo554a(Fragment fragment) {
        mo13988a(new C0330a(3, fragment));
        return this;
    }

    /* renamed from: b */
    public final C0338m mo557b(Fragment fragment) {
        mo13988a(new C0330a(5, fragment));
        return this;
    }

    /* renamed from: c */
    public final C0338m mo558c(Fragment fragment) {
        mo13988a(new C0330a(6, fragment));
        return this;
    }

    /* renamed from: d */
    public final C0338m mo563d(Fragment fragment) {
        mo13988a(new C0330a(7, fragment));
        return this;
    }

    /* renamed from: r */
    public final C0338m mo565r(int i, int i2) {
        this.f1751BW = i;
        this.f1752BX = i2;
        this.f1753BY = 0;
        this.f1754BZ = 0;
        return this;
    }

    /* renamed from: dg */
    public final C0338m mo564dg() {
        if (this.f1758Cd) {
            this.f1757Cc = true;
            this.mName = null;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    /* renamed from: dh */
    private C0338m m9890dh() {
        if (this.f1757Cc) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1758Cd = false;
        return this;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aq */
    public final void mo13992aq(int i) {
        if (this.f1757Cc) {
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            int size = this.f1750BV.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0330a c0330a = (C0330a) this.f1750BV.get(i2);
                if (c0330a.fragment != null) {
                    Fragment fragment = c0330a.fragment;
                    fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(c0330a.fragment).append(" to ").append(c0330a.fragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* renamed from: di */
    public final void mo13995di() {
        if (this.f1767Cm != null) {
            int size = this.f1767Cm.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.f1767Cm.get(i)).run();
            }
            this.f1767Cm = null;
        }
    }

    public final int commit() {
        return m9891x(false);
    }

    public final int commitAllowingStateLoss() {
        return m9891x(true);
    }

    public final void commitNow() {
        m9890dh();
        this.f1749BU.execSingleAction(this, false);
    }

    public final void commitNowAllowingStateLoss() {
        m9890dh();
        this.f1749BU.execSingleAction(this, true);
    }

    /* renamed from: x */
    private int m9891x(boolean z) {
        if (this.f1759Ce) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            PrintWriter printWriter = new PrintWriter(new C0406e("FragmentManager"));
            mo13989a("  ", printWriter);
            printWriter.close();
        }
        this.f1759Ce = true;
        if (this.f1757Cc) {
            this.mIndex = this.f1749BU.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.f1749BU.enqueueAction(this, z);
        return this.mIndex;
    }

    /* renamed from: a */
    public final boolean mo496a(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1757Cc) {
            this.f1749BU.addBackStackState(this);
        }
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ar */
    public final boolean mo13993ar(int i) {
        int size = this.f1750BV.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0330a c0330a = (C0330a) this.f1750BV.get(i2);
            int i3 = c0330a.fragment != null ? c0330a.fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo13991a(ArrayList<C6185b> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1750BV.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            C0330a c0330a = (C0330a) this.f1750BV.get(i4);
            int i6 = c0330a.fragment != null ? c0330a.fragment.mContainerId : 0;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    C6185b c6185b = (C6185b) arrayList.get(i7);
                    int size2 = c6185b.f1750BV.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        C0330a c0330a2 = (C0330a) c6185b.f1750BV.get(i8);
                        if (c0330a2.fragment != null) {
                            i3 = c0330a2.fragment.mContainerId;
                        } else {
                            i3 = 0;
                        }
                        if (i3 == i6) {
                            return true;
                        }
                    }
                }
                i5 = i6;
            }
            i4++;
            i3 = i5;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dj */
    public final void mo13996dj() {
        int size = this.f1750BV.size();
        for (int i = 0; i < size; i++) {
            C0330a c0330a = (C0330a) this.f1750BV.get(i);
            Fragment fragment = c0330a.fragment;
            if (fragment != null) {
                fragment.setNextTransition(this.f1755Ca, this.f1756Cb);
            }
            switch (c0330a.f285Cn) {
                case 1:
                    fragment.setNextAnim(c0330a.f286Co);
                    this.f1749BU.addFragment(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(c0330a.f287Cp);
                    this.f1749BU.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(c0330a.f287Cp);
                    this.f1749BU.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(c0330a.f286Co);
                    this.f1749BU.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(c0330a.f287Cp);
                    this.f1749BU.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c0330a.f286Co);
                    this.f1749BU.attachFragment(fragment);
                    break;
                case 8:
                    this.f1749BU.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.f1749BU.setPrimaryNavigationFragment(null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0330a.f285Cn);
            }
            if (!(this.f1766Cl || c0330a.f285Cn == 1 || fragment == null)) {
                this.f1749BU.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.f1766Cl) {
            this.f1749BU.moveToState(this.f1749BU.mCurState, true);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: y */
    public final void mo13998y(boolean z) {
        for (int size = this.f1750BV.size() - 1; size >= 0; size--) {
            C0330a c0330a = (C0330a) this.f1750BV.get(size);
            Fragment fragment = c0330a.fragment;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.f1755Ca), this.f1756Cb);
            }
            switch (c0330a.f285Cn) {
                case 1:
                    fragment.setNextAnim(c0330a.f289Cr);
                    this.f1749BU.removeFragment(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(c0330a.f288Cq);
                    this.f1749BU.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(c0330a.f288Cq);
                    this.f1749BU.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(c0330a.f289Cr);
                    this.f1749BU.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(c0330a.f288Cq);
                    this.f1749BU.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c0330a.f289Cr);
                    this.f1749BU.detachFragment(fragment);
                    break;
                case 8:
                    this.f1749BU.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.f1749BU.setPrimaryNavigationFragment(fragment);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0330a.f285Cn);
            }
            if (!(this.f1766Cl || c0330a.f285Cn == 3 || fragment == null)) {
                this.f1749BU.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.f1766Cl && z) {
            this.f1749BU.moveToState(this.f1749BU.mCurState, true);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final Fragment mo13986a(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1750BV.size()) {
                return fragment;
            }
            C0330a c0330a = (C0330a) this.f1750BV.get(i2);
            switch (c0330a.f285Cn) {
                case 1:
                case 7:
                    arrayList.add(c0330a.fragment);
                    break;
                case 2:
                    Fragment fragment2 = c0330a.fragment;
                    int i3 = fragment2.mContainerId;
                    Object obj = null;
                    int size = arrayList.size() - 1;
                    int i4 = i2;
                    Fragment fragment3 = fragment;
                    while (size >= 0) {
                        Object obj2;
                        Fragment fragment4 = (Fragment) arrayList.get(size);
                        if (fragment4.mContainerId != i3) {
                            obj2 = obj;
                        } else if (fragment4 == fragment2) {
                            obj2 = 1;
                        } else {
                            if (fragment4 == fragment3) {
                                this.f1750BV.add(i4, new C0330a(9, fragment4));
                                i4++;
                                fragment3 = null;
                            }
                            C0330a c0330a2 = new C0330a(3, fragment4);
                            c0330a2.f286Co = c0330a.f286Co;
                            c0330a2.f288Cq = c0330a.f288Cq;
                            c0330a2.f287Cp = c0330a.f287Cp;
                            c0330a2.f289Cr = c0330a.f289Cr;
                            this.f1750BV.add(i4, c0330a2);
                            arrayList.remove(fragment4);
                            i4++;
                            obj2 = obj;
                        }
                        size--;
                        obj = obj2;
                    }
                    if (obj == null) {
                        c0330a.f285Cn = 1;
                        arrayList.add(fragment2);
                        i2 = i4;
                        fragment = fragment3;
                        break;
                    }
                    this.f1750BV.remove(i4);
                    i2 = i4 - 1;
                    fragment = fragment3;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c0330a.fragment);
                    if (c0330a.fragment != fragment) {
                        break;
                    }
                    this.f1750BV.add(i2, new C0330a(9, c0330a.fragment));
                    i2++;
                    fragment = null;
                    break;
                case 8:
                    this.f1750BV.add(i2, new C0330a(9, fragment));
                    i2++;
                    fragment = c0330a.fragment;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final Fragment mo13994b(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1750BV.size()) {
                return fragment;
            }
            C0330a c0330a = (C0330a) this.f1750BV.get(i2);
            switch (c0330a.f285Cn) {
                case 1:
                case 7:
                    arrayList.remove(c0330a.fragment);
                    break;
                case 3:
                case 6:
                    arrayList.add(c0330a.fragment);
                    break;
                case 8:
                    fragment = null;
                    break;
                case 9:
                    fragment = c0330a.fragment;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo13987a(C0297c c0297c) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1750BV.size()) {
                C0330a c0330a = (C0330a) this.f1750BV.get(i2);
                if (C6185b.m9889b(c0330a)) {
                    c0330a.fragment.setOnStartEnterTransitionListener(c0297c);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    static boolean m9889b(C0330a c0330a) {
        Fragment fragment = c0330a.fragment;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    /* renamed from: b */
    public final C0338m mo556b(int i, Fragment fragment) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m9888a(i, fragment, null, 2);
        return this;
    }
}
