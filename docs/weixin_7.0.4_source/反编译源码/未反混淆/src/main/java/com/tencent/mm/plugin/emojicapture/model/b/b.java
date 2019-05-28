package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.f.e;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b extends e {
    private final String TAG = "MicroMsg.EmojiMixFrameSyncMgr";

    public b(String str, d dVar, int i) {
        j.p(str, "videoPath");
        j.p(dVar, "emojiFrameRetriever");
        super(str, dVar);
        AppMethodBeat.i(2663);
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
        ab.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + str + ", videoPlayRate:" + i + ", fps:" + this.eWJ + ", duration:" + this.eWK + ", frameCount:" + this.eWI + ", frameDuration:" + this.eWS + ", targetFrameRate:" + this.eWR + ", targetFrameCount:" + this.eWP + ", targetFrameDuration:" + this.eWU);
        AppMethodBeat.o(2663);
    }
}
