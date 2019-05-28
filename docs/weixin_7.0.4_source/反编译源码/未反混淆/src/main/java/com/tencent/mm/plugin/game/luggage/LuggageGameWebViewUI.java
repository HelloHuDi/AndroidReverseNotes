package com.tencent.mm.plugin.game.luggage;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.d.b;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.s;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.plugin.wepkg.event.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.lang.reflect.Field;

public class LuggageGameWebViewUI extends MMActivity {
    private b mTJ;
    private int mTK = -1;
    private boolean mTL = true;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(135811);
        super.onCreate(bundle);
        overridePendingTransition(a.yng, a.ynh);
        AppBrandMainProcessService.a(new ActiveMainProcessTask());
        long longExtra = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        ab.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", Long.valueOf(longExtra), Long.valueOf(System.currentTimeMillis()));
        final String stringExtra = getIntent().getStringExtra("rawUrl");
        if (bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.LuggageGameWebViewUI", "url is null");
            AppMethodBeat.o(135811);
            return;
        }
        int i;
        GameWebPerformanceInfo kU = GameWebPerformanceInfo.kU(stringExtra);
        kU.url = stringExtra;
        kU.eBT = getIntent().getLongExtra("gamecenterui_createtime", 0);
        kU.eBU = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        kU.startTime = getIntent().getLongExtra("start_time", kU.eBU);
        kU.eBZ = System.currentTimeMillis();
        kU.eBK = 1;
        kU.eBN = 1;
        ab.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", stringExtra, Long.valueOf(kU.startTime), Long.valueOf(kU.eBT), Long.valueOf(kU.eBU), Long.valueOf(kU.eBZ));
        g.az(stringExtra, System.currentTimeMillis());
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.mTJ = new b(this);
        setContentView((View) this.mTJ.bPj);
        this.mTJ.a((j) new j() {
            public final e j(String str, Bundle bundle) {
                GameWebPerformanceInfo kU;
                AppMethodBeat.i(135809);
                long currentTimeMillis = System.currentTimeMillis();
                ab.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", Long.valueOf(currentTimeMillis));
                bundle.putInt("minimize_secene", 3);
                boolean z = bundle.getBoolean("from_bag", false);
                boolean z2 = bundle.getBoolean("float_layer_page", false);
                if (LuggageGameWebViewUI.this.mTL || z2 || z || LuggageGameWebViewUI.NM(str)) {
                    kU = GameWebPerformanceInfo.kU(str);
                } else {
                    g.agg(str);
                    g.az(str, currentTimeMillis);
                    kU = GameWebPerformanceInfo.kV(str);
                }
                if (bo.isNullOrNil(kU.url)) {
                    ab.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", str);
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
                e aVar;
                if (z) {
                    com.tencent.mm.plugin.game.luggage.d.e eVar = new com.tencent.mm.plugin.game.luggage.d.e(LuggageGameWebViewUI.this.mTJ.bPq, m.a(LuggageGameWebViewUI.this.mController.ylL, Integer.valueOf(s.ujF)), bundle);
                    AppMethodBeat.o(135809);
                    return eVar;
                } else if (z2) {
                    aVar = new com.tencent.mm.plugin.game.luggage.d.a(LuggageGameWebViewUI.this.mTJ.bPq, bundle);
                    AppMethodBeat.o(135809);
                    return aVar;
                } else {
                    k aq = d.aq(LuggageGameWebViewUI.this.mController.ylL, str);
                    if (aq != null) {
                        aVar = new f(LuggageGameWebViewUI.this.mTJ.bPq, aq, bundle);
                        AppMethodBeat.o(135809);
                        return aVar;
                    }
                    aVar = new com.tencent.mm.plugin.game.luggage.d.e(LuggageGameWebViewUI.this.mTJ.bPq, null, bundle);
                    AppMethodBeat.o(135809);
                    return aVar;
                }
            }
        });
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) getIntent().getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams != null) {
            GameFloatLayerInfo gameFloatLayerInfo = gameWebViewLaunchParams.mTF;
            if (gameFloatLayerInfo != null) {
                GameWebPerformanceInfo kU2 = GameWebPerformanceInfo.kU(gameFloatLayerInfo.url);
                kU2.url = gameFloatLayerInfo.url;
                kU2.eBT = getIntent().getLongExtra("gamecenterui_createtime", 0);
                kU2.eBU = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
                kU2.startTime = getIntent().getLongExtra("start_time", kU2.eBU);
                kU2.eBZ = System.currentTimeMillis();
                kU2.eBK = 1;
                kU2.eBN = 1;
                g.az(gameFloatLayerInfo.url, System.currentTimeMillis());
                Bundle bundle2 = new Bundle();
                bundle2.putString("rawUrl", gameFloatLayerInfo.url);
                bundle2.putBoolean("show_full_screen", gameFloatLayerInfo.mTC);
                bundle2.putInt("screen_orientation", gameFloatLayerInfo.orientation);
                bundle2.putBoolean("float_layer_page", true);
                bundle2.putBoolean("needAnimation", false);
                bundle2.putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
                bundle2.putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
                this.mTJ.a(gameFloatLayerInfo.url, bundle2, false);
                i = 1;
                if (i == 0) {
                    kU.eBR = 1;
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(135810);
                            if (LuggageGameWebViewUI.this.isFinishing() || LuggageGameWebViewUI.this.uiu) {
                                AppMethodBeat.o(135810);
                                return;
                            }
                            b c = LuggageGameWebViewUI.this.mTJ;
                            String str = stringExtra;
                            Bundle extras = LuggageGameWebViewUI.this.getIntent().getExtras();
                            e j = c.bPn.j(str, extras);
                            c.bPj.addView(j.getContentView(), 0);
                            c.bPk.add(j);
                            j.g(str, extras);
                            j.wT();
                            c.xc();
                            AppMethodBeat.o(135810);
                        }
                    }, 300);
                    AppMethodBeat.o(135811);
                    return;
                }
                this.mTJ.h(stringExtra, getIntent().getExtras());
                AppMethodBeat.o(135811);
                return;
            }
        }
        i = 0;
        if (i == 0) {
        }
    }

    public void initSwipeBack() {
        AppMethodBeat.i(135812);
        super.initSwipeBack();
        if (getSwipeBackLayout() == null) {
            AppMethodBeat.o(135812);
            return;
        }
        View childAt = getSwipeBackLayout().getChildAt(0);
        getSwipeBackLayout().removeView(childAt);
        com.tencent.mm.ui.statusbar.b bVar = new com.tencent.mm.ui.statusbar.b(this);
        if (childAt instanceof FrameLayout) {
            View childAt2 = ((FrameLayout) childAt).getChildAt(0);
            LayoutParams layoutParams = childAt2.getLayoutParams();
            ((FrameLayout) childAt).removeView(childAt2);
            bVar.addView(childAt2, layoutParams);
        } else {
            bVar.addView(childAt);
        }
        getSwipeBackLayout().addView(bVar);
        getSwipeBackLayout().setContentView(bVar);
        AppMethodBeat.o(135812);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(135813);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        supportRequestWindowFeature(9);
        AppMethodBeat.o(135813);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onResume() {
        AppMethodBeat.i(135814);
        super.onResume();
        ab.i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
        this.mTJ.onResume();
        AppMethodBeat.o(135814);
    }

    public void onPause() {
        AppMethodBeat.i(135815);
        super.onPause();
        ab.i("MicroMsg.LuggageGameWebViewUI", "onPause");
        this.mTJ.onPause();
        AppMethodBeat.o(135815);
    }

    public void onDestroy() {
        AppMethodBeat.i(135816);
        super.onDestroy();
        ab.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
        b.mTH = null;
        b.mHeaders = null;
        b.JQ = 0;
        this.mTJ.destroy();
        c.clear();
        ab.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            ab.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
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
                    ab.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", th, "", new Object[0]);
                }
            }
        }
        System.gc();
        AppMethodBeat.o(135816);
    }

    public void onBackPressed() {
        AppMethodBeat.i(135817);
        if (!this.mTJ.wY()) {
            finish();
        }
        AppMethodBeat.o(135817);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(135818);
        ab.i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis()));
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
        AppMethodBeat.o(135818);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(135819);
        super.onActivityResult(i, i2, intent);
        this.mTJ.onActivityResult(i, i2, intent);
        AppMethodBeat.o(135819);
    }

    public final void aBS() {
        AppMethodBeat.i(135820);
        if (this.mTK != -1) {
            setRequestedOrientation(this.mTK);
            AppMethodBeat.o(135820);
            return;
        }
        this.ylk = getSharedPreferences(ah.doA(), 4).getBoolean("settings_landscape_mode", false);
        if (this.ylk) {
            setRequestedOrientation(-1);
            AppMethodBeat.o(135820);
            return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(135820);
    }

    public final boolean W(int i, boolean z) {
        AppMethodBeat.i(135821);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(135821);
            return false;
        } else if (getSwipeBackLayout() == null) {
            boolean c = com.tencent.mm.plugin.webview.luggage.c.a.c(this, i, z);
            AppMethodBeat.o(135821);
            return c;
        } else if (VERSION.SDK_INT < 21 || getWindow() == null) {
            AppMethodBeat.o(135821);
            return false;
        } else {
            com.tencent.mm.ui.statusbar.a.d(getSwipeBackLayout().getChildAt(0), i, z);
            AppMethodBeat.o(135821);
            return true;
        }
    }

    static /* synthetic */ boolean NM(String str) {
        AppMethodBeat.i(135822);
        if (d.NO(str) != null) {
            AppMethodBeat.o(135822);
            return true;
        }
        AppMethodBeat.o(135822);
        return false;
    }
}
