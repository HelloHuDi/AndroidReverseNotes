package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9715b;
import com.tencent.p177mm.modelvideo.C9715b.C9714a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p230g.p231a.C32594lp;
import com.tencent.p177mm.p230g.p231a.C32594lp.C9414a;
import com.tencent.p177mm.p230g.p232b.p233a.C32662an;
import com.tencent.p177mm.p230g.p232b.p233a.C9502ar;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C44686h.C26326a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C35180c;
import com.tencent.p177mm.plugin.story.p531g.C4116b;
import com.tencent.p177mm.plugin.story.p531g.C4116b.C4117a;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C39933n.C13892b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Arrays;
import java.util.UUID;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0002\u0013\u001c\u0018\u00002\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\nJ\u001c\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010(\u001a\u00020\rH\u0002J\u0006\u0010)\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\r2\u0006\u0010%\u001a\u00020\nJ\b\u0010+\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020\nH\u0002J\u0006\u00100\u001a\u00020\u001fJ\u0006\u00101\u001a\u00020\u001fJ\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u001fJ\u0012\u00107\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010!H\u0002J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\rJ\b\u0010;\u001a\u00020\u001fH\u0002J\u0006\u0010<\u001a\u00020\u001fJ\u001a\u0010=\u001a\u00020\u001f2\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p */
public final class C22319p {
    final String TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    private boolean eif;
    StoryVideoView sqW;
    C22320b sqX;
    boolean sqY;
    String sqZ;
    private boolean sra;
    C35201i srb;
    private boolean srd;
    private C45293b sre = new C45293b(C4996ah.getContext());
    private boolean srf;
    final long srg = 987;
    int srh;
    private final C7159d sri = new C7159d(this);
    private final C13894e srj;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$d */
    public static final class C7159d extends C4884c<C32594lp> {
        final /* synthetic */ C22319p srl;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$d$a */
        static final class C7160a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C7159d srs;
            final /* synthetic */ C32594lp srt;

            C7160a(C7159d c7159d, C32594lp c32594lp) {
                this.srs = c7159d;
                this.srt = c32594lp;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                int i;
                cek cek;
                String str = null;
                AppMethodBeat.m2504i(110977);
                C35201i c35201i = this.srs.srl.srb;
                if (c35201i != null) {
                    i = c35201i.fDG;
                } else {
                    i = 0;
                }
                C35201i c35201i2 = this.srs.srl.srb;
                if (c35201i2 != null) {
                    cek = c35201i2.rWj;
                } else {
                    cek = null;
                }
                if (i > 0 && cek != null) {
                    String str2 = this.srt.cHq.cHr;
                    C43649s c43649s = C43649s.rTV;
                    if (C25052j.m39373j(str2, C43649s.m78156be(i, cek.Url))) {
                        String filePath;
                        String str3 = this.srs.srl.TAG;
                        StringBuilder append = new StringBuilder().append(this.srt.cHq.cHr).append(" video source changed, filePath:");
                        StoryVideoView storyVideoView = this.srs.srl.sqW;
                        if (storyVideoView != null) {
                            filePath = storyVideoView.getFilePath();
                        } else {
                            filePath = null;
                        }
                        C4990ab.m7416i(str3, append.append(filePath).toString());
                        C22319p.m33989a(this.srs.srl, false, 2);
                        storyVideoView = this.srs.srl.sqW;
                        if (storyVideoView != null) {
                            str = storyVideoView.getFilePath();
                        }
                        C5730e.deleteFile(str);
                        c35201i = this.srs.srl.srb;
                        if (c35201i != null) {
                            C43649s c43649s2 = C43649s.rTV;
                            C29298n a = C43649s.m78153a(c35201i);
                            a.cCe();
                            C4133a c4133a = C43644j.rST;
                            C4133a.cxX().mo25974b(a);
                        }
                        this.srs.srl.cDe();
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110977);
                return c37091y;
            }
        }

