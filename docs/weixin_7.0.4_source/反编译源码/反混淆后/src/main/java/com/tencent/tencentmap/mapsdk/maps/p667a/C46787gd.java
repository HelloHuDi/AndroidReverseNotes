package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.map.lib.C45132a;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.util.C17862b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gd */
public class C46787gd implements C41052ge {
    /* renamed from: a */
    protected C44514gg f18140a = null;
    /* renamed from: b */
    private Context f18141b;
    /* renamed from: c */
    private C8889f f18142c;
    /* renamed from: d */
    private C46789gm f18143d;
    /* renamed from: e */
    private C16266gp f18144e;
    /* renamed from: f */
    private C31052gy f18145f;
    /* renamed from: g */
    private float f18146g = 0.5f;
    /* renamed from: h */
    private Handler f18147h = new Handler();
    /* renamed from: i */
    private int f18148i = 0;

    /* renamed from: a */
    static /* synthetic */ void m88790a(C46787gd c46787gd, float f, float f2, boolean z) {
        AppMethodBeat.m2504i(99015);
        c46787gd.m88789a(f, f2, z);
        AppMethodBeat.m2505o(99015);
    }

    public C46787gd(C44514gg c44514gg, Context context) {
        AppMethodBeat.m2504i(98989);
        this.f18140a = c44514gg;
        this.f18141b = context;
        mo75390k();
        AppMethodBeat.m2505o(98989);
    }

    /* renamed from: a_ */
    public void mo12502a_() {
        AppMethodBeat.m2504i(98990);
        if (this.f18140a != null) {
            this.f18140a.mo12502a_();
        }
        AppMethodBeat.m2505o(98990);
    }

    /* renamed from: a */
    public void mo65136a(C44513gf c44513gf) {
        AppMethodBeat.m2504i(98991);
        this.f18144e.mo29424a(c44513gf);
        AppMethodBeat.m2505o(98991);
    }

    /* renamed from: b */
    public void mo65137b(C44513gf c44513gf) {
        AppMethodBeat.m2504i(98992);
        this.f18144e.mo29425b(c44513gf);
        AppMethodBeat.m2505o(98992);
    }

    /* renamed from: b */
    public C8889f mo75386b() {
        return this.f18142c;
    }

    /* renamed from: c */
    public C46789gm mo75387c() {
        return this.f18143d;
    }

    /* renamed from: a */
    public void mo75384a(C45132a c45132a, C24386hf c24386hf) {
        AppMethodBeat.m2504i(98993);
        if (this.f18143d.mo75431a(this.f18141b.getApplicationContext(), c45132a, c24386hf)) {
            this.f18143d.mo12440a().mo58847k();
        }
        AppMethodBeat.m2505o(98993);
    }

    /* renamed from: a */
    public void mo75383a(float f, float f2, float f3) {
        AppMethodBeat.m2504i(98994);
        if (!(this.f18143d == null || this.f18147h == null)) {
            float l = this.f18143d.mo12440a().mo58848l();
            final float a = mo50431a(f3);
            final boolean z = ((double) Math.abs(l - a)) > 1.0E-4d;
            this.f18148i = 0;
            final float f4 = (f2 - this.f18146g) / 10.0f;
            final float f5 = f;
            final float f6 = f2;
            final float f7 = f3;
            this.f18147h.post(new Runnable() {

                /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gd$1$1 */
                class C310471 implements Runnable {
                    C310471() {
                    }

                    public void run() {
                        AppMethodBeat.m2504i(98987);
                        C46787gd.this.f18143d.mo12440a().mo58788a(a);
                        AppMethodBeat.m2505o(98987);
                    }
                }

                public void run() {
                    AppMethodBeat.m2504i(98988);
                    C46787gd.this.f18146g = C46787gd.this.f18146g + f4;
                    C46787gd.m88790a(C46787gd.this, f5, C46787gd.this.f18146g, true);
                    if (C46787gd.this.f18148i = C46787gd.this.f18148i + 1 < 10) {
                        C46787gd.this.f18147h.postDelayed(this, 16);
                        AppMethodBeat.m2505o(98988);
                        return;
                    }
                    C46787gd.m88790a(C46787gd.this, f5, f6, true);
                    if (f7 >= 3.0f && f7 <= 20.0f) {
                        if (z) {
                            C46787gd.this.f18143d.mo12440a().mo58797a((int) f7, new C310471(), false);
                            AppMethodBeat.m2505o(98988);
                            return;
                        }
                        C46787gd.this.f18143d.mo12440a().mo58788a(a);
                    }
                    AppMethodBeat.m2505o(98988);
                }
            });
        }
        AppMethodBeat.m2505o(98994);
    }

    public int getEGLContextHash() {
        AppMethodBeat.m2504i(98995);
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        if (egl10 != null) {
            EGLContext eglGetCurrentContext = egl10.eglGetCurrentContext();
            if (eglGetCurrentContext != null) {
                int hashCode = eglGetCurrentContext.hashCode();
                AppMethodBeat.m2505o(98995);
                return hashCode;
            }
        }
        AppMethodBeat.m2505o(98995);
        return 0;
    }

    /* renamed from: d */
    public void mo75388d() {
        AppMethodBeat.m2504i(98996);
        if (this.f18143d != null) {
            getEGLContextHash();
            this.f18143d.mo75462n();
        }
        AppMethodBeat.m2505o(98996);
    }

