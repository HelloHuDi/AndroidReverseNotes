package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> gnG;
    private String label;
    private HashSet<String> zol;
    private int zon;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SelectLabelContactUI selectLabelContactUI, String str) {
        AppMethodBeat.i(33915);
        selectLabelContactUI.arS(str);
        AppMethodBeat.o(33915);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kh() {
        AppMethodBeat.i(33907);
        super.Kh();
        this.label = getIntent().getStringExtra("label");
        this.zon = getIntent().getIntExtra("list_attr", 0);
        this.gnG = new HashSet();
        this.zol = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.zol.addAll(bo.P(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(bo.P(stringExtra.split(",")));
        }
        AppMethodBeat.o(33907);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33908);
        super.onCreate(bundle);
        if (s.hr(this.zon, 64)) {
            a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33906);
                    ab.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new ArrayList(SelectLabelContactUI.this.gnG).toString());
                    SelectLabelContactUI.a(SelectLabelContactUI.this, bo.c(r0, ","));
                    AppMethodBeat.o(33906);
                    return true;
                }
            }, b.GREEN);
        }
        Kt();
        AppMethodBeat.o(33908);
    }

    public final void mO(int i) {
        AppMethodBeat.i(33909);
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        n dHV = dHV();
        a Pn = dHV.getItem(headerViewsCount);
        if (Pn == null) {
            AppMethodBeat.o(33909);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(33909);
        } else {
            String str = Pn.ehM.field_username;
            ab.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", str);
            if (!s.hr(this.zon, 64)) {
                arS(str);
                AppMethodBeat.o(33909);
            } else if (this.zol.contains(str) || this.gnG.contains(str) || !s.hr(this.zon, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.zol.size() + this.gnG.size() < getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER)) {
                if (!this.zol.contains(str)) {
                    if (this.gnG.contains(str)) {
                        this.gnG.remove(str);
                    } else {
                        this.gnG.add(str);
                    }
                }
                Kt();
                dHV.notifyDataSetChanged();
                AppMethodBeat.o(33909);
            } else {
                h.a(this.mController.ylL, getString(R.string.e1m, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER))}), getString(R.string.t6), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(33909);
            }
        }
    }

    private void Kt() {
        AppMethodBeat.i(33910);
        if (!s.hr(this.zon, 64) || this.gnG.size() <= 0) {
            updateOptionMenuText(1, getString(R.string.s6));
            enableOptionMenu(1, false);
            AppMethodBeat.o(33910);
            return;
        }
        updateOptionMenuText(1, getString(R.string.s6) + "(" + this.gnG.size() + ")");
        enableOptionMenu(1, true);
        AppMethodBeat.o(33910);
    }

    private void arS(String str) {
        AppMethodBeat.i(33911);
        Intent intent;
        if (s.hr(this.zon, 16384)) {
            intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(33911);
            return;
        }
        intent = new Intent();
        intent.setClass(this, ChattingUI.class);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        startActivity(intent);
        finish();
        AppMethodBeat.o(33911);
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
        return this.label;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aoA() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final o aoz() {
        AppMethodBeat.i(33912);
        h hVar = new h(this, s.hr(this.zon, 64), com.tencent.mm.plugin.label.a.a.bJa().PH(com.tencent.mm.plugin.label.a.a.bJa().PE(this.label)));
        AppMethodBeat.o(33912);
        return hVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(33913);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(33913);
            return false;
        }
        boolean contains = this.gnG.contains(aVar.ehM.field_username);
        AppMethodBeat.o(33913);
        return contains;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(33914);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(33914);
            return false;
        }
        boolean contains = this.zol.contains(aVar.ehM.field_username);
        AppMethodBeat.o(33914);
        return contains;
    }
}
