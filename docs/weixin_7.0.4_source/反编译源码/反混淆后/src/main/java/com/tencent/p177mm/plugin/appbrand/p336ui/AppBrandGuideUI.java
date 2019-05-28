package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19771b;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C10835f;
import com.tencent.p177mm.plugin.appbrand.report.model.C45677o;
import com.tencent.p177mm.plugin.appbrand.report.model.C45677o.C45676a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI */
public final class AppBrandGuideUI extends MMActivity implements C10835f {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI$2 */
    class C107632 implements OnClickListener {
        C107632() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(132956);
            C45677o.m84378a(C45676a.GUIDE_CLOSE, "");
            AppBrandGuideUI.this.finish();
            AppMethodBeat.m2505o(132956);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI$4 */
    class C107644 implements OnKeyListener {
        C107644() {
        }

        public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(132958);
            if (4 == i) {
                if (1 == keyEvent.getAction()) {
                    C45677o.m84378a(C45676a.GUIDE_CLOSE_BY_BACK, "");
                    AppBrandGuideUI.this.finish();
                }
                AppMethodBeat.m2505o(132958);
                return true;
            }
            AppMethodBeat.m2505o(132958);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI$3 */
    class C273193 implements OnClickListener {
        C273193() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(132957);
            AppBrandGuideUI.this.startActivity(new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
            C45677o.m84378a(C45676a.TO_APP_LAUNCHER, "");
            AppBrandGuideUI.this.finish();
            AppMethodBeat.m2505o(132957);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI$1 */
    class C335371 implements OnDismissListener {
        C335371() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(132955);
            AppBrandGuideUI.this.finish();
            AppMethodBeat.m2505o(132955);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI$a */
    public static final class C38522a implements ActivityLifecycleCallbacks, C10835f {
        public boolean iGD = false;
        String iGE;

        public static Application aMe() {
            AppMethodBeat.m2504i(132959);
            Application application = (Application) C4996ah.getContext().getApplicationContext();
            AppMethodBeat.m2505o(132959);
            return application;
        }

        /* renamed from: DV */
        public final void mo61249DV(String str) {
            this.iGD = true;
            this.iGE = str;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppBrandGuideUI) {
                this.iGD = false;
            }
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.m2504i(132960);
            if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
                this.iGD = false;
            }
            if (C1720g.m3531RK() && this.iGD) {
                boolean z;
                RunningTaskInfo av = C5046bo.m7523av(activity, activity.getTaskId());
                if (av == null || av.baseActivity == null) {
                    z = false;
                } else if (av.baseActivity.getClassName().endsWith(".LauncherUI") || !av.baseActivity.getClassName().contains(".AppBrandUI")) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.iGD = false;
                    activity.startActivity(new Intent(activity, AppBrandGuideUI.class));
                }
            }
            AppMethodBeat.m2505o(132960);
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        /* renamed from: bg */
        public final void mo6073bg(String str, int i) {
            this.iGD = false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(132961);
        setTheme(C25738R.style.f10637a7);
        super.onCreate(bundle);
        C5222ae.m7935a(getWindow());
        C38522a auN = C42340f.auN();
        if (auN == null) {
            super.finish();
            AppMethodBeat.m2505o(132961);
            return;
        }
        C19771b.m30603d(this);
        C5652a c5652a = new C5652a(this);
        c5652a.mo11446PV(C25738R.string.f8887i9);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(C25738R.drawable.aw5);
        TextView textView = new TextView(this);
        textView.setText(C25738R.string.f8919je);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LayoutParams(-1, -2));
        linearLayout.addView(textView, new LayoutParams(-1, -2));
        ((MarginLayoutParams) textView.getLayoutParams()).topMargin = C1338a.fromDPToPix(this, 16);
        c5652a.mo11479fn(linearLayout);
        c5652a.mo11458a(new C335371());
        c5652a.mo11454Qd(C25738R.string.ar5);
        c5652a.mo11476b(new C107632());
        c5652a.mo11453Qc(C25738R.string.f8918jd);
        c5652a.mo11462a(false, new C273193());
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(true);
        C5653c aMb = c5652a.aMb();
        aMb.setOnKeyListener(new C107644());
        aMb.show();
        C45677o.m84378a(C45676a.GUIDE_EXPOSE, auN.iGE);
        auN.iGD = false;
        auN.iGE = null;
        AppMethodBeat.m2505o(132961);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(132962);
        super.onDestroy();
        C19771b.m30602c(this);
        AppMethodBeat.m2505o(132962);
    }

    /* renamed from: bg */
    public final void mo6073bg(String str, int i) {
        AppMethodBeat.m2504i(132963);
        finish();
        AppMethodBeat.m2505o(132963);
    }
}
