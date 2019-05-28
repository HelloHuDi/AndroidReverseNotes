package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.b */
public final class C5240b {
    private Context mContext;
    private int voj;
    private boolean yeG = false;
    private View yeH;
    private int yeI;
    private LayoutParams yeJ;
    private int yeK;

    /* renamed from: com.tencent.mm.ui.b$1 */
    class C52411 implements OnGlobalLayoutListener {
        C52411() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(105941);
            C5240b.m8008a(C5240b.this);
            AppMethodBeat.m2505o(105941);
        }
    }

    /* renamed from: com.tencent.mm.ui.b$2 */
    class C52422 implements OnGlobalLayoutListener {
        C52422() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(105942);
            C5240b.m8008a(C5240b.this);
            AppMethodBeat.m2505o(105942);
        }
    }

    /* renamed from: c */
    public static void m8009c(Activity activity, boolean z) {
        AppMethodBeat.m2504i(105943);
        C5240b c5240b = new C5240b(activity, z);
        AppMethodBeat.m2505o(105943);
    }

    /* renamed from: a */
    public static void m8007a(Activity activity, boolean z, View view) {
        AppMethodBeat.m2504i(105944);
        C5240b c5240b = new C5240b(activity, z, view);
        AppMethodBeat.m2505o(105944);
    }

    private C5240b(Activity activity, boolean z) {
        AppMethodBeat.m2504i(105945);
        this.mContext = activity;
        this.yeG = z;
        this.yeH = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.yeH.getViewTreeObserver().addOnGlobalLayoutListener(new C52411());
        this.yeJ = this.yeH.getLayoutParams();
        AppMethodBeat.m2505o(105945);
    }

    private C5240b(Activity activity, boolean z, View view) {
        AppMethodBeat.m2504i(105946);
        this.mContext = activity;
        this.yeG = z;
        this.yeH = view;
        this.yeH.getViewTreeObserver().addOnGlobalLayoutListener(new C52422());
        this.yeJ = this.yeH.getLayoutParams();
        AppMethodBeat.m2505o(105946);
    }

    /* renamed from: a */
    static /* synthetic */ void m8008a(C5240b c5240b) {
        int i;
        Object obj = null;
        AppMethodBeat.m2504i(105947);
        Rect rect = new Rect();
        c5240b.yeH.getWindowVisibleDisplayFrame(rect);
        if (c5240b.yeG) {
            i = rect.bottom - rect.top;
        } else {
            i = rect.bottom;
        }
        if (i != c5240b.yeI) {
            int identifier;
            int height = c5240b.yeH.getRootView().getHeight();
            int i2 = height - i;
            if (C5231al.m7994hw(c5240b.mContext)) {
                if (C5231al.m7994hw(c5240b.mContext)) {
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
            if (!C5046bo.isNullOrNil(str)) {
                str = str.toLowerCase();
                if ((str.contains("huawei") || str.contains("honor")) && VERSION.SDK_INT == 24) {
                    obj = 1;
                }
            }
            if (obj != null) {
                if (i2 > height / 4) {
                    c5240b.yeJ.height = (height - i2) + ((int) ((((float) i) / ((float) c5240b.voj)) * ((float) c5240b.yeK)));
                } else {
                    c5240b.yeJ.height = height - identifier;
                    c5240b.voj = i;
                    c5240b.yeK = c5240b.yeJ.height - i;
                }
            } else if (i2 > height / 4) {
                c5240b.yeJ.height = height - i2;
            } else {
                c5240b.yeJ.height = i;
            }
            c5240b.yeH.requestLayout();
            c5240b.yeI = i;
        }
        AppMethodBeat.m2505o(105947);
    }
}
