package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements com.tencent.liteav.basic.d.a, d {
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    Surface e;
    d f;
    private int g;
    private ByteBuffer h;
    private ByteBuffer i;
    private long j;
    private boolean k = false;
    private ArrayList<com.tencent.liteav.basic.g.b> l = new ArrayList();
    private a m;
    private WeakReference<com.tencent.liteav.basic.d.a> n;

    static class a extends Handler {
        a a;
        d b;
        WeakReference<com.tencent.liteav.basic.d.a> c;
        boolean d;
        boolean e;
        Surface f;
        private ByteBuffer g;
        private ByteBuffer h;

        public a(Looper looper) {
            super(looper);
        }

        public void a(boolean z, boolean z2, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, d dVar, com.tencent.liteav.basic.d.a aVar) {
            AppMethodBeat.i(67803);
            this.e = z;
            this.d = z2;
            this.f = surface;
            this.g = byteBuffer;
            this.h = byteBuffer2;
            this.b = dVar;
            this.c = new WeakReference(aVar);
            AppMethodBeat.o(67803);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(67804);
            switch (message.what) {
                case 100:
                    a(((Boolean) message.obj).booleanValue());
                    AppMethodBeat.o(67804);
                    return;
                case 101:
                    try {
                        Bundle data = message.getData();
                        a(data.getByteArray("nal"), data.getLong("pts"), data.getLong("dts"), data.getInt("codecId"));
                        AppMethodBeat.o(67804);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.o(67804);
                        return;
                    }
                case 102:
                    b();
                    AppMethodBeat.o(67804);
                    return;
                case 103:
                    boolean z2 = message.arg1 == 1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    a(z2, z);
                    break;
            }
            AppMethodBeat.o(67804);
        }

        public boolean a() {
            AppMethodBeat.i(67805);
            if (this.a != null) {
                boolean isHevc = this.a.isHevc();
                AppMethodBeat.o(67805);
                return isHevc;
            }
            AppMethodBeat.o(67805);
            return false;
        }

        private void a(byte[] bArr, long j, long j2, int i) {
            AppMethodBeat.i(67806);
            com.tencent.liteav.basic.g.b bVar = new com.tencent.liteav.basic.g.b();
            bVar.a = bArr;
            bVar.g = j;
            bVar.h = j2;
            bVar.i = i;
            if (this.a != null) {
                this.a.decode(bVar);
            }
            AppMethodBeat.o(67806);
        }

        private void b() {
            AppMethodBeat.i(67807);
            if (this.a != null) {
                this.a.stop();
                this.a.setListener(null);
                this.a.setNotifyListener(null);
                this.a = null;
            }
            Looper.myLooper().quit();
            TXCLog.w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.d);
            AppMethodBeat.o(67807);
        }

        private void a(boolean z, boolean z2) {
            AppMethodBeat.i(67808);
            this.d = z;
            TXCLog.w("TXCVideoDecoder", "play:decode: restart decode hwdec: " + this.d);
            if (this.a != null) {
                this.a.stop();
                this.a.setListener(null);
                this.a.setNotifyListener(null);
                this.a = null;
            }
            a(z2);
            AppMethodBeat.o(67808);
        }

        private void a(boolean z) {
            AppMethodBeat.i(67809);
            if (this.a != null) {
                TXCLog.i("TXCVideoDecoder", "play:decode: start decode ignore hwdec: " + this.d);
                AppMethodBeat.o(67809);
                return;
            }
            if (this.d) {
                this.a = new c();
            } else {
                this.a = new TXCVideoFfmpegDecoder();
            }
            this.a.setListener(this.b);
            this.a.setNotifyListener(this.c);
            this.a.config(this.f);
            this.a.start(this.g, this.h, z, this.e);
            TXCLog.w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.d + ", hevc: " + this.e);
            AppMethodBeat.o(67809);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.i(67768);
        com.tencent.liteav.basic.util.b.a(this.n, this.j, i, bundle);
        AppMethodBeat.o(67768);
    }

    public void a(long j) {
        this.j = j;
    }

    public b() {
        AppMethodBeat.i(67769);
        AppMethodBeat.o(67769);
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public boolean a() {
        return this.b;
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(67770);
        this.n = new WeakReference(aVar);
        AppMethodBeat.o(67770);
    }

    public int a(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        AppMethodBeat.i(67771);
        int a = a(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z);
        AppMethodBeat.o(67771);
        return a;
    }

    public int a(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        this.e = surface;
        this.h = byteBuffer;
        this.i = byteBuffer2;
        this.a = z;
        return 0;
    }

    public void a(boolean z) {
        this.b = z;
    }

    private void b(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(67772);
        boolean z = bVar.b == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", bVar.a);
        bundle.putLong("pts", bVar.g);
        bundle.putLong("dts", bVar.h);
        bundle.putInt("codecId", bVar.i);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        a aVar = this.m;
        if (aVar != null) {
            aVar.sendMessage(message);
        }
        this.g++;
        AppMethodBeat.o(67772);
    }

    public void a(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(67773);
        Object obj = bVar.b == 0 ? 1 : null;
        if (this.d || obj != null) {
            try {
                if (!(this.d || obj == null)) {
                    TXCLog.w("TXCVideoDecoder", "play:decode: push first i frame");
                    this.d = true;
                }
                if (!(this.k || bVar.i != 1 || this.b)) {
                    TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
                    com.tencent.liteav.basic.util.b.a(this.n, (int) TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
                    this.k = true;
                }
                if (this.m != null) {
                    if (!this.l.isEmpty()) {
                        Iterator it = this.l.iterator();
                        while (it.hasNext()) {
                            b((com.tencent.liteav.basic.g.b) it.next());
                        }
                    }
                    this.l.clear();
                    b(bVar);
                    AppMethodBeat.o(67773);
                    return;
                }
                if (!(obj == null || this.l.isEmpty())) {
                    this.l.clear();
                }
                this.l.add(bVar);
                if (!this.k) {
                    b();
                }
                AppMethodBeat.o(67773);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(67773);
                return;
            }
        }
        TXCLog.i("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
        AppMethodBeat.o(67773);
    }

    /* JADX WARNING: Missing block: B:15:0x0091, code skipped:
            r1 = new android.os.Bundle();
            r1.putInt("EVT_ID", 2008);
            r1.putLong("EVT_TIME", com.tencent.liteav.basic.util.TXCTimeUtil.getTimeTick());
            r2 = com.tencent.rtmp.TXLiveConstants.EVT_DESCRIPTION;
     */
    /* JADX WARNING: Missing block: B:16:0x00ab, code skipped:
            if (r11.b == false) goto L_0x00d1;
     */
    /* JADX WARNING: Missing block: B:17:0x00ad, code skipped:
            r0 = "启动硬解";
     */
    /* JADX WARNING: Missing block: B:18:0x00b0, code skipped:
            r1.putCharSequence(r2, r0);
            r2 = "EVT_PARAM1";
     */
    /* JADX WARNING: Missing block: B:19:0x00b8, code skipped:
            if (r11.b == false) goto L_0x00d5;
     */
    /* JADX WARNING: Missing block: B:20:0x00ba, code skipped:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:21:0x00bb, code skipped:
            r1.putInt(r2, r0);
            com.tencent.liteav.basic.util.b.a(r11.n, r11.j, 2008, r1);
            com.tencent.matrix.trace.core.AppMethodBeat.o(67774);
     */
    /* JADX WARNING: Missing block: B:26:0x00d1, code skipped:
            r0 = "启动软解";
     */
    /* JADX WARNING: Missing block: B:27:0x00d5, code skipped:
            r0 = 2;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b() {
        AppMethodBeat.i(67774);
        if (this.b && this.e == null) {
            TXCLog.i("TXCVideoDecoder", "play:decode: start decoder error when not setup surface");
            AppMethodBeat.o(67774);
            return -1;
        }
        synchronized (this) {
            try {
                if (this.m != null) {
                    TXCLog.e("TXCVideoDecoder", "play:decode: start decoder error when decoder is started");
                } else {
                    this.g = 0;
                    this.k = false;
                    HandlerThread handlerThread = new HandlerThread("VDecoder");
                    handlerThread.start();
                    handlerThread.setName("VDecoder" + handlerThread.getId());
                    a aVar = new a(handlerThread.getLooper());
                    aVar.a(this.c, this.b, this.e, this.h, this.i, this, this);
                    TXCLog.w("TXCVideoDecoder", "play:decode: start decode thread");
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    obtain.obj = Boolean.valueOf(this.a);
                    aVar.sendMessage(obtain);
                    this.m = aVar;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67774);
            }
        }
        return -1;
    }

    public void c() {
        AppMethodBeat.i(67775);
        synchronized (this) {
            try {
                if (this.m != null) {
                    this.m.sendEmptyMessage(102);
                }
                this.m = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67775);
            }
        }
        this.l.clear();
        this.d = false;
        this.g = 0;
    }

    public void b(boolean z) {
        int i = 1;
        AppMethodBeat.i(67776);
        synchronized (this) {
            try {
                this.b = z;
                this.l.clear();
                this.d = false;
                this.g = 0;
                Message obtain = Message.obtain();
                obtain.what = 103;
                obtain.arg1 = this.b ? 1 : 0;
                if (!this.a) {
                    i = 0;
                }
                obtain.arg2 = i;
                if (this.m != null) {
                    this.m.sendMessage(obtain);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67776);
            }
        }
    }

    public void a(byte[] bArr, long j, int i) {
        AppMethodBeat.i(67777);
        a aVar = this.m;
        if (!(aVar == null || aVar.d || aVar.a == null)) {
            ((TXCVideoFfmpegDecoder) aVar.a).loadNativeData(bArr, j, i);
        }
        AppMethodBeat.o(67777);
    }

    public int d() {
        AppMethodBeat.i(67778);
        int size = this.g + this.l.size();
        AppMethodBeat.o(67778);
        return size;
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        AppMethodBeat.i(67779);
        if (this.f != null) {
            this.f.a(surfaceTexture, i, i2, j, j2);
        }
        if (this.g > 0) {
            this.g--;
        }
        AppMethodBeat.o(67779);
    }

    public void a(long j, int i, int i2, long j2, long j3) {
        AppMethodBeat.i(67780);
        if (this.f != null) {
            this.f.a(j, i, i2, j2, j3);
        }
        if (this.g > 0) {
            this.g--;
        }
        AppMethodBeat.o(67780);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67781);
        if (this.f != null) {
            this.f.a(i, i2);
        }
        AppMethodBeat.o(67781);
    }

    public boolean e() {
        AppMethodBeat.i(67782);
        a aVar = this.m;
        if (aVar != null) {
            boolean a = aVar.a();
            AppMethodBeat.o(67782);
            return a;
        }
        AppMethodBeat.o(67782);
        return false;
    }
}
