package com.tencent.p177mm.plugin.appbrand.p329s.p912c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.s.c.a */
public final class C45683a {
    private static final C10726a iSh = new C385051();

    /* renamed from: com.tencent.mm.plugin.appbrand.s.c.a$a */
    public static abstract class C10726a {
        public abstract int aOd();

        public abstract boolean aOe();

        /* renamed from: dc */
        public abstract void mo22280dc(Context context);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.c.a$b */
    static abstract class C33524b {
        public abstract Intent aOg();

        C33524b() {
        }

        /* renamed from: dd */
        public final void mo54001dd(Context context) {
            Intent aOg = aOg();
            if (!(context instanceof Activity)) {
                aOg.addFlags(268435456);
            }
            context.startActivity(aOg);
        }

        public final boolean aOf() {
            int i;
            List queryIntentActivities = C4996ah.getContext().getPackageManager().queryIntentActivities(aOg(), 0);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 && ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.exported) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.c.a$1 */
    static class C385051 extends C10726a {
        C385051() {
        }

        public final int aOd() {
            return -1;
        }

        /* renamed from: dc */
        public final void mo22280dc(Context context) {
        }

        public final boolean aOe() {
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(133600);
        AppMethodBeat.m2505o(133600);
    }

    public static C10726a aOc() {
        AppMethodBeat.m2504i(133599);
        C38506b c38506b = new C38506b();
        AppMethodBeat.m2505o(133599);
        return c38506b;
    }
}
