package com.tencent.p177mm.p612ui.base.sortview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.base.sortview.C36085c.C15543a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.base.sortview.BaseSortView */
public abstract class BaseSortView extends LinearLayout implements C30374a {
    /* renamed from: Up */
    private OnItemSelectedListener f17255Up;
    private OnItemClickListener arw;
    private ListView jMQ;
    private int mMode;
    private OnItemLongClickListener oiQ;
    private C36081a yDA;
    private VerticalScrollBar yDu;
    private View yDv;
    private C36085c yDw = new C36085c(getItemViewCreator());
    private List<C36087d> yDx = new ArrayList();
    public boolean yDy;
    public boolean yDz;

    /* renamed from: com.tencent.mm.ui.base.sortview.BaseSortView$1 */
    class C155421 extends DataSetObserver {
        C155421() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(107304);
            if (BaseSortView.this.yDA != null) {
                BaseSortView.this.yDA.mo22886aW(BaseSortView.this.yDw.yDx);
            }
            AppMethodBeat.m2505o(107304);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.sortview.BaseSortView$3 */
    class C236383 implements OnItemLongClickListener {
        C236383() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107306);
            if (BaseSortView.this.oiQ != null) {
                boolean onItemLongClick = BaseSortView.this.oiQ.onItemLongClick(adapterView, view, i, j);
                AppMethodBeat.m2505o(107306);
                return onItemLongClick;
            }
            AppMethodBeat.m2505o(107306);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.sortview.BaseSortView$2 */
    class C303972 implements OnItemClickListener {
        C303972() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107305);
            if (BaseSortView.this.arw != null) {
                BaseSortView.this.arw.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(107305);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.sortview.BaseSortView$4 */
    class C303984 implements OnItemSelectedListener {
        C303984() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107307);
            if (BaseSortView.this.f17255Up != null) {
                BaseSortView.this.f17255Up.onItemSelected(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(107307);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
            AppMethodBeat.m2504i(107308);
            if (BaseSortView.this.f17255Up != null) {
                BaseSortView.this.f17255Up.onNothingSelected(adapterView);
            }
            AppMethodBeat.m2505o(107308);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.sortview.BaseSortView$a */
    public interface C36081a {
        /* renamed from: aW */
        void mo22886aW(List<C36087d> list);
    }

    /* renamed from: a */
    public abstract boolean mo22884a(String str, C36087d c36087d);

    public abstract C15543a getItemViewCreator();

    public abstract ListView getListView();

    public abstract View getNoResultView();

    public abstract VerticalScrollBar getScrollBar();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.yDu = getScrollBar();
        this.jMQ = getListView();
        this.yDv = getNoResultView();
        this.yDy = true;
        mo70149ql(true);
        this.jMQ.setAdapter(this.yDw);
        if (this.yDu != null) {
            this.yDu.setOnScrollBarTouchListener(this);
        }
        this.yDw.registerDataSetObserver(new C155421());
        this.jMQ.setOnItemClickListener(new C303972());
        this.jMQ.setOnItemLongClickListener(new C236383());
        this.jMQ.setOnItemSelectedListener(new C303984());
    }

    public void refresh() {
        this.yDw.refresh();
    }

    public C36085c getAdapter() {
        return this.yDw;
    }

    /* renamed from: dJ */
    public final void mo70141dJ(List<C36087d> list) {
        if (this.mMode == 0 && this.yDx != list) {
            this.yDx.clear();
            if (list != null) {
                this.yDx.addAll(list);
            }
        }
        this.yDw.mo56931dJ(list);
    }

    public final void aqS(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            C4990ab.m7420w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (C36087d c36087d : this.yDx) {
                if (mo22884a(str, c36087d)) {
                    arrayList.add(c36087d);
                }
            }
            z2 = true;
        }
        ListView listView = this.jMQ;
        if (!z2 || arrayList.size() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        BaseSortView.m79989x(listView, z3);
        View view = this.yDv;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        BaseSortView.m79989x(view, z);
        mo70141dJ(arrayList);
    }

    public List<C36087d> getDatas() {
        return this.yDw.yDx;
    }

    /* renamed from: kp */
    public final void mo17482kp(String str) {
        int aqT = this.yDw.aqT(str);
        if (aqT >= 0) {
            this.jMQ.setSelection(aqT);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.arw;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.arw = onItemClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return this.oiQ;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.oiQ = onItemLongClickListener;
    }

    public OnItemSelectedListener getOnItemSelectedListener() {
        return this.f17255Up;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f17255Up = onItemSelectedListener;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int i) {
        if (i == 1) {
            this.mMode = 1;
            aqS("");
            return;
        }
        this.mMode = 0;
        BaseSortView.m79989x(this.yDv, false);
        BaseSortView.m79989x(this.jMQ, true);
        mo70141dJ(this.yDx);
    }

    /* renamed from: x */
    protected static void m79989x(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: ql */
    public final void mo70149ql(boolean z) {
        this.yDz = z;
        if (this.yDu != null) {
            this.yDu.setVisibility(z ? 0 : 8);
        }
    }

    public final void dAH() {
        this.yDy = false;
        this.yDw.refresh();
    }

    public C36081a getDataSetObserver() {
        return this.yDA;
    }

    public void setDataSetObserver(C36081a c36081a) {
        this.yDA = c36081a;
    }
}
