package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<k> dataList = new ArrayList();
    int mode;

    class a {
        public ImageView eks;
        public TextView gnd;
        public TextView gne;
        public TextView gnf;
        public TextView gng;
        public TextView gnh;

        public a(View view) {
            AppMethodBeat.i(40714);
            this.eks = (ImageView) view.findViewById(R.id.ik);
            this.gnd = (TextView) view.findViewById(R.id.im);
            this.gne = (TextView) view.findViewById(R.id.in);
            this.gnf = (TextView) view.findViewById(R.id.io);
            this.gng = (TextView) view.findViewById(R.id.ip);
            this.gnh = (TextView) view.findViewById(R.id.iq);
            AppMethodBeat.o(40714);
        }
    }

    public b(Context context, int i) {
        AppMethodBeat.i(40715);
        this.context = context;
        this.mode = i;
        AppMethodBeat.o(40715);
    }

    public final int getCount() {
        AppMethodBeat.i(40716);
        int size = this.dataList.size();
        AppMethodBeat.o(40716);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(40717);
        Object obj = this.dataList.get(i);
        AppMethodBeat.o(40717);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(40718);
        if (view == null) {
            view = v.hu(this.context).inflate(R.layout.c, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        k kVar = (k) getItem(i);
        aVar.eks.setImageResource(R.raw.aa_record_default_icon);
        com.tencent.mm.pluginsdk.ui.a.b.f(aVar.eks, kVar.vzM, R.raw.aa_record_default_icon);
        aVar.gne.setText(j.b(this.context, kVar.title, aVar.gne.getTextSize()));
        CharSequence mJ = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(kVar.vzM);
        if (bo.isNullOrNil(mJ) || mJ.endsWith("@chatroom")) {
            mJ = this.context.getString(R.string.ar);
        }
        aVar.gnd.setText(j.b(this.context, mJ, aVar.gnd.getTextSize()));
        if (this.mode == 2) {
            aVar.gnf.setText(kVar.vzY);
        } else {
            aVar.gnf.setText(kVar.vzV);
        }
        aVar.gng.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) kVar.cSh) / 100.0f), this.context.getString(R.string.c0)}));
        aVar.gnh.setVisibility(0);
        if (this.mode != 2) {
            switch (kVar.state) {
                case 1:
                    aVar.gnh.setText(R.string.b_);
                    aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.dk));
                    break;
                case 2:
                    aVar.gnh.setText(R.string.b8);
                    aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.dk));
                    break;
                case 3:
                    aVar.gnh.setText(R.string.b6);
                    aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.xy));
                    break;
                case 4:
                    aVar.gnh.setText(R.string.b7);
                    aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.xy));
                    break;
                default:
                    aVar.gnh.setVisibility(4);
                    break;
            }
        }
        switch (kVar.state) {
            case 1:
                aVar.gnh.setText(R.string.ba);
                aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.dk));
                break;
            case 2:
                aVar.gnh.setText(R.string.b9);
                aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.dk));
                break;
            default:
                aVar.gnh.setVisibility(4);
                break;
        }
        AppMethodBeat.o(40718);
        return view;
    }

    public final void aot() {
        AppMethodBeat.i(40719);
        this.dataList.clear();
        AppMethodBeat.o(40719);
    }
}
