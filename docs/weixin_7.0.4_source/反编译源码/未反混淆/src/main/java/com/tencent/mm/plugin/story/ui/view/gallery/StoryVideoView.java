package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import a.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 b2\u00020\u0001:\u0001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J \u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0014J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\rH\u0002J\u0006\u0010/\u001a\u00020 J\u0006\u00100\u001a\u00020\tJ\b\u00101\u001a\u00020\tH\u0016J\u0006\u00102\u001a\u00020 J\b\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020 J\b\u00108\u001a\u000204H\u0016J\u001a\u00109\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020 H\u0016J\u0018\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020 H\u0016J\"\u0010?\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\u0010\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u0013H\u0016J\b\u0010D\u001a\u000204H\u0016J\b\u0010E\u001a\u000204H\u0016J\b\u0010F\u001a\u000204H\u0016J\b\u0010G\u001a\u000204H\u0016J\b\u0010H\u001a\u000204H\u0016J\b\u0010I\u001a\u00020\u0013H\u0016J\u0018\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020\tH\u0002J\b\u0010N\u001a\u000204H\u0014J\b\u0010O\u001a\u000204H\u0002J\b\u0010P\u001a\u000204H\u0016J\u0012\u0010Q\u001a\u0002042\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\u0013H\u0016J\u000e\u0010U\u001a\u0002042\u0006\u0010V\u001a\u00020\u0013J\u0012\u0010W\u001a\u0002042\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\"\u0010Z\u001a\u0002042\u0006\u00105\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010\t2\u0006\u0010\\\u001a\u00020 H\u0016J\b\u0010]\u001a\u000204H\u0014J\b\u0010$\u001a\u000204H\u0016J\u0010\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020\u0013H\u0014J\b\u0010`\u001a\u000204H\u0016J\b\u0010a\u001a\u000204H\u0014R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeLayer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView extends MMVideoView {
    public static final a sqI = new a();
    private String cvF;
    private boolean eif;
    private long fqM;
    private TextView mqf;
    private i rVZ;
    private final String sqA;
    private boolean sqB;
    boolean sqC;
    private boolean sqD;
    private boolean sqE;
    private boolean sqF;
    private o sqG;
    private long sqH;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
    public static final class b implements com.tencent.mm.pluginsdk.ui.tools.e.a {
        final /* synthetic */ StoryVideoView sqJ;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTextureUpdate"})
        static final class a implements e {
            final /* synthetic */ b sqK;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView$b$a$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ a sqL;

                AnonymousClass1(a aVar) {
                    this.sqL = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(110908);
                    ab.i(this.sqL.sqK.sqJ.TAG, "onTextureUpdate");
                    if (this.sqL.sqK.sqJ.klq == null) {
                        AppMethodBeat.o(110908);
                        return;
                    }
                    StoryVideoView.h(this.sqL.sqK.sqJ);
                    com.tencent.mm.pluginsdk.ui.tools.e f = this.sqL.sqK.sqJ.klq;
                    if (f == null) {
                        v vVar = new v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(110908);
                        throw vVar;
                    }
                    ((View) f).setAlpha(1.0f);
                    AppMethodBeat.o(110908);
                }
            }

            a(b bVar) {
                this.sqK = bVar;
            }

            public final void bQL() {
                AppMethodBeat.i(110909);
                this.sqK.sqJ.setFirstPlayWaitTime(bo.az(this.sqK.sqJ.fqM));
                al.n(new AnonymousClass1(this), 50);
                AppMethodBeat.o(110909);
            }
        }

        b(StoryVideoView storyVideoView) {
            this.sqJ = storyVideoView;
        }

        public final void pL() {
            AppMethodBeat.i(110910);
            String a = this.sqJ.TAG;
            StringBuilder append = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(this.sqJ.sqE).append(", isFakeVideo:");
            i c = this.sqJ.rVZ;
            ab.i(a, append.append(c != null ? Boolean.valueOf(c.cze()) : null).append(", fakeStartTime:").append(StoryVideoView.d(this.sqJ)).append(", fakeEndTime:").append(StoryVideoView.e(this.sqJ)).toString());
            if (!this.sqJ.sqE) {
                c = this.sqJ.rVZ;
                if (c == null || !c.cze() || StoryVideoView.d(this.sqJ) <= 0) {
                    this.sqJ.klq.start();
                } else {
                    this.sqJ.klq.d((double) StoryVideoView.d(this.sqJ), true);
                }
                this.sqJ.klq.setOneTimeVideoTextureUpdateCallback(new a(this));
            }
            AppMethodBeat.o(110910);
        }

        public final void EA() {
            AppMethodBeat.i(110911);
            String a = this.sqJ.TAG;
            StringBuilder stringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
            i c = this.sqJ.rVZ;
            ab.i(a, stringBuilder.append(c != null ? Boolean.valueOf(c.cze()) : null).append(", fakeStartTime:").append(StoryVideoView.d(this.sqJ)).toString());
            c = this.sqJ.rVZ;
            if (c == null || !c.cze() || StoryVideoView.d(this.sqJ) <= 0) {
                this.sqJ.klq.d(0.0d, true);
            } else {
                this.sqJ.klq.d((double) StoryVideoView.d(this.sqJ), true);
            }
            com.tencent.mm.pluginsdk.ui.h.b i = this.sqJ.rcd;
            if (i != null) {
                i.cq(this.sqJ.getSessionId(), StoryVideoView.j(this.sqJ));
                AppMethodBeat.o(110911);
                return;
            }
            AppMethodBeat.o(110911);
        }

        public final int dG(int i, int i2) {
            AppMethodBeat.i(110912);
            i c = this.sqJ.rVZ;
            if (c != null && c.cze() && StoryVideoView.e(this.sqJ) > 0 && ((long) i) >= StoryVideoView.e(this.sqJ)) {
                ab.i(this.sqJ.TAG, "fakeVideo exceed endTime, playTime:" + i + ", fakeEndTime:" + StoryVideoView.e(this.sqJ) + ", fakeStartTime:" + StoryVideoView.d(this.sqJ));
                if (StoryVideoView.d(this.sqJ) > 0) {
                    this.sqJ.klq.d((double) StoryVideoView.d(this.sqJ), true);
                } else {
                    this.sqJ.klq.d(0.0d, true);
                }
            }
            AppMethodBeat.o(110912);
            return 0;
        }

        public final void dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$Companion;", "", "()V", "PRELOAD_CACHE", "", "PRELOAD_CACHE_GOOD_NETWORK", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ long rVy;
        final /* synthetic */ StoryVideoView sqJ;
        final /* synthetic */ bm sqM;

        c(StoryVideoView storyVideoView, bm bmVar, long j) {
            this.sqJ = storyVideoView;
            this.sqM = bmVar;
            this.rVy = j;
        }

        public final void run() {
            AppMethodBeat.i(110913);
            ab.i(this.sqJ.TAG, "reportStopLocalVideo");
            com.tencent.mm.plugin.sight.base.a WR = d.WR(this.sqJ.fUM);
            if (WR != null) {
                bm bmVar = this.sqM.m7do((long) WR.eWK);
                com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
                bmVar.dm((long) com.tencent.mm.plugin.story.model.j.a.cxT().ly(this.rVy)).dt((long) WR.videoBitrate).ajK();
            }
            AppMethodBeat.o(110913);
        }
    }

    static {
        AppMethodBeat.i(110950);
        AppMethodBeat.o(110950);
    }

    public StoryVideoView(Context context, AttributeSet attributeSet) {
        a.f.b.j.p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.i(110948);
        this.sqA = "MicroMsg.StoryVideoView";
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        setRootPath(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath());
        diM();
        setIsShowBasicControls(false);
        LinearLayout linearLayout = this.vgm;
        a.f.b.j.o(linearLayout, "footerRoot");
        linearLayout.setVisibility(8);
        this.TAG = this.sqA;
        this.sqB = true;
        AppMethodBeat.o(110948);
    }

    public static final /* synthetic */ void h(StoryVideoView storyVideoView) {
        AppMethodBeat.i(110951);
        storyVideoView.bJc();
        AppMethodBeat.o(110951);
    }

    public static final /* synthetic */ String j(StoryVideoView storyVideoView) {
        AppMethodBeat.i(110952);
        String mediaId = storyVideoView.getMediaId();
        AppMethodBeat.o(110952);
        return mediaId;
    }

    public StoryVideoView(Context context) {
        a.f.b.j.p(context, "context");
        this(context, null);
        AppMethodBeat.i(110949);
        AppMethodBeat.o(110949);
    }

    public final long getFirstPlayWaitTime() {
        return this.sqH;
    }

    public final void setFirstPlayWaitTime(long j) {
        this.sqH = j;
    }

    public final void initView() {
        AppMethodBeat.i(110914);
        super.initView();
        Context context = getContext();
        a.f.b.j.o(context, "context");
        this.sqG = new o(context);
        RelativeLayout relativeLayout = this.vgl;
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        relativeLayout.addView(oVar, new LayoutParams(-1, -1));
        this.mqf = (TextView) findViewById(R.id.af2);
        AppMethodBeat.o(110914);
    }

    public final void a(i iVar, String str) {
        AppMethodBeat.i(110915);
        a.f.b.j.p(iVar, "item");
        TextView textView = this.mqf;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.rVZ = iVar;
        cek cek = iVar.rWj;
        int i = iVar.fDG;
        this.sqF = false;
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        oVar.setVisibility(8);
        if (iVar.czf()) {
            String str2;
            if (iVar.cze()) {
                this.sqF = true;
                ab.i(this.TAG, "LogStory: play fake video");
                oVar = this.sqG;
                if (oVar == null) {
                    a.f.b.j.avw("fakeLayer");
                }
                oVar.setVisibility(0);
                cee cee = iVar.rWl;
                if (cee != null) {
                    o oVar2 = this.sqG;
                    if (oVar2 == null) {
                        a.f.b.j.avw("fakeLayer");
                    }
                    oVar2.setFakeVideoInfo(cee);
                    oVar2 = this.sqG;
                    if (oVar2 == null) {
                        a.f.b.j.avw("fakeLayer");
                    }
                    oVar2.lW(this.eif);
                    this.fUM = cee.videoPath;
                    this.fUL = "";
                    str2 = this.fUM;
                    a.f.b.j.o(str2, "filepath");
                    abf(str2);
                }
            } else {
                ab.i(this.TAG, "LogStory: play normal video");
                s sVar = s.rTV;
                str2 = s.a(cek);
                if (com.tencent.mm.vfs.e.asZ(str2) > 0) {
                    ab.i(this.TAG, "play " + str2 + " downloadDone now can play " + cek.Id);
                    this.fUM = str2;
                    if (str2 != null) {
                        abf(str2);
                    }
                } else {
                    com.tencent.mm.plugin.story.model.j.a aVar;
                    s sVar2 = s.rTV;
                    n a = s.a(iVar);
                    int asZ = (int) com.tencent.mm.vfs.e.asZ(a.field_filePath);
                    ab.i(this.TAG, "play " + str2 + " error try play from url or videoCache " + cek.Id + " fileLength:" + asZ + " cacheSize:" + a.field_cacheSize);
                    if (asZ < a.field_cacheSize) {
                        a.field_cacheSize = asZ;
                        aVar = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxX().b(a);
                    }
                    ab.i(this.TAG, String.valueOf(a));
                    if (a.Jo() && com.tencent.mm.vfs.e.ct(a.field_filePath)) {
                        ab.i(this.TAG, "play " + cek.Id + " download finish");
                        this.fUM = a.field_filePath;
                        sVar = s.rTV;
                        this.fUL = s.be(i, cek.Url);
                        str2 = this.fUM;
                        a.f.b.j.o(str2, "filepath");
                        abf(str2);
                    } else {
                        if (a.Jo() && !com.tencent.mm.vfs.e.ct(a.field_filePath)) {
                            ab.i(this.TAG, "error downloadFinish " + a.Jo() + " ret:" + com.tencent.mm.vfs.e.ct(a.field_filePath));
                            a.cCe();
                            aVar = j.rST;
                            com.tencent.mm.plugin.story.model.j.a.cxX().b(a);
                        }
                        ab.i(this.TAG, "play " + cek.Id + ' ' + str + " start online play " + a.field_filePath);
                        reset();
                        this.klq.stop();
                        this.klq.setVideoCallback(this);
                        this.sqC = false;
                        this.vgu = true;
                        setNeedShowLoading(true);
                        super.c(false, iVar.rWj.Url, (int) cek.duration);
                        this.fUM = a.field_filePath;
                        sVar = s.rTV;
                        this.fUL = s.be(i, cek.Url);
                        this.cvF = str;
                        this.fqM = bo.yz();
                        this.sqH = 0;
                        start();
                    }
                }
            }
            setLoop(true);
            com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
            if (eVar == null) {
                v vVar = new v("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(110915);
                throw vVar;
            }
            ((View) eVar).setAlpha(0.0f);
            AppMethodBeat.o(110915);
            return;
        }
        ab.i(this.TAG, "play empty item");
        aNt();
        AppMethodBeat.o(110915);
    }

    public final void EA() {
        AppMethodBeat.i(110916);
        ab.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.fUP + ", downloadStatus:" + this.fUO);
        if (getCurrPosMs() <= 0) {
            AppMethodBeat.o(110916);
            return;
        }
        com.tencent.mm.pluginsdk.ui.h.b bVar = this.rcd;
        if (bVar != null) {
            bVar.cq(getSessionId(), getMediaId());
        }
        super.EA();
        AppMethodBeat.o(110916);
    }

    public final String getSessionId() {
        AppMethodBeat.i(110917);
        String nullAsNil = bo.nullAsNil(this.cvF);
        a.f.b.j.o(nullAsNil, "Util.nullAsNil(sessionId)");
        AppMethodBeat.o(110917);
        return nullAsNil;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(110918);
        super.setMute(z);
        this.eif = z;
        if (this.klq != null) {
            this.klq.setMute(z);
        }
        AppMethodBeat.o(110918);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(i iVar) {
        boolean j;
        Object obj = null;
        AppMethodBeat.i(110919);
        ab.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.VN + ", sessionId:" + this.cvF + ", isLocalVideo:" + this.sqC);
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        oVar.lW(this.eif);
        if (getCurrPosSec() >= getVideoDurationSec()) {
            ab.i(this.TAG, "resume, restart video");
            if (iVar != null) {
                a(iVar, this.cvF);
                AppMethodBeat.o(110919);
                return;
            }
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.sqC).append(", currentPosition:");
        com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
        ab.i(str, append.append(eVar != null ? Integer.valueOf(eVar.getCurrentPosition()) : null).toString());
        if (this.sqC) {
            int currentPosition;
            eVar = this.klq;
            if (eVar != null) {
                currentPosition = eVar.getCurrentPosition();
            } else {
                currentPosition = 0;
            }
            if (currentPosition > 0) {
                eVar = this.klq;
                if (eVar != null) {
                    obj = Boolean.valueOf(eVar.start());
                }
                this.sqE = false;
                j = a.f.b.j.j(obj, Boolean.TRUE);
                if (!j) {
                    AppMethodBeat.o(110919);
                    return;
                } else if (getCurrPosMs() <= 0 || this.sqC) {
                    if (iVar != null) {
                        a(iVar, this.cvF);
                    }
                    AppMethodBeat.o(110919);
                    return;
                } else if (this.VN) {
                    super.play();
                    AppMethodBeat.o(110919);
                    return;
                } else {
                    this.vgu = true;
                    akU();
                    AppMethodBeat.o(110919);
                    return;
                }
            }
        }
        j = false;
        if (!j) {
        }
    }

    public final boolean pause() {
        AppMethodBeat.i(110920);
        ab.i(this.TAG, "pause, isLocalVideo:" + this.sqC);
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        oVar.cDc();
        if (this.sqC) {
            this.sqE = true;
            this.klq.pause();
            AppMethodBeat.o(110920);
            return true;
        }
        boolean pause = super.pause();
        AppMethodBeat.o(110920);
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
        AppMethodBeat.i(110921);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("playLocalVideo: ").append(str).append(", isPlayingNow:");
        com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
        a.f.b.j.o(eVar, "videoView");
        ab.i(str2, append.append(eVar.isPlaying()).toString());
        if (this.klq == null) {
            this.klq = cf(getContext());
        }
        reset();
        com.tencent.mm.pluginsdk.ui.tools.e eVar2 = this.klq;
        if (eVar2 != null) {
            eVar2.stop();
        }
        com.tencent.mm.pluginsdk.ui.tools.e eVar3 = this.klq;
        if (eVar3 != null) {
            boolean z;
            if (!this.eif) {
                if (this.sqF) {
                    o oVar = this.sqG;
                    if (oVar == null) {
                        a.f.b.j.avw("fakeLayer");
                    }
                }
                z = false;
                eVar3.setMute(z);
            }
            z = true;
            eVar3.setMute(z);
        }
        this.bkJ = false;
        this.sqC = true;
        setDownloadStatus(3);
        setNeedShowLoading(false);
        eVar2 = this.klq;
        if (eVar2 == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
            AppMethodBeat.o(110921);
            throw vVar;
        }
        ((StoryVideoPlayTextureView) eVar2).setNeedResetExtractor(bwE());
        eVar2 = this.klq;
        a.f.b.j.o(eVar2, "videoView");
        eVar2.setVideoPath(str);
        this.fqM = bo.yz();
        this.sqH = 0;
        k kVar = k.rTc;
        i iVar = this.rVZ;
        if (iVar != null) {
            str2 = iVar.username;
        }
        str2 = "";
        k.aao(str2);
        this.klq.setVideoCallback(new b(this));
        this.sqE = false;
        this.cvF = null;
        AppMethodBeat.o(110921);
    }

    public final void cV(boolean z) {
        AppMethodBeat.i(110923);
        ab.c(this.TAG, aZk() + " startTimer, isLocalVideo:" + this.sqC, new Object[0]);
        if (!this.sqC) {
            super.cV(z);
        }
        AppMethodBeat.o(110923);
    }

    public final void stopTimer() {
        AppMethodBeat.i(110924);
        ab.c(this.TAG, aZk() + " stopTimer, isLocalVideo:" + this.sqC, new Object[0]);
        super.stopTimer();
        AppMethodBeat.o(110924);
    }

    public final boolean isLive() {
        AppMethodBeat.i(110925);
        if (this.sqC) {
            AppMethodBeat.o(110925);
            return false;
        }
        boolean isLive = super.isLive();
        AppMethodBeat.o(110925);
        return isLive;
    }

    public final void setNeedShowLoading(boolean z) {
        AppMethodBeat.i(110926);
        ab.i(this.TAG, hashCode() + " setNeedShowLoading: " + z);
        this.sqB = z;
        if (!this.sqB) {
            bJc();
        }
        AppMethodBeat.o(110926);
    }

    public final void aNt() {
        AppMethodBeat.i(110927);
        if (this.sqB) {
            gR(800);
        }
        AppMethodBeat.o(110927);
    }

    public final void akV() {
        AppMethodBeat.i(110928);
        ab.i(this.TAG, "onUIPause, isLocalVideo:" + this.sqC);
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        oVar.cDc();
        if (this.sqC) {
            com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
            if (eVar != null) {
                eVar.pause();
                AppMethodBeat.o(110928);
                return;
            }
            AppMethodBeat.o(110928);
            return;
        }
        super.akV();
        AppMethodBeat.o(110928);
    }

    public final void akW() {
        AppMethodBeat.i(110929);
        ab.i(this.TAG, "onUIResume, isLocalVideo:" + this.sqC);
        if (isPlaying()) {
            o oVar = this.sqG;
            if (oVar == null) {
                a.f.b.j.avw("fakeLayer");
            }
            oVar.lW(this.eif);
        }
        if (this.sqC) {
            AppMethodBeat.o(110929);
            return;
        }
        super.akW();
        AppMethodBeat.o(110929);
    }

    public final void aEX() {
        AppMethodBeat.i(110930);
        ab.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.sqC);
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        oVar.cDd();
        super.aEX();
        AppMethodBeat.o(110930);
    }

    public final void h(String str, int i, int i2) {
        AppMethodBeat.i(110931);
        if (bo.isEqual(this.fUL, str)) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.fUU).append(", playStatus:").append(this.fUP).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
            com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
            a.f.b.j.o(eVar, "videoView");
            ab.d(str2, append.append(eVar.isPlaying()).toString(), aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            if ((getCurrPosMs() <= 0 || this.fUP == 1 || this.fUP == 0) && mm(getCurrPosSec())) {
                cV(true);
            }
            AppMethodBeat.o(110931);
            return;
        }
        AppMethodBeat.o(110931);
    }

    public final void dH(int i, int i2) {
        AppMethodBeat.i(110932);
        super.dH(i, i2);
        ab.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.sqC + ", isPrepareVideo:" + this.fUX + ", isPrepared:" + this.VN + ", playerStatus:" + this.fUP + ", downloadStatus:" + this.fUO);
        AppMethodBeat.o(110932);
    }

    public final void ad(String str, int i) {
        AppMethodBeat.i(110933);
        super.ad(str, i);
        AppMethodBeat.o(110933);
    }

    private final boolean bwE() {
        AppMethodBeat.i(110934);
        if (this.sqC) {
            AppMethodBeat.o(110934);
            return false;
        }
        try {
            boolean z = g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.o(110934);
            return z;
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "check need reset error", new Object[0]);
            AppMethodBeat.o(110934);
            return false;
        }
    }

    public final boolean mn(int i) {
        AppMethodBeat.i(110935);
        boolean mn = super.mn(i);
        ab.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.fUV + ", ret:" + mn);
        AppMethodBeat.o(110935);
        return mn;
    }

    public final boolean a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(110936);
        a.f.b.j.p(pInt, "start");
        a.f.b.j.p(pInt2, "end");
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
            AppMethodBeat.o(110936);
            return false;
        }
        ab.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", aZk(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW), this.fUL, str);
        AppMethodBeat.o(110936);
        return true;
    }

    public final void start() {
        AppMethodBeat.i(110937);
        if (this.bqQ > 0 && !this.sqC) {
            ab.i(this.TAG, "start from onError and not local video");
            i iVar = this.rVZ;
            if (iVar != null) {
                s sVar = s.rTV;
                n a = s.a(iVar);
                if (a.Jo()) {
                    ab.i(this.TAG, "start from onError and download finish now");
                    String str = a.field_filePath;
                    a.f.b.j.o(str, "videoCache.field_filePath");
                    abf(str);
                    AppMethodBeat.o(110937);
                    return;
                }
            }
        }
        super.start();
        AppMethodBeat.o(110937);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x00fd, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:28:0x00fe, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace(r14.TAG, r0, "stop error", new java.lang.Object[0]);
            com.tencent.matrix.trace.core.AppMethodBeat.o(110938);
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void stop() {
        long j = 1;
        AppMethodBeat.i(110938);
        o oVar = this.sqG;
        if (oVar == null) {
            a.f.b.j.avw("fakeLayer");
        }
        oVar.cDd();
        if (this.sqC) {
            bm bmVar = new bm();
            i iVar = this.rVZ;
            bm gf = bmVar.gf(String.valueOf(iVar != null ? Long.valueOf(iVar.rUJ) : null));
            h hVar = h.scu;
            gf = gf.dl(h.cAs().FF());
            hVar = h.scu;
            if (h.cAs().FK() != 1) {
                j = 0;
            }
            bm GV = gf.dn(j).dq(this.sqH).dr((long) getStayTime()).ds((long) getErrorCode()).GV();
            h hVar2 = h.scu;
            GV = GV.du(h.cAs().FE());
            hVar2 = h.scu;
            GV.dv(h.cAs().FH()).dp((long) getCurrPosMs());
            ab.d(this.TAG, "time distance %d", Long.valueOf(System.currentTimeMillis() - bmVar.GW()));
            if (System.currentTimeMillis() - bmVar.GW() >= 500) {
                i iVar2 = this.rVZ;
                if (iVar2 != null) {
                    j = iVar2.rUJ;
                } else {
                    j = 0;
                }
                try {
                    com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cno().post(new c(this, bmVar, j));
                } catch (Exception e) {
                    ab.printErrStackTrace(this.TAG, e, "reportStopLocalVideo", new Object[0]);
                    bmVar.ajK();
                }
            }
            this.klq.stop();
            reset();
            AppMethodBeat.o(110938);
            return;
        }
        super.stop();
        AppMethodBeat.o(110938);
    }

    public final void c(boolean z, String str, int i) {
        AppMethodBeat.i(139115);
        super.c(z, str, i);
        AppMethodBeat.o(139115);
    }

    public final void bQL() {
        AppMethodBeat.i(110940);
        super.bQL();
        com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
        if (eVar == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(110940);
            throw vVar;
        }
        ((View) eVar).setAlpha(1.0f);
        this.sqH = bo.az(this.fqM);
        AppMethodBeat.o(110940);
    }

    public final int cCZ() {
        return this.vgG.rlG > this.vgG.startTimeStamp ? (int) (this.vgG.rlG - this.vgG.startTimeStamp) : 0;
    }

    public final int cDa() {
        return this.vgG.blockCount;
    }

    public final int getStayTime() {
        AppMethodBeat.i(110941);
        int az = (int) bo.az(this.fqM);
        AppMethodBeat.o(110941);
        return az;
    }

    public final int getErrorCode() {
        return this.vgG.viH;
    }

    public final String getFilePath() {
        AppMethodBeat.i(110942);
        String str = this.fUM;
        a.f.b.j.o(str, "filepath");
        AppMethodBeat.o(110942);
        return str;
    }

    public final void setScaleType(com.tencent.mm.pluginsdk.ui.h.d dVar) {
        AppMethodBeat.i(110943);
        super.setScaleType(dVar);
        AppMethodBeat.o(110943);
    }

    public final com.tencent.mm.pluginsdk.ui.tools.e cf(Context context) {
        AppMethodBeat.i(110944);
        StoryVideoPlayTextureView storyVideoPlayTextureView = new StoryVideoPlayTextureView(context);
        storyVideoPlayTextureView.setOpenWithNoneSurface(true);
        storyVideoPlayTextureView.setNeedResetExtractor(bwE());
        storyVideoPlayTextureView.setIsOnlineVideoType(true);
        com.tencent.mm.pluginsdk.ui.tools.e eVar = storyVideoPlayTextureView;
        AppMethodBeat.o(110944);
        return eVar;
    }

    public final void akY() {
        AppMethodBeat.i(110945);
        super.akY();
        ab.i(this.TAG, "onSurfaceAvailable");
        this.sqD = true;
        AppMethodBeat.o(110945);
    }

    public final void akU() {
        v vVar;
        AppMethodBeat.i(110946);
        ab.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.sqD);
        if (this.klq != null) {
            com.tencent.mm.pluginsdk.ui.tools.e eVar = this.klq;
            if (eVar == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
                AppMethodBeat.o(110946);
                throw vVar;
            }
            ((StoryVideoPlayTextureView) eVar).setNeedResetExtractor(bwE());
        }
        super.akU();
        com.tencent.mm.kernel.e RP = g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        Object obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0));
        if (obj == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(110946);
            throw vVar;
        }
        if (((Integer) obj).intValue() == 1) {
            TextView textView = this.mqf;
            if (textView != null) {
                textView.setText(d.RK(this.fUM));
            }
            TextView textView2 = this.mqf;
            if (textView2 != null) {
                textView2.setVisibility(0);
                AppMethodBeat.o(110946);
                return;
            }
        }
        AppMethodBeat.o(110946);
    }

    public final void reset() {
        AppMethodBeat.i(110947);
        super.reset();
        this.sqD = false;
        this.cvF = null;
        AppMethodBeat.o(110947);
    }

    public final void cU(boolean z) {
        AppMethodBeat.i(110922);
        if (this.sqC) {
            AppMethodBeat.o(110922);
            return;
        }
        super.cU(z);
        AppMethodBeat.o(110922);
    }

    public final int cDb() {
        if (this.vgG.blockCount > 0) {
            return (int) (this.vgG.viG / ((long) this.vgG.blockCount));
        }
        return 0;
    }

    public static final /* synthetic */ long d(StoryVideoView storyVideoView) {
        i iVar = storyVideoView.rVZ;
        if (iVar != null) {
            cee cee = iVar.rWl;
            if (cee != null) {
                return cee.startTime;
            }
        }
        return 0;
    }

    public static final /* synthetic */ long e(StoryVideoView storyVideoView) {
        i iVar = storyVideoView.rVZ;
        if (iVar != null) {
            cee cee = iVar.rWl;
            if (cee != null) {
                return cee.endTime;
            }
        }
        return 0;
    }
}
