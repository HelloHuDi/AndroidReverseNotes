package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.liteav.audio.impl.Record.b */
public abstract class C32135b {
    /* renamed from: a */
    protected int f14683a = 0;
    /* renamed from: b */
    protected int f14684b = 0;
    /* renamed from: c */
    protected int f14685c = 0;
    /* renamed from: d */
    private WeakReference<C0945h> f14686d = null;

    /* renamed from: a */
    public void mo52712a(Context context, int i, int i2, int i3) {
        this.f14683a = i;
        this.f14684b = i2;
        this.f14685c = i3;
    }

    /* renamed from: a */
    public synchronized void mo52713a(C0945h c0945h) {
        if (c0945h == null) {
            this.f14686d = null;
        } else {
            this.f14686d = new WeakReference(c0945h);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo52714a(byte[] bArr, int i, long j) {
        C0945h c0945h = null;
        synchronized (this) {
            if (this.f14686d != null) {
                c0945h = (C0945h) this.f14686d.get();
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordPCM(bArr, i, j);
        } else {
            TXCLog.m15676e("AudioCenter:TXCAudioBaseRecord", "onRecordPcmData:no callback");
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo52711a() {
        C0945h c0945h = null;
        synchronized (this) {
            if (this.f14686d != null) {
                c0945h = (C0945h) this.f14686d.get();
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordStart();
        } else {
            TXCLog.m15676e("AudioCenter:TXCAudioBaseRecord", "onRecordStart:no callback");
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo52715b() {
        C0945h c0945h = null;
        synchronized (this) {
            if (this.f14686d != null) {
                c0945h = (C0945h) this.f14686d.get();
            }
        }
        if (c0945h != null) {
            c0945h.onAudioRecordStop();
        } else {
            TXCLog.m15676e("AudioCenter:TXCAudioBaseRecord", "onRecordStop:no callback");
        }
    }
}
