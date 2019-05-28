package com.tencent.p177mm.p215cf;

import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C8900q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.mm.cf.c */
public final class C45279c {
    private static boolean ydA = false;
    public static C26007a ydB = null;

    /* renamed from: MK */
    public static void m83487MK(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.m2504i(76900);
        switch (i) {
            case 1:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                break;
            case 2:
                z = false;
                z2 = true;
                z3 = true;
                z4 = true;
                break;
            case 3:
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            case 4:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            case 5:
                z = true;
                z2 = false;
                z3 = true;
                z4 = false;
                break;
            case 6:
                C4990ab.m7416i("MicroMsg.MemoryDumpOperation", "GC NOW.");
                System.gc();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
        }
        C4990ab.m7411d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(76899);
                if (C45279c.ydA) {
                    C4990ab.m7420w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
                    AppMethodBeat.m2505o(76899);
                    return;
                }
                String ag;
                if (z4) {
                    ag = C37632b.m63571ag(true, false);
                } else {
                    ag = null;
                }
                Process.setThreadPriority(10);
                boolean isWifi = C5023at.isWifi(C4996ah.getContext());
                if (!z3 || isWifi) {
                    if (!z2 || r0 == null) {
                        ag = z ? C37632b.ydz : null;
                    }
                    C45279c.ydA = true;
                    C45279c.m83489sS(ag);
                    C45279c.ydA = false;
                    AppMethodBeat.m2505o(76899);
                    return;
                }
                C4990ab.m7420w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
                AppMethodBeat.m2505o(76899);
            }
        });
        AppMethodBeat.m2505o(76900);
    }

    /* renamed from: Mn */
    static boolean m83488Mn() {
        AppMethodBeat.m2504i(76901);
        try {
            if (Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                AppMethodBeat.m2505o(76901);
                return true;
            }
            AppMethodBeat.m2505o(76901);
            return false;
        } catch (Exception e) {
            AppMethodBeat.m2505o(76901);
            return false;
        }
    }

    /* renamed from: sS */
    static /* synthetic */ void m83489sS(String str) {
        AppMethodBeat.m2504i(76902);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", str);
            AppMethodBeat.m2505o(76902);
        } else if (C45279c.m83488Mn()) {
            File file = new File(str);
            if (file.exists()) {
                String b = C8900q.m16038b(file, true, null);
                if (b != null) {
                    File file2 = new File(b);
                    if (!C5023at.isWifi(C4996ah.getContext()) && file2.length() > 5242880) {
                        C4990ab.m7416i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + file2.length());
                        AppMethodBeat.m2505o(76902);
                        return;
                    } else if (ydB == null) {
                        C4990ab.m7412e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
                        AppMethodBeat.m2505o(76902);
                        return;
                    } else {
                        C4990ab.m7417i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", Boolean.valueOf(ydB.mo43886UC(b)));
                        if (ydB.mo43886UC(b)) {
                            C1173e.m2576u(new File(C37632b.ydz));
                        }
                    }
                }
                AppMethodBeat.m2505o(76902);
                return;
            }
            C4990ab.m7412e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
            AppMethodBeat.m2505o(76902);
        } else {
            C4990ab.m7412e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
            AppMethodBeat.m2505o(76902);
        }
    }
}
