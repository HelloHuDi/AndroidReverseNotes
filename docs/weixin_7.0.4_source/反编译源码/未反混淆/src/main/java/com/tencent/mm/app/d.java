package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.io.RandomAccessFile;

public final class d {
    private static final String cdZ = (ac.eSj + "channel_history.cfg");

    static {
        AppMethodBeat.i(15376);
        AppMethodBeat.o(15376);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0188 A:{SYNTHETIC, Splitter:B:47:0x0188} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0166 A:{SYNTHETIC, Splitter:B:39:0x0166} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void Ba() {
        Throwable e;
        AppMethodBeat.i(15374);
        if (Bb()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(cdZ, "rw");
                try {
                    long length = randomAccessFile.length();
                    ab.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", Long.valueOf(length), Integer.valueOf(g.cdf));
                    if (length <= 0) {
                        ab.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                        try {
                            randomAccessFile.close();
                            AppMethodBeat.o(15374);
                            return;
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", "");
                            AppMethodBeat.o(15374);
                            return;
                        }
                    }
                    String readLine = randomAccessFile.readLine();
                    int i = g.cdf;
                    int i2 = g.cdf;
                    g.xya = g.cdf;
                    String str = "";
                    if (!bo.isNullOrNil(readLine)) {
                        str = str + readLine + ",";
                        i2 = bo.getInt(readLine, 0);
                        if (i2 != g.cdf) {
                            g.xya = i2;
                            ab.i("MicroMsg.ChannelHistory", "real correct final channelid: " + g.cdf);
                        }
                    }
                    if (ah.xzd) {
                        while (true) {
                            readLine = randomAccessFile.readLine();
                            if (bo.isNullOrNil(readLine)) {
                                break;
                            }
                            str = str + readLine + ",";
                            i2 = bo.getInt(readLine, 0);
                        }
                        ab.i("MicroMsg.ChannelHistory", "channel list: %s", str);
                        if (i2 != i) {
                            randomAccessFile.seek(length);
                            randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(i)}).getBytes());
                            ab.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                    try {
                        randomAccessFile.close();
                        AppMethodBeat.o(15374);
                        return;
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Close ChannelHistory History file failed.", "");
                        AppMethodBeat.o(15374);
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.o(15374);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.o(15374);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e222) {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Close ChannelHistory History file failed.", "");
                        AppMethodBeat.o(15374);
                        return;
                    }
                }
                AppMethodBeat.o(15374);
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e5, "Close ChannelHistory History file failed.", "");
                    }
                }
                AppMethodBeat.o(15374);
                throw e;
            }
        }
        ab.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
        AppMethodBeat.o(15374);
    }

    private static boolean Bb() {
        AppMethodBeat.i(15375);
        boolean exists = new File(cdZ).exists();
        AppMethodBeat.o(15375);
        return exists;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe A:{SYNTHETIC, Splitter:B:43:0x00fe} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e4 A:{SYNTHETIC, Splitter:B:36:0x00e4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void aT(Context context) {
        Throwable e;
        com.tencent.mm.booter.d bo;
        AppMethodBeat.i(15373);
        g.gj(context);
        try {
            a cL = a.cL(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(cL == null || cL.cdc == null)) {
                ab.i("MicroMsg.ChannelHistory", "apk external info not null");
                if (cL.cdc.cdf != 0) {
                    g.cdf = cL.cdc.cdf;
                    ab.i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (NameNotFoundException e2) {
            ab.e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            ab.e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", e3.getMessage());
        }
        ab.i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", Integer.valueOf(g.cdf), ah.getProcessName());
        if (!Bb()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(cdZ, "rw");
                try {
                    randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(g.cdf)}).getBytes());
                    try {
                        randomAccessFile.close();
                    } catch (Exception e32) {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e32, "Close ChannelHistory History file failed.", "");
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                        if (randomAccessFile != null) {
                        }
                        bo = com.tencent.mm.booter.d.bo(context);
                        g.cdf = bo.ebO;
                        AppMethodBeat.o(15373);
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                                ab.printErrStackTrace("MicroMsg.ChannelHistory", e5, "Close ChannelHistory History file failed.", "");
                            }
                        }
                        AppMethodBeat.o(15373);
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                ab.printErrStackTrace("MicroMsg.ChannelHistory", e, "Open ChannelHistory History file failed.", "");
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e322) {
                        ab.printErrStackTrace("MicroMsg.ChannelHistory", e322, "Close ChannelHistory History file failed.", "");
                    }
                }
                bo = com.tencent.mm.booter.d.bo(context);
                g.cdf = bo.ebO;
                AppMethodBeat.o(15373);
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(15373);
                throw e;
            }
        }
        bo = com.tencent.mm.booter.d.bo(context);
        if (!(bo == null || bo.ebO == -1)) {
            g.cdf = bo.ebO;
        }
        AppMethodBeat.o(15373);
    }
}
