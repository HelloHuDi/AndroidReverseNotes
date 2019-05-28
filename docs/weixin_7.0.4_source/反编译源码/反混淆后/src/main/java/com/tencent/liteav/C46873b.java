package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C25647m;
import com.tencent.liteav.basic.p141e.C37354l;
import com.tencent.liteav.basic.p811g.C8803c;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.capturer.C37367a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.b */
public class C46873b implements C0946a, C25647m, C45108k {
    /* renamed from: a */
    WeakReference<C0946a> f18278a;
    /* renamed from: b */
    private Context f18279b;
    /* renamed from: c */
    private C37367a f18280c;
    /* renamed from: d */
    private C37369l f18281d;
    /* renamed from: e */
    private boolean f18282e;
    /* renamed from: f */
    private C25658f f18283f;
    /* renamed from: g */
    private int f18284g;
    /* renamed from: h */
    private boolean f18285h;
    /* renamed from: i */
    private int f18286i;
    /* renamed from: j */
    private int f18287j;
    /* renamed from: k */
    private C37354l f18288k;
    /* renamed from: l */
    private boolean f18289l;

    /* renamed from: com.tencent.liteav.b$2 */
    class C321392 implements Runnable {
        C321392() {
        }

        public void run() {
            AppMethodBeat.m2504i(67089);
            if (C46873b.this.f18286i != -1) {
                C46873b.this.f18284g = C46873b.this.f18286i;
                C46873b.this.f18286i = -1;
            }
            if (C46873b.this.f18287j != -1) {
                C46873b.this.f18283f.f5313l = C46873b.this.f18287j;
                C46873b.this.f18280c.mo60173d(C46873b.this.f18283f.f5313l);
                C46873b.this.f18287j = -1;
            }
            AppMethodBeat.m2505o(67089);
        }
    }

    public C46873b(Context context, C25658f c25658f, C37354l c37354l) {
        AppMethodBeat.m2504i(67655);
        this.f18280c = null;
        this.f18284g = 0;
        this.f18285h = false;
        this.f18286i = -1;
        this.f18287j = -1;
        this.f18288k = null;
        this.f18289l = false;
        this.f18280c = new C37367a();
        try {
            this.f18283f = (C25658f) c25658f.clone();
        } catch (CloneNotSupportedException e) {
            this.f18283f = new C25658f();
        }
        this.f18279b = context;
        this.f18288k = c37354l;
        this.f18288k.setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(67655);
    }

    /* renamed from: a */
    public void mo43389a() {
        AppMethodBeat.m2504i(67656);
        this.f18288k.mo14491a(this.f18283f.f5309h);
        m89124c(this.f18288k.getSurfaceTexture());
        AppMethodBeat.m2505o(67656);
    }

    /* renamed from: a */
    public void mo43397a(boolean z) {
        AppMethodBeat.m2504i(67657);
        mo43402c();
        this.f18288k.mo14490a();
        AppMethodBeat.m2505o(67657);
    }

    /* renamed from: b */
    public void mo43399b() {
        AppMethodBeat.m2504i(67658);
        m89124c(this.f18288k.getSurfaceTexture());
        AppMethodBeat.m2505o(67658);
    }

    /* renamed from: c */
    public void mo43402c() {
        AppMethodBeat.m2504i(67659);
        this.f18280c.mo60167b();
        this.f18282e = false;
        AppMethodBeat.m2505o(67659);
    }

    /* renamed from: b */
    public void mo43401b(boolean z) {
        AppMethodBeat.m2504i(67660);
        if (this.f18282e && this.f18280c != null) {
            C25658f c25658f = this.f18283f;
            boolean z2 = z ? !this.f18283f.f5314m : this.f18283f.f5314m;
            c25658f.f5314m = z2;
            this.f18280c.mo60167b();
            this.f18288k.mo14494a(false);
            this.f18280c.mo60164a(m89126g());
            this.f18280c.mo60165a(this.f18288k.getSurfaceTexture());
            if (this.f18280c.mo60171c(this.f18283f.f5314m) == 0) {
                this.f18282e = true;
                m89119a(1003, "打开摄像头成功");
            } else {
                this.f18282e = false;
                m89119a((int) TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL, "打开摄像头失败，请确认摄像头权限是否打开");
            }
            this.f18289l = false;
        }
        AppMethodBeat.m2505o(67660);
    }

