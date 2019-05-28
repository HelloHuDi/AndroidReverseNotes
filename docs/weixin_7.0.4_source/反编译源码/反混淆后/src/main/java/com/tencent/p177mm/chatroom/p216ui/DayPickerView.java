package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.p1187a.C37637b;
import com.tencent.p177mm.chatroom.p1187a.C37637b.C26008a;
import com.tencent.p177mm.chatroom.p1187a.C45282a;
import com.tencent.p177mm.chatroom.p216ui.C9233a.C9234a;
import com.tencent.p177mm.chatroom.p710c.C26014a;
import java.util.Collection;

/* renamed from: com.tencent.mm.chatroom.ui.DayPickerView */
public class DayPickerView extends RecyclerView {
    private TypedArray egT;
    private C45282a egU;
    protected C37637b eiX;
    protected int eiY;
    protected long eiZ;
    private C41530m eja;
    private Collection<C26014a> ejb;
    private long ejc;
    protected Context mContext;
    /* renamed from: sU */
    protected int f4318sU;

    /* renamed from: com.tencent.mm.chatroom.ui.DayPickerView$1 */
    class C181361 extends C41530m {
        C181361() {
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(104079);
            super.mo6642a(recyclerView, i, i2);
            if (((C32463c) recyclerView.getChildAt(0)) == null) {
                AppMethodBeat.m2505o(104079);
                return;
            }
            DayPickerView.this.eiZ = (long) i2;
            DayPickerView.this.f4318sU = DayPickerView.this.eiY;
            AppMethodBeat.m2505o(104079);
        }
    }

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104080);
        this.eiY = 0;
        this.f4318sU = 0;
        this.ejc = -1;
        if (!isInEditMode()) {
            this.egT = context.obtainStyledAttributes(attributeSet, C9234a.DayPickerView);
            setLayoutParams(new LayoutParams(-1, -1));
            setLayoutManager(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            setOnScrollListener(this.eja);
            setFadingEdgeLength(0);
            this.eja = new C181361();
        }
        AppMethodBeat.m2505o(104080);
    }

    /* renamed from: a */
    public final void mo33627a(C45282a c45282a, Collection<C26014a> collection) {
        AppMethodBeat.m2504i(104081);
        this.ejb = collection;
        this.egU = c45282a;
        setUpAdapter(collection);
        setAdapter(this.eiX);
        mo61465bY(this.eiX.getItemCount() - 1);
        this.eiX.aop.notifyChanged();
        AppMethodBeat.m2505o(104081);
    }

    public void setBeginDate(long j) {
        this.ejc = j;
    }

    /* Access modifiers changed, original: protected */
    public void setUpAdapter(Collection<C26014a> collection) {
        AppMethodBeat.m2504i(104082);
        if (this.eiX == null) {
            this.eiX = new C37637b(getContext(), this.egU, this.egT, this.ejc, collection);
        }
        AppMethodBeat.m2505o(104082);
    }

    public C26008a<C26014a> getSelectedDays() {
        return this.eiX.egV;
    }

    /* Access modifiers changed, original: protected */
    public C45282a getController() {
        return this.egU;
    }

    /* Access modifiers changed, original: protected */
    public TypedArray getTypedArray() {
        return this.egT;
    }
}
