package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p253f.C1779d;
import com.tencent.p177mm.media.p253f.C32745e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.b */
public final class C38909b extends C32745e {
    private final String TAG = "MicroMsg.EmojiMixFrameSyncMgr";

    public C38909b(String str, C1779d c1779d, int i) {
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(c1779d, "emojiFrameRetriever");
        super(str, c1779d);
        AppMethodBeat.m2504i(2663);
        this.eWR = i * 20;
        if (this.eWR > 30) {
            this.eWR = 30;
        }
        this.eWS /= (float) i;
        this.eWU = 1000.0f / ((float) this.eWR);
        if (this.eWU < this.eWS) {
            this.eWU = this.eWS;
        }
        this.eWP = (int) (((float) (this.eWK / i)) / this.eWU);
        this.eWQ = 0;
        C4990ab.m7416i(this.TAG, "init MixFrameSyncMgr,videoPath:" + str + ", videoPlayRate:" + i + ", fps:" + this.eWJ + ", duration:" + this.eWK + ", frameCount:" + this.eWI + ", frameDuration:" + this.eWS + ", targetFrameRate:" + this.eWR + ", targetFrameCount:" + this.eWP + ", targetFrameDuration:" + this.eWU);
        AppMethodBeat.m2505o(2663);
    }
}