        C7159d(C22319p c22319p) {
            this.srl = c22319p;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            Object valueOf;
            C35201i c35201i;
            AppMethodBeat.m2504i(110978);
            C32594lp c32594lp = (C32594lp) c4883b;
            String str = this.srl.TAG;
            StringBuilder stringBuilder = new StringBuilder("onelinevideo event callback, retcode:");
            if (c32594lp != null) {
                C9414a c9414a = c32594lp.cHq;
                if (c9414a != null) {
                    valueOf = Integer.valueOf(c9414a.retCode);
                    C4990ab.m7416i(str, stringBuilder.append(valueOf).append(", currVideoItem:").append(this.srl.srb).toString());
                    if (!(c32594lp == null || this.srl.srb == null)) {
                        c35201i = this.srl.srb;
                        if ((c35201i == null || c35201i.cNE != 0) && c32594lp.cHq.retCode == -21112) {
                            C8902b.m16042a(new C7160a(this, c32594lp));
                        }
                    }
                    AppMethodBeat.m2505o(110978);
                    return false;
                }
            }
            valueOf = null;
            C4990ab.m7416i(str, stringBuilder.append(valueOf).append(", currVideoItem:").append(this.srl.srb).toString());
            c35201i = this.srl.srb;
            C8902b.m16042a(new C7160a(this, c32594lp));
            AppMethodBeat.m2505o(110978);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0015"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$e */
    public static final class C13894e implements C23324b {
        final /* synthetic */ C22319p srl;

        C13894e(C22319p c22319p) {
            this.srl = c22319p;
        }

        /* renamed from: c */
        public final void mo9209c(String str, String str2, String str3, int i, int i2) {
            AppMethodBeat.m2504i(110979);
            C4990ab.m7416i(this.srl.TAG, "videoViewCallback onError: " + str + ", meidiaId:" + str2 + ", errorMsg:" + str3 + ", what:" + i + ", extra:" + i2);
            AppMethodBeat.m2505o(110979);
        }

        /* renamed from: cp */
        public final void mo9210cp(String str, String str2) {
            AppMethodBeat.m2504i(110980);
            C4990ab.m7416i(this.srl.TAG, "videoViewCallback onPrepared: " + str + ", meidiaId:" + str2);
            AppMethodBeat.m2505o(110980);
        }

        /* renamed from: cq */
        public final void mo9211cq(String str, String str2) {
            AppMethodBeat.m2504i(110981);
            C4990ab.m7416i(this.srl.TAG, "videoViewCallback onVideoEnded: " + str + ", meidiaId:" + str2);
            C22212h c22212h = C22212h.scu;
            C9502ar cAs = C22212h.cAs();
            cAs.mo20753bQ(cAs.mo20741FO() + 1);
            C35201i c35201i = this.srl.srb;
            if (c35201i != null) {
                C4116b c4116b = C4116b.sbw;
                long j = c35201i.rUJ;
                if (C4116b.aiG()) {
                    C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(j)));
                    if (C4116b.sbi.containsKey(Long.valueOf(j))) {
                        C4117a c4117a = (C4117a) C4116b.sbi.get(Long.valueOf(j));
                        if (c4117a != null) {
                            c4117a.eTf = true;
                            AppMethodBeat.m2505o(110981);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(110981);
                return;
            }
            AppMethodBeat.m2505o(110981);
        }

        /* renamed from: d */
        public final void mo9216d(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(110982);
            C4990ab.m7416i(this.srl.TAG, "videoViewCallback onGetVideoSize: " + str + ", " + this.srl.sqZ + ", meidiaId:" + str2);
            AppMethodBeat.m2505o(110982);
        }

        /* renamed from: cr */
        public final void mo9212cr(String str, String str2) {
            AppMethodBeat.m2504i(110983);
            C4990ab.m7416i(this.srl.TAG, "videoViewCallback onVideoPause: " + str + ", meidiaId:" + str2);
            AppMethodBeat.m2505o(110983);
        }

        /* renamed from: cs */
        public final void mo9213cs(String str, String str2) {
            String sessionId;
            AppMethodBeat.m2504i(110984);
            String str3 = this.srl.TAG;
            StringBuilder append = new StringBuilder("videoViewCallback onVideoPlay: ").append(str).append(' ');
            StoryVideoView storyVideoView = this.srl.sqW;
            if (storyVideoView != null) {
                sessionId = storyVideoView.getSessionId();
            } else {
                sessionId = null;
            }
            C4990ab.m7416i(str3, append.append(sessionId).append(", ").append(this.srl.sqZ).append(", meidiaId:").append(str2).append(", isVideoPause:").append(this.srl.sqY).toString());
            if (C6163u.m9833I(str, this.srl.sqZ, false) && this.srl.sqY) {
                storyVideoView = this.srl.sqW;
                if (!(storyVideoView == null || storyVideoView.sqC)) {
                    this.srl.mo37863r(null);
                }
            }
            C35201i c35201i = this.srl.srb;
            if (c35201i != null) {
                C35180c c35180c = C35180c.sbQ;
                C35180c.m57811lm(c35201i.rUJ);
                C4116b c4116b = C4116b.sbw;
                long j = c35201i.rUJ;
                if (C4116b.aiG()) {
                    str3 = "MicroMsg.StoryBrowseDetailIDKeyStat";
                    append = new StringBuilder("onVideoPlay storyId ").append(j).append(" lastStoryId ").append(C4116b.sbh).append(" contains:").append(C4116b.sbi.containsKey(Long.valueOf(j))).append(" result");
                    C4117a c4117a = (C4117a) C4116b.sbi.get(Long.valueOf(j));
                    C4990ab.m7418v(str3, append.append(c4117a != null ? Long.valueOf(c4117a.sbz) : null).toString());
                    if (j == C4116b.sbh && C4116b.sbi.containsKey(Long.valueOf(j))) {
                        c4117a = (C4117a) C4116b.sbi.get(Long.valueOf(j));
                        if (c4117a != null && !c4117a.rmk && c4117a.sbz <= 0 && c4117a.sby > 0) {
                            c4117a.isWaiting = false;
                            long gb = C5046bo.m7566gb(c4117a.sby);
                            c4117a.sbz = C5046bo.anU();
                            if (gb > 120000) {
                                C4990ab.m7420w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + j + " onPlayCostTime:" + gb);
                            } else {
                                C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + j + " onPlayCostTime:" + gb);
                                C4116b.m6441l(C4116b.lhy, 31, gb);
                                C4116b.m6441l(C4116b.lhy, 30, 1);
                                if (gb <= 400) {
                                    C4116b.m6441l(C4116b.lhy, 90, 1);
                                } else if (gb <= 800) {
                                    C4116b.m6441l(C4116b.lhy, 91, 1);
                                } else if (gb <= 1600) {
                                    C4116b.m6441l(C4116b.lhy, 92, 1);
                                } else if (gb <= 3200) {
                                    C4116b.m6441l(C4116b.lhy, 93, 1);
                                } else if (gb <= 5000) {
                                    C4116b.m6441l(C4116b.lhy, 94, 1);
                                } else {
                                    C4116b.m6441l(C4116b.lhy, 95, 1);
                                }
                                if (gb <= 400) {
                                    C4116b.m6441l(C4116b.lhy, 50, 1);
                                } else if (gb <= 800) {
                                    C4116b.m6441l(C4116b.lhy, 51, 1);
                                } else if (gb <= 1000) {
                                    C4116b.m6441l(C4116b.lhy, 52, 1);
                                } else if (gb <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                    C4116b.m6441l(C4116b.lhy, 53, 1);
                                } else if (gb <= 3000) {
                                    C4116b.m6441l(C4116b.lhy, 54, 1);
                                } else if (gb <= 4000) {
                                    C4116b.m6441l(C4116b.lhy, 55, 1);
                                } else {
                                    C4116b.m6441l(C4116b.lhy, 56, 1);
                                }
                                if (j == C4116b.sbk) {
                                    if (C4116b.sbo) {
                                        C4116b.m6441l(C4116b.lhy, 40, 1);
                                        C4116b.m6441l(C4116b.lhy, 42, gb);
                                    } else {
                                        C4116b.m6441l(C4116b.lhy, 41, 1);
                                        C4116b.m6441l(C4116b.lhy, 43, gb);
                                    }
                                    if (gb <= 1000) {
                                        if (C4116b.sbo) {
                                            C4116b.m6441l(C4116b.lhy, 44, 1);
                                        } else {
                                            C4116b.m6441l(C4116b.lhy, 45, 1);
                                        }
                                    } else if (gb <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                        if (C4116b.sbo) {
                                            C4116b.m6441l(C4116b.lhy, 46, 1);
                                        } else {
                                            C4116b.m6441l(C4116b.lhy, 47, 1);
                                        }
                                    } else if (C4116b.sbo) {
                                        C4116b.m6441l(C4116b.lhy, 48, 1);
                                    } else {
                                        C4116b.m6441l(C4116b.lhy, 49, 1);
                                    }
                                }
                            }
                        }
                    }
                }
                C39933n.sqi.mo63131lA(c35201i.rUJ);
                C22241k c22241k = C22241k.rTc;
                C22241k.aao(c35201i.username);
                AppMethodBeat.m2505o(110984);
                return;
            }
            AppMethodBeat.m2505o(110984);
        }

        /* renamed from: ct */
        public final void mo9214ct(String str, String str2) {
            AppMethodBeat.m2504i(110985);
            C4990ab.m7416i(this.srl.TAG, "videoViewCallback onVideoWaiting: " + str + ", meidiaId:" + str2);
            C35201i c35201i = this.srl.srb;
            if (c35201i != null) {
                C35180c c35180c = C35180c.sbQ;
                C35180c.m57810ll(c35201i.rUJ);
                C4116b c4116b = C4116b.sbw;
                long j = c35201i.rUJ;
                if (C4116b.aiG() && C4116b.sbi.containsKey(Long.valueOf(j))) {
                    C4117a c4117a = (C4117a) C4116b.sbi.get(Long.valueOf(j));
                    if (!(c4117a == null || c4117a.rmk || !c4117a.sbA)) {
                        c4117a.isWaiting = true;
                        AppMethodBeat.m2505o(110985);
                        return;
                    }
                }
                AppMethodBeat.m2505o(110985);
                return;
            }
            AppMethodBeat.m2505o(110985);
        }

        /* renamed from: cu */
        public final void mo9215cu(String str, String str2) {
            String sessionId;
            AppMethodBeat.m2504i(110986);
            String str3 = this.srl.TAG;
            StringBuilder append = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(str).append(' ');
            StoryVideoView storyVideoView = this.srl.sqW;
            if (storyVideoView != null) {
                sessionId = storyVideoView.getSessionId();
            } else {
                sessionId = null;
            }
            C4990ab.m7416i(str3, append.append(sessionId).append(", ").append(this.srl.sqZ).append(", meidiaId:").append(str2).append(", isVideoPause:").append(this.srl.sqY).toString());
            if (C6163u.m9833I(str, this.srl.sqZ, false) && this.srl.sqY) {
                storyVideoView = this.srl.sqW;
                if (storyVideoView == null) {
                    AppMethodBeat.m2505o(110986);
                    return;
                } else if (!storyVideoView.sqC) {
                    this.srl.mo37863r(null);
                }
            }
            AppMethodBeat.m2505o(110986);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\u0010 \u001a\u00060!R\u00020\"H\u0002J \u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0016J \u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0012\u0010(\u001a\u00020'2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010)\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010*\u001a\u00020'2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$b */
    final class C22320b implements C9715b {
        final String TAG = "MicroMsg.VideoPlayProxy";
        int cFa;
        private C9714a hYm;
        boolean sqx;
        C35201i sqy;
        C29298n srk;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$b$a */
        static final class C22321a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ int srn;
            final /* synthetic */ int sro;
            final /* synthetic */ C22320b srr;

            C22321a(C22320b c22320b, String str, int i, int i2) {
                this.srr = c22320b;
                this.sqz = str;
                this.srn = i;
                this.sro = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110970);
                C35201i c35201i = this.srr.sqy;
                if (c35201i != null) {
                    C22320b c22320b = this.srr;
                    C43649s c43649s = C43649s.rTV;
                    c22320b.srk = C43649s.m78153a(c35201i);
                }
                C37961o.alm();
                int k = C45150e.m83031k(this.sqz, this.srn, this.sro);
                String str = this.srr.TAG;
                StringBuilder append = new StringBuilder("requestVideoData ").append(this.sqz).append(' ').append(this.srn).append(' ').append(this.sro).append(' ');
                C29298n c29298n = this.srr.srk;
                C4990ab.m7416i(str, append.append(c29298n != null ? Integer.valueOf(c29298n.field_cacheSize) : null).append(", ret:").append(k).append(" this:").append(this.srr).toString());
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110970);
                return c37091y;
            }
        }

