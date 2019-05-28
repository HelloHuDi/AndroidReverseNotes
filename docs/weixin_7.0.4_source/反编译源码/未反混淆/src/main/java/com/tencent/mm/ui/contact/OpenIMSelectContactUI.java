package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI extends MMBaseSelectContactUI {
    private String csB;
    private List<String> elZ;
    private HashSet<String> gnG;
    private String title;
    private int zkf;
    private HashSet<String> zol;
    private HashSet<String> zom;
    private int zon;
    private boolean zoo = true;
    private a zop = new a();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OpenIMSelectContactUI() {
        AppMethodBeat.i(33825);
        AppMethodBeat.o(33825);
    }

    static /* synthetic */ boolean a(OpenIMSelectContactUI openIMSelectContactUI, List list, List list2) {
        AppMethodBeat.i(33839);
        boolean q = openIMSelectContactUI.q(list, list2);
        AppMethodBeat.o(33839);
        return q;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33826);
        super.onCreate(bundle);
        if (s.hr(this.zon, 64)) {
            a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33824);
                    ArrayList a = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, s.hr(OpenIMSelectContactUI.this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    a.remove(r.Yz());
                    ArrayList arrayList = new ArrayList(OpenIMSelectContactUI.this.zom);
                    arrayList.removeAll(a);
                    boolean a2 = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, a, arrayList);
                    AppMethodBeat.o(33824);
                    return a2;
                }
            }, b.GREEN);
        }
        Kt();
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            ajq((String) it.next());
        }
        AppMethodBeat.o(33826);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kh() {
        AppMethodBeat.i(33827);
        super.Kh();
        this.csB = getIntent().getStringExtra("openim_appid");
        this.title = getIntent().getStringExtra("titile");
        this.zkf = getIntent().getIntExtra("list_type", -1);
        this.zon = getIntent().getIntExtra("list_attr", s.znD);
        this.elZ = new ArrayList();
        this.gnG = new HashSet();
        this.zom = new HashSet();
        this.zol = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.zol.addAll(bo.P(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(bo.P(stringExtra.split(",")));
            this.zom.addAll(this.gnG);
        }
        HashSet hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!bo.isNullOrNil(stringExtra2)) {
            hashSet.addAll(bo.P(stringExtra2.split(",")));
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(s.dIf());
        hashSet2.addAll(s.dIg());
        this.elZ.addAll(hashSet2);
        AppMethodBeat.o(33827);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.i(33828);
        if (bo.isNullOrNil(this.title)) {
            this.title = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(this.csB, "openim_acct_type_title", a.TYPE_WORDING);
        }
        String str = this.title;
        AppMethodBeat.o(33828);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final o aoz() {
        AppMethodBeat.i(33829);
        w wVar = new w(this.csB, this, this.elZ, s.hr(this.zon, 64));
        AppMethodBeat.o(33829);
        return wVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aoA() {
        AppMethodBeat.i(33830);
        q qVar = new q(this, this.elZ, s.hr(this.zon, 64), this.scene);
        AppMethodBeat.o(33830);
        return qVar;
    }

    public final void mO(int i) {
        int i2 = 0;
        AppMethodBeat.i(33831);
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            ab.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i));
            AppMethodBeat.o(33831);
            return;
        }
        com.tencent.mm.ui.contact.a.a Pn = dHV().getItem(headerViewsCount);
        if (Pn == null) {
            AppMethodBeat.o(33831);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(33831);
        } else if (Pn.ehM.field_deleteFlag == 1) {
            AppMethodBeat.o(33831);
        } else {
            String str = Pn.ehM.field_username;
            ab.i("OpenIMSelectContactUI", "ClickUser=%s", str);
            if (s.hr(this.zon, 64)) {
                if (!s.hr(this.zon, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.gnG.size() < getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER)) {
                    if (!this.zol.contains(str)) {
                        dIb();
                        ajq(str);
                        if (this.gnG.contains(str)) {
                            this.gnG.remove(str);
                        } else {
                            this.gnG.add(str);
                        }
                    }
                } else if (!this.zol.contains(str)) {
                    dIb();
                    if (this.gnG.contains(str)) {
                        ajq(str);
                        this.gnG.remove(str);
                    } else {
                        str = getIntent().getStringExtra("too_many_member_tip_string");
                        if (bo.isNullOrNil(str)) {
                            str = getString(R.string.e1m, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        h.a(this.mController.ylL, str, getString(R.string.t6), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
                Kt();
                if (this.zoo && (this.zkf == 1 || this.zkf == 0)) {
                    headerViewsCount = this.zol != null ? this.zol.size() : 0;
                    if (this.gnG != null) {
                        i2 = this.gnG.size();
                    }
                    this.zop.e(this, headerViewsCount + i2, bo.ank(com.tencent.mm.m.g.Nu().getValue("ChatRoomInviteStartCount")));
                }
                dHW().notifyDataSetChanged();
                AppMethodBeat.o(33831);
                return;
            }
            q(bo.P(new String[]{str}), new ArrayList(0));
            AppMethodBeat.o(33831);
        }
    }

    private void Kt() {
        AppMethodBeat.i(33832);
        if (!s.hr(this.zon, 64) || this.gnG.size() <= 0) {
            updateOptionMenuText(1, getString(R.string.ot));
            enableOptionMenu(1, false);
            AppMethodBeat.o(33832);
            return;
        }
        updateOptionMenuText(1, getString(R.string.ot) + "(" + this.gnG.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!s.hr(this.zon, 262144) || this.gnG.size() >= intExtra) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(33832);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(33832);
    }

    private void ajq(String str) {
        AppMethodBeat.i(33833);
        if (this.opo == null) {
            AppMethodBeat.o(33833);
            return;
        }
        this.opo.ajq(str);
        AppMethodBeat.o(33833);
    }

    private boolean q(List<String> list, List<String> list2) {
        AppMethodBeat.i(33834);
        ab.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", list, list2);
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", bo.c((List) list, ","));
        intent.putExtra("Cancel_Select_Contact", bo.c((List) list2, ","));
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(33834);
        return true;
    }

    public final void vI(String str) {
        AppMethodBeat.i(33835);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        Kt();
        AppMethodBeat.o(33835);
    }

    public final boolean dId() {
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(33836);
        boolean contains;
        if (aVar.zmW && aVar.ehM != null) {
            contains = this.gnG.contains(aVar.ehM.field_username);
            AppMethodBeat.o(33836);
            return contains;
        } else if (aVar.zmX && aVar.ehM != null) {
            contains = this.gnG.contains(aVar.ehM.field_username);
            AppMethodBeat.o(33836);
            return contains;
        } else if (aVar instanceof k) {
            contains = this.gnG.isEmpty();
            AppMethodBeat.o(33836);
            return contains;
        } else {
            AppMethodBeat.o(33836);
            return false;
        }
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(33837);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(33837);
            return false;
        }
        boolean contains = this.zol.contains(aVar.ehM.field_username);
        AppMethodBeat.o(33837);
        return contains;
    }

    static /* synthetic */ ArrayList a(OpenIMSelectContactUI openIMSelectContactUI, boolean z) {
        AppMethodBeat.i(33838);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = openIMSelectContactUI.gnG.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !t.mW(str)) {
                hashSet.add(str);
            } else {
                List<String> mz = n.mz(str);
                if (mz != null) {
                    for (String str2 : mz) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(33838);
        return arrayList;
    }
}
