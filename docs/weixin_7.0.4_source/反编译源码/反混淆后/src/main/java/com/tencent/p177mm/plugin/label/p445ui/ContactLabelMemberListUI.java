package com.tencent.p177mm.plugin.label.p445ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.label.C43234a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI */
public class ContactLabelMemberListUI extends MMActivity {
    private TextView juy;
    private C7306ak mHandler = new C123551();
    private C4937b nIg = new C123562();
    private ListView nIv;
    private C43240a nIw;
    private String nIx;
    private String nIy;

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI$3 */
    class C123543 implements OnMenuItemClickListener {
        C123543() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22641);
            ContactLabelMemberListUI.this.finish();
            AppMethodBeat.m2505o(22641);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI$1 */
    class C123551 extends C7306ak {
        C123551() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(22639);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", Integer.valueOf(message.what));
            switch (message.what) {
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    ContactLabelMemberListUI.m20279a(ContactLabelMemberListUI.this);
                    AppMethodBeat.m2505o(22639);
                    return;
                default:
                    C4990ab.m7420w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                    AppMethodBeat.m2505o(22639);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI$2 */
    class C123562 implements C4937b {
        C123562() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(22640);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
            if (ContactLabelMemberListUI.this.mHandler != null) {
                ContactLabelMemberListUI.this.mHandler.removeMessages(ReaderCallback.HIDDEN_BAR);
                ContactLabelMemberListUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.HIDDEN_BAR, 300);
            }
            AppMethodBeat.m2505o(22640);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI$4 */
    class C123574 implements OnMenuItemClickListener {
        C123574() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22642);
            Intent intent = new Intent();
            intent.setClass(ContactLabelMemberListUI.this, ContactLabelEditUI.class);
            intent.putExtra("label_id", ContactLabelMemberListUI.this.nIx);
            intent.putExtra("label_name", ContactLabelMemberListUI.this.nIy);
            ContactLabelMemberListUI.this.startActivityForResult(intent, 10001);
            AppMethodBeat.m2505o(22642);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI$5 */
    class C123585 implements OnItemClickListener {
        C123585() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22643);
            ContactLabelMemberListUI.m20280a(ContactLabelMemberListUI.this, i);
            AppMethodBeat.m2505o(22643);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactLabelMemberListUI() {
        AppMethodBeat.m2504i(22644);
        AppMethodBeat.m2505o(22644);
    }

    /* renamed from: a */
    static /* synthetic */ void m20279a(ContactLabelMemberListUI contactLabelMemberListUI) {
        AppMethodBeat.m2504i(22651);
        contactLabelMemberListUI.bJk();
        AppMethodBeat.m2505o(22651);
    }

    public final int getLayoutId() {
        return 2130969229;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22645);
        super.onCreate(bundle);
        this.nIx = getIntent().getStringExtra("label_id");
        this.nIy = getIntent().getStringExtra("label_name");
        setBackBtn(new C123543());
        addTextOptionMenu(0, getString(C25738R.string.cl0), new C123574());
        setMMTitle(this.nIy);
        this.nIv = (ListView) findViewById(2131823069);
        this.juy = (TextView) findViewById(2131821749);
        if (C5046bo.isNullOrNil(this.nIx)) {
            C4990ab.m7412e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.nIw = new C43240a(this.mController.ylL);
        this.nIv.setAdapter(this.nIw);
        this.nIv.setOnItemClickListener(new C123585());
        this.nIv.setEmptyView(this.juy);
        AppMethodBeat.m2505o(22645);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22646);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.nIg);
        super.onResume();
        bJk();
        AppMethodBeat.m2505o(22646);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22647);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.nIg);
        super.onPause();
        AppMethodBeat.m2505o(22647);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22648);
        if (this.nIw != null) {
            this.nIw.bIf();
            this.nIw.dww();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(22648);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22649);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 10001:
                if (i2 == -1) {
                    finish();
                    AppMethodBeat.m2505o(22649);
                    return;
                }
                bJk();
                AppMethodBeat.m2505o(22649);
                return;
            default:
                C4990ab.m7413e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", Integer.valueOf(i));
                AppMethodBeat.m2505o(22649);
                return;
        }
    }

    private void bJk() {
        AppMethodBeat.m2504i(22650);
        if (this.nIw != null) {
            this.nIw.nIr = C21156a.bJa().mo41635PH(this.nIx);
            this.nIw.mo5248a(null, null);
        }
        this.nIy = C21156a.bJa().mo41631PD(this.nIx);
        if (!C5046bo.isNullOrNil(this.nIy)) {
            setMMTitle(this.nIy);
        }
        AppMethodBeat.m2505o(22650);
    }

    /* renamed from: a */
    static /* synthetic */ void m20280a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        AppMethodBeat.m2504i(22652);
        if (contactLabelMemberListUI.nIw != null && i <= contactLabelMemberListUI.nIw.getCount()) {
            C7616ad c7616ad = contactLabelMemberListUI.nIw.mo68754xB(i).ehM;
            if (c7616ad == null || C5046bo.isNullOrNil(c7616ad.field_username) || c7616ad.field_deleteFlag == 1) {
                AppMethodBeat.m2505o(22652);
                return;
            } else if (C1855t.m3956ny(c7616ad.field_username)) {
                C4990ab.m7413e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", c7616ad.field_username);
                AppMethodBeat.m2505o(22652);
                return;
            } else {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", c7616ad.field_username);
                intent.putExtra("Contact_Alias", c7616ad.mo14673Hq());
                intent.putExtra("Contact_Nick", c7616ad.mo16706Oi());
                intent.putExtra("Contact_QuanPin", c7616ad.mo14677Hu());
                intent.putExtra("Contact_PyInitial", c7616ad.mo14676Ht());
                intent.putExtra("Contact_Sex", c7616ad.dtS);
                intent.putExtra("Contact_Province", c7616ad.getProvince());
                intent.putExtra("Contact_City", c7616ad.getCity());
                intent.putExtra("Contact_Signature", c7616ad.signature);
                C43234a.gkE.mo38912c(intent, contactLabelMemberListUI);
            }
        }
        AppMethodBeat.m2505o(22652);
    }
}
