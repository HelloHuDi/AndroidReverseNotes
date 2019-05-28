package com.tencent.p177mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.trafficmonitor.TrafficClickFlowReceiver.C22441c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.trafficmonitor.d */
public final class C29473d {
    private static Map<String, Long> sKg = new HashMap();
    private static Map<String, Integer> sKh = new HashMap();
    public final String TAG = "Traf.TrafficModel";
    private long sKb;
    private double sKc = 0.35d;
    private double sKd = 3.0d;
    long sKe = 0;
    double sKf = 0.0d;

    static {
        AppMethodBeat.m2504i(114780);
        sKg.put(BuildConfig.COMMAND, Long.valueOf(4194304));
        sKg.put("Background", Long.valueOf(5242880));
        sKg.put("WebViewUI", Long.valueOf(83886080));
        sKg.put("WebviewMpUI", Long.valueOf(83886080));
        sKg.put("SnsTimeLineUI", Long.valueOf(15728640));
        sKg.put("SnsUserUI", Long.valueOf(15728640));
        sKg.put("AppBrandLaunchProxyUI", Long.valueOf(12582912));
        sKg.put("AppBrandUI", Long.valueOf(20971520));
        sKg.put("ChattingUI", Long.valueOf(12582912));
        sKg.put("SnsBrowseUI", Long.valueOf(12582912));
        sKg.put("SnsOnlineVideoActivity", Long.valueOf(12582912));
        sKg.put("EmojiStoreV2UI", Long.valueOf(16777216));
        sKg.put("EmojiStoreDetailUI", Long.valueOf(16777216));
        sKg.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912));
        sKg.put("FTSWebViewUI", Long.valueOf(12582912));
        sKg.put("TopStoryHomeUI", Long.valueOf(16777216));
        sKg.put("TopStoryVideoStreamUI", Long.valueOf(25165824));
        sKg.put("GameDemoActivity1", Long.valueOf(12582912));
        sKg.put("ImageGalleryUI", Long.valueOf(12582912));
        sKg.put("SnsGalleryUI", Long.valueOf(12582912));
        sKg.put("VideoActivity", Long.valueOf(16777216));
        sKg.put("MultiTalkMainUI", Long.valueOf(16777216));
        sKg.put("FavoriteVideoPlayUI", Long.valueOf(16777216));
        sKg.put("AppAttachDownloadUI", Long.valueOf(20971520));
        sKg.put("LuggageGameWebViewUI", Long.valueOf(20971520));
        sKh.put("AppAttachDownloadUI", Integer.valueOf(2));
        sKh.put("SendImgProxyUI", Integer.valueOf(2));
        AppMethodBeat.m2505o(114780);
    }

    public C29473d(long j) {
        this.sKb = j;
    }

    /* renamed from: a */
    public final boolean mo47717a(List<C22441c> list, long j, long j2, long j3) {
        AppMethodBeat.m2504i(114778);
        C4990ab.m7417i("Traf.TrafficModel", "realInterval:%d", Long.valueOf(j3));
        if (j3 <= 5000) {
            AppMethodBeat.m2505o(114778);
            return false;
        }
        int i;
        if (j3 <= 300000) {
            i = 100;
        } else if (j3 > 300000 && j3 <= 600000) {
            i = 90;
        } else if (j3 <= 600000 || j3 > 1800000) {
            i = 50;
        } else {
            i = 60;
        }
        this.sKb = ((((long) i) * j3) * 1048576) / 60000;
        this.sKe = 0;
        long j4 = 0;
        Object obj = null;
        i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            long min = Math.min(((C22441c) list.get(i2)).endTime - ((C22441c) list.get(i2)).startTime, j2);
            j4 += min;
            Object obj2 = ((C22441c) list.get(i2)).sJY;
            if (obj2 == null) {
                obj2 = BuildConfig.COMMAND;
            }
            if (obj2.equals("AppAttachDownloadUI") && obj == null) {
                obj = 1;
            }
            obj2.equals("SendImgProxyUI");
            if (obj2.contains("_")) {
                obj2 = obj2.substring(0, obj2.indexOf("_"));
            }
            if (sKg.containsKey(obj2)) {
                this.sKe = (long) ((((((double) min) / 1000.0d) / 60.0d) * ((double) ((Long) sKg.get(obj2)).longValue())) + ((double) this.sKe));
            } else {
                this.sKe = (long) ((((((double) min) / 1000.0d) / 60.0d) * 8388608.0d) + ((double) this.sKe));
            }
            i = i2 + 1;
        }
        if (j4 < j2) {
            this.sKe += (((j2 - j4) / 1000) / 60) * 8388608;
        }
        this.sKe = Math.max(((Long) sKg.get(BuildConfig.COMMAND)).longValue() * ((j2 / 1000) / 60), this.sKe);
        if (obj != null) {
            this.sKe = ((long) ((Integer) sKh.get("AppAttachDownloadUI")).intValue()) * this.sKe;
        }
        if (obj != null) {
            this.sKe = ((long) ((Integer) sKh.get("SendImgProxyUI")).intValue()) * this.sKe;
        }
        this.sKf = (((double) j) / ((double) this.sKb)) + ((((double) j) / ((double) this.sKe)) * this.sKc);
        if (this.sKf < 0.0d) {
            this.sKf = 0.0d;
        }
        double d = this.sKf;
        C4990ab.m7417i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", Long.valueOf(j), Long.valueOf(this.sKb), Long.valueOf(this.sKe), Long.valueOf(j3));
        if (d > this.sKd) {
            AppMethodBeat.m2505o(114778);
            return true;
        }
        AppMethodBeat.m2505o(114778);
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(114779);
        String str = "TrafficModel{standardTraffic=" + this.sKb + ", preciseRatio=" + this.sKc + ", threshold=" + this.sKd + '}';
        AppMethodBeat.m2505o(114779);
        return str;
    }
}
