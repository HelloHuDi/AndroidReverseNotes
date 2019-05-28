package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class m {
    private static float cL(Context context) {
        AppMethodBeat.i(126590);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.VideoPlayerUtils", e, "", new Object[0]);
        }
        AppMethodBeat.o(126590);
        return f;
    }

    public static float cN(Context context) {
        AppMethodBeat.i(126591);
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float cL;
        if (attributes.screenBrightness < 0.0f) {
            cL = cL(context);
            AppMethodBeat.o(126591);
            return cL;
        }
        cL = attributes.screenBrightness;
        AppMethodBeat.o(126591);
        return cL;
    }

    public static String fQ(long j) {
        String str;
        AppMethodBeat.i(126592);
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(j));
        AppMethodBeat.o(126592);
        return str;
    }
}
