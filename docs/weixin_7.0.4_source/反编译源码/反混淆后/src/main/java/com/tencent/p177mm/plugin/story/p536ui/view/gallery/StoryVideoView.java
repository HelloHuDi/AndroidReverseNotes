package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.MMVideoView;
import com.tencent.p177mm.p230g.p232b.p233a.C9505bm;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 b2\u00020\u0001:\u0001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J \u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0014J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\rH\u0002J\u0006\u0010/\u001a\u00020 J\u0006\u00100\u001a\u00020\tJ\b\u00101\u001a\u00020\tH\u0016J\u0006\u00102\u001a\u00020 J\b\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020 J\b\u00108\u001a\u000204H\u0016J\u001a\u00109\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020 H\u0016J\u0018\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020 H\u0016J\"\u0010?\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\u0010\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u0013H\u0016J\b\u0010D\u001a\u000204H\u0016J\b\u0010E\u001a\u000204H\u0016J\b\u0010F\u001a\u000204H\u0016J\b\u0010G\u001a\u000204H\u0016J\b\u0010H\u001a\u000204H\u0016J\b\u0010I\u001a\u00020\u0013H\u0016J\u0018\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020\tH\u0002J\b\u0010N\u001a\u000204H\u0014J\b\u0010O\u001a\u000204H\u0002J\b\u0010P\u001a\u000204H\u0016J\u0012\u0010Q\u001a\u0002042\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\u0013H\u0016J\u000e\u0010U\u001a\u0002042\u0006\u0010V\u001a\u00020\u0013J\u0012\u0010W\u001a\u0002042\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\"\u0010Z\u001a\u0002042\u0006\u00105\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010\t2\u0006\u0010\\\u001a\u00020 H\u0016J\b\u0010]\u001a\u000204H\u0014J\b\u0010$\u001a\u000204H\u0016J\u0010\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020\u0013H\u0014J\b\u0010`\u001a\u000204H\u0016J\b\u0010a\u001a\u000204H\u0014R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeLayer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView */
public final class StoryVideoView extends MMVideoView {
    public static final C4170a sqI = new C4170a();
    private String cvF;
    private boolean eif;
    private long fqM;
    private TextView mqf;
    private C35201i rVZ;
    private final String sqA;
    private boolean sqB;
    boolean sqC;
    private boolean sqD;
    private boolean sqE;
    private boolean sqF;
    private C35263o sqG;
    private long sqH;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView$b */
    public static final class C4167b implements C14981a {
        final /* synthetic */ StoryVideoView sqJ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTextureUpdate"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView$b$a */
        static final class C4168a implements C14980e {
            final /* synthetic */ C4167b sqK;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView$b$a$1 */
            static final class C41691 implements Runnable {
                final /* synthetic */ C4168a sqL;

                C41691(C4168a c4168a) {
                    this.sqL = c4168a;
                }

                public final void run() {
                    AppMethodBeat.m2504i(110908);
                    C4990ab.m7416i(this.sqL.sqK.sqJ.TAG, "onTextureUpdate");
                    if (this.sqL.sqK.sqJ.klq == null) {
                        AppMethodBeat.m2505o(110908);
                        return;
                    }
                    StoryVideoView.m6502h(this.sqL.sqK.sqJ);
                    C14979e f = this.sqL.sqK.sqJ.klq;
                    if (f == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.m2505o(110908);
                        throw c44941v;
                    }
                    ((View) f).setAlpha(1.0f);
                    AppMethodBeat.m2505o(110908);
                }
            }

            C4168a(C4167b c4167b) {
                this.sqK = c4167b;
            }

            public final void bQL() {
                AppMethodBeat.m2504i(110909);
                this.sqK.sqJ.setFirstPlayWaitTime(C5046bo.m7525az(this.sqK.sqJ.fqM));
                C5004al.m7442n(new C41691(this), 50);
                AppMethodBeat.m2505o(110909);
            }
        }

