package com.tencent.mm.ui.base.sortview;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.VerticalScrollBar;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements com.tencent.mm.ui.base.VerticalScrollBar.a {
    private OnItemSelectedListener Up;
    private OnItemClickListener arw;
    private ListView jMQ;
    private int mMode;
    private OnItemLongClickListener oiQ;
    private a yDA;
    private VerticalScrollBar yDu;
    private View yDv;
    private c yDw = new c(getItemViewCreator());
    private List<d> yDx = new ArrayList();
    public boolean yDy;
    public boolean yDz;

    public interface a {
        void aW(List<d> list);
    }

    public abstract boolean a(String str, d dVar);

    public abstract com.tencent.mm.ui.base.sortview.c.a getItemViewCreator();

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
        ql(true);
        this.jMQ.setAdapter(this.yDw);
        if (this.yDu != null) {
            this.yDu.setOnScrollBarTouchListener(this);
        }
        this.yDw.registerDataSetObserver(new DataSetObserver() {
            public final void onChanged() {
                AppMethodBeat.i(107304);
                if (BaseSortView.this.yDA != null) {
                    BaseSortView.this.yDA.aW(BaseSortView.this.yDw.yDx);
                }
                AppMethodBeat.o(107304);
            }
        });
        this.jMQ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107305);
                if (BaseSortView.this.arw != null) {
                    BaseSortView.this.arw.onItemClick(adapterView, view, i, j);
                }
                AppMethodBeat.o(107305);
            }
        });
        this.jMQ.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107306);
                if (BaseSortView.this.oiQ != null) {
                    boolean onItemLongClick = BaseSortView.this.oiQ.onItemLongClick(adapterView, view, i, j);
                    AppMethodBeat.o(107306);
                    return onItemLongClick;
                }
                AppMethodBeat.o(107306);
                return false;
            }
        });
        this.jMQ.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107307);
                if (BaseSortView.this.Up != null) {
                    BaseSortView.this.Up.onItemSelected(adapterView, view, i, j);
                }
                AppMethodBeat.o(107307);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
                AppMethodBeat.i(107308);
                if (BaseSortView.this.Up != null) {
                    BaseSortView.this.Up.onNothingSelected(adapterView);
                }
                AppMethodBeat.o(107308);
            }
        });
    }

    public void refresh() {
        this.yDw.refresh();
    }

    public c getAdapter() {
        return this.yDw;
    }

    public final void dJ(List<d> list) {
        if (this.mMode == 0 && this.yDx != list) {
            this.yDx.clear();
            if (list != null) {
                this.yDx.addAll(list);
            }
        }
        this.yDw.dJ(list);
    }

    public final void aqS(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            ab.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (d dVar : this.yDx) {
                if (a(str, dVar)) {
                    arrayList.add(dVar);
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
        x(listView, z3);
        View view = this.yDv;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        x(view, z);
        dJ(arrayList);
    }

    public List<d> getDatas() {
        return this.yDw.yDx;
    }

    public final void kp(String str) {
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
        return this.Up;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Up = onItemSelectedListener;
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
        x(this.yDv, false);
        x(this.jMQ, true);
        dJ(this.yDx);
    }

    protected static void x(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void ql(boolean z) {
        this.yDz = z;
        if (this.yDu != null) {
            this.yDu.setVisibility(z ? 0 : 8);
        }
    }

    public final void dAH() {
        this.yDy = false;
        this.yDw.refresh();
    }

    public a getDataSetObserver() {
        return this.yDA;
    }

    public void setDataSetObserver(a aVar) {
        this.yDA = aVar;
    }
}
