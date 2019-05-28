package com.tencent.p177mm.plugin.monitor;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Debug.MemoryInfo;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf.C18201;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.monitor.C39415a.C21323a;
import com.tencent.p177mm.plugin.monitor.C39415a.C21324b;
import com.tencent.p177mm.plugin.monitor.C39415a.C21325c;
import com.tencent.p177mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.p177mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.p177mm.plugin.report.kvdata.TableInfo;
import com.tencent.p177mm.plugin.report.kvdata.log_14375;
import com.tencent.p177mm.plugin.report.service.C3744e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.monitor.b */
public class C46086b implements C1816at {
    private static final long startTime = System.currentTimeMillis();
    private C4931a foI = new C460858();
    private boolean jZS = false;
    private boolean jZT = true;
    private BroadcastReceiver jZU;
    private Runnable jZV;
    private C4884c nqj = new C4331811();
    private long oEA = 1024;
    private long oEB = 1440;
    private long oEC = 20;
    private long oED = 1440;
    private long oEE = 0;
    private C21323a oEF;
    private long oEG = 0;
    private C1202f oEH = new C345621();
    private Runnable oEI = new C394179();
    private Runnable oEJ = new C4331710();
    private C7564ap oEK = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C1262112(), true);
    private long oEt = 1024;
    private long oEu = 10;
    private long oEv = 1800;
    private long oEw = 3000000;
    private long oEx = 15000;
    private long oEy = 100000;
    private long oEz = 10000;

    /* renamed from: com.tencent.mm.plugin.monitor.b$12 */
    class C1262112 implements C5015a {
        C1262112() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(84530);
            C46086b.m85920e(C46086b.this);
            AppMethodBeat.m2505o(84530);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$4 */
    class C126224 implements Comparator<C5728b> {
        C126224() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(84520);
            long lastModified = ((C5728b) obj).lastModified() - ((C5728b) obj2).lastModified();
            if (lastModified > 0) {
                AppMethodBeat.m2505o(84520);
                return 1;
            } else if (lastModified == 0) {
                AppMethodBeat.m2505o(84520);
                return 0;
            } else {
                AppMethodBeat.m2505o(84520);
                return -1;
            }
        }

        public final boolean equals(Object obj) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$5 */
    class C126235 implements Runnable {
        C126235() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84521);
            try {
                int round;
                int i;
                long j;
                long j2;
                long j3;
                long j4;
                long j5;
                int i2;
                C5728b c5728b = new C5728b(C5128ac.eSj + "SdcardInfo.cfg");
                C7060h.pYm.mo8378a(340, c5728b.exists() ? 10 : 11, 1, true);
                boolean dpr = C5034bd.dpr();
                String path = C1448h.getDataDirectory().getPath();
                String path2 = C1448h.getExternalStorageDirectory().getPath();
                StatFs statFs = new StatFs(path);
                long blockSize = (long) statFs.getBlockSize();
                long blockCount = (long) statFs.getBlockCount();
                long availableBlocks = (long) statFs.getAvailableBlocks();
                long j6 = blockSize * blockCount;
                long j7 = blockSize * availableBlocks;
                if (blockCount > 0) {
                    round = Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount));
                } else {
                    round = -1;
                }
                statFs = new StatFs(path2);
                long blockSize2 = (long) statFs.getBlockSize();
                long blockCount2 = (long) statFs.getBlockCount();
                long availableBlocks2 = (long) statFs.getAvailableBlocks();
                long j8 = blockSize2 * blockCount2;
                long j9 = blockSize2 * availableBlocks2;
                int i3 = -1;
                if (blockCount2 > 0) {
                    i3 = Math.round((((float) availableBlocks2) * 100.0f) / ((float) blockCount2));
                }
                boolean equals = C6457e.eSl.equals(path2);
                if (equals) {
                    i = i3;
                    j = j9;
                    j2 = j8;
                    j3 = availableBlocks2;
                    j4 = blockCount2;
                    j5 = blockSize2;
                } else {
                    statFs = new StatFs(C6457e.eSl);
                    j5 = (long) statFs.getBlockSize();
                    j4 = (long) statFs.getBlockCount();
                    long availableBlocks3 = (long) statFs.getAvailableBlocks();
                    long j10 = j5 * j4;
                    long j11 = j5 * availableBlocks3;
                    if (j4 > 0) {
                        i = Math.round((((float) availableBlocks3) * 100.0f) / ((float) j4));
                        j = j11;
                        j2 = j10;
                        j3 = availableBlocks3;
                    } else {
                        i = i3;
                        j = j11;
                        j2 = j10;
                        j3 = availableBlocks3;
                    }
                }
                String amQ = C5034bd.amQ(C6457e.eSl);
                String amQ2 = C5034bd.amQ(path);
                String str = "MicroMsg.SubCoreBaseMonitor";
                String str2 = "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]";
                Object[] objArr = new Object[26];
                objArr[0] = path;
                objArr[1] = path2;
                objArr[2] = C6457e.eSl;
                objArr[3] = amQ;
                objArr[4] = Boolean.valueOf(dpr);
                objArr[5] = Long.valueOf(blockSize);
                objArr[6] = Long.valueOf(blockCount);
                objArr[7] = Long.valueOf(availableBlocks);
                objArr[8] = Long.valueOf(j6);
                objArr[9] = Long.valueOf(j7);
                objArr[10] = Integer.valueOf(round);
                objArr[11] = Long.valueOf(blockSize2);
                objArr[12] = Long.valueOf(blockCount2);
                objArr[13] = Long.valueOf(availableBlocks2);
                objArr[14] = Long.valueOf(j8);
                objArr[15] = Long.valueOf(j9);
                objArr[16] = Integer.valueOf(i3);
                objArr[17] = Boolean.valueOf(equals);
                objArr[18] = Long.valueOf(j5);
                objArr[19] = Long.valueOf(j4);
                objArr[20] = Long.valueOf(j3);
                objArr[21] = Long.valueOf(j2);
                objArr[22] = Long.valueOf(j);
                objArr[23] = Integer.valueOf(i);
                if (c5728b.exists()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[24] = Integer.valueOf(i2);
                objArr[25] = amQ2;
                C4990ab.m7417i(str, str2, objArr);
                C7060h.pYm.mo8378a(340, 0, 1, true);
                C7060h.pYm.mo8378a(340, dpr ? 1 : 2, 1, true);
                C7060h.pYm.mo8378a(340, equals ? 3 : 4, 1, true);
                C7060h c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(5000);
                String str3 = "%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s";
                Object[] objArr2 = new Object[26];
                objArr2[0] = path;
                objArr2[1] = path2;
                objArr2[2] = C6457e.eSl;
                objArr2[3] = amQ;
                objArr2[4] = Integer.valueOf(dpr ? 1 : 0);
                objArr2[5] = Long.valueOf(blockSize);
                objArr2[6] = Long.valueOf(blockCount);
                objArr2[7] = Long.valueOf(availableBlocks);
                objArr2[8] = Long.valueOf(j6);
                objArr2[9] = Long.valueOf(j7);
                objArr2[10] = Integer.valueOf(round);
                objArr2[11] = Long.valueOf(blockSize2);
                objArr2[12] = Long.valueOf(blockCount2);
                objArr2[13] = Long.valueOf(availableBlocks2);
                objArr2[14] = Long.valueOf(j8);
                objArr2[15] = Long.valueOf(j9);
                objArr2[16] = Integer.valueOf(i3);
                objArr2[17] = Integer.valueOf(equals ? 1 : 0);
                objArr2[18] = Long.valueOf(j5);
                objArr2[19] = Long.valueOf(j4);
                objArr2[20] = Long.valueOf(j3);
                objArr2[21] = Long.valueOf(j2);
                objArr2[22] = Long.valueOf(j);
                objArr2[23] = Integer.valueOf(i);
                if (c5728b.exists()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr2[24] = Integer.valueOf(i2);
                objArr2[25] = amQ2;
                objArr[1] = String.format(str3, objArr2);
                c7060h.mo8381e(11098, objArr);
                C7060h.pYm.mo8381e(11098, Integer.valueOf(ReaderCallback.HIDDEN_BAR), path + ";" + amQ2);
                C7060h.pYm.mo8381e(11098, Integer.valueOf(ReaderCallback.SHOW_BAR), C6457e.eSl + ";" + amQ);
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(ReaderCallback.COPY_SELECT_TEXT);
                objArr[1] = Integer.valueOf(c5728b.exists() ? 1 : 0);
                c7060h.mo8381e(11098, objArr);
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(ReaderCallback.SEARCH_SELECT_TEXT);
                objArr[1] = Integer.valueOf(dpr ? 1 : 0);
                c7060h.mo8381e(11098, objArr);
                C7060h.pYm.mo8378a(340, 7, 1, true);
                AppMethodBeat.m2505o(84521);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportSDStatus err!", new Object[0]);
                C7060h.pYm.mo8378a(340, 8, 1, true);
                AppMethodBeat.m2505o(84521);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$7 */
    class C126247 implements Runnable {
        C126247() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84523);
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", Boolean.valueOf(C4815f.vxx), Boolean.valueOf(C4815f.vxy));
            C7060h.pYm.mo8378a(148, C4815f.vxx ? 100 : 101, 1, true);
            C7060h.pYm.mo8378a(148, C4815f.vxy ? 102 : 103, 1, true);
            AppMethodBeat.m2505o(84523);
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$13 */
    class C2852813 extends BroadcastReceiver {

        /* renamed from: com.tencent.mm.plugin.monitor.b$13$1 */
        class C285291 implements C39415a {
            C285291() {
            }

            /* renamed from: a */
            public final void mo46508a(int i, C21323a c21323a) {
                AppMethodBeat.m2504i(84531);
                C46086b.this.oEE = SystemClock.uptimeMillis();
                C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", Integer.valueOf(i), Long.valueOf(C46086b.this.oEE), C46086b.this.oEF, c21323a);
                C46086b.this.oEF = null;
                if (i == 0 && !c21323a.fIa) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(C46086b.this.oEE));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().dsb();
                    try {
                        C46086b.m85916b(C46086b.this, c21323a);
                        AppMethodBeat.m2505o(84531);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "doReportSDInfo err!", new Object[0]);
                        C7060h.pYm.mo8378a(418, 6, 1, true);
                    }
                }
                AppMethodBeat.m2505o(84531);
            }
        }

        C2852813() {
        }

        public final void onReceive(Context context, Intent intent) {
            boolean z;
            AppMethodBeat.m2504i(84533);
            String action = intent.getAction();
            int i = -1;
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        i = 1;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        i = 3;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    C46086b.this.jZT = true;
                    break;
                case 1:
                    C46086b.this.jZT = false;
                    break;
                case 2:
                    C46086b.this.jZS = true;
                    break;
                case 3:
                    C46086b.this.jZS = false;
                    break;
            }
            String str = "MicroMsg.SubCoreBaseMonitor";
            String str2 = "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
            Object[] objArr = new Object[5];
            objArr[0] = action;
            objArr[1] = Boolean.valueOf(C46086b.this.jZT);
            objArr[2] = Boolean.valueOf(C46086b.this.jZS);
            objArr[3] = Long.valueOf(C46086b.this.oEE);
            if (C46086b.this.jZV == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[4] = Boolean.valueOf(z);
            C4990ab.m7419v(str, str2, objArr);
            if (C46086b.this.jZV == null && C46086b.this.jZS && !C46086b.this.jZT) {
                if (C4872b.dnO()) {
                    C46086b.this.oEC = 0;
                } else if (SystemClock.uptimeMillis() - C46086b.this.oEE < C46086b.this.oEB * 60000) {
                    C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", Long.valueOf(C46086b.this.oEB));
                    AppMethodBeat.m2505o(84533);
                    return;
                }
                final C285291 c285291 = new C285291();
                C46086b.this.jZV = new Runnable() {
                    public final void run() {
                        int i;
                        AppMethodBeat.m2504i(84532);
                        C46086b.this.jZV = null;
                        List bOv = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().bOv();
                        if (C5046bo.m7548ek(bOv)) {
                            C4990ab.m7416i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
                            i = 0;
                        } else {
                            C7305d.post(new C18201(bOv), "checkUnfinishedDeleteMsgTask");
                            i = bOv.size();
                        }
                        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", Integer.valueOf(i));
                        if (i > 0) {
                            C7060h.pYm.mo8378a(418, 8, 1, true);
                        }
                        C46086b.this.oEF = C46086b.m85908a(C46086b.this, c285291);
                        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", C46086b.this.oEF);
                        AppMethodBeat.m2505o(84532);
                    }
                };
                C7305d.xDH.mo10141a(C46086b.this.jZV, "MicroMsg.SubCoreBaseMonitor", C46086b.this.oEC * 60000);
                C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", Long.valueOf(C46086b.this.oEC));
                AppMethodBeat.m2505o(84533);
            } else if (C46086b.this.jZV != null) {
                C7305d.xDH.mo10143al(C46086b.this.jZV);
                C46086b.this.jZV = null;
                C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", C46086b.this.oEF);
                AppMethodBeat.m2505o(84533);
            } else {
                if (C46086b.this.oEF != null) {
                    C46086b.this.oEF.fIa = true;
                    C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", C46086b.this.oEF);
                    C46086b.this.oEF = null;
                }
                AppMethodBeat.m2505o(84533);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$15 */
    class C2853115 implements Comparator<C21324b> {
        C2853115() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            long j = (long) (((C21324b) obj).tag - ((C21324b) obj2).tag);
            if (j > 0) {
                return 1;
            }
            if (j == 0) {
                return 0;
            }
            return -1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$1 */
    class C345621 implements C1202f {
        C345621() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(84517);
            String str2 = "MicroMsg.SubCoreBaseMonitor";
            String str3 = "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(c1207m == null ? -1 : c1207m.getType());
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            C4990ab.m7417i(str2, str3, objArr);
            if (i == 0 && i2 == 0) {
                C3744e.cgp();
            }
            AppMethodBeat.m2505o(84517);
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$3 */
    class C394163 implements Runnable {
        C394163() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84519);
            try {
                C1720g.m3537RQ();
                int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                C1720g.m3537RQ();
                long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                long r = C46086b.m85935r(C46086b.this);
                int i = (intValue <= 0 || C7243d.vxo == intValue) ? 1 : 0;
                StringBuilder append = new StringBuilder().append(intValue).append(";").append(C7243d.vxo).append(";");
                if (i != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                String stringBuilder = append.append(i).append(";").append(new SimpleDateFormat("yyyyMMdd").format(new Date(longValue))).append(";").append(r).toString();
                C7060h.pYm.mo8378a(418, 1, 1, true);
                C7060h.pYm.mo8381e(13778, Integer.valueOf(3), Integer.valueOf(1), stringBuilder);
                C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", stringBuilder);
                AppMethodBeat.m2505o(84519);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportVersion err!", new Object[0]);
                C7060h.pYm.mo8378a(418, 2, 1, true);
                AppMethodBeat.m2505o(84519);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$9 */
    class C394179 implements Runnable {
        C394179() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84526);
            C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
            if (C1720g.m3531RK()) {
                C46086b.m85915b(C46086b.this);
                C46086b.m85918c(C46086b.this);
                C46086b.m85919d(C46086b.this);
                C46086b.m85920e(C46086b.this);
                C46086b.m85921f(C46086b.this);
                C7305d.xDH.mo10143al(C46086b.this.oEJ);
                C7305d.xDH.mo10144o(C46086b.this.oEJ, 10000);
                AppMethodBeat.m2505o(84526);
                return;
            }
            C4990ab.m7420w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
            AppMethodBeat.m2505o(84526);
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$10 */
    class C4331710 implements Runnable {
        C4331710() {
        }

        public final void run() {
            AppMethodBeat.m2504i(84527);
            C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
            if (C1720g.m3531RK()) {
                C46086b.m85923h(C46086b.this);
            }
            AppMethodBeat.m2505o(84527);
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$11 */
    class C4331811 extends C4884c<C6523mp> {
        C4331811() {
            AppMethodBeat.m2504i(84528);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(84528);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(84529);
            C7305d.xDH.mo10143al(C46086b.this.oEI);
            C7305d.xDH.mo10144o(C46086b.this.oEI, 3000);
            AppMethodBeat.m2505o(84529);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.b$8 */
    class C460858 implements C4931a {

        /* renamed from: com.tencent.mm.plugin.monitor.b$8$1 */
        class C285331 implements Runnable {
            C285331() {
            }

            public final void run() {
                AppMethodBeat.m2504i(84524);
                C46086b.m85913a(C46086b.this);
                AppMethodBeat.m2505o(84524);
            }
        }

        C460858() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(84525);
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", C5046bo.dpG());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                C7305d.xDH.mo10144o(new C285331(), 100);
            }
            AppMethodBeat.m2505o(84525);
        }
    }

    public C46086b() {
        AppMethodBeat.m2504i(84536);
        AppMethodBeat.m2505o(84536);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m85913a(C46086b c46086b) {
        AppMethodBeat.m2504i(84543);
        boolean je = c46086b.m85926je(true);
        AppMethodBeat.m2505o(84543);
        return je;
    }

    static {
        AppMethodBeat.m2504i(84555);
        AppMethodBeat.m2505o(84555);
    }

    /* renamed from: je */
    private boolean m85926je(boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(84537);
        C5141c ll = C18624c.abi().mo17131ll("100212");
        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", Boolean.valueOf(z), ll, Boolean.valueOf(ll.isValid()), ll.dru(), Long.valueOf(1024), Long.valueOf(10), Long.valueOf(1800), Long.valueOf(3000000), Long.valueOf(15000), Long.valueOf(15000), Long.valueOf(100000), Long.valueOf(10000), Long.valueOf(1440), Long.valueOf(20), Long.valueOf(1440));
        if (ll.isValid()) {
            C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map dru = ll.dru();
            long j = C5046bo.getLong((String) dru.get("sdsize"), 1024);
            long j2 = C5046bo.getLong((String) dru.get("sdratio"), 10);
            long j3 = C5046bo.getLong((String) dru.get("dbsize"), 1800);
            long j4 = C5046bo.getLong((String) dru.get("fdbsize"), 1024);
            long j5 = C5046bo.getLong((String) dru.get("msg"), 3000000);
            long j6 = C5046bo.getLong((String) dru.get("conv"), 15000);
            long j7 = C5046bo.getLong((String) dru.get("contact"), 100000);
            long j8 = C5046bo.getLong((String) dru.get("chatroom"), 10000);
            long j9 = C5046bo.getLong((String) dru.get("sditv"), 1440);
            long j10 = C5046bo.getLong((String) dru.get("sdwait"), 20);
            long j11 = C5046bo.getLong((String) dru.get("dbitv"), 1440);
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", Long.valueOf(this.oEt), Long.valueOf(j), Long.valueOf(this.oEu), Long.valueOf(j2), Long.valueOf(this.oEv), Long.valueOf(j3), Long.valueOf(this.oEA), Long.valueOf(j4), Long.valueOf(this.oEw), Long.valueOf(j5), Long.valueOf(this.oEx), Long.valueOf(j6), Long.valueOf(this.oEy), Long.valueOf(j7), Long.valueOf(this.oEz), Long.valueOf(j8), Long.valueOf(this.oEB), Long.valueOf(j9), Long.valueOf(this.oEC), Long.valueOf(j10), Long.valueOf(this.oED), Long.valueOf(j11));
            if (this.oEt != j) {
                this.oEt = j;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.oEu != j2) {
                this.oEu = j2;
                z2 = true;
            }
            if (this.oEv != j3) {
                this.oEv = j3;
                z2 = true;
            }
            if (this.oEA != j4) {
                this.oEA = j4;
                z2 = true;
            }
            if (this.oEw != j5) {
                this.oEw = j5;
                z2 = true;
            }
            if (this.oEx != j6) {
                this.oEx = j6;
                z2 = true;
            }
            if (this.oEy != j7) {
                this.oEy = j7;
                z2 = true;
            }
            if (this.oEz != j8) {
                this.oEz = j8;
                z2 = true;
            }
            if (this.oEB != j9) {
                this.oEB = j9;
                z2 = true;
            }
            if (this.oEC != j10) {
                this.oEC = j10;
                z2 = true;
            }
            if (this.oED != j11) {
                this.oED = j11;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            C7060h.pYm.mo8378a(509, 0, 1, true);
            if (z) {
                C7060h.pYm.mo8378a(509, 18, 1, true);
            }
        }
        if (this.oEt <= 0) {
            C7060h.pYm.mo8378a(509, 30, 1, true);
            this.oEt = 1024;
        }
        if (this.oEu <= 0) {
            C7060h.pYm.mo8378a(509, 31, 1, true);
            this.oEu = 10;
        }
        if (this.oEv <= 0) {
            C7060h.pYm.mo8378a(509, 32, 1, true);
            this.oEv = 1800;
        }
        if (this.oEw <= 0) {
            C7060h.pYm.mo8378a(509, 33, 1, true);
            this.oEw = 3000000;
        }
        if (this.oEx <= 0) {
            C7060h.pYm.mo8378a(509, 34, 1, true);
            this.oEx = 15000;
        }
        if (this.oEy <= 0) {
            C7060h.pYm.mo8378a(509, 35, 1, true);
            this.oEy = 100000;
        }
        if (this.oEz <= 0) {
            C7060h.pYm.mo8378a(509, 36, 1, true);
            this.oEz = 10000;
        }
        if (this.oEB <= 0) {
            C7060h.pYm.mo8378a(509, 37, 1, true);
            this.oEB = 1440;
        }
        if (this.oEC <= 0) {
            C7060h.pYm.mo8378a(509, 38, 1, true);
            this.oEC = 20;
        }
        if (this.oED <= 0) {
            C7060h.pYm.mo8378a(509, 39, 1, true);
            this.oED = 1440;
        }
        if (this.oEA <= 0) {
            C7060h.pYm.mo8378a(509, 40, 1, true);
            this.oEA = 1024;
        }
        AppMethodBeat.m2505o(84537);
        return z2;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(84538);
        C4879a.xxA.mo10051b(this.nqj);
        C18624c.abi().mo10116c(this.foI);
        boolean je = m85926je(false);
        C1720g.m3537RQ();
        this.oEG = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
        C3744e.m6063ki(this.oEG != 0);
        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", Long.valueOf(this.oEG), Boolean.valueOf(je), this.foI);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(989, this.oEH);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(988, this.oEH);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(987, this.oEH);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(986, this.oEH);
        C1720g.m3537RQ();
        this.oEE = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        Context context = C4996ah.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z2 = intExtra == 2 || intExtra == 5;
            this.jZS = z2;
        } else {
            this.jZS = false;
        }
        this.jZT = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.jZU = new C2852813();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this.jZU, intentFilter);
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.oEF != null ? "enabled" : "disabled";
        objArr[1] = this.jZT ? "" : " not";
        objArr[2] = this.jZS ? "" : " not";
        objArr[3] = Long.valueOf(this.oEE);
        objArr[4] = Long.valueOf(this.oEB * 60000);
        objArr[5] = Long.valueOf(this.oEC * 60000);
        C4990ab.m7417i(str, str2, objArr);
        this.oEK.stopTimer();
        AppMethodBeat.m2505o(84538);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(84539);
        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()));
        if (this.jZU != null) {
            C4996ah.getContext().unregisterReceiver(this.jZU);
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", this.jZU);
            this.jZU = null;
        }
        if (this.jZV != null) {
            C7305d.xDH.mo10143al(this.jZV);
            this.jZV = null;
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", this.oEF);
        }
        if (this.oEF != null) {
            this.oEF.fIa = true;
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", this.oEF);
            this.oEF = null;
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(989, this.oEH);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(988, this.oEH);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(987, this.oEH);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(986, this.oEH);
        C18624c.abi().mo10117d(this.foI);
        C4879a.xxA.mo10053d(this.nqj);
        AppMethodBeat.m2505o(84539);
    }

    /* renamed from: RQ */
    private static boolean m85905RQ(String str) {
        AppMethodBeat.m2504i(84540);
        C1720g.m3537RQ();
        if (C1720g.m3536RP().eJM.equals(str + "/")) {
            AppMethodBeat.m2505o(84540);
            return true;
        }
        AppMethodBeat.m2505o(84540);
        return false;
    }

    /* renamed from: a */
    private C21323a m85910a(C5728b c5728b, C21323a c21323a, C21324b c21324b, C21325c c21325c, Map<String, Integer> map, boolean z, int i) {
        AppMethodBeat.m2504i(84541);
        if (c21323a.fIa) {
            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", c21323a, c21324b);
            AppMethodBeat.m2505o(84541);
        } else {
            if (c21323a.bna < i) {
                c21323a.bna++;
            }
            if (c5728b.isDirectory()) {
                Object obj;
                C21324b c21324b2;
                String w = C5736j.m8649w(c5728b.dMD());
                if (c21324b == null) {
                    if (map == null || map.size() <= 0 || map.get(w) == null) {
                        if (C6457e.eSn.equals(c5728b.getParent() + "/")) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null || C46086b.m85905RQ(w)) {
                            if (C46086b.m85905RQ(c5728b.getParent())) {
                                c21324b2 = new C21324b(w, 203);
                            } else {
                                c21324b2 = c21324b;
                            }
                        } else if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", c5728b.getName())) {
                            c21324b2 = new C21324b(w, 202);
                        } else if (Pattern.matches("[a-fA-F0-9]{32}", c5728b.getName())) {
                            c21324b2 = new C21324b(w, 201);
                        } else {
                            c21324b2 = new C21324b(w, 203);
                        }
                    } else {
                        c21324b2 = new C21324b(w, ((Integer) map.get(w)).intValue());
                        map.remove(w);
                    }
                    if (c21324b2 != null) {
                        c21323a.oEq.add(c21324b2);
                        C4990ab.m7411d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", w, c21323a, c21324b2);
                    }
                } else {
                    c21324b2 = c21324b;
                }
                c21323a.oEo++;
                if (c21324b2 != null) {
                    c21324b2.oEo++;
                }
                if (c21325c != null) {
                    c21325c.oEo++;
                }
                if (i > 15) {
                    C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", Integer.valueOf(i), C5736j.m8649w(c5728b.dMD()), c21323a);
                    AppMethodBeat.m2505o(84541);
                } else {
                    String[] list = c5728b.list();
                    if (list == null) {
                        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", C5736j.m8649w(c5728b.dMD()));
                        AppMethodBeat.m2505o(84541);
                    } else if (z) {
                        C21325c c21325c2 = c21325c;
                        for (String str : list) {
                            if (!C5046bo.isNullOrNil(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                c21325c2 = new C21325c(C5736j.m8649w(c5728b.dMD()) + "/" + str);
                                c21323a.oEr.add(c21325c2);
                            }
                            m85910a(new C5728b(C5736j.m8649w(c5728b.mUri) + "/" + str), c21323a, c21324b2, c21325c2, map, false, i + 1);
                        }
                    } else {
                        Object obj2 = 1;
                        int length = list.length;
                        int i2 = 0;
                        while (i2 < length) {
                            m85910a(new C5728b(C5736j.m8649w(c5728b.dMD()) + "/" + list[i2]), c21323a, c21324b2, c21325c, map, false, i + 1);
                            if (obj2 == null || c21323a.bna <= 15) {
                                obj = obj2;
                            } else {
                                C7060h.pYm.mo8378a(418, 7, 1, true);
                                C7060h.pYm.mo8381e(13778, Integer.valueOf(2), Integer.valueOf(2), C5736j.m8649w(c5728b.dMD()) + "/" + r18);
                                obj = null;
                            }
                            i2++;
                            obj2 = obj;
                        }
                    }
                }
            } else {
                c21323a.oEp++;
                if (c21324b != null) {
                    c21324b.oEp++;
                }
                if (c21325c != null) {
                    c21325c.oEp++;
                }
                if (c5728b.exists()) {
                    long length2 = c5728b.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        c21323a.fileLenInvalidCount++;
                        if (c21324b != null) {
                            c21324b.fileLenInvalidCount++;
                        }
                        if (c21325c != null) {
                            c21325c.oEs++;
                        }
                    } else {
                        c21323a.jrb += length2;
                        if (c21324b != null) {
                            c21324b.jrb += length2;
                        }
                        if (c21325c != null) {
                            c21325c.jrb = length2 + c21325c.jrb;
                        }
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", C5736j.m8649w(c5728b.dMD()), Long.valueOf(c21323a.oEp));
                    AppMethodBeat.m2505o(84541);
                }
            }
            AppMethodBeat.m2505o(84541);
        }
        return c21323a;
    }

    /* renamed from: k */
    private synchronized void m85927k(int i, long j, long j2) {
        long j3;
        AppMethodBeat.m2504i(84542);
        boolean z = j > j2;
        if (z) {
            j3 = this.oEG | ((long) i);
        } else {
            j3 = this.oEG & ((long) (i ^ -1));
        }
        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(this.oEG), Long.valueOf(j3), Long.valueOf(Thread.currentThread().getId()));
        if (j3 != this.oEG) {
            if (this.oEG == 0) {
                C7060h.pYm.mo8378a(509, 1, 1, true);
            }
            if (j3 == 0) {
                C7060h.pYm.mo8378a(509, 2, 1, true);
            }
        }
        C5127a c5127a = null;
        C5127a c5127a2;
        switch (i) {
            case 1:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG;
                C7060h.pYm.mo8378a(509, z ? 3 : 4, 1, true);
                c5127a = c5127a2;
                break;
            case 2:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG;
                C7060h.pYm.mo8378a(509, z ? 5 : 6, 1, true);
                c5127a = c5127a2;
                break;
            case 4:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG;
                C7060h.pYm.mo8378a(509, z ? 7 : 8, 1, true);
                c5127a = c5127a2;
                break;
            case 8:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG;
                C7060h.pYm.mo8378a(509, z ? 9 : 10, 1, true);
                c5127a = c5127a2;
                break;
            case 16:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG;
                C7060h.pYm.mo8378a(509, z ? 11 : 12, 1, true);
                c5127a = c5127a2;
                break;
            case 32:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG;
                C7060h.pYm.mo8378a(509, z ? 13 : 14, 1, true);
                c5127a = c5127a2;
                break;
            case 64:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG;
                C7060h.pYm.mo8378a(509, z ? 15 : 16, 1, true);
                c5127a = c5127a2;
                break;
            case 128:
                c5127a2 = C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG;
                C7060h.pYm.mo8378a(509, z ? 19 : 20, 1, true);
                c5127a = c5127a2;
                break;
        }
        this.oEG = j3;
        C3744e.m6063ki(j3 != 0);
        final long j4 = j3;
        final long j5 = j;
        C7305d.xDH.mo10142ak(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(84522);
                if (C1720g.m3531RK()) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(j4));
                    if (c5127a != null) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(c5127a, Long.valueOf(j5));
                    }
                    C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", Long.valueOf(j4), Long.valueOf(C46086b.this.oEG), c5127a, Long.valueOf(j5));
                    AppMethodBeat.m2505o(84522);
                    return;
                }
                AppMethodBeat.m2505o(84522);
            }
        });
        AppMethodBeat.m2505o(84542);
    }

    /* renamed from: b */
    static /* synthetic */ void m85915b(C46086b c46086b) {
        AppMethodBeat.m2504i(84544);
        if (C1720g.m3531RK()) {
            C1720g.m3537RQ();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(currentTimeMillis));
                C7305d.post(new C126235(), "reportSDStatus");
            }
        }
        AppMethodBeat.m2505o(84544);
    }

    /* renamed from: c */
    static /* synthetic */ void m85918c(C46086b c46086b) {
        AppMethodBeat.m2504i(84545);
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > c46086b.oED * 60000 || longValue > currentTimeMillis) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            currentTimeMillis = (c46086b.oEv * 1024) * 1024;
            final long j = c46086b.oEw;
            final long j2 = (c46086b.oEA * 1024) * 1024;
            final long j3 = c46086b.oEx;
            final long j4 = c46086b.oEy;
            final long j5 = c46086b.oEz;
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(84518);
                    try {
                        log_14375 log_14375 = new log_14375();
                        log_14375.type_ = 1;
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                        C1720g.m3537RQ();
                        long length = new C5728b(C1720g.m3536RP().mo5238Rw()).length();
                        bDStatusInfo.mmDBSize_ = length;
                        StringBuilder stringBuilder = new StringBuilder();
                        C1720g.m3537RQ();
                        long length2 = new C5728b(stringBuilder.append(C1720g.m3536RP().cachePath).append("SnsMicroMsg.db").toString()).length();
                        bDStatusInfo.snsDBSize_ = length2;
                        stringBuilder = new StringBuilder();
                        C1720g.m3537RQ();
                        long length3 = new C5728b(stringBuilder.append(C1720g.m3536RP().cachePath).append("enFavorite.db").toString()).length();
                        bDStatusInfo.favDBSize_ = length3;
                        C46086b.m85912a(C46086b.this, 4, length, currentTimeMillis);
                        C46086b.m85912a(C46086b.this, 128, length3, j2);
                        String str = length + ";" + length2 + ";" + length3;
                        C1720g.m3537RQ();
                        C7480h c7480h = C1720g.m3536RP().eJO;
                        if (c7480h == null || !c7480h.isOpen()) {
                            C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList();
                            Cursor a = c7480h.mo10104a("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                            if (a != null) {
                                int columnIndex = a.getColumnIndex("name");
                                while (a.moveToNext()) {
                                    arrayList.add(a.getString(columnIndex));
                                }
                                a.close();
                            }
                            String str2 = str + ";" + arrayList.size();
                            bDStatusInfo.mmDBTableCount_ = arrayList.size();
                            LinkedList linkedList = new LinkedList();
                            bDStatusInfo.tableList_ = linkedList;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                Cursor a2 = c7480h.mo10104a("select count(*) from ".concat(String.valueOf(str)), null, 2);
                                length = 0;
                                if (a2 != null) {
                                    if (a2.moveToFirst()) {
                                        length = a2.getLong(0);
                                    }
                                    a2.close();
                                }
                                String str3 = str2 + ";" + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + length;
                                TableInfo tableInfo = new TableInfo();
                                tableInfo.name_ = str;
                                tableInfo.count_ = length;
                                linkedList.add(tableInfo);
                                if (ShareConstants.WEB_DIALOG_PARAM_MESSAGE.equals(str)) {
                                    C46086b.m85912a(C46086b.this, 8, length, j);
                                    str2 = str3;
                                } else if ("rconversation".equals(str)) {
                                    C46086b.m85912a(C46086b.this, 16, length, j3);
                                    str2 = str3;
                                } else if ("rcontact".equals(str)) {
                                    C46086b.m85912a(C46086b.this, 32, length, j4);
                                    str2 = str3;
                                } else {
                                    if ("chatroom".equals(str)) {
                                        C46086b.m85912a(C46086b.this, 64, length, j5);
                                    }
                                    str2 = str3;
                                }
                            }
                            C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            str = str2;
                        }
                        C7060h.pYm.mo8381e(13778, Integer.valueOf(1), Integer.valueOf(1), str);
                        C7060h.pYm.mo15417c(14375, log_14375);
                        C7060h.pYm.mo8378a(418, 3, 1, true);
                        C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", str);
                        AppMethodBeat.m2505o(84518);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportDBInfo err!", new Object[0]);
                        C7060h.pYm.mo8378a(418, 4, 1, true);
                        AppMethodBeat.m2505o(84518);
                    }
                }
            }, "reportDBInfo");
        }
        AppMethodBeat.m2505o(84545);
    }

    /* renamed from: d */
    static /* synthetic */ void m85919d(C46086b c46086b) {
        AppMethodBeat.m2504i(84546);
        if (C1720g.m3531RK()) {
            C1720g.m3537RQ();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                C7305d.post(new C394163(), "reportVersion");
            }
        }
        AppMethodBeat.m2505o(84546);
    }

    /* renamed from: e */
    static /* synthetic */ void m85920e(C46086b c46086b) {
        AppMethodBeat.m2504i(84547);
        if (C1720g.m3531RK()) {
            int i;
            C1720g.m3537RQ();
            C7580z Ry = C1720g.m3536RP().mo5239Ry();
            int intValue = ((Integer) Ry.get(C5127a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(0))).intValue();
            long longValue = ((Long) Ry.get(C5127a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(0))).longValue();
            int intValue2 = ((Integer) Ry.get(C5127a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(0))).intValue();
            int myPid = Process.myPid();
            MemoryInfo[] processMemoryInfo = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
            if (processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
                i = -1;
            } else {
                i = processMemoryInfo[0].getTotalPss();
            }
            if (intValue == 0) {
                Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
                Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
                C5127a c5127a = C5127a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT;
                if (i <= 0) {
                    i = 0;
                }
                Ry.set(c5127a, Integer.valueOf(i));
            } else if (intValue != myPid) {
                C7060h.pYm.mo8381e(13778, Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(longValue));
                C7060h.pYm.mo8381e(13778, Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(intValue2));
                Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
                long currentTimeMillis = System.currentTimeMillis() - startTime;
                if (i <= 0) {
                    i = 0;
                }
                Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(currentTimeMillis));
                Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i));
                C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(myPid));
            } else {
                Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
                if (i > intValue2) {
                    Ry.set(C5127a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i));
                }
            }
            Ry.dsb();
            c46086b.oEK.mo16770ae(180000, 180000);
        }
        AppMethodBeat.m2505o(84547);
    }

    /* renamed from: f */
    static /* synthetic */ void m85921f(C46086b c46086b) {
        AppMethodBeat.m2504i(84548);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3537RQ();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORT_ECDH_AUTH_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_REPORT_ECDH_AUTH_TIME_LONG, Long.valueOf(currentTimeMillis));
                C7305d.post(new C126247(), "reportECDHAuth");
            }
        }
        AppMethodBeat.m2505o(84548);
    }

    /* renamed from: h */
    static /* synthetic */ void m85923h(C46086b c46086b) {
        AppMethodBeat.m2504i(84549);
        if (c46086b.oEG != 0) {
            C1720g.m3537RQ();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                C7060h.pYm.mo8378a(509, 17, 1, true);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                C1720g.m3537RQ();
                longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
                log_14375 log_14375 = new log_14375();
                log_14375.type_ = 4;
                HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                log_14375.heavyDetailInfo_ = heavyDetailInfo;
                heavyDetailInfo.flag_ = longValue;
                String valueOf = String.valueOf(longValue);
                C1720g.m3537RQ();
                long longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileRatio_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.dbSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.message_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.conversation_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.contact_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.chatroom_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                C1720g.m3537RQ();
                longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.favDbSize_ = longValue2;
                String str = valueOf + ";" + longValue2;
                C4996ah.getContext().getSharedPreferences("heavyDetailInfo", 0).edit().putLong("sdFileSize", heavyDetailInfo.sdFileSize_).putLong("sdFileRatio", heavyDetailInfo.sdFileRatio_).putLong("dbSize", heavyDetailInfo.dbSize_).putLong(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, heavyDetailInfo.message_).putLong("conversation", heavyDetailInfo.conversation_).putLong("contact", heavyDetailInfo.contact_).putLong("chatroom", heavyDetailInfo.chatroom_).putLong("favDbSize", heavyDetailInfo.favDbSize_).putLong("flag", heavyDetailInfo.flag_).apply();
                try {
                    JSONObject put = new JSONObject().put("sdFileSize", heavyDetailInfo.sdFileSize_).put("sdFileRatio", heavyDetailInfo.sdFileRatio_).put("dbSize", heavyDetailInfo.dbSize_).put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, heavyDetailInfo.message_).put("conversation", heavyDetailInfo.conversation_).put("contact", heavyDetailInfo.contact_).put("chatroom", heavyDetailInfo.chatroom_).put("favDbSize", heavyDetailInfo.favDbSize_).put("flag", heavyDetailInfo.flag_);
                    String str2 = C1720g.m3536RP().cachePath + "heavyDetailInfo";
                    byte[] bytes = put.toString().getBytes();
                    C5730e.m8624b(str2, bytes, bytes.length);
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.SubCoreBaseMonitor", "Failed to write heavyDetailInfo");
                }
                C7060h.pYm.mo8381e(13778, Integer.valueOf(4), Integer.valueOf(1), str);
                C7060h.pYm.mo15417c(14375, log_14375);
                C4990ab.m7417i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", str);
            }
        }
        AppMethodBeat.m2505o(84549);
    }

    /* renamed from: r */
    static /* synthetic */ long m85935r(C46086b c46086b) {
        AppMethodBeat.m2504i(84554);
        C1720g.m3537RQ();
        if (C1720g.m3536RP().isSDCardAvailable()) {
            C5728b c5728b = new C5728b(C6457e.euX);
            if (c5728b.exists() && c5728b.isDirectory()) {
                C5728b[] dMF = c5728b.dMF();
                if (dMF == null || dMF.length == 0) {
                    C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
                    AppMethodBeat.m2505o(84554);
                    return 0;
                }
                Arrays.sort(dMF, new C126224());
                long j = 0;
                for (C5728b name : dMF) {
                    String name2 = name.getName();
                    if (!C5046bo.isNullOrNil(name2) && name2.endsWith(".xlog")) {
                        j = C5046bo.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                        if (j > 0) {
                            break;
                        }
                    }
                }
                AppMethodBeat.m2505o(84554);
                return j;
            }
            C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
            AppMethodBeat.m2505o(84554);
            return 0;
        }
        C4990ab.m7416i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
        AppMethodBeat.m2505o(84554);
        return 0;
    }
}
