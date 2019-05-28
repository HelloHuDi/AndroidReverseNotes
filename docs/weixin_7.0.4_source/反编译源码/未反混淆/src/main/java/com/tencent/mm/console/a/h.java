package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import java.util.Calendar;

public final class h implements a {
    static {
        AppMethodBeat.i(16139);
        b.a(new h(), "//sport");
        AppMethodBeat.o(16139);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16138);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16138);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16138);
            return true;
        } else {
            String str2 = strArr[1];
            Object obj = -1;
            switch (str2.hashCode()) {
                case -734972924:
                    if (str2.equals("setdevicestep")) {
                        obj = null;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1761741959:
                    if (str2.equals("setextapistep")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1840324855:
                    if (str2.equals("updatehistorystep")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            Calendar instance;
            switch (obj) {
                case null:
                    int intValue = Integer.valueOf(strArr[2]).intValue();
                    bo.dpC();
                    instance = Calendar.getInstance();
                    instance.set(11, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    ((com.tencent.mm.plugin.sport.a.b) g.K(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), intValue, bs.dut());
                    break;
                case 1:
                    ((com.tencent.mm.plugin.sport.a.b) g.K(com.tencent.mm.plugin.sport.a.b.class)).cvZ();
                    Process.killProcess(Process.myPid());
                    break;
                case 2:
                    com.tencent.mm.sdk.b.b fpVar = new fp();
                    fpVar.czu.action = 2;
                    fpVar.czu.czx = (long) Integer.valueOf(strArr[2]).intValue();
                    fpVar.czu.baZ = 1;
                    com.tencent.mm.sdk.b.a.xxA.a(fpVar, Looper.getMainLooper());
                    break;
                case 3:
                    instance = Calendar.getInstance();
                    instance.add(5, -1);
                    instance.set(10, 23);
                    instance.set(12, 59);
                    instance.set(13, 59);
                    long timeInMillis = instance.getTimeInMillis();
                    instance.add(5, -120);
                    instance.set(10, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    ((com.tencent.mm.plugin.sport.a.b) g.K(com.tencent.mm.plugin.sport.a.b.class)).a(instance.getTimeInMillis(), timeInMillis, null);
                    break;
            }
            AppMethodBeat.o(16138);
            return true;
        }
    }
}
