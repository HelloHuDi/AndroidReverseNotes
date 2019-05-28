package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.q.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> gnF;
    private HashSet<String> gnG;
    private long gnH;
    private int gnI;
    private CheckBox gnJ;
    private View gnK;
    private String title;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(AASelectContactUI aASelectContactUI) {
        AppMethodBeat.i(40766);
        aASelectContactUI.Kt();
        AppMethodBeat.o(40766);
    }

    public final void Kh() {
        AppMethodBeat.i(40755);
        super.Kh();
        this.title = getIntent().getStringExtra("titile");
        this.gnH = getIntent().getLongExtra("max_select_num", 20);
        this.gnI = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!t.kH(this.chatroomName)) {
            ab.i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.gnG = new HashSet();
        this.gnF = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnF.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(bo.P(stringExtra.split(",")));
            Kt();
        }
        this.gnJ = (CheckBox) findViewById(R.id.j4);
        this.gnK = findViewById(R.id.j3);
        this.gnK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40749);
                if (AASelectContactUI.this.gnJ.isChecked()) {
                    if (AASelectContactUI.this.gnG != null) {
                        AASelectContactUI.this.gnG.clear();
                    } else {
                        AASelectContactUI.this.gnG = new HashSet();
                    }
                    AASelectContactUI.this.gnJ.setChecked(false);
                    AASelectContactUI.this.dHV().notifyDataSetChanged();
                } else {
                    final List vE = h.vE(AASelectContactUI.this.chatroomName);
                    if (((long) vE.size()) > AASelectContactUI.this.gnH) {
                        com.tencent.mm.ui.base.h.a(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(R.string.bw, new Object[]{Long.valueOf(AASelectContactUI.this.gnH)}), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(40748);
                                AASelectContactUI.a(AASelectContactUI.this, vE);
                                AppMethodBeat.o(40748);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        AASelectContactUI.a(AASelectContactUI.this, vE);
                    }
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(6));
                AppMethodBeat.o(40749);
            }
        });
        if (this.gnG.size() == h.vE(this.chatroomName).size()) {
            this.gnJ.setChecked(true);
        } else {
            this.gnJ.setChecked(false);
        }
        this.gnJ.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(40750);
                AASelectContactUI.e(AASelectContactUI.this);
                AppMethodBeat.o(40750);
            }
        });
        AppMethodBeat.o(40755);
    }

    public final void initView() {
        AppMethodBeat.i(40756);
        super.initView();
        a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40751);
                if (((long) AASelectContactUI.this.gnG.size()) > AASelectContactUI.this.gnH) {
                    com.tencent.mm.ui.base.h.b(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(R.string.clt, new Object[]{Long.valueOf(AASelectContactUI.this.gnH)}), "", true);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(8));
                    com.tencent.mm.plugin.report.service.h.pYm.e(13722, Integer.valueOf(3));
                    AppMethodBeat.o(40751);
                } else if (AASelectContactUI.this.gnG.size() <= 0) {
                    com.tencent.mm.ui.base.h.b(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(R.string.bz, new Object[]{Integer.valueOf(1)}), "", true);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(9));
                    AppMethodBeat.o(40751);
                } else {
                    List linkedList = new LinkedList();
                    linkedList.addAll(AASelectContactUI.this.gnG);
                    AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", bo.c(linkedList, ",")));
                    AASelectContactUI.this.finish();
                    AASelectContactUI.this.aqX();
                    com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(8));
                    AppMethodBeat.o(40751);
                }
                return true;
            }
        }, b.GREEN);
        Kt();
        this.opo.setOnContactDeselectListener(this);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40754);
                if (AASelectContactUI.this.gnG == null || AASelectContactUI.this.gnG.size() <= 0 || ((long) AASelectContactUI.this.gnG.size()) > AASelectContactUI.this.gnH || (AASelectContactUI.this.gnG.size() == 1 && AASelectContactUI.this.gnG.contains(r.Yz()))) {
                    AASelectContactUI.this.finish();
                } else {
                    com.tencent.mm.ui.base.h.a(AASelectContactUI.this, AASelectContactUI.this.getString(R.string.bu), null, AASelectContactUI.this.getString(R.string.by), AASelectContactUI.this.getString(R.string.bx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(40752);
                            if (((long) AASelectContactUI.this.gnG.size()) > AASelectContactUI.this.gnH) {
                                com.tencent.mm.ui.base.h.b(AASelectContactUI.this.mController.ylL, AASelectContactUI.this.getString(R.string.clt, new Object[]{Long.valueOf(AASelectContactUI.this.gnH)}), "", true);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13722, Integer.valueOf(3));
                                AppMethodBeat.o(40752);
                                return;
                            }
                            List linkedList = new LinkedList();
                            linkedList.addAll(AASelectContactUI.this.gnG);
                            AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", bo.c(linkedList, ",")));
                            AASelectContactUI.this.finish();
                            com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(11));
                            AppMethodBeat.o(40752);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(40753);
                            AASelectContactUI.this.finish();
                            com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(10));
                            AppMethodBeat.o(40753);
                        }
                    });
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(7));
                AppMethodBeat.o(40754);
                return true;
            }
        });
        AppMethodBeat.o(40756);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40757);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnF.addAll(bo.P(stringExtra.split(",")));
        }
        AppMethodBeat.o(40757);
    }

    public final boolean aow() {
        return false;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        return this.title;
    }

    public final o aoz() {
        AppMethodBeat.i(40758);
        d dVar = new d(this, this.chatroomName);
        AppMethodBeat.o(40758);
        return dVar;
    }

    public final m aoA() {
        AppMethodBeat.i(40759);
        e eVar = new e(this, this.chatroomName);
        AppMethodBeat.o(40759);
        return eVar;
    }

    public final void mO(int i) {
        AppMethodBeat.i(40760);
        n dHV = dHV();
        a Pn = dHV.getItem(i - getContentLV().getHeaderViewsCount());
        if (Pn == null) {
            AppMethodBeat.o(40760);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(40760);
        } else {
            ab.i("MicroMsg.AASelectContactUI", "ClickUser=%s", Pn.ehM.field_username);
            String str = Pn.ehM.field_username;
            if (str.equals(r.Yz())) {
                com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(4));
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(5));
            }
            dIb();
            if (this.gnG.contains(str)) {
                this.gnG.remove(str);
            } else {
                this.gnG.add(str);
            }
            if (this.gnG.size() == h.vE(this.chatroomName).size()) {
                this.gnJ.setChecked(true);
            } else {
                this.gnJ.setChecked(false);
            }
            dHV.notifyDataSetChanged();
            Kt();
            AppMethodBeat.o(40760);
        }
    }

    private void Kt() {
        AppMethodBeat.i(40763);
        if (this.gnG.size() > 0) {
            updateOptionMenuText(1, getString(R.string.ax, new Object[]{Integer.valueOf(this.gnG.size())}));
        } else {
            updateOptionMenuText(1, getString(R.string.s6));
        }
        if (this.gnG.size() == 1 && this.gnG.contains(r.Yz())) {
            enableOptionMenu(1, false);
            AppMethodBeat.o(40763);
            return;
        }
        enableOptionMenu(1, true);
        AppMethodBeat.o(40763);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void vI(String str) {
        AppMethodBeat.i(40764);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        AppMethodBeat.o(40764);
    }

    public final int getLayoutId() {
        return R.layout.g;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(40761);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(40761);
            return false;
        }
        boolean contains = this.gnG.contains(aVar.ehM.field_username);
        AppMethodBeat.o(40761);
        return contains;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(40762);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(40762);
            return false;
        }
        boolean contains = this.gnF.contains(aVar.ehM.field_username);
        AppMethodBeat.o(40762);
        return contains;
    }
}
