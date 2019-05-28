package com.tencent.mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.model.WMElement;

public final class k {
    public static void bPx() {
        AppMethodBeat.i(76531);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        h.pYm.a(440, 0, 1, false);
        int i = 36;
        if (j.ouz.etz == 1) {
            i = 39;
        }
        if (j.ouz.fay == 720) {
            i++;
        } else if (j.ouz.bPI()) {
            i += 2;
        }
        h.pYm.a(440, (long) i, 1, false);
        AppMethodBeat.o(76531);
    }

    public static void Vv() {
        AppMethodBeat.i(76532);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
        h.pYm.a(440, 2, 1, false);
        AppMethodBeat.o(76532);
    }

    public static void bPy() {
        AppMethodBeat.i(76533);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        h.pYm.a(440, 7, 1, false);
        AppMethodBeat.o(76533);
    }

    public static void bPz() {
        AppMethodBeat.i(76534);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        h.pYm.a(440, 8, 1, false);
        AppMethodBeat.o(76534);
    }

    public static void bPA() {
        AppMethodBeat.i(76535);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        h.pYm.a(440, 16, 1, false);
        AppMethodBeat.o(76535);
    }

    public static void bPB() {
        AppMethodBeat.i(76536);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
        h.pYm.a(440, 21, 1, false);
        AppMethodBeat.o(76536);
    }

    public static void bPC() {
        AppMethodBeat.i(76537);
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        h.pYm.a(440, 31, 1, false);
        AppMethodBeat.o(76537);
    }

    public static void d(boolean z, long j) {
        int intExtra;
        AppMethodBeat.i(76538);
        ab.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", Boolean.valueOf(z), Long.valueOf(j));
        a.bPi().otD = j;
        a bPi = a.bPi();
        d dVar = new d();
        d dVar2 = new d();
        dVar.k("model", bPi.model + ",");
        dVar.k("apiLevel", bPi.ote + ",");
        dVar.k("memoryClass", bPi.fXT + ",");
        dVar.k("totalMemory", bPi.otf + ",");
        dVar.k("maxCpu", bPi.otg + ",");
        dVar.k("screenW", bPi.oth + ",");
        dVar.k("screenH", bPi.oti + ",");
        dVar2.k("model", bPi.model + ",");
        dVar2.k("apiLevel", bPi.ote + ",");
        dVar2.k("memoryClass", bPi.fXT + ",");
        dVar2.k("totalMemory", bPi.otf + ",");
        dVar2.k("maxCpu", bPi.otg + ",");
        dVar2.k("screenW", bPi.oth + ",");
        dVar2.k("screenH", bPi.oti + ",");
        dVar.k("cropx", bPi.otn + ",");
        dVar.k("cropy", bPi.oto + ",");
        dVar.k("previewx", bPi.otp + ",");
        dVar.k("previewy", bPi.otq + ",");
        dVar.k("encoderx", bPi.otr + ",");
        dVar.k("encodery", bPi.ots + ",");
        dVar.k(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, bPi.rotate + ",");
        dVar.k("deviceoutfps", bPi.ott + ",");
        dVar.k("recordfps", bPi.otu + ",");
        dVar.k("recordertype", bPi.otv + ",");
        dVar.k("videoBitrate", bPi.videoBitrate + ",");
        dVar.k("needRotateEachFrame", bPi.etA + ",");
        dVar.k("isNeedRealtimeScale", bPi.otw + ",");
        dVar.k("resolutionLimit", bPi.fay + ",");
        dVar.k("outfps", bPi.otx + ",");
        dVar.k("recordTime", bPi.oty + ",");
        dVar.k("avgcpu", bPi.otz + ",");
        dVar.k("outx", bPi.otA + ",");
        dVar.k("outy", bPi.otB + ",");
        dVar.k("outbitrate", bPi.otC + ",");
        dVar.k("fileSize", bPi.fileSize + ",");
        dVar.k("wait2playtime", bPi.otD + ",");
        dVar.k("useback", bPi.otE + ",");
        int i = 0;
        int i2 = 0;
        Intent registerReceiver = ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            intExtra = registerReceiver.getIntExtra("status", -1);
            intExtra = (intExtra == 2 || intExtra == 5) ? 1 : 0;
            i = registerReceiver.getIntExtra("level", -1);
            i2 = registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1);
        } else {
            intExtra = 0;
        }
        ab.i("MicroMsg.CaptureStatistics", "battery %s %s %s", Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2));
        dVar.k("mIsCharging", intExtra + ",");
        dVar.k("level", i + ",");
        dVar.k(WMElement.ANIMATE_TYPE_SCALE, i2 + ",");
        dVar.k("createTime", System.currentTimeMillis() + ",");
        dVar2.k("prewViewlist1", bPi.otj + ",");
        dVar2.k("pictureSize1", bPi.otk + ",");
        dVar2.k("prewViewlist2", bPi.otl + ",");
        dVar2.k("pictureSize2", bPi.otm + ",");
        ab.i("MicroMsg.CaptureStatistics", "report " + dVar.Fk());
        ab.v("MicroMsg.CaptureStatistics", "report " + dVar2.Fk());
        h.pYm.X(13947, dVar.toString());
        h.pYm.X(13949, dVar2.toString());
        if (z) {
            h.pYm.a(440, 119, 1, false);
            h.pYm.a(440, 120, j, false);
            if (j.ouz.fay == 720) {
                h.pYm.a(440, 122, j, false);
                AppMethodBeat.o(76538);
                return;
            } else if (j.ouz.bPI()) {
                h.pYm.a(440, 123, j, false);
                AppMethodBeat.o(76538);
                return;
            } else {
                h.pYm.a(440, 121, j, false);
                AppMethodBeat.o(76538);
                return;
            }
        }
        h.pYm.a(440, 124, 1, false);
        h.pYm.a(440, 125, j, false);
        if (j.ouz.etz == 1) {
            h.pYm.a(440, 127, j, false);
            h.pYm.a(440, 131, j, false);
            AppMethodBeat.o(76538);
            return;
        }
        h.pYm.a(440, 126, j, false);
        h.pYm.a(440, 130, j, false);
        AppMethodBeat.o(76538);
    }

    public static void bPD() {
        AppMethodBeat.i(76539);
        h.pYm.a(440, 140, 0, false);
        AppMethodBeat.o(76539);
    }
}
