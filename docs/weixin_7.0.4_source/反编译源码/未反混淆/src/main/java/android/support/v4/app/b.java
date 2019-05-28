package android.support.v4.app;

import android.support.v4.f.e;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class b extends m implements g, android.support.v4.app.i.a {
    final FragmentManagerImpl BU;
    ArrayList<a> BV = new ArrayList();
    int BW;
    int BX;
    int BY;
    int BZ;
    int Ca;
    int Cb;
    boolean Cc;
    boolean Cd = true;
    boolean Ce;
    int Cf;
    CharSequence Cg;
    int Ch;
    CharSequence Ci;
    ArrayList<String> Cj;
    ArrayList<String> Ck;
    boolean Cl = false;
    ArrayList<Runnable> Cm;
    int mIndex = -1;
    String mName;

    static final class a {
        int Cn;
        int Co;
        int Cp;
        int Cq;
        int Cr;
        Fragment fragment;

        a() {
        }

        a(int i, Fragment fragment) {
            this.Cn = i;
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

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.Ce);
            if (this.Ca != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.Ca));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.Cb));
            }
            if (!(this.BW == 0 && this.BX == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.BW));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.BX));
            }
            if (!(this.BY == 0 && this.BZ == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.BY));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.BZ));
            }
            if (!(this.Cf == 0 && this.Cg == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.Cf));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.Cg);
            }
            if (!(this.Ch == 0 && this.Ci == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.Ch));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.Ci);
            }
        }
        if (!this.BV.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            new StringBuilder().append(str).append("    ");
            int size = this.BV.size();
            for (int i = 0; i < size; i++) {
                String str2;
                a aVar = (a) this.BV.get(i);
                switch (aVar.Cn) {
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
                        str2 = "cmd=" + aVar.Cn;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.fragment);
                if (z) {
                    if (!(aVar.Co == 0 && aVar.Cp == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.Co));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.Cp));
                    }
                    if (aVar.Cq != 0 || aVar.Cr != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.Cq));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.Cr));
                    }
                }
            }
        }
    }

    public b(FragmentManagerImpl fragmentManagerImpl) {
        this.BU = fragmentManagerImpl;
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        this.BV.add(aVar);
        aVar.Co = this.BW;
        aVar.Cp = this.BX;
        aVar.Cq = this.BY;
        aVar.Cr = this.BZ;
    }

    public final m a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final m a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public final m a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.mFragmentManager = this.BU;
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
        a(new a(i2, fragment));
    }

    public final m a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public final m b(Fragment fragment) {
        a(new a(5, fragment));
        return this;
    }

    public final m c(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public final m d(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public final m r(int i, int i2) {
        this.BW = i;
        this.BX = i2;
        this.BY = 0;
        this.BZ = 0;
        return this;
    }

    public final m dg() {
        if (this.Cd) {
            this.Cc = true;
            this.mName = null;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    private m dh() {
        if (this.Cc) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.Cd = false;
        return this;
    }

    /* Access modifiers changed, original: final */
    public final void aq(int i) {
        if (this.Cc) {
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            int size = this.BV.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.BV.get(i2);
                if (aVar.fragment != null) {
                    Fragment fragment = aVar.fragment;
                    fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(aVar.fragment).append(" to ").append(aVar.fragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void di() {
        if (this.Cm != null) {
            int size = this.Cm.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.Cm.get(i)).run();
            }
            this.Cm = null;
        }
    }

    public final int commit() {
        return x(false);
    }

    public final int commitAllowingStateLoss() {
        return x(true);
    }

    public final void commitNow() {
        dh();
        this.BU.execSingleAction(this, false);
    }

    public final void commitNowAllowingStateLoss() {
        dh();
        this.BU.execSingleAction(this, true);
    }

    private int x(boolean z) {
        if (this.Ce) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
            a("  ", printWriter);
            printWriter.close();
        }
        this.Ce = true;
        if (this.Cc) {
            this.mIndex = this.BU.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.BU.enqueueAction(this, z);
        return this.mIndex;
    }

    public final boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.Cc) {
            this.BU.addBackStackState(this);
        }
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean ar(int i) {
        int size = this.BV.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.BV.get(i2);
            int i3 = aVar.fragment != null ? aVar.fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(ArrayList<b> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.BV.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            a aVar = (a) this.BV.get(i4);
            int i6 = aVar.fragment != null ? aVar.fragment.mContainerId : 0;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    b bVar = (b) arrayList.get(i7);
                    int size2 = bVar.BV.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        a aVar2 = (a) bVar.BV.get(i8);
                        if (aVar2.fragment != null) {
                            i3 = aVar2.fragment.mContainerId;
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
    public final void dj() {
        int size = this.BV.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.BV.get(i);
            Fragment fragment = aVar.fragment;
            if (fragment != null) {
                fragment.setNextTransition(this.Ca, this.Cb);
            }
            switch (aVar.Cn) {
                case 1:
                    fragment.setNextAnim(aVar.Co);
                    this.BU.addFragment(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.Cp);
                    this.BU.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.Cp);
                    this.BU.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.Co);
                    this.BU.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.Cp);
                    this.BU.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.Co);
                    this.BU.attachFragment(fragment);
                    break;
                case 8:
                    this.BU.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.BU.setPrimaryNavigationFragment(null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.Cn);
            }
            if (!(this.Cl || aVar.Cn == 1 || fragment == null)) {
                this.BU.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.Cl) {
            this.BU.moveToState(this.BU.mCurState, true);
        }
    }

    /* Access modifiers changed, original: final */
    public final void y(boolean z) {
        for (int size = this.BV.size() - 1; size >= 0; size--) {
            a aVar = (a) this.BV.get(size);
            Fragment fragment = aVar.fragment;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.Ca), this.Cb);
            }
            switch (aVar.Cn) {
                case 1:
                    fragment.setNextAnim(aVar.Cr);
                    this.BU.removeFragment(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.Cq);
                    this.BU.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.Cq);
                    this.BU.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.Cr);
                    this.BU.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.Cq);
                    this.BU.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.Cr);
                    this.BU.detachFragment(fragment);
                    break;
                case 8:
                    this.BU.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.BU.setPrimaryNavigationFragment(fragment);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.Cn);
            }
            if (!(this.Cl || aVar.Cn == 3 || fragment == null)) {
                this.BU.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.Cl && z) {
            this.BU.moveToState(this.BU.mCurState, true);
        }
    }

    /* Access modifiers changed, original: final */
    public final Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BV.size()) {
                return fragment;
            }
            a aVar = (a) this.BV.get(i2);
            switch (aVar.Cn) {
                case 1:
                case 7:
                    arrayList.add(aVar.fragment);
                    break;
                case 2:
                    Fragment fragment2 = aVar.fragment;
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
                                this.BV.add(i4, new a(9, fragment4));
                                i4++;
                                fragment3 = null;
                            }
                            a aVar2 = new a(3, fragment4);
                            aVar2.Co = aVar.Co;
                            aVar2.Cq = aVar.Cq;
                            aVar2.Cp = aVar.Cp;
                            aVar2.Cr = aVar.Cr;
                            this.BV.add(i4, aVar2);
                            arrayList.remove(fragment4);
                            i4++;
                            obj2 = obj;
                        }
                        size--;
                        obj = obj2;
                    }
                    if (obj == null) {
                        aVar.Cn = 1;
                        arrayList.add(fragment2);
                        i2 = i4;
                        fragment = fragment3;
                        break;
                    }
                    this.BV.remove(i4);
                    i2 = i4 - 1;
                    fragment = fragment3;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.fragment);
                    if (aVar.fragment != fragment) {
                        break;
                    }
                    this.BV.add(i2, new a(9, aVar.fragment));
                    i2++;
                    fragment = null;
                    break;
                case 8:
                    this.BV.add(i2, new a(9, fragment));
                    i2++;
                    fragment = aVar.fragment;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    /* Access modifiers changed, original: final */
    public final Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BV.size()) {
                return fragment;
            }
            a aVar = (a) this.BV.get(i2);
            switch (aVar.Cn) {
                case 1:
                case 7:
                    arrayList.remove(aVar.fragment);
                    break;
                case 3:
                case 6:
                    arrayList.add(aVar.fragment);
                    break;
                case 8:
                    fragment = null;
                    break;
                case 9:
                    fragment = aVar.fragment;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(c cVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.BV.size()) {
                a aVar = (a) this.BV.get(i2);
                if (b(aVar)) {
                    aVar.fragment.setOnStartEnterTransitionListener(cVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    static boolean b(a aVar) {
        Fragment fragment = aVar.fragment;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    public final m b(int i, Fragment fragment) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, null, 2);
        return this;
    }
}
