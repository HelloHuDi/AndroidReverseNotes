package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.account.bind.p271ui.C42279b.C26573a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.friend.p272a.C32956ab;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.friend.p272a.C9877al;
import com.tencent.p177mm.plugin.account.friend.p273ui.InviteFriendUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C45491b;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI */
public class MobileFriendUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private TextView emptyTipTv = null;
    private ListView gtT;
    C42279b gtU;
    private View gtV;
    private C9877al gtW;
    String gtX;
    private TextView gtY = null;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$13 */
    class C197313 implements C30723a {
        C197313() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(13731);
            MobileFriendUI mobileFriendUI = MobileFriendUI.this;
            MobileFriendUI.this.gtU.getCount();
            MobileFriendUI.m74757e(mobileFriendUI);
            AppMethodBeat.m2505o(13731);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$14 */
    class C197414 implements OnItemClickListener {
        C197414() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(13732);
            if (i < MobileFriendUI.this.gtT.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(13732);
                return;
            }
            C18817a c18817a = (C18817a) MobileFriendUI.this.gtU.getItem(i - MobileFriendUI.this.gtT.getHeaderViewsCount());
            if (c18817a.status == 1 || c18817a.status == 2) {
                MobileFriendUI.this.mo67798b(c18817a);
            }
            if (c18817a.status == 0) {
                Intent intent = new Intent(MobileFriendUI.this, InviteFriendUI.class);
                intent.putExtra("friend_type", 1);
                intent.putExtra("friend_user_name", c18817a.getUsername());
                intent.putExtra("friend_num", c18817a.apG());
                intent.putExtra("friend_nick", c18817a.apA());
                intent.putExtra("friend_weixin_nick", c18817a.apD());
                intent.putExtra("friend_scene", 13);
                MobileFriendUI.this.startActivity(intent);
            }
            AppMethodBeat.m2505o(13732);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$15 */
    class C197515 implements C26573a {
        C197515() {
        }

        /* renamed from: mT */
        public final void mo5733mT(int i) {
            AppMethodBeat.m2504i(13733);
            if (i > 0) {
                MobileFriendUI.this.gtY.setVisibility(8);
                AppMethodBeat.m2505o(13733);
                return;
            }
            MobileFriendUI.this.gtY.setVisibility(0);
            AppMethodBeat.m2505o(13733);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$2 */
    class C19762 implements OnClickListener {
        C19762() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13720);
            Intent intent = new Intent(MobileFriendUI.this.mController.ylL, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 6);
            MMWizardActivity.m23791J(MobileFriendUI.this, intent);
            AppMethodBeat.m2505o(13720);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$3 */
    class C19773 implements OnMenuItemClickListener {
        C19773() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13721);
            MobileFriendUI.this.aqX();
            MobileFriendUI.this.finish();
            AppMethodBeat.m2505o(13721);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$9 */
    class C98669 implements OnCancelListener {
        C98669() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13727);
            if (MobileFriendUI.this.gtW != null) {
                C1720g.m3540Rg().mo14547c(MobileFriendUI.this.gtW);
            }
            AppMethodBeat.m2505o(13727);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$8 */
    class C265678 implements DialogInterface.OnClickListener {
        C265678() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13726);
            MobileFriendUI.this.finish();
            AppMethodBeat.m2505o(13726);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$10 */
    class C3294510 implements C45491b {
        C3294510() {
        }

        /* renamed from: cN */
        public final void mo14963cN(boolean z) {
            AppMethodBeat.m2504i(13728);
            C4990ab.m7417i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
            if (z) {
                System.currentTimeMillis();
                C38033l.apX();
                C1720g.m3540Rg().mo14541a(new C9877al(C38033l.aqb(), C38033l.aqa()), 0);
                AppMethodBeat.m2505o(13728);
                return;
            }
            if (MobileFriendUI.this.ehJ != null) {
                MobileFriendUI.this.ehJ.dismiss();
                MobileFriendUI.this.ehJ = null;
            }
            AppMethodBeat.m2505o(13728);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$12 */
    class C3294612 implements C30723a {
        C3294612() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(13730);
            MobileFriendUI mobileFriendUI = MobileFriendUI.this;
            MobileFriendUI.this.gtU.getCount();
            MobileFriendUI.m74757e(mobileFriendUI);
            AppMethodBeat.m2505o(13730);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$1 */
    class C329471 implements DialogInterface.OnClickListener {
        C329471() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13719);
            MobileFriendUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            MobileFriendUI.this.finish();
            AppMethodBeat.m2505o(13719);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$4 */
    class C329484 implements OnClickListener {
        C329484() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13722);
            C4978c.m7375a(MobileFriendUI.this.gtT);
            AppMethodBeat.m2505o(13722);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$5 */
    class C329495 implements DialogInterface.OnClickListener {
        C329495() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13723);
            C7060h.pYm.mo8381e(11438, Integer.valueOf(6));
            C4990ab.m7417i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(6));
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            ((C7599a) C1720g.m3530M(C7599a.class)).syncUploadMContactStatus(true, true);
            MobileFriendUI.m74760h(MobileFriendUI.this);
            AppMethodBeat.m2505o(13723);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$11 */
    class C3802811 implements C5600b {
        C3802811() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(13729);
            MobileFriendUI.this.gtX = C5046bo.m7586vA(str);
            MobileFriendUI mobileFriendUI = MobileFriendUI.this;
            if (mobileFriendUI.gtU != null) {
                mobileFriendUI.gtU.mo67803vM(mobileFriendUI.gtX);
            }
            AppMethodBeat.m2505o(13729);
        }

        public final void apo() {
        }

        public final void app() {
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$7 */
    class C380297 implements OnClickListener {
        C380297() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13725);
            MMWizardActivity.m23791J(MobileFriendUI.this, new Intent(MobileFriendUI.this, BindMContactIntroUI.class));
            AppMethodBeat.m2505o(13725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.MobileFriendUI$6 */
    class C422776 implements DialogInterface.OnClickListener {
        C422776() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13724);
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
            ((C7599a) C1720g.m3530M(C7599a.class)).syncUploadMContactStatus(false, true);
            MobileFriendUI.this.finish();
            AppMethodBeat.m2505o(13724);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: h */
    static /* synthetic */ void m74760h(MobileFriendUI mobileFriendUI) {
        AppMethodBeat.m2504i(13745);
        mobileFriendUI.getData();
        AppMethodBeat.m2505o(13745);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13734);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.d0a);
        ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).fni.mo10108hY("qqlist", "update addr_upload2 set reserved4=0");
        C1720g.m3540Rg().mo14539a(32, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C19394e.CTRL_INDEX, (C1202f) this);
        initView();
        C4990ab.m7417i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)));
        if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            aps();
            AppMethodBeat.m2505o(13734);
            return;
        }
        AppMethodBeat.m2505o(13734);
    }

    private void aps() {
        AppMethodBeat.m2504i(13735);
        if (C41711b.m73394iW(26)) {
            C4990ab.m7417i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.WRITE_CONTACTS", 48, null, null)));
            if (!C35805b.m58707a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                AppMethodBeat.m2505o(13735);
                return;
            }
        }
        getData();
        AppMethodBeat.m2505o(13735);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(13736);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(13736);
            return;
        }
        C4990ab.m7417i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C329471(), new C265678());
                    break;
                }
                aps();
                AppMethodBeat.m2505o(13736);
                return;
        }
        AppMethodBeat.m2505o(13736);
    }

    private void getData() {
        AppMethodBeat.m2504i(13737);
        if (!C38033l.apR()) {
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.d09), true, new C98669());
            if (this.gtU.getCount() == 0) {
                if (!(((C7599a) C1720g.m3530M(C7599a.class)).syncAddrBook(new C3294510()) || this.ehJ == null)) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                AppMethodBeat.m2505o(13737);
                return;
            }
            List aqb = C38033l.aqb();
            List aqa = C38033l.aqa();
            if (aqb.size() == 0 && aqa.size() == 0) {
                C1720g.m3540Rg().mo14541a(new C32956ab(), 0);
            } else {
                this.gtW = new C9877al(C38033l.aqb(), C38033l.aqa());
                C1720g.m3540Rg().mo14541a(this.gtW, 0);
                AppMethodBeat.m2505o(13737);
                return;
            }
        }
        AppMethodBeat.m2505o(13737);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13738);
        super.onResume();
        this.gtU.notifyDataSetChanged();
        AppMethodBeat.m2505o(13738);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13739);
        super.onPause();
        AppMethodBeat.m2505o(13739);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13740);
        C18608f.m29045oU("2");
        C1720g.m3540Rg().mo14546b(32, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C19394e.CTRL_INDEX, (C1202f) this);
        this.gtU.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(13740);
    }

    public final int getLayoutId() {
        return 2130970235;
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(13741);
        this.emptyTipTv = (TextView) findViewById(2131824026);
        this.emptyTipTv.setText(C25738R.string.d07);
        this.gtY = (TextView) findViewById(2131824027);
        this.gtY.setText(C25738R.string.d0p);
        this.gtV = findViewById(2131824014);
        this.gtT = (ListView) findViewById(2131824012);
        C5601o c5601o = new C5601o((byte) 0);
        c5601o.zHa = new C3802811();
        mo17380a(c5601o);
        if (C26407g.aaK().mo60654oP("2") != null) {
            String str = C26407g.aaK().mo60654oP("2").value;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            C18608f.m29044oT("2");
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", Boolean.valueOf(z));
        if (z) {
            this.gtU = new C45494d(this, new C197313());
        } else {
            this.gtU = new C44690c(this, new C3294612());
        }
        this.gtT.setAdapter(this.gtU);
        this.gtT.setOnItemClickListener(new C197414());
        this.gtU.mo67802a(new C197515());
        if (!(C38033l.apS() == C38034a.SUCC || C38033l.apS() == C38034a.SUCC_UNLOAD)) {
            this.gtV = findViewById(2131824014);
            this.gtV.setVisibility(0);
            this.gtV.setOnClickListener(new C19762());
            this.gtT.setVisibility(8);
        }
        setBackBtn(new C19773());
        C329484 c329484 = new C329484();
        if (!C1853r.m3849Zc() || C38033l.apR()) {
            C30379h.m48428a((Context) this, (int) C25738R.string.a64, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new C329495(), new C422776());
        }
        AppMethodBeat.m2505o(13741);
    }

    /* renamed from: b */
    public final void mo67798b(C18817a c18817a) {
        AppMethodBeat.m2504i(13742);
        if (C5046bo.isNullOrNil(c18817a.getUsername())) {
            C4990ab.m7412e("MicroMsg.MobileFriendUI", "username is null");
            AppMethodBeat.m2505o(13742);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", c18817a.getUsername());
        intent.putExtra("Contact_Nick", c18817a.apD());
        intent.putExtra("Contact_Mobile_MD5", c18817a.mo34067Aq());
        intent.putExtra("Contact_Alias", c18817a.guS);
        intent.putExtra("Contact_Sex", c18817a.guN);
        intent.putExtra("Contact_Signature", c18817a.guQ);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(c18817a.guW, c18817a.guO, c18817a.guP));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        C24679a.gkE.mo38912c(intent, this);
        AppMethodBeat.m2505o(13742);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13743);
        C4990ab.m7416i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() == 32 && this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!(i == 0 && i2 == 0)) {
            C4990ab.m7412e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (c1207m.getType() == C19394e.CTRL_INDEX) {
            C1720g.m3540Rg().mo14541a(new C32956ab(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 32) {
                ((C7599a) C1720g.m3530M(C7599a.class)).updateAllContact();
            }
            this.gtU.mo5248a(null, null);
            AppMethodBeat.m2505o(13743);
            return;
        }
        if (c1207m.getType() == 32) {
            Toast.makeText(this, C25738R.string.d08, 0).show();
        }
        AppMethodBeat.m2505o(13743);
    }

    /* renamed from: e */
    static /* synthetic */ void m74757e(MobileFriendUI mobileFriendUI) {
        AppMethodBeat.m2504i(13744);
        if (C38033l.apS() != C38034a.SUCC && C38033l.apS() != C38034a.SUCC_UNLOAD) {
            mobileFriendUI.gtV.setVisibility(0);
            mobileFriendUI.gtV.setOnClickListener(new C380297());
            mobileFriendUI.gtT.setVisibility(8);
            mobileFriendUI.emptyTipTv.setVisibility(8);
            AppMethodBeat.m2505o(13744);
        } else if (mobileFriendUI.gtU.getCount() <= 0) {
            mobileFriendUI.emptyTipTv.setVisibility(0);
            mobileFriendUI.gtT.setVisibility(8);
            mobileFriendUI.gtV.setVisibility(8);
            AppMethodBeat.m2505o(13744);
        } else {
            mobileFriendUI.emptyTipTv.setVisibility(8);
            mobileFriendUI.gtT.setVisibility(0);
            mobileFriendUI.gtV.setVisibility(8);
            AppMethodBeat.m2505o(13744);
        }
    }
}
