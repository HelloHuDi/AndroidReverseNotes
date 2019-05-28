package com.tencent.p177mm.plugin.story.p530f;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.media.editor.p252a.C1772j;
import com.tencent.p177mm.media.editor.p252a.C26382a;
import com.tencent.p177mm.media.editor.p252a.C26384d;
import com.tencent.p177mm.media.editor.p252a.C37889e;
import com.tencent.p177mm.media.editor.p252a.C37890g;
import com.tencent.p177mm.media.editor.p252a.C45427f;
import com.tencent.p177mm.media.editor.p252a.C45428h;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.media.p254g.C1784i;
import com.tencent.p177mm.media.p254g.C1784i.C1785a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.p1036e.C13775a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c.C29276a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39869f.C29278a;
import com.tencent.p177mm.plugin.story.p1034d.C43629b.C13742b;
import com.tencent.p177mm.plugin.story.p1303e.C29282c;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a;
import com.tencent.p177mm.plugin.story.p1303e.C29282c.C29283a.C29281a;
import com.tencent.p177mm.plugin.story.p1303e.C39872a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35186d;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35187c;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C7610e;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C39930f;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C46289e;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C46925b;
import com.tencent.p177mm.protocal.protobuf.C40526hk;
import com.tencent.p177mm.protocal.protobuf.C46599xy;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ayv;
import com.tencent.p177mm.protocal.protobuf.ced;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.protocal.protobuf.cej;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.protocal.protobuf.cgu;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004`!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u0011J:\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u0002032\u0006\u0010+\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\u001aJ\u000e\u00104\u001a\u0002052\u0006\u0010\u0010\u001a\u00020\u0011J*\u00106\u001a\u0004\u0018\u00010 2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0002J0\u0010<\u001a\u00020\u00132\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>H\u0002J*\u0010?\u001a\u0004\u0018\u00010 2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#H\u0002J0\u0010B\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>H\u0002J\u001e\u0010C\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>J\u0018\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J4\u0010F\u001a\u0004\u0018\u00010 2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#H\u0002J:\u0010K\u001a\u00020\u00132\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020>H\u0002J:\u0010L\u001a\u00020M2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u000201H\u0002J&\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\fJ\u0016\u0010S\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00162\u0006\u0010T\u001a\u00020*J\u000e\u0010U\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0016J\u000e\u0010V\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006W"}, dWq = {"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "checkMD5", "", "file", "destMD5", "checkStoryEditorFileMD5", "storyEditorProtoData", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "cleanUnAvailableData", "data", "getAudioCacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "getFakeVideoData", "getStoryCaptureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getStoryDataEditorItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "getStoryDataEditorItemReport", "dataType", "", "getStoryFileMD5", "Lcom/tencent/mm/protocal/protobuf/StoryEditorFileMD5;", "insertCompositeVideo", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "view", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "muteOrigin", "mixAudio", "captureInfo", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "insertEditorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onUnSerializeStoryDataDrawingRect", "", "reshowEmojiEditorItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "viewMatrix", "Landroid/graphics/Matrix;", "validArea", "reshowEmojiItem", "itemLayout", "Landroid/view/ViewGroup;", "reshowPositionEditorItem", "cityName", "poiName", "reshowPositionItem", "reshowStoryDataEditorItem", "reshowStoryDataEditorItemFrame", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "reshowTextEditorItem", "text", "", "textColor", "textBgColor", "reshowTextItem", "serializeStoryDataToByteArray", "", "signStoryDataMix", "localId", "mixVideoPath", "mixThumbPath", "needExport", "signStoryDataMixEnable", "storyEditorData", "signStoryDataMixError", "signStoryDataMixTime", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.f.l */
public final class C22210l {
    private static Rect eUN = new Rect(0, 0, C5230ak.m7993hy(C4996ah.getContext()).x, C5230ak.m7993hy(C4996ah.getContext()).y);
    public static final C22210l sac = new C22210l();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$1$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$1"})
    /* renamed from: com.tencent.mm.plugin.story.f.l$a */
    static final class C4114a implements Runnable {
        final /* synthetic */ Context fbw;
        final /* synthetic */ cgu sad;
        final /* synthetic */ Matrix sae;
        final /* synthetic */ ViewGroup saf;
        final /* synthetic */ cee sag;

        C4114a(cgu cgu, Matrix matrix, Context context, ViewGroup viewGroup, cee cee) {
            this.sad = cgu;
            this.sae = matrix;
            this.fbw = context;
            this.saf = viewGroup;
            this.sag = cee;
        }

        public final void run() {
            AppMethodBeat.m2504i(109666);
            C22210l c22210l = C22210l.sac;
            C22210l.m33876a((CharSequence) this.sad.text, this.sad.textColor, this.sad.eUv, this.sae, this.fbw, this.saf);
            AppMethodBeat.m2505o(109666);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$3$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$3"})
    /* renamed from: com.tencent.mm.plugin.story.f.l$c */
    static final class C4115c implements Runnable {
        final /* synthetic */ Context fbw;
        final /* synthetic */ Matrix sae;
        final /* synthetic */ ViewGroup saf;
        final /* synthetic */ cee sag;
        final /* synthetic */ ayv saj;

        C4115c(ayv ayv, Matrix matrix, Context context, ViewGroup viewGroup, cee cee) {
            this.saj = ayv;
            this.sae = matrix;
            this.fbw = context;
            this.saf = viewGroup;
            this.sag = cee;
        }

        public final void run() {
            AppMethodBeat.m2504i(109668);
            C22210l c22210l = C22210l.sac;
            String str = this.saj.eUt;
            C25052j.m39375o(str, "it.cityName");
            String str2 = this.saj.eUu;
            C25052j.m39375o(str2, "it.poiName");
            C22210l.m33877a(str, str2, this.sae, this.fbw, this.saf);
            AppMethodBeat.m2505o(109668);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$2$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$2"})
    /* renamed from: com.tencent.mm.plugin.story.f.l$b */
    static final class C13763b implements Runnable {
        final /* synthetic */ Context fbw;
        final /* synthetic */ Matrix sae;
        final /* synthetic */ ViewGroup saf;
        final /* synthetic */ cee sag;
        final /* synthetic */ C46599xy sah;
        final /* synthetic */ Rect sai;

        C13763b(C46599xy c46599xy, Matrix matrix, Rect rect, Context context, ViewGroup viewGroup, cee cee) {
            this.sah = c46599xy;
            this.sae = matrix;
            this.sai = rect;
            this.fbw = context;
            this.saf = viewGroup;
            this.sag = cee;
        }

        public final void run() {
            AppMethodBeat.m2504i(109667);
            C22210l c22210l = C22210l.sac;
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            EmojiInfo Je = ((C6835d) M).getProvider().mo35597Je(this.sah.cvZ);
            C25052j.m39375o(Je, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
            C22210l.m33875a(Je, this.sae, this.fbw, this.saf);
            AppMethodBeat.m2505o(109667);
        }
    }

    static {
        AppMethodBeat.m2504i(109684);
        AppMethodBeat.m2505o(109684);
    }

    private C22210l() {
    }

    public static Rect czI() {
        return eUN;
    }

    /* renamed from: a */
    public static C39878d m33869a(C13742b c13742b, boolean z, AudioCacheInfo audioCacheInfo, C39872a c39872a, long j, cei cei) {
        AppMethodBeat.m2504i(109669);
        C25052j.m39376p(c13742b, "view");
        C25052j.m39376p(c39872a, "captureInfo");
        C25052j.m39376p(cei, C8741b.LOCATION);
        try {
            Object obj;
            int i;
            long j2;
            C8901a c8901a = new C8901a("insertCompositeVideo");
            C39878d c39878d = new C39878d();
            c39878d.field_mixFlag = 0;
            c39878d.field_mixRetryTime = 0;
            c39878d.field_timeStamp = j;
            C4133a c4133a = C43644j.rST;
            if (C4133a.cye() == C29278a.BACKGROUND) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i = 1;
            } else {
                i = 0;
            }
            c39878d.field_available = i;
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "is running serialize the story to bytearray");
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
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "input the timeStamp is ".concat(String.valueOf(j)));
            if (i == 3) {
                C1785a c1785a = C1784i.eYK;
                if (C5730e.m8628ct(C1785a.m3671lY(c39872a.fbT))) {
                    c1785a = C1784i.eYK;
                    cee.xdR = C1785a.m3671lY(c39872a.fbT);
                }
            }
            cee.timeStamp = j;
            if (c39872a.rRG == -1) {
                j2 = 0;
            } else {
                j2 = c39872a.rRG;
            }
            cee.startTime = j2;
            cee.endTime = c39872a.rRH;
            cee.thumbPath = c39872a.fbU;
            cee.videoPath = c39872a.fbT;
            cee.fbV = c39872a.fbV;
            cee.smk = cei;
            C43528a WR = C21846d.m33388WR(c39872a.fbT);
            if (WR != null && (c39872a.rRH == -1 || c39872a.rRH == 0)) {
                cee.endTime = (long) WR.eWK;
            }
            cee.eTb = i;
            cee.xdS = c13742b.getItemContainer().getLeft();
            cee.xdU = c13742b.getItemContainer().getTop();
            cee.xdT = c13742b.getItemContainer().getRight();
            cee.xdV = c13742b.getItemContainer().getBottom();
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
            C25052j.m39376p(cee, "storyEditorProtoData");
            ced ced = new ced();
            ced.xdP = C1178g.m2587cz(cee.xdR);
            ced.xdO = C1178g.m2587cz(cee.eYi);
            ced.xdN = C1178g.m2587cz(cee.videoPath);
            ced.xdQ = C1178g.m2587cz(cee.thumbPath);
            cee.xdY = ced;
            for (C45428h UJ : c13742b.getItemContainer().getAllItemViews()) {
                C26382a UJ2 = UJ.mo26049UJ();
                if (UJ2 != null) {
                    C40526hk c40526hk = new C40526hk();
                    c40526hk.dataType = UJ2.eUi.value;
                    c40526hk.vKa = C1946aa.m4152ad(UJ2.mo5316UG().toByteArray());
                    cee.xdW.add(c40526hk);
                }
            }
            byte[] toByteArray = cee.toByteArray();
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "storyEditorItem " + cee.videoPath + " thumb " + cee.thumbPath + " and result " + C5730e.m8628ct(cee.thumbPath) + " music " + cee.eYi + " ret " + C5046bo.m7565ga(((long) toByteArray.length) * 1) + '}');
            C25052j.m39375o(toByteArray, "ret");
            C25052j.m39376p(toByteArray, "value");
            c39878d.field_baseItemData = toByteArray;
            c4133a = C43644j.rST;
            C4133a.cxY().mo10101b((C4925c) c39878d);
            AppMethodBeat.m2505o(109669);
            return c39878d;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Media.StoryDataProtoUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(109669);
            return null;
        }
    }

    /* renamed from: a */
    public static cej m33870a(C13742b c13742b, AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.m2504i(109670);
        C25052j.m39376p(c13742b, "view");
        cej cej = new cej();
        for (C45428h UJ : c13742b.getItemContainer().getAllItemViews()) {
            C26382a UJ2 = UJ.mo26049UJ();
            if (UJ2 != null) {
                int i = UJ2.eUi.value;
                C44941v c44941v;
                if (i == C37889e.TEXT.value) {
                    if (UJ2 == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.TextItem");
                        AppMethodBeat.m2505o(109670);
                        throw c44941v;
                    }
                    cej.xeh.add(String.valueOf(((C1772j) UJ2).text));
                } else if (i != C37889e.EMOJI.value) {
                    continue;
                } else if (UJ2 == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.media.editor.item.EmojiItem");
                    AppMethodBeat.m2505o(109670);
                    throw c44941v;
                } else {
                    LinkedList linkedList = cej.xeg;
                    EmojiInfo emojiInfo = ((C37890g) UJ2).exP;
                    linkedList.add(emojiInfo != null ? emojiInfo.mo20410Aq() : null);
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
        AppMethodBeat.m2505o(109670);
        return cej;
    }

    /* renamed from: a */
    public static ArrayList<C9584b> m33871a(cee cee, Context context) {
        AppMethodBeat.m2504i(109671);
        C25052j.m39376p(cee, "storyEditorProtoData");
        C25052j.m39376p(context, "context");
        ArrayList arrayList = new ArrayList();
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "get the editor data which is waiting for run mixing");
        LinkedList<C40526hk> linkedList = cee.xdW;
        C25052j.m39375o(linkedList, "storyEditorProtoData.baseItemData");
        for (C40526hk c40526hk : linkedList) {
            int i = c40526hk.dataType;
            C1331a cgu;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C1332b buffer;
            C1331a c1331a;
            Matrix matrix;
            float[] fArr;
            int i2;
            LinkedList<Float> linkedList2;
            int i3;
            if (i == C37889e.TEXT.value) {
                cgu = new cgu();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    c1331a = cgu;
                } catch (Exception e) {
                    C4990ab.m7408b("safeParser", "", e);
                    c1331a = null;
                }
                cgu cgu2 = (cgu) c1331a;
                if (cgu2 != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + cgu2.text);
                    Bitmap f = new C39930f(context).mo63128f(cgu2.text, cgu2.textColor, cgu2.eUv);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i = 0;
                    LinkedList<Float> linkedList3 = cgu2.wCL.xls;
                    C25052j.m39375o(linkedList3, "it.matrix.value");
                    for (Float f2 : linkedList3) {
                        i2 = i + 1;
                        C25052j.m39375o(f2, "data");
                        fArr[i] = f2.floatValue();
                        i = i2;
                    }
                    matrix.setValues(fArr);
                    arrayList.add(new C26384d(f, matrix));
                }
            } else if (i == C37889e.EMOJI.value) {
                cgu = new C46599xy();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    c1331a = cgu;
                } catch (Exception e2) {
                    C4990ab.m7408b("safeParser", "", e2);
                    c1331a = null;
                }
                C46599xy c46599xy = (C46599xy) c1331a;
                if (c46599xy != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + c46599xy.cvZ);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = c46599xy.wdG.xls;
                    C25052j.m39375o(linkedList2, "it.editorMatrix.value");
                    for (Float f3 : linkedList2) {
                        i3 = i2 + 1;
                        C25052j.m39375o(f3, "data");
                        fArr[i2] = f3.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    C1677a M = C1720g.m3530M(C6835d.class);
                    C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    EmojiInfo Je = ((C6835d) M).getProvider().mo35597Je(c46599xy.cvZ);
                    C25052j.m39375o(Je, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
                    arrayList.add(new C45427f(Je, matrix));
                }
            } else if (i == C37889e.LOCATION.value) {
                cgu = new ayv();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    c1331a = cgu;
                } catch (Exception e22) {
                    C4990ab.m7408b("safeParser", "", e22);
                    c1331a = null;
                }
                ayv ayv = (ayv) c1331a;
                if (ayv != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "location data is  " + ayv.eUt + " - " + ayv.eUu + " and matrix is " + ayv.wCL.xls);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = ayv.wCL.xls;
                    C25052j.m39375o(linkedList2, "it.matrix.value");
                    for (Float f32 : linkedList2) {
                        i3 = i2 + 1;
                        C25052j.m39375o(f32, "data");
                        fArr[i2] = f32.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    C46289e c46289e = new C46289e(context);
                    String str = ayv.eUt;
                    C25052j.m39375o(str, "it.cityName");
                    String str2 = ayv.eUu;
                    C25052j.m39375o(str2, "it.poiName");
                    arrayList.add(new C26384d(c46289e.mo74444gD(str, str2), matrix));
                }
            }
        }
        AppMethodBeat.m2505o(109671);
        return arrayList;
    }

    /* renamed from: a */
    public static void m33874a(cee cee, Context context, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(109672);
        C25052j.m39376p(cee, "storyEditorProtoData");
        C25052j.m39376p(context, "context");
        C25052j.m39376p(viewGroup, "itemLayout");
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "reshow the fake story which has editor item");
        C29276a c29276a = (C29276a) C29275c.rRk.mo53288Uw();
        String str = cee.videoPath;
        C25052j.m39375o(str, "storyEditorProtoData.videoPath");
        c29276a.aaa(str);
        LinkedList<C40526hk> linkedList = cee.xdW;
        C25052j.m39375o(linkedList, "storyEditorProtoData.baseItemData");
        for (C40526hk c40526hk : linkedList) {
            int i = c40526hk.dataType;
            C1331a cgu;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C1332b buffer;
            Matrix matrix;
            float[] fArr;
            int i2;
            LinkedList<Float> linkedList2;
            int i3;
            if (i == C37889e.TEXT.value) {
                cgu = new cgu();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                } catch (Exception e) {
                    C4990ab.m7408b("safeParser", "", e);
                    cgu = null;
                }
                cgu cgu2 = (cgu) cgu;
                if (cgu2 != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + cgu2.text);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = cgu2.wCL.xls;
                    C25052j.m39375o(linkedList2, "it.matrix.value");
                    for (Float f : linkedList2) {
                        i3 = i2 + 1;
                        C25052j.m39375o(f, "data");
                        fArr[i2] = f.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    C5004al.m7441d(new C4114a(cgu2, matrix, context, viewGroup, cee));
                }
            } else if (i == C37889e.EMOJI.value) {
                cgu = new C46599xy();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                } catch (Exception e2) {
                    C4990ab.m7408b("safeParser", "", e2);
                    cgu = null;
                }
                C46599xy c46599xy = (C46599xy) cgu;
                if (c46599xy != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + c46599xy.cvZ);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    if (c46599xy.wdH != null) {
                        linkedList2 = c46599xy.wdH.xls;
                        C25052j.m39375o(linkedList2, "it.showMatrix.value");
                        for (Float f2 : linkedList2) {
                            i3 = i2 + 1;
                            C25052j.m39375o(f2, "data");
                            fArr[i2] = f2.floatValue();
                            i2 = i3;
                        }
                        matrix.setValues(fArr);
                        C5004al.m7441d(new C13763b(c46599xy, matrix, new Rect(cee.xdS, cee.xdU, cee.xdT, cee.xdV), context, viewGroup, cee));
                    }
                }
            } else if (i == C37889e.LOCATION.value) {
                cgu = new ayv();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                } catch (Exception e22) {
                    C4990ab.m7408b("safeParser", "", e22);
                    cgu = null;
                }
                ayv ayv = (ayv) cgu;
                if (ayv != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "reshow location data is  " + ayv.eUt + " - " + ayv.eUu + " and matrix is " + ayv.wCL.xls);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = ayv.wCL.xls;
                    C25052j.m39375o(linkedList2, "it.matrix.value");
                    for (Float f22 : linkedList2) {
                        i3 = i2 + 1;
                        C25052j.m39375o(f22, "data");
                        fArr[i2] = f22.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    C5004al.m7441d(new C4115c(ayv, matrix, context, viewGroup, cee));
                }
            }
        }
        AppMethodBeat.m2505o(109672);
    }

    /* renamed from: b */
    public static C13775a m33879b(cee cee, Context context) {
        int i;
        int i2;
        Object obj;
        AppMethodBeat.m2504i(109673);
        C25052j.m39376p(cee, "storyEditorProtoData");
        C25052j.m39376p(context, "context");
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "reshow the fake story as frame retriever");
        C29276a c29276a = (C29276a) C29275c.rRk.mo53288Uw();
        String str = cee.videoPath;
        C25052j.m39375o(str, "storyEditorProtoData.videoPath");
        c29276a.aaa(str);
        List arrayList = new ArrayList();
        LinkedList<C40526hk> linkedList = cee.xdW;
        C25052j.m39375o(linkedList, "storyEditorProtoData.baseItemData");
        for (C40526hk c40526hk : linkedList) {
            i = c40526hk.dataType;
            C1331a cgu;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C1332b buffer;
            C1331a c1331a;
            Matrix matrix;
            float[] fArr;
            LinkedList<Float> linkedList2;
            int i3;
            C9584b UI;
            if (i == C37889e.TEXT.value) {
                cgu = new cgu();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    c1331a = cgu;
                } catch (Exception e) {
                    C4990ab.m7408b("safeParser", "", e);
                    c1331a = null;
                }
                cgu cgu2 = (cgu) c1331a;
                if (cgu2 != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "text string is " + cgu2.text);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = cgu2.wCL.xls;
                    C25052j.m39375o(linkedList2, "it.matrix.value");
                    for (Float f : linkedList2) {
                        i3 = i2 + 1;
                        C25052j.m39375o(f, "data");
                        fArr[i2] = f.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    CharSequence charSequence = cgu2.text;
                    i2 = cgu2.textColor;
                    i3 = cgu2.eUv;
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the text editor item");
                    obj = (charSequence == null || C6163u.m9837ar(charSequence)) ? 1 : null;
                    if (obj != null) {
                        obj = null;
                    } else {
                        C39930f c39930f = new C39930f(context);
                        c39930f.mo63127a(charSequence, i2, i3, matrix);
                        obj = c39930f.mo26048UI();
                    }
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            } else if (i == C37889e.EMOJI.value) {
                cgu = new C46599xy();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    c1331a = cgu;
                } catch (Exception e2) {
                    C4990ab.m7408b("safeParser", "", e2);
                    c1331a = null;
                }
                C46599xy c46599xy = (C46599xy) c1331a;
                if (c46599xy != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "emoji md5 is " + c46599xy.cvZ);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    if (c46599xy.wdH != null) {
                        linkedList2 = c46599xy.wdH.xls;
                        C25052j.m39375o(linkedList2, "it.showMatrix.value");
                        for (Float f2 : linkedList2) {
                            i3 = i2 + 1;
                            C25052j.m39375o(f2, "data");
                            fArr[i2] = f2.floatValue();
                            i2 = i3;
                        }
                        matrix.setValues(fArr);
                        Rect rect = new Rect(cee.xdS, cee.xdU, cee.xdT, cee.xdV);
                        C1677a M = C1720g.m3530M(C6835d.class);
                        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                        EmojiInfo Je = ((C6835d) M).getProvider().mo35597Je(c46599xy.cvZ);
                        C25052j.m39375o(Je, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
                        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the emoji editor item");
                        C46925b c46925b = new C46925b(context, true);
                        c46925b.setViewMatrix(matrix);
                        c46925b.setEmojiInfo(Je);
                        UI = c46925b.mo26048UI();
                        if (UI != null) {
                            arrayList.add(UI);
                        }
                    }
                }
            } else if (i == C37889e.LOCATION.value) {
                cgu = new ayv();
                sKBuiltinBuffer_t = c40526hk.vKa;
                C25052j.m39375o(sKBuiltinBuffer_t, "it.itemData");
                buffer = sKBuiltinBuffer_t.getBuffer();
                C25052j.m39375o(buffer, "it.itemData.buffer");
                try {
                    cgu.parseFrom(buffer.getBytes());
                    c1331a = cgu;
                } catch (Exception e22) {
                    C4990ab.m7408b("safeParser", "", e22);
                    c1331a = null;
                }
                ayv ayv = (ayv) c1331a;
                if (ayv != null) {
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "reshow location data is  " + ayv.eUt + " - " + ayv.eUu + " and matrix is " + ayv.wCL.xls);
                    matrix = new Matrix();
                    fArr = new float[9];
                    i2 = 0;
                    linkedList2 = ayv.wCL.xls;
                    C25052j.m39375o(linkedList2, "it.matrix.value");
                    for (Float f22 : linkedList2) {
                        i3 = i2 + 1;
                        C25052j.m39375o(f22, "data");
                        fArr[i2] = f22.floatValue();
                        i2 = i3;
                    }
                    matrix.setValues(fArr);
                    String str2 = ayv.eUt;
                    C25052j.m39375o(str2, "it.cityName");
                    str = ayv.eUu;
                    C25052j.m39375o(str, "it.poiName");
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the position editor item");
                    C46289e c46289e = new C46289e(context);
                    c46289e.mo74443a(str2, str, matrix);
                    UI = c46289e.mo26048UI();
                    if (UI != null) {
                        arrayList.add(UI);
                    }
                }
            }
        }
        int i4 = c29276a.eXL;
        obj = (i4 == 270 || i4 == 90) ? 1 : null;
        if (obj != null) {
            i = c29276a.eTj;
        } else {
            i = c29276a.eTi;
        }
        if (obj != null) {
            i2 = c29276a.eTi;
        } else {
            i2 = c29276a.eTj;
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(109673);
            return null;
        } else if (i == 0 || i2 == 0) {
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "error width " + i + " height " + i2);
            AppMethodBeat.m2505o(109673);
            return null;
        } else {
            C29283a c29283a = C29282c.rRS;
            String str3 = cee.videoPath;
            C25052j.m39375o(str3, "storyEditorProtoData.videoPath");
            C29281a aaj = C29283a.aaj(str3);
            C13775a c13775a;
            if (cee.fbV || aaj == null || aaj.rRT) {
                c13775a = new C13775a(C22210l.m33878a(cee), arrayList, i, i2, 0, 0, 0);
                AppMethodBeat.m2505o(109673);
                return c13775a;
            }
            c13775a = new C13775a(C22210l.m33878a(cee), arrayList, i, i2, aaj.width, aaj.height, 0);
            AppMethodBeat.m2505o(109673);
            return c13775a;
        }
    }

    /* renamed from: a */
    public static float[] m33878a(cee cee) {
        AppMethodBeat.m2504i(109674);
        C25052j.m39376p(cee, "storyEditorProtoData");
        float[] fArr = new float[]{(float) cee.xdS, (float) cee.xdU, (float) cee.xdT, (float) cee.xdV};
        AppMethodBeat.m2505o(109674);
        return fArr;
    }

    /* renamed from: a */
    public static void m33873a(long j, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(109675);
        C25052j.m39376p(str, "mixVideoPath");
        C25052j.m39376p(str2, "mixThumbPath");
        C4133a c4133a = C43644j.rST;
        C39878d ls = C4133a.cxY().mo17051ls(j);
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix " + j + " storyLocalId " + (ls != null ? Integer.valueOf(ls.field_storyLocalId) : null) + ", needExport:" + z);
        if (ls != null) {
            int i = ls.field_mixFlag;
            C35186d c35186d = C35186d.sdv;
            if (C8902b.m16046cf(i, C35186d.cBx())) {
                C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "sign the data " + j + " is mix end");
                i = ls.field_mixFlag;
                c35186d = C35186d.sdv;
                ls.field_mixFlag = i & (C35186d.cBx() ^ -1);
                c4133a = C43644j.rST;
                C4133a.cxY().mo17049b(j, ls);
                if (z) {
                    C29283a c29283a = C29282c.rRS;
                    C29283a.aai(str);
                }
                c4133a = C43644j.rST;
                C39879j Fe = C4133a.cxT().mo74397Fe(ls.field_storyLocalId);
                if (Fe != null) {
                    i = Fe.field_localFlag;
                    C35187c c35187c = C35187c.sds;
                    Fe.field_localFlag = i & (C35187c.cBw() ^ -1);
                    Fe.cBS();
                    C39911a c39911a = C43647q.rTk;
                    cek cek = new cek();
                    StringBuilder stringBuilder = new StringBuilder();
                    C29283a c29283a2 = C29282c.rRS;
                    stringBuilder = stringBuilder.append(C29282c.rRP);
                    String str3 = C1839cb.aaE() + '-' + C5046bo.m7588yz();
                    Charset charset = C17355d.UTF_8;
                    if (str3 == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.m2505o(109675);
                        throw c44941v;
                    }
                    float f;
                    cek cek2;
                    byte[] bytes = str3.getBytes(charset);
                    C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
                    cek.f4416Id = stringBuilder.append(C1178g.m2591x(bytes)).toString();
                    C29309l c29309l = C29309l.rTg;
                    String aat = C29309l.aat(cek.f4416Id);
                    c29309l = C29309l.rTg;
                    String aas = C29309l.aas(cek.f4416Id);
                    c29309l = C29309l.rTg;
                    C29309l.aax(aat);
                    c29309l = C29309l.rTg;
                    C29309l.aax(aas);
                    c29309l = C29309l.rTg;
                    C29309l.aay(aat);
                    c29309l = C29309l.rTg;
                    C29309l.aay(aas);
                    long y = C5730e.m8644y(str, aat);
                    long y2 = C5730e.m8644y(str2, aas);
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + str + " to " + aat + ", ret:" + y);
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + str2 + " to " + aas + ", ret:" + y2);
                    C43528a WR = C21846d.m33388WR(aat);
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
                    Fe.mo63082b(cBR);
                    c4133a = C43644j.rST;
                    C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + ls.field_storyLocalId + " newVideoPath:" + aat + "  newThumbPath:" + aas + " ret:" + C4133a.cxT().mo74398a(ls.field_storyLocalId, Fe));
                }
                c4133a = C43644j.rST;
                C4133a.cya().checkPost();
            }
        }
        AppMethodBeat.m2505o(109675);
    }

    /* renamed from: lf */
    public static void m33882lf(long j) {
        AppMethodBeat.m2504i(109676);
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(j)));
        C4133a c4133a = C43644j.rST;
        C39878d ls = C4133a.cxY().mo17051ls(j);
        if (ls != null && ls.cBG()) {
            int i = ls.field_mixFlag;
            C35186d c35186d = C35186d.sdv;
            ls.field_mixFlag = i & (C35186d.cBx() ^ -1);
            i = ls.field_mixFlag;
            c35186d = C35186d.sdv;
            ls.field_mixFlag = i | C35186d.cBy();
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxY().mo17049b(j, ls);
            c4133a2 = C43644j.rST;
            C39879j Fe = C4133a.cxT().mo74397Fe(ls.field_storyLocalId);
            if (Fe != null) {
                Fe.cqY();
                C4133a c4133a3 = C43644j.rST;
                C4133a.cxT().mo74398a(ls.field_storyLocalId, Fe);
            }
        }
        AppMethodBeat.m2505o(109676);
    }

    /* renamed from: a */
    public static void m33872a(long j, C39878d c39878d) {
        AppMethodBeat.m2504i(109677);
        C25052j.m39376p(c39878d, "storyEditorData");
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixEnable ".concat(String.valueOf(j)));
        if (c39878d.cBG()) {
            int i = c39878d.field_mixFlag;
            C35186d c35186d = C35186d.sdv;
            c39878d.field_mixFlag = i | C35186d.cBx();
            C4133a c4133a = C43644j.rST;
            C4133a.cxY().mo17049b(j, c39878d);
        }
        AppMethodBeat.m2505o(109677);
    }

    /* renamed from: lg */
    public static void m33883lg(long j) {
        AppMethodBeat.m2504i(109678);
        C4133a c4133a = C43644j.rST;
        C39878d ls = C4133a.cxY().mo17051ls(j);
        if (ls != null && ls.cBG()) {
            ls.field_mixRetryTime++;
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxY().mo17049b(j, ls);
        }
        AppMethodBeat.m2505o(109678);
    }

    public static void czJ() {
        AppMethodBeat.m2504i(109679);
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "run clean dirty data which is the ismixed equals true");
        C4133a c4133a = C43644j.rST;
        C4133a.cxY();
        c4133a = C43644j.rST;
        C7610e cxY = C4133a.cxY();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("mixFlag&");
        C35186d c35186d = C35186d.sdv;
        Cursor query = cxY.bSd.query("StoryEditorInfo", null, stringBuilder.append(C35186d.cBx()).append("=0").toString(), null, null, null, null);
        if (query != null && query.moveToFirst()) {
            do {
                C39878d c39878d = new C39878d();
                c39878d.mo8995d(query);
                arrayList.add(Long.valueOf(c39878d.field_timeStamp));
            } while (query.moveToNext());
            query.close();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "delete the source data which is mix up");
            C25052j.m39375o(l, "i");
            C22210l.m33880b(C22210l.m33884lh(l.longValue()));
        }
        AppMethodBeat.m2505o(109679);
    }

    /* renamed from: lh */
    public static cee m33884lh(long j) {
        C39878d c39878d;
        cee cee = null;
        AppMethodBeat.m2504i(109680);
        C4133a c4133a = C43644j.rST;
        Cursor query = C4133a.cxY().bSd.query("StoryEditorInfo", null, "timeStamp=".concat(String.valueOf(j)), null, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                c39878d = new C39878d();
                c39878d.mo8995d(query);
            } else {
                c39878d = null;
            }
            query.close();
        } else {
            c39878d = null;
        }
        if (c39878d == null || !c39878d.cBG()) {
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "has no editor data ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(109680);
        } else {
            C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "is running mix and use the editor data to show " + c39878d.field_mixFlag);
            cee = new cee();
            try {
                byte[] bArr = c39878d.field_baseItemData;
                C25052j.m39375o(bArr, "field_baseItemData");
                cee.parseFrom(bArr);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Media.StoryDataProtoUtil", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(109680);
        }
        return cee;
    }

    /* renamed from: li */
    public static void m33885li(long j) {
        AppMethodBeat.m2504i(109681);
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "run clean null data");
        C4133a c4133a = C43644j.rST;
        C4133a.cxY().bSd.delete("StoryEditorInfo", "timeStamp=".concat(String.valueOf(j)), null);
        AppMethodBeat.m2505o(109681);
    }

    /* renamed from: b */
    public static void m33880b(cee cee) {
        String str;
        String str2 = null;
        AppMethodBeat.m2504i(109682);
        C4990ab.m7409c("MicroMsg.Media.StoryDataProtoUtil", "cleanUnAvailableData, videoPath " + cee + "?.videoPath", new Object[0]);
        if (cee != null && cee.fbV) {
            C5730e.deleteFile(cee.videoPath);
        }
        if (cee != null) {
            str = cee.xdR;
        } else {
            str = null;
        }
        C5730e.deleteFile(str);
        if (cee != null) {
            str = cee.eYi;
        } else {
            str = null;
        }
        C5730e.deleteFile(str);
        if (cee != null) {
            str2 = cee.thumbPath;
        }
        C5730e.deleteFile(str2);
        AppMethodBeat.m2505o(109682);
    }

    /* renamed from: gA */
    public static boolean m33881gA(String str, String str2) {
        AppMethodBeat.m2504i(109683);
        C25052j.m39376p(str, "file");
        String cz = C1178g.m2587cz(str);
        if (cz == null || str2 == null || !C6163u.m9833I(str2, cz, true)) {
            AppMethodBeat.m2505o(109683);
            return false;
        }
        AppMethodBeat.m2505o(109683);
        return true;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m33877a(String str, String str2, Matrix matrix, Context context, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(109687);
        C4990ab.m7416i("MicroMsg.Media.StoryDataProtoUtil", "fake story reshow the position item view");
        C46289e c46289e = new C46289e(context);
        viewGroup.addView(c46289e, new LayoutParams(-1, -1));
        c46289e.mo74443a(str, str2, matrix);
        AppMethodBeat.m2505o(109687);
    }
}
