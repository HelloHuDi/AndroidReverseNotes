package com.tencent.mm.plugin.story.model.audio;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.h.q;
import com.google.android.exoplayer2.source.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002JL\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010J\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000RN\u0010\u0005\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/story/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cancelAll", "cancelCache", "Companion", "plugin-story_release"})
public final class g {
    private static final g rUF = new g();
    public static final a rUG = new a();
    private final String TAG = "MicroMsg.StoryAudioManager";
    private final Map<Integer, a> rUE = Collections.synchronizedMap(new HashMap());

    @l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static i a(AudioCacheInfo audioCacheInfo, String str) {
            AppMethodBeat.i(109198);
            j.p(audioCacheInfo, "cacheInfo");
            j.p(str, "userAgent");
            i gVar;
            if (audioCacheInfo.aIM) {
                gVar = new com.google.android.exoplayer2.source.g(Uri.parse(audioCacheInfo.cachePath), new q(), new c());
                AppMethodBeat.o(109198);
                return gVar;
            }
            gVar = new com.google.android.exoplayer2.source.g(Uri.parse(audioCacheInfo.musicUrl), new o(str), new c());
            AppMethodBeat.o(109198);
            return gVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    static final class b extends k implements m<Boolean, String, y> {
        final /* synthetic */ m jTs;
        final /* synthetic */ g rUH;
        final /* synthetic */ AudioCacheInfo rUI;

        b(g gVar, AudioCacheInfo audioCacheInfo, m mVar) {
            this.rUH = gVar;
            this.rUI = audioCacheInfo;
            this.jTs = mVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(109199);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str = (String) obj2;
            ab.i(this.rUH.TAG, "cacheAudio callback ".concat(String.valueOf(booleanValue)));
            this.rUH.rUE.remove(Integer.valueOf(this.rUI.rTW));
            m mVar = this.jTs;
            if (mVar != null) {
                mVar.m(Boolean.valueOf(booleanValue), str);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(109199);
            return yVar;
        }
    }

    public g() {
        AppMethodBeat.i(109203);
        AppMethodBeat.o(109203);
    }

    public final void a(AudioCacheInfo audioCacheInfo, m<? super Boolean, ? super String, y> mVar) {
        AppMethodBeat.i(109200);
        j.p(audioCacheInfo, "info");
        ab.i(this.TAG, "cache audio " + audioCacheInfo.rTW);
        a aVar = (a) this.rUE.get(Integer.valueOf(audioCacheInfo.rTW));
        if (aVar != null) {
            aVar.a(mVar);
            AppMethodBeat.o(109200);
        } else if (e.ct(audioCacheInfo.cachePath)) {
            mVar.m(Boolean.TRUE, audioCacheInfo.cachePath);
            AppMethodBeat.o(109200);
        } else {
            a aVar2 = new a(audioCacheInfo);
            aVar2.a(new b(this, audioCacheInfo, mVar));
            aVar2.start();
            Map map = this.rUE;
            j.o(map, "audioTaskMap");
            map.put(Integer.valueOf(audioCacheInfo.rTW), aVar2);
            AppMethodBeat.o(109200);
        }
    }

    public final void cancelCache(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.i(109201);
        if (audioCacheInfo != null) {
            a aVar = (a) this.rUE.remove(Integer.valueOf(audioCacheInfo.rTW));
            if (aVar != null) {
                aVar.cancel();
                AppMethodBeat.o(109201);
                return;
            }
        }
        AppMethodBeat.o(109201);
    }

    public final void cancelAll() {
        AppMethodBeat.i(109202);
        Iterable<a> values = this.rUE.values();
        synchronized (values) {
            try {
                for (a cancel : values) {
                    cancel.cancel();
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109202);
            }
        }
        this.rUE.clear();
    }

    static {
        AppMethodBeat.i(109204);
        AppMethodBeat.o(109204);
    }
}
