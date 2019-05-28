package com.tencent.mm.plugin.story.proxy;

import a.f.b.j;
import a.l;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016JH\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\nH\u0016JX\u0010'\u001a\u00020\u000e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/2(\u00100\u001a$\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0016J*\u00101\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016Rx\u0010\u0003\u001a`\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "favorite", "videoPath", "mediaDes", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getRecommendMusic", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "getRecommendMusicCallback", "respBytes", "", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class d implements a {
    private static final String TAG = TAG;
    private static final d sbe = new d();
    public static final a sbf = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryProxy$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static String getAccPath() {
        AppMethodBeat.i(109756);
        String accPath;
        if (ah.bqo()) {
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            accPath = RP.getAccPath();
            j.o(accPath, "MMKernel.storage().accPath");
            AppMethodBeat.o(109756);
            return accPath;
        }
        com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar = StoryCaptureProxy.saw;
        accPath = StoryCaptureProxy.access$getInstance$cp().getAccPath();
        AppMethodBeat.o(109756);
        return accPath;
    }

    public static VideoTransPara getVideoPara() {
        AppMethodBeat.i(109757);
        VideoTransPara afJ;
        if (ah.bqo()) {
            com.tencent.mm.modelcontrol.d afF = com.tencent.mm.modelcontrol.d.afF();
            j.o(afF, "SubCoreVideoControl.getCore()");
            afJ = afF.afJ();
            j.o(afJ, "SubCoreVideoControl.getCore().storyRecordVideoPara");
            AppMethodBeat.o(109757);
            return afJ;
        }
        com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar = StoryCaptureProxy.saw;
        afJ = StoryCaptureProxy.access$getInstance$cp().getVideoPara();
        AppMethodBeat.o(109757);
        return afJ;
    }

    public final int commitStory(String str, String str2, String str3, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.i(138832);
        j.p(str, "videoPath");
        j.p(str2, "thumbPath");
        j.p(str3, "mediaDes");
        j.p(cei, b.LOCATION);
        j.p(cej, "editorInfo");
        int commit;
        if (ah.bqo()) {
            String cz = com.tencent.mm.c.g.cz(str);
            com.tencent.mm.plugin.story.model.g.d dVar = new com.tencent.mm.plugin.story.model.g.d();
            baa baa = new baa();
            com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar = StoryCaptureProxy.saw;
            ab.i(StoryCaptureProxy.TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + cz + " isCaptureVideo:" + z + " scope:" + i);
            baa.wDP = z;
            j.o(cz, "md5");
            dVar.am(str, str2, cz);
            dVar.a(cei);
            dVar.a(cej);
            dVar.b(baa);
            dVar.EM(i);
            dVar.EN(i2);
            commit = dVar.commit();
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
            AppMethodBeat.o(138832);
            return commit;
        }
        com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar3 = StoryCaptureProxy.saw;
        commit = StoryCaptureProxy.access$getInstance$cp().commitStory(str, str2, str3, cei, z, cej, i, 0);
        AppMethodBeat.o(138832);
        return commit;
    }

    public final int commitStory(com.tencent.mm.plugin.story.h.d dVar, String str, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.i(138833);
        j.p(dVar, "storyEditorData");
        j.p(str, "thumbPath");
        j.p(cei, b.LOCATION);
        j.p(cej, "editorInfo");
        int commit;
        if (ah.bqo()) {
            com.tencent.mm.plugin.story.model.g.d dVar2 = new com.tencent.mm.plugin.story.model.g.d();
            baa baa = new baa();
            com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar = StoryCaptureProxy.saw;
            ab.i(StoryCaptureProxy.TAG, "storyEditorData " + dVar.xDa + " isCaptureVideo:" + z + " scope:" + i);
            baa.wDP = z;
            dVar2.a(dVar, str);
            dVar2.a(cej);
            dVar2.a(cei);
            dVar2.b(baa);
            dVar2.EM(i);
            dVar2.EN(i2);
            commit = dVar2.commit();
            com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
            AppMethodBeat.o(138833);
            return commit;
        }
        com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar3 = StoryCaptureProxy.saw;
        commit = StoryCaptureProxy.access$getInstance$cp().commitStory(dVar, str, cei, z, cej, i, 0);
        AppMethodBeat.o(138833);
        return commit;
    }

    static {
        AppMethodBeat.i(109760);
        AppMethodBeat.o(109760);
    }
}
