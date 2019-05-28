package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.friend.p273ui.FindMContactAddUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
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

/* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI */
public class FindMContactIntroUI extends MMWizardActivity {
    private String cFl;
    private ProgressDialog ehJ = null;
    private String elr = null;
    private C1202f fQS = null;
    private boolean gsC = false;
    private List<String[]> gsD = null;
    private C32957ag gsE;
    private String gsF;
    private Button gsR;
    private TextView gsS;
    private TextView gsT;
    private String gsy = "";
    private int gsz = 2;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$1 */
    class C188081 implements OnClickListener {
        C188081() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13596);
            FindMContactIntroUI.m74719a(FindMContactIntroUI.this);
            AppMethodBeat.m2505o(13596);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$2 */
    class C188092 implements DialogInterface.OnClickListener {
        C188092() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13597);
            dialogInterface.dismiss();
            FindMContactIntroUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(13597);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$3 */
    class C188103 implements DialogInterface.OnClickListener {
        C188103() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13598);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(13598);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$8 */
    class C188118 implements DialogInterface.OnClickListener {
        C188118() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13604);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
            AppMethodBeat.m2505o(13604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$10 */
    class C3294110 implements OnCancelListener {
        C3294110() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13606);
            if (FindMContactIntroUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(431, FindMContactIntroUI.this.fQS);
                FindMContactIntroUI.this.fQS = null;
            }
            AppMethodBeat.m2505o(13606);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$11 */
    class C3294211 implements C5002a {
        C3294211() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(13607);
            if (FindMContactIntroUI.this.gsD == null || FindMContactIntroUI.this.gsD.size() == 0) {
                if (FindMContactIntroUI.this.ehJ != null) {
                    FindMContactIntroUI.this.ehJ.dismiss();
                    FindMContactIntroUI.this.ehJ = null;
                }
                FindMContactIntroUI.m74720b(FindMContactIntroUI.this);
            } else {
                FindMContactIntroUI.this.gsE = new C32957ag(FindMContactIntroUI.this.elr, FindMContactIntroUI.this.gsD);
                C1720g.m3540Rg().mo14541a(FindMContactIntroUI.this.gsE, 0);
            }
            AppMethodBeat.m2505o(13607);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(13608);
            try {
                FindMContactIntroUI.this.gsD = C46482a.m87692cJ(FindMContactIntroUI.this);
                C4990ab.m7410d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (FindMContactIntroUI.this.gsD == null ? 0 : FindMContactIntroUI.this.gsD.size()));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FindMContactIntroUI", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(13608);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(13609);
            String str = super.toString() + "|doUpload";
            AppMethodBeat.m2505o(13609);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$9 */
    class C329449 implements C1202f {
        C329449() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(13605);
            if (FindMContactIntroUI.this.ehJ != null) {
                FindMContactIntroUI.this.ehJ.dismiss();
                FindMContactIntroUI.this.ehJ = null;
            }
            if (FindMContactIntroUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(431, FindMContactIntroUI.this.fQS);
                FindMContactIntroUI.this.fQS = null;
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
                String str2 = "MicroMsg.FindMContactIntroUI";
                String str3 = "tigerreg data size=%d, addcount=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aqj == null ? 0 : aqj.size());
                objArr[1] = Integer.valueOf(i3);
                C4990ab.m7411d(str2, str3, objArr);
                if (FindMContactIntroUI.this.gsy == null || !FindMContactIntroUI.this.gsy.contains("1") || i4 == 0) {
                    FindMContactIntroUI.m74720b(FindMContactIntroUI.this);
                    AppMethodBeat.m2505o(13605);
                    return;
                }
                C42756a.m75796wA("R300_300_phone");
                Intent intent = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
                intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.elr);
                intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.gsy);
                intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.gsz);
                intent.putExtra("login_type", 0);
                MMWizardActivity.m23791J(FindMContactIntroUI.this, intent);
                AppMethodBeat.m2505o(13605);
                return;
            }
            Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(C25738R.string.f9111ps, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(13605);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$4 */
    class C422714 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$4$1 */
        class C98601 implements DialogInterface.OnClickListener {
            C98601() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13599);
                FindMContactIntroUI.m74720b(FindMContactIntroUI.this);
                AppMethodBeat.m2505o(13599);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$4$2 */
        class C329432 implements DialogInterface.OnClickListener {
            C329432() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C422714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13600);
            C30379h.m48466d(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(C25738R.string.bul), null, FindMContactIntroUI.this.getString(C25738R.string.bum), FindMContactIntroUI.this.getString(C25738R.string.buk), new C98601(), new C329432());
            AppMethodBeat.m2505o(13600);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$5 */
    class C422725 implements DialogInterface.OnClickListener {
        C422725() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13601);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            C42756a.m75796wA("R200_100");
            Intent intent = new Intent();
            intent.putExtra("mobile_input_purpose", 4);
            intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.elr);
            intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.gsy);
            intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.gsz);
            C24679a.gkE.mo38901a(FindMContactIntroUI.this, intent);
            C42756a.m75796wA("R300_300_phone");
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FindMContactIntroUI.this.getClass().getName()).append(",R300_200_phone,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_200_phone")).append(",2").toString());
            AppMethodBeat.m2505o(13601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$6 */
    class C422736 implements DialogInterface.OnClickListener {
        C422736() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13602);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
            AppMethodBeat.m2505o(13602);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI$7 */
    class C422747 implements DialogInterface.OnClickListener {
        C422747() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13603);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            FindMContactIntroUI.m74724f(FindMContactIntroUI.this);
            AppMethodBeat.m2505o(13603);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m74720b(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.m2504i(13620);
        findMContactIntroUI.aoZ();
        AppMethodBeat.m2505o(13620);
    }

    /* renamed from: f */
    static /* synthetic */ void m74724f(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.m2504i(13621);
        findMContactIntroUI.api();
        AppMethodBeat.m2505o(13621);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(13610);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.buo);
        C24679a.gkF.mo38846BV();
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (C38033l.apS() != C38034a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        this.gsC = z;
        this.gsF = C42756a.m75794FP();
        C4990ab.m7411d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", this.gsy, Integer.valueOf(this.gsz));
        AppMethodBeat.m2505o(13610);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13611);
        if (this.fQS != null) {
            C1720g.m3540Rg().mo14546b(431, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(13611);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13612);
        super.onResume();
        initView();
        StringBuilder stringBuilder;
        if (this.gsC) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_100_QQ")).append(",1").toString());
            C42756a.m75798wz("R300_100_QQ");
            AppMethodBeat.m2505o(13612);
            return;
        }
        stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_100_phone")).append(",1").toString());
        C42756a.m75798wz("R300_100_phone");
        AppMethodBeat.m2505o(13612);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13613);
        super.onPause();
        C42756a.m75796wA("RE900_100");
        StringBuilder stringBuilder;
        if (this.gsC) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_100_QQ")).append(",4").toString());
            AppMethodBeat.m2505o(13613);
            return;
        }
        stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_100_phone")).append(",4").toString());
        AppMethodBeat.m2505o(13613);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13614);
        this.gsR = (Button) findViewById(2131824033);
        this.gsT = (TextView) findViewById(2131824035);
        this.gsS = (TextView) findViewById(2131824034);
        if (this.gsy == null || !this.gsy.contains("2")) {
            this.gsS.setText(getString(C25738R.string.bu6));
        } else {
            this.gsS.setText(getString(C25738R.string.bu5));
        }
        this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        }
        this.gsR.setOnClickListener(new C188081());
        this.gsT.setOnClickListener(new C422714());
        AppMethodBeat.m2505o(13614);
    }

    private void api() {
        AppMethodBeat.m2504i(13615);
        C4990ab.m7417i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            C6300p Rg = C1720g.m3540Rg();
            C1202f c329449 = new C329449();
            this.fQS = c329449;
            Rg.mo14539a(431, c329449);
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9160rd), true, new C3294110());
            C1720g.m3539RS().mo10300a(new C3294211());
            AppMethodBeat.m2505o(13615);
            return;
        }
        AppMethodBeat.m2505o(13615);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13616);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(13616);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13616);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(13617);
        C42756a.m75796wA(this.gsF);
        aqX();
        mo27541Ni(1);
        AppMethodBeat.m2505o(13617);
    }

    public final int getLayoutId() {
        return 2130969555;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(13618);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(13618);
            return;
        }
        C4990ab.m7417i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C188092(), new C188103());
                    break;
                }
                api();
                AppMethodBeat.m2505o(13618);
                return;
        }
        AppMethodBeat.m2505o(13618);
    }

    /* renamed from: a */
    static /* synthetic */ void m74719a(FindMContactIntroUI findMContactIntroUI) {
        AppMethodBeat.m2504i(13619);
        StringBuilder stringBuilder;
        if (findMContactIntroUI.gsC) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_200_phone")).append(",1").toString());
            C30379h.m48428a((Context) findMContactIntroUI, (int) C25738R.string.bu8, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new C422725(), new C422736());
            AppMethodBeat.m2505o(13619);
        } else if (C38033l.apR()) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_200_phone")).append(",1").toString());
            C30379h.m48428a((Context) findMContactIntroUI, (int) C25738R.string.bu8, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new C422747(), new C188118());
            AppMethodBeat.m2505o(13619);
        } else {
            findMContactIntroUI.api();
            AppMethodBeat.m2505o(13619);
        }
    }
}
