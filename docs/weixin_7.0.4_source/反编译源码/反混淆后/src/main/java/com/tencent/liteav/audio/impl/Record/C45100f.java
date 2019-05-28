package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.liteav.audio.impl.Record.f */
public class C45100f implements Runnable {
    /* renamed from: a */
    private static final String f17742a = ("AudioCenter:" + C45100f.class.getSimpleName());
    /* renamed from: b */
    private static C45100f f17743b = null;
    /* renamed from: c */
    private Context f17744c;
    /* renamed from: d */
    private int f17745d = TXRecordCommon.AUDIO_SAMPLERATE_48000;
    /* renamed from: e */
    private int f17746e = 1;
    /* renamed from: f */
    private int f17747f = 16;
    /* renamed from: g */
    private int f17748g = TXEAudioDef.TXE_AEC_NONE;
    /* renamed from: h */
    private AudioRecord f17749h;
    /* renamed from: i */
    private byte[] f17750i = null;
    /* renamed from: j */
    private WeakReference<C0945h> f17751j;
    /* renamed from: k */
    private Thread f17752k = null;
    /* renamed from: l */
    private boolean f17753l = false;

    static {
        AppMethodBeat.m2504i(66662);
        AppMethodBeat.m2505o(66662);
    }

    /* renamed from: a */
    public static C45100f m82736a() {
        AppMethodBeat.m2504i(66651);
        if (f17743b == null) {
            synchronized (C45100f.class) {
                try {
                    if (f17743b == null) {
                        f17743b = new C45100f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(66651);
                    }
                }
            }
        }
        C45100f c45100f = f17743b;
        AppMethodBeat.m2505o(66651);
        return c45100f;
    }

    private C45100f() {
    }

    /* renamed from: a */
    public synchronized void mo72870a(C0945h c0945h) {
        AppMethodBeat.m2504i(66652);
        if (c0945h == null) {
            this.f17751j = null;
            AppMethodBeat.m2505o(66652);
        } else {
            this.f17751j = new WeakReference(c0945h);
            AppMethodBeat.m2505o(66652);
        }
    }

    /* renamed from: a */
    public void mo72869a(Context context, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(66653);
        mo72871b();
        this.f17744c = context;
        this.f17745d = i;
        this.f17746e = i2;
        this.f17747f = i3;
        this.f17748g = i4;
        this.f17753l = true;
        this.f17752k = new Thread(this, "AudioSysRecord Thread");
        this.f17752k.start();
        AppMethodBeat.m2505o(66653);
    }

