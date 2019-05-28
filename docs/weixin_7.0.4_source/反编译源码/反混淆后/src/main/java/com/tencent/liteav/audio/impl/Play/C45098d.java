package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.C32136a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.tencent.liteav.audio.impl.Play.d */
public class C45098d {
    /* renamed from: a */
    static C45098d f17726a = new C45098d();
    /* renamed from: b */
    private static final String f17727b = ("AudioCenter:" + C45098d.class.getSimpleName());
    /* renamed from: c */
    private C17766a f17728c;
    /* renamed from: d */
    private boolean f17729d = false;
    /* renamed from: e */
    private volatile boolean f17730e = false;
    /* renamed from: f */
    private Context f17731f = null;
    /* renamed from: g */
    private int f17732g = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
    /* renamed from: h */
    private volatile boolean f17733h = false;
    /* renamed from: i */
    private int f17734i = C41678a.f16923e;
    /* renamed from: j */
    private int f17735j = C41678a.f16925g;
    /* renamed from: k */
    private int f17736k = C41678a.f16926h;

    /* renamed from: com.tencent.liteav.audio.impl.Play.d$a */
    class C17766a extends Thread {
        /* renamed from: b */
        volatile boolean f4072b = false;

        public C17766a(String str) {
            super(str);
        }

        /* renamed from: a */
        public void mo32864a() {
            this.f4072b = true;
        }

        /* renamed from: b */
        public void mo32865b() {
            this.f4072b = false;
        }
    }

    static {
        AppMethodBeat.m2504i(66627);
        AppMethodBeat.m2505o(66627);
    }

    private C45098d() {
    }

    /* renamed from: a */
    public static C45098d m82718a() {
        return f17726a;
    }

    /* renamed from: b */
    public void mo72862b() {
        AppMethodBeat.m2504i(66624);
        TXCLog.m15679w(f17727b, "mult-track-player start!");
        if (this.f17730e) {
            TXCLog.m15676e(f17727b, "mult-track-player can not start because of has started!");
            AppMethodBeat.m2505o(66624);
        } else if (this.f17734i == 0 || this.f17735j == 0) {
            TXCLog.m15676e(f17727b, "strat mult-track-player failed with invalid audio info , samplerate:" + this.f17734i + ", channels:" + this.f17735j);
            AppMethodBeat.m2505o(66624);
        } else {
            this.f17730e = true;
            if (this.f17728c == null) {
                this.f17728c = new C17766a("AUDIO_TRACK") {
                    public void run() {
                        int i = 3;
                        AppMethodBeat.m2504i(66635);
                        mo32864a();
                        try {
                            int i2;
                            if (C45098d.this.f17735j == 1) {
                                i2 = 2;
                            } else {
                                i2 = 3;
                            }
                            if (C45098d.this.f17736k != 8) {
                                i = 2;
                            }
                            AudioTrack audioTrack = new AudioTrack(3, C45098d.this.f17734i, i2, i, AudioTrack.getMinBufferSize(C45098d.this.f17734i, i2, i), 1);
                            TXCLog.m15677i(C45098d.f17727b, "create audio track, samplerate:" + C45098d.this.f17734i + ", channels:" + C45098d.this.f17735j + ", bits:" + C45098d.this.f17736k);
                            try {
                                audioTrack.play();
                                C45098d.this.f17733h = true;
                                C45098d.this.mo72861a(C45098d.this.f17731f, C45098d.this.f17732g);
                                int i3 = 100;
                                int i4 = 0;
                                while (this.f4072b) {
                                    byte[] nativeGetMixedTracksData = TXCAudioBasePlayController.nativeGetMixedTracksData(C45098d.this.f17735j * 2048);
                                    if (nativeGetMixedTracksData == null || nativeGetMixedTracksData.length <= 0) {
                                        try {
                                            C373481.sleep(5);
                                        } catch (InterruptedException e) {
                                        }
                                    } else {
                                        if (C45098d.this.f17729d) {
                                            Arrays.fill(nativeGetMixedTracksData, (byte) 0);
                                        }
                                        if (i3 != 0 && i4 < 800) {
                                            short[] sArr = new short[(nativeGetMixedTracksData.length / 2)];
                                            ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                                            for (i2 = 0; i2 < sArr.length; i2++) {
                                                sArr[i2] = (short) (sArr[i2] / i3);
                                            }
                                            ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
                                            i4 += nativeGetMixedTracksData.length / ((C45098d.this.f17734i * 2) / 1000);
                                            i3 = (i3 * (800 - i4)) / 800;
                                        }
                                        audioTrack.write(nativeGetMixedTracksData, 0, nativeGetMixedTracksData.length);
                                    }
                                }
                                try {
                                    audioTrack.pause();
                                    audioTrack.flush();
                                    audioTrack.stop();
                                    audioTrack.release();
                                } catch (Exception e2) {
                                }
                                TXCLog.m15676e(C45098d.f17727b, "mult-player thread stop finish!");
                                AppMethodBeat.m2505o(66635);
                            } catch (Exception e3) {
                                AppMethodBeat.m2505o(66635);
                            }
                        } catch (Exception e4) {
                            AppMethodBeat.m2505o(66635);
                        }
                    }
                };
                this.f17728c.start();
            }
            TXCLog.m15679w(f17727b, "mult-track-player thread start finish!");
            AppMethodBeat.m2505o(66624);
        }
    }

    /* renamed from: c */
    public void mo72863c() {
        AppMethodBeat.m2504i(66625);
        TXCLog.m15679w(f17727b, "mult-track-player stop!");
        if (this.f17730e) {
            if (this.f17728c != null) {
                this.f17728c.mo32865b();
                this.f17728c = null;
            }
            this.f17732g = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
            this.f17731f = null;
            this.f17733h = false;
            this.f17730e = false;
            TXCLog.m15679w(f17727b, "mult-track-player stop finish!");
            AppMethodBeat.m2505o(66625);
            return;
        }
        TXCLog.m15679w(f17727b, "mult-track-player can not stop because of not started yet!");
        AppMethodBeat.m2505o(66625);
    }

    /* renamed from: a */
    public synchronized void mo72861a(Context context, int i) {
        AppMethodBeat.m2504i(66626);
        this.f17731f = context;
        this.f17732g = i;
        if (this.f17733h) {
            C32136a.m52261a().mo52716a(i);
        }
        AppMethodBeat.m2505o(66626);
    }

    /* renamed from: d */
    public boolean mo72864d() {
        return this.f17730e;
    }
}
