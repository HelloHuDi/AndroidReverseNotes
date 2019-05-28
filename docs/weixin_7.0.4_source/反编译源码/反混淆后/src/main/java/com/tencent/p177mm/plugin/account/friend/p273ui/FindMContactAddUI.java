package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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
import com.tencent.p177mm.plugin.account.friend.p272a.C32961i;
import com.tencent.p177mm.plugin.account.friend.p272a.C32961i.C1983a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI */
public class FindMContactAddUI extends MMWizardActivity {
    private ProgressDialog ehJ = null;
    private String elr = null;
    private TextView emptyTipTv = null;
    private C1202f fQS = null;
    private String gsF;
    private String gsy = "";
    private int gsz = 2;
    private ListView gtT;
    private C32961i gwQ;
    private View gwR;
    private TextView gwS = null;
    private TextView gwT = null;
    private TextView gwU = null;
    private TextView gwV = null;
    private Button gwW = null;
    private int gwX;
    private List<String[]> gwY;
    private boolean gwZ = true;
    private C1983a gxa = new C188217();

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$10 */
    class C988310 implements OnMenuItemClickListener {
        C988310() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(108523);
            FindMContactAddUI.m29416i(FindMContactAddUI.this);
            AppMethodBeat.m2505o(108523);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$12 */
    class C988412 implements OnClickListener {
        C988412() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$9 */
    class C98859 implements View.OnClickListener {
        C98859() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108522);
            FindMContactAddUI.this.gwW.setVisibility(0);
            FindMContactAddUI.this.gwV.setVisibility(8);
            FindMContactAddUI.this.gwQ.mo53517dl(false);
            FindMContactAddUI.this.gwQ.notifyDataSetChanged();
            AppMethodBeat.m2505o(108522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$7 */
    class C188217 implements C1983a {
        C188217() {
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(108520);
            if (FindMContactAddUI.this.gsz == 2 || FindMContactAddUI.this.gsz != 1) {
                FindMContactAddUI.this.gwW.setText(FindMContactAddUI.this.getString(C25738R.string.bu2, new Object[]{Integer.valueOf(FindMContactAddUI.this.gwQ.getCount())}));
            } else {
                FindMContactAddUI.this.gwW.setText(FindMContactAddUI.this.getString(C25738R.string.bu3));
            }
            if (FindMContactAddUI.this.gwQ.apN()) {
                if (!(FindMContactAddUI.this.gsz == 1 || FindMContactAddUI.this.gwW.getVisibility() != 0 || FindMContactAddUI.this.gwV == null)) {
                    FindMContactAddUI.this.gwW.setVisibility(8);
                    FindMContactAddUI.this.gwV.setVisibility(0);
                }
            } else if (!(FindMContactAddUI.this.gsz == 1 || FindMContactAddUI.this.gwW.getVisibility() != 8 || FindMContactAddUI.this.gwV == null)) {
                FindMContactAddUI.this.gwW.setVisibility(0);
                FindMContactAddUI.this.gwV.setVisibility(8);
            }
            if (FindMContactAddUI.this.gwQ.getSelectCount() <= 0 || FindMContactAddUI.this.gsz == 1) {
                FindMContactAddUI.this.gwS.setText(FindMContactAddUI.this.getResources().getQuantityString(C25738R.plurals.f9597i, FindMContactAddUI.this.gwQ.getCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.gwQ.getCount())}));
                AppMethodBeat.m2505o(108520);
                return;
            }
            FindMContactAddUI.this.gwS.setText(FindMContactAddUI.this.getResources().getQuantityString(C25738R.plurals.f9594f, FindMContactAddUI.this.gwQ.getSelectCount(), new Object[]{Integer.valueOf(FindMContactAddUI.this.gwQ.getSelectCount())}));
            AppMethodBeat.m2505o(108520);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$11 */
    class C1882211 implements View.OnClickListener {
        C1882211() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108524);
            C4978c.m7375a(FindMContactAddUI.this.gtT);
            AppMethodBeat.m2505o(108524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$1 */
    class C188231 implements OnCancelListener {
        C188231() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$8 */
    class C188248 implements View.OnClickListener {
        C188248() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108521);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_300_AddAllButton")).append(",3").toString());
            if (FindMContactAddUI.this.gsz == 2) {
                FindMContactAddUI.this.gwQ.mo53517dl(true);
                FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                FindMContactAddUI.this.gwW.setVisibility(8);
                if (FindMContactAddUI.this.gwV != null) {
                    FindMContactAddUI.this.gwV.setVisibility(0);
                    AppMethodBeat.m2505o(108521);
                    return;
                }
            } else if (FindMContactAddUI.this.gsz == 1) {
                FindMContactAddUI.this.gwQ.mo53517dl(true);
                FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                FindMContactAddUI.m29416i(FindMContactAddUI.this);
                AppMethodBeat.m2505o(108521);
                return;
            } else {
                FindMContactAddUI.this.gwQ.mo53517dl(true);
                FindMContactAddUI.this.gwQ.notifyDataSetChanged();
                FindMContactAddUI.this.gwW.setVisibility(8);
                if (FindMContactAddUI.this.gwV != null) {
                    FindMContactAddUI.this.gwV.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(108521);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$2 */
    class C188252 implements C1202f {
        C188252() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(108514);
            if (FindMContactAddUI.this.ehJ != null) {
                FindMContactAddUI.this.ehJ.dismiss();
                FindMContactAddUI.this.ehJ = null;
            }
            if (FindMContactAddUI.this.fQS != null) {
                C1720g.m3540Rg().mo14546b(30, FindMContactAddUI.this.fQS);
                FindMContactAddUI.this.fQS = null;
            }
            if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                Toast.makeText(FindMContactAddUI.this.mController.ylL, str, 1).show();
                AppMethodBeat.m2505o(108514);
            } else if (FindMContactAddUI.this.gsy == null || !FindMContactAddUI.this.gsy.contains("2")) {
                FindMContactAddUI.m29421n(FindMContactAddUI.this);
                AppMethodBeat.m2505o(108514);
            } else {
                Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
                intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.elr);
                intent.putExtra("login_type", FindMContactAddUI.this.gwX);
                intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.gsz);
                MMWizardActivity.m23791J(FindMContactAddUI.this, intent);
                AppMethodBeat.m2505o(108514);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$5 */
    class C188265 implements OnClickListener {
        C188265() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108516);
            FindMContactAddUI.this.gwZ = true;
            FindMContactAddUI.this.finish();
            AppMethodBeat.m2505o(108516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$4 */
    class C188274 implements OnClickListener {
        C188274() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108515);
            FindMContactAddUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FindMContactAddUI.this.gwZ = true;
            FindMContactAddUI.this.finish();
            AppMethodBeat.m2505o(108515);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$13 */
    class C1882813 implements OnClickListener {
        C1882813() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108525);
            if (FindMContactAddUI.this.gsy == null || !FindMContactAddUI.this.gsy.contains("2")) {
                FindMContactAddUI.m29421n(FindMContactAddUI.this);
                AppMethodBeat.m2505o(108525);
                return;
            }
            Intent intent = new Intent(FindMContactAddUI.this, FindMContactInviteUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactAddUI.this.elr);
            intent.putExtra("login_type", FindMContactAddUI.this.gwX);
            intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.this.gsz);
            MMWizardActivity.m23791J(FindMContactAddUI.this, intent);
            AppMethodBeat.m2505o(108525);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$3 */
    class C188293 implements OnCancelListener {
        C188293() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI$6 */
    class C188306 implements C5002a {
        C188306() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(108517);
            if (FindMContactAddUI.this.ehJ != null) {
                FindMContactAddUI.this.ehJ.dismiss();
                FindMContactAddUI.this.ehJ = null;
            }
            FindMContactAddUI.this.gwQ.notifyDataSetChanged();
            AppMethodBeat.m2505o(108517);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(108518);
            try {
                FindMContactAddUI.this.gwY = C46482a.m87692cJ(FindMContactAddUI.this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FindMContactAddUI", e, "", new Object[0]);
            }
            FindMContactAddUI.this.gwQ.gsD = FindMContactAddUI.this.gwY;
            FindMContactAddUI.this.gwQ.mo53526r(((C7599a) C1720g.m3530M(C7599a.class)).getFriendData());
            AppMethodBeat.m2505o(108518);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(108519);
            String str = super.toString() + "|listMFriendData";
            AppMethodBeat.m2505o(108519);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FindMContactAddUI() {
        AppMethodBeat.m2504i(108526);
        AppMethodBeat.m2505o(108526);
    }

    /* renamed from: n */
    static /* synthetic */ void m29421n(FindMContactAddUI findMContactAddUI) {
        AppMethodBeat.m2504i(108537);
        findMContactAddUI.aoZ();
        AppMethodBeat.m2505o(108537);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(108527);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bu7);
        C24679a.gkF.mo38846BV();
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.gwX = getIntent().getIntExtra("login_type", 0);
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(108527);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(108529);
        if (i == 4) {
            aoZ();
            AppMethodBeat.m2505o(108529);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(108529);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(108530);
        C42756a.m75796wA(this.gsF);
        aqX();
        mo27541Ni(1);
        AppMethodBeat.m2505o(108530);
    }

    public void onResume() {
        AppMethodBeat.m2504i(108531);
        super.onResume();
        this.gwQ.notifyDataSetChanged();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_300_QQ")).append(",1").toString());
            C42756a.m75798wz("R300_300_QQ");
        } else {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_300_phone,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_300_phone")).append(",1").toString());
            C42756a.m75798wz("R300_300_phone");
        }
        if (this.gwZ) {
            C4990ab.m7417i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
            if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                aqv();
            } else {
                AppMethodBeat.m2505o(108531);
                return;
            }
        }
        AppMethodBeat.m2505o(108531);
    }

    public void onPause() {
        AppMethodBeat.m2504i(108532);
        super.onPause();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_300_QQ")).append(",2").toString());
            AppMethodBeat.m2505o(108532);
            return;
        }
        stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_300_phone")).append(",2").toString());
        AppMethodBeat.m2505o(108532);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(108533);
        if (this.fQS != null) {
            C1720g.m3540Rg().mo14546b(30, this.fQS);
            this.fQS = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(108533);
    }

    public final int getLayoutId() {
        return 2130969552;
    }

    public final void initView() {
        AppMethodBeat.m2504i(108534);
        this.emptyTipTv = (TextView) findViewById(2131824026);
        this.emptyTipTv.setText(C25738R.string.d07);
        this.gtT = (ListView) findViewById(2131824012);
        if (this.gsz == 2 || this.gsz != 1) {
            this.gwR = LayoutInflater.from(this).inflate(2130969553, null);
            this.gwS = (TextView) this.gwR.findViewById(2131824029);
            this.gwT = (TextView) this.gwR.findViewById(2131824028);
            this.gwU = (TextView) this.gwR.findViewById(2131824032);
            this.gwW = (Button) this.gwR.findViewById(2131824031);
            this.gwT.setText(getString(C25738R.string.buy));
            this.gwU.setText(getString(C25738R.string.buz));
            this.gwW.setText(getString(C25738R.string.bu2, new Object[]{Integer.valueOf(0)}));
            this.gwV = (TextView) this.gwR.findViewById(2131824030);
        } else {
            this.gwR = LayoutInflater.from(this).inflate(2130969554, null);
            this.gwS = (TextView) this.gwR.findViewById(2131824029);
            this.gwT = (TextView) this.gwR.findViewById(2131824028);
            this.gwU = (TextView) this.gwR.findViewById(2131824032);
            this.gwW = (Button) this.gwR.findViewById(2131824031);
            this.gwT.setText(getString(C25738R.string.buy));
            this.gwU.setText(getString(C25738R.string.buz));
            this.gwW.setText(getString(C25738R.string.bu3));
        }
        this.gwQ = new C32961i(this, this.gxa, 1);
        this.gwW.setOnClickListener(new C188248());
        if (this.gwV != null) {
            this.gwV.setOnClickListener(new C98859());
            this.gwV.setVisibility(8);
        }
        this.gtT.addHeaderView(this.gwR);
        this.gtT.setAdapter(this.gwQ);
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C988310());
        C1882211 c1882211 = new C1882211();
        AppMethodBeat.m2505o(108534);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(108535);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(108535);
            return;
        }
        C4990ab.m7417i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C188274(), new C188265());
                    break;
                }
                aqv();
                AppMethodBeat.m2505o(108535);
                return;
        }
        AppMethodBeat.m2505o(108535);
    }

