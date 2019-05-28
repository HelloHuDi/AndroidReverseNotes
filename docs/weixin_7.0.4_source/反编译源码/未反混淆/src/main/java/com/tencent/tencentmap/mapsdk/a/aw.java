package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.m;
import com.tencent.tencentmap.mapsdk.maps.a.gg;
import com.tencent.tencentmap.mapsdk.maps.a.hw;
import com.tencent.tencentmap.mapsdk.maps.a.hx;
import com.tencent.tencentmap.mapsdk.maps.a.hz;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import java.util.List;

public class aw extends by implements cb {
    private iz a = null;
    private at b = null;
    private ac c = null;
    private View d = null;
    private View e = null;
    private View f = null;
    private View g = null;
    private ViewGroup h = null;
    private LinearLayout i = null;
    private boolean j = false;
    private final int k = 1;
    private final int l = 2;
    private an m = null;
    private m n = null;
    private com.tencent.tencentmap.mapsdk.a.aj.b o = null;
    private Handler p = new Handler() {
        public void handleMessage(Message message) {
            AppMethodBeat.i(100690);
            if (aw.this.j) {
                AppMethodBeat.o(100690);
                return;
            }
            Object obj = message.obj;
            if (obj == null) {
                AppMethodBeat.o(100690);
                return;
            }
            aw.a(aw.this, (b) obj);
            super.handleMessage(message);
            AppMethodBeat.o(100690);
        }
    };
    private a q = new a() {
        private de b = null;
        private boolean c = false;

        public void a() {
            this.c = false;
            this.b = null;
        }

        public void a(MotionEvent motionEvent) {
            AppMethodBeat.i(100691);
            if (aw.this.a == null || aw.this.a.b() == null || !this.c || this.b == null) {
                AppMethodBeat.o(100691);
                return;
            }
            m s = this.b.s();
            switch (motionEvent.getAction()) {
                case 0:
                    AppMethodBeat.o(100691);
                    return;
                case 1:
                case 3:
                case 4:
                    this.c = false;
                    if (s != null) {
                        s.c(this.b);
                    }
                    if (aw.this.n != null) {
                        aw.this.n.c(this.b);
                    }
                    this.b = null;
                    break;
                case 2:
                    this.b.a(ic.a(aw.this.a.b().t().a(new DoublePoint((double) ((int) motionEvent.getX()), (double) ((int) motionEvent.getY())))));
                    if (s != null) {
                        s.b(this.b);
                    }
                    if (aw.this.n != null) {
                        aw.this.n.b(this.b);
                        AppMethodBeat.o(100691);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(100691);
        }

        public void a(String str) {
            AppMethodBeat.i(100692);
            if (str.trim().length() == 0) {
                this.b = null;
                this.c = false;
                AppMethodBeat.o(100692);
                return;
            }
            this.b = aw.a(aw.this, str);
            if (this.b != null) {
                if (this.b.i()) {
                    this.c = true;
                    if (aw.this.n != null) {
                        aw.this.n.a(this.b);
                    }
                } else {
                    this.b = null;
                    this.c = false;
                    AppMethodBeat.o(100692);
                    return;
                }
            }
            AppMethodBeat.o(100692);
        }
    };
    private com.tencent.tencentmap.mapsdk.a.an.a r = new com.tencent.tencentmap.mapsdk.a.an.a() {
    };

    public interface a {
        void a();

        void a(MotionEvent motionEvent);

        void a(String str);
    }

    static class b {
        String a;
        GeoPoint b;
        boolean c;
        hx d;

        private b() {
            this.a = "";
            this.b = null;
            this.c = false;
            this.d = null;
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public aw(ac acVar, gg ggVar) {
        AppMethodBeat.i(100693);
        this.a = (iz) ggVar.getVectorMapDelegate();
        this.c = acVar;
        if (this.a == null) {
            AppMethodBeat.o(100693);
            return;
        }
        this.a.n = this.q;
        if (this.a.a(hx.class) == null) {
            this.a.a(hx.class, (cb) this);
        }
        AppMethodBeat.o(100693);
    }

    public void a() {
        AppMethodBeat.i(100694);
        if (this.a == null) {
            AppMethodBeat.o(100694);
            return;
        }
        this.j = true;
        if (this.p != null) {
            this.p.removeCallbacksAndMessages(null);
        }
        this.a.b(hx.class);
        this.a = null;
        if (this.n != null) {
            this.n = null;
        }
        if (this.o != null) {
            this.o = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        if (this.h != null) {
            this.h.removeAllViews();
            this.h = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        if (this.d != null) {
            ViewGroup viewGroup = (ViewGroup) this.d;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.d.setBackgroundDrawable(null);
            this.d = null;
        }
        AppMethodBeat.o(100694);
    }

    /* Access modifiers changed, original: 0000 */
    public de a(df dfVar, at atVar) {
        AppMethodBeat.i(100695);
        if (this.a == null) {
            AppMethodBeat.o(100695);
            return null;
        }
        if (this.b == null) {
            this.b = atVar;
        }
        hx hxVar = new hx(this.a);
        hxVar.a(dfVar);
        this.a.a((hz) hxVar);
        if (this.a.a(hx.class) == null) {
            this.a.a(hx.class, (cb) this);
        }
        this.a.b().a();
        de deVar = new de(dfVar, atVar, hxVar.A());
        hxVar.y = deVar;
        this.a.a(hxVar);
        AppMethodBeat.o(100695);
        return deVar;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:16:0x003e, code skipped:
            r5.a.b().a();
            com.tencent.matrix.trace.core.AppMethodBeat.o(100696);
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(String str) {
        AppMethodBeat.i(100696);
        if (this.a == null) {
            AppMethodBeat.o(100696);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str, false);
                if (b == null || !(b instanceof hx)) {
                } else {
                    b.d();
                    if (str.equals(this.a.r())) {
                        this.a.a("", false);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100696);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, float f, float f2) {
        AppMethodBeat.i(100697);
        if (this.a == null) {
            AppMethodBeat.o(100697);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    ((hx) b).b(f, f2);
                    this.a.b().a();
                    AppMethodBeat.o(100697);
                } else {
                    AppMethodBeat.o(100697);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100697);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, boolean z) {
        AppMethodBeat.i(100698);
        if (this.a == null) {
            AppMethodBeat.o(100698);
            return;
        }
        this.a.b().a();
        AppMethodBeat.o(100698);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, cm cmVar) {
        AppMethodBeat.i(100699);
        if (this.a == null) {
            AppMethodBeat.o(100699);
            return;
        }
        synchronized (this.a.b) {
            try {
                hx k = k(str);
                if (k != null) {
                    k.a(cmVar);
                }
                i(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100699);
            }
        }
        this.a.b().a();
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:21:0x004c, code skipped:
            r4.a.b().a();
            com.tencent.matrix.trace.core.AppMethodBeat.o(100700);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(String str, db dbVar) {
        AppMethodBeat.i(100700);
        if (this.a == null) {
            AppMethodBeat.o(100700);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    hx hxVar = (hx) b;
                    hxVar.a(ic.a(dbVar));
                    if (str.equals(this.a.r()) && hxVar.z != null) {
                        hxVar.z.b(ic.a(dbVar));
                    }
                } else {
                    AppMethodBeat.o(100700);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100700);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, String str2) {
        AppMethodBeat.i(100701);
        if (this.a == null) {
            AppMethodBeat.o(100701);
            return;
        }
        synchronized (this.a.b) {
            try {
                this.a.a("", true, true);
                i(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100701);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(String str, String str2) {
        AppMethodBeat.i(100702);
        if (this.a == null) {
            AppMethodBeat.o(100702);
            return;
        }
        synchronized (this.a.b) {
            try {
                i(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100702);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(String str, boolean z) {
        AppMethodBeat.i(100703);
        if (this.a == null) {
            AppMethodBeat.o(100703);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.a(z);
                    this.a.b().a();
                    AppMethodBeat.o(100703);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100703);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean b(String str) {
        boolean z = false;
        AppMethodBeat.i(100704);
        if (this.a == null) {
            AppMethodBeat.o(100704);
            return false;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    b = (hx) b;
                    if (b.y.d()) {
                        z = false;
                        a(b, false, null);
                        this.a.b().a();
                        AppMethodBeat.o(100704);
                        return true;
                    }
                    AppMethodBeat.o(100704);
                    return false;
                } else {
                    AppMethodBeat.o(100704);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100704);
            }
        }
        return z;
    }

    private void i(String str) {
        AppMethodBeat.i(100705);
        hx k = k(str);
        if (k == null || !k.y.d()) {
            AppMethodBeat.o(100705);
            return;
        }
        a(k, true, false);
        AppMethodBeat.o(100705);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean c(String str) {
        AppMethodBeat.i(100706);
        if (this.a == null) {
            AppMethodBeat.o(100706);
            return false;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    ((hx) b).u();
                    AppMethodBeat.o(100706);
                    return true;
                } else {
                    AppMethodBeat.o(100706);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100706);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean d(String str) {
        AppMethodBeat.i(100707);
        if (this.a == null) {
            AppMethodBeat.o(100707);
            return false;
        }
        hz b = this.a.b(str);
        if (b == null) {
            AppMethodBeat.o(100707);
            return false;
        } else if (b instanceof hx) {
            hx hxVar = (hx) b;
            if (hxVar.z == null || !hxVar.z.j()) {
                AppMethodBeat.o(100707);
                return false;
            }
            AppMethodBeat.o(100707);
            return true;
        } else {
            AppMethodBeat.o(100707);
            return false;
        }
    }

    private de j(String str) {
        AppMethodBeat.i(100708);
        if (str == null || str.equals("") || this.a == null) {
            AppMethodBeat.o(100708);
            return null;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    de deVar = ((hx) b).y;
                    AppMethodBeat.o(100708);
                    return deVar;
                } else {
                    AppMethodBeat.o(100708);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100708);
            }
        }
        return null;
    }

    public boolean a(hz hzVar, boolean z, GeoPoint geoPoint) {
        AppMethodBeat.i(100709);
        hx hxVar = (hx) hzVar;
        b bVar = new b();
        bVar.a = hxVar.A();
        bVar.b = hxVar.g();
        bVar.d = hxVar;
        bVar.c = z;
        if (this.p != null) {
            this.p.removeCallbacksAndMessages(bVar);
            Message obtainMessage = this.p.obtainMessage();
            obtainMessage.obj = bVar;
            this.p.sendMessage(obtainMessage);
        }
        AppMethodBeat.o(100709);
        return true;
    }

    private void a(b bVar) {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(100710);
        if (bVar == null) {
            AppMethodBeat.o(100710);
        } else if (this.a == null) {
            AppMethodBeat.o(100710);
        } else {
            String str = bVar.a;
            hx hxVar = bVar.d;
            boolean z3 = bVar.c;
            de deVar = hxVar == null ? null : hxVar.y;
            if (deVar == null) {
                this.a.a("", true);
                AppMethodBeat.o(100710);
            } else if (this.a.s != null && z3 && this.a.s.a(deVar)) {
                AppMethodBeat.o(100710);
            } else if (deVar.d()) {
                boolean j;
                if (!(this.a.W == null || this.a.V)) {
                    if (this.a.W == hxVar.z) {
                        j = this.a.W.j();
                        if (hxVar.h()) {
                            hxVar.a(z3, true);
                        }
                        if (z3) {
                            hw hwVar = this.a.W;
                            if (j) {
                                z2 = false;
                            }
                            hwVar.d(z2);
                            AppMethodBeat.o(100710);
                            return;
                        }
                        this.a.W.d(true);
                        AppMethodBeat.o(100710);
                        return;
                    }
                    this.a.W.d(false);
                }
                if (hxVar.z != null) {
                    j = hxVar.z.j();
                    if (z3) {
                        hw hwVar2 = hxVar.z;
                        if (!j) {
                            z = true;
                        }
                        hwVar2.d(z);
                        if (!j) {
                            this.a.W = hxVar.z;
                        }
                    }
                }
                a(hxVar, z3, z3);
                this.a.a(str, true);
                AppMethodBeat.o(100710);
            } else {
                AppMethodBeat.o(100710);
            }
        }
    }

    private void a(hx hxVar, boolean z, boolean z2) {
        AppMethodBeat.i(100711);
        if (this.o == null) {
            hxVar.v();
        } else {
            hxVar.a(this.c, this.o);
        }
        hxVar.a(z, z2);
        AppMethodBeat.o(100711);
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        AppMethodBeat.i(100712);
        if (this.a == null) {
            AppMethodBeat.o(100712);
            return;
        }
        this.a.c(hx.class);
        this.a.a("", false);
        this.q.a();
        AppMethodBeat.o(100712);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, float f) {
        AppMethodBeat.i(100713);
        if (this.a == null) {
            AppMethodBeat.o(100713);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    ((hx) b).a(f);
                    this.a.b().a();
                    AppMethodBeat.o(100713);
                } else {
                    AppMethodBeat.o(100713);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100713);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(String str, float f) {
        AppMethodBeat.i(100714);
        if (this.a == null) {
            AppMethodBeat.o(100714);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    ((hx) b).b(f);
                    this.a.b().a();
                    AppMethodBeat.o(100714);
                } else {
                    AppMethodBeat.o(100714);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100714);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public float e(String str) {
        AppMethodBeat.i(100715);
        if (this.a == null) {
            AppMethodBeat.o(100715);
            return 0.0f;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    float n = ((hx) b).n();
                    AppMethodBeat.o(100715);
                    return n;
                } else {
                    AppMethodBeat.o(100715);
                    return 0.0f;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100715);
            }
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:19:0x003a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(100716);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public db f(String str) {
        AppMethodBeat.i(100716);
        if (this.a == null) {
            AppMethodBeat.o(100716);
            return null;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    GeoPoint g = ((hx) b).g();
                    db a;
                    if (g != null) {
                        a = ic.a(g);
                    } else {
                        a = null;
                    }
                } else {
                    AppMethodBeat.o(100716);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100716);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:19:0x0038, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(100717);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(String str, boolean z) {
        AppMethodBeat.i(100717);
        if (this.a == null) {
            AppMethodBeat.o(100717);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    hx hxVar = (hx) b;
                    hxVar.c(z);
                    if (!z) {
                        hxVar.a(hxVar.g());
                    }
                } else {
                    AppMethodBeat.o(100717);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100717);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean g(String str) {
        AppMethodBeat.i(100718);
        if (this.a == null) {
            AppMethodBeat.o(100718);
            return false;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    boolean o = ((hx) b).o();
                    AppMethodBeat.o(100718);
                    return o;
                } else {
                    AppMethodBeat.o(100718);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100718);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, int i, int i2) {
        AppMethodBeat.i(100719);
        if (this.a == null) {
            AppMethodBeat.o(100719);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    ((hx) b).a(i, i2);
                    AppMethodBeat.o(100719);
                } else {
                    AppMethodBeat.o(100719);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100719);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void c(String str, float f) {
        AppMethodBeat.i(100720);
        if (this.a == null) {
            AppMethodBeat.o(100720);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str, false);
                if (b == null) {
                } else {
                    b.c(f);
                    this.a.a(b);
                    this.a.b().a();
                    AppMethodBeat.o(100720);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100720);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:17:0x0030, code skipped:
            r1 = new java.util.ArrayList(2);
            r1.add(r0.t());
            r2 = r0.z;
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code skipped:
            if (r2 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:20:0x0045, code skipped:
            if (r2.j() == false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:21:0x0047, code skipped:
            r1.add(r0.z.k());
     */
    /* JADX WARNING: Missing block: B:22:0x0050, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(100721);
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public List<j> h(String str) {
        AppMethodBeat.i(100721);
        if (this.a == null) {
            AppMethodBeat.o(100721);
            return null;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    hx hxVar = (hx) b;
                } else {
                    AppMethodBeat.o(100721);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100721);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(m mVar) {
        this.n = mVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(com.tencent.tencentmap.mapsdk.a.aj.b bVar) {
        this.o = bVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, int i) {
        AppMethodBeat.i(100722);
        if (this.a == null) {
            AppMethodBeat.o(100722);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hx) {
                    ((hx) b).a_(i);
                    this.a.b().a();
                    AppMethodBeat.o(100722);
                } else {
                    AppMethodBeat.o(100722);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100722);
            }
        }
    }

    private hx k(String str) {
        AppMethodBeat.i(100723);
        hz b = this.a.b(str);
        if (b == null) {
            AppMethodBeat.o(100723);
            return null;
        } else if (b instanceof hx) {
            hx hxVar = (hx) b;
            AppMethodBeat.o(100723);
            return hxVar;
        } else {
            AppMethodBeat.o(100723);
            return null;
        }
    }
}
