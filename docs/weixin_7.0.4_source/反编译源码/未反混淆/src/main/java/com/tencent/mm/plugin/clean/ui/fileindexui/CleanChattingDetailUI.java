package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements h {
    private ProgressDialog ehJ;
    private Button gzI;
    private long kvY;
    private View kxA;
    CheckBox kxB;
    MMAutoAdjustTextView kxC;
    private b kxD;
    private GridHeadersGridView kxy;
    private b kxz;
    private int pos;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18772);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("key_username");
        this.pos = getIntent().getIntExtra("key_pos", 0);
        if (bo.isNullOrNil(this.username)) {
            ab.w("MicroMsg.CleanChattingDetailUI", "username is null");
            finish();
            AppMethodBeat.o(18772);
            return;
        }
        this.kxA = findViewById(R.id.a1u);
        this.kxB = (CheckBox) findViewById(R.id.a1s);
        this.kxC = (MMAutoAdjustTextView) findViewById(R.id.aw9);
        this.gzI = (Button) findViewById(R.id.aw8);
        tx(0);
        if (t.kH(this.username)) {
            setMMTitle(s.getDisplayName(this.username, this.username));
        } else {
            setMMTitle(s.mJ(this.username));
        }
        this.kxy = (GridHeadersGridView) findViewById(R.id.aw7);
        this.kxy.setNumColumns(3);
        this.kxz = new b(this, this.username);
        this.kxy.setOnHeaderClickListener(this.kxz.kxn);
        this.kxy.setOnItemClickListener(this.kxz.jMk);
        this.kxy.setOnScrollListener(this.kxz.kxp);
        this.kxy.setAdapter(this.kxz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18766);
                CleanChattingDetailUI.this.finish();
                AppMethodBeat.o(18766);
                return false;
            }
        });
        this.kxA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18767);
                b a = CleanChattingDetailUI.this.kxz;
                if (a.jur.size() == a.iLD.size()) {
                    a.jur.clear();
                } else {
                    for (int i = 0; i < a.iLD.size(); i++) {
                        a.jur.add(Integer.valueOf(i));
                    }
                }
                a.bgi();
                CleanChattingDetailUI.this.kxz.notifyDataSetChanged();
                AppMethodBeat.o(18767);
            }
        });
        this.gzI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18769);
                com.tencent.mm.ui.base.h.d(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.string.at9), "", CleanChattingDetailUI.this.getString(R.string.b53), CleanChattingDetailUI.this.getString(R.string.abx), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(18768);
                        CleanChattingDetailUI.b(CleanChattingDetailUI.this);
                        com.tencent.mm.plugin.report.service.h.pYm.a(714, 31, 1, false);
                        AppMethodBeat.o(18768);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(18769);
            }
        });
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.apz), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.ehJ.dismiss();
        if (this.kxz != null) {
            d.post(new b(this.kxz, (byte) 0), "load_clean_detail");
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(714, 30, 1, false);
        AppMethodBeat.o(18772);
    }

    public final int getLayoutId() {
        return R.layout.oj;
    }

    public final void tx(int i) {
        AppMethodBeat.i(18773);
        this.gzI.setEnabled(i > 0);
        AppMethodBeat.o(18773);
    }

    public void onDestroy() {
        AppMethodBeat.i(18774);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.kxz != null) {
            this.kxz.isStop = true;
        }
        super.onDestroy();
        AppMethodBeat.o(18774);
    }

    public final void dP(final int i, final int i2) {
        AppMethodBeat.i(18775);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18770);
                CleanChattingDetailUI.this.ehJ.setMessage(CleanChattingDetailUI.this.getString(R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.o(18770);
            }
        });
        AppMethodBeat.o(18775);
    }

    public final void hi(final long j) {
        AppMethodBeat.i(18776);
        ab.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", hashCode(), Long.valueOf(j));
        j.bgd().kvW -= j;
        j.bgd().kvV -= j;
        this.kvY += j;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18771);
                CleanChattingDetailUI.this.ehJ.dismiss();
                Intent intent = new Intent();
                intent.putExtra("key_pos", CleanChattingDetailUI.this.pos);
                intent.putExtra("key_delete_size", CleanChattingDetailUI.this.kvY);
                CleanChattingDetailUI.this.setResult(1000, intent);
                com.tencent.mm.ui.base.h.b(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.string.aq0, new Object[]{bo.ga(j)}), "", true);
                AppMethodBeat.o(18771);
            }
        });
        AppMethodBeat.o(18776);
    }

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        AppMethodBeat.i(18777);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cleanChattingDetailUI.kxz.jur);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            i tv = cleanChattingDetailUI.kxz.tv(intValue);
            if (tv != null) {
                arrayList2.add(tv);
                cleanChattingDetailUI.kxz.iLD.remove(intValue);
            }
        }
        cleanChattingDetailUI.kxz.bgh();
        cleanChattingDetailUI.kxz.notifyDataSetChanged();
        cleanChattingDetailUI.kxD = new b(null, arrayList2, cleanChattingDetailUI);
        d.post(cleanChattingDetailUI.kxD, "delete-clean");
        cleanChattingDetailUI.ehJ.show();
        cleanChattingDetailUI.ehJ.setMessage(cleanChattingDetailUI.getString(R.string.aqi, new Object[]{"0%"}));
        AppMethodBeat.o(18777);
    }
}
