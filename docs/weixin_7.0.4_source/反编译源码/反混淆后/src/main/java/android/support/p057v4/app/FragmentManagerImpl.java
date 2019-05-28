package android.support.p057v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p057v4.app.C0336i.C0333a;
import android.support.p057v4.app.C0336i.C0334b;
import android.support.p057v4.app.C0336i.C0335c;
import android.support.p057v4.app.C6185b.C0330a;
import android.support.p057v4.app.Fragment.C0297c;
import android.support.p057v4.app.Fragment.SavedState;
import android.support.p057v4.p065f.C0402b;
import android.support.p057v4.p065f.C0405d;
import android.support.p057v4.p065f.C0406e;
import android.support.p057v4.p065f.C0415j;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v4.app.FragmentManagerImpl */
final class FragmentManagerImpl extends C0336i implements Factory2 {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField = null;
    SparseArray<Fragment> mActive;
    final ArrayList<Fragment> mAdded = new ArrayList();
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<C6185b> mBackStack;
    ArrayList<C0335c> mBackStackChangeListeners;
    ArrayList<C6185b> mBackStackIndices;
    C0331f mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit = new C03001();
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    C6186h mHost;
    private final CopyOnWriteArrayList<C0415j<C0334b, Boolean>> mLifecycleCallbacks = new CopyOnWriteArrayList();
    boolean mNeedMenuInvalidate;
    int mNextFragmentIndex = 0;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<C0310g> mPendingActions;
    ArrayList<C6181i> mPostponedTransactions;
    Fragment mPrimaryNav;
    C0337j mSavedNonConfig;
    SparseArray<Parcelable> mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    boolean mStopped;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<C6185b> mTmpRecords;

    /* renamed from: android.support.v4.app.FragmentManagerImpl$1 */
    class C03001 implements Runnable {
        C03001() {
        }

        public final void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$b */
    static class C0305b implements AnimationListener {
        /* renamed from: Dd */
        private final AnimationListener f251Dd;

        /* synthetic */ C0305b(AnimationListener animationListener, byte b) {
            this(animationListener);
        }

        private C0305b(AnimationListener animationListener) {
            this.f251Dd = animationListener;
        }

        public void onAnimationStart(Animation animation) {
            if (this.f251Dd != null) {
                this.f251Dd.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f251Dd != null) {
                this.f251Dd.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f251Dd != null) {
                this.f251Dd.onAnimationRepeat(animation);
            }
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$c */
    static class C0306c {
        /* renamed from: De */
        public final Animation f252De;
        /* renamed from: Df */
        public final Animator f253Df;

        private C0306c(Animation animation) {
            this.f252De = animation;
            this.f253Df = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private C0306c(Animator animator) {
            this.f252De = null;
            this.f253Df = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$d */
    static class C0307d extends AnimatorListenerAdapter {
        View mView;

        C0307d(View view) {
            this.mView = view;
        }

        public final void onAnimationStart(Animator animator) {
            this.mView.setLayerType(2, null);
        }

        public final void onAnimationEnd(Animator animator) {
            this.mView.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$e */
    static class C0308e extends AnimationSet implements Runnable {
        /* renamed from: Ag */
        private boolean f254Ag;
        /* renamed from: BE */
        private final ViewGroup f255BE;
        /* renamed from: Dg */
        private final View f256Dg;
        /* renamed from: Dh */
        private boolean f257Dh;

        C0308e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f255BE = viewGroup;
            this.f256Dg = view;
            addAnimation(animation);
        }

        public final boolean getTransformation(long j, Transformation transformation) {
            if (this.f254Ag) {
                if (this.f257Dh) {
                    return false;
                }
                return true;
            } else if (super.getTransformation(j, transformation)) {
                return true;
            } else {
                this.f254Ag = true;
                C0367z.m618a(this.f255BE, this);
                return true;
            }
        }

        public final boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.f254Ag) {
                if (this.f257Dh) {
                    return false;
                }
                return true;
            } else if (super.getTransformation(j, transformation, f)) {
                return true;
            } else {
                this.f254Ag = true;
                C0367z.m618a(this.f255BE, this);
                return true;
            }
        }

        public final void run() {
            this.f255BE.endViewTransition(this.f256Dg);
            this.f257Dh = true;
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$f */
    static class C0309f {
        /* renamed from: Di */
        public static final int[] f258Di = new int[]{16842755, 16842960, 16842961};
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$g */
    interface C0310g {
        /* renamed from: a */
        boolean mo496a(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$a */
    static class C6179a extends C0305b {
        View mView;

        /* renamed from: android.support.v4.app.FragmentManagerImpl$a$1 */
        class C03041 implements Runnable {
            C03041() {
            }

            public final void run() {
                C6179a.this.mView.setLayerType(0, null);
            }
        }

        C6179a(View view, AnimationListener animationListener) {
            super(animationListener, (byte) 0);
            this.mView = view;
        }

        public final void onAnimationEnd(Animation animation) {
            if (C0477s.m930av(this.mView) || VERSION.SDK_INT >= 24) {
                this.mView.post(new C03041());
            } else {
                this.mView.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$h */
    class C6180h implements C0310g {
        /* renamed from: Dj */
        final int f1742Dj;
        final int mId;
        final String mName;

        C6180h(String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.f1742Dj = i2;
        }

        /* renamed from: a */
        public final boolean mo496a(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManagerImpl.this.mPrimaryNav != null && this.mId < 0 && this.mName == null) {
                C0336i peekChildFragmentManager = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.popBackStackImmediate()) {
                    return false;
                }
            }
            return FragmentManagerImpl.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.f1742Dj);
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$i */
    static class C6181i implements C0297c {
        /* renamed from: Dk */
        final boolean f1743Dk;
        /* renamed from: Dl */
        final C6185b f1744Dl;
        /* renamed from: Dm */
        int f1745Dm;

        C6181i(C6185b c6185b, boolean z) {
            this.f1743Dk = z;
            this.f1744Dl = c6185b;
        }

        /* renamed from: dk */
        public final void mo480dk() {
            this.f1745Dm--;
            if (this.f1745Dm == 0) {
                this.f1744Dl.f1749BU.scheduleCommit();
            }
        }

        public final void startListening() {
            this.f1745Dm++;
        }

        /* renamed from: dn */
        public final void mo13905dn() {
            boolean z;
            boolean z2 = false;
            if (this.f1745Dm > 0) {
                z = true;
            } else {
                z = false;
            }
            FragmentManagerImpl fragmentManagerImpl = this.f1744Dl.f1749BU;
            int size = fragmentManagerImpl.mAdded.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) fragmentManagerImpl.mAdded.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            FragmentManagerImpl fragmentManagerImpl2 = this.f1744Dl.f1749BU;
            C6185b c6185b = this.f1744Dl;
            boolean z3 = this.f1743Dk;
            if (!z) {
                z2 = true;
            }
            fragmentManagerImpl2.completeExecute(c6185b, z3, z2, true);
        }

        /* renamed from: do */
        public final void mo13906do() {
            this.f1744Dl.f1749BU.completeExecute(this.f1744Dl, this.f1743Dk, false, false);
        }
    }

    FragmentManagerImpl() {
    }

    static boolean modifiesAlpha(C0306c c0306c) {
        if (c0306c.f252De instanceof AlphaAnimation) {
            return true;
        }
        if (!(c0306c.f252De instanceof AnimationSet)) {
            return FragmentManagerImpl.modifiesAlpha(c0306c.f253Df);
        }
        List animations = ((AnimationSet) c0306c.f252De).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean modifiesAlpha(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
            return false;
        } else if (!(animator instanceof AnimatorSet)) {
            return false;
        } else {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (FragmentManagerImpl.modifiesAlpha((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean shouldRunOnHWLayer(View view, C0306c c0306c) {
        if (view == null || c0306c == null || VERSION.SDK_INT < 19 || view.getLayerType() != 0 || !C0477s.m921am(view) || !FragmentManagerImpl.modifiesAlpha(c0306c)) {
            return false;
        }
        return true;
    }

    private void throwException(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new C0406e(TAG));
        if (this.mHost != null) {
            try {
                this.mHost.mo14003a("  ", printWriter, new String[0]);
            } catch (Exception e) {
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
            }
        }
        throw runtimeException;
    }

    public final C0338m beginTransaction() {
        return new C6185b(this);
    }

    public final boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        forcePostponedTransactions();
        return execPendingActions;
    }

    public final void popBackStack() {
        enqueueAction(new C6180h(null, -1, 0), false);
    }

    public final boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    public final void popBackStack(String str, int i) {
        enqueueAction(new C6180h(str, -1, i), false);
    }

    public final boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i);
    }

    public final void popBackStack(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(i)));
        }
        enqueueAction(new C6180h(null, i, i2), false);
    }

    public final boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        execPendingActions();
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(i)));
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions();
        ensureExecReady(true);
        if (this.mPrimaryNav != null && i < 0 && str == null) {
            C0336i peekChildFragmentManager = this.mPrimaryNav.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.popBackStackImmediate()) {
                return true;
            }
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        doPendingDeferredStart();
        burpActive();
        return popBackStackState;
    }

    public final int getBackStackEntryCount() {
        return this.mBackStack != null ? this.mBackStack.size() : 0;
    }

    public final C0333a getBackStackEntryAt(int i) {
        return (C0333a) this.mBackStack.get(i);
    }

    public final void addOnBackStackChangedListener(C0335c c0335c) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(c0335c);
    }

    public final void removeOnBackStackChangedListener(C0335c c0335c) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(c0335c);
        }
    }

    public final void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = (Fragment) this.mActive.get(i);
        if (fragment != null) {
            return fragment;
        }
        throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final List<Fragment> getFragments() {
        if (this.mAdded.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Fragment> list;
        synchronized (this.mAdded) {
            list = (List) this.mAdded.clone();
        }
        return list;
    }

    /* Access modifiers changed, original: final */
    public final List<Fragment> getActiveFragments() {
        if (this.mActive == null) {
            return null;
        }
        int size = this.mActive.size();
        List<Fragment> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.mActive.valueAt(i));
        }
        return arrayList;
    }

