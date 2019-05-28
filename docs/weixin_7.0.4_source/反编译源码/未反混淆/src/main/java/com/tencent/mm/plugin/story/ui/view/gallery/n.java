package com.tencent.mm.plugin.story.ui.view.gallery;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.o;
import a.y;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
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

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005hijklB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u0004H\u0002J\u001e\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0;2\b\b\u0002\u0010<\u001a\u00020\u0004J.\u0010=\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u00062\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00042\b\b\u0002\u0010B\u001a\u000204H\u0002J\u0006\u0010C\u001a\u000209J\u000e\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020)J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020)2\b\b\u0002\u0010A\u001a\u00020\u0004J\u000e\u0010H\u001a\u0002092\u0006\u0010G\u001a\u00020)J\u000e\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020)J0\u0010K\u001a\u00020L2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\u0006\u0010P\u001a\u00020\u0004J\u0006\u0010Q\u001a\u000204J\u0006\u0010B\u001a\u000204J\u0010\u0010R\u001a\u0002042\u0006\u0010E\u001a\u00020)H\u0002J\u000e\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020\u0015J\u000e\u0010U\u001a\u0002092\u0006\u0010E\u001a\u00020)J\u000e\u0010V\u001a\u0002092\u0006\u0010T\u001a\u00020\u0015J\u0010\u0010W\u001a\u0002042\u0006\u0010E\u001a\u00020)H\u0002J\u0012\u0010X\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010Y\u001a\u0002042\u0006\u0010E\u001a\u00020)2\u0006\u0010Z\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010[\u001a\u00020,J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J4\u0010]\u001a\u0002042\u0012\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0;0;2\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\b\b\u0002\u0010b\u001a\u000204J\u0010\u0010c\u001a\u0002092\u0006\u0010d\u001a\u000204H\u0002J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u0004H\u0002J\u0010\u0010g\u001a\u0002092\u0006\u0010>\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)0'X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000b¨\u0006m"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", "index", "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class n {
    private static long sbh;
    private static k spU = new k();
    private static int spV;
    private static int spW;
    private static int spX;
    private static final Map<String, i> spY;
    private static final Map<String, Integer> spZ;
    private static final Set<String> sqa;
    private static final List<c> sqb;
    private static int sqc = 3;
    private static a sqd = new a(new ArrayList());
    private static volatile String sqe;
    private static volatile Long sqf;
    private static long sqg;
    private static long sqh;
    public static final n sqi = new n();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-story_release"})
    public static final class b {
        final long bgY;
        final boolean sqw;
        final boolean sqx;
        final long xb;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                if (!(this.sqw == bVar.sqw)) {
                    return false;
                }
                if (!(this.xb == bVar.xb)) {
                    return false;
                }
                if (!(this.bgY == bVar.bgY)) {
                    return false;
                }
                if (!(this.sqx == bVar.sqx)) {
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
            long j = this.xb;
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
            AppMethodBeat.i(110875);
            String str = "MoovReadyInfo(isMoovReady=" + this.sqw + ", offset=" + this.xb + ", length=" + this.bgY + ", preloadFinish=" + this.sqx + ")";
            AppMethodBeat.o(110875);
            return str;
        }

        public b(boolean z, long j, long j2, boolean z2) {
            this.sqw = z;
            this.xb = j;
            this.bgY = j2;
            this.sqx = z2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\u00020\n2\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u0002J*\u0010\u001c\u001a\u00020\n2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012J\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020#R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00120\u00110\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
    public static final class a {
        static final String TAG = TAG;
        public static final a squ = new a();
        private final int sqj;
        int sqk;
        int sqm;
        private int sqn;
        private ArrayList<g> sqo;
        private ArrayList<g> sqp;
        List<? extends a.f.a.a<o<i, c>>> sqq;
        int sqr;
        int sqs;
        private final boolean sqt;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        static final class b extends k implements a.f.a.a<o<? extends i, ? extends c>> {
            final /* synthetic */ a sqv;

            b(a aVar) {
                this.sqv = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110863);
                o a = a.a(this.sqv);
                AppMethodBeat.o(110863);
                return a;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        static final class c extends k implements a.f.a.a<o<? extends i, ? extends c>> {
            final /* synthetic */ a sqv;

            c(a aVar) {
                this.sqv = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110864);
                o a = a.a(this.sqv);
                AppMethodBeat.o(110864);
                return a;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        static final class d extends k implements a.f.a.a<o<? extends i, ? extends c>> {
            final /* synthetic */ a sqv;

            d(a aVar) {
                this.sqv = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110865);
                o b = a.b(this.sqv);
                AppMethodBeat.o(110865);
                return b;
            }
        }

        public /* synthetic */ a(List list) {
            this(list, 0, 0, null);
        }

        public a(List<? extends List<g>> list, int i, int i2, a aVar) {
            y yVar;
            j.p(list, "groupItems");
            AppMethodBeat.i(110871);
            this.sqr = i;
            this.sqs = i2;
            this.sqt = true;
            this.sqj = 15;
            this.sqo = new ArrayList();
            this.sqp = new ArrayList();
            this.sqq = a.a.l.listOf(new b(this), new c(this), new d(this));
            if (!(aVar == null || this.sqr == aVar.sqr) || (!(aVar == null || this.sqs == aVar.sqs) || dL(list))) {
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
                    yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(110871);
                }
            }
            if (this.sqr < list.size()) {
                Iterable<g> iterable2 = (Iterable) list.get(this.sqr);
                synchronized (iterable2) {
                    try {
                        for (g add : iterable2) {
                            this.sqo.add(add);
                        }
                        yVar = y.AUy;
                    } catch (Throwable th) {
                        AppMethodBeat.o(110871);
                    }
                }
                return;
            }
            AppMethodBeat.o(110871);
        }

        public static final /* synthetic */ o a(a aVar) {
            AppMethodBeat.i(110873);
            o cCX = aVar.cCX();
            AppMethodBeat.o(110873);
            return cCX;
        }

        public static final /* synthetic */ o b(a aVar) {
            AppMethodBeat.i(110874);
            o cCY = aVar.cCY();
            AppMethodBeat.o(110874);
            return cCY;
        }

        static {
            AppMethodBeat.i(110872);
            AppMethodBeat.o(110872);
        }

        /* Access modifiers changed, original: final */
        public final o<i, c> cCV() {
            AppMethodBeat.i(110866);
            try {
                if (this.sqn > this.sqj) {
                    ab.i(TAG, "stop preload now " + this.sqn);
                    AppMethodBeat.o(110866);
                    return null;
                }
                o<i, c> oVar = (o) ((a.f.a.a) this.sqq.get(this.sqn % this.sqq.size())).invoke();
                this.sqn++;
                AppMethodBeat.o(110866);
                return oVar;
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "error on produce", new Object[0]);
                AppMethodBeat.o(110866);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean dL(List<? extends List<g>> list) {
            AppMethodBeat.i(110867);
            if (list.size() == this.sqp.size()) {
                int size = list.size();
                int i = 0;
                while (i < size) {
                    if (((List) list.get(i)).isEmpty()) {
                        AppMethodBeat.o(110867);
                        return true;
                    } else if (((g) this.sqp.get(i)).rVZ.cNE != ((g) ((List) list.get(i)).get(0)).rVZ.cNE) {
                        AppMethodBeat.o(110867);
                        return true;
                    } else {
                        i++;
                    }
                }
                AppMethodBeat.o(110867);
                return false;
            }
            AppMethodBeat.o(110867);
            return true;
        }

        private final void reset() {
            this.sqk = this.sqr;
            this.sqm = this.sqs;
            this.sqn = 0;
        }

        public final void cCW() {
            AppMethodBeat.i(110868);
            ab.i(TAG, "resetWalk");
            reset();
            AppMethodBeat.o(110868);
        }

        /* JADX WARNING: Missing block: B:14:0x003f, code skipped:
            r0 = new a.o(r2, new com.tencent.mm.plugin.story.ui.view.gallery.n.c(r6.sqk, 0, r2));
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final o<i, c> cCX() {
            AppMethodBeat.i(110869);
            while (true) {
                if (this.sqt) {
                    this.sqk++;
                }
                if (this.sqk >= this.sqp.size()) {
                    AppMethodBeat.o(110869);
                    return null;
                }
                try {
                    if (this.sqp.size() > 0) {
                        i iVar = ((g) this.sqp.get(this.sqk)).rVZ;
                        n nVar = n.sqi;
                        i iVar2 = n.l(iVar) ? iVar : null;
                        if (iVar2 != null) {
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
                    AppMethodBeat.o(110869);
                }
            }
            return r0;
        }

        /* JADX WARNING: Missing block: B:14:0x0041, code skipped:
            r0 = new a.o(r2, new com.tencent.mm.plugin.story.ui.view.gallery.n.c(r6.sqk, r6.sqm, r2));
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final o<i, c> cCY() {
            AppMethodBeat.i(110870);
            while (true) {
                if (this.sqt) {
                    this.sqm++;
                }
                if (this.sqm >= this.sqo.size()) {
                    AppMethodBeat.o(110870);
                    return null;
                }
                try {
                    if (this.sqo.size() > this.sqm) {
                        i iVar = ((g) this.sqo.get(this.sqm)).rVZ;
                        n nVar = n.sqi;
                        i iVar2 = n.l(iVar) ? iVar : null;
                        if (iVar2 != null) {
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
                    AppMethodBeat.o(110870);
                }
            }
            return r0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u000bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
    public static final class c {
        private int connectionCount;
        int ehE;
        String fUL;
        private final int sqr;
        private final int sqs;
        final i sqy;

        public /* synthetic */ c(int i, int i2, i iVar) {
            this(i, i2, iVar, 0, 1);
        }

        public c(int i, int i2, i iVar, int i3, int i4) {
            j.p(iVar, "item");
            AppMethodBeat.i(110876);
            this.sqr = i;
            this.sqs = i2;
            this.sqy = iVar;
            this.ehE = i3;
            this.connectionCount = i4;
            s sVar = s.rTV;
            String be = s.be(this.sqy.fDG, this.sqy.rWj.Url);
            if (be == null) {
                be = "";
            }
            this.fUL = be;
            AppMethodBeat.o(110876);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
    static final class d implements com.tencent.mm.i.g.b {
        private final long eyR;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            final /* synthetic */ String sqz;

            a(String str) {
                this.sqz = str;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110877);
                n.a(n.sqi, this.sqz);
                y yVar = y.AUy;
                AppMethodBeat.o(110877);
                return yVar;
            }
        }

        public d(long j) {
            this.eyR = j;
        }

        public final void a(String str, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(110878);
            ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + str + ", sceneResult:" + dVar);
            n nVar;
            if (dVar == null || dVar.field_retCode != -21112) {
                if (!(str == null || dVar == null)) {
                    nVar = n.sqi;
                    if (n.spY.containsKey(str)) {
                        nVar = n.sqi;
                        i iVar = (i) n.spY.get(str);
                        if (iVar != null) {
                            if (dVar.field_recvedBytes <= 0 || dVar.field_fileLength <= 0) {
                                ab.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + dVar.field_recvedBytes + ", fileLength:" + dVar.field_fileLength);
                            } else {
                                s sVar = s.rTV;
                                com.tencent.mm.plugin.story.h.n a = s.a(iVar);
                                a.field_cacheSize = dVar.field_recvedBytes;
                                a.field_totalSize = dVar.field_fileLength;
                                com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cxX().b(a);
                                n nVar2 = n.sqi;
                                n.sqa.add(str);
                                ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + a.field_cacheSize + ", totalSize:" + a.field_totalSize + ", preloadCost:" + bo.az(this.eyR));
                                com.tencent.mm.ab.b.a(new a(str));
                                AppMethodBeat.o(110878);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.o(110878);
                return;
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + str + ", video source change!");
            nVar = n.sqi;
            n.abe(str);
            AppMethodBeat.o(110878);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    static final class e implements com.tencent.mm.i.g.a {
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }

        public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(110879);
            n nVar;
            if (dVar == null || dVar.field_retCode != -21112) {
                if (cVar != null && cVar.field_toltalLength > 0) {
                    String str2;
                    String str3;
                    nVar = n.sqi;
                    i iVar = (i) n.spY.get(str);
                    n nVar2 = n.sqi;
                    boolean a = t.a((Iterable) n.sqa, (Object) str);
                    int i2 = (int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f);
                    nVar2 = n.sqi;
                    Integer num = (Integer) n.spZ.get(str);
                    int intValue = num != null ? num.intValue() : 0;
                    String str4 = hashCode() + " onPreload, mediaId:" + str + ", startRet:" + i + ", preloadOffset:" + cVar.field_finishedLength + ", totalLength: " + cVar.field_toltalLength + " desiredPreloadPercent:" + intValue + ", preloadPercent:" + i2 + " isFinish:" + a;
                    Object obj = null;
                    if (intValue <= 0 || i2 < intValue) {
                        str2 = str4;
                    } else {
                        str2 = str4 + " exceed:true ";
                        obj = 1;
                    }
                    if (iVar != null) {
                        s sVar = s.rTV;
                        com.tencent.mm.plugin.story.h.n a2 = s.a(iVar);
                        a2.field_cacheSize = cVar.field_finishedLength;
                        a2.field_totalSize = cVar.field_toltalLength;
                        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxX().b(a2);
                        aVar = com.tencent.mm.plugin.story.model.j.rST;
                        f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(iVar.username);
                        if (aap.field_syncId == iVar.rUJ && aap.isValid()) {
                            long j = iVar.rUJ;
                            str3 = iVar.rWj.Id;
                            j.o(str3, "videoItem.media.Id");
                            if (aap.b(j, str3, a2.field_cacheSize)) {
                                str2 = str2 + " * ext pre update * ";
                                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cxU().a((long) ((int) aap.xDa), aap);
                            }
                        }
                        if (!(obj == null || str == null)) {
                            nVar = n.sqi;
                            n.sqa.add(str);
                        }
                        str3 = str2 + "update cacheSize done";
                    } else {
                        str3 = str2;
                    }
                    StringBuilder append = new StringBuilder().append(str3).append(", currentSpeed:");
                    n nVar3 = n.sqi;
                    ab.i("MicroMsg.StoryVideoPreloadMgr", append.append(n.cCR()).toString());
                }
                AppMethodBeat.o(110879);
                return 0;
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + str + ", video source change!");
            nVar = n.sqi;
            n.abe(str);
            AppMethodBeat.o(110879);
            return 0;
        }
    }

    static {
        AppMethodBeat.i(110904);
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        j.o(synchronizedMap, "Collections.synchronized…tring, StoryVideoItem>())");
        spY = synchronizedMap;
        synchronizedMap = Collections.synchronizedMap(new HashMap());
        j.o(synchronizedMap, "Collections.synchronized…p(HashMap<String, Int>())");
        spZ = synchronizedMap;
        Set synchronizedSet = Collections.synchronizedSet(new HashSet());
        j.o(synchronizedSet, "Collections.synchronizedSet(HashSet<String>())");
        sqa = synchronizedSet;
        List synchronizedList = Collections.synchronizedList(new LinkedList());
        j.o(synchronizedList, "Collections.synchronized…t(LinkedList<TaskInfo>())");
        sqb = synchronizedList;
        AppMethodBeat.o(110904);
    }

    private n() {
    }

    public static final /* synthetic */ boolean l(i iVar) {
        AppMethodBeat.i(110907);
        boolean k = k(iVar);
        AppMethodBeat.o(110907);
        return k;
    }

    public static k cCM() {
        return spU;
    }

    private static List<Integer> cCN() {
        AppMethodBeat.i(110880);
        if (cCQ()) {
            List list = spU.soU;
            AppMethodBeat.o(110880);
            return list;
        }
        List<Integer> list2 = spU.soT;
        AppMethodBeat.o(110880);
        return list2;
    }

    public static /* synthetic */ boolean e(List list, int i, int i2) {
        AppMethodBeat.i(110882);
        boolean d = d(list, i, i2);
        AppMethodBeat.o(110882);
        return d;
    }

    private static boolean d(List<? extends List<g>> list, int i, int i2) {
        boolean z;
        AppMethodBeat.i(110881);
        j.p(list, "groupItems");
        ab.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + list.size() + ", positionV:" + i + "  positionH:" + i2 + ", skipPosition:true");
        a aVar = sqd;
        j.p(list, "galleryItems");
        if (aVar.dL(list)) {
            z = false;
        } else if (aVar.sqs == i2 && aVar.sqr == i) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(110881);
        } else {
            int i3;
            int size;
            c cVar;
            int i4;
            if (i >= 0 && i2 >= 0 && i < list.size() && i2 < ((List) list.get(i)).size()) {
                g gVar = (g) ((List) list.get(i)).get(i2);
                if (gVar != null) {
                    i iVar = gVar.rVZ;
                    if (iVar != null) {
                        sqg = iVar.rUJ;
                    }
                }
            }
            sbh = 0;
            sqc = 0;
            sqd = new a(list, i, i2, sqd);
            ArrayList arrayList = new ArrayList();
            Iterable iterable = list;
            synchronized (iterable) {
                try {
                    i3 = 0;
                    for (Object next : iterable) {
                        int i5 = i3 + 1;
                        if (i3 < 0) {
                            a.a.l.dWs();
                        }
                        List list2 = (List) next;
                        if (i3 >= i && list2.size() > 0) {
                            arrayList.add(Integer.valueOf(((g) list2.get(0)).rVZ.cNE));
                        }
                        i3 = i5;
                    }
                    y yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(110881);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (i < list.size() && i2 < ((List) list.get(i)).size()) {
                size = ((List) list.get(i)).size();
                while (i2 < size) {
                    arrayList2.add(Integer.valueOf(((g) ((List) list.get(i)).get(i2)).rVZ.cNE));
                    i2++;
                }
            }
            Collection arrayList3 = new ArrayList();
            for (Object next2 : sqb) {
                cVar = (c) next2;
                if (arrayList.contains(Integer.valueOf(cVar.sqy.cNE)) || arrayList2.contains(Integer.valueOf(cVar.sqy.cNE))) {
                    z = false;
                } else {
                    i4 = 1;
                }
                if (i4 != 0) {
                    arrayList3.add(next2);
                }
            }
            Iterable<c> iterable2 = (List) arrayList3;
            synchronized (iterable2) {
                try {
                    for (c cVar2 : iterable2) {
                        j(cVar2.sqy);
                    }
                    y yVar2 = y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.o(110881);
                }
            }
            spV = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_strategy, 1);
            size = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_speed_good, 450);
            i3 = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_speed_bad, 200);
            spW = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_force_preload, 0);
            spX = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_force_canload, 100);
            spU.soR = size;
            spU.soS = i3;
            i4 = CdnLogic.getRecentAverageSpeed(2);
            ab.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + spV + " clicfg_story_preload_speed_good:" + size + " clicfg_story_preload_speed_bad:" + i3 + " clicfg_story_preload_force_preload " + spW + "  clicfg_story_preload_force_canload: " + spX + " speed:" + i4);
            if (i4 > 0 && spX > 0 && i4 < spX) {
                ab.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + i4 + " clicfg_story_preload_force_canload: " + spX);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(sqb);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    j(((c) it.next()).sqy);
                }
            }
            AppMethodBeat.o(110881);
        }
        return false;
    }

    public final void lA(long j) {
        AppMethodBeat.i(110883);
        if (sbh == j) {
            AppMethodBeat.o(110883);
            return;
        }
        sbh = j;
        if (spV == 0) {
            AppMethodBeat.o(110883);
            return;
        }
        a aVar = sqd;
        if (aVar != null) {
            aVar.cCW();
        }
        lV(true);
        AppMethodBeat.o(110883);
    }

    public final void lB(long j) {
        AppMethodBeat.i(110884);
        Long l = sqf;
        if (l != null && l.longValue() == j) {
            sqf = Long.valueOf(0);
        }
        if (sqh == j) {
            AppMethodBeat.o(110884);
            return;
        }
        sqh = j;
        if (spV == 0) {
            AppMethodBeat.o(110884);
        } else if (spX == 0) {
            AppMethodBeat.o(110884);
        } else if (sqb.size() > 0) {
            AppMethodBeat.o(110884);
        } else {
            a aVar = sqd;
            if (aVar != null) {
                aVar.cCW();
            }
            lV(false);
            AppMethodBeat.o(110884);
        }
    }

    public final void f(i iVar) {
        AppMethodBeat.i(110885);
        j.p(iVar, "item");
        ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + iVar + ' ' + an.doQ());
        if (g(iVar)) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
            lV(false);
            AppMethodBeat.o(110885);
        } else if (b(iVar) == 1) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
            lV(true);
            AppMethodBeat.o(110885);
        } else {
            if (spW == 1) {
                lV(true);
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
            AppMethodBeat.o(110885);
        }
    }

    private static int b(i iVar) {
        AppMethodBeat.i(110886);
        j.p(iVar, "item");
        s sVar = s.rTV;
        com.tencent.mm.plugin.story.h.n a = s.a(iVar);
        if (a.cCd()) {
            ab.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + iVar.rUJ);
            AppMethodBeat.o(110886);
            return 1;
        } else if (a.field_totalSize <= 0) {
            AppMethodBeat.o(110886);
            return 0;
        } else if ((((float) a.field_cacheSize) / ((float) a.field_totalSize)) * 100.0f >= ((float) spU.soQ)) {
            ab.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + a.field_cacheSize + " totalSize: " + a.field_totalSize);
            AppMethodBeat.o(110886);
            return 1;
        } else {
            AppMethodBeat.o(110886);
            return 0;
        }
    }

    private final void lV(boolean z) {
        int i = 1;
        AppMethodBeat.i(110887);
        boolean cCP = cCP();
        boolean cCQ = cCQ();
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
            ab.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + cCP + ", isBadNetwork:" + cCQ + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + sqb.size() + " maxTaskNum " + i + " totalPreLoadOneItemSelect " + sqc + " checkNet " + z + " callerFrom " + an.doQ());
            List cCN = cCN();
            while (sqb.size() < i && i2 < cCN.size() && sqc < 3 && l(((Number) cCN.get(i2)).intValue(), "startPreLoad", Fl(i2))) {
                recentAverageSpeed = i2 + 1;
                sqc++;
                i2 = recentAverageSpeed;
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + sqb.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + i2 + " preloadRunningSet " + sqb.size() + " totalPreLoadOneItemSelect " + sqc + ' ');
            AppMethodBeat.o(110887);
            return;
        }
        ab.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + recentAverageSpeed + " clicfg_story_preload_force_canload: " + spX + " callerFrom " + an.doQ());
        AppMethodBeat.o(110887);
    }

    private static /* synthetic */ boolean a(n nVar, int i, String str) {
        AppMethodBeat.i(110889);
        boolean l = nVar.l(i, str, 1);
        AppMethodBeat.o(110889);
        return l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean l(int i, String str, int i2) {
        AppMethodBeat.i(110888);
        while (true) {
            o oVar;
            n nVar = this;
            a aVar = sqd;
            o oVar2 = null;
            int i3 = 0;
            while (true) {
                oVar = oVar2;
                if (i3 < aVar.sqq.size() && oVar == null) {
                    oVar2 = aVar.cCV();
                    ab.i(a.TAG, "produceVideoItem walkVertical:" + aVar.sqk + "  walkHorizontal:" + aVar.sqm + " positionV:" + aVar.sqr + " positionH:" + aVar.sqs + ", ret:" + oVar2);
                    i3++;
                } else if (oVar != null) {
                    AppMethodBeat.o(110888);
                    return false;
                } else {
                    Object obj;
                    i iVar = (i) oVar.first;
                    String str2 = ((c) oVar.second).fUL;
                    StringBuilder append = new StringBuilder("try preload mediaId ").append(str2).append(" videoItem:").append(iVar).append(" pos:").append((c) oVar.second).append("  groupinfo ");
                    a aVar2 = sqd;
                    ab.i("MicroMsg.StoryVideoPreloadMgr", append.append("positionV:" + aVar2.sqr + ", positionH:" + aVar2.sqs + ", walkVertical:" + aVar2.sqk + ", walkHorizontal:" + aVar2.sqm).append(" quota:").append(i).append("  fromTag:").append(str).toString());
                    for (Object next : sqb) {
                        if (j.j(((c) next).fUL, str2)) {
                            obj = next;
                            break;
                        }
                    }
                    obj = null;
                    c cVar = (c) obj;
                    if (cVar == null || i > cVar.ehE) {
                        String str3;
                        if ((((CharSequence) str2).length() == 0 ? 1 : null) == null) {
                            str3 = str2;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null) {
                            int a = a(str2, iVar.rWj, i, cCP());
                            s sVar = s.rTV;
                            com.tencent.mm.plugin.story.h.n a2 = s.a(iVar);
                            if (a2.cCd() || (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) a)) {
                                ab.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str2 + ", already reach cache size! cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", cachePercent:" + ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f) + "  fromTag:" + str);
                            } else if (nVar.a(iVar, a, i2, (c) oVar.second)) {
                                ((c) oVar.second).ehE = i;
                                AppMethodBeat.o(110888);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        ab.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + i + " cur:" + cVar.ehE + " fromTag:" + str);
                    }
                }
            }
            if (oVar != null) {
            }
        }
    }

    public static /* synthetic */ void dK(List list) {
        AppMethodBeat.i(110891);
        q(list, 0);
        AppMethodBeat.o(110891);
    }

    public static void q(List<i> list, int i) {
        int i2 = 0;
        AppMethodBeat.i(110890);
        j.p(list, "videoItemList");
        ab.c("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + list.size(), new Object[0]);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + cCP() + ", isBadNetwork:" + cCQ() + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + sqb.size() + " downloadExpect " + i);
        List cCN = cCN();
        Iterable<i> iterable = list;
        synchronized (iterable) {
            try {
                for (i iVar : iterable) {
                    if (k(iVar)) {
                        int intValue = i > 0 ? i : i2 < cCN.size() ? ((Number) cCN.get(i2)).intValue() : ((Number) t.fL(cCN)).intValue();
                        int Fl = Fl(i2);
                        s sVar = s.rTV;
                        String be = s.be(iVar.fDG, iVar.rWj.Url);
                        int a = a(be, iVar.rWj, intValue, cCP());
                        sVar = s.rTV;
                        com.tencent.mm.plugin.story.h.n a2 = s.a(iVar);
                        for (Object next : sqb) {
                            if (j.j(((c) next).fUL, be)) {
                                break;
                            }
                        }
                        Object next2 = null;
                        if (next2 != null) {
                            ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + be + ", already prealoding!");
                        } else if (a2.cCd() || (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) a)) {
                            ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + be + ", already reach cache size! cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", cachePercent:" + ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f));
                        } else {
                            if (sqi.a(iVar, a, Fl, new c(0, i2, iVar, intValue, Fl))) {
                                i2++;
                            }
                        }
                    }
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(110890);
            }
        }
        ab.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + i2 + " preloadRunningSet " + sqb.size());
    }

    private static boolean g(i iVar) {
        AppMethodBeat.i(110892);
        if (iVar.cze()) {
            AppMethodBeat.o(110892);
            return true;
        }
        s sVar = s.rTV;
        if (com.tencent.mm.vfs.e.asZ(s.a(iVar.rWj)) > 0) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + iVar.rWj.cNE + " username:" + iVar.username);
            AppMethodBeat.o(110892);
            return true;
        }
        sVar = s.rTV;
        if (s.a(iVar).cCd()) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + iVar.rWj.cNE + " username:" + iVar.username);
            AppMethodBeat.o(110892);
            return true;
        }
        AppMethodBeat.o(110892);
        return false;
    }

    private synchronized boolean a(i iVar, int i, int i2, c cVar) {
        boolean z;
        AppMethodBeat.i(110893);
        j.p(iVar, "videoItem");
        j.p(cVar, "taskInfo");
        if (iVar.cze() || bo.isNullOrNil(iVar.rWj.Url)) {
            AppMethodBeat.o(110893);
            z = false;
        } else if (g(iVar)) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + iVar.rWj.Url);
            AppMethodBeat.o(110893);
            z = false;
        } else {
            String str = iVar.rWj.Url;
            String str2 = cVar.fUL;
            s sVar = s.rTV;
            com.tencent.mm.plugin.story.h.n a = s.a(iVar);
            ab.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str2 + ", " + i + ", playingMediaId:" + sqe + ", " + a.field_filePath + ", " + str + "  videoCache " + a);
            if (str2 == null || u.I(sqe, str2, false)) {
                AppMethodBeat.o(110893);
                z = false;
            } else {
                int i3;
                s sVar2 = s.rTV;
                com.tencent.mm.vfs.e.tf(s.aaF(iVar.username));
                j.o(str, "url");
                String str3 = a.field_filePath;
                j.o(str3, "videoCache.field_filePath");
                ab.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str2 + ", path:" + str3 + ", url:" + str + ", preloadPercent:" + i + ", connectionCount:" + i2);
                h hVar = new h();
                hVar.field_mediaId = str2;
                hVar.url = str;
                hVar.egx = 2;
                hVar.egD = 2;
                hVar.egy = 6;
                hVar.egI = i;
                hVar.field_preloadRatio = i;
                hVar.concurrentCount = 4;
                hVar.field_fullpath = str3;
                hVar.egl = new e();
                hVar.egz = new d(bo.yz());
                hVar.connectionCount = i2;
                hVar.field_fileType = com.tencent.mm.i.a.efK;
                hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.v(2, str3);
                com.tencent.mm.al.f.afx().d(hVar);
                ab.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + hVar + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
                spY.put(str2, iVar);
                spZ.put(str2, Integer.valueOf(i));
                int i4 = 0;
                for (c cVar2 : sqb) {
                    if (j.j(cVar2.fUL, cVar.fUL)) {
                        i3 = i4;
                        break;
                    }
                    i4++;
                }
                i3 = -1;
                if (i3 > 0) {
                    sqb.set(i3, cVar);
                } else {
                    sqb.add(cVar);
                }
                sqa.remove(str2);
                z = true;
                AppMethodBeat.o(110893);
            }
        }
        return z;
    }

    private static int Fl(int i) {
        AppMethodBeat.i(110894);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(i)));
        List list = spU.soV;
        if (i >= spU.soV.size()) {
            i = spU.soV.size() - 1;
        }
        int intValue = ((Number) list.get(i)).intValue();
        AppMethodBeat.o(110894);
        return intValue;
    }

    public static void h(i iVar) {
        Object obj;
        AppMethodBeat.i(110895);
        j.p(iVar, "videoItem");
        s sVar = s.rTV;
        String be = s.be(iVar.fDG, iVar.rWj.Url);
        sqe = be;
        sqf = Long.valueOf(iVar.rUJ);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + sqe + " then remove it from preload");
        for (Object next : sqb) {
            if (j.j(be, ((c) next).fUL)) {
                obj = next;
                break;
            }
        }
        obj = null;
        c cVar = (c) obj;
        if (cVar != null) {
            sqb.remove(cVar);
            j(cVar.sqy);
            AppMethodBeat.o(110895);
            return;
        }
        AppMethodBeat.o(110895);
    }

    public static b i(i iVar) {
        AppMethodBeat.i(110896);
        j.p(iVar, "videoItem");
        s sVar = s.rTV;
        String be = s.be(iVar.fDG, iVar.rWj.Url);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(be)));
        sVar = s.rTV;
        com.tencent.mm.plugin.story.h.n a = s.a(iVar);
        b bVar;
        if (a.field_cacheSize <= 0 || a.field_totalSize <= 0) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", be + " not hit cache or moov not ready");
            bVar = new b(false, 0, 0, false);
            AppMethodBeat.o(110896);
            return bVar;
        }
        ab.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + be + ", cachePercent:" + (((float) a.field_cacheSize) / ((float) a.field_totalSize)) + ", filePath:" + a.field_filePath);
        String str = a.field_filePath;
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        long[] jArr = new long[2];
        c2CDownloadRequest.fileKey = be;
        c2CDownloadRequest.fileType = 6;
        c2CDownloadRequest.url = iVar.rWj.Url;
        c2CDownloadRequest.savePath = str;
        ab.i("MicroMsg.StoryVideoPreloadMgr", be + " queryMoovReady: " + CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr) + ", offset:" + jArr[0] + ", length:" + jArr[1] + ", preloadFinish:" + t.a((Iterable) sqa, (Object) be));
        bVar = new b(true, jArr[0], jArr[1], t.a((Iterable) sqa, (Object) be));
        AppMethodBeat.o(110896);
        return bVar;
    }

    private static void j(i iVar) {
        Object obj;
        AppMethodBeat.i(110897);
        j.p(iVar, "videoItem");
        s sVar = s.rTV;
        String be = s.be(iVar.fDG, iVar.rWj.Url);
        ab.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(be)));
        com.tencent.mm.al.f.afx().rO(be);
        for (Object next : sqb) {
            if (j.j(((c) next).fUL, be)) {
                obj = next;
                break;
            }
        }
        obj = null;
        c cVar = (c) obj;
        if (cVar != null) {
            sqb.remove(cVar);
            if (sqc > 0) {
                sqc--;
            }
            AppMethodBeat.o(110897);
            return;
        }
        AppMethodBeat.o(110897);
    }

    public static void cCO() {
        AppMethodBeat.i(110898);
        ab.c("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
        for (String str : spY.keySet()) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
            com.tencent.mm.al.f.afx().rO(str);
        }
        spY.clear();
        spZ.clear();
        sqd = new a(new ArrayList());
        sqb.clear();
        AppMethodBeat.o(110898);
    }

    private static int a(String str, cek cek, int i, boolean z) {
        AppMethodBeat.i(110899);
        float f = cek.duration;
        ab.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + i + ", mediaId:" + str + ", duration:" + f + ", isGoodNetwork:" + z + " media:" + cek.duration);
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
        AppMethodBeat.o(110899);
        return i2;
    }

    private static boolean cCQ() {
        AppMethodBeat.i(110901);
        int i = spU.soS;
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        if (1 <= recentAverageSpeed && i >= recentAverageSpeed) {
            AppMethodBeat.o(110901);
            return true;
        }
        AppMethodBeat.o(110901);
        return false;
    }

    public static int cCR() {
        AppMethodBeat.i(139114);
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        AppMethodBeat.o(139114);
        return recentAverageSpeed;
    }

    private static boolean k(i iVar) {
        AppMethodBeat.i(110903);
        if (g(iVar) || iVar.cze()) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + iVar + " isLocalVideo or fake video");
            AppMethodBeat.o(110903);
            return false;
        }
        s sVar = s.rTV;
        String be = s.be(iVar.fDG, iVar.rWj.Url);
        if (bo.isNullOrNil(be) || bo.isNullOrNil(iVar.rWj.Url) || u.I(sqe, be, false)) {
            ab.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + be + ", already request preload or url " + iVar.rWj.Url);
            AppMethodBeat.o(110903);
            return false;
        }
        AppMethodBeat.o(110903);
        return true;
    }

    private static boolean cCP() {
        AppMethodBeat.i(110900);
        if (CdnLogic.getRecentAverageSpeed(2) >= spU.soR) {
            AppMethodBeat.o(110900);
            return true;
        }
        AppMethodBeat.o(110900);
        return false;
    }

    public static final /* synthetic */ void abe(String str) {
        AppMethodBeat.i(110905);
        ab.c("MicroMsg.StoryVideoPreloadMgr", "onVideoSourceChange: ".concat(String.valueOf(str)), new Object[0]);
        i iVar = (i) spY.get(str);
        if (iVar != null) {
            j(iVar);
            s sVar = s.rTV;
            com.tencent.mm.plugin.story.h.n a = s.a(iVar);
            a.cCe();
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxX().b(a);
            com.tencent.mm.vfs.e.deleteFile(a.field_filePath);
        }
        AppMethodBeat.o(110905);
    }

    public static final /* synthetic */ void a(n nVar, String str) {
        Object obj;
        AppMethodBeat.i(110906);
        for (Object next : sqb) {
            if (j.j(str, ((c) next).fUL)) {
                obj = next;
                break;
            }
        }
        obj = null;
        obj = (c) obj;
        if (obj != null) {
            sqb.remove(obj);
        }
        if (spV == 1) {
            boolean z;
            ab.i("MicroMsg.StoryVideoPreloadMgr", "upgrades mediaId " + str + " runningMediaId " + sqf + " selectMediaId " + sqg);
            Long l = sqf;
            long j = sqg;
            if (l != null && l.longValue() == j) {
                l = sqf;
                if (l == null || l.longValue() != 0) {
                    z = true;
                    nVar.lV(z);
                }
            }
            z = false;
            nVar.lV(z);
        }
        if (spU.soP) {
            int intValue;
            int i;
            y yVar;
            boolean cCP = cCP();
            if (cCQ()) {
                if ((!((Collection) sqb).isEmpty() ? 1 : null) != null) {
                    ab.i("MicroMsg.StoryVideoPreloadMgr", "isBadNetWork pass " + sqb.size() + " getNetworkSpeed:" + CdnLogic.getRecentAverageSpeed(2));
                    AppMethodBeat.o(110906);
                    return;
                }
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", "upgrades preloadRunningSet size " + sqb.size());
            List cCN = cCN();
            if ((!((Collection) cCN).isEmpty() ? 1 : null) != null) {
                int intValue2 = ((Number) t.fL(cCN)).intValue();
                if (a(nVar, intValue2, "upgrades")) {
                    ab.i("MicroMsg.StoryVideoPreloadMgr", "add new task when upgrades newQuota " + intValue2 + " then running " + sqb.size());
                }
            }
            int u = t.u(cCN);
            Integer num = (Integer) t.r(cCN);
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = 0;
            }
            Iterable<c> iterable = sqb;
            synchronized (iterable) {
                try {
                    i = u;
                    for (c cVar : iterable) {
                        i -= cVar.ehE;
                    }
                    yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(110906);
                }
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", "upgrades quotaList:" + t.u(cCN) + " totalQuota " + i + " maxQuota " + intValue);
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
                            c cVar2 = (c) it.next();
                            str3 = str2 + "mediaId " + cVar2.fUL + ", quota:" + cVar2.ehE;
                        }
                        y yVar2 = y.AUy;
                    } catch (Throwable th) {
                        AppMethodBeat.o(110906);
                    }
                }
                ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota no quota left " + i + " info: " + str2);
                return;
            }
            String str4;
            j.p(cCN, "list");
            a.f.b.u.b bVar = new a.f.b.u.b();
            bVar.AVD = 0;
            a.f.a.a aVar = new com.tencent.mm.ab.b.a(bVar, cCN);
            LinkedList linkedList = new LinkedList();
            Iterable<c> iterable3 = sqb;
            synchronized (iterable3) {
                try {
                    for (c cVar3 : iterable3) {
                        linkedList.add(cVar3);
                    }
                    yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(110906);
                }
            }
            if (obj != null) {
                if ((obj.ehE < intValue ? 1 : null) == null) {
                    obj = null;
                }
                if (obj != null) {
                    ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota try add remove which one remove " + intValue + "  it.quota " + obj);
                    linkedList.add(obj);
                }
            }
            str2 = "";
            Iterable<c> iterable4 = linkedList;
            synchronized (iterable4) {
                try {
                    str4 = str2;
                    for (c cVar4 : iterable4) {
                        str4 = str4 + "mediaId " + cVar4.fUL + ", quota:" + cVar4.ehE;
                    }
                    y yVar3 = y.AUy;
                } catch (Throwable th2) {
                    AppMethodBeat.o(110906);
                }
            }
            ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota quota left " + i + " info: " + str4);
            Iterable<c> iterable5 = linkedList;
            synchronized (iterable5) {
                try {
                    for (c cVar42 : iterable5) {
                        Integer num2 = (Integer) aVar.invoke();
                        ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota getQuota1 " + num2 + " cur: quota " + cVar42.ehE + " cdnMediaId " + cVar42.fUL);
                        if (num2 != null) {
                            int intValue3 = num2.intValue();
                            obj = (intValue3 <= 0 || intValue3 <= cVar42.ehE) ? null : 1;
                            Integer num3 = obj != null ? num2 : null;
                            if (num3 != null) {
                                num3.intValue();
                                String str5 = cVar42.fUL;
                                i iVar = cVar42.sqy;
                                int a = a(str5, iVar.rWj, num2.intValue(), cCP);
                                s sVar = s.rTV;
                                com.tencent.mm.plugin.story.h.n a2 = s.a(iVar);
                                ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota getQuota2 mediaId " + str5 + " old " + cVar42.ehE + " newupgradeQuota: " + num2);
                                if (a2.cCd() || (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) a)) {
                                    ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota pull preload video, " + str5 + ", already reach cache size! cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", cachePercent:" + ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f));
                                } else if (sqi.a(iVar, a, 1, cVar42)) {
                                    cVar42.ehE = num2.intValue();
                                    ab.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota ok! mediaId ".concat(String.valueOf(str5)));
                                }
                            }
                        }
                    }
                    y yVar4 = y.AUy;
                } catch (Throwable th3) {
                    AppMethodBeat.o(110906);
                }
            }
            return;
        }
        AppMethodBeat.o(110906);
    }
}
