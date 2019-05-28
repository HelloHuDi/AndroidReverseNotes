package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: com.tencent.liteav.audio.impl.Record.d */
public class C45099d extends C32135b implements Runnable {
    /* renamed from: d */
    private boolean f17737d = false;
    /* renamed from: e */
    private Thread f17738e = null;
    /* renamed from: f */
    private byte[] f17739f = new byte[20480];
    /* renamed from: g */
    private int f17740g = 0;
    /* renamed from: h */
    private int f17741h = 0;

    public C45099d() {
        AppMethodBeat.m2504i(66663);
        AppMethodBeat.m2505o(66663);
    }

    /* renamed from: a */
    public void mo52712a(Context context, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66664);
        super.mo52712a(context, i, i2, i3);
        mo72866c();
        this.f17737d = true;
        this.f17738e = new Thread(this, "AudioCustomRecord Thread");
        this.f17738e.start();
        AppMethodBeat.m2505o(66664);
    }

    /* renamed from: c */
    public void mo72866c() {
        AppMethodBeat.m2504i(66665);
        this.f17737d = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.f17738e == null || !this.f17738e.isAlive() || Thread.currentThread().getId() == this.f17738e.getId())) {
            try {
                this.f17738e.join();
            } catch (InterruptedException e) {
                TXCLog.m15676e("AudioCenter:TXCAudioCustomRecord", "custom record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.m15677i("AudioCenter:TXCAudioCustomRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.f17738e = null;
        AppMethodBeat.m2505o(66665);
    }

    /* renamed from: d */
    public boolean mo72867d() {
        return this.f17737d;
    }

    /* renamed from: a */
    public synchronized void mo72865a(byte[] bArr) {
        AppMethodBeat.m2504i(66666);
        if (bArr == null || m82731f() < bArr.length) {
            TXCLog.m15676e("AudioCenter:TXCAudioCustomRecord", "缓冲区不够. 自定义数据长度 = " + (bArr == null ? -1 : bArr.length) + ", 剩余缓冲区长度 = " + m82731f());
            AppMethodBeat.m2505o(66666);
        } else if (this.f17740g + bArr.length <= this.f17739f.length) {
            System.arraycopy(bArr, 0, this.f17739f, this.f17740g, bArr.length);
            this.f17740g += bArr.length;
            AppMethodBeat.m2505o(66666);
        } else {
            int length = this.f17739f.length - this.f17740g;
            System.arraycopy(bArr, 0, this.f17739f, this.f17740g, length);
            this.f17740g = bArr.length - length;
            System.arraycopy(bArr, length, this.f17739f, 0, this.f17740g);
            AppMethodBeat.m2505o(66666);
        }
    }

    /* renamed from: e */
    private int m82730e() {
        return ((this.f17740g + this.f17739f.length) - this.f17741h) % this.f17739f.length;
    }

    /* renamed from: f */
    private int m82731f() {
        AppMethodBeat.m2504i(66667);
        int length = this.f17739f.length - m82730e();
        AppMethodBeat.m2505o(66667);
        return length;
    }

    public void run() {
        AppMethodBeat.m2504i(66668);
        if (this.f17737d) {
            mo52711a();
            int i = ((this.f14684b * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.f14685c) / 8;
            byte[] bArr = new byte[i];
            while (this.f17737d && !Thread.interrupted()) {
                if (i <= m82730e()) {
                    synchronized (this) {
                        try {
                            if (this.f17741h + i <= this.f17739f.length) {
                                System.arraycopy(this.f17739f, this.f17741h, bArr, 0, i);
                                this.f17741h += i;
                            } else {
                                int length = this.f17739f.length - this.f17741h;
                                System.arraycopy(this.f17739f, this.f17741h, bArr, 0, length);
                                this.f17741h = i - length;
                                System.arraycopy(this.f17739f, 0, bArr, length, this.f17741h);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(66668);
                        }
                    }
                    mo52714a(bArr, i, TXCTimeUtil.getTimeTick());
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
            mo52715b();
            AppMethodBeat.m2505o(66668);
            return;
        }
        TXCLog.m15679w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
        AppMethodBeat.m2505o(66668);
    }
}
