package com.tencent.p177mm.media.widget.p257b;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C21294h;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.smtt.sdk.TbsReaderView;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/media/widget/recorder/AACMediaCodecBufIdRecorder;", "Lcom/tencent/mm/plugin/mmsight/model/encode/MMSightAACMediaCodecRecorder;", "sampleRate", "", "bitrate", "(II)V", "TAG", "", "bufId", "init", "bufferId", "tempPath", "isIgnoreCodecConfig", "", "processOutputBuffer", "", "outputBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "plugin-mediaeditor_release"})
@TargetApi(16)
/* renamed from: com.tencent.mm.media.widget.b.a */
public final class C9612a extends C21294h {
    private final String TAG = "MicroMsg.MMSightAACMediaCodecBufIdRecorder";
    private int eTa = -1;

    public C9612a(int i, int i2) {
        super(i, i2);
    }

    /* renamed from: q */
    public final int mo20926q(int i, String str) {
        AppMethodBeat.m2504i(13315);
        C25052j.m39376p(str, TbsReaderView.KEY_TEMP_PATH);
        Log.m81045d(this.TAG, "bufferId:" + i + " ,tempPath:" + str);
        this.eTa = i;
        int q = super.mo20926q(i, str);
        AppMethodBeat.m2505o(13315);
        return q;
    }

    /* renamed from: g */
    public final void mo20925g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(13316);
        if (!(this.eTa < 0 || byteBuffer == null || bufferInfo == null || this.ovY)) {
            Log.m81045d(this.TAG, "writeAACData  ,bufferInfo.size : " + bufferInfo.size);
            SightVideoJNI.writeAACDataLock(this.eTa, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.m2505o(13316);
    }

    /* renamed from: WF */
    public final boolean mo20924WF() {
        return true;
    }
}
