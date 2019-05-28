package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bg {
    private static final Queue<Integer> fmJ = new ConcurrentLinkedQueue();
    private static final long[] fmK = new long[]{0, FaceGestureDetGLThread.BRIGHTNESS_DURATION, 5000, 10000, 30000, 60000, 180000, 300000, 600000, 1800000, 3600000};
    private static final int[] fmL = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] fmM = new int[]{30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};

    static {
        AppMethodBeat.i(59923);
        AppMethodBeat.o(59923);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(String str, long j, long j2, int i) {
        AppMethodBeat.i(59922);
        if (str == null) {
            AppMethodBeat.o(59922);
            return;
        }
        try {
            String Yz = r.Yz();
            if (Yz == null || !Yz.equals(str)) {
                ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                if (str.endsWith("@chatroom")) {
                    if (aoO.dua == 0) {
                        AppMethodBeat.o(59922);
                        return;
                    } else {
                        ab.i("MicroMsg.MsgReporter", "[oneliang]it is a normal chatroom? username:%s", str);
                    }
                } else if (t.nF(str) || ad.aou(str) || ad.aow(str) || t.nB(str) || ad.mR(str) || aoO.dsf()) {
                    AppMethodBeat.o(59922);
                    return;
                }
                long aaD = cb.aaD();
                if (aaD <= 0) {
                    ab.i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
                    AppMethodBeat.o(59922);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = aaD - j2;
                ab.i("MicroMsg.MsgReporter", "[oneliang]current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", Long.valueOf(aaD), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j), Integer.valueOf(i));
                boolean fE = a.fE(j2);
                if (fE) {
                    e.pXa.a(780, 100, 1, false);
                } else {
                    e.pXa.a(780, 101, 1, false);
                }
                for (int length = fmK.length - 1; length >= 0; length--) {
                    if (j3 >= fmK[length]) {
                        if (fE) {
                            e.pXa.a(780, (long) fmL[length], 1, false);
                        } else {
                            e.pXa.a(780, (long) fmM[length], 1, false);
                        }
                        if (j3 >= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                            a.a(aaD, currentTimeMillis, j2, j3, j);
                        }
                        switch (i) {
                            case 1:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        e.pXa.a(780, 113, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 118, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        e.pXa.a(780, 112, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 117, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        e.pXa.a(780, 111, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 116, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        e.pXa.a(780, 110, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 115, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                }
                                break;
                            case 3:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        e.pXa.a(780, 133, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 138, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        e.pXa.a(780, 132, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 137, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        e.pXa.a(780, 131, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 136, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        e.pXa.a(780, 130, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 135, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                }
                                break;
                            case 34:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        e.pXa.a(780, 123, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 128, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        e.pXa.a(780, 122, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 127, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        e.pXa.a(780, 121, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 126, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        e.pXa.a(780, 120, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 125, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                }
                                break;
                            case 43:
                                if (j3 < 60000) {
                                    if (j3 < 30000) {
                                        if (j3 < 10000) {
                                            if (j3 >= 0) {
                                                if (!fE) {
                                                    e.pXa.a(780, 155, 1, false);
                                                    break;
                                                }
                                                e.pXa.a(780, 150, 1, false);
                                                AppMethodBeat.o(59922);
                                                return;
                                            }
                                        } else if (fE) {
                                            e.pXa.a(780, 151, 1, false);
                                            AppMethodBeat.o(59922);
                                            return;
                                        } else {
                                            e.pXa.a(780, 156, 1, false);
                                            AppMethodBeat.o(59922);
                                            return;
                                        }
                                    } else if (fE) {
                                        e.pXa.a(780, 152, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    } else {
                                        e.pXa.a(780, 157, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                } else if (fE) {
                                    e.pXa.a(780, 153, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else {
                                    e.pXa.a(780, 158, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                }
                                break;
                            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        e.pXa.a(780, 143, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 148, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        e.pXa.a(780, 142, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 147, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        e.pXa.a(780, 141, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 146, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        e.pXa.a(780, 140, 1, false);
                                        AppMethodBeat.o(59922);
                                        return;
                                    }
                                    e.pXa.a(780, 145, 1, false);
                                    AppMethodBeat.o(59922);
                                    return;
                                }
                                break;
                        }
                        AppMethodBeat.o(59922);
                        return;
                    }
                }
                switch (i) {
                    case 1:
                        break;
                    case 3:
                        break;
                    case 34:
                        break;
                    case 43:
                        break;
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        break;
                }
                AppMethodBeat.o(59922);
                return;
            }
            AppMethodBeat.o(59922);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgReporter", "[oneliang]something about contact has exception:%s", e.getMessage());
            AppMethodBeat.o(59922);
        }
    }
}
