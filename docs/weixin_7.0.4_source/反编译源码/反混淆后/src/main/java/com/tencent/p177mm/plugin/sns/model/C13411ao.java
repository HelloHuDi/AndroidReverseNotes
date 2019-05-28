package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37794rn;
import com.tencent.p177mm.p230g.p231a.C41969av;
import com.tencent.p177mm.p230g.p231a.C9326e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.sns.model.ao */
public final class C13411ao {
    boolean fVW = false;
    boolean fVX = false;
    long qMH = 0;
    private boolean qMI = false;
    int qMJ = 0;
    int qMK = 1440;
    C4884c<C37794rn> qML = new C134121();
    C4884c qMM = new C134092();
    C4884c qMN = new C134103();

    /* renamed from: com.tencent.mm.plugin.sns.model.ao$2 */
    class C134092 extends C4884c<C9326e> {
        C134092() {
            AppMethodBeat.m2504i(36603);
            this.xxI = C9326e.class.getName().hashCode();
            AppMethodBeat.m2505o(36603);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36604);
            C9326e c9326e = (C9326e) c4883b;
            if (c9326e.crS.className.equals("SnsTimeLineUI")) {
                C13411ao.this.fVX = c9326e.crS.active;
                C4990ab.m7417i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", Boolean.valueOf(C13411ao.this.fVX));
            }
            AppMethodBeat.m2505o(36604);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ao$3 */
    class C134103 extends C4884c<C41969av> {
        C134103() {
            AppMethodBeat.m2504i(36605);
            this.xxI = C41969av.class.getName().hashCode();
            AppMethodBeat.m2505o(36605);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36606);
            C41969av c41969av = (C41969av) c4883b;
            C13411ao.this.fVW = c41969av.ctX.ctY;
            C4990ab.m7417i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", Boolean.valueOf(C13411ao.this.fVW));
            AppMethodBeat.m2505o(36606);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ao$1 */
    class C134121 extends C4884c<C37794rn> {
        C134121() {
            AppMethodBeat.m2504i(36600);
            this.xxI = C37794rn.class.getName().hashCode();
            AppMethodBeat.m2505o(36600);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36602);
            boolean cog = cog();
            AppMethodBeat.m2505o(36602);
            return cog;
        }

        private boolean cog() {
            int minutes;
            int i = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
            AppMethodBeat.m2504i(36601);
            C13411ao c13411ao = C13411ao.this;
            try {
                if (c13411ao.cof()) {
                    Date date = new Date();
                    minutes = date.getMinutes() + (date.getHours() * 60);
                    if (minutes >= c13411ao.qMJ && minutes <= c13411ao.qMK) {
                        C4990ab.m7417i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", Integer.valueOf(minutes), Integer.valueOf(c13411ao.qMJ), Integer.valueOf(c13411ao.qMK));
                        AppMethodBeat.m2505o(36601);
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            int i2 = C26373g.m41964Nu().getInt("SnsImgPreLoadingSmallImage", 1);
            int i3 = C26373g.m41964Nu().getInt("SnsImgPreLoadingBigImage", 1);
            int i4 = C26373g.m41964Nu().getInt("SnsPreLoadingVideo", 1);
            minutes = C26373g.m41964Nu().getInt("SnsImgPreLoadingInterval", TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            C4990ab.m7417i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minutes));
            if (i2 > 0 || i3 > 0 || i4 > 0) {
                if (minutes > 0) {
                    i = minutes;
                }
                if (c13411ao.fVW || c13411ao.fVX || C5046bo.m7549fp(c13411ao.qMH) < ((long) i)) {
                    C4990ab.m7417i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", Boolean.valueOf(c13411ao.fVW), Boolean.valueOf(c13411ao.fVX));
                } else if (C46225y.m86450XO("@__weixintimtline")) {
                    C1720g.m3537RQ();
                    if (!C1720g.m3535RO().eJo.mo14541a(new C34963t(), 0)) {
                        C4990ab.m7416i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                        C46225y.m86451XP("@__weixintimtline");
                    }
                    c13411ao.qMH = C5046bo.anT();
                } else {
                    C4990ab.m7416i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
                }
            }
            AppMethodBeat.m2505o(36601);
            return false;
        }
    }

    C13411ao() {
        AppMethodBeat.m2504i(36607);
        AppMethodBeat.m2505o(36607);
    }

    /* Access modifiers changed, original: final */
    public final boolean cof() {
        AppMethodBeat.m2504i(36608);
        String value = C26373g.m41964Nu().getValue("SnsImgPreLoadingTimeLimit");
        C4990ab.m7417i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", value);
        if (C5046bo.isNullOrNil(value)) {
            AppMethodBeat.m2505o(36608);
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            this.qMJ = C5046bo.ank(split2[1]) + (C5046bo.ank(split2[0]) * 60);
            split = split[1].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            this.qMK = C5046bo.ank(split[1]) + (C5046bo.ank(split[0]) * 60);
            C4990ab.m7411d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", Integer.valueOf(this.qMJ), Integer.valueOf(this.qMK));
            AppMethodBeat.m2505o(36608);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(36608);
            return false;
        }
    }

    public final void start() {
        AppMethodBeat.m2504i(36609);
        C4879a.xxA.mo10052c(this.qML);
        C4879a.xxA.mo10052c(this.qMM);
        C4879a.xxA.mo10052c(this.qMN);
        AppMethodBeat.m2505o(36609);
    }
}
