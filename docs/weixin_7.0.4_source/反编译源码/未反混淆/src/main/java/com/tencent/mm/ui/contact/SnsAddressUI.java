package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private HashSet<String> gnG;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(SnsAddressUI snsAddressUI) {
        AppMethodBeat.i(33937);
        snsAddressUI.Kt();
        AppMethodBeat.o(33937);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kh() {
        AppMethodBeat.i(33926);
        super.Kh();
        this.elZ = new ArrayList();
        ArrayList P = bo.P(bo.bc(getIntent().getStringExtra("Block_list"), "").split(","));
        HashSet dIf = s.dIf();
        dIf.addAll(P);
        this.elZ.addAll(dIf);
        this.elZ.addAll(s.dIg());
        this.gnG = new HashSet();
        String bc = bo.bc(getIntent().getStringExtra("Select_Contact"), "");
        if (!bo.isNullOrNil(bc)) {
            this.gnG.addAll(bo.P(bc.split(",")));
        }
        AppMethodBeat.o(33926);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33927);
        super.onCreate(bundle);
        ab.i("MicroMsg.SnsAddressUI", "Create!");
        a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33923);
                Intent intent = new Intent();
                List P = bo.P((String[]) SnsAddressUI.this.gnG.toArray(new String[0]));
                if (P == null || P.size() == 0) {
                    intent.putExtra("Select_Contact", "");
                } else {
                    intent.putExtra("Select_Contact", bo.c(P, ","));
                }
                SnsAddressUI.this.setResult(-1, intent);
                SnsAddressUI.this.finish();
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33922);
                        if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                            SnsAddressUI.this.moveTaskToBack(true);
                        }
                        AppMethodBeat.o(33922);
                    }
                }, 100);
                SnsAddressUI.this.aqX();
                AppMethodBeat.o(33923);
                return true;
            }
        }, b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33924);
                SnsAddressUI.this.finish();
                if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    SnsAddressUI.this.moveTaskToBack(true);
                }
                AppMethodBeat.o(33924);
                return true;
            }
        });
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            this.opo.ajq((String) it.next());
        }
        this.opo.setOnContactDeselectListener(new a() {
            public final void vI(String str) {
                AppMethodBeat.i(33925);
                if (str != null) {
                    SnsAddressUI.this.gnG.remove(str);
                    SnsAddressUI.b(SnsAddressUI.this);
                }
                AppMethodBeat.o(33925);
            }
        });
        Kt();
        AppMethodBeat.o(33927);
    }

    public final void mO(int i) {
        AppMethodBeat.i(33928);
        n dHV = dHV();
        com.tencent.mm.ui.contact.a.a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.o(33928);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(33928);
        } else {
            ab.i("MicroMsg.SnsAddressUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            dIb();
            if (this.gnG.contains(str)) {
                this.gnG.remove(str);
                this.opo.ajq(str);
            } else if (this.gnG.size() < com.tencent.mm.storage.ab.xID) {
                this.gnG.add(str);
                this.opo.ajq(str);
            } else {
                Toast.makeText(this, R.string.emu, 0).show();
                ab.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", Integer.valueOf(com.tencent.mm.storage.ab.xID));
            }
            Kt();
            dHV.notifyDataSetChanged();
            AppMethodBeat.o(33928);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.i(33929);
        String bc = bo.bc(getIntent().getStringExtra("Add_address_titile"), "");
        AppMethodBeat.o(33929);
        return bc;
    }

    /* Access modifiers changed, original: protected|final */
    public final o aoz() {
        AppMethodBeat.i(33930);
        c.a aVar = new c.a();
        aVar.zkR = true;
        aVar.zkY = true;
        aVar.zla = getString(R.string.ed);
        aVar.zkZ = bo.bc(getIntent().getStringExtra("Add_get_from_sns"), "");
        aVar.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        c cVar = new c(this, this.elZ, true, aVar);
        AppMethodBeat.o(33930);
        return cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aoA() {
        AppMethodBeat.i(33931);
        q qVar = new q(this, this.elZ, true, this.scene);
        AppMethodBeat.o(33931);
        return qVar;
    }

    private void Kt() {
        String format;
        boolean z;
        AppMethodBeat.i(33932);
        if (this.gnG.size() == 0) {
            format = String.format("%s", new Object[]{getString(R.string.s6)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(R.string.s6), Integer.valueOf(this.gnG.size()), Integer.valueOf(com.tencent.mm.storage.ab.xID)});
        }
        updateOptionMenuText(1, format);
        if (this.gnG.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        enableOptionMenu(1, z);
        AppMethodBeat.o(33932);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(33933);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(33933);
            return;
        }
        switch (i) {
            case 3:
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!bo.isNullOrNil(stringExtra)) {
                    ab.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        Object obj = split[i3];
                        if (this.gnG.add(obj)) {
                            this.opo.ajq(obj);
                        }
                        i3++;
                    }
                    Kt();
                    dHV().notifyDataSetChanged();
                    break;
                }
                ab.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                AppMethodBeat.o(33933);
                return;
        }
        AppMethodBeat.o(33933);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bOd() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void QA(String str) {
        AppMethodBeat.i(33934);
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.gnG);
        intent.putExtra("always_select_contact", bo.c(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", s.C(16384, 64));
        startActivityForResult(intent, 3);
        AppMethodBeat.o(33934);
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void vI(String str) {
        AppMethodBeat.i(33936);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        Kt();
        AppMethodBeat.o(33936);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(33935);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(33935);
            return false;
        }
        boolean contains = this.gnG.contains(aVar.ehM.field_username);
        AppMethodBeat.o(33935);
        return contains;
    }
}
