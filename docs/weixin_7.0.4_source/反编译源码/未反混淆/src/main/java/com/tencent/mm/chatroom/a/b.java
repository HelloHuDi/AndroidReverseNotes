package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.c;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

public final class b extends android.support.v7.widget.RecyclerView.a<b> implements com.tencent.mm.chatroom.ui.c.a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray egT;
    private final a egU;
    public final a<com.tencent.mm.chatroom.c.a> egV;
    private final Collection<com.tencent.mm.chatroom.c.a> egW;
    private final Integer egX;
    private final Integer egY;
    private final boolean egZ;
    private final Context mContext;

    public static class b extends v {
        final c ehb;

        public b(View view, com.tencent.mm.chatroom.ui.c.a aVar) {
            super(view);
            AppMethodBeat.i(103891);
            this.ehb = (c) view;
            this.ehb.setLayoutParams(new LayoutParams(-1, -1));
            this.ehb.setClickable(true);
            this.ehb.setOnDayClickListener(aVar);
            AppMethodBeat.o(103891);
        }
    }

    public static class a<K> implements Serializable {
        K eha;
        K first;
    }

    public b(Context context, a aVar, TypedArray typedArray, long j, Collection<com.tencent.mm.chatroom.c.a> collection) {
        AppMethodBeat.i(103892);
        this.egT = typedArray;
        this.egY = Integer.valueOf(typedArray.getInt(20, this.calendar.get(2) % 12));
        if (-1 != j) {
            this.calendar.setTimeInMillis(j);
        }
        this.egX = Integer.valueOf(typedArray.getInt(19, this.calendar.get(2)));
        this.egZ = typedArray.getBoolean(18, false);
        this.egV = new a();
        this.egW = collection;
        this.mContext = context;
        this.egU = aVar;
        if (this.egT.getBoolean(16, false)) {
            c(new com.tencent.mm.chatroom.c.a(System.currentTimeMillis()));
        }
        AppMethodBeat.o(103892);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        AppMethodBeat.i(103893);
        int i = ((new com.tencent.mm.chatroom.c.a(this.egU.Jz()).year - this.calendar.get(1)) + 1) * 12;
        if (this.egX.intValue() != -1) {
            i -= this.egX.intValue();
        }
        if (this.egY.intValue() != -1) {
            i -= (12 - this.egY.intValue()) - 1;
        }
        AppMethodBeat.o(103893);
        return i;
    }

    public final void b(com.tencent.mm.chatroom.c.a aVar) {
        AppMethodBeat.i(103894);
        if (aVar != null) {
            c(aVar);
        }
        AppMethodBeat.o(103894);
    }

    private void c(com.tencent.mm.chatroom.c.a aVar) {
        AppMethodBeat.i(103895);
        this.egU.a(aVar);
        d(aVar);
        AppMethodBeat.o(103895);
    }

    private void d(com.tencent.mm.chatroom.c.a aVar) {
        AppMethodBeat.i(103896);
        if (!this.egZ) {
            this.egV.first = aVar;
        } else if (this.egV.first != null && this.egV.eha == null) {
            this.egV.eha = aVar;
            if (((com.tencent.mm.chatroom.c.a) this.egV.first).month < aVar.month) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= (((com.tencent.mm.chatroom.c.a) this.egV.first).month - aVar.month) - 1) {
                        break;
                    }
                    this.egU.a(aVar);
                    i = i2 + 1;
                }
            }
        } else if (this.egV.eha != null) {
            this.egV.first = aVar;
            this.egV.eha = null;
        } else {
            this.egV.first = aVar;
        }
        this.aop.notifyChanged();
        AppMethodBeat.o(103896);
    }
}
