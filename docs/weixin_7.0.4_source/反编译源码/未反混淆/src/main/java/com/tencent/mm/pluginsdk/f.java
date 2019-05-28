package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;

public final class f {
    public static int fD(Context context) {
        AppMethodBeat.i(105827);
        int i = 0;
        if (context instanceof MMActivity) {
            i = ((MMActivity) context).mController.getTitleLocation();
        }
        if (i <= 0) {
            i = context.getResources().getDimensionPixelSize(R.dimen.fd);
        }
        AppMethodBeat.o(105827);
        return i;
    }

    public static void ah(Activity activity) {
        AppMethodBeat.i(105828);
        if (VERSION.SDK_INT >= 16) {
            if (activity instanceof AppCompatActivity) {
                ((AppCompatActivity) activity).supportRequestWindowFeature(109);
                AppMethodBeat.o(105828);
                return;
            }
            activity.requestWindowFeature(9);
        }
        AppMethodBeat.o(105828);
    }

    public static void m(MMActivity mMActivity) {
        AppMethodBeat.i(105829);
        if (VERSION.SDK_INT >= 16) {
            mMActivity.supportRequestWindowFeature(109);
        }
        AppMethodBeat.o(105829);
    }

    public static void n(final MMActivity mMActivity) {
        AppMethodBeat.i(105830);
        if (VERSION.SDK_INT >= 16) {
            mMActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(105824);
                    mMActivity.getWindow().getDecorView().setSystemUiVisibility(mMActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    ab.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", Integer.valueOf(a.bG(mMActivity)), Integer.valueOf(com.tencent.mm.bz.a.fromDPToPix(mMActivity, 2)));
                    mMActivity.mController.ylv.setPadding(0, r0 - com.tencent.mm.bz.a.fromDPToPix(mMActivity, 2), 0, 0);
                    AppMethodBeat.o(105824);
                }
            });
        }
        AppMethodBeat.o(105830);
    }

    public static void a(final MMFragmentActivity mMFragmentActivity, final View view) {
        AppMethodBeat.i(105831);
        if (mMFragmentActivity == null) {
            AppMethodBeat.o(105831);
            return;
        }
        if (!(VERSION.SDK_INT < 16 || mMFragmentActivity.getWindow() == null || mMFragmentActivity.getWindow().getDecorView() == null)) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(105825);
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    ab.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(a.bG(mMFragmentActivity)));
                    if (view != null) {
                        view.setPadding(0, r0, 0, 0);
                    }
                    AppMethodBeat.o(105825);
                }
            });
        }
        AppMethodBeat.o(105831);
    }

    public static void b(final MMFragmentActivity mMFragmentActivity, final View view) {
        AppMethodBeat.i(105832);
        if (mMFragmentActivity == null) {
            AppMethodBeat.o(105832);
            return;
        }
        if (!(VERSION.SDK_INT < 16 || mMFragmentActivity.getWindow() == null || mMFragmentActivity.getWindow().getDecorView() == null)) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                final /* synthetic */ int val$height = 0;

                public final void run() {
                    AppMethodBeat.i(105826);
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 256);
                    ab.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(this.val$height));
                    if (view != null) {
                        view.setPadding(0, this.val$height, 0, 0);
                    }
                    AppMethodBeat.o(105826);
                }
            });
        }
        AppMethodBeat.o(105832);
    }

    public static int de(Context context) {
        AppMethodBeat.i(105833);
        int i = 0;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.dx, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i <= 0) {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                i = context.getResources().getDimensionPixelSize(R.dimen.fc);
            } else {
                i = context.getResources().getDimensionPixelSize(R.dimen.fd);
            }
        }
        AppMethodBeat.o(105833);
        return i;
    }
}
