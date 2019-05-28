package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class i {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    public interface a {
    }

    public static abstract class b {
    }

    public interface c {
    }

    public abstract void addOnBackStackChangedListener(c cVar);

    public abstract m beginTransaction();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i);

    public abstract Fragment findFragmentByTag(String str);

    public abstract a getBackStackEntryAt(int i);

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

    public abstract void registerFragmentLifecycleCallbacks(b bVar, boolean z);

    public abstract void removeOnBackStackChangedListener(c cVar);

    public abstract SavedState saveFragmentInstanceState(Fragment fragment);

    public abstract void unregisterFragmentLifecycleCallbacks(b bVar);

    @Deprecated
    public m openTransaction() {
        return beginTransaction();
    }

    public static void enableDebugLogging(boolean z) {
        FragmentManagerImpl.DEBUG = z;
    }
}
