package com.tencent.mm.ui;

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
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MMFragmentActivity extends AppCompatActivity implements com.tencent.mm.ui.widget.SwipeBackLayout.a, com.tencent.mm.ui.widget.h.a, com.tencent.mm.vending.e.b {
    public static final long ANIMATION_DURATION = 320;
    public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
    private static final String TAG = "MicroMsg.MMFragmentActivity";
    public static final float WIDTH_SETTLE_FACT = 3.5f;
    String className;
    private a mActivityAnimStyle = new a();
    private View mContentViewForSwipeBack = null;
    private boolean mIsPaused;
    private com.tencent.mm.vending.a.a mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    private b mNfcFilterHelper;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean mSwiping;
    ArrayList<WeakReference<MMFragment>> record = new ArrayList();

    public static class a {
        public static int ync;
        public static int ynd;
        public static int yne;
        public static int ynf;
        public static int yng = ync;
        public static int ynh = ynd;
        public static int yni = yne;
        public static int ynj = ynf;

        public static void dyv() {
            int i = R.anim.s;
            AppMethodBeat.i(106051);
            w wVar = q.eth;
            boolean Md = w.Md();
            ab.i(MMFragmentActivity.TAG, "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(Md)));
            if (Md) {
                int Ml = com.tencent.mm.compatible.i.b.Ml() & d.iW(19);
                ab.i(MMFragmentActivity.TAG, "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(Ml)));
                ync = Ml != 0 ? R.anim.df : R.anim.c4;
                ynd = Ml != 0 ? R.anim.dc : R.anim.s;
                if (Ml != 0) {
                    i = R.anim.db;
                }
                yne = i;
                ynf = Ml != 0 ? R.anim.dg : R.anim.c9;
                yng = ync;
                ynh = ynd;
                yni = yne;
                ynj = ynf;
                AppMethodBeat.o(106051);
                return;
            }
            AppMethodBeat.o(106051);
        }

        static {
            int i;
            int i2 = R.anim.s;
            AppMethodBeat.i(106052);
            int Ml = com.tencent.mm.compatible.i.b.Ml() & d.iW(19);
            ync = Ml != 0 ? R.anim.df : R.anim.c4;
            ynd = Ml != 0 ? R.anim.dc : R.anim.s;
            if (Ml != 0) {
                i2 = R.anim.db;
            }
            yne = i2;
            if (Ml != 0) {
                i = R.anim.dg;
            } else {
                i = R.anim.c9;
            }
            ynf = i;
            AppMethodBeat.o(106052);
        }
    }

    final class b {
        NfcAdapter ynk;
        PendingIntent ynl;
        IntentFilter[] ynm;
        String[][] ynn;

        private b() {
            this.ynk = null;
        }

        /* synthetic */ b(MMFragmentActivity mMFragmentActivity, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void init() {
            AppMethodBeat.i(106053);
            Intent intent = new Intent();
            intent.setClassName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
            intent.addFlags(536870912);
            this.ynl = PendingIntent.getActivity(MMFragmentActivity.this, 0, intent, 0);
            try {
                new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
                new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataScheme("vnd.android.nfc");
                this.ynm = new IntentFilter[]{r0, r1, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
                String[][] strArr = new String[1][];
                strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName()};
                this.ynn = strArr;
                AppMethodBeat.o(106053);
            } catch (MalformedMimeTypeException e) {
                RuntimeException runtimeException = new RuntimeException("fail", e);
                AppMethodBeat.o(106053);
                throw runtimeException;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMFragmentActivity() {
        AppMethodBeat.i(106054);
        AppMethodBeat.o(106054);
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(106055);
        this.mLifeCycleKeeper.zWX.keep(aVar);
        AppMethodBeat.o(106055);
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.vending.e.b theCreate() {
        return this.mLifeCycleKeeper.zWX;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.vending.e.b theResume() {
        return this.mLifeCycleKeeper.zWY;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.vending.e.b theStart() {
        return this.mLifeCycleKeeper.zWY;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106056);
        this.className = getClass().getName();
        ac.bL(3, this.className);
        super.onCreate(bundle);
        this.mNfcFilterHelper = new b(this, (byte) 0);
        b bVar = this.mNfcFilterHelper;
        try {
            bVar.ynk = NfcAdapter.getDefaultAdapter(MMFragmentActivity.this);
        } catch (Throwable th) {
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
        }
        bVar.init();
        ab.i(TAG, "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bo.gU(this), appendMemLog());
        AppMethodBeat.o(106056);
    }

    public String appendMemLog() {
        AppMethodBeat.i(106057);
        long totalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        String format = String.format("Runtime: [%s:%s:%s] Native: [%s:%s:%s] ", new Object[]{Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()), Long.valueOf(totalMemory), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize())});
        AppMethodBeat.o(106057);
        return format;
    }

    public void onDestroy() {
        Class cls;
        Field declaredField;
        Object obj;
        AppMethodBeat.i(106058);
        ab.i(TAG, "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), bo.gU(this), appendMemLog());
        this.mLifeCycleKeeper.zWX.dead();
        super.onDestroy();
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && VERSION.SDK_INT == 24) {
            try {
                if (com.tencent.mm.ac.b.a.eOw == null) {
                    cls = Class.forName("android.rms.iaware.FastgrabConfigReader");
                    com.tencent.mm.ac.b.a.eOw = cls;
                    declaredField = cls.getDeclaredField("mFastgrabConfigReader");
                    com.tencent.mm.ac.b.a.field_mFastgrabConfigReader = declaredField;
                    declaredField.setAccessible(true);
                    declaredField = com.tencent.mm.ac.b.a.eOw.getDeclaredField("mContext");
                    com.tencent.mm.ac.b.a.field_mContext = declaredField;
                    declaredField.setAccessible(true);
                }
                obj = com.tencent.mm.ac.b.a.field_mFastgrabConfigReader.get(com.tencent.mm.ac.b.a.eOw);
                if (com.tencent.mm.ac.b.a.field_mContext.get(obj) == this) {
                    com.tencent.mm.ac.b.a.field_mContext.set(obj, null);
                }
            } catch (Throwable th) {
            }
        }
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && VERSION.SDK_INT == 24) {
            try {
                if (com.tencent.mm.ac.b.b.aIl == null) {
                    cls = Class.forName("android.gestureboost.GestureBoostManager");
                    com.tencent.mm.ac.b.b.aIl = cls;
                    declaredField = cls.getDeclaredField("sGestureBoostManager");
                    com.tencent.mm.ac.b.b.eOx = declaredField;
                    declaredField.setAccessible(true);
                    declaredField = com.tencent.mm.ac.b.b.aIl.getDeclaredField("mContext");
                    com.tencent.mm.ac.b.b.eOy = declaredField;
                    declaredField.setAccessible(true);
                }
                obj = com.tencent.mm.ac.b.b.eOx.get(null);
                if (obj != null) {
                    com.tencent.mm.ac.b.b.eOy.set(obj, null);
                }
            } catch (Throwable th2) {
            }
        }
        try {
            if (VERSION.SDK_INT >= 23 && Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
                obj = ah.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
                Field declaredField2 = obj.getClass().getDeclaredField("mContext");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, ah.getContext());
            }
        } catch (Throwable th3) {
        }
        ab.i(TAG, "Activity dump [%s]", com.tencent.mm.ac.a.SY());
        AppMethodBeat.o(106058);
    }

    public void onStop() {
        AppMethodBeat.i(106059);
        this.mLifeCycleKeeper.zWZ.dead();
        super.onStop();
        AppMethodBeat.o(106059);
    }

    public void onStart() {
        AppMethodBeat.i(106060);
        super.onStart();
        AppMethodBeat.o(106060);
    }

    public void onPause() {
        AppMethodBeat.i(106061);
        ac.bL(2, this.className);
        this.mIsPaused = true;
        super.onPause();
        if (isSupportNavigationSwipeBack()) {
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(false);
            }
            if (!isFinishing()) {
                h.a(this);
            }
        }
        if (this.mNfcFilterHelper != null) {
            b bVar = this.mNfcFilterHelper;
            if (bVar.ynk != null) {
                try {
                    bVar.ynk.disableForegroundDispatch(MMFragmentActivity.this);
                } catch (Exception e) {
                    ab.e(TAG, "lo-nfc-onPause: exp:" + e.getLocalizedMessage());
                }
            }
        }
        this.mLifeCycleKeeper.zWY.dead();
        AppMethodBeat.o(106061);
    }

    public void onResume() {
        AppMethodBeat.i(106062);
        ac.bL(1, this.className);
        this.mIsPaused = false;
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            h.b(this);
            onSwipe(1.0f);
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(true);
                getSwipeBackLayout().zOp = false;
            }
        }
        if (this.mNfcFilterHelper != null) {
            b bVar = this.mNfcFilterHelper;
            if (bVar.ynk != null) {
                if (bVar.ynl == null || bVar.ynm == null || bVar.ynn == null) {
                    bVar.init();
                }
                try {
                    bVar.ynk.enableForegroundDispatch(MMFragmentActivity.this, bVar.ynl, bVar.ynm, bVar.ynn);
                    AppMethodBeat.o(106062);
                    return;
                } catch (Exception e) {
                    ab.e(TAG, "lo-nfc-onResume: exp:" + e.getLocalizedMessage());
                }
            }
        }
        AppMethodBeat.o(106062);
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment) {
        AppMethodBeat.i(106063);
        if (fragment == null) {
            AppMethodBeat.o(106063);
            return;
        }
        switchFragmentInternalWithoutAnim(fragment, fragment.getId());
        AppMethodBeat.o(106063);
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment, int i) {
        AppMethodBeat.i(106064);
        switchFragment(fragment, i, false, false, 0, 0);
        AppMethodBeat.o(106064);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment) {
        AppMethodBeat.i(106065);
        if (fragment == null) {
            AppMethodBeat.o(106065);
            return;
        }
        switchFragmentInternalFarwardWithAnim(fragment, fragment.getId());
        AppMethodBeat.o(106065);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment, int i) {
        AppMethodBeat.i(106066);
        switchFragment(fragment, i, false, true, R.anim.df, R.anim.dc);
        AppMethodBeat.o(106066);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment) {
        AppMethodBeat.i(106067);
        switchFragmentInternalBackwardWithAnim(fragment, fragment.getId());
        AppMethodBeat.o(106067);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment, int i) {
        AppMethodBeat.i(106068);
        switchFragment(fragment, i, false, true, R.anim.db, R.anim.dg);
        AppMethodBeat.o(106068);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, View view) {
        AppMethodBeat.i(106069);
        if (fragment == null) {
            AppMethodBeat.o(106069);
            return;
        }
        switchFragmentInternalBackwardWithAnimLeftSelfView(fragment, fragment.getId(), view);
        AppMethodBeat.o(106069);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, int i, View view) {
        AppMethodBeat.i(106070);
        switchFragment(fragment, i, false, true, 0, R.anim.dg);
        if (view == null) {
            AppMethodBeat.o(106070);
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.db);
        if (loadAnimation != null) {
            view.startAnimation(loadAnimation);
        }
        view.setVisibility(0);
        AppMethodBeat.o(106070);
    }

    public void switchFragmentActivity(Fragment fragment) {
        AppMethodBeat.i(106071);
        if (fragment == null) {
            AppMethodBeat.o(106071);
            return;
        }
        switchFragmentActivity(fragment, fragment.getId());
        AppMethodBeat.o(106071);
    }

    public void switchFragmentActivity(Fragment fragment, int i) {
        AppMethodBeat.i(106072);
        switchFragment(fragment, i, true, true, R.anim.c4, R.anim.c9);
        this.record.add(new WeakReference((MMFragment) fragment));
        AppMethodBeat.o(106072);
    }

    public boolean popBackStackImmediate() {
        AppMethodBeat.i(106073);
        if (this.record.size() == 0) {
            AppMethodBeat.o(106073);
            return false;
        }
        this.record.remove(this.record.size() - 1);
        boolean popBackStackImmediate = getSupportFragmentManager().popBackStackImmediate();
        AppMethodBeat.o(106073);
        return popBackStackImmediate;
    }

    public void switchFragment(Fragment fragment, int i, boolean z, boolean z2, int i2, int i3) {
        AppMethodBeat.i(106074);
        if (fragment == null || i == 0) {
            AppMethodBeat.o(106074);
            return;
        }
        i supportFragmentManager = getSupportFragmentManager();
        m beginTransaction = supportFragmentManager.beginTransaction();
        if (z2) {
            beginTransaction.r(i2, i3);
        }
        if (supportFragmentManager.findFragmentById(i) == null) {
            beginTransaction.a(i, fragment, fragment.getTag());
        } else if (fragment.isHidden()) {
            beginTransaction.b(fragment);
        }
        if (z) {
            beginTransaction.dg();
        }
        beginTransaction.commit();
        supportFragmentManager.executePendingTransactions();
        AppMethodBeat.o(106074);
    }

    public MMFragment getCurrentFragmet() {
        AppMethodBeat.i(106075);
        int size = this.record.size();
        if (size == 0) {
            AppMethodBeat.o(106075);
            return null;
        }
        MMFragment mMFragment = (MMFragment) ((WeakReference) this.record.get(size - 1)).get();
        if (mMFragment == null || !mMFragment.isShowing()) {
            AppMethodBeat.o(106075);
            return null;
        }
        AppMethodBeat.o(106075);
        return mMFragment;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(106076);
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
        AppMethodBeat.o(106076);
    }

    public void putActivityOpenAnimation(int i, int i2) {
        AppMethodBeat.i(106077);
        if (enableActivityAnimation()) {
            a.yng = i;
            a.ynh = i2;
        }
        super.overridePendingTransition(i, i2);
        AppMethodBeat.o(106077);
    }

    public void putActivityCloseAnimation(int i, int i2) {
        AppMethodBeat.i(106078);
        if (enableActivityAnimation()) {
            a.yni = i;
            a.ynj = i2;
        }
        super.overridePendingTransition(i, i2);
        AppMethodBeat.o(106078);
    }

    public boolean enableActivityAnimation() {
        boolean booleanExtra;
        AppMethodBeat.i(106079);
        Intent intent = getIntent();
        if (intent != null) {
            booleanExtra = intent.getBooleanExtra(EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, false);
        } else {
            booleanExtra = false;
        }
        if (booleanExtra) {
            AppMethodBeat.o(106079);
            return false;
        }
        AppMethodBeat.o(106079);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void initActivityOpenAnimation(Intent intent) {
        AppMethodBeat.i(106080);
        if (enableActivityAnimation()) {
            ComponentName component = intent == null ? null : intent.getComponent();
            if (component != null) {
                Object obj;
                String d = com.tencent.mm.ui.base.b.d(component);
                if ((com.tencent.mm.ui.base.b.aqL(d) & 2) == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    super.overridePendingTransition(a.yng, a.ynh);
                    AppMethodBeat.o(106080);
                    return;
                } else if (com.tencent.mm.ui.base.b.aqN(d)) {
                    com.tencent.mm.ui.base.b.hN(this);
                } else {
                    com.tencent.mm.ui.base.b.hK(this);
                    AppMethodBeat.o(106080);
                    return;
                }
            }
        }
        AppMethodBeat.o(106080);
    }

    /* Access modifiers changed, original: protected */
    public void initActivityCloseAnimation() {
        AppMethodBeat.i(106081);
        if (enableActivityAnimation()) {
            if (com.tencent.mm.ui.base.b.aE(getClass())) {
                super.overridePendingTransition(a.yni, a.ynj);
                AppMethodBeat.o(106081);
                return;
            }
            Object obj;
            if ((com.tencent.mm.ui.base.b.aB(getClass()) & 4) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                com.tencent.mm.ui.base.b.hM(this);
                AppMethodBeat.o(106081);
                return;
            }
            com.tencent.mm.ui.base.b.hN(this);
        }
        AppMethodBeat.o(106081);
    }

    public void finish() {
        AppMethodBeat.i(106082);
        super.finish();
        initActivityCloseAnimation();
        AppMethodBeat.o(106082);
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.i(106083);
        if (d.a(this, this.mIsPaused, intentArr, bundle)) {
            AppMethodBeat.o(106083);
            return;
        }
        super.startActivities(intentArr, bundle);
        initActivityOpenAnimation(null);
        AppMethodBeat.o(106083);
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        AppMethodBeat.i(106084);
        super.startActivities(intentArr);
        initActivityOpenAnimation(null);
        AppMethodBeat.o(106084);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(106085);
        super.startActivity(intent);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(106085);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        AppMethodBeat.i(106086);
        super.startActivity(intent, bundle);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(106086);
    }

    public void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.i(106087);
        super.startActivityForResult(intent, i);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(106087);
    }

    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.i(106088);
        if (d.a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i), bundle)) {
            AppMethodBeat.o(106088);
            return;
        }
        super.startActivityForResult(intent, i, bundle);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(106088);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        AppMethodBeat.i(106089);
        super.startActivityFromFragment(fragment, intent, i);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(106089);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        AppMethodBeat.i(106090);
        if (d.a(this, this.mIsPaused, new Intent[]{intent}, fragment, Integer.valueOf(i))) {
            AppMethodBeat.o(106090);
            return;
        }
        super.startActivityFromFragment(fragment, intent, i, bundle);
        AppMethodBeat.o(106090);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSwiping() {
        return this.mSwiping;
    }

    public boolean isHideStatusBar() {
        AppMethodBeat.i(106092);
        if ((com.tencent.mm.ui.base.b.aB(getClass()) & 32) != 0) {
            AppMethodBeat.o(106092);
            return true;
        }
        AppMethodBeat.o(106092);
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
        AppMethodBeat.i(106094);
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(R.layout.az9, viewGroup, false);
        this.mSwipeBackLayout.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(R.color.a3p);
        viewGroup.removeView(viewGroup2);
        this.mSwipeBackLayout.addView(viewGroup2);
        this.mSwipeBackLayout.setContentView(viewGroup2);
        viewGroup.addView(this.mSwipeBackLayout);
        this.mSwipeBackLayout.setSwipeGestureDelegate(this);
        AppMethodBeat.o(106094);
    }

    public Object getSystemService(String str) {
        AppMethodBeat.i(106095);
        Object systemService;
        if (!"clipboard".equals(str) || getApplicationContext() == null) {
            systemService = super.getSystemService(str);
            if ("layout_inflater".equals(str)) {
                systemService = v.a((LayoutInflater) systemService);
                AppMethodBeat.o(106095);
                return systemService;
            }
            AppMethodBeat.o(106095);
            return systemService;
        }
        systemService = getApplicationContext().getSystemService(str);
        AppMethodBeat.o(106095);
        return systemService;
    }

    public Resources getResources() {
        AppMethodBeat.i(106096);
        Resources resources;
        if (ah.getContext().getAssets() == null || ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.o(106096);
            return resources;
        }
        resources = ah.getResources();
        AppMethodBeat.o(106096);
        return resources;
    }

    public void onSwipe(float f) {
        AppMethodBeat.i(106097);
        ab.v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f), Long.valueOf(320));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ae.a(getWindow(), getSupportActionBar() != null ? getSupportActionBar().getCustomView() : null);
        }
        View view = this.mContentViewForSwipeBack;
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.h.s(view, 0.0f);
            AppMethodBeat.o(106097);
            return;
        }
        com.tencent.mm.ui.tools.h.s(view, ((((float) view.getWidth()) / 3.5f) * (1.0f - f)) * -1.0f);
        AppMethodBeat.o(106097);
    }

    public void onSettle(boolean z, int i) {
        long j = 160;
        AppMethodBeat.i(106098);
        ab.v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ae.a(getWindow(), getSupportActionBar().getCustomView());
        }
        View view = this.mContentViewForSwipeBack;
        if (z) {
            if (i <= 0) {
                j = 320;
            }
            com.tencent.mm.ui.tools.h.a(view, j, 0.0f, null);
            AppMethodBeat.o(106098);
            return;
        }
        if (i <= 0) {
            j = 320;
        }
        com.tencent.mm.ui.tools.h.a(view, j, ((float) (view.getWidth() * -1)) / 3.5f, null);
        AppMethodBeat.o(106098);
    }

    public void onSwipeBack() {
        AppMethodBeat.i(106099);
        if (!isFinishing()) {
            finish();
        }
        getWindow().getDecorView().setVisibility(8);
        overridePendingTransition(0, 0);
        this.mSwiping = false;
        AppMethodBeat.o(106099);
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(106100);
        if (isSupportNavigationSwipeBack() && keyEvent.getKeyCode() == 4 && getSwipeBackLayout().dkx()) {
            ab.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
            AppMethodBeat.o(106100);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(106100);
        return dispatchKeyEvent;
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106101);
        super.onConfigurationChanged(configuration);
        if (getSupportActionBar() != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.jz);
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.k1);
                if (findViewById != null && (findViewById instanceof Toolbar)) {
                    Toolbar toolbar = (Toolbar) findViewById;
                    LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = com.tencent.mm.compatible.util.a.bG(this);
                    }
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
        AppMethodBeat.o(106101);
    }

    public void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(106102);
        if (getCurrentFragmet() == null || !getCurrentFragmet().interceptSupportInvalidateOptionsMenu()) {
            super.supportInvalidateOptionsMenu();
            AppMethodBeat.o(106102);
            return;
        }
        AppMethodBeat.o(106102);
    }

    public final boolean isSupportNavigationSwipeBack() {
        AppMethodBeat.i(106091);
        if (!d.iW(19) || !com.tencent.mm.compatible.i.b.Ml()) {
            AppMethodBeat.o(106091);
            return false;
        } else if (supportNavigationSwipeBack() && com.tencent.mm.ui.base.b.aD(getClass())) {
            AppMethodBeat.o(106091);
            return true;
        } else {
            AppMethodBeat.o(106091);
            return false;
        }
    }

    public boolean initNavigationSwipeBack() {
        AppMethodBeat.i(106093);
        if (d.iW(19)) {
            if (!com.tencent.mm.ui.base.b.aD(getClass()) || !convertActivityFromTranslucent()) {
                boolean z;
                if ((com.tencent.mm.ui.base.b.aB(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && al.isMainThread()) {
                    com.tencent.mm.ui.base.b.au(this);
                }
            } else if (al.isMainThread()) {
                com.tencent.mm.ui.base.b.au(this);
            }
        }
        if (isSupportNavigationSwipeBack()) {
            initSwipeBack();
            AppMethodBeat.o(106093);
            return true;
        }
        AppMethodBeat.o(106093);
        return false;
    }
}
