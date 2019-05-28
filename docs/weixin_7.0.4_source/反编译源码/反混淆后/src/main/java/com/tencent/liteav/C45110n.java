package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.liteav.n */
public abstract class C45110n {
    /* renamed from: a */
    protected C17787g f17792a = null;
    /* renamed from: b */
    protected Context f17793b = null;
    /* renamed from: c */
    protected TXCloudVideoView f17794c = null;
    /* renamed from: d */
    protected WeakReference<C0946a> f17795d;

    /* renamed from: a */
    public abstract int mo67308a(String str, int i);

    /* renamed from: a */
    public abstract int mo67309a(boolean z);

    /* renamed from: a */
    public abstract void mo67311a(int i);

    /* renamed from: b */
    public abstract void mo67322b(int i);

    /* renamed from: b */
    public abstract void mo67323b(boolean z);

    /* renamed from: c */
    public abstract int mo67324c(int i);

    /* renamed from: c */
    public abstract boolean mo67325c();

    /* renamed from: e */
    public abstract int mo67327e();

    public C45110n(Context context) {
        if (context != null) {
            this.f17793b = context.getApplicationContext();
        }
    }

    /* renamed from: h */
    public C17787g mo72894h() {
        return this.f17792a;
    }

    /* renamed from: a */
    public void mo67315a(C17787g c17787g) {
        this.f17792a = c17787g;
        if (this.f17792a == null) {
            this.f17792a = new C17787g();
        }
    }

    /* renamed from: a */
    public void mo67310a() {
        TXCLog.m15679w("TXIPlayer", "pause not support");
    }

    /* renamed from: b */
    public void mo67321b() {
        TXCLog.m15679w("TXIPlayer", "resume not support");
    }

    /* renamed from: a */
    public void mo67314a(Surface surface) {
    }

    /* renamed from: a */
    public void mo67312a(int i, int i2) {
    }

    /* renamed from: e */
    public void mo72893e(int i) {
        TXCLog.m15679w("TXIPlayer", "seek not support");
    }

    /* renamed from: a */
    public void mo67318a(TXCloudVideoView tXCloudVideoView) {
        this.f17794c = tXCloudVideoView;
    }

    /* renamed from: d */
    public TextureView mo67326d() {
        return null;
    }

    /* renamed from: a */
    public void mo72891a(C0946a c0946a) {
        this.f17795d = new WeakReference(c0946a);
    }

    /* renamed from: a */
    public void mo67319a(ITXVideoRecordListener iTXVideoRecordListener) {
    }

    /* renamed from: a */
    public void mo67317a(ITXAudioRawDataListener iTXAudioRawDataListener) {
    }

    /* renamed from: c */
    public void mo72892c(boolean z) {
        TXCLog.m15679w("TXIPlayer", "autoPlay not implement");
    }

    /* renamed from: a */
    public void mo72890a(float f) {
        TXCLog.m15679w("TXIPlayer", "rate not implement");
    }

    /* renamed from: a */
    public void mo67313a(Context context, int i) {
    }

    /* renamed from: a */
    public boolean mo67320a(byte[] bArr) {
        return false;
    }

    /* renamed from: a */
    public void mo67316a(C8832o c8832o) {
    }

    /* renamed from: a */
    public int mo67307a(String str) {
        return -1;
    }

    /* renamed from: g */
    public void mo67329g() {
    }

    /* renamed from: f */
    public boolean mo67328f() {
        return false;
    }
}
