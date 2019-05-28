package com.tencent.tencentmap.mapsdk.p666a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36519hz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36899hx;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44514gg;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5885hw;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C16180m;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30989b;
import com.tencent.tencentmap.mapsdk.p666a.C46749an.C36457a;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.aw */
public class C46940aw extends C44486by implements C46756cb {
    /* renamed from: a */
    private C31061iz f18292a = null;
    /* renamed from: b */
    private C44481at f18293b = null;
    /* renamed from: c */
    private C36456ac f18294c = null;
    /* renamed from: d */
    private View f18295d = null;
    /* renamed from: e */
    private View f18296e = null;
    /* renamed from: f */
    private View f18297f = null;
    /* renamed from: g */
    private View f18298g = null;
    /* renamed from: h */
    private ViewGroup f18299h = null;
    /* renamed from: i */
    private LinearLayout f18300i = null;
    /* renamed from: j */
    private boolean f18301j = false;
    /* renamed from: k */
    private final int f18302k = 1;
    /* renamed from: l */
    private final int f18303l = 2;
    /* renamed from: m */
    private C46749an f18304m = null;
    /* renamed from: n */
    private C16180m f18305n = null;
    /* renamed from: o */
    private C30989b f18306o = null;
    /* renamed from: p */
    private Handler f18307p = new C444821();
    /* renamed from: q */
    private C41010a f18308q = new C243342();
    /* renamed from: r */
    private C36457a f18309r = new C243353();

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aw$2 */
    class C243342 implements C41010a {
        /* renamed from: b */
        private C44490de f4596b = null;
        /* renamed from: c */
        private boolean f4597c = false;

        C243342() {
        }

        /* renamed from: a */
        public void mo40423a() {
            this.f4597c = false;
            this.f4596b = null;
        }

