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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.applet.C23576a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C32961i;
import com.tencent.p177mm.plugin.account.friend.p272a.C32961i.C1983a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI */
public class FindMContactInviteUI extends MMWizardActivity {
    private ProgressDialog ehJ = null;
    private TextView emptyTipTv = null;
    private C1202f fQS = null;
    private String gsF;
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
    private C1983a gxa = new C265906();
    private String gxc = null;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$12 */
    class C988612 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$12$2 */
        class C98872 implements OnCancelListener {
            C98872() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$12$1 */
        class C98881 implements C1202f {
            C98881() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(108549);
                if (FindMContactInviteUI.this.ehJ != null) {
                    FindMContactInviteUI.this.ehJ.dismiss();
                    FindMContactInviteUI.this.ehJ = null;
                }
                if (FindMContactInviteUI.this.fQS != null) {
                    C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetSendToNetworkOn, FindMContactInviteUI.this.fQS);
                    FindMContactInviteUI.this.fQS = null;
                }
                FindMContactInviteUI.m42444l(FindMContactInviteUI.this);
                AppMethodBeat.m2505o(108549);
            }
        }

        C988612() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108550);
            StringBuilder stringBuilder;
            if (FindMContactInviteUI.this.gwX == 1) {
                stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_500_QQ,");
                C1720g.m3534RN();
                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_500_QQ")).append(",3").toString());
            } else {
                stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_500_phone,");
                C1720g.m3534RN();
                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_500_phone")).append(",3").toString());
            }
            C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetSendToNetworkOn, FindMContactInviteUI.this.fQS = new C98881());
            FindMContactInviteUI findMContactInviteUI = FindMContactInviteUI.this;
            Context context = FindMContactInviteUI.this.mController.ylL;
            FindMContactInviteUI.this.getString(C25738R.string.f9238tz);
            findMContactInviteUI.ehJ = C30379h.m48458b(context, FindMContactInviteUI.this.getString(C25738R.string.bud), true, new C98872());
            FindMContactInviteUI.this.gwQ.mo53527wc(FindMContactInviteUI.this.gxc);
            AppMethodBeat.m2505o(108550);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$1 */
    class C98891 implements OnCancelListener {
        C98891() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$7 */
    class C188317 implements View.OnClickListener {
        C188317() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108544);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R300_300_AddAllButton")).append(",3").toString());
            if (FindMContactInviteUI.this.gsz == 2) {
                FindMContactInviteUI.this.gwQ.mo53517dl(true);
                FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                FindMContactInviteUI.this.gwW.setVisibility(8);
                if (FindMContactInviteUI.this.gwV != null) {
                    FindMContactInviteUI.this.gwV.setVisibility(0);
                    AppMethodBeat.m2505o(108544);
                    return;
                }
            } else if (FindMContactInviteUI.this.gsz == 1) {
                FindMContactInviteUI.this.gwQ.mo53517dl(true);
                FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                FindMContactInviteUI.m42440h(FindMContactInviteUI.this);
                AppMethodBeat.m2505o(108544);
                return;
            } else {
                FindMContactInviteUI.this.gwQ.mo53517dl(true);
                FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
                FindMContactInviteUI.this.gwW.setVisibility(8);
                if (FindMContactInviteUI.this.gwV != null) {
                    FindMContactInviteUI.this.gwV.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(108544);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$8 */
    class C188328 implements View.OnClickListener {
        C188328() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108545);
            FindMContactInviteUI.this.gwW.setVisibility(0);
            FindMContactInviteUI.this.gwV.setVisibility(8);
            FindMContactInviteUI.this.gwQ.mo53517dl(false);
            FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
            AppMethodBeat.m2505o(108545);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$9 */
    class C188339 implements OnTouchListener {
        C188339() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(108546);
            if (FindMContactInviteUI.this.gwQ != null) {
                C32961i b = FindMContactInviteUI.this.gwQ;
                if (b.gvm != null) {
                    b.gvm.onTouchEvent(motionEvent);
                }
            }
            AppMethodBeat.m2505o(108546);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$11 */
    class C2658711 implements View.OnClickListener {
        C2658711() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108548);
            C4978c.m7375a(FindMContactInviteUI.this.gtT);
            AppMethodBeat.m2505o(108548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$10 */
    class C2658810 implements OnMenuItemClickListener {
        C2658810() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(108547);
            FindMContactInviteUI.m42440h(FindMContactInviteUI.this);
            AppMethodBeat.m2505o(108547);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$4 */
    class C265894 implements OnClickListener {
        C265894() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108539);
            FindMContactInviteUI.this.gwZ = true;
            FindMContactInviteUI.this.finish();
            AppMethodBeat.m2505o(108539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$6 */
    class C265906 implements C1983a {
        C265906() {
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(108543);
            if (FindMContactInviteUI.this.gsz == 2 || FindMContactInviteUI.this.gsz != 1) {
                FindMContactInviteUI.this.gwW.setText(FindMContactInviteUI.this.getString(C25738R.string.bua, new Object[]{Integer.valueOf(FindMContactInviteUI.this.gwQ.getCount())}));
            } else {
                FindMContactInviteUI.this.gwW.setText(FindMContactInviteUI.this.getString(C25738R.string.bub));
            }
            if (FindMContactInviteUI.this.gwQ.apN()) {
                if (!(FindMContactInviteUI.this.gsz == 1 || FindMContactInviteUI.this.gwW.getVisibility() != 0 || FindMContactInviteUI.this.gwV == null)) {
                    FindMContactInviteUI.this.gwW.setVisibility(8);
                    FindMContactInviteUI.this.gwV.setVisibility(0);
                }
            } else if (!(FindMContactInviteUI.this.gsz == 1 || FindMContactInviteUI.this.gwW.getVisibility() != 8 || FindMContactInviteUI.this.gwV == null)) {
                FindMContactInviteUI.this.gwW.setVisibility(0);
                FindMContactInviteUI.this.gwV.setVisibility(8);
            }
            if (FindMContactInviteUI.this.gwQ.getSelectCount() <= 0 || FindMContactInviteUI.this.gsz == 1) {
                FindMContactInviteUI.this.gwS.setText(FindMContactInviteUI.this.getResources().getQuantityString(C25738R.plurals.f9596h, FindMContactInviteUI.this.gwQ.getCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.this.gwQ.getCount())}));
                AppMethodBeat.m2505o(108543);
                return;
            }
            FindMContactInviteUI.this.gwS.setText(FindMContactInviteUI.this.getResources().getQuantityString(C25738R.plurals.f9595g, FindMContactInviteUI.this.gwQ.getSelectCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.this.gwQ.getSelectCount())}));
            AppMethodBeat.m2505o(108543);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$2 */
    class C265912 implements OnClickListener {
        C265912() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$3 */
    class C265923 implements OnClickListener {
        C265923() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108538);
            FindMContactInviteUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FindMContactInviteUI.this.gwZ = true;
            FindMContactInviteUI.this.finish();
            AppMethodBeat.m2505o(108538);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI$5 */
    class C265935 implements C5002a {
        C265935() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(108540);
            if (FindMContactInviteUI.this.ehJ != null) {
                FindMContactInviteUI.this.ehJ.dismiss();
                FindMContactInviteUI.this.ehJ = null;
            }
            FindMContactInviteUI.this.gwQ.notifyDataSetChanged();
            AppMethodBeat.m2505o(108540);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(108541);
            try {
                FindMContactInviteUI.this.gwY = C46482a.m87692cJ(FindMContactInviteUI.this);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FindMContactInviteUI", e, "", new Object[0]);
            }
            FindMContactInviteUI.this.gwQ.gsD = FindMContactInviteUI.this.gwY;
            FindMContactInviteUI.this.gwQ.mo53526r(((C7599a) C1720g.m3530M(C7599a.class)).getFriendData());
            AppMethodBeat.m2505o(108541);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(108542);
            String str = super.toString() + "|listMFriendData";
            AppMethodBeat.m2505o(108542);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FindMContactInviteUI() {
        AppMethodBeat.m2504i(108551);
        AppMethodBeat.m2505o(108551);
    }

    /* renamed from: l */
    static /* synthetic */ void m42444l(FindMContactInviteUI findMContactInviteUI) {
        AppMethodBeat.m2504i(108562);
        findMContactInviteUI.aoZ();
        AppMethodBeat.m2505o(108562);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(108552);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bue);
        C24679a.gkF.mo38846BV();
        this.gxc = getIntent().getStringExtra("regsetinfo_ticket");
        this.gwX = getIntent().getIntExtra("login_type", 0);
        this.gsz = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(108552);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(108553);
        if (i == 4) {
            aoZ();
            AppMethodBeat.m2505o(108553);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(108553);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(108554);
        C42756a.m75796wA(this.gsF);
        aqX();
        mo27541Ni(1);
        AppMethodBeat.m2505o(108554);
    }

    public void onResume() {
        AppMethodBeat.m2504i(108555);
        super.onResume();
        this.gwQ.notifyDataSetChanged();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_400_QQ")).append(",1").toString());
        } else {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_400_phone,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R300_400_phone")).append(",1").toString());
        }
        if (this.gwZ) {
            C4990ab.m7417i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
            if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                aqv();
            } else {
                AppMethodBeat.m2505o(108555);
                return;
            }
        }
        AppMethodBeat.m2505o(108555);
    }

    public void onPause() {
        AppMethodBeat.m2504i(108557);
        super.onPause();
        StringBuilder stringBuilder;
        if (this.gwX == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_400_QQ")).append(",2").toString());
            AppMethodBeat.m2505o(108557);
            return;
        }
        stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R300_400_phone")).append(",2").toString());
        AppMethodBeat.m2505o(108557);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(108558);
        if (this.fQS != null) {
            C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetSendToNetworkOn, this.fQS);
            this.fQS = null;
        }
        if (this.gwQ != null) {
            C32961i c32961i = this.gwQ;
            if (c32961i.gvm != null) {
                c32961i.gvm.detach();
                c32961i.gvm = null;
            }
        }
        ((C7599a) C1720g.m3530M(C7599a.class)).clearFriendData();
        super.onDestroy();
        AppMethodBeat.m2505o(108558);
    }

    public final int getLayoutId() {
        return 2130969552;
    }

    public final void initView() {
        AppMethodBeat.m2504i(108559);
        this.emptyTipTv = (TextView) findViewById(2131824026);
        this.emptyTipTv.setText(C25738R.string.d07);
        this.gtT = (ListView) findViewById(2131824012);
        if (this.gsz == 2 || this.gsz != 1) {
            this.gwR = LayoutInflater.from(this).inflate(2130969553, null);
            this.gwS = (TextView) this.gwR.findViewById(2131824029);
            this.gwT = (TextView) this.gwR.findViewById(2131824028);
            this.gwU = (TextView) this.gwR.findViewById(2131824032);
            this.gwW = (Button) this.gwR.findViewById(2131824031);
            this.gwT.setText(getString(C25738R.string.buf));
            this.gwU.setText(getString(C25738R.string.buc));
            this.gwW.setText(getString(C25738R.string.bua, new Object[]{Integer.valueOf(0)}));
            this.gwV = (TextView) this.gwR.findViewById(2131824030);
        } else {
            this.gwR = LayoutInflater.from(this).inflate(2130969554, null);
            this.gwS = (TextView) this.gwR.findViewById(2131824029);
            this.gwT = (TextView) this.gwR.findViewById(2131824028);
            this.gwU = (TextView) this.gwR.findViewById(2131824032);
            this.gwW = (Button) this.gwR.findViewById(2131824031);
            this.gwT.setText(getString(C25738R.string.buc));
            this.gwU.setText(getString(C25738R.string.buc));
            this.gwW.setText(getString(C25738R.string.bub));
        }
        this.gwQ = new C32961i(this, this.gxa, 2);
        this.gwW.setOnClickListener(new C188317());
        if (this.gwV != null) {
            this.gwV.setOnClickListener(new C188328());
            this.gwV.setVisibility(8);
        }
        this.gtT.addHeaderView(this.gwR);
        this.gtT.setAdapter(this.gwQ);
        this.gtT.setOnScrollListener(new C23576a());
        this.gtT.setOnTouchListener(new C188339());
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C2658810());
        C2658711 c2658711 = new C2658711();
        AppMethodBeat.m2505o(108559);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(108560);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(108560);
            return;
        }
        C4990ab.m7417i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C265923(), new C265894());
                    break;
                }
                aqv();
                AppMethodBeat.m2505o(108560);
                return;
        }
        AppMethodBeat.m2505o(108560);
    }

    private void aqv() {
        AppMethodBeat.m2504i(108556);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.d09), true, new C98891());
        C1720g.m3539RS().mo10300a(new C265935());
        AppMethodBeat.m2505o(108556);
    }

    /* renamed from: h */
    static /* synthetic */ void m42440h(FindMContactInviteUI findMContactInviteUI) {
        AppMethodBeat.m2504i(108561);
        findMContactInviteUI.aqX();
        if (findMContactInviteUI.gwQ.getSelectCount() == 0) {
            findMContactInviteUI.aoZ();
            AppMethodBeat.m2505o(108561);
            return;
        }
        C30379h.m48440a((Context) findMContactInviteUI, findMContactInviteUI.getString(C25738R.string.bu_), "", new C988612(), new C265912());
        AppMethodBeat.m2505o(108561);
    }
}
