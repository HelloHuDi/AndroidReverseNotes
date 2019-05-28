package com.tencent.mm.plugin.story.proxy;

import a.f.a.r;
import a.f.b.j;
import a.k.u;
import a.l;
import a.v;
import a.y;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J@\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016JH\u0010\u0016\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J(\u0010$\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\rH\u0007JX\u0010,\u001a\u00020\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002042(\u00105\u001a$\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007H\u0016J*\u00106\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u00107\u001a\u000208H\u0017J8\u00109\u001a\u00020\u00112\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u0002080;j\b\u0012\u0004\u0012\u000208`<2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0007J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020>H\u0007J \u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001dH\u0016J\u0019\u0010E\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0002Rx\u0010\u0006\u001a`\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006G"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "favorite", "videoPath", "mediaDes", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getRecommendMusic", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "getRecommendMusicCallback", "respBytes", "", "getRecommendMusicRemote", "imageDataBytes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
public final class StoryCaptureProxy extends com.tencent.mm.remoteservice.a implements a {
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    public static StoryCaptureProxy sav;
    public static final a saw = new a();
    private r<? super Integer, ? super Integer, ? super String, ? super ann, y> sau;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ StoryCaptureProxy sax;

        b(StoryCaptureProxy storyCaptureProxy) {
            this.sax = storyCaptureProxy;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(109707);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            a aVar2 = StoryCaptureProxy.saw;
            ab.i(StoryCaptureProxy.TAG, "LogStory: getRecommendMusicRemote in worker");
            Object CLIENT_CALL = this.sax.CLIENT_CALL("getRecommendMusicCallback", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm, ((ann) aVar.fsy).toByteArray());
            AppMethodBeat.o(109707);
            return CLIENT_CALL;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static void a(StoryCaptureProxy storyCaptureProxy) {
            AppMethodBeat.i(109705);
            j.p(storyCaptureProxy, "<set-?>");
            StoryCaptureProxy.sav = storyCaptureProxy;
            AppMethodBeat.o(109705);
        }

        public static void createInstance(d dVar) {
            AppMethodBeat.i(109706);
            a(new StoryCaptureProxy(dVar));
            AppMethodBeat.o(109706);
        }
    }

    public static final void createInstance(d dVar) {
        AppMethodBeat.i(109723);
        a.createInstance(dVar);
        AppMethodBeat.o(109723);
    }

    public StoryCaptureProxy(d dVar) {
        super(dVar);
    }

    public static final /* synthetic */ StoryCaptureProxy access$getInstance$cp() {
        AppMethodBeat.i(109722);
        StoryCaptureProxy storyCaptureProxy = sav;
        if (storyCaptureProxy == null) {
            j.avw("instance");
        }
        AppMethodBeat.o(109722);
        return storyCaptureProxy;
    }

    static {
        AppMethodBeat.i(109721);
        AppMethodBeat.o(109721);
    }

    public final r<Integer, Integer, String, ann, y> getMusicCallback() {
        return this.sau;
    }

    public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super ann, y> rVar) {
        this.sau = rVar;
    }

    public final String getAccPath() {
        AppMethodBeat.i(109708);
        String obj = REMOTE_CALL("getAccPathRemote", new Object[0]).toString();
        AppMethodBeat.o(109708);
        return obj;
    }

    @f
    public final String getAccPathRemote() {
        AppMethodBeat.i(109709);
        e RP = g.RP();
        j.o(RP, "storage()");
        String accPath = RP.getAccPath();
        j.o(accPath, "storage().accPath");
        AppMethodBeat.o(109709);
        return accPath;
    }

    public final VideoTransPara getVideoPara() {
        AppMethodBeat.i(109710);
        VideoTransPara videoTransPara = (VideoTransPara) REMOTE_CALL("getVideoParaRemote", new Object[0]);
        if (videoTransPara == null) {
            j.dWJ();
        }
        AppMethodBeat.o(109710);
        return videoTransPara;
    }

    @f
    public final VideoTransPara getVideoParaRemote() {
        AppMethodBeat.i(109711);
        com.tencent.mm.modelcontrol.d afF = com.tencent.mm.modelcontrol.d.afF();
        j.o(afF, "SubCoreVideoControl.getCore()");
        VideoTransPara afJ = afF.afJ();
        j.o(afJ, "para");
        AppMethodBeat.o(109711);
        return afJ;
    }

    public final void getRecommendMusic(LinkedList<com.tencent.mm.bt.b> linkedList, float f, float f2, long j, r<? super Integer, ? super Integer, ? super String, ? super ann, y> rVar) {
        AppMethodBeat.i(109712);
        j.p(linkedList, "imageData");
        ab.i(TAG, "LogStory: getRecommendMusic");
        this.sau = rVar;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.bt.b bytes : linkedList) {
            arrayList.add(bytes.getBytes());
        }
        REMOTE_CALL("getRecommendMusicRemote", arrayList, Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j));
        AppMethodBeat.o(109712);
    }

    @com.tencent.mm.remoteservice.e
    public final void getRecommendMusicCallback(int i, int i2, String str, byte[] bArr) {
        AppMethodBeat.i(109713);
        j.p(bArr, "respBytes");
        ab.i(TAG, "LogStory: getRecommendMusicCallback");
        ann ann = new ann();
        ann.parseFrom(bArr);
        r rVar = this.sau;
        if (rVar != null) {
            rVar.a(Integer.valueOf(i), Integer.valueOf(i2), str, ann);
            AppMethodBeat.o(109713);
            return;
        }
        AppMethodBeat.o(109713);
    }

    @f
    public final void getRecommendMusicRemote(ArrayList<byte[]> arrayList, float f, float f2, long j) {
        AppMethodBeat.i(109714);
        j.p(arrayList, "imageDataBytes");
        ab.i(TAG, "LogStory: getRecommendMusicRemote");
        LinkedList linkedList = new LinkedList();
        for (byte[] bVar : arrayList) {
            linkedList.add(new com.tencent.mm.bt.b(bVar));
        }
        new com.tencent.mm.plugin.story.model.audio.d(linkedList, f, f2, j, (byte) 0).acy().j(new b(this));
        AppMethodBeat.o(109714);
    }

    public final int commitStory(String str, String str2, String str3, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.i(138830);
        j.p(str, "videoPath");
        j.p(str2, "thumbPath");
        j.p(str3, "mediaDes");
        j.p(cei, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        j.p(cej, "editorInfo");
        String cz = com.tencent.mm.c.g.cz(str);
        com.tencent.mm.plugin.story.model.g.d dVar = new com.tencent.mm.plugin.story.model.g.d();
        baa baa = new baa();
        ab.d(TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + cz + " isCaptureVideo:" + z);
        baa.wDP = z;
        j.o(cz, "md5");
        dVar.am(str, str2, cz);
        dVar.a(cej);
        dVar.a(cei);
        dVar.b(baa);
        dVar.EM(i);
        dVar.EN(i2);
        int commit = dVar.commit();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
        AppMethodBeat.o(138830);
        return commit;
    }

    public final int commitStory(com.tencent.mm.plugin.story.h.d dVar, String str, cei cei, boolean z, cej cej, int i, int i2) {
        AppMethodBeat.i(138831);
        j.p(dVar, "storyEditorData");
        j.p(str, "thumbPath");
        j.p(cei, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        j.p(cej, "editorInfo");
        com.tencent.mm.plugin.story.model.g.d dVar2 = new com.tencent.mm.plugin.story.model.g.d();
        baa baa = new baa();
        ab.d(TAG, "storyEditorData " + dVar.xDa + " isCaptureVideo:" + z);
        baa.wDP = z;
        dVar2.a(dVar, str);
        dVar2.a(cej);
        dVar2.a(cei);
        dVar2.b(baa);
        dVar2.EM(i);
        dVar2.EN(i2);
        int commit = dVar2.commit();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
        AppMethodBeat.o(138831);
        return commit;
    }

    @f
    public final void commitStoryRemote(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(109717);
        j.p(str, "videoPath");
        j.p(str2, "thumbPath");
        j.p(str3, "mediaDes");
        String cz = com.tencent.mm.c.g.cz(str);
        com.tencent.mm.plugin.story.model.g.d dVar = new com.tencent.mm.plugin.story.model.g.d();
        baa baa = new baa();
        ab.d(TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + cz + " isCaptureVideo:" + z);
        baa.wDP = z;
        j.o(cz, "md5");
        dVar.am(str, str2, cz);
        dVar.b(baa);
        dVar.commit();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
        AppMethodBeat.o(109717);
    }

    public final void set(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(109718);
        j.p(aVar, "key");
        j.p(obj, "defva");
        ab.i(TAG, "get %s %s", aVar, obj);
        ab.i(TAG, "setConfigStorage, %s %s", ((com.tencent.mm.storage.ac.a[]) com.tencent.mm.storage.ac.a.class.getEnumConstants())[aVar.ordinal()], obj);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        RP.Ry().set(r0, obj);
        AppMethodBeat.o(109718);
    }

    public final Object get(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(109719);
        j.p(aVar, "key");
        j.p(obj, "defva");
        ab.i(TAG, "getConfigStorage, %s %s", ((com.tencent.mm.storage.ac.a[]) com.tencent.mm.storage.ac.a.class.getEnumConstants())[aVar.ordinal()], obj);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj2 = RP.Ry().get(r0, obj);
        j.o(obj2, "MMKernel.storage().configStg.get(index, defva)");
        AppMethodBeat.o(109719);
        return obj2;
    }

    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(109720);
        j.p(str, "methodName");
        j.p(bundle, "data");
        ab.i(TAG, "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                j.o(method2, "mth");
                if (u.I(method2.getName(), str, true)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if ((j.j(method.getReturnType(), Void.TYPE) ^ 1) != 0) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.o(109720);
                            return;
                        }
                        String str2 = RESULT_KEY;
                        if (invoke == null) {
                            v vVar = new v("null cannot be cast to non-null type java.io.Serializable");
                            AppMethodBeat.o(109720);
                            throw vVar;
                        }
                        bundle.putSerializable(str2, (Serializable) invoke);
                        AppMethodBeat.o(109720);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ab.e(TAG, "exception:%s", bo.l(e));
        }
        AppMethodBeat.o(109720);
    }
}
