package com.bumptech.glide.c.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class i {
    public final int aDj;
    public final int aDk;
    public final int aDl;
    private final Context context;

    public static final class a {
        static final int aDm = (VERSION.SDK_INT < 26 ? 4 : 1);
        ActivityManager aDn;
        c aDo;
        float aDp = 2.0f;
        float aDq = ((float) aDm);
        float aDr = 0.4f;
        float aDs = 0.33f;
        int aDt = 4194304;
        final Context context;

        public a(Context context) {
            AppMethodBeat.i(91992);
            this.context = context;
            this.aDn = (ActivityManager) context.getSystemService("activity");
            this.aDo = new b(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && i.a(this.aDn)) {
                this.aDq = 0.0f;
            }
            AppMethodBeat.o(91992);
        }
    }

    interface c {
        int mY();

        int mZ();
    }

    static final class b implements c {
        private final DisplayMetrics aDu;

        b(DisplayMetrics displayMetrics) {
            this.aDu = displayMetrics;
        }

        public final int mY() {
            return this.aDu.widthPixels;
        }

        public final int mZ() {
            return this.aDu.heightPixels;
        }
    }

    public i(a aVar) {
        int i;
        AppMethodBeat.i(91993);
        this.context = aVar.context;
        if (a(aVar.aDn)) {
            i = aVar.aDt / 2;
        } else {
            i = aVar.aDt;
        }
        this.aDl = i;
        ActivityManager activityManager = aVar.aDn;
        float f = aVar.aDr;
        float f2 = aVar.aDs;
        float memoryClass = (float) ((activityManager.getMemoryClass() * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (!a(activityManager)) {
            f2 = f;
        }
        int round = Math.round(f2 * memoryClass);
        i = (aVar.aDo.mY() * aVar.aDo.mZ()) * 4;
        int round2 = Math.round(((float) i) * aVar.aDq);
        i = Math.round(((float) i) * aVar.aDp);
        int i2 = round - this.aDl;
        if (i + round2 <= i2) {
            this.aDk = i;
            this.aDj = round2;
        } else {
            memoryClass = ((float) i2) / (aVar.aDq + aVar.aDp);
            this.aDk = Math.round(aVar.aDp * memoryClass);
            this.aDj = Math.round(memoryClass * aVar.aDq);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            new StringBuilder("Calculation complete, Calculated memory cache size: ").append(df(this.aDk)).append(", pool size: ").append(df(this.aDj)).append(", byte array size: ").append(df(this.aDl)).append(", memory class limited? ").append(i + round2 > round).append(", max size: ").append(df(round)).append(", memoryClass: ").append(aVar.aDn.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(aVar.aDn));
        }
        AppMethodBeat.o(91993);
    }

    private String df(int i) {
        AppMethodBeat.i(91994);
        String formatFileSize = Formatter.formatFileSize(this.context, (long) i);
        AppMethodBeat.o(91994);
        return formatFileSize;
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        AppMethodBeat.i(91995);
        if (VERSION.SDK_INT >= 19) {
            boolean isLowRamDevice = activityManager.isLowRamDevice();
            AppMethodBeat.o(91995);
            return isLowRamDevice;
        }
        AppMethodBeat.o(91995);
        return true;
    }
}
