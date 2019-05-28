package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.k.u;
import a.v;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.media.g.i;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.ui.view.editor.item.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ak;
import com.tencent.mm.vfs.e;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004`!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u0011J:\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u0002032\u0006\u0010+\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\u001aJ\u000e\u00104\u001a\u0002052\u0006\u0010\u0010\u001a\u00020\u0011J*\u00106\u001a\u0004\u0018\u00010 2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0002J0\u0010<\u001a\u00020\u00132\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>H\u0002J*\u0010?\u001a\u0004\u0018\u00010 2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#H\u0002J0\u0010B\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>H\u0002J\u001e\u0010C\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>J\u0018\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J4\u0010F\u001a\u0004\u0018\u00010 2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#H\u0002J:\u0010K\u001a\u00020\u00132\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>H\u0002J:\u0010L\u001a\u00020M2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u000201H\u0002J&\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\fJ\u0016\u0010S\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00162\u0006\u0010T\u001a\u00020*J\u000e\u0010U\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0016J\u000e\u0010V\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006W"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "checkMD5", "", "file", "destMD5", "checkStoryEditorFileMD5", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "cleanUnAvailableData", "data", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "getFakeVideoData", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "getStoryDataEditorItemReport", "dataType", "", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "insertCompositeVideo", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "view", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "muteOrigin", "mixAudio", "captureInfo", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "insertEditorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onUnSerializeStoryDataDrawingRect", "", "reshowEmojiEditorItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "viewMatrix", "Landroid/graphics/Matrix;", "validArea", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "reshowPositionEditorItem", "cityName", "poiName", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "reshowTextEditorItem", "text", "", "textColor", "textBgColor", "reshowTextItem", "serializeStoryDataToByteArray", "", "signStoryDataMix", "localId", "mixVideoPath", "mixThumbPath", "needExport", "signStoryDataMixEnable", "storyEditorData", "signStoryDataMixError", "signStoryDataMixTime", "plugin-story_release"})
public final class l {
    private static Rect eUN = new Rect(0, 0, ak.hy(ah.getContext()).x, ak.hy(ah.getContext()).y);
    public static final l sac = new l();

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$1$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$1"})
    static final class a implements Runnable {
        final /* synthetic */ Context fbw;
        final /* synthetic */ cgu sad;
        final /* synthetic */ Matrix sae;
        final /* synthetic */ ViewGroup saf;
        final /* synthetic */ cee sag;

        a(cgu cgu, Matrix matrix, Context context, ViewGroup viewGroup, cee cee) {
            this.sad = cgu;
            this.sae = matrix;
            this.fbw = context;
            this.saf = viewGroup;
            this.sag = cee;
        }

        public final void run() {
            AppMethodBeat.i(109666);
            l lVar = l.sac;
            l.a((CharSequence) this.sad.text, this.sad.textColor, this.sad.eUv, this.sae, this.fbw, this.saf);
            AppMethodBeat.o(109666);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$3$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$3"})
    static final class c implements Runnable {
        final /* synthetic */ Context fbw;
        final /* synthetic */ Matrix sae;
        final /* synthetic */ ViewGroup saf;
        final /* synthetic */ cee sag;
        final /* synthetic */ ayv saj;

        c(ayv ayv, Matrix matrix, Context context, ViewGroup viewGroup, cee cee) {
            this.saj = ayv;
            this.sae = matrix;
            this.fbw = context;
            this.saf = viewGroup;
            this.sag = cee;
        }

        public final void run() {
            AppMethodBeat.i(109668);
            l lVar = l.sac;
            String str = this.saj.eUt;
            j.o(str, "it.cityName");
            String str2 = this.saj.eUu;
            j.o(str2, "it.poiName");
            l.a(str, str2, this.sae, this.fbw, this.saf);
            AppMethodBeat.o(109668);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$2$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$2"})
    static final class b implements Runnable {
        final /* synthetic */ Context fbw;
        final /* synthetic */ Matrix sae;
        final /* synthetic */ ViewGroup saf;
        final /* synthetic */ cee sag;
        final /* synthetic */ xy sah;
        final /* synthetic */ Rect sai;

        b(xy xyVar, Matrix matrix, Rect rect, Context context, ViewGroup viewGroup, cee cee) {
            this.sah = xyVar;
            this.sae = matrix;
            this.sai = rect;
            this.fbw = context;
            this.saf = viewGroup;
            this.sag = cee;
        }

        public final void run() {
            AppMethodBeat.i(109667);
            l lVar = l.sac;
            com.tencent.mm.kernel.b.a M = g.M(d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            EmojiInfo Je = ((d) M).getProvider().Je(this.sah.cvZ);
            j.o(Je, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
            l.a(Je, this.sae, this.fbw, this.saf);
            AppMethodBeat.o(109667);
        }
    }

    static {
        AppMethodBeat.i(109684);
        AppMethodBeat.o(109684);
    }

    private l() {
    }

    public static Rect czI() {
        return eUN;
    }

    public static com.tencent.mm.plugin.story.h.d a(com.tencent.mm.plugin.story.d.b.b bVar, boolean z, AudioCacheInfo audioCacheInfo, com.tencent.mm.plugin.story.e.a aVar, long j, cei cei) {
        AppMethodBeat.i(109669);
        j.p(bVar, "view");
        j.p(aVar, "captureInfo");
        j.p(cei, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        try {
            Object obj;
            int i;
            long j2;
            com.tencent.mm.ab.a aVar2 = new com.tencent.mm.ab.a("insertCompositeVideo");
            com.tencent.mm.plugin.story.h.d dVar = new com.tencent.mm.plugin.story.h.d();
            dVar.field_mixFlag = 0;
            dVar.field_mixRetryTime = 0;
            dVar.field_timeStamp = j;
            com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
            if (com.tencent.mm.plugin.story.model.j.a.cye() == com.tencent.mm.plugin.story.c.a.f.a.BACKGROUND) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i = 1;
            } else {
                i = 0;
            }
            dVar.field_available = i;
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "is running serialize the story to bytearray");
            if (z) {
                if (audioCacheInfo == null) {
                    i = 0;
                } else {
                    i = 2;
                }
            } else if (audioCacheInfo == null) {
                i = 1;
            } else {
                i = 3;
            }
            cee cee = new cee();
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "input the timeStamp is ".concat(String.valueOf(j)));
            if (i == 3) {
                com.tencent.mm.media.g.i.a aVar4 = i.eYK;
                if (e.ct(com.tencent.mm.media.g.i.a.lY(aVar.fbT))) {
                    aVar4 = i.eYK;
                    cee.xdR = com.tencent.mm.media.g.i.a.lY(aVar.fbT);
                }
            }
            cee.timeStamp = j;
            if (aVar.rRG == -1) {
                j2 = 0;
            } else {
                j2 = aVar.rRG;
            }
            cee.startTime = j2;
            cee.endTime = aVar.rRH;
            cee.thumbPath = aVar.fbU;
            cee.videoPath = aVar.fbT;
            cee.fbV = aVar.fbV;
            cee.smk = cei;
            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(aVar.fbT);
            if (WR != null && (aVar.rRH == -1 || aVar.rRH == 0)) {
                cee.endTime = (long) WR.eWK;
            }
            cee.eTb = i;
            cee.xdS = bVar.getItemContainer().getLeft();
            cee.xdU = bVar.getItemContainer().getTop();
            cee.xdT = bVar.getItemContainer().getRight();
            cee.xdV = bVar.getItemContainer().getBottom();
            cee.xdW = new LinkedList();
            if (audioCacheInfo != null) {
                cee.eYi = audioCacheInfo.cachePath;
                cee.rTW = audioCacheInfo.rTW;
                cee.musicUrl = audioCacheInfo.musicUrl;
                cee.aIM = audioCacheInfo.aIM;
                cee.rTZ = audioCacheInfo.rTZ;
                cee.xdZ = audioCacheInfo.position;
                cee.xea = audioCacheInfo.rUb;
            }
            j.p(cee, "storyEditorProtoData");
            ced ced = new ced();
            ced.xdP = com.tencent.mm.a.g.cz(cee.xdR);
            ced.xdO = com.tencent.mm.a.g.cz(cee.eYi);
            ced.xdN = com.tencent.mm.a.g.cz(cee.videoPath);
            ced.xdQ = com.tencent.mm.a.g.cz(cee.thumbPath);
            cee.xdY = ced;
            for (h UJ : bVar.getItemContainer().getAllItemViews()) {
                com.tencent.mm.media.editor.a.a UJ2 = UJ.UJ();
                if (UJ2 != null) {
                    hk hkVar = new hk();
                    hkVar.dataType = UJ2.eUi.value;
                    hkVar.vKa = aa.ad(UJ2.UG().toByteArray());
                    cee.xdW.add(hkVar);
                }
            }
            byte[] toByteArray = cee.toByteArray();
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "storyEditorItem " + cee.videoPath + " thumb " + cee.thumbPath + " and result " + e.ct(cee.thumbPath) + " music " + cee.eYi + " ret " + bo.ga(((long) toByteArray.length) * 1) + '}');
            j.o(toByteArray, "ret");
            j.p(toByteArray, "value");
            dVar.field_baseItemData = toByteArray;
            aVar3 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxY().b((com.tencent.mm.sdk.e.c) dVar);
            AppMethodBeat.o(109669);
            return dVar;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Media.StoryDataProtoUtil", e, "", new Object[0]);
            AppMethodBeat.o(109669);
            return null;
        }
    }

    public static cej a(com.tencent.mm.plugin.story.d.b.b bVar, AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.i(109670);
        j.p(bVar, "view");
        cej cej = new cej();
        for (h UJ : bVar.getItemContainer().getAllItemViews()) {
            com.tencent.mm.media.editor.a.a UJ2 = UJ.UJ();
            if (UJ2 != null) {
                int i = UJ2.eUi.value;
                v vVar;
                if (i == com.tencent.mm.media.editor.a.e.TEXT.value) {
                    if (UJ2 == null) {
                        vVar = new v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.TextItem");
                        AppMethodBeat.o(109670);
                        throw vVar;
                    }
                    cej.xeh.add(String.valueOf(((com.tencent.mm.media.editor.a.j) UJ2).text));
                } else if (i != com.tencent.mm.media.editor.a.e.EMOJI.value) {
                    continue;
                } else if (UJ2 == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.EmojiItem");
                    AppMethodBeat.o(109670);
                    throw vVar;
                } else {
                    LinkedList linkedList = cej.xeg;
                    EmojiInfo emojiInfo = ((com.tencent.mm.media.editor.a.g) UJ2).exP;
                    linkedList.add(emojiInfo != null ? emojiInfo.Aq() : null);
                }
            }
        }
        if (audioCacheInfo != null) {
            cej.xef = true;
            cej.rTW = audioCacheInfo.rTW;
            cej.xdZ = audioCacheInfo.position;
            cej.xee = audioCacheInfo.rUb;
        } else {
            cej.xef = false;
        }
        AppMethodBeat.o(109670);
        return cej;
    }

    public static ArrayList<com.tencent.mm.media.editor.a.b> a(cee cee, Context context) {
        AppMethodBeat.i(109671);
        j.p(cee, "storyEditorProtoData");
        j.p(context, "context");
        ArrayList arrayList = new ArrayList();
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "get the editor data which is waiting for run mixing");
        LinkedList<hk> linkedList = cee.xdW;
        j.o(linkedList, "storyEditorProtoData.baseItemData");
        for (hk hkVar : linkedList) {
            int i = hkVar.dataType;
            com.tencent.mm.bt.a cgu;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            com.tencent.mm.bt.b buffer;
            com.tencent.mm.bt.a aVar;
            Matrix matrix;
            float[] fArr;
            int i2;
            LinkedList<Float> linkedList2;
            int i3;
            if (i == com.tencent.mm.media.editor.a.e.TEXT.value) {
                cgu = new cgu();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    aVar = cgu;
                } catch (Exception e) {
                    ab.b("safeParser", "", e);
                    aVar = null;
                }
                cgu cgu2 = (cgu) aVar;
                if (cgu2 != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + cgu2.text);
                    Bitmap f = new f(context).f(cgu2.text, cgu2.textColor, cgu2.eUv);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i = 0;
                    LinkedList<Float> linkedList3 = cgu2.wCL.xls;
                    j.o(linkedList3, "it.matrix.value");
                    for (Float f2 : linkedList3) {
                        i2 = i + 1;
                        j.o(f2, "data");
                        fArr[i] = f2.floatValue();
                        i = i2;
                    }
                    matrix.setValues(fArr);
                    arrayList.add(new com.tencent.mm.media.editor.a.d(f, matrix));
                }
            } else if (i == com.tencent.mm.media.editor.a.e.EMOJI.value) {
                cgu = new xy();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    aVar = cgu;
                } catch (Exception e2) {
                    ab.b("safeParser", "", e2);
                    aVar = null;
                }
                xy xyVar = (xy) aVar;
                if (xyVar != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + xyVar.cvZ);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = xyVar.wdG.xls;
                    j.o(linkedList2, "it.editorMatrix.value");
                    for (Float f3 : linkedList2) {
                        i3 = i2 + 1;
                        j.o(f3, "data");
                        fArr[i2] = f3.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    com.tencent.mm.kernel.b.a M = g.M(d.class);
                    j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    EmojiInfo Je = ((d) M).getProvider().Je(xyVar.cvZ);
                    j.o(Je, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
                    arrayList.add(new com.tencent.mm.media.editor.a.f(Je, matrix));
                }
            } else if (i == com.tencent.mm.media.editor.a.e.LOCATION.value) {
                cgu = new ayv();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    aVar = cgu;
                } catch (Exception e22) {
                    ab.b("safeParser", "", e22);
                    aVar = null;
                }
                ayv ayv = (ayv) aVar;
                if (ayv != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "location data is  " + ayv.eUt + " - " + ayv.eUu + " and matrix is " + ayv.wCL.xls);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = ayv.wCL.xls;
                    j.o(linkedList2, "it.matrix.value");
                    for (Float f32 : linkedList2) {
                        i3 = i2 + 1;
                        j.o(f32, "data");
                        fArr[i2] = f32.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    com.tencent.mm.plugin.story.ui.view.editor.item.e eVar = new com.tencent.mm.plugin.story.ui.view.editor.item.e(context);
                    String str = ayv.eUt;
                    j.o(str, "it.cityName");
                    String str2 = ayv.eUu;
                    j.o(str2, "it.poiName");
                    arrayList.add(new com.tencent.mm.media.editor.a.d(eVar.gD(str, str2), matrix));
                }
            }
        }
        AppMethodBeat.o(109671);
        return arrayList;
    }

    public static void a(cee cee, Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(109672);
        j.p(cee, "storyEditorProtoData");
        j.p(context, "context");
        j.p(viewGroup, "itemLayout");
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow the fake story which has editor item");
        com.tencent.mm.plugin.story.c.a.c.a aVar = (com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw();
        String str = cee.videoPath;
        j.o(str, "storyEditorProtoData.videoPath");
        aVar.aaa(str);
        LinkedList<hk> linkedList = cee.xdW;
        j.o(linkedList, "storyEditorProtoData.baseItemData");
        for (hk hkVar : linkedList) {
            int i = hkVar.dataType;
            com.tencent.mm.bt.a cgu;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            com.tencent.mm.bt.b buffer;
            Matrix matrix;
            float[] fArr;
            int i2;
            LinkedList<Float> linkedList2;
            int i3;
            if (i == com.tencent.mm.media.editor.a.e.TEXT.value) {
                cgu = new cgu();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                } catch (Exception e) {
                    ab.b("safeParser", "", e);
                    cgu = null;
                }
                cgu cgu2 = (cgu) cgu;
                if (cgu2 != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + cgu2.text);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = cgu2.wCL.xls;
                    j.o(linkedList2, "it.matrix.value");
                    for (Float f : linkedList2) {
                        i3 = i2 + 1;
                        j.o(f, "data");
                        fArr[i2] = f.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    al.d(new a(cgu2, matrix, context, viewGroup, cee));
                }
            } else if (i == com.tencent.mm.media.editor.a.e.EMOJI.value) {
                cgu = new xy();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                } catch (Exception e2) {
                    ab.b("safeParser", "", e2);
                    cgu = null;
                }
                xy xyVar = (xy) cgu;
                if (xyVar != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + xyVar.cvZ);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    if (xyVar.wdH != null) {
                        linkedList2 = xyVar.wdH.xls;
                        j.o(linkedList2, "it.showMatrix.value");
                        for (Float f2 : linkedList2) {
                            i3 = i2 + 1;
                            j.o(f2, "data");
                            fArr[i2] = f2.floatValue();
                            i2 = i3;
                        }
                        matrix.setValues(fArr);
                        al.d(new b(xyVar, matrix, new Rect(cee.xdS, cee.xdU, cee.xdT, cee.xdV), context, viewGroup, cee));
                    }
                }
            } else if (i == com.tencent.mm.media.editor.a.e.LOCATION.value) {
                cgu = new ayv();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                } catch (Exception e22) {
                    ab.b("safeParser", "", e22);
                    cgu = null;
                }
                ayv ayv = (ayv) cgu;
                if (ayv != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow location data is  " + ayv.eUt + " - " + ayv.eUu + " and matrix is " + ayv.wCL.xls);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = ayv.wCL.xls;
                    j.o(linkedList2, "it.matrix.value");
                    for (Float f22 : linkedList2) {
                        i3 = i2 + 1;
                        j.o(f22, "data");
                        fArr[i2] = f22.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    al.d(new c(ayv, matrix, context, viewGroup, cee));
                }
            }
        }
        AppMethodBeat.o(109672);
    }

    public static com.tencent.mm.plugin.story.model.e.a b(cee cee, Context context) {
        int i;
        int i2;
        Object obj;
        AppMethodBeat.i(109673);
        j.p(cee, "storyEditorProtoData");
        j.p(context, "context");
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow the fake story as frame retriever");
        com.tencent.mm.plugin.story.c.a.c.a aVar = (com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw();
        String str = cee.videoPath;
        j.o(str, "storyEditorProtoData.videoPath");
        aVar.aaa(str);
        List arrayList = new ArrayList();
        LinkedList<hk> linkedList = cee.xdW;
        j.o(linkedList, "storyEditorProtoData.baseItemData");
        for (hk hkVar : linkedList) {
            i = hkVar.dataType;
            com.tencent.mm.bt.a cgu;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            com.tencent.mm.bt.b buffer;
            com.tencent.mm.bt.a aVar2;
            Matrix matrix;
            float[] fArr;
            LinkedList<Float> linkedList2;
            int i3;
            com.tencent.mm.media.editor.a.b UI;
            if (i == com.tencent.mm.media.editor.a.e.TEXT.value) {
                cgu = new cgu();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    aVar2 = cgu;
                } catch (Exception e) {
                    ab.b("safeParser", "", e);
                    aVar2 = null;
                }
                cgu cgu2 = (cgu) aVar2;
                if (cgu2 != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + cgu2.text);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = cgu2.wCL.xls;
                    j.o(linkedList2, "it.matrix.value");
                    for (Float f : linkedList2) {
                        i3 = i2 + 1;
                        j.o(f, "data");
                        fArr[i2] = f.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    CharSequence charSequence = cgu2.text;
                    i2 = cgu2.textColor;
                    i3 = cgu2.eUv;
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the text editor item");
                    obj = (charSequence == null || u.ar(charSequence)) ? 1 : null;
                    if (obj != null) {
                        obj = null;
                    } else {
                        f fVar = new f(context);
                        fVar.a(charSequence, i2, i3, matrix);
                        obj = fVar.UI();
                    }
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            } else if (i == com.tencent.mm.media.editor.a.e.EMOJI.value) {
                cgu = new xy();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    aVar2 = cgu;
                } catch (Exception e2) {
                    ab.b("safeParser", "", e2);
                    aVar2 = null;
                }
                xy xyVar = (xy) aVar2;
                if (xyVar != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + xyVar.cvZ);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    if (xyVar.wdH != null) {
                        linkedList2 = xyVar.wdH.xls;
                        j.o(linkedList2, "it.showMatrix.value");
                        for (Float f2 : linkedList2) {
                            i3 = i2 + 1;
                            j.o(f2, "data");
                            fArr[i2] = f2.floatValue();
                            i2 = i3;
                        }
                        matrix.setValues(fArr);
                        Rect rect = new Rect(cee.xdS, cee.xdU, cee.xdT, cee.xdV);
                        com.tencent.mm.kernel.b.a M = g.M(d.class);
                        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                        EmojiInfo Je = ((d) M).getProvider().Je(xyVar.cvZ);
                        j.o(Je, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
                        ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the emoji editor item");
                        com.tencent.mm.plugin.story.ui.view.editor.item.b bVar = new com.tencent.mm.plugin.story.ui.view.editor.item.b(context, true);
                        bVar.setViewMatrix(matrix);
                        bVar.setEmojiInfo(Je);
                        UI = bVar.UI();
                        if (UI != null) {
                            arrayList.add(UI);
                        }
                    }
                }
            } else if (i == com.tencent.mm.media.editor.a.e.LOCATION.value) {
                cgu = new ayv();
                sKBuiltinBuffer_t = hkVar.vKa;
                j.o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                j.o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    aVar2 = cgu;
                } catch (Exception e22) {
                    ab.b("safeParser", "", e22);
                    aVar2 = null;
                }
                ayv ayv = (ayv) aVar2;
                if (ayv != null) {
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "reshow location data is  " + ayv.eUt + " - " + ayv.eUu + " and matrix is " + ayv.wCL.xls);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = ayv.wCL.xls;
                    j.o(linkedList2, "it.matrix.value");
                    for (Float f22 : linkedList2) {
                        i3 = i2 + 1;
                        j.o(f22, "data");
                        fArr[i2] = f22.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    String str2 = ayv.eUt;
                    j.o(str2, "it.cityName");
                    str = ayv.eUu;
                    j.o(str, "it.poiName");
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the position editor item");
                    com.tencent.mm.plugin.story.ui.view.editor.item.e eVar = new com.tencent.mm.plugin.story.ui.view.editor.item.e(context);
                    eVar.a(str2, str, matrix);
                    UI = eVar.UI();
                    if (UI != null) {
                        arrayList.add(UI);
                    }
                }
            }
        }
        int i4 = aVar.eXL;
        obj = (i4 == 270 || i4 == 90) ? 1 : null;
        if (obj != null) {
            i = aVar.eTj;
        } else {
            i = aVar.eTi;
        }
        if (obj != null) {
            i2 = aVar.eTi;
        } else {
            i2 = aVar.eTj;
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(109673);
            return null;
        } else if (i == 0 || i2 == 0) {
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "error width " + i + " height " + i2);
            AppMethodBeat.o(109673);
            return null;
        } else {
            com.tencent.mm.plugin.story.e.c.a aVar3 = com.tencent.mm.plugin.story.e.c.rRS;
            String str3 = cee.videoPath;
            j.o(str3, "storyEditorProtoData.videoPath");
            com.tencent.mm.plugin.story.e.c.a.a aaj = com.tencent.mm.plugin.story.e.c.a.aaj(str3);
            com.tencent.mm.plugin.story.model.e.a aVar4;
            if (cee.fbV || aaj == null || aaj.rRT) {
                aVar4 = new com.tencent.mm.plugin.story.model.e.a(a(cee), arrayList, i, i2, 0, 0, 0);
                AppMethodBeat.o(109673);
                return aVar4;
            }
            aVar4 = new com.tencent.mm.plugin.story.model.e.a(a(cee), arrayList, i, i2, aaj.width, aaj.height, 0);
            AppMethodBeat.o(109673);
            return aVar4;
        }
    }

    public static float[] a(cee cee) {
        AppMethodBeat.i(109674);
        j.p(cee, "storyEditorProtoData");
        float[] fArr = new float[]{(float) cee.xdS, (float) cee.xdU, (float) cee.xdT, (float) cee.xdV};
        AppMethodBeat.o(109674);
        return fArr;
    }

    public static void a(long j, String str, String str2, boolean z) {
        AppMethodBeat.i(109675);
        j.p(str, "mixVideoPath");
        j.p(str2, "mixThumbPath");
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls(j);
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix " + j + " storyLocalId " + (ls != null ? Integer.valueOf(ls.field_storyLocalId) : null) + ", needExport:" + z);
        if (ls != null) {
            int i = ls.field_mixFlag;
            com.tencent.mm.plugin.story.h.a.d dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
            if (com.tencent.mm.ab.b.cf(i, com.tencent.mm.plugin.story.h.a.d.cBx())) {
                ab.i("MicroMsg.Media.StoryDataProtoUtil", "sign the data " + j + " is mix end");
                i = ls.field_mixFlag;
                dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
                ls.field_mixFlag = i & (com.tencent.mm.plugin.story.h.a.d.cBx() ^ -1);
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxY().b(j, ls);
                if (z) {
                    com.tencent.mm.plugin.story.e.c.a aVar2 = com.tencent.mm.plugin.story.e.c.rRS;
                    com.tencent.mm.plugin.story.e.c.a.aai(str);
                }
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(ls.field_storyLocalId);
                if (Fe != null) {
                    i = Fe.field_localFlag;
                    com.tencent.mm.plugin.story.h.a.c cVar = com.tencent.mm.plugin.story.h.a.c.sds;
                    Fe.field_localFlag = i & (com.tencent.mm.plugin.story.h.a.c.cBw() ^ -1);
                    Fe.cBS();
                    com.tencent.mm.plugin.story.model.q.a aVar3 = q.rTk;
                    cek cek = new cek();
                    StringBuilder stringBuilder = new StringBuilder();
                    com.tencent.mm.plugin.story.e.c.a aVar4 = com.tencent.mm.plugin.story.e.c.rRS;
                    stringBuilder = stringBuilder.append(com.tencent.mm.plugin.story.e.c.rRP);
                    String str3 = cb.aaE() + '-' + bo.yz();
                    Charset charset = a.k.d.UTF_8;
                    if (str3 == null) {
                        v vVar = new v("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(109675);
                        throw vVar;
                    }
                    float f;
                    cek cek2;
                    byte[] bytes = str3.getBytes(charset);
                    j.o(bytes, "(this as java.lang.String).getBytes(charset)");
                    cek.Id = stringBuilder.append(com.tencent.mm.a.g.x(bytes)).toString();
                    com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    String aat = com.tencent.mm.plugin.story.model.l.aat(cek.Id);
                    lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    String aas = com.tencent.mm.plugin.story.model.l.aas(cek.Id);
                    lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    com.tencent.mm.plugin.story.model.l.aax(aat);
                    lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    com.tencent.mm.plugin.story.model.l.aax(aas);
                    lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    com.tencent.mm.plugin.story.model.l.aay(aat);
                    lVar = com.tencent.mm.plugin.story.model.l.rTg;
                    com.tencent.mm.plugin.story.model.l.aay(aas);
                    long y = e.y(str, aat);
                    long y2 = e.y(str2, aas);
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + str + " to " + aat + ", ret:" + y);
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + str2 + " to " + aas + ", ret:" + y2);
                    com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(aat);
                    if (WR != null) {
                        f = ((float) WR.eWK) / 1000.0f;
                        cek2 = cek;
                    } else {
                        f = 0.0f;
                        cek2 = cek;
                    }
                    cek2.duration = f;
                    cfb cBR = Fe.cBR();
                    if (cBR.xeA.wbK.size() == 0) {
                        cBR.xeA.wbK.add(cek);
                    } else {
                        cBR.xeA.wbK.set(0, cek);
                    }
                    Fe.b(cBR);
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    ab.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + ls.field_storyLocalId + " newVideoPath:" + aat + "  newThumbPath:" + aas + " ret:" + com.tencent.mm.plugin.story.model.j.a.cxT().a(ls.field_storyLocalId, Fe));
                }
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
            }
        }
        AppMethodBeat.o(109675);
    }

    public static void lf(long j) {
        AppMethodBeat.i(109676);
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(j)));
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls(j);
        if (ls != null && ls.cBG()) {
            int i = ls.field_mixFlag;
            com.tencent.mm.plugin.story.h.a.d dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
            ls.field_mixFlag = i & (com.tencent.mm.plugin.story.h.a.d.cBx() ^ -1);
            i = ls.field_mixFlag;
            dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
            ls.field_mixFlag = i | com.tencent.mm.plugin.story.h.a.d.cBy();
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxY().b(j, ls);
            aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(ls.field_storyLocalId);
            if (Fe != null) {
                Fe.cqY();
                com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().a(ls.field_storyLocalId, Fe);
            }
        }
        AppMethodBeat.o(109676);
    }

    public static void a(long j, com.tencent.mm.plugin.story.h.d dVar) {
        AppMethodBeat.i(109677);
        j.p(dVar, "storyEditorData");
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixEnable ".concat(String.valueOf(j)));
        if (dVar.cBG()) {
            int i = dVar.field_mixFlag;
            com.tencent.mm.plugin.story.h.a.d dVar2 = com.tencent.mm.plugin.story.h.a.d.sdv;
            dVar.field_mixFlag = i | com.tencent.mm.plugin.story.h.a.d.cBx();
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxY().b(j, dVar);
        }
        AppMethodBeat.o(109677);
    }

    public static void lg(long j) {
        AppMethodBeat.i(109678);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.d ls = com.tencent.mm.plugin.story.model.j.a.cxY().ls(j);
        if (ls != null && ls.cBG()) {
            ls.field_mixRetryTime++;
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxY().b(j, ls);
        }
        AppMethodBeat.o(109678);
    }

    public static void czJ() {
        AppMethodBeat.i(109679);
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "run clean dirty data which is the ismixed equals true");
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxY();
        aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.e cxY = com.tencent.mm.plugin.story.model.j.a.cxY();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("mixFlag&");
        com.tencent.mm.plugin.story.h.a.d dVar = com.tencent.mm.plugin.story.h.a.d.sdv;
        Cursor query = cxY.bSd.query("StoryEditorInfo", null, stringBuilder.append(com.tencent.mm.plugin.story.h.a.d.cBx()).append("=0").toString(), null, null, null, null);
        if (query != null && query.moveToFirst()) {
            do {
                com.tencent.mm.plugin.story.h.d dVar2 = new com.tencent.mm.plugin.story.h.d();
                dVar2.d(query);
                arrayList.add(Long.valueOf(dVar2.field_timeStamp));
            } while (query.moveToNext());
            query.close();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "delete the source data which is mix up");
            j.o(l, "i");
            b(lh(l.longValue()));
        }
        AppMethodBeat.o(109679);
    }

    public static cee lh(long j) {
        com.tencent.mm.plugin.story.h.d dVar;
        cee cee = null;
        AppMethodBeat.i(109680);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        Cursor query = com.tencent.mm.plugin.story.model.j.a.cxY().bSd.query("StoryEditorInfo", null, "timeStamp=".concat(String.valueOf(j)), null, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                dVar = new com.tencent.mm.plugin.story.h.d();
                dVar.d(query);
            } else {
                dVar = null;
            }
            query.close();
        } else {
            dVar = null;
        }
        if (dVar == null || !dVar.cBG()) {
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "has no editor data ".concat(String.valueOf(j)));
            AppMethodBeat.o(109680);
        } else {
            ab.i("MicroMsg.Media.StoryDataProtoUtil", "is running mix and use the editor data to show " + dVar.field_mixFlag);
            cee = new cee();
            try {
                byte[] bArr = dVar.field_baseItemData;
                j.o(bArr, "field_baseItemData");
                cee.parseFrom(bArr);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Media.StoryDataProtoUtil", e, "", new Object[0]);
            }
            AppMethodBeat.o(109680);
        }
        return cee;
    }

    public static void li(long j) {
        AppMethodBeat.i(109681);
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "run clean null data");
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxY().bSd.delete("StoryEditorInfo", "timeStamp=".concat(String.valueOf(j)), null);
        AppMethodBeat.o(109681);
    }

    public static void b(cee cee) {
        String str;
        String str2 = null;
        AppMethodBeat.i(109682);
        ab.c("MicroMsg.Media.StoryDataProtoUtil", "cleanUnAvailableData, videoPath " + cee + "?.videoPath", new Object[0]);
        if (cee != null && cee.fbV) {
            e.deleteFile(cee.videoPath);
        }
        if (cee != null) {
            str = cee.xdR;
        } else {
            str = null;
        }
        e.deleteFile(str);
        if (cee != null) {
            str = cee.eYi;
        } else {
            str = null;
        }
        e.deleteFile(str);
        if (cee != null) {
            str2 = cee.thumbPath;
        }
        e.deleteFile(str2);
        AppMethodBeat.o(109682);
    }

    public static boolean gA(String str, String str2) {
        AppMethodBeat.i(109683);
        j.p(str, "file");
        String cz = com.tencent.mm.a.g.cz(str);
        if (cz == null || str2 == null || !u.I(str2, cz, true)) {
            AppMethodBeat.o(109683);
            return false;
        }
        AppMethodBeat.o(109683);
        return true;
    }

    public static final /* synthetic */ void a(String str, String str2, Matrix matrix, Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(109687);
        ab.i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the position item view");
        com.tencent.mm.plugin.story.ui.view.editor.item.e eVar = new com.tencent.mm.plugin.story.ui.view.editor.item.e(context);
        viewGroup.addView(eVar, new LayoutParams(-1, -1));
        eVar.a(str, str2, matrix);
        AppMethodBeat.o(109687);
    }
}