    /* renamed from: a */
    public void mo75385a(byte[] bArr) {
        AppMethodBeat.m2504i(98997);
        if (this.f18145f != null) {
            this.f18145f.mo50384b();
            this.f18145f.mo50383a(bArr);
        }
        AppMethodBeat.m2505o(98997);
    }

    /* renamed from: e */
    public void mo12505e() {
        AppMethodBeat.m2504i(98998);
        if (this.f18145f != null) {
            this.f18145f.mo50384b();
        }
        this.f18143d.mo75460l();
        AppMethodBeat.m2505o(98998);
    }

    /* renamed from: f */
    public void mo12506f() {
        AppMethodBeat.m2504i(98999);
        if (this.f18145f != null) {
            this.f18145f.mo50382a();
        }
        this.f18143d.mo75461m();
        AppMethodBeat.m2505o(98999);
    }

    /* renamed from: g */
    public void mo12507g() {
        AppMethodBeat.m2504i(99000);
        C17862b.m27955a();
        AppMethodBeat.m2505o(99000);
    }

    public void setZOrderMediaOverlay(boolean z) {
        AppMethodBeat.m2504i(99001);
        if (this.f18140a != null) {
            this.f18140a.setZOrderMediaOverlay(z);
        }
        AppMethodBeat.m2505o(99001);
    }

    public C41052ge getVectorMapDelegate() {
        return this;
    }

    public int getWidth() {
        AppMethodBeat.m2504i(99002);
        if (this.f18140a != null) {
            int width = this.f18140a.getWidth();
            AppMethodBeat.m2505o(99002);
            return width;
        }
        AppMethodBeat.m2505o(99002);
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public int getHeight() {
        AppMethodBeat.m2504i(99003);
        if (this.f18140a != null) {
            int height = this.f18140a.getHeight();
            AppMethodBeat.m2505o(99003);
            return height;
        }
        AppMethodBeat.m2505o(99003);
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* renamed from: a */
    public boolean mo50453a(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99004);
        if (this.f18144e != null) {
            boolean onTouch = this.f18144e.onTouch(null, motionEvent);
            AppMethodBeat.m2505o(99004);
            return onTouch;
        }
        AppMethodBeat.m2505o(99004);
        return false;
    }

    /* renamed from: h */
    public void mo75389h() {
        AppMethodBeat.m2504i(99005);
        if (this.f18140a != null) {
            this.f18140a.mo12502a_();
        }
        AppMethodBeat.m2505o(99005);
    }

    /* renamed from: i */
    public Context mo65138i() {
        return this.f18141b;
    }

    /* renamed from: a */
    public void mo12500a(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(99006);
        this.f18143d.mo75428a(gl10);
        AppMethodBeat.m2505o(99006);
    }

    /* renamed from: a */
    public void mo12499a(GL10 gl10, int i, int i2) {
        AppMethodBeat.m2504i(99007);
        this.f18143d.mo75412a(i, i2);
        AppMethodBeat.m2505o(99007);
    }

    /* renamed from: j */
    public void mo12510j() {
    }

    /* renamed from: a */
    public boolean mo12501a(GL10 gl10) {
        AppMethodBeat.m2504i(99008);
        boolean b = this.f18143d.mo75439b(gl10);
        AppMethodBeat.m2505o(99008);
        return b;
    }

    /* renamed from: k */
    public void mo75390k() {
        AppMethodBeat.m2504i(99009);
        if (this.f18141b == null) {
            AppMethodBeat.m2505o(99009);
            return;
        }
        this.f18144e = new C16266gp(this);
        if (this.f18143d == null) {
            this.f18143d = new C46789gm(this.f18141b, this);
        }
        this.f18142c = new C8889f(this.f18143d);
        this.f18144e.mo29423a(this.f18143d);
        WindowManager windowManager = (WindowManager) this.f18141b.getSystemService("window");
        this.f18143d.mo75434b(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        this.f18145f = new C31052gy(mo75387c());
        this.f18145f.start();
        AppMethodBeat.m2505o(99009);
    }

    /* renamed from: a */
    private void m88789a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(99010);
        this.f18143d.mo12440a().mo58790a(f, f2, 0, z);
        AppMethodBeat.m2505o(99010);
    }

    /* renamed from: a */
    private float mo50431a(float f) {
        AppMethodBeat.m2504i(99011);
        int i = (int) f;
        float pow = (((float) (1 << (i - 3))) * 3.0517578E-5f) * ((float) Math.pow(2.0d, (double) (f - ((float) i))));
        AppMethodBeat.m2505o(99011);
        return pow;
    }

    /* renamed from: l */
    public void mo75391l() {
        AppMethodBeat.m2504i(99012);
        if (this.f18143d != null) {
            this.f18143d.mo75465q();
        }
        AppMethodBeat.m2505o(99012);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: m */
    public boolean mo75392m() {
        AppMethodBeat.m2504i(99013);
        Context i = mo65138i();
        if (i == null) {
            AppMethodBeat.m2505o(99013);
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) i.getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        if (VERSION.SDK_INT < 14) {
            AppMethodBeat.m2505o(99013);
            return isEnabled;
        }
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (isEnabled && isTouchExplorationEnabled) {
            AppMethodBeat.m2505o(99013);
            return true;
        }
        AppMethodBeat.m2505o(99013);
        return false;
    }

    /* renamed from: n */
    public boolean mo75393n() {
        AppMethodBeat.m2504i(99014);
        if (this.f18143d == null || !this.f18143d.mo75399F()) {
            AppMethodBeat.m2505o(99014);
            return false;
        }
        AppMethodBeat.m2505o(99014);
        return true;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }
}
