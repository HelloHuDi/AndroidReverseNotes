package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.ipcall.C46040a;
import com.tencent.p177mm.plugin.ipcall.p438a.C28325a;
import com.tencent.p177mm.plugin.ipcall.p438a.C28325a.C28322a;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21082b;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI */
public class IPCallContactUI extends MMActivity {
    private C5601o elS = new C5601o((byte) 0);
    private C7306ak fbD = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(22072);
            if (message.what == 1) {
                if (IPCallContactUI.this.nBv != null) {
                    IPCallContactUI.this.nBv.dismiss();
                }
                IPCallContactUI.this.nBx.setVisibility(0);
                IPCallContactUI.this.nBw;
                C21128c.nzw = C21082b.bHW();
                IPCallContactUI.this.nBw.mo6869KC();
                IPCallContactUI.this.nBw.notifyDataSetChanged();
                IPCallContactUI.this.nBg.invalidateViews();
                IPCallContactUI.this.nBz.setAddressCount(IPCallContactUI.this.nBw.getCount());
                C46040a.bGG().bGH();
                AppMethodBeat.m2505o(22072);
                return;
            }
            if (message.what == 2) {
                if (IPCallContactUI.this.nBw.getCount() == 0) {
                    IPCallContactUI.this.nBB.setVisibility(0);
                } else {
                    IPCallContactUI.this.nBB.setVisibility(8);
                }
                if (IPCallContactUI.this.nBw.getCount() != 0 && IPCallContactUI.this.nBG) {
                    IPCallContactUI.this.nBw.notifyDataSetChanged();
                }
            }
            AppMethodBeat.m2505o(22072);
        }
    };
    private String gtX;
    private VerticalScrollBar nBA;
    private LinearLayout nBB;
    private int nBC = -1;
    private int nBD = -1;
    private C28322a nBE = new C211017();
    private Runnable nBF = new C1226210();
    private boolean nBG = true;
    private ListView nBg;
    private Runnable nBn = new C211028();
    private ProgressDialog nBv = null;
    private C21128c nBw;
    private RelativeLayout nBx;
    private LinearLayout nBy;
    private IPCallAddressCountView nBz = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$10 */
    class C1226210 implements Runnable {
        C1226210() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22084);
            if (!(IPCallContactUI.this.nBw == null || IPCallContactUI.this.nBg == null || IPCallContactUI.this.nBw.jLC)) {
                IPCallContactUI.this.nBw.mo36448vM(IPCallContactUI.this.gtX);
                IPCallContactUI.this.fbD.sendEmptyMessage(2);
                IPCallContactUI.this.nBg.invalidateViews();
            }
            AppMethodBeat.m2505o(22084);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$9 */
    class C122639 implements OnCancelListener {
        C122639() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22083);
            IPCallContactUI.this.finish();
            AppMethodBeat.m2505o(22083);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$12 */
    class C2109912 implements C30374a {
        C2109912() {
        }

        /* renamed from: kp */
        public final void mo17482kp(String str) {
            AppMethodBeat.m2504i(22087);
            if ("↑".equals(str)) {
                IPCallContactUI.this.nBg.setSelection(0);
                AppMethodBeat.m2505o(22087);
                return;
            }
            int intValue;
            C21128c d = IPCallContactUI.this.nBw;
            if (d.emK.containsKey(str)) {
                intValue = ((Integer) d.emK.get(str)).intValue();
            } else {
                intValue = -1;
            }
            if (intValue != -1) {
                IPCallContactUI.this.nBg.setSelection(intValue);
            }
            AppMethodBeat.m2505o(22087);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$1 */
    class C211001 implements OnMenuItemClickListener {
        C211001() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22071);
            IPCallContactUI.this.finish();
            AppMethodBeat.m2505o(22071);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$7 */
    class C211017 implements C28322a {
        C211017() {
        }

        public final void aLj() {
            AppMethodBeat.m2504i(22081);
            IPCallContactUI.this.fbD.sendEmptyMessage(1);
            AppMethodBeat.m2505o(22081);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$8 */
    class C211028 implements Runnable {
        C211028() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22082);
            C28325a.bHb().mo46238a(IPCallContactUI.this.nBE, false);
            AppMethodBeat.m2505o(22082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$11 */
    class C2110311 implements OnScrollListener {
        private int lqq = 0;

        C2110311() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(22085);
            this.lqq = i;
            IPCallContactUI.this.aqX();
            AppMethodBeat.m2505o(22085);
        }

        @TargetApi(11)
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(22086);
            if (IPCallContactUI.this.nBC == -1) {
                IPCallContactUI.this.nBC = i;
                AppMethodBeat.m2505o(22086);
                return;
            }
            if (IPCallContactUI.this.nBD == -1) {
                IPCallContactUI.this.nBD = i;
            }
            AppMethodBeat.m2505o(22086);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$4 */
    class C211054 implements OnClickListener {
        C211054() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22074);
            dialogInterface.dismiss();
            IPCallContactUI.this.finish();
            AppMethodBeat.m2505o(22074);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$5 */
    class C211065 implements C5600b {
        C211065() {
        }

        public final void app() {
            AppMethodBeat.m2504i(22075);
            C4990ab.m7410d("MicroMsg.IPCallContactUI", "onEnterSearch");
            C7060h.pYm.mo8381e(12767, Integer.valueOf(1));
            IPCallContactUI.this.nBy.setVisibility(0);
            IPCallContactUI.this.nBg.setVisibility(8);
            IPCallContactUI.this.nBz.setVisibility(8);
            IPCallContactUI.this.mo36416iu(false);
            AppMethodBeat.m2505o(22075);
        }

        public final void apo() {
            AppMethodBeat.m2504i(22076);
            C4990ab.m7410d("MicroMsg.IPCallContactUI", "onQuitSearch");
            IPCallContactUI.this.mo36417vM("");
            IPCallContactUI.this.mo36416iu(true);
            IPCallContactUI.this.nBy.setVisibility(8);
            IPCallContactUI.this.nBg.setVisibility(0);
            IPCallContactUI.this.nBz.setVisibility(0);
            AppMethodBeat.m2505o(22076);
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(22077);
            C4990ab.m7410d("MicroMsg.IPCallContactUI", "onSearchChange");
            IPCallContactUI.this.mo36417vM(str);
            if (!C5046bo.isNullOrNil(str)) {
                IPCallContactUI.this.nBy.setVisibility(8);
                IPCallContactUI.this.nBg.setVisibility(0);
                IPCallContactUI.this.nBz.setVisibility(8);
            }
            AppMethodBeat.m2505o(22077);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            AppMethodBeat.m2504i(22078);
            C4990ab.m7410d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
            AppMethodBeat.m2505o(22078);
            return false;
        }

        public final void apq() {
            AppMethodBeat.m2504i(22079);
            IPCallContactUI.this.nBy.setVisibility(0);
            IPCallContactUI.this.nBg.setVisibility(8);
            IPCallContactUI.this.nBz.setVisibility(8);
            AppMethodBeat.m2505o(22079);
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$6 */
    class C211076 implements OnItemClickListener {
        C211076() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22080);
            if (IPCallContactUI.this.nBw.mo10892wK(i)) {
                AppMethodBeat.m2505o(22080);
                return;
            }
            C21083c xn = IPCallContactUI.this.nBw.mo36449xn(i);
            if (xn != null) {
                if (!IPCallContactUI.this.nBG) {
                    C7060h.pYm.mo8381e(12767, Integer.valueOf(2));
                }
                Intent intent = new Intent(IPCallContactUI.this.mController.ylL, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", xn.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", xn.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", xn.field_wechatUsername);
                IPCallContactUI.this.mController.ylL.startActivity(intent);
            }
            AppMethodBeat.m2505o(22080);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallContactUI$3 */
    class C211083 implements OnClickListener {
        C211083() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22073);
            dialogInterface.dismiss();
            IPCallContactUI.this.finish();
            IPCallContactUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(22073);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallContactUI() {
        AppMethodBeat.m2504i(22088);
        AppMethodBeat.m2505o(22088);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22089);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.cg6);
        setBackBtn(new C211001());
        C4990ab.m7417i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
        if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.nBx = (RelativeLayout) findViewById(2131824244);
            this.nBy = (LinearLayout) findViewById(2131825035);
            this.nBg = (ListView) findViewById(2131825036);
            this.nBA = (VerticalScrollBar) findViewById(2131821057);
            this.nBB = (LinearLayout) findViewById(2131825037);
            this.elS.zHa = new C211065();
            this.elS.zHf = C25738R.string.f9220te;
            mo17380a(this.elS);
            this.nBw = new C21128c(this.mController.ylL);
            C21128c.nzw = C21082b.bHW();
            this.nBz = new IPCallAddressCountView(this.mController.ylL, this.nBw.bIe());
            this.nBg.addFooterView(this.nBz, null, false);
            this.nBg.setAdapter(this.nBw);
            this.nBg.setOnItemClickListener(new C211076());
            this.nBA.setVisibility(0);
            this.nBg.setOnScrollListener(new C2110311());
            this.nBA.setOnScrollBarTouchListener(new C2109912());
            if (this.nBw.bIe() <= 0) {
                this.nBx.setVisibility(8);
                Context context = this.mController.ylL;
                this.mController.ylL.getString(C25738R.string.f9238tz);
                this.nBv = C30379h.m48458b(context, this.mController.ylL.getString(C25738R.string.cgq), true, new C122639());
                C7305d.post(this.nBn, "IPCall_LoadSystemAddressBook");
                AppMethodBeat.m2505o(22089);
                return;
            }
            C46040a.bGG().bGH();
        }
        AppMethodBeat.m2505o(22089);
    }

    /* renamed from: vM */
    public final void mo36417vM(String str) {
        AppMethodBeat.m2504i(22090);
        this.gtX = str;
        this.fbD.removeCallbacks(this.nBF);
        this.fbD.postDelayed(this.nBF, 200);
        AppMethodBeat.m2505o(22090);
    }

    /* renamed from: iu */
    public final void mo36416iu(boolean z) {
        AppMethodBeat.m2504i(22091);
        this.nBG = z;
        if (this.nBG) {
            this.nBw.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(22091);
    }

    public final int getLayoutId() {
        return 2130969883;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22092);
        super.onDestroy();
        C28325a bHb = C28325a.bHb();
        C28322a c28322a = this.nBE;
        if (bHb.nvk.contains(c28322a)) {
            bHb.nvk.remove(c28322a);
        }
        this.fbD.removeMessages(1);
        AppMethodBeat.m2505o(22092);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22093);
        super.onResume();
        supportInvalidateOptionsMenu();
        AppMethodBeat.m2505o(22093);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(22094);
        C4990ab.m7410d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.m2505o(22094);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(22095);
        super.onBackPressed();
        AppMethodBeat.m2505o(22095);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(22096);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(22096);
            return;
        }
        C4990ab.m7417i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C211083(), new C211054());
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(22096);
    }
}
