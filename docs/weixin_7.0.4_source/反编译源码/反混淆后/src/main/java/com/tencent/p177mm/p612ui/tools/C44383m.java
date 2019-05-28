package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.tools.m */
public final class C44383m {
    /* renamed from: a */
    public static void m80242a(Context context, ScrollView scrollView, View view, View view2, View view3) {
        AppMethodBeat.m2504i(107752);
        if (view3 == null) {
            AppMethodBeat.m2505o(107752);
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
                AppMethodBeat.m2504i(107751);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view4.getLayoutParams();
                int i = marginLayoutParams.topMargin;
                int fromDPToPix = C1338a.fromDPToPix(context2, this.zGK);
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
                        fromDPToPix = ((height - C5230ak.m7989hF(context2)) - C30036f.m47542de(context2)) - view4.getMeasuredHeight();
                        if (C5046bo.m7563gW(i, fromDPToPix)) {
                            AppMethodBeat.m2505o(107751);
                            return;
                        }
                        ViewGroup viewGroup = (ViewGroup) scrollView2.getChildAt(0);
                        if (C5046bo.m7500C(view4.getTag(), "no_first")) {
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
                        AppMethodBeat.m2505o(107751);
                        return;
                    } else if (C5046bo.m7563gW(i, fromDPToPix)) {
                        AppMethodBeat.m2505o(107751);
                        return;
                    } else {
                        ((ViewGroup) view4.getParent()).removeView(view4);
                        ((ViewGroup) view6.getParent()).addView(view4);
                    }
                } else if (C5046bo.m7563gW(i, fromDPToPix)) {
                    AppMethodBeat.m2505o(107751);
                    return;
                }
                marginLayoutParams.topMargin = fromDPToPix;
                view4.setVisibility(0);
                view4.setLayoutParams(marginLayoutParams);
                view4.requestLayout();
                AppMethodBeat.m2505o(107751);
            }
        });
        AppMethodBeat.m2505o(107752);
    }
}
