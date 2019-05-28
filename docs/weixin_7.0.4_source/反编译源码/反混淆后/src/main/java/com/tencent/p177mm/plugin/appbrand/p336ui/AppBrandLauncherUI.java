package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.plugin.appbrand.C10049aa;
import com.tencent.p177mm.plugin.appbrand.appusage.C19104i;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C26778d;
import com.tencent.p177mm.plugin.appbrand.appusage.C42382q;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.p1231o.C38452a;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C19766b;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C45705o;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.AppBrandLauncherRecommendList;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C19803c;
import com.tencent.p177mm.plugin.appbrand.p904k.C45633b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Locale;

@C18524i
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI */
public final class AppBrandLauncherUI extends MMActivity implements C19766b {
    public static final int iGI = C10049aa.gQs;
    private int cDB;
    private int iGJ = -1;
    private boolean iGK;
    private C45705o iGL;
    public C26778d iGM;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI$a */
    enum C2469a {
        WebSearch,
        StarList;

        static {
            AppMethodBeat.m2505o(132976);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI$1 */
    class C77171 implements Runnable {
        C77171() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132970);
            if (AppBrandLauncherUI.this.uiu || AppBrandLauncherUI.this.isFinishing()) {
                AppMethodBeat.m2505o(132970);
                return;
            }
            Fragment findFragmentById = AppBrandLauncherUI.m13748a(AppBrandLauncherUI.this).findFragmentById(16908290);
            if (findFragmentById == null || !(findFragmentById instanceof Fragment)) {
                AppMethodBeat.m2505o(132970);
                return;
            }
            ((Fragment) findFragmentById).aMf();
            AppMethodBeat.m2505o(132970);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI$2 */
    class C77182 implements OnMenuItemClickListener {
        C77182() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(132971);
            AppBrandLauncherUI.this.onBackPressed();
            AppMethodBeat.m2505o(132971);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI$3 */
    class C77193 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI$3$1 */
        class C77201 implements Runnable {
            C77201() {
            }

            public final void run() {
                Bundle toBundle;
                AppMethodBeat.m2504i(132972);
                if (VERSION.SDK_INT >= 21) {
                    toBundle = ActivityOptions.makeSceneTransitionAnimation(AppBrandLauncherUI.this, new Pair[0]).toBundle();
                } else {
                    toBundle = null;
                }
                AppBrandLauncherUI.this.startActivityForResult(((C42401a) C1720g.m3528K(C42401a.class)).mo21550D(AppBrandLauncherUI.this, AppBrandLauncherUI.this.cDB == 13 ? 52 : 201), 1, toBundle);
                AppMethodBeat.m2505o(132972);
            }
        }

        C77193() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(132973);
            ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new C77201());
            AppMethodBeat.m2505o(132973);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI$Fragment */
    public static abstract class Fragment extends android.support.p057v4.app.Fragment {
        /* renamed from: WL */
        public View f2134WL;
        public int gOW;
        private final C7306ak iGP = new C7306ak(Looper.getMainLooper());
        public String iGQ;

        public abstract int getLayoutId();

        public abstract void initView();

        public void aMf() {
        }

        public void setScene(int i) {
            this.gOW = i;
        }

        public final View getContentView() {
            return this.f2134WL;
        }

        @SuppressLint({"ResourceType"})
        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (getLayoutId() < 0) {
                this.f2134WL = new FrameLayout(viewGroup.getContext());
            } else {
                this.f2134WL = layoutInflater.inflate(getLayoutId(), null);
            }
            initView();
            return this.f2134WL;
        }

        /* renamed from: N */
        public final void mo17545N(Runnable runnable) {
            this.iGP.post(runnable);
        }

        public final void runOnUiThread(Runnable runnable) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(runnable);
            }
        }

