package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.dbbackup.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.plugin.dbbackup.a.a.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collection;

public class DBRecoveryUI extends MMActivity implements b {
    private static final int[] kIi = new int[]{0, 5, 70, 80, 90, 100, 100};
    private ProgressBar gHA;
    private int gOW;
    private a kIa;
    private View kIb;
    private View kIc;
    private TextView kId;
    private View kIe;
    private int kIf;
    private boolean kIg;
    private OnClickListener kIh = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(18943);
            if (DBRecoveryUI.this.gOW != 0) {
                DBRecoveryUI.this.kIb.setVisibility(0);
                DBRecoveryUI.this.kIc.setVisibility(8);
                AppMethodBeat.o(18943);
                return;
            }
            d.bhS();
            AppMethodBeat.o(18943);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public DBRecoveryUI() {
        AppMethodBeat.i(18954);
        AppMethodBeat.o(18954);
    }

    static /* synthetic */ void d(DBRecoveryUI dBRecoveryUI) {
        AppMethodBeat.i(18965);
        dBRecoveryUI.bhJ();
        AppMethodBeat.o(18965);
    }

    static /* synthetic */ void e(DBRecoveryUI dBRecoveryUI) {
        AppMethodBeat.i(18966);
        dBRecoveryUI.bhK();
        AppMethodBeat.o(18966);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18955);
        super.onCreate(bundle);
        this.gOW = getIntent().getIntExtra("scene", 2);
        this.kIg = false;
        setMMTitle((int) R.string.b49);
        this.kIb = findViewById(R.id.b7q);
        this.kIc = findViewById(R.id.b7s);
        this.gHA = (ProgressBar) findViewById(R.id.oa);
        this.kId = (TextView) findViewById(R.id.b7t);
        findViewById(R.id.b7r).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18945);
                if (g.RP().Rs() == null) {
                    h.g(DBRecoveryUI.this, R.string.b4d, 0);
                    AppMethodBeat.o(18945);
                    return;
                }
                h.a(DBRecoveryUI.this, (int) R.string.b47, 0, (int) R.string.b4h, (int) R.string.b4_, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(18944);
                        e.pXa.a(873, 25, 1, false);
                        DBRecoveryUI.d(DBRecoveryUI.this);
                        AppMethodBeat.o(18944);
                    }
                }, null, (int) R.color.gn);
                AppMethodBeat.o(18945);
            }
        });
        this.kIe = findViewById(R.id.axh);
        this.kIe.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18946);
                DBRecoveryUI.e(DBRecoveryUI.this);
                AppMethodBeat.o(18946);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18947);
                if (DBRecoveryUI.this.kIg) {
                    DBRecoveryUI.e(DBRecoveryUI.this);
                } else {
                    DBRecoveryUI.this.finish();
                }
                AppMethodBeat.o(18947);
                return true;
            }
        });
        if (this.gOW == 0) {
            bhJ();
        }
        e.pXa.a(181, (long) (this.gOW + 51), 1, true);
        e.pXa.a(873, 14, 1, false);
        if (this.gOW == 2) {
            e.pXa.a(873, 15, 1, false);
        }
        AppMethodBeat.o(18955);
    }

    public void onBackPressed() {
        AppMethodBeat.i(18956);
        if (this.kIg) {
            bhK();
            AppMethodBeat.o(18956);
            return;
        }
        finish();
        AppMethodBeat.o(18956);
    }

    public final int getLayoutId() {
        return R.layout.rt;
    }

    private void bhJ() {
        AppMethodBeat.i(18957);
        if (this.kIa != null) {
            ab.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
            AppMethodBeat.o(18957);
            return;
        }
        boolean z;
        this.kIb.setVisibility(8);
        this.kIc.setVisibility(0);
        this.kIe.setEnabled(true);
        StringBuilder append = new StringBuilder().append(q.LK());
        g.RN();
        byte[] bytes = com.tencent.mm.a.g.x(append.append(com.tencent.mm.kernel.a.QF()).toString().getBytes()).substring(0, 7).getBytes();
        String Rs = g.RP().Rs();
        String path = g.RP().eJN.getPath();
        String str = path + "-recovery";
        this.kIf = 0;
        String str2 = g.RP().eJM + "dbback/";
        a.a aVar = new a.a();
        aVar.kJp = this;
        aVar = aVar.aC(bytes).aD(bytes);
        aVar.kJn = new c() {
            private Collection<String> kIl;
            private int kIm = com.tencent.mm.kernel.a.QF();

            {
                AppMethodBeat.i(18948);
                g.RN();
                AppMethodBeat.o(18948);
            }

            private void bhM() {
                AppMethodBeat.i(18949);
                if (this.kIl == null) {
                    this.kIl = com.tencent.mm.plugin.dbbackup.a.b.bib();
                }
                AppMethodBeat.o(18949);
            }

            public final Collection<byte[]> bhN() {
                AppMethodBeat.i(18950);
                bhM();
                ArrayList arrayList = new ArrayList();
                for (String str : this.kIl) {
                    arrayList.add(com.tencent.mm.a.g.y((str + this.kIm).getBytes()));
                }
                AppMethodBeat.o(18950);
                return arrayList;
            }

            public final Collection<byte[]> bhO() {
                AppMethodBeat.i(18951);
                bhM();
                ArrayList arrayList = new ArrayList();
                for (String str : this.kIl) {
                    arrayList.add(com.tencent.mm.a.g.x((str + this.kIm).getBytes()).substring(0, 7).getBytes());
                }
                AppMethodBeat.o(18951);
                return arrayList;
            }
        };
        aVar.kJf = Rs;
        aVar.kJe = path;
        aVar.kJd = str;
        aVar.kJg = g.RP().cachePath + "heavyDetailInfo";
        if (this.gOW == 0) {
            z = true;
        } else {
            z = false;
        }
        aVar.kJo = z;
        this.kIa = aVar.Ig(Rs + ".sm").Ih(Rs + ".bak").Ig(str2 + "corrupted/EnMicroMsg.db.sm").Ih(str2 + "corrupted/EnMicroMsg.db.bak").Ig(str2 + "EnMicroMsg.db.sm").Ih(str2 + "EnMicroMsg.db.bak").bia();
        this.kIa.execute(new Void[0]);
        this.kIg = true;
        AppMethodBeat.o(18957);
    }

    private void bhK() {
        AppMethodBeat.i(18958);
        this.kIe.setEnabled(false);
        if (this.kIa != null) {
            this.kIa.cancel();
            this.kIa = null;
            AppMethodBeat.o(18958);
            return;
        }
        ab.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
        AppMethodBeat.o(18958);
    }

    public final void R(int i, int i2, int i3) {
        float f = 1.0f;
        AppMethodBeat.i(18959);
        if (i <= 0 || i > 6) {
            AppMethodBeat.o(18959);
            return;
        }
        if (i3 > 0) {
            int i4 = kIi[i - 1];
            int i5 = kIi[i] - i4;
            float f2 = ((float) i2) / ((float) i3);
            if (f2 <= 1.0f) {
                f = f2;
            }
            this.gHA.setProgress((int) ((f * ((float) i5)) + ((float) i4)));
        } else if (this.kIf != i) {
            this.gHA.setProgress(kIi[i - 1]);
        }
        this.kIf = i;
        String str = getResources().getStringArray(R.array.f)[i - 1];
        this.kId.setText(String.format(str, new Object[]{Integer.valueOf(i2)}));
        AppMethodBeat.o(18959);
    }

    public final void F(long j, long j2) {
        AppMethodBeat.i(18960);
        this.kIg = false;
        this.kIa = null;
        bhL();
        h.a((Context) this, getString(R.string.b4f, new Object[]{Long.valueOf((j2 / 1024) / 1024), Long.valueOf((j / 1024) / 1024)}), null, false, this.kIh);
        AppMethodBeat.o(18960);
    }

    public final void onSuccess() {
        AppMethodBeat.i(18961);
        this.kIg = false;
        this.kIa = null;
        ab.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
        final com.tencent.mm.ui.widget.a.c a = h.a((Context) this, (int) R.string.b4g, 0, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(18952);
                DBRecoveryUI.this.finish();
                d.bhS();
                AppMethodBeat.o(18952);
            }
        });
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18953);
                a.dismiss();
                DBRecoveryUI.this.finish();
                d.bhS();
                AppMethodBeat.o(18953);
            }
        }, 5000);
        AppMethodBeat.o(18961);
    }

    public final void onCanceled() {
        AppMethodBeat.i(18962);
        this.kIg = false;
        this.kIa = null;
        ab.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
        bhL();
        h.a((Context) this, (int) R.string.b4b, 0, false, this.kIh);
        AppMethodBeat.o(18962);
    }

    public final void onFailure() {
        AppMethodBeat.i(18963);
        this.kIg = false;
        this.kIa = null;
        ab.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
        bhL();
        h.a((Context) this, (int) R.string.b4c, 0, false, this.kIh);
        AppMethodBeat.o(18963);
    }

    private static void bhL() {
        AppMethodBeat.i(18964);
        z Ry = g.RP().Ry();
        Ry.set(89, Integer.valueOf(2));
        Ry.dsb();
        AppMethodBeat.o(18964);
    }
}
