package com.tencent.p177mm.plugin.story.proxy;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p535g.C4131d;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.plugin.story.proxy.StoryCaptureProxy.C31583a;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.protocal.protobuf.cej;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016JH\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\nH\u0016JX\u0010'\u001a\u00020\u000e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/2(\u00100\u001a$\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0016J*\u00101\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016Rx\u0010\u0003\u001a`\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "favorite", "videoPath", "mediaDes", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getRecommendMusic", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "getRecommendMusicCallback", "respBytes", "", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.proxy.d */
public final class C39913d implements C29312a {
    private static final String TAG = TAG;
    private static final C39913d sbe = new C39913d();
    public static final C22249a sbf = new C22249a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryProxy$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.d$a */
    public static final class C22249a {
        private C22249a() {
        }

        public /* synthetic */ C22249a(byte b) {
            this();
        }
    }

    public static String getAccPath() {
        AppMethodBeat.m2504i(109756);
        String accPath;
        if (C4996ah.bqo()) {
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            accPath = RP.getAccPath();
            C25052j.m39375o(accPath, "MMKernel.storage().accPath");
            AppMethodBeat.m2505o(109756);
            return accPath;
        }
        C31583a c31583a = StoryCaptureProxy.saw;
        accPath = StoryCaptureProxy.access$getInstance$cp().getAccPath();
        AppMethodBeat.m2505o(109756);
        return accPath;
    }

    public static VideoTransPara getVideoPara() {
        AppMethodBeat.m2504i(109757);
        VideoTransPara afJ;
        if (C4996ah.bqo()) {
            C42204d afF = C42204d.afF();
            C25052j.m39375o(afF, "SubCoreVideoControl.getCore()");
            afJ = afF.afJ();
            C25052j.m39375o(afJ, "SubCoreVideoControl.getCore().storyRecordVideoPara");
            AppMethodBeat.m2505o(109757);
            return afJ;
        }
        C31583a c31583a = StoryCaptureProxy.saw;
        afJ = StoryCaptureProxy.access$getInstance$cp().getVideoPara();
        AppMethodBeat.m2505o(109757);
        return afJ;
    }

    public final int commitStory(String str, String str2, String str3, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.m2504i(138832);
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(str2, "thumbPath");
        C25052j.m39376p(str3, "mediaDes");
        C25052j.m39376p(cei, C8741b.LOCATION);
        C25052j.m39376p(cej, "editorInfo");
        int commit;
        if (C4996ah.bqo()) {
            String cz = C25998g.m41489cz(str);
            C4131d c4131d = new C4131d();
            baa baa = new baa();
            C31583a c31583a = StoryCaptureProxy.saw;
            C4990ab.m7416i(StoryCaptureProxy.TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + cz + " isCaptureVideo:" + z + " scope:" + i);
            baa.wDP = z;
            C25052j.m39375o(cz, "md5");
            c4131d.mo9010am(str, str2, cz);
            c4131d.mo9007a(cei);
            c4131d.mo9008a(cej);
            c4131d.mo9011b(baa);
            c4131d.mo9005EM(i);
            c4131d.mo9006EN(i2);
            commit = c4131d.commit();
            C4133a c4133a = C43644j.rST;
            C4133a.cya().checkPost();
            AppMethodBeat.m2505o(138832);
            return commit;
        }
        C31583a c31583a2 = StoryCaptureProxy.saw;
        commit = StoryCaptureProxy.access$getInstance$cp().commitStory(str, str2, str3, cei, z, cej, i, 0);
        AppMethodBeat.m2505o(138832);
        return commit;
    }

    public final int commitStory(C39878d c39878d, String str, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.m2504i(138833);
        C25052j.m39376p(c39878d, "storyEditorData");
        C25052j.m39376p(str, "thumbPath");
        C25052j.m39376p(cei, C8741b.LOCATION);
        C25052j.m39376p(cej, "editorInfo");
        int commit;
        if (C4996ah.bqo()) {
            C4131d c4131d = new C4131d();
            baa baa = new baa();
            C31583a c31583a = StoryCaptureProxy.saw;
            C4990ab.m7416i(StoryCaptureProxy.TAG, "storyEditorData " + c39878d.xDa + " isCaptureVideo:" + z + " scope:" + i);
            baa.wDP = z;
            c4131d.mo9009a(c39878d, str);
            c4131d.mo9008a(cej);
            c4131d.mo9007a(cei);
            c4131d.mo9011b(baa);
            c4131d.mo9005EM(i);
            c4131d.mo9006EN(i2);
            commit = c4131d.commit();
            C4133a c4133a = C43644j.rST;
            C4133a.cya().checkPost();
            AppMethodBeat.m2505o(138833);
            return commit;
        }
        C31583a c31583a2 = StoryCaptureProxy.saw;
        commit = StoryCaptureProxy.access$getInstance$cp().commitStory(c39878d, str, cei, z, cej, i, 0);
        AppMethodBeat.m2505o(138833);
        return commit;
    }

    static {
        AppMethodBeat.m2504i(109760);
        AppMethodBeat.m2505o(109760);
    }
}
