package com.tencent.mm.plugin.story.model.audio;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\u0017\u001a\u00020\u000f2<\b\u0002\u0010\u0018\u001a6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000Rû\u0001\u0010\u0007\u001aî\u0001\u0012p\u0012n\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f \u0010*6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0\t \u0010*v\u0012p\u0012n\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f \u0010*6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0\t\u0018\u00010\u00110\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/AudioDownloadTask;", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "notifyCallbacks", "start", "plugin-story_release"})
public final class a {
    final String TAG = "MicroMsg.AudioDownloadTask";
    private final String cHr;
    private final List<m<Boolean, String, y>> callbacks = Collections.synchronizedList(new ArrayList());
    private final g rUk;
    private final AudioCacheInfo rUl;

    public a(AudioCacheInfo audioCacheInfo) {
        j.p(audioCacheInfo, "info");
        AppMethodBeat.i(109184);
        this.rUl = audioCacheInfo;
        final String str = this.rUl.cachePath + "_temp";
        final String str2 = this.rUl.cachePath;
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        com.tencent.mm.plugin.story.model.l.aax(str);
        if (str2 != null) {
            lVar = com.tencent.mm.plugin.story.model.l.rTg;
            com.tencent.mm.plugin.story.model.l.aax(str2);
        }
        this.cHr = "downaudio_" + this.rUl.rTW;
        this.rUk = new g();
        this.rUk.egn = 60;
        this.rUk.ego = 60;
        this.rUk.field_mediaId = this.cHr;
        this.rUk.egm = this.rUl.musicUrl;
        this.rUk.field_fileType = CdnLogic.kMediaTypeStoryAudio;
        this.rUk.field_fullpath = str;
        this.rUk.egl = new com.tencent.mm.i.g.a(this) {
            final /* synthetic */ a rUm;

            /* JADX WARNING: Missing block: B:3:0x0028, code skipped:
            if (r0 == null) goto L_0x002a;
     */
            /* JADX WARNING: Missing block: B:8:0x0036, code skipped:
            if (r0 == null) goto L_0x0038;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                String cVar2;
                AppMethodBeat.i(109177);
                j.p(str, "mediaId");
                String str2 = this.rUm.TAG;
                String str3 = "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (cVar != null) {
                    cVar2 = cVar.toString();
                }
                cVar2 = BuildConfig.COMMAND;
                objArr[2] = cVar2;
                if (dVar != null) {
                    cVar2 = dVar.toString();
                }
                cVar2 = BuildConfig.COMMAND;
                objArr[3] = cVar2;
                ab.d(str2, str3, objArr);
                if (dVar != null) {
                    if (dVar.field_retCode == 0) {
                        ab.i(this.rUm.TAG, "download success " + str + ' ' + str2);
                        e.aQ(str, str2);
                        a.a(this.rUm, true, str2);
                    } else {
                        ab.w(this.rUm.TAG, "download fail sceneResult " + dVar.field_retCode);
                        a.a(this.rUm, false, null);
                    }
                } else if (i != 0) {
                    ab.w(this.rUm.TAG, "download fail startRet ".concat(String.valueOf(i)));
                    a.a(this.rUm, false, null);
                }
                AppMethodBeat.o(109177);
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(109178);
                j.p(str, "mediaId");
                j.p(byteArrayOutputStream, "buff");
                AppMethodBeat.o(109178);
            }

            public final byte[] l(String str, byte[] bArr) {
                AppMethodBeat.i(109179);
                j.p(str, "mediaId");
                j.p(bArr, "inbuf");
                byte[] bArr2 = new byte[0];
                AppMethodBeat.o(109179);
                return bArr2;
            }
        };
        AppMethodBeat.o(109184);
    }

    public static final /* synthetic */ void a(a aVar, boolean z, String str) {
        AppMethodBeat.i(109185);
        aVar.s(z, str);
        AppMethodBeat.o(109185);
    }

    public final void start() {
        AppMethodBeat.i(109180);
        if (!f.afx().d(this.rUk)) {
            s(false, null);
        }
        AppMethodBeat.o(109180);
    }

    public final void a(m<? super Boolean, ? super String, y> mVar) {
        AppMethodBeat.i(109181);
        if (mVar != null) {
            this.callbacks.add(mVar);
        }
        AppMethodBeat.o(109181);
    }

    public final void cancel() {
        AppMethodBeat.i(109182);
        ab.i(this.TAG, "cancel " + this.cHr);
        f.afx().rO(this.cHr);
        this.callbacks.clear();
        AppMethodBeat.o(109182);
    }

    private final void s(boolean z, String str) {
        AppMethodBeat.i(109183);
        List list = this.callbacks;
        j.o(list, "callbacks");
        Iterable<m> iterable = list;
        synchronized (iterable) {
            try {
                for (m m : iterable) {
                    m.m(Boolean.valueOf(z), str);
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(109183);
            }
        }
        this.callbacks.clear();
    }
}
