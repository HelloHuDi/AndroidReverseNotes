package com.tencent.mm.plugin.appbrand.s.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public final class a {
    private static final a iSh = new a() {
        public final int aOd() {
            return -1;
        }

        public final void dc(Context context) {
        }

        public final boolean aOe() {
            return false;
        }
    };

    public static abstract class a {
        public abstract int aOd();

        public abstract boolean aOe();

        public abstract void dc(Context context);
    }

    static abstract class b {
        public abstract Intent aOg();

        b() {
        }

        public final void dd(Context context) {
            Intent aOg = aOg();
            if (!(context instanceof Activity)) {
                aOg.addFlags(268435456);
            }
            context.startActivity(aOg);
        }

        public final boolean aOf() {
            int i;
            List queryIntentActivities = ah.getContext().getPackageManager().queryIntentActivities(aOg(), 0);
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

    static {
        AppMethodBeat.i(133600);
        AppMethodBeat.o(133600);
    }

    public static a aOc() {
        AppMethodBeat.i(133599);
        b bVar = new b();
        AppMethodBeat.o(133599);
        return bVar;
    }
}