    /* renamed from: d */
    public boolean mo43406d() {
        return this.f18282e;
    }

    /* renamed from: e */
    public int mo43408e() {
        AppMethodBeat.m2504i(67661);
        int a = this.f18280c.mo60161a();
        AppMethodBeat.m2505o(67661);
        return a;
    }

    /* renamed from: a */
    public boolean mo43398a(int i) {
        AppMethodBeat.m2504i(67662);
        boolean c = this.f18280c.mo60172c(i);
        AppMethodBeat.m2505o(67662);
        return c;
    }

    /* renamed from: a */
    public void mo43390a(float f) {
        AppMethodBeat.m2504i(67663);
        this.f18280c.mo60162a(f);
        AppMethodBeat.m2505o(67663);
    }

    /* renamed from: b */
    public void mo43400b(int i) {
        AppMethodBeat.m2504i(67664);
        this.f18286i = i;
        m89127h();
        AppMethodBeat.m2505o(67664);
    }

    /* renamed from: a */
    public void mo43395a(C37369l c37369l) {
        this.f18281d = c37369l;
    }

    /* renamed from: c */
    public void mo43404c(final boolean z) {
        AppMethodBeat.m2504i(67665);
        mo43396a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66823);
                C46873b.this.f18283f.f5299L = z;
                AppMethodBeat.m2505o(66823);
            }
        });
        AppMethodBeat.m2505o(67665);
    }

    /* renamed from: d */
    public boolean mo43407d(boolean z) {
        AppMethodBeat.m2504i(67666);
        boolean a = this.f18280c.mo60166a(z);
        AppMethodBeat.m2505o(67666);
        return a;
    }

    /* renamed from: a */
    public void mo43394a(C8803c c8803c) {
        AppMethodBeat.m2504i(67667);
        if (this.f18288k != null) {
            this.f18288k.mo14492a(c8803c.f2652a, c8803c.f2659h, this.f18284g, c8803c.f2655d, c8803c.f2656e);
        }
        AppMethodBeat.m2505o(67667);
    }

    /* renamed from: e */
    public void mo43409e(boolean z) {
        this.f18285h = z;
    }

    /* renamed from: a */
    public void mo43396a(Runnable runnable) {
        AppMethodBeat.m2504i(67668);
        this.f18288k.mo14493a(runnable);
        AppMethodBeat.m2505o(67668);
    }

    /* renamed from: f */
    public EGLContext mo43410f() {
        AppMethodBeat.m2504i(67669);
        EGLContext gLContext = this.f18288k.getGLContext();
        AppMethodBeat.m2505o(67669);
        return gLContext;
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(67670);
        C17778b.m27742a(this.f18278a, i, bundle);
        AppMethodBeat.m2505o(67670);
    }

    /* renamed from: a */
    public void mo43393a(C0946a c0946a) {
        AppMethodBeat.m2504i(67671);
        this.f18278a = new WeakReference(c0946a);
        AppMethodBeat.m2505o(67671);
    }

    /* renamed from: c */
    public void mo43403c(int i) {
        AppMethodBeat.m2504i(67672);
        this.f18287j = i;
        m89127h();
        AppMethodBeat.m2505o(67672);
    }

    /* renamed from: a */
    public void mo43392a(int i, int i2) {
        this.f18283f.f5302a = i;
        this.f18283f.f5303b = i2;
    }

    /* renamed from: d */
    public void mo43405d(int i) {
        AppMethodBeat.m2504i(67673);
        this.f18283f.f5312k = i;
        this.f18283f.mo43387a();
        AppMethodBeat.m2505o(67673);
    }

    /* renamed from: a */
    public void mo43391a(float f, float f2) {
        AppMethodBeat.m2504i(67674);
        if (this.f18280c != null && this.f18283f.f5291D) {
            this.f18280c.mo60163a(f, f2);
        }
        AppMethodBeat.m2505o(67674);
    }

    /* renamed from: c */
    private void m89124c(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67675);
        if (!(surfaceTexture == null || this.f18282e || this.f18280c == null)) {
            this.f18280c.mo60165a(surfaceTexture);
            this.f18280c.mo60168b(this.f18283f.f5309h);
            this.f18280c.mo60173d(this.f18283f.f5313l);
            this.f18280c.mo60169b(this.f18283f.f5291D);
            this.f18280c.mo60164a(m89126g());
            if (this.f18280c.mo60171c(this.f18283f.f5314m) == 0) {
                this.f18282e = true;
                m89119a(1003, "打开摄像头成功");
                this.f18289l = false;
                if (this.f18285h && !C8790b.m15606a().mo19846c()) {
                    C8790b.m15606a().mo19834a(this.f18279b);
                    this.f18285h = false;
                    AppMethodBeat.m2505o(67675);
                    return;
                }
            }
            this.f18282e = false;
            m89119a((int) TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL, "打开摄像头失败，请确认摄像头权限是否打开");
        }
        AppMethodBeat.m2505o(67675);
    }

    /* renamed from: a */
    private void m89119a(int i, String str) {
        AppMethodBeat.m2504i(67676);
        C17778b.m27743a(this.f18278a, i, str);
        AppMethodBeat.m2505o(67676);
    }

    /* renamed from: a */
    public void mo43376a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67677);
        m89124c(surfaceTexture);
        if (this.f18281d != null) {
            this.f18281d.mo60181a(surfaceTexture);
        }
        AppMethodBeat.m2505o(67677);
    }

    /* renamed from: b */
    public void mo43377b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67678);
        if (this.f18281d != null) {
            this.f18281d.mo60183r();
        }
        AppMethodBeat.m2505o(67678);
    }

    /* renamed from: a */
    public int mo43375a(int i, float[] fArr) {
        boolean z = true;
        AppMethodBeat.m2504i(67679);
        if (this.f18282e) {
            if (!this.f18289l) {
                C17778b.m27743a(this.f18278a, 1007, "首帧画面采集完成");
                this.f18289l = true;
            }
            if (this.f18281d != null) {
                C8803c c8803c = new C8803c();
                c8803c.f2655d = this.f18280c.mo60175e();
                c8803c.f2656e = this.f18280c.mo60176f();
                c8803c.f2657f = this.f18283f.f5302a;
                c8803c.f2658g = this.f18283f.f5303b;
                c8803c.f2660i = this.f18280c.mo60170c();
                if (!this.f18280c.mo60174d()) {
                    z = this.f18283f.f5299L;
                } else if (this.f18283f.f5299L) {
                    z = false;
                }
                c8803c.f2659h = z;
                c8803c.f2652a = i;
                c8803c.f2654c = fArr;
                c8803c.f2661j = this.f18284g;
                c8803c.f2653b = 4;
                if (c8803c.f2660i == 0 || c8803c.f2660i == 180) {
                    c8803c.f2657f = this.f18283f.f5303b;
                    c8803c.f2658g = this.f18283f.f5302a;
                } else {
                    c8803c.f2657f = this.f18283f.f5302a;
                    c8803c.f2658g = this.f18283f.f5303b;
                }
                c8803c.f2662k = C17778b.m27738a(c8803c.f2655d, c8803c.f2656e, this.f18283f.f5303b, this.f18283f.f5302a);
                this.f18281d.mo60182b(c8803c);
            }
            AppMethodBeat.m2505o(67679);
        } else {
            AppMethodBeat.m2505o(67679);
        }
        return 0;
    }

    /* renamed from: g */
    private int m89126g() {
        if (this.f18283f.f5300M) {
            return 7;
        }
        switch (this.f18283f.f5312k) {
            case 0:
                return 4;
            case 1:
                return 5;
            case 2:
                return 6;
            case 6:
                return 3;
            default:
                return 7;
        }
    }

    /* renamed from: h */
    private void m89127h() {
        AppMethodBeat.m2504i(67680);
        mo43396a(new C321392());
        AppMethodBeat.m2505o(67680);
    }
}