    private void aqv() {
        AppMethodBeat.m2504i(108528);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.d09), true, new C188231());
        C1720g.m3539RS().mo10300a(new C188306());
        AppMethodBeat.m2505o(108528);
    }

    /* renamed from: i */
    static /* synthetic */ void m29416i(FindMContactAddUI findMContactAddUI) {
        AppMethodBeat.m2504i(108536);
        findMContactAddUI.aqX();
        if (findMContactAddUI.gwQ.getSelectCount() == 0) {
            C30379h.m48466d(findMContactAddUI, findMContactAddUI.getString(C25738R.string.bun), "", findMContactAddUI.getString(C25738R.string.bu0), findMContactAddUI.getString(C25738R.string.bu1), new C988412(), new C1882813());
            AppMethodBeat.m2505o(108536);
            return;
        }
        C6300p Rg = C1720g.m3540Rg();
        C1202f c188252 = new C188252();
        findMContactAddUI.fQS = c188252;
        Rg.mo14539a(30, c188252);
        Context context = findMContactAddUI.mController.ylL;
        findMContactAddUI.getString(C25738R.string.f9238tz);
        findMContactAddUI.ehJ = C30379h.m48458b(context, findMContactAddUI.getString(C25738R.string.bud), true, new C188293());
        C32961i c32961i = findMContactAddUI.gwQ;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < c32961i.gvi.size(); i++) {
            if (c32961i.gty[i] == 1) {
                linkedList.add(((aym) c32961i.gvi.get(i)).jBB);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        C1720g.m3540Rg().mo14541a(new C46498m(2, linkedList, linkedList2, "", ""), 0);
        AppMethodBeat.m2505o(108536);
    }
}
