package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.a.c;
import android.support.v4.f.n;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.tencent.mars.cdn.CdnLogic;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends d implements ViewModelStoreOwner, android.support.v4.app.a.a, c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final g mFragments = new g(new a());
    final Handler mHandler = new Handler() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (FragmentActivity.this.mStopped) {
                        FragmentActivity.this.doReallyStop(false);
                        return;
                    }
                    return;
                case 2:
                    FragmentActivity.this.onResumeFragments();
                    FragmentActivity.this.mFragments.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    r mLoaderManager;
    int mNextCandidateRequestIndex;
    n<String> mPendingFragmentActivityResults;
    boolean mReallyStopped = true;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped = true;
    private ViewModelStore mViewModelStore;

    static final class b {
        Object CU;
        ViewModelStore CV;
        j CW;

        b() {
        }
    }

    class a extends h<FragmentActivity> {
        public a() {
            super(FragmentActivity.this);
        }

        public final void a(String str, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, null, printWriter, strArr);
        }

        public final boolean dl() {
            return !FragmentActivity.this.isFinishing();
        }

        public final LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public final void dm() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        public final void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        public final void a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            FragmentActivity.this.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        public final void a(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        public final boolean H(String str) {
            return a.a(FragmentActivity.this, str);
        }

        public final boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        public final int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public final void onAttachFragment(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public final View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        public final boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public final /* bridge */ /* synthetic */ Object onGetHost() {
            return FragmentActivity.this;
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.aH(i4);
            this.mPendingFragmentActivityResults.delete(i4);
            if (str != null) {
                Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    findFragmentByWho.onActivityResult(CdnLogic.kBizGeneric & i, i2, intent);
                    return;
                }
                return;
            }
            return;
        }
        android.support.v4.app.a.b dd = a.dd();
        if (dd == null || !dd.df()) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
        boolean isStateSaved = fragmentManagerImpl.isStateSaved();
        if (isStateSaved && VERSION.SDK_INT <= 25) {
            return;
        }
        if (isStateSaved || !fragmentManagerImpl.popBackStackImmediate()) {
            super.onBackPressed();
        }
    }

    public void supportFinishAfterTransition() {
        a.c(this);
    }

    public void setEnterSharedElementCallback(ac acVar) {
        a.a((Activity) this, acVar);
    }

    public void setExitSharedElementCallback(ac acVar) {
        a.b(this, acVar);
    }

    public void supportPostponeEnterTransition() {
        a.d(this);
    }

    public void supportStartPostponedEnterTransition() {
        a.e(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.noteStateNotSaved();
        this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mViewModelStore == null) {
            this.mViewModelStore = new ViewModelStore();
        }
        return this.mViewModelStore;
    }

    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        g gVar = this.mFragments;
        gVar.mHost.mFragmentManager.attachController(gVar.mHost, gVar.mHost, null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.mViewModelStore = bVar.CV;
        }
        if (bundle != null) {
            j jVar;
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            g gVar2 = this.mFragments;
            if (bVar != null) {
                jVar = bVar.CW;
            } else {
                jVar = null;
            }
            gVar2.mHost.mFragmentManager.restoreAllState(parcelable, jVar);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                    this.mPendingFragmentActivityResults = new n(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.put(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new n();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        g gVar = this.mFragments;
        return onCreatePanelMenu | gVar.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, getMenuInflater());
    }

    /* Access modifiers changed, original: final */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mHost.mFragmentManager.onCreateView(view, str, context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        if (!(this.mViewModelStore == null || this.mRetaining)) {
            this.mViewModelStore.clear();
        }
        this.mFragments.mHost.mFragmentManager.dispatchDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.mHost.mFragmentManager.dispatchPause();
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    /* Access modifiers changed, original: protected */
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.execPendingActions();
    }

    /* Access modifiers changed, original: protected */
    public void onResumeFragments() {
        this.mFragments.mHost.mFragmentManager.dispatchResume();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    /* Access modifiers changed, original: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        j retainNonConfig = this.mFragments.mHost.mFragmentManager.retainNonConfig();
        if (retainNonConfig == null && this.mViewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        Object bVar = new b();
        bVar.CU = onRetainCustomNonConfigurationInstance;
        bVar.CV = this.mViewModelStore;
        bVar.CW = retainNonConfig;
        return bVar;
    }

    /* Access modifiers changed, original: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        Parcelable saveAllState = this.mFragments.mHost.mFragmentManager.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable(FRAGMENTS_TAG, saveAllState);
        }
        if (this.mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.size()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mPendingFragmentActivityResults.size()) {
                    iArr[i2] = this.mPendingFragmentActivityResults.keyAt(i2);
                    strArr[i2] = (String) this.mPendingFragmentActivityResults.valueAt(i2);
                    i = i2 + 1;
                } else {
                    bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
                    bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
                    return;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mHost.mFragmentManager.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragments.mHost.mFragmentManager.dispatchStart();
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.mHost.mFragmentManager.dispatchStop();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        return bVar != null ? bVar.CU : null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        if (this.mLoaderManager != null) {
            this.mLoaderManager.dump(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.mHost.mFragmentManager.dump(str, fileDescriptor, printWriter, strArr);
    }

    /* Access modifiers changed, original: 0000 */
    public void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void onReallyStop() {
        this.mFragments.mHost.mFragmentManager.dispatchReallyStop();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public i getSupportFragmentManager() {
        return this.mFragments.mHost.mFragmentManager;
    }

    public r getSupportLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mLoaderManager = new s(this, getViewModelStore());
        return this.mLoaderManager;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            c.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            c.checkForValidRequestCode(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.noteStateNotSaved();
        int i2 = (i >> 16) & CdnLogic.kBizGeneric;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.mPendingFragmentActivityResults.aH(i3);
            this.mPendingFragmentActivityResults.delete(i3);
            if (str != null) {
                Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    findFragmentByWho.onRequestPermissionsResult(i & CdnLogic.kBizGeneric, strArr, iArr);
                }
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            c.checkForValidRequestCode(i);
            a.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (CdnLogic.kBizGeneric & i), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        if (i == -1) {
            try {
                a.a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            c.checkForValidRequestCode(i);
            a.a(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (CdnLogic.kBizGeneric & i), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.size() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (true) {
            n nVar = this.mPendingFragmentActivityResults;
            int i = this.mNextCandidateRequestIndex;
            if (nVar.Lj) {
                nVar.gc();
            }
            if (android.support.v4.f.c.a(nVar.Ly, nVar.mSize, i) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
            } else {
                int i2 = this.mNextCandidateRequestIndex;
                this.mPendingFragmentActivityResults.put(i2, fragment.mWho);
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
                return i2;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            a.a(this, strArr, i);
            return;
        }
        c.checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            a.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (CdnLogic.kBizGeneric & i));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), State.CREATED));
    }

    private static boolean markState(i iVar, State state) {
        boolean z = false;
        for (Fragment fragment : iVar.getFragments()) {
            if (fragment != null) {
                boolean markState;
                if (fragment.getLifecycle().getCurrentState().isAtLeast(State.STARTED)) {
                    fragment.mLifecycleRegistry.markState(state);
                    z = true;
                }
                i peekChildFragmentManager = fragment.peekChildFragmentManager();
                if (peekChildFragmentManager != null) {
                    markState = markState(peekChildFragmentManager, state) | z;
                } else {
                    markState = z;
                }
                z = markState;
            }
        }
        return z;
    }
}
