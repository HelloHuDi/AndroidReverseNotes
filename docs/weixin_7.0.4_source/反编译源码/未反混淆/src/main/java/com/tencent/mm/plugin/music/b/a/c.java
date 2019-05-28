package com.tencent.mm.plugin.music.b.a;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.xwalk.core.XWalkEnvironment;

public final class c implements d {
    private static volatile HashMap<String, a> oKA = new HashMap();
    private static volatile HashMap<String, List<Long>> oKB = new HashMap();
    private static volatile HashMap<String, List<Long>> oKC = new HashMap();
    private static volatile HashMap<String, List<Long>> oKD = new HashMap();
    private static volatile int oKr = 0;
    private static volatile int oKs = 0;
    private static volatile int oKt = 0;
    private static volatile int oKu = 0;
    private static volatile int oKv = 0;
    private static volatile int oKw = 0;
    private static volatile int oKx = 0;
    private static volatile HashMap<String, Integer> oKy = new HashMap();
    private static volatile HashMap<String, Integer> oKz = new HashMap();

    class a {
        long duration = 0;
        long fileSize = 0;
        long oKQ = 0;
        int playCount = 0;

        a() {
        }
    }

    class b {
        long hoN = 0;
        int oKR = 0;
        long oKS = 0;

        b() {
        }
    }

    static /* synthetic */ int Cd() {
        int i = oKu;
        oKu = i + 1;
        return i;
    }

    static /* synthetic */ int alh() {
        int i = oKv;
        oKv = i + 1;
        return i;
    }

    static /* synthetic */ int bTn() {
        int i = oKs;
        oKs = i + 1;
        return i;
    }

    static /* synthetic */ int bTr() {
        int i = oKx;
        oKx = i + 1;
        return i;
    }

    static /* synthetic */ int bTs() {
        int i = oKw;
        oKw = i + 1;
        return i;
    }

