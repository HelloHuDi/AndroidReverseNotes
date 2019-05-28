package com.tencent.p177mm.plugin.story.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C18438bd;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo.C4123a;
import com.tencent.p177mm.plugin.story.model.p744a.C46276b;
import com.tencent.p177mm.protocal.protobuf.bqk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0018\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020%J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001a¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.audio.b */
public final class C22219b {
    public static final String TAG = TAG;
    private static C22219b rUt;
    public static long rUu;
    public static long rUv;
    private static C18438bd rUw = new C18438bd();
    public static final C13771a rUx = new C13771a();
    public boolean cHY = true;
    public int cvd = AudioCacheInfo.rUh;
    public long pvG;
    public int rUp;
    public long rUq;
    public boolean rUr;
    public final ArrayList<bqk> rUs = new ArrayList();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020-2\u0006\u0010\"\u001a\u00020-J\u0006\u0010.\u001a\u00020,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/story/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/story/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/story/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.audio.b$a */
    public static final class C13771a {
        private C13771a() {
        }

        public /* synthetic */ C13771a(byte b) {
            this();
        }

        public static void cyU() {
            AppMethodBeat.m2504i(109186);
            C4990ab.m7410d(C22219b.TAG, "reportAudioSearchStruct:\n " + C22219b.rUw.mo4983Fk());
            C22219b.rUw.ajK();
            C18438bd c18438bd = new C18438bd();
            C25052j.m39376p(c18438bd, "<set-?>");
            C22219b.rUw = c18438bd;
            AppMethodBeat.m2505o(109186);
        }
    }

    public C22219b() {
        AppMethodBeat.m2504i(109189);
        C4123a c4123a = AudioCacheInfo.rUj;
        AppMethodBeat.m2505o(109189);
    }

    static {
        AppMethodBeat.m2504i(109190);
        AppMethodBeat.m2505o(109190);
    }

    public final void cyQ() {
        AppMethodBeat.m2504i(109187);
        if (!this.cHY) {
            bqk bqk = new bqk();
            long currentTimeMillis = System.currentTimeMillis();
            bqk.wSJ = this.rUp;
            int i = this.cvd;
            C4123a c4123a = AudioCacheInfo.rUj;
            bqk.wSK = i == AudioCacheInfo.rUh ? 1 : 9;
            bqk.wSL = (int) (currentTimeMillis - this.rUq);
            bqk.wSM = (int) (this.rUq / 1000);
            this.rUs.add(bqk);
            this.cHY = true;
            C4990ab.m7416i(TAG, "record pause " + C29301c.m46522a(bqk));
        }
        AppMethodBeat.m2505o(109187);
    }

    public final void cyR() {
        AppMethodBeat.m2504i(109188);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14552d((C1207m) new C46276b(this.pvG, this.rUs));
        rUt = null;
        AppMethodBeat.m2505o(109188);
    }
}
