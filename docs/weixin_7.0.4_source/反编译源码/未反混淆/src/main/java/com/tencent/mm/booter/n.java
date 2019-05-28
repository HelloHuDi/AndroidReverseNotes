package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class n {
    static long ecE = 0;

    static class a {
        int ecG;
        int ecH = 1;
        int ecI;
        int ecJ;
        int ecK;

        a() {
        }

        public final boolean jK(String str) {
            AppMethodBeat.i(15865);
            String[] split = str.split(",");
            if (split == null || split.length != 5) {
                ab.e("MicroMsg.ProcessReport", "error format");
                AppMethodBeat.o(15865);
                return false;
            }
            try {
                this.ecG = bo.getInt(split[0], 0);
                this.ecH = bo.getInt(split[1], 0);
                this.ecI = bo.getInt(split[2], 0);
                this.ecJ = bo.getInt(split[3], 0);
                this.ecK = bo.getInt(split[4], 0);
                AppMethodBeat.o(15865);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
                ab.printErrStackTrace("MicroMsg.ProcessReport", e, "", new Object[0]);
                AppMethodBeat.o(15865);
                return false;
            }
        }

        public final String toString() {
            AppMethodBeat.i(15866);
            String format = String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.ecG), Integer.valueOf(this.ecH), Integer.valueOf(this.ecI), Integer.valueOf(this.ecJ), Integer.valueOf(this.ecK)});
            AppMethodBeat.o(15866);
            return format;
        }
    }

    public static void IE() {
        a aVar;
        AppMethodBeat.i(15867);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("mm_proc_startup", 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            aVar = new a();
            if (aVar.jK(split[split.length - 1])) {
                aVar.ecK = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        aVar = new a();
        aVar.ecG = 2;
        aVar.ecI = Process.myPid();
        aVar.ecJ = (int) bo.anT();
        String g = g(split);
        String aVar2 = aVar.toString();
        if (g.length() > 0) {
            aVar2 = g + "=" + aVar2;
        }
        ab.d("MicroMsg.ProcessReport", "startProc new info %s", aVar2);
        sharedPreferences.edit().putString("startup_info", aVar2).commit();
        AppMethodBeat.o(15867);
    }

    public static void BY() {
        AppMethodBeat.i(15868);
        jI("mm_proc_startup");
        jI("push_proc_startup");
        AppMethodBeat.o(15868);
    }

    private static void jI(String str) {
        AppMethodBeat.i(15869);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(15869);
            return;
        }
        a aVar = new a();
        if (aVar.jK(split[split.length - 1])) {
            aVar.ecH = 2;
            split[split.length - 1] = aVar.toString();
        }
        ab.d("MicroMsg.ProcessReport", "uerExit new info %s", g(split));
        sharedPreferences.edit().putString("startup_info", r1).commit();
        AppMethodBeat.o(15869);
    }

    public static void IF() {
        AppMethodBeat.i(15870);
        if (ecE == 0 || bo.az(ecE) >= 3600000) {
            final int intValue = ((Integer) aw.ZI().get(37, Integer.valueOf(0))).intValue();
            if (d.vxo != intValue) {
                aw.ZI().set(37, Integer.valueOf(d.vxo));
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(15863);
                        h.pYm.X(10675, intValue + "," + g.cdf);
                        AppMethodBeat.o(15863);
                    }
                });
            }
            ecE = bo.yz();
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(15864);
                    n.jJ("mm_proc_startup");
                    n.jJ("push_proc_startup");
                    AppMethodBeat.o(15864);
                }
            });
            AppMethodBeat.o(15870);
            return;
        }
        AppMethodBeat.o(15870);
    }

    private static String g(String[] strArr) {
        AppMethodBeat.i(15871);
        String str = "";
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                str = str + "=";
            }
            str = str + str2;
        }
        AppMethodBeat.o(15871);
        return str;
    }

    static /* synthetic */ void jJ(String str) {
        AppMethodBeat.i(15872);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            ab.i("MicroMsg.ProcessReport", "nothing to reprot");
            AppMethodBeat.o(15872);
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            ab.i("MicroMsg.ProcessReport", "reprot %s: %s", str, split[i]);
            h.pYm.X(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
        AppMethodBeat.o(15872);
    }
}
