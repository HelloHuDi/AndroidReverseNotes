package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI extends MMActivity implements h {
    private List<c> dataList = new ArrayList();
    private ProgressDialog ehJ;
    private Button gzI;
    private TextView jux;
    private View kxA;
    private CheckBox kxB;
    private a kxH;
    private ListView kxI;
    private TextView kxJ;
    private TextView kxK;
    private boolean kxL = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CleanChattingUI() {
        AppMethodBeat.i(18788);
        AppMethodBeat.o(18788);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18789);
        super.onCreate(bundle);
        ab.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle((int) R.string.aqb);
        this.kxI = (ListView) findViewById(R.id.aw_);
        this.kxH = new a(this, this.dataList);
        this.kxI.setAdapter(this.kxH);
        this.kxI.setEmptyView(findViewById(R.id.a1m));
        this.kxK = (TextView) findViewById(R.id.ys);
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
                AppMethodBeat.i(18778);
                CleanChattingUI.this.finish();
                AppMethodBeat.o(18778);
                return false;
            }
        });
        this.kxI.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(18779);
                c tu = CleanChattingUI.this.kxH.tu(i);
                if (tu != null) {
                    Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                    intent.putExtra("key_username", tu.username);
                    intent.putExtra("key_pos", i);
                    CleanChattingUI.this.startActivityForResult(intent, 0);
                    com.tencent.mm.plugin.report.service.h.pYm.a(714, 21, 1, false);
                }
                AppMethodBeat.o(18779);
            }
        });
        this.gzI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18781);
                com.tencent.mm.ui.base.h.d(CleanChattingUI.this, CleanChattingUI.this.getString(R.string.at8), "", CleanChattingUI.this.getString(R.string.b53), CleanChattingUI.this.getString(R.string.abx), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(18780);
                        CleanChattingUI.b(CleanChattingUI.this);
                        com.tencent.mm.plugin.report.service.h.pYm.a(714, 22, 1, false);
                        AppMethodBeat.o(18780);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(18781);
            }
        });
        this.kxA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18782);
                a a = CleanChattingUI.this.kxH;
                if (a.jur.size() == a.getCount()) {
                    a.jur.clear();
                } else {
                    for (int i = 0; i < a.getCount(); i++) {
                        a.jur.add(Integer.valueOf(i));
                    }
                }
                a.notifyDataSetChanged();
                a.kxj.a(a.jur);
                AppMethodBeat.o(18782);
            }
        });
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.apz), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.ehJ.dismiss();
        com.tencent.mm.plugin.report.service.h.pYm.a(714, 20, 1, false);
        AppMethodBeat.o(18789);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(18790);
        if (this.kxH == null) {
            ab.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
            AppMethodBeat.o(18790);
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c tu = this.kxH.tu(intValue);
            if (tu != null) {
                j = tu.size + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.kxJ.setText(getString(R.string.b58, new Object[]{bo.ga(j)}));
            this.gzI.setEnabled(true);
            if (hashSet.size() == this.kxH.getCount()) {
                this.kxB.setChecked(true);
                AppMethodBeat.o(18790);
                return;
            }
            this.kxB.setChecked(false);
            AppMethodBeat.o(18790);
            return;
        }
        this.kxJ.setText("");
        this.gzI.setEnabled(false);
        this.kxB.setChecked(false);
        AppMethodBeat.o(18790);
    }

    public void onDestroy() {
        AppMethodBeat.i(18791);
        if (this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(18791);
    }

    public void onResume() {
        AppMethodBeat.i(18792);
        super.onResume();
        if (this.kxH != null && this.dataList.isEmpty()) {
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18785);
                    if (!CleanChattingUI.this.kxL) {
                        ab.i("MicroMsg.CleanChattingUI", "load contact cursor now");
                        CleanChattingUI.this.kxL = true;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(18783);
                                CleanChattingUI.this.kxK.setText(CleanChattingUI.this.getString(R.string.fp, new Object[]{" "}));
                                AppMethodBeat.o(18783);
                            }
                        });
                        try {
                            Cursor aZo = b.aZc().aZd().aZo();
                            if (aZo != null) {
                                while (aZo.moveToNext()) {
                                    c cVar = new c();
                                    cVar.username = aZo.getString(0);
                                    cVar.size = aZo.getLong(1);
                                    CleanChattingUI.this.dataList.add(cVar);
                                }
                            }
                        } catch (NullPointerException e) {
                            ab.printErrStackTrace("MicroMsg.CleanChattingUI", e, "", new Object[0]);
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(18784);
                                CleanChattingUI.this.kxH.notifyDataSetChanged();
                                CleanChattingUI.this.kxK.setText(R.string.apy);
                                AppMethodBeat.o(18784);
                            }
                        });
                    }
                    AppMethodBeat.o(18785);
                }
            });
        }
        AppMethodBeat.o(18792);
    }

    public final int getLayoutId() {
        return R.layout.ol;
    }

    public final void dP(final int i, final int i2) {
        AppMethodBeat.i(18793);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18786);
                CleanChattingUI.this.ehJ.setMessage(CleanChattingUI.this.getString(R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.o(18786);
            }
        });
        AppMethodBeat.o(18793);
    }

    public final void hi(final long j) {
        AppMethodBeat.i(18794);
        ab.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", hashCode(), Long.valueOf(j));
        j.bgd().kvW -= j;
        j.bgd().kvV -= j;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18787);
                CleanChattingUI.this.ehJ.dismiss();
                com.tencent.mm.ui.base.h.b(CleanChattingUI.this, CleanChattingUI.this.getString(R.string.aq0, new Object[]{bo.ga(j)}), "", true);
                CleanChattingUI.this.kxK.setText(CleanChattingUI.this.getString(R.string.fp, new Object[]{" "}));
                AppMethodBeat.o(18787);
            }
        });
        AppMethodBeat.o(18794);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(18795);
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pos", -1);
            long longExtra = intent.getLongExtra("key_delete_size", 0);
            if (intExtra >= 0 && intExtra < this.dataList.size()) {
                c cVar = (c) this.dataList.get(intExtra);
                if (cVar != null) {
                    if (cVar.size == longExtra) {
                        this.dataList.remove(intExtra);
                        this.kxH.bgh();
                    } else {
                        cVar.size -= longExtra;
                    }
                }
            }
        }
        this.kxH.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(18795);
    }

    static /* synthetic */ void b(CleanChattingUI cleanChattingUI) {
        AppMethodBeat.i(18796);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cleanChattingUI.kxH.jur);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c tu = cleanChattingUI.kxH.tu(intValue);
            if (tu != null) {
                arrayList2.add(tu.username);
                cleanChattingUI.dataList.remove(intValue);
            }
        }
        cleanChattingUI.kxH.bgh();
        cleanChattingUI.kxH.notifyDataSetChanged();
        d.post(new com.tencent.mm.plugin.clean.b.b(arrayList2, null, cleanChattingUI), "delete-clean");
        cleanChattingUI.ehJ.setMessage(cleanChattingUI.getString(R.string.aqi, new Object[]{"0%"}));
        cleanChattingUI.ehJ.show();
        AppMethodBeat.o(18796);
    }
}
