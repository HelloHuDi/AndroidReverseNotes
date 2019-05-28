package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Date;

public final class ao {
    boolean fVW = false;
    boolean fVX = false;
    long qMH = 0;
    private boolean qMI = false;
    int qMJ = 0;
    int qMK = 1440;
    c<rn> qML = new c<rn>() {
        {
            AppMethodBeat.i(36600);
            this.xxI = rn.class.getName().hashCode();
            AppMethodBeat.o(36600);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36602);
            boolean cog = cog();
            AppMethodBeat.o(36602);
            return cog;
        }

        private boolean cog() {
            int minutes;
            int i = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
            AppMethodBeat.i(36601);
            ao aoVar = ao.this;
            try {
                if (aoVar.cof()) {
                    Date date = new Date();
                    minutes = date.getMinutes() + (date.getHours() * 60);
                    if (minutes >= aoVar.qMJ && minutes <= aoVar.qMK) {
                        ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", Integer.valueOf(minutes), Integer.valueOf(aoVar.qMJ), Integer.valueOf(aoVar.qMK));
                        AppMethodBeat.o(36601);
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            int i2 = g.Nu().getInt("SnsImgPreLoadingSmallImage", 1);
            int i3 = g.Nu().getInt("SnsImgPreLoadingBigImage", 1);
            int i4 = g.Nu().getInt("SnsPreLoadingVideo", 1);
            minutes = g.Nu().getInt("SnsImgPreLoadingInterval", TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            ab.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minutes));
            if (i2 > 0 || i3 > 0 || i4 > 0) {
                if (minutes > 0) {
                    i = minutes;
                }
                if (aoVar.fVW || aoVar.fVX || bo.fp(aoVar.qMH) < ((long) i)) {
                    ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", Boolean.valueOf(aoVar.fVW), Boolean.valueOf(aoVar.fVX));
                } else if (y.XO("@__weixintimtline")) {
                    com.tencent.mm.kernel.g.RQ();
                    if (!com.tencent.mm.kernel.g.RO().eJo.a(new t(), 0)) {
                        ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                        y.XP("@__weixintimtline");
                    }
                    aoVar.qMH = bo.anT();
                } else {
                    ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
                }
            }
            AppMethodBeat.o(36601);
            return false;
        }
    };
    c qMM = new c<e>() {
        {
            AppMethodBeat.i(36603);
            this.xxI = e.class.getName().hashCode();
            AppMethodBeat.o(36603);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36604);
            e eVar = (e) bVar;
            if (eVar.crS.className.equals("SnsTimeLineUI")) {
                ao.this.fVX = eVar.crS.active;
                ab.i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", Boolean.valueOf(ao.this.fVX));
            }
            AppMethodBeat.o(36604);
            return false;
        }
    };
    c qMN = new c<av>() {
        {
            AppMethodBeat.i(36605);
            this.xxI = av.class.getName().hashCode();
            AppMethodBeat.o(36605);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36606);
            av avVar = (av) bVar;
            ao.this.fVW = avVar.ctX.ctY;
            ab.i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", Boolean.valueOf(ao.this.fVW));
            AppMethodBeat.o(36606);
            return false;
        }
    };

    ao() {
        AppMethodBeat.i(36607);
        AppMethodBeat.o(36607);
    }

    /* Access modifiers changed, original: final */
    public final boolean cof() {
        AppMethodBeat.i(36608);
        String value = g.Nu().getValue("SnsImgPreLoadingTimeLimit");
        ab.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", value);
        if (bo.isNullOrNil(value)) {
            AppMethodBeat.o(36608);
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            this.qMJ = bo.ank(split2[1]) + (bo.ank(split2[0]) * 60);
            split = split[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            this.qMK = bo.ank(split[1]) + (bo.ank(split[0]) * 60);
            ab.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", Integer.valueOf(this.qMJ), Integer.valueOf(this.qMK));
            AppMethodBeat.o(36608);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(36608);
            return false;
        }
    }

    public final void start() {
        AppMethodBeat.i(36609);
        a.xxA.c(this.qML);
        a.xxA.c(this.qMM);
        a.xxA.c(this.qMN);
        AppMethodBeat.o(36609);
    }
}
