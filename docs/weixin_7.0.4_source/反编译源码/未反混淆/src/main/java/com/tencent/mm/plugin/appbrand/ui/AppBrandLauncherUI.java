package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.aa;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.appusage.r.d;
import com.tencent.mm.plugin.appbrand.ui.a.b;
import com.tencent.mm.plugin.appbrand.ui.recents.o;
import com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import java.util.Locale;

@i
public final class AppBrandLauncherUI extends MMActivity implements b {
    public static final int iGI = aa.gQs;
    private int cDB;
    private int iGJ = -1;
    private boolean iGK;
    private o iGL;
    public d iGM;

    enum a {
        WebSearch,
        StarList;

        static {
            AppMethodBeat.o(132976);
        }
    }

    public static abstract class Fragment extends android.support.v4.app.Fragment {
        public View WL;
        public int gOW;
        private final ak iGP = new ak(Looper.getMainLooper());
        public String iGQ;

        public abstract int getLayoutId();

        public abstract void initView();

        public void aMf() {
        }

        public void setScene(int i) {
            this.gOW = i;
        }

        public final View getContentView() {
            return this.WL;
        }

        @SuppressLint({"ResourceType"})
        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (getLayoutId() < 0) {
                this.WL = new FrameLayout(viewGroup.getContext());
            } else {
                this.WL = layoutInflater.inflate(getLayoutId(), null);
            }
            initView();
            return this.WL;
        }

        public final void N(Runnable runnable) {
            this.iGP.post(runnable);
        }

