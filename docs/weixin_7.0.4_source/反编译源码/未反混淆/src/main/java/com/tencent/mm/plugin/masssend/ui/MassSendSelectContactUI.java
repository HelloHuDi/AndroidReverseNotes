package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private HashSet<String> gnG;
    private Button opm;
    private boolean opn;
    private MultiSelectContactView opo;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void Kh() {
        AppMethodBeat.i(22877);
        super.Kh();
        this.elZ = new ArrayList();
        this.elZ.addAll(s.dIf());
        this.elZ.addAll(s.dIg());
        this.elZ.add(r.Yz());
        this.gnG = new HashSet();
        AppMethodBeat.o(22877);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22878);
        super.onCreate(bundle);
        ab.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.opo = this.opo;
        if (this.opo == null) {
            finish();
            AppMethodBeat.o(22878);
            return;
        }
        this.opo.setBackgroundDrawable(null);
        a(1, getString(R.string.cz2), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22874);
                ab.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
                List P = bo.P((String[]) MassSendSelectContactUI.this.gnG.toArray(new String[0]));
                if (P == null) {
                    ab.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
                    AppMethodBeat.o(22874);
                    return false;
                }
                P.remove(r.Yz());
                String c = bo.c(P, ";");
                Intent intent = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
                intent.putExtra("mass_send_contact_list", c);
                MassSendSelectContactUI.this.startActivity(intent);
                AppMethodBeat.o(22874);
                return true;
            }
        }, b.GREEN);
        this.opm = (Button) findViewById(R.id.d7u);
        this.opm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(22875);
                ab.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
                n nVar = (n) ((HeaderViewListAdapter) MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
                if (MassSendSelectContactUI.this.opn) {
                    MassSendSelectContactUI.this.opm.setText(R.string.cz3);
                    Iterator it = MassSendSelectContactUI.this.gnG.iterator();
                    while (it.hasNext()) {
                        MassSendSelectContactUI.this.opo.ajq((String) it.next());
                    }
                    MassSendSelectContactUI.this.gnG.clear();
                } else {
                    MassSendSelectContactUI.this.opm.setText(R.string.cyr);
                    int count = nVar.getCount();
                    for (int i = 0; i < count; i++) {
                        a Pn = nVar.getItem(i);
                        if (!(Pn == null || Pn.ehM == null || MassSendSelectContactUI.this.gnG.contains(Pn.ehM.field_username))) {
                            MassSendSelectContactUI.this.gnG.add(Pn.ehM.field_username);
                            MassSendSelectContactUI.this.opo.ajq(Pn.ehM.field_username);
                        }
                    }
                }
                MassSendSelectContactUI massSendSelectContactUI = MassSendSelectContactUI.this;
                if (MassSendSelectContactUI.this.opn) {
                    z = false;
                } else {
                    z = true;
                }
                massSendSelectContactUI.opn = z;
                MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.this.gnG.size());
                nVar.notifyDataSetChanged();
                AppMethodBeat.o(22875);
            }
        });
        this.opo.setOnContactDeselectListener(new MultiSelectContactView.a() {
            public final void vI(String str) {
                AppMethodBeat.i(22876);
                if (str != null) {
                    MassSendSelectContactUI.this.gnG.remove(str);
                    MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.this.gnG.size());
                }
                AppMethodBeat.o(22876);
            }
        });
        yu(this.gnG.size());
        AppMethodBeat.o(22878);
    }

    private void yu(int i) {
        AppMethodBeat.i(22879);
        if (i > 0) {
            updateOptionMenuText(1, getString(R.string.cz2) + "(" + this.gnG.size() + ")");
            enableOptionMenu(1, true);
            AppMethodBeat.o(22879);
            return;
        }
        updateOptionMenuText(1, getString(R.string.cz2));
        enableOptionMenu(1, false);
        AppMethodBeat.o(22879);
    }

    public final void QA(String str) {
        AppMethodBeat.i(22880);
        h.pYm.e(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", bo.c(new ArrayList(this.gnG), ","));
        intent.putExtra("list_attr", s.C(16384, 64));
        d.b((Context) this, ".ui.contact.SelectLabelContactUI", intent, 0);
        AppMethodBeat.o(22880);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(22881);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.o(22881);
            return;
        }
        switch (i) {
            case 0:
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!bo.isNullOrNil(stringExtra)) {
                    ab.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        Object obj = split[i3];
                        if (this.gnG.add(obj)) {
                            this.opo.ajq(obj);
                        }
                        i3++;
                    }
                    yu(this.gnG.size());
                    dHV().notifyDataSetChanged();
                    if (this.elS != null) {
                        this.elS.clearFocus();
                        this.elS.dJS();
                        break;
                    }
                }
                ab.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                AppMethodBeat.o(22881);
                return;
                break;
        }
        AppMethodBeat.o(22881);
    }

    public final int getLayoutId() {
        return R.layout.acr;
    }

    public final void mO(int i) {
        AppMethodBeat.i(22882);
        n dHV = dHV();
        a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.o(22882);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(22882);
        } else {
            ab.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            dIb();
            if (this.gnG.contains(str)) {
                this.gnG.remove(str);
                this.opo.ajq(str);
            } else {
                this.gnG.add(str);
                this.opo.ajq(str);
            }
            yu(this.gnG.size());
            dHV.notifyDataSetChanged();
            dIb();
            dIc();
            AppMethodBeat.o(22882);
        }
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return true;
    }

    public final String aoy() {
        AppMethodBeat.i(22883);
        String string = getString(R.string.cz4);
        AppMethodBeat.o(22883);
        return string;
    }

    public final o aoz() {
        AppMethodBeat.i(22884);
        c.a aVar = new c.a();
        aVar.zkR = true;
        aVar.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        c cVar = new c(this, this.elZ, true, aVar);
        AppMethodBeat.o(22884);
        return cVar;
    }

    public final m aoA() {
        AppMethodBeat.i(22885);
        q qVar = new q(this, this.elZ, true, this.scene);
        AppMethodBeat.o(22885);
        return qVar;
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final boolean bOd() {
        return true;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(22886);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(22886);
            return false;
        }
        boolean contains = this.gnG.contains(aVar.ehM.field_username);
        AppMethodBeat.o(22886);
        return contains;
    }
}
