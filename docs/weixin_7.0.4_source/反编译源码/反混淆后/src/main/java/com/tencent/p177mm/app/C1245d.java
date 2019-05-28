package com.tencent.p177mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.app.d */
public final class C1245d {
    private static final String cdZ = (C5128ac.eSj + "channel_history.cfg");

    static {
        AppMethodBeat.m2504i(15376);
        AppMethodBeat.m2505o(15376);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0188 A:{SYNTHETIC, Splitter:B:47:0x0188} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0166 A:{SYNTHETIC, Splitter:B:39:0x0166} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Ba */
    public static void m2681Ba() {
        Throwable e;
        AppMethodBeat.m2504i(15374);
        if (C1245d.m2682Bb()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(cdZ, "rw");
                try {
                    long length = randomAccessFile.length();
                    C4990ab.m7417i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", Long.valueOf(length), Integer.valueOf(C5059g.cdf));
                    if (length <= 0) {
                        C4990ab.m7420w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                        try {
                            randomAccessFile.close();
                            AppMethodBeat.m2505o(15374);
                            return;
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", "");
                            AppMethodBeat.m2505o(15374);
                            return;
                        }
                    }
                    String readLine = randomAccessFile.readLine();
                    int i = C5059g.cdf;
                    int i2 = C5059g.cdf;
                    C5059g.xya = C5059g.cdf;
                    String str = "";
                    if (!C5046bo.isNullOrNil(readLine)) {
                        str = str + readLine + ",";
                        i2 = C5046bo.getInt(readLine, 0);
                        if (i2 != C5059g.cdf) {
                            C5059g.xya = i2;
                            C4990ab.m7416i("MicroMsg.ChannelHistory", "real correct final channelid: " + C5059g.cdf);
                        }
                    }
                    if (C4996ah.xzd) {
                        while (true) {
                            readLine = randomAccessFile.readLine();
                            if (C5046bo.isNullOrNil(readLine)) {
                                break;
                            }
                            str = str + readLine + ",";
                            i2 = C5046bo.getInt(readLine, 0);
                        }
                        C4990ab.m7417i("MicroMsg.ChannelHistory", "channel list: %s", str);
                        if (i2 != i) {
                            randomAccessFile.seek(length);
                            randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(i)}).getBytes());
                            C4990ab.m7417i("MicroMsg.ChannelHistory", "channelid change from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                    try {
                        randomAccessFile.close();
                        AppMethodBeat.m2505o(15374);
                        return;
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Close ChannelHistory History file failed.", "");
                        AppMethodBeat.m2505o(15374);
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.m2505o(15374);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.m2505o(15374);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e222) {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Close ChannelHistory History file failed.", "");
                        AppMethodBeat.m2505o(15374);
                        return;
                    }
                }
                AppMethodBeat.m2505o(15374);
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e5, "Close ChannelHistory History file failed.", "");
                    }
                }
                AppMethodBeat.m2505o(15374);
                throw e;
            }
        }
        C4990ab.m7420w("MicroMsg.ChannelHistory", "channel history file does not exit!");
        AppMethodBeat.m2505o(15374);
    }

    /* renamed from: Bb */
    private static boolean m2682Bb() {
        AppMethodBeat.m2504i(15375);
        boolean exists = new File(cdZ).exists();
        AppMethodBeat.m2505o(15375);
        return exists;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe A:{SYNTHETIC, Splitter:B:43:0x00fe} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e4 A:{SYNTHETIC, Splitter:B:36:0x00e4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aT */
    public static void m2683aT(Context context) {
        Throwable e;
        C1326d bo;
        AppMethodBeat.m2504i(15373);
        C5059g.m7674gj(context);
        try {
            C32429a cL = C32429a.m53086cL(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(cL == null || cL.cdc == null)) {
                C4990ab.m7416i("MicroMsg.ChannelHistory", "apk external info not null");
                if (cL.cdc.cdf != 0) {
                    C5059g.cdf = cL.cdc.cdf;
                    C4990ab.m7416i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (NameNotFoundException e2) {
            C4990ab.m7412e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", e3.getMessage());
        }
        C4990ab.m7417i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", Integer.valueOf(C5059g.cdf), C4996ah.getProcessName());
        if (!C1245d.m2682Bb()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(cdZ, "rw");
                try {
                    randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(C5059g.cdf)}).getBytes());
                    try {
                        randomAccessFile.close();
                    } catch (Exception e32) {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e32, "Close ChannelHistory History file failed.", "");
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                        if (randomAccessFile != null) {
                        }
                        bo = C1326d.m2839bo(context);
                        C5059g.cdf = bo.ebO;
                        AppMethodBeat.m2505o(15373);
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                                C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e5, "Close ChannelHistory History file failed.", "");
                            }
                        }
                        AppMethodBeat.m2505o(15373);
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e322) {
                        C4990ab.printErrStackTrace("MicroMsg.ChannelHistory", e322, "Close ChannelHistory History file failed.", "");
                    }
                }
                bo = C1326d.m2839bo(context);
                C5059g.cdf = bo.ebO;
                AppMethodBeat.m2505o(15373);
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(15373);
                throw e;
            }
        }
        bo = C1326d.m2839bo(context);
        if (!(bo == null || bo.ebO == -1)) {
            C5059g.cdf = bo.ebO;
        }
        AppMethodBeat.m2505o(15373);
    }
}
