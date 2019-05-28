package com.tencent.mm.cf;

import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.concurrent.Executors;

public final class c {
    private static boolean ydA = false;
    public static a ydB = null;

    public static void MK(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(76900);
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
                ab.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
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
        ab.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76899);
                if (c.ydA) {
                    ab.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
                    AppMethodBeat.o(76899);
                    return;
                }
                String ag;
                if (z4) {
                    ag = b.ag(true, false);
                } else {
                    ag = null;
                }
                Process.setThreadPriority(10);
                boolean isWifi = at.isWifi(ah.getContext());
                if (!z3 || isWifi) {
                    if (!z2 || r0 == null) {
                        ag = z ? b.ydz : null;
                    }
                    c.ydA = true;
                    c.sS(ag);
                    c.ydA = false;
                    AppMethodBeat.o(76899);
                    return;
                }
                ab.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
                AppMethodBeat.o(76899);
            }
        });
        AppMethodBeat.o(76900);
    }

    static boolean Mn() {
        AppMethodBeat.i(76901);
        try {
            if (Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                AppMethodBeat.o(76901);
                return true;
            }
            AppMethodBeat.o(76901);
            return false;
        } catch (Exception e) {
            AppMethodBeat.o(76901);
            return false;
        }
    }

    static /* synthetic */ void sS(String str) {
        AppMethodBeat.i(76902);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", str);
            AppMethodBeat.o(76902);
        } else if (Mn()) {
            File file = new File(str);
            if (file.exists()) {
                String b = q.b(file, true, null);
                if (b != null) {
                    File file2 = new File(b);
                    if (!at.isWifi(ah.getContext()) && file2.length() > 5242880) {
                        ab.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + file2.length());
                        AppMethodBeat.o(76902);
                        return;
                    } else if (ydB == null) {
                        ab.e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
                        AppMethodBeat.o(76902);
                        return;
                    } else {
                        ab.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", Boolean.valueOf(ydB.UC(b)));
                        if (ydB.UC(b)) {
                            e.u(new File(b.ydz));
                        }
                    }
                }
                AppMethodBeat.o(76902);
                return;
            }
            ab.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
            AppMethodBeat.o(76902);
        } else {
            ab.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
            AppMethodBeat.o(76902);
        }
    }
}
