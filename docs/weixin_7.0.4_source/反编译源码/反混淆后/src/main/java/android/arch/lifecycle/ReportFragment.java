package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.Lifecycle.Event;
import android.os.Bundle;

public class ReportFragment extends Fragment {
    /* renamed from: cO */
    private ActivityInitializationListener f31cO;

    interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static void injectIfNeededIn(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ActivityInitializationListener activityInitializationListener = this.f31cO;
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
        m343b(Event.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        ActivityInitializationListener activityInitializationListener = this.f31cO;
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
        m343b(Event.ON_START);
    }

    public void onResume() {
        super.onResume();
        ActivityInitializationListener activityInitializationListener = this.f31cO;
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
        m343b(Event.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        m343b(Event.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        m343b(Event.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        m343b(Event.ON_DESTROY);
        this.f31cO = null;
    }

    /* renamed from: b */
    private void m343b(Event event) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
            }
        }
    }
}
