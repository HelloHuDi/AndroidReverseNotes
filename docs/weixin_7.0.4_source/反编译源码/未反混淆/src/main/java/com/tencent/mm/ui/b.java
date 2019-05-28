package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    private Context mContext;
    private int voj;
    private boolean yeG = false;
    private View yeH;
    private int yeI;
    private LayoutParams yeJ;
    private int yeK;

    public static void c(Activity activity, boolean z) {
        AppMethodBeat.i(105943);
        b bVar = new b(activity, z);
        AppMethodBeat.o(105943);
    }

    public static void a(Activity activity, boolean z, View view) {
        AppMethodBeat.i(105944);
        b bVar = new b(activity, z, view);
        AppMethodBeat.o(105944);
    }

    private b(Activity activity, boolean z) {
        AppMethodBeat.i(105945);
        this.mContext = activity;
        this.yeG = z;
        this.yeH = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.yeH.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(105941);
                b.a(b.this);
                AppMethodBeat.o(105941);
            }
        });
        this.yeJ = this.yeH.getLayoutParams();
        AppMethodBeat.o(105945);
    }

    private b(Activity activity, boolean z, View view) {
        AppMethodBeat.i(105946);
        this.mContext = activity;
        this.yeG = z;
        this.yeH = view;
        this.yeH.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(105942);
                b.a(b.this);
                AppMethodBeat.o(105942);
            }
        });
        this.yeJ = this.yeH.getLayoutParams();
        AppMethodBeat.o(105946);
    }

    static /* synthetic */ void a(b bVar) {
        int i;
        Object obj = null;
        AppMethodBeat.i(105947);
        Rect rect = new Rect();
        bVar.yeH.getWindowVisibleDisplayFrame(rect);
        if (bVar.yeG) {
            i = rect.bottom - rect.top;
        } else {
            i = rect.bottom;
        }
        if (i != bVar.yeI) {
            int identifier;
            int height = bVar.yeH.getRootView().getHeight();
            int i2 = height - i;
            if (al.hw(bVar.mContext)) {
                if (al.hw(bVar.mContext)) {
                    identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
                    if (identifier > 0) {
                        identifier = Resources.getSystem().getDimensionPixelSize(identifier);
                    }
                }
                identifier = 0;
            } else {
                identifier = 0;
            }
            String str = Build.BRAND;
            if (!bo.isNullOrNil(str)) {
                str = str.toLowerCase();
                if ((str.contains("huawei") || str.contains("honor")) && VERSION.SDK_INT == 24) {
                    obj = 1;
                }
            }
            if (obj != null) {
                if (i2 > height / 4) {
                    bVar.yeJ.height = (height - i2) + ((int) ((((float) i) / ((float) bVar.voj)) * ((float) bVar.yeK)));
                } else {
                    bVar.yeJ.height = height - identifier;
                    bVar.voj = i;
                    bVar.yeK = bVar.yeJ.height - i;
                }
            } else if (i2 > height / 4) {
                bVar.yeJ.height = height - i2;
            } else {
                bVar.yeJ.height = i;
            }
            bVar.yeH.requestLayout();
            bVar.yeI = i;
        }
        AppMethodBeat.o(105947);
    }
}
