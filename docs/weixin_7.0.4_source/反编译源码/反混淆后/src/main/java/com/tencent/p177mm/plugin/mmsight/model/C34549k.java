package com.tencent.p177mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.model.WMElement;

/* renamed from: com.tencent.mm.plugin.mmsight.model.k */
public final class C34549k {
    public static void bPx() {
        AppMethodBeat.m2504i(76531);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        C7060h.pYm.mo8378a(440, 0, 1, false);
        int i = 36;
        if (C12563j.ouz.etz == 1) {
            i = 39;
        }
        if (C12563j.ouz.fay == 720) {
            i++;
        } else if (C12563j.ouz.bPI()) {
            i += 2;
        }
        C7060h.pYm.mo8378a(440, (long) i, 1, false);
        AppMethodBeat.m2505o(76531);
    }

    /* renamed from: Vv */
    public static void m56642Vv() {
        AppMethodBeat.m2504i(76532);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
        C7060h.pYm.mo8378a(440, 2, 1, false);
        AppMethodBeat.m2505o(76532);
    }

    public static void bPy() {
        AppMethodBeat.m2504i(76533);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        C7060h.pYm.mo8378a(440, 7, 1, false);
        AppMethodBeat.m2505o(76533);
    }

    public static void bPz() {
        AppMethodBeat.m2504i(76534);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        C7060h.pYm.mo8378a(440, 8, 1, false);
        AppMethodBeat.m2505o(76534);
    }

    public static void bPA() {
        AppMethodBeat.m2504i(76535);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        C7060h.pYm.mo8378a(440, 16, 1, false);
        AppMethodBeat.m2505o(76535);
    }

    public static void bPB() {
        AppMethodBeat.m2504i(76536);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
        C7060h.pYm.mo8378a(440, 21, 1, false);
        AppMethodBeat.m2505o(76536);
    }

    public static void bPC() {
        AppMethodBeat.m2504i(76537);
        C4990ab.m7416i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        C7060h.pYm.mo8378a(440, 31, 1, false);
        AppMethodBeat.m2505o(76537);
    }

