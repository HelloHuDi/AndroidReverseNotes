package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C46622bu;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5138d;

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI */
public class ShakeSayHiListUI extends MMActivity {
    private ListView gtT;
    private C5279d jKa = new C349052();
    private long jvz;
    private int limit = 0;
    private int oQK = 0;
    private int oQL = 0;
    private C46622bu qui = null;
    private int qwr = 0;
    private C43526b qws;

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$7 */
    class C132927 implements OnItemClickListener {
        C132927() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(24880);
            C41338bt c41338bt = (C41338bt) ShakeSayHiListUI.this.qws.getItem(i);
            if (c41338bt == null || c41338bt.field_content == null) {
                AppMethodBeat.m2505o(24880);
                return;
            }
            C5138d apF = C5138d.apF(c41338bt.field_content);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", apF.svN);
            intent.putExtra("Contact_Encryptusername", apF.xZx);
            intent.putExtra("Contact_Alias", apF.dFl);
            intent.putExtra("Contact_Nick", apF.nickname);
            intent.putExtra("Contact_QuanPin", apF.gwG);
            intent.putExtra("Contact_PyInitial", apF.gwF);
            intent.putExtra("Contact_Sex", apF.dtS);
            intent.putExtra("Contact_Signature", apF.signature);
            intent.putExtra("Contact_Scene", apF.scene);
            intent.putExtra("Contact_FMessageCard", true);
            intent.putExtra("Contact_City", apF.getCity());
            intent.putExtra("Contact_Province", apF.getProvince());
            intent.putExtra("Contact_Content", C5046bo.isNullOrNil(c41338bt.field_sayhicontent) ? ShakeSayHiListUI.this.getString(C25738R.string.al3) : c41338bt.field_sayhicontent);
            intent.putExtra("Contact_verify_Scene", apF.scene);
            intent.putExtra("Contact_Uin", apF.pnz);
            intent.putExtra("Contact_QQNick", apF.gwH);
            intent.putExtra("Contact_Mobile_MD5", apF.xZi);
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_from_msgType", 37);
            intent.putExtra("Verify_ticket", apF.mGZ);
            intent.putExtra("Contact_ShowFMessageList", true);
            intent.putExtra("Contact_Source_FMessage", apF.scene);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(apF.svN);
            if (!(aoO == null || ((int) aoO.ewQ) < 0 || C7486a.m12942jh(aoO.field_type))) {
                int i2 = apF.cAd;
                if (i2 == 0 || i2 == 2 || i2 == 5) {
                    intent.putExtra("User_Verify", true);
                }
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Sns_from_Scene", 18);
            }
            C46193a.gkE.mo38912c(intent, ShakeSayHiListUI.this);
            AppMethodBeat.m2505o(24880);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$9 */
    class C132939 implements OnMenuItemClickListener {
        C132939() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24882);
            ShakeSayHiListUI.this.aqX();
            ShakeSayHiListUI.this.finish();
            AppMethodBeat.m2505o(24882);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$10 */
    class C2184110 implements OnClickListener {
        C2184110() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24883);
            C4978c.m7375a(ShakeSayHiListUI.this.gtT);
            AppMethodBeat.m2505o(24883);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$6 */
    class C290076 implements C23599f {
        C290076() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(24879);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.SayHiListUI", "onItemDel object null");
                AppMethodBeat.m2505o(24879);
                return;
            }
            C41789d.akR().mo74758QT(obj.toString());
            ShakeSayHiListUI.this.qws.mo5248a(null, null);
            AppMethodBeat.m2505o(24879);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$2 */
    class C349052 implements C5279d {
        C349052() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(24874);
            C41789d.akR().mo74758QT(String.valueOf(ShakeSayHiListUI.this.jvz));
            ShakeSayHiListUI.this.qws.mo5248a(null, null);
            AppMethodBeat.m2505o(24874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$3 */
    class C349063 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$3$1 */
        class C349071 implements DialogInterface.OnClickListener {
            C349071() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(24875);
                ShakeSayHiListUI.this.qui.axQ();
                ShakeSayHiListUI.this.qws.mo6869KC();
                TextView textView = (TextView) ShakeSayHiListUI.this.findViewById(2131821807);
                textView.setText(C25738R.string.dx8);
                textView.setVisibility(0);
                ShakeSayHiListUI.this.enableOptionMenu(false);
                AppMethodBeat.m2505o(24875);
            }
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$3$2 */
        class C349082 implements DialogInterface.OnClickListener {
            C349082() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C349063() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24876);
            C30379h.m48453a(ShakeSayHiListUI.this.mController.ylL, true, ShakeSayHiListUI.this.getString(C25738R.string.dx3), "", ShakeSayHiListUI.this.getString(C25738R.string.dx2), ShakeSayHiListUI.this.getString(C25738R.string.f9076or), new C349071(), new C349082());
            AppMethodBeat.m2505o(24876);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$5 */
    class C349095 implements C23600g {
        C349095() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(24878);
            ShakeSayHiListUI.this.gtT.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(24878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI$4 */
    class C397084 implements C15521c {
        C397084() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(24877);
            int positionForView = ShakeSayHiListUI.this.gtT.getPositionForView(view);
            AppMethodBeat.m2505o(24877);
            return positionForView;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShakeSayHiListUI() {
        AppMethodBeat.m2504i(24884);
        AppMethodBeat.m2505o(24884);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24885);
        super.onCreate(bundle);
        this.qwr = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.qwr == 1) {
            this.qui = C41789d.akR();
            setMMTitle((int) C25738R.string.dx7);
        } else {
            setMMTitle((int) C25738R.string.dx5);
        }
        this.oQL = this.qui.baS();
        this.limit = this.oQL == 0 ? 8 : this.oQL;
        this.oQK = this.qui.getCount();
        C46622bu c46622bu = this.qui;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (c46622bu.bSd.update(c46622bu.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            c46622bu.doNotify();
        }
        initView();
        AppMethodBeat.m2505o(24885);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24886);
        super.onResume();
        if (this.oQK != this.qui.getCount()) {
            this.oQK = this.qui.getCount();
            if (this.oQK == 0) {
                TextView textView = (TextView) findViewById(2131821807);
                textView.setText(C25738R.string.dx8);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.qws.mo6869KC();
        }
        this.qws.notifyDataSetChanged();
        AppMethodBeat.m2505o(24886);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24887);
        this.qws.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(24887);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24888);
        super.onPause();
        if (this.qws.jJR != null) {
            this.qws.jJR.bIp();
        }
        AppMethodBeat.m2505o(24888);
    }

    public final int getLayoutId() {
        return 2130969931;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(24889);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(24889);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.m2504i(24890);
        final View inflate = getLayoutInflater().inflate(2130970536, null);
        this.gtT = (ListView) findViewById(2131825251);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(24873);
                ShakeSayHiListUI.this.limit = ShakeSayHiListUI.this.limit + 8;
                C4990ab.m7410d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.this.limit);
                ShakeSayHiListUI.this.qws.mo69079CA(ShakeSayHiListUI.this.limit);
                if (ShakeSayHiListUI.this.oQK <= ShakeSayHiListUI.this.limit) {
                    ShakeSayHiListUI.this.gtT.removeFooterView(inflate);
                    C4990ab.m7410d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.this.limit);
                }
                AppMethodBeat.m2505o(24873);
            }
        });
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C349063());
        if (this.oQK == 0) {
            TextView textView = (TextView) findViewById(2131821807);
            textView.setText(C25738R.string.dx8);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oQK > 0 && this.limit < this.oQK) {
            this.gtT.addFooterView(inflate);
        }
        this.qws = new C43526b(this, this.qui, this.limit);
        this.qws.setGetViewPositionCallback(new C397084());
        this.qws.setPerformItemClickListener(new C349095());
        this.qws.mo69080a(new C290076());
        this.gtT.setAdapter(this.qws);
        this.gtT.setOnItemClickListener(new C132927());
        final C46696j c46696j = new C46696j(this);
        this.gtT.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(24881);
                if (i < ShakeSayHiListUI.this.gtT.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(24881);
                } else {
                    c46696j.mo75004a(view, i, j, ShakeSayHiListUI.this, ShakeSayHiListUI.this.jKa);
                    AppMethodBeat.m2505o(24881);
                }
                return true;
            }
        });
        setBackBtn(new C132939());
        C2184110 c2184110 = new C2184110();
        AppMethodBeat.m2505o(24890);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(24891);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jvz = ((C41338bt) this.qws.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, C25738R.string.f9088p4);
        AppMethodBeat.m2505o(24891);
    }
}
