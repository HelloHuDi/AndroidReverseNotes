package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ae;

public final class a {
    public static final boolean jdd = (VERSION.SDK_INT < 20);
    public final Activity activity;
    public boolean jde = false;
    public int jdf = 0;

    public a(Activity activity) {
        this.activity = activity;
    }

    public final void aQi() {
        AppMethodBeat.i(123568);
        if (!this.jde || this.activity.isFinishing()) {
            AppMethodBeat.o(123568);
            return;
        }
        if (jdd) {
            n v = n.v(this.activity);
            if (v == null) {
                ab.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
                AppMethodBeat.o(123568);
                return;
            }
            a(v);
        }
        AppMethodBeat.o(123568);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(123569);
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int hA = ae.hA(this.activity);
        int i = point.y;
        if (aQj()) {
            hA = 0;
        }
        ab.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", Integer.valueOf(i - hA));
        nVar.setForceHeight(hA);
        AppMethodBeat.o(123569);
    }

    private boolean aQj() {
        AppMethodBeat.i(123570);
        if (this.activity.getWindow() == null || (this.activity.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) <= 0) {
            AppMethodBeat.o(123570);
            return false;
        }
        AppMethodBeat.o(123570);
        return true;
    }

    public static boolean dp(Context context) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(123571);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            z = resources.getBoolean(identifier);
        } else {
            z = false;
        }
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                z2 = false;
            } else {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                    z2 = true;
                }
                z2 = z;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(123571);
        return z2;
    }
}
