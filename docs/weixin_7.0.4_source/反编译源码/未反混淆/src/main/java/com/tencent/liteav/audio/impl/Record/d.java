package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class d extends b implements Runnable {
    private boolean d = false;
    private Thread e = null;
    private byte[] f = new byte[20480];
    private int g = 0;
    private int h = 0;

    public d() {
        AppMethodBeat.i(66663);
        AppMethodBeat.o(66663);
    }

    public void a(Context context, int i, int i2, int i3) {
        AppMethodBeat.i(66664);
        super.a(context, i, i2, i3);
        c();
        this.d = true;
        this.e = new Thread(this, "AudioCustomRecord Thread");
        this.e.start();
        AppMethodBeat.o(66664);
    }

    public void c() {
        AppMethodBeat.i(66665);
        this.d = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.e == null || !this.e.isAlive() || Thread.currentThread().getId() == this.e.getId())) {
            try {
                this.e.join();
            } catch (InterruptedException e) {
                TXCLog.e("AudioCenter:TXCAudioCustomRecord", "custom record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.i("AudioCenter:TXCAudioCustomRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.e = null;
        AppMethodBeat.o(66665);
    }

    public boolean d() {
        return this.d;
    }

    public synchronized void a(byte[] bArr) {
        AppMethodBeat.i(66666);
        if (bArr == null || f() < bArr.length) {
            TXCLog.e("AudioCenter:TXCAudioCustomRecord", "缓冲区不够. 自定义数据长度 = " + (bArr == null ? -1 : bArr.length) + ", 剩余缓冲区长度 = " + f());
            AppMethodBeat.o(66666);
        } else if (this.g + bArr.length <= this.f.length) {
            System.arraycopy(bArr, 0, this.f, this.g, bArr.length);
            this.g += bArr.length;
            AppMethodBeat.o(66666);
        } else {
            int length = this.f.length - this.g;
            System.arraycopy(bArr, 0, this.f, this.g, length);
            this.g = bArr.length - length;
            System.arraycopy(bArr, length, this.f, 0, this.g);
            AppMethodBeat.o(66666);
        }
    }

    private int e() {
        return ((this.g + this.f.length) - this.h) % this.f.length;
    }

    private int f() {
        AppMethodBeat.i(66667);
        int length = this.f.length - e();
        AppMethodBeat.o(66667);
        return length;
    }

    public void run() {
        AppMethodBeat.i(66668);
        if (this.d) {
            a();
            int i = ((this.b * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.c) / 8;
            byte[] bArr = new byte[i];
            while (this.d && !Thread.interrupted()) {
                if (i <= e()) {
                    synchronized (this) {
                        try {
                            if (this.h + i <= this.f.length) {
                                System.arraycopy(this.f, this.h, bArr, 0, i);
                                this.h += i;
                            } else {
                                int length = this.f.length - this.h;
                                System.arraycopy(this.f, this.h, bArr, 0, length);
                                this.h = i - length;
                                System.arraycopy(this.f, 0, bArr, length, this.h);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(66668);
                        }
                    }
                    a(bArr, i, TXCTimeUtil.getTimeTick());
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
            b();
            AppMethodBeat.o(66668);
            return;
        }
        TXCLog.w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
        AppMethodBeat.o(66668);
    }
}
