package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Arrays;
import java.util.UUID;

@l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0002\u0013\u001c\u0018\u00002\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\nJ\u001c\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010(\u001a\u00020\rH\u0002J\u0006\u0010)\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\r2\u0006\u0010%\u001a\u00020\nJ\b\u0010+\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020\nH\u0002J\u0006\u00100\u001a\u00020\u001fJ\u0006\u00101\u001a\u00020\u001fJ\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u001fJ\u0012\u00107\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010!H\u0002J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\rJ\b\u0010;\u001a\u00020\u001fH\u0002J\u0006\u0010<\u001a\u00020\u001fJ\u001a\u0010=\u001a\u00020\u001f2\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class p {
    final String TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    private boolean eif;
    StoryVideoView sqW;
    b sqX;
    boolean sqY;
    String sqZ;
    private boolean sra;
    i srb;
    private boolean srd;
    private com.tencent.mm.compatible.util.b sre = new com.tencent.mm.compatible.util.b(ah.getContext());
    private boolean srf;
    final long srg = 987;
    int srh;
    private final d sri = new d(this);
    private final e srj;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class d extends com.tencent.mm.sdk.b.c<lp> {
        final /* synthetic */ p srl;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            final /* synthetic */ d srs;
            final /* synthetic */ lp srt;

            a(d dVar, lp lpVar) {
                this.srs = dVar;
                this.srt = lpVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                int i;
                cek cek;
                String str = null;
                AppMethodBeat.i(110977);
                i iVar = this.srs.srl.srb;
                if (iVar != null) {
                    i = iVar.fDG;
                } else {
                    i = 0;
                }
                i iVar2 = this.srs.srl.srb;
                if (iVar2 != null) {
                    cek = iVar2.rWj;
                } else {
                    cek = null;
                }
                if (i > 0 && cek != null) {
                    String str2 = this.srt.cHq.cHr;
                    s sVar = s.rTV;
                    if (j.j(str2, s.be(i, cek.Url))) {
                        String filePath;
                        String str3 = this.srs.srl.TAG;
                        StringBuilder append = new StringBuilder().append(this.srt.cHq.cHr).append(" video source changed, filePath:");
                        StoryVideoView storyVideoView = this.srs.srl.sqW;
                        if (storyVideoView != null) {
                            filePath = storyVideoView.getFilePath();
                        } else {
                            filePath = null;
                        }
                        ab.i(str3, append.append(filePath).toString());
                        p.a(this.srs.srl, false, 2);
                        storyVideoView = this.srs.srl.sqW;
                        if (storyVideoView != null) {
                            str = storyVideoView.getFilePath();
                        }
                        com.tencent.mm.vfs.e.deleteFile(str);
                        iVar = this.srs.srl.srb;
                        if (iVar != null) {
                            s sVar2 = s.rTV;
                            n a = s.a(iVar);
                            a.cCe();
                            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                            com.tencent.mm.plugin.story.model.j.a.cxX().b(a);
                        }
                        this.srs.srl.cDe();
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(110977);
                return yVar;
            }
        }

        d(p pVar) {
            this.srl = pVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            Object valueOf;
            i iVar;
            AppMethodBeat.i(110978);
            lp lpVar = (lp) bVar;
            String str = this.srl.TAG;
            StringBuilder stringBuilder = new StringBuilder("onelinevideo event callback, retcode:");
            if (lpVar != null) {
                com.tencent.mm.g.a.lp.a aVar = lpVar.cHq;
                if (aVar != null) {
                    valueOf = Integer.valueOf(aVar.retCode);
                    ab.i(str, stringBuilder.append(valueOf).append(", currVideoItem:").append(this.srl.srb).toString());
                    if (!(lpVar == null || this.srl.srb == null)) {
                        iVar = this.srl.srb;
                        if ((iVar == null || iVar.cNE != 0) && lpVar.cHq.retCode == -21112) {
                            com.tencent.mm.ab.b.a(new a(this, lpVar));
                        }
                    }
                    AppMethodBeat.o(110978);
                    return false;
                }
            }
            valueOf = null;
            ab.i(str, stringBuilder.append(valueOf).append(", currVideoItem:").append(this.srl.srb).toString());
            iVar = this.srl.srb;
            com.tencent.mm.ab.b.a(new a(this, lpVar));
            AppMethodBeat.o(110978);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0015"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
    public static final class e implements com.tencent.mm.pluginsdk.ui.h.b {
        final /* synthetic */ p srl;

        e(p pVar) {
            this.srl = pVar;
        }

        public final void c(String str, String str2, String str3, int i, int i2) {
            AppMethodBeat.i(110979);
            ab.i(this.srl.TAG, "videoViewCallback onError: " + str + ", meidiaId:" + str2 + ", errorMsg:" + str3 + ", what:" + i + ", extra:" + i2);
            AppMethodBeat.o(110979);
        }

        public final void cp(String str, String str2) {
            AppMethodBeat.i(110980);
            ab.i(this.srl.TAG, "videoViewCallback onPrepared: " + str + ", meidiaId:" + str2);
            AppMethodBeat.o(110980);
        }

        public final void cq(String str, String str2) {
            AppMethodBeat.i(110981);
            ab.i(this.srl.TAG, "videoViewCallback onVideoEnded: " + str + ", meidiaId:" + str2);
            h hVar = h.scu;
            ar cAs = h.cAs();
            cAs.bQ(cAs.FO() + 1);
            i iVar = this.srl.srb;
            if (iVar != null) {
                com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
                long j = iVar.rUJ;
                if (com.tencent.mm.plugin.story.g.b.aiG()) {
                    ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(j)));
                    if (com.tencent.mm.plugin.story.g.b.sbi.containsKey(Long.valueOf(j))) {
                        com.tencent.mm.plugin.story.g.b.a aVar = (com.tencent.mm.plugin.story.g.b.a) com.tencent.mm.plugin.story.g.b.sbi.get(Long.valueOf(j));
                        if (aVar != null) {
                            aVar.eTf = true;
                            AppMethodBeat.o(110981);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(110981);
                return;
            }
            AppMethodBeat.o(110981);
        }

        public final void d(String str, String str2, int i, int i2) {
            AppMethodBeat.i(110982);
            ab.i(this.srl.TAG, "videoViewCallback onGetVideoSize: " + str + ", " + this.srl.sqZ + ", meidiaId:" + str2);
            AppMethodBeat.o(110982);
        }

        public final void cr(String str, String str2) {
            AppMethodBeat.i(110983);
            ab.i(this.srl.TAG, "videoViewCallback onVideoPause: " + str + ", meidiaId:" + str2);
            AppMethodBeat.o(110983);
        }

        public final void cs(String str, String str2) {
            String sessionId;
            AppMethodBeat.i(110984);
            String str3 = this.srl.TAG;
            StringBuilder append = new StringBuilder("videoViewCallback onVideoPlay: ").append(str).append(' ');
            StoryVideoView storyVideoView = this.srl.sqW;
            if (storyVideoView != null) {
                sessionId = storyVideoView.getSessionId();
            } else {
                sessionId = null;
            }
            ab.i(str3, append.append(sessionId).append(", ").append(this.srl.sqZ).append(", meidiaId:").append(str2).append(", isVideoPause:").append(this.srl.sqY).toString());
            if (u.I(str, this.srl.sqZ, false) && this.srl.sqY) {
                storyVideoView = this.srl.sqW;
                if (!(storyVideoView == null || storyVideoView.sqC)) {
                    this.srl.r(null);
                }
            }
            i iVar = this.srl.srb;
            if (iVar != null) {
                com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                com.tencent.mm.plugin.story.g.c.lm(iVar.rUJ);
                com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
                long j = iVar.rUJ;
                if (com.tencent.mm.plugin.story.g.b.aiG()) {
                    str3 = "MicroMsg.StoryBrowseDetailIDKeyStat";
                    append = new StringBuilder("onVideoPlay storyId ").append(j).append(" lastStoryId ").append(com.tencent.mm.plugin.story.g.b.sbh).append(" contains:").append(com.tencent.mm.plugin.story.g.b.sbi.containsKey(Long.valueOf(j))).append(" result");
                    com.tencent.mm.plugin.story.g.b.a aVar = (com.tencent.mm.plugin.story.g.b.a) com.tencent.mm.plugin.story.g.b.sbi.get(Long.valueOf(j));
                    ab.v(str3, append.append(aVar != null ? Long.valueOf(aVar.sbz) : null).toString());
                    if (j == com.tencent.mm.plugin.story.g.b.sbh && com.tencent.mm.plugin.story.g.b.sbi.containsKey(Long.valueOf(j))) {
                        aVar = (com.tencent.mm.plugin.story.g.b.a) com.tencent.mm.plugin.story.g.b.sbi.get(Long.valueOf(j));
                        if (aVar != null && !aVar.rmk && aVar.sbz <= 0 && aVar.sby > 0) {
                            aVar.isWaiting = false;
                            long gb = bo.gb(aVar.sby);
                            aVar.sbz = bo.anU();
                            if (gb > 120000) {
                                ab.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + j + " onPlayCostTime:" + gb);
                            } else {
                                ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + j + " onPlayCostTime:" + gb);
                                com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 31, gb);
                                com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 30, 1);
                                if (gb <= 400) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 90, 1);
                                } else if (gb <= 800) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 91, 1);
                                } else if (gb <= 1600) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 92, 1);
                                } else if (gb <= 3200) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 93, 1);
                                } else if (gb <= 5000) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 94, 1);
                                } else {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 95, 1);
                                }
                                if (gb <= 400) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 50, 1);
                                } else if (gb <= 800) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 51, 1);
                                } else if (gb <= 1000) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 52, 1);
                                } else if (gb <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 53, 1);
                                } else if (gb <= 3000) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 54, 1);
                                } else if (gb <= 4000) {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 55, 1);
                                } else {
                                    com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 56, 1);
                                }
                                if (j == com.tencent.mm.plugin.story.g.b.sbk) {
                                    if (com.tencent.mm.plugin.story.g.b.sbo) {
                                        com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 40, 1);
                                        com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 42, gb);
                                    } else {
                                        com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 41, 1);
                                        com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 43, gb);
                                    }
                                    if (gb <= 1000) {
                                        if (com.tencent.mm.plugin.story.g.b.sbo) {
                                            com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 44, 1);
                                        } else {
                                            com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 45, 1);
                                        }
                                    } else if (gb <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                        if (com.tencent.mm.plugin.story.g.b.sbo) {
                                            com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 46, 1);
                                        } else {
                                            com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 47, 1);
                                        }
                                    } else if (com.tencent.mm.plugin.story.g.b.sbo) {
                                        com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 48, 1);
                                    } else {
                                        com.tencent.mm.plugin.story.g.b.l(com.tencent.mm.plugin.story.g.b.lhy, 49, 1);
                                    }
                                }
                            }
                        }
                    }
                }
                n.sqi.lA(iVar.rUJ);
                com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
                com.tencent.mm.plugin.story.model.k.aao(iVar.username);
                AppMethodBeat.o(110984);
                return;
            }
            AppMethodBeat.o(110984);
        }

        public final void ct(String str, String str2) {
            AppMethodBeat.i(110985);
            ab.i(this.srl.TAG, "videoViewCallback onVideoWaiting: " + str + ", meidiaId:" + str2);
            i iVar = this.srl.srb;
            if (iVar != null) {
                com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                com.tencent.mm.plugin.story.g.c.ll(iVar.rUJ);
                com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
                long j = iVar.rUJ;
                if (com.tencent.mm.plugin.story.g.b.aiG() && com.tencent.mm.plugin.story.g.b.sbi.containsKey(Long.valueOf(j))) {
                    com.tencent.mm.plugin.story.g.b.a aVar = (com.tencent.mm.plugin.story.g.b.a) com.tencent.mm.plugin.story.g.b.sbi.get(Long.valueOf(j));
                    if (!(aVar == null || aVar.rmk || !aVar.sbA)) {
                        aVar.isWaiting = true;
                        AppMethodBeat.o(110985);
                        return;
                    }
                }
                AppMethodBeat.o(110985);
                return;
            }
            AppMethodBeat.o(110985);
        }

        public final void cu(String str, String str2) {
            String sessionId;
            AppMethodBeat.i(110986);
            String str3 = this.srl.TAG;
            StringBuilder append = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(str).append(' ');
            StoryVideoView storyVideoView = this.srl.sqW;
            if (storyVideoView != null) {
                sessionId = storyVideoView.getSessionId();
            } else {
                sessionId = null;
            }
            ab.i(str3, append.append(sessionId).append(", ").append(this.srl.sqZ).append(", meidiaId:").append(str2).append(", isVideoPause:").append(this.srl.sqY).toString());
            if (u.I(str, this.srl.sqZ, false) && this.srl.sqY) {
                storyVideoView = this.srl.sqW;
                if (storyVideoView == null) {
                    AppMethodBeat.o(110986);
                    return;
                } else if (!storyVideoView.sqC) {
                    this.srl.r(null);
                }
            }
            AppMethodBeat.o(110986);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\u0010 \u001a\u00060!R\u00020\"H\u0002J \u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0016J \u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0012\u0010(\u001a\u00020'2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010)\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010*\u001a\u00020'2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
    final class b implements com.tencent.mm.modelvideo.b {
        final String TAG = "MicroMsg.VideoPlayProxy";
        int cFa;
        private com.tencent.mm.modelvideo.b.a hYm;
        boolean sqx;
        i sqy;
        n srk;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ int srn;
            final /* synthetic */ int sro;
            final /* synthetic */ b srr;

            a(b bVar, String str, int i, int i2) {
                this.srr = bVar;
                this.sqz = str;
                this.srn = i;
                this.sro = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110970);
                i iVar = this.srr.sqy;
                if (iVar != null) {
                    b bVar = this.srr;
                    s sVar = s.rTV;
                    bVar.srk = s.a(iVar);
                }
                o.alm();
                int k = com.tencent.mm.al.e.k(this.sqz, this.srn, this.sro);
                String str = this.srr.TAG;
                StringBuilder append = new StringBuilder("requestVideoData ").append(this.sqz).append(' ').append(this.srn).append(' ').append(this.sro).append(' ');
                n nVar = this.srr.srk;
                ab.i(str, append.append(nVar != null ? Integer.valueOf(nVar.field_cacheSize) : null).append(", ret:").append(k).append(" this:").append(this.srr).toString());
                y yVar = y.AUy;
                AppMethodBeat.o(110970);
                return yVar;
            }
        }

        public final void p(i iVar) {
            AppMethodBeat.i(110971);
            j.p(iVar, "item");
            this.sqy = iVar;
            s sVar = s.rTV;
            this.srk = s.a(iVar);
            ab.i(this.TAG, "setStoryVideoItem " + iVar + " videoCache " + this.srk);
            AppMethodBeat.o(110971);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00fc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void r(String str, String str2, String str3) {
            int i = 0;
            Object obj = null;
            AppMethodBeat.i(110972);
            ab.i(this.TAG, "startHttpStream " + str + ' ' + str2 + ' ' + str3 + " this:" + this);
            if (this.sqy != null) {
                String str4;
                s sVar = s.rTV;
                i iVar = this.sqy;
                if (iVar == null) {
                    j.dWJ();
                }
                this.srk = s.a(iVar);
                n nVar = this.srk;
                if (!(nVar == null || com.tencent.mm.vfs.e.ct(nVar.field_filePath))) {
                    com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    String str5 = nVar.field_filePath;
                    j.o(str5, "it.field_filePath");
                    com.tencent.mm.plugin.story.model.l.aay(str5);
                    ab.i(this.TAG, "startHttpStream error downloadFinish " + nVar.Jo() + " ret:" + com.tencent.mm.vfs.e.ct(nVar.field_filePath) + " path:" + nVar.field_filePath);
                    nVar.cCe();
                    com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cxX().b(nVar);
                }
                iVar = p.this.srb;
                if (iVar != null) {
                    com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                    com.tencent.mm.plugin.story.g.c.czW();
                    com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
                    long j = iVar.rUJ;
                    if (com.tencent.mm.plugin.story.g.b.aiG()) {
                        ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(j)));
                        if (com.tencent.mm.plugin.story.g.b.sbi.containsKey(Long.valueOf(j))) {
                            com.tencent.mm.plugin.story.g.b.a aVar2 = (com.tencent.mm.plugin.story.g.b.a) com.tencent.mm.plugin.story.g.b.sbi.get(Long.valueOf(j));
                            if (aVar2 != null) {
                                aVar2.sbA = true;
                            }
                        }
                    }
                }
                iVar = this.sqy;
                if (iVar != null) {
                    cek cek = iVar.rWj;
                    if (cek != null) {
                        str4 = cek.Url;
                        if (!bo.isNullOrNil(str4)) {
                            p pVar = p.this;
                            pVar.srh++;
                            StoryVideoView storyVideoView = pVar.sqW;
                            if (storyVideoView != null) {
                                storyVideoView.setNeedShowLoading(true);
                            }
                            a aVar3 = new a();
                            aVar3.hYm = this.hYm;
                            aVar3.a(this.srk, this.sqy);
                            com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
                            a aVar4 = new a();
                            aVar4.hYm = this.hYm;
                            aVar4.a(this.srk, this.sqy);
                            hVar.field_mediaId = str;
                            hVar.url = str3;
                            hVar.egD = 1;
                            hVar.egy = 6;
                            hVar.concurrentCount = 4;
                            hVar.field_fullpath = str2;
                            hVar.egK = aVar3;
                            hVar.field_fileType = com.tencent.mm.i.a.efK;
                            hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.v(1, str2);
                            n nVar2 = n.sqi;
                            iVar = this.sqy;
                            if (iVar == null) {
                                j.dWJ();
                            }
                            n.h(iVar);
                            iVar = p.this.srb;
                            if (iVar != null) {
                                boolean z;
                                com.tencent.mm.plugin.story.g.b bVar2 = com.tencent.mm.plugin.story.g.b.sbw;
                                long j2 = iVar.rUJ;
                                if (this.srk != null) {
                                    nVar = this.srk;
                                    if (nVar == null || nVar.field_cacheSize != 0) {
                                        z = false;
                                        com.tencent.mm.plugin.story.g.b.z(j2, z);
                                    }
                                }
                                z = true;
                                com.tencent.mm.plugin.story.g.b.z(j2, z);
                            }
                            o.alm().a(hVar);
                            if (!(this.sqy == null || str == null)) {
                                nVar2 = n.sqi;
                                iVar = this.sqy;
                                if (iVar == null) {
                                    j.dWJ();
                                }
                                com.tencent.mm.plugin.story.ui.view.gallery.n.b i2 = n.i(iVar);
                                if (i2.sqw && !aVar3.sqw) {
                                    Object valueOf;
                                    String str6 = this.TAG;
                                    StringBuilder append = new StringBuilder("checkPreloadOnVideoPlay ").append(str).append(", moovReady, offset:").append(i2.xb).append(", length:").append(i2.bgY).append(", cacheSize:");
                                    nVar = this.srk;
                                    if (nVar != null) {
                                        valueOf = Integer.valueOf(nVar.field_cacheSize);
                                    } else {
                                        valueOf = null;
                                    }
                                    StringBuilder append2 = append.append(valueOf).append(", totalSize:");
                                    n nVar3 = this.srk;
                                    if (nVar3 != null) {
                                        obj = Integer.valueOf(nVar3.field_totalSize);
                                    }
                                    ab.i(str6, append2.append(obj).append(", preloadFinish:").append(i2.sqx).toString());
                                    if (i2.xb > 0 && i2.bgY > 0) {
                                        aVar3.onMoovReady(str, (int) i2.xb, (int) i2.bgY);
                                        nVar = this.srk;
                                        if (nVar != null) {
                                            i = nVar.field_cacheSize;
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
                if (bo.isNullOrNil(str4)) {
                }
            }
            AppMethodBeat.o(110972);
        }

        /* JADX WARNING: Missing block: B:30:0x00e8, code skipped:
            if (r0 == null) goto L_0x00ea;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dV(String str) {
            Integer valueOf;
            int i;
            String filePath;
            long j;
            int i2 = 2;
            int i3 = 1;
            Long l = null;
            AppMethodBeat.i(110973);
            j.p(str, "mediaId");
            ab.i(this.TAG, "this: " + this + " stop " + str + ' ' + bo.dpG());
            Object[] objArr = new Object[17];
            StoryVideoView storyVideoView = p.this.sqW;
            objArr[0] = storyVideoView != null ? Integer.valueOf(storyVideoView.getCurrPosMs()) : Integer.valueOf(0);
            storyVideoView = p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf((int) storyVideoView.getFirstPlayWaitTime());
            } else {
                valueOf = null;
            }
            objArr[1] = valueOf;
            storyVideoView = p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.cCZ());
            } else {
                valueOf = null;
            }
            objArr[2] = valueOf;
            storyVideoView = p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.cDa());
            } else {
                valueOf = null;
            }
            objArr[3] = valueOf;
            storyVideoView = p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.cDb());
            } else {
                valueOf = null;
            }
            objArr[4] = valueOf;
            storyVideoView = p.this.sqW;
            if (storyVideoView != null) {
                valueOf = Integer.valueOf(storyVideoView.getStayTime());
            } else {
                valueOf = null;
            }
            objArr[5] = valueOf;
            storyVideoView = p.this.sqW;
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
            com.tencent.mm.plugin.story.e.c.a aVar = com.tencent.mm.plugin.story.e.c.rRS;
            storyVideoView = p.this.sqW;
            if (storyVideoView != null) {
                filePath = storyVideoView.getFilePath();
            }
            filePath = "";
            objArr[10] = com.tencent.mm.plugin.story.e.c.a.aak(filePath);
            i iVar = this.sqy;
            if (iVar != null) {
                l = Long.valueOf(iVar.rUJ);
            }
            objArr[11] = l;
            h hVar = h.scu;
            objArr[12] = Long.valueOf(h.cAs().FF());
            hVar = h.scu;
            objArr[13] = Long.valueOf(h.cAs().FH());
            hVar = h.scu;
            if (h.cAs().FK() != 1) {
                i3 = 0;
            }
            objArr[14] = Integer.valueOf(i3);
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            i iVar2 = this.sqy;
            if (iVar2 != null) {
                j = iVar2.rUJ;
            } else {
                j = 0;
            }
            objArr[15] = Integer.valueOf(cxT.ly(j));
            objArr[16] = Integer.valueOf(p.this.srh);
            ab.i(this.TAG, "reportTips: " + Arrays.toString(objArr));
            o.alm().l(str, objArr);
            AppMethodBeat.o(110973);
        }

        public final void requestVideoData(String str, int i, int i2) {
            AppMethodBeat.i(110974);
            j.p(str, "mediaId");
            com.tencent.mm.ab.b.a(new a(this, str, i, i2));
            AppMethodBeat.o(110974);
        }

        public final boolean isVideoDataAvailable(String str, int i, int i2) {
            String str2;
            StringBuilder append;
            n nVar;
            Object obj = null;
            AppMethodBeat.i(110975);
            j.p(str, "mediaId");
            i iVar = this.sqy;
            if (iVar != null) {
                s sVar = s.rTV;
                this.srk = s.a(iVar);
                n nVar2 = this.srk;
                if (nVar2 != null && nVar2.Jo()) {
                    str2 = this.TAG;
                    append = new StringBuilder("isVideoDataAvailable ").append(str).append(", ").append(i).append(", ").append(i2).append(", download finish cacheSize:");
                    nVar = this.srk;
                    if (nVar != null) {
                        obj = Integer.valueOf(nVar.field_cacheSize);
                    }
                    ab.i(str2, append.append(obj).append(" this:").append(this).toString());
                    AppMethodBeat.o(110975);
                    return true;
                }
            }
            boolean isVideoDataAvailable = o.alm().isVideoDataAvailable(str, i, i2);
            str2 = this.TAG;
            append = new StringBuilder("isVideoDataAvailable ").append(str).append(", ").append(i).append(", ").append(i2).append(", available:").append(isVideoDataAvailable).append(" cacheSize:");
            nVar = this.srk;
            if (nVar != null) {
                obj = Integer.valueOf(nVar.field_cacheSize);
            }
            ab.i(str2, append.append(obj).append(" this:").append(this).toString());
            AppMethodBeat.o(110975);
            return isVideoDataAvailable;
        }

        public final void a(com.tencent.mm.modelvideo.b.a aVar) {
            this.hYm = aVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
    public static final class c implements com.tencent.mm.pluginsdk.ui.h.c {
        final /* synthetic */ p srl;

        c(p pVar) {
            this.srl = pVar;
        }

        public final void gp(long j) {
            AppMethodBeat.i(110976);
            StoryVideoView storyVideoView = this.srl.sqW;
            if (storyVideoView != null) {
                if (!storyVideoView.sqC) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(this.srl.srg, j, 1, false);
                    if (j >= 141 && j <= 145) {
                        ab.i(this.srl.TAG, "initCreateVideoView test key " + j + " value 1 currVideoItem:" + this.srl.srb + ' ' + bo.dpG());
                    }
                }
                AppMethodBeat.o(110976);
                return;
            }
            AppMethodBeat.o(110976);
        }

        public final void wB(String str) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
    final class a implements com.tencent.mm.i.h.a {
        final String TAG = "MicroMsg.VideoPlayProxy";
        com.tencent.mm.modelvideo.b.a hYm;
        volatile boolean sqw;
        i sqy;
        n srk;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ a srm;
            final /* synthetic */ int srn;
            final /* synthetic */ int sro;

            a(a aVar, String str, int i, int i2) {
                this.srm = aVar;
                this.sqz = str;
                this.srn = i;
                this.sro = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110962);
                StoryVideoView storyVideoView = p.this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.onDataAvailable(this.sqz, this.srn, this.sro);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(110962);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class b extends k implements a.f.a.a<y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ a srm;
            final /* synthetic */ int srp;

            b(a aVar, String str, int i) {
                this.srm = aVar;
                this.sqz = str;
                this.srp = i;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110963);
                com.tencent.mm.modelvideo.b.a aVar = this.srm.hYm;
                if (aVar != null) {
                    aVar.ad(this.sqz, this.srp);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(110963);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class d extends k implements a.f.a.a<y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ a srm;
            final /* synthetic */ int srn;
            final /* synthetic */ int srq;

            d(a aVar, String str, int i, int i2) {
                this.srm = aVar;
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
                y yVar;
                AppMethodBeat.i(110965);
                p pVar = p.this;
                String str = pVar.TAG;
                StringBuilder append = new StringBuilder("checkPauseOnProgress, isVideoPause:").append(pVar.sqY).append(", ");
                StoryVideoView storyVideoView = pVar.sqW;
                ab.i(str, append.append(storyVideoView != null ? storyVideoView.getSessionId() : null).append(", ").append(pVar.sqZ).toString());
                if (pVar.sqY) {
                    String sessionId;
                    storyVideoView = pVar.sqW;
                    if (storyVideoView != null) {
                        sessionId = storyVideoView.getSessionId();
                    } else {
                        sessionId = null;
                    }
                    if (u.I(sessionId, pVar.sqZ, false)) {
                        pVar.r(null);
                        z = true;
                        if (z) {
                            storyVideoView = p.this.sqW;
                            if (storyVideoView != null) {
                                storyVideoView.h(this.sqz, this.srn, this.srq);
                            }
                            n nVar = this.srm.srk;
                            if (nVar != null) {
                                nVar.field_totalSize = this.srq;
                            }
                            nVar = this.srm.srk;
                            if (nVar != null) {
                                nVar.field_cacheSize = this.srn;
                            }
                            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                            boolean c = com.tencent.mm.plugin.story.model.j.a.cxX().c(this.srm.srk, new String[0]);
                            i iVar = this.srm.sqy;
                            if (iVar != null) {
                                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                                f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(iVar.username);
                                if (aap.field_syncId == iVar.rUJ && aap.isValid() && this.srm.srk != null) {
                                    int i;
                                    long j = iVar.rUJ;
                                    String str2 = iVar.rWj.Id;
                                    j.o(str2, "it.media.Id");
                                    nVar = this.srm.srk;
                                    if (nVar != null) {
                                        i = nVar.field_cacheSize;
                                    } else {
                                        i = 0;
                                    }
                                    if (aap.b(j, str2, i)) {
                                        ab.i(this.srm.TAG, "markPreloadCompleted onProgress, mediaId:" + this.sqz + ", offset:" + this.srn + ", total:" + this.srq + " this:" + this.srm);
                                        aVar = com.tencent.mm.plugin.story.model.j.rST;
                                        com.tencent.mm.plugin.story.model.j.a.cxU().a((long) ((int) aap.xDa), aap);
                                    }
                                }
                            }
                            ab.i(this.srm.TAG, "onProgress, update ret " + c + " mediaId:" + this.sqz + ", offset:" + this.srn + ", total:" + this.srq + " this:" + this.srm);
                        } else {
                            ab.i(this.srm.TAG, "checkPauseOnProgress return");
                        }
                        yVar = y.AUy;
                        AppMethodBeat.o(110965);
                        return yVar;
                    }
                }
                z = false;
                if (z) {
                }
                yVar = y.AUy;
                AppMethodBeat.o(110965);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class c extends k implements a.f.a.a<y> {
            final /* synthetic */ String sqz;
            final /* synthetic */ a srm;
            final /* synthetic */ int srn;
            final /* synthetic */ int sro;

            c(a aVar, String str, int i, int i2) {
                this.srm = aVar;
                this.sqz = str;
                this.srn = i;
                this.sro = i2;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110964);
                StoryVideoView storyVideoView = p.this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.ml(this.srn);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(110964);
                return yVar;
            }
        }

        public final void a(n nVar, i iVar) {
            this.srk = nVar;
            this.sqy = iVar;
        }

        public final void onMoovReady(String str, int i, int i2) {
            String str2;
            AppMethodBeat.i(110966);
            j.p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onMoovReady, mediaId:").append(str).append(", offset:").append(i).append(", length:").append(i2).append(", isMoovReady:").append(this.sqw).append(" this:").append(this).append(" currVideoItem:");
            i iVar = p.this.srb;
            if (iVar != null) {
                str2 = iVar.username;
            } else {
                str2 = null;
            }
            ab.i(str3, append.append(str2).toString());
            if (this.sqw) {
                AppMethodBeat.o(110966);
                return;
            }
            this.sqw = true;
            com.tencent.mm.ab.b.a(new c(this, str, i, i2));
            AppMethodBeat.o(110966);
        }

        public final void onDataAvailable(String str, int i, int i2) {
            String str2;
            AppMethodBeat.i(110967);
            j.p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onDataAvailable, mediaId:").append(str).append(", offset:").append(i).append(", length:").append(i2).append(" this:").append(this).append(" currVideoItem:");
            i iVar = p.this.srb;
            if (iVar != null) {
                str2 = iVar.username;
            } else {
                str2 = null;
            }
            ab.i(str3, append.append(str2).toString());
            com.tencent.mm.ab.b.a(new a(this, str, i, i2));
            AppMethodBeat.o(110967);
        }

        public final void h(String str, int i, int i2) {
            String str2;
            AppMethodBeat.i(110968);
            j.p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onProgress, mediaId:").append(str).append(", offset:").append(i).append(", total:").append(i2).append(" this:").append(this).append(" currVideoItem:");
            i iVar = p.this.srb;
            if (iVar != null) {
                str2 = iVar.username;
            } else {
                str2 = null;
            }
            ab.i(str3, append.append(str2).toString());
            com.tencent.mm.ab.b.a(new d(this, str, i, i2));
            AppMethodBeat.o(110968);
        }

        public final void a(String str, int i, com.tencent.mm.i.d dVar) {
            int i2;
            String str2;
            long j;
            int i3 = 0;
            String[] strArr = null;
            AppMethodBeat.i(110969);
            j.p(str, "mediaId");
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onFinish, mediaId:").append(str).append(", ret:").append(i).append(", sceneResult:");
            if (dVar != null) {
                i2 = dVar.field_retCode;
            } else {
                i2 = 0;
            }
            append = append.append(i2).append(" this:").append(this).append(" currVideoItem:");
            i iVar = p.this.srb;
            if (iVar != null) {
                str2 = iVar.username;
            } else {
                str2 = null;
            }
            ab.i(str3, append.append(str2).toString());
            iVar = this.sqy;
            if (iVar != null) {
                com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
                com.tencent.mm.plugin.story.g.b.lk(iVar.rUJ);
                n.sqi.lB(iVar.rUJ);
            }
            n nVar = this.srk;
            if (nVar != null) {
                str2 = nVar.field_filePath;
            } else {
                str2 = null;
            }
            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(str2);
            if (WR != null) {
                h hVar = h.scu;
                h.cAE().bq((long) WR.eWK);
                hVar = h.scu;
                h.cAE().br((long) WR.videoBitrate);
                hVar = h.scu;
                h.cAE().bs((long) WR.fzS);
                hVar = h.scu;
                h.cAE().bt((long) WR.eTk);
                hVar = h.scu;
                h.cAE().bu((long) WR.width);
                hVar = h.scu;
                h.cAE().bv((long) WR.height);
                hVar = h.scu;
                h.cAE().bw((long) WR.qwV);
            }
            h hVar2 = h.scu;
            an cAE = h.cAE();
            if (this.srk != null) {
                n nVar2 = this.srk;
                if (nVar2 == null) {
                    j.dWJ();
                }
                j = (long) nVar2.field_totalSize;
            } else {
                j = 0;
            }
            cAE.bp(j);
            hVar2 = h.scu;
            an cAE2 = h.cAE();
            nVar = this.srk;
            if (nVar != null) {
                str2 = nVar.field_url;
            } else {
                str2 = null;
            }
            cAE2.ft(str2);
            hVar2 = h.scu;
            cAE2 = h.cAE();
            com.tencent.mm.al.f.afy();
            nVar = this.srk;
            if (nVar != null) {
                str2 = nVar.field_filePath;
            } else {
                str2 = null;
            }
            cAE2.fu(com.tencent.mm.al.a.rJ(str2));
            if (dVar != null) {
                hVar2 = h.scu;
                h.cAE().bn(dVar.field_startTime);
                hVar2 = h.scu;
                h.cAE().bo(dVar.field_endTime);
            }
            if (dVar != null) {
                strArr = dVar.field_usedSvrIps;
            }
            if (strArr != null) {
                StringBuffer stringBuffer = new StringBuffer();
                strArr = dVar.field_usedSvrIps;
                int length = strArr.length;
                while (i3 < length) {
                    stringBuffer.append(strArr[i3]).append("|");
                    i3++;
                }
                h hVar3 = h.scu;
                h.cAE().fv(stringBuffer.toString());
            }
            if (p.this.sqX != null) {
                long j2;
                hVar2 = h.scu;
                cAE = h.cAE();
                b bVar2 = p.this.sqX;
                if (bVar2 == null) {
                    j.dWJ();
                }
                cAE.bx((long) bVar2.cFa);
                hVar2 = h.scu;
                an cAE3 = h.cAE();
                b bVar3 = p.this.sqX;
                if (bVar3 == null) {
                    j.dWJ();
                }
                if (bVar3.sqx) {
                    j2 = 3;
                } else {
                    bVar3 = p.this.sqX;
                    if (bVar3 == null) {
                        j.dWJ();
                    }
                    j2 = bVar3.cFa > 0 ? 2 : 1;
                }
                cAE3.by(j2);
            }
            hVar2 = h.scu;
            h.cAF();
            com.tencent.mm.ab.b.a(new b(this, str, i));
            AppMethodBeat.o(110969);
        }
    }

    public p() {
        AppMethodBeat.i(111001);
        ab.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
        com.tencent.mm.sdk.b.a.xxA.c(this.sri);
        this.srj = new e(this);
        AppMethodBeat.o(111001);
    }

    public final void a(ViewGroup viewGroup, LayoutParams layoutParams) {
        Object valueOf;
        AppMethodBeat.i(110987);
        j.p(viewGroup, "parent");
        this.srh = 0;
        boolean s = s(viewGroup);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("attachVideoView, parent:").append(viewGroup.hashCode()).append(", isVideoPause:").append(this.sqY).append(", currentSessionId:").append(this.sqZ).append(", isPlayingVideoItem:").append(this.sra).append(" videoView ");
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            valueOf = Integer.valueOf(storyVideoView.hashCode());
        } else {
            valueOf = null;
        }
        ab.c(str, append.append(valueOf).append(" sameParent ").append(s).append(" this:").append(hashCode()).toString(), new Object[0]);
        r(viewGroup);
        if (this.sqW == null) {
            Context context = ah.getContext();
            j.o(context, "MMApplicationContext.getContext()");
            eX(context);
        }
        if (s) {
            if (layoutParams != null) {
                storyVideoView = this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.setLayoutParams(layoutParams);
                    AppMethodBeat.o(110987);
                    return;
                }
            }
            AppMethodBeat.o(110987);
        } else if (layoutParams == null) {
            viewGroup.addView(this.sqW);
            AppMethodBeat.o(110987);
        } else {
            viewGroup.addView(this.sqW, layoutParams);
            AppMethodBeat.o(110987);
        }
    }

    public final void o(i iVar) {
        AppMethodBeat.i(110989);
        j.p(iVar, "item");
        boolean z = !n(iVar);
        ab.c(this.TAG, "change:" + z + " changeVideoItem: origin: " + this.srb + ", new: " + iVar + ", " + this.srd + " change:" + z + " this:" + hashCode(), new Object[0]);
        if (z) {
            this.srb = iVar;
            if (this.srd) {
                a(this, false, 2);
                cDe();
            }
        }
        AppMethodBeat.o(110989);
    }

    public final void cDe() {
        AppMethodBeat.i(110990);
        ab.c(this.TAG, "playVideo, " + this.sqY + ' ' + this.srd + ", " + this.srb, new Object[0]);
        cDf();
        this.srd = true;
        i iVar = this.srb;
        if (iVar != null) {
            boolean z = this.sqY;
            this.sqY = false;
            StoryVideoView storyVideoView;
            if (z) {
                storyVideoView = this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.m(iVar);
                }
            } else {
                this.sqZ = UUID.randomUUID().toString();
                b bVar = this.sqX;
                if (bVar != null) {
                    bVar.p(iVar);
                }
                storyVideoView = this.sqW;
                if (storyVideoView != null) {
                    storyVideoView.a(iVar, this.sqZ);
                }
            }
            this.sqY = false;
            if (iVar.czf()) {
                this.sra = true;
            }
            if (!this.srf) {
                this.sre.requestFocus();
                this.srf = true;
            }
        }
        h hVar = h.scu;
        ar cAs = h.cAs();
        StoryVideoView storyVideoView2 = this.sqW;
        cAs.bF((long) at.gC(storyVideoView2 != null ? storyVideoView2.getContext() : null));
        AppMethodBeat.o(110990);
    }

    /* Access modifiers changed, original: final */
    public final void cDf() {
        AppMethodBeat.i(110991);
        ab.i(this.TAG, "setVideoViewProp, isMute:" + this.eif);
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.setMute(this.eif);
            AppMethodBeat.o(110991);
            return;
        }
        AppMethodBeat.o(110991);
    }

    public static /* synthetic */ void a(p pVar, boolean z, int i) {
        AppMethodBeat.i(110993);
        if ((i & 2) != 0) {
            z = true;
        }
        pVar.N(false, z);
        AppMethodBeat.o(110993);
    }

    public final void N(boolean z, boolean z2) {
        AppMethodBeat.i(110992);
        ab.c(this.TAG, "stopVideo, detach: ".concat(String.valueOf(z)), new Object[0]);
        if (this.sra) {
            this.sqZ = null;
            StoryVideoView storyVideoView = this.sqW;
            if (storyVideoView != null) {
                storyVideoView.stop();
            }
            this.sqY = false;
            if (this.srf) {
                this.sre.Mm();
                this.srf = false;
            }
            this.sra = false;
        }
        if (z) {
            this.srd = false;
            r(null);
            h hVar = h.scu;
            h.cAs().bJ(System.currentTimeMillis());
            if (z2) {
                hVar = h.scu;
                h.cAt();
            }
        }
        AppMethodBeat.o(110992);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(110994);
        String str = "";
        j.o(str, "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
        ab.i(this.TAG, "setMute " + z + " ret " + str);
        this.eif = z;
        AppMethodBeat.o(110994);
    }

    public final void akW() {
        AppMethodBeat.i(110995);
        StoryVideoView storyVideoView = this.sqW;
        if (storyVideoView != null) {
            storyVideoView.akW();
            AppMethodBeat.o(110995);
            return;
        }
        AppMethodBeat.o(110995);
    }

    public final void akV() {
        AppMethodBeat.i(110996);
        ab.i(this.TAG, "onUIPause " + hashCode());
        r(null);
        if (this.srf) {
            this.sre.Mm();
            this.srf = false;
        }
        AppMethodBeat.o(110996);
    }

    public final void aEX() {
        AppMethodBeat.i(110997);
        ab.i(this.TAG, "onUIDestroy " + hashCode());
        this.srd = false;
        r(null);
        this.srb = null;
        this.sqW = null;
        if (this.srf) {
            this.sre.Mm();
            this.srf = false;
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.sri);
        AppMethodBeat.o(110997);
    }

    /* Access modifiers changed, original: final */
    public final void eX(Context context) {
        AppMethodBeat.i(110998);
        this.sqW = new StoryVideoView(context);
        this.sqX = new b();
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
            storyVideoView.setReporter(new c(this));
        }
        this.sra = false;
        AppMethodBeat.o(110998);
    }

    /* Access modifiers changed, original: final */
    public final void r(ViewGroup viewGroup) {
        int hashCode;
        ViewParent parent;
        AppMethodBeat.i(110999);
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
        ab.c(str, stringBuilder.append(parent2 != null ? parent2.hashCode() : 0).append(", newParent:").append(viewGroup != null ? viewGroup.hashCode() : 0).append(", isPlayingVideoItem:").append(this.sra).toString(), new Object[0]);
        storyVideoView = this.sqW;
        if (storyVideoView != null) {
            parent = storyVideoView.getParent();
        } else {
            parent = null;
        }
        if (!(parent == null || s(viewGroup))) {
            a(this, true, 1);
            storyVideoView = this.sqW;
            if (storyVideoView != null) {
                parent = storyVideoView.getParent();
            } else {
                parent = null;
            }
            if (parent == null) {
                v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(110999);
                throw vVar;
            }
            ((ViewGroup) parent).removeView(this.sqW);
            this.srb = null;
        }
        AppMethodBeat.o(110999);
    }

    private final boolean s(ViewGroup viewGroup) {
        AppMethodBeat.i(111000);
        StoryVideoView storyVideoView = this.sqW;
        boolean j = j.j(storyVideoView != null ? storyVideoView.getParent() : null, viewGroup);
        AppMethodBeat.o(111000);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean n(i iVar) {
        i iVar2;
        Object obj;
        AppMethodBeat.i(110988);
        if (iVar.cNE != 0) {
            iVar2 = this.srb;
            if (iVar2 != null && iVar2.cNE == iVar.cNE) {
                AppMethodBeat.o(110988);
                return true;
            }
        }
        CharSequence charSequence = iVar.rWj.Url;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            iVar2 = this.srb;
            if (iVar2 != null) {
                cek cek = iVar2.rWj;
                if (cek != null) {
                    obj = cek.Url;
                    if (j.j(obj, iVar.rWj.Url)) {
                        AppMethodBeat.o(110988);
                        return true;
                    }
                }
            }
            obj = null;
            if (j.j(obj, iVar.rWj.Url)) {
            }
        }
        AppMethodBeat.o(110988);
        return false;
    }
}
