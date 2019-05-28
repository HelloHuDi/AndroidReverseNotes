package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.a.a;
import com.tencent.mm.chatroom.a.b;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray egT;
    private a egU;
    protected b eiX;
    protected int eiY;
    protected long eiZ;
    private m eja;
    private Collection<com.tencent.mm.chatroom.c.a> ejb;
    private long ejc;
    protected Context mContext;
    protected int sU;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(104080);
        this.eiY = 0;
        this.sU = 0;
        this.ejc = -1;
        if (!isInEditMode()) {
            this.egT = context.obtainStyledAttributes(attributeSet, a.a.DayPickerView);
            setLayoutParams(new LayoutParams(-1, -1));
            setLayoutManager(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            setOnScrollListener(this.eja);
            setFadingEdgeLength(0);
            this.eja = new m() {
                public final void a(RecyclerView recyclerView, int i, int i2) {
                    AppMethodBeat.i(104079);
                    super.a(recyclerView, i, i2);
                    if (((c) recyclerView.getChildAt(0)) == null) {
                        AppMethodBeat.o(104079);
                        return;
                    }
                    DayPickerView.this.eiZ = (long) i2;
                    DayPickerView.this.sU = DayPickerView.this.eiY;
                    AppMethodBeat.o(104079);
                }
            };
        }
        AppMethodBeat.o(104080);
    }

    public final void a(a aVar, Collection<com.tencent.mm.chatroom.c.a> collection) {
        AppMethodBeat.i(104081);
        this.ejb = collection;
        this.egU = aVar;
        setUpAdapter(collection);
        setAdapter(this.eiX);
        bY(this.eiX.getItemCount() - 1);
        this.eiX.aop.notifyChanged();
        AppMethodBeat.o(104081);
    }

    public void setBeginDate(long j) {
        this.ejc = j;
    }

    /* Access modifiers changed, original: protected */
    public void setUpAdapter(Collection<com.tencent.mm.chatroom.c.a> collection) {
        AppMethodBeat.i(104082);
        if (this.eiX == null) {
            this.eiX = new b(getContext(), this.egU, this.egT, this.ejc, collection);
        }
        AppMethodBeat.o(104082);
    }

    public b.a<com.tencent.mm.chatroom.c.a> getSelectedDays() {
        return this.eiX.egV;
    }

    /* Access modifiers changed, original: protected */
    public a getController() {
        return this.egU;
    }

    /* Access modifiers changed, original: protected */
    public TypedArray getTypedArray() {
        return this.egT;
    }
}
