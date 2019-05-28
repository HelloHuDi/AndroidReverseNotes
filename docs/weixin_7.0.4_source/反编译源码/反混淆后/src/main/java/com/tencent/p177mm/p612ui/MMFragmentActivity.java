package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.C0338m;
import android.support.p057v4.app.Fragment;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C1431w;
import com.tencent.p177mm.compatible.p223i.C1436b;
import com.tencent.p177mm.compatible.util.C1441a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p179ac.C1185a;
import com.tencent.p177mm.p179ac.C1188b.C1186a;
import com.tencent.p177mm.p179ac.C1188b.C1187b;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.tools.C5587h;
import com.tencent.p177mm.p612ui.widget.C5666h;
import com.tencent.p177mm.p612ui.widget.C5666h.C5665a;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout.C5628a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p635a.C5676a;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.MMFragmentActivity */
public class MMFragmentActivity extends AppCompatActivity implements C5628a, C5665a, C5685b {
    public static final long ANIMATION_DURATION = 320;
    public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
    private static final String TAG = "MicroMsg.MMFragmentActivity";
    public static final float WIDTH_SETTLE_FACT = 3.5f;
    String className;
    private C5206a mActivityAnimStyle = new C5206a();
    private View mContentViewForSwipeBack = null;
    private boolean mIsPaused;
    private C5676a mLifeCycleKeeper = new C5676a();
    private C5207b mNfcFilterHelper;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean mSwiping;
    ArrayList<WeakReference<MMFragment>> record = new ArrayList();

    /* renamed from: com.tencent.mm.ui.MMFragmentActivity$a */
    public static class C5206a {
        public static int ync;
        public static int ynd;
        public static int yne;
        public static int ynf;
        public static int yng = ync;
        public static int ynh = ynd;
        public static int yni = yne;
        public static int ynj = ynf;

