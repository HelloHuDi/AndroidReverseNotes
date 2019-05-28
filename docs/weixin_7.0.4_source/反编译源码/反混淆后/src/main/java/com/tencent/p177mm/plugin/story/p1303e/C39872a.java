package com.tencent.p177mm.plugin.story.p1303e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.audio.AudioCacheInfo;
import java.io.Serializable;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020*R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "recordThumb", "", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.e.a */
public final class C39872a implements Serializable {
    public int eXL;
    public String fbT = "";
    public String fbU = "";
    public boolean fbV;
    public long rRG;
    public long rRH;
    public int rRI;
    public AudioCacheInfo rRJ;

    public final void aad(String str) {
        AppMethodBeat.m2504i(108986);
        C25052j.m39376p(str, "<set-?>");
        this.fbT = str;
        AppMethodBeat.m2505o(108986);
    }

    public final void aae(String str) {
        AppMethodBeat.m2504i(108987);
        C25052j.m39376p(str, "<set-?>");
        this.fbU = str;
        AppMethodBeat.m2505o(108987);
    }

    public final void reset() {
        this.rRI = 0;
        this.rRJ = null;
        this.fbT = "";
        this.fbU = "";
        this.rRG = 0;
        this.rRH = 0;
        this.eXL = 0;
        this.fbV = false;
    }
}
