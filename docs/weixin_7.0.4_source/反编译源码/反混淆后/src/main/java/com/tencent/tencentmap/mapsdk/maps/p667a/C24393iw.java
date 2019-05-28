package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C44480ak;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.iw */
public class C24393iw extends View implements C44514gg {
    /* renamed from: a */
    private Context f4740a;
    /* renamed from: b */
    private C31061iz f4741b;
    /* renamed from: c */
    private Object f4742c;
    /* renamed from: d */
    private int f4743d;
    /* renamed from: e */
    private int f4744e;
    /* renamed from: f */
    private C44480ak f4745f;
    /* renamed from: g */
    private C31060iy f4746g;
    /* renamed from: h */
    private boolean f4747h = true;
    /* renamed from: i */
    private boolean f4748i = false;

    public C24393iw(Context context, C44480ak c44480ak) {
        super(context);
        AppMethodBeat.m2504i(99883);
        if (!(c44480ak == null || context == null)) {
            Object d = c44480ak.mo70663d();
            if (d == null) {
                AppMethodBeat.m2505o(99883);
                return;
            }
            this.f4740a = context.getApplicationContext();
            this.f4742c = d;
            this.f4743d = c44480ak.mo70664e();
            this.f4744e = c44480ak.mo70665f();
            if (this.f4744e <= 0 || this.f4743d <= 0) {
                this.f4743d = 0;
                this.f4744e = 0;
            }
            this.f4745f = c44480ak;
            this.f4741b = new C31061iz(this, this.f4740a, this.f4745f);
        }
        AppMethodBeat.m2505o(99883);
    }

    /* renamed from: a_ */
    public void mo12502a_() {
        AppMethodBeat.m2504i(99884);
        if (this.f4746g != null) {
            synchronized (this.f4746g) {
                try {
                    this.f4746g.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99884);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(99884);
    }

    /* renamed from: e */
    public void mo12505e() {
        AppMethodBeat.m2504i(99885);
        if (this.f4741b != null) {
            this.f4741b.mo12505e();
        }
        if (this.f4746g != null) {
            this.f4746g.mo50404b();
        }
        m37867b();
        m37868c();
        AppMethodBeat.m2505o(99885);
    }

    /* renamed from: f */
    public void mo12506f() {
        AppMethodBeat.m2504i(99886);
        if (this.f4741b != null) {
            this.f4741b.mo12506f();
        }
        if (this.f4746g != null) {
            this.f4746g.mo50402a();
        }
        AppMethodBeat.m2505o(99886);
    }

    /* renamed from: g */
    public void mo12507g() {
        AppMethodBeat.m2504i(99887);
        if (this.f4741b != null) {
            this.f4741b.mo12507g();
        }
        if (this.f4746g != null) {
            this.f4746g.mo50405c();
        }
        AppMethodBeat.m2505o(99887);
    }

    public void setZOrderMediaOverlay(boolean z) {
    }

    public C41052ge getVectorMapDelegate() {
        return this.f4741b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99888);
        if (this.f4741b != null) {
            boolean a = this.f4741b.mo50453a(motionEvent);
            AppMethodBeat.m2505o(99888);
            return a;
        }
        AppMethodBeat.m2505o(99888);
        return false;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(99889);
        if (this.f4741b != null) {
            this.f4743d = i;
            this.f4744e = i2;
            this.f4741b.mo12499a(null, i, i2);
            this.f4741b.mo50433a(i, i2);
            this.f4741b.mo75389h();
            this.f4747h = true;
        }
        AppMethodBeat.m2505o(99889);
    }

    /* renamed from: b */
    private void m37867b() {
        AppMethodBeat.m2504i(99890);
        if (this.f4741b != null && this.f4747h) {
            this.f4741b.mo12500a(null, null);
            this.f4741b.mo12499a(null, this.f4743d, this.f4744e);
            this.f4741b.mo50433a(this.f4743d, this.f4744e);
            this.f4747h = false;
        }
        AppMethodBeat.m2505o(99890);
    }

    /* renamed from: c */
    private void m37868c() {
        AppMethodBeat.m2504i(99891);
        if (this.f4746g == null) {
            this.f4746g = new C31060iy(this.f4742c, this.f4741b);
        }
        if (!this.f4748i) {
            this.f4746g.start();
            this.f4748i = true;
        }
        AppMethodBeat.m2505o(99891);
    }
}
