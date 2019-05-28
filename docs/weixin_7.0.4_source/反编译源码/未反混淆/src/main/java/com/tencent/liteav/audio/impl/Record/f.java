package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

public class f implements Runnable {
    private static final String a = ("AudioCenter:" + f.class.getSimpleName());
    private static f b = null;
    private Context c;
    private int d = TXRecordCommon.AUDIO_SAMPLERATE_48000;
    private int e = 1;
    private int f = 16;
    private int g = TXEAudioDef.TXE_AEC_NONE;
    private AudioRecord h;
    private byte[] i = null;
    private WeakReference<h> j;
    private Thread k = null;
    private boolean l = false;

    static {
        AppMethodBeat.i(66662);
        AppMethodBeat.o(66662);
    }

    public static f a() {
        AppMethodBeat.i(66651);
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        b = new f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(66651);
                    }
                }
            }
        }
        f fVar = b;
        AppMethodBeat.o(66651);
        return fVar;
    }

    private f() {
    }

    public synchronized void a(h hVar) {
        AppMethodBeat.i(66652);
        if (hVar == null) {
            this.j = null;
            AppMethodBeat.o(66652);
        } else {
            this.j = new WeakReference(hVar);
            AppMethodBeat.o(66652);
        }
    }

    public void a(Context context, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(66653);
        b();
        this.c = context;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.l = true;
        this.k = new Thread(this, "AudioSysRecord Thread");
        this.k.start();
        AppMethodBeat.o(66653);
    }

    public void b() {
        AppMethodBeat.i(66654);
        this.l = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.k == null || !this.k.isAlive() || Thread.currentThread().getId() == this.k.getId())) {
            try {
                this.k.join();
            } catch (Exception e) {
                TXCLog.e(a, "record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.i(a, "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.k = null;
        AppMethodBeat.o(66654);
    }

    public synchronized boolean c() {
        return this.l;
    }

    private void d() {
        int i;
        AppMethodBeat.i(66655);
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.f;
        int i5 = this.g;
        TXCLog.i(a, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}));
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
                TXCLog.i(a, "audio record type: system aec");
                if (this.c != null) {
                    ((AudioManager) this.c.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(3);
                }
                this.h = new AudioRecord(7, i2, i6, i, minBufferSize * 2);
                if (this.c != null) {
                    ((AudioManager) this.c.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
                }
            } else {
                TXCLog.i(a, "audio record type: system normal");
                this.h = new AudioRecord(1, i2, i6, i, minBufferSize * 2);
            }
        } catch (IllegalArgumentException e) {
        }
        if (this.h == null || this.h.getState() != 1) {
            TXCLog.e(a, "audio record: initialize the mic failed.");
            e();
            a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "open mic failed!");
            AppMethodBeat.o(66655);
            return;
        }
        i5 = ((i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * i4) / 8;
        if (i5 > minBufferSize) {
            this.i = new byte[minBufferSize];
        } else {
            this.i = new byte[i5];
        }
        TXCLog.i(a, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(this.i.length), Integer.valueOf(this.h.getState())}));
        if (this.h != null) {
            try {
                this.h.startRecording();
                AppMethodBeat.o(66655);
                return;
            } catch (Exception e2) {
                TXCLog.e(a, "mic startRecording failed.");
                a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "start recording failed!");
                AppMethodBeat.o(66655);
                return;
            }
        }
        AppMethodBeat.o(66655);
    }

    private void e() {
        AppMethodBeat.i(66656);
        if (this.h != null) {
            TXCLog.i(a, "stop mic");
            try {
                this.h.setRecordPositionUpdateListener(null);
                this.h.stop();
                this.h.release();
            } catch (Exception e) {
            }
        }
        this.h = null;
        this.i = null;
        AppMethodBeat.o(66656);
    }

    private void a(byte[] bArr, int i, long j) {
        AppMethodBeat.i(66657);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.j != null) {
                    hVar = (h) this.j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66657);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordPCM(bArr, i, j);
            return;
        }
        TXCLog.e(a, "onRecordPcmData:no callback");
        AppMethodBeat.o(66657);
    }

    private void a(int i, String str) {
        AppMethodBeat.i(66658);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.j != null) {
                    hVar = (h) this.j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66658);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordError(i, str);
            return;
        }
        TXCLog.e(a, "onRecordError:no callback");
        AppMethodBeat.o(66658);
    }

    private void f() {
        AppMethodBeat.i(66659);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.j != null) {
                    hVar = (h) this.j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66659);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordStart();
            return;
        }
        TXCLog.e(a, "onRecordStart:no callback");
        AppMethodBeat.o(66659);
    }

    private void g() {
        AppMethodBeat.i(66660);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.j != null) {
                    hVar = (h) this.j.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66660);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordStop();
            return;
        }
        TXCLog.e(a, "onRecordStop:no callback");
        AppMethodBeat.o(66660);
    }

    public void run() {
        AppMethodBeat.i(66661);
        if (this.l) {
            f();
            d();
            int i = 0;
            int i2 = 0;
            while (this.l && !Thread.interrupted() && this.h != null && i2 <= 5) {
                System.currentTimeMillis();
                int read = this.h.read(this.i, i, this.i.length - i);
                if (read == this.i.length - i) {
                    a(this.i, this.i.length, TXCTimeUtil.getTimeTick());
                    i = 0;
                    i2 = 0;
                } else if (read <= 0) {
                    TXCLog.e(a, "read pcm eror, len =".concat(String.valueOf(read)));
                    i2++;
                } else {
                    i += read;
                }
            }
            e();
            if (i2 > 5) {
                a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "read data failed!");
                AppMethodBeat.o(66661);
                return;
            }
            g();
            AppMethodBeat.o(66661);
            return;
        }
        TXCLog.w(a, "audio record: abandom start audio sys record thread!");
        AppMethodBeat.o(66661);
    }
}
