package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.tencentmap.mapsdk.maps.a.gg;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import com.tencent.tencentmap.mapsdk.maps.a.ld;
import com.tencent.tencentmap.mapsdk.maps.a.le;
import com.tencent.tencentmap.mapsdk.maps.a.le.b;
import com.tencent.tencentmap.mapsdk.maps.a.lf;
import com.tencent.tencentmap.mapsdk.maps.a.lh;
import com.tencent.tencentmap.mapsdk.maps.a.li;
import com.tencent.tencentmap.mapsdk.maps.a.lj;
import com.tencent.tencentmap.mapsdk.maps.a.lq;
import java.util.ArrayList;
import java.util.List;

public class bi extends cf implements as, com.tencent.tencentmap.mapsdk.maps.a.li.a {
    public Handler a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AppMethodBeat.i(100807);
            if (!(message == null || message.obj == null)) {
                li liVar = (li) message.obj;
                if (liVar.a == 0) {
                    if (bi.this.e != null) {
                        bi.this.e.a(liVar.b, liVar.c);
                        AppMethodBeat.o(100807);
                        return;
                    }
                } else if (liVar.a == 1) {
                    if (bi.this.f != null) {
                        bi.this.f.a(liVar.d, liVar.e);
                        bi.this.f.g();
                        AppMethodBeat.o(100807);
                        return;
                    }
                } else if (liVar.a == 3 && ic.e == 1) {
                    if (TextUtils.equals(Token.WX_TOKEN_PLATFORMID_VALUE, Token.WX_TOKEN_PLATFORMID_VALUE)) {
                        AppMethodBeat.o(100807);
                        return;
                    } else if (bi.this.b == null) {
                        AppMethodBeat.o(100807);
                        return;
                    } else {
                        if (bi.this.h == null) {
                            bi.this.h = new ld(bi.this.b.getContext().getApplicationContext());
                            bi.this.h.a(bi.this.i);
                        }
                        bi.this.h.a(bi.this.b);
                    }
                }
            }
            AppMethodBeat.o(100807);
        }
    };
    private ac b = null;
    private ak c;
    private iz d;
    private lj e;
    private lh f;
    private lf g;
    private ld h;
    private com.tencent.tencentmap.mapsdk.maps.a.jk.a i;
    private int j;
    private List<le> k = new ArrayList();
    private boolean l = false;

    public interface a {
        void a();
    }

    public bi(ac acVar, gg ggVar) {
        AppMethodBeat.i(100809);
        this.b = acVar;
        if (ggVar == null) {
            AppMethodBeat.o(100809);
            return;
        }
        this.d = (iz) ggVar.getVectorMapDelegate();
        this.c = this.d.P();
        if (ggVar instanceof View) {
            View view = (View) ggVar;
            if (this.b.indexOfChild(view) < 0) {
                this.b.addView(view, 0, new LayoutParams(-1, -1));
                this.b.requestLayout();
            }
        }
        int i = 4;
        int i2 = 20;
        if (this.d.b() != null) {
            i = this.d.b().b();
            i2 = this.d.b().c();
        }
        this.f = new lh(this.b.getContext().getApplicationContext(), i, i2);
        this.d.a(this.f);
        this.g = new lf(this.b.getContext(), this.b);
        this.d.a(this.g);
        this.e = new lj(this.b.getContext(), this.d);
        this.k.add(this.f);
        this.k.add(this.e);
        this.d.a((com.tencent.tencentmap.mapsdk.maps.a.li.a) this);
        this.d.a((as) this);
        b(0, 0);
        AppMethodBeat.o(100809);
    }

    public void a() {
        AppMethodBeat.i(100810);
        if (this.b == null || this.d == null) {
            AppMethodBeat.o(100810);
            return;
        }
        if (this.a != null) {
            this.a.removeCallbacksAndMessages(null);
        }
        this.b.removeAllViews();
        this.d.a(null);
        for (le a : this.k) {
            a.a();
        }
        this.e = null;
        this.e = null;
        this.k.clear();
        this.k = null;
        this.d = null;
        this.b = null;
        AppMethodBeat.o(100810);
    }

    public void a(a aVar) {
        AppMethodBeat.i(100811);
        if (this.e != null) {
            this.e.a(aVar);
        }
        AppMethodBeat.o(100811);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(boolean z) {
        AppMethodBeat.i(100812);
        this.e.a(z);
        AppMethodBeat.o(100812);
    }

    /* Access modifiers changed, original: 0000 */
    public void b(boolean z) {
        AppMethodBeat.i(100813);
        this.d.h(z);
        AppMethodBeat.o(100813);
    }

    /* Access modifiers changed, original: 0000 */
    public void c(boolean z) {
        AppMethodBeat.i(100814);
        this.d.b(z);
        AppMethodBeat.o(100814);
    }

    /* Access modifiers changed, original: 0000 */
    public void d(boolean z) {
        AppMethodBeat.i(100815);
        this.d.d(z);
        AppMethodBeat.o(100815);
    }

    /* Access modifiers changed, original: 0000 */
    public void e(boolean z) {
        AppMethodBeat.i(100816);
        this.d.e(z);
        AppMethodBeat.o(100816);
    }

    /* Access modifiers changed, original: 0000 */
    public void f(boolean z) {
        AppMethodBeat.i(100817);
        this.d.f(z);
        AppMethodBeat.o(100817);
    }

    /* Access modifiers changed, original: 0000 */
    public void g(boolean z) {
        AppMethodBeat.i(100818);
        this.d.g(z);
        c(z);
        d(z);
        e(z);
        f(z);
        AppMethodBeat.o(100818);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean b() {
        AppMethodBeat.i(100819);
        boolean v = this.d.v();
        AppMethodBeat.o(100819);
        return v;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean c() {
        AppMethodBeat.i(100820);
        boolean y = this.d.y();
        AppMethodBeat.o(100820);
        return y;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean d() {
        AppMethodBeat.i(100821);
        boolean z = this.d.z();
        AppMethodBeat.o(100821);
        return z;
    }

    public boolean e() {
        AppMethodBeat.i(100822);
        if (this.g != null) {
            boolean b = this.g.b();
            AppMethodBeat.o(100822);
            return b;
        }
        AppMethodBeat.o(100822);
        return false;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(100823);
        this.j = i2;
        for (le leVar : this.k) {
            leVar.a(i, i2);
            leVar.a(this.b);
        }
        AppMethodBeat.o(100823);
    }

    /* Access modifiers changed, original: protected */
    public void f() {
        AppMethodBeat.i(100824);
        for (le a : this.k) {
            a.a(this.b);
        }
        AppMethodBeat.o(100824);
    }

    /* Access modifiers changed, original: 0000 */
    public void h(boolean z) {
        AppMethodBeat.i(100825);
        if (this.f != null) {
            this.f.b(z);
        }
        AppMethodBeat.o(100825);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean g() {
        AppMethodBeat.i(100826);
        if (this.f != null) {
            boolean f = this.f.f();
            AppMethodBeat.o(100826);
            return f;
        }
        AppMethodBeat.o(100826);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i) {
        AppMethodBeat.i(100827);
        if (this.f != null) {
            this.f.a(b.a(i));
            f();
        }
        AppMethodBeat.o(100827);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, int[] iArr) {
        AppMethodBeat.i(100828);
        if (this.f != null) {
            b a = b.a(i);
            this.f.a(a);
            switch (a) {
                case LEFT_TOP:
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP, iArr[0]);
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT, iArr[1]);
                    break;
                case LEFT_BOTTOM:
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM, iArr[0]);
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT, iArr[1]);
                    break;
                case RIGHT_BOTTOM:
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM, iArr[0]);
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT, iArr[1]);
                    break;
                case RIGHT_TOP:
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP, iArr[0]);
                    this.f.a(com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT, iArr[1]);
                    break;
            }
            this.f.d();
            f();
        }
        AppMethodBeat.o(100828);
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i) {
        AppMethodBeat.i(100829);
        if (this.f != null) {
            this.f.b(b.a(i));
            f();
        }
        AppMethodBeat.o(100829);
    }

    public void i(boolean z) {
        AppMethodBeat.i(100830);
        if (this.f == null || this.d == null || this.d.b() == null) {
            AppMethodBeat.o(100830);
            return;
        }
        if (z) {
            this.f.b();
        }
        this.f.a(lq.g());
        this.f.a(this.d.Q(), this.d.b().e());
        AppMethodBeat.o(100830);
    }

    public void a(li liVar) {
        AppMethodBeat.i(100831);
        if (!(liVar == null || liVar.a == -1)) {
            this.a.sendMessage(this.a.obtainMessage(liVar.a, liVar));
        }
        AppMethodBeat.o(100831);
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i, int i2) {
        AppMethodBeat.i(100832);
        if (this.d != null) {
            this.d.b(i, i2);
        }
        AppMethodBeat.o(100832);
    }

    /* Access modifiers changed, original: 0000 */
    public void j(boolean z) {
        AppMethodBeat.i(100833);
        if (!(this.d == null || this.d.b() == null)) {
            this.d.b().j(z);
        }
        AppMethodBeat.o(100833);
    }

    public void k(boolean z) {
        AppMethodBeat.i(100834);
        this.g.a(z);
        AppMethodBeat.o(100834);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(float f) {
        AppMethodBeat.i(100835);
        if (this.f != null) {
            this.f.a(f);
        }
        AppMethodBeat.o(100835);
    }

    public void a(com.tencent.tencentmap.mapsdk.maps.a.lh.a aVar, ak akVar) {
        AppMethodBeat.i(100836);
        if (!(akVar == null || akVar.d() == null || this.f == null || akVar == null)) {
            this.f.a(aVar);
            int e = akVar.e();
            int f = akVar.f();
            this.b.measure(MeasureSpec.makeMeasureSpec(e, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(f, ErrorDialogData.SUPPRESSED));
            a(e, f);
        }
        AppMethodBeat.o(100836);
    }

    public void a(com.tencent.tencentmap.mapsdk.maps.a.jk.a aVar, ak akVar) {
        AppMethodBeat.i(100837);
        if (!(akVar == null || akVar.d() == null)) {
            this.i = aVar;
            int e = akVar.e();
            int f = akVar.f();
            this.b.measure(MeasureSpec.makeMeasureSpec(e, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(f, ErrorDialogData.SUPPRESSED));
            a(e, f);
        }
        AppMethodBeat.o(100837);
    }
}
