package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

public class Res {
    private static final String TAG = "Res";
    protected final String RclassName = (this.ctx.getPackageName() + ".R");
    protected Context ctx;

    public Res(Context context) {
        AppMethodBeat.m2504i(76281);
        this.ctx = context;
        AppMethodBeat.m2505o(76281);
    }

    private int reflectResouce(String str, String str2) {
        int i = -1;
        AppMethodBeat.m2504i(76282);
        if (this.RclassName == null || str == null || str2 == null) {
            AppMethodBeat.m2505o(76282);
            return 0;
        }
        try {
            Class cls = Class.forName(this.RclassName + "$" + str);
            i = C5046bo.getInt(cls.getField(str2).get(cls.newInstance()).toString(), -1);
            AppMethodBeat.m2505o(76282);
            return i;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(76282);
            return i;
        }
    }

    public int string(String str) {
        AppMethodBeat.m2504i(76283);
        int reflectResouce = reflectResouce("string", str);
        AppMethodBeat.m2505o(76283);
        return reflectResouce;
    }

    public int drawable(String str) {
        AppMethodBeat.m2504i(76284);
        int reflectResouce = reflectResouce("drawable", str);
        AppMethodBeat.m2505o(76284);
        return reflectResouce;
    }

    public int layout(String str) {
        AppMethodBeat.m2504i(76285);
        int reflectResouce = reflectResouce("layout", str);
        AppMethodBeat.m2505o(76285);
        return reflectResouce;
    }

    /* renamed from: id */
    public int mo65235id(String str) {
        AppMethodBeat.m2504i(76286);
        int reflectResouce = reflectResouce("id", str);
        AppMethodBeat.m2505o(76286);
        return reflectResouce;
    }

    public int style(String str) {
        AppMethodBeat.m2504i(76287);
        int reflectResouce = reflectResouce(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, str);
        AppMethodBeat.m2505o(76287);
        return reflectResouce;
    }
}
