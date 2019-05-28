package com.tencent.p177mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.booter.n */
public final class C41900n {
    static long ecE = 0;

    /* renamed from: com.tencent.mm.booter.n$2 */
    static class C91912 implements Runnable {
        C91912() {
        }

        public final void run() {
            AppMethodBeat.m2504i(15864);
            C41900n.m74005jJ("mm_proc_startup");
            C41900n.m74005jJ("push_proc_startup");
            AppMethodBeat.m2505o(15864);
        }
    }

    /* renamed from: com.tencent.mm.booter.n$a */
    static class C41899a {
        int ecG;
        int ecH = 1;
        int ecI;
        int ecJ;
        int ecK;

        C41899a() {
        }

        /* renamed from: jK */
        public final boolean mo67548jK(String str) {
            AppMethodBeat.m2504i(15865);
            String[] split = str.split(",");
            if (split == null || split.length != 5) {
                C4990ab.m7412e("MicroMsg.ProcessReport", "error format");
                AppMethodBeat.m2505o(15865);
                return false;
            }
            try {
                this.ecG = C5046bo.getInt(split[0], 0);
                this.ecH = C5046bo.getInt(split[1], 0);
                this.ecI = C5046bo.getInt(split[2], 0);
                this.ecJ = C5046bo.getInt(split[3], 0);
                this.ecK = C5046bo.getInt(split[4], 0);
                AppMethodBeat.m2505o(15865);
                return true;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ProcessReport", "ParseFrom parse failed");
                C4990ab.printErrStackTrace("MicroMsg.ProcessReport", e, "", new Object[0]);
                AppMethodBeat.m2505o(15865);
                return false;
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(15866);
            String format = String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.ecG), Integer.valueOf(this.ecH), Integer.valueOf(this.ecI), Integer.valueOf(this.ecJ), Integer.valueOf(this.ecK)});
            AppMethodBeat.m2505o(15866);
            return format;
        }
    }

    /* renamed from: IE */
    public static void m74001IE() {
        C41899a c41899a;
        AppMethodBeat.m2504i(15867);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("mm_proc_startup", 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            c41899a = new C41899a();
            if (c41899a.mo67548jK(split[split.length - 1])) {
                c41899a.ecK = Process.myPid();
                split[split.length - 1] = c41899a.toString();
            }
        }
        c41899a = new C41899a();
        c41899a.ecG = 2;
        c41899a.ecI = Process.myPid();
        c41899a.ecJ = (int) C5046bo.anT();
        String g = C41900n.m74003g(split);
        String c41899a2 = c41899a.toString();
        if (g.length() > 0) {
            c41899a2 = g + "=" + c41899a2;
        }
        C4990ab.m7411d("MicroMsg.ProcessReport", "startProc new info %s", c41899a2);
        sharedPreferences.edit().putString("startup_info", c41899a2).commit();
        AppMethodBeat.m2505o(15867);
    }

    /* renamed from: BY */
    public static void m74000BY() {
        AppMethodBeat.m2504i(15868);
        C41900n.m74004jI("mm_proc_startup");
        C41900n.m74004jI("push_proc_startup");
        AppMethodBeat.m2505o(15868);
    }

    /* renamed from: jI */
    private static void m74004jI(String str) {
        AppMethodBeat.m2504i(15869);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length == 0) {
            AppMethodBeat.m2505o(15869);
            return;
        }
        C41899a c41899a = new C41899a();
        if (c41899a.mo67548jK(split[split.length - 1])) {
            c41899a.ecH = 2;
            split[split.length - 1] = c41899a.toString();
        }
        C4990ab.m7411d("MicroMsg.ProcessReport", "uerExit new info %s", C41900n.m74003g(split));
        sharedPreferences.edit().putString("startup_info", r1).commit();
        AppMethodBeat.m2505o(15869);
    }

    /* renamed from: IF */
    public static void m74002IF() {
        AppMethodBeat.m2504i(15870);
        if (ecE == 0 || C5046bo.m7525az(ecE) >= 3600000) {
            final int intValue = ((Integer) C9638aw.m17188ZI().get(37, Integer.valueOf(0))).intValue();
            if (C7243d.vxo != intValue) {
                C9638aw.m17188ZI().set(37, Integer.valueOf(C7243d.vxo));
                new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(15863);
                        C7060h.pYm.mo8374X(10675, intValue + "," + C5059g.cdf);
                        AppMethodBeat.m2505o(15863);
                    }
                });
            }
            ecE = C5046bo.m7588yz();
            new C7306ak(Looper.getMainLooper()).post(new C91912());
            AppMethodBeat.m2505o(15870);
            return;
        }
        AppMethodBeat.m2505o(15870);
    }

    /* renamed from: g */
    private static String m74003g(String[] strArr) {
        AppMethodBeat.m2504i(15871);
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
        AppMethodBeat.m2505o(15871);
        return str;
    }

    /* renamed from: jJ */
    static /* synthetic */ void m74005jJ(String str) {
        AppMethodBeat.m2504i(15872);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            C4990ab.m7416i("MicroMsg.ProcessReport", "nothing to reprot");
            AppMethodBeat.m2505o(15872);
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            C4990ab.m7417i("MicroMsg.ProcessReport", "reprot %s: %s", str, split[i]);
            C7060h.pYm.mo8374X(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
        AppMethodBeat.m2505o(15872);
    }
}
