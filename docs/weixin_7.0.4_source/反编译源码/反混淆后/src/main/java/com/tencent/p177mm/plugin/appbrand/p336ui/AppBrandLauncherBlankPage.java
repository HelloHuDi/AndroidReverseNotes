package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage */
public final class AppBrandLauncherBlankPage extends Fragment {
    /* renamed from: cO */
    public static AppBrandLauncherBlankPage m65231cO(String str, String str2) {
        AppMethodBeat.m2504i(132966);
        AppBrandLauncherBlankPage appBrandLauncherBlankPage = new AppBrandLauncherBlankPage();
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_title", str);
        bundle.putString("extra_tip", str2);
        appBrandLauncherBlankPage.setArguments(bundle);
        AppMethodBeat.m2505o(132966);
        return appBrandLauncherBlankPage;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(132967);
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle(getArguments() == null ? "" : getArguments().getString("extra_title"));
        }
        AppMethodBeat.m2505o(132967);
    }

    public final void initView() {
        String str;
        AppMethodBeat.m2504i(132968);
        FragmentActivity activity = getActivity();
        if (getArguments() == null) {
            str = null;
        } else {
            str = getArguments().getString("extra_tip");
        }
        ((ViewGroup) this.f2134WL).addView(AppBrandLauncherBlankPage.m65230Y(activity, str), new LayoutParams(-1, -1));
        C19690c.m30495a(this.gOW, "", "", 0, "", this.iGQ);
        AppMethodBeat.m2505o(132968);
    }

    /* renamed from: Y */
    public static ViewGroup m65230Y(Context context, String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(132969);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C1318a.app_brand_launcher_blank_tip_icon);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C1338a.fromDPToPix(context, 50), C1338a.fromDPToPix(context, 50));
        layoutParams.topMargin = C1338a.fromDPToPix(context, 91);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#B2B2B2"));
        textView.setGravity(17);
        if (str2 == null) {
            str2 = "";
        }
        textView.setText(str2);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = C1338a.fromDPToPix(context, 16);
        layoutParams.gravity = 1;
        linearLayout.addView(textView, layoutParams);
        AppMethodBeat.m2505o(132969);
        return linearLayout;
    }
}
