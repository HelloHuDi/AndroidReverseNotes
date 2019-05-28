package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.appbrand.widget.input.C2560am.C2561a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.a */
public final class C11006a {
    public static final boolean jdd = (VERSION.SDK_INT < 20);
    public final Activity activity;
    public boolean jde = false;
    public int jdf = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.a$1 */
    public class C110071 implements C2561a {
        public final void aQk() {
            AppMethodBeat.m2504i(123567);
            C4990ab.m7416i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onRootViewResized");
            C11006a.m18749a(C11006a.this);
            AppMethodBeat.m2505o(123567);
        }
    }

    public C11006a(Activity activity) {
        this.activity = activity;
    }

    public final void aQi() {
        AppMethodBeat.m2504i(123568);
        if (!this.jde || this.activity.isFinishing()) {
            AppMethodBeat.m2505o(123568);
            return;
        }
        if (jdd) {
            C42740n v = C42740n.m75744v(this.activity);
            if (v == null) {
                C4990ab.m7420w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
                AppMethodBeat.m2505o(123568);
                return;
            }
            mo22664a(v);
        }
        AppMethodBeat.m2505o(123568);
    }

    /* renamed from: a */
    public final void mo22664a(C42740n c42740n) {
        AppMethodBeat.m2504i(123569);
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int hA = C5222ae.m7947hA(this.activity);
        int i = point.y;
        if (aQj()) {
            hA = 0;
        }
        C4990ab.m7417i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", Integer.valueOf(i - hA));
        c42740n.setForceHeight(hA);
        AppMethodBeat.m2505o(123569);
    }

    private boolean aQj() {
        AppMethodBeat.m2504i(123570);
        if (this.activity.getWindow() == null || (this.activity.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) <= 0) {
            AppMethodBeat.m2505o(123570);
            return false;
        }
        AppMethodBeat.m2505o(123570);
        return true;
    }

    /* renamed from: dp */
    public static boolean m18750dp(Context context) {
        boolean z;
        boolean z2;
        AppMethodBeat.m2504i(123571);
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
        AppMethodBeat.m2505o(123571);
        return z2;
    }
}
