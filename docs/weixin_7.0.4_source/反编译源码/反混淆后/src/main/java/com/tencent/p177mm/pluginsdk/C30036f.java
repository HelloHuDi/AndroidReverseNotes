package com.tencent.p177mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.p069v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1441a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.f */
public final class C30036f {
    /* renamed from: fD */
    public static int m47543fD(Context context) {
        AppMethodBeat.m2504i(105827);
        int i = 0;
        if (context instanceof MMActivity) {
            i = ((MMActivity) context).mController.getTitleLocation();
        }
        if (i <= 0) {
            i = context.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
        }
        AppMethodBeat.m2505o(105827);
        return i;
    }

    /* renamed from: ah */
    public static void m47540ah(Activity activity) {
        AppMethodBeat.m2504i(105828);
        if (VERSION.SDK_INT >= 16) {
            if (activity instanceof AppCompatActivity) {
                ((AppCompatActivity) activity).supportRequestWindowFeature(109);
                AppMethodBeat.m2505o(105828);
                return;
            }
            activity.requestWindowFeature(9);
        }
        AppMethodBeat.m2505o(105828);
    }

    /* renamed from: m */
    public static void m47544m(MMActivity mMActivity) {
        AppMethodBeat.m2504i(105829);
        if (VERSION.SDK_INT >= 16) {
            mMActivity.supportRequestWindowFeature(109);
        }
        AppMethodBeat.m2505o(105829);
    }

    /* renamed from: n */
    public static void m47545n(final MMActivity mMActivity) {
        AppMethodBeat.m2504i(105830);
        if (VERSION.SDK_INT >= 16) {
            mMActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(105824);
                    mMActivity.getWindow().getDecorView().setSystemUiVisibility(mMActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    C4990ab.m7417i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", Integer.valueOf(C1441a.m3065bG(mMActivity)), Integer.valueOf(C1338a.fromDPToPix(mMActivity, 2)));
                    mMActivity.mController.ylv.setPadding(0, r0 - C1338a.fromDPToPix(mMActivity, 2), 0, 0);
                    AppMethodBeat.m2505o(105824);
                }
            });
        }
        AppMethodBeat.m2505o(105830);
    }

    /* renamed from: a */
    public static void m47539a(final MMFragmentActivity mMFragmentActivity, final View view) {
        AppMethodBeat.m2504i(105831);
        if (mMFragmentActivity == null) {
            AppMethodBeat.m2505o(105831);
            return;
        }
        if (!(VERSION.SDK_INT < 16 || mMFragmentActivity.getWindow() == null || mMFragmentActivity.getWindow().getDecorView() == null)) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(105825);
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    C4990ab.m7417i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(C1441a.m3065bG(mMFragmentActivity)));
                    if (view != null) {
                        view.setPadding(0, r0, 0, 0);
                    }
                    AppMethodBeat.m2505o(105825);
                }
            });
        }
        AppMethodBeat.m2505o(105831);
    }

    /* renamed from: b */
    public static void m47541b(final MMFragmentActivity mMFragmentActivity, final View view) {
        AppMethodBeat.m2504i(105832);
        if (mMFragmentActivity == null) {
            AppMethodBeat.m2505o(105832);
            return;
        }
        if (!(VERSION.SDK_INT < 16 || mMFragmentActivity.getWindow() == null || mMFragmentActivity.getWindow().getDecorView() == null)) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                final /* synthetic */ int val$height = 0;

                public final void run() {
                    AppMethodBeat.m2504i(105826);
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    C4990ab.m7417i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(this.val$height));
                    if (view != null) {
                        view.setPadding(0, this.val$height, 0, 0);
                    }
                    AppMethodBeat.m2505o(105826);
                }
            });
        }
        AppMethodBeat.m2505o(105832);
    }

    /* renamed from: de */
    public static int m47542de(Context context) {
        AppMethodBeat.m2504i(105833);
        int i = 0;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C25738R.attr.f5618dx, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i <= 0) {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i = context.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
            } else {
                i = context.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            }
        }
        AppMethodBeat.m2505o(105833);
        return i;
    }
}
