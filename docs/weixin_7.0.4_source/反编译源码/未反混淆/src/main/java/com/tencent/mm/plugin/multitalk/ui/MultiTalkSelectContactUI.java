package com.tencent.mm.plugin.multitalk.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.q;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> gnF;
    private HashSet<String> gnG;
    private c oGA = new c<kc>() {
        {
            AppMethodBeat.i(54159);
            this.xxI = kc.class.getName().hashCode();
            AppMethodBeat.o(54159);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(54160);
            kc kcVar = (kc) bVar;
            if ((kcVar instanceof kc) && kcVar.cFw.action == 0) {
                MultiTalkSelectContactUI.this.finish();
            }
            AppMethodBeat.o(54160);
            return false;
        }
    };
    private boolean oHU;
    private d oHV;
    private boolean oHW = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MultiTalkSelectContactUI() {
        AppMethodBeat.i(54161);
        AppMethodBeat.o(54161);
    }

    public final void Kh() {
        AppMethodBeat.i(54162);
        super.Kh();
        this.oHU = getIntent().getBooleanExtra("key_need_gallery", false);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!t.kH(this.chatroomName)) {
            finish();
        }
        this.gnG = new HashSet();
        this.gnF = new HashSet();
        AppMethodBeat.o(54162);
    }

    public void initView() {
        AppMethodBeat.i(54163);
        super.initView();
        xE(getResources().getColor(R.color.l8));
        dyb();
        this.oHV = new d(this);
        if (this.oHU) {
            this.oHV.setVisible(true);
        } else {
            this.oHV.setVisible(false);
        }
        int i = R.string.s6;
        if (this.oHU) {
            i = R.string.d39;
        }
        a(1, getString(i), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(54158);
                if (at.isNetworkConnected(ah.getContext())) {
                    List linkedList = new LinkedList();
                    linkedList.addAll(MultiTalkSelectContactUI.this.gnG);
                    linkedList.add(r.Yz());
                    String c = bo.c(linkedList, ",");
                    if (MultiTalkSelectContactUI.this.oHU) {
                        e.a(MultiTalkSelectContactUI.this.gnG.size(), MultiTalkSelectContactUI.this.oHW, 1, "", MultiTalkSelectContactUI.this.oHV.oIB);
                        p.bSf().b(MultiTalkSelectContactUI.this, c, MultiTalkSelectContactUI.this.chatroomName);
                    } else {
                        e.a(MultiTalkSelectContactUI.this.gnG.size(), MultiTalkSelectContactUI.this.oHW, 2, j.bRU(), 0);
                        MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", c));
                        MultiTalkSelectContactUI.this.finish();
                    }
                } else {
                    com.tencent.mm.bg.e.a(MultiTalkSelectContactUI.this, R.string.f6c, null);
                }
                MultiTalkSelectContactUI.this.aqX();
                AppMethodBeat.o(54158);
                return true;
            }
        }, q.b.GREEN);
        Kt();
        this.opo.setBackgroundResource(R.color.l8);
        this.opo.getInputText().setTextColor(-1);
        AppMethodBeat.o(54163);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(54164);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnF.addAll(bo.P(stringExtra.split(",")));
        }
        this.gnF.add(r.Yz());
        if (this.oHU) {
            this.oHV.Sp(r.Yz());
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.oGA);
        AppMethodBeat.o(54164);
    }

    public void onDestroy() {
        AppMethodBeat.i(54165);
        com.tencent.mm.sdk.b.a.xxA.d(this.oGA);
        super.onDestroy();
        AppMethodBeat.o(54165);
    }

    public final int getLayoutId() {
        return R.layout.ahx;
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(54166);
        String stringExtra = getIntent().getStringExtra("titile");
        AppMethodBeat.o(54166);
        return stringExtra;
    }

    public final o aoz() {
        AppMethodBeat.i(54167);
        a aVar = new a(this, this.chatroomName);
        AppMethodBeat.o(54167);
        return aVar;
    }

    public final m aoA() {
        AppMethodBeat.i(54168);
        b bVar = new b(this, this.chatroomName);
        AppMethodBeat.o(54168);
        return bVar;
    }

    public final void mO(int i) {
        int i2 = 1;
        AppMethodBeat.i(54169);
        n dHV = dHV();
        com.tencent.mm.ui.contact.a.a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.o(54169);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(54169);
        } else {
            ab.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            if (r.Yz().equals(str)) {
                AppMethodBeat.o(54169);
                return;
            }
            dIb();
            if (this.gnG.contains(str)) {
                if (this.oHU) {
                    d dVar = this.oHV;
                    if (dVar.size != 0) {
                        int i3;
                        int i4;
                        int i5 = -1;
                        for (i3 = 0; i3 < dVar.oIu.getChildCount(); i3++) {
                            if (dVar.oIu.getChildAt(i3).getTag().equals(str)) {
                                i5 = i3;
                                i4 = 1;
                                break;
                            }
                        }
                        i4 = 0;
                        if (i5 < 0) {
                            i3 = 0;
                            while (i3 < dVar.oIv.getChildCount()) {
                                if (dVar.oIv.getChildAt(i3).getTag().equals(str)) {
                                    break;
                                }
                                i3++;
                            }
                        }
                        i3 = i5;
                        i2 = 0;
                        if (i3 >= 0) {
                            if (i2 != 0) {
                                dVar.oIv.removeViewAt(i3);
                                dVar.size--;
                            }
                            if (i4 != 0) {
                                if (dVar.size <= 5) {
                                    dVar.oIu.removeViewAt(i3);
                                    dVar.size--;
                                } else {
                                    dVar.oIu.removeViewAt(i3);
                                    View childAt = dVar.oIv.getChildAt(0);
                                    dVar.oIv.removeViewAt(0);
                                    dVar.oIu.addView(childAt);
                                    dVar.size--;
                                }
                            }
                            dVar.zj(dVar.size);
                            dVar.zk(dVar.size);
                        }
                    }
                }
                this.gnG.remove(str);
            } else if (this.gnF.size() + this.gnG.size() == 9) {
                this.oHW = true;
                Toast.makeText(this, R.string.d35, 0).show();
                AppMethodBeat.o(54169);
                return;
            } else {
                if (this.oHU) {
                    this.oHV.Sp(str);
                }
                this.gnG.add(str);
            }
            dHV.notifyDataSetChanged();
            Kt();
            AppMethodBeat.o(54169);
        }
    }

    public final void bMQ() {
        AppMethodBeat.i(54170);
        super.bMQ();
        aqX();
        AppMethodBeat.o(54170);
    }

    private void Kt() {
        AppMethodBeat.i(54173);
        if (this.gnG.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(54173);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(54173);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(54171);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(54171);
            return false;
        }
        boolean contains = this.gnG.contains(aVar.ehM.field_username);
        AppMethodBeat.o(54171);
        return contains;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(54172);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(54172);
            return false;
        }
        boolean contains = this.gnF.contains(aVar.ehM.field_username);
        AppMethodBeat.o(54172);
        return contains;
    }
}
