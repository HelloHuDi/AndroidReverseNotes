package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends BaseAdapter {
    private Context mContext;
    private c piK = com.tencent.mm.plugin.product.a.a.bZD();
    LinkedList<m> pjv;
    OnItemClickListener pjw;

    class a {
        public TextView pjx = null;
        public MaxGridView pjy = null;
        public j pjz = null;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(44123);
        m AO = AO(i);
        AppMethodBeat.o(44123);
        return AO;
    }

    public i(Context context) {
        AppMethodBeat.i(44119);
        this.mContext = context;
        com.tencent.mm.plugin.product.a.a.bZC();
        AppMethodBeat.o(44119);
    }

    public final int getCount() {
        AppMethodBeat.i(44120);
        if (this.pjv != null) {
            int size = this.pjv.size();
            AppMethodBeat.o(44120);
            return size;
        }
        AppMethodBeat.o(44120);
        return 0;
    }

    private m AO(int i) {
        AppMethodBeat.i(44121);
        m mVar = (m) this.pjv.get(i);
        AppMethodBeat.o(44121);
        return mVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        Object pair;
        AppMethodBeat.i(44122);
        m AO = AO(i);
        if (view == null || view.getTag() == null) {
            aVar = new a();
            view = View.inflate(this.mContext, R.layout.alc, null);
            aVar.pjx = (TextView) view.findViewById(R.id.dov);
            aVar.pjy = (MaxGridView) view.findViewById(R.id.dow);
            aVar.pjz = new j(this.mContext);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pjx.setText(AO.phY);
        aVar.pjy.setOnItemClickListener(this.pjw);
        j jVar = aVar.pjz;
        c cVar = this.piK;
        String str2 = AO.phX;
        if (cVar.pha.containsKey(str2)) {
            str = (String) cVar.pha.get(str2);
        } else {
            str = null;
        }
        jVar.pjB = AO;
        jVar.pjC = str;
        Context context = this.mContext;
        LinkedList linkedList = AO.phZ;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (com.tencent.mm.bz.a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alb, null)).getPaint();
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(((h) it.next()).name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix2 = ((int) f) + (com.tencent.mm.bz.a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = com.tencent.mm.bz.a.fromDPToPix(context, 12);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = (fromDPToPix - (fromDPToPix3 * i2)) / (i2 + 1);
        }
        for (fromDPToPix3 = 4; fromDPToPix3 > 0; fromDPToPix3--) {
            if (fromDPToPix2 < iArr[fromDPToPix3 - 1]) {
                pair = new Pair(Integer.valueOf(fromDPToPix3), Integer.valueOf(iArr[fromDPToPix3 - 1]));
                break;
            }
        }
        pair = new Pair(Integer.valueOf(1), Integer.valueOf(fromDPToPix));
        ab.d("MicroMsg.MallProductImageAdapter", AO.phY + " numColumns = " + pair);
        aVar.pjy.setColumnWidth(((Integer) pair.second).intValue());
        aVar.pjz.notifyDataSetChanged();
        aVar.pjy.setAdapter(aVar.pjz);
        AppMethodBeat.o(44122);
        return view;
    }
}