        C4167b(StoryVideoView storyVideoView) {
            this.sqJ = storyVideoView;
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(110910);
            String a = this.sqJ.TAG;
            StringBuilder append = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(this.sqJ.sqE).append(", isFakeVideo:");
            C35201i c = this.sqJ.rVZ;
            C4990ab.m7416i(a, append.append(c != null ? Boolean.valueOf(c.cze()) : null).append(", fakeStartTime:").append(StoryVideoView.m6498d(this.sqJ)).append(", fakeEndTime:").append(StoryVideoView.m6499e(this.sqJ)).toString());
            if (!this.sqJ.sqE) {
                c = this.sqJ.rVZ;
                if (c == null || !c.cze() || StoryVideoView.m6498d(this.sqJ) <= 0) {
                    this.sqJ.klq.start();
                } else {
                    this.sqJ.klq.mo27356d((double) StoryVideoView.m6498d(this.sqJ), true);
                }
                this.sqJ.klq.setOneTimeVideoTextureUpdateCallback(new C4168a(this));
            }
            AppMethodBeat.m2505o(110910);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(110911);
            String a = this.sqJ.TAG;
            StringBuilder stringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
            C35201i c = this.sqJ.rVZ;
            C4990ab.m7416i(a, stringBuilder.append(c != null ? Boolean.valueOf(c.cze()) : null).append(", fakeStartTime:").append(StoryVideoView.m6498d(this.sqJ)).toString());
            c = this.sqJ.rVZ;
            if (c == null || !c.cze() || StoryVideoView.m6498d(this.sqJ) <= 0) {
                this.sqJ.klq.mo27356d(0.0d, true);
            } else {
                this.sqJ.klq.mo27356d((double) StoryVideoView.m6498d(this.sqJ), true);
            }
            C23324b i = this.sqJ.rcd;
            if (i != null) {
                i.mo9211cq(this.sqJ.getSessionId(), StoryVideoView.m6504j(this.sqJ));
                AppMethodBeat.m2505o(110911);
                return;
            }
            AppMethodBeat.m2505o(110911);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            AppMethodBeat.m2504i(110912);
            C35201i c = this.sqJ.rVZ;
            if (c != null && c.cze() && StoryVideoView.m6499e(this.sqJ) > 0 && ((long) i) >= StoryVideoView.m6499e(this.sqJ)) {
                C4990ab.m7416i(this.sqJ.TAG, "fakeVideo exceed endTime, playTime:" + i + ", fakeEndTime:" + StoryVideoView.m6499e(this.sqJ) + ", fakeStartTime:" + StoryVideoView.m6498d(this.sqJ));
                if (StoryVideoView.m6498d(this.sqJ) > 0) {
                    this.sqJ.klq.mo27356d((double) StoryVideoView.m6498d(this.sqJ), true);
                } else {
                    this.sqJ.klq.mo27356d(0.0d, true);
                }
            }
            AppMethodBeat.m2505o(110912);
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$Companion;", "", "()V", "PRELOAD_CACHE", "", "PRELOAD_CACHE_GOOD_NETWORK", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView$a */
    public static final class C4170a {
        private C4170a() {
        }

        public /* synthetic */ C4170a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView$c */
    static final class C4171c implements Runnable {
        final /* synthetic */ long rVy;
        final /* synthetic */ StoryVideoView sqJ;
        final /* synthetic */ C9505bm sqM;

        C4171c(StoryVideoView storyVideoView, C9505bm c9505bm, long j) {
            this.sqJ = storyVideoView;
            this.sqM = c9505bm;
            this.rVy = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(110913);
            C4990ab.m7416i(this.sqJ.TAG, "reportStopLocalVideo");
            C43528a WR = C21846d.m33388WR(this.sqJ.fUM);
            if (WR != null) {
                C9505bm c9505bm = this.sqM.mo20779do((long) WR.eWK);
                C4133a c4133a = C43644j.rST;
                c9505bm.mo20777dm((long) C4133a.cxT().mo74418ly(this.rVy)).mo20784dt((long) WR.videoBitrate).ajK();
            }
            AppMethodBeat.m2505o(110913);
        }
    }

    static {
        AppMethodBeat.m2504i(110950);
        AppMethodBeat.m2505o(110950);
    }

    public StoryVideoView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110948);
        this.sqA = "MicroMsg.StoryVideoView";
        C4133a c4133a = C43644j.rST;
        setRootPath(C4133a.getAccStoryPath());
        diM();
        setIsShowBasicControls(false);
        LinearLayout linearLayout = this.vgm;
        C25052j.m39375o(linearLayout, "footerRoot");
        linearLayout.setVisibility(8);
        this.TAG = this.sqA;
        this.sqB = true;
        AppMethodBeat.m2505o(110948);
    }

