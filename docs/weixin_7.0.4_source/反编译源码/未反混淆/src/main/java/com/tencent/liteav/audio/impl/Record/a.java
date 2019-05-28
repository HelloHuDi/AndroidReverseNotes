package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a implements Runnable {
    private WeakReference<h> a;
    private Context b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private Thread g;
    private byte[] h;

    public synchronized void a(h hVar) {
        AppMethodBeat.i(66644);
        if (hVar == null) {
            this.a = null;
            AppMethodBeat.o(66644);
        } else {
            this.a = new WeakReference(hVar);
            AppMethodBeat.o(66644);
        }
    }

    public void a(Context context, int i, int i2, int i3) {
        AppMethodBeat.i(66645);
        a();
        this.b = context;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = true;
        this.g = new Thread(this, "AudioSysRecord Thread");
        this.g.start();
        AppMethodBeat.o(66645);
    }

    public void a() {
        AppMethodBeat.i(66646);
        this.f = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.g == null || !this.g.isAlive() || Thread.currentThread().getId() == this.g.getId())) {
            try {
                this.g.join();
            } catch (Exception e) {
                TXCLog.e("AudioCenter:TXCAudioBGMRecord", "record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.g = null;
        AppMethodBeat.o(66646);
    }

    public boolean b() {
        return this.f;
    }

    private void a(byte[] bArr, int i, long j) {
        AppMethodBeat.i(66647);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.a != null) {
                    hVar = (h) this.a.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66647);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordPCM(bArr, i, j);
            return;
        }
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
        AppMethodBeat.o(66647);
    }

    private void c() {
        AppMethodBeat.i(66648);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.a != null) {
                    hVar = (h) this.a.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66648);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordStart();
            return;
        }
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
        AppMethodBeat.o(66648);
    }

    private void d() {
        AppMethodBeat.i(66649);
        h hVar = null;
        synchronized (this) {
            try {
                if (this.a != null) {
                    hVar = (h) this.a.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66649);
            }
        }
        if (hVar != null) {
            hVar.onAudioRecordStop();
            return;
        }
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
        AppMethodBeat.o(66649);
    }

    public void run() {
        AppMethodBeat.i(66650);
        if (this.f) {
            c();
            int i = this.c;
            int i2 = this.d;
            int i3 = this.e;
            int i4 = ((i2 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * i3) / 8;
            this.h = new byte[i4];
            Arrays.fill(this.h, (byte) 0);
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            while (this.f && !Thread.interrupted()) {
                if (((((((System.currentTimeMillis() - currentTimeMillis) * ((long) i)) * ((long) i2)) * ((long) i3)) / 8) / 1000) - j < ((long) i4)) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                } else {
                    j += (long) this.h.length;
                    a(this.h, this.h.length, TXCTimeUtil.getTimeTick());
                }
            }
            d();
            AppMethodBeat.o(66650);
            return;
        }
        TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
        AppMethodBeat.o(66650);
    }
}
