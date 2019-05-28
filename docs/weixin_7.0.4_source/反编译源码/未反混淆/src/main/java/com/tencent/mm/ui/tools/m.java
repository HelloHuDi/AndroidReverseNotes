package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ak;

public final class m {
    public static void a(Context context, ScrollView scrollView, View view, View view2, View view3) {
        AppMethodBeat.i(107752);
        if (view3 == null) {
            AppMethodBeat.o(107752);
            return;
        }
        final View view4 = view3;
        final Context context2 = context;
        final View view5 = view;
        final View view6 = view2;
        final ScrollView scrollView2 = scrollView;
        scrollView.post(new Runnable() {
            final /* synthetic */ int zGK = 72;

            public final void run() {
                AppMethodBeat.i(107751);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view4.getLayoutParams();
                int i = marginLayoutParams.topMargin;
                int fromDPToPix = a.fromDPToPix(context2, this.zGK);
                if (view5.getMeasuredHeight() > 0) {
                    int height = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getHeight();
                    int[] iArr = new int[2];
                    if (view6.getTag(view6.getId()) == null) {
                        view6.getLocationOnScreen(iArr);
                        view6.setTag(view6.getId(), iArr);
                    } else {
                        iArr = (int[]) view6.getTag(view6.getId());
                    }
                    if (height >= ((iArr[1] + view6.getMeasuredHeight()) + this.zGK) + view4.getMeasuredHeight()) {
                        fromDPToPix = ((height - ak.hF(context2)) - f.de(context2)) - view4.getMeasuredHeight();
                        if (bo.gW(i, fromDPToPix)) {
                            AppMethodBeat.o(107751);
                            return;
                        }
                        ViewGroup viewGroup = (ViewGroup) scrollView2.getChildAt(0);
                        if (bo.C(view4.getTag(), "no_first")) {
                            ((ViewGroup) view4.getParent()).removeView(view4);
                            viewGroup.addView(view4);
                        } else {
                            scrollView2.removeView(viewGroup);
                            LayoutParams layoutParams = new LayoutParams(-1, -2);
                            RelativeLayout relativeLayout = new RelativeLayout(context2);
                            relativeLayout.addView(viewGroup);
                            relativeLayout.setLayoutParams(layoutParams);
                            scrollView2.addView(relativeLayout);
                            ((ViewGroup) view4.getParent()).removeView(view4);
                            relativeLayout.addView(view4);
                        }
                        marginLayoutParams = (MarginLayoutParams) view4.getLayoutParams();
                        marginLayoutParams.topMargin = fromDPToPix;
                        marginLayoutParams.bottomMargin = 0;
                        view4.setLayoutParams(marginLayoutParams);
                        view4.setVisibility(0);
                        view4.setTag("no_first");
                        scrollView2.requestLayout();
                        AppMethodBeat.o(107751);
                        return;
                    } else if (bo.gW(i, fromDPToPix)) {
                        AppMethodBeat.o(107751);
                        return;
                    } else {
                        ((ViewGroup) view4.getParent()).removeView(view4);
                        ((ViewGroup) view6.getParent()).addView(view4);
                    }
                } else if (bo.gW(i, fromDPToPix)) {
                    AppMethodBeat.o(107751);
                    return;
                }
                marginLayoutParams.topMargin = fromDPToPix;
                view4.setVisibility(0);
                view4.setLayoutParams(marginLayoutParams);
                view4.requestLayout();
                AppMethodBeat.o(107751);
            }
        });
        AppMethodBeat.o(107752);
    }
}
