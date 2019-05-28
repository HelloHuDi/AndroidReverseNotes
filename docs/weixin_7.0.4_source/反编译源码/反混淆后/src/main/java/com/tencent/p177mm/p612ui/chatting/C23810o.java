package com.tencent.p177mm.p612ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: com.tencent.mm.ui.chatting.o */
public final class C23810o {
    public C46650a cgL;
    public long[] yJa = null;

    /* renamed from: com.tencent.mm.ui.chatting.o$1 */
    class C53571 implements OnMenuItemClickListener {
        C53571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30620);
            Intent intent = new Intent();
            Set<Long> dCQ = ((C15612h) C23810o.this.cgL.mo74857aF(C15612h.class)).dCQ();
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
                C23810o.this.cgL.yTx.getContext().setResult(-1, intent);
            } else {
                C23810o.this.cgL.yTx.getContext().setResult(0, intent);
            }
            intent.putExtra("k_is_group_chat", C23810o.this.cgL.dFx());
            C23810o.this.cgL.yTx.dBP();
            AppMethodBeat.m2505o(30620);
            return false;
        }
    }

    public C23810o(C46650a c46650a, long[] jArr) {
        AppMethodBeat.m2504i(30622);
        this.cgL = c46650a;
        this.yJa = jArr;
        this.cgL.yTx.removeAllOptionMenu();
        this.cgL.yTx.addTextOptionMenu(2, this.cgL.yTx.getMMResources().getString(C25738R.string.a9f), new C53571(), null, C5535b.GREEN);
        final C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
        c15612h.mo27805c(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(30621);
                c15612h.mo27825nf(((Long) view.getTag()).longValue());
                AppMethodBeat.m2505o(30621);
            }
        });
        AppMethodBeat.m2505o(30622);
    }
}
