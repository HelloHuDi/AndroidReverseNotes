package com.tencent.p177mm.compatible.util;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;

/* renamed from: com.tencent.mm.compatible.util.f */
public final class C1445f {
    /* renamed from: Mn */
    public static boolean m3070Mn() {
        AppMethodBeat.m2504i(93070);
        String absolutePath = C1448h.getExternalStorageDirectory().getAbsolutePath();
        if (C6457e.eSl.equalsIgnoreCase(absolutePath)) {
            try {
                if (C1448h.getExternalStorageState().equals("mounted") && new File(absolutePath).canWrite()) {
                    AppMethodBeat.m2505o(93070);
                    return true;
                }
                AppMethodBeat.m2505o(93070);
                return false;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e.getMessage() + " SDCARD_ROOT: " + C6457e.eSl);
                AppMethodBeat.m2505o(93070);
                return false;
            }
        }
        try {
            boolean canWrite = new File(C6457e.eSl).canWrite();
            AppMethodBeat.m2505o(93070);
            return canWrite;
        } catch (Exception e2) {
            C4990ab.m7420w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + C6457e.eSl);
            AppMethodBeat.m2505o(93070);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Mo */
    public static boolean m3071Mo() {
        Exception e;
        AppMethodBeat.m2504i(93071);
        if (C1445f.m3070Mn()) {
            StatFs statFs;
            long blockSize;
            long j = 0;
            long j2 = 0;
            try {
                statFs = new StatFs(C6457e.eSl);
                try {
                    j = (long) statFs.getBlockCount();
                    j2 = (long) statFs.getAvailableBlocks();
                    blockSize = (long) statFs.getBlockSize();
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.m7413e("MicroMsg.CUtil", "checkSDCardFull", e);
                    blockSize = 0;
                    if (statFs == null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                statFs = null;
                C4990ab.m7413e("MicroMsg.CUtil", "checkSDCardFull", e);
                blockSize = 0;
                if (statFs == null) {
                }
            }
            if (statFs == null) {
                AppMethodBeat.m2505o(93071);
                return false;
            } else if (j <= 0) {
                AppMethodBeat.m2505o(93071);
                return false;
            } else if (j - j2 < 0) {
                AppMethodBeat.m2505o(93071);
                return false;
            } else {
                long j3 = blockSize * j2;
                long j4 = blockSize * j;
                C4990ab.m7417i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(blockSize), Long.valueOf(j4), Long.valueOf(j3), Integer.valueOf((int) (((j - j2) * 100) / j)));
                if (95 > ((int) (((j - j2) * 100) / j))) {
                    AppMethodBeat.m2505o(93071);
                    return false;
                } else if (j3 > 314572800) {
                    AppMethodBeat.m2505o(93071);
                    return false;
                } else {
                    C4990ab.m7416i("MicroMsg.CUtil", "checkSDCardFull is full!");
                    AppMethodBeat.m2505o(93071);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(93071);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: eW */
    public static boolean m3072eW(long j) {
        long blockCount;
        Exception e;
        long j2;
        AppMethodBeat.m2504i(93072);
        if (C1445f.m3070Mn()) {
            StatFs statFs;
            long availableBlocks;
            try {
                statFs = new StatFs(C6457e.eSl);
                try {
                    blockCount = (long) statFs.getBlockCount();
                    try {
                        availableBlocks = (long) statFs.getAvailableBlocks();
                    } catch (Exception e2) {
                        e = e2;
                        j2 = blockCount;
                        C4990ab.m7413e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                        availableBlocks = 0;
                        blockCount = j2;
                        if (statFs != null) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    j2 = 0;
                    C4990ab.m7413e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                    availableBlocks = 0;
                    blockCount = j2;
                    if (statFs != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                statFs = null;
                j2 = 0;
                C4990ab.m7413e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                availableBlocks = 0;
                blockCount = j2;
                if (statFs != null) {
                }
            }
            if (statFs != null) {
                AppMethodBeat.m2505o(93072);
                return false;
            } else if (blockCount <= 0) {
                AppMethodBeat.m2505o(93072);
                return false;
            } else if (blockCount - availableBlocks < 0) {
                AppMethodBeat.m2505o(93072);
                return false;
            } else {
                if (((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize()) < j) {
                    C4990ab.m7416i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + j + " not enough and ret false");
                    AppMethodBeat.m2505o(93072);
                    return false;
                }
                AppMethodBeat.m2505o(93072);
                return true;
            }
        }
        C4990ab.m7416i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
        AppMethodBeat.m2505o(93072);
        return false;
    }
}
