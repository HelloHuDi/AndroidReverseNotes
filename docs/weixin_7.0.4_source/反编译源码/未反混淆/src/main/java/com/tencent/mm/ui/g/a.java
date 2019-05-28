package com.tencent.mm.ui.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static b zzB;
    private static b zzC;

    @TargetApi(11)
    public static void a(Activity activity, View view) {
        AppMethodBeat.i(107423);
        View decorView = activity.getWindow().getDecorView();
        zzB = b.ig(activity);
        zzC = b.ig(activity);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        int height = ((AppCompatActivity) activity).getSupportActionBar().getHeight();
        zzB.setHeight((iArr[1] - i) - height);
        zzC.setHeight((db(activity)[1] - iArr[1]) - view.getHeight());
        zzB.showAtLocation(decorView, 48, 0, height + i);
        zzC.showAtLocation(decorView, 80, 0, 0);
        AppMethodBeat.o(107423);
    }

    public static void dismiss() {
        AppMethodBeat.i(107424);
        if (zzB != null) {
            zzB.setAnimationStyle(-1);
            zzB.dismiss();
            zzB = null;
        }
        if (zzC != null) {
            zzC.setAnimationStyle(-1);
            zzC.dismiss();
            zzC = null;
        }
        AppMethodBeat.o(107424);
    }

    private static int[] db(Context context) {
        AppMethodBeat.i(107425);
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.o(107425);
        return iArr;
    }
}
