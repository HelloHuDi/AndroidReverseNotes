package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Set;

public final class o {
    public a cgL;
    public long[] yJa = null;

    public o(a aVar, long[] jArr) {
        AppMethodBeat.i(30622);
        this.cgL = aVar;
        this.yJa = jArr;
        this.cgL.yTx.removeAllOptionMenu();
        this.cgL.yTx.addTextOptionMenu(2, this.cgL.yTx.getMMResources().getString(R.string.a9f), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30620);
                Intent intent = new Intent();
                Set<Long> dCQ = ((h) o.this.cgL.aF(h.class)).dCQ();
                if (dCQ != null) {
                    ArrayList<Long> arrayList = new ArrayList();
                    for (Long l : dCQ) {
                        if (l != null) {
                            arrayList.add(l);
                        }
                    }
                    long[] jArr = new long[arrayList.size()];
                    int i = 0;
                    for (Long l2 : arrayList) {
                        int i2 = i + 1;
                        jArr[i] = l2.longValue();
                        i = i2;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", jArr);
                    o.this.cgL.yTx.getContext().setResult(-1, intent);
                } else {
                    o.this.cgL.yTx.getContext().setResult(0, intent);
                }
                intent.putExtra("k_is_group_chat", o.this.cgL.dFx());
                o.this.cgL.yTx.dBP();
                AppMethodBeat.o(30620);
                return false;
            }
        }, null, b.GREEN);
        final h hVar = (h) this.cgL.aF(h.class);
        hVar.c(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30621);
                hVar.nf(((Long) view.getTag()).longValue());
                AppMethodBeat.o(30621);
            }
        });
        AppMethodBeat.o(30622);
    }
}