    /* renamed from: h */
    public static final /* synthetic */ void m6502h(StoryVideoView storyVideoView) {
        AppMethodBeat.m2504i(110951);
        storyVideoView.bJc();
        AppMethodBeat.m2505o(110951);
    }

    /* renamed from: j */
    public static final /* synthetic */ String m6504j(StoryVideoView storyVideoView) {
        AppMethodBeat.m2504i(110952);
        String mediaId = storyVideoView.getMediaId();
        AppMethodBeat.m2505o(110952);
        return mediaId;
    }

    public StoryVideoView(Context context) {
        C25052j.m39376p(context, "context");
        this(context, null);
        AppMethodBeat.m2504i(110949);
        AppMethodBeat.m2505o(110949);
    }

    public final long getFirstPlayWaitTime() {
        return this.sqH;
    }

    public final void setFirstPlayWaitTime(long j) {
        this.sqH = j;
    }

    public final void initView() {
        AppMethodBeat.m2504i(110914);
        super.initView();
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.sqG = new C35263o(context);
        RelativeLayout relativeLayout = this.vgl;
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        relativeLayout.addView(c35263o, new LayoutParams(-1, -1));
        this.mqf = (TextView) findViewById(2131822138);
        AppMethodBeat.m2505o(110914);
    }

    /* renamed from: a */
    public final void mo9054a(C35201i c35201i, String str) {
        AppMethodBeat.m2504i(110915);
        C25052j.m39376p(c35201i, "item");
        TextView textView = this.mqf;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.rVZ = c35201i;
        cek cek = c35201i.rWj;
        int i = c35201i.fDG;
        this.sqF = false;
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        c35263o.setVisibility(8);
        if (c35201i.czf()) {
            String str2;
            if (c35201i.cze()) {
                this.sqF = true;
                C4990ab.m7416i(this.TAG, "LogStory: play fake video");
                c35263o = this.sqG;
                if (c35263o == null) {
                    C25052j.avw("fakeLayer");
                }
                c35263o.setVisibility(0);
                cee cee = c35201i.rWl;
                if (cee != null) {
                    C35263o c35263o2 = this.sqG;
                    if (c35263o2 == null) {
                        C25052j.avw("fakeLayer");
                    }
                    c35263o2.setFakeVideoInfo(cee);
                    c35263o2 = this.sqG;
                    if (c35263o2 == null) {
                        C25052j.avw("fakeLayer");
                    }
                    c35263o2.mo55978lW(this.eif);
                    this.fUM = cee.videoPath;
                    this.fUL = "";
                    str2 = this.fUM;
                    C25052j.m39375o(str2, "filepath");
                    abf(str2);
                }
            } else {
                C4990ab.m7416i(this.TAG, "LogStory: play normal video");
                C43649s c43649s = C43649s.rTV;
                str2 = C43649s.m78154a(cek);
                if (C5730e.asZ(str2) > 0) {
                    C4990ab.m7416i(this.TAG, "play " + str2 + " downloadDone now can play " + cek.f4416Id);
                    this.fUM = str2;
                    if (str2 != null) {
                        abf(str2);
                    }
                } else {
                    C4133a c4133a;
                    C43649s c43649s2 = C43649s.rTV;
                    C29298n a = C43649s.m78153a(c35201i);
                    int asZ = (int) C5730e.asZ(a.field_filePath);
                    C4990ab.m7416i(this.TAG, "play " + str2 + " error try play from url or videoCache " + cek.f4416Id + " fileLength:" + asZ + " cacheSize:" + a.field_cacheSize);
                    if (asZ < a.field_cacheSize) {
                        a.field_cacheSize = asZ;
                        c4133a = C43644j.rST;
                        C4133a.cxX().mo25974b(a);
                    }
                    C4990ab.m7416i(this.TAG, String.valueOf(a));
                    if (a.mo47507Jo() && C5730e.m8628ct(a.field_filePath)) {
                        C4990ab.m7416i(this.TAG, "play " + cek.f4416Id + " download finish");
                        this.fUM = a.field_filePath;
                        c43649s = C43649s.rTV;
                        this.fUL = C43649s.m78156be(i, cek.Url);
                        str2 = this.fUM;
                        C25052j.m39375o(str2, "filepath");
                        abf(str2);
                    } else {
                        if (a.mo47507Jo() && !C5730e.m8628ct(a.field_filePath)) {
                            C4990ab.m7416i(this.TAG, "error downloadFinish " + a.mo47507Jo() + " ret:" + C5730e.m8628ct(a.field_filePath));
                            a.cCe();
                            c4133a = C43644j.rST;
                            C4133a.cxX().mo25974b(a);
                        }
                        C4990ab.m7416i(this.TAG, "play " + cek.f4416Id + ' ' + str + " start online play " + a.field_filePath);
                        reset();
                        this.klq.stop();
                        this.klq.setVideoCallback(this);
                        this.sqC = false;
                        this.vgu = true;
                        setNeedShowLoading(true);
                        super.mo9063c(false, c35201i.rWj.Url, (int) cek.duration);
                        this.fUM = a.field_filePath;
                        c43649s = C43649s.rTV;
                        this.fUL = C43649s.m78156be(i, cek.Url);
                        this.cvF = str;
                        this.fqM = C5046bo.m7588yz();
                        this.sqH = 0;
                        start();
                    }
                }
            }
            setLoop(true);
            C14979e c14979e = this.klq;
            if (c14979e == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.m2505o(110915);
                throw c44941v;
            }
            ((View) c14979e).setAlpha(0.0f);
            AppMethodBeat.m2505o(110915);
            return;
        }
        C4990ab.m7416i(this.TAG, "play empty item");
        aNt();
        AppMethodBeat.m2505o(110915);
    }

