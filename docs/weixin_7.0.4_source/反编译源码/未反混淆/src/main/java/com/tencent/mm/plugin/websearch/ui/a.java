package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class a {
    public static float cN(Context context) {
        AppMethodBeat.i(73811);
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float cL;
        if (attributes.screenBrightness < 0.0f) {
            cL = cL(context);
            AppMethodBeat.o(73811);
            return cL;
        }
        cL = attributes.screenBrightness;
        AppMethodBeat.o(73811);
        return cL;
    }

    private static float cL(Context context) {
        AppMethodBeat.i(73812);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (Exception e) {
        }
        AppMethodBeat.o(73812);
        return f;
    }

    public static String fQ(long j) {
        String str;
        AppMethodBeat.i(73813);
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(j));
        AppMethodBeat.o(73813);
        return str;
    }
}
