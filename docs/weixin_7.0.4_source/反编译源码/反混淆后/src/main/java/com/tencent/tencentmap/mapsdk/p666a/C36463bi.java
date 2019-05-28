package com.tencent.tencentmap.mapsdk.p666a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16287jk.C16288a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24406lh;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24406lh.C24404a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24412lj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24414lq;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31076li;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31076li.C31077a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44514gg;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44533le;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44533le.C36531b;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44533le.C41072a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44828ld;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44829lf;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bi */
public class C36463bi extends C16190cf implements C24333as, C31077a {
    /* renamed from: a */
    public Handler f15217a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(100807);
            if (!(message == null || message.obj == null)) {
                C31076li c31076li = (C31076li) message.obj;
                if (c31076li.f14311a == 0) {
                    if (C36463bi.this.f15221e != null) {
                        C36463bi.this.f15221e.mo40733a(c31076li.f14312b, c31076li.f14313c);
                        AppMethodBeat.m2505o(100807);
                        return;
                    }
                } else if (c31076li.f14311a == 1) {
                    if (C36463bi.this.f15222f != null) {
                        C36463bi.this.f15222f.mo40701a(c31076li.f14314d, c31076li.f14315e);
                        C36463bi.this.f15222f.mo40718g();
                        AppMethodBeat.m2505o(100807);
                        return;
                    }
                } else if (c31076li.f14311a == 3 && C36520ic.f15400e == 1) {
                    if (TextUtils.equals(Token.WX_TOKEN_PLATFORMID_VALUE, Token.WX_TOKEN_PLATFORMID_VALUE)) {
                        AppMethodBeat.m2505o(100807);
                        return;
                    } else if (C36463bi.this.f15218b == null) {
                        AppMethodBeat.m2505o(100807);
                        return;
                    } else {
                        if (C36463bi.this.f15224h == null) {
                            C36463bi.this.f15224h = new C44828ld(C36463bi.this.f15218b.getContext().getApplicationContext());
                            C36463bi.this.f15224h.mo72029a(C36463bi.this.f15225i);
                        }
                        C36463bi.this.f15224h.mo40708a(C36463bi.this.f15218b);
                    }
                }
            }
            AppMethodBeat.m2505o(100807);
        }
    };
    /* renamed from: b */
    private C36456ac f15218b = null;
    /* renamed from: c */
    private C44480ak f15219c;
    /* renamed from: d */
    private C31061iz f15220d;
    /* renamed from: e */
    private C24412lj f15221e;
    /* renamed from: f */
    private C24406lh f15222f;
    /* renamed from: g */
    private C44829lf f15223g;
    /* renamed from: h */
    private C44828ld f15224h;
    /* renamed from: i */
    private C16288a f15225i;
    /* renamed from: j */
    private int f15226j;
    /* renamed from: k */
    private List<C44533le> f15227k = new ArrayList();
    /* renamed from: l */
    private boolean f15228l = false;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.bi$a */
    public interface C16187a {
        /* renamed from: a */
        void mo29103a();
    }

    public C36463bi(C36456ac c36456ac, C44514gg c44514gg) {
        AppMethodBeat.m2504i(100809);
        this.f15218b = c36456ac;
        if (c44514gg == null) {
            AppMethodBeat.m2505o(100809);
            return;
        }
        this.f15220d = (C31061iz) c44514gg.getVectorMapDelegate();
        this.f15219c = this.f15220d.mo50423P();
        if (c44514gg instanceof View) {
            View view = (View) c44514gg;
            if (this.f15218b.indexOfChild(view) < 0) {
                this.f15218b.addView(view, 0, new LayoutParams(-1, -1));
                this.f15218b.requestLayout();
            }
        }
        int i = 4;
        int i2 = 20;
        if (this.f15220d.mo75386b() != null) {
            i = this.f15220d.mo75386b().mo20187b();
            i2 = this.f15220d.mo75386b().mo20203c();
        }
        this.f15222f = new C24406lh(this.f15218b.getContext().getApplicationContext(), i, i2);
        this.f15220d.mo50445a(this.f15222f);
        this.f15223g = new C44829lf(this.f15218b.getContext(), this.f15218b);
        this.f15220d.mo50444a(this.f15223g);
        this.f15221e = new C24412lj(this.f15218b.getContext(), this.f15220d);
        this.f15227k.add(this.f15222f);
        this.f15227k.add(this.f15221e);
        this.f15220d.mo50446a((C31077a) this);
        this.f15220d.mo50440a((C24333as) this);
        mo29123b(0, 0);
        AppMethodBeat.m2505o(100809);
    }

    /* renamed from: a */
    public void mo57684a() {
        AppMethodBeat.m2504i(100810);
        if (this.f15218b == null || this.f15220d == null) {
            AppMethodBeat.m2505o(100810);
            return;
        }
        if (this.f15217a != null) {
            this.f15217a.removeCallbacksAndMessages(null);
        }
        this.f15218b.removeAllViews();
        this.f15220d.mo50446a(null);
        for (C44533le a : this.f15227k) {
            a.mo40698a();
        }
        this.f15221e = null;
        this.f15221e = null;
        this.f15227k.clear();
        this.f15227k = null;
        this.f15220d = null;
        this.f15218b = null;
        AppMethodBeat.m2505o(100810);
    }

    /* renamed from: a */
    public void mo57685a(C16187a c16187a) {
        AppMethodBeat.m2504i(100811);
        if (this.f15221e != null) {
            this.f15221e.mo40730a(c16187a);
        }
        AppMethodBeat.m2505o(100811);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29121a(boolean z) {
        AppMethodBeat.m2504i(100812);
        this.f15221e.mo40732a(z);
        AppMethodBeat.m2505o(100812);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo29124b(boolean z) {
        AppMethodBeat.m2504i(100813);
        this.f15220d.mo50475h(z);
        AppMethodBeat.m2505o(100813);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo29126c(boolean z) {
        AppMethodBeat.m2504i(100814);
        this.f15220d.mo50460b(z);
        AppMethodBeat.m2505o(100814);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo29128d(boolean z) {
        AppMethodBeat.m2504i(100815);
        this.f15220d.mo50468d(z);
        AppMethodBeat.m2505o(100815);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public void mo29130e(boolean z) {
        AppMethodBeat.m2504i(100816);
        this.f15220d.mo50471e(z);
        AppMethodBeat.m2505o(100816);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public void mo29132f(boolean z) {
        AppMethodBeat.m2504i(100817);
        this.f15220d.mo50473f(z);
        AppMethodBeat.m2505o(100817);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public void mo29133g(boolean z) {
        AppMethodBeat.m2504i(100818);
        this.f15220d.mo50474g(z);
        mo29126c(z);
        mo29128d(z);
        mo29130e(z);
        mo29132f(z);
        AppMethodBeat.m2505o(100818);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo29125b() {
        AppMethodBeat.m2504i(100819);
        boolean v = this.f15220d.mo50485v();
        AppMethodBeat.m2505o(100819);
        return v;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public boolean mo29127c() {
        AppMethodBeat.m2504i(100820);
        boolean y = this.f15220d.mo50488y();
        AppMethodBeat.m2505o(100820);
        return y;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public boolean mo29129d() {
        AppMethodBeat.m2504i(100821);
        boolean z = this.f15220d.mo50489z();
        AppMethodBeat.m2505o(100821);
        return z;
    }

    /* renamed from: e */
    public boolean mo29131e() {
        AppMethodBeat.m2504i(100822);
        if (this.f15223g != null) {
            boolean b = this.f15223g.mo72033b();
            AppMethodBeat.m2505o(100822);
            return b;
        }
        AppMethodBeat.m2505o(100822);
        return false;
    }

    /* renamed from: a */
    public void mo40422a(int i, int i2) {
        AppMethodBeat.m2504i(100823);
        this.f15226j = i2;
        for (C44533le c44533le : this.f15227k) {
            c44533le.mo40422a(i, i2);
            c44533le.mo40708a(this.f15218b);
        }
        AppMethodBeat.m2505o(100823);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: f */
    public void mo57688f() {
        AppMethodBeat.m2504i(100824);
        for (C44533le a : this.f15227k) {
            a.mo40708a(this.f15218b);
        }
        AppMethodBeat.m2505o(100824);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: h */
    public void mo29135h(boolean z) {
        AppMethodBeat.m2504i(100825);
        if (this.f15222f != null) {
            this.f15222f.mo40712b(z);
        }
        AppMethodBeat.m2505o(100825);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public boolean mo29134g() {
        AppMethodBeat.m2504i(100826);
        if (this.f15222f != null) {
            boolean f = this.f15222f.mo40717f();
            AppMethodBeat.m2505o(100826);
            return f;
        }
        AppMethodBeat.m2505o(100826);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29119a(int i) {
        AppMethodBeat.m2504i(100827);
        if (this.f15222f != null) {
            this.f15222f.mo40704a(C36531b.m60522a(i));
            mo57688f();
        }
        AppMethodBeat.m2505o(100827);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29120a(int i, int[] iArr) {
        AppMethodBeat.m2504i(100828);
        if (this.f15222f != null) {
            C36531b a = C36531b.m60522a(i);
            this.f15222f.mo40704a(a);
            switch (a) {
                case LEFT_TOP:
                    this.f15222f.mo40703a(C41072a.TOP, iArr[0]);
                    this.f15222f.mo40703a(C41072a.LEFT, iArr[1]);
                    break;
                case LEFT_BOTTOM:
                    this.f15222f.mo40703a(C41072a.BOTTOM, iArr[0]);
                    this.f15222f.mo40703a(C41072a.LEFT, iArr[1]);
                    break;
                case RIGHT_BOTTOM:
                    this.f15222f.mo40703a(C41072a.BOTTOM, iArr[0]);
                    this.f15222f.mo40703a(C41072a.RIGHT, iArr[1]);
                    break;
                case RIGHT_TOP:
                    this.f15222f.mo40703a(C41072a.TOP, iArr[0]);
                    this.f15222f.mo40703a(C41072a.RIGHT, iArr[1]);
                    break;
            }
            this.f15222f.mo40715d();
            mo57688f();
        }
        AppMethodBeat.m2505o(100828);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo29122b(int i) {
        AppMethodBeat.m2504i(100829);
        if (this.f15222f != null) {
            this.f15222f.mo40711b(C36531b.m60522a(i));
            mo57688f();
        }
        AppMethodBeat.m2505o(100829);
    }

    /* renamed from: i */
    public void mo57689i(boolean z) {
        AppMethodBeat.m2504i(100830);
        if (this.f15222f == null || this.f15220d == null || this.f15220d.mo75386b() == null) {
            AppMethodBeat.m2505o(100830);
            return;
        }
        if (z) {
            this.f15222f.mo40709b();
        }
        this.f15222f.mo40706a(C24414lq.m37996g());
        this.f15222f.mo40702a(this.f15220d.mo50424Q(), this.f15220d.mo75386b().mo20215e());
        AppMethodBeat.m2505o(100830);
    }

    /* renamed from: a */
    public void mo50529a(C31076li c31076li) {
        AppMethodBeat.m2504i(100831);
        if (!(c31076li == null || c31076li.f14311a == -1)) {
            this.f15217a.sendMessage(this.f15217a.obtainMessage(c31076li.f14311a, c31076li));
        }
        AppMethodBeat.m2505o(100831);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo29123b(int i, int i2) {
        AppMethodBeat.m2504i(100832);
        if (this.f15220d != null) {
            this.f15220d.mo50458b(i, i2);
        }
        AppMethodBeat.m2505o(100832);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: j */
    public void mo29136j(boolean z) {
        AppMethodBeat.m2504i(100833);
        if (!(this.f15220d == null || this.f15220d.mo75386b() == null)) {
            this.f15220d.mo75386b().mo20233j(z);
        }
        AppMethodBeat.m2505o(100833);
    }

    /* renamed from: k */
    public void mo29137k(boolean z) {
        AppMethodBeat.m2504i(100834);
        this.f15223g.mo72031a(z);
        AppMethodBeat.m2505o(100834);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29118a(float f) {
        AppMethodBeat.m2504i(100835);
        if (this.f15222f != null) {
            this.f15222f.mo40699a(f);
        }
        AppMethodBeat.m2505o(100835);
    }

    /* renamed from: a */
    public void mo57687a(C24404a c24404a, C44480ak c44480ak) {
        AppMethodBeat.m2504i(100836);
        if (!(c44480ak == null || c44480ak.mo70663d() == null || this.f15222f == null || c44480ak == null)) {
            this.f15222f.mo40705a(c24404a);
            int e = c44480ak.mo70664e();
            int f = c44480ak.mo70665f();
            this.f15218b.measure(MeasureSpec.makeMeasureSpec(e, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(f, ErrorDialogData.SUPPRESSED));
            mo40422a(e, f);
        }
        AppMethodBeat.m2505o(100836);
    }

    /* renamed from: a */
    public void mo57686a(C16288a c16288a, C44480ak c44480ak) {
        AppMethodBeat.m2504i(100837);
        if (!(c44480ak == null || c44480ak.mo70663d() == null)) {
            this.f15225i = c16288a;
            int e = c44480ak.mo70664e();
            int f = c44480ak.mo70665f();
            this.f15218b.measure(MeasureSpec.makeMeasureSpec(e, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(f, ErrorDialogData.SUPPRESSED));
            mo40422a(e, f);
        }
        AppMethodBeat.m2505o(100837);
    }
}
