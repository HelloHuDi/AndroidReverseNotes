package com.tencent.p177mm.plugin.p468n;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C18171e;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.n.a */
public final class C39452a extends C12693h {
    private AudioTrack aQf;
    private int channels;
    private boolean eif = false;
    private int sampleRate;

    public C39452a(C3546g c3546g, C7306ak c7306ak) {
        super(c3546g, c7306ak);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo24680a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(117856);
        C4990ab.m7411d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", aZm(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (C46107d.m86025yG(this.state)) {
            Object obj;
            if (this.aQf == null) {
                C4990ab.m7417i("MicroMsg.AudioTrackDataSource", "%s init audio track", aZm());
                if (this.channels == 0) {
                    this.channels = this.orM.getInteger("channel-count");
                }
                int i2 = this.channels == 1 ? 4 : 12;
                this.aQf = new C18171e(3, getSampleRate(), i2, AudioTrack.getMinBufferSize(getSampleRate(), i2, 2));
                if (this.aQf == null || this.aQf.getState() == 1) {
                    setMute(this.eif);
                    obj = 1;
                } else {
                    C4990ab.m7421w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", aZm(), Integer.valueOf(this.aQf.getState()));
                    this.aQf.release();
                    this.aQf = null;
                    obj = null;
                }
                if (obj == null) {
                    AppMethodBeat.m2505o(117856);
                    return false;
                }
            }
            if (C46107d.m86020yB(this.state) && (this.aQf.getPlayState() == 2 || this.aQf.getPlayState() == 1)) {
                onStart();
            }
            if (this.state == 4) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && this.aQf.getPlayState() == 3) {
                onPause();
            }
            try {
                this.orH.orA = bufferInfo.presentationTimeUs;
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer.get(bArr);
                byteBuffer.clear();
                if (bArr.length > 0) {
                    this.aQf.write(bArr, 0, bArr.length);
                }
                C4990ab.m7411d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", aZm(), Integer.valueOf(i), Long.valueOf(this.orH.orA));
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", aZm(), e.toString());
            }
            AppMethodBeat.m2505o(117856);
            return true;
        }
        C4990ab.m7417i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", aZm(), Integer.valueOf(this.state));
        AppMethodBeat.m2505o(117856);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onStart() {
        AppMethodBeat.m2504i(117857);
        C4990ab.m7417i("MicroMsg.AudioTrackDataSource", "%s on start", aZm());
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.play();
        }
        AppMethodBeat.m2505o(117857);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(117858);
        C4990ab.m7417i("MicroMsg.AudioTrackDataSource", "%s on pause", aZm());
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.pause();
        }
        AppMethodBeat.m2505o(117858);
    }

    public final void release() {
        AppMethodBeat.m2504i(117859);
        try {
            this.aQf.flush();
            this.aQf.release();
        } catch (Exception e) {
        }
        super.release();
        AppMethodBeat.m2505o(117859);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(117860);
        if (this.aQf == null) {
            C4990ab.m7421w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", aZm(), Boolean.valueOf(z));
            this.eif = z;
            AppMethodBeat.m2505o(117860);
        } else if (C1443d.m3067fP(21)) {
            C4990ab.m7411d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", aZm(), Boolean.valueOf(z));
            if (z) {
                this.aQf.setStereoVolume(0.0f, 0.0f);
                AppMethodBeat.m2505o(117860);
                return;
            }
            this.aQf.setStereoVolume(1.0f, 1.0f);
            AppMethodBeat.m2505o(117860);
        } else {
            C4990ab.m7411d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", aZm(), Boolean.valueOf(z));
            m67416iT(z);
            AppMethodBeat.m2505o(117860);
        }
    }

    @TargetApi(21)
    /* renamed from: iT */
    private void m67416iT(boolean z) {
        AppMethodBeat.m2504i(117861);
        if (z) {
            this.aQf.setVolume(0.0f);
            AppMethodBeat.m2505o(117861);
            return;
        }
        this.aQf.setVolume(1.0f);
        AppMethodBeat.m2505o(117861);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo24683b(MediaCodec mediaCodec) {
        AppMethodBeat.m2504i(117862);
        C4990ab.m7417i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", aZm());
        mediaCodec.configure(this.orM, null, null, 0);
        AppMethodBeat.m2505o(117862);
        return false;
    }

    private int getSampleRate() {
        AppMethodBeat.m2504i(117863);
        if (this.sampleRate == 0) {
            this.sampleRate = this.orM.getInteger("sample-rate");
        }
        int i = this.sampleRate;
        AppMethodBeat.m2505o(117863);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo24686c(MediaCodec mediaCodec) {
        AppMethodBeat.m2504i(117864);
        C4990ab.m7417i("MicroMsg.AudioTrackDataSource", "%s on output format changed", aZm());
        this.sampleRate = 0;
        this.channels = 0;
        if (this.aQf != null) {
            try {
                this.aQf.flush();
                this.aQf.release();
            } catch (Exception e) {
            }
        }
        this.aQf = null;
        AppMethodBeat.m2505o(117864);
    }

    /* Access modifiers changed, original: final */
    public final String type() {
        return SlookAirButtonRecentMediaAdapter.AUDIO_TYPE;
    }
}
