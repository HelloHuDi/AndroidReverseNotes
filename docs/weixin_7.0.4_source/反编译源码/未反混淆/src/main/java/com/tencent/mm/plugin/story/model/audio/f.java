package com.tencent.mm.plugin.story.model.audio;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.o;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.concurrent.Callable;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R.\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006."}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/GetRecommendAudioTask;", "", "videoPath", "", "startTime", "", "endTime", "(Ljava/lang/String;JJ)V", "TAG", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "getEndTime", "()J", "frameInterval", "", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "imageDataTime", "", "isLoading", "", "()Z", "setLoading", "(Z)V", "lastRequestId", "latitude", "", "longitude", "getStartTime", "thumbFetcherPool", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher$FetcherPool;", "thumbHeight", "thumbTarget", "thumbWidth", "getVideoPath", "()Ljava/lang/String;", "getMusicRequestId", "loadMore", "processImageData", "plugin-story_release"})
public final class f {
    public final String TAG;
    public float cEB;
    public float cGm;
    private final long endTime;
    public b<? super LinkedList<bql>, y> exD;
    int fgI;
    int fgJ;
    int frameInterval;
    public boolean isLoading;
    public final LinkedList<com.tencent.mm.bt.b> rUA;
    public long rUB;
    private final com.tencent.mm.plugin.mmsight.segment.d.a rUC;
    private int rUy;
    private int[] rUz;
    private final long startTime;
    final String videoPath;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.story.model.audio.f$1 */
    static final class AnonymousClass1<V> implements Callable<d> {
        final /* synthetic */ f rUD;

        AnonymousClass1(f fVar) {
            this.rUD = fVar;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.i(109194);
            d k = o.k(this.rUD.videoPath, this.rUD.frameInterval, this.rUD.fgJ, this.rUD.fgI);
            AppMethodBeat.o(109194);
            return k;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ f rUD;

        public a(f fVar) {
            this.rUD = fVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(109195);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            this.rUD.isLoading = false;
            int i = aVar.errType;
            int i2 = aVar.errCode;
            ab.i(this.rUD.TAG, "LogStory: getRecommendMusic callback " + i + ' ' + i2 + ", " + aVar.aIm);
            b bVar;
            if (i == 0 && i2 == 0) {
                ann ann = (ann) aVar.fsy;
                this.rUD.rUB = ann.rUb;
                LinkedList linkedList = ann.vKY;
                ab.i(this.rUD.TAG, "get audio list ".concat(String.valueOf(ann)));
                bVar = this.rUD.exD;
                if (bVar != null) {
                    j.o(linkedList, "audioList");
                    bVar.am(linkedList);
                }
                Object obj2 = com.tencent.mm.vending.c.a.zXH;
                AppMethodBeat.o(109195);
                return obj2;
            }
            bVar = this.rUD.exD;
            if (bVar != null) {
                bVar.am(new LinkedList());
            }
            Void voidR = com.tencent.mm.vending.c.a.zXH;
            AppMethodBeat.o(109195);
            return voidR;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(String str, long j, long j2) {
        int i;
        j.p(str, "videoPath");
        AppMethodBeat.i(109197);
        this.videoPath = str;
        this.startTime = j;
        this.endTime = j2;
        this.TAG = "MicroMsg.GetRecommendAudioTask";
        this.frameInterval = 1000;
        this.rUy = 299;
        this.fgJ = 299;
        this.fgI = 299;
        this.rUz = new int[0];
        this.rUA = new LinkedList();
        this.rUy = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_music_story_thumb_size, 299);
        this.fgJ = this.rUy;
        this.fgI = this.rUy;
        ab.i(this.TAG, "GetRecommendAudioTask thumbWidth " + this.fgJ + " thumbHeight " + this.fgI + " thumbTarget " + this.rUy);
        com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(this.videoPath);
        int i2 = WR != null ? WR.eWK : 0;
        if (i2 <= 0) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.videoPath);
                i = bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            } catch (Exception e) {
            }
            if (i <= 0) {
                ab.w(this.TAG, "get video duration error! file exit: " + e.ct(this.videoPath));
            }
            this.rUC = new com.tencent.mm.plugin.mmsight.segment.d.a(3, new AnonymousClass1(this));
            if ((this.endTime < 0 ? this.endTime : (long) i) - (this.startTime < 0 ? this.startTime : 0) <= 0) {
                this.rUz = new int[]{(int) (100 + (this.startTime < 0 ? this.startTime : 0)), (int) (((this.endTime < 0 ? this.endTime : (long) i) - (this.startTime < 0 ? this.startTime : 0)) / 2), (int) ((this.endTime < 0 ? this.endTime : (long) i) - 100)};
            } else if (i > 300) {
                this.rUz = new int[]{100, i / 2, i - 100};
            }
            cyV();
            AppMethodBeat.o(109197);
        }
        i = i2;
        if (i <= 0) {
        }
        this.rUC = new com.tencent.mm.plugin.mmsight.segment.d.a(3, new AnonymousClass1(this));
        if (this.startTime < 0) {
        }
        if (this.endTime < 0) {
        }
        if ((this.endTime < 0 ? this.endTime : (long) i) - (this.startTime < 0 ? this.startTime : 0) <= 0) {
        }
        cyV();
        AppMethodBeat.o(109197);
    }

    private final void cyV() {
        AppMethodBeat.i(109196);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.fgJ, this.fgI, Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(this.fgJ, this.fgI, Config.ARGB_8888);
            d bQd = this.rUC.bQd();
            bQd.reuseBitmap(createBitmap2);
            for (int i : this.rUz) {
                new Canvas(createBitmap).drawBitmap(bQd.getFrameAtTime((long) i), null, new Rect(0, 0, this.fgJ, this.fgI), null);
                this.rUA.add(new com.tencent.mm.bt.b(com.tencent.mm.sdk.platformtools.d.c(createBitmap, 50)));
            }
            this.rUC.a(bQd);
            this.rUC.destroy();
            AppMethodBeat.o(109196);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "processImageData error", new Object[0]);
            AppMethodBeat.o(109196);
        }
    }
}