    /* renamed from: EA */
    public final void mo8553EA() {
        AppMethodBeat.m2504i(110916);
        C4990ab.m7416i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.fUP + ", downloadStatus:" + this.fUO);
        if (getCurrPosMs() <= 0) {
            AppMethodBeat.m2505o(110916);
            return;
        }
        C23324b c23324b = this.rcd;
        if (c23324b != null) {
            c23324b.mo9211cq(getSessionId(), getMediaId());
        }
        super.mo8553EA();
        AppMethodBeat.m2505o(110916);
    }

    public final String getSessionId() {
        AppMethodBeat.m2504i(110917);
        String nullAsNil = C5046bo.nullAsNil(this.cvF);
        C25052j.m39375o(nullAsNil, "Util.nullAsNil(sessionId)");
        AppMethodBeat.m2505o(110917);
        return nullAsNil;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(110918);
        super.setMute(z);
        this.eif = z;
        if (this.klq != null) {
            this.klq.setMute(z);
        }
        AppMethodBeat.m2505o(110918);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: m */
    public final void mo9078m(C35201i c35201i) {
        boolean j;
        Object obj = null;
        AppMethodBeat.m2504i(110919);
        C4990ab.m7416i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.f14408VN + ", sessionId:" + this.cvF + ", isLocalVideo:" + this.sqC);
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        c35263o.mo55978lW(this.eif);
        if (getCurrPosSec() >= getVideoDurationSec()) {
            C4990ab.m7416i(this.TAG, "resume, restart video");
            if (c35201i != null) {
                mo9054a(c35201i, this.cvF);
                AppMethodBeat.m2505o(110919);
                return;
            }
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.sqC).append(", currentPosition:");
        C14979e c14979e = this.klq;
        C4990ab.m7416i(str, append.append(c14979e != null ? Integer.valueOf(c14979e.getCurrentPosition()) : null).toString());
        if (this.sqC) {
            int currentPosition;
            c14979e = this.klq;
            if (c14979e != null) {
                currentPosition = c14979e.getCurrentPosition();
            } else {
                currentPosition = 0;
            }
            if (currentPosition > 0) {
                c14979e = this.klq;
                if (c14979e != null) {
                    obj = Boolean.valueOf(c14979e.start());
                }
                this.sqE = false;
                j = C25052j.m39373j(obj, Boolean.TRUE);
                if (!j) {
                    AppMethodBeat.m2505o(110919);
                    return;
                } else if (getCurrPosMs() <= 0 || this.sqC) {
                    if (c35201i != null) {
                        mo9054a(c35201i, this.cvF);
                    }
                    AppMethodBeat.m2505o(110919);
                    return;
                } else if (this.f14408VN) {
                    super.play();
                    AppMethodBeat.m2505o(110919);
                    return;
                } else {
                    this.vgu = true;
                    akU();
                    AppMethodBeat.m2505o(110919);
                    return;
                }
            }
        }
        j = false;
        if (!j) {
        }
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(110920);
        C4990ab.m7416i(this.TAG, "pause, isLocalVideo:" + this.sqC);
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        c35263o.cDc();
        if (this.sqC) {
            this.sqE = true;
            this.klq.pause();
            AppMethodBeat.m2505o(110920);
            return true;
        }
        boolean pause = super.pause();
        AppMethodBeat.m2505o(110920);
        return pause;
    }

