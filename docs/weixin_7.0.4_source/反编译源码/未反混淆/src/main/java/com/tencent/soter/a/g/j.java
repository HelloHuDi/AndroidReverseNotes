package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.d;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.c;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import java.nio.charset.Charset;

public class j extends d {
    private static final String AwX = ("soter_triggered_oom" + g.x(a.dQT().getBytes(Charset.forName("UTF-8"))));
    private boolean AwY = false;
    private String AwZ = "";
    private d Awo;
    private String Awp = "";
    private int[] Awq;
    private h.a Axa = new h.a() {
        @SuppressLint({"ApplySharedPref"})
        public final void dQZ() {
            AppMethodBeat.i(10549);
            com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
            SharedPreferences dRh = com.tencent.soter.a.c.a.dRe().dRh();
            if (dRh != null) {
                Editor edit = dRh.edit();
                edit.putBoolean(j.AwX, true);
                edit.commit();
            }
            AppMethodBeat.o(10549);
        }

        public final boolean dQY() {
            AppMethodBeat.i(10550);
            SharedPreferences dRh = com.tencent.soter.a.c.a.dRe().dRh();
            if (dRh != null) {
                com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: is triggered OOM: %b", Boolean.valueOf(dRh.getBoolean(j.AwX, false)));
                AppMethodBeat.o(10550);
                return dRh.getBoolean(j.AwX, false);
            }
            AppMethodBeat.o(10550);
            return false;
        }
    };

    static {
        AppMethodBeat.i(10558);
        AppMethodBeat.o(10558);
    }

    public j(Context context, e eVar) {
        boolean z = false;
        AppMethodBeat.i(10553);
        c cVar = eVar.Awr;
        if (cVar != null) {
            com.tencent.soter.core.c.d.a(cVar);
        }
        com.tencent.soter.a.c.a dRe = com.tencent.soter.a.c.a.dRe();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (com.tencent.soter.a.c.a.class) {
            try {
                dRe.AvP = sharedPreferences;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(10553);
                }
            }
        }
        h.a(this.Axa);
        a.dQK();
        a.iO(context);
        a.bLV();
        if (a.dQN() && (a.iP(context) || a.iQ(context))) {
            z = true;
        }
        this.AwY = z;
        this.Awo = eVar.Awo;
        this.Awq = eVar.Awq;
        this.Awp = eVar.Awp;
        this.AwZ = eVar.Aws;
        AppMethodBeat.o(10553);
    }

    /* Access modifiers changed, original: final */
    public final boolean dRl() {
        int i;
        AppMethodBeat.i(10554);
        int[] iArr = this.Awq;
        if (iArr == null || iArr.length <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            b(new com.tencent.soter.a.b.d(27, "no business scene provided"));
            AppMethodBeat.o(10554);
            return true;
        }
        if (g.nullAsNil(this.Awp).length() > 16) {
            com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String x = g.x(this.Awp.getBytes(Charset.forName("UTF-8")));
            if (g.isNullOrNil(x) || x.length() < 16) {
                x = null;
            } else {
                x = x.substring(0, 16);
            }
            if (g.isNullOrNil(x)) {
                com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                b(new com.tencent.soter.a.b.d(28, "the account salt length is too long"));
                AppMethodBeat.o(10554);
                return true;
            }
            this.Awp = x;
        }
        if (g.isNullOrNil(this.AwZ) || this.AwZ.length() <= 24) {
            if (this.Awo == null) {
                com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!g.isNullOrNil(this.AwZ)) {
                com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                e.dQW().Avi = this.AwZ;
            }
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10551);
                    j.this.b(j.this.Awp, j.this.Awq);
                    j.c(j.this);
                    AppMethodBeat.o(10551);
                }
            });
            AppMethodBeat.o(10554);
            return false;
        }
        com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
        b(new com.tencent.soter.a.b.d(29, "the passed ask name is too long (larger than 24)"));
        AppMethodBeat.o(10554);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.i(10555);
        if (!this.AwY) {
            com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.AwY + "]", new Object[0]);
            b(new com.tencent.soter.a.b.d(2));
            synchronized (com.tencent.soter.a.c.a.class) {
                try {
                    com.tencent.soter.a.c.a.dRe().rq(false);
                    com.tencent.soter.a.c.a.dRe().dRf();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10555);
                }
            }
        } else if (this.Awo == null) {
            com.tencent.soter.a.c.a.dRe().rq(true);
            com.tencent.soter.a.c.a.dRe().dRf();
            b(new com.tencent.soter.a.b.d(0));
            AppMethodBeat.o(10555);
        } else {
            this.Awo.bR(new d.a(a.dQT()));
            this.Awo.a(new b<d.b>() {
                public final /* synthetic */ void dd(Object obj) {
                    AppMethodBeat.i(10552);
                    com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: got support tag from backend: %b", Boolean.valueOf(((d.b) obj).cOQ));
                    synchronized (com.tencent.soter.a.c.a.class) {
                        try {
                            com.tencent.soter.a.c.a.dRe().rq(r7.cOQ);
                            com.tencent.soter.a.c.a.dRe().dRf();
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(10552);
                        }
                    }
                    j.this.b(new com.tencent.soter.a.b.d(0));
                }
            });
            this.Awo.execute();
            AppMethodBeat.o(10555);
        }
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DefaultLocale"})
    public void b(String str, int[] iArr) {
        AppMethodBeat.i(10556);
        for (int put : iArr) {
            com.tencent.soter.a.c.a.dRe().dRg().put(put, String.format("%suid%d_%s_scene%d", new Object[]{"Wechat", Integer.valueOf(Process.myUid()), g.nullAsNil(str), Integer.valueOf(iArr[r0])}));
        }
        AppMethodBeat.o(10556);
    }

    private static boolean Rl(int i) {
        return i == 2 || i == 1;
    }

    static /* synthetic */ void c(j jVar) {
        AppMethodBeat.i(10557);
        SharedPreferences dRh = com.tencent.soter.a.c.a.dRe().dRh();
        com.tencent.soter.core.c.d.d("Soter.TaskInit", "soter: ask status: %d", Integer.valueOf(dRh.getInt(e.dQW().Avi, 0)));
        if (Rl(dRh.getInt(e.dQW().Avi, 0)) && a.dQQ()) {
            a.dQP();
        }
        for (int i : jVar.Awq) {
            String str = (String) com.tencent.soter.a.c.a.dRe().dRg().get(i, "");
            if (!g.isNullOrNil(str)) {
                com.tencent.soter.core.c.d.d("Soter.TaskInit", "soter: %s status: %d", str, Integer.valueOf(dRh.getInt(str, 0)));
                if (Rl(dRh.getInt(str, 0)) && a.aua(str)) {
                    a.cn(str, false);
                }
            }
        }
        AppMethodBeat.o(10557);
    }
}
