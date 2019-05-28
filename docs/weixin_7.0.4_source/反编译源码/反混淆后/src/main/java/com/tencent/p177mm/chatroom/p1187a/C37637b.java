package com.tencent.p177mm.chatroom.p1187a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.p216ui.C32463c;
import com.tencent.p177mm.chatroom.p216ui.C32463c.C18166a;
import com.tencent.p177mm.chatroom.p710c.C26014a;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/* renamed from: com.tencent.mm.chatroom.a.b */
public final class C37637b extends C41523a<C18132b> implements C18166a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray egT;
    private final C45282a egU;
    public final C26008a<C26014a> egV;
    private final Collection<C26014a> egW;
    private final Integer egX;
    private final Integer egY;
    private final boolean egZ;
    private final Context mContext;

    /* renamed from: com.tencent.mm.chatroom.a.b$b */
    public static class C18132b extends C41531v {
        final C32463c ehb;

        public C18132b(View view, C18166a c18166a) {
            super(view);
            AppMethodBeat.m2504i(103891);
            this.ehb = (C32463c) view;
            this.ehb.setLayoutParams(new LayoutParams(-1, -1));
            this.ehb.setClickable(true);
            this.ehb.setOnDayClickListener(c18166a);
            AppMethodBeat.m2505o(103891);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.a.b$a */
    public static class C26008a<K> implements Serializable {
        K eha;
        K first;
    }

    public C37637b(Context context, C45282a c45282a, TypedArray typedArray, long j, Collection<C26014a> collection) {
        AppMethodBeat.m2504i(103892);
        this.egT = typedArray;
        this.egY = Integer.valueOf(typedArray.getInt(20, this.calendar.get(2) % 12));
        if (-1 != j) {
            this.calendar.setTimeInMillis(j);
        }
        this.egX = Integer.valueOf(typedArray.getInt(19, this.calendar.get(2)));
        this.egZ = typedArray.getBoolean(18, false);
        this.egV = new C26008a();
        this.egW = collection;
        this.mContext = context;
        this.egU = c45282a;
        if (this.egT.getBoolean(16, false)) {
            m63585c(new C26014a(System.currentTimeMillis()));
        }
        AppMethodBeat.m2505o(103892);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(103893);
        int i = ((new C26014a(this.egU.mo60480Jz()).year - this.calendar.get(1)) + 1) * 12;
        if (this.egX.intValue() != -1) {
            i -= this.egX.intValue();
        }
        if (this.egY.intValue() != -1) {
            i -= (12 - this.egY.intValue()) - 1;
        }
        AppMethodBeat.m2505o(103893);
        return i;
    }

    /* renamed from: b */
    public final void mo33658b(C26014a c26014a) {
        AppMethodBeat.m2504i(103894);
        if (c26014a != null) {
            m63585c(c26014a);
        }
        AppMethodBeat.m2505o(103894);
    }

    /* renamed from: c */
    private void m63585c(C26014a c26014a) {
        AppMethodBeat.m2504i(103895);
        this.egU.mo60481a(c26014a);
        m63586d(c26014a);
        AppMethodBeat.m2505o(103895);
    }

    /* renamed from: d */
    private void m63586d(C26014a c26014a) {
        AppMethodBeat.m2504i(103896);
        if (!this.egZ) {
            this.egV.first = c26014a;
        } else if (this.egV.first != null && this.egV.eha == null) {
            this.egV.eha = c26014a;
            if (((C26014a) this.egV.first).month < c26014a.month) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= (((C26014a) this.egV.first).month - c26014a.month) - 1) {
                        break;
                    }
                    this.egU.mo60481a(c26014a);
                    i = i2 + 1;
                }
            }
        } else if (this.egV.eha != null) {
            this.egV.first = c26014a;
            this.egV.eha = null;
        } else {
            this.egV.first = c26014a;
        }
        this.aop.notifyChanged();
        AppMethodBeat.m2505o(103896);
    }
}