        /* renamed from: p */
        public final void mo37865p(C35201i c35201i) {
            AppMethodBeat.m2504i(110971);
            C25052j.m39376p(c35201i, "item");
            this.sqy = c35201i;
            C43649s c43649s = C43649s.rTV;
            this.srk = C43649s.m78153a(c35201i);
            C4990ab.m7416i(this.TAG, "setStoryVideoItem " + c35201i + " videoCache " + this.srk);
            AppMethodBeat.m2505o(110971);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00fc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: r */
        public final void mo8715r(String str, String str2, String str3) {
            int i = 0;
            Object obj = null;
            AppMethodBeat.m2504i(110972);
            C4990ab.m7416i(this.TAG, "startHttpStream " + str + ' ' + str2 + ' ' + str3 + " this:" + this);
            if (this.sqy != null) {
                String str4;
                C43649s c43649s = C43649s.rTV;
                C35201i c35201i = this.sqy;
                if (c35201i == null) {
                    C25052j.dWJ();
                }
                this.srk = C43649s.m78153a(c35201i);
                C29298n c29298n = this.srk;
                if (!(c29298n == null || C5730e.m8628ct(c29298n.field_filePath))) {
                    C29309l c29309l = C29309l.rTg;
                    String str5 = c29298n.field_filePath;
                    C25052j.m39375o(str5, "it.field_filePath");
                    C29309l.aay(str5);
                    C4990ab.m7416i(this.TAG, "startHttpStream error downloadFinish " + c29298n.mo47507Jo() + " ret:" + C5730e.m8628ct(c29298n.field_filePath) + " path:" + c29298n.field_filePath);
                    c29298n.cCe();
                    C4133a c4133a = C43644j.rST;
                    C4133a.cxX().mo25974b(c29298n);
                }
                c35201i = C22319p.this.srb;
                if (c35201i != null) {
                    C35180c c35180c = C35180c.sbQ;
                    C35180c.czW();
                    C4116b c4116b = C4116b.sbw;
                    long j = c35201i.rUJ;
                    if (C4116b.aiG()) {
                        C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(j)));
                        if (C4116b.sbi.containsKey(Long.valueOf(j))) {
                            C4117a c4117a = (C4117a) C4116b.sbi.get(Long.valueOf(j));
                            if (c4117a != null) {
                                c4117a.sbA = true;
                            }
                        }
                    }
                }
                c35201i = this.sqy;
                if (c35201i != null) {
                    cek cek = c35201i.rWj;
                    if (cek != null) {
                        str4 = cek.Url;
                        if (!C5046bo.isNullOrNil(str4)) {
                            C22319p c22319p = C22319p.this;
                            c22319p.srh++;
                            StoryVideoView storyVideoView = c22319p.sqW;
                            if (storyVideoView != null) {
                                storyVideoView.setNeedShowLoading(true);
                            }
                            C22323a c22323a = new C22323a();
                            c22323a.hYm = this.hYm;
                            c22323a.mo37866a(this.srk, this.sqy);
                            C44686h c44686h = new C44686h();
                            C22323a c22323a2 = new C22323a();
                            c22323a2.hYm = this.hYm;
                            c22323a2.mo37866a(this.srk, this.sqy);
                            c44686h.field_mediaId = str;
                            c44686h.url = str3;
                            c44686h.egD = 1;
                            c44686h.egy = 6;
                            c44686h.concurrentCount = 4;
                            c44686h.field_fullpath = str2;
                            c44686h.egK = c22323a;
                            c44686h.field_fileType = C42129a.efK;
                            c44686h.field_requestVideoFormat = C42204d.m74456v(1, str2);
                            C39933n c39933n = C39933n.sqi;
                            c35201i = this.sqy;
                            if (c35201i == null) {
                                C25052j.dWJ();
                            }
                            C39933n.m68384h(c35201i);
                            c35201i = C22319p.this.srb;
                            if (c35201i != null) {
                                boolean z;
                                C4116b c4116b2 = C4116b.sbw;
                                long j2 = c35201i.rUJ;
                                if (this.srk != null) {
                                    c29298n = this.srk;
                                    if (c29298n == null || c29298n.field_cacheSize != 0) {
                                        z = false;
                                        C4116b.m6444z(j2, z);
                                    }
                                }
                                z = true;
                                C4116b.m6444z(j2, z);
                            }
                            C37961o.alm().mo73059a(c44686h);
                            if (!(this.sqy == null || str == null)) {
                                c39933n = C39933n.sqi;
                                c35201i = this.sqy;
                                if (c35201i == null) {
                                    C25052j.dWJ();
                                }
                                C13892b i2 = C39933n.m68385i(c35201i);
                                if (i2.sqw && !c22323a.sqw) {
                                    Object valueOf;
                                    String str6 = this.TAG;
                                    StringBuilder append = new StringBuilder("checkPreloadOnVideoPlay ").append(str).append(", moovReady, offset:").append(i2.f2943xb).append(", length:").append(i2.bgY).append(", cacheSize:");
                                    c29298n = this.srk;
                                    if (c29298n != null) {
                                        valueOf = Integer.valueOf(c29298n.field_cacheSize);
                                    } else {
                                        valueOf = null;
                                    }
                                    StringBuilder append2 = append.append(valueOf).append(", totalSize:");
                                    C29298n c29298n2 = this.srk;
                                    if (c29298n2 != null) {
                                        obj = Integer.valueOf(c29298n2.field_totalSize);
                                    }
                                    C4990ab.m7416i(str6, append2.append(obj).append(", preloadFinish:").append(i2.sqx).toString());
                                    if (i2.f2943xb > 0 && i2.bgY > 0) {
                                        c22323a.onMoovReady(str, (int) i2.f2943xb, (int) i2.bgY);
                                        c29298n = this.srk;
                                        if (c29298n != null) {
                                            i = c29298n.field_cacheSize;
                                        }
                                        this.cFa = i;
                                        this.sqx = i2.sqx;
                                    }
                                }
                            }
                        }
                    }
                }
                str4 = null;
                if (C5046bo.isNullOrNil(str4)) {
                }
            }
            AppMethodBeat.m2505o(110972);
        }

