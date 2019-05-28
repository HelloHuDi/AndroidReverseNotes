package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.h.a;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.Locale;

public abstract class MMFragment extends FragmentActivitySupport implements OnAttachStateChangeListener, a {
    protected static final int DEFAULT_TOAST_TIME = 3000;
    public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
    public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
    private static final String TAG = "MicroMsg.MMFragment";
    private static final String TAG2 = "MicroMsg.INIT";
    String className;
    protected q mController = new q() {
        /* Access modifiers changed, original: protected|final */
        public final int getLayoutId() {
            AppMethodBeat.i(106040);
            int layoutId = MMFragment.this.getLayoutId();
            AppMethodBeat.o(106040);
            return layoutId;
        }

        /* Access modifiers changed, original: protected|final */
        public final void dealContentView(View view) {
            AppMethodBeat.i(106041);
            MMFragment.this.dealContentView(view);
            AppMethodBeat.o(106041);
        }

        /* Access modifiers changed, original: protected|final */
        public final String bJj() {
            AppMethodBeat.i(106042);
            String identityString = MMFragment.this.getIdentityString();
            AppMethodBeat.o(106042);
            return identityString;
        }

        /* Access modifiers changed, original: protected|final */
        public final View getLayoutView() {
            AppMethodBeat.i(106043);
            View layoutView = MMFragment.this.getLayoutView();
            AppMethodBeat.o(106043);
            return layoutView;
        }

        public final void onKeyboardStateChanged() {
            AppMethodBeat.i(106044);
            MMFragment.this.onKeyboardStateChanged();
            AppMethodBeat.o(106044);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCreateBeforeSetContentView() {
            AppMethodBeat.i(106045);
            MMFragment.this.onCreateBeforeSetContentView();
            AppMethodBeat.o(106045);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getClassName() {
            AppMethodBeat.i(106046);
            String name = MMFragment.this.getClass().getName();
            AppMethodBeat.o(106046);
            return name;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dxT() {
            return false;
        }

        public final boolean noActionBar() {
            AppMethodBeat.i(106047);
            boolean noActionBar = MMFragment.this.noActionBar();
            AppMethodBeat.o(106047);
            return noActionBar;
        }
    };
    private boolean mCurVisible = false;
    private a mListener;
    protected AppCompatActivity mParent;
    private MMFragment mParentFragment;
    private boolean mParentVisible = false;
    private SwipeBackLayout mSwipeBackLayout;

    public abstract int getLayoutId();

    public MMFragment(boolean z) {
        super(z);
    }

    public void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public static Locale initLanguage(Context context) {
        return q.initLanguage(context);
    }

    /* Access modifiers changed, original: protected */
    public void onCreateBeforeSetContentView() {
    }

    public void setActivityController(q qVar) {
        if (qVar != null) {
            this.mController = qVar;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.a(thisActivity().getBaseContext(), (AppCompatActivity) thisActivity());
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (isSupportNavigationSwipeBack()) {
            initSwipeBack();
        }
        getView().addOnAttachStateChangeListener(this);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSupportCustomActionBar() {
        return isSupportNavigationSwipeBack();
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    public boolean noActionBar() {
        return false;
    }

    public void onSwipeBack() {
    }

    public void onDragBegin() {
    }

    public void onCancelDrag() {
    }

    private void initSwipeBack() {
        View contentView = getContentView();
        ViewGroup viewGroup = (ViewGroup) contentView.getParent();
        if (viewGroup != null) {
            this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(thisActivity()).inflate(R.layout.az9, viewGroup, false);
            viewGroup.removeView(contentView);
            viewGroup.addView(this.mSwipeBackLayout);
        } else {
            this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(thisActivity()).inflate(R.layout.az9, null);
        }
        this.mSwipeBackLayout.addView(contentView);
        this.mSwipeBackLayout.setContentView(contentView);
        this.mSwipeBackLayout.qX(true);
        this.mSwipeBackLayout.setSwipeGestureDelegate(new SwipeBackLayout.a() {
            public final void onSwipeBack() {
                AppMethodBeat.i(106048);
                MMFragment.this.onSwipeBack();
                AppMethodBeat.o(106048);
            }

            public final void onCancel() {
                AppMethodBeat.i(106049);
                MMFragment.this.onCancelDrag();
                AppMethodBeat.o(106049);
            }

            public final void onDrag() {
                AppMethodBeat.i(106050);
                MMFragment.this.onDragBegin();
                AppMethodBeat.o(106050);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return getContentView();
    }

    /* Access modifiers changed, original: protected */
    public void dealContentView(View view) {
    }

    public int keyboardState() {
        return this.mController.ymc;
    }

    public void onKeyboardStateChanged() {
    }

    public void setParent(AppCompatActivity appCompatActivity) {
        this.mParent = appCompatActivity;
    }

    public final Activity getContext() {
        return this.mController.ylL;
    }

    public q getController() {
        return this.mController;
    }

    public boolean isScreenEnable() {
        return this.mController.ylz;
    }

    public void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void setBodyView(int i) {
        q qVar = this.mController;
        if (qVar.yly == null) {
            qVar.yly = (FrameLayout) qVar.contentView.findViewById(R.id.d88);
        }
        if (qVar.ylw != null) {
            qVar.yly.removeView(qVar.ylw);
        }
        qVar.yly.removeView(qVar.ylv);
        qVar.ylv = ((LayoutInflater) qVar.mContext.getSystemService("layout_inflater")).inflate(i, null);
        qVar.yly.addView(qVar.ylv, 0, new LayoutParams(-1, -1));
        if (qVar.ylw != null) {
            qVar.yly.addView(qVar.ylw, qVar.yly.getChildCount(), new LayoutParams(-1, b.b(qVar.mContext, 47.0f)));
        }
        qVar.yly.invalidate();
    }

    public View getBodyView() {
        return this.mController.ylv;
    }

    /* Access modifiers changed, original: protected|final */
    public final View getContentView() {
        return this.mController.contentView;
    }

    /* Access modifiers changed, original: protected */
    public int getForceOrientation() {
        return -1;
    }

    public boolean getLandscapeMode() {
        return this.mController.getLandscapeMode();
    }

    public int getStreamVolume(int i) {
        return this.mController.fZh.getStreamVolume(i);
    }

    public int getStreamMaxVolume(int i) {
        return this.mController.fZh.getStreamMaxVolume(i);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        ac.bL(1, this.className);
        super.onResume();
        ab.v(TAG2, "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        ab.v(TAG2, "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - currentTimeMillis));
        onParentVisibilityChanged(true);
    }

    public void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mController.hq(getActivity());
    }

    public void activateBroadcast(boolean z) {
        this.mController.activateBroadcast(z);
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        ac.bL(2, this.className);
        super.onPause();
        this.mController.onPause();
        ab.v(TAG2, "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - currentTimeMillis));
        onParentVisibilityChanged(false);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!this.mController.onCreateOptionsMenu(menu)) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public boolean callBackMenu() {
        return this.mController.callBackMenu();
    }

    public String getIdentityString() {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public View getLayoutView() {
        return null;
    }

    @Deprecated
    public void setToTop(OnClickListener onClickListener) {
    }

    @Deprecated
    public void setTitleClickAction(SimpleOnGestureListener simpleOnGestureListener) {
    }

    @Deprecated
    public void setRedDotVisibilty(int i) {
    }

    public void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public void fullScreenWithTitleBar(boolean z) {
        q qVar = this.mController;
        if (z) {
            qVar.ylL.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            qVar.ylL.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    public void setTitleVisibility(int i) {
        this.mController.setTitleVisibility(i);
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public void updateDescription(String str) {
        this.mController.updateDescription(str);
    }

    public void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    public void setMMSubTitleColor(int i) {
    }

    public void setTitleLogo(int i, int i2) {
        this.mController.setTitleLogo(i, i2);
    }

    public void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public void enableOptionMenu(boolean z) {
        this.mController.d(true, -1, z);
    }

    public void enableOptionMenu(int i, boolean z) {
        this.mController.d(false, i, z);
    }

    public void showOptionMenu(boolean z) {
        this.mController.e(true, -1, z);
    }

    public void showOptionMenu(int i, boolean z) {
        this.mController.e(false, i, z);
    }

    public void addSearchMenu(boolean z, o oVar) {
        this.mController.addSearchMenu(z, oVar);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, q.b.NORMAL);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, q.b bVar) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener, onLongClickListener, bVar);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener, int i3) {
        q qVar = this.mController;
        String str = "";
        q.b bVar = q.b.NORMAL;
        q.a aVar = new q.a();
        aVar.yfi = i;
        aVar.ymp = i3;
        aVar.yfj = i2;
        aVar.text = str;
        aVar.gzB = onMenuItemClickListener;
        aVar.mlV = null;
        aVar.ymr = bVar;
        aVar.yms = false;
        if (aVar.yfj == R.drawable.uu && bo.isNullOrNil(str)) {
            aVar.text = qVar.mContext.getString(R.string.rn);
        }
        qVar.Nf(aVar.yfi);
        qVar.yfa.add(aVar);
        qVar.supportInvalidateOptionsMenu();
    }

    public void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, str, i2, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, int i2, int i3, boolean z, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, z, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener, onLongClickListener);
    }

    public void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener, onLongClickListener);
    }

    public void updateOptionMenuIcon(int i, int i2) {
        this.mController.updateOptionMenuIcon(i, i2);
    }

    public void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    public void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.updateOptionMenuListener(i, onMenuItemClickListener, onLongClickListener);
    }

    public q.a findMenuInfo(int i) {
        return this.mController.Ng(i);
    }

    public void updateOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        q qVar = this.mController;
        qVar.updateOptionMenuText(i, qVar.ylL.getString(i2));
        this.mController.updateOptionMenuIcon(i, i3);
        this.mController.updateOptionMenuListener(i, onMenuItemClickListener, null);
        this.mController.a(this.mController.Ng(i));
    }

    public void updateOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener, int i3) {
        this.mController.updateOptionMenuIcon(i, i2);
        this.mController.updateOptionMenuListener(i, onMenuItemClickListener, null);
        q qVar = this.mController;
        q.a Ng = qVar.Ng(i);
        if (!(Ng == null || Ng.yfj == i2)) {
            Ng.yfj = i2;
            Ng.ymp = i3;
            qVar.supportInvalidateOptionsMenu();
        }
        this.mController.a(this.mController.Ng(i));
    }

    public void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public void removeAllOptionMenu() {
        this.mController.removeAllOptionMenu();
    }

    public boolean removeOptionMenu(int i) {
        return this.mController.removeOptionMenu(i);
    }

    public CharSequence getMMTitle() {
        return this.mController.getMMTitle();
    }

    public void hideTitleView() {
        this.mController.hideTitleView();
    }

    public void showTitleView() {
        this.mController.showTitleView();
    }

    public boolean isTitleShowing() {
        return this.mController.isTitleShowing();
    }

    public int getTitleLocation() {
        return this.mController.getTitleLocation();
    }

    public void setTitlePhoneIconVisibility(int i) {
        q qVar = this.mController;
        qVar.ylK = i == 0;
        qVar.dym();
    }

    public void setTitleMuteIconVisibility(int i) {
        this.mController.setTitleMuteIconVisibility(i);
    }

    public boolean hideVKB() {
        return this.mController.hideVKB();
    }

    public boolean hideVKB(View view) {
        return this.mController.hideVKB(view);
    }

    public void showVKB() {
        q.showVKB(this.mController.ylL);
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void finish() {
        super.finish();
        int intExtra = thisActivity().getIntent().getIntExtra(FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int intExtra2 = thisActivity().getIntent().getIntExtra(FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (intExtra != -1) {
            getContext().overridePendingTransition(intExtra, intExtra2);
        }
    }

    public void startActivity(Intent intent) {
        startActivityReal(intent);
    }

    public void startActivityReal(Intent intent) {
        super.startActivity(intent);
    }

    public Resources thisResources() {
        FragmentActivity activity = super.getActivity();
        if (activity == null) {
            return ah.getContext().getResources();
        }
        return activity.getResources();
    }

    public FragmentActivity thisActivity() {
        if (this.mController.ylL != null) {
            return this.mController.ylL;
        }
        return super.getActivity();
    }

    public Resources getMMResources() {
        return thisActivity().getResources();
    }

    public String getMMString(int i) {
        return thisActivity().getString(i);
    }

    public String getMMString(int i, Object... objArr) {
        return thisActivity().getString(i, objArr);
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        if (!this.mController.interceptSupportInvalidateOptionsMenu()) {
            return false;
        }
        this.mController.supportInvalidateOptionsMenu();
        return true;
    }

    public void onStart() {
        this.mController.onStart();
        super.onStart();
        onParentVisibilityChanged(true);
    }

    public void onStop() {
        super.onStop();
        onParentVisibilityChanged(false);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        filterAndNotifyVisibility(!z, z);
    }

    public void setUserVisibleHint(boolean z) {
        ab.i(TAG, "[setUserVisibleHint] isVisibleToUser:%s name:%s", Boolean.valueOf(z), getClass().getName());
        super.setUserVisibleHint(z);
        filterAndNotifyVisibility(z);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof MMFragment)) {
            this.mParentFragment = (MMFragment) parentFragment;
            this.mParentFragment.setOnVisibilityChangedListener(this);
        }
        filterAndNotifyVisibility(true);
    }

    public void onDetach() {
        if (this.mParentFragment != null) {
            this.mParentFragment.setOnVisibilityChangedListener(null);
        }
        super.onDetach();
        filterAndNotifyVisibility(false);
        this.mParentFragment = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        getView().removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        filterAndNotifyVisibility(true);
    }

    public void onViewDetachedFromWindow(View view) {
        filterAndNotifyVisibility(false);
    }

    public void onFragmentVisibilityChanged(boolean z) {
        filterAndNotifyVisibility(z);
    }

    /* Access modifiers changed, original: protected */
    public void onParentVisibilityChanged(boolean z) {
        this.mParentVisible = z;
        filterAndNotifyVisibility(z);
    }

    public void setOnVisibilityChangedListener(a aVar) {
        this.mListener = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(boolean z) {
        if (this.mListener != null) {
            this.mListener.onFragmentVisibilityChanged(z);
        }
        int i = -1;
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(getClass().getName())) {
            i = arguments.getInt(getClass().getName());
        }
        ab.i(TAG, "[onVisibilityChanged] visible:%s name:%s id:%s", Boolean.valueOf(z), getClass().getName(), Integer.valueOf(i));
        kx kxVar = new kx();
        kxVar.cGP.name = getClass().getName();
        kxVar.cGP.id = i;
        kxVar.cGP.aIB = z;
        com.tencent.mm.sdk.b.a.xxA.m(kxVar);
    }

    public boolean isFragmentVisible() {
        return this.mCurVisible;
    }

    private void filterAndNotifyVisibility(boolean z) {
        filterAndNotifyVisibility(z, false);
    }

    private void filterAndNotifyVisibility(boolean z, boolean z2) {
        if (z != this.mCurVisible) {
            boolean z3;
            boolean isFragmentVisible = this.mParentFragment == null ? this.mParentVisible : this.mParentFragment.isFragmentVisible();
            boolean isVisible = super.isVisible();
            boolean userVisibleHint = getUserVisibleHint();
            if (isFragmentVisible && isVisible && userVisibleHint && !z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            ab.i(TAG, "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", Boolean.valueOf(z3), Boolean.valueOf(isFragmentVisible), Boolean.valueOf(isVisible), Boolean.valueOf(userVisibleHint), getClass().getName());
            if (z3 != this.mCurVisible) {
                this.mCurVisible = z3;
                onVisibilityChanged(this.mCurVisible);
            }
        }
    }

    public final boolean isSupportNavigationSwipeBack() {
        if (d.iW(19) && com.tencent.mm.compatible.i.b.Ml()) {
            return supportNavigationSwipeBack();
        }
        return false;
    }
}
