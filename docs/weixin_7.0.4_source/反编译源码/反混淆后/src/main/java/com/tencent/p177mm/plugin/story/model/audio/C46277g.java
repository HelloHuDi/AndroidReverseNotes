package com.tencent.p177mm.plugin.story.model.audio;

import android.net.Uri;
import com.google.android.exoplayer2.p101c.C45022c;
import com.google.android.exoplayer2.p110h.C25541o;
import com.google.android.exoplayer2.p110h.C32057q;
import com.google.android.exoplayer2.source.C45052i;
import com.google.android.exoplayer2.source.C46871g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002JL\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2<\b\u0002\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010J\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000RN\u0010\u0005\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/story/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cancelAll", "cancelCache", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.audio.g */
public final class C46277g {
    private static final C46277g rUF = new C46277g();
    public static final C4125a rUG = new C4125a();
    private final String TAG = "MicroMsg.StoryAudioManager";
    private final Map<Integer, C39888a> rUE = Collections.synchronizedMap(new HashMap());

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/story/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.audio.g$a */
    public static final class C4125a {
        private C4125a() {
        }

        public /* synthetic */ C4125a(byte b) {
            this();
        }

        /* renamed from: a */
        public static C45052i m6450a(AudioCacheInfo audioCacheInfo, String str) {
            AppMethodBeat.m2504i(109198);
            C25052j.m39376p(audioCacheInfo, "cacheInfo");
            C25052j.m39376p(str, "userAgent");
            C45052i c46871g;
            if (audioCacheInfo.aIM) {
                c46871g = new C46871g(Uri.parse(audioCacheInfo.cachePath), new C32057q(), new C45022c());
                AppMethodBeat.m2505o(109198);
                return c46871g;
            }
            c46871g = new C46871g(Uri.parse(audioCacheInfo.musicUrl), new C25541o(str), new C45022c());
            AppMethodBeat.m2505o(109198);
            return c46871g;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "filePath", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.audio.g$b */
    static final class C31430b extends C25053k implements C31591m<Boolean, String, C37091y> {
        final /* synthetic */ C31591m jTs;
        final /* synthetic */ C46277g rUH;
        final /* synthetic */ AudioCacheInfo rUI;

        C31430b(C46277g c46277g, AudioCacheInfo audioCacheInfo, C31591m c31591m) {
            this.rUH = c46277g;
            this.rUI = audioCacheInfo;
            this.jTs = c31591m;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(109199);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str = (String) obj2;
            C4990ab.m7416i(this.rUH.TAG, "cacheAudio callback ".concat(String.valueOf(booleanValue)));
            this.rUH.rUE.remove(Integer.valueOf(this.rUI.rTW));
            C31591m c31591m = this.jTs;
            if (c31591m != null) {
                c31591m.mo212m(Boolean.valueOf(booleanValue), str);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(109199);
            return c37091y;
        }
    }

    public C46277g() {
        AppMethodBeat.m2504i(109203);
        AppMethodBeat.m2505o(109203);
    }

    /* renamed from: a */
    public final void mo74419a(AudioCacheInfo audioCacheInfo, C31591m<? super Boolean, ? super String, C37091y> c31591m) {
        AppMethodBeat.m2504i(109200);
        C25052j.m39376p(audioCacheInfo, "info");
        C4990ab.m7416i(this.TAG, "cache audio " + audioCacheInfo.rTW);
        C39888a c39888a = (C39888a) this.rUE.get(Integer.valueOf(audioCacheInfo.rTW));
        if (c39888a != null) {
            c39888a.mo63096a(c31591m);
            AppMethodBeat.m2505o(109200);
        } else if (C5730e.m8628ct(audioCacheInfo.cachePath)) {
            c31591m.mo212m(Boolean.TRUE, audioCacheInfo.cachePath);
            AppMethodBeat.m2505o(109200);
        } else {
            C39888a c39888a2 = new C39888a(audioCacheInfo);
            c39888a2.mo63096a(new C31430b(this, audioCacheInfo, c31591m));
            c39888a2.start();
            Map map = this.rUE;
            C25052j.m39375o(map, "audioTaskMap");
            map.put(Integer.valueOf(audioCacheInfo.rTW), c39888a2);
            AppMethodBeat.m2505o(109200);
        }
    }

    public final void cancelCache(AudioCacheInfo audioCacheInfo) {
        AppMethodBeat.m2504i(109201);
        if (audioCacheInfo != null) {
            C39888a c39888a = (C39888a) this.rUE.remove(Integer.valueOf(audioCacheInfo.rTW));
            if (c39888a != null) {
                c39888a.cancel();
                AppMethodBeat.m2505o(109201);
                return;
            }
        }
        AppMethodBeat.m2505o(109201);
    }

    public final void cancelAll() {
        AppMethodBeat.m2504i(109202);
        Iterable<C39888a> values = this.rUE.values();
        synchronized (values) {
            try {
                for (C39888a cancel : values) {
                    cancel.cancel();
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109202);
            }
        }
        this.rUE.clear();
    }

    static {
        AppMethodBeat.m2504i(109204);
        AppMethodBeat.m2505o(109204);
    }
}
