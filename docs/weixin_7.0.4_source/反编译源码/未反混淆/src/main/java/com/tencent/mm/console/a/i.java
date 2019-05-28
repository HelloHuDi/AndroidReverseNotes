package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.MMProtocalJni;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public final class i implements a {
    static {
        AppMethodBeat.i(16141);
        b.a(new i(), "//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert");
        AppMethodBeat.o(16141);
    }

    public static void init() {
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        int i;
        AppMethodBeat.i(16140);
        String str2 = strArr[0];
        switch (str2.hashCode()) {
            case -2061874877:
                if (str2.equals("//netassert")) {
                    boolean i2 = true;
                    break;
                }
            case -1869906331:
                if (str2.equals("//jnipushassert")) {
                    i2 = 3;
                    break;
                }
            case -1794206389:
                if (str2.equals("//jniassert")) {
                    i2 = 2;
                    break;
                }
            case 918688960:
                if (str2.equals("//pushassert")) {
                    i2 = 4;
                    break;
                }
            case 1957466406:
                if (str2.equals("//assert")) {
                    i2 = 0;
                    break;
                }
            default:
                i2 = -1;
                break;
        }
        switch (i2) {
            case 0:
                Assert.assertTrue("test errlog " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                AppMethodBeat.o(16140);
                return true;
            case 1:
                Assert.assertTrue("NetsceneQueue forbid in ", false);
                AppMethodBeat.o(16140);
                return true;
            case 2:
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.o(16140);
                return true;
            case 3:
                WatchDogPushReceiver.mj(2);
                AppMethodBeat.o(16140);
                return true;
            case 4:
                WatchDogPushReceiver.mj(1);
                AppMethodBeat.o(16140);
                return true;
            default:
                AppMethodBeat.o(16140);
                return false;
        }
    }
}
