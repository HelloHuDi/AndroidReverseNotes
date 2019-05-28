package com.tencent.p177mm.plugin.websearch.p1066ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.plugin.websearch.ui.a */
public final class C14430a {
    /* renamed from: cN */
    public static float m22662cN(Context context) {
        AppMethodBeat.m2504i(73811);
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float cL;
        if (attributes.screenBrightness < 0.0f) {
            cL = C14430a.m22661cL(context);
            AppMethodBeat.m2505o(73811);
            return cL;
        }
        cL = attributes.screenBrightness;
        AppMethodBeat.m2505o(73811);
        return cL;
    }

    /* renamed from: cL */
    private static float m22661cL(Context context) {
        AppMethodBeat.m2504i(73812);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(73812);
        return f;
    }

    /* renamed from: fQ */
    public static String m22663fQ(long j) {
        String str;
        AppMethodBeat.m2504i(73813);
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(j));
        AppMethodBeat.m2505o(73813);
        return str;
    }
}
