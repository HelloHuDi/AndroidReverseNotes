package com.tencent.p177mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p209c.C25998g;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.audio.C22220d;
import com.tencent.p177mm.plugin.story.model.p535g.C4131d;
import com.tencent.p177mm.plugin.story.p532h.C39878d;
import com.tencent.p177mm.protocal.protobuf.ann;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.protocal.protobuf.cej;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J@\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016JH\u0010\u0016\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J(\u0010$\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\rH\u0007JX\u0010,\u001a\u00020\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002042(\u00105\u001a$\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007H\u0016J*\u00106\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u00107\u001a\u000208H\u0017J8\u00109\u001a\u00020\u00112\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u0002080;j\b\u0012\u0004\u0012\u000208`<2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0007J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020>H\u0007J \u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001dH\u0016J\u0019\u0010E\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0002Rx\u0010\u0006\u001a`\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "favorite", "videoPath", "mediaDes", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getRecommendMusic", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "getRecommendMusicCallback", "respBytes", "", "getRecommendMusicRemote", "imageDataBytes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.proxy.StoryCaptureProxy */
public final class StoryCaptureProxy extends C31577a implements C29312a {
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    public static StoryCaptureProxy sav;
    public static final C31583a saw = new C31583a();
    private C0011r<? super Integer, ? super Integer, ? super String, ? super ann, C37091y> sau;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.StoryCaptureProxy$b */
    static final class C31582b<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ StoryCaptureProxy sax;

        C31582b(StoryCaptureProxy storyCaptureProxy) {
            this.sax = storyCaptureProxy;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(109707);
            C37441a c37441a = (C37441a) obj;
            C31583a c31583a = StoryCaptureProxy.saw;
            C4990ab.m7416i(StoryCaptureProxy.TAG, "LogStory: getRecommendMusicRemote in worker");
            Object CLIENT_CALL = this.sax.CLIENT_CALL("getRecommendMusicCallback", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm, ((ann) c37441a.fsy).toByteArray());
            AppMethodBeat.m2505o(109707);
            return CLIENT_CALL;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.StoryCaptureProxy$a */
    public static final class C31583a {
        private C31583a() {
        }

        public /* synthetic */ C31583a(byte b) {
            this();
        }

        /* renamed from: a */
        private static void m51046a(StoryCaptureProxy storyCaptureProxy) {
            AppMethodBeat.m2504i(109705);
            C25052j.m39376p(storyCaptureProxy, "<set-?>");
            StoryCaptureProxy.sav = storyCaptureProxy;
            AppMethodBeat.m2505o(109705);
        }

        public static void createInstance(C46607d c46607d) {
            AppMethodBeat.m2504i(109706);
            C31583a.m51046a(new StoryCaptureProxy(c46607d));
            AppMethodBeat.m2505o(109706);
        }
    }

    public static final void createInstance(C46607d c46607d) {
        AppMethodBeat.m2504i(109723);
        C31583a.createInstance(c46607d);
        AppMethodBeat.m2505o(109723);
    }

    public StoryCaptureProxy(C46607d c46607d) {
        super(c46607d);
    }

    public static final /* synthetic */ StoryCaptureProxy access$getInstance$cp() {
        AppMethodBeat.m2504i(109722);
        StoryCaptureProxy storyCaptureProxy = sav;
        if (storyCaptureProxy == null) {
            C25052j.avw("instance");
        }
        AppMethodBeat.m2505o(109722);
        return storyCaptureProxy;
    }

    static {
        AppMethodBeat.m2504i(109721);
        AppMethodBeat.m2505o(109721);
    }

    public final C0011r<Integer, Integer, String, ann, C37091y> getMusicCallback() {
        return this.sau;
    }

    public final void setMusicCallback(C0011r<? super Integer, ? super Integer, ? super String, ? super ann, C37091y> c0011r) {
        this.sau = c0011r;
    }

    public final String getAccPath() {
        AppMethodBeat.m2504i(109708);
        String obj = REMOTE_CALL("getAccPathRemote", new Object[0]).toString();
        AppMethodBeat.m2505o(109708);
        return obj;
    }

    @C46608f
    public final String getAccPathRemote() {
        AppMethodBeat.m2504i(109709);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        String accPath = RP.getAccPath();
        C25052j.m39375o(accPath, "storage().accPath");
        AppMethodBeat.m2505o(109709);
        return accPath;
    }

    public final VideoTransPara getVideoPara() {
        AppMethodBeat.m2504i(109710);
        VideoTransPara videoTransPara = (VideoTransPara) REMOTE_CALL("getVideoParaRemote", new Object[0]);
        if (videoTransPara == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(109710);
        return videoTransPara;
    }

    @C46608f
    public final VideoTransPara getVideoParaRemote() {
        AppMethodBeat.m2504i(109711);
        C42204d afF = C42204d.afF();
        C25052j.m39375o(afF, "SubCoreVideoControl.getCore()");
        VideoTransPara afJ = afF.afJ();
        C25052j.m39375o(afJ, "para");
        AppMethodBeat.m2505o(109711);
        return afJ;
    }

    public final void getRecommendMusic(LinkedList<C1332b> linkedList, float f, float f2, long j, C0011r<? super Integer, ? super Integer, ? super String, ? super ann, C37091y> c0011r) {
        AppMethodBeat.m2504i(109712);
        C25052j.m39376p(linkedList, "imageData");
        C4990ab.m7416i(TAG, "LogStory: getRecommendMusic");
        this.sau = c0011r;
        ArrayList arrayList = new ArrayList();
        for (C1332b bytes : linkedList) {
            arrayList.add(bytes.getBytes());
        }
        REMOTE_CALL("getRecommendMusicRemote", arrayList, Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j));
        AppMethodBeat.m2505o(109712);
    }

    @C40602e
    public final void getRecommendMusicCallback(int i, int i2, String str, byte[] bArr) {
        AppMethodBeat.m2504i(109713);
        C25052j.m39376p(bArr, "respBytes");
        C4990ab.m7416i(TAG, "LogStory: getRecommendMusicCallback");
        ann ann = new ann();
        ann.parseFrom(bArr);
        C0011r c0011r = this.sau;
        if (c0011r != null) {
            c0011r.mo47a(Integer.valueOf(i), Integer.valueOf(i2), str, ann);
            AppMethodBeat.m2505o(109713);
            return;
        }
        AppMethodBeat.m2505o(109713);
    }

    @C46608f
    public final void getRecommendMusicRemote(ArrayList<byte[]> arrayList, float f, float f2, long j) {
        AppMethodBeat.m2504i(109714);
        C25052j.m39376p(arrayList, "imageDataBytes");
        C4990ab.m7416i(TAG, "LogStory: getRecommendMusicRemote");
        LinkedList linkedList = new LinkedList();
        for (byte[] c1332b : arrayList) {
            linkedList.add(new C1332b(c1332b));
        }
        new C22220d(linkedList, f, f2, j, (byte) 0).acy().mo60494j(new C31582b(this));
        AppMethodBeat.m2505o(109714);
    }

    public final int commitStory(String str, String str2, String str3, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.m2504i(138830);
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(str2, "thumbPath");
        C25052j.m39376p(str3, "mediaDes");
        C25052j.m39376p(cei, C8741b.LOCATION);
        C25052j.m39376p(cej, "editorInfo");
        String cz = C25998g.m41489cz(str);
        C4131d c4131d = new C4131d();
        baa baa = new baa();
        C4990ab.m7410d(TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + cz + " isCaptureVideo:" + z);
        baa.wDP = z;
        C25052j.m39375o(cz, "md5");
        c4131d.mo9010am(str, str2, cz);
        c4131d.mo9008a(cej);
        c4131d.mo9007a(cei);
        c4131d.mo9011b(baa);
        c4131d.mo9005EM(i);
        c4131d.mo9006EN(i2);
        int commit = c4131d.commit();
        C4133a c4133a = C43644j.rST;
        C4133a.cya().checkPost();
        AppMethodBeat.m2505o(138830);
        return commit;
    }

    public final int commitStory(C39878d c39878d, String str, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.m2504i(138831);
        C25052j.m39376p(c39878d, "storyEditorData");
        C25052j.m39376p(str, "thumbPath");
        C25052j.m39376p(cei, C8741b.LOCATION);
        C25052j.m39376p(cej, "editorInfo");
        C4131d c4131d = new C4131d();
        baa baa = new baa();
        C4990ab.m7410d(TAG, "storyEditorData " + c39878d.xDa + " isCaptureVideo:" + z);
        baa.wDP = z;
        c4131d.mo9009a(c39878d, str);
        c4131d.mo9008a(cej);
        c4131d.mo9007a(cei);
        c4131d.mo9011b(baa);
        c4131d.mo9005EM(i);
        c4131d.mo9006EN(i2);
        int commit = c4131d.commit();
        C4133a c4133a = C43644j.rST;
        C4133a.cya().checkPost();
        AppMethodBeat.m2505o(138831);
        return commit;
    }

    @C46608f
    public final void commitStoryRemote(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(109717);
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(str2, "thumbPath");
        C25052j.m39376p(str3, "mediaDes");
        String cz = C25998g.m41489cz(str);
        C4131d c4131d = new C4131d();
        baa baa = new baa();
        C4990ab.m7410d(TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + cz + " isCaptureVideo:" + z);
        baa.wDP = z;
        C25052j.m39375o(cz, "md5");
        c4131d.mo9010am(str, str2, cz);
        c4131d.mo9011b(baa);
        c4131d.commit();
        C4133a c4133a = C43644j.rST;
        C4133a.cya().checkPost();
        AppMethodBeat.m2505o(109717);
    }

    public final void set(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(109718);
        C25052j.m39376p(c5127a, "key");
        C25052j.m39376p(obj, "defva");
        C4990ab.m7417i(TAG, "get %s %s", c5127a, obj);
        C4990ab.m7417i(TAG, "setConfigStorage, %s %s", ((C5127a[]) C5127a.class.getEnumConstants())[c5127a.ordinal()], obj);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(r0, obj);
        AppMethodBeat.m2505o(109718);
    }

    public final Object get(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(109719);
        C25052j.m39376p(c5127a, "key");
        C25052j.m39376p(obj, "defva");
        C4990ab.m7417i(TAG, "getConfigStorage, %s %s", ((C5127a[]) C5127a.class.getEnumConstants())[c5127a.ordinal()], obj);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj2 = RP.mo5239Ry().get(r0, obj);
        C25052j.m39375o(obj2, "MMKernel.storage().configStg.get(index, defva)");
        AppMethodBeat.m2505o(109719);
        return obj2;
    }

    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(109720);
        C25052j.m39376p(str, "methodName");
        C25052j.m39376p(bundle, "data");
        C4990ab.m7417i(TAG, "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                C25052j.m39375o(method2, "mth");
                if (C6163u.m9833I(method2.getName(), str, true)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? C40602e.class : C46608f.class)) {
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if ((C25052j.m39373j(method.getReturnType(), Void.TYPE) ^ 1) != 0) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.m2505o(109720);
                            return;
                        }
                        String str2 = RESULT_KEY;
                        if (invoke == null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.io.Serializable");
                            AppMethodBeat.m2505o(109720);
                            throw c44941v;
                        }
                        bundle.putSerializable(str2, (Serializable) invoke);
                        AppMethodBeat.m2505o(109720);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "exception:%s", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(109720);
    }
}
