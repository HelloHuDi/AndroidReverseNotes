package com.tencent.p177mm.wallet_core.p649c;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C27084e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.wallet_core.c.z */
public final class C36381z {
    public static long AfW = 0;
    public static int tPj = 1;
    public static int tPk = 2;

    public static void dNW() {
        AppMethodBeat.m2504i(49087);
        AfW = System.currentTimeMillis();
        AppMethodBeat.m2505o(49087);
    }

    public static int dNX() {
        AppMethodBeat.m2504i(49088);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - AfW) / 1000);
        AppMethodBeat.m2505o(49088);
        return currentTimeMillis;
    }

    /* renamed from: d */
    public static void m59953d(String str, String str2, String str3, int i, String str4) {
        Exception e;
        AppMethodBeat.m2504i(49089);
        if (str3 == null || str3.length() <= 0) {
            AppMethodBeat.m2505o(49089);
            return;
        }
        String str5;
        String str6 = null;
        try {
            int i2;
            char charAt;
            if (Character.isDigit(str3.charAt(0))) {
                i2 = 0;
                str5 = str3;
                while (i2 < str5.length()) {
                    try {
                        charAt = str5.charAt(i2);
                        if (!(Character.isDigit(charAt) || ".".equalsIgnoreCase(String.valueOf(charAt)))) {
                            str6 = str5.substring(i2).trim();
                            str5 = str5.substring(0, i2 - 1).trim();
                        }
                        i2++;
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.m7413e("MicroMsg.WalletReportUtil", "", e);
                        C7060h.pYm.mo8381e(10756, str, str2, str5, str6, Integer.valueOf(i), str4);
                        AppMethodBeat.m2505o(49089);
                    }
                }
            }
            str5 = str3;
            for (i2 = 0; i2 < str5.length(); i2++) {
                charAt = str5.charAt(i2);
                if (Character.isDigit(charAt) || ".".equalsIgnoreCase(String.valueOf(charAt))) {
                    str6 = str5.substring(0, i2 - 1).trim();
                    str5 = str5.substring(i2).trim();
                }
            }
        } catch (Exception e3) {
            e = e3;
            str5 = str3;
        }
        C7060h.pYm.mo8381e(10756, str, str2, str5, str6, Integer.valueOf(i), str4);
        AppMethodBeat.m2505o(49089);
    }

    /* renamed from: hL */
    public static void m59954hL(int i, int i2) {
        AppMethodBeat.m2504i(49090);
        C7060h.pYm.mo8381e(12097, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(49090);
    }

    /* renamed from: a */
    public static void m59952a(int i, int i2, int i3, int i4, long j, int i5, String str) {
        AppMethodBeat.m2504i(49091);
        IDKey iDKey;
        if (C36381z.m59955hM(i, i2) || C36381z.m59956hN(i, i2) || C36381z.m59957hO(i, i2) || C36381z.m59951QO(i) || C36381z.m59958hP(i, i2)) {
            C4990ab.m7416i("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i + " cmdid:" + i2);
            int i6 = -1;
            if (i5 == 4) {
                i6 = 132;
            } else if (i5 == 1) {
                i6 = ErrorCode.STARTDOWNLOAD_4;
            } else if (i5 == 2 || i5 == 36) {
                i6 = 131;
            } else if (i5 == 3) {
                i6 = 130;
            } else if (i5 == 5) {
                i6 = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
            } else if (i5 == 100) {
                i6 = C19394e.CTRL_INDEX;
            } else if (i5 == 6 || i5 == 1001) {
                i6 = 152;
            } else if (i5 == 11) {
                i6 = C19392d.CTRL_INDEX;
            } else if (i5 == 21) {
                i6 = C33333a.CTRL_INDEX;
            } else if (i5 == 31 || i5 == 33 || i5 == 32) {
                i6 = 118;
            } else if (i5 == 37) {
                i6 = C31128d.MIC_ALPHA_ADJUST_REAL;
            } else if (i5 == 39) {
                i6 = 298;
            }
            if (i6 == -1) {
                C4990ab.m7412e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay get ID by scene is -1, the scene is ".concat(String.valueOf(i5)));
                i6 = -1;
                if (i == 385 && i2 == 74) {
                    i6 = C19392d.CTRL_INDEX;
                }
                if (i == 385 && i2 == 75) {
                    i6 = C33333a.CTRL_INDEX;
                } else if (C36381z.m59951QO(i)) {
                    i6 = C31128d.MIC_ALPHA_ADJUST_REAL;
                } else if (C36381z.m59958hP(i, i2)) {
                    i6 = 145;
                } else if (i == 397) {
                    i6 = 131;
                } else if (i == 398) {
                    i6 = 130;
                } else if (i == v2helper.EMethodOutputVolumeGainEnable) {
                    i6 = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                } else if (i == 556) {
                    i6 = 152;
                } else if (i == C27084e.CTRL_INDEX) {
                    i6 = C19394e.CTRL_INDEX;
                } else if (i == 1544 || i == 1582) {
                    i6 = 118;
                } else if (i == 1575) {
                    i6 = C31128d.MIC_ALPHA_ADJUST_REAL;
                }
            }
            if (i6 == -1) {
                C4990ab.m7412e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i + " cmdid:" + i2 + " , ID is -1");
                i6 = -1;
                if (TextUtils.isEmpty(str)) {
                    i6 = -1;
                } else if (str.equals("BalanceFetchProcess")) {
                    i6 = C33333a.CTRL_INDEX;
                } else if (str.equals("BalanceSaveProcess")) {
                    i6 = C19392d.CTRL_INDEX;
                }
            }
            if (i6 == -1) {
                C4990ab.m7412e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the processName is for idkey report processName:" + str + " , ID is -1");
                AppMethodBeat.m2505o(49091);
                return;
            }
            iDKey = new IDKey();
            iDKey.SetID(i6);
            iDKey.SetValue(1);
            if (C36381z.m59955hM(i, i2)) {
                iDKey.SetKey(26);
            } else if (C36381z.m59956hN(i, i2)) {
                iDKey.SetKey(45);
            } else if (C36381z.m59951QO(i)) {
                if (i == 1581) {
                    iDKey.SetKey(64);
                } else {
                    iDKey.SetKey(83);
                }
            } else if (C36381z.m59958hP(i, i2)) {
                if (i2 == 0) {
                    iDKey.SetKey(7);
                } else {
                    iDKey.SetKey(26);
                }
            } else if (C36381z.m59957hO(i, i2)) {
                iDKey.SetKey(7);
            } else {
                C4990ab.m7412e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i + " cmdid:" + i2 + " , ID is -1");
                AppMethodBeat.m2505o(49091);
                return;
            }
            ArrayList arrayList = new ArrayList();
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(i6);
            iDKey2.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i6);
            iDKey3.SetValue(1);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(i6);
            iDKey4.SetValue((long) ((int) j));
            if (C36381z.m59955hM(i, i2)) {
                iDKey2.SetKey(19);
                if (j <= 1000) {
                    iDKey3.SetKey(20);
                    iDKey4.SetKey(23);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(21);
                    iDKey4.SetKey(24);
                } else if (j > 3000) {
                    iDKey3.SetKey(22);
                    iDKey4.SetKey(25);
                }
            } else if (C36381z.m59956hN(i, i2)) {
                iDKey2.SetKey(38);
                if (j <= 1000) {
                    iDKey3.SetKey(39);
                    iDKey4.SetKey(42);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(40);
                    iDKey4.SetKey(43);
                } else if (j > 3000) {
                    iDKey3.SetKey(41);
                    iDKey4.SetKey(44);
                }
            } else if (i == 1581) {
                iDKey2.SetKey(57);
                if (j <= 1000) {
                    iDKey3.SetKey(58);
                    iDKey4.SetKey(61);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(59);
                    iDKey4.SetKey(62);
                } else if (j > 3000) {
                    iDKey3.SetKey(60);
                    iDKey4.SetKey(63);
                }
            } else if (i == 1685) {
                iDKey2.SetKey(76);
                if (j <= 1000) {
                    iDKey3.SetKey(77);
                    iDKey4.SetKey(80);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(78);
                    iDKey4.SetKey(81);
                } else if (j > 3000) {
                    iDKey3.SetKey(79);
                    iDKey4.SetKey(82);
                }
            } else if (i == 1558 && i2 == 0) {
                iDKey2.SetKey(0);
                if (j <= 1000) {
                    iDKey3.SetKey(1);
                    iDKey4.SetKey(4);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(2);
                    iDKey4.SetKey(5);
                } else if (j > 3000) {
                    iDKey3.SetKey(3);
                    iDKey4.SetKey(6);
                }
            } else if (i == 1558 && i2 == 1) {
                iDKey2.SetKey(19);
                if (j <= 1000) {
                    iDKey3.SetKey(20);
                    iDKey4.SetKey(23);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(21);
                    iDKey4.SetKey(24);
                } else if (j > 3000) {
                    iDKey3.SetKey(22);
                    iDKey4.SetKey(25);
                }
            } else {
                iDKey2.SetKey(0);
                if (j <= 1000) {
                    iDKey3.SetKey(1);
                    iDKey4.SetKey(4);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(2);
                    iDKey4.SetKey(5);
                } else if (j > 3000) {
                    iDKey3.SetKey(3);
                    iDKey4.SetKey(6);
                }
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            C7060h.pYm.mo8379b(arrayList, true);
            arrayList = new ArrayList();
            if (!(i3 == 0 && i4 == 0)) {
                ArrayList arrayList2 = new ArrayList();
                iDKey3 = new IDKey();
                iDKey3.SetID(i6);
                iDKey3.SetValue(1);
                iDKey4 = new IDKey();
                iDKey4.SetID(i6);
                iDKey4.SetValue(1);
                if (C36381z.m59955hM(i, i2)) {
                    iDKey3.SetKey(27);
                    if (i4 < 0) {
                        iDKey4.SetKey(28);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(29);
                    }
                } else if (C36381z.m59956hN(i, i2)) {
                    iDKey3.SetKey(46);
                    if (i4 < 0) {
                        iDKey4.SetKey(47);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(48);
                    }
                } else if (i == 1581) {
                    iDKey3.SetKey(65);
                    if (i4 < 0) {
                        iDKey4.SetKey(66);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(67);
                    }
                } else if (i == 1685) {
                    iDKey3.SetKey(84);
                    if (i4 < 0) {
                        iDKey4.SetKey(85);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(86);
                    }
                } else if (i == 1558 && i2 == 0) {
                    iDKey3.SetKey(8);
                    if (i4 < 0) {
                        iDKey4.SetKey(9);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(10);
                    }
                } else if (i == 1558 && i2 == 1) {
                    iDKey3.SetKey(27);
                    if (i4 < 0) {
                        iDKey4.SetKey(28);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(29);
                    }
                } else {
                    iDKey3.SetKey(8);
                    if (i4 < 0) {
                        iDKey4.SetKey(9);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(10);
                    }
                }
                arrayList2.add(iDKey3);
                arrayList2.add(iDKey4);
                arrayList.addAll(arrayList2);
            }
            arrayList.add(iDKey);
            C7060h.pYm.mo8379b(arrayList, true);
            AppMethodBeat.m2505o(49091);
            return;
        }
        Object obj;
        if (i == 385 && i2 == 19) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ArrayList arrayList3 = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(C19395n.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(0);
            arrayList3.add(iDKey);
            if (!(i3 == 0 && i4 == 0)) {
                iDKey = new IDKey();
                iDKey.SetID(C19395n.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(1);
                arrayList3.add(iDKey);
            }
            C7060h.pYm.mo8379b(arrayList3, true);
            AppMethodBeat.m2505o(49091);
            return;
        }
        AppMethodBeat.m2505o(49091);
    }

    /* renamed from: hM */
    private static boolean m59955hM(int i, int i2) {
        return i == 385 && i2 == 112;
    }

    /* renamed from: hN */
    private static boolean m59956hN(int i, int i2) {
        return i == 385 && (i2 == 0 || i2 == 1 || i2 == 16);
    }

    /* renamed from: hO */
    private static boolean m59957hO(int i, int i2) {
        return i == 398 || ((i == 385 && (i2 == 74 || i2 == 75)) || i == 1544 || i == 1582 || i == C27084e.CTRL_INDEX || i == 397 || i == 1575 || i == 1639 || i == 556 || i == v2helper.EMethodOutputVolumeGainEnable);
    }

    /* renamed from: QO */
    private static boolean m59951QO(int i) {
        return i == 1581 || i == 1685;
    }

    /* renamed from: hP */
    private static boolean m59958hP(int i, int i2) {
        return i == 1558 && (i2 == 0 || i2 == 1);
    }
}