    /* JADX WARNING: Missing block: B:16:0x0064, code skipped:
            if (r0.sqP != false) goto L_0x0066;
     */
    /* JADX WARNING: Missing block: B:27:0x00ad, code skipped:
            if (r0 == null) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void abf(String str) {
        AppMethodBeat.m2504i(110921);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("playLocalVideo: ").append(str).append(", isPlayingNow:");
        C14979e c14979e = this.klq;
        C25052j.m39375o(c14979e, "videoView");
        C4990ab.m7416i(str2, append.append(c14979e.isPlaying()).toString());
        if (this.klq == null) {
            this.klq = mo9069cf(getContext());
        }
        reset();
        C14979e c14979e2 = this.klq;
        if (c14979e2 != null) {
            c14979e2.stop();
        }
        C14979e c14979e3 = this.klq;
        if (c14979e3 != null) {
            boolean z;
            if (!this.eif) {
                if (this.sqF) {
                    C35263o c35263o = this.sqG;
                    if (c35263o == null) {
                        C25052j.avw("fakeLayer");
                    }
                }
                z = false;
                c14979e3.setMute(z);
            }
            z = true;
            c14979e3.setMute(z);
        }
        this.bkJ = false;
        this.sqC = true;
        setDownloadStatus(3);
        setNeedShowLoading(false);
        c14979e2 = this.klq;
        if (c14979e2 == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
            AppMethodBeat.m2505o(110921);
            throw c44941v;
        }
        ((StoryVideoPlayTextureView) c14979e2).setNeedResetExtractor(bwE());
        c14979e2 = this.klq;
        C25052j.m39375o(c14979e2, "videoView");
        c14979e2.setVideoPath(str);
        this.fqM = C5046bo.m7588yz();
        this.sqH = 0;
        C22241k c22241k = C22241k.rTc;
        C35201i c35201i = this.rVZ;
        if (c35201i != null) {
            str2 = c35201i.username;
        }
        str2 = "";
        C22241k.aao(str2);
        this.klq.setVideoCallback(new C4167b(this));
        this.sqE = false;
        this.cvF = null;
        AppMethodBeat.m2505o(110921);
    }

    /* renamed from: cV */
    public final void mo9068cV(boolean z) {
        AppMethodBeat.m2504i(110923);
        C4990ab.m7409c(this.TAG, aZk() + " startTimer, isLocalVideo:" + this.sqC, new Object[0]);
        if (!this.sqC) {
            super.mo9068cV(z);
        }
        AppMethodBeat.m2505o(110923);
    }

    public final void stopTimer() {
        AppMethodBeat.m2504i(110924);
        C4990ab.m7409c(this.TAG, aZk() + " stopTimer, isLocalVideo:" + this.sqC, new Object[0]);
        super.stopTimer();
        AppMethodBeat.m2505o(110924);
    }

    public final boolean isLive() {
        AppMethodBeat.m2504i(110925);
        if (this.sqC) {
            AppMethodBeat.m2505o(110925);
            return false;
        }
        boolean isLive = super.isLive();
        AppMethodBeat.m2505o(110925);
        return isLive;
    }