        public static void dyv() {
            int i = C25738R.anim.f8293s;
            AppMethodBeat.m2504i(106051);
            C1431w c1431w = C1427q.eth;
            boolean Md = C1431w.m3054Md();
            C4990ab.m7416i(MMFragmentActivity.TAG, "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(Md)));
            if (Md) {
                int Ml = C1436b.m3061Ml() & C1443d.m3068iW(19);
                C4990ab.m7416i(MMFragmentActivity.TAG, "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(Ml)));
                ync = Ml != 0 ? C25738R.anim.f8403df : C25738R.anim.f8362c4;
                ynd = Ml != 0 ? C25738R.anim.f8402dc : C25738R.anim.f8293s;
                if (Ml != 0) {
                    i = C25738R.anim.f8401db;
                }
                yne = i;
                ynf = Ml != 0 ? C25738R.anim.f8404dg : C25738R.anim.f8367c9;
                yng = ync;
                ynh = ynd;
                yni = yne;
                ynj = ynf;
                AppMethodBeat.m2505o(106051);
                return;
            }
            AppMethodBeat.m2505o(106051);
        }

        static {
            int i;
            int i2 = C25738R.anim.f8293s;
            AppMethodBeat.m2504i(106052);
            int Ml = C1436b.m3061Ml() & C1443d.m3068iW(19);
            ync = Ml != 0 ? C25738R.anim.f8403df : C25738R.anim.f8362c4;
            ynd = Ml != 0 ? C25738R.anim.f8402dc : C25738R.anim.f8293s;
            if (Ml != 0) {
                i2 = C25738R.anim.f8401db;
            }
            yne = i2;
            if (Ml != 0) {
                i = C25738R.anim.f8404dg;
            } else {
                i = C25738R.anim.f8367c9;
            }
            ynf = i;
            AppMethodBeat.m2505o(106052);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMFragmentActivity$b */
    final class C5207b {
        NfcAdapter ynk;
        PendingIntent ynl;
        IntentFilter[] ynm;
        String[][] ynn;

        private C5207b() {
            this.ynk = null;
        }

        /* synthetic */ C5207b(MMFragmentActivity mMFragmentActivity, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void init() {
            AppMethodBeat.m2504i(106053);
            Intent intent = new Intent();
            intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
            intent.addFlags(536870912);
            this.ynl = PendingIntent.getActivity(MMFragmentActivity.this, 0, intent, 0);
            try {
                new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
                new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataScheme("vnd.android.nfc");
                this.ynm = new IntentFilter[]{r0, r1, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
                String[][] strArr = new String[1][];
                strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName()};
                this.ynn = strArr;
                AppMethodBeat.m2505o(106053);
            } catch (MalformedMimeTypeException e) {
                RuntimeException runtimeException = new RuntimeException("fail", e);
                AppMethodBeat.m2505o(106053);
                throw runtimeException;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MMFragmentActivity() {
        AppMethodBeat.m2504i(106054);
        AppMethodBeat.m2505o(106054);
    }

    public void keep(C5684a c5684a) {
        AppMethodBeat.m2504i(106055);
        this.mLifeCycleKeeper.zWX.keep(c5684a);
        AppMethodBeat.m2505o(106055);
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    /* Access modifiers changed, original: protected */
    public C5685b theCreate() {
        return this.mLifeCycleKeeper.zWX;
    }

    /* Access modifiers changed, original: protected */
    public C5685b theResume() {
        return this.mLifeCycleKeeper.zWY;
    }

    /* Access modifiers changed, original: protected */
    public C5685b theStart() {
        return this.mLifeCycleKeeper.zWY;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(106056);
        this.className = getClass().getName();
        C5219ac.m7928bL(3, this.className);
        super.onCreate(bundle);
        this.mNfcFilterHelper = new C5207b(this, (byte) 0);
        C5207b c5207b = this.mNfcFilterHelper;
        try {
            c5207b.ynk = NfcAdapter.getDefaultAdapter(MMFragmentActivity.this);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
        }
        c5207b.init();
        C4990ab.m7417i(TAG, "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), C5046bo.m7559gU(this), appendMemLog());
        AppMethodBeat.m2505o(106056);
    }

    public String appendMemLog() {
        AppMethodBeat.m2504i(106057);
        long totalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        String format = String.format("Runtime: [%s:%s:%s] Native: [%s:%s:%s] ", new Object[]{Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()), Long.valueOf(totalMemory), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize())});
        AppMethodBeat.m2505o(106057);
        return format;
    }

    public void onDestroy() {
        Class cls;
        Field declaredField;
        Object obj;
        AppMethodBeat.m2504i(106058);
        C4990ab.m7417i(TAG, "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), C5046bo.m7559gU(this), appendMemLog());
        this.mLifeCycleKeeper.zWX.dead();
        super.onDestroy();
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && VERSION.SDK_INT == 24) {
            try {
                if (C1186a.eOw == null) {
                    cls = Class.forName("android.rms.iaware.FastgrabConfigReader");
                    C1186a.eOw = cls;
                    declaredField = cls.getDeclaredField("mFastgrabConfigReader");
                    C1186a.field_mFastgrabConfigReader = declaredField;
                    declaredField.setAccessible(true);
                    declaredField = C1186a.eOw.getDeclaredField("mContext");
                    C1186a.field_mContext = declaredField;
                    declaredField.setAccessible(true);
                }
                obj = C1186a.field_mFastgrabConfigReader.get(C1186a.eOw);
                if (C1186a.field_mContext.get(obj) == this) {
                    C1186a.field_mContext.set(obj, null);
                }
            } catch (Throwable th) {
            }
        }
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && VERSION.SDK_INT == 24) {
            try {
                if (C1187b.aIl == null) {
                    cls = Class.forName("android.gestureboost.GestureBoostManager");
                    C1187b.aIl = cls;
                    declaredField = cls.getDeclaredField("sGestureBoostManager");
                    C1187b.eOx = declaredField;
                    declaredField.setAccessible(true);
                    declaredField = C1187b.aIl.getDeclaredField("mContext");
                    C1187b.eOy = declaredField;
                    declaredField.setAccessible(true);
                }
                obj = C1187b.eOx.get(null);
                if (obj != null) {
                    C1187b.eOy.set(obj, null);
                }
            } catch (Throwable th2) {
            }
        }
        try {
            if (VERSION.SDK_INT >= 23 && Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
                obj = C4996ah.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
                Field declaredField2 = obj.getClass().getDeclaredField("mContext");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, C4996ah.getContext());
            }
        } catch (Throwable th3) {
        }
        C4990ab.m7417i(TAG, "Activity dump [%s]", C1185a.m2613SY());
        AppMethodBeat.m2505o(106058);
    }

    public void onStop() {
        AppMethodBeat.m2504i(106059);
        this.mLifeCycleKeeper.zWZ.dead();
        super.onStop();
        AppMethodBeat.m2505o(106059);
    }

    public void onStart() {
        AppMethodBeat.m2504i(106060);
        super.onStart();
        AppMethodBeat.m2505o(106060);
    }

    public void onPause() {
        AppMethodBeat.m2504i(106061);
        C5219ac.m7928bL(2, this.className);
        this.mIsPaused = true;
        super.onPause();
        if (isSupportNavigationSwipeBack()) {
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(false);
            }
            if (!isFinishing()) {
                C5666h.m8512a(this);
            }
        }
        if (this.mNfcFilterHelper != null) {
            C5207b c5207b = this.mNfcFilterHelper;
            if (c5207b.ynk != null) {
                try {
                    c5207b.ynk.disableForegroundDispatch(MMFragmentActivity.this);
                } catch (Exception e) {
                    C4990ab.m7412e(TAG, "lo-nfc-onPause: exp:" + e.getLocalizedMessage());
                }
            }
        }
        this.mLifeCycleKeeper.zWY.dead();
        AppMethodBeat.m2505o(106061);
    }

    public void onResume() {
        AppMethodBeat.m2504i(106062);
        C5219ac.m7928bL(1, this.className);
        this.mIsPaused = false;
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            C5666h.m8513b(this);
            onSwipe(1.0f);
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(true);
                getSwipeBackLayout().zOp = false;
            }
        }
        if (this.mNfcFilterHelper != null) {
            C5207b c5207b = this.mNfcFilterHelper;
            if (c5207b.ynk != null) {
                if (c5207b.ynl == null || c5207b.ynm == null || c5207b.ynn == null) {
                    c5207b.init();
                }
                try {
                    c5207b.ynk.enableForegroundDispatch(MMFragmentActivity.this, c5207b.ynl, c5207b.ynm, c5207b.ynn);
                    AppMethodBeat.m2505o(106062);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e(TAG, "lo-nfc-onResume: exp:" + e.getLocalizedMessage());
                }
            }
        }
        AppMethodBeat.m2505o(106062);
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment) {
        AppMethodBeat.m2504i(106063);
        if (fragment == null) {
            AppMethodBeat.m2505o(106063);
            return;
        }
        switchFragmentInternalWithoutAnim(fragment, fragment.getId());
        AppMethodBeat.m2505o(106063);
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment, int i) {
        AppMethodBeat.m2504i(106064);
        switchFragment(fragment, i, false, false, 0, 0);
        AppMethodBeat.m2505o(106064);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment) {
        AppMethodBeat.m2504i(106065);
        if (fragment == null) {
            AppMethodBeat.m2505o(106065);
            return;
        }
        switchFragmentInternalFarwardWithAnim(fragment, fragment.getId());
        AppMethodBeat.m2505o(106065);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment, int i) {
        AppMethodBeat.m2504i(106066);
        switchFragment(fragment, i, false, true, C25738R.anim.f8403df, C25738R.anim.f8402dc);
        AppMethodBeat.m2505o(106066);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment) {
        AppMethodBeat.m2504i(106067);
        switchFragmentInternalBackwardWithAnim(fragment, fragment.getId());
        AppMethodBeat.m2505o(106067);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment, int i) {
        AppMethodBeat.m2504i(106068);
        switchFragment(fragment, i, false, true, C25738R.anim.f8401db, C25738R.anim.f8404dg);
        AppMethodBeat.m2505o(106068);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, View view) {
        AppMethodBeat.m2504i(106069);
        if (fragment == null) {
            AppMethodBeat.m2505o(106069);
            return;
        }
        switchFragmentInternalBackwardWithAnimLeftSelfView(fragment, fragment.getId(), view);
        AppMethodBeat.m2505o(106069);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, int i, View view) {
        AppMethodBeat.m2504i(106070);
        switchFragment(fragment, i, false, true, 0, C25738R.anim.f8404dg);
        if (view == null) {
            AppMethodBeat.m2505o(106070);
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C25738R.anim.f8401db);
        if (loadAnimation != null) {
            view.startAnimation(loadAnimation);
        }
        view.setVisibility(0);
        AppMethodBeat.m2505o(106070);
    }

    public void switchFragmentActivity(Fragment fragment) {
        AppMethodBeat.m2504i(106071);
        if (fragment == null) {
            AppMethodBeat.m2505o(106071);
            return;
        }
        switchFragmentActivity(fragment, fragment.getId());
        AppMethodBeat.m2505o(106071);
    }

    public void switchFragmentActivity(Fragment fragment, int i) {
        AppMethodBeat.m2504i(106072);
        switchFragment(fragment, i, true, true, C25738R.anim.f8362c4, C25738R.anim.f8367c9);
        this.record.add(new WeakReference((MMFragment) fragment));
        AppMethodBeat.m2505o(106072);
    }

    public boolean popBackStackImmediate() {
        AppMethodBeat.m2504i(106073);
        if (this.record.size() == 0) {
            AppMethodBeat.m2505o(106073);
            return false;
        }
        this.record.remove(this.record.size() - 1);
        boolean popBackStackImmediate = getSupportFragmentManager().popBackStackImmediate();
        AppMethodBeat.m2505o(106073);
        return popBackStackImmediate;
    }

    public void switchFragment(Fragment fragment, int i, boolean z, boolean z2, int i2, int i3) {
        AppMethodBeat.m2504i(106074);
        if (fragment == null || i == 0) {
            AppMethodBeat.m2505o(106074);
            return;
        }
        C0336i supportFragmentManager = getSupportFragmentManager();
        C0338m beginTransaction = supportFragmentManager.beginTransaction();
        if (z2) {
            beginTransaction.mo565r(i2, i3);
        }
        if (supportFragmentManager.findFragmentById(i) == null) {
            beginTransaction.mo553a(i, fragment, fragment.getTag());
        } else if (fragment.isHidden()) {
            beginTransaction.mo557b(fragment);
        }
        if (z) {
            beginTransaction.mo564dg();
        }
        beginTransaction.commit();
        supportFragmentManager.executePendingTransactions();
        AppMethodBeat.m2505o(106074);
    }

    public MMFragment getCurrentFragmet() {
        AppMethodBeat.m2504i(106075);
        int size = this.record.size();
        if (size == 0) {
            AppMethodBeat.m2505o(106075);
            return null;
        }
        MMFragment mMFragment = (MMFragment) ((WeakReference) this.record.get(size - 1)).get();
        if (mMFragment == null || !mMFragment.isShowing()) {
            AppMethodBeat.m2505o(106075);
            return null;
        }
        AppMethodBeat.m2505o(106075);
        return mMFragment;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(106076);
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
        AppMethodBeat.m2505o(106076);
    }

    public void putActivityOpenAnimation(int i, int i2) {
        AppMethodBeat.m2504i(106077);
        if (enableActivityAnimation()) {
            C5206a.yng = i;
            C5206a.ynh = i2;
        }
        super.overridePendingTransition(i, i2);
        AppMethodBeat.m2505o(106077);
    }

    public void putActivityCloseAnimation(int i, int i2) {
        AppMethodBeat.m2504i(106078);
        if (enableActivityAnimation()) {
            C5206a.yni = i;
            C5206a.ynj = i2;
        }
        super.overridePendingTransition(i, i2);
        AppMethodBeat.m2505o(106078);
    }

    public boolean enableActivityAnimation() {
        boolean booleanExtra;
        AppMethodBeat.m2504i(106079);
        Intent intent = getIntent();
        if (intent != null) {
            booleanExtra = intent.getBooleanExtra(EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, false);
        } else {
            booleanExtra = false;
        }
        if (booleanExtra) {
            AppMethodBeat.m2505o(106079);
            return false;
        }
        AppMethodBeat.m2505o(106079);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void initActivityOpenAnimation(Intent intent) {
        AppMethodBeat.m2504i(106080);
        if (enableActivityAnimation()) {
            ComponentName component = intent == null ? null : intent.getComponent();
            if (component != null) {
                Object obj;
                String d = C5274b.m8051d(component);
                if ((C5274b.aqL(d) & 2) == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    super.overridePendingTransition(C5206a.yng, C5206a.ynh);
                    AppMethodBeat.m2505o(106080);
                    return;
                } else if (C5274b.aqN(d)) {
                    C5274b.m8055hN(this);
                } else {
                    C5274b.m8052hK(this);
                    AppMethodBeat.m2505o(106080);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(106080);
    }

    /* Access modifiers changed, original: protected */
    public void initActivityCloseAnimation() {
        AppMethodBeat.m2504i(106081);
        if (enableActivityAnimation()) {
            if (C5274b.m8049aE(getClass())) {
                super.overridePendingTransition(C5206a.yni, C5206a.ynj);
                AppMethodBeat.m2505o(106081);
                return;
            }
            Object obj;
            if ((C5274b.m8046aB(getClass()) & 4) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                C5274b.m8054hM(this);
                AppMethodBeat.m2505o(106081);
                return;
            }
            C5274b.m8055hN(this);
        }
        AppMethodBeat.m2505o(106081);
    }

    public void finish() {
        AppMethodBeat.m2504i(106082);
        super.finish();
        initActivityCloseAnimation();
        AppMethodBeat.m2505o(106082);
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.m2504i(106083);
        if (C5493d.m8286a(this, this.mIsPaused, intentArr, bundle)) {
            AppMethodBeat.m2505o(106083);
            return;
        }
        super.startActivities(intentArr, bundle);
        initActivityOpenAnimation(null);
        AppMethodBeat.m2505o(106083);
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        AppMethodBeat.m2504i(106084);
        super.startActivities(intentArr);
        initActivityOpenAnimation(null);
        AppMethodBeat.m2505o(106084);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.m2504i(106085);
        super.startActivity(intent);
        initActivityOpenAnimation(intent);
        AppMethodBeat.m2505o(106085);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(106086);
        super.startActivity(intent, bundle);
        initActivityOpenAnimation(intent);
        AppMethodBeat.m2505o(106086);
    }

    public void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.m2504i(106087);
        super.startActivityForResult(intent, i);
        initActivityOpenAnimation(intent);
        AppMethodBeat.m2505o(106087);
    }

    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(106088);
        if (C5493d.m8286a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i), bundle)) {
            AppMethodBeat.m2505o(106088);
            return;
        }
        super.startActivityForResult(intent, i, bundle);
        initActivityOpenAnimation(intent);
        AppMethodBeat.m2505o(106088);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        AppMethodBeat.m2504i(106089);
        super.startActivityFromFragment(fragment, intent, i);
        initActivityOpenAnimation(intent);
        AppMethodBeat.m2505o(106089);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(106090);
        if (C5493d.m8286a(this, this.mIsPaused, new Intent[]{intent}, fragment, Integer.valueOf(i))) {
            AppMethodBeat.m2505o(106090);
            return;
        }
        super.startActivityFromFragment(fragment, intent, i, bundle);
        AppMethodBeat.m2505o(106090);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSwiping() {
        return this.mSwiping;
    }

    public boolean isHideStatusBar() {
        AppMethodBeat.m2504i(106092);
        if ((C5274b.m8046aB(getClass()) & 32) != 0) {
            AppMethodBeat.m2505o(106092);
            return true;
        }
        AppMethodBeat.m2505o(106092);
        return false;
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean convertActivityFromTranslucent() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void initSwipeBack() {
        AppMethodBeat.m2504i(106094);
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(2130970910, viewGroup, false);
        this.mSwipeBackLayout.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(C25738R.color.a3p);
        viewGroup.removeView(viewGroup2);
        this.mSwipeBackLayout.addView(viewGroup2);
        this.mSwipeBackLayout.setContentView(viewGroup2);
        viewGroup.addView(this.mSwipeBackLayout);
        this.mSwipeBackLayout.setSwipeGestureDelegate(this);
        AppMethodBeat.m2505o(106094);
    }

    public Object getSystemService(String str) {
        AppMethodBeat.m2504i(106095);
        Object systemService;
        if (!"clipboard".equals(str) || getApplicationContext() == null) {
            systemService = super.getSystemService(str);
            if ("layout_inflater".equals(str)) {
                systemService = C5616v.m8408a((LayoutInflater) systemService);
                AppMethodBeat.m2505o(106095);
                return systemService;
            }
            AppMethodBeat.m2505o(106095);
            return systemService;
        }
        systemService = getApplicationContext().getSystemService(str);
        AppMethodBeat.m2505o(106095);
        return systemService;
    }

    public Resources getResources() {
        AppMethodBeat.m2504i(106096);
        Resources resources;
        if (C4996ah.getContext().getAssets() == null || C4996ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(106096);
            return resources;
        }
        resources = C4996ah.getResources();
        AppMethodBeat.m2505o(106096);
        return resources;
    }

    public void onSwipe(float f) {
        AppMethodBeat.m2504i(106097);
        C4990ab.m7419v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f), Long.valueOf(320));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = C5222ae.m7934a(getWindow(), getSupportActionBar() != null ? getSupportActionBar().getCustomView() : null);
        }
        View view = this.mContentViewForSwipeBack;
        if (Float.compare(1.0f, f) <= 0) {
            C5587h.m8390s(view, 0.0f);
            AppMethodBeat.m2505o(106097);
            return;
        }
        C5587h.m8390s(view, ((((float) view.getWidth()) / 3.5f) * (1.0f - f)) * -1.0f);
        AppMethodBeat.m2505o(106097);
    }

    public void onSettle(boolean z, int i) {
        long j = 160;
        AppMethodBeat.m2504i(106098);
        C4990ab.m7419v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = C5222ae.m7934a(getWindow(), getSupportActionBar().getCustomView());
        }
        View view = this.mContentViewForSwipeBack;
        if (z) {
            if (i <= 0) {
                j = 320;
            }
            C5587h.m8387a(view, j, 0.0f, null);
            AppMethodBeat.m2505o(106098);
            return;
        }
        if (i <= 0) {
            j = 320;
        }
        C5587h.m8387a(view, j, ((float) (view.getWidth() * -1)) / 3.5f, null);
        AppMethodBeat.m2505o(106098);
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(106099);
        if (!isFinishing()) {
            finish();
        }
        getWindow().getDecorView().setVisibility(8);
        overridePendingTransition(0, 0);
        this.mSwiping = false;
        AppMethodBeat.m2505o(106099);
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(106100);
        if (isSupportNavigationSwipeBack() && keyEvent.getKeyCode() == 4 && getSwipeBackLayout().dkx()) {
            C4990ab.m7420w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
            AppMethodBeat.m2505o(106100);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(106100);
        return dispatchKeyEvent;
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(106101);
        super.onConfigurationChanged(configuration);
        if (getSupportActionBar() != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(2131820939);
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(2131820941);
                if (findViewById != null && (findViewById instanceof Toolbar)) {
                    Toolbar toolbar = (Toolbar) findViewById;
                    LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = C1441a.m3065bG(this);
                    }
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
        AppMethodBeat.m2505o(106101);
    }

    public void supportInvalidateOptionsMenu() {
        AppMethodBeat.m2504i(106102);
        if (getCurrentFragmet() == null || !getCurrentFragmet().interceptSupportInvalidateOptionsMenu()) {
            super.supportInvalidateOptionsMenu();
            AppMethodBeat.m2505o(106102);
            return;
        }
        AppMethodBeat.m2505o(106102);
    }

    public final boolean isSupportNavigationSwipeBack() {
        AppMethodBeat.m2504i(106091);
        if (!C1443d.m3068iW(19) || !C1436b.m3061Ml()) {
            AppMethodBeat.m2505o(106091);
            return false;
        } else if (supportNavigationSwipeBack() && C5274b.m8048aD(getClass())) {
            AppMethodBeat.m2505o(106091);
            return true;
        } else {
            AppMethodBeat.m2505o(106091);
            return false;
        }
    }

    public boolean initNavigationSwipeBack() {
        AppMethodBeat.m2504i(106093);
        if (C1443d.m3068iW(19)) {
            if (!C5274b.m8048aD(getClass()) || !convertActivityFromTranslucent()) {
                boolean z;
                if ((C5274b.m8046aB(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && C5004al.isMainThread()) {
                    C5274b.m8050au(this);
                }
            } else if (C5004al.isMainThread()) {
                C5274b.m8050au(this);
            }
        }
        if (isSupportNavigationSwipeBack()) {
            initSwipeBack();
            AppMethodBeat.m2505o(106093);
            return true;
        }
        AppMethodBeat.m2505o(106093);
        return false;
    }
}
