package com.tencent.mm.plugin.clean.ui.newui;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI extends MMActivity implements h {
    private ProgressDialog ehJ;
    private Button gzI;
    private TextView jux;
    private View kxA;
    private CheckBox kxB;
    private ListView kxI;
    private TextView kxJ;
    private e kyL;
    private a kyO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18880);
        super.onCreate(bundle);
        d.bfZ();
        ab.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle((int) R.string.aqq);
        this.kxI = (ListView) findViewById(R.id.aw_);
        this.kyO = new a(this);
        this.kxI.setAdapter(this.kyO);
        this.kxI.setEmptyView(findViewById(R.id.a1m));
        this.kxA = findViewById(R.id.a1u);
        this.kxJ = (TextView) findViewById(R.id.aw9);
        this.kxB = (CheckBox) findViewById(R.id.a1s);
        this.jux = (TextView) findViewById(R.id.a1t);
        if (!aa.don()) {
            this.kxJ.setTextSize(1, 14.0f);
            this.jux.setTextSize(1, 14.0f);
        }
        this.gzI = (Button) findViewById(R.id.aw8);
        this.gzI.setEnabled(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18874);
                CleanChattingUI.this.finish();
                AppMethodBeat.o(18874);
                return false;
            }
        });
        this.kxI.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(18875);
                Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                intent.putExtra("key_position", i);
                CleanChattingUI.this.startActivityForResult(intent, 0);
                AppMethodBeat.o(18875);
            }
        });
        this.gzI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18877);
                com.tencent.mm.ui.base.h.d(CleanChattingUI.this, CleanChattingUI.this.getString(R.string.at8), "", CleanChattingUI.this.getString(R.string.b53), CleanChattingUI.this.getString(R.string.abx), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(18876);
                        CleanChattingUI.a(CleanChattingUI.this);
                        AppMethodBeat.o(18876);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(18877);
            }
        });
        this.kxA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18878);
                a b = CleanChattingUI.this.kyO;
                if (b.jur.size() == b.getCount()) {
                    b.jur.clear();
                } else {
                    for (int i = 0; i < b.getCount(); i++) {
                        b.jur.add(Integer.valueOf(i));
                    }
                }
                b.notifyDataSetChanged();
                b.kyF.a(b.jur);
                AppMethodBeat.o(18878);
            }
        });
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.apz), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.ehJ.dismiss();
        AppMethodBeat.o(18880);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(18881);
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < d.bfS().size()) {
                i = (int) (((b) d.bfS().get(intValue)).jrb + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.kxJ.setText(getString(R.string.b58, new Object[]{bo.ga((long) i)}));
            this.gzI.setEnabled(true);
            if (hashSet.size() == this.kyO.getCount()) {
                this.kxB.setChecked(true);
                AppMethodBeat.o(18881);
                return;
            }
            this.kxB.setChecked(false);
            AppMethodBeat.o(18881);
            return;
        }
        this.kxJ.setText("");
        this.gzI.setEnabled(false);
        this.kxB.setChecked(false);
        AppMethodBeat.o(18881);
    }

    public void onDestroy() {
        AppMethodBeat.i(18882);
        if (this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.kyL != null) {
            this.kyL.bgb();
        }
        d.bga();
        d.bfY();
        super.onDestroy();
        AppMethodBeat.o(18882);
    }

    public final int getLayoutId() {
        return R.layout.ol;
    }

    public final void dP(int i, int i2) {
        AppMethodBeat.i(18883);
        this.ehJ.setMessage(getString(R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.o(18883);
    }

    public final void hi(long j) {
        AppMethodBeat.i(18884);
        this.ehJ.dismiss();
        d.hg(d.bfW() + j);
        d.hd(d.bfT() - j);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.aq0, new Object[]{bo.ga(j)}), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(18879);
                if (d.bfS() != null && d.bfS().size() == 0) {
                    CleanChattingUI.this.finish();
                }
                AppMethodBeat.o(18879);
            }
        });
        AppMethodBeat.o(18884);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(18885);
        this.kyO.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(18885);
    }
}