        /* JADX WARNING: Missing block: B:30:0x00e8, code skipped:
            if (r0 == null) goto L_0x00ea;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: dV */
        public final void mo8713dV(String str) {
            Integer valueOf;
            int i;
            String filePath;
            long j;
            int i2 = 2;
            int i3 = 1;
            Long l = null;
            AppMethodBeat.m2504i(110973);
            C25052j.m39376p(str, "mediaId");
            C4990ab.m7416i(this.TAG, "this: " + this + " stop " + str + ' ' + C5046bo.dpG());
            Object[] objArr = new Object[17];
            StoryVideoView storyVideoView = C22319p.this.sqW;
            objArr[0] = storyVideoView != null ? Integer.valueOf(storyVideoView.getCurrPosMs()) : Integer.valueOf(0);
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf((int) storyVideoView.getFirstPlayWaitTime());
            } else {
                valueOf = null;
            }
            objArr[1] = valueOf;
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.cCZ());
            } else {
                valueOf = null;
            }
            objArr[2] = valueOf;
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.cDa());
            } else {
                valueOf = null;
            }
            objArr[3] = valueOf;
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.cDb());
            } else {
                valueOf = null;
            }
            objArr[4] = valueOf;
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.getStayTime());
            } else {
                valueOf = null;
            }
            objArr[5] = valueOf;
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.getErrorCode());
            } else {
                valueOf = null;
            }
            objArr[6] = valueOf;
            objArr[7] = Integer.valueOf(this.cFa);
            if (this.cFa > 0) {
                i = 2;
            } else {
                i = 1;
            }
            objArr[8] = Integer.valueOf(i);
            if (this.sqx) {
                i2 = 3;
            }
            objArr[9] = Integer.valueOf(i2);
            C29283a c29283a = C29282c.rRS;
            storyVideoView = C22319p.this.sqW;
            if (storyVideoView != null) {
                filePath = storyVideoView.getFilePath();
            }
            filePath = "";
            objArr[10] = C29283a.aak(filePath);
            C35201i c35201i = this.sqy;
            if (c35201i != null) {
                l = Long.valueOf(c35201i.rUJ);
            }
            objArr[11] = l;
            C22212h c22212h = C22212h.scu;
            objArr[12] = Long.valueOf(C22212h.cAs().mo20732FF());
            c22212h = C22212h.scu;
            objArr[13] = Long.valueOf(C22212h.cAs().mo20734FH());
            c22212h = C22212h.scu;
            if (C22212h.cAs().mo20737FK() != 1) {
                i3 = 0;
            }
            objArr[14] = Integer.valueOf(i3);
            C4133a c4133a = C43644j.rST;
            C46275k cxT = C4133a.cxT();
            C35201i c35201i2 = this.sqy;
            if (c35201i2 != null) {
                j = c35201i2.rUJ;
            } else {
                j = 0;
            }
            objArr[15] = Integer.valueOf(cxT.mo74418ly(j));
            objArr[16] = Integer.valueOf(C22319p.this.srh);
            C4990ab.m7416i(this.TAG, "reportTips: " + Arrays.toString(objArr));
            C37961o.alm().mo73063l(str, objArr);
            AppMethodBeat.m2505o(110973);
        }

        public final void requestVideoData(String str, int i, int i2) {
            AppMethodBeat.m2504i(110974);
            C25052j.m39376p(str, "mediaId");
            C8902b.m16042a(new C22321a(this, str, i, i2));
            AppMethodBeat.m2505o(110974);
        }

        public final boolean isVideoDataAvailable(String str, int i, int i2) {
            String str2;
            StringBuilder append;
            C29298n c29298n;
            Object obj = null;
            AppMethodBeat.m2504i(110975);
            C25052j.m39376p(str, "mediaId");
            C35201i c35201i = this.sqy;
            if (c35201i != null) {
                C43649s c43649s = C43649s.rTV;
                this.srk = C43649s.m78153a(c35201i);
                C29298n c29298n2 = this.srk;
                if (c29298n2 != null && c29298n2.mo47507Jo()) {
                    str2 = this.TAG;
                    append = new StringBuilder("isVideoDataAvailable ").append(str).append(", ").append(i).append(", ").append(i2).append(", download finish cacheSize:");
                    c29298n = this.srk;
                    if (c29298n != null) {
                        obj = Integer.valueOf(c29298n.field_cacheSize);
                    }
                    C4990ab.m7416i(str2, append.append(obj).append(" this:").append(this).toString());
                    AppMethodBeat.m2505o(110975);
                    return true;
                }
            }
            boolean isVideoDataAvailable = C37961o.alm().isVideoDataAvailable(str, i, i2);
            str2 = this.TAG;
            append = new StringBuilder("isVideoDataAvailable ").append(str).append(", ").append(i).append(", ").append(i2).append(", available:").append(isVideoDataAvailable).append(" cacheSize:");
            c29298n = this.srk;
            if (c29298n != null) {
                obj = Integer.valueOf(c29298n.field_cacheSize);
            }
            C4990ab.m7416i(str2, append.append(obj).append(" this:").append(this).toString());
            AppMethodBeat.m2505o(110975);
            return isVideoDataAvailable;
        }

        /* renamed from: a */
        public final void mo8712a(C9714a c9714a) {
            this.hYm = c9714a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$c */
    public static final class C22322c implements C23325c {
        final /* synthetic */ C22319p srl;

        C22322c(C22319p c22319p) {
            this.srl = c22319p;
        }

        /* renamed from: gp */
        public final void mo26918gp(long j) {
            AppMethodBeat.m2504i(110976);
            StoryVideoView storyVideoView = this.srl.sqW;
            if (storyVideoView != null) {
                if (!storyVideoView.sqC) {
                    C7060h.pYm.mo8378a(this.srl.srg, j, 1, false);
                    if (j >= 141 && j <= 145) {
                        C4990ab.m7416i(this.srl.TAG, "initCreateVideoView test key " + j + " value 1 currVideoItem:" + this.srl.srb + ' ' + C5046bo.dpG());
                    }
                }
                AppMethodBeat.m2505o(110976);
                return;
            }
            AppMethodBeat.m2505o(110976);
        }

        /* renamed from: wB */
        public final void mo26927wB(String str) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$a */
    final class C22323a implements C26326a {
        final String TAG = "MicroMsg.VideoPlayProxy";
        C9714a hYm;
        volatile boolean sqw;
        C35201i sqy;
        C29298n srk;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$a$a */
        static final class C22316a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ C22323a srm;
            final /* synthetic */ int srn;
            final /* synthetic */ int sro;

            C22316a(C22323a c22323a, String str, int i, int i2) {
                this.srm = c22323a;
                this.sqz = str;
                this.srn = i;
                this.sro = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110962);
                StoryVideoView storyVideoView = C22319p.this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.onDataAvailable(this.sqz, this.srn, this.sro);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110962);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$a$b */
        static final class C22317b extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ C22323a srm;
            final /* synthetic */ int srp;

            C22317b(C22323a c22323a, String str, int i) {
                this.srm = c22323a;
                this.sqz = str;
                this.srp = i;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110963);
                C9714a c9714a = this.srm.hYm;
                if (c9714a != null) {
                    c9714a.mo9058ad(this.sqz, this.srp);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110963);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$a$d */
        static final class C22318d extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ C22323a srm;
            final /* synthetic */ int srn;
            final /* synthetic */ int srq;

            C22318d(C22323a c22323a, String str, int i, int i2) {
                this.srm = c22323a;
                this.sqz = str;
                this.srn = i;
                this.srq = i2;
                super(0);
            }

            /* JADX WARNING: Removed duplicated region for block: B:42:0x017e  */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object invoke() {
                boolean z;
                C37091y c37091y;
                AppMethodBeat.m2504i(110965);
                C22319p c22319p = C22319p.this;
                String str = c22319p.TAG;
                StringBuilder append = new StringBuilder("checkPauseOnProgress, isVideoPause:").append(c22319p.sqY).append(", ");
                StoryVideoView storyVideoView = c22319p.sqW;
                C4990ab.m7416i(str, append.append(storyVideoView != null ? storyVideoView.getSessionId() : null).append(", ").append(c22319p.sqZ).toString());
                if (c22319p.sqY) {
                    String sessionId;
                    storyVideoView = c22319p.sqW;
                    if (storyVideoView != null) {
                        sessionId = storyVideoView.getSessionId();
                    } else {
                        sessionId = null;
                    }
                    if (C6163u.m9833I(sessionId, c22319p.sqZ, false)) {
                        c22319p.mo37863r(null);
                        z = true;
                        if (z) {
                            storyVideoView = C22319p.this.sqW;
                            if (storyVideoView != null) {
                                storyVideoView.mo9075h(this.sqz, this.srn, this.srq);
                            }
                            C29298n c29298n = this.srm.srk;
                            if (c29298n != null) {
                                c29298n.field_totalSize = this.srq;
                            }
                            c29298n = this.srm.srk;
                            if (c29298n != null) {
                                c29298n.field_cacheSize = this.srn;
                            }
                            C4133a c4133a = C43644j.rST;
                            boolean c = C4133a.cxX().mo10103c(this.srm.srk, new String[0]);
                            C35201i c35201i = this.srm.sqy;
                            if (c35201i != null) {
                                C4133a c4133a2 = C43644j.rST;
                                C4119f aap = C4133a.cxU().aap(c35201i.username);
                                if (aap.field_syncId == c35201i.rUJ && aap.isValid() && this.srm.srk != null) {
                                    int i;
                                    long j = c35201i.rUJ;
                                    String str2 = c35201i.rWj.f4416Id;
                                    C25052j.m39375o(str2, "it.media.Id");
                                    c29298n = this.srm.srk;
                                    if (c29298n != null) {
                                        i = c29298n.field_cacheSize;
                                    } else {
                                        i = 0;
                                    }
                                    if (aap.mo8989b(j, str2, i)) {
                                        C4990ab.m7416i(this.srm.TAG, "markPreloadCompleted onProgress, mediaId:" + this.sqz + ", offset:" + this.srn + ", total:" + this.srq + " this:" + this.srm);
                                        c4133a = C43644j.rST;
                                        C4133a.cxU().mo47494a((long) ((int) aap.xDa), aap);
                                    }
                                }
                            }
                            C4990ab.m7416i(this.srm.TAG, "onProgress, update ret " + c + " mediaId:" + this.sqz + ", offset:" + this.srn + ", total:" + this.srq + " this:" + this.srm);
                        } else {
                            C4990ab.m7416i(this.srm.TAG, "checkPauseOnProgress return");
                        }
                        c37091y = C37091y.AUy;
                        AppMethodBeat.m2505o(110965);
                        return c37091y;
                    }
                }
                z = false;
                if (z) {
                }
                c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110965);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.p$a$c */
        static final class C22324c extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ C22323a srm;
            final /* synthetic */ int srn;
            final /* synthetic */ int sro;

            C22324c(C22323a c22323a, String str, int i, int i2) {
                this.srm = c22323a;
                this.sqz = str;
                this.srn = i;
                this.sro = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110964);
                StoryVideoView storyVideoView = C22319p.this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.mo21050ml(this.srn);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110964);
                return c37091y;
            }
        }

        /* renamed from: a */
        public final void mo37866a(C29298n c29298n, C35201i c35201i) {
            this.srk = c29298n;
            this.sqy = c35201i;
        }

        public final void onMoovReady(String str, int i, int i2) {
            String str2;
            AppMethodBeat.m2504i(110966);
            C25052j.m39376p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onMoovReady, mediaId:").append(str).append(", offset:").append(i).append(", length:").append(i2).append(", isMoovReady:").append(this.sqw).append(" this:").append(this).append(" currVideoItem:");
            C35201i c35201i = C22319p.this.srb;
            if (c35201i != null) {
                str2 = c35201i.username;
            } else {
                str2 = null;
            }
            C4990ab.m7416i(str3, append.append(str2).toString());
            if (this.sqw) {
                AppMethodBeat.m2505o(110966);
                return;
            }
            this.sqw = true;
            C8902b.m16042a(new C22324c(this, str, i, i2));
            AppMethodBeat.m2505o(110966);
        }

        public final void onDataAvailable(String str, int i, int i2) {
            String str2;
            AppMethodBeat.m2504i(110967);
            C25052j.m39376p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onDataAvailable, mediaId:").append(str).append(", offset:").append(i).append(", length:").append(i2).append(" this:").append(this).append(" currVideoItem:");
            C35201i c35201i = C22319p.this.srb;
            if (c35201i != null) {
                str2 = c35201i.username;
            } else {
                str2 = null;
            }
            C4990ab.m7416i(str3, append.append(str2).toString());
            C8902b.m16042a(new C22316a(this, str, i, i2));
            AppMethodBeat.m2505o(110967);
        }

        /* renamed from: h */
        public final void mo8706h(String str, int i, int i2) {
            String str2;
            AppMethodBeat.m2504i(110968);
            C25052j.m39376p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onProgress, mediaId:").append(str).append(", offset:").append(i).append(", total:").append(i2).append(" this:").append(this).append(" currVideoItem:");
            C35201i c35201i = C22319p.this.srb;
            if (c35201i != null) {
                str2 = c35201i.username;
            } else {
                str2 = null;
            }
            C4990ab.m7416i(str3, append.append(str2).toString());
            C8902b.m16042a(new C22318d(this, str, i, i2));
            AppMethodBeat.m2505o(110968);
        }

        /* renamed from: a */
        public final void mo8705a(String str, int i, C9545d c9545d) {
            int i2;
            String str2;
            long j;
            int i3 = 0;
            String[] strArr = null;
            AppMethodBeat.m2504i(110969);
            C25052j.m39376p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onFinish, mediaId:").append(str).append(", ret:").append(i).append(", sceneResult:");
            if (c9545d != null) {
                i2 = c9545d.field_retCode;
            } else {
                i2 = 0;
            }
            append = append.append(i2).append(" this:").append(this).append(" currVideoItem:");
            C35201i c35201i = C22319p.this.srb;
            if (c35201i != null) {
                str2 = c35201i.username;
            } else {
                str2 = null;
            }
            C4990ab.m7416i(str3, append.append(str2).toString());
            c35201i = this.sqy;
            if (c35201i != null) {
                C4116b c4116b = C4116b.sbw;
                C4116b.m6443lk(c35201i.rUJ);
                C39933n.sqi.mo63132lB(c35201i.rUJ);
            }
            C29298n c29298n = this.srk;
            if (c29298n != null) {
                str2 = c29298n.field_filePath;
            } else {
                str2 = null;
            }
            C43528a WR = C21846d.m33388WR(str2);
            if (WR != null) {
                C22212h c22212h = C22212h.scu;
                C22212h.cAE().mo53155bq((long) WR.eWK);
                c22212h = C22212h.scu;
                C22212h.cAE().mo53156br((long) WR.videoBitrate);
                c22212h = C22212h.scu;
                C22212h.cAE().mo53157bs((long) WR.fzS);
                c22212h = C22212h.scu;
                C22212h.cAE().mo53158bt((long) WR.eTk);
                c22212h = C22212h.scu;
                C22212h.cAE().mo53159bu((long) WR.width);
                c22212h = C22212h.scu;
                C22212h.cAE().mo53160bv((long) WR.height);
                c22212h = C22212h.scu;
                C22212h.cAE().mo53161bw((long) WR.qwV);
            }
            C22212h c22212h2 = C22212h.scu;
            C32662an cAE = C22212h.cAE();
            if (this.srk != null) {
                C29298n c29298n2 = this.srk;
                if (c29298n2 == null) {
                    C25052j.dWJ();
                }
                j = (long) c29298n2.field_totalSize;
            } else {
                j = 0;
            }
            cAE.mo53154bp(j);
            c22212h2 = C22212h.scu;
            C32662an cAE2 = C22212h.cAE();
            c29298n = this.srk;
            if (c29298n != null) {
                str2 = c29298n.field_url;
            } else {
                str2 = null;
            }
            cAE2.mo53164ft(str2);
            c22212h2 = C22212h.scu;
            cAE2 = C22212h.cAE();
            C37461f.afy();
            c29298n = this.srk;
            if (c29298n != null) {
                str2 = c29298n.field_filePath;
            } else {
                str2 = null;
            }
            cAE2.mo53165fu(C8941a.m16130rJ(str2));
            if (c9545d != null) {
                c22212h2 = C22212h.scu;
                C22212h.cAE().mo53152bn(c9545d.field_startTime);
                c22212h2 = C22212h.scu;
                C22212h.cAE().mo53153bo(c9545d.field_endTime);
            }
            if (c9545d != null) {
                strArr = c9545d.field_usedSvrIps;
            }
            if (strArr != null) {
                StringBuffer stringBuffer = new StringBuffer();
                strArr = c9545d.field_usedSvrIps;
                int length = strArr.length;
                while (i3 < length) {
                    stringBuffer.append(strArr[i3]).append("|");
                    i3++;
                }
                C22212h c22212h3 = C22212h.scu;
                C22212h.cAE().mo53166fv(stringBuffer.toString());
            }
            if (C22319p.this.sqX != null) {
                long j2;
                c22212h2 = C22212h.scu;
                cAE = C22212h.cAE();
                C22320b c22320b = C22319p.this.sqX;
                if (c22320b == null) {
                    C25052j.dWJ();
                }
                cAE.mo53162bx((long) c22320b.cFa);
                c22212h2 = C22212h.scu;
                C32662an cAE3 = C22212h.cAE();
                C22320b c22320b2 = C22319p.this.sqX;
                if (c22320b2 == null) {
                    C25052j.dWJ();
                }
                if (c22320b2.sqx) {
                    j2 = 3;
                } else {
                    c22320b2 = C22319p.this.sqX;
                    if (c22320b2 == null) {
                        C25052j.dWJ();
                    }
                    j2 = c22320b2.cFa > 0 ? 2 : 1;
                }
                cAE3.mo53163by(j2);
            }
            c22212h2 = C22212h.scu;
            C22212h.cAF();
            C8902b.m16042a(new C22317b(this, str, i));
            AppMethodBeat.m2505o(110969);
        }
    }

    public C22319p() {
        AppMethodBeat.m2504i(111001);
        C4990ab.m7416i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
        C4879a.xxA.mo10052c(this.sri);
        this.srj = new C13894e(this);
        AppMethodBeat.m2505o(111001);
    }

    /* renamed from: a */
    public final void mo37855a(ViewGroup viewGroup, LayoutParams layoutParams) {
        Object valueOf;
        AppMethodBeat.m2504i(110987);
        C25052j.m39376p(viewGroup, "parent");
        this.srh = 0;
        boolean s = m33991s(viewGroup);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("attachVideoView, parent:").append(viewGroup.hashCode()).append(", isVideoPause:").append(this.sqY).append(", currentSessionId:").append(this.sqZ).append(", isPlayingVideoItem:").append(this.sra).append(" videoView ");
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            valueOf = Integer.valueOf(storyVideoView.hashCode());
        } else {
            valueOf = null;
        }
        C4990ab.m7409c(str, append.append(valueOf).append(" sameParent ").append(s).append(" this:").append(hashCode()).toString(), new Object[0]);
        mo37863r(viewGroup);
        if (this.sqW == null) {
            Context context = C4996ah.getContext();
            C25052j.m39375o(context, "MMApplicationContext.getContext()");
            mo37861eX(context);
        }
        if (s) {
            if (layoutParams != null) {
                storyVideoView = this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.setLayoutParams(layoutParams);
                    AppMethodBeat.m2505o(110987);
                    return;
                }
            }
            AppMethodBeat.m2505o(110987);
        } else if (layoutParams == null) {
            viewGroup.addView(this.sqW);
            AppMethodBeat.m2505o(110987);
        } else {
            viewGroup.addView(this.sqW, layoutParams);
            AppMethodBeat.m2505o(110987);
        }
    }

    /* renamed from: o */
    public final void mo37862o(C35201i c35201i) {
        AppMethodBeat.m2504i(110989);
        C25052j.m39376p(c35201i, "item");
        boolean z = !m33990n(c35201i);
        C4990ab.m7409c(this.TAG, "change:" + z + " changeVideoItem: origin: " + this.srb + ", new: " + c35201i + ", " + this.srd + " change:" + z + " this:" + hashCode(), new Object[0]);
        if (z) {
            this.srb = c35201i;
            if (this.srd) {
                C22319p.m33989a(this, false, 2);
                cDe();
            }
        }
        AppMethodBeat.m2505o(110989);
    }

    public final void cDe() {
        AppMethodBeat.m2504i(110990);
        C4990ab.m7409c(this.TAG, "playVideo, " + this.sqY + ' ' + this.srd + ", " + this.srb, new Object[0]);
        cDf();
        this.srd = true;
        C35201i c35201i = this.srb;
        if (c35201i != null) {
            boolean z = this.sqY;
            this.sqY = false;
            StoryVideoView storyVideoView;
            if (z) {
                storyVideoView = this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.mo9078m(c35201i);
                }
            } else {
                this.sqZ = UUID.randomUUID().toString();
                C22320b c22320b = this.sqX;
                if (c22320b != null) {
                    c22320b.mo37865p(c35201i);
                }
                storyVideoView = this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.mo9054a(c35201i, this.sqZ);
                }
            }
            this.sqY = false;
            if (c35201i.czf()) {
                this.sra = true;
            }
            if (!this.srf) {
                this.sre.requestFocus();
                this.srf = true;
            }
        }
        C22212h c22212h = C22212h.scu;
        C9502ar cAs = C22212h.cAs();
        StoryVideoView storyVideoView2 = this.sqW;
        cAs.mo20742bF((long) C5023at.m7472gC(storyVideoView2 != null ? storyVideoView2.getContext() : null));
        AppMethodBeat.m2505o(110990);
    }

    /* Access modifiers changed, original: final */
    public final void cDf() {
        AppMethodBeat.m2504i(110991);
        C4990ab.m7416i(this.TAG, "setVideoViewProp, isMute:" + this.eif);
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.setMute(this.eif);
            AppMethodBeat.m2505o(110991);
            return;
        }
        AppMethodBeat.m2505o(110991);
    }

    /* renamed from: a */
    public static /* synthetic */ void m33989a(C22319p c22319p, boolean z, int i) {
        AppMethodBeat.m2504i(110993);
        if ((i & 2) != 0) {
            z = true;
        }
        c22319p.mo37854N(false, z);
        AppMethodBeat.m2505o(110993);
    }

    /* renamed from: N */
    public final void mo37854N(boolean z, boolean z2) {
        AppMethodBeat.m2504i(110992);
        C4990ab.m7409c(this.TAG, "stopVideo, detach: ".concat(String.valueOf(z)), new Object[0]);
        if (this.sra) {
            this.sqZ = null;
            StoryVideoView storyVideoView = this.sqW;
            if (storyVideoView != null) {
                storyVideoView.stop();
            }
            this.sqY = false;
            if (this.srf) {
                this.sre.mo73178Mm();
                this.srf = false;
            }
            this.sra = false;
        }
        if (z) {
            this.srd = false;
            mo37863r(null);
            C22212h c22212h = C22212h.scu;
            C22212h.cAs().mo20746bJ(System.currentTimeMillis());
            if (z2) {
                c22212h = C22212h.scu;
                C22212h.cAt();
            }
        }
        AppMethodBeat.m2505o(110992);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(110994);
        String str = "";
        C25052j.m39375o(str, "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
        C4990ab.m7416i(this.TAG, "setMute " + z + " ret " + str);
        this.eif = z;
        AppMethodBeat.m2505o(110994);
    }

    public final void akW() {
        AppMethodBeat.m2504i(110995);
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.akW();
            AppMethodBeat.m2505o(110995);
            return;
        }
        AppMethodBeat.m2505o(110995);
    }

    public final void akV() {
        AppMethodBeat.m2504i(110996);
        C4990ab.m7416i(this.TAG, "onUIPause " + hashCode());
        mo37863r(null);
        if (this.srf) {
            this.sre.mo73178Mm();
            this.srf = false;
        }
        AppMethodBeat.m2505o(110996);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(110997);
        C4990ab.m7416i(this.TAG, "onUIDestroy " + hashCode());
        this.srd = false;
        mo37863r(null);
        this.srb = null;
        this.sqW = null;
        if (this.srf) {
            this.sre.mo73178Mm();
            this.srf = false;
        }
        C4879a.xxA.mo10053d(this.sri);
        AppMethodBeat.m2505o(110997);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eX */
    public final void mo37861eX(Context context) {
        AppMethodBeat.m2504i(110998);
        this.sqW = new StoryVideoView(context);
        this.sqX = new C22320b();
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.setIOnlineVideoProxy(this.sqX);
        }
        storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.setIMMVideoViewCallback(this.srj);
        }
        storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.setReporter(new C22322c(this));
        }
        this.sra = false;
        AppMethodBeat.m2505o(110998);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final void mo37863r(ViewGroup viewGroup) {
        int hashCode;
        ViewParent parent;
        AppMethodBeat.m2504i(110999);
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("checkDetachVideoView, videoView:");
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            hashCode = storyVideoView.hashCode();
        } else {
            hashCode = 0;
        }
        stringBuilder = stringBuilder.append(hashCode).append(", isPlay:");
        storyVideoView = this.sqW;
        stringBuilder = stringBuilder.append(storyVideoView != null ? storyVideoView.isPlaying() : false).append(", parent:");
        storyVideoView = this.sqW;
        Object parent2 = storyVideoView != null ? storyVideoView.getParent() : null;
        C4990ab.m7409c(str, stringBuilder.append(parent2 != null ? parent2.hashCode() : 0).append(", newParent:").append(viewGroup != null ? viewGroup.hashCode() : 0).append(", isPlayingVideoItem:").append(this.sra).toString(), new Object[0]);
        storyVideoView = this.sqW;
        if (storyVideoView != null) {
            parent = storyVideoView.getParent();
        } else {
            parent = null;
        }
        if (!(parent == null || m33991s(viewGroup))) {
            C22319p.m33989a(this, true, 1);
            storyVideoView = this.sqW;
            if (storyVideoView != null) {
                parent = storyVideoView.getParent();
            } else {
                parent = null;
            }
            if (parent == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.m2505o(110999);
                throw c44941v;
            }
            ((ViewGroup) parent).removeView(this.sqW);
            this.srb = null;
        }
        AppMethodBeat.m2505o(110999);
    }

    /* renamed from: s */
    private final boolean m33991s(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(111000);
        StoryVideoView storyVideoView = this.sqW;
        boolean j = C25052j.m39373j(storyVideoView != null ? storyVideoView.getParent() : null, viewGroup);
        AppMethodBeat.m2505o(111000);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    private final boolean m33990n(C35201i c35201i) {
        C35201i c35201i2;
        Object obj;
        AppMethodBeat.m2504i(110988);
        if (c35201i.cNE != 0) {
            c35201i2 = this.srb;
            if (c35201i2 != null && c35201i2.cNE == c35201i.cNE) {
                AppMethodBeat.m2505o(110988);
                return true;
            }
        }
        CharSequence charSequence = c35201i.rWj.Url;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            c35201i2 = this.srb;
            if (c35201i2 != null) {
                cek cek = c35201i2.rWj;
                if (cek != null) {
                    obj = cek.Url;
                    if (C25052j.m39373j(obj, c35201i.rWj.Url)) {
                        AppMethodBeat.m2505o(110988);
                        return true;
                    }
                }
            }
            obj = null;
            if (C25052j.m39373j(obj, c35201i.rWj.Url)) {
            }
        }
        AppMethodBeat.m2505o(110988);
        return false;
    }
}