    public final void setNeedShowLoading(boolean z) {
        AppMethodBeat.m2504i(110926);
        C4990ab.m7416i(this.TAG, hashCode() + " setNeedShowLoading: " + z);
        this.sqB = z;
        if (!this.sqB) {
            bJc();
        }
        AppMethodBeat.m2505o(110926);
    }

    public final void aNt() {
        AppMethodBeat.m2504i(110927);
        if (this.sqB) {
            mo35358gR(800);
        }
        AppMethodBeat.m2505o(110927);
    }

    public final void akV() {
        AppMethodBeat.m2504i(110928);
        C4990ab.m7416i(this.TAG, "onUIPause, isLocalVideo:" + this.sqC);
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        c35263o.cDc();
        if (this.sqC) {
            C14979e c14979e = this.klq;
            if (c14979e != null) {
                c14979e.pause();
                AppMethodBeat.m2505o(110928);
                return;
            }
            AppMethodBeat.m2505o(110928);
            return;
        }
        super.akV();
        AppMethodBeat.m2505o(110928);
    }

    public final void akW() {
        AppMethodBeat.m2504i(110929);
        C4990ab.m7416i(this.TAG, "onUIResume, isLocalVideo:" + this.sqC);
        if (isPlaying()) {
            C35263o c35263o = this.sqG;
            if (c35263o == null) {
                C25052j.avw("fakeLayer");
            }
            c35263o.mo55978lW(this.eif);
        }
        if (this.sqC) {
            AppMethodBeat.m2505o(110929);
            return;
        }
        super.akW();
        AppMethodBeat.m2505o(110929);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(110930);
        C4990ab.m7416i(this.TAG, "onUIDestroy, isLocalVideo:" + this.sqC);
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        c35263o.cDd();
        super.aEX();
        AppMethodBeat.m2505o(110930);
    }

