package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32574ir;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.ipcall.C39265b;
import com.tencent.p177mm.plugin.ipcall.p438a.C28325a;
import com.tencent.p177mm.plugin.ipcall.p438a.C43220d;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34373g;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C43223b;
import com.tencent.p177mm.plugin.ipcall.p442ui.C43228e.C211383;
import com.tencent.p177mm.plugin.ipcall.p442ui.C43228e.C211394;
import com.tencent.p177mm.plugin.ipcall.p442ui.C43228e.C211405;
import com.tencent.p177mm.plugin.ipcall.p442ui.C43228e.C392692;
import com.tencent.p177mm.plugin.ipcall.p442ui.C43228e.C432291;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI */
public class IPCallAddressUI extends MMActivity implements C1202f {
    private View nAU;
    private ListView nBg;
    private C43228e nBh = null;
    private int nBi = 0;
    private boolean nBj = false;
    private boolean nBk = true;
    private boolean nBl = false;
    private C4884c nBm = new C283401();
    private Runnable nBn = new C343863();

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI$2 */
    class C122612 implements OnMenuItemClickListener {
        C122612() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22051);
            if (IPCallAddressUI.this.nBi == 1) {
                C39265b.gkE.mo38931p(new Intent(), IPCallAddressUI.this);
            } else {
                IPCallAddressUI.this.finish();
            }
            AppMethodBeat.m2505o(22051);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI$1 */
    class C283401 extends C4884c<C32574ir> {
        C283401() {
            AppMethodBeat.m2504i(22049);
            this.xxI = C32574ir.class.getName().hashCode();
            AppMethodBeat.m2505o(22049);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(22050);
            if (IPCallAddressUI.this.nBh != null) {
                IPCallAddressUI.this.nBh.bIh();
            }
            AppMethodBeat.m2505o(22050);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI$5 */
    class C343855 implements OnClickListener {
        C343855() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22054);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(22054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI$3 */
    class C343863 implements Runnable {
        C343863() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22052);
            C28325a.bHb().mo46238a(null, true);
            AppMethodBeat.m2505o(22052);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI$4 */
    class C343874 implements OnClickListener {
        C343874() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22053);
            dialogInterface.dismiss();
            IPCallAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(22053);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallAddressUI() {
        AppMethodBeat.m2504i(22055);
        AppMethodBeat.m2505o(22055);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22056);
        super.onCreate(bundle);
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE);
            Intent intent = new Intent();
            intent.setClass(this.mController.ylL, IPCallAcitivityUI.class);
            this.mController.ylL.startActivity(intent);
            overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
            this.nBk = false;
        }
        setBackBtn(new C122612());
        if (this.nBk) {
            this.nBl = true;
            bIj();
        }
        C9638aw.m17190ZK();
        this.nBj = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue();
        setMMTitle((int) C25738R.string.cgr);
        this.nBg = (ListView) findViewById(2131825036);
        this.nAU = findViewById(2131825037);
        this.nBh = new C43228e(this, this.nBg, this.nAU);
        C43228e c43228e = this.nBh;
        c43228e.nAT = new C46913h(c43228e.nAV);
        ViewGroup viewGroup = (ViewGroup) View.inflate(c43228e.nAV, 2130969893, null);
        c43228e.nAS.addHeaderView(viewGroup, null, false);
        c43228e.nAS.setAdapter(c43228e.nAT);
        c43228e.nAX = (TextView) viewGroup.findViewById(2131825121);
        c43228e.nAY = (TextView) viewGroup.findViewById(2131825122);
        c43228e.nAZ = (LinearLayout) viewGroup.findViewById(2131825123);
        c43228e.nBa = (TextView) viewGroup.findViewById(2131825125);
        c43228e.nBb = (ImageView) viewGroup.findViewById(2131825124);
        viewGroup.findViewById(2131825120).setOnClickListener(new C432291());
        viewGroup.findViewById(2131825127).setOnClickListener(new C392692());
        viewGroup.findViewById(2131825128).setOnClickListener(new C211383());
        c43228e.nAS.setOnItemClickListener(new C211394());
        c43228e.nAS.setOnItemLongClickListener(new C211405());
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            C43220d.bHg().mo68728ii(true);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.FALSE);
        } else {
            C43220d.bHg().mo68728ii(false);
        }
        if (c43228e.nAT.getCount() > 0) {
            c43228e.nAU.setVisibility(8);
        } else {
            c43228e.nAU.setVisibility(0);
        }
        c43228e.bIi();
        c43228e.bIh();
        c43228e.nAW = true;
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_TOKYO, (C1202f) this);
        C4879a.xxA.mo10052c(this.nBm);
        this.nBi = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        C7060h.pYm.mo8378a(257, 0, 1, true);
        AppMethodBeat.m2505o(22056);
    }

    public final int getLayoutId() {
        return 2130969881;
    }

    private void bIj() {
        AppMethodBeat.m2504i(22057);
        C4990ab.m7417i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            C7305d.post(this.nBn, "IPCallAddressUI_LoadSystemAddressBook");
        }
        AppMethodBeat.m2505o(22057);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22058);
        super.onDestroy();
        if (this.nBh != null) {
            C43228e c43228e = this.nBh;
            c43228e.nAS.setOnItemClickListener(null);
            c43228e.nAS.setOnItemLongClickListener(null);
            C17884o.acd().mo67500b(c43228e.nAT);
        }
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_TOKYO, (C1202f) this);
        C4879a.xxA.mo10053d(this.nBm);
        AppMethodBeat.m2505o(22058);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22059);
        super.onResume();
        if (this.nBh != null) {
            C43228e c43228e = this.nBh;
            if (!(c43228e.nAT == null || c43228e.nAW)) {
                c43228e.nAT.notifyDataSetChanged();
                if (c43228e.nAT.getCount() > 0) {
                    c43228e.nAU.setVisibility(8);
                } else {
                    c43228e.nAU.setVisibility(0);
                }
            }
            c43228e.nAW = false;
        }
        supportInvalidateOptionsMenu();
        C43223b.bHU().mo68730it(true);
        if (!this.nBl) {
            this.nBl = true;
            bIj();
        }
        AppMethodBeat.m2505o(22059);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22060);
        if ((c1207m instanceof C34373g) && i == 0 && i2 == 0 && this.nBh != null) {
            this.nBh.bIi();
        }
        AppMethodBeat.m2505o(22060);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(22061);
        C4990ab.m7410d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.m2505o(22061);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(22062);
        if (this.nBi == 1) {
            C39265b.gkE.mo38931p(new Intent(), this);
            AppMethodBeat.m2505o(22062);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(22062);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(22063);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(22063);
            return;
        }
        C4990ab.m7417i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0 && this.nBj) {
                    this.nBj = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C343874(), new C343855());
                    break;
                }
        }
        AppMethodBeat.m2505o(22063);
    }
}