    /* Access modifiers changed, original: final */
    public final int getActiveFragmentCount() {
        if (this.mActive == null) {
            return 0;
        }
        return this.mActive.size();
    }

    public final SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle saveFragmentBasicState = saveFragmentBasicState(fragment);
        if (saveFragmentBasicState != null) {
            return new SavedState(saveFragmentBasicState);
        }
        return null;
    }

    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.mParent != null) {
            C0405d.m692a(this.mParent, stringBuilder);
        } else {
            C0405d.m692a(this.mHost, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        C6185b c6185b;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.mActive != null) {
            size = this.mActive.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mActive.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.mAdded.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                fragment = (Fragment) this.mAdded.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.mCreatedMenus != null) {
            size = this.mCreatedMenus.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mCreatedMenus.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.mBackStack != null) {
            size = this.mBackStack.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    c6185b = (C6185b) this.mBackStack.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c6185b.toString());
                    c6185b.mo13989a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null) {
                int size2 = this.mBackStackIndices.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c6185b = (C6185b) this.mBackStackIndices.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c6185b);
                    }
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null) {
            i = this.mPendingActions.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    C0310g c0310g = (C0310g) this.mPendingActions.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(c0310g);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
    }

    static C0306c makeOpenCloseAnimation(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new C0306c(animationSet, (byte) 0);
    }

    static C0306c makeFadeAnimation(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        return new C0306c(alphaAnimation, (byte) 0);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051 A:{SYNTHETIC, Splitter:B:17:0x0051} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C0306c loadAnimation(Fragment fragment, int i, boolean z, int i2) {
        int nextAnim = fragment.getNextAnim();
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new C0306c(onCreateAnimation, (byte) 0);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new C0306c(onCreateAnimator, (byte) 0);
        }
        if (nextAnim != 0) {
            byte b;
            boolean equals = "anim".equals(this.mHost.mContext.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.mHost.mContext, nextAnim);
                    if (loadAnimation != null) {
                        return new C0306c(loadAnimation, (byte) 0);
                    }
                    b = (byte) 1;
                    if (b == (byte) 0) {
                        try {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.mHost.mContext, nextAnim);
                            if (loadAnimator != null) {
                                return new C0306c(loadAnimator, (byte) 0);
                            }
                        } catch (RuntimeException e) {
                            if (equals) {
                                throw e;
                            }
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mHost.mContext, nextAnim);
                            if (loadAnimation2 != null) {
                                return new C0306c(loadAnimation2, (byte) 0);
                            }
                        }
                    }
                } catch (NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException e3) {
                }
            }
            b = (byte) 0;
            if (b == (byte) 0) {
            }
        }
        if (i == 0) {
            return null;
        }
        int transitToStyleIndex = FragmentManagerImpl.transitToStyleIndex(i, z);
        if (transitToStyleIndex < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.mContext, 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.mContext, 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.mContext, 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return FragmentManagerImpl.makeOpenCloseAnimation(this.mHost.mContext, 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return FragmentManagerImpl.makeFadeAnimation(this.mHost.mContext, 0.0f, 1.0f);
            case 6:
                return FragmentManagerImpl.makeFadeAnimation(this.mHost.mContext, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mHost.onHasWindowAnimations()) {
                    i2 = this.mHost.onGetWindowAnimations();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public final void performPendingDeferredStart(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = false;
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    private static void setHWLayerAnimListenerIfAlpha(View view, C0306c c0306c) {
        if (view != null && c0306c != null && FragmentManagerImpl.shouldRunOnHWLayer(view, c0306c)) {
            if (c0306c.f253Df != null) {
                c0306c.f253Df.addListener(new C0307d(view));
                return;
            }
            AnimationListener animationListener = FragmentManagerImpl.getAnimationListener(c0306c.f252De);
            view.setLayerType(2, null);
            c0306c.f252De.setAnimationListener(new C6179a(view, animationListener));
        }
    }

    private static AnimationListener getAnimationListener(Animation animation) {
        try {
            if (sAnimationListenerField == null) {
                Field declaredField = Animation.class.getDeclaredField("mListener");
                sAnimationListenerField = declaredField;
                declaredField.setAccessible(true);
            }
            return (AnimationListener) sAnimationListenerField.get(animation);
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:215:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARNING: Missing block: B:80:0x01aa, code skipped:
            ensureInflatedFragmentView(r11);
     */
    /* JADX WARNING: Missing block: B:81:0x01ad, code skipped:
            if (r12 <= 1) goto L_0x0298;
     */
    /* JADX WARNING: Missing block: B:83:0x01b1, code skipped:
            if (DEBUG == false) goto L_0x01be;
     */
    /* JADX WARNING: Missing block: B:84:0x01b3, code skipped:
            new java.lang.StringBuilder("moveto ACTIVITY_CREATED: ").append(r11);
     */
    /* JADX WARNING: Missing block: B:86:0x01c0, code skipped:
            if (r11.mFromLayout != false) goto L_0x0283;
     */
    /* JADX WARNING: Missing block: B:88:0x01c4, code skipped:
            if (r11.mContainerId == 0) goto L_0x041e;
     */
    /* JADX WARNING: Missing block: B:90:0x01c9, code skipped:
            if (r11.mContainerId != -1) goto L_0x01ea;
     */
    /* JADX WARNING: Missing block: B:91:0x01cb, code skipped:
            throwException(new java.lang.IllegalArgumentException("Cannot create fragment " + r11 + " for a container view with no id"));
     */
    /* JADX WARNING: Missing block: B:92:0x01ea, code skipped:
            r0 = (android.view.ViewGroup) r10.mContainer.onFindViewById(r11.mContainerId);
     */
    /* JADX WARNING: Missing block: B:93:0x01f4, code skipped:
            if (r0 != null) goto L_0x0238;
     */
    /* JADX WARNING: Missing block: B:95:0x01f8, code skipped:
            if (r11.mRestored != false) goto L_0x0238;
     */
    /* JADX WARNING: Missing block: B:97:?, code skipped:
            r1 = r11.getResources().getResourceName(r11.mContainerId);
     */
    /* JADX WARNING: Missing block: B:132:0x02e2, code skipped:
            r1 = "unknown";
     */
    /* JADX WARNING: Missing block: B:139:0x02f7, code skipped:
            if (r12 > 0) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:141:0x02fb, code skipped:
            if (r10.mDestroyed == false) goto L_0x030d;
     */
    /* JADX WARNING: Missing block: B:143:0x0301, code skipped:
            if (r11.getAnimatingAway() == null) goto L_0x03d5;
     */
    /* JADX WARNING: Missing block: B:144:0x0303, code skipped:
            r0 = r11.getAnimatingAway();
            r11.setAnimatingAway(null);
            r0.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:146:0x0311, code skipped:
            if (r11.getAnimatingAway() != null) goto L_0x0319;
     */
    /* JADX WARNING: Missing block: B:148:0x0317, code skipped:
            if (r11.getAnimator() == null) goto L_0x03e7;
     */
    /* JADX WARNING: Missing block: B:149:0x0319, code skipped:
            r11.setStateAfterAnimating(r12);
            r12 = 1;
     */
    /* JADX WARNING: Missing block: B:156:0x0337, code skipped:
            if (r12 >= 4) goto L_0x034e;
     */
    /* JADX WARNING: Missing block: B:158:0x033b, code skipped:
            if (DEBUG == false) goto L_0x0348;
     */
    /* JADX WARNING: Missing block: B:159:0x033d, code skipped:
            new java.lang.StringBuilder("movefrom STARTED: ").append(r11);
     */
    /* JADX WARNING: Missing block: B:160:0x0348, code skipped:
            r11.performStop();
            dispatchOnFragmentStopped(r11, false);
     */
    /* JADX WARNING: Missing block: B:161:0x034e, code skipped:
            if (r12 >= 3) goto L_0x0362;
     */
    /* JADX WARNING: Missing block: B:163:0x0352, code skipped:
            if (DEBUG == false) goto L_0x035f;
     */
    /* JADX WARNING: Missing block: B:164:0x0354, code skipped:
            new java.lang.StringBuilder("movefrom STOPPED: ").append(r11);
     */
    /* JADX WARNING: Missing block: B:165:0x035f, code skipped:
            r11.performReallyStop();
     */
    /* JADX WARNING: Missing block: B:167:0x0363, code skipped:
            if (r12 >= 2) goto L_0x02f7;
     */
    /* JADX WARNING: Missing block: B:169:0x0367, code skipped:
            if (DEBUG == false) goto L_0x0374;
     */
    /* JADX WARNING: Missing block: B:170:0x0369, code skipped:
            new java.lang.StringBuilder("movefrom ACTIVITY_CREATED: ").append(r11);
     */
    /* JADX WARNING: Missing block: B:172:0x0376, code skipped:
            if (r11.mView == null) goto L_0x0387;
     */
    /* JADX WARNING: Missing block: B:174:0x037e, code skipped:
            if (r10.mHost.mo14004dl() == false) goto L_0x0387;
     */
    /* JADX WARNING: Missing block: B:176:0x0382, code skipped:
            if (r11.mSavedViewState != null) goto L_0x0387;
     */
    /* JADX WARNING: Missing block: B:177:0x0384, code skipped:
            saveFragmentViewState(r11);
     */
    /* JADX WARNING: Missing block: B:178:0x0387, code skipped:
            r11.performDestroyView();
            dispatchOnFragmentViewDestroyed(r11, false);
     */
    /* JADX WARNING: Missing block: B:179:0x038f, code skipped:
            if (r11.mView == null) goto L_0x03cb;
     */
    /* JADX WARNING: Missing block: B:181:0x0393, code skipped:
            if (r11.mContainer == null) goto L_0x03cb;
     */
    /* JADX WARNING: Missing block: B:182:0x0395, code skipped:
            r11.mContainer.endViewTransition(r11.mView);
            r11.mView.clearAnimation();
     */
    /* JADX WARNING: Missing block: B:183:0x03a3, code skipped:
            if (r10.mCurState <= 0) goto L_0x041c;
     */
    /* JADX WARNING: Missing block: B:185:0x03a7, code skipped:
            if (r10.mDestroyed != false) goto L_0x041c;
     */
    /* JADX WARNING: Missing block: B:187:0x03af, code skipped:
            if (r11.mView.getVisibility() != 0) goto L_0x041c;
     */
    /* JADX WARNING: Missing block: B:189:0x03b6, code skipped:
            if (r11.mPostponedAlpha < 0.0f) goto L_0x041c;
     */
    /* JADX WARNING: Missing block: B:190:0x03b8, code skipped:
            r0 = loadAnimation(r11, r13, false, r14);
     */
    /* JADX WARNING: Missing block: B:191:0x03bc, code skipped:
            r11.mPostponedAlpha = 0.0f;
     */
    /* JADX WARNING: Missing block: B:192:0x03bf, code skipped:
            if (r0 == null) goto L_0x03c4;
     */
    /* JADX WARNING: Missing block: B:193:0x03c1, code skipped:
            animateRemoveFragment(r11, r0, r12);
     */
    /* JADX WARNING: Missing block: B:194:0x03c4, code skipped:
            r11.mContainer.removeView(r11.mView);
     */
    /* JADX WARNING: Missing block: B:195:0x03cb, code skipped:
            r11.mContainer = null;
            r11.mView = null;
            r11.mInnerView = null;
            r11.mInLayout = false;
     */
    /* JADX WARNING: Missing block: B:197:0x03d9, code skipped:
            if (r11.getAnimator() == null) goto L_0x030d;
     */
    /* JADX WARNING: Missing block: B:198:0x03db, code skipped:
            r0 = r11.getAnimator();
            r11.setAnimator(null);
            r0.cancel();
     */
    /* JADX WARNING: Missing block: B:200:0x03e9, code skipped:
            if (DEBUG == false) goto L_0x03f6;
     */
    /* JADX WARNING: Missing block: B:201:0x03eb, code skipped:
            new java.lang.StringBuilder("movefrom CREATED: ").append(r11);
     */
    /* JADX WARNING: Missing block: B:203:0x03f8, code skipped:
            if (r11.mRetaining != false) goto L_0x0411;
     */
    /* JADX WARNING: Missing block: B:204:0x03fa, code skipped:
            r11.performDestroy();
            dispatchOnFragmentDestroyed(r11, false);
     */
    /* JADX WARNING: Missing block: B:205:0x0400, code skipped:
            r11.performDetach();
            dispatchOnFragmentDetached(r11, false);
     */
    /* JADX WARNING: Missing block: B:206:0x0406, code skipped:
            if (r15 != false) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:208:0x040a, code skipped:
            if (r11.mRetaining != false) goto L_0x0414;
     */
    /* JADX WARNING: Missing block: B:209:0x040c, code skipped:
            makeInactive(r11);
     */
    /* JADX WARNING: Missing block: B:210:0x0411, code skipped:
            r11.mState = 0;
     */
    /* JADX WARNING: Missing block: B:211:0x0414, code skipped:
            r11.mHost = null;
            r11.mParentFragment = null;
            r11.mFragmentManager = null;
     */
    /* JADX WARNING: Missing block: B:212:0x041c, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:213:0x041e, code skipped:
            r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void moveToState(Fragment fragment, int i, int i2, int i3, boolean z) {
        boolean z2 = true;
        if ((!fragment.mAdded || fragment.mDetached) && i > 1) {
            i = 1;
        }
        if (fragment.mRemoving && r12 > fragment.mState) {
            if (fragment.mState == 0 && fragment.isInBackStack()) {
                i = 1;
            } else {
                i = fragment.mState;
            }
        }
        if (fragment.mDeferStart && fragment.mState < 4 && r12 > 3) {
            i = 3;
        }
        if (fragment.mState > i) {
            if (fragment.mState > i) {
                switch (fragment.mState) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        if (i < 5) {
                            if (DEBUG) {
                                new StringBuilder("movefrom RESUMED: ").append(fragment);
                            }
                            fragment.performPause();
                            dispatchOnFragmentPaused(fragment, false);
                            break;
                        }
                        break;
                }
            }
        } else if (!fragment.mFromLayout || fragment.mInLayout) {
            if (!(fragment.getAnimatingAway() == null && fragment.getAnimator() == null)) {
                fragment.setAnimatingAway(null);
                fragment.setAnimator(null);
                moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
            }
            switch (fragment.mState) {
                case 0:
                    if (i > 0) {
                        FragmentManagerImpl fragmentManagerImpl;
                        if (DEBUG) {
                            new StringBuilder("moveto CREATED: ").append(fragment);
                        }
                        if (fragment.mSavedFragmentState != null) {
                            fragment.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
                            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mTarget = getFragment(fragment.mSavedFragmentState, TARGET_STATE_TAG);
                            if (fragment.mTarget != null) {
                                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
                            }
                            if (fragment.mSavedUserVisibleHint != null) {
                                fragment.mUserVisibleHint = fragment.mSavedUserVisibleHint.booleanValue();
                                fragment.mSavedUserVisibleHint = null;
                            } else {
                                fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
                            }
                            if (!fragment.mUserVisibleHint) {
                                fragment.mDeferStart = true;
                                if (i > 3) {
                                    i = 3;
                                }
                            }
                        }
                        fragment.mHost = this.mHost;
                        fragment.mParentFragment = this.mParent;
                        if (this.mParent != null) {
                            fragmentManagerImpl = this.mParent.mChildFragmentManager;
                        } else {
                            fragmentManagerImpl = this.mHost.mFragmentManager;
                        }
                        fragment.mFragmentManager = fragmentManagerImpl;
                        if (fragment.mTarget != null) {
                            if (this.mActive.get(fragment.mTarget.mIndex) != fragment.mTarget) {
                                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                            } else if (fragment.mTarget.mState <= 0) {
                                moveToState(fragment.mTarget, 1, 0, 0, true);
                            }
                        }
                        dispatchOnFragmentPreAttached(fragment, this.mHost.mContext, false);
                        fragment.mCalled = false;
                        fragment.onAttach(this.mHost.mContext);
                        if (fragment.mCalled) {
                            if (fragment.mParentFragment == null) {
                                this.mHost.onAttachFragment(fragment);
                            } else {
                                fragment.mParentFragment.onAttachFragment(fragment);
                            }
                            dispatchOnFragmentAttached(fragment, this.mHost.mContext, false);
                            if (fragment.mIsCreated) {
                                fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
                                fragment.mState = 1;
                            } else {
                                dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
                                fragment.performCreate(fragment.mSavedFragmentState);
                                dispatchOnFragmentCreated(fragment, fragment.mSavedFragmentState, false);
                            }
                            fragment.mRetaining = false;
                            break;
                        }
                        throw new C0325ad("Fragment " + fragment + " did not call through to super.onAttach()");
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } else {
            return;
        }
        if (fragment.mState == i) {
            new StringBuilder("moveToState: Fragment state for ").append(fragment).append(" not updated inline; expected state ").append(i).append(" found ").append(fragment.mState);
            fragment.mState = i;
            return;
        }
        return;
        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + r1 + ") for fragment " + fragment));
        fragment.mContainer = r0;
        fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), r0, fragment.mSavedFragmentState);
        if (fragment.mView != null) {
            fragment.mInnerView = fragment.mView;
            fragment.mView.setSaveFromParentEnabled(false);
            if (r0 != null) {
                r0.addView(fragment.mView);
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
            dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
            if (fragment.mView.getVisibility() != 0 || fragment.mContainer == null) {
                z2 = false;
            }
            fragment.mIsNewlyAdded = z2;
        } else {
            fragment.mInnerView = null;
        }
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        dispatchOnFragmentActivityCreated(fragment, fragment.mSavedFragmentState, false);
        if (fragment.mView != null) {
            fragment.restoreViewState(fragment.mSavedFragmentState);
        }
        fragment.mSavedFragmentState = null;
        if (i > 2) {
            fragment.mState = 3;
        }
        if (i > 3) {
            if (DEBUG) {
                new StringBuilder("moveto STARTED: ").append(fragment);
            }
            fragment.performStart();
            dispatchOnFragmentStarted(fragment, false);
        }
        if (i > 4) {
            if (DEBUG) {
                new StringBuilder("moveto RESUMED: ").append(fragment);
            }
            fragment.performResume();
            dispatchOnFragmentResumed(fragment, false);
            fragment.mSavedFragmentState = null;
            fragment.mSavedViewState = null;
        }
        if (fragment.mState == i) {
        }
    }

    private void animateRemoveFragment(final Fragment fragment, C0306c c0306c, int i) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        if (c0306c.f252De != null) {
            C0308e c0308e = new C0308e(c0306c.f252De, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            c0308e.setAnimationListener(new C0305b(FragmentManagerImpl.getAnimationListener(c0308e)) {

                /* renamed from: android.support.v4.app.FragmentManagerImpl$2$1 */
                class C03011 implements Runnable {
                    C03011() {
                    }

                    public final void run() {
                        if (fragment.getAnimatingAway() != null) {
                            fragment.setAnimatingAway(null);
                            FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                        }
                    }
                }

                public final void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new C03011());
                }
            });
            FragmentManagerImpl.setHWLayerAnimListenerIfAlpha(view, c0306c);
            fragment.mView.startAnimation(c0308e);
            return;
        }
        Animator animator = c0306c.f253Df;
        fragment.setAnimator(c0306c.f253Df);
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        FragmentManagerImpl.setHWLayerAnimListenerIfAlpha(fragment.mView, c0306c);
        animator.start();
    }

    /* Access modifiers changed, original: final */
    public final void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* Access modifiers changed, original: final */
    public final void ensureInflatedFragmentView(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null) {
                fragment.mInnerView = fragment.mView;
                fragment.mView.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void completeShowHideFragment(final Fragment fragment) {
        if (fragment.mView != null) {
            C0306c loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (loadAnimation == null || loadAnimation.f253Df == null) {
                if (loadAnimation != null) {
                    FragmentManagerImpl.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation.f252De);
                    loadAnimation.f252De.start();
                }
                int i = (!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8;
                fragment.mView.setVisibility(i);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                loadAnimation.f253Df.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    loadAnimation.f253Df.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                FragmentManagerImpl.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                loadAnimation.f253Df.start();
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* Access modifiers changed, original: final */
    public final void moveFragmentToExpectedState(Fragment fragment) {
        if (fragment != null) {
            int i = this.mCurState;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            moveToState(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment findFragmentUnder = findFragmentUnder(fragment);
                if (findFragmentUnder != null) {
                    View view = findFragmentUnder.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    i = viewGroup.indexOfChild(fragment.mView);
                    if (i < indexOfChild) {
                        viewGroup.removeViewAt(i);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    C0306c loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (loadAnimation != null) {
                        FragmentManagerImpl.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                        if (loadAnimation.f252De != null) {
                            fragment.mView.startAnimation(loadAnimation.f252De);
                        } else {
                            loadAnimation.f253Df.setTarget(fragment.mView);
                            loadAnimation.f253Df.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void moveToState(int i, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != null) {
                int i2;
                int size = this.mAdded.size();
                for (i2 = 0; i2 < size; i2++) {
                    moveFragmentToExpectedState((Fragment) this.mAdded.get(i2));
                }
                size = this.mActive.size();
                for (i2 = 0; i2 < size; i2++) {
                    Fragment fragment = (Fragment) this.mActive.valueAt(i2);
                    if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                        moveFragmentToExpectedState(fragment);
                    }
                }
                startPendingDeferredFragments();
                if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 5) {
                    this.mHost.mo14005dm();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void startPendingDeferredFragments() {
        if (this.mActive != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mActive.size()) {
                    Fragment fragment = (Fragment) this.mActive.valueAt(i2);
                    if (fragment != null) {
                        performPendingDeferredStart(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void makeActive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i = this.mNextFragmentIndex;
            this.mNextFragmentIndex = i + 1;
            fragment.setIndex(i, this.mParent);
            if (this.mActive == null) {
                this.mActive = new SparseArray();
            }
            this.mActive.put(fragment.mIndex, fragment);
            if (DEBUG) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                new StringBuilder("Freeing fragment index ").append(fragment);
            }
            this.mActive.put(fragment.mIndex, null);
            fragment.initState();
        }
    }

    public final void addFragment(Fragment fragment, boolean z) {
        if (DEBUG) {
            new StringBuilder("add: ").append(fragment);
        }
        makeActive(fragment);
        if (!fragment.mDetached) {
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
            }
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            if (z) {
                moveToState(fragment);
            }
        }
    }

    public final void removeFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public final void hideFragment(Fragment fragment) {
        boolean z = true;
        if (DEBUG) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mHiddenChanged) {
                z = false;
            }
            fragment.mHiddenChanged = z;
        }
    }

    public final void showFragment(Fragment fragment) {
        boolean z = false;
        if (DEBUG) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (!fragment.mHiddenChanged) {
                z = true;
            }
            fragment.mHiddenChanged = z;
        }
    }

    public final void detachFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (DEBUG) {
                    new StringBuilder("remove from detach: ").append(fragment);
                }
                synchronized (this.mAdded) {
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public final void attachFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
                }
                if (DEBUG) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public final Fragment findFragmentById(int i) {
        int size;
        Fragment fragment;
        for (size = this.mAdded.size() - 1; size >= 0; size--) {
            fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        if (this.mActive != null) {
            for (size = this.mActive.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByTag(String str) {
        int size;
        Fragment fragment;
        if (str != null) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.mActive == null || str == null)) {
            for (size = this.mActive.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByWho(String str) {
        if (!(this.mActive == null || str == null)) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }

    public final boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    public final void enqueueAction(C0310g c0310g, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed && this.mHost != null) {
                if (this.mPendingActions == null) {
                    this.mPendingActions = new ArrayList();
                }
                this.mPendingActions.add(c0310g);
                scheduleCommit();
            } else if (z) {
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    private void scheduleCommit() {
        Object obj = 1;
        synchronized (this) {
            Object obj2 = (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) ? null : 1;
            if (this.mPendingActions == null || this.mPendingActions.size() != 1) {
                obj = null;
            }
            if (!(obj2 == null && obj == null)) {
                this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                this.mHost.mHandler.post(this.mExecCommit);
            }
        }
    }

    public final int allocBackStackIndex(C6185b c6185b) {
        int size;
        synchronized (this) {
            if (this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                if (this.mBackStackIndices == null) {
                    this.mBackStackIndices = new ArrayList();
                }
                size = this.mBackStackIndices.size();
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(size).append(" to ").append(c6185b);
                }
                this.mBackStackIndices.add(c6185b);
            } else {
                size = ((Integer) this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(size).append(" with ").append(c6185b);
                }
                this.mBackStackIndices.set(size, c6185b);
            }
        }
        return size;
    }

    public final void setBackStackIndex(int i, C6185b c6185b) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            int size = this.mBackStackIndices.size();
            if (i < size) {
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(i).append(" to ").append(c6185b);
                }
                this.mBackStackIndices.set(i, c6185b);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(i).append(" with ").append(c6185b);
                }
                this.mBackStackIndices.add(c6185b);
            }
        }
    }

    public final void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList();
                this.mTmpIsPop = new ArrayList();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction(null, null);
            } finally {
                this.mExecutingActions = false;
            }
        }
    }

    public final void execSingleAction(C0310g c0310g, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            if (c0310g.mo496a(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            doPendingDeferredStart();
            burpActive();
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final boolean execPendingActions() {
        ensureExecReady(true);
        boolean z = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        burpActive();
        return z;
    }

    private void executePostponedTransaction(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        if (this.mPostponedTransactions == null) {
            i = 0;
        } else {
            i = this.mPostponedTransactions.size();
        }
        int i2 = 0;
        int i3 = i;
        while (i2 < i3) {
            int indexOf;
            C6181i c6181i = (C6181i) this.mPostponedTransactions.get(i2);
            if (!(arrayList == null || c6181i.f1743Dk)) {
                indexOf = arrayList.indexOf(c6181i.f1744Dl);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    c6181i.mo13906do();
                    i2++;
                    i3 = i3;
                }
            }
            if (c6181i.f1745Dm == 0) {
                indexOf = 1;
            } else {
                indexOf = 0;
            }
            if (indexOf != 0 || (arrayList != null && c6181i.f1744Dl.mo13991a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i2);
                i2--;
                i3--;
                if (!(arrayList == null || c6181i.f1743Dk)) {
                    indexOf = arrayList.indexOf(c6181i.f1744Dl);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        c6181i.mo13906do();
                    }
                }
                c6181i.mo13905dn();
            }
            i2++;
            i3 = i3;
        }
    }

    private void removeRedundantOperationsAndExecute(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            executePostponedTransaction(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                int i4;
                if (((C6185b) arrayList.get(i)).f1766Cl) {
                    i3 = i;
                    i4 = i2;
                } else {
                    if (i2 != i) {
                        executeOpsTogether(arrayList, arrayList2, i2, i);
                    }
                    i3 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C6185b) arrayList.get(i3)).f1766Cl) {
                            i3++;
                        }
                    }
                    i4 = i3;
                    executeOpsTogether(arrayList, arrayList2, i, i4);
                    i3 = i4 - 1;
                }
                i = i3 + 1;
                i2 = i4;
            }
            if (i2 != size) {
                executeOpsTogether(arrayList, arrayList2, i2, size);
            }
        }
    }

    private void executeOpsTogether(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int postponePostponableTransactions;
        boolean z = ((C6185b) arrayList.get(i)).f1766Cl;
        if (this.mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            this.mTmpAddedFragments.clear();
        }
        this.mTmpAddedFragments.addAll(this.mAdded);
        int i3 = i;
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        while (i3 < i2) {
            Fragment b;
            boolean z3;
            C6185b c6185b = (C6185b) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                b = c6185b.mo13994b(this.mTmpAddedFragments, primaryNavigationFragment);
            } else {
                b = c6185b.mo13986a(this.mTmpAddedFragments, primaryNavigationFragment);
            }
            if (z2 || c6185b.f1757Cc) {
                z3 = true;
            } else {
                z3 = false;
            }
            i3++;
            primaryNavigationFragment = b;
            z2 = z3;
        }
        this.mTmpAddedFragments.clear();
        if (!z) {
            C0344n.m541a(this, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2, false);
        }
        FragmentManagerImpl.executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            C0402b c0402b = new C0402b();
            addAddedFragments(c0402b);
            postponePostponableTransactions = postponePostponableTransactions(arrayList, arrayList2, i, i2, c0402b);
            makeRemovedFragmentsInvisible(c0402b);
        } else {
            postponePostponableTransactions = i2;
        }
        if (postponePostponableTransactions != i && z) {
            C0344n.m541a(this, (ArrayList) arrayList, (ArrayList) arrayList2, i, postponePostponableTransactions, true);
            moveToState(this.mCurState, true);
        }
        while (i < i2) {
            C6185b c6185b2 = (C6185b) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && c6185b2.mIndex >= 0) {
                freeBackStackIndex(c6185b2.mIndex);
                c6185b2.mIndex = -1;
            }
            c6185b2.mo13995di();
            i++;
        }
        if (z2) {
            reportBackStackChanged();
        }
    }

    private void makeRemovedFragmentsInvisible(C0402b<Fragment> c0402b) {
        int size = c0402b.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) c0402b.f472Ld[i];
            if (!fragment.mAdded) {
                View view = fragment.getView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    private int postponePostponableTransactions(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0402b<Fragment> c0402b) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (i3 >= i) {
            boolean z;
            int i5;
            C6185b c6185b = (C6185b) arrayList.get(i3);
            boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
            for (int i6 = 0; i6 < c6185b.f1750BV.size(); i6++) {
                if (C6185b.m9889b((C0330a) c6185b.f1750BV.get(i6))) {
                    z = true;
                    break;
                }
            }
            z = false;
            z = z && !c6185b.mo13991a((ArrayList) arrayList, i3 + 1, i2);
            if (z) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }
                C0297c c6181i = new C6181i(c6185b, booleanValue);
                this.mPostponedTransactions.add(c6181i);
                c6185b.mo13987a(c6181i);
                if (booleanValue) {
                    c6185b.mo13996dj();
                } else {
                    c6185b.mo13998y(false);
                }
                int i7 = i4 - 1;
                if (i3 != i7) {
                    arrayList.remove(i3);
                    arrayList.add(i7, c6185b);
                }
                addAddedFragments(c0402b);
                i5 = i7;
            } else {
                i5 = i4;
            }
            i3--;
            i4 = i5;
        }
        return i4;
    }

    private void completeExecute(C6185b c6185b, boolean z, boolean z2, boolean z3) {
        if (z) {
            c6185b.mo13998y(z3);
        } else {
            c6185b.mo13996dj();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c6185b);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0344n.m541a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        if (this.mActive != null) {
            int size = this.mActive.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && c6185b.mo13993ar(fragment.mContainerId)) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private Fragment findFragmentUnder(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.mAdded.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = (Fragment) this.mAdded.get(indexOf);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return fragment2;
            }
        }
        return null;
    }

    private static void executeOps(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C6185b c6185b = (C6185b) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                c6185b.mo13992aq(-1);
                c6185b.mo13998y(i == i2 + -1);
            } else {
                c6185b.mo13992aq(1);
                c6185b.mo13996dj();
            }
            i++;
        }
    }

    private void addAddedFragments(C0402b<Fragment> c0402b) {
        if (this.mCurState > 0) {
            int min = Math.min(this.mCurState, 4);
            int size = this.mAdded.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment.mState < min) {
                    moveToState(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (!(fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded)) {
                        c0402b.add(fragment);
                    }
                }
            }
        }
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                ((C6181i) this.mPostponedTransactions.remove(0)).mo13905dn();
            }
        }
    }

    private void endAnimatingAwayFragments() {
        int i;
        if (this.mActive == null) {
            i = 0;
        } else {
            i = this.mActive.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            Fragment fragment = (Fragment) this.mActive.valueAt(i2);
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    moveToState(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean generateOpsForPendingActions(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.mPendingActions == null || this.mPendingActions.size() == 0) {
            } else {
                boolean z = false;
                for (int i = 0; i < this.mPendingActions.size(); i++) {
                    z |= ((C0310g) this.mPendingActions.get(i)).mo496a(arrayList, arrayList2);
                }
                this.mPendingActions.clear();
                this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                return z;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    /* Access modifiers changed, original: final */
    public final void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                this.mBackStackChangeListeners.get(i);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void addBackStackState(C6185b c6185b) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(c6185b);
    }

    /* Access modifiers changed, original: final */
    public final boolean popBackStackState(ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.mBackStack == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.mBackStack.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                C6185b c6185b;
                size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    c6185b = (C6185b) this.mBackStack.get(size2);
                    if ((str != null && str.equals(c6185b.mName)) || (i >= 0 && i == c6185b.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c6185b = (C6185b) this.mBackStack.get(size2);
                        if ((str == null || !str.equals(c6185b.mName)) && (i < 0 || i != c6185b.mIndex)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.mBackStack.size() - 1) {
                return false;
            }
            for (size2 = this.mBackStack.size() - 1; size2 > size; size2--) {
                arrayList.add(this.mBackStack.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* Access modifiers changed, original: final */
    public final C0337j retainNonConfig() {
        FragmentManagerImpl.setRetaining(this.mSavedNonConfig);
        return this.mSavedNonConfig;
    }

    private static void setRetaining(C0337j c0337j) {
        if (c0337j != null) {
            List<Fragment> list = c0337j.f290Dn;
            if (list != null) {
                for (Fragment fragment : list) {
                    fragment.mRetaining = true;
                }
            }
            List<C0337j> list2 = c0337j.f291Do;
            if (list2 != null) {
                for (C0337j retaining : list2) {
                    FragmentManagerImpl.setRetaining(retaining);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void saveNonConfig() {
        List list;
        List list2;
        List list3;
        if (this.mActive != null) {
            int i = 0;
            list = null;
            list2 = null;
            list3 = null;
            while (i < this.mActive.size()) {
                ArrayList arrayList;
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null) {
                    Object obj;
                    int i2;
                    if (fragment.mRetainInstance) {
                        if (list3 == null) {
                            list3 = new ArrayList();
                        }
                        list3.add(fragment);
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        if (DEBUG) {
                            new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        fragment.mChildFragmentManager.saveNonConfig();
                        obj = fragment.mChildFragmentManager.mSavedNonConfig;
                    } else {
                        C0337j obj2 = fragment.mChildNonConfig;
                    }
                    if (list2 == null && obj2 != null) {
                        list2 = new ArrayList(this.mActive.size());
                        for (i2 = 0; i2 < i; i2++) {
                            list2.add(null);
                        }
                    }
                    if (list2 != null) {
                        list2.add(obj2);
                    }
                    if (list == null && fragment.mViewModelStore != null) {
                        arrayList = new ArrayList(this.mActive.size());
                        for (i2 = 0; i2 < i; i2++) {
                            arrayList.add(null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(fragment.mViewModelStore);
                    }
                }
                i++;
                Object list4 = arrayList;
            }
        } else {
            list4 = null;
            list2 = null;
            list3 = null;
        }
        if (list3 == null && list2 == null && list4 == null) {
            this.mSavedNonConfig = null;
        } else {
            this.mSavedNonConfig = new C0337j(list3, list2, list4);
        }
    }

    /* Access modifiers changed, original: final */
    public final void saveFragmentViewState(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = new SparseArray();
            } else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (this.mStateBundle.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* Access modifiers changed, original: final */
    public final Parcelable saveAllState() {
        BackStackState[] backStackStateArr = null;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.mStateSaved = true;
        this.mSavedNonConfig = null;
        if (this.mActive == null || this.mActive.size() <= 0) {
            return null;
        }
        int size = this.mActive.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.mActive.valueAt(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, fragment.mTargetRequestCode);
                        }
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Saved state of ").append(fragment).append(": ").append(fragmentState.mSavedFragmentState);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (!z) {
            return null;
        }
        int[] iArr;
        int i2;
        i = this.mAdded.size();
        if (i > 0) {
            iArr = new int[i];
            for (i2 = 0; i2 < i; i2++) {
                iArr[i2] = ((Fragment) this.mAdded.get(i2)).mIndex;
                if (iArr[i2] < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (DEBUG) {
                    new StringBuilder("saveAllState: adding fragment #").append(i2).append(": ").append(this.mAdded.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        if (this.mBackStack != null) {
            i = this.mBackStack.size();
            if (i > 0) {
                backStackStateArr = new BackStackState[i];
                for (i2 = 0; i2 < i; i2++) {
                    backStackStateArr[i2] = new BackStackState((C6185b) this.mBackStack.get(i2));
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.mBackStack.get(i2));
                    }
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f259Dq = fragmentStateArr;
        fragmentManagerState.f260Dr = iArr;
        fragmentManagerState.f261Ds = backStackStateArr;
        if (this.mPrimaryNav != null) {
            fragmentManagerState.f262Dt = this.mPrimaryNav.mIndex;
        }
        fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
        saveNonConfig();
        return fragmentManagerState;
    }

    /* Access modifiers changed, original: final */
    public final void restoreAllState(Parcelable parcelable, C0337j c0337j) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f259Dq != null) {
                List list;
                int size;
                Fragment fragment;
                int i;
                List list2;
                int i2;
                List list3 = null;
                if (c0337j != null) {
                    List list4 = c0337j.f290Dn;
                    list = c0337j.f291Do;
                    List list5 = c0337j.f292Dp;
                    size = list4 != null ? list4.size() : 0;
                    for (int i3 = 0; i3 < size; i3++) {
                        fragment = (Fragment) list4.get(i3);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        i = 0;
                        while (i < fragmentManagerState.f259Dq.length && fragmentManagerState.f259Dq[i].mIndex != fragment.mIndex) {
                            i++;
                        }
                        if (i == fragmentManagerState.f259Dq.length) {
                            throwException(new IllegalStateException("Could not find active fragment with index " + fragment.mIndex));
                        }
                        FragmentState fragmentState = fragmentManagerState.f259Dq[i];
                        fragmentState.f263Du = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                    list2 = list5;
                    list3 = list;
                } else {
                    list2 = null;
                }
                this.mActive = new SparseArray(fragmentManagerState.f259Dq.length);
                int i4 = 0;
                while (true) {
                    i2 = i4;
                    if (i2 >= fragmentManagerState.f259Dq.length) {
                        break;
                    }
                    FragmentState fragmentState2 = fragmentManagerState.f259Dq[i2];
                    if (fragmentState2 != null) {
                        C0337j c0337j2;
                        if (list3 == null || i2 >= list3.size()) {
                            c0337j2 = null;
                        } else {
                            c0337j2 = (C0337j) list3.get(i2);
                        }
                        ViewModelStore viewModelStore = null;
                        if (list2 != null && i2 < list2.size()) {
                            viewModelStore = (ViewModelStore) list2.get(i2);
                        }
                        C6186h c6186h = this.mHost;
                        C0331f c0331f = this.mContainer;
                        Fragment fragment2 = this.mParent;
                        if (fragmentState2.f263Du == null) {
                            Context context = c6186h.mContext;
                            if (fragmentState2.mArguments != null) {
                                fragmentState2.mArguments.setClassLoader(context.getClassLoader());
                            }
                            if (c0331f != null) {
                                fragmentState2.f263Du = c0331f.instantiate(context, fragmentState2.mClassName, fragmentState2.mArguments);
                            } else {
                                fragmentState2.f263Du = Fragment.instantiate(context, fragmentState2.mClassName, fragmentState2.mArguments);
                            }
                            if (fragmentState2.mSavedFragmentState != null) {
                                fragmentState2.mSavedFragmentState.setClassLoader(context.getClassLoader());
                                fragmentState2.f263Du.mSavedFragmentState = fragmentState2.mSavedFragmentState;
                            }
                            fragmentState2.f263Du.setIndex(fragmentState2.mIndex, fragment2);
                            fragmentState2.f263Du.mFromLayout = fragmentState2.mFromLayout;
                            fragmentState2.f263Du.mRestored = true;
                            fragmentState2.f263Du.mFragmentId = fragmentState2.mFragmentId;
                            fragmentState2.f263Du.mContainerId = fragmentState2.mContainerId;
                            fragmentState2.f263Du.mTag = fragmentState2.mTag;
                            fragmentState2.f263Du.mRetainInstance = fragmentState2.mRetainInstance;
                            fragmentState2.f263Du.mDetached = fragmentState2.mDetached;
                            fragmentState2.f263Du.mHidden = fragmentState2.mHidden;
                            fragmentState2.f263Du.mFragmentManager = c6186h.mFragmentManager;
                            if (DEBUG) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.f263Du);
                            }
                        }
                        fragmentState2.f263Du.mChildNonConfig = c0337j2;
                        fragmentState2.f263Du.mViewModelStore = viewModelStore;
                        fragment = fragmentState2.f263Du;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: active #").append(i2).append(": ").append(fragment);
                        }
                        this.mActive.put(fragment.mIndex, fragment);
                        fragmentState2.f263Du = null;
                    }
                    i4 = i2 + 1;
                }
                if (c0337j != null) {
                    list = c0337j.f290Dn;
                    if (list != null) {
                        i = list.size();
                    } else {
                        i = 0;
                    }
                    for (i2 = 0; i2 < i; i2++) {
                        fragment = (Fragment) list.get(i2);
                        if (fragment.mTargetIndex >= 0) {
                            fragment.mTarget = (Fragment) this.mActive.get(fragment.mTargetIndex);
                            if (fragment.mTarget == null) {
                                new StringBuilder("Re-attaching retained fragment ").append(fragment).append(" target no longer exists: ").append(fragment.mTargetIndex);
                            }
                        }
                    }
                }
                this.mAdded.clear();
                if (fragmentManagerState.f260Dr != null) {
                    for (size = 0; size < fragmentManagerState.f260Dr.length; size++) {
                        fragment = (Fragment) this.mActive.get(fragmentManagerState.f260Dr[size]);
                        if (fragment == null) {
                            throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f260Dr[size]));
                        }
                        fragment.mAdded = true;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: added #").append(size).append(": ").append(fragment);
                        }
                        if (this.mAdded.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.mAdded) {
                            this.mAdded.add(fragment);
                        }
                    }
                }
                if (fragmentManagerState.f261Ds != null) {
                    this.mBackStack = new ArrayList(fragmentManagerState.f261Ds.length);
                    for (i4 = 0; i4 < fragmentManagerState.f261Ds.length; i4++) {
                        C6185b a = fragmentManagerState.f261Ds[i4].mo472a(this);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: back stack #").append(i4).append(" (index ").append(a.mIndex).append("): ").append(a);
                            PrintWriter printWriter = new PrintWriter(new C0406e(TAG));
                            a.mo13990a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(a);
                        if (a.mIndex >= 0) {
                            setBackStackIndex(a.mIndex, a);
                        }
                    }
                } else {
                    this.mBackStack = null;
                }
                if (fragmentManagerState.f262Dt >= 0) {
                    this.mPrimaryNav = (Fragment) this.mActive.get(fragmentManagerState.f262Dt);
                }
                this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
            }
        }
    }

    private void burpActive() {
        if (this.mActive != null) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                if (this.mActive.valueAt(size) == null) {
                    this.mActive.delete(this.mActive.keyAt(size));
                }
            }
        }
    }

    public final void attachController(C6186h c6186h, C0331f c0331f, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = c6186h;
        this.mContainer = c0331f;
        this.mParent = fragment;
    }

    public final void noteStateNotSaved() {
        this.mSavedNonConfig = null;
        this.mStateSaved = false;
        this.mStopped = false;
        int size = this.mAdded.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(1);
    }

    public final void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(2);
    }

    public final void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(4);
    }

    public final void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(5);
    }

    public final void dispatchPause() {
        dispatchStateChange(4);
    }

    public final void dispatchStop() {
        this.mStopped = true;
        dispatchStateChange(3);
    }

    public final void dispatchReallyStop() {
        dispatchStateChange(2);
    }

    public final void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public final void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            moveToState(i, false);
            execPendingActions();
        } finally {
            this.mExecutingActions = false;
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAdded.size()) {
                Fragment fragment = (Fragment) this.mAdded.get(i2);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final void dispatchLowMemory() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAdded.size()) {
                Fragment fragment = (Fragment) this.mAdded.get(i2);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        if (this.mCurState <= 0) {
            return false;
        }
        Fragment fragment;
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.mAdded.size()) {
            fragment = (Fragment) this.mAdded.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
            }
            i2++;
            z = z;
        }
        if (this.mCreatedMenus != null) {
            while (i < this.mCreatedMenus.size()) {
                fragment = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mCurState <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState <= 0) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState <= 0) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = (Fragment) this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (this.mActive.get(fragment.mIndex) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            this.mPrimaryNav = fragment;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    public final void registerFragmentLifecycleCallbacks(C0334b c0334b, boolean z) {
        this.mLifecycleCallbacks.add(new C0415j(c0334b, Boolean.valueOf(z)));
    }

    public final void unregisterFragmentLifecycleCallbacks(C0334b c0334b) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            for (int i = 0; i < size; i++) {
                if (((C0415j) this.mLifecycleCallbacks.get(i)).first == c0334b) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentPreAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            C0336i fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            C0415j c0415j = (C0415j) it.next();
            if (z) {
                ((Boolean) c0415j.second).booleanValue();
            }
        }
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int transitToStyleIndex(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0309f.f258Di);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mHost.mContext, string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string2 != null) {
            findFragmentById = findFragmentByTag(string2);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = findFragmentById(id);
        }
        if (DEBUG) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(string).append(" existing=").append(findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = this.mContainer.instantiate(context, string, null);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.mHost;
            instantiate.onInflate(this.mHost.mContext, attributeSet, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            findFragmentById.mInLayout = true;
            findFragmentById.mHost = this.mHost;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(this.mHost.mContext, attributeSet, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        }
        if (this.mCurState > 0 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* Access modifiers changed, original: final */
    public final Factory2 getLayoutInflaterFactory() {
        return this;
    }
}
