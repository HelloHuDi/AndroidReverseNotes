package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C32957ag;
import com.tencent.p177mm.plugin.account.friend.p273ui.FindMContactAddUI;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI */
public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String cFl;
    private ProgressDialog ehJ = null;
    private String elr = null;
    private C1202f fQS = null;
    private List<String[]> gsD = null;
    private C32957ag gsE;
    private Button gsW;
    private TextView gsX;
    private String gsy = "";
    private int gsz = 2;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$5 */
    class C98615 implements C5002a {
        C98615() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(13626);
            if (FindMContactLearmMoreUI.this.gsD == null || FindMContactLearmMoreUI.this.gsD.size() == 0) {
                if (FindMContactLearmMoreUI.this.ehJ != null) {
                    FindMContactLearmMoreUI.this.ehJ.dismiss();
                    FindMContactLearmMoreUI.this.ehJ = null;
                }
                FindMContactLearmMoreUI.m25453b(FindMContactLearmMoreUI.this);
            } else {
                FindMContactLearmMoreUI.this.gsE = new C32957ag(FindMContactLearmMoreUI.this.elr, FindMContactLearmMoreUI.this.gsD);
                C1720g.m3540Rg().mo14541a(FindMContactLearmMoreUI.this.gsE, 0);
            }
            AppMethodBeat.m2505o(13626);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(13627);
            try {
                FindMContactLearmMoreUI.this.gsD = C46482a.m87692cJ(FindMContactLearmMoreUI.this);
                C4990ab.m7410d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (FindMContactLearmMoreUI.this.gsD == null ? 0 : FindMContactLearmMoreUI.this.gsD.size()));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(13627);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(13628);
            String str = super.toString() + "|doUpload";
            AppMethodBeat.m2505o(13628);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$6 */
    class C98626 implements OnClickListener {
        C98626() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13629);
            dialogInterface.dismiss();
            FindMContactLearmMoreUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(13629);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$7 */
    class C98637 implements OnClickListener {
        C98637() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13630);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(13630);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$1 */
    class C165671 implements View.OnClickListener {
        C165671() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13622);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            ((C7599a) C1720g.m3530M(C7599a.class)).syncUploadMContactStatus(true, false);
            FindMContactLearmMoreUI.m25452a(FindMContactLearmMoreUI.this);
            AppMethodBeat.m2505o(13622);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$3 */
    class C165683 implements C1202f {
        C165683() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(13624);
            if (FindMContactLearmMoreUI.this.ehJ != null) {
                FindMContactLearmMoreUI.this.ehJ.dismiss();
                FindMContactLearmMoreUI.this.ehJ = null;
            }
            if (FindMContactLearmMoreUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(431, FindMContactLearmMoreUI.this.fQS);
                FindMContactLearmMoreUI.this.fQS = null;
            }
            if (i == 0 && i2 == 0) {
                int i3;
                LinkedList aqj = ((C32957ag) c1207m).aqj();
                ((C7599a) C1720g.m3530M(C7599a.class)).setFriendData(aqj);
                int i4;
                if (aqj == null || aqj.size() <= 0) {
                    i4 = 0;
                    i3 = 0;
                } else {
                    Iterator it = aqj.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        aym aym = (aym) it.next();
                        if (aym != null) {
                            if (aym.jBT == 1) {
                                i4 = i3 + 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4;
                        }
                    }
                    i4 = i3 > 0 ? 1 : 0;
                }
                String str2 = "MicroMsg.FindMContactLearmMoreUI";
                String str3 = "tigerreg data size=%d, addcount=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aqj == null ? 0 : aqj.size());
                objArr[1] = Integer.valueOf(i3);
                C4990ab.m7411d(str2, str3, objArr);
                if (FindMContactLearmMoreUI.this.gsy == null || !FindMContactLearmMoreUI.this.gsy.contains("1") || i4 == 0) {
                    FindMContactLearmMoreUI.m25453b(FindMContactLearmMoreUI.this);
                    AppMethodBeat.m2505o(13624);
                    return;
                }
                C42756a.m75796wA("R300_300_phone");
                Intent intent = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
                intent.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.this.elr);
                intent.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.this.gsy);
                intent.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.this.gsz);
                intent.putExtra("login_type", 0);
                MMWizardActivity.m23791J(FindMContactLearmMoreUI.this, intent);
                AppMethodBeat.m2505o(13624);
                return;
            }
            Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(C25738R.string.f9111ps, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            FindMContactLearmMoreUI.m25453b(FindMContactLearmMoreUI.this);
            AppMethodBeat.m2505o(13624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$2 */
    class C165692 implements View.OnClickListener {
        C165692() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13623);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
            ((C7599a) C1720g.m3530M(C7599a.class)).syncUploadMContactStatus(true, false);
            FindMContactLearmMoreUI.m25453b(FindMContactLearmMoreUI.this);
            AppMethodBeat.m2505o(13623);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI$4 */
    class C165704 implements OnCancelListener {
        C165704() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13625);
            if (FindMContactLearmMoreUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(431, FindMContactLearmMoreUI.this.fQS);
                FindMContactLearmMoreUI.this.fQS = null;
            }
            AppMethodBeat.m2505o(13625);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m25452a(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        AppMethodBeat.m2504i(13640);
        findMContactLearmMoreUI.api();
        AppMethodBeat.m2505o(13640);
    }

    /* renamed from: b */
    static /* synthetic */ void m25453b(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        AppMethodBeat.m2504i(13641);
        findMContactLearmMoreUI.aoZ();
        AppMethodBeat.m2505o(13641);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13631);
        super.onCreate(bundle);
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        initView();
        AppMethodBeat.m2505o(13631);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13632);
        if (this.fQS != null) {
            C1720g.m3540Rg().mo14546b(431, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(13632);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13633);
        super.onResume();
        C42756a.m75798wz("R300_100_phone");
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE300_600,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("RE300_600")).append(",1").toString());
        AppMethodBeat.m2505o(13633);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13634);
        super.onPause();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE300_600,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("RE300_600")).append(",2").toString());
        AppMethodBeat.m2505o(13634);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13635);
        setMMTitle((int) C25738R.string.bux);
        this.gsW = (Button) findViewById(2131823196);
        this.gsX = (TextView) findViewById(2131822819);
        this.gsW.setOnClickListener(new C165671());
        this.gsX.setOnClickListener(new C165692());
        C1720g.m3536RP().mo5239Ry().set(12323, Boolean.TRUE);
        this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        }
        AppMethodBeat.m2505o(13635);
    }

    private void api() {
        AppMethodBeat.m2504i(13636);
        C4990ab.m7417i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            C6300p Rg = C1720g.m3540Rg();
            C1202f c165683 = new C165683();
            this.fQS = c165683;
            Rg.mo14539a(431, c165683);
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9160rd), true, new C165704());
            C1720g.m3539RS().mo10300a(new C98615());
            ((C7599a) C1720g.m3530M(C7599a.class)).syncUploadMContactStatus(true, false);
            ((C7599a) C1720g.m3530M(C7599a.class)).syncAddrBookAndUpload();
            AppMethodBeat.m2505o(13636);
            return;
        }
        AppMethodBeat.m2505o(13636);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13637);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(13637);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13637);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(13638);
        aqX();
        mo27541Ni(1);
        AppMethodBeat.m2505o(13638);
    }

    public final int getLayoutId() {
        return 2130969556;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(13639);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(13639);
            return;
        }
        C4990ab.m7417i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C98626(), new C98637());
                    break;
                }
                api();
                AppMethodBeat.m2505o(13639);
                return;
        }
        AppMethodBeat.m2505o(13639);
    }
}