        public final <T extends View> T aMg() {
            return this.f2134WL.findViewById(16908298);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: eE */
    public final void mo17538eE(boolean z) {
        AppMethodBeat.m2504i(132977);
        if (this.iGL != null) {
            this.iGL.mo17538eE(z);
        }
        if (z && this.iGM != null) {
            this.iGM.haa[4] = "1";
        }
        AppMethodBeat.m2505o(132977);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(132978);
        super.onCreateBeforeSetContentView();
        getWindow().setSoftInputMode(3);
        AppMethodBeat.m2505o(132978);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132979);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(132979);
        } else if (C19104i.axb()) {
            this.cDB = getIntent().getIntExtra("extra_enter_scene", -1);
            overridePendingTransition(C5206a.ync, C5206a.ynd);
            this.iGK = getIntent().getBooleanExtra("extra_show_recommend", false);
            boolean booleanExtra = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
            boolean aNF = C19803c.aNF();
            setTitleBarDoubleClickListener(new C77171());
            setMMTitle(getResources().getString(C25738R.string.f8887i9));
            setBackBtn(new C77182(), C1318a.actionbar_icon_dark_back);
            if (C38452a.aLC()) {
                addIconOptionMenu(C2469a.WebSearch.ordinal(), C25738R.string.ewn, C1318a.actionbar_icon_dark_search, new C77193(), null);
            }
            mo17446xE(-855310);
            findViewById(16908290).setBackgroundColor(-855310);
            C4990ab.m7417i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b", Boolean.valueOf(this.iGK), Boolean.valueOf(aNF));
            if (this.iGK && aNF && !booleanExtra) {
                getSupportFragmentManager().beginTransaction().mo556b(16908290, new AppBrandLauncherRecommendList()).commit();
            } else {
                Lifecycle lifecycle = getLifecycle();
                C45705o c45705o = new C45705o(this);
                this.iGL = c45705o;
                lifecycle.addObserver(c45705o);
            }
            C7060h.pYm.mo8378a(465, 0, 1, false);
            if (C38452a.aLC()) {
                long j;
                long currentTimeMillis = System.currentTimeMillis();
                Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC, null);
                if (obj == null || !(obj instanceof Long)) {
                    j = 0;
                } else {
                    j = ((Long) obj).longValue();
                }
                String language = Locale.getDefault().getLanguage();
                Object obj2 = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC, null);
                if (currentTimeMillis - j >= 3600000 || obj2 == null || !obj2.equals(language)) {
                    C1720g.m3535RO().eJo.mo14541a(new C45633b(), 0);
                }
                C4990ab.m7419v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", obj2, language, Long.valueOf(j), Long.valueOf(currentTimeMillis));
            } else {
                C4990ab.m7416i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
            }
            C45287c.aNX();
            if (C26776r.axv()) {
                this.iGM = new C26778d();
            }
            C26776r.axx();
            C19104i.axc();
            AppMethodBeat.m2505o(132979);
        } else {
            finish();
            AppMethodBeat.m2505o(132979);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(132980);
        if (isFinishing()) {
            AppMethodBeat.m2505o(132980);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(132980);
        return dispatchTouchEvent;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(132982);
        super.onDestroy();
        C42382q.clearData();
        if (this.iGM != null) {
            C7060h.pYm.mo8381e(14113, (Object[]) this.iGM.haa);
            this.iGM = null;
        }
        AppMethodBeat.m2505o(132982);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(132983);
        super.onActivityResult(i, i2, intent);
        this.iGJ = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            C4990ab.m7417i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", stringExtra, C45445b.fpE);
            C7060h.pYm.mo8381e(13929, stringExtra, C45445b.fpE, Integer.valueOf(2), Integer.valueOf(intExtra));
        }
        AppMethodBeat.m2505o(132983);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(132984);
        mo17368M(charSequence);
        AppMethodBeat.m2505o(132984);
    }

    public final void setTitle(int i) {
        AppMethodBeat.m2504i(132985);
        setMMTitle(i);
        AppMethodBeat.m2505o(132985);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(132986);
        finish();
        AppMethodBeat.m2505o(132986);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(132981);
        if (this.iGJ > 0) {
            int i = this.iGJ == 1 ? 7 : this.iGJ == 2 ? 6 : this.iGJ == 3 ? 9 : this.iGJ == 4 ? 12 : 4;
            this.iGJ = 0;
            Fragment fragment = (Fragment) super.getSupportFragmentManager().findFragmentById(16908290);
            if (fragment != null) {
                fragment.setScene(i);
            }
        }
        super.onResume();
        String abv = C45445b.abv();
        C46400aa.adH(abv);
        C46400aa.adI(abv);
        AppMethodBeat.m2505o(132981);
    }

    /* renamed from: a */
    static /* synthetic */ C0336i m13748a(AppBrandLauncherUI appBrandLauncherUI) {
        AppMethodBeat.m2504i(132987);
        C0336i supportFragmentManager = super.getSupportFragmentManager();
        AppMethodBeat.m2505o(132987);
        return supportFragmentManager;
    }
}
