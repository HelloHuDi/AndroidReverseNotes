package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;

public final class AppBrandLauncherBlankPage extends Fragment {
    public static AppBrandLauncherBlankPage cO(String str, String str2) {
        AppMethodBeat.i(132966);
        AppBrandLauncherBlankPage appBrandLauncherBlankPage = new AppBrandLauncherBlankPage();
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_title", str);
        bundle.putString("extra_tip", str2);
        appBrandLauncherBlankPage.setArguments(bundle);
        AppMethodBeat.o(132966);
        return appBrandLauncherBlankPage;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.i(132967);
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle(getArguments() == null ? "" : getArguments().getString("extra_title"));
        }
        AppMethodBeat.o(132967);
    }

    public final void initView() {
        String str;
        AppMethodBeat.i(132968);
        FragmentActivity activity = getActivity();
        if (getArguments() == null) {
            str = null;
        } else {
            str = getArguments().getString("extra_tip");
        }
        ((ViewGroup) this.WL).addView(Y(activity, str), new LayoutParams(-1, -1));
        c.a(this.gOW, "", "", 0, "", this.iGQ);
        AppMethodBeat.o(132968);
    }

    public static ViewGroup Y(Context context, String str) {
        CharSequence str2;
        AppMethodBeat.i(132969);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.raw.app_brand_launcher_blank_tip_icon);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(context, 50), a.fromDPToPix(context, 50));
        layoutParams.topMargin = a.fromDPToPix(context, 91);
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
        layoutParams.topMargin = a.fromDPToPix(context, 16);
        layoutParams.gravity = 1;
        linearLayout.addView(textView, layoutParams);
        AppMethodBeat.o(132969);
        return linearLayout;
    }
}
