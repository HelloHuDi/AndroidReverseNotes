package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.p */
public final class C4783p {
    private static int vvz = -1;

    /* renamed from: a */
    public static void m7142a(final View view, VideoSightView videoSightView) {
        AppMethodBeat.m2504i(70414);
        if (view == null || videoSightView == null) {
            C4990ab.m7412e("VideoSightHelper", "null view object " + view + "," + videoSightView);
            AppMethodBeat.m2505o(70414);
            return;
        }
        if (view.getVisibility() == 0) {
            videoSightView.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public final void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    AppMethodBeat.m2504i(70413);
                    int i9 = i4 - i2;
                    int i10 = i8 - i6;
                    if (i9 > 0 && i10 != i9) {
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(70412);
                                int height = (view.getResources().getDisplayMetrics().heightPixels - view.getHeight()) >>> 1;
                                int height2 = (int) ((((double) height) / 1.618d) - ((double) (view.getHeight() >>> 1)));
                                if (height2 >= 0) {
                                    if (C4783p.vvz < 0) {
                                        C4783p.vvz = C4977b.m7371b(view.getContext(), 20.0f);
                                    }
                                    if ((view.getHeight() + height2) + C4783p.vvz > height) {
                                        height = height2 - (((view.getHeight() + height2) + C4783p.vvz) - height);
                                    } else {
                                        height = height2;
                                    }
                                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                    if (height > 0 && height != layoutParams.bottomMargin) {
                                        C4990ab.m7416i("VideoSightHelper", "setting tip marginBottom ".concat(String.valueOf(height)));
                                        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, height);
                                        view.setLayoutParams(layoutParams);
                                    }
                                }
                                AppMethodBeat.m2505o(70412);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(70413);
                }
            });
        }
        AppMethodBeat.m2505o(70414);
    }
}
