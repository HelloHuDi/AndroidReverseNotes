package com.tencent.p177mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.p468n.C12691e;
import com.tencent.p177mm.plugin.p878a.C37990a;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.p878a.C45479b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.modelcontrol.d */
public class C42204d implements C1816at {
    private static final int fzG = C42258c.m74641aT("dscp");
    private C18654a fzH = new C18654a();
    private byte[] fzI = null;
    private C45479b fzJ;
    private C37939e[] fzK;
    private C37939e[] fzL;
    private C37939e[] fzM;
    private C37939e[] fzN;
    private C37939e[] fzO;
    private C37939e[] fzP;
    private C37939e[] fzQ;

    static {
        AppMethodBeat.m2504i(50616);
        AppMethodBeat.m2505o(50616);
    }

    public C42204d() {
        AppMethodBeat.m2504i(50592);
        AppMethodBeat.m2505o(50592);
    }

    public static C42204d afF() {
        AppMethodBeat.m2504i(50593);
        C42204d c42204d = (C42204d) C7485q.m12925Y(C42204d.class);
        AppMethodBeat.m2505o(50593);
        return c42204d;
    }

    /* renamed from: rS */
    private static C37939e[] m74454rS(String str) {
        int i = 0;
        AppMethodBeat.m2504i(50594);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue(str);
        if (C5046bo.isNullOrNil(value)) {
            C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "key %s config is null", str);
            AppMethodBeat.m2505o(50594);
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[".concat(String.valueOf(value));
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "%s=%s ", str, value);
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            C4990ab.m7411d("MicroMsg.SubCoreVideoControl", "parse config root length %d", Integer.valueOf(length));
            C37939e[] c37939eArr = new C37939e[length];
            while (i < length) {
                c37939eArr[i] = C42204d.m74451e(jSONArray.getJSONObject(i));
                i++;
            }
            AppMethodBeat.m2505o(50594);
            return c37939eArr;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            AppMethodBeat.m2505o(50594);
            return null;
        }
    }

    /* renamed from: e */
    private static C37939e m74451e(JSONObject jSONObject) {
        AppMethodBeat.m2504i(50595);
        C37939e c37939e = new C37939e();
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
            C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", string, string2, string3, string4, string5, str);
            c37939e.mo60703a(string, string2, string3, string4, string5, str);
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
                if (C42204d.m74450a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new C26440f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !c37939e.fzW) {
                int i2 = ((C26440f) arrayList.get(0)).fAe;
                for (int i3 = 1; i3 < arrayList.size(); i3++) {
                    C26440f c26440f = (C26440f) arrayList.get(i3);
                    c26440f.fAd = i2;
                    i2 = c26440f.fAe;
                }
            }
            c37939e.fzX = new C26440f[arrayList.size()];
            arrayList.toArray(c37939e.fzX);
            C4990ab.m7411d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", c37939e);
            AppMethodBeat.m2505o(50595);
            return c37939e;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            AppMethodBeat.m2505o(50595);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m74450a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        AppMethodBeat.m2504i(50596);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4)) {
            AppMethodBeat.m2505o(50596);
            return false;
        }
        try {
            String[] split;
            if (C5046bo.isNullOrNil(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = C5046bo.getInt(split[0], -1);
                pInt2.value = C5046bo.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    AppMethodBeat.m2505o(50596);
                    return false;
                }
            }
            split = str2.split(VideoMaterialUtil.CRAZYFACE_X);
            pInt3.value = C5046bo.getInt(split[0], -1);
            pInt4.value = C5046bo.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                AppMethodBeat.m2505o(50596);
                return false;
            }
            pInt5.value = C5046bo.getInt(str3, -1);
            pInt6.value = C5046bo.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                AppMethodBeat.m2505o(50596);
                return false;
            }
            pInt6.value *= 1000;
            C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value));
            AppMethodBeat.m2505o(50596);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    /* renamed from: a */
    public static int m74448a(VideoTransPara videoTransPara) {
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
        AppMethodBeat.m2504i(50597);
        if (C5046bo.m7540cb(this.fzI)) {
            try {
                this.fzI = ("{\"WXVer\":" + C7243d.vxo + "}").getBytes("UTF-8");
                C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", r0);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", e.toString());
            }
        }
        byte[] bArr = this.fzI;
        AppMethodBeat.m2505o(50597);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3 A:{SYNTHETIC, Splitter:B:30:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed A:{SYNTHETIC, Splitter:B:36:0x00ed} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: rT */
    public final boolean mo67743rT(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(50598);
        if (this.fzJ == null) {
            this.fzJ = new C45479b();
        }
        C45479b c45479b = this.fzJ;
        c45479b.gjO = -1;
        c45479b.gjQ = -1;
        c45479b.gjR = null;
        long yz = C5046bo.m7588yz();
        long vB = this.fzJ.mo73275vB(str);
        if (vB <= 0) {
            AppMethodBeat.m2505o(50598);
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(vB);
                byte[] bArr = new byte[8];
                C37990a c37990a = null;
                for (C37990a a = C42258c.m74639a(randomAccessFile, bArr, C37990a.aXh); a != null; a = C42258c.m74639a(randomAccessFile, bArr, C37990a.aXh)) {
                    c37990a = C42258c.m74639a(randomAccessFile, bArr, fzG);
                    if (c37990a != null) {
                        break;
                    }
                    randomAccessFile.seek(a.getEndPos());
                }
                if (c37990a != null) {
                    byte[] bArr2 = new byte[(((int) c37990a.getSize()) - 8)];
                    randomAccessFile.seek(c37990a.gjN + 8);
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
                    C4990ab.m7413e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(vB), Long.valueOf(C5046bo.m7525az(yz)), str);
                    if (C5046bo.isNullOrNil(str2)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(50598);
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            C4990ab.m7413e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
            if (randomAccessFile != null) {
            }
            C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(vB), Long.valueOf(C5046bo.m7525az(yz)), str);
            if (C5046bo.isNullOrNil(str2)) {
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(50598);
            throw th;
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(vB), Long.valueOf(C5046bo.m7525az(yz)), str);
        if (C5046bo.isNullOrNil(str2)) {
            boolean contains = str2.contains("WXVer");
            AppMethodBeat.m2505o(50598);
            return contains;
        }
        AppMethodBeat.m2505o(50598);
        return false;
    }

    public final VideoTransPara afG() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara videoTransPara;
        AppMethodBeat.m2504i(50599);
        long yz = C5046bo.m7588yz();
        if (this.fzK == null) {
            this.fzK = C42204d.m74454rS("C2CRecordVideoConfig");
        }
        if (this.fzK != null) {
            for (C37939e c37939e : this.fzK) {
                if (c37939e != null && c37939e.afQ()) {
                    C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    afR = c37939e.afR();
                    z = c37939e.fzW;
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
        videoTransPara.duration = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.mmc2c_record_sight_max_timelength, 10);
        if (z) {
            C7060h.pYm.mo8378a(422, 12, 1, false);
        } else {
            C7060h.pYm.mo8378a(422, 11, 1, false);
        }
        C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(videoTransPara.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 13, 18)), 1, false);
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", Long.valueOf(C5046bo.m7525az(yz)), videoTransPara, Integer.valueOf(r0));
        AppMethodBeat.m2505o(50599);
        return videoTransPara;
    }

    public final VideoTransPara afH() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara afL;
        AppMethodBeat.m2504i(50600);
        long yz = C5046bo.m7588yz();
        if (this.fzL == null) {
            this.fzL = C42204d.m74454rS("SnsRecordVideoConfig");
        }
        if (this.fzL != null) {
            for (C37939e c37939e : this.fzL) {
                if (c37939e != null && c37939e.afQ()) {
                    C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    afR = c37939e.afR();
                    z = c37939e.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afL = C42204d.afL();
        } else {
            afL = afR;
        }
        afL.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        afL.fzT = 10;
        afL.fAf = 200;
        afL.duration = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.mmsns_record_sight_max_timelength, 10);
        if (z) {
            C7060h.pYm.mo8378a(422, 32, 1, false);
        } else {
            C7060h.pYm.mo8378a(422, 31, 1, false);
        }
        C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(afL.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", Long.valueOf(C5046bo.m7525az(yz)), afL, Integer.valueOf(r0));
        AppMethodBeat.m2505o(50600);
        return afL;
    }

    public final VideoTransPara afI() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara afL;
        AppMethodBeat.m2504i(50601);
        long yz = C5046bo.m7588yz();
        if (this.fzM == null) {
            this.fzM = C42204d.m74454rS("SnsAlbumVideoConfig");
        }
        if (this.fzM != null) {
            for (C37939e c37939e : this.fzM) {
                if (c37939e != null && c37939e.afQ()) {
                    C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    afR = c37939e.afR();
                    z = c37939e.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afL = C42204d.afL();
        } else {
            afL = afR;
        }
        afL.audioSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        afL.fzT = 10;
        afL.fAf = 200;
        afL.duration = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.mmsns_album_sight_max_timelength, 10);
        if (z) {
            C7060h.pYm.mo8378a(422, 22, 1, false);
        } else {
            C7060h.pYm.mo8378a(422, 21, 1, false);
        }
        C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(afL.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 23, 28)), 1, false);
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", Long.valueOf(C5046bo.m7525az(yz)), afL, Integer.valueOf(r0));
        AppMethodBeat.m2505o(50601);
        return afL;
    }

    public final VideoTransPara afJ() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara videoTransPara;
        AppMethodBeat.m2504i(50602);
        long yz = C5046bo.m7588yz();
        if (this.fzN == null) {
            this.fzN = C42204d.m74454rS("StoryRecordVideoConfig");
        }
        if (this.fzN != null) {
            for (C37939e c37939e : this.fzN) {
                if (c37939e != null && c37939e.afQ()) {
                    C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
                    afR = c37939e.afR();
                    z = c37939e.fzW;
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
            C7060h.pYm.mo8378a(422, 32, 1, false);
        } else {
            C7060h.pYm.mo8378a(422, 31, 1, false);
        }
        C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(videoTransPara.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", Long.valueOf(C5046bo.m7525az(yz)), videoTransPara, Integer.valueOf(r0));
        AppMethodBeat.m2505o(50602);
        return videoTransPara;
    }

    /* renamed from: b */
    public final VideoTransPara mo67741b(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(50603);
        if (videoTransPara == null) {
            C4990ab.m7412e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
            AppMethodBeat.m2505o(50603);
            return null;
        } else if (videoTransPara.duration >= 300) {
            C4990ab.m7421w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", Integer.valueOf(300));
            AppMethodBeat.m2505o(50603);
            return null;
        } else {
            Object obj;
            C37939e[] c37939eArr;
            boolean z;
            int i;
            long yz = C5046bo.m7588yz();
            VideoTransPara lj = C42204d.m74452lj(videoTransPara.duration);
            int i2 = 1;
            C5141c ll = C18624c.abi().mo17131ll("100157");
            if (ll.isValid()) {
                i2 = C5046bo.getInt((String) ll.dru().get("VideoEncodeStep"), 1);
            }
            C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", Integer.valueOf(i2));
            if (i2 > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (this.fzP == null) {
                    this.fzP = C42204d.m74454rS("C2CAlbumVideoStepConfig");
                }
                c37939eArr = this.fzP;
            } else {
                if (this.fzO == null) {
                    this.fzO = C42204d.m74454rS("C2CAlbumVideoConfig");
                }
                c37939eArr = this.fzO;
            }
            if (c37939eArr != null) {
                for (C37939e c37939e : c37939eArr) {
                    if (c37939e != null && c37939e.afQ()) {
                        C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                        int a = C18654a.m29158a(c37939e.fzX, videoTransPara, lj);
                        z = c37939e.fzW;
                        i = a;
                        break;
                    }
                }
                z = true;
                i = 0;
            } else {
                C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
                z = true;
                i = C18654a.m29158a(null, videoTransPara, lj);
            }
            if (i <= 0) {
                lj = C42204d.m74452lj(videoTransPara.duration);
            } else {
                lj.isDefault = false;
            }
            if (z) {
                C7060h.pYm.mo8378a(422, 2, 1, false);
            } else {
                C7060h.pYm.mo8378a(422, 1, 1, false);
            }
            C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(lj.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 3, 8)), 1, false);
            C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i2), Integer.valueOf(i), lj, videoTransPara);
            AppMethodBeat.m2505o(50603);
            return lj;
        }
    }

    public final VideoTransPara afK() {
        VideoTransPara afR;
        boolean z;
        VideoTransPara afL;
        AppMethodBeat.m2504i(50604);
        long yz = C5046bo.m7588yz();
        if (this.fzQ == null) {
            this.fzQ = C42204d.m74454rS("NearbyRecordVideoConfig");
        }
        if (this.fzQ != null) {
            for (C37939e c37939e : this.fzQ) {
                if (c37939e != null && c37939e.afQ()) {
                    C4990ab.m7416i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
                    afR = c37939e.afR();
                    z = c37939e.fzW;
                    break;
                }
            }
        }
        afR = null;
        z = true;
        if (afR == null) {
            afL = C42204d.afL();
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
            C7060h.pYm.mo8378a(422, 32, 1, false);
        } else {
            C7060h.pYm.mo8378a(422, 31, 1, false);
        }
        C7060h.pYm.mo8378a(422, (long) C5046bo.m7567h((Integer) C7060h.m11789a(afL.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", Long.valueOf(C5046bo.m7525az(yz)), afL, Integer.valueOf(r0));
        AppMethodBeat.m2505o(50604);
        return afL;
    }

    private static VideoTransPara afL() {
        AppMethodBeat.m2504i(50605);
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
        AppMethodBeat.m2505o(50605);
        return videoTransPara;
    }

    /* renamed from: lj */
    private static VideoTransPara m74452lj(int i) {
        AppMethodBeat.m2504i(50606);
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
        AppMethodBeat.m2505o(50606);
        return videoTransPara;
    }

    public static boolean afM() {
        int i;
        AppMethodBeat.m2504i(50607);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        C5141c ll = C18624c.abi().mo17131ll("100136");
        if (ll.isValid()) {
            i = C5046bo.getInt((String) ll.dru().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !C42204d.afO()) ? false : intValue > 0 ? true : i > 0;
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        AppMethodBeat.m2505o(50607);
        return z;
    }

    public static boolean afN() {
        int i;
        AppMethodBeat.m2504i(50608);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        C5141c ll = C18624c.abi().mo17131ll("100153");
        if (ll.isValid()) {
            i = C5046bo.getInt((String) ll.dru().get("snsStreamDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !C42204d.afO()) ? false : intValue > 0 ? true : i > 0;
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        AppMethodBeat.m2505o(50608);
        return z;
    }

    public static boolean afO() {
        int i;
        String str;
        String str2;
        int i2;
        boolean z;
        AppMethodBeat.m2504i(50609);
        long yz = C5046bo.m7588yz();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        C5141c ll = C18624c.abi().mo17131ll("100190");
        if (ll.isValid()) {
            Map dru = ll.dru();
            i = C5046bo.getInt((String) dru.get("player"), 1);
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
        if (!C5046bo.isNullOrNil(str)) {
            for (String str4 : str.split(";")) {
                if (C5046bo.getInt(str4, 0) == i3) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!C5046bo.isNullOrNil(str2)) {
            for (String equalsIgnoreCase : str2.split(";")) {
                if (equalsIgnoreCase.equalsIgnoreCase(str3)) {
                    z = false;
                    break;
                }
            }
        }
        if (C1443d.m3067fP(18)) {
            z = false;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
        }
        if (intValue == 0) {
            z = false;
        }
        if (i2 <= 0) {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", Boolean.valueOf(z), Integer.valueOf(i3), str, str3, str2, Integer.valueOf(i2), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(50609);
        return z;
    }

    /* renamed from: a */
    public static int m74447a(int i, C26493s c26493s) {
        int i2;
        AppMethodBeat.m2504i(50610);
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
                i2 = C42204d.m74449a(c26493s);
                break;
            case 2:
                i2 = C42204d.m74449a(c26493s);
                break;
            default:
                i2 = 1;
                break;
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", Integer.valueOf(i2));
        if (i2 == 2) {
            C7060h.pYm.mo8378a(354, 130, 1, false);
        } else {
            C7060h.pYm.mo8378a(354, 131, 1, false);
        }
        AppMethodBeat.m2505o(50610);
        return i2;
    }

    /* renamed from: a */
    private static int m74449a(C26493s c26493s) {
        int i = 1;
        AppMethodBeat.m2504i(50611);
        if (C42204d.m74453lk(1)) {
            C37961o.all();
            String uh = C9720t.m17303uh(c26493s.getFileName());
            if (C5730e.m8628ct(uh)) {
                if (C26492r.m42230uc(uh)) {
                    i = 2;
                }
                AppMethodBeat.m2505o(50611);
                return i;
            }
            AppMethodBeat.m2505o(50611);
            return 2;
        }
        AppMethodBeat.m2505o(50611);
        return 1;
    }

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (com.tencent.p177mm.modelvideo.C26492r.m42230uc(r8) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: u */
    public static int m74455u(int i, String str) {
        int i2 = 2;
        AppMethodBeat.m2504i(50612);
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                if (C42204d.m74453lk(2)) {
                    if (C5730e.m8628ct(str)) {
                        break;
                    }
                }
                break;
            default:
                i2 = 1;
                break;
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", Integer.valueOf(i2));
        AppMethodBeat.m2505o(50612);
        return i2;
    }

    /* JADX WARNING: Missing block: B:11:0x0035, code skipped:
            if (com.tencent.p177mm.modelvideo.C26492r.m42230uc(r8) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: v */
    public static int m74456v(int i, String str) {
        int i2 = 2;
        AppMethodBeat.m2504i(50613);
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                if (C42204d.m74453lk(3)) {
                    if (C5730e.m8628ct(str)) {
                        break;
                    }
                }
                break;
            default:
                i2 = 1;
                break;
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check story video format[%d]", Integer.valueOf(i2));
        AppMethodBeat.m2505o(50613);
        return i2;
    }

    public static boolean afP() {
        AppMethodBeat.m2504i(50614);
        String str = null;
        C5141c ll = C18624c.abi().mo17131ll("100253");
        if (ll.isValid()) {
            str = (String) ll.dru().get("noCompleteRange");
        }
        if (C5046bo.isNullOrNil(str)) {
            str = "20:00-23:30";
        }
        C1720g.m3534RN();
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", Boolean.valueOf(C45448b.m83718W(str, C1179i.m2593bL(C1668a.m3383QF(), 30))), str, Integer.valueOf(r3));
        if (C45448b.m83718W(str, C1179i.m2593bL(C1668a.m3383QF(), 30))) {
            AppMethodBeat.m2505o(50614);
            return false;
        }
        AppMethodBeat.m2505o(50614);
        return true;
    }

    /* renamed from: lk */
    private static boolean m74453lk(int i) {
        AppMethodBeat.m2504i(50615);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SUPPORT_HEVC_VIDEO_INT, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = C12691e.bOS() ? 1 : 0;
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SUPPORT_HEVC_VIDEO_INT, Integer.valueOf(intValue));
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", Integer.valueOf(intValue));
        if (intValue <= 0) {
            AppMethodBeat.m2505o(50615);
            return false;
        }
        boolean z;
        int i2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("VideoDownloadH265Flag", 0);
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
        int i3 = C1427q.etn.esI;
        if (i3 != -1) {
            if (i3 == 1) {
                z = true;
            } else {
                z = false;
            }
        }
        C4990ab.m7417i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevc, scene:%s, flag:%s, configResult:%s, dynamicConfigResult:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3));
        AppMethodBeat.m2505o(50615);
        return z;
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
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        this.fzK = null;
        this.fzP = null;
        this.fzO = null;
        this.fzL = null;
        this.fzM = null;
    }
}
