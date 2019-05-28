package com.bumptech.glide.p086c.p088b.p785b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: com.bumptech.glide.c.b.b.i */
public final class C8519i {
    public final int aDj;
    public final int aDk;
    public final int aDl;
    private final Context context;

    /* renamed from: com.bumptech.glide.c.b.b.i$a */
    public static final class C8520a {
        static final int aDm = (VERSION.SDK_INT < 26 ? 4 : 1);
        ActivityManager aDn;
        C8521c aDo;
        float aDp = 2.0f;
        float aDq = ((float) aDm);
        float aDr = 0.4f;
        float aDs = 0.33f;
        int aDt = 4194304;
        final Context context;

        public C8520a(Context context) {
            AppMethodBeat.m2504i(91992);
            this.context = context;
            this.aDn = (ActivityManager) context.getSystemService("activity");
            this.aDo = new C8522b(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && C8519i.m15139a(this.aDn)) {
                this.aDq = 0.0f;
            }
            AppMethodBeat.m2505o(91992);
        }
    }

    /* renamed from: com.bumptech.glide.c.b.b.i$c */
    interface C8521c {
        /* renamed from: mY */
        int mo18624mY();

        /* renamed from: mZ */
        int mo18625mZ();
    }

    /* renamed from: com.bumptech.glide.c.b.b.i$b */
    static final class C8522b implements C8521c {
        private final DisplayMetrics aDu;

        C8522b(DisplayMetrics displayMetrics) {
            this.aDu = displayMetrics;
        }

        /* renamed from: mY */
        public final int mo18624mY() {
            return this.aDu.widthPixels;
        }

        /* renamed from: mZ */
        public final int mo18625mZ() {
            return this.aDu.heightPixels;
        }
    }

    public C8519i(C8520a c8520a) {
        int i;
        AppMethodBeat.m2504i(91993);
        this.context = c8520a.context;
        if (C8519i.m15139a(c8520a.aDn)) {
            i = c8520a.aDt / 2;
        } else {
            i = c8520a.aDt;
        }
        this.aDl = i;
        ActivityManager activityManager = c8520a.aDn;
        float f = c8520a.aDr;
        float f2 = c8520a.aDs;
        float memoryClass = (float) ((activityManager.getMemoryClass() * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (!C8519i.m15139a(activityManager)) {
            f2 = f;
        }
        int round = Math.round(f2 * memoryClass);
        i = (c8520a.aDo.mo18624mY() * c8520a.aDo.mo18625mZ()) * 4;
        int round2 = Math.round(((float) i) * c8520a.aDq);
        i = Math.round(((float) i) * c8520a.aDp);
        int i2 = round - this.aDl;
        if (i + round2 <= i2) {
            this.aDk = i;
            this.aDj = round2;
        } else {
            memoryClass = ((float) i2) / (c8520a.aDq + c8520a.aDp);
            this.aDk = Math.round(c8520a.aDp * memoryClass);
            this.aDj = Math.round(memoryClass * c8520a.aDq);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            new StringBuilder("Calculation complete, Calculated memory cache size: ").append(m15140df(this.aDk)).append(", pool size: ").append(m15140df(this.aDj)).append(", byte array size: ").append(m15140df(this.aDl)).append(", memory class limited? ").append(i + round2 > round).append(", max size: ").append(m15140df(round)).append(", memoryClass: ").append(c8520a.aDn.getMemoryClass()).append(", isLowMemoryDevice: ").append(C8519i.m15139a(c8520a.aDn));
        }
        AppMethodBeat.m2505o(91993);
    }

    /* renamed from: df */
    private String m15140df(int i) {
        AppMethodBeat.m2504i(91994);
        String formatFileSize = Formatter.formatFileSize(this.context, (long) i);
        AppMethodBeat.m2505o(91994);
        return formatFileSize;
    }

    @TargetApi(19)
    /* renamed from: a */
    static boolean m15139a(ActivityManager activityManager) {
        AppMethodBeat.m2504i(91995);
        if (VERSION.SDK_INT >= 19) {
            boolean isLowRamDevice = activityManager.isLowRamDevice();
            AppMethodBeat.m2505o(91995);
            return isLowRamDevice;
        }
        AppMethodBeat.m2505o(91995);
        return true;
    }
}
