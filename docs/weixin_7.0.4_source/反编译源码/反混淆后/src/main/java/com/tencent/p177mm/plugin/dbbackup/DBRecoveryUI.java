package com.tencent.p177mm.plugin.dbbackup;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.dbbackup.p938a.C20301a;
import com.tencent.p177mm.plugin.dbbackup.p938a.C20301a.C20298a;
import com.tencent.p177mm.plugin.dbbackup.p938a.C20301a.C20299b;
import com.tencent.p177mm.plugin.dbbackup.p938a.C20301a.C20300c;
import com.tencent.p177mm.plugin.dbbackup.p938a.C27700b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7580z;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI */
public class DBRecoveryUI extends MMActivity implements C20299b {
    private static final int[] kIi = new int[]{0, 5, 70, 80, 90, 100, 100};
    private ProgressBar gHA;
    private int gOW;
    private C20301a kIa;
    private View kIb;
    private View kIc;
    private TextView kId;
    private View kIe;
    private int kIf;
    private boolean kIg;
    private OnClickListener kIh = new C202951();

    /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$1 */
    class C202951 implements OnClickListener {
        C202951() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18943);
            if (DBRecoveryUI.this.gOW != 0) {
                DBRecoveryUI.this.kIb.setVisibility(0);
                DBRecoveryUI.this.kIc.setVisibility(8);
                AppMethodBeat.m2505o(18943);
                return;
            }
            C11486d.bhS();
            AppMethodBeat.m2505o(18943);
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$2 */
    class C202962 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$2$1 */
        class C202971 implements OnClickListener {
            C202971() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18944);
                C7053e.pXa.mo8378a(873, 25, 1, false);
                DBRecoveryUI.m38622d(DBRecoveryUI.this);
                AppMethodBeat.m2505o(18944);
            }
        }

        C202962() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18945);
            if (C1720g.m3536RP().mo5234Rs() == null) {
                C30379h.m48467g(DBRecoveryUI.this, C25738R.string.b4d, 0);
                AppMethodBeat.m2505o(18945);
                return;
            }
            C30379h.m48430a(DBRecoveryUI.this, (int) C25738R.string.b47, 0, (int) C25738R.string.b4h, (int) C25738R.string.b4_, false, new C202971(), null, (int) C25738R.color.f11768gn);
            AppMethodBeat.m2505o(18945);
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$3 */
    class C247403 implements View.OnClickListener {
        C247403() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18946);
            DBRecoveryUI.m38623e(DBRecoveryUI.this);
            AppMethodBeat.m2505o(18946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$4 */
    class C247414 implements OnMenuItemClickListener {
        C247414() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18947);
            if (DBRecoveryUI.this.kIg) {
                DBRecoveryUI.m38623e(DBRecoveryUI.this);
            } else {
                DBRecoveryUI.this.finish();
            }
            AppMethodBeat.m2505o(18947);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$6 */
    class C247426 implements OnClickListener {
        C247426() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(18952);
            DBRecoveryUI.this.finish();
            C11486d.bhS();
            AppMethodBeat.m2505o(18952);
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.DBRecoveryUI$5 */
    class C247445 implements C20300c {
        private Collection<String> kIl;
        private int kIm = C1668a.m3383QF();

        C247445() {
            AppMethodBeat.m2504i(18948);
            C1720g.m3534RN();
            AppMethodBeat.m2505o(18948);
        }

        private void bhM() {
            AppMethodBeat.m2504i(18949);
            if (this.kIl == null) {
                this.kIl = C27700b.bib();
            }
            AppMethodBeat.m2505o(18949);
        }

        public final Collection<byte[]> bhN() {
            AppMethodBeat.m2504i(18950);
            bhM();
            ArrayList arrayList = new ArrayList();
            for (String str : this.kIl) {
                arrayList.add(C1178g.m2592y((str + this.kIm).getBytes()));
            }
            AppMethodBeat.m2505o(18950);
            return arrayList;
        }

        public final Collection<byte[]> bhO() {
            AppMethodBeat.m2504i(18951);
            bhM();
            ArrayList arrayList = new ArrayList();
            for (String str : this.kIl) {
                arrayList.add(C1178g.m2591x((str + this.kIm).getBytes()).substring(0, 7).getBytes());
            }
            AppMethodBeat.m2505o(18951);
            return arrayList;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public DBRecoveryUI() {
        AppMethodBeat.m2504i(18954);
        AppMethodBeat.m2505o(18954);
    }

    /* renamed from: d */
    static /* synthetic */ void m38622d(DBRecoveryUI dBRecoveryUI) {
        AppMethodBeat.m2504i(18965);
        dBRecoveryUI.bhJ();
        AppMethodBeat.m2505o(18965);
    }

    /* renamed from: e */
    static /* synthetic */ void m38623e(DBRecoveryUI dBRecoveryUI) {
        AppMethodBeat.m2504i(18966);
        dBRecoveryUI.bhK();
        AppMethodBeat.m2505o(18966);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18955);
        super.onCreate(bundle);
        this.gOW = getIntent().getIntExtra("scene", 2);
        this.kIg = false;
        setMMTitle((int) C25738R.string.b49);
        this.kIb = findViewById(2131823198);
        this.kIc = findViewById(2131823200);
        this.gHA = (ProgressBar) findViewById(2131821099);
        this.kId = (TextView) findViewById(2131823201);
        findViewById(2131823199).setOnClickListener(new C202962());
        this.kIe = findViewById(2131822819);
        this.kIe.setOnClickListener(new C247403());
        setBackBtn(new C247414());
        if (this.gOW == 0) {
            bhJ();
        }
        C7053e.pXa.mo8378a(181, (long) (this.gOW + 51), 1, true);
        C7053e.pXa.mo8378a(873, 14, 1, false);
        if (this.gOW == 2) {
            C7053e.pXa.mo8378a(873, 15, 1, false);
        }
        AppMethodBeat.m2505o(18955);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(18956);
        if (this.kIg) {
            bhK();
            AppMethodBeat.m2505o(18956);
            return;
        }
        finish();
        AppMethodBeat.m2505o(18956);
    }

    public final int getLayoutId() {
        return 2130969263;
    }

    private void bhJ() {
        AppMethodBeat.m2504i(18957);
        if (this.kIa != null) {
            C4990ab.m7412e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
            AppMethodBeat.m2505o(18957);
            return;
        }
        boolean z;
        this.kIb.setVisibility(8);
        this.kIc.setVisibility(0);
        this.kIe.setEnabled(true);
        StringBuilder append = new StringBuilder().append(C1427q.m3026LK());
        C1720g.m3534RN();
        byte[] bytes = C1178g.m2591x(append.append(C1668a.m3383QF()).toString().getBytes()).substring(0, 7).getBytes();
        String Rs = C1720g.m3536RP().mo5234Rs();
        String path = C1720g.m3536RP().eJN.getPath();
        String str = path + "-recovery";
        this.kIf = 0;
        String str2 = C1720g.m3536RP().eJM + "dbback/";
        C20298a c20298a = new C20298a();
        c20298a.kJp = this;
        c20298a = c20298a.mo35540aC(bytes).mo35541aD(bytes);
        c20298a.kJn = new C247445();
        c20298a.kJf = Rs;
        c20298a.kJe = path;
        c20298a.kJd = str;
        c20298a.kJg = C1720g.m3536RP().cachePath + "heavyDetailInfo";
        if (this.gOW == 0) {
            z = true;
        } else {
            z = false;
        }
        c20298a.kJo = z;
        this.kIa = c20298a.mo35538Ig(Rs + ".sm").mo35539Ih(Rs + ".bak").mo35538Ig(str2 + "corrupted/EnMicroMsg.db.sm").mo35539Ih(str2 + "corrupted/EnMicroMsg.db.bak").mo35538Ig(str2 + "EnMicroMsg.db.sm").mo35539Ih(str2 + "EnMicroMsg.db.bak").bia();
        this.kIa.execute(new Void[0]);
        this.kIg = true;
        AppMethodBeat.m2505o(18957);
    }

    private void bhK() {
        AppMethodBeat.m2504i(18958);
        this.kIe.setEnabled(false);
        if (this.kIa != null) {
            this.kIa.cancel();
            this.kIa = null;
            AppMethodBeat.m2505o(18958);
            return;
        }
        C4990ab.m7412e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
        AppMethodBeat.m2505o(18958);
    }

    /* renamed from: R */
    public final void mo35544R(int i, int i2, int i3) {
        float f = 1.0f;
        AppMethodBeat.m2504i(18959);
        if (i <= 0 || i > 6) {
            AppMethodBeat.m2505o(18959);
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
        String str = getResources().getStringArray(C25738R.array.f12606f)[i - 1];
        this.kId.setText(String.format(str, new Object[]{Integer.valueOf(i2)}));
        AppMethodBeat.m2505o(18959);
    }

    /* renamed from: F */
    public final void mo35543F(long j, long j2) {
        AppMethodBeat.m2504i(18960);
        this.kIg = false;
        this.kIa = null;
        DBRecoveryUI.bhL();
        C30379h.m48448a((Context) this, getString(C25738R.string.b4f, new Object[]{Long.valueOf((j2 / 1024) / 1024), Long.valueOf((j / 1024) / 1024)}), null, false, this.kIh);
        AppMethodBeat.m2505o(18960);
    }

    public final void onSuccess() {
        AppMethodBeat.m2504i(18961);
        this.kIg = false;
        this.kIa = null;
        C4990ab.m7416i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
        final C5653c a = C30379h.m48433a((Context) this, (int) C25738R.string.b4g, 0, false, new C247426());
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18953);
                a.dismiss();
                DBRecoveryUI.this.finish();
                C11486d.bhS();
                AppMethodBeat.m2505o(18953);
            }
        }, 5000);
        AppMethodBeat.m2505o(18961);
    }

    public final void onCanceled() {
        AppMethodBeat.m2504i(18962);
        this.kIg = false;
        this.kIa = null;
        C4990ab.m7416i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
        DBRecoveryUI.bhL();
        C30379h.m48433a((Context) this, (int) C25738R.string.b4b, 0, false, this.kIh);
        AppMethodBeat.m2505o(18962);
    }

    public final void onFailure() {
        AppMethodBeat.m2504i(18963);
        this.kIg = false;
        this.kIa = null;
        C4990ab.m7412e("MicroMsg.DBRecoveryUI", "Recovery failed.");
        DBRecoveryUI.bhL();
        C30379h.m48433a((Context) this, (int) C25738R.string.b4c, 0, false, this.kIh);
        AppMethodBeat.m2505o(18963);
    }

    private static void bhL() {
        AppMethodBeat.m2504i(18964);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        Ry.set(89, Integer.valueOf(2));
        Ry.dsb();
        AppMethodBeat.m2505o(18964);
    }
}
