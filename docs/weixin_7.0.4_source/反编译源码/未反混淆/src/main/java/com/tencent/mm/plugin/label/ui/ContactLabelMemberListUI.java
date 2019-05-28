package com.tencent.mm.plugin.label.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class ContactLabelMemberListUI extends MMActivity {
    private TextView juy;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22639);
            ab.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", Integer.valueOf(message.what));
            switch (message.what) {
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    ContactLabelMemberListUI.a(ContactLabelMemberListUI.this);
                    AppMethodBeat.o(22639);
                    return;
                default:
                    ab.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                    AppMethodBeat.o(22639);
                    return;
            }
        }
    };
    private b nIg = new b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(22640);
            ab.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
            if (ContactLabelMemberListUI.this.mHandler != null) {
                ContactLabelMemberListUI.this.mHandler.removeMessages(ReaderCallback.HIDDEN_BAR);
                ContactLabelMemberListUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.HIDDEN_BAR, 300);
            }
            AppMethodBeat.o(22640);
        }
    };
    private ListView nIv;
    private a nIw;
    private String nIx;
    private String nIy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelMemberListUI() {
        AppMethodBeat.i(22644);
        AppMethodBeat.o(22644);
    }

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI) {
        AppMethodBeat.i(22651);
        contactLabelMemberListUI.bJk();
        AppMethodBeat.o(22651);
    }

    public final int getLayoutId() {
        return R.layout.qw;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22645);
        super.onCreate(bundle);
        this.nIx = getIntent().getStringExtra("label_id");
        this.nIy = getIntent().getStringExtra("label_name");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22641);
                ContactLabelMemberListUI.this.finish();
                AppMethodBeat.o(22641);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.cl0), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22642);
                Intent intent = new Intent();
                intent.setClass(ContactLabelMemberListUI.this, ContactLabelEditUI.class);
                intent.putExtra("label_id", ContactLabelMemberListUI.this.nIx);
                intent.putExtra("label_name", ContactLabelMemberListUI.this.nIy);
                ContactLabelMemberListUI.this.startActivityForResult(intent, 10001);
                AppMethodBeat.o(22642);
                return false;
            }
        });
        setMMTitle(this.nIy);
        this.nIv = (ListView) findViewById(R.id.b49);
        this.juy = (TextView) findViewById(R.id.a5j);
        if (bo.isNullOrNil(this.nIx)) {
            ab.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.nIw = new a(this.mController.ylL);
        this.nIv.setAdapter(this.nIw);
        this.nIv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22643);
                ContactLabelMemberListUI.a(ContactLabelMemberListUI.this, i);
                AppMethodBeat.o(22643);
            }
        });
        this.nIv.setEmptyView(this.juy);
        AppMethodBeat.o(22645);
    }

    public void onResume() {
        AppMethodBeat.i(22646);
        aw.ZK();
        c.XM().a(this.nIg);
        super.onResume();
        bJk();
        AppMethodBeat.o(22646);
    }

    public void onPause() {
        AppMethodBeat.i(22647);
        aw.ZK();
        c.XM().b(this.nIg);
        super.onPause();
        AppMethodBeat.o(22647);
    }

    public void onDestroy() {
        AppMethodBeat.i(22648);
        if (this.nIw != null) {
            this.nIw.bIf();
            this.nIw.dww();
        }
        super.onDestroy();
        AppMethodBeat.o(22648);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22649);
        ab.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 10001:
                if (i2 == -1) {
                    finish();
                    AppMethodBeat.o(22649);
                    return;
                }
                bJk();
                AppMethodBeat.o(22649);
                return;
            default:
                ab.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", Integer.valueOf(i));
                AppMethodBeat.o(22649);
                return;
        }
    }

    private void bJk() {
        AppMethodBeat.i(22650);
        if (this.nIw != null) {
            this.nIw.nIr = a.bJa().PH(this.nIx);
            this.nIw.a(null, null);
        }
        this.nIy = a.bJa().PD(this.nIx);
        if (!bo.isNullOrNil(this.nIy)) {
            setMMTitle(this.nIy);
        }
        AppMethodBeat.o(22650);
    }

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        AppMethodBeat.i(22652);
        if (contactLabelMemberListUI.nIw != null && i <= contactLabelMemberListUI.nIw.getCount()) {
            ad adVar = contactLabelMemberListUI.nIw.xB(i).ehM;
            if (adVar == null || bo.isNullOrNil(adVar.field_username) || adVar.field_deleteFlag == 1) {
                AppMethodBeat.o(22652);
                return;
            } else if (t.ny(adVar.field_username)) {
                ab.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", adVar.field_username);
                AppMethodBeat.o(22652);
                return;
            } else {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", adVar.field_username);
                intent.putExtra("Contact_Alias", adVar.Hq());
                intent.putExtra("Contact_Nick", adVar.Oi());
                intent.putExtra("Contact_QuanPin", adVar.Hu());
                intent.putExtra("Contact_PyInitial", adVar.Ht());
                intent.putExtra("Contact_Sex", adVar.dtS);
                intent.putExtra("Contact_Province", adVar.getProvince());
                intent.putExtra("Contact_City", adVar.getCity());
                intent.putExtra("Contact_Signature", adVar.signature);
                com.tencent.mm.plugin.label.a.gkE.c(intent, contactLabelMemberListUI);
            }
        }
        AppMethodBeat.o(22652);
    }
}