        public final void runOnUiThread(Runnable runnable) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(runnable);
            }
        }

        public final <T extends View> T aMg() {
            return this.WL.findViewById(16908298);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void eE(boolean z) {
        AppMethodBeat.i(132977);
        if (this.iGL != null) {
            this.iGL.eE(z);
        }
        if (z && this.iGM != null) {
            this.iGM.haa[4] = "1";
        }
        AppMethodBeat.o(132977);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(132978);
        super.onCreateBeforeSetContentView();
        getWindow().setSoftInputMode(3);
        AppMethodBeat.o(132978);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(132979);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(132979);
        } else if (com.tencent.mm.plugin.appbrand.appusage.i.axb()) {
            this.cDB = getIntent().getIntExtra("extra_enter_scene", -1);
            overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.ync, com.tencent.mm.ui.MMFragmentActivity.a.ynd);
            this.iGK = getIntent().getBooleanExtra("extra_show_recommend", false);
            boolean booleanExtra = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
            boolean aNF = c.aNF();
            setTitleBarDoubleClickListener(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132970);
                    if (AppBrandLauncherUI.this.uiu || AppBrandLauncherUI.this.isFinishing()) {
                        AppMethodBeat.o(132970);
                        return;
                    }
                    android.support.v4.app.Fragment findFragmentById = AppBrandLauncherUI.a(AppBrandLauncherUI.this).findFragmentById(16908290);
                    if (findFragmentById == null || !(findFragmentById instanceof Fragment)) {
                        AppMethodBeat.o(132970);
                        return;
                    }
                    ((Fragment) findFragmentById).aMf();
                    AppMethodBeat.o(132970);
                }
            });
            setMMTitle(getResources().getString(R.string.i9));
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(132971);
                    AppBrandLauncherUI.this.onBackPressed();
                    AppMethodBeat.o(132971);
                    return true;
                }
            }, R.raw.actionbar_icon_dark_back);
            if (com.tencent.mm.plugin.appbrand.o.a.aLC()) {
                addIconOptionMenu(a.WebSearch.ordinal(), R.string.ewn, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(132973);
                        ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
                            public final void run() {
                                Bundle toBundle;
                                AppMethodBeat.i(132972);
                                if (VERSION.SDK_INT >= 21) {
                                    toBundle = ActivityOptions.makeSceneTransitionAnimation(AppBrandLauncherUI.this, new Pair[0]).toBundle();
                                } else {
                                    toBundle = null;
                                }
                                AppBrandLauncherUI.this.startActivityForResult(((com.tencent.mm.plugin.appbrand.compat.a.a) g.K(com.tencent.mm.plugin.appbrand.compat.a.a.class)).D(AppBrandLauncherUI.this, AppBrandLauncherUI.this.cDB == 13 ? 52 : 201), 1, toBundle);
                                AppMethodBeat.o(132972);
                            }
                        });
                        AppMethodBeat.o(132973);
                        return true;
                    }
                }, null);
            }
            xE(-855310);
            findViewById(16908290).setBackgroundColor(-855310);
            ab.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b", Boolean.valueOf(this.iGK), Boolean.valueOf(aNF));
            if (this.iGK && aNF && !booleanExtra) {
                getSupportFragmentManager().beginTransaction().b(16908290, new AppBrandLauncherRecommendList()).commit();
            } else {
                Lifecycle lifecycle = getLifecycle();
                o oVar = new o(this);
                this.iGL = oVar;
                lifecycle.addObserver(oVar);
            }
            h.pYm.a(465, 0, 1, false);
            if (com.tencent.mm.plugin.appbrand.o.a.aLC()) {
                long j;
                long currentTimeMillis = System.currentTimeMillis();
                Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC, null);
                if (obj == null || !(obj instanceof Long)) {
                    j = 0;
                } else {
                    j = ((Long) obj).longValue();
                }
                String language = Locale.getDefault().getLanguage();
                Object obj2 = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC, null);
                if (currentTimeMillis - j >= 3600000 || obj2 == null || !obj2.equals(language)) {
                    g.RO().eJo.a(new com.tencent.mm.plugin.appbrand.k.b(), 0);
                }
                ab.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", obj2, language, Long.valueOf(j), Long.valueOf(currentTimeMillis));
            } else {
                ab.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
            }
            com.tencent.mm.cj.c.aNX();
            if (r.axv()) {
                this.iGM = new d();
            }
            r.axx();
            com.tencent.mm.plugin.appbrand.appusage.i.axc();
            AppMethodBeat.o(132979);
        } else {
            finish();
            AppMethodBeat.o(132979);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(132980);
        if (isFinishing()) {
            AppMethodBeat.o(132980);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(132980);
        return dispatchTouchEvent;
    }

    public final void onDestroy() {
        AppMethodBeat.i(132982);
        super.onDestroy();
        q.clearData();
        if (this.iGM != null) {
            h.pYm.e(14113, (Object[]) this.iGM.haa);
            this.iGM = null;
        }
        AppMethodBeat.o(132982);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(132983);
        super.onActivityResult(i, i2, intent);
        this.iGJ = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            ab.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", stringExtra, com.tencent.mm.modelappbrand.b.fpE);
            h.pYm.e(13929, stringExtra, com.tencent.mm.modelappbrand.b.fpE, Integer.valueOf(2), Integer.valueOf(intExtra));
        }
        AppMethodBeat.o(132983);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(132984);
        M(charSequence);
        AppMethodBeat.o(132984);
    }

    public final void setTitle(int i) {
        AppMethodBeat.i(132985);
        setMMTitle(i);
        AppMethodBeat.o(132985);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(132986);
        finish();
        AppMethodBeat.o(132986);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.i(132981);
        if (this.iGJ > 0) {
            int i = this.iGJ == 1 ? 7 : this.iGJ == 2 ? 6 : this.iGJ == 3 ? 9 : this.iGJ == 4 ? 12 : 4;
            this.iGJ = 0;
            Fragment fragment = (Fragment) super.getSupportFragmentManager().findFragmentById(16908290);
            if (fragment != null) {
                fragment.setScene(i);
            }
        }
        super.onResume();
        String abv = com.tencent.mm.modelappbrand.b.abv();
        com.tencent.mm.plugin.websearch.api.aa.adH(abv);
        com.tencent.mm.plugin.websearch.api.aa.adI(abv);
        AppMethodBeat.o(132981);
    }

    static /* synthetic */ android.support.v4.app.i a(AppBrandLauncherUI appBrandLauncherUI) {
        AppMethodBeat.i(132987);
        android.support.v4.app.i supportFragmentManager = super.getSupportFragmentManager();
        AppMethodBeat.o(132987);
        return supportFragmentManager;
    }
}
