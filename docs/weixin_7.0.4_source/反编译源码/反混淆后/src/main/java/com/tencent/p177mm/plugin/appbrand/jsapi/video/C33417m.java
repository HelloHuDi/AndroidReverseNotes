package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.m */
public final class C33417m {
    /* renamed from: cL */
    private static float m54607cL(Context context) {
        AppMethodBeat.m2504i(126590);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoPlayerUtils", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(126590);
        return f;
    }

    /* renamed from: cN */
    public static float m54608cN(Context context) {
        AppMethodBeat.m2504i(126591);
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float cL;
        if (attributes.screenBrightness < 0.0f) {
            cL = C33417m.m54607cL(context);
            AppMethodBeat.m2505o(126591);
            return cL;
        }
        cL = attributes.screenBrightness;
        AppMethodBeat.m2505o(126591);
        return cL;
    }

    /* renamed from: fQ */
    public static String m54609fQ(long j) {
        String str;
        AppMethodBeat.m2504i(126592);
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(j));
        AppMethodBeat.m2505o(126592);
        return str;
    }
}
