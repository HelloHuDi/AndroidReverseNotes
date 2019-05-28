package com.tencent.p177mm.console.p845a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelstat.WatchDogPushReceiver;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.protocal.MMProtocalJni;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.console.a.i */
public final class C9252i implements C44041a {
    static {
        AppMethodBeat.m2504i(16141);
        C44042b.m79163a(new C9252i(), "//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert");
        AppMethodBeat.m2505o(16141);
    }

    public static void init() {
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        int i;
        AppMethodBeat.m2504i(16140);
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
                AppMethodBeat.m2505o(16140);
                return true;
            case 1:
                Assert.assertTrue("NetsceneQueue forbid in ", false);
                AppMethodBeat.m2505o(16140);
                return true;
            case 2:
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.m2505o(16140);
                return true;
            case 3:
                WatchDogPushReceiver.m29200mj(2);
                AppMethodBeat.m2505o(16140);
                return true;
            case 4:
                WatchDogPushReceiver.m29200mj(1);
                AppMethodBeat.m2505o(16140);
                return true;
            default:
                AppMethodBeat.m2505o(16140);
                return false;
        }
    }
}
