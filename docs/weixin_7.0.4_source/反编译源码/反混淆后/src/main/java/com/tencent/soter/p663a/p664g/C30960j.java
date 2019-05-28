package com.tencent.soter.p663a.p664g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C24322h;
import com.tencent.soter.core.p1351c.C24322h.C24324a;
import com.tencent.soter.core.p1351c.C44475c;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C46745e;
import com.tencent.soter.p663a.p1106b.C16166d;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C24297d;
import com.tencent.soter.p663a.p1108f.C24297d.C24295a;
import com.tencent.soter.p663a.p1108f.C24297d.C24296b;
import java.nio.charset.Charset;

/* renamed from: com.tencent.soter.a.g.j */
public class C30960j extends C44469d {
    private static final String AwX = ("soter_triggered_oom" + C24321g.m37492x(C40997a.dQT().getBytes(Charset.forName("UTF-8"))));
    private boolean AwY = false;
    private String AwZ = "";
    private C24297d Awo;
    private String Awp = "";
    private int[] Awq;
    private C24324a Axa = new C243141();

    /* renamed from: com.tencent.soter.a.g.j$1 */
    class C243141 implements C24324a {
        C243141() {
        }

        @SuppressLint({"ApplySharedPref"})
        public final void dQZ() {
            AppMethodBeat.m2504i(10549);
            C44476d.m80486w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
            SharedPreferences dRh = C16167a.dRe().dRh();
            if (dRh != null) {
                Editor edit = dRh.edit();
                edit.putBoolean(C30960j.AwX, true);
                edit.commit();
            }
            AppMethodBeat.m2505o(10549);
        }

        public final boolean dQY() {
            AppMethodBeat.m2504i(10550);
            SharedPreferences dRh = C16167a.dRe().dRh();
            if (dRh != null) {
                C44476d.m80484i("Soter.TaskInit", "soter: is triggered OOM: %b", Boolean.valueOf(dRh.getBoolean(C30960j.AwX, false)));
                AppMethodBeat.m2505o(10550);
                return dRh.getBoolean(C30960j.AwX, false);
            }
            AppMethodBeat.m2505o(10550);
            return false;
        }
    }

