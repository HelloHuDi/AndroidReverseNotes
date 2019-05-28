package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C42130g.C1629b;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.p823ab.C8902b.C8903a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.C0220l;
import p000a.C31826o;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C41380b;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005hijklB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u0004H\u0002J\u001e\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0;2\b\b\u0002\u0010<\u001a\u00020\u0004J.\u0010=\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u00062\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00042\b\b\u0002\u0010B\u001a\u000204H\u0002J\u0006\u0010C\u001a\u000209J\u000e\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020)J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020)2\b\b\u0002\u0010A\u001a\u00020\u0004J\u000e\u0010H\u001a\u0002092\u0006\u0010G\u001a\u00020)J\u000e\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020)J0\u0010K\u001a\u00020L2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\u0006\u0010P\u001a\u00020\u0004J\u0006\u0010Q\u001a\u000204J\u0006\u0010B\u001a\u000204J\u0010\u0010R\u001a\u0002042\u0006\u0010E\u001a\u00020)H\u0002J\u000e\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020\u0015J\u000e\u0010U\u001a\u0002092\u0006\u0010E\u001a\u00020)J\u000e\u0010V\u001a\u0002092\u0006\u0010T\u001a\u00020\u0015J\u0010\u0010W\u001a\u0002042\u0006\u0010E\u001a\u00020)H\u0002J\u0012\u0010X\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010Y\u001a\u0002042\u0006\u0010E\u001a\u00020)2\u0006\u0010Z\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010[\u001a\u00020,J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J4\u0010]\u001a\u0002042\u0012\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0;0;2\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\b\b\u0002\u0010b\u001a\u000204J\u0010\u0010c\u001a\u0002092\u0006\u0010d\u001a\u000204H\u0002J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u0004H\u0002J\u0010\u0010g\u001a\u0002092\u0006\u0010>\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)0'X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000b¨\u0006m"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n */
public final class C39933n {
    private static long sbh;
    private static C39932k spU = new C39932k();
    private static int spV;
    private static int spW;
    private static int spX;
    private static final Map<String, C35201i> spY;
    private static final Map<String, Integer> spZ;
    private static final Set<String> sqa;
    private static final List<C39934c> sqb;
    private static int sqc = 3;
    private static C29376a sqd = new C29376a(new ArrayList());
    private static volatile String sqe;
    private static volatile Long sqf;
    private static long sqg;
    private static long sqh;
    public static final C39933n sqi = new C39933n();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$b */
    public static final class C13892b {
        final long bgY;
        final boolean sqw;
        final boolean sqx;
        /* renamed from: xb */
        final long f2943xb;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof C13892b)) {
                    return false;
                }
                C13892b c13892b = (C13892b) obj;
                if (!(this.sqw == c13892b.sqw)) {
                    return false;
                }
                if (!(this.f2943xb == c13892b.f2943xb)) {
                    return false;
                }
                if (!(this.bgY == c13892b.bgY)) {
                    return false;
                }
                if (!(this.sqx == c13892b.sqx)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 1;
            int i2 = this.sqw;
            if (i2 != 0) {
                i2 = 1;
            }
            i2 *= 31;
            long j = this.f2943xb;
            i2 = (i2 + ((int) (j ^ (j >>> 32)))) * 31;
            j = this.bgY;
            int i3 = (i2 + ((int) (j ^ (j >>> 32)))) * 31;
            boolean z = this.sqx;
            if (!z) {
                boolean i4 = z;
            }
            return i3 + i4;
        }

        public final String toString() {
            AppMethodBeat.m2504i(110875);
            String str = "MoovReadyInfo(isMoovReady=" + this.sqw + ", offset=" + this.f2943xb + ", length=" + this.bgY + ", preloadFinish=" + this.sqx + ")";
            AppMethodBeat.m2505o(110875);
            return str;
        }

        public C13892b(boolean z, long j, long j2, boolean z2) {
            this.sqw = z;
            this.f2943xb = j;
            this.bgY = j2;
            this.sqx = z2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\u00020\n2\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u0002J*\u0010\u001c\u001a\u00020\n2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012J\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020#R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00120\u00110\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$a */
    public static final class C29376a {
        static final String TAG = TAG;
        public static final C13891a squ = new C13891a();
        private final int sqj;
        int sqk;
        int sqm;
        private int sqn;
        private ArrayList<C43640g> sqo;
        private ArrayList<C43640g> sqp;
        List<? extends C31214a<C31826o<C35201i, C39934c>>> sqq;
        int sqr;
        int sqs;
        private final boolean sqt;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$a$a */
        public static final class C13891a {
            private C13891a() {
            }

            public /* synthetic */ C13891a(byte b) {
                this();
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$a$b */
        static final class C29377b extends C25053k implements C31214a<C31826o<? extends C35201i, ? extends C39934c>> {
            final /* synthetic */ C29376a sqv;

            C29377b(C29376a c29376a) {
                this.sqv = c29376a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110863);
                C31826o a = C29376a.m46626a(this.sqv);
                AppMethodBeat.m2505o(110863);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$a$c */
        static final class C29378c extends C25053k implements C31214a<C31826o<? extends C35201i, ? extends C39934c>> {
            final /* synthetic */ C29376a sqv;

            C29378c(C29376a c29376a) {
                this.sqv = c29376a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110864);
                C31826o a = C29376a.m46626a(this.sqv);
                AppMethodBeat.m2505o(110864);
                return a;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$a$d */
        static final class C29379d extends C25053k implements C31214a<C31826o<? extends C35201i, ? extends C39934c>> {
            final /* synthetic */ C29376a sqv;

            C29379d(C29376a c29376a) {
                this.sqv = c29376a;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110865);
                C31826o b = C29376a.m46627b(this.sqv);
                AppMethodBeat.m2505o(110865);
                return b;
            }
        }

        public /* synthetic */ C29376a(List list) {
            this(list, 0, 0, null);
        }

        public C29376a(List<? extends List<C43640g>> list, int i, int i2, C29376a c29376a) {
            C37091y c37091y;
            C25052j.m39376p(list, "groupItems");
            AppMethodBeat.m2504i(110871);
            this.sqr = i;
            this.sqs = i2;
            this.sqt = true;
            this.sqj = 15;
            this.sqo = new ArrayList();
            this.sqp = new ArrayList();
            this.sqq = C7987l.listOf(new C29377b(this), new C29378c(this), new C29379d(this));
            if (!(c29376a == null || this.sqr == c29376a.sqr) || (!(c29376a == null || this.sqs == c29376a.sqs) || mo47616dL(list))) {
                reset();
            }
            this.sqo.clear();
            this.sqp.clear();
            Iterable<List> iterable = list;
            synchronized (iterable) {
                try {
                    for (List list2 : iterable) {
                        if (!((Collection) list2).isEmpty()) {
                            this.sqp.add(list2.get(0));
                        }
                    }
                    c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(110871);
                }
            }
            if (this.sqr < list.size()) {
                Iterable<C43640g> iterable2 = (Iterable) list.get(this.sqr);
                synchronized (iterable2) {
                    try {
                        for (C43640g add : iterable2) {
                            this.sqo.add(add);
                        }
                        c37091y = C37091y.AUy;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(110871);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(110871);
        }

        /* renamed from: a */
        public static final /* synthetic */ C31826o m46626a(C29376a c29376a) {
            AppMethodBeat.m2504i(110873);
            C31826o cCX = c29376a.cCX();
            AppMethodBeat.m2505o(110873);
            return cCX;
        }

        /* renamed from: b */
        public static final /* synthetic */ C31826o m46627b(C29376a c29376a) {
            AppMethodBeat.m2504i(110874);
            C31826o cCY = c29376a.cCY();
            AppMethodBeat.m2505o(110874);
            return cCY;
        }

        static {
            AppMethodBeat.m2504i(110872);
            AppMethodBeat.m2505o(110872);
        }

        /* Access modifiers changed, original: final */
        public final C31826o<C35201i, C39934c> cCV() {
            AppMethodBeat.m2504i(110866);
            try {
                if (this.sqn > this.sqj) {
                    C4990ab.m7416i(TAG, "stop preload now " + this.sqn);
                    AppMethodBeat.m2505o(110866);
                    return null;
                }
                C31826o<C35201i, C39934c> c31826o = (C31826o) ((C31214a) this.sqq.get(this.sqn % this.sqq.size())).invoke();
                this.sqn++;
                AppMethodBeat.m2505o(110866);
                return c31826o;
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "error on produce", new Object[0]);
                AppMethodBeat.m2505o(110866);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dL */
        public final boolean mo47616dL(List<? extends List<C43640g>> list) {
            AppMethodBeat.m2504i(110867);
            if (list.size() == this.sqp.size()) {
                int size = list.size();
                int i = 0;
                while (i < size) {
                    if (((List) list.get(i)).isEmpty()) {
                        AppMethodBeat.m2505o(110867);
                        return true;
                    } else if (((C43640g) this.sqp.get(i)).rVZ.cNE != ((C43640g) ((List) list.get(i)).get(0)).rVZ.cNE) {
                        AppMethodBeat.m2505o(110867);
                        return true;
                    } else {
                        i++;
                    }
                }
                AppMethodBeat.m2505o(110867);
                return false;
            }
            AppMethodBeat.m2505o(110867);
            return true;
        }

        private final void reset() {
            this.sqk = this.sqr;
            this.sqm = this.sqs;
            this.sqn = 0;
        }

        public final void cCW() {
            AppMethodBeat.m2504i(110868);
            C4990ab.m7416i(TAG, "resetWalk");
            reset();
            AppMethodBeat.m2505o(110868);
        }

        /* JADX WARNING: Missing block: B:14:0x003f, code skipped:
            r0 = new p000a.C31826o(r2, new com.tencent.p177mm.plugin.story.p536ui.view.gallery.C39933n.C39934c(r6.sqk, 0, r2));
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final C31826o<C35201i, C39934c> cCX() {
            AppMethodBeat.m2504i(110869);
            while (true) {
                if (this.sqt) {
                    this.sqk++;
                }
                if (this.sqk >= this.sqp.size()) {
                    AppMethodBeat.m2505o(110869);
                    return null;
                }
                try {
                    if (this.sqp.size() > 0) {
                        C35201i c35201i = ((C43640g) this.sqp.get(this.sqk)).rVZ;
                        C39933n c39933n = C39933n.sqi;
                        C35201i c35201i2 = C39933n.m68389l(c35201i) ? c35201i : null;
                        if (c35201i2 != null) {
                            break;
                        }
                    }
                    if (!this.sqt) {
                        this.sqk++;
                    }
                } finally {
                    if (!this.sqt) {
                        this.sqk++;
                    }
                    AppMethodBeat.m2505o(110869);
                }
            }
            return r0;
        }

        /* JADX WARNING: Missing block: B:14:0x0041, code skipped:
            r0 = new p000a.C31826o(r2, new com.tencent.p177mm.plugin.story.p536ui.view.gallery.C39933n.C39934c(r6.sqk, r6.sqm, r2));
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final C31826o<C35201i, C39934c> cCY() {
            AppMethodBeat.m2504i(110870);
            while (true) {
                if (this.sqt) {
                    this.sqm++;
                }
                if (this.sqm >= this.sqo.size()) {
                    AppMethodBeat.m2505o(110870);
                    return null;
                }
                try {
                    if (this.sqo.size() > this.sqm) {
                        C35201i c35201i = ((C43640g) this.sqo.get(this.sqm)).rVZ;
                        C39933n c39933n = C39933n.sqi;
                        C35201i c35201i2 = C39933n.m68389l(c35201i) ? c35201i : null;
                        if (c35201i2 != null) {
                            break;
                        }
                    }
                    if (!this.sqt) {
                        this.sqm++;
                    }
                } finally {
                    if (!this.sqt) {
                        this.sqm++;
                    }
                    AppMethodBeat.m2505o(110870);
                }
            }
            return r0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u000bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$c */
    public static final class C39934c {
        private int connectionCount;
        int ehE;
        String fUL;
        private final int sqr;
        private final int sqs;
        final C35201i sqy;

        public /* synthetic */ C39934c(int i, int i2, C35201i c35201i) {
            this(i, i2, c35201i, 0, 1);
        }

        public C39934c(int i, int i2, C35201i c35201i, int i3, int i4) {
            C25052j.m39376p(c35201i, "item");
            AppMethodBeat.m2504i(110876);
            this.sqr = i;
            this.sqs = i2;
            this.sqy = c35201i;
            this.ehE = i3;
            this.connectionCount = i4;
            C43649s c43649s = C43649s.rTV;
            String be = C43649s.m78156be(this.sqy.fDG, this.sqy.rWj.Url);
            if (be == null) {
                be = "";
            }
            this.fUL = be;
            AppMethodBeat.m2505o(110876);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$d */
    static final class C39935d implements C1629b {
        private final long eyR;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$d$a */
        static final class C13893a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ String sqz;

            C13893a(String str) {
                this.sqz = str;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110877);
                C39933n.m68376a(C39933n.sqi, this.sqz);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110877);
                return c37091y;
            }
        }

        public C39935d(long j) {
            this.eyR = j;
        }

        /* renamed from: a */
        public final void mo5085a(String str, C9545d c9545d) {
            AppMethodBeat.m2504i(110878);
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + str + ", sceneResult:" + c9545d);
            C39933n c39933n;
            if (c9545d == null || c9545d.field_retCode != -21112) {
                if (!(str == null || c9545d == null)) {
                    c39933n = C39933n.sqi;
                    if (C39933n.spY.containsKey(str)) {
                        c39933n = C39933n.sqi;
                        C35201i c35201i = (C35201i) C39933n.spY.get(str);
                        if (c35201i != null) {
                            if (c9545d.field_recvedBytes <= 0 || c9545d.field_fileLength <= 0) {
                                C4990ab.m7412e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + c9545d.field_recvedBytes + ", fileLength:" + c9545d.field_fileLength);
                            } else {
                                C43649s c43649s = C43649s.rTV;
                                C29298n a = C43649s.m78153a(c35201i);
                                a.field_cacheSize = c9545d.field_recvedBytes;
                                a.field_totalSize = c9545d.field_fileLength;
                                C4133a c4133a = C43644j.rST;
                                C4133a.cxX().mo25974b(a);
                                C39933n c39933n2 = C39933n.sqi;
                                C39933n.sqa.add(str);
                                C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + a.field_cacheSize + ", totalSize:" + a.field_totalSize + ", preloadCost:" + C5046bo.m7525az(this.eyR));
                                C8902b.m16042a(new C13893a(str));
                                AppMethodBeat.m2505o(110878);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(110878);
                return;
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + str + ", video source change!");
            c39933n = C39933n.sqi;
            C39933n.abe(str);
            AppMethodBeat.m2505o(110878);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.n$e */
    static final class C39936e implements C1628a {
        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(110879);
            C39933n c39933n;
            if (c9545d == null || c9545d.field_retCode != -21112) {
                if (c18496c != null && c18496c.field_toltalLength > 0) {
                    String str2;
                    String str3;
                    c39933n = C39933n.sqi;
                    C35201i c35201i = (C35201i) C39933n.spY.get(str);
                    C39933n c39933n2 = C39933n.sqi;
                    boolean a = C25035t.m39327a((Iterable) C39933n.sqa, (Object) str);
                    int i2 = (int) ((((float) c18496c.field_finishedLength) / ((float) c18496c.field_toltalLength)) * 100.0f);
                    c39933n2 = C39933n.sqi;
                    Integer num = (Integer) C39933n.spZ.get(str);
                    int intValue = num != null ? num.intValue() : 0;
                    String str4 = hashCode() + " onPreload, mediaId:" + str + ", startRet:" + i + ", preloadOffset:" + c18496c.field_finishedLength + ", totalLength: " + c18496c.field_toltalLength + " desiredPreloadPercent:" + intValue + ", preloadPercent:" + i2 + " isFinish:" + a;
                    Object obj = null;
                    if (intValue <= 0 || i2 < intValue) {
                        str2 = str4;
                    } else {
                        str2 = str4 + " exceed:true ";
                        obj = 1;
                    }
                    if (c35201i != null) {
                        C43649s c43649s = C43649s.rTV;
                        C29298n a2 = C43649s.m78153a(c35201i);
                        a2.field_cacheSize = c18496c.field_finishedLength;
                        a2.field_totalSize = c18496c.field_toltalLength;
                        C4133a c4133a = C43644j.rST;
                        C4133a.cxX().mo25974b(a2);
                        c4133a = C43644j.rST;
                        C4119f aap = C4133a.cxU().aap(c35201i.username);
                        if (aap.field_syncId == c35201i.rUJ && aap.isValid()) {
                            long j = c35201i.rUJ;
                            str3 = c35201i.rWj.f4416Id;
                            C25052j.m39375o(str3, "videoItem.media.Id");
                            if (aap.mo8989b(j, str3, a2.field_cacheSize)) {
                                str2 = str2 + " * ext pre update * ";
                                C4133a c4133a2 = C43644j.rST;
                                C4133a.cxU().mo47494a((long) ((int) aap.xDa), aap);
                            }
                        }
                        if (!(obj == null || str == null)) {
                            c39933n = C39933n.sqi;
                            C39933n.sqa.add(str);
                        }
                        str3 = str2 + "update cacheSize done";
                    } else {
                        str3 = str2;
                    }
                    StringBuilder append = new StringBuilder().append(str3).append(", currentSpeed:");
                    C39933n c39933n3 = C39933n.sqi;
                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", append.append(C39933n.cCR()).toString());
                }
                AppMethodBeat.m2505o(110879);
                return 0;
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + str + ", video source change!");
            c39933n = C39933n.sqi;
            C39933n.abe(str);
            AppMethodBeat.m2505o(110879);
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(110904);
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        C25052j.m39375o(synchronizedMap, "Collections.synchronized…tring, StoryVideoItem>())");
        spY = synchronizedMap;
        synchronizedMap = Collections.synchronizedMap(new HashMap());
        C25052j.m39375o(synchronizedMap, "Collections.synchronized…p(HashMap<String, Int>())");
        spZ = synchronizedMap;
        Set synchronizedSet = Collections.synchronizedSet(new HashSet());
        C25052j.m39375o(synchronizedSet, "Collections.synchronizedSet(HashSet<String>())");
        sqa = synchronizedSet;
        List synchronizedList = Collections.synchronizedList(new LinkedList());
        C25052j.m39375o(synchronizedList, "Collections.synchronized…t(LinkedList<TaskInfo>())");
        sqb = synchronizedList;
        AppMethodBeat.m2505o(110904);
    }

    private C39933n() {
    }

    /* renamed from: l */
    public static final /* synthetic */ boolean m68389l(C35201i c35201i) {
        AppMethodBeat.m2504i(110907);
        boolean k = C39933n.m68387k(c35201i);
        AppMethodBeat.m2505o(110907);
        return k;
    }

    public static C39932k cCM() {
        return spU;
    }

    private static List<Integer> cCN() {
        AppMethodBeat.m2504i(110880);
        if (C39933n.cCQ()) {
            List list = spU.soU;
            AppMethodBeat.m2505o(110880);
            return list;
        }
        List<Integer> list2 = spU.soT;
        AppMethodBeat.m2505o(110880);
        return list2;
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m68382e(List list, int i, int i2) {
        AppMethodBeat.m2504i(110882);
        boolean d = C39933n.m68380d(list, i, i2);
        AppMethodBeat.m2505o(110882);
        return d;
    }

    /* renamed from: d */
    private static boolean m68380d(List<? extends List<C43640g>> list, int i, int i2) {
        boolean z;
        AppMethodBeat.m2504i(110881);
        C25052j.m39376p(list, "groupItems");
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + list.size() + ", positionV:" + i + "  positionH:" + i2 + ", skipPosition:true");
        C29376a c29376a = sqd;
        C25052j.m39376p(list, "galleryItems");
        if (c29376a.mo47616dL(list)) {
            z = false;
        } else if (c29376a.sqs == i2 && c29376a.sqr == i) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(110881);
        } else {
            int i3;
            int size;
            C39934c c39934c;
            int i4;
            if (i >= 0 && i2 >= 0 && i < list.size() && i2 < ((List) list.get(i)).size()) {
                C43640g c43640g = (C43640g) ((List) list.get(i)).get(i2);
                if (c43640g != null) {
                    C35201i c35201i = c43640g.rVZ;
                    if (c35201i != null) {
                        sqg = c35201i.rUJ;
                    }
                }
            }
            sbh = 0;
            sqc = 0;
            sqd = new C29376a(list, i, i2, sqd);
            ArrayList arrayList = new ArrayList();
            Iterable iterable = list;
            synchronized (iterable) {
                try {
                    i3 = 0;
                    for (Object next : iterable) {
                        int i5 = i3 + 1;
                        if (i3 < 0) {
                            C7987l.dWs();
                        }
                        List list2 = (List) next;
                        if (i3 >= i && list2.size() > 0) {
                            arrayList.add(Integer.valueOf(((C43640g) list2.get(0)).rVZ.cNE));
                        }
                        i3 = i5;
                    }
                    C37091y c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(110881);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (i < list.size() && i2 < ((List) list.get(i)).size()) {
                size = ((List) list.get(i)).size();
                while (i2 < size) {
                    arrayList2.add(Integer.valueOf(((C43640g) ((List) list.get(i)).get(i2)).rVZ.cNE));
                    i2++;
                }
            }
            Collection arrayList3 = new ArrayList();
            for (Object next2 : sqb) {
                c39934c = (C39934c) next2;
                if (arrayList.contains(Integer.valueOf(c39934c.sqy.cNE)) || arrayList2.contains(Integer.valueOf(c39934c.sqy.cNE))) {
                    z = false;
                } else {
                    i4 = 1;
                }
                if (i4 != 0) {
                    arrayList3.add(next2);
                }
            }
            Iterable<C39934c> iterable2 = (List) arrayList3;
            synchronized (iterable2) {
                try {
                    for (C39934c c39934c2 : iterable2) {
                        C39933n.m68386j(c39934c2.sqy);
                    }
                    C37091y c37091y2 = C37091y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(110881);
                }
            }
            spV = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_strategy, 1);
            size = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_speed_good, 450);
            i3 = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_speed_bad, 200);
            spW = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_force_preload, 0);
            spX = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_force_canload, 100);
            spU.soR = size;
            spU.soS = i3;
            i4 = CdnLogic.getRecentAverageSpeed(2);
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + spV + " clicfg_story_preload_speed_good:" + size + " clicfg_story_preload_speed_bad:" + i3 + " clicfg_story_preload_force_preload " + spW + "  clicfg_story_preload_force_canload: " + spX + " speed:" + i4);
            if (i4 > 0 && spX > 0 && i4 < spX) {
                C4990ab.m7420w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i4 + " clicfg_story_preload_force_canload: " + spX);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(sqb);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C39933n.m68386j(((C39934c) it.next()).sqy);
                }
            }
            AppMethodBeat.m2505o(110881);
        }
        return false;
    }

    /* renamed from: lA */
    public final void mo63131lA(long j) {
        AppMethodBeat.m2504i(110883);
        if (sbh == j) {
            AppMethodBeat.m2505o(110883);
            return;
        }
        sbh = j;
        if (spV == 0) {
            AppMethodBeat.m2505o(110883);
            return;
        }
        C29376a c29376a = sqd;
        if (c29376a != null) {
            c29376a.cCW();
        }
        m68390lV(true);
        AppMethodBeat.m2505o(110883);
    }

    /* renamed from: lB */
    public final void mo63132lB(long j) {
        AppMethodBeat.m2504i(110884);
        Long l = sqf;
        if (l != null && l.longValue() == j) {
            sqf = Long.valueOf(0);
        }
        if (sqh == j) {
            AppMethodBeat.m2505o(110884);
            return;
        }
        sqh = j;
        if (spV == 0) {
            AppMethodBeat.m2505o(110884);
        } else if (spX == 0) {
            AppMethodBeat.m2505o(110884);
        } else if (sqb.size() > 0) {
            AppMethodBeat.m2505o(110884);
        } else {
            C29376a c29376a = sqd;
            if (c29376a != null) {
                c29376a.cCW();
            }
            m68390lV(false);
            AppMethodBeat.m2505o(110884);
        }
    }

    /* renamed from: f */
    public final void mo63130f(C35201i c35201i) {
        AppMethodBeat.m2504i(110885);
        C25052j.m39376p(c35201i, "item");
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + c35201i + ' ' + C5007an.doQ());
        if (C39933n.m68383g(c35201i)) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
            m68390lV(false);
            AppMethodBeat.m2505o(110885);
        } else if (C39933n.m68379b(c35201i) == 1) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
            m68390lV(true);
            AppMethodBeat.m2505o(110885);
        } else {
            if (spW == 1) {
                m68390lV(true);
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
            AppMethodBeat.m2505o(110885);
        }
    }

    /* renamed from: b */
    private static int m68379b(C35201i c35201i) {
        AppMethodBeat.m2504i(110886);
        C25052j.m39376p(c35201i, "item");
        C43649s c43649s = C43649s.rTV;
        C29298n a = C43649s.m78153a(c35201i);
        if (a.cCd()) {
            C4990ab.m7418v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + c35201i.rUJ);
            AppMethodBeat.m2505o(110886);
            return 1;
        } else if (a.field_totalSize <= 0) {
            AppMethodBeat.m2505o(110886);
            return 0;
        } else if ((((float) a.field_cacheSize) / ((float) a.field_totalSize)) * 100.0f >= ((float) spU.soQ)) {
            C4990ab.m7418v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + a.field_cacheSize + " totalSize: " + a.field_totalSize);
            AppMethodBeat.m2505o(110886);
            return 1;
        } else {
            AppMethodBeat.m2505o(110886);
            return 0;
        }
    }

    /* renamed from: lV */
    private final void m68390lV(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(110887);
        boolean cCP = C39933n.cCP();
        boolean cCQ = C39933n.cCQ();
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        if (!z || recentAverageSpeed <= 0 || spX <= 0 || recentAverageSpeed >= spX) {
            int i2 = 0;
            if (cCQ) {
                recentAverageSpeed = 1;
            } else {
                recentAverageSpeed = 3;
            }
            if (spV != 1) {
                i = recentAverageSpeed;
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + cCP + ", isBadNetwork:" + cCQ + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + sqb.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + sqc + " checkNet " + z + " callerFrom " + C5007an.doQ());
            List cCN = C39933n.cCN();
            while (sqb.size() < i && i2 < cCN.size() && sqc < 3 && m68388l(((Number) cCN.get(i2)).intValue(), "startPreLoad", C39933n.m68374Fl(i2))) {
                recentAverageSpeed = i2 + 1;
                sqc++;
                i2 = recentAverageSpeed;
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + sqb.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + i2 + " preloadRunningSet " + sqb.size() + " totalPreLoadOneItemSelect " + sqc + ' ');
            AppMethodBeat.m2505o(110887);
            return;
        }
        C4990ab.m7420w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + recentAverageSpeed + " clicfg_story_preload_force_canload: " + spX + " callerFrom " + C5007an.doQ());
        AppMethodBeat.m2505o(110887);
    }

    /* renamed from: a */
    private static /* synthetic */ boolean m68378a(C39933n c39933n, int i, String str) {
        AppMethodBeat.m2504i(110889);
        boolean l = c39933n.m68388l(i, str, 1);
        AppMethodBeat.m2505o(110889);
        return l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    private final boolean m68388l(int i, String str, int i2) {
        AppMethodBeat.m2504i(110888);
        while (true) {
            C31826o c31826o;
            C39933n c39933n = this;
            C29376a c29376a = sqd;
            C31826o c31826o2 = null;
            int i3 = 0;
            while (true) {
                c31826o = c31826o2;
                if (i3 < c29376a.sqq.size() && c31826o == null) {
                    c31826o2 = c29376a.cCV();
                    C4990ab.m7416i(C29376a.TAG, "produceVideoItem walkVertical:" + c29376a.sqk + "  walkHorizontal:" + c29376a.sqm + " positionV:" + c29376a.sqr + " positionH:" + c29376a.sqs + ", ret:" + c31826o2);
                    i3++;
                } else if (c31826o != null) {
                    AppMethodBeat.m2505o(110888);
                    return false;
                } else {
                    Object obj;
                    C35201i c35201i = (C35201i) c31826o.first;
                    String str2 = ((C39934c) c31826o.second).fUL;
                    StringBuilder append = new StringBuilder("try preload mediaId ").append(str2).append(" videoItem:").append(c35201i).append(" pos:").append((C39934c) c31826o.second).append("  groupinfo ");
                    C29376a c29376a2 = sqd;
                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", append.append("positionV:" + c29376a2.sqr + ", positionH:" + c29376a2.sqs + ", walkVertical:" + c29376a2.sqk + ", walkHorizontal:" + c29376a2.sqm).append(" quota:").append(i).append("  fromTag:").append(str).toString());
                    for (Object next : sqb) {
                        if (C25052j.m39373j(((C39934c) next).fUL, str2)) {
                            obj = next;
                            break;
                        }
                    }
                    obj = null;
                    C39934c c39934c = (C39934c) obj;
                    if (c39934c == null || i > c39934c.ehE) {
                        String str3;
                        if ((((CharSequence) str2).length() == 0 ? 1 : null) == null) {
                            str3 = str2;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null) {
                            int a = C39933n.m68375a(str2, c35201i.rWj, i, C39933n.cCP());
                            C43649s c43649s = C43649s.rTV;
                            C29298n a2 = C43649s.m78153a(c35201i);
                            if (a2.cCd() || (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) a)) {
                                C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str2 + ", already reach cache size! cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", cachePercent:" + ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f) + "  fromTag:" + str);
                            } else if (c39933n.m68377a(c35201i, a, i2, (C39934c) c31826o.second)) {
                                ((C39934c) c31826o.second).ehE = i;
                                AppMethodBeat.m2505o(110888);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + i + " cur:" + c39934c.ehE + " fromTag:" + str);
                    }
                }
            }
            if (c31826o != null) {
            }
        }
    }

    /* renamed from: dK */
    public static /* synthetic */ void m68381dK(List list) {
        AppMethodBeat.m2504i(110891);
        C39933n.m68391q(list, 0);
        AppMethodBeat.m2505o(110891);
    }

    /* renamed from: q */
    public static void m68391q(List<C35201i> list, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(110890);
        C25052j.m39376p(list, "videoItemList");
        C4990ab.m7409c("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + list.size(), new Object[0]);
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + C39933n.cCP() + ", isBadNetwork:" + C39933n.cCQ() + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + sqb.size() + " downloadExpect " + i);
        List cCN = C39933n.cCN();
        Iterable<C35201i> iterable = list;
        synchronized (iterable) {
            try {
                for (C35201i c35201i : iterable) {
                    if (C39933n.m68387k(c35201i)) {
                        int intValue = i > 0 ? i : i2 < cCN.size() ? ((Number) cCN.get(i2)).intValue() : ((Number) C25035t.m39339fL(cCN)).intValue();
                        int Fl = C39933n.m68374Fl(i2);
                        C43649s c43649s = C43649s.rTV;
                        String be = C43649s.m78156be(c35201i.fDG, c35201i.rWj.Url);
                        int a = C39933n.m68375a(be, c35201i.rWj, intValue, C39933n.cCP());
                        c43649s = C43649s.rTV;
                        C29298n a2 = C43649s.m78153a(c35201i);
                        for (Object next : sqb) {
                            if (C25052j.m39373j(((C39934c) next).fUL, be)) {
                                break;
                            }
                        }
                        Object next2 = null;
                        if (next2 != null) {
                            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + be + ", already prealoding!");
                        } else if (a2.cCd() || (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) a)) {
                            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + be + ", already reach cache size! cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", cachePercent:" + ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f));
                        } else {
                            if (sqi.m68377a(c35201i, a, Fl, new C39934c(0, i2, c35201i, intValue, Fl))) {
                                i2++;
                            }
                        }
                    }
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(110890);
            }
        }
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + i2 + " preloadRunningSet " + sqb.size());
    }

    /* renamed from: g */
    private static boolean m68383g(C35201i c35201i) {
        AppMethodBeat.m2504i(110892);
        if (c35201i.cze()) {
            AppMethodBeat.m2505o(110892);
            return true;
        }
        C43649s c43649s = C43649s.rTV;
        if (C5730e.asZ(C43649s.m78154a(c35201i.rWj)) > 0) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + c35201i.rWj.cNE + " username:" + c35201i.username);
            AppMethodBeat.m2505o(110892);
            return true;
        }
        c43649s = C43649s.rTV;
        if (C43649s.m78153a(c35201i).cCd()) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + c35201i.rWj.cNE + " username:" + c35201i.username);
            AppMethodBeat.m2505o(110892);
            return true;
        }
        AppMethodBeat.m2505o(110892);
        return false;
    }

    /* renamed from: a */
    private synchronized boolean m68377a(C35201i c35201i, int i, int i2, C39934c c39934c) {
        boolean z;
        AppMethodBeat.m2504i(110893);
        C25052j.m39376p(c35201i, "videoItem");
        C25052j.m39376p(c39934c, "taskInfo");
        if (c35201i.cze() || C5046bo.isNullOrNil(c35201i.rWj.Url)) {
            AppMethodBeat.m2505o(110893);
            z = false;
        } else if (C39933n.m68383g(c35201i)) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + c35201i.rWj.Url);
            AppMethodBeat.m2505o(110893);
            z = false;
        } else {
            String str = c35201i.rWj.Url;
            String str2 = c39934c.fUL;
            C43649s c43649s = C43649s.rTV;
            C29298n a = C43649s.m78153a(c35201i);
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str2 + ", " + i + ", playingMediaId:" + sqe + ", " + a.field_filePath + ", " + str + "  videoCache " + a);
            if (str2 == null || C6163u.m9833I(sqe, str2, false)) {
                AppMethodBeat.m2505o(110893);
                z = false;
            } else {
                int i3;
                C43649s c43649s2 = C43649s.rTV;
                C5730e.m8643tf(C43649s.aaF(c35201i.username));
                C25052j.m39375o(str, "url");
                String str3 = a.field_filePath;
                C25052j.m39375o(str3, "videoCache.field_filePath");
                C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str2 + ", path:" + str3 + ", url:" + str + ", preloadPercent:" + i + ", connectionCount:" + i2);
                C44686h c44686h = new C44686h();
                c44686h.field_mediaId = str2;
                c44686h.url = str;
                c44686h.egx = 2;
                c44686h.egD = 2;
                c44686h.egy = 6;
                c44686h.egI = i;
                c44686h.field_preloadRatio = i;
                c44686h.concurrentCount = 4;
                c44686h.field_fullpath = str3;
                c44686h.egl = new C39936e();
                c44686h.egz = new C39935d(C5046bo.m7588yz());
                c44686h.connectionCount = i2;
                c44686h.field_fileType = C42129a.efK;
                c44686h.field_requestVideoFormat = C42204d.m74456v(2, str3);
                C37461f.afx().mo51224d(c44686h);
                C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + c44686h + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
                spY.put(str2, c35201i);
                spZ.put(str2, Integer.valueOf(i));
                int i4 = 0;
                for (C39934c c39934c2 : sqb) {
                    if (C25052j.m39373j(c39934c2.fUL, c39934c.fUL)) {
                        i3 = i4;
                        break;
                    }
                    i4++;
                }
                i3 = -1;
                if (i3 > 0) {
                    sqb.set(i3, c39934c);
                } else {
                    sqb.add(c39934c);
                }
                sqa.remove(str2);
                z = true;
                AppMethodBeat.m2505o(110893);
            }
        }
        return z;
    }

    /* renamed from: Fl */
    private static int m68374Fl(int i) {
        AppMethodBeat.m2504i(110894);
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(i)));
        List list = spU.soV;
        if (i >= spU.soV.size()) {
            i = spU.soV.size() - 1;
        }
        int intValue = ((Number) list.get(i)).intValue();
        AppMethodBeat.m2505o(110894);
        return intValue;
    }

    /* renamed from: h */
    public static void m68384h(C35201i c35201i) {
        Object obj;
        AppMethodBeat.m2504i(110895);
        C25052j.m39376p(c35201i, "videoItem");
        C43649s c43649s = C43649s.rTV;
        String be = C43649s.m78156be(c35201i.fDG, c35201i.rWj.Url);
        sqe = be;
        sqf = Long.valueOf(c35201i.rUJ);
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + sqe + " then remove it from preload");
        for (Object next : sqb) {
            if (C25052j.m39373j(be, ((C39934c) next).fUL)) {
                obj = next;
                break;
            }
        }
        obj = null;
        C39934c c39934c = (C39934c) obj;
        if (c39934c != null) {
            sqb.remove(c39934c);
            C39933n.m68386j(c39934c.sqy);
            AppMethodBeat.m2505o(110895);
            return;
        }
        AppMethodBeat.m2505o(110895);
    }

    /* renamed from: i */
    public static C13892b m68385i(C35201i c35201i) {
        AppMethodBeat.m2504i(110896);
        C25052j.m39376p(c35201i, "videoItem");
        C43649s c43649s = C43649s.rTV;
        String be = C43649s.m78156be(c35201i.fDG, c35201i.rWj.Url);
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(be)));
        c43649s = C43649s.rTV;
        C29298n a = C43649s.m78153a(c35201i);
        C13892b c13892b;
        if (a.field_cacheSize <= 0 || a.field_totalSize <= 0) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", be + " not hit cache or moov not ready");
            c13892b = new C13892b(false, 0, 0, false);
            AppMethodBeat.m2505o(110896);
            return c13892b;
        }
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + be + ", cachePercent:" + (((float) a.field_cacheSize) / ((float) a.field_totalSize)) + ", filePath:" + a.field_filePath);
        String str = a.field_filePath;
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        long[] jArr = new long[2];
        c2CDownloadRequest.fileKey = be;
        c2CDownloadRequest.fileType = 6;
        c2CDownloadRequest.url = c35201i.rWj.Url;
        c2CDownloadRequest.savePath = str;
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", be + " queryMoovReady: " + CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr) + ", offset:" + jArr[0] + ", length:" + jArr[1] + ", preloadFinish:" + C25035t.m39327a((Iterable) sqa, (Object) be));
        c13892b = new C13892b(true, jArr[0], jArr[1], C25035t.m39327a((Iterable) sqa, (Object) be));
        AppMethodBeat.m2505o(110896);
        return c13892b;
    }

    /* renamed from: j */
    private static void m68386j(C35201i c35201i) {
        Object obj;
        AppMethodBeat.m2504i(110897);
        C25052j.m39376p(c35201i, "videoItem");
        C43649s c43649s = C43649s.rTV;
        String be = C43649s.m78156be(c35201i.fDG, c35201i.rWj.Url);
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(be)));
        C37461f.afx().mo51228rO(be);
        for (Object next : sqb) {
            if (C25052j.m39373j(((C39934c) next).fUL, be)) {
                obj = next;
                break;
            }
        }
        obj = null;
        C39934c c39934c = (C39934c) obj;
        if (c39934c != null) {
            sqb.remove(c39934c);
            if (sqc > 0) {
                sqc--;
            }
            AppMethodBeat.m2505o(110897);
            return;
        }
        AppMethodBeat.m2505o(110897);
    }

    public static void cCO() {
        AppMethodBeat.m2504i(110898);
        C4990ab.m7409c("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
        for (String str : spY.keySet()) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
            C37461f.afx().mo51228rO(str);
        }
        spY.clear();
        spZ.clear();
        sqd = new C29376a(new ArrayList());
        sqb.clear();
        AppMethodBeat.m2505o(110898);
    }

    /* renamed from: a */
    private static int m68375a(String str, cek cek, int i, boolean z) {
        AppMethodBeat.m2504i(110899);
        float f = cek.duration;
        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + i + ", mediaId:" + str + ", duration:" + f + ", isGoodNetwork:" + z + " media:" + cek.duration);
        int i2 = z ? 5 : 3;
        if (f <= 0.0f) {
            i2 = spU.soQ;
        } else if (f > ((float) i2) || i > 0) {
            i2 = (int) (((double) (((float) Math.max(3, i)) / f)) * 100.0d);
        } else {
            i2 = 100;
        }
        if (i2 <= spU.soQ) {
            i2 = spU.soQ;
        }
        AppMethodBeat.m2505o(110899);
        return i2;
    }

    private static boolean cCQ() {
        AppMethodBeat.m2504i(110901);
        int i = spU.soS;
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        if (1 <= recentAverageSpeed && i >= recentAverageSpeed) {
            AppMethodBeat.m2505o(110901);
            return true;
        }
        AppMethodBeat.m2505o(110901);
        return false;
    }

    public static int cCR() {
        AppMethodBeat.m2504i(139114);
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        AppMethodBeat.m2505o(139114);
        return recentAverageSpeed;
    }

    /* renamed from: k */
    private static boolean m68387k(C35201i c35201i) {
        AppMethodBeat.m2504i(110903);
        if (C39933n.m68383g(c35201i) || c35201i.cze()) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + c35201i + " isLocalVideo or fake video");
            AppMethodBeat.m2505o(110903);
            return false;
        }
        C43649s c43649s = C43649s.rTV;
        String be = C43649s.m78156be(c35201i.fDG, c35201i.rWj.Url);
        if (C5046bo.isNullOrNil(be) || C5046bo.isNullOrNil(c35201i.rWj.Url) || C6163u.m9833I(sqe, be, false)) {
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + be + ", already request preload or url " + c35201i.rWj.Url);
            AppMethodBeat.m2505o(110903);
            return false;
        }
        AppMethodBeat.m2505o(110903);
        return true;
    }

    private static boolean cCP() {
        AppMethodBeat.m2504i(110900);
        if (CdnLogic.getRecentAverageSpeed(2) >= spU.soR) {
            AppMethodBeat.m2505o(110900);
            return true;
        }
        AppMethodBeat.m2505o(110900);
        return false;
    }

    public static final /* synthetic */ void abe(String str) {
        AppMethodBeat.m2504i(110905);
        C4990ab.m7409c("MicroMsg.StoryVideoPreloadMgr", "onVideoSourceChange: ".concat(String.valueOf(str)), new Object[0]);
        C35201i c35201i = (C35201i) spY.get(str);
        if (c35201i != null) {
            C39933n.m68386j(c35201i);
            C43649s c43649s = C43649s.rTV;
            C29298n a = C43649s.m78153a(c35201i);
            a.cCe();
            C4133a c4133a = C43644j.rST;
            C4133a.cxX().mo25974b(a);
            C5730e.deleteFile(a.field_filePath);
        }
        AppMethodBeat.m2505o(110905);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m68376a(C39933n c39933n, String str) {
        Object obj;
        AppMethodBeat.m2504i(110906);
        for (Object next : sqb) {
            if (C25052j.m39373j(str, ((C39934c) next).fUL)) {
                obj = next;
                break;
            }
        }
        obj = null;
        obj = (C39934c) obj;
        if (obj != null) {
            sqb.remove(obj);
        }
        if (spV == 1) {
            boolean z;
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgrades mediaId " + str + " runningMediaId " + sqf + " selectMediaId " + sqg);
            Long l = sqf;
            long j = sqg;
            if (l != null && l.longValue() == j) {
                l = sqf;
                if (l == null || l.longValue() != 0) {
                    z = true;
                    c39933n.m68390lV(z);
                }
            }
            z = false;
            c39933n.m68390lV(z);
        }
        if (spU.soP) {
            int intValue;
            int i;
            C37091y c37091y;
            boolean cCP = C39933n.cCP();
            if (C39933n.cCQ()) {
                if ((!((Collection) sqb).isEmpty() ? 1 : null) != null) {
                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "isBadNetWork pass " + sqb.size() + " getNetworkSpeed:" + CdnLogic.getRecentAverageSpeed(2));
                    AppMethodBeat.m2505o(110906);
                    return;
                }
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgrades preloadRunningSet size " + sqb.size());
            List cCN = C39933n.cCN();
            if ((!((Collection) cCN).isEmpty() ? 1 : null) != null) {
                int intValue2 = ((Number) C25035t.m39339fL(cCN)).intValue();
                if (C39933n.m68378a(c39933n, intValue2, "upgrades")) {
                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "add new task when upgrades newQuota " + intValue2 + " then running " + sqb.size());
                }
            }
            int u = C25035t.m39360u(cCN);
            Integer num = (Integer) C25035t.m39357r(cCN);
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = 0;
            }
            Iterable<C39934c> iterable = sqb;
            synchronized (iterable) {
                try {
                    i = u;
                    for (C39934c c39934c : iterable) {
                        i -= c39934c.ehE;
                    }
                    c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(110906);
                }
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgrades quotaList:" + C25035t.m39360u(cCN) + " totalQuota " + i + " maxQuota " + intValue);
            String str2;
            if (i <= 0) {
                String str3 = "";
                Iterable iterable2 = sqb;
                synchronized (iterable2) {
                    try {
                        Iterator it = iterable2.iterator();
                        while (true) {
                            str2 = str3;
                            if (!it.hasNext()) {
                                break;
                            }
                            C39934c c39934c2 = (C39934c) it.next();
                            str3 = str2 + "mediaId " + c39934c2.fUL + ", quota:" + c39934c2.ehE;
                        }
                        C37091y c37091y2 = C37091y.AUy;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(110906);
                    }
                }
                C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota no quota left " + i + " info: " + str2);
                return;
            }
            String str4;
            C25052j.m39376p(cCN, "list");
            C41380b c41380b = new C41380b();
            c41380b.AVD = 0;
            C31214a c8903a = new C8903a(c41380b, cCN);
            LinkedList linkedList = new LinkedList();
            Iterable<C39934c> iterable3 = sqb;
            synchronized (iterable3) {
                try {
                    for (C39934c c39934c3 : iterable3) {
                        linkedList.add(c39934c3);
                    }
                    c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(110906);
                }
            }
            if (obj != null) {
                if ((obj.ehE < intValue ? 1 : null) == null) {
                    obj = null;
                }
                if (obj != null) {
                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota try add remove which one remove " + intValue + "  it.quota " + obj);
                    linkedList.add(obj);
                }
            }
            str2 = "";
            Iterable<C39934c> iterable4 = linkedList;
            synchronized (iterable4) {
                try {
                    str4 = str2;
                    for (C39934c c39934c4 : iterable4) {
                        str4 = str4 + "mediaId " + c39934c4.fUL + ", quota:" + c39934c4.ehE;
                    }
                    C37091y c37091y3 = C37091y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(110906);
                }
            }
            C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota quota left " + i + " info: " + str4);
            Iterable<C39934c> iterable5 = linkedList;
            synchronized (iterable5) {
                try {
                    for (C39934c c39934c42 : iterable5) {
                        Integer num2 = (Integer) c8903a.invoke();
                        C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota getQuota1 " + num2 + " cur: quota " + c39934c42.ehE + " cdnMediaId " + c39934c42.fUL);
                        if (num2 != null) {
                            int intValue3 = num2.intValue();
                            obj = (intValue3 <= 0 || intValue3 <= c39934c42.ehE) ? null : 1;
                            Integer num3 = obj != null ? num2 : null;
                            if (num3 != null) {
                                num3.intValue();
                                String str5 = c39934c42.fUL;
                                C35201i c35201i = c39934c42.sqy;
                                int a = C39933n.m68375a(str5, c35201i.rWj, num2.intValue(), cCP);
                                C43649s c43649s = C43649s.rTV;
                                C29298n a2 = C43649s.m78153a(c35201i);
                                C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota getQuota2 mediaId " + str5 + " old " + c39934c42.ehE + " newupgradeQuota: " + num2);
                                if (a2.cCd() || (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) a)) {
                                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota pull preload video, " + str5 + ", already reach cache size! cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", cachePercent:" + ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f));
                                } else if (sqi.m68377a(c35201i, a, 1, c39934c42)) {
                                    c39934c42.ehE = num2.intValue();
                                    C4990ab.m7416i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota ok! mediaId ".concat(String.valueOf(str5)));
                                }
                            }
                        }
                    }
                    C37091y c37091y4 = C37091y.AUy;
                } catch (Throwable th3) {
                    AppMethodBeat.m2505o(110906);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(110906);
    }
}
