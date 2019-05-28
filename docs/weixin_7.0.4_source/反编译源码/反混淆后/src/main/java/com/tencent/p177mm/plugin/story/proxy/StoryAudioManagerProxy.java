package com.tencent.p177mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.p177mm.plugin.story.model.audio.C46277g;
import com.tencent.p177mm.plugin.story.model.audio.C46277g.C4125a;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u00020\rH\u0007J\u0010\u0010\u0018\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0016R5\u0010\u0005\u001a)\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "audioTaskMap", "Landroid/util/SparseArray;", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cacheAudio", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "callback", "cacheAudioCallback", "musicId", "", "cacheAudioRemote", "cancelAll", "cancelAllRemote", "cancelCache", "cancelCacheRemote", "onCallback", "methodName", "", "data", "Landroid/os/Bundle;", "clientCall", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy */
public final class StoryAudioManagerProxy extends C31577a {
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    public static StoryAudioManagerProxy sar;
    public static final C22248a sas = new C22248a();
    private final SparseArray<LinkedList<C17126b<Boolean, C37091y>>> saq = new SparseArray();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy$c */
    static final class C22246c extends C25053k implements C31591m<Boolean, String, C37091y> {
        final /* synthetic */ AudioCacheInfo rUI;
        final /* synthetic */ StoryAudioManagerProxy sat;

        C22246c(StoryAudioManagerProxy storyAudioManagerProxy, AudioCacheInfo audioCacheInfo) {
            this.sat = storyAudioManagerProxy;
            this.rUI = audioCacheInfo;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(109691);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.sat.CLIENT_CALL("cacheAudioCallback", Integer.valueOf(this.rUI.rTW), Boolean.valueOf(booleanValue));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109691);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy$b */
    static final class C22247b extends C25053k implements C31591m<Boolean, String, C37091y> {
        final /* synthetic */ AudioCacheInfo rUI;
        final /* synthetic */ StoryAudioManagerProxy sat;

