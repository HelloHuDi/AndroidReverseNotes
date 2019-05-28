package com.tencent.p177mm.plugin.story.model.audio;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\u0017\u001a\u00020\u000f2<\b\u0002\u0010\u0018\u001a6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000Rû\u0001\u0010\u0007\u001aî\u0001\u0012p\u0012n\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f \u0010*6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0\t \u0010*v\u0012p\u0012n\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f \u0010*6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0\t\u0018\u00010\u00110\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/AudioDownloadTask;", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "notifyCallbacks", "start", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.audio.a */
public final class C39888a {
    final String TAG = "MicroMsg.AudioDownloadTask";
    private final String cHr;
    private final List<C31591m<Boolean, String, C37091y>> callbacks = Collections.synchronizedList(new ArrayList());
    private final C42130g rUk;
    private final AudioCacheInfo rUl;

    public C39888a(AudioCacheInfo audioCacheInfo) {
        C25052j.m39376p(audioCacheInfo, "info");
        AppMethodBeat.m2504i(109184);
        this.rUl = audioCacheInfo;
        final String str = this.rUl.cachePath + "_temp";
        final String str2 = this.rUl.cachePath;
        C29309l c29309l = C29309l.rTg;
        C29309l.aax(str);
        if (str2 != null) {
            c29309l = C29309l.rTg;
            C29309l.aax(str2);
        }
        this.cHr = "downaudio_" + this.rUl.rTW;
        this.rUk = new C42130g();
        this.rUk.egn = 60;
        this.rUk.ego = 60;
        this.rUk.field_mediaId = this.cHr;
        this.rUk.egm = this.rUl.musicUrl;
        this.rUk.field_fileType = CdnLogic.kMediaTypeStoryAudio;
        this.rUk.field_fullpath = str;
        this.rUk.egl = new C1628a(this) {
            final /* synthetic */ C39888a rUm;

            /* JADX WARNING: Missing block: B:3:0x0028, code skipped:
            if (r0 == null) goto L_0x002a;
     */
            /* JADX WARNING: Missing block: B:8:0x0036, code skipped:
            if (r0 == null) goto L_0x0038;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                String c18496c2;
                AppMethodBeat.m2504i(109177);
                C25052j.m39376p(str, "mediaId");
                String str2 = this.rUm.TAG;
                String str3 = "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (c18496c != null) {
                    c18496c2 = c18496c.toString();
                }
                c18496c2 = BuildConfig.COMMAND;
                objArr[2] = c18496c2;
                if (c9545d != null) {
                    c18496c2 = c9545d.toString();
                }
                c18496c2 = BuildConfig.COMMAND;
                objArr[3] = c18496c2;
                C4990ab.m7411d(str2, str3, objArr);
                if (c9545d != null) {
                    if (c9545d.field_retCode == 0) {
                        C4990ab.m7416i(this.rUm.TAG, "download success " + str + ' ' + str2);
                        C5730e.m8623aQ(str, str2);
                        C39888a.m68313a(this.rUm, true, str2);
                    } else {
                        C4990ab.m7420w(this.rUm.TAG, "download fail sceneResult " + c9545d.field_retCode);
                        C39888a.m68313a(this.rUm, false, null);
                    }
                } else if (i != 0) {
                    C4990ab.m7420w(this.rUm.TAG, "download fail startRet ".concat(String.valueOf(i)));
                    C39888a.m68313a(this.rUm, false, null);
                }
                AppMethodBeat.m2505o(109177);
                return 0;
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.m2504i(109178);
                C25052j.m39376p(str, "mediaId");
                C25052j.m39376p(byteArrayOutputStream, "buff");
                AppMethodBeat.m2505o(109178);
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                AppMethodBeat.m2504i(109179);
                C25052j.m39376p(str, "mediaId");
                C25052j.m39376p(bArr, "inbuf");
                byte[] bArr2 = new byte[0];
                AppMethodBeat.m2505o(109179);
                return bArr2;
            }
        };
        AppMethodBeat.m2505o(109184);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m68313a(C39888a c39888a, boolean z, String str) {
        AppMethodBeat.m2504i(109185);
        c39888a.m68314s(z, str);
        AppMethodBeat.m2505o(109185);
    }

    public final void start() {
        AppMethodBeat.m2504i(109180);
        if (!C37461f.afx().mo51224d(this.rUk)) {
            m68314s(false, null);
        }
        AppMethodBeat.m2505o(109180);
    }

    /* renamed from: a */
    public final void mo63096a(C31591m<? super Boolean, ? super String, C37091y> c31591m) {
        AppMethodBeat.m2504i(109181);
        if (c31591m != null) {
            this.callbacks.add(c31591m);
        }
        AppMethodBeat.m2505o(109181);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(109182);
        C4990ab.m7416i(this.TAG, "cancel " + this.cHr);
        C37461f.afx().mo51228rO(this.cHr);
        this.callbacks.clear();
        AppMethodBeat.m2505o(109182);
    }

    /* renamed from: s */
    private final void m68314s(boolean z, String str) {
        AppMethodBeat.m2504i(109183);
        List list = this.callbacks;
        C25052j.m39375o(list, "callbacks");
        Iterable<C31591m> iterable = list;
        synchronized (iterable) {
            try {
                for (C31591m m : iterable) {
                    m.mo212m(Boolean.valueOf(z), str);
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(109183);
            }
        }
        this.callbacks.clear();
    }
}