    /* renamed from: b */
    public void mo72871b() {
        AppMethodBeat.m2504i(66654);
        this.f17753l = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.f17752k == null || !this.f17752k.isAlive() || Thread.currentThread().getId() == this.f17752k.getId())) {
            try {
                this.f17752k.join();
            } catch (Exception e) {
                TXCLog.m15676e(f17742a, "record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.m15677i(f17742a, "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.f17752k = null;
        AppMethodBeat.m2505o(66654);
    }

    /* renamed from: c */
    public synchronized boolean mo72872c() {
        return this.f17753l;
    }

    /* renamed from: d */
    private void m82739d() {
        int i;
        AppMethodBeat.m2504i(66655);
        int i2 = this.f17745d;
        int i3 = this.f17746e;
        int i4 = this.f17747f;
        int i5 = this.f17748g;
        TXCLog.m15677i(f17742a, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}));
        int i6 = 12;
        if (i3 == 1) {
            i6 = 16;
        }
        if (i4 == 8) {
            i = 3;
        } else {
            i = 2;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(i2, i6, i);
        try {
            if (i5 == TXEAudioDef.TXE_AEC_SYSTEM) {
                TXCLog.m15677i(f17742a, "audio record type: system aec");
                if (this.f17744c != null) {
                    ((AudioManager) this.f17744c.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(3);
                }
                this.f17749h = new AudioRecord(7, i2, i6, i, minBufferSize * 2);
                if (this.f17744c != null) {
                    ((AudioManager) this.f17744c.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
                }
            } else {
                TXCLog.m15677i(f17742a, "audio record type: system normal");
                this.f17749h = new AudioRecord(1, i2, i6, i, minBufferSize * 2);
            }
        } catch (IllegalArgumentException e) {
        }
        if (this.f17749h == null || this.f17749h.getState() != 1) {
            TXCLog.m15676e(f17742a, "audio record: initialize the mic failed.");
            m82740e();
            m82737a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "open mic failed!");
            AppMethodBeat.m2505o(66655);
            return;
        }
        i5 = ((i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * i4) / 8;
        if (i5 > minBufferSize) {
            this.f17750i = new byte[minBufferSize];
        } else {
            this.f17750i = new byte[i5];
        }
        TXCLog.m15677i(f17742a, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(this.f17750i.length), Integer.valueOf(this.f17749h.getState())}));
        if (this.f17749h != null) {
            try {
                this.f17749h.startRecording();
                AppMethodBeat.m2505o(66655);
                return;
            } catch (Exception e2) {
                TXCLog.m15676e(f17742a, "mic startRecording failed.");
                m82737a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "start recording failed!");
                AppMethodBeat.m2505o(66655);
                return;
            }
        }
        AppMethodBeat.m2505o(66655);
    }

    /* renamed from: e */
    private void m82740e() {
        AppMethodBeat.m2504i(66656);
        if (this.f17749h != null) {
            TXCLog.m15677i(f17742a, "stop mic");
            try {
                this.f17749h.setRecordPositionUpdateListener(null);
                this.f17749h.stop();
                this.f17749h.release();
            } catch (Exception e) {
            }
        }
        this.f17749h = null;
        this.f17750i = null;
        AppMethodBeat.m2505o(66656);
    }

    /* renamed from: a */
    private void m82738a(byte[] bArr, int i, long j) {
        AppMethodBeat.m2504i(66657);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f17751j != null) {
                    c0945h = (C0945h) this.f17751j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66657);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordPCM(bArr, i, j);
            return;
        }
        TXCLog.m15676e(f17742a, "onRecordPcmData:no callback");
        AppMethodBeat.m2505o(66657);
    }

    /* renamed from: a */
    private void m82737a(int i, String str) {
        AppMethodBeat.m2504i(66658);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f17751j != null) {
                    c0945h = (C0945h) this.f17751j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66658);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordError(i, str);
            return;
        }
        TXCLog.m15676e(f17742a, "onRecordError:no callback");
        AppMethodBeat.m2505o(66658);
    }

    /* renamed from: f */
    private void m82741f() {
        AppMethodBeat.m2504i(66659);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f17751j != null) {
                    c0945h = (C0945h) this.f17751j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66659);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordStart();
            return;
        }
        TXCLog.m15676e(f17742a, "onRecordStart:no callback");
        AppMethodBeat.m2505o(66659);
    }

    /* renamed from: g */
    private void m82742g() {
        AppMethodBeat.m2504i(66660);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f17751j != null) {
                    c0945h = (C0945h) this.f17751j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66660);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordStop();
            return;
        }
        TXCLog.m15676e(f17742a, "onRecordStop:no callback");
        AppMethodBeat.m2505o(66660);
    }

    public void run() {
        AppMethodBeat.m2504i(66661);
        if (this.f17753l) {
            m82741f();
            m82739d();
            int i = 0;
            int i2 = 0;
            while (this.f17753l && !Thread.interrupted() && this.f17749h != null && i2 <= 5) {
                System.currentTimeMillis();
                int read = this.f17749h.read(this.f17750i, i, this.f17750i.length - i);
                if (read == this.f17750i.length - i) {
                    m82738a(this.f17750i, this.f17750i.length, TXCTimeUtil.getTimeTick());
                    i = 0;
                    i2 = 0;
                } else if (read <= 0) {
                    TXCLog.m15676e(f17742a, "read pcm eror, len =".concat(String.valueOf(read)));
                    i2++;
                } else {
                    i += read;
                }
            }
            m82740e();
            if (i2 > 5) {
                m82737a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "read data failed!");
                AppMethodBeat.m2505o(66661);
                return;
            }
            m82742g();
            AppMethodBeat.m2505o(66661);
            return;
        }
        TXCLog.m15679w(f17742a, "audio record: abandom start audio sys record thread!");
        AppMethodBeat.m2505o(66661);
    }
}
