package com.tencent.p177mm.plugin.game.luggage;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.p146d.C17820m;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p146d.C37398j;
import com.tencent.luggage.p146d.C8860e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.statusbar.C5540a;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.game.luggage.p432d.C16771f;
import com.tencent.p177mm.plugin.game.luggage.p432d.C39210a;
import com.tencent.p177mm.plugin.game.luggage.p432d.C46006b;
import com.tencent.p177mm.plugin.webview.luggage.C29809s;
import com.tencent.p177mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C46417a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43963g;
import com.tencent.p177mm.plugin.wepkg.event.C35760c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI */
public class LuggageGameWebViewUI extends MMActivity {
    private C46006b mTJ;
    private int mTK = -1;
    private boolean mTL = true;

    /* renamed from: com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI$1 */
    class C121271 implements C37398j {
        C121271() {
        }

        /* renamed from: j */
        public final C8860e mo23952j(String str, Bundle bundle) {
            GameWebPerformanceInfo kU;
            AppMethodBeat.m2504i(135809);
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", Long.valueOf(currentTimeMillis));
            bundle.putInt("minimize_secene", 3);
            boolean z = bundle.getBoolean("from_bag", false);
            boolean z2 = bundle.getBoolean("float_layer_page", false);
            if (LuggageGameWebViewUI.this.mTL || z2 || z || LuggageGameWebViewUI.m66795NM(str)) {
                kU = GameWebPerformanceInfo.m63878kU(str);
            } else {
                C43963g.agg(str);
                C43963g.m78905az(str, currentTimeMillis);
                kU = GameWebPerformanceInfo.m63879kV(str);
            }
            if (C5046bo.isNullOrNil(kU.url)) {
                C4990ab.m7417i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", str);
                kU.url = str;
                kU.eBZ = currentTimeMillis;
                kU.eBU = currentTimeMillis;
                kU.startTime = currentTimeMillis;
                kU.eBK = 1;
            }
            kU.eCb = currentTimeMillis;
            if (!z2) {
                LuggageGameWebViewUI.this.mTL = false;
            }
            C8860e c39210a;
            if (z) {
                C12140e c12140e = new C12140e(LuggageGameWebViewUI.this.mTJ.bPq, C17820m.m27869a(LuggageGameWebViewUI.this.mController.ylL, Integer.valueOf(C29809s.ujF)), bundle);
                AppMethodBeat.m2505o(135809);
                return c12140e;
            } else if (z2) {
                c39210a = new C39210a(LuggageGameWebViewUI.this.mTJ.bPq, bundle);
                AppMethodBeat.m2505o(135809);
                return c39210a;
            } else {
                C32186k aq = C12146d.m20087aq(LuggageGameWebViewUI.this.mController.ylL, str);
                if (aq != null) {
                    c39210a = new C16771f(LuggageGameWebViewUI.this.mTJ.bPq, aq, bundle);
                    AppMethodBeat.m2505o(135809);
                    return c39210a;
                }
                c39210a = new C12140e(LuggageGameWebViewUI.this.mTJ.bPq, null, bundle);
                AppMethodBeat.m2505o(135809);
                return c39210a;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(135811);
        super.onCreate(bundle);
        overridePendingTransition(C5206a.yng, C5206a.ynh);
        AppBrandMainProcessService.m54349a(new ActiveMainProcessTask());
        long longExtra = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        C4990ab.m7417i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", Long.valueOf(longExtra), Long.valueOf(System.currentTimeMillis()));
        final String stringExtra = getIntent().getStringExtra("rawUrl");
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.LuggageGameWebViewUI", "url is null");
            AppMethodBeat.m2505o(135811);
            return;
        }
        int i;
        GameWebPerformanceInfo kU = GameWebPerformanceInfo.m63878kU(stringExtra);
        kU.url = stringExtra;
        kU.eBT = getIntent().getLongExtra("gamecenterui_createtime", 0);
        kU.eBU = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        kU.startTime = getIntent().getLongExtra("start_time", kU.eBU);
        kU.eBZ = System.currentTimeMillis();
        kU.eBK = 1;
        kU.eBN = 1;
        C4990ab.m7417i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", stringExtra, Long.valueOf(kU.startTime), Long.valueOf(kU.eBT), Long.valueOf(kU.eBU), Long.valueOf(kU.eBZ));
        C43963g.m78905az(stringExtra, System.currentTimeMillis());
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.mTJ = new C46006b(this);
        setContentView((View) this.mTJ.bPj);
        this.mTJ.mo67377a((C37398j) new C121271());
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) getIntent().getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams != null) {
            GameFloatLayerInfo gameFloatLayerInfo = gameWebViewLaunchParams.mTF;
            if (gameFloatLayerInfo != null) {
                GameWebPerformanceInfo kU2 = GameWebPerformanceInfo.m63878kU(gameFloatLayerInfo.url);
                kU2.url = gameFloatLayerInfo.url;
                kU2.eBT = getIntent().getLongExtra("gamecenterui_createtime", 0);
                kU2.eBU = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
                kU2.startTime = getIntent().getLongExtra("start_time", kU2.eBU);
                kU2.eBZ = System.currentTimeMillis();
                kU2.eBK = 1;
                kU2.eBN = 1;
                C43963g.m78905az(gameFloatLayerInfo.url, System.currentTimeMillis());
                Bundle bundle2 = new Bundle();
                bundle2.putString("rawUrl", gameFloatLayerInfo.url);
                bundle2.putBoolean("show_full_screen", gameFloatLayerInfo.mTC);
                bundle2.putInt("screen_orientation", gameFloatLayerInfo.orientation);
                bundle2.putBoolean("float_layer_page", true);
                bundle2.putBoolean("needAnimation", false);
                bundle2.putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
                bundle2.putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
                this.mTJ.mo67378a(gameFloatLayerInfo.url, bundle2, false);
                i = 1;
                if (i == 0) {
                    kU.eBR = 1;
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(135810);
                            if (LuggageGameWebViewUI.this.isFinishing() || LuggageGameWebViewUI.this.uiu) {
                                AppMethodBeat.m2505o(135810);
                                return;
                            }
                            C46006b c = LuggageGameWebViewUI.this.mTJ;
                            String str = stringExtra;
                            Bundle extras = LuggageGameWebViewUI.this.getIntent().getExtras();
                            C8860e j = c.bPn.mo23952j(str, extras);
                            c.bPj.addView(j.getContentView(), 0);
                            c.bPk.add(j);
                            j.mo20038g(str, extras);
                            j.mo20044wT();
                            c.mo67384xc();
                            AppMethodBeat.m2505o(135810);
                        }
                    }, 300);
                    AppMethodBeat.m2505o(135811);
                    return;
                }
                this.mTJ.mo60236h(stringExtra, getIntent().getExtras());
                AppMethodBeat.m2505o(135811);
                return;
            }
        }
        i = 0;
        if (i == 0) {
        }
    }

    public void initSwipeBack() {
        AppMethodBeat.m2504i(135812);
        super.initSwipeBack();
        if (getSwipeBackLayout() == null) {
            AppMethodBeat.m2505o(135812);
            return;
        }
        View childAt = getSwipeBackLayout().getChildAt(0);
        getSwipeBackLayout().removeView(childAt);
        C7355b c7355b = new C7355b(this);
        if (childAt instanceof FrameLayout) {
            View childAt2 = ((FrameLayout) childAt).getChildAt(0);
            LayoutParams layoutParams = childAt2.getLayoutParams();
            ((FrameLayout) childAt).removeView(childAt2);
            c7355b.addView(childAt2, layoutParams);
        } else {
            c7355b.addView(childAt);
        }
        getSwipeBackLayout().addView(c7355b);
        getSwipeBackLayout().setContentView(c7355b);
        AppMethodBeat.m2505o(135812);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(135813);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        supportRequestWindowFeature(9);
        AppMethodBeat.m2505o(135813);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onResume() {
        AppMethodBeat.m2504i(135814);
        super.onResume();
        C4990ab.m7416i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
        this.mTJ.onResume();
        AppMethodBeat.m2505o(135814);
    }

    public void onPause() {
        AppMethodBeat.m2504i(135815);
        super.onPause();
        C4990ab.m7416i("MicroMsg.LuggageGameWebViewUI", "onPause");
        this.mTJ.onPause();
        AppMethodBeat.m2505o(135815);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(135816);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
        C28211b.mTH = null;
        C28211b.mHeaders = null;
        C28211b.f13696JQ = 0;
        this.mTJ.destroy();
        C35760c.clear();
        C4990ab.m7416i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            C4990ab.m7416i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
            String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 3; i++) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof View)) {
                        View view = (View) obj;
                        if (!(view.getContext() instanceof ContextWrapper)) {
                            if (view.getContext() != this) {
                                break;
                            }
                            declaredField.set(inputMethodManager, null);
                        } else if (((ContextWrapper) view.getContext()).getBaseContext() == this) {
                            declaredField.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", th, "", new Object[0]);
                }
            }
        }
        System.gc();
        AppMethodBeat.m2505o(135816);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(135817);
        if (!this.mTJ.mo67382wY()) {
            finish();
        }
        AppMethodBeat.m2505o(135817);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.m2504i(135818);
        C4990ab.m7417i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis()));
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
        AppMethodBeat.m2505o(135818);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(135819);
        super.onActivityResult(i, i2, intent);
        this.mTJ.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(135819);
    }

    public final void aBS() {
        AppMethodBeat.m2504i(135820);
        if (this.mTK != -1) {
            setRequestedOrientation(this.mTK);
            AppMethodBeat.m2505o(135820);
            return;
        }
        this.ylk = getSharedPreferences(C4996ah.doA(), 4).getBoolean("settings_landscape_mode", false);
        if (this.ylk) {
            setRequestedOrientation(-1);
            AppMethodBeat.m2505o(135820);
            return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.m2505o(135820);
    }

    /* renamed from: W */
    public final boolean mo62087W(int i, boolean z) {
        AppMethodBeat.m2504i(135821);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(135821);
            return false;
        } else if (getSwipeBackLayout() == null) {
            boolean c = C46417a.m87416c(this, i, z);
            AppMethodBeat.m2505o(135821);
            return c;
        } else if (VERSION.SDK_INT < 21 || getWindow() == null) {
            AppMethodBeat.m2505o(135821);
            return false;
        } else {
            C5540a.m8360d(getSwipeBackLayout().getChildAt(0), i, z);
            AppMethodBeat.m2505o(135821);
            return true;
        }
    }

    /* renamed from: NM */
    static /* synthetic */ boolean m66795NM(String str) {
        AppMethodBeat.m2504i(135822);
        if (C12146d.m20085NO(str) != null) {
            AppMethodBeat.m2505o(135822);
            return true;
        }
        AppMethodBeat.m2505o(135822);
        return false;
    }
}
