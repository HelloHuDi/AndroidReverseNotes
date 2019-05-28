package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import java.util.List;

public final class b extends BaseAdapter implements a {
    private Context context;
    private List<f> qnw;
    boolean suv = false;

    public b(Context context, List<f> list) {
        this.context = context;
        this.qnw = list;
    }

    public final void lX(boolean z) {
        AppMethodBeat.i(25463);
        this.suv = z;
        notifyDataSetChanged();
        AppMethodBeat.o(25463);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(25464);
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, R.layout.e3, null);
            cVar.iyo = (ImageView) view.findViewById(R.id.xm);
            cVar.suQ = (TextView) view.findViewById(R.id.xn);
            cVar.gtb = (TextView) view.findViewById(R.id.xp);
            cVar.suR = view.findViewById(R.id.xo);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.suR.setVisibility(4);
        if (wK(i)) {
            cVar.iyo.setVisibility(4);
            cVar.suQ.setVisibility(4);
            cVar.gtb.setVisibility(4);
            AppMethodBeat.o(25464);
        } else {
            f fVar = (f) getItem(i);
            cVar.iyo.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 5, com.tencent.mm.bz.a.getDensity(this.context));
            if (b == null) {
                cVar.iyo.setBackgroundResource(R.drawable.aau);
            } else {
                cVar.iyo.setBackgroundDrawable(new BitmapDrawable(b));
            }
            cVar.gtb.setVisibility(0);
            cVar.gtb.setText(g.b(this.context, fVar, null));
            if (this.suv) {
                cVar.suQ.setVisibility(0);
            } else {
                cVar.suQ.setVisibility(8);
            }
            AppMethodBeat.o(25464);
        }
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(25465);
        int realCount = getRealCount() + bFs();
        AppMethodBeat.o(25465);
        return realCount;
    }

    public final boolean wK(int i) {
        AppMethodBeat.i(25466);
        int size = this.qnw.size();
        if (i < size || i >= size + bFs()) {
            AppMethodBeat.o(25466);
            return false;
        }
        AppMethodBeat.o(25466);
        return true;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(25467);
        if (wK(i)) {
            AppMethodBeat.o(25467);
            return null;
        }
        Object obj = this.qnw.get(i);
        AppMethodBeat.o(25467);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int getRealCount() {
        AppMethodBeat.i(25468);
        int size = this.qnw.size();
        AppMethodBeat.o(25468);
        return size;
    }

    private int bFs() {
        AppMethodBeat.i(25469);
        int realCount = (4 - (getRealCount() % 4)) % 4;
        AppMethodBeat.o(25469);
        return realCount;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(25470);
        notifyDataSetChanged();
        AppMethodBeat.o(25470);
    }
}