        C22247b(StoryAudioManagerProxy storyAudioManagerProxy, AudioCacheInfo audioCacheInfo) {
            this.sat = storyAudioManagerProxy;
            this.rUI = audioCacheInfo;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(109690);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            if (this.sat.saq.get(this.rUI.rTW) != null) {
                Object obj3 = this.sat.saq.get(this.rUI.rTW);
                C25052j.m39375o(obj3, "audioTaskMap[info.musicId]");
                for (C17126b am : (Iterable) obj3) {
                    am.mo50am(Boolean.valueOf(booleanValue));
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109690);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy$a */
    public static final class C22248a {
        private C22248a() {
        }

        public /* synthetic */ C22248a(byte b) {
            this();
        }

        /* renamed from: a */
        private static void m33921a(StoryAudioManagerProxy storyAudioManagerProxy) {
            AppMethodBeat.m2504i(109688);
            C25052j.m39376p(storyAudioManagerProxy, "<set-?>");
            StoryAudioManagerProxy.sar = storyAudioManagerProxy;
            AppMethodBeat.m2505o(109688);
        }

        public static void createInstance(C46607d c46607d) {
            AppMethodBeat.m2504i(109689);
            C22248a.m33921a(new StoryAudioManagerProxy(c46607d));
            AppMethodBeat.m2505o(109689);
        }
    }

    public static final void createInstance(C46607d c46607d) {
        AppMethodBeat.m2504i(109704);
        C22248a.createInstance(c46607d);
        AppMethodBeat.m2505o(109704);
    }

    public StoryAudioManagerProxy(C46607d c46607d) {
        super(c46607d);
        AppMethodBeat.m2504i(109701);
        AppMethodBeat.m2505o(109701);
    }

    public static final /* synthetic */ StoryAudioManagerProxy access$getInstance$cp() {
        AppMethodBeat.m2504i(109703);
        StoryAudioManagerProxy storyAudioManagerProxy = sar;
        if (storyAudioManagerProxy == null) {
            C25052j.avw("instance");
        }
        AppMethodBeat.m2505o(109703);
        return storyAudioManagerProxy;
    }

    static {
        AppMethodBeat.m2504i(109702);
        AppMethodBeat.m2505o(109702);
    }

    public static /* synthetic */ void cacheAudio$default(StoryAudioManagerProxy storyAudioManagerProxy, AudioCacheInfo audioCacheInfo, C17126b c17126b, int i, Object obj) {
        AppMethodBeat.m2504i(109693);
        if ((i & 2) != 0) {
            c17126b = null;
        }
        storyAudioManagerProxy.cacheAudio(audioCacheInfo, c17126b);
        AppMethodBeat.m2505o(109693);
    }

    public final void cacheAudio(AudioCacheInfo audioCacheInfo, C17126b<? super Boolean, C37091y> c17126b) {
        AppMethodBeat.m2504i(109692);
        C25052j.m39376p(audioCacheInfo, "info");
        LinkedList linkedList = (LinkedList) this.saq.get(audioCacheInfo.rTW);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.saq.put(audioCacheInfo.rTW, linkedList);
        }
        if (c17126b != null) {
            linkedList.add(c17126b);
        }
        C4125a c4125a = C46277g.rUG;
        C46277g.rUF.mo74419a(audioCacheInfo, new C22247b(this, audioCacheInfo));
        AppMethodBeat.m2505o(109692);
    }

    @C40602e
    public final void cacheAudioCallback(int i, boolean z) {
        AppMethodBeat.m2504i(109694);
        LinkedList<C17126b> linkedList = (LinkedList) this.saq.get(i);
        if (linkedList != null) {
            for (C17126b am : linkedList) {
                am.mo50am(Boolean.valueOf(z));
            }
            AppMethodBeat.m2505o(109694);
            return;
        }
        AppMethodBeat.m2505o(109694);
    }

    @C46608f
    public final void cacheAudioRemote(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.m2504i(109695);
        C25052j.m39376p(audioCacheInfo, "info");
        C4125a c4125a = C46277g.rUG;
        C46277g.rUF.mo74419a(audioCacheInfo, new C22246c(this, audioCacheInfo));
        AppMethodBeat.m2505o(109695);
    }

    public final void cancelCache(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.m2504i(109696);
        if (audioCacheInfo != null) {
            this.saq.removeAt(audioCacheInfo.rTW);
            REMOTE_CALL("cancelCacheRemote", audioCacheInfo);
        }
        AppMethodBeat.m2505o(109696);
    }

    @C46608f
    public final void cancelCacheRemote(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.m2504i(109697);
        C4125a c4125a = C46277g.rUG;
        C46277g.rUF.cancelCache(audioCacheInfo);
        AppMethodBeat.m2505o(109697);
    }

    public final void cancelAll() {
        AppMethodBeat.m2504i(109698);
        this.saq.clear();
        REMOTE_CALL("cancelAllRemote", new Object[0]);
        AppMethodBeat.m2505o(109698);
    }

    @C46608f
    public final void cancelAllRemote() {
        AppMethodBeat.m2504i(109699);
        C4125a c4125a = C46277g.rUG;
        C46277g.rUF.cancelAll();
        AppMethodBeat.m2505o(109699);
    }

    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(109700);
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
                    bundle.setClassLoader(AudioCacheInfo.class.getClassLoader());
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if ((C25052j.m39373j(method.getReturnType(), Void.TYPE) ^ 1) != 0) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.m2505o(109700);
                            return;
                        }
                        String str2 = RESULT_KEY;
                        if (invoke == null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.io.Serializable");
                            AppMethodBeat.m2505o(109700);
                            throw c44941v;
                        }
                        bundle.putSerializable(str2, (Serializable) invoke);
                        AppMethodBeat.m2505o(109700);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "exception:%s", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(109700);
    }
}
