package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.model.bg */
public final class C1830bg {
    private static final Queue<Integer> fmJ = new ConcurrentLinkedQueue();
    private static final long[] fmK = new long[]{0, FaceGestureDetGLThread.BRIGHTNESS_DURATION, 5000, 10000, 30000, 60000, 180000, 300000, 600000, 1800000, 3600000};
    private static final int[] fmL = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] fmM = new int[]{30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};

    static {
        AppMethodBeat.m2504i(59923);
        AppMethodBeat.m2505o(59923);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m3766a(String str, long j, long j2, int i) {
        AppMethodBeat.m2504i(59922);
        if (str == null) {
            AppMethodBeat.m2505o(59922);
            return;
        }
        try {
            String Yz = C1853r.m3846Yz();
            if (Yz == null || !Yz.equals(str)) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                if (str.endsWith("@chatroom")) {
                    if (aoO.dua == 0) {
                        AppMethodBeat.m2505o(59922);
                        return;
                    } else {
                        C4990ab.m7417i("MicroMsg.MsgReporter", "[oneliang]it is a normal chatroom? username:%s", str);
                    }
                } else if (C1855t.m3920nF(str) || C7616ad.aou(str) || C7616ad.aow(str) || C1855t.m3916nB(str) || C7616ad.m13548mR(str) || aoO.dsf()) {
                    AppMethodBeat.m2505o(59922);
                    return;
                }
                long aaD = C1839cb.aaD();
                if (aaD <= 0) {
                    C4990ab.m7416i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
                    AppMethodBeat.m2505o(59922);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = aaD - j2;
                C4990ab.m7417i("MicroMsg.MsgReporter", "[oneliang]current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", Long.valueOf(aaD), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j), Integer.valueOf(i));
                boolean fE = C41753a.m73604fE(j2);
                if (fE) {
                    C7053e.pXa.mo8378a(780, 100, 1, false);
                } else {
                    C7053e.pXa.mo8378a(780, 101, 1, false);
                }
                for (int length = fmK.length - 1; length >= 0; length--) {
                    if (j3 >= fmK[length]) {
                        if (fE) {
                            C7053e.pXa.mo8378a(780, (long) fmL[length], 1, false);
                        } else {
                            C7053e.pXa.mo8378a(780, (long) fmM[length], 1, false);
                        }
                        if (j3 >= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                            C41753a.m73602a(aaD, currentTimeMillis, j2, j3, j);
                        }
                        switch (i) {
                            case 1:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 113, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 118, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 112, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 117, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 111, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 116, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 110, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 115, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                }
                                break;
                            case 3:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 133, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 138, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 132, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 137, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 131, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 136, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 130, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 135, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                }
                                break;
                            case 34:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 123, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 128, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 122, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 127, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 121, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 126, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 120, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 125, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                }
                                break;
                            case 43:
                                if (j3 < 60000) {
                                    if (j3 < 30000) {
                                        if (j3 < 10000) {
                                            if (j3 >= 0) {
                                                if (!fE) {
                                                    C7053e.pXa.mo8378a(780, 155, 1, false);
                                                    break;
                                                }
                                                C7053e.pXa.mo8378a(780, 150, 1, false);
                                                AppMethodBeat.m2505o(59922);
                                                return;
                                            }
                                        } else if (fE) {
                                            C7053e.pXa.mo8378a(780, 151, 1, false);
                                            AppMethodBeat.m2505o(59922);
                                            return;
                                        } else {
                                            C7053e.pXa.mo8378a(780, 156, 1, false);
                                            AppMethodBeat.m2505o(59922);
                                            return;
                                        }
                                    } else if (fE) {
                                        C7053e.pXa.mo8378a(780, 152, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    } else {
                                        C7053e.pXa.mo8378a(780, 157, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                } else if (fE) {
                                    C7053e.pXa.mo8378a(780, 153, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else {
                                    C7053e.pXa.mo8378a(780, 158, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                }
                                break;
                            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                                if (j3 >= 60000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 143, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 148, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 30000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 142, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 147, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 10000) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 141, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 146, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                } else if (j3 >= 0) {
                                    if (fE) {
                                        C7053e.pXa.mo8378a(780, 140, 1, false);
                                        AppMethodBeat.m2505o(59922);
                                        return;
                                    }
                                    C7053e.pXa.mo8378a(780, 145, 1, false);
                                    AppMethodBeat.m2505o(59922);
                                    return;
                                }
                                break;
                        }
                        AppMethodBeat.m2505o(59922);
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
                AppMethodBeat.m2505o(59922);
                return;
            }
            AppMethodBeat.m2505o(59922);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MsgReporter", "[oneliang]something about contact has exception:%s", e.getMessage());
            AppMethodBeat.m2505o(59922);
        }
    }
}
