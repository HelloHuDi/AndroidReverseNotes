package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.ab;
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
    private int index;
    private View kxA;
    CheckBox kxB;
    MMAutoAdjustTextView kxC;
    private GridHeadersGridView kxy;
    private b kyJ;
    private b kyK;
    private e kyL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18868);
        super.onCreate(bundle);
        d.bfZ();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
            AppMethodBeat.o(18868);
        } else if (d.bfS() == null) {
            finish();
            AppMethodBeat.o(18868);
        } else {
            this.kxA = findViewById(R.id.a1u);
            this.kxB = (CheckBox) findViewById(R.id.a1s);
            this.kxC = (MMAutoAdjustTextView) findViewById(R.id.aw9);
            this.gzI = (Button) findViewById(R.id.aw8);
            tx(0);
            this.kyK = (b) d.bfS().get(this.index);
            if (t.kH(this.kyK.username)) {
                setMMTitle(s.getDisplayName(this.kyK.username, this.kyK.username));
            } else {
                setMMTitle(s.mJ(this.kyK.username));
            }
            this.kxy = (GridHeadersGridView) findViewById(R.id.aw7);
            this.kxy.setNumColumns(3);
            this.kyJ = new b(this, this.kyK.kwf);
            this.kxy.setOnHeaderClickListener(this.kyJ.kxn);
            this.kxy.setOnItemClickListener(this.kyJ.jMk);
            this.kxy.setOnScrollListener(this.kyJ.kxp);
            this.kxy.setAdapter(this.kyJ);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(18863);
                    CleanChattingDetailUI.this.finish();
                    AppMethodBeat.o(18863);
                    return false;
                }
            });
            this.kxA.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(18864);
                    b a = CleanChattingDetailUI.this.kyJ;
                    if (a.jur.size() == a.iLD.size()) {
                        a.jur.clear();
                    } else {
                        for (int i = 0; i < a.iLD.size(); i++) {
                            a.jur.add(Integer.valueOf(i));
                        }
                    }
                    a.bgi();
                    CleanChattingDetailUI.this.kyJ.notifyDataSetChanged();
                    AppMethodBeat.o(18864);
                }
            });
            this.gzI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(18866);
                    com.tencent.mm.ui.base.h.d(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.string.at9), "", CleanChattingDetailUI.this.getString(R.string.b53), CleanChattingDetailUI.this.getString(R.string.abx), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(18865);
                            CleanChattingDetailUI.b(CleanChattingDetailUI.this);
                            AppMethodBeat.o(18865);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(18866);
                }
            });
            getString(R.string.tz);
            this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.apz), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.ehJ.dismiss();
            AppMethodBeat.o(18868);
        }
    }

    public final int getLayoutId() {
        return R.layout.oj;
    }

    public final void tx(int i) {
        AppMethodBeat.i(18869);
        this.gzI.setEnabled(i > 0);
        AppMethodBeat.o(18869);
    }

    public void onDestroy() {
        AppMethodBeat.i(18870);
        if (this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.kyL != null) {
            this.kyL.bgb();
        }
        d.bga();
        d.bfY();
        super.onDestroy();
        AppMethodBeat.o(18870);
    }

    public final void dP(int i, int i2) {
        AppMethodBeat.i(18871);
        this.ehJ.setMessage(getString(R.string.aqi, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.o(18871);
    }

    public final void hi(long j) {
        AppMethodBeat.i(18872);
        this.ehJ.dismiss();
        d.hg(d.bfW() + j);
        d.hd(d.bfT() - j);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.aq0, new Object[]{bo.ga(j)}), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(18867);
                if (CleanChattingDetailUI.this.kyK.kwf.size() == 0) {
                    CleanChattingDetailUI.this.finish();
                }
                AppMethodBeat.o(18867);
            }
        });
        AppMethodBeat.o(18872);
    }

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        AppMethodBeat.i(18873);
        if (d.bfQ() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.kyJ.jur);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.kyK.kwf.get(intValue));
                cleanChattingDetailUI.kyK.kwf.remove(intValue);
            }
            if (!cleanChattingDetailUI.kyK.bfI()) {
                d.bfS().remove(cleanChattingDetailUI.index);
                ab.i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", cleanChattingDetailUI.kyK.username);
            }
            cleanChattingDetailUI.kyJ.bgh();
            cleanChattingDetailUI.kyJ.notifyDataSetChanged();
            if (cleanChattingDetailUI.kyL != null) {
                cleanChattingDetailUI.kyL.bgb();
            }
            cleanChattingDetailUI.kyL = new e(d.bfQ(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.kyL.start();
            cleanChattingDetailUI.ehJ.show();
            cleanChattingDetailUI.ehJ.setMessage(cleanChattingDetailUI.getString(R.string.aqi, new Object[]{"0%"}));
        }
        AppMethodBeat.o(18873);
    }
}