    public final void eD(int i, int i2) {
        int i3;
        AppMethodBeat.i(104821);
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrSceneIdKey, scene:".concat(String.valueOf(i)));
        switch (i) {
        }
        iDKey2.SetKey(9);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(688);
        ab.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                i3 = 17;
                break;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                i3 = 18;
                break;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                i3 = 19;
                break;
            case 62:
                i3 = 20;
                break;
            case 63:
                i3 = 21;
                break;
            case 64:
                i3 = 22;
                break;
            case 66:
                i3 = 23;
                break;
            case 67:
                i3 = 24;
                break;
            case 69:
                i3 = 25;
                break;
            case 70:
                i3 = 36;
                break;
            case 74:
                i3 = 26;
                break;
            case 80:
                i3 = 27;
                break;
            case 101:
                i3 = 28;
                break;
            case 102:
                i3 = 29;
                break;
            case 500:
                i3 = 31;
                break;
            case 501:
                i3 = 32;
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                i3 = 33;
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                i3 = 34;
                break;
            case 504:
                i3 = 35;
                break;
            default:
                i3 = 30;
                break;
        }
        iDKey3.SetKey(i3);
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(104821);
    }

    public final void zp(int i) {
        int i2;
        AppMethodBeat.i(104822);
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        if (i == 2) {
            i2 = 42;
        } else if (i == 3) {
            i2 = 43;
        } else if (i == 4) {
            i2 = 44;
        } else if (i == 5) {
            i2 = 45;
        } else if (i == 6) {
            i2 = 46;
        } else if (i == 7) {
            i2 = 47;
        } else if (i == 8) {
            i2 = 48;
        } else if (i == 9) {
            i2 = 49;
        } else {
            i2 = 50;
        }
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(104822);
    }

    static {
        AppMethodBeat.i(104835);
        AppMethodBeat.o(104835);
    }

    public final void bTm() {
        synchronized (oKz) {
            oKt++;
        }
    }

    public final void fl(final String str, final String str2) {
        AppMethodBeat.i(104826);
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104816);
                String str = str + "-" + ag.ck(str2);
                synchronized (c.oKz) {
                    try {
                        if (c.oKy.containsKey(str)) {
                            c.oKy.put(str, Integer.valueOf(((Integer) c.oKy.get(str)).intValue() + 1));
                        } else {
                            c.oKy.put(str, Integer.valueOf(1));
                        }
                        c.bTn();
                    } finally {
                        AppMethodBeat.o(104816);
                    }
                }
            }
        });
        AppMethodBeat.o(104826);
    }

    public final void r(final String str, final String str2, final boolean z) {
        AppMethodBeat.i(104827);
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104817);
                String str = str + "-" + ag.ck(str2);
                synchronized (c.oKz) {
                    try {
                        if (c.oKz.containsKey(str)) {
                            c.oKz.put(str, Integer.valueOf(((Integer) c.oKz.get(str)).intValue() + 1));
                        } else {
                            c.oKz.put(str, Integer.valueOf(1));
                        }
                        if (z) {
                            c.Cd();
                        } else {
                            c.alh();
                        }
                    } finally {
                        AppMethodBeat.o(104817);
                    }
                }
            }
        });
        AppMethodBeat.o(104827);
    }

    public final void a(String str, String str2, long j, long j2, long j3) {
        AppMethodBeat.i(104828);
        a(str, str2, j, j2, j3, true, "", 0, 0, 0);
        AppMethodBeat.o(104828);
    }

    public final void a(String str, String str2, long j, long j2, long j3, boolean z, String str3, long j4, long j5, long j6) {
        AppMethodBeat.i(104829);
        final String str4 = str;
        final String str5 = str2;
        final long j7 = j;
        final long j8 = j2;
        final long j9 = j3;
        final boolean z2 = z;
        final String str6 = str3;
        final long j10 = j6;
        final long j11 = j5;
        final long j12 = j4;
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104818);
                String str = str4 + "-" + ag.ck(str5);
                synchronized (c.oKz) {
                    try {
                        int intValue;
                        if (c.oKz.containsKey(str)) {
                            c.a(c.oKB, str, j7);
                            c.a(c.oKC, str, j8);
                            c.a(c.oKD, str, j9);
                            intValue = ((Integer) c.oKz.get(str)).intValue() - 1;
                            if (intValue > 0) {
                                c.oKz.put(str, Integer.valueOf(intValue));
                            } else {
                                c.oKz.remove(str);
                            }
                            if (z2) {
                                c.bTs();
                            } else {
                                c.oKr = 1;
                                c.bTr();
                            }
                        } else {
                            ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio not exist audioKey, audioId:%s, audioSrc:%s", str4, str5);
                        }
                        if (c.oKy.containsKey(str)) {
                            intValue = ((Integer) c.oKy.get(str)).intValue() - 1;
                            if (intValue > 0) {
                                c.oKy.put(str, Integer.valueOf(intValue));
                            } else {
                                c.oKy.remove(str);
                            }
                        }
                        if (!(z2 || TextUtils.isEmpty(str6))) {
                            a aVar;
                            if (c.oKA.containsKey(str6)) {
                                aVar = (a) c.oKA.get(str6);
                                if (aVar != null) {
                                    aVar.playCount++;
                                }
                                aVar.oKQ = j10;
                                aVar.fileSize = j11;
                                aVar.duration = j12;
                                c.oKA.put(str6, aVar);
                            } else {
                                aVar = new a();
                                aVar.playCount = 1;
                                aVar.oKQ = j10;
                                aVar.fileSize = j11;
                                aVar.duration = j12;
                                c.oKA.put(str6, aVar);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(104818);
                    }
                }
            }
        });
        AppMethodBeat.o(104829);
    }

    public final void b(String str, long j, long j2, long j3) {
        AppMethodBeat.i(104830);
        final String str2 = str;
        final long j4 = j;
        final long j5 = j2;
        final long j6 = j3;
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104819);
                synchronized (c.oKz) {
                    try {
                        String str;
                        int intValue;
                        ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear appId:%s", str2);
                        int i = 0;
                        int i2 = 0;
                        String str2 = "";
                        for (Entry entry : c.oKy.entrySet()) {
                            String str3;
                            str = (String) entry.getKey();
                            i += ((Integer) entry.getValue()).intValue();
                            if (((Integer) entry.getValue()).intValue() > i2) {
                                intValue = ((Integer) entry.getValue()).intValue();
                                str3 = str;
                            } else {
                                intValue = i2;
                                str3 = str2;
                            }
                            ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear real invoke audioKey:%s, lostCount:%s", str, entry.getValue());
                            i2 = intValue;
                            str2 = str3;
                        }
                        c.oKy.clear();
                        int i3 = 0;
                        Object obj = "";
                        int i4 = 0;
                        for (Entry entry2 : c.oKz.entrySet()) {
                            str = (String) entry2.getKey();
                            int intValue2 = i4 + ((Integer) entry2.getValue()).intValue();
                            if (((Integer) entry2.getValue()).intValue() > i3) {
                                intValue = ((Integer) entry2.getValue()).intValue();
                                obj = str;
                            } else {
                                intValue = i3;
                            }
                            ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear audioKey:%s, lostCount:%s", str, entry2.getValue());
                            i3 = intValue;
                            i4 = intValue2;
                        }
                        c.oKz.clear();
                        b bVar = new b();
                        b bVar2 = new b();
                        b bVar3 = new b();
                        c.a(bVar, c.oKB);
                        c.a(bVar2, c.oKC);
                        c.a(bVar3, c.oKD);
                        c.oKB.clear();
                        c.oKC.clear();
                        c.oKD.clear();
                        ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear invokeTotalLostCount:%s, invokeMaxLostCount:%s, invokeMaxLostKey:%s, totalCostCount:%s, totalCostTime:%s, averageCostTime:%s, totalJsCostCount:%s, totalJSCostTime:%s, averageJSCostTime:%s,totalInvokeCostCount:%s, totalInvokeCostTime:%s, averageInvokeCostTime:%s,totalLostCount:%s, maxLostCount:%s, maxLostKey:%s, realInvokeTotalCount:%s, reachMaxPlayerCount:%s, audioPlayerType:%s, useQQAudioPlayerCount:%s, useAudioMixPlayerCount:%s, mixAverageTime:%s, maxCacheBufferSize:%s, realCacheBufferSize:%s", Integer.valueOf(i), Integer.valueOf(i2), str2, Integer.valueOf(bVar.oKR), Long.valueOf(bVar.hoN), Long.valueOf(bVar.oKS), Integer.valueOf(bVar2.oKR), Long.valueOf(bVar2.hoN), Long.valueOf(bVar2.oKS), Integer.valueOf(bVar3.oKR), Long.valueOf(bVar3.hoN), Long.valueOf(bVar3.oKS), Integer.valueOf(i4), Integer.valueOf(i3), obj, Integer.valueOf(c.oKs), Integer.valueOf(c.oKt), Integer.valueOf(c.oKr), Integer.valueOf(c.oKw), Integer.valueOf(c.oKx), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6));
                        ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear invokeQQAudioPlayerPlayCount:%s, invokeMixPlayerPlayCount:%s, useQQAudioPlayerPlayLostCount:%s, useMixPlayerPlayLostCount:%s, ", Integer.valueOf(c.oKu), Integer.valueOf(c.oKv), Integer.valueOf((c.oKu - c.oKw) + c.oKt), Integer.valueOf(c.oKv - c.oKx));
                        if (bVar.oKR > 0 && bVar2.oKR > 0 && bVar3.oKR > 0) {
                            h.pYm.e(15686, str2, Integer.valueOf(i), Integer.valueOf(i2), str2, Integer.valueOf(bVar.oKR), Long.valueOf(bVar.hoN), Long.valueOf(bVar.oKS), Integer.valueOf(bVar2.oKR), Long.valueOf(bVar2.hoN), Long.valueOf(bVar2.oKS), Integer.valueOf(bVar3.oKR), Long.valueOf(bVar3.hoN), Long.valueOf(bVar3.oKS), Integer.valueOf(i4), Integer.valueOf(i3), obj, Integer.valueOf(c.oKs), Integer.valueOf(c.oKt), Integer.valueOf(c.oKr), Integer.valueOf(c.oKw), Integer.valueOf(c.oKx), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf((c.oKu - c.oKw) + c.oKt), Integer.valueOf(c.oKv - c.oKx));
                            c.a(c.oKr, bVar2.oKS, bVar3.oKS, bVar.oKS, i4 + c.oKt, i, j5, j6, c.oKt + (c.oKu - c.oKw), c.oKv - c.oKx);
                        }
                        c.oKs = 0;
                        c.oKt = 0;
                        c.oKr = 0;
                        c.oKu = 0;
                        c.oKv = 0;
                        c.oKw = 0;
                        c.oKx = 0;
                        c.SO(str2);
                        c.oKA.clear();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(104819);
                    }
                }
            }
        });
        AppMethodBeat.o(104830);
    }

    public final void zo(int i) {
        AppMethodBeat.i(104820);
        ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportQQAudioPlayerSum scene:%d", Integer.valueOf(i));
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerSumIdKeyByScene, scene:".concat(String.valueOf(i)));
        switch (i) {
        }
        iDKey2.SetKey(2);
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(104820);
    }

    public final void zq(int i) {
        AppMethodBeat.i(104823);
        ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportAudioMixPlayerSum scene:%d", Integer.valueOf(i));
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(90);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(104823);
    }

    public final void zr(int i) {
        AppMethodBeat.i(104824);
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(91);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        iDKey2.SetKey(b.zn(i));
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.pYm.b(arrayList, true);
        b.r(arrayList);
        AppMethodBeat.o(104824);
    }

    public final void zs(int i) {
        AppMethodBeat.i(104825);
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(118);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        iDKey2.SetKey(b.zn(i));
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.pYm.b(arrayList, true);
        b.r(arrayList);
        AppMethodBeat.o(104825);
    }

    public static void a(int i, long j, long j2, long j3, int i2, int i3, long j4, long j5, int i4, int i5) {
        int i6;
        AppMethodBeat.i(104831);
        IDKey iDKey = new IDKey();
        iDKey.SetID(971);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(971);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(971);
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(971);
        iDKey3.SetValue(1);
        arrayList.add(iDKey3);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(971);
        iDKey4.SetValue(1);
        arrayList.add(iDKey4);
        IDKey iDKey5 = new IDKey();
        iDKey5.SetID(971);
        iDKey5.SetValue(1);
        arrayList.add(iDKey5);
        IDKey iDKey6 = new IDKey();
        iDKey6.SetID(971);
        iDKey6.SetValue(1);
        arrayList.add(iDKey6);
        IDKey iDKey7 = new IDKey();
        iDKey7.SetID(971);
        iDKey7.SetValue(1);
        arrayList.add(iDKey7);
        IDKey iDKey8 = new IDKey();
        IDKey iDKey9 = new IDKey();
        if (i2 > 0) {
            iDKey8.SetID(971);
            iDKey8.SetValue(1);
            arrayList.add(iDKey8);
            iDKey9.SetID(971);
            iDKey9.SetValue(1);
            arrayList.add(iDKey9);
        }
        IDKey iDKey10 = new IDKey();
        IDKey iDKey11 = new IDKey();
        if (i3 > 0) {
            iDKey10.SetID(971);
            iDKey10.SetValue(1);
            arrayList.add(iDKey10);
            iDKey11.SetID(971);
            iDKey11.SetValue(1);
            arrayList.add(iDKey11);
        }
        if (i == 0) {
            iDKey.SetKey(1);
            iDKey2.SetKey(2);
            if (0 <= j && j <= 3) {
                i6 = 3;
            } else if (3 < j && j <= 6) {
                i6 = 4;
            } else if (6 < j && j <= 10) {
                i6 = 5;
            } else if (10 < j && j <= 15) {
                i6 = 6;
            } else if (15 >= j || j > 20) {
                i6 = 8;
            } else {
                i6 = 7;
            }
            iDKey3.SetKey(i6);
            iDKey4.SetKey(11);
            if (0 <= j2 && j2 <= 6) {
                i6 = 12;
            } else if (6 < j2 && j2 <= 10) {
                i6 = 13;
            } else if (10 < j2 && j2 <= 15) {
                i6 = 14;
            } else if (15 < j2 && j2 <= 20) {
                i6 = 15;
            } else if (20 < j2 && j2 <= 30) {
                i6 = 16;
            } else if (30 < j2 && j2 <= 40) {
                i6 = 17;
            } else if (40 >= j2 || j2 > 50) {
                i6 = 19;
            } else {
                i6 = 18;
            }
            iDKey5.SetKey(i6);
            iDKey6.SetKey(22);
            if (0 <= j3 && j3 <= 20) {
                i6 = 23;
            } else if (20 < j3 && j3 <= 30) {
                i6 = 24;
            } else if (30 < j3 && j3 <= 40) {
                i6 = 25;
            } else if (40 < j3 && j3 <= 50) {
                i6 = 26;
            } else if (50 < j3 && j3 <= 60) {
                i6 = 27;
            } else if (60 < j3 && j3 <= 70) {
                i6 = 28;
            } else if (70 < j3 && j3 <= 80) {
                i6 = 29;
            } else if (80 < j3 && j3 <= 90) {
                i6 = 30;
            } else if (90 < j3 && j3 <= 100) {
                i6 = 31;
            } else if (100 < j3 && j3 <= 110) {
                i6 = 32;
            } else if (110 < j3 && j3 <= 120) {
                i6 = 33;
            } else if (120 < j3 && j3 <= 130) {
                i6 = 34;
            } else if (130 < j3 && j3 <= 140) {
                i6 = 35;
            } else if (140 < j3 && j3 <= 150) {
                i6 = 36;
            } else if (150 >= j3 || j3 > 200) {
                i6 = 38;
            } else {
                i6 = 37;
            }
            iDKey7.SetKey(i6);
            if (i2 > 0) {
                iDKey8.SetKey(41);
                if (i2 == 0) {
                    i6 = 42;
                } else if (i2 > 0 && i2 <= 3) {
                    i6 = 43;
                } else if (4 <= i2 && i2 <= 6) {
                    i6 = 44;
                } else if (7 <= i2 && i2 <= 10) {
                    i6 = 45;
                } else if (11 <= i2 && i2 <= 15) {
                    i6 = 46;
                } else if (15 < i2 && i2 <= 20) {
                    i6 = 47;
                } else if (20 < i2 && i2 <= 40) {
                    i6 = 48;
                } else if (40 < i2 && i2 <= 60) {
                    i6 = 49;
                } else if (60 >= i2 || i2 > 100) {
                    i6 = 51;
                } else {
                    i6 = 50;
                }
                iDKey9.SetKey(i6);
            }
            if (i3 > 0) {
                iDKey10.SetKey(124);
                if (i3 == 0) {
                    i6 = 125;
                } else if (i3 >= 0 && i3 <= 10) {
                    i6 = 126;
                } else if (10 <= i3 && i3 <= 20) {
                    i6 = d.MIC_SketchMark;
                } else if (20 <= i3 && i3 <= 40) {
                    i6 = 128;
                } else if (40 <= i3 && i3 <= 60) {
                    i6 = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                } else if (60 < i3 && i3 <= 100) {
                    i6 = 130;
                } else if (100 < i3 && i3 <= 150) {
                    i6 = 131;
                } else if (150 < i3 && i3 <= 200) {
                    i6 = 132;
                } else if (200 >= i3 || i3 > 500) {
                    i6 = com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX;
                } else {
                    i6 = e.CTRL_INDEX;
                }
                iDKey11.SetKey(i6);
            }
        } else {
            iDKey.SetKey(59);
            iDKey2.SetKey(60);
            if (0 < j && j <= 3) {
                i6 = 61;
            } else if (3 < j && j <= 6) {
                i6 = 62;
            } else if (6 < j && j <= 10) {
                i6 = 63;
            } else if (10 < j && j <= 15) {
                i6 = 64;
            } else if (15 >= j || j > 20) {
                i6 = 66;
            } else {
                i6 = 65;
            }
            iDKey3.SetKey(i6);
            iDKey4.SetKey(69);
            if (0 <= j2 && j2 <= 6) {
                i6 = 70;
            } else if (6 < j2 && j2 <= 10) {
                i6 = 71;
            } else if (10 < j2 && j2 <= 15) {
                i6 = 72;
            } else if (15 < j2 && j2 <= 20) {
                i6 = 73;
            } else if (20 < j2 && j2 <= 30) {
                i6 = 74;
            } else if (30 < j2 && j2 <= 40) {
                i6 = 75;
            } else if (40 >= j2 || j2 > 50) {
                i6 = 77;
            } else {
                i6 = 76;
            }
            iDKey5.SetKey(i6);
            iDKey6.SetKey(80);
            if (0 <= j3 && j3 <= 20) {
                i6 = 81;
            } else if (20 < j3 && j3 <= 30) {
                i6 = 82;
            } else if (30 < j3 && j3 <= 40) {
                i6 = 83;
            } else if (40 < j3 && j3 <= 50) {
                i6 = 84;
            } else if (50 < j3 && j3 <= 60) {
                i6 = 85;
            } else if (60 < j3 && j3 <= 70) {
                i6 = 86;
            } else if (70 < j3 && j3 <= 80) {
                i6 = 87;
            } else if (80 < j3 && j3 <= 90) {
                i6 = 88;
            } else if (90 < j3 && j3 <= 100) {
                i6 = 89;
            } else if (100 < j3 && j3 <= 110) {
                i6 = 90;
            } else if (110 < j3 && j3 <= 120) {
                i6 = 91;
            } else if (120 < j3 && j3 <= 130) {
                i6 = 92;
            } else if (130 < j3 && j3 <= 140) {
                i6 = 93;
            } else if (140 < j3 && j3 <= 150) {
                i6 = 94;
            } else if (150 >= j3 || j3 > 200) {
                i6 = 96;
            } else {
                i6 = 95;
            }
            iDKey7.SetKey(i6);
            if (i2 > 0) {
                iDKey8.SetKey(98);
                if (i2 == 0) {
                    i6 = 99;
                } else if (i2 > 0 && i2 <= 3) {
                    i6 = 100;
                } else if (4 <= i2 && i2 <= 6) {
                    i6 = 101;
                } else if (7 <= i2 && i2 <= 10) {
                    i6 = 102;
                } else if (11 <= i2 && i2 <= 15) {
                    i6 = 103;
                } else if (15 < i2 && i2 <= 20) {
                    i6 = 104;
                } else if (20 < i2 && i2 <= 40) {
                    i6 = 105;
                } else if (40 < i2 && i2 <= 60) {
                    i6 = 106;
                } else if (60 >= i2 || i2 > 100) {
                    i6 = 108;
                } else {
                    i6 = 107;
                }
                iDKey9.SetKey(i6);
            }
            if (i3 > 0) {
                iDKey10.SetKey(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX);
                if (i3 == 0) {
                    i6 = 140;
                } else if (i3 >= 0 && i3 <= 10) {
                    i6 = 141;
                } else if (10 <= i3 && i3 <= 20) {
                    i6 = ErrorCode.NEEDDOWNLOAD_3;
                } else if (20 <= i3 && i3 <= 40) {
                    i6 = ErrorCode.NEEDDOWNLOAD_4;
                } else if (40 <= i3 && i3 <= 60) {
                    i6 = 144;
                } else if (60 < i3 && i3 <= 100) {
                    i6 = 145;
                } else if (100 < i3 && i3 <= 150) {
                    i6 = 146;
                } else if (150 < i3 && i3 <= 200) {
                    i6 = ErrorCode.NEEDDOWNLOAD_8;
                } else if (200 >= i3 || i3 > 500) {
                    i6 = 149;
                } else {
                    i6 = 148;
                }
                iDKey11.SetKey(i6);
            }
            if (j4 > 0 && j5 > 0) {
                iDKey = new IDKey();
                iDKey.SetID(971);
                iDKey.SetValue(1);
                iDKey.SetKey(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(971);
                iDKey2.SetValue(1);
                if (0 <= j4 && j4 <= 10485760) {
                    i6 = JsApiMakeVoIPCall.CTRL_INDEX;
                } else if (10485760 < j4 && j4 <= 20971520) {
                    i6 = 155;
                } else if (20971520 < j4 && j4 <= 31457280) {
                    i6 = 156;
                } else if (31457280 < j4 && j4 <= 41943040) {
                    i6 = 157;
                } else if (41943040 < j4 && j4 <= 52428800) {
                    i6 = 158;
                } else if (52428800 < j4 && j4 <= 62914560) {
                    i6 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                } else if (62914560 < j4 && j4 <= 73400320) {
                    i6 = 160;
                } else if (73400320 < j4 && j4 <= 94371840) {
                    i6 = 161;
                } else if (94371840 >= j4 || j4 > 115343360) {
                    i6 = ErrorCode.STARTDOWNLOAD_4;
                } else {
                    i6 = ErrorCode.STARTDOWNLOAD_3;
                }
                iDKey2.SetKey(i6);
                arrayList.add(iDKey2);
                iDKey2 = new IDKey();
                iDKey2.SetID(971);
                iDKey2.SetValue(1);
                if (0 <= j5 && j5 <= 10485760) {
                    i6 = 169;
                } else if (10485760 < j5 && j5 <= 20971520) {
                    i6 = ErrorCode.NEEDDOWNLOAD_TRUE;
                } else if (20971520 < j5 && j5 <= 31457280) {
                    i6 = ErrorCode.NEEDDOWNLOAD_FALSE_1;
                } else if (31457280 < j5 && j5 <= 41943040) {
                    i6 = ErrorCode.NEEDDOWNLOAD_FALSE_2;
                } else if (41943040 < j5 && j5 <= 52428800) {
                    i6 = ErrorCode.NEEDDOWNLOAD_FALSE_3;
                } else if (52428800 < j5 && j5 <= 62914560) {
                    i6 = ErrorCode.NEEDDOWNLOAD_FALSE_4;
                } else if (62914560 < j5 && j5 <= 73400320) {
                    i6 = ErrorCode.NEEDDOWNLOAD_FALSE_5;
                } else if (73400320 < j5 && j5 <= 94371840) {
                    i6 = ErrorCode.NEEDDOWNLOAD_FALSE_6;
                } else if (94371840 >= j5 || j5 > 115343360) {
                    i6 = 178;
                } else {
                    i6 = ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
                }
                iDKey2.SetKey(i6);
                arrayList.add(iDKey2);
            }
        }
        if (i4 > 0) {
            iDKey = new IDKey();
            iDKey.SetID(971);
            iDKey.SetValue(1);
            iDKey.SetKey(181);
            arrayList.add(iDKey);
            iDKey2 = new IDKey();
            iDKey2.SetID(971);
            iDKey2.SetValue(1);
            if (i4 > 0 && i4 <= 3) {
                i6 = FaceMoveUtil.TRIANGLE_COUNT;
            } else if (4 <= i4 && i4 <= 6) {
                i6 = 183;
            } else if (7 <= i4 && i4 <= 10) {
                i6 = FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE;
            } else if (11 <= i4 && i4 <= 15) {
                i6 = 185;
            } else if (15 < i4 && i4 <= 20) {
                i6 = 186;
            } else if (20 < i4 && i4 <= 40) {
                i6 = 187;
            } else if (40 < i4 && i4 <= 60) {
                i6 = 188;
            } else if (60 >= i4 || i4 > 100) {
                i6 = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            } else {
                i6 = 189;
            }
            iDKey2.SetKey(i6);
            arrayList.add(iDKey2);
        }
        if (i5 > 0) {
            iDKey = new IDKey();
            iDKey2 = new IDKey();
            iDKey.SetID(971);
            iDKey.SetValue(1);
            iDKey.SetKey(JsApiChooseMedia.CTRL_INDEX);
            arrayList.add(iDKey);
            iDKey2.SetID(971);
            iDKey2.SetValue(1);
            if (i5 > 0 && i5 <= 3) {
                i6 = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
            } else if (4 <= i5 && i5 <= 6) {
                i6 = JsApiChooseWeChatContact.CTRL_INDEX;
            } else if (7 <= i5 && i5 <= 10) {
                i6 = 196;
            } else if (11 <= i5 && i5 <= 15) {
                i6 = 197;
            } else if (15 < i5 && i5 <= 20) {
                i6 = o.CTRL_INDEX;
            } else if (20 < i5 && i5 <= 40) {
                i6 = 199;
            } else if (40 < i5 && i5 <= 60) {
                i6 = 200;
            } else if (60 >= i5 || i5 > 100) {
                i6 = 202;
            } else {
                i6 = 201;
            }
            iDKey2.SetKey(i6);
            arrayList.add(iDKey2);
        }
        h.pYm.b(arrayList, true);
        a.r(arrayList);
        AppMethodBeat.o(104831);
    }

    static /* synthetic */ void a(HashMap hashMap, String str, long j) {
        AppMethodBeat.i(104832);
        if (hashMap.containsKey(str)) {
            ((List) hashMap.get(str)).add(Long.valueOf(j));
            AppMethodBeat.o(104832);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        hashMap.put(str, arrayList);
        AppMethodBeat.o(104832);
    }

    static /* synthetic */ void a(b bVar, HashMap hashMap) {
        AppMethodBeat.i(104833);
        for (Entry value : hashMap.entrySet()) {
            List list = (List) value.getValue();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                bVar.hoN = ((Long) list.get(i2)).longValue() + bVar.hoN;
                i = i2 + 1;
            }
            bVar.oKR += list.size();
        }
        if (bVar.hoN > 0 && bVar.oKR > 0) {
            bVar.oKS = bVar.hoN / ((long) bVar.oKR);
        }
        AppMethodBeat.o(104833);
    }

    static /* synthetic */ void SO(String str) {
        AppMethodBeat.i(104834);
        for (Entry entry : oKA.entrySet()) {
            a aVar = (a) entry.getValue();
            if (aVar != null && aVar.playCount > 0) {
                long ek;
                if (aVar.fileSize == 0) {
                    ek = com.tencent.mm.audio.mix.h.a.ek((String) entry.getKey());
                } else {
                    ek = aVar.fileSize;
                }
                h.pYm.e(16577, str, Long.valueOf(ek), Long.valueOf(aVar.oKQ), Long.valueOf(aVar.duration), Integer.valueOf(aVar.playCount), Integer.valueOf(0));
            }
        }
        AppMethodBeat.o(104834);
    }
}
