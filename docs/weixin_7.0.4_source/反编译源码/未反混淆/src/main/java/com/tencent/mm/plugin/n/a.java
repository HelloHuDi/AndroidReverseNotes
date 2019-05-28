package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

public final class a extends h {
    private AudioTrack aQf;
    private int channels;
    private boolean eif = false;
    private int sampleRate;

    public a(g gVar, ak akVar) {
        super(gVar, akVar);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        AppMethodBeat.i(117856);
        ab.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", aZm(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (d.yG(this.state)) {
            Object obj;
            if (this.aQf == null) {
                ab.i("MicroMsg.AudioTrackDataSource", "%s init audio track", aZm());
                if (this.channels == 0) {
                    this.channels = this.orM.getInteger("channel-count");
                }
                int i2 = this.channels == 1 ? 4 : 12;
                this.aQf = new e(3, getSampleRate(), i2, AudioTrack.getMinBufferSize(getSampleRate(), i2, 2));
                if (this.aQf == null || this.aQf.getState() == 1) {
                    setMute(this.eif);
                    obj = 1;
                } else {
                    ab.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", aZm(), Integer.valueOf(this.aQf.getState()));
                    this.aQf.release();
                    this.aQf = null;
                    obj = null;
                }
                if (obj == null) {
                    AppMethodBeat.o(117856);
                    return false;
                }
            }
            if (d.yB(this.state) && (this.aQf.getPlayState() == 2 || this.aQf.getPlayState() == 1)) {
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
                ab.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", aZm(), Integer.valueOf(i), Long.valueOf(this.orH.orA));
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (Exception e) {
                ab.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", aZm(), e.toString());
            }
            AppMethodBeat.o(117856);
            return true;
        }
        ab.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", aZm(), Integer.valueOf(this.state));
        AppMethodBeat.o(117856);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onStart() {
        AppMethodBeat.i(117857);
        ab.i("MicroMsg.AudioTrackDataSource", "%s on start", aZm());
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.play();
        }
        AppMethodBeat.o(117857);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(117858);
        ab.i("MicroMsg.AudioTrackDataSource", "%s on pause", aZm());
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.pause();
        }
        AppMethodBeat.o(117858);
    }

    public final void release() {
        AppMethodBeat.i(117859);
        try {
            this.aQf.flush();
            this.aQf.release();
        } catch (Exception e) {
        }
        super.release();
        AppMethodBeat.o(117859);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(117860);
        if (this.aQf == null) {
            ab.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", aZm(), Boolean.valueOf(z));
            this.eif = z;
            AppMethodBeat.o(117860);
        } else if (d.fP(21)) {
            ab.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", aZm(), Boolean.valueOf(z));
            if (z) {
                this.aQf.setStereoVolume(0.0f, 0.0f);
                AppMethodBeat.o(117860);
                return;
            }
            this.aQf.setStereoVolume(1.0f, 1.0f);
            AppMethodBeat.o(117860);
        } else {
            ab.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", aZm(), Boolean.valueOf(z));
            iT(z);
            AppMethodBeat.o(117860);
        }
    }

    @TargetApi(21)
    private void iT(boolean z) {
        AppMethodBeat.i(117861);
        if (z) {
            this.aQf.setVolume(0.0f);
            AppMethodBeat.o(117861);
            return;
        }
        this.aQf.setVolume(1.0f);
        AppMethodBeat.o(117861);
    }

    /* Access modifiers changed, original: final */
    public final boolean b(MediaCodec mediaCodec) {
        AppMethodBeat.i(117862);
        ab.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", aZm());
        mediaCodec.configure(this.orM, null, null, 0);
        AppMethodBeat.o(117862);
        return false;
    }

    private int getSampleRate() {
        AppMethodBeat.i(117863);
        if (this.sampleRate == 0) {
            this.sampleRate = this.orM.getInteger("sample-rate");
        }
        int i = this.sampleRate;
        AppMethodBeat.o(117863);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(MediaCodec mediaCodec) {
        AppMethodBeat.i(117864);
        ab.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", aZm());
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
        AppMethodBeat.o(117864);
    }

    /* Access modifiers changed, original: final */
    public final String type() {
        return SlookAirButtonRecentMediaAdapter.AUDIO_TYPE;
    }
}
