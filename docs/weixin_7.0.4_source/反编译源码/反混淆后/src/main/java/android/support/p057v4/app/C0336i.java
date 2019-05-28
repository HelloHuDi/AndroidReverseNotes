package android.support.p057v4.app;

import android.os.Bundle;
import android.support.p057v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: android.support.v4.app.i */
public abstract class C0336i {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* renamed from: android.support.v4.app.i$a */
    public interface C0333a {
    }

    /* renamed from: android.support.v4.app.i$b */
    public static abstract class C0334b {
    }

    /* renamed from: android.support.v4.app.i$c */
    public interface C0335c {
    }

    public abstract void addOnBackStackChangedListener(C0335c c0335c);

    public abstract C0338m beginTransaction();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i);

    public abstract Fragment findFragmentByTag(String str);

    public abstract C0333a getBackStackEntryAt(int i);

    public abstract int getBackStackEntryCount();

    public abstract Fragment getFragment(Bundle bundle, String str);

    public abstract List<Fragment> getFragments();

    public abstract Fragment getPrimaryNavigationFragment();

    public abstract boolean isDestroyed();

    public abstract boolean isStateSaved();

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int i2);

    public abstract void popBackStack(String str, int i);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int i, int i2);

    public abstract boolean popBackStackImmediate(String str, int i);

    public abstract void putFragment(Bundle bundle, String str, Fragment fragment);

    public abstract void registerFragmentLifecycleCallbacks(C0334b c0334b, boolean z);

    public abstract void removeOnBackStackChangedListener(C0335c c0335c);

    public abstract SavedState saveFragmentInstanceState(Fragment fragment);

    public abstract void unregisterFragmentLifecycleCallbacks(C0334b c0334b);

    @Deprecated
    public C0338m openTransaction() {
        return beginTransaction();
    }

    public static void enableDebugLogging(boolean z) {
        FragmentManagerImpl.DEBUG = z;
    }
}
