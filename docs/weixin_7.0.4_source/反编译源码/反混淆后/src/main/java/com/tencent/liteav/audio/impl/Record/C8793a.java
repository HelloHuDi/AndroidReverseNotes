package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: com.tencent.liteav.audio.impl.Record.a */
public class C8793a implements Runnable {
    /* renamed from: a */
    private WeakReference<C0945h> f2466a;
    /* renamed from: b */
    private Context f2467b;
    /* renamed from: c */
    private int f2468c;
    /* renamed from: d */
    private int f2469d;
    /* renamed from: e */
    private int f2470e;
    /* renamed from: f */
    private boolean f2471f;
    /* renamed from: g */
    private Thread f2472g;
    /* renamed from: h */
    private byte[] f2473h;

    /* renamed from: a */
    public synchronized void mo19861a(C0945h c0945h) {
        AppMethodBeat.m2504i(66644);
        if (c0945h == null) {
            this.f2466a = null;
            AppMethodBeat.m2505o(66644);
        } else {
            this.f2466a = new WeakReference(c0945h);
            AppMethodBeat.m2505o(66644);
        }
    }

    /* renamed from: a */
    public void mo19860a(Context context, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66645);
        mo19859a();
        this.f2467b = context;
        this.f2468c = i;
        this.f2469d = i2;
        this.f2470e = i3;
        this.f2471f = true;
        this.f2472g = new Thread(this, "AudioSysRecord Thread");
        this.f2472g.start();
        AppMethodBeat.m2505o(66645);
    }

    /* renamed from: a */
    public void mo19859a() {
        AppMethodBeat.m2504i(66646);
        this.f2471f = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.f2472g == null || !this.f2472g.isAlive() || Thread.currentThread().getId() == this.f2472g.getId())) {
            try {
                this.f2472g.join();
            } catch (Exception e) {
                TXCLog.m15676e("AudioCenter:TXCAudioBGMRecord", "record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.m15677i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.f2472g = null;
        AppMethodBeat.m2505o(66646);
    }

    /* renamed from: b */
    public boolean mo19862b() {
        return this.f2471f;
    }

    /* renamed from: a */
    private void m15631a(byte[] bArr, int i, long j) {
        AppMethodBeat.m2504i(66647);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f2466a != null) {
                    c0945h = (C0945h) this.f2466a.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66647);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordPCM(bArr, i, j);
            return;
        }
        TXCLog.m15676e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
        AppMethodBeat.m2505o(66647);
    }

    /* renamed from: c */
    private void m15632c() {
        AppMethodBeat.m2504i(66648);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f2466a != null) {
                    c0945h = (C0945h) this.f2466a.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66648);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordStart();
            return;
        }
        TXCLog.m15676e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
        AppMethodBeat.m2505o(66648);
    }

    /* renamed from: d */
    private void m15633d() {
        AppMethodBeat.m2504i(66649);
        C0945h c0945h = null;
        synchronized (this) {
            try {
                if (this.f2466a != null) {
                    c0945h = (C0945h) this.f2466a.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66649);
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordStop();
            return;
        }
        TXCLog.m15676e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
        AppMethodBeat.m2505o(66649);
    }

    public void run() {
        AppMethodBeat.m2504i(66650);
        if (this.f2471f) {
            m15632c();
            int i = this.f2468c;
            int i2 = this.f2469d;
            int i3 = this.f2470e;
            int i4 = ((i2 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * i3) / 8;
            this.f2473h = new byte[i4];
            Arrays.fill(this.f2473h, (byte) 0);
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            while (this.f2471f && !Thread.interrupted()) {
                if (((((((System.currentTimeMillis() - currentTimeMillis) * ((long) i)) * ((long) i2)) * ((long) i3)) / 8) / 1000) - j < ((long) i4)) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                } else {
                    j += (long) this.f2473h.length;
                    m15631a(this.f2473h, this.f2473h.length, TXCTimeUtil.getTimeTick());
                }
            }
            m15633d();
            AppMethodBeat.m2505o(66650);
            return;
        }
        TXCLog.m15679w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
        AppMethodBeat.m2505o(66650);
    }
}
