package com.tencent.p177mm.plugin.product.p482ui;

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
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p737c.C34682m;
import com.tencent.p177mm.plugin.product.p737c.C46133h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.product.ui.i */
public final class C28678i extends BaseAdapter {
    private Context mContext;
    private C12808c piK = C34676a.bZD();
    LinkedList<C34682m> pjv;
    OnItemClickListener pjw;

    /* renamed from: com.tencent.mm.plugin.product.ui.i$a */
    class C12830a {
        public TextView pjx = null;
        public MaxGridView pjy = null;
        public C21450j pjz = null;

        C12830a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(44123);
        C34682m AO = m45562AO(i);
        AppMethodBeat.m2505o(44123);
        return AO;
    }

    public C28678i(Context context) {
        AppMethodBeat.m2504i(44119);
        this.mContext = context;
        C34676a.bZC();
        AppMethodBeat.m2505o(44119);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44120);
        if (this.pjv != null) {
            int size = this.pjv.size();
            AppMethodBeat.m2505o(44120);
            return size;
        }
        AppMethodBeat.m2505o(44120);
        return 0;
    }

    /* renamed from: AO */
    private C34682m m45562AO(int i) {
        AppMethodBeat.m2504i(44121);
        C34682m c34682m = (C34682m) this.pjv.get(i);
        AppMethodBeat.m2505o(44121);
        return c34682m;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C12830a c12830a;
        String str;
        Object pair;
        AppMethodBeat.m2504i(44122);
        C34682m AO = m45562AO(i);
        if (view == null || view.getTag() == null) {
            c12830a = new C12830a();
            view = View.inflate(this.mContext, 2130970396, null);
            c12830a.pjx = (TextView) view.findViewById(2131826606);
            c12830a.pjy = (MaxGridView) view.findViewById(2131826607);
            c12830a.pjz = new C21450j(this.mContext);
            view.setTag(c12830a);
        } else {
            c12830a = (C12830a) view.getTag();
        }
        c12830a.pjx.setText(AO.phY);
        c12830a.pjy.setOnItemClickListener(this.pjw);
        C21450j c21450j = c12830a.pjz;
        C12808c c12808c = this.piK;
        String str2 = AO.phX;
        if (c12808c.pha.containsKey(str2)) {
            str = (String) c12808c.pha.get(str2);
        } else {
            str = null;
        }
        c21450j.pjB = AO;
        c21450j.pjC = str;
        Context context = this.mContext;
        LinkedList linkedList = AO.phZ;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (C1338a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130970395, null)).getPaint();
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(((C46133h) it.next()).name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix2 = ((int) f) + (C1338a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = C1338a.fromDPToPix(context, 12);
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
        C4990ab.m7410d("MicroMsg.MallProductImageAdapter", AO.phY + " numColumns = " + pair);
        c12830a.pjy.setColumnWidth(((Integer) pair.second).intValue());
        c12830a.pjz.notifyDataSetChanged();
        c12830a.pjy.setAdapter(c12830a.pjz);
        AppMethodBeat.m2505o(44122);
        return view;
    }
}