    /* renamed from: d */
    public static void m56643d(boolean z, long j) {
        int intExtra;
        AppMethodBeat.m2504i(76538);
        C4990ab.m7419v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", Boolean.valueOf(z), Long.valueOf(j));
        C12558a.bPi().otD = j;
        C12558a bPi = C12558a.bPi();
        C32831d c32831d = new C32831d();
        C32831d c32831d2 = new C32831d();
        c32831d.mo53399k("model", bPi.model + ",");
        c32831d.mo53399k("apiLevel", bPi.ote + ",");
        c32831d.mo53399k("memoryClass", bPi.fXT + ",");
        c32831d.mo53399k("totalMemory", bPi.otf + ",");
        c32831d.mo53399k("maxCpu", bPi.otg + ",");
        c32831d.mo53399k("screenW", bPi.oth + ",");
        c32831d.mo53399k("screenH", bPi.oti + ",");
        c32831d2.mo53399k("model", bPi.model + ",");
        c32831d2.mo53399k("apiLevel", bPi.ote + ",");
        c32831d2.mo53399k("memoryClass", bPi.fXT + ",");
        c32831d2.mo53399k("totalMemory", bPi.otf + ",");
        c32831d2.mo53399k("maxCpu", bPi.otg + ",");
        c32831d2.mo53399k("screenW", bPi.oth + ",");
        c32831d2.mo53399k("screenH", bPi.oti + ",");
        c32831d.mo53399k("cropx", bPi.otn + ",");
        c32831d.mo53399k("cropy", bPi.oto + ",");
        c32831d.mo53399k("previewx", bPi.otp + ",");
        c32831d.mo53399k("previewy", bPi.otq + ",");
        c32831d.mo53399k("encoderx", bPi.otr + ",");
        c32831d.mo53399k("encodery", bPi.ots + ",");
        c32831d.mo53399k(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, bPi.rotate + ",");
        c32831d.mo53399k("deviceoutfps", bPi.ott + ",");
        c32831d.mo53399k("recordfps", bPi.otu + ",");
        c32831d.mo53399k("recordertype", bPi.otv + ",");
        c32831d.mo53399k("videoBitrate", bPi.videoBitrate + ",");
        c32831d.mo53399k("needRotateEachFrame", bPi.etA + ",");
        c32831d.mo53399k("isNeedRealtimeScale", bPi.otw + ",");
        c32831d.mo53399k("resolutionLimit", bPi.fay + ",");
        c32831d.mo53399k("outfps", bPi.otx + ",");
        c32831d.mo53399k("recordTime", bPi.oty + ",");
        c32831d.mo53399k("avgcpu", bPi.otz + ",");
        c32831d.mo53399k("outx", bPi.otA + ",");
        c32831d.mo53399k("outy", bPi.otB + ",");
        c32831d.mo53399k("outbitrate", bPi.otC + ",");
        c32831d.mo53399k("fileSize", bPi.fileSize + ",");
        c32831d.mo53399k("wait2playtime", bPi.otD + ",");
        c32831d.mo53399k("useback", bPi.otE + ",");
        int i = 0;
        int i2 = 0;
        Intent registerReceiver = C4996ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            intExtra = registerReceiver.getIntExtra("status", -1);
            intExtra = (intExtra == 2 || intExtra == 5) ? 1 : 0;
            i = registerReceiver.getIntExtra("level", -1);
            i2 = registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1);
        } else {
            intExtra = 0;
        }
        C4990ab.m7417i("MicroMsg.CaptureStatistics", "battery %s %s %s", Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2));
        c32831d.mo53399k("mIsCharging", intExtra + ",");
        c32831d.mo53399k("level", i + ",");
        c32831d.mo53399k(WMElement.ANIMATE_TYPE_SCALE, i2 + ",");
        c32831d.mo53399k("createTime", System.currentTimeMillis() + ",");
        c32831d2.mo53399k("prewViewlist1", bPi.otj + ",");
        c32831d2.mo53399k("pictureSize1", bPi.otk + ",");
        c32831d2.mo53399k("prewViewlist2", bPi.otl + ",");
        c32831d2.mo53399k("pictureSize2", bPi.otm + ",");
        C4990ab.m7416i("MicroMsg.CaptureStatistics", "report " + c32831d.mo53398Fk());
        C4990ab.m7418v("MicroMsg.CaptureStatistics", "report " + c32831d2.mo53398Fk());
        C7060h.pYm.mo8374X(13947, c32831d.toString());
        C7060h.pYm.mo8374X(13949, c32831d2.toString());
        if (z) {
            C7060h.pYm.mo8378a(440, 119, 1, false);
            C7060h.pYm.mo8378a(440, 120, j, false);
            if (C12563j.ouz.fay == 720) {
                C7060h.pYm.mo8378a(440, 122, j, false);
                AppMethodBeat.m2505o(76538);
                return;
            } else if (C12563j.ouz.bPI()) {
                C7060h.pYm.mo8378a(440, 123, j, false);
                AppMethodBeat.m2505o(76538);
                return;
            } else {
                C7060h.pYm.mo8378a(440, 121, j, false);
                AppMethodBeat.m2505o(76538);
                return;
            }
        }
        C7060h.pYm.mo8378a(440, 124, 1, false);
        C7060h.pYm.mo8378a(440, 125, j, false);
        if (C12563j.ouz.etz == 1) {
            C7060h.pYm.mo8378a(440, 127, j, false);
            C7060h.pYm.mo8378a(440, 131, j, false);
            AppMethodBeat.m2505o(76538);
            return;
        }
        C7060h.pYm.mo8378a(440, 126, j, false);
        C7060h.pYm.mo8378a(440, 130, j, false);
        AppMethodBeat.m2505o(76538);
    }

    public static void bPD() {
        AppMethodBeat.m2504i(76539);
        C7060h.pYm.mo8378a(440, 140, 0, false);
        AppMethodBeat.m2505o(76539);
    }
}