    /* renamed from: h */
    public final void mo9075h(String str, int i, int i2) {
        AppMethodBeat.m2504i(110931);
        if (C5046bo.isEqual(this.fUL, str)) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.fUU).append(", playStatus:").append(this.fUP).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
            C14979e c14979e = this.klq;
            C25052j.m39375o(c14979e, "videoView");
            C4990ab.m7411d(str2, append.append(c14979e.isPlaying()).toString(), aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            if ((getCurrPosMs() <= 0 || this.fUP == 1 || this.fUP == 0) && mo44255mm(getCurrPosSec())) {
                mo9068cV(true);
            }
            AppMethodBeat.m2505o(110931);
            return;
        }
        AppMethodBeat.m2505o(110931);
    }

    /* renamed from: dH */
    public final void mo8555dH(int i, int i2) {
        AppMethodBeat.m2504i(110932);
        super.mo8555dH(i, i2);
        C4990ab.m7416i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.sqC + ", isPrepareVideo:" + this.fUX + ", isPrepared:" + this.f14408VN + ", playerStatus:" + this.fUP + ", downloadStatus:" + this.fUO);
        AppMethodBeat.m2505o(110932);
    }

    /* renamed from: ad */
    public final void mo9058ad(String str, int i) {
        AppMethodBeat.m2504i(110933);
        super.mo9058ad(str, i);
        AppMethodBeat.m2505o(110933);
    }

    private final boolean bwE() {
        AppMethodBeat.m2504i(110934);
        if (this.sqC) {
            AppMethodBeat.m2505o(110934);
            return false;
        }
        try {
            boolean z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.m2505o(110934);
            return z;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "check need reset error", new Object[0]);
            AppMethodBeat.m2505o(110934);
            return false;
        }
    }

    /* renamed from: mn */
    public final boolean mo9079mn(int i) {
        AppMethodBeat.m2504i(110935);
        boolean mn = super.mo9079mn(i);
        C4990ab.m7416i(this.TAG, "checkCanPlay, cachePlayTime:" + this.fUV + ", ret:" + mn);
        AppMethodBeat.m2505o(110935);
        return mn;
    }

    /* renamed from: a */
    public final boolean mo9055a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(110936);
        C25052j.m39376p(pInt, "start");
        C25052j.m39376p(pInt2, "end");
        String str = "";
        pInt.value = Math.max(i, this.fUV);
        if (this.fUP == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.fUW;
            str = str + "step1;";
        }
        if (this.fUP == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.fUW) + 8;
            str = str + "step2;";
        }
        if (this.fUP == 3) {
            pInt.value = this.fUV;
            pInt2.value = (i + 1) + this.fVa.fVg;
            str = str + "step3;";
        } else if (this.fUP == 4) {
            pInt.value = this.fUV;
            pInt2.value = ((this.fUW + i) + 1) + this.fVa.fVg;
            str = str + "step4;";
        }
        if (pInt2.value >= this.fUR + 1) {
            pInt2.value = this.fUR + 1;
            str = str + "step5;";
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.fVa.fVg;
            AppMethodBeat.m2505o(110936);
            return false;
        }
        C4990ab.m7417i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", aZk(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW), this.fUL, str);
        AppMethodBeat.m2505o(110936);
        return true;
    }

    public final void start() {
        AppMethodBeat.m2504i(110937);
        if (this.bqQ > 0 && !this.sqC) {
            C4990ab.m7416i(this.TAG, "start from onError and not local video");
            C35201i c35201i = this.rVZ;
            if (c35201i != null) {
                C43649s c43649s = C43649s.rTV;
                C29298n a = C43649s.m78153a(c35201i);
                if (a.mo47507Jo()) {
                    C4990ab.m7416i(this.TAG, "start from onError and download finish now");
                    String str = a.field_filePath;
                    C25052j.m39375o(str, "videoCache.field_filePath");
                    abf(str);
                    AppMethodBeat.m2505o(110937);
                    return;
                }
            }
        }
        super.start();
        AppMethodBeat.m2505o(110937);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x00fd, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:28:0x00fe, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace(r14.TAG, r0, "stop error", new java.lang.Object[0]);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(110938);
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void stop() {
        long j = 1;
        AppMethodBeat.m2504i(110938);
        C35263o c35263o = this.sqG;
        if (c35263o == null) {
            C25052j.avw("fakeLayer");
        }
        c35263o.cDd();
        if (this.sqC) {
            C9505bm c9505bm = new C9505bm();
            C35201i c35201i = this.rVZ;
            C9505bm gf = c9505bm.mo20787gf(String.valueOf(c35201i != null ? Long.valueOf(c35201i.rUJ) : null));
            C22212h c22212h = C22212h.scu;
            gf = gf.mo20776dl(C22212h.cAs().mo20732FF());
            c22212h = C22212h.scu;
            if (C22212h.cAs().mo20737FK() != 1) {
                j = 0;
            }
            C9505bm GV = gf.mo20778dn(j).mo20781dq(this.sqH).mo20782dr((long) getStayTime()).mo20783ds((long) getErrorCode()).mo20774GV();
            C22212h c22212h2 = C22212h.scu;
            GV = GV.mo20785du(C22212h.cAs().mo20731FE());
            c22212h2 = C22212h.scu;
            GV.mo20786dv(C22212h.cAs().mo20734FH()).mo20780dp((long) getCurrPosMs());
            C4990ab.m7411d(this.TAG, "time distance %d", Long.valueOf(System.currentTimeMillis() - c9505bm.mo20775GW()));
            if (System.currentTimeMillis() - c9505bm.mo20775GW() >= 500) {
                C35201i c35201i2 = this.rVZ;
                if (c35201i2 != null) {
                    j = c35201i2.rUJ;
                } else {
                    j = 0;
                }
                try {
                    C4133a c4133a = C43644j.rST;
                    C4133a.cno().post(new C4171c(this, c9505bm, j));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(this.TAG, e, "reportStopLocalVideo", new Object[0]);
                    c9505bm.ajK();
                }
            }
            this.klq.stop();
            reset();
            AppMethodBeat.m2505o(110938);
            return;
        }
        super.stop();
        AppMethodBeat.m2505o(110938);
    }

    /* renamed from: c */
    public final void mo9063c(boolean z, String str, int i) {
        AppMethodBeat.m2504i(139115);
        super.mo9063c(z, str, i);
        AppMethodBeat.m2505o(139115);
    }

    public final void bQL() {
        AppMethodBeat.m2504i(110940);
        super.bQL();
        C14979e c14979e = this.klq;
        if (c14979e == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.m2505o(110940);
            throw c44941v;
        }
        ((View) c14979e).setAlpha(1.0f);
        this.sqH = C5046bo.m7525az(this.fqM);
        AppMethodBeat.m2505o(110940);
    }

    public final int cCZ() {
        return this.vgG.rlG > this.vgG.startTimeStamp ? (int) (this.vgG.rlG - this.vgG.startTimeStamp) : 0;
    }

    public final int cDa() {
        return this.vgG.blockCount;
    }

    public final int getStayTime() {
        AppMethodBeat.m2504i(110941);
        int az = (int) C5046bo.m7525az(this.fqM);
        AppMethodBeat.m2505o(110941);
        return az;
    }

    public final int getErrorCode() {
        return this.vgG.viH;
    }

    public final String getFilePath() {
        AppMethodBeat.m2504i(110942);
        String str = this.fUM;
        C25052j.m39375o(str, "filepath");
        AppMethodBeat.m2505o(110942);
        return str;
    }

    public final void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(110943);
        super.setScaleType(c35873d);
        AppMethodBeat.m2505o(110943);
    }

    /* renamed from: cf */
    public final C14979e mo9069cf(Context context) {
        AppMethodBeat.m2504i(110944);
        StoryVideoPlayTextureView storyVideoPlayTextureView = new StoryVideoPlayTextureView(context);
        storyVideoPlayTextureView.setOpenWithNoneSurface(true);
        storyVideoPlayTextureView.setNeedResetExtractor(bwE());
        storyVideoPlayTextureView.setIsOnlineVideoType(true);
        C14979e c14979e = storyVideoPlayTextureView;
        AppMethodBeat.m2505o(110944);
        return c14979e;
    }

    public final void akY() {
        AppMethodBeat.m2504i(110945);
        super.akY();
        C4990ab.m7416i(this.TAG, "onSurfaceAvailable");
        this.sqD = true;
        AppMethodBeat.m2505o(110945);
    }

    public final void akU() {
        C44941v c44941v;
        AppMethodBeat.m2504i(110946);
        C4990ab.m7416i(this.TAG, "prepareVideo, surfaceAvailable:" + this.sqD);
        if (this.klq != null) {
            C14979e c14979e = this.klq;
            if (c14979e == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
                AppMethodBeat.m2505o(110946);
                throw c44941v;
            }
            ((StoryVideoPlayTextureView) c14979e).setNeedResetExtractor(bwE());
        }
        super.akU();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj = RP.mo5239Ry().get(C5127a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.m2505o(110946);
            throw c44941v;
        }
        if (((Integer) obj).intValue() == 1) {
            TextView textView = this.mqf;
            if (textView != null) {
                textView.setText(C21846d.m33384RK(this.fUM));
            }
            TextView textView2 = this.mqf;
            if (textView2 != null) {
                textView2.setVisibility(0);
                AppMethodBeat.m2505o(110946);
                return;
            }
        }
        AppMethodBeat.m2505o(110946);
    }

    public final void reset() {
        AppMethodBeat.m2504i(110947);
        super.reset();
        this.sqD = false;
        this.cvF = null;
        AppMethodBeat.m2505o(110947);
    }

    /* renamed from: cU */
    public final void mo9067cU(boolean z) {
        AppMethodBeat.m2504i(110922);
        if (this.sqC) {
            AppMethodBeat.m2505o(110922);
            return;
        }
        super.mo9067cU(z);
        AppMethodBeat.m2505o(110922);
    }

    public final int cDb() {
        if (this.vgG.blockCount > 0) {
            return (int) (this.vgG.viG / ((long) this.vgG.blockCount));
        }
        return 0;
    }

    /* renamed from: d */
    public static final /* synthetic */ long m6498d(StoryVideoView storyVideoView) {
        C35201i c35201i = storyVideoView.rVZ;
        if (c35201i != null) {
            cee cee = c35201i.rWl;
            if (cee != null) {
                return cee.startTime;
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static final /* synthetic */ long m6499e(StoryVideoView storyVideoView) {
        C35201i c35201i = storyVideoView.rVZ;
        if (c35201i != null) {
            cee cee = c35201i.rWl;
            if (cee != null) {
                return cee.endTime;
            }
        }
        return 0;
    }
}
