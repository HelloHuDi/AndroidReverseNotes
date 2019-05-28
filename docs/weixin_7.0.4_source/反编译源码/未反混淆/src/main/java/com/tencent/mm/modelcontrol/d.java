package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements at {
    private static final int fzG = c.aT("dscp");
    private a fzH = new a();
    private byte[] fzI = null;
    private b fzJ;
    private e[] fzK;
    private e[] fzL;
    private e[] fzM;
    private e[] fzN;
    private e[] fzO;
    private e[] fzP;
    private e[] fzQ;

    static {
        AppMethodBeat.i(50616);
        AppMethodBeat.o(50616);
    }

    public d() {
        AppMethodBeat.i(50592);
        AppMethodBeat.o(50592);
    }

    public static d afF() {
        AppMethodBeat.i(50593);
        d dVar = (d) q.Y(d.class);
        AppMethodBeat.o(50593);
        return dVar;
    }

    private static e[] rS(String str) {
        int i = 0;
        AppMethodBeat.i(50594);
        String value = ((a) g.K(a.class)).Nu().getValue(str);
        if (bo.isNullOrNil(value)) {
            ab.i("MicroMsg.SubCoreVideoControl", "key %s config is null", str);
            AppMethodBeat.o(50594);
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[".concat(String.valueOf(value));
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        ab.i("MicroMsg.SubCoreVideoControl", "%s=%s ", str, value);
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            ab.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", Integer.valueOf(length));
            e[] eVarArr = new e[length];
            while (i < length) {
                eVarArr[i] = e(jSONArray.getJSONObject(i));
                i++;
            }
            AppMethodBeat.o(50594);
            return eVarArr;
        } catch (Exception e) {
            ab.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            AppMethodBeat.o(50594);
            return null;
        }
    }

    private static e e(JSONObject jSONObject) {
        AppMethodBeat.i(50595);
        e eVar = new e();
        try {
            String str;
            String string = jSONObject.isNull("time") ? "" : jSONObject.getString("time");
            String string2 = jSONObject.getString("abr");
            String string3 = jSONObject.getString("intval");
            String string4 = jSONObject.getString("prof");
            String string5 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                str = jSONObject.getString("stepbr");
            }
            ab.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", string, string2, string3, string4, string5, str);
            eVar.a(string, string2, string3, string4, string5, str);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            ArrayList arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !eVar.fzW) {
                int i2 = ((f) arrayList.get(0)).fAe;
                for (int i3 = 1; i3 < arrayList.size(); i3++) {
                    f fVar = (f) arrayList.get(i3);
                    fVar.fAd = i2;
                    i2 = fVar.fAe;
                }
            }
            eVar.fzX = new f[arrayList.size()];
            arrayList.toArray(eVar.fzX);
            ab.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", eVar);
            AppMethodBeat.o(50595);
            return eVar;
        } catch (Exception e) {
            ab.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            AppMethodBeat.o(50595);
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        AppMethodBeat.i(50596);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4)) {
            AppMethodBeat.o(50596);
            return false;
        }
        try {
            String[] split;
            if (bo.isNullOrNil(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = bo.getInt(split[0], -1);
                pInt2.value = bo.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    AppMethodBeat.o(50596);
                    return false;
                }
            }
            split = str2.split(VideoMaterialUtil.CRAZYFACE_X);
            pInt3.value = bo.getInt(split[0], -1);
            pInt4.value = bo.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                AppMethodBeat.o(50596);
                return false;
            }
            pInt5.value = bo.getInt(str3, -1);
            pInt6.value = bo.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                AppMethodBeat.o(50596);
                return false;
            }
            pInt6.value *= 1000;
            ab.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value));
            AppMethodBeat.o(50596);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    public static int a(VideoTransPara videoTransPara) {
        if (videoTransPara == null) {
            return 0;
        }
        switch (videoTransPara.duration) {
            case 10:
                return 1;
            default:
                return videoTransPara.duration;
        }
    }

    public final byte[] getWeixinMeta() {
        AppMethodBeat.i(50597);
        if (bo.cb(this.fzI)) {
            try {
                this.fzI = ("{\"WXVer\":" + com.tencent.mm.protocal.d.vxo + "}").getBytes("UTF-8");
                ab.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", r0);
            } catch (Exception e) {
                ab.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", e.toString());
            }
        }
        byte[] bArr = this.fzI;
        AppMethodBeat.o(50597);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3 A:{SYNTHETIC, Splitter:B:30:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed A:{SYNTHETIC, Splitter:B:36:0x00ed} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean rT(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(50598);
        if (this.fzJ == null) {
            this.fzJ = new b();
        }
        b bVar = this.fzJ;
        bVar.gjO = -1;
        bVar.gjQ = -1;
        bVar.gjR = null;
        long yz = bo.yz();
        long vB = this.fzJ.vB(str);
        if (vB <= 0) {
            AppMethodBeat.o(50598);
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(vB);
                byte[] bArr = new byte[8];
                com.tencent.mm.plugin.a.a aVar = null;
                for (com.tencent.mm.plugin.a.a a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.aXh); a != null; a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.aXh)) {
                    aVar = c.a(randomAccessFile, bArr, fzG);
                    if (aVar != null) {
                        break;
                    }
                    randomAccessFile.seek(a.getEndPos());
                }
                if (aVar != null) {
                    byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                    randomAccessFile.seek(aVar.gjN + 8);
                    if (randomAccessFile.read(bArr2) > 0) {
                        str2 = new String(bArr2, "UTF-8");
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    ab.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(vB), Long.valueOf(bo.az(yz)), str);
                    if (bo.isNullOrNil(str2)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.o(50598);
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            ab.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
            if (randomAccessFile != null) {
            }
            ab.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(vB), Long.valueOf(bo.az(yz)), str);
            if (bo.isNullOrNil(str2)) {
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(50598);
            throw th;
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(vB), Long.valueOf(bo.az(yz)), str);
        if (bo.isNullOrNil(str2)) {
            boolean contains = str2.contains("WXVer");
            AppMethodBeat.o(50598);
            return contains;
        }
        AppMethodBeat.o(50598);
        return false;
    }

    public final VideoTransPara afG() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara videoTransPara;
        AppMethodBeat.i(50599);
        long yz = bo.yz();
        if (this.fzK == null) {
            this.fzK = rS("C2CRecordVideoConfig");
        }
        if (this.fzK != null) {
            for (e eVar : this.fzK) {
                if (eVar != null && eVar.afQ()) {
                    ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    afR = eVar.afR();
                    z = eVar.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afR = new VideoTransPara();
            afR.isDefault = true;
            afR.width = 540;
            afR.height = VideoFilterUtil.IMAGE_HEIGHT;
            afR.fps = 30;
            afR.videoBitrate = 1200000;
            afR.fzT = 10;
            afR.fzS = 64000;
            afR.fzU = 2;
            afR.fzV = 1;
            videoTransPara = afR;
        } else {
            videoTransPara = afR;
        }
        videoTransPara.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        videoTransPara.fzT = 10;
        videoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.mmc2c_record_sight_max_timelength, 10);
        if (z) {
            h.pYm.a(422, 12, 1, false);
        } else {
            h.pYm.a(422, 11, 1, false);
        }
        h.pYm.a(422, (long) bo.h((Integer) h.a(videoTransPara.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 13, 18)), 1, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", Long.valueOf(bo.az(yz)), videoTransPara, Integer.valueOf(r0));
        AppMethodBeat.o(50599);
        return videoTransPara;
    }

    public final VideoTransPara afH() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara afL;
        AppMethodBeat.i(50600);
        long yz = bo.yz();
        if (this.fzL == null) {
            this.fzL = rS("SnsRecordVideoConfig");
        }
        if (this.fzL != null) {
            for (e eVar : this.fzL) {
                if (eVar != null && eVar.afQ()) {
                    ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    afR = eVar.afR();
                    z = eVar.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afL = afL();
        } else {
            afL = afR;
        }
        afL.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        afL.fzT = 10;
        afL.fAf = 200;
        afL.duration = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.mmsns_record_sight_max_timelength, 10);
        if (z) {
            h.pYm.a(422, 32, 1, false);
        } else {
            h.pYm.a(422, 31, 1, false);
        }
        h.pYm.a(422, (long) bo.h((Integer) h.a(afL.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", Long.valueOf(bo.az(yz)), afL, Integer.valueOf(r0));
        AppMethodBeat.o(50600);
        return afL;
    }

    public final VideoTransPara afI() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara afL;
        AppMethodBeat.i(50601);
        long yz = bo.yz();
        if (this.fzM == null) {
            this.fzM = rS("SnsAlbumVideoConfig");
        }
        if (this.fzM != null) {
            for (e eVar : this.fzM) {
                if (eVar != null && eVar.afQ()) {
                    ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    afR = eVar.afR();
                    z = eVar.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afL = afL();
        } else {
            afL = afR;
        }
        afL.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        afL.fzT = 10;
        afL.fAf = 200;
        afL.duration = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.mmsns_album_sight_max_timelength, 10);
        if (z) {
            h.pYm.a(422, 22, 1, false);
        } else {
            h.pYm.a(422, 21, 1, false);
        }
        h.pYm.a(422, (long) bo.h((Integer) h.a(afL.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 23, 28)), 1, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", Long.valueOf(bo.az(yz)), afL, Integer.valueOf(r0));
        AppMethodBeat.o(50601);
        return afL;
    }

    public final VideoTransPara afJ() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara videoTransPara;
        AppMethodBeat.i(50602);
        long yz = bo.yz();
        if (this.fzN == null) {
            this.fzN = rS("StoryRecordVideoConfig");
        }
        if (this.fzN != null) {
            for (e eVar : this.fzN) {
                if (eVar != null && eVar.afQ()) {
                    ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
                    afR = eVar.afR();
                    z = eVar.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afR = new VideoTransPara();
            afR.isDefault = true;
            afR.width = 720;
            afR.height = ActUtil.HEIGHT;
            afR.fps = 30;
            afR.videoBitrate = 3500000;
            afR.fzT = 10;
            afR.fzS = TXRecordCommon.AUDIO_SAMPLERATE_48000;
            afR.fzU = 2;
            afR.fzV = 1;
            videoTransPara = afR;
        } else {
            videoTransPara = afR;
        }
        videoTransPara.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        videoTransPara.fzT = 10;
        videoTransPara.fAf = 200;
        if (videoTransPara.duration <= 0) {
            videoTransPara.duration = 15;
        }
        if (z) {
            h.pYm.a(422, 32, 1, false);
        } else {
            h.pYm.a(422, 31, 1, false);
        }
        h.pYm.a(422, (long) bo.h((Integer) h.a(videoTransPara.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", Long.valueOf(bo.az(yz)), videoTransPara, Integer.valueOf(r0));
        AppMethodBeat.o(50602);
        return videoTransPara;
    }

    public final VideoTransPara b(VideoTransPara videoTransPara) {
        AppMethodBeat.i(50603);
        if (videoTransPara == null) {
            ab.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
            AppMethodBeat.o(50603);
            return null;
        } else if (videoTransPara.duration >= 300) {
            ab.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", Integer.valueOf(300));
            AppMethodBeat.o(50603);
            return null;
        } else {
            Object obj;
            e[] eVarArr;
            boolean z;
            int i;
            long yz = bo.yz();
            VideoTransPara lj = lj(videoTransPara.duration);
            int i2 = 1;
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100157");
            if (ll.isValid()) {
                i2 = bo.getInt((String) ll.dru().get("VideoEncodeStep"), 1);
            }
            ab.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", Integer.valueOf(i2));
            if (i2 > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (this.fzP == null) {
                    this.fzP = rS("C2CAlbumVideoStepConfig");
                }
                eVarArr = this.fzP;
            } else {
                if (this.fzO == null) {
                    this.fzO = rS("C2CAlbumVideoConfig");
                }
                eVarArr = this.fzO;
            }
            if (eVarArr != null) {
                for (e eVar : eVarArr) {
                    if (eVar != null && eVar.afQ()) {
                        ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                        int a = a.a(eVar.fzX, videoTransPara, lj);
                        z = eVar.fzW;
                        i = a;
                        break;
                    }
                }
                z = true;
                i = 0;
            } else {
                ab.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
                z = true;
                i = a.a(null, videoTransPara, lj);
            }
            if (i <= 0) {
                lj = lj(videoTransPara.duration);
            } else {
                lj.isDefault = false;
            }
            if (z) {
                h.pYm.a(422, 2, 1, false);
            } else {
                h.pYm.a(422, 1, 1, false);
            }
            h.pYm.a(422, (long) bo.h((Integer) h.a(lj.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 3, 8)), 1, false);
            ab.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", Long.valueOf(bo.az(yz)), Integer.valueOf(i2), Integer.valueOf(i), lj, videoTransPara);
            AppMethodBeat.o(50603);
            return lj;
        }
    }

    public final VideoTransPara afK() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara afL;
        AppMethodBeat.i(50604);
        long yz = bo.yz();
        if (this.fzQ == null) {
            this.fzQ = rS("NearbyRecordVideoConfig");
        }
        if (this.fzQ != null) {
            for (e eVar : this.fzQ) {
                if (eVar != null && eVar.afQ()) {
                    ab.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
                    afR = eVar.afR();
                    z = eVar.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afL = afL();
        } else {
            afL = afR;
        }
        afL.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        afL.fzT = 10;
        afL.fAf = 200;
        if (afL.duration <= 0) {
            afL.duration = 10;
        }
        if (z) {
            h.pYm.a(422, 32, 1, false);
        } else {
            h.pYm.a(422, 31, 1, false);
        }
        h.pYm.a(422, (long) bo.h((Integer) h.a(afL.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", Long.valueOf(bo.az(yz)), afL, Integer.valueOf(r0));
        AppMethodBeat.o(50604);
        return afL;
    }

    private static VideoTransPara afL() {
        AppMethodBeat.i(50605);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 540;
        videoTransPara.height = VideoFilterUtil.IMAGE_HEIGHT;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 1600000;
        videoTransPara.fzT = 10;
        videoTransPara.fzS = 64000;
        videoTransPara.fzU = 2;
        videoTransPara.fzV = 1;
        AppMethodBeat.o(50605);
        return videoTransPara;
    }

    private static VideoTransPara lj(int i) {
        AppMethodBeat.i(50606);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.fzT = 1;
        videoTransPara.fzS = TXRecordCommon.AUDIO_SAMPLERATE_48000;
        videoTransPara.fzU = 2;
        videoTransPara.fzV = 1;
        if (i <= 120) {
            videoTransPara.fps = 30;
            videoTransPara.width = 540;
            videoTransPara.height = VideoFilterUtil.IMAGE_HEIGHT;
            videoTransPara.videoBitrate = 1200000;
        } else {
            videoTransPara.fps = 24;
            videoTransPara.width = v2helper.VOIP_ENC_HEIGHT_LV1;
            videoTransPara.height = 640;
            videoTransPara.videoBitrate = 544000;
        }
        AppMethodBeat.o(50606);
        return videoTransPara;
    }

    public static boolean afM() {
        int i;
        AppMethodBeat.i(50607);
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100136");
        if (ll.isValid()) {
            i = bo.getInt((String) ll.dru().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !afO()) ? false : intValue > 0 ? true : i > 0;
        ab.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        AppMethodBeat.o(50607);
        return z;
    }

    public static boolean afN() {
        int i;
        AppMethodBeat.i(50608);
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100153");
        if (ll.isValid()) {
            i = bo.getInt((String) ll.dru().get("snsStreamDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !afO()) ? false : intValue > 0 ? true : i > 0;
        ab.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        AppMethodBeat.o(50608);
        return z;
    }

    public static boolean afO() {
        int i;
        String str;
        String str2;
        int i2;
        boolean z;
        AppMethodBeat.i(50609);
        long yz = bo.yz();
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100190");
        if (ll.isValid()) {
            Map dru = ll.dru();
            i = bo.getInt((String) dru.get("player"), 1);
            str = (String) dru.get("apilevel");
            str2 = (String) dru.get("devices");
            i2 = i;
        } else {
            str2 = null;
            str = null;
            i2 = 1;
        }
        int i3 = VERSION.SDK_INT;
        String str3 = Build.BRAND + Build.MODEL;
        if (!bo.isNullOrNil(str)) {
            for (String str4 : str.split(";")) {
                if (bo.getInt(str4, 0) == i3) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!bo.isNullOrNil(str2)) {
            for (String equalsIgnoreCase : str2.split(";")) {
                if (equalsIgnoreCase.equalsIgnoreCase(str3)) {
                    z = false;
                    break;
                }
            }
        }
        if (com.tencent.mm.compatible.util.d.fP(18)) {
            z = false;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            g.RP().Ry().set(ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
        }
        if (intValue == 0) {
            z = false;
        }
        if (i2 <= 0) {
            z = false;
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", Boolean.valueOf(z), Integer.valueOf(i3), str, str3, str2, Integer.valueOf(i2), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(50609);
        return z;
    }

    public static int a(int i, s sVar) {
        int i2;
        AppMethodBeat.i(50610);
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
                i2 = a(sVar);
                break;
            case 2:
                i2 = a(sVar);
                break;
            default:
                i2 = 1;
                break;
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", Integer.valueOf(i2));
        if (i2 == 2) {
            h.pYm.a(354, 130, 1, false);
        } else {
            h.pYm.a(354, 131, 1, false);
        }
        AppMethodBeat.o(50610);
        return i2;
    }

    private static int a(s sVar) {
        int i = 1;
        AppMethodBeat.i(50611);
        if (lk(1)) {
            o.all();
            String uh = t.uh(sVar.getFileName());
            if (e.ct(uh)) {
                if (r.uc(uh)) {
                    i = 2;
                }
                AppMethodBeat.o(50611);
                return i;
            }
            AppMethodBeat.o(50611);
            return 2;
        }
        AppMethodBeat.o(50611);
        return 1;
    }

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (com.tencent.mm.modelvideo.r.uc(r8) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int u(int i, String str) {
        int i2 = 2;
        AppMethodBeat.i(50612);
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                if (lk(2)) {
                    if (e.ct(str)) {
                        break;
                    }
                }
                break;
            default:
                i2 = 1;
                break;
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", Integer.valueOf(i2));
        AppMethodBeat.o(50612);
        return i2;
    }

    /* JADX WARNING: Missing block: B:11:0x0035, code skipped:
            if (com.tencent.mm.modelvideo.r.uc(r8) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int v(int i, String str) {
        int i2 = 2;
        AppMethodBeat.i(50613);
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                if (lk(3)) {
                    if (e.ct(str)) {
                        break;
                    }
                }
                break;
            default:
                i2 = 1;
                break;
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check story video format[%d]", Integer.valueOf(i2));
        AppMethodBeat.o(50613);
        return i2;
    }

    public static boolean afP() {
        AppMethodBeat.i(50614);
        String str = null;
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100253");
        if (ll.isValid()) {
            str = (String) ll.dru().get("noCompleteRange");
        }
        if (bo.isNullOrNil(str)) {
            str = "20:00-23:30";
        }
        g.RN();
        ab.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", Boolean.valueOf(b.W(str, i.bL(com.tencent.mm.kernel.a.QF(), 30))), str, Integer.valueOf(r3));
        if (b.W(str, i.bL(com.tencent.mm.kernel.a.QF(), 30))) {
            AppMethodBeat.o(50614);
            return false;
        }
        AppMethodBeat.o(50614);
        return true;
    }

    private static boolean lk(int i) {
        AppMethodBeat.i(50615);
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_SUPPORT_HEVC_VIDEO_INT, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = com.tencent.mm.plugin.n.e.bOS() ? 1 : 0;
            g.RP().Ry().set(ac.a.USERINFO_SUPPORT_HEVC_VIDEO_INT, Integer.valueOf(intValue));
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", Integer.valueOf(intValue));
        if (intValue <= 0) {
            AppMethodBeat.o(50615);
            return false;
        }
        boolean z;
        int i2 = ((a) g.K(a.class)).Nu().getInt("VideoDownloadH265Flag", 0);
        switch (i) {
            case 1:
                if ((i2 & 2) == 0) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 2:
                if ((i2 & 4) == 0) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 3:
                if ((i2 & 1) == 0) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        int i3 = com.tencent.mm.compatible.e.q.etn.esI;
        if (i3 != -1) {
            if (i3 == 1) {
                z = true;
            } else {
                z = false;
            }
        }
        ab.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevc, scene:%s, flag:%s, configResult:%s, dynamicConfigResult:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        AppMethodBeat.o(50615);
        return z;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        this.fzK = null;
        this.fzP = null;
        this.fzO = null;
        this.fzL = null;
        this.fzM = null;
    }
}
