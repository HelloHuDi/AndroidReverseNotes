package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9345fp;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7574bs;
import java.util.Calendar;

/* renamed from: com.tencent.mm.console.a.h */
public final class C26059h implements C44041a {
    static {
        AppMethodBeat.m2504i(16139);
        C44042b.m79163a(new C26059h(), "//sport");
        AppMethodBeat.m2505o(16139);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16138);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16138);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16138);
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
                    C5046bo.dpC();
                    instance = Calendar.getInstance();
                    instance.set(11, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    ((C39858b) C1720g.m3528K(C39858b.class)).mo63049b("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), intValue, C7574bs.dut());
                    break;
                case 1:
                    ((C39858b) C1720g.m3528K(C39858b.class)).cvZ();
                    Process.killProcess(Process.myPid());
                    break;
                case 2:
                    C4883b c9345fp = new C9345fp();
                    c9345fp.czu.action = 2;
                    c9345fp.czu.czx = (long) Integer.valueOf(strArr[2]).intValue();
                    c9345fp.czu.baZ = 1;
                    C4879a.xxA.mo10048a(c9345fp, Looper.getMainLooper());
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
                    ((C39858b) C1720g.m3528K(C39858b.class)).mo63048a(instance.getTimeInMillis(), timeInMillis, null);
                    break;
            }
            AppMethodBeat.m2505o(16138);
            return true;
        }
    }
}
