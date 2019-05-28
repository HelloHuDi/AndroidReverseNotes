package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.widget.a.c;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI extends MMActivity implements f {

    public static final class a implements ActivityLifecycleCallbacks, f {
        public boolean iGD = false;
        String iGE;

        public static Application aMe() {
            AppMethodBeat.i(132959);
            Application application = (Application) ah.getContext().getApplicationContext();
            AppMethodBeat.o(132959);
            return application;
        }

        public final void DV(String str) {
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
            AppMethodBeat.i(132960);
            if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
                this.iGD = false;
            }
            if (g.RK() && this.iGD) {
                boolean z;
                RunningTaskInfo av = bo.av(activity, activity.getTaskId());
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
            AppMethodBeat.o(132960);
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void bg(String str, int i) {
            this.iGD = false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(132961);
        setTheme(R.style.a7);
        super.onCreate(bundle);
        ae.a(getWindow());
        a auN = com.tencent.mm.plugin.appbrand.app.f.auN();
        if (auN == null) {
            super.finish();
            AppMethodBeat.o(132961);
            return;
        }
        b.d(this);
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
        aVar.PV(R.string.i9);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.aw5);
        TextView textView = new TextView(this);
        textView.setText(R.string.je);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LayoutParams(-1, -2));
        linearLayout.addView(textView, new LayoutParams(-1, -2));
        ((MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 16);
        aVar.fn(linearLayout);
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(132955);
                AppBrandGuideUI.this.finish();
                AppMethodBeat.o(132955);
            }
        });
        aVar.Qd(R.string.ar5);
        aVar.b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(132956);
                o.a(com.tencent.mm.plugin.appbrand.report.model.o.a.GUIDE_CLOSE, "");
                AppBrandGuideUI.this.finish();
                AppMethodBeat.o(132956);
            }
        });
        aVar.Qc(R.string.jd);
        aVar.a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(132957);
                AppBrandGuideUI.this.startActivity(new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
                o.a(com.tencent.mm.plugin.appbrand.report.model.o.a.TO_APP_LAUNCHER, "");
                AppBrandGuideUI.this.finish();
                AppMethodBeat.o(132957);
            }
        });
        aVar.rc(false);
        aVar.rd(true);
        c aMb = aVar.aMb();
        aMb.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(132958);
                if (4 == i) {
                    if (1 == keyEvent.getAction()) {
                        o.a(com.tencent.mm.plugin.appbrand.report.model.o.a.GUIDE_CLOSE_BY_BACK, "");
                        AppBrandGuideUI.this.finish();
                    }
                    AppMethodBeat.o(132958);
                    return true;
                }
                AppMethodBeat.o(132958);
                return false;
            }
        });
        aMb.show();
        o.a(com.tencent.mm.plugin.appbrand.report.model.o.a.GUIDE_EXPOSE, auN.iGE);
        auN.iGD = false;
        auN.iGE = null;
        AppMethodBeat.o(132961);
    }

    public final void onDestroy() {
        AppMethodBeat.i(132962);
        super.onDestroy();
        b.c(this);
        AppMethodBeat.o(132962);
    }

    public final void bg(String str, int i) {
        AppMethodBeat.i(132963);
        finish();
        AppMethodBeat.o(132963);
    }
}
