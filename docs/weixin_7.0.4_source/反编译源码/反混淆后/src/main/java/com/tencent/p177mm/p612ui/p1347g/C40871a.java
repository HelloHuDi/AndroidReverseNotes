package com.tencent.p177mm.p612ui.p1347g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.p069v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.g.a */
public final class C40871a {
    private static C24005b zzB;
    private static C24005b zzC;

    @TargetApi(11)
    /* renamed from: a */
    public static void m70821a(Activity activity, View view) {
        AppMethodBeat.m2504i(107423);
        View decorView = activity.getWindow().getDecorView();
        zzB = C24005b.m36990ig(activity);
        zzC = C24005b.m36990ig(activity);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        int height = ((AppCompatActivity) activity).getSupportActionBar().getHeight();
        zzB.setHeight((iArr[1] - i) - height);
        zzC.setHeight((C40871a.m70822db(activity)[1] - iArr[1]) - view.getHeight());
        zzB.showAtLocation(decorView, 48, 0, height + i);
        zzC.showAtLocation(decorView, 80, 0, 0);
        AppMethodBeat.m2505o(107423);
    }

    public static void dismiss() {
        AppMethodBeat.m2504i(107424);
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
        AppMethodBeat.m2505o(107424);
    }

    /* renamed from: db */
    private static int[] m70822db(Context context) {
        AppMethodBeat.m2504i(107425);
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
        AppMethodBeat.m2505o(107425);
        return iArr;
    }
}
