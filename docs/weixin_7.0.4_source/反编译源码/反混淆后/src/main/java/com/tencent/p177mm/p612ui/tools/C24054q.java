package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.tools.q */
public final class C24054q {
    private static C24054q zHV = null;
    private ColorStateList[] yDX = new ColorStateList[2];
    private boolean zHW = false;

    private C24054q(Context context) {
        AppMethodBeat.m2504i(107808);
        this.yDX[0] = C1338a.m2870h(context, (int) C25738R.color.a7z);
        this.yDX[1] = C1338a.m2870h(context, (int) C25738R.color.a80);
        AppMethodBeat.m2505o(107808);
    }

    /* renamed from: ih */
    private static C24054q m37012ih(Context context) {
        AppMethodBeat.m2504i(107809);
        Assert.assertTrue(context != null);
        if (zHV == null || !zHV.zHW) {
            zHV = new C24054q(context);
        }
        C24054q c24054q = zHV;
        AppMethodBeat.m2505o(107809);
        return c24054q;
    }

    /* renamed from: ii */
    public static ColorStateList m37013ii(Context context) {
        AppMethodBeat.m2504i(107810);
        ColorStateList colorStateList = C24054q.m37012ih(context).yDX[0];
        AppMethodBeat.m2505o(107810);
        return colorStateList;
    }

    /* renamed from: ij */
    public static ColorStateList m37014ij(Context context) {
        AppMethodBeat.m2504i(107811);
        ColorStateList colorStateList = C24054q.m37012ih(context).yDX[1];
        AppMethodBeat.m2505o(107811);
        return colorStateList;
    }
}
