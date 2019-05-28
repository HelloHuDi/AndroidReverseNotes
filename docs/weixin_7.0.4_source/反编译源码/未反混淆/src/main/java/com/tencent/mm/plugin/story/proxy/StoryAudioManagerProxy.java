package com.tencent.mm.plugin.story.proxy;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.v;
import a.y;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.g;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u00020\rH\u0007J\u0010\u0010\u0018\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0016R5\u0010\u0005\u001a)\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "audioTaskMap", "Landroid/util/SparseArray;", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cacheAudio", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "callback", "cacheAudioCallback", "musicId", "", "cacheAudioRemote", "cancelAll", "cancelAllRemote", "cancelCache", "cancelCacheRemote", "onCallback", "methodName", "", "data", "Landroid/os/Bundle;", "clientCall", "Companion", "plugin-story_release"})
public final class StoryAudioManagerProxy extends com.tencent.mm.remoteservice.a {
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    public static StoryAudioManagerProxy sar;
    public static final a sas = new a();
    private final SparseArray<LinkedList<a.f.a.b<Boolean, y>>> saq = new SparseArray();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    static final class c extends k implements m<Boolean, String, y> {
        final /* synthetic */ AudioCacheInfo rUI;
        final /* synthetic */ StoryAudioManagerProxy sat;

        c(StoryAudioManagerProxy storyAudioManagerProxy, AudioCacheInfo audioCacheInfo) {
            this.sat = storyAudioManagerProxy;
            this.rUI = audioCacheInfo;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(109691);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.sat.CLIENT_CALL("cacheAudioCallback", Integer.valueOf(this.rUI.rTW), Boolean.valueOf(booleanValue));
            y yVar = y.AUy;
            AppMethodBeat.o(109691);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    static final class b extends k implements m<Boolean, String, y> {
        final /* synthetic */ AudioCacheInfo rUI;
        final /* synthetic */ StoryAudioManagerProxy sat;

        b(StoryAudioManagerProxy storyAudioManagerProxy, AudioCacheInfo audioCacheInfo) {
            this.sat = storyAudioManagerProxy;
            this.rUI = audioCacheInfo;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(109690);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            if (this.sat.saq.get(this.rUI.rTW) != null) {
                Object obj3 = this.sat.saq.get(this.rUI.rTW);
                j.o(obj3, "audioTaskMap[info.musicId]");
                for (a.f.a.b am : (Iterable) obj3) {
                    am.am(Boolean.valueOf(booleanValue));
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109690);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static void a(StoryAudioManagerProxy storyAudioManagerProxy) {
            AppMethodBeat.i(109688);
            j.p(storyAudioManagerProxy, "<set-?>");
            StoryAudioManagerProxy.sar = storyAudioManagerProxy;
            AppMethodBeat.o(109688);
        }

        public static void createInstance(d dVar) {
            AppMethodBeat.i(109689);
            a(new StoryAudioManagerProxy(dVar));
            AppMethodBeat.o(109689);
        }
    }

    public static final void createInstance(d dVar) {
        AppMethodBeat.i(109704);
        a.createInstance(dVar);
        AppMethodBeat.o(109704);
    }

    public StoryAudioManagerProxy(d dVar) {
        super(dVar);
        AppMethodBeat.i(109701);
        AppMethodBeat.o(109701);
    }

    public static final /* synthetic */ StoryAudioManagerProxy access$getInstance$cp() {
        AppMethodBeat.i(109703);
        StoryAudioManagerProxy storyAudioManagerProxy = sar;
        if (storyAudioManagerProxy == null) {
            j.avw("instance");
        }
        AppMethodBeat.o(109703);
        return storyAudioManagerProxy;
    }

    static {
        AppMethodBeat.i(109702);
        AppMethodBeat.o(109702);
    }

    public static /* synthetic */ void cacheAudio$default(StoryAudioManagerProxy storyAudioManagerProxy, AudioCacheInfo audioCacheInfo, a.f.a.b bVar, int i, Object obj) {
        AppMethodBeat.i(109693);
        if ((i & 2) != 0) {
            bVar = null;
        }
        storyAudioManagerProxy.cacheAudio(audioCacheInfo, bVar);
        AppMethodBeat.o(109693);
    }

    public final void cacheAudio(AudioCacheInfo audioCacheInfo, a.f.a.b<? super Boolean, y> bVar) {
        AppMethodBeat.i(109692);
        j.p(audioCacheInfo, "info");
        LinkedList linkedList = (LinkedList) this.saq.get(audioCacheInfo.rTW);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.saq.put(audioCacheInfo.rTW, linkedList);
        }
        if (bVar != null) {
            linkedList.add(bVar);
        }
        com.tencent.mm.plugin.story.model.audio.g.a aVar = g.rUG;
        g.rUF.a(audioCacheInfo, new b(this, audioCacheInfo));
        AppMethodBeat.o(109692);
    }

    @e
    public final void cacheAudioCallback(int i, boolean z) {
        AppMethodBeat.i(109694);
        LinkedList<a.f.a.b> linkedList = (LinkedList) this.saq.get(i);
        if (linkedList != null) {
            for (a.f.a.b am : linkedList) {
                am.am(Boolean.valueOf(z));
            }
            AppMethodBeat.o(109694);
            return;
        }
        AppMethodBeat.o(109694);
    }

    @f
    public final void cacheAudioRemote(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.i(109695);
        j.p(audioCacheInfo, "info");
        com.tencent.mm.plugin.story.model.audio.g.a aVar = g.rUG;
        g.rUF.a(audioCacheInfo, new c(this, audioCacheInfo));
        AppMethodBeat.o(109695);
    }

    public final void cancelCache(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.i(109696);
        if (audioCacheInfo != null) {
            this.saq.removeAt(audioCacheInfo.rTW);
            REMOTE_CALL("cancelCacheRemote", audioCacheInfo);
        }
        AppMethodBeat.o(109696);
    }

    @f
    public final void cancelCacheRemote(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.i(109697);
        com.tencent.mm.plugin.story.model.audio.g.a aVar = g.rUG;
        g.rUF.cancelCache(audioCacheInfo);
        AppMethodBeat.o(109697);
    }

    public final void cancelAll() {
        AppMethodBeat.i(109698);
        this.saq.clear();
        REMOTE_CALL("cancelAllRemote", new Object[0]);
        AppMethodBeat.o(109698);
    }

    @f
    public final void cancelAllRemote() {
        AppMethodBeat.i(109699);
        com.tencent.mm.plugin.story.model.audio.g.a aVar = g.rUG;
        g.rUF.cancelAll();
        AppMethodBeat.o(109699);
    }

    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(109700);
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
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    bundle.setClassLoader(AudioCacheInfo.class.getClassLoader());
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if ((j.j(method.getReturnType(), Void.TYPE) ^ 1) != 0) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.o(109700);
                            return;
                        }
                        String str2 = RESULT_KEY;
                        if (invoke == null) {
                            v vVar = new v("null cannot be cast to non-null type java.io.Serializable");
                            AppMethodBeat.o(109700);
                            throw vVar;
                        }
                        bundle.putSerializable(str2, (Serializable) invoke);
                        AppMethodBeat.o(109700);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ab.e(TAG, "exception:%s", bo.l(e));
        }
        AppMethodBeat.o(109700);
    }
}