        /* renamed from: a */
        public void mo40424a(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(100691);
            if (C46940aw.this.f18292a == null || C46940aw.this.f18292a.mo75386b() == null || !this.f4597c || this.f4596b == null) {
                AppMethodBeat.m2505o(100691);
                return;
            }
            C16180m s = this.f4596b.mo70761s();
            switch (motionEvent.getAction()) {
                case 0:
                    AppMethodBeat.m2505o(100691);
                    return;
                case 1:
                case 3:
                case 4:
                    this.f4597c = false;
                    if (s != null) {
                        s.mo29058c(this.f4596b);
                    }
                    if (C46940aw.this.f18305n != null) {
                        C46940aw.this.f18305n.mo29058c(this.f4596b);
                    }
                    this.f4596b = null;
                    break;
                case 2:
                    this.f4596b.mo70732a(C36520ic.m60471a(C46940aw.this.f18292a.mo75386b().mo20244t().mo29297a(new DoublePoint((double) ((int) motionEvent.getX()), (double) ((int) motionEvent.getY())))));
                    if (s != null) {
                        s.mo29057b(this.f4596b);
                    }
                    if (C46940aw.this.f18305n != null) {
                        C46940aw.this.f18305n.mo29057b(this.f4596b);
                        AppMethodBeat.m2505o(100691);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(100691);
        }

        /* renamed from: a */
        public void mo40425a(String str) {
            AppMethodBeat.m2504i(100692);
            if (str.trim().length() == 0) {
                this.f4596b = null;
                this.f4597c = false;
                AppMethodBeat.m2505o(100692);
                return;
            }
            this.f4596b = C46940aw.m89716a(C46940aw.this, str);
            if (this.f4596b != null) {
                if (this.f4596b.mo70751i()) {
                    this.f4597c = true;
                    if (C46940aw.this.f18305n != null) {
                        C46940aw.this.f18305n.mo29056a(this.f4596b);
                    }
                } else {
                    this.f4596b = null;
                    this.f4597c = false;
                    AppMethodBeat.m2505o(100692);
                    return;
                }
            }
            AppMethodBeat.m2505o(100692);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aw$3 */
    class C243353 implements C36457a {
        C243353() {
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aw$a */
    public interface C41010a {
        /* renamed from: a */
        void mo40423a();

        /* renamed from: a */
        void mo40424a(MotionEvent motionEvent);

        /* renamed from: a */
        void mo40425a(String str);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aw$1 */
    class C444821 extends Handler {
        C444821() {
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(100690);
            if (C46940aw.this.f18301j) {
                AppMethodBeat.m2505o(100690);
                return;
            }
            Object obj = message.obj;
            if (obj == null) {
                AppMethodBeat.m2505o(100690);
                return;
            }
            C46940aw.m89718a(C46940aw.this, (C46751b) obj);
            super.handleMessage(message);
            AppMethodBeat.m2505o(100690);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aw$b */
    static class C46751b {
        /* renamed from: a */
        String f18028a;
        /* renamed from: b */
        GeoPoint f18029b;
        /* renamed from: c */
        boolean f18030c;
        /* renamed from: d */
        C36899hx f18031d;

        private C46751b() {
            this.f18028a = "";
            this.f18029b = null;
            this.f18030c = false;
            this.f18031d = null;
        }

        /* synthetic */ C46751b(C444821 c444821) {
            this();
        }
    }

    public C46940aw(C36456ac c36456ac, C44514gg c44514gg) {
        AppMethodBeat.m2504i(100693);
        this.f18292a = (C31061iz) c44514gg.getVectorMapDelegate();
        this.f18294c = c36456ac;
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100693);
            return;
        }
        this.f18292a.f14279n = this.f18308q;
        if (this.f18292a.mo50428a(C36899hx.class) == null) {
            this.f18292a.mo50447a(C36899hx.class, (C46756cb) this);
        }
        AppMethodBeat.m2505o(100693);
    }

    /* renamed from: a */
    public void mo76205a() {
        AppMethodBeat.m2504i(100694);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100694);
            return;
        }
        this.f18301j = true;
        if (this.f18307p != null) {
            this.f18307p.removeCallbacksAndMessages(null);
        }
        this.f18292a.mo50455b(C36899hx.class);
        this.f18292a = null;
        if (this.f18305n != null) {
            this.f18305n = null;
        }
        if (this.f18306o != null) {
            this.f18306o = null;
        }
        if (this.f18295d != null) {
            this.f18295d = null;
        }
        if (this.f18299h != null) {
            this.f18299h.removeAllViews();
            this.f18299h = null;
        }
        if (this.f18300i != null) {
            this.f18300i = null;
        }
        if (this.f18293b != null) {
            this.f18293b = null;
        }
        if (this.f18294c != null) {
            this.f18294c = null;
        }
        if (this.f18295d != null) {
            ViewGroup viewGroup = (ViewGroup) this.f18295d;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.f18295d.setBackgroundDrawable(null);
            this.f18295d = null;
        }
        AppMethodBeat.m2505o(100694);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C44490de mo70701a(C44491df c44491df, C44481at c44481at) {
        AppMethodBeat.m2504i(100695);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100695);
            return null;
        }
        if (this.f18293b == null) {
            this.f18293b = c44481at;
        }
        C36899hx c36899hx = new C36899hx(this.f18292a);
        c36899hx.mo58873a(c44491df);
        this.f18292a.mo50454a((C36519hz) c36899hx);
        if (this.f18292a.mo50428a(C36899hx.class) == null) {
            this.f18292a.mo50447a(C36899hx.class, (C46756cb) this);
        }
        this.f18292a.mo75386b().mo20154a();
        C44490de c44490de = new C44490de(c44491df, c44481at, c36899hx.mo57757A());
        c36899hx.f15581y = c44490de;
        this.f18292a.mo50443a(c36899hx);
        AppMethodBeat.m2505o(100695);
        return c44490de;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:16:0x003e, code skipped:
            r5.f18292a.mo75386b().mo20154a();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100696);
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo70704a(String str) {
        AppMethodBeat.m2504i(100696);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100696);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50457b(str, false);
                if (b == null || !(b instanceof C36899hx)) {
                } else {
                    b.mo29450d();
                    if (str.equals(this.f18292a.mo50481r())) {
                        this.f18292a.mo50449a("", false);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100696);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70706a(String str, float f, float f2) {
        AppMethodBeat.m2504i(100697);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100697);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    ((C36899hx) b).mo58877b(f, f2);
                    this.f18292a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100697);
                } else {
                    AppMethodBeat.m2505o(100697);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100697);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70712a(String str, boolean z) {
        AppMethodBeat.m2504i(100698);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100698);
            return;
        }
        this.f18292a.mo75386b().mo20154a();
        AppMethodBeat.m2505o(100698);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70709a(String str, C41018cm c41018cm) {
        AppMethodBeat.m2504i(100699);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100699);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36899hx k = m89725k(str);
                if (k != null) {
                    k.mo58872a(c41018cm);
                }
                m89723i(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100699);
            }
        }
        this.f18292a.mo75386b().mo20154a();
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:21:0x004c, code skipped:
            r4.f18292a.mo75386b().mo20154a();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100700);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo70710a(String str, C24343db c24343db) {
        AppMethodBeat.m2504i(100700);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100700);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    C36899hx c36899hx = (C36899hx) b;
                    c36899hx.mo58870a(C36520ic.m60470a(c24343db));
                    if (str.equals(this.f18292a.mo50481r()) && c36899hx.f15582z != null) {
                        c36899hx.f15582z.mo12484b(C36520ic.m60470a(c24343db));
                    }
                } else {
                    AppMethodBeat.m2505o(100700);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100700);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70711a(String str, String str2) {
        AppMethodBeat.m2504i(100701);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100701);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                this.f18292a.mo50450a("", true, true);
                m89723i(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100701);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo70715b(String str, String str2) {
        AppMethodBeat.m2504i(100702);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100702);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                m89723i(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100702);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo70716b(String str, boolean z) {
        AppMethodBeat.m2504i(100703);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100703);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo29442a(z);
                    this.f18292a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100703);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100703);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo70717b(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(100704);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100704);
            return false;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    b = (C36899hx) b;
                    if (b.f15581y.mo70744d()) {
                        z = false;
                        mo29097a(b, false, null);
                        this.f18292a.mo75386b().mo20154a();
                        AppMethodBeat.m2505o(100704);
                        return true;
                    }
                    AppMethodBeat.m2505o(100704);
                    return false;
                } else {
                    AppMethodBeat.m2505o(100704);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100704);
            }
        }
        return z;
    }

    /* renamed from: i */
    private void m89723i(String str) {
        AppMethodBeat.m2504i(100705);
        C36899hx k = m89725k(str);
        if (k == null || !k.f15581y.mo70744d()) {
            AppMethodBeat.m2505o(100705);
            return;
        }
        m89719a(k, true, false);
        AppMethodBeat.m2505o(100705);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public boolean mo70720c(String str) {
        AppMethodBeat.m2504i(100706);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100706);
            return false;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    ((C36899hx) b).mo58898u();
                    AppMethodBeat.m2505o(100706);
                    return true;
                } else {
                    AppMethodBeat.m2505o(100706);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100706);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public boolean mo70721d(String str) {
        AppMethodBeat.m2504i(100707);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100707);
            return false;
        }
        C36519hz b = this.f18292a.mo50456b(str);
        if (b == null) {
            AppMethodBeat.m2505o(100707);
            return false;
        } else if (b instanceof C36899hx) {
            C36899hx c36899hx = (C36899hx) b;
            if (c36899hx.f15582z == null || !c36899hx.f15582z.mo12491j()) {
                AppMethodBeat.m2505o(100707);
                return false;
            }
            AppMethodBeat.m2505o(100707);
            return true;
        } else {
            AppMethodBeat.m2505o(100707);
            return false;
        }
    }

    /* renamed from: j */
    private C44490de m89724j(String str) {
        AppMethodBeat.m2504i(100708);
        if (str == null || str.equals("") || this.f18292a == null) {
            AppMethodBeat.m2505o(100708);
            return null;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    C44490de c44490de = ((C36899hx) b).f15581y;
                    AppMethodBeat.m2505o(100708);
                    return c44490de;
                } else {
                    AppMethodBeat.m2505o(100708);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100708);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo29097a(C36519hz c36519hz, boolean z, GeoPoint geoPoint) {
        AppMethodBeat.m2504i(100709);
        C36899hx c36899hx = (C36899hx) c36519hz;
        C46751b c46751b = new C46751b();
        c46751b.f18028a = c36899hx.mo57757A();
        c46751b.f18029b = c36899hx.mo58885g();
        c46751b.f18031d = c36899hx;
        c46751b.f18030c = z;
        if (this.f18307p != null) {
            this.f18307p.removeCallbacksAndMessages(c46751b);
            Message obtainMessage = this.f18307p.obtainMessage();
            obtainMessage.obj = c46751b;
            this.f18307p.sendMessage(obtainMessage);
        }
        AppMethodBeat.m2505o(100709);
        return true;
    }

    /* renamed from: a */
    private void m89717a(C46751b c46751b) {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(100710);
        if (c46751b == null) {
            AppMethodBeat.m2505o(100710);
        } else if (this.f18292a == null) {
            AppMethodBeat.m2505o(100710);
        } else {
            String str = c46751b.f18028a;
            C36899hx c36899hx = c46751b.f18031d;
            boolean z3 = c46751b.f18030c;
            C44490de c44490de = c36899hx == null ? null : c36899hx.f15581y;
            if (c44490de == null) {
                this.f18292a.mo50449a("", true);
                AppMethodBeat.m2505o(100710);
            } else if (this.f18292a.f14284s != null && z3 && this.f18292a.f14284s.mo50171a(c44490de)) {
                AppMethodBeat.m2505o(100710);
            } else if (c44490de.mo70744d()) {
                boolean j;
                if (!(this.f18292a.f14209W == null || this.f18292a.f14208V)) {
                    if (this.f18292a.f14209W == c36899hx.f15582z) {
                        j = this.f18292a.f14209W.mo12491j();
                        if (c36899hx.mo58886h()) {
                            c36899hx.mo58875a(z3, true);
                        }
                        if (z3) {
                            C5885hw c5885hw = this.f18292a.f14209W;
                            if (j) {
                                z2 = false;
                            }
                            c5885hw.mo12486d(z2);
                            AppMethodBeat.m2505o(100710);
                            return;
                        }
                        this.f18292a.f14209W.mo12486d(true);
                        AppMethodBeat.m2505o(100710);
                        return;
                    }
                    this.f18292a.f14209W.mo12486d(false);
                }
                if (c36899hx.f15582z != null) {
                    j = c36899hx.f15582z.mo12491j();
                    if (z3) {
                        C5885hw c5885hw2 = c36899hx.f15582z;
                        if (!j) {
                            z = true;
                        }
                        c5885hw2.mo12486d(z);
                        if (!j) {
                            this.f18292a.f14209W = c36899hx.f15582z;
                        }
                    }
                }
                m89719a(c36899hx, z3, z3);
                this.f18292a.mo50449a(str, true);
                AppMethodBeat.m2505o(100710);
            } else {
                AppMethodBeat.m2505o(100710);
            }
        }
    }

    /* renamed from: a */
    private void m89719a(C36899hx c36899hx, boolean z, boolean z2) {
        AppMethodBeat.m2504i(100711);
        if (this.f18306o == null) {
            c36899hx.mo58899v();
        } else {
            c36899hx.mo58871a(this.f18294c, this.f18306o);
        }
        c36899hx.mo58875a(z, z2);
        AppMethodBeat.m2505o(100711);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo70713b() {
        AppMethodBeat.m2504i(100712);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100712);
            return;
        }
        this.f18292a.mo50465c(C36899hx.class);
        this.f18292a.mo50449a("", false);
        this.f18308q.mo40423a();
        AppMethodBeat.m2505o(100712);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70705a(String str, float f) {
        AppMethodBeat.m2504i(100713);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100713);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    ((C36899hx) b).mo58867a(f);
                    this.f18292a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100713);
                } else {
                    AppMethodBeat.m2505o(100713);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100713);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo70714b(String str, float f) {
        AppMethodBeat.m2504i(100714);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100714);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    ((C36899hx) b).mo58876b(f);
                    this.f18292a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100714);
                } else {
                    AppMethodBeat.m2505o(100714);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100714);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public float mo70722e(String str) {
        AppMethodBeat.m2504i(100715);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100715);
            return 0.0f;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    float n = ((C36899hx) b).mo58892n();
                    AppMethodBeat.m2505o(100715);
                    return n;
                } else {
                    AppMethodBeat.m2505o(100715);
                    return 0.0f;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100715);
            }
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:19:0x003a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100716);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public C24343db mo70723f(String str) {
        AppMethodBeat.m2504i(100716);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100716);
            return null;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    GeoPoint g = ((C36899hx) b).mo58885g();
                    C24343db a;
                    if (g != null) {
                        a = C36520ic.m60471a(g);
                    } else {
                        a = null;
                    }
                } else {
                    AppMethodBeat.m2505o(100716);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100716);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:19:0x0038, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100717);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public void mo70719c(String str, boolean z) {
        AppMethodBeat.m2504i(100717);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100717);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    C36899hx c36899hx = (C36899hx) b;
                    c36899hx.mo58881c(z);
                    if (!z) {
                        c36899hx.mo58870a(c36899hx.mo58885g());
                    }
                } else {
                    AppMethodBeat.m2505o(100717);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100717);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public boolean mo70724g(String str) {
        AppMethodBeat.m2504i(100718);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100718);
            return false;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    boolean o = ((C36899hx) b).mo58893o();
                    AppMethodBeat.m2505o(100718);
                    return o;
                } else {
                    AppMethodBeat.m2505o(100718);
                    return false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100718);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70708a(String str, int i, int i2) {
        AppMethodBeat.m2504i(100719);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100719);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    ((C36899hx) b).mo58868a(i, i2);
                    AppMethodBeat.m2505o(100719);
                } else {
                    AppMethodBeat.m2505o(100719);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100719);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo70718c(String str, float f) {
        AppMethodBeat.m2504i(100720);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100720);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50457b(str, false);
                if (b == null) {
                } else {
                    b.mo50175c(f);
                    this.f18292a.mo50454a(b);
                    this.f18292a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100720);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100720);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:17:0x0030, code skipped:
            r1 = new java.util.ArrayList(2);
            r1.add(r0.mo58897t());
            r2 = r0.f15582z;
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code skipped:
            if (r2 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:20:0x0045, code skipped:
            if (r2.mo12491j() == false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:21:0x0047, code skipped:
            r1.add(r0.f15582z.mo12492k());
     */
    /* JADX WARNING: Missing block: B:22:0x0050, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100721);
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public List<C41717j> mo70725h(String str) {
        AppMethodBeat.m2504i(100721);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100721);
            return null;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    C36899hx c36899hx = (C36899hx) b;
                } else {
                    AppMethodBeat.m2505o(100721);
                    return null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100721);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70703a(C16180m c16180m) {
        this.f18305n = c16180m;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70702a(C30989b c30989b) {
        this.f18306o = c30989b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo70707a(String str, int i) {
        AppMethodBeat.m2504i(100722);
        if (this.f18292a == null) {
            AppMethodBeat.m2505o(100722);
            return;
        }
        synchronized (this.f18292a.f14265b) {
            try {
                C36519hz b = this.f18292a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36899hx) {
                    ((C36899hx) b).mo50174a_(i);
                    this.f18292a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100722);
                } else {
                    AppMethodBeat.m2505o(100722);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100722);
            }
        }
    }

    /* renamed from: k */
    private C36899hx m89725k(String str) {
        AppMethodBeat.m2504i(100723);
        C36519hz b = this.f18292a.mo50456b(str);
        if (b == null) {
            AppMethodBeat.m2505o(100723);
            return null;
        } else if (b instanceof C36899hx) {
            C36899hx c36899hx = (C36899hx) b;
            AppMethodBeat.m2505o(100723);
            return c36899hx;
        } else {
            AppMethodBeat.m2505o(100723);
            return null;
        }
    }
}