    /* renamed from: com.tencent.soter.a.g.j$2 */
    class C243152 implements Runnable {
        C243152() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10551);
            C30960j.this.mo37724b(C30960j.this.Awp, C30960j.this.Awq);
            C30960j.m49592c(C30960j.this);
            AppMethodBeat.m2505o(10551);
        }
    }

    /* renamed from: com.tencent.soter.a.g.j$3 */
    class C309613 implements C24291b<C24296b> {
        C309613() {
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10552);
            C44476d.m80484i("Soter.TaskInit", "soter: got support tag from backend: %b", Boolean.valueOf(((C24296b) obj).cOQ));
            synchronized (C16167a.class) {
                try {
                    C16167a.dRe().mo28991rq(r7.cOQ);
                    C16167a.dRe().dRf();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10552);
                }
            }
            C30960j.this.mo70642b(new C16166d(0));
        }
    }

    static {
        AppMethodBeat.m2504i(10558);
        AppMethodBeat.m2505o(10558);
    }

    public C30960j(Context context, C44471e c44471e) {
        boolean z = false;
        AppMethodBeat.m2504i(10553);
        C44475c c44475c = c44471e.Awr;
        if (c44475c != null) {
            C44476d.m80480a(c44475c);
        }
        C16167a dRe = C16167a.dRe();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (C16167a.class) {
            try {
                dRe.AvP = sharedPreferences;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(10553);
                }
            }
        }
        C24322h.m37493a(this.Axa);
        C40997a.dQK();
        C40997a.m71096iO(context);
        C40997a.bLV();
        if (C40997a.dQN() && (C40997a.m71097iP(context) || C40997a.m71098iQ(context))) {
            z = true;
        }
        this.AwY = z;
        this.Awo = c44471e.Awo;
        this.Awq = c44471e.Awq;
        this.Awp = c44471e.Awp;
        this.AwZ = c44471e.Aws;
        AppMethodBeat.m2505o(10553);
    }

    /* Access modifiers changed, original: final */
    public final boolean dRl() {
        int i;
        AppMethodBeat.m2504i(10554);
        int[] iArr = this.Awq;
        if (iArr == null || iArr.length <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            C44476d.m80483e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            mo70642b(new C16166d(27, "no business scene provided"));
            AppMethodBeat.m2505o(10554);
            return true;
        }
        if (C24321g.nullAsNil(this.Awp).length() > 16) {
            C44476d.m80486w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String x = C24321g.m37492x(this.Awp.getBytes(Charset.forName("UTF-8")));
            if (C24321g.isNullOrNil(x) || x.length() < 16) {
                x = null;
            } else {
                x = x.substring(0, 16);
            }
            if (C24321g.isNullOrNil(x)) {
                C44476d.m80486w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                mo70642b(new C16166d(28, "the account salt length is too long"));
                AppMethodBeat.m2505o(10554);
                return true;
            }
            this.Awp = x;
        }
        if (C24321g.isNullOrNil(this.AwZ) || this.AwZ.length() <= 24) {
            if (this.Awo == null) {
                C44476d.m80486w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!C24321g.isNullOrNil(this.AwZ)) {
                C44476d.m80484i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                C46745e.dQW().Avi = this.AwZ;
            }
            C44472g.dRq().mo70644R(new C243152());
            AppMethodBeat.m2505o(10554);
            return false;
        }
        C44476d.m80483e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
        mo70642b(new C16166d(29, "the passed ask name is too long (larger than 24)"));
        AppMethodBeat.m2505o(10554);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.m2504i(10555);
        if (!this.AwY) {
            C44476d.m80486w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.AwY + "]", new Object[0]);
            mo70642b(new C16166d(2));
            synchronized (C16167a.class) {
                try {
                    C16167a.dRe().mo28991rq(false);
                    C16167a.dRe().dRf();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10555);
                }
            }
        } else if (this.Awo == null) {
            C16167a.dRe().mo28991rq(true);
            C16167a.dRe().dRf();
            mo70642b(new C16166d(0));
            AppMethodBeat.m2505o(10555);
        } else {
            this.Awo.mo55795bR(new C24295a(C40997a.dQT()));
            this.Awo.mo55794a(new C309613());
            this.Awo.execute();
            AppMethodBeat.m2505o(10555);
        }
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: b */
    public void mo37724b(String str, int[] iArr) {
        AppMethodBeat.m2504i(10556);
        for (int put : iArr) {
            C16167a.dRe().dRg().put(put, String.format("%suid%d_%s_scene%d", new Object[]{"Wechat", Integer.valueOf(Process.myUid()), C24321g.nullAsNil(str), Integer.valueOf(iArr[r0])}));
        }
        AppMethodBeat.m2505o(10556);
    }

    /* renamed from: Rl */
    private static boolean m49589Rl(int i) {
        return i == 2 || i == 1;
    }

    /* renamed from: c */
    static /* synthetic */ void m49592c(C30960j c30960j) {
        AppMethodBeat.m2504i(10557);
        SharedPreferences dRh = C16167a.dRe().dRh();
        C44476d.m80482d("Soter.TaskInit", "soter: ask status: %d", Integer.valueOf(dRh.getInt(C46745e.dQW().Avi, 0)));
        if (C30960j.m49589Rl(dRh.getInt(C46745e.dQW().Avi, 0)) && C40997a.dQQ()) {
            C40997a.dQP();
        }
        for (int i : c30960j.Awq) {
            String str = (String) C16167a.dRe().dRg().get(i, "");
            if (!C24321g.isNullOrNil(str)) {
                C44476d.m80482d("Soter.TaskInit", "soter: %s status: %d", str, Integer.valueOf(dRh.getInt(str, 0)));
                if (C30960j.m49589Rl(dRh.getInt(str, 0)) && C40997a.aua(str)) {
                    C40997a.m71093cn(str, false);
                }
            }
        }
        AppMethodBeat.m2505o(10557);
    }
}
